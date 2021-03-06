/*
 * This file was automatically generated by EvoSuite
 * Thu Sep 20 14:28:42 GMT 2018
 */

package org.gmod.schema.phylogeny;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.gmod.schema.phylogeny.Phylonode;
import org.gmod.schema.phylogeny.PhylonodePub;
import org.gmod.schema.pub.Pub;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, useJEE = true) 
public class PhylonodePub_ESTest extends PhylonodePub_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      PhylonodePub phylonodePub0 = new PhylonodePub();
      phylonodePub0.setPhylonodePubId(1);
      int int0 = phylonodePub0.getPhylonodePubId();
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      PhylonodePub phylonodePub0 = new PhylonodePub();
      phylonodePub0.setPhylonodePubId((-789));
      int int0 = phylonodePub0.getPhylonodePubId();
      assertEquals((-789), int0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      PhylonodePub phylonodePub0 = new PhylonodePub();
      phylonodePub0.setPhylonode((Phylonode) null);
      assertEquals(0, phylonodePub0.getPhylonodePubId());
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      Pub pub0 = mock(Pub.class, new ViolatedAssumptionAnswer());
      Phylonode phylonode0 = mock(Phylonode.class, new ViolatedAssumptionAnswer());
      PhylonodePub phylonodePub0 = new PhylonodePub((-1), pub0, phylonode0);
      assertEquals((-1), phylonodePub0.getPhylonodePubId());
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      PhylonodePub phylonodePub0 = new PhylonodePub();
      int int0 = phylonodePub0.getPhylonodePubId();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      PhylonodePub phylonodePub0 = new PhylonodePub();
      Pub pub0 = phylonodePub0.getPub();
      assertNull(pub0);
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      PhylonodePub phylonodePub0 = new PhylonodePub();
      Phylonode phylonode0 = phylonodePub0.getPhylonode();
      assertNull(phylonode0);
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      PhylonodePub phylonodePub0 = new PhylonodePub();
      phylonodePub0.setPub((Pub) null);
      assertEquals(0, phylonodePub0.getPhylonodePubId());
  }
}
