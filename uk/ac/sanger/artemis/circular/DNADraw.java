/*
 * Copyright (C) 2008  Genome Research Limited
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 *
 *  @author: Tim Carver
 */

package uk.ac.sanger.artemis.circular;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

import uk.ac.sanger.artemis.EntryGroup;
import uk.ac.sanger.artemis.editor.BrowserControl;
import uk.ac.sanger.artemis.io.Range;
import uk.ac.sanger.artemis.sequence.Bases;


public class DNADraw extends ScrollPanel
                     implements Printable, DragGestureListener,
                     DragSourceListener, DropTargetListener
{

  private static final long serialVersionUID = 1L;
  public static JScrollPane jsp;
  private DNADraw current_dna;
  private JFrame mainFrame;

  private Point location    = new Point(75,75);
  private Dimension border  = new Dimension(150,100);
  private Dimension panelSize = new Dimension(690,690);
  private Dimension linearPanelSize = new Dimension(800,350);
  private Hashtable lineAttr;
  private Vector minorTicks;
  private Vector majorTicks;
  private Vector block;
  private Vector restrictionEnzyme;

  private int startTick = 0;
  private int minorTick = 100;
  private int majorTick = 500;

//
// store the tick positions -- there appears to be
// a bug in AffineTransform when it comes to using
// elements from the matrix when printing
//
  private int[] tickMajorXPositions;
  private int[] tickMajorYPositions;

  private int[] tickMinorXPositions;
  private int[] tickMinorYPositions;

  private boolean labelTicks = true;
  
  private int[] reXPositions;
  private int[] reYPositions;
  private boolean close = false;
  private EntryGroup artemisEntryGroup;
  private Bases bases;
  private Graph gcGraph;
  private Graph gcSkewGraph;
  private Graph userGraph;
  protected static int Y_SHIFT = -35;
  protected static int THETA = -90;
  private TrackViewer viewer;
  private AffineTransform original;

  public DNADraw()
  {
    super(new BorderLayout()); 
    current_dna = this;
    setBackground(Color.white);
    setPreferredSize(panelSize);
    setOpaque(false);
    setToolTipText("");
    
    DragSource dragSource = DragSource.getDefaultDragSource();
    dragSource.createDefaultDragGestureRecognizer(
       this,                             // component where drag originates
       DnDConstants.ACTION_COPY_OR_MOVE, // actions
       this);      
    setDropTarget(new DropTarget(this,this));
    lineAttr = new Hashtable();
    lineAttr.put("start",new Integer(0));
    lineAttr.put("end",new Integer(4000));
    lineAttr.put("lsize",new Integer(5));
    lineAttr.put("circular",new Boolean(true));

    MouseListener mouseListener = new MouseAdapter()
    {
      public void mouseClicked(MouseEvent me)
      {
        if(me.getClickCount() == 2 &&
           !me.isPopupTrigger())
        {
          final Block b = getBlockAtLocation(me.getPoint());
          if(b != null)
          {
            final JFrame f = new JFrame("Properties");
            JButton butt = new JButton("Delete");
            butt.addActionListener(new ActionListener()
            {
              public void actionPerformed(ActionEvent e)
              {
                block.remove(b);
                current_dna.repaint();
                f.setVisible(false);
                f.dispose();
              }
            });
            b.showProperties(f, DNADraw.this, butt);
          }
        }
      }
    };
    this.addMouseListener(mouseListener);
  }
  

  /**
   * Add list of features to a track
   * @param features
   * @param track
   * @param drawLabel
   */
  public void addFeaturesToTrack(final List features, 
                                 final Track track,
                                 final boolean drawLabel)
  {
    for(int i=0; i<features.size(); i++)
    {
      addFeatureToTrack((uk.ac.sanger.artemis.circular.Feature)features.get(i),
          track, drawLabel);
    }
  }
  
  /**
   * Add a feature to a track
   * @param tmpf
   * @param track
   * @param drawLabel
   */
  public void addFeatureToTrack(final uk.ac.sanger.artemis.circular.Feature tmpf, 
                                final Track track,
                                final boolean drawLabel)
  {
    final uk.ac.sanger.artemis.Feature f = tmpf.getArtemisFeature();
    Vector ranges = f.getLocation().getRanges();
      
    for(int j=0; j<ranges.size(); j++)
    {
      Range range = (Range) ranges.get(j);

      Block drawBlock = new Block(f.getIDString(), 
            range.getStart(),
            range.getEnd(), 
            f.getColour(), 
            10.f, 
            track, this);
      drawBlock.setDrawLabel(drawLabel);
      drawBlock.setFeature(f);
      addBlock(drawBlock);
    }
  }
  
  public String getToolTipText(MouseEvent me) 
  {
    Block b = getBlockAtLocation(me.getPoint());
    if(b != null)
    {
      if(b.getFeature() != null)
        return b.getLabel()+" "+b.getFeature().getLocation().toStringShort();
      
      return b.getLabel()+" "+b.getBstart()+".."+b.getBend();
    }
    return null;
  }

  public DNADraw(Vector minorTicks, Vector majorTicks,
                 Vector block,
                 Vector restrictionEnzyme)
  {
    this();
    this.minorTicks = minorTicks;
    this.block = block;
    this.restrictionEnzyme = restrictionEnzyme;
  }


  public DNADraw(Vector block, Vector restrictionEnzyme,
                 Hashtable lineAttr, int startTick,
                 int minorTick, int majorTick)
  {
    this();
    this.block = block;
    this.restrictionEnzyme = restrictionEnzyme;
    this.lineAttr     = lineAttr;
    this.startTick    = startTick;
    this.minorTick    = minorTick;
    this.majorTick    = majorTick;

    if(!isCircular())
      setPreferredSize(linearPanelSize);
    
    calculateTickPosistions();
  }


  /**
  *
  * Get the width/diameter of the DNA map
  *
  */
  protected double getDiameter()
  {
    return getWidth()-border.getWidth();
  }


  protected Point getLocationPoint()
  {
    return location;
  }


  protected void zoomIn()
  {
    int wid = getWidth();
    wid     = wid+(int)(wid*0.1);
    int hgt = getHeight();
    if(isCircular())
      hgt = hgt+(int)(hgt*0.1);
    zoom(wid,hgt);
  }


  protected void zoomOut()
  {
    int wid = getWidth();
    wid     = wid-(int)(wid*0.1);
    int hgt = getHeight();  
    if(isCircular())
      hgt = hgt-(int)(hgt*0.1);
    zoom(wid,hgt);
  }

  
  private void zoom(int wid, int hgt)
  {
    if(isCircular())
    {
      panelSize = new Dimension(wid,hgt);
      setPreferredSize(panelSize);
      setSize(panelSize);
    }
    else
    {
      linearPanelSize = new Dimension(wid,hgt);
      setPreferredSize(linearPanelSize);
      setSize(linearPanelSize);
    }
    repaint();
  }

  
  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    

    if(isCircular())
      drawCircularPanel(g2,true);
    else
      drawLinearPanel(g2);
  }


  protected boolean isCircular()
  {
    return ((Boolean)lineAttr.get("circular")).booleanValue();
  }


  protected void addBlock(Block b)
  {
    this.getGeneticMarker().add(b);
    validate();
  }


  protected void drawLinearPanel(Graphics2D g2)
  {
    FontMetrics fm = g2.getFontMetrics();
    double hgt = fm.getAscent();
    g2.setColor(Color.black);
    double widDash = 4;

    int lineSize = 5;
    try
    {
      lineSize = getLineSize();
    }
    catch(NullPointerException npe)
    {
      System.out.println("No line size specified using default!");
    }
    g2.setStroke(new BasicStroke((float)lineSize));

    double widthPanel  = getWidth();
    double ddiameter  = widthPanel-border.getWidth();
    int diameter = (int)ddiameter;
    int ymid = getHeight()/2;

    g2.setStroke(new BasicStroke((float)lineSize));
    g2.drawLine(location.x,ymid,
                diameter,ymid);   

    int start = getStart();
    int end   = getEnd();

    g2.setColor(Color.black);
    g2.setStroke(new BasicStroke(1.f));

    if(majorTicks == null || minorTicks == null)
      calculateTickPosistions();

    Enumeration enumTk = minorTicks.elements();
    while(enumTk.hasMoreElements())
    {
      int tick = ((Integer)enumTk.nextElement()).intValue();
      int x = ((diameter-location.x)*(tick-start)/(end-start))+location.x;
      int y = ymid+(int)((lineSize+widDash)/2);
      g2.drawLine(x,ymid,x,y);
    }

    enumTk = majorTicks.elements();
    while(enumTk.hasMoreElements())
    {
      int tick = ((Integer)enumTk.nextElement()).intValue();
      int x = ((diameter-location.x)*(tick-start)/(end-start))+location.x;
      int y = ymid+(lineSize/2)+(int)widDash;
      g2.drawLine(x,ymid,x,y);
      String label = Integer.toString(tick);
      x-=(fm.stringWidth(label)/2);
      y+=hgt;
      g2.drawString(label,x,y);
    }

    if(restrictionEnzyme != null)
    {
      enumTk = restrictionEnzyme.elements();
      while(enumTk.hasMoreElements())
      {
        Vector re = (Vector)enumTk.nextElement();
        String reLabel = (String)re.elementAt(0);
        int pos = ((Integer)re.elementAt(1)).intValue();
        g2.setColor((Color)re.elementAt(2));
        int x = ((diameter-location.x)*(pos-start)/(end-start))+location.x;
        int y = ymid-(lineSize/2)-(int)widDash;
        g2.drawLine(x,ymid,x,y);
        x-=(fm.stringWidth(reLabel)/2);
        y-=hgt;
        g2.drawString(reLabel,x,y);
      }
    }

    // draw features
    Vector markers = getGeneticMarker();
    for(int i=0; i<markers.size(); i++)
    {
      Block b = (Block)markers.get(i);
      b.drawLinear(g2);
    }
  }

  protected void drawCircularPanel(Graphics2D g2, boolean record)
  {
    RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON); 
    qualityHints.put(RenderingHints.KEY_RENDERING,               
    RenderingHints.VALUE_RENDER_QUALITY); 
    g2.setRenderingHints(qualityHints);
    g2.setColor(Color.black);
 
    FontMetrics fm = g2.getFontMetrics();
    double hgt = fm.getAscent();
    final double widthPanel  = getWidth(); 
    final double heightPanel = getHeight();

    double rad = 360.d;
    double pi  = Math.PI;
    double widDash = 4;

    double ddiameter  = widthPanel-border.getWidth();
    double ddiameter2 = ddiameter/2.d;
    int diameter = (int)ddiameter;

    int lineSize = 5;
    try
    {
      lineSize = getLineSize();
    }
    catch(NullPointerException npe)
    {
      System.out.println("No line size specified using default!");
    }

    original = g2.getTransform();
    AffineTransform origin = (AffineTransform) original.clone();
    
    origin.translate(0, Y_SHIFT);
    
    // rotate so that origin is at the top
    origin.translate(widthPanel/2, heightPanel/2);
    origin.rotate(Math.toRadians(THETA));
    origin.translate(-widthPanel/2, -heightPanel/2);

    g2.setTransform(origin);
    
    g2.setStroke(new BasicStroke((float)lineSize));
    g2.drawArc(location.x,location.y,
               diameter,diameter,0,360);

    /* draw track circle
     * int shift = (int)(diameter*(1.d-0.9d)/2);
    g2.drawArc(location.x+shift,location.y+shift,
        (int)(diameter*0.9),(int)(diameter*0.9),0,360);*/


    AffineTransform newOrig;

    if(restrictionEnzyme != null)
    {
      if(record)
      {
        int nsize = restrictionEnzyme.size();
        reXPositions = new int[nsize];
        reYPositions = new int[nsize];
      }
      Enumeration enumRes = restrictionEnzyme.elements();
      while(enumRes.hasMoreElements())
      {
        Vector re = (Vector)enumRes.nextElement();
        String reLabel = (String)re.elementAt(0);
        int pos = ((Integer)re.elementAt(1)).intValue();
        g2.setColor((Color)re.elementAt(2));
        double ang = getAngleFromPosition(pos,rad);

        newOrig = (AffineTransform)(origin.clone());
        newOrig.rotate(Math.toRadians(-ang),
                       widthPanel/2.d,heightPanel/2.d);

        int widLabel  = (lineSize+fm.stringWidth(reLabel))/2;
        int widREDash = (int)(widDash+widDash+lineSize)+widLabel;

        int x = 0;
        int y = 0;
        if(record)
        {
          x = (int)( ddiameter2 + (newOrig.getScaleX()*
                       (ddiameter2 + 10 + widLabel + widREDash) ) -
                       widLabel );
          y = (int)( ddiameter2 + (newOrig.getShearY()*
                       (ddiameter2 + 10 + widREDash + (hgt/2.d)) ) +
                       hgt/2.d );

          int index = restrictionEnzyme.indexOf(re);
          reXPositions[index] = x;
          reYPositions[index] = y;
        }
        else
        {
          int index = restrictionEnzyme.indexOf(re);
          x = reXPositions[index];
          y = reYPositions[index];
        }

        AffineTransform labelTransform = (AffineTransform)(origin.clone());
        labelTransform.translate(location.x+ddiameter2, location.y+ddiameter2);
        labelTransform.rotate(Math.toRadians(-DNADraw.THETA));
        labelTransform.translate(-(location.x+ddiameter2), -(location.y+ddiameter2));
        g2.setTransform(labelTransform);
        
        
        g2.drawString(reLabel,location.x+x,location.y+y);
        g2.setTransform(newOrig);
        g2.setStroke(new BasicStroke(1.f));
        int xLine = location.x+(int)(ddiameter);
        int yLine = location.y+(int)(ddiameter/2.d);
        g2.drawLine(xLine,yLine,(int)(xLine+widREDash),yLine);
        g2.setTransform(origin);
      }
    }

    if(majorTicks == null || minorTicks == null)
      calculateTickPosistions();
    //major ticks
    drawCircularTicks(g2,ddiameter,ddiameter2,diameter,origin,
                      widthPanel,heightPanel,rad,pi,widDash,fm,
                      lineSize,record,majorTicks,false);


    //minor ticks
    drawCircularTicks(g2,ddiameter,ddiameter2,diameter,origin,
                      widthPanel,heightPanel,rad,pi,widDash/2,fm,
                      lineSize,record,minorTicks,true);
    
    // draw features
    Vector markers = getGeneticMarker();
    for(int i=0; i<markers.size(); i++)
    {
      Block b = (Block)markers.get(i);
      b.drawCircular(g2);
    }
    
  }


  private void drawCircularTicks(Graphics2D g2, double ddiameter,
            double ddiameter2, int diameter, AffineTransform origin,
            double widthPanel,double heightPanel, double rad, double pi,
            double widDash, FontMetrics fm, int lineSize,
            boolean record, Vector ticks, boolean smallTicks)
  {

    double hgt = fm.getAscent();

    g2.setColor(Color.black);
    if(record)
    {
      int nsize = ticks.size();

      if(smallTicks)
      {
        tickMinorXPositions = new int[nsize];
        tickMinorYPositions = new int[nsize];
      }
      else
      {
        tickMajorXPositions = new int[nsize];
        tickMajorYPositions = new int[nsize];
      }
    }

    AffineTransform newOrig;
    Enumeration enumTk = ticks.elements();
    while(enumTk.hasMoreElements())
    {
      int tick = ((Integer)enumTk.nextElement()).intValue();
      double theta = Math.toRadians(-getAngleFromPosition(tick,rad));
      if(theta > pi)
        theta = theta - pi*2.d;

      newOrig = (AffineTransform)(origin.clone());

      // rotate and add tick mark
      newOrig.rotate(theta,widthPanel/2.d,heightPanel/2.d);
      String label = Integer.toString(tick);
      double wid = fm.stringWidth(label);

      int x = 0;
      int y = 0;
      if(record)
      {
        x = (int)( (ddiameter2) + (newOrig.getScaleX()*
                   (widDash+lineSize+3+(diameter+wid)/2.d)) - (wid/2.d));

        y = (int)( (ddiameter2) + (newOrig.getShearY()*
                   (widDash+lineSize+3+(diameter+hgt)/2.d)) + (hgt/2.d));

        int index = ticks.indexOf(new Integer(tick));

        if(smallTicks)
        {
          tickMinorXPositions[index] = x;
          tickMinorYPositions[index] = y;
        }
        else
        {
          tickMajorXPositions[index] = x;
          tickMajorYPositions[index] = y;
        }
      }
      else    // use stored positions for printing
      {
        int index = ticks.indexOf(new Integer(tick));
        if(smallTicks)
        {
          x = tickMinorXPositions[index];
          y = tickMinorYPositions[index];
        }
        {
          x = tickMajorXPositions[index];
          y = tickMajorYPositions[index];
        }
      }

      if(labelTicks && !smallTicks)        // add tick label
      {
        AffineTransform labelTransform = (AffineTransform)(origin.clone());
        labelTransform.translate(location.x+ddiameter2, location.y+ddiameter2);
        labelTransform.rotate(Math.toRadians(-THETA));
        labelTransform.translate(-(location.x+ddiameter2), -(location.y+ddiameter2));
        g2.setTransform(labelTransform);
        g2.drawString(label,
                    location.x+x,
                    location.y+y);
        g2.setTransform(origin);
      }
      
      g2.setTransform(newOrig);

      g2.setStroke(new BasicStroke(1.f));
      int xLine = location.x+(int)(ddiameter);
      int yLine = location.y+(int)(ddiameter/2.d);
      g2.drawLine(xLine,yLine,(int)(xLine+lineSize+widDash),yLine);

/*
      System.out.println("THETA "+Math.toDegrees(theta));
      System.out.println("m00 "+newOrig.getScaleX()+
                         " m01 "+newOrig.getShearX()+
                         " m02 "+newOrig.getTranslateX());
      System.out.println("m10 "+newOrig.getScaleY()+
                         " m12 "+newOrig.getTranslateY());
*/
      g2.setTransform(origin);
    }

    return;
  }


  /**
  *
  * Calculate the tick marks to be drawn
  *
  */
  protected void calculateTickPosistions()
  {
    minorTicks = new Vector();
    majorTicks = new Vector();
    int start = getStart();
    int end   = getEnd();

    if(majorTick == 0)
      return;

    for(int i=startTick; i<end; i+=majorTick)
      if(i >= start)
        majorTicks.add(new Integer(i));

    if(minorTick == 0)
      return;

    for(int i=startTick; i<end; i+=minorTick)
    {
      Integer tk = new Integer(i);
      if(i >= start && !majorTicks.contains(tk))
        minorTicks.add(tk);
    }
  }


  /**
  *
  * Return the position tick marks start at
  *
  */
  protected int getStartTick()
  { 
    return startTick;
  }

  
  /**
  *
  * Set the position tick marks start at
  *
  */
  protected boolean setStartTick(int startTick)
  {
    this.startTick = startTick;
    if((startTick >= getStart()) && (startTick < getEnd()))
      return true;
    
    return false;
  }

  
  /**
  *
  * Return the interval for the tick marks
  *
  */
  protected int getTickInterval()
  {
    return majorTick;
  }


  /**
  *
  * Set the interval for the tick marks
  *
  */
  public boolean setTickInterval(int majorTick)
  {
    if(majorTick < (getEnd()-getStart()))
    {
      this.majorTick = majorTick;
      return true;
    }
    return false;
  }


  /**
  *
  * Return the interval for the tick marks
  *
  */
  protected int getMinorTickInterval()
  {
    return minorTick;
  }


  /**
  *
  * Set the interval for the tick marks
  *
  */
  public boolean setMinorTickInterval(int minorTick)
  {
    if(minorTick < (getEnd()-getStart()))
    {
      this.minorTick = minorTick;
      return true;
    }
    return false;
  }


  /**
  *
  * Return an angle in degrees
  *
  */
  protected double getAngleFromPosition(int pos,double rad)
  {
    int start = getStart();
    int end   = getEnd();
    return - ((pos-start)*rad)/(end-start);
  }


  /**
  *
  * The method @print@ must be implemented for @Printable@ interface.
  * Parameters are supplied by system.
  *
  */
  public int print(Graphics g, PageFormat pf, int pageIndex)
                                       throws PrinterException
  {
    Graphics2D g2 = (Graphics2D)g;
    g2.setColor(Color.black);    //set default foreground color to black

    //RepaintManager.currentManager(this).setDoubleBufferingEnabled(false);
    Dimension d = this.getSize();    //get size of document
    double panelWidth  = d.width;    //width in pixels
    double panelHeight = d.height;   //height in pixels
    double pageHeight = pf.getImageableHeight();   //height of printer page
    double pageWidth  = pf.getImageableWidth();    //width of printer page
    double scale = pageWidth/panelWidth;
    int totalNumPages = (int)Math.ceil(scale * panelHeight / pageHeight);
    // Make sure not print empty pages
    if(pageIndex >= totalNumPages)
     return Printable.NO_SUCH_PAGE;

    // Shift Graphic to line up with beginning of print-imageable region
    g2.translate(pf.getImageableX(), pf.getImageableY());
    // Shift Graphic to line up with beginning of next page to print
    g2.translate(0f, -pageIndex*pageHeight);
    // Scale the page so the width fits...
    g2.scale(scale, scale);
    drawAll(g2,false);
    return Printable.PAGE_EXISTS;
  }

  public void drawAll(Graphics2D g2, boolean l)
  {
    if(((Boolean)lineAttr.get("circular")).booleanValue())
      drawCircularPanel(g2,l);   //repaint the page for printing
    else
      drawLinearPanel(g2);

    if(gcGraph != null && containsGraph(gcGraph))
      gcGraph.draw(g2);
    if(gcSkewGraph != null && containsGraph(gcSkewGraph))
      gcSkewGraph.draw(g2);
    if(userGraph != null && containsGraph(userGraph))
      userGraph.draw(g2);    
  }

  /**
   * Check if a Graph object is contained by the panel.
   * @param g
   * @return
   */
  private boolean containsGraph(Graph g)
  {
    int ncomponents = getComponentCount();
    for(int i=0; i<ncomponents; i++)
      if(getComponent(i).equals(g))
        return true;
    
    return false;
  }

  public void doPrintActions()
  {
    final PrinterJob pj=PrinterJob.getPrinterJob();
    pj.setPrintable(this);
    pj.printDialog();
    try
    {
      pj.print();
    }
    catch (Exception PrintException) {}
  }


  public void setRestrictionEnzyme(Vector restrictionEnzyme)
  {
    this.restrictionEnzyme = restrictionEnzyme;
  }

  public void setGeneticMarker(Vector block)
  {
    this.block = block;
  }

  protected Hashtable getLineAttributes()
  {
    return lineAttr;
  }

  public Hashtable getFeaturePoints()
  {
    Collections.sort(block, new BlockComparator());
    final Hashtable h = new Hashtable(block.size());
    int len = 0;
    double lastAngle = -10.d;
    
    for(int i=0; i<block.size(); i++)
    {
      Block b = (Block)block.get(i);
      double thisAngle = b.getMidAngle();
      
      if( Math.abs(thisAngle - lastAngle ) < 2 )
        len = len+10;
      else
        len = 0;
      
      h.put(b.getFeature().getIDString()+";"+b.getBstart()+".."+b.getBend(),
            b.getLinePoints( len ));
      
      lastAngle = thisAngle;
    }
    return h;
  }

  public void setLineAttributes(Hashtable lineAttr)
  {
    this.lineAttr = lineAttr;
  }


  protected void setLineSize(int lineSize)
  {
    lineAttr.put("lsize",new Integer(lineSize));
  }


  protected int getLineSize()
  {
    return ((Integer)lineAttr.get("lsize")).intValue();
  }

  public void setPlasmidLocation(int x,int y)
  {
    location.setLocation(x,y);
  } 

  
  public JMenuBar createMenuBar()
  {
    JMenuBar menuBar = new JMenuBar();

// file menu
    JMenu fileMenu = new JMenu("File");
    fileMenu.setMnemonic(KeyEvent.VK_F);
    menuBar.add(fileMenu);

    final JMenuItem openMenu = new JMenuItem("Open");
    openMenu.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Wizard.getFeaturesFromFile(DNADraw.this);
        majorTicks = null;

        if(gcGraph != null)
          gcGraph = new GCGraph(DNADraw.this);
        if(gcSkewGraph != null)
          gcSkewGraph = new GCSkewGraph(DNADraw.this);
        
        repaint();
        
        /*EmbossCirdnaReader dnaRead = new EmbossCirdnaReader();
        block = dnaRead.getBlock();
        restrictionEnzyme = dnaRead.getRestrictionEnzyme();

        lineAttr.put("start",new Integer(dnaRead.getStart()));
        lineAttr.put("end",new Integer(dnaRead.getEnd()));
   
        current_dna = new DNADraw(block,restrictionEnzyme,
                                  lineAttr,0,100,100);
        jsp.setViewportView(current_dna);*/
      }
    });
    fileMenu.add(openMenu);
    fileMenu.add(new JSeparator());
 
    final JMenuItem readInEntry = new JMenuItem("Read In Entry on Separate Track...");
    readInEntry.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Wizard.readEntry(DNADraw.this);
        viewer.refresh();
        repaint();
      }
    });
    fileMenu.add(readInEntry);
    
