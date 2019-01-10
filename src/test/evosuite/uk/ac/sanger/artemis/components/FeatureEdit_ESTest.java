/*
 * This file was automatically generated by EvoSuite
 * Thu Sep 20 11:36:25 GMT 2018
 */

package uk.ac.sanger.artemis.components;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import javax.swing.JFrame;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import uk.ac.sanger.artemis.EntryGroup;
import uk.ac.sanger.artemis.Feature;
import uk.ac.sanger.artemis.Selection;
import uk.ac.sanger.artemis.SimpleEntryGroup;
import uk.ac.sanger.artemis.SimpleGotoEventSource;
import uk.ac.sanger.artemis.components.FeatureEdit;
import uk.ac.sanger.artemis.io.EmblStreamFeature;
import uk.ac.sanger.artemis.io.RawStreamSequence;
import uk.ac.sanger.artemis.sequence.Bases;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, useJEE = true) 
public class FeatureEdit_ESTest extends FeatureEdit_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      FeatureEdit.setTabbedView(true);
      boolean boolean0 = FeatureEdit.isTabbedView();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      EmblStreamFeature emblStreamFeature0 = new EmblStreamFeature();
      Feature feature0 = new Feature(emblStreamFeature0);
      RawStreamSequence rawStreamSequence0 = new RawStreamSequence("readOnly");
      Bases bases0 = new Bases(rawStreamSequence0);
      SimpleEntryGroup simpleEntryGroup0 = new SimpleEntryGroup(bases0);
      SimpleGotoEventSource simpleGotoEventSource0 = new SimpleGotoEventSource(simpleEntryGroup0);
      FeatureEdit featureEdit0 = null;
      try {
        featureEdit0 = new FeatureEdit(feature0, (EntryGroup) null, (Selection) null, simpleGotoEventSource0, (JFrame) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sanger.artemis.components.FeatureEdit", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      boolean boolean0 = FeatureEdit.isTabbedView();
      assertFalse(boolean0);
  }
}
