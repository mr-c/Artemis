/*
 * This file was automatically generated by EvoSuite
 * Wed Sep 19 19:14:47 GMT 2018
 */

package uk.ac.sanger.artemis.editor;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.MenuElement;
import javax.swing.MenuSelectionManager;
import javax.swing.event.MenuDragMouseEvent;
import javax.swing.text.DefaultEditorKit;
import org.apache.batik.anim.dom.SVG12DOMImplementation;
import org.apache.batik.anim.dom.SVG12OMDocument;
import org.apache.batik.dom.GenericDocumentType;
import org.apache.batik.svggen.SVGGeneratorContext;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.xmlgraphics.java2d.GraphicsConfigurationWithoutTransparency;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import org.w3c.dom.DOMImplementation;
import uk.ac.sanger.artemis.editor.HitInfo;
import uk.ac.sanger.artemis.editor.MouseOverButton;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false, useJEE = true) 
public class MouseOverButton_ESTest extends MouseOverButton_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      HitInfo hitInfo0 = new HitInfo("uk.ac.sanger.artemis.editor.MouseOverButton", "");
      hitInfo0.setOrganism("uk.ac.sanger.artemis.editor.MouseOverButton");
      MouseOverButton mouseOverButton0 = new MouseOverButton(hitInfo0);
      String string0 = mouseOverButton0.getToolTipText();
      assertEquals("uk.ac.sanger.artemis.editor.MouseOverButton", string0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      MouseOverButton mouseOverButton0 = new MouseOverButton();
      // Undeclared exception!
      try { 
        mouseOverButton0.processMouseEvent((MouseEvent) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.awt.Component", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      HitInfo hitInfo0 = new HitInfo("uk.ac.sanger.artemis.editor.MouseOverButton", "");
      MouseOverButton mouseOverButton0 = new MouseOverButton(hitInfo0);
      // Undeclared exception!
      try { 
        mouseOverButton0.paintComponent((Graphics) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("javax.swing.JComponent", e);
      }
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      MouseOverButton mouseOverButton0 = null;
      try {
        mouseOverButton0 = new MouseOverButton((HitInfo) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sanger.artemis.editor.MouseOverButton", e);
      }
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      MouseOverButton mouseOverButton0 = new MouseOverButton("");
      MouseWheelEvent mouseWheelEvent0 = new MouseWheelEvent(mouseOverButton0, 1684, 1684, 7, 287, 17, 3, false, 0, 3, (short)8);
      mouseOverButton0.processMouseEvent(mouseWheelEvent0);
      assertEquals(1684L, mouseWheelEvent0.getWhen());
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      MouseOverButton mouseOverButton0 = new MouseOverButton("");
      String string0 = mouseOverButton0.getToolTipText();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      MouseOverButton mouseOverButton0 = new MouseOverButton("$I:z6e2J`79&^CK,");
      GraphicsConfigurationWithoutTransparency graphicsConfigurationWithoutTransparency0 = new GraphicsConfigurationWithoutTransparency();
      BufferedImage bufferedImage0 = graphicsConfigurationWithoutTransparency0.createCompatibleImage(1893, 1893, 0);
      Graphics graphics2D0 = bufferedImage0.getGraphics();
      mouseOverButton0.paintComponent(graphics2D0);
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      MouseOverButton mouseOverButton0 = new MouseOverButton("");
      GenericDocumentType genericDocumentType0 = new GenericDocumentType("", "", "org.apache.batik.anim.values.AnimatableMotionPointValue");
      DOMImplementation dOMImplementation0 = SVG12DOMImplementation.getDOMImplementation();
      SVG12OMDocument sVG12OMDocument0 = new SVG12OMDocument(genericDocumentType0, dOMImplementation0);
      SVGGeneratorContext sVGGeneratorContext0 = SVGGeneratorContext.createDefault(sVG12OMDocument0);
      SVGGraphics2D sVGGraphics2D0 = new SVGGraphics2D(sVGGeneratorContext0, false);
      mouseOverButton0.paintComponent(sVGGraphics2D0);
      assertFalse(mouseOverButton0.isFocusTraversalPolicySet());
  }

  @Test(timeout = 4000)
  public void test8()  throws Throwable  {
      MouseOverButton mouseOverButton0 = new MouseOverButton();
      MenuElement[] menuElementArray0 = new MenuElement[2];
      DefaultEditorKit.CutAction defaultEditorKit_CutAction0 = new DefaultEditorKit.CutAction();
      JCheckBoxMenuItem jCheckBoxMenuItem0 = new JCheckBoxMenuItem(defaultEditorKit_CutAction0);
      MenuSelectionManager menuSelectionManager0 = MenuSelectionManager.defaultManager();
      MenuDragMouseEvent menuDragMouseEvent0 = new MenuDragMouseEvent(jCheckBoxMenuItem0, 504, 1808, 0, 18, 8836, (-2071), 8836, 0, true, menuElementArray0, menuSelectionManager0);
      mouseOverButton0.processMouseEvent(menuDragMouseEvent0);
      assertEquals(8836, menuDragMouseEvent0.getY());
  }
}