// print
    final JMenu printMenu = new JMenu("Print");
    fileMenu.add(printMenu);

    JMenuItem print = new JMenuItem("Print postscript");
    print.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        doPrintActions();
      }
    });
    printMenu.add(print);

    JMenuItem printImage = new JMenuItem("Print png/jpeg Image...");
    printImage.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        PrintDNAImage pdnai = new PrintDNAImage(current_dna);
        pdnai.print();
      }
    });
    printMenu.add(printImage);

// print preview
    JMenuItem printPreview = new JMenuItem("Print Preview...");
    printPreview.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        PrintDNAImage pdnai = new PrintDNAImage(current_dna);
        pdnai.printPreview();
      }
    });
    fileMenu.add(printPreview);
    fileMenu.add(new JSeparator());


    JMenuItem fileMenuExit = new JMenuItem("Exit");
    fileMenuExit.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        if(!close)
          System.exit(0);
        else
        {
          mainFrame.setVisible(false);
          mainFrame.dispose();
        }
      }
    });
    fileMenu.add(fileMenuExit);

// view menu
    JMenu viewMenu = new JMenu("View");
    menuBar.add(viewMenu);
  
    JMenuItem zoomIn = new JMenuItem("Zoom In");
    zoomIn.setAccelerator(KeyStroke.getKeyStroke(
                    KeyEvent.VK_I, ActionEvent.CTRL_MASK));
    zoomIn.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        zoomIn();
      }
    });
    viewMenu.add(zoomIn);

    JMenuItem zoomOut = new JMenuItem("Zoom Out");
    zoomOut.setAccelerator(KeyStroke.getKeyStroke(
                    KeyEvent.VK_O, ActionEvent.CTRL_MASK));
    zoomOut.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        zoomOut();
      }
    });
    viewMenu.add(zoomOut);

    
    JMenu graph_menu = new JMenu("Graph");
    graph_menu.setMnemonic(KeyEvent.VK_G);
    menuBar.add(graph_menu);
    
    JMenu gc = new JMenu("GC plot");
    graph_menu.add(gc);
    
    final JCheckBoxMenuItem gcPlot = new JCheckBoxMenuItem("Draw");
    gcPlot.setState(false);
    gcPlot.addItemListener(new ItemListener() 
    {
      public void itemStateChanged(ItemEvent event) 
      {
        if(gcPlot.isSelected())
        {
          if(gcGraph == null)
          {
            setCursor(new Cursor(Cursor.WAIT_CURSOR));
            gcGraph = new GCGraph(DNADraw.this);
            gcGraph.setTrack(0.4);
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
          }
          add(gcGraph);
          revalidate();
        }
        else
          remove(gcGraph);
        repaint();
      }
    });
    gc.add(gcPlot);
    
    JMenuItem gcOptions = new JMenuItem("Options...");
    gc.add(gcOptions);
    gcOptions.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        gcGraph.showOptions();
      } 
    });
    
    JMenu gcSkew = new JMenu("GC Skew");
    graph_menu.add(gcSkew);
    
    final JCheckBoxMenuItem gcSkewPlot = new JCheckBoxMenuItem("GC Skew plot");
    gcSkewPlot.setState(false);
    gcSkewPlot.addItemListener(new ItemListener() 
    {
      public void itemStateChanged(ItemEvent event) 
      {
        if(gcSkewPlot.isSelected())
        {
          if(gcSkewGraph == null)
          {
            setCursor(new Cursor(Cursor.WAIT_CURSOR));
            gcSkewGraph = new GCSkewGraph(DNADraw.this);
            gcSkewGraph.setTrack(0.2);
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
          }
          add(gcSkewGraph);
          revalidate();
        }
        else
          remove(gcSkewGraph);
        repaint();
      }
    });
    gcSkew.add(gcSkewPlot);

    JMenuItem gcSkewOptions = new JMenuItem("Options...");
    gcSkew.add(gcSkewOptions);
    gcSkewOptions.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        gcSkewGraph.showOptions();
      } 
    });

    
    //
    // User graph
    
    JMenu user = new JMenu("User");
    graph_menu.add(user);
    final JCheckBoxMenuItem userPlot = new JCheckBoxMenuItem("User plot");
    userPlot.setState(false);
    userPlot.addItemListener(new ItemListener() 
    {
      public void itemStateChanged(ItemEvent event) 
      {
        if(userPlot.isSelected())
        {
          final uk.ac.sanger.artemis.components.StickyFileChooser dialog =
            new uk.ac.sanger.artemis.components.StickyFileChooser ();

          dialog.setDialogTitle ("Select a data file name ...");
          dialog.setDialogType (JFileChooser.OPEN_DIALOG);

          final int status = dialog.showOpenDialog (null);

          if(status != JFileChooser.APPROVE_OPTION ||
             dialog.getSelectedFile () == null) 
          {
            return;
          }

          final java.io.File file =
            new java.io.File (dialog.getCurrentDirectory (),
                      dialog.getSelectedFile ().getName ());

          if(file.length() == 0)
            return;
          
          final uk.ac.sanger.artemis.util.Document document =
              new uk.ac.sanger.artemis.util.FileDocument (file);
          
          try
          {
            userGraph = new UserGraph(DNADraw.this, document);
          }
          catch(IOException e)
          {
            e.printStackTrace();
            return;
          }
          
          if(userGraph == null)
          {
            setCursor(new Cursor(Cursor.WAIT_CURSOR));
            try
            {
              userGraph = new UserGraph(DNADraw.this, document);
            }
            catch(IOException e)
            {
              e.printStackTrace();
            }
            userGraph.setTrack(0.2);
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
          }
          add(userGraph);
          revalidate();
        }
        else
          remove(userGraph);
        repaint();
      }
    });
    user.add(userPlot);

    
    JMenuItem userOptions = new JMenuItem("Options...");
    user.add(userOptions);
    userOptions.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        userGraph.showOptions();
      } 
    });
    
    
