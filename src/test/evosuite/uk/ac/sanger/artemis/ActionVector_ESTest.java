/*
 * This file was automatically generated by EvoSuite
 * Thu Sep 20 13:35:36 GMT 2018
 */

package uk.ac.sanger.artemis;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.NoSuchElementException;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import uk.ac.sanger.artemis.Action;
import uk.ac.sanger.artemis.ActionVector;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, useJEE = true) 
public class ActionVector_ESTest extends ActionVector_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      ActionVector actionVector0 = new ActionVector();
      actionVector0.add((Action) null);
      actionVector0.size();
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      ActionVector actionVector0 = new ActionVector();
      actionVector0.add((Action) null);
      actionVector0.removeAndReturnLast();
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      ActionVector actionVector0 = new ActionVector();
      actionVector0.add((Action) null);
      actionVector0.elementAt(0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      ActionVector actionVector0 = new ActionVector();
      actionVector0.add((Action) null);
      actionVector0.add((Action) null);
      actionVector0.removeAndReturnLast();
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      ActionVector actionVector0 = new ActionVector();
      // Undeclared exception!
      try { 
        actionVector0.removeAndReturnLast();
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Vector", e);
      }
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      ActionVector actionVector0 = new ActionVector();
      int int0 = actionVector0.size();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      ActionVector actionVector0 = new ActionVector();
      // Undeclared exception!
      try { 
        actionVector0.elementAt(2);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // 2 >= 0
         //
         verifyException("java.util.Vector", e);
      }
  }
}
