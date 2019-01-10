/*
 * This file was automatically generated by EvoSuite
 * Wed Sep 19 22:02:18 GMT 2018
 */

package uk.ac.sanger.artemis.plot;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.junit.runner.RunWith;
import uk.ac.sanger.artemis.io.FastaStreamSequence;
import uk.ac.sanger.artemis.io.GenbankStreamSequence;
import uk.ac.sanger.artemis.io.RawStreamSequence;
import uk.ac.sanger.artemis.io.Sequence;
import uk.ac.sanger.artemis.plot.AGWindowAlgorithm;
import uk.ac.sanger.artemis.sequence.Bases;
import uk.ac.sanger.artemis.sequence.Strand;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false, useJEE = true) 
public class AGWindowAlgorithm_ESTest extends AGWindowAlgorithm_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      FastaStreamSequence fastaStreamSequence0 = new FastaStreamSequence("$K");
      Bases bases0 = new Bases(fastaStreamSequence0);
      Strand strand0 = mock(Strand.class, new ViolatedAssumptionAnswer());
      doReturn(bases0).when(strand0).getBases();
      doReturn(true).when(strand0).isForwardStrand();
      AGWindowAlgorithm aGWindowAlgorithm0 = new AGWindowAlgorithm(strand0);
      float[] floatArray0 = new float[9];
      fastaStreamSequence0.setFromChar(bases0.letter_index);
      aGWindowAlgorithm0.getValues(2, 2, floatArray0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Strand strand0 = mock(Strand.class, new ViolatedAssumptionAnswer());
      doReturn((Bases) null).when(strand0).getBases();
      doReturn(false).when(strand0).isForwardStrand();
      AGWindowAlgorithm aGWindowAlgorithm0 = new AGWindowAlgorithm(strand0);
      aGWindowAlgorithm0.getDefaultStepSize(50331648);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      RawStreamSequence rawStreamSequence0 = new RawStreamSequence("");
      Bases bases0 = new Bases(rawStreamSequence0);
      Strand strand0 = bases0.getForwardStrand();
      AGWindowAlgorithm aGWindowAlgorithm0 = new AGWindowAlgorithm(strand0);
      aGWindowAlgorithm0.getAverage();
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      FastaStreamSequence fastaStreamSequence0 = new FastaStreamSequence("(]joj&sW");
      Bases bases0 = new Bases(fastaStreamSequence0);
      Strand strand0 = mock(Strand.class, new ViolatedAssumptionAnswer());
      doReturn(bases0).when(strand0).getBases();
      doReturn(false).when(strand0).isForwardStrand();
      AGWindowAlgorithm aGWindowAlgorithm0 = new AGWindowAlgorithm(strand0);
      aGWindowAlgorithm0.getAverage();
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      FastaStreamSequence fastaStreamSequence0 = new FastaStreamSequence("uk.ac.sanger.artemis.components.FeatureDisplay$1", "uk.ac.sanger.artemis.components.FeatureDisplay$1");
      Bases bases0 = new Bases(fastaStreamSequence0);
      Strand strand0 = bases0.getReverseStrand();
      AGWindowAlgorithm aGWindowAlgorithm0 = new AGWindowAlgorithm(strand0);
      aGWindowAlgorithm0.getAverage();
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Bases bases0 = new Bases((Sequence) null);
      Strand strand0 = bases0.getReverseStrand();
      AGWindowAlgorithm aGWindowAlgorithm0 = new AGWindowAlgorithm(strand0);
      float[] floatArray0 = new float[9];
      // Undeclared exception!
      try { 
        aGWindowAlgorithm0.getValues((-590), 0, floatArray0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sanger.artemis.sequence.Bases", e);
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      GenbankStreamSequence genbankStreamSequence0 = new GenbankStreamSequence(" would violate constraints");
      Bases bases0 = new Bases(genbankStreamSequence0);
      Strand strand0 = mock(Strand.class, new ViolatedAssumptionAnswer());
      doReturn(bases0).when(strand0).getBases();
      doReturn(true).when(strand0).isForwardStrand();
      AGWindowAlgorithm aGWindowAlgorithm0 = new AGWindowAlgorithm(strand0);
      float[] floatArray0 = new float[8];
      // Undeclared exception!
      try { 
        aGWindowAlgorithm0.getValues(97, 0, floatArray0);
        fail("Expecting exception: Error");
      
      } catch(Error e) {
         //
         // internal error - unexpected exception: org.evosuite.runtime.mock.java.lang.MockThrowable: start: 97 > end: 0
         //
         verifyException("uk.ac.sanger.artemis.plot.AGWindowAlgorithm", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      AGWindowAlgorithm aGWindowAlgorithm0 = null;
      try {
        aGWindowAlgorithm0 = new AGWindowAlgorithm((Strand) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sanger.artemis.plot.BaseAlgorithm", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      FastaStreamSequence fastaStreamSequence0 = new FastaStreamSequence("(]joj&sW");
      Bases bases0 = new Bases(fastaStreamSequence0);
      Strand strand0 = mock(Strand.class, new ViolatedAssumptionAnswer());
      doReturn(bases0).when(strand0).getBases();
      doReturn(false).when(strand0).isForwardStrand();
      AGWindowAlgorithm aGWindowAlgorithm0 = new AGWindowAlgorithm(strand0);
      aGWindowAlgorithm0.getMinimumInternal();
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      FastaStreamSequence fastaStreamSequence0 = new FastaStreamSequence("(]joj&sW");
      Bases bases0 = new Bases(fastaStreamSequence0);
      Strand strand0 = mock(Strand.class, new ViolatedAssumptionAnswer());
      doReturn(bases0).when(strand0).getBases();
      doReturn(false).when(strand0).isForwardStrand();
      AGWindowAlgorithm aGWindowAlgorithm0 = new AGWindowAlgorithm(strand0);
      aGWindowAlgorithm0.getMaximumInternal();
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      FastaStreamSequence fastaStreamSequence0 = new FastaStreamSequence("(]joj&sW");
      Bases bases0 = new Bases(fastaStreamSequence0);
      Strand strand0 = mock(Strand.class, new ViolatedAssumptionAnswer());
      doReturn(bases0).when(strand0).getBases();
      doReturn(false).when(strand0).isForwardStrand();
      AGWindowAlgorithm aGWindowAlgorithm0 = new AGWindowAlgorithm(strand0);
      aGWindowAlgorithm0.getValueCount();
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      FastaStreamSequence fastaStreamSequence0 = new FastaStreamSequence("$K");
      Bases bases0 = new Bases(fastaStreamSequence0);
      Strand strand0 = mock(Strand.class, new ViolatedAssumptionAnswer());
      doReturn(bases0).when(strand0).getBases();
      doReturn(true).when(strand0).isForwardStrand();
      AGWindowAlgorithm aGWindowAlgorithm0 = new AGWindowAlgorithm(strand0);
      aGWindowAlgorithm0.getDefaultStepSize(12);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Strand strand0 = mock(Strand.class, new ViolatedAssumptionAnswer());
      doReturn((Bases) null).when(strand0).getBases();
      doReturn(false).when(strand0).isForwardStrand();
      AGWindowAlgorithm aGWindowAlgorithm0 = new AGWindowAlgorithm(strand0);
      aGWindowAlgorithm0.getDefaultStepSize(0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Strand strand0 = mock(Strand.class, new ViolatedAssumptionAnswer());
      doReturn((Bases) null).when(strand0).getBases();
      doReturn(false).when(strand0).isForwardStrand();
      AGWindowAlgorithm aGWindowAlgorithm0 = new AGWindowAlgorithm(strand0);
      aGWindowAlgorithm0.getDefaultMinWindowSize();
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Strand strand0 = mock(Strand.class, new ViolatedAssumptionAnswer());
      doReturn((Bases) null).when(strand0).getBases();
      doReturn(false).when(strand0).isForwardStrand();
      AGWindowAlgorithm aGWindowAlgorithm0 = new AGWindowAlgorithm(strand0);
      aGWindowAlgorithm0.getDefaultMaxWindowSize();
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      FastaStreamSequence fastaStreamSequence0 = new FastaStreamSequence("$K");
      Bases bases0 = new Bases(fastaStreamSequence0);
      Strand strand0 = mock(Strand.class, new ViolatedAssumptionAnswer());
      doReturn(bases0).when(strand0).getBases();
      doReturn(true).when(strand0).isForwardStrand();
      AGWindowAlgorithm aGWindowAlgorithm0 = new AGWindowAlgorithm(strand0);
      aGWindowAlgorithm0.getDefaultWindowSize();
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      FastaStreamSequence fastaStreamSequence0 = new FastaStreamSequence("$K");
      Bases bases0 = new Bases(fastaStreamSequence0);
      Strand strand0 = mock(Strand.class, new ViolatedAssumptionAnswer());
      doReturn(bases0).when(strand0).getBases();
      doReturn(true).when(strand0).isForwardStrand();
      AGWindowAlgorithm aGWindowAlgorithm0 = new AGWindowAlgorithm(strand0);
      float[] floatArray0 = new float[9];
      aGWindowAlgorithm0.getValues(2, 2, floatArray0);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Strand strand0 = mock(Strand.class, new ViolatedAssumptionAnswer());
      doReturn((Bases) null).when(strand0).getBases();
      doReturn(false).when(strand0).isForwardStrand();
      AGWindowAlgorithm aGWindowAlgorithm0 = new AGWindowAlgorithm(strand0);
      // Undeclared exception!
      try { 
        aGWindowAlgorithm0.getAverage();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sanger.artemis.plot.BaseAlgorithm", e);
      }
  }
}