// options menu
    JMenu optionMenu = new JMenu("Options");
    menuBar.add(optionMenu);


    JMenuItem wizard = new JMenuItem("DNA Wizard...");
    wizard.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {   
        Wizard wiz = new Wizard(current_dna);
        current_dna = wiz.getDNADraw();
        jsp.setViewportView(current_dna);
      }
    });
    optionMenu.add(wizard);
    optionMenu.add(new JSeparator());

    JMenuItem tracksMenu = new JMenuItem("Track Manager...");

    if(getArtemisEntryGroup() != null)
    {
      viewer = new TrackViewer(DNADraw.this);
      tracksMenu.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          viewer.setVisible(true);
        }
      });
    }
    else
      tracksMenu.setEnabled(false);
    
    optionMenu.add(tracksMenu);
    
    
    JMenuItem line = new JMenuItem("DNA Properties...");
    line.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        JFrame f = new JFrame("DNA Properties");
        LineAttribute la = new LineAttribute(current_dna);
        JScrollPane laScroll = new JScrollPane(la);
        JPanel laPane = (JPanel)f.getContentPane();
        laPane.add(laScroll,BorderLayout.CENTER);
        f.setJMenuBar(la.createMenuBar(f));
        f.pack();
        f.setVisible(true);
      }
    });
    optionMenu.add(line);

    
    JMenuItem tickMarks = new JMenuItem("Tick marks...");
    tickMarks.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        JFrame f = new JFrame("Tick Marks");
        Ticks tk = new Ticks(current_dna,true);
        JScrollPane tkScroll = new JScrollPane(tk);
        JPanel tkPane = (JPanel)f.getContentPane();
        tkPane.add(tkScroll,BorderLayout.CENTER);
        f.setJMenuBar(tk.createMenuBar(f));
        f.pack();
        f.setVisible(true);
      }
    });
    optionMenu.add(tickMarks);


    JMenuItem gmarker = new JMenuItem("Features...");
    gmarker.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        JFrame f = new JFrame("Features");
        GeneticMarker gm = new GeneticMarker(current_dna,
                                             block);
        JScrollPane gmScroll = new JScrollPane(gm);
        JPanel gmPane = (JPanel)f.getContentPane();
        gmPane.add(gmScroll,BorderLayout.CENTER);
        f.setJMenuBar(gm.createMenuBar(f));
        f.pack();
        f.setVisible(true);
      }
    });
    optionMenu.add(gmarker);

    JMenuItem reSites = new JMenuItem("Restriction Enzyme...");
    reSites.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        JFrame f = new JFrame("Restriction Enzyme");
        RestrictionEnzyme re = new RestrictionEnzyme(current_dna,
                                              restrictionEnzyme);
        JScrollPane reScroll = new JScrollPane(re);
        JPanel rePane = (JPanel)f.getContentPane();
        rePane.add(reScroll,BorderLayout.CENTER);
        f.setJMenuBar(re.createMenuBar(f));
        f.pack();
        f.setVisible(true);
      }
    });
    optionMenu.add(reSites);
    
    final JCheckBoxMenuItem labelTick = new JCheckBoxMenuItem("Show tick numbers", labelTicks);
    labelTick.addItemListener(new ItemListener()
    {

      public void itemStateChanged(ItemEvent e)
      {
        labelTicks = labelTick.isSelected();
        repaint();
      }
    });
    optionMenu.add(labelTick);

// help manu
    JMenu helpMenu = new JMenu("Help");
    menuBar.add(helpMenu);
   
    JMenuItem aboutMenu = new JMenuItem("About");
    helpMenu.add(aboutMenu);
    aboutMenu.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        ClassLoader cl = DNADraw.this.getClass().getClassLoader();
        URL url = cl.getResource("etc/readmeDNADraw.html");
        BrowserControl.displayURL(url.toString());
      }
    });

    return menuBar;
  }

  
  public void setCloseAndDispose(boolean close, JFrame mainFrame)
  {
    this.mainFrame = mainFrame;
    this.close = close;
  }

  protected Vector getGeneticMarker()
  {
    return block;
  }


  protected Vector getRestrictionEnzyme()
  {
    return restrictionEnzyme;
  }


  protected int getStart()
  {
    return ((Integer)lineAttr.get("start")).intValue();
  }

 
  protected int getEnd()
  {
    return ((Integer)lineAttr.get("end")).intValue();
  }

  
  protected void setStart(int start)
  {
    lineAttr.put("start",new Integer(start));
    calculateTickPosistions();
  }


  protected void setEnd(int end)
  {
    lineAttr.put("end",new Integer(end));
    calculateTickPosistions();
  }

  private Block getBlockAtLocation(Point loc)
  {
    for(int i=0; i<block.size(); i++)
    {
      Block b = (Block) block.get(i);
      if(b.isOverMe(loc.x, loc.y))
        return b;
    }
    return null;
  }
  
////////////////////
// DRAG AND DROP
////////////////////
  public RenderedImage createImage(Block b)
  {
    // Create a buffered image in which to draw
    BufferedImage bufferedImage = new BufferedImage(getWidth(), getHeight(),
                                      BufferedImage.TYPE_INT_ARGB);
  
    // Create a graphics contents on the buffered image
    Graphics2D g2d = bufferedImage.createGraphics();
    RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON); 
    qualityHints.put(RenderingHints.KEY_RENDERING,               
    RenderingHints.VALUE_RENDER_QUALITY); 
    g2d.setRenderingHints(qualityHints);
    g2d.setTransform( ((Graphics2D)getGraphics()).getTransform() );
    // Draw graphics
    //b.drawCircular(g2d);
    
    g2d.setStroke(new BasicStroke(2.f));
    g2d.setColor(b.getColour());
    g2d.drawArc(0, 0, 10, 10, 0, 360);
    g2d.dispose();
  
    return bufferedImage;
  }
  
// drag source
  public void dragGestureRecognized(DragGestureEvent e)
  {
    // ignore if mouse popup trigger
    InputEvent ie = e.getTriggerEvent();
    if(ie instanceof MouseEvent)
      if(((MouseEvent)ie).isPopupTrigger())
        return;

    Point loc = e.getDragOrigin();
    Block b = getBlockAtLocation(loc);
    
    if(b != null)
    {
      Image image = (Image)createImage(b);
      e.startDrag(DragSource.DefaultCopyDrop,  // cursor
          image, new Point(-1, -1),
          (Transferable)b,             // transferable data
          this);
    }
  }

  public void dragDropEnd(DragSourceDropEvent e) {}
  public void dragEnter(DragSourceDragEvent e) {}
  public void dragExit(DragSourceEvent e) {}
  public void dragOver(DragSourceDragEvent e) {}
  public void dropActionChanged(DragSourceDragEvent e) {}

// drop sink
  public void dragEnter(DropTargetDragEvent e)
  {
    if(e.isDataFlavorSupported(Block.BLOCK))
      e.acceptDrag(DnDConstants.ACTION_COPY_OR_MOVE);
  }

  public void drop(DropTargetDropEvent e)
  {
    Transferable t = e.getTransferable();
    if(t.isDataFlavorSupported(Block.BLOCK))
    {
      try
      {
        Point loc = e.getLocation();
        Block b   = (Block)t.getTransferData(Block.BLOCK);
        b.setBlockLocation(loc.x,loc.y);
        DNADraw.this.repaint();
      }
      catch(Exception ufe){} 
    }
  }

  public void dragOver(DropTargetDragEvent e)
  {
  }

  public void dropActionChanged(DropTargetDragEvent e) {}
  public void dragExit(DropTargetEvent e){}
  
  public EntryGroup getArtemisEntryGroup()
  {
    return artemisEntryGroup;
  }

  public void setArtemisEntryGroup(EntryGroup artemisEntryGroup)
  {
    this.artemisEntryGroup = artemisEntryGroup;
  }
  
  public Bases getBases()
  {
    if(getArtemisEntryGroup() != null)
      return getArtemisEntryGroup().getSequenceEntry().getBases();
    return this.bases;
  }
  
  public void setBases(Bases bases)
  {
    this.bases = bases;
  }
  
  protected Vector getBlock()
  {
    return block;
  }
  
  public static void main(String arg[])
  {
    final Wizard wiz = new Wizard(null);
    final DNADraw dna = wiz.getDNADraw();
     
    /**
    final DNADraw dna = new DNADraw();
    final String seq =         
    "taaaggtagaattggaaaaattggaaaaattggaaaaatcatgtgatcac"+
    "tgtaaaacaactaacaaatgcaagaatgattatgataaaaataaatgtga"+
    "aaagtgtaaaacgagatgtcaacaatatgataattttattcttaaatgga"+
    "aaactctattcgatatacaatctaagaaatacaaagaattgtatgaacca"+
    "atagatacaaaaaactctacttatgatcatgttgaaaattttgtacaaaa"+
    "gttgaaaaaatataaaaatgaatgttctgttgaaagcgtttctgaatatc"+
    "ttcatgaaacaagtaagtgtttgaattataaatttgatgaaaatgatggt"+
    "tcttctaatatacgatcatatgcttttgaagaaacaccaaaaagttataa"+
    "agaagcttgcagttgtacattaccttctaagaatccattggataattgtc"+
    "ctaccgatcaaaacaaagatgtatgtaaggaattacaaacttttaccttc"+
    "tgctcgaagaatgattatgataataatcttgataattggaacgcatacct"+
    "tgttcttaatagttcagatgataataaaggtgtattgattcctccaagaa"+
    "gaagacatttatgtacaagacctatcactgcatataattatagaaaaggt"+
    "gataaagaaattttaaaaaaaaaacttcttacttctgctttcagtcaagg"+
    "acaattgttaggtcaaaaatataaatcggaagaagagttgtgctttgagg"+
    "caatgaaatatagttatgcagattattccgatataattaaaggaactgat"+
    "atgatggacacttcattatctgaaaaaattaaaaaaatatttgaaacatc"+
    "aaatcaagacactgaagattgtaaaacatggtgggaaaaaaatagaagtc"+
    "atgtatggcacgctatgttatgtggatatatatcaaaaaacaaaaatgag"+
    "aacattaacccaaaatggtgtaatgtacctactgaagatggaactgatca"+
    "attcttaagatggttaattgaatgggcaatgcaagcatgtaaagaaaaga"+
    "aacgtgtaagggattcattaaaaacaaaatgtcgttgttcaaacaaagat"+
    "aattttaaagcgtcagaattattaagacaacctggatgtcagaatgatat"+
    "tagaaaatatattagcttgaatatattgatacaaaattcaatggaaaatc"+
    "taaatataaaatataaaaaattcaaagatcaatcttcaggtttagggttc"+
    "agggtttagggttcagggtttagggtttagggttcagggttttaggttta"+
    "gggttcagggtttagggttcagggtttagggtttagggttcagggtttta"+
    "gggtttagggttcagggtttagggtttaggtttagggtttaggtttaggg"+
    "ttcagggtttaggtttagggttcagggtttaggtttagggttcagggttt"+
    "agggttcagggttcagggtttagggttccggtttagggttcagggttcag"+
    "ggtttagggtttagggtttagggttcagggttcaggtttagggtttaggg"+
    "ttcagggtttagggtttaggtttcagggtttagggtttagggtttagggt"+
    "ttaggtttagggtttagggtttaggtttagggtttagggttcatggttta"+
    "gggtttagggtttagggtttagggtttagggtttaggtttagggttgtgg"+
    "tttagggtttagggtttagggttcagggtttagggtttagggttcagggt";
    
    Bases bases = new Bases(new uk.ac.sanger.artemis.io.RawStreamSequence(seq));
    
    dna.setBases( bases  );
    int sequenceLength = bases.getLength();
    
    
    // set sequence length and
    Hashtable lineAttr = new Hashtable();
    lineAttr.put("lsize",new Integer(1));
    lineAttr.put("circular",new Boolean(true));
    lineAttr.put("start",new Integer(0));
    lineAttr.put("end",new Integer(sequenceLength));
    dna.setLineAttributes(lineAttr);   
    
    // set ticks
    int div;
    if(sequenceLength < 1000)
      div = 100;
    else if(sequenceLength < 10000)
      div = 1000;
    else if(sequenceLength < 100000)
      div = 10000;
    else
      div = 100000;
    int tick = sequenceLength/div;
    tick = tick*(div/10);
    dna.setMinorTickInterval(tick);
    dna.setTickInterval(tick);
     
    final List features = new Vector();
    features.add(new Feature("a", 20, 250, 2));
    features.add(new Feature("b", 300, 550, 2));

    final Track track = new Track(0.9);
    dna.setGeneticMarker(new Vector());
    dna.addFeaturesToTrack(features, track, true);
    
    final Track track2 = new Track(0.8);
    dna.addFeatureToTrack(new Feature("cc", 1400, 1555, 5), track2, true);
    **/
    
    //
    final JFrame f = new JFrame("DNA Viewer");

    Dimension d = f.getToolkit().getScreenSize();
    jsp = new JScrollPane(dna);
    jsp.getViewport().setBackground(Color.white);
    f.getContentPane().add(jsp);
    f.setJMenuBar(dna.createMenuBar());
    
    //dna.add(new Graph(dna));
    f.pack();
    f.setLocation(((int)d.getWidth()-f.getWidth())/4,
                  ((int)d.getHeight()-f.getHeight())/2);

    
    //dna.add(dna.new BlockPanel(dna));
    f.setVisible(true);
  }
  
  /*class BlockPanel extends JPanel
  {
    private DNADraw dna;
    BlockPanel(DNADraw dna)
    {
      super();
      this.dna = dna;
      setOpaque(false);
      setPreferredSize(dna.getPreferredSize());
    }
    
    protected void paintComponent(Graphics g)
    {
      Hashtable h = dna.getFeaturePoints();
      Enumeration he = h.keys();
      Graphics2D g2 = (Graphics2D)g;
      g2.setTransform(original);
      g2.setStroke(new BasicStroke(1.f));
      while(he.hasMoreElements())
      {
        String label = (String) he.nextElement();
        Point[] p = (Point[])h.get(label);
        
        g2.setColor(Color.DARK_GRAY);
        g2.drawLine(p[0].x,p[0].y,p[1].x,p[1].y);
        g2.drawLine(p[1].x,p[1].y,p[2].x,p[2].y);
        //g2.drawString(label, p[0].x,p[0].y);
      }
    }
  }*/

}
