/*
 * This file was automatically generated by EvoSuite
 * Wed Sep 19 20:36:43 GMT 2018
 */

package uk.ac.sanger.artemis.io;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.awt.HeadlessException;
import java.io.StringReader;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.System;
import org.evosuite.runtime.testdata.EvoSuiteFile;
import org.evosuite.runtime.testdata.FileSystemHandling;
import org.junit.runner.RunWith;
import uk.ac.sanger.artemis.EntryGroup;
import uk.ac.sanger.artemis.FilteredEntryGroup;
import uk.ac.sanger.artemis.SimpleEntryGroup;
import uk.ac.sanger.artemis.components.FileViewer;
import uk.ac.sanger.artemis.io.BlastEntryInformation;
import uk.ac.sanger.artemis.io.BlastStreamFeature;
import uk.ac.sanger.artemis.io.ChadoCanonicalGene;
import uk.ac.sanger.artemis.io.DatabaseInferredFeature;
import uk.ac.sanger.artemis.io.DatabaseStreamFeature;
import uk.ac.sanger.artemis.io.EmblStreamFeature;
import uk.ac.sanger.artemis.io.EntryInformation;
import uk.ac.sanger.artemis.io.Feature;
import uk.ac.sanger.artemis.io.GFFStreamFeature;
import uk.ac.sanger.artemis.io.GenbankStreamFeature;
import uk.ac.sanger.artemis.io.Key;
import uk.ac.sanger.artemis.io.Location;
import uk.ac.sanger.artemis.io.MSPcrunchEntryInformation;
import uk.ac.sanger.artemis.io.PublicDBStreamFeature;
import uk.ac.sanger.artemis.io.QualifierVector;
import uk.ac.sanger.artemis.io.Range;
import uk.ac.sanger.artemis.io.RangeVector;
import uk.ac.sanger.artemis.io.ValidateFeature;
import uk.ac.sanger.artemis.sequence.Bases;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false, useJEE = true) 
public class ValidateFeature_ESTest extends ValidateFeature_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      // Undeclared exception!
      try { 
        ValidateFeature.validateGO((QualifierVector) null, (EntryInformation) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sanger.artemis.io.ValidateFeature", e);
      }
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      // Undeclared exception!
      try { 
        ValidateFeature.testHeader((String) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.io.StringReader", e);
      }
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      // Undeclared exception!
      try { 
        ValidateFeature.isStrandOK((GFFStreamFeature) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sanger.artemis.io.ValidateFeature", e);
      }
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      // Undeclared exception!
      try { 
        ValidateFeature.isPartialConsistent((GFFStreamFeature) null, "");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sanger.artemis.io.ValidateFeature", e);
      }
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      // Undeclared exception!
      try { 
        ValidateFeature.isPartOfGene((GFFStreamFeature) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sanger.artemis.io.ValidateFeature", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      SimpleEntryGroup simpleEntryGroup0 = new SimpleEntryGroup();
      ValidateFeature validateFeature0 = new ValidateFeature(simpleEntryGroup0);
      // Undeclared exception!
      try { 
        validateFeature0.isInternalStops((Feature) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sanger.artemis.io.ValidateFeature", e);
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      // Undeclared exception!
      try { 
        ValidateFeature.isIdPrefixConsistent((GFFStreamFeature) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sanger.artemis.io.ValidateFeature", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      // Undeclared exception!
      try { 
        ValidateFeature.isCompleteGeneModelOK((GFFStreamFeature) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sanger.artemis.io.ValidateFeature", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      // Undeclared exception!
      try { 
        ValidateFeature.isCDSPhaseOK((GFFStreamFeature) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sanger.artemis.io.ValidateFeature", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      // Undeclared exception!
      try { 
        ValidateFeature.isBoundaryOK((GFFStreamFeature) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sanger.artemis.io.ValidateFeature", e);
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      // Undeclared exception!
      try { 
        ValidateFeature.isAttributesOK((GFFStreamFeature) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sanger.artemis.io.ValidateFeature", e);
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      ValidateFeature validateFeature0 = new ValidateFeature((EntryGroup) null);
      // Undeclared exception!
      try { 
        validateFeature0.hasValidStop((Feature) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sanger.artemis.io.ValidateFeature", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      SimpleEntryGroup simpleEntryGroup0 = new SimpleEntryGroup();
      uk.ac.sanger.artemis.FeatureVector featureVector0 = new uk.ac.sanger.artemis.FeatureVector();
      FilteredEntryGroup filteredEntryGroup0 = new FilteredEntryGroup(simpleEntryGroup0, featureVector0, "");
      ValidateFeature validateFeature0 = new ValidateFeature(filteredEntryGroup0);
      // Undeclared exception!
      try { 
        validateFeature0.featureValidate((Feature) null, (FileViewer) null, true);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sanger.artemis.io.ValidateFeature", e);
      }
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      String[] stringArray0 = new String[1];
      EvoSuiteFile evoSuiteFile0 = new EvoSuiteFile("+c");
      FileSystemHandling.appendStringToFile(evoSuiteFile0, "_Heb");
      stringArray0[0] = "+c";
      // Undeclared exception!
      try { 
        ValidateFeature.main(stringArray0);
        fail("Expecting exception: HeadlessException");
      
      } catch(HeadlessException e) {
         
      }
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      String[] stringArray0 = new String[3];
      stringArray0[0] = "";
      stringArray0[1] = "e(#Z0f11t2w";
      stringArray0[2] = "";
      // Undeclared exception!
      try { 
        ValidateFeature.main(stringArray0);
        fail("Expecting exception: HeadlessException");
      
      } catch(HeadlessException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.awt.GraphicsEnvironment", e);
      }
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      String[] stringArray0 = new String[2];
      stringArray0[0] = "-+";
      stringArray0[1] = "EXP";
      ValidateFeature.main(stringArray0);
      assertEquals(2, stringArray0.length);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      String[] stringArray0 = new String[0];
      // Undeclared exception!
      try { 
        ValidateFeature.main(stringArray0);
        fail("Expecting exception: System.SystemExitException");
      
      } catch(System.SystemExitException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.evosuite.runtime.System", e);
      }
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      String[] stringArray0 = new String[1];
      // Undeclared exception!
      try { 
        ValidateFeature.main(stringArray0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
      }
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      // Undeclared exception!
      try { 
        ValidateFeature.main((String[]) null);
        fail("Expecting exception: System.SystemExitException");
      
      } catch(System.SystemExitException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.evosuite.runtime.System", e);
      }
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      Key key0 = Key.CDS;
      Range range0 = new Range(1308);
      RangeVector rangeVector0 = new RangeVector(range0);
      Location location0 = new Location(rangeVector0, false);
      QualifierVector qualifierVector0 = new QualifierVector();
      GFFStreamFeature gFFStreamFeature0 = new GFFStreamFeature(key0, location0, qualifierVector0);
      ValidateFeature.isPartOfGene(gFFStreamFeature0);
      boolean boolean0 = ValidateFeature.isPartOfGene(gFFStreamFeature0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      BlastEntryInformation blastEntryInformation0 = new BlastEntryInformation();
      Key key0 = blastEntryInformation0.getDefaultKey();
      Range range0 = new Range((-1520), 0);
      RangeVector rangeVector0 = new RangeVector(range0);
      Location location0 = new Location(rangeVector0, true);
      QualifierVector qualifierVector0 = new QualifierVector();
      ChadoCanonicalGene chadoCanonicalGene0 = new ChadoCanonicalGene();
      DatabaseInferredFeature databaseInferredFeature0 = new DatabaseInferredFeature(key0, location0, qualifierVector0, chadoCanonicalGene0);
      boolean boolean0 = ValidateFeature.isPartOfGene(databaseInferredFeature0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      BlastEntryInformation blastEntryInformation0 = new BlastEntryInformation();
      Key key0 = blastEntryInformation0.getDefaultKey();
      Range range0 = new Range((-1520), 0);
      RangeVector rangeVector0 = new RangeVector(range0);
      Location location0 = new Location(rangeVector0, true);
      QualifierVector qualifierVector0 = new QualifierVector();
      ChadoCanonicalGene chadoCanonicalGene0 = new ChadoCanonicalGene();
      DatabaseInferredFeature databaseInferredFeature0 = new DatabaseInferredFeature(key0, location0, qualifierVector0, chadoCanonicalGene0);
      ValidateFeature validateFeature0 = new ValidateFeature((EntryGroup) null);
      validateFeature0.hasValidStop(databaseInferredFeature0);
      boolean boolean0 = validateFeature0.hasValidStop(databaseInferredFeature0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      BlastEntryInformation blastEntryInformation0 = new BlastEntryInformation();
      Key key0 = blastEntryInformation0.getDefaultKey();
      Range range0 = new Range((-1520), 0);
      RangeVector rangeVector0 = new RangeVector(range0);
      Location location0 = new Location(rangeVector0, true);
      QualifierVector qualifierVector0 = new QualifierVector();
      ChadoCanonicalGene chadoCanonicalGene0 = new ChadoCanonicalGene();
      DatabaseInferredFeature databaseInferredFeature0 = new DatabaseInferredFeature(key0, location0, qualifierVector0, chadoCanonicalGene0);
      SimpleEntryGroup simpleEntryGroup0 = new SimpleEntryGroup();
      uk.ac.sanger.artemis.Entry entry0 = uk.ac.sanger.artemis.Entry.newEntry((Bases) null);
      uk.ac.sanger.artemis.FeatureVector featureVector0 = entry0.checkFeatureStartCodons();
      uk.ac.sanger.artemis.Feature feature0 = new uk.ac.sanger.artemis.Feature(databaseInferredFeature0);
      FilteredEntryGroup filteredEntryGroup0 = new FilteredEntryGroup(simpleEntryGroup0, featureVector0, "o-#d;_u-hY;3to(");
      ValidateFeature validateFeature0 = new ValidateFeature(filteredEntryGroup0);
      boolean boolean0 = validateFeature0.hasValidStop(databaseInferredFeature0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      BlastEntryInformation blastEntryInformation0 = new BlastEntryInformation();
      Key key0 = blastEntryInformation0.getDefaultKey();
      Range range0 = new Range((-1520), 0);
      RangeVector rangeVector0 = new RangeVector(range0);
      Location location0 = new Location(rangeVector0, true);
      QualifierVector qualifierVector0 = new QualifierVector();
      ChadoCanonicalGene chadoCanonicalGene0 = new ChadoCanonicalGene();
      DatabaseInferredFeature databaseInferredFeature0 = new DatabaseInferredFeature(key0, location0, qualifierVector0, chadoCanonicalGene0);
      SimpleEntryGroup simpleEntryGroup0 = new SimpleEntryGroup();
      ValidateFeature validateFeature0 = new ValidateFeature(simpleEntryGroup0);
      boolean boolean0 = validateFeature0.isInternalStops(databaseInferredFeature0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      GenbankStreamFeature genbankStreamFeature0 = new GenbankStreamFeature();
      EmblStreamFeature emblStreamFeature0 = new EmblStreamFeature(genbankStreamFeature0);
      GFFStreamFeature gFFStreamFeature0 = new GFFStreamFeature(emblStreamFeature0);
      String string0 = ValidateFeature.isAttributesOK(gFFStreamFeature0);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      BlastEntryInformation blastEntryInformation0 = new BlastEntryInformation();
      Key key0 = blastEntryInformation0.getDefaultKey();
      Range range0 = new Range(2146, 2146);
      Location location0 = new Location(range0);
      QualifierVector qualifierVector0 = new QualifierVector();
      ChadoCanonicalGene chadoCanonicalGene0 = new ChadoCanonicalGene();
      DatabaseInferredFeature databaseInferredFeature0 = new DatabaseInferredFeature(key0, location0, qualifierVector0, chadoCanonicalGene0);
      boolean boolean0 = ValidateFeature.isCDSPhaseOK(databaseInferredFeature0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      EmblStreamFeature emblStreamFeature0 = new EmblStreamFeature();
      DatabaseStreamFeature databaseStreamFeature0 = new DatabaseStreamFeature(emblStreamFeature0);
      boolean boolean0 = ValidateFeature.isCDSPhaseOK(databaseStreamFeature0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      GenbankStreamFeature genbankStreamFeature0 = new GenbankStreamFeature();
      EmblStreamFeature emblStreamFeature0 = new EmblStreamFeature(genbankStreamFeature0);
      GFFStreamFeature gFFStreamFeature0 = new GFFStreamFeature(emblStreamFeature0, false);
      boolean boolean0 = ValidateFeature.isIdPrefixConsistent(gFFStreamFeature0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      BlastEntryInformation blastEntryInformation0 = new BlastEntryInformation();
      Key key0 = blastEntryInformation0.getDefaultKey();
      Range range0 = new Range((-1520), 0);
      RangeVector rangeVector0 = new RangeVector(range0);
      Location location0 = new Location(rangeVector0, true);
      QualifierVector qualifierVector0 = new QualifierVector();
      ChadoCanonicalGene chadoCanonicalGene0 = new ChadoCanonicalGene();
      DatabaseInferredFeature databaseInferredFeature0 = new DatabaseInferredFeature(key0, location0, qualifierVector0, chadoCanonicalGene0);
      boolean boolean0 = ValidateFeature.isIdPrefixConsistent(databaseInferredFeature0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      EmblStreamFeature emblStreamFeature0 = new EmblStreamFeature();
      DatabaseStreamFeature databaseStreamFeature0 = new DatabaseStreamFeature(emblStreamFeature0);
      boolean boolean0 = ValidateFeature.isPartialConsistent(databaseStreamFeature0, "snoRNA");
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      BlastEntryInformation blastEntryInformation0 = new BlastEntryInformation();
      Key key0 = blastEntryInformation0.getDefaultKey();
      Range range0 = new Range((-1520), 0);
      RangeVector rangeVector0 = new RangeVector(range0);
      Location location0 = new Location(rangeVector0, true);
      QualifierVector qualifierVector0 = new QualifierVector();
      ChadoCanonicalGene chadoCanonicalGene0 = new ChadoCanonicalGene();
      DatabaseInferredFeature databaseInferredFeature0 = new DatabaseInferredFeature(key0, location0, qualifierVector0, chadoCanonicalGene0);
      boolean boolean0 = ValidateFeature.isPartialConsistent(databaseInferredFeature0, "o-#d;_u-hY;3to(");
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      BlastEntryInformation blastEntryInformation0 = new BlastEntryInformation();
      Key key0 = blastEntryInformation0.getDefaultKey();
      Range range0 = new Range((-1520), 0);
      RangeVector rangeVector0 = new RangeVector(range0);
      Location location0 = new Location(rangeVector0, true);
      QualifierVector qualifierVector0 = new QualifierVector();
      ChadoCanonicalGene chadoCanonicalGene0 = new ChadoCanonicalGene();
      DatabaseInferredFeature databaseInferredFeature0 = new DatabaseInferredFeature(key0, location0, qualifierVector0, chadoCanonicalGene0);
      boolean boolean0 = ValidateFeature.isStrandOK(databaseInferredFeature0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      EmblStreamFeature emblStreamFeature0 = new EmblStreamFeature();
      DatabaseStreamFeature databaseStreamFeature0 = new DatabaseStreamFeature(emblStreamFeature0);
      boolean boolean0 = ValidateFeature.isStrandOK(databaseStreamFeature0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      BlastEntryInformation blastEntryInformation0 = new BlastEntryInformation();
      Key key0 = blastEntryInformation0.getDefaultKey();
      Range range0 = new Range((-1520), 0);
      RangeVector rangeVector0 = new RangeVector(range0);
      Location location0 = new Location(rangeVector0, true);
      QualifierVector qualifierVector0 = new QualifierVector();
      ChadoCanonicalGene chadoCanonicalGene0 = new ChadoCanonicalGene();
      DatabaseInferredFeature databaseInferredFeature0 = new DatabaseInferredFeature(key0, location0, qualifierVector0, chadoCanonicalGene0);
      int int0 = ValidateFeature.isBoundaryOK(databaseInferredFeature0);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      Key key0 = Key.CDS;
      Range range0 = new Range(1308);
      RangeVector rangeVector0 = new RangeVector(range0);
      Location location0 = new Location(rangeVector0, false);
      QualifierVector qualifierVector0 = new QualifierVector();
      GFFStreamFeature gFFStreamFeature0 = new GFFStreamFeature(key0, location0, qualifierVector0);
      int int0 = ValidateFeature.isBoundaryOK(gFFStreamFeature0);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      EmblStreamFeature emblStreamFeature0 = new EmblStreamFeature();
      DatabaseStreamFeature databaseStreamFeature0 = new DatabaseStreamFeature(emblStreamFeature0);
      int int0 = ValidateFeature.isCompleteGeneModelOK(databaseStreamFeature0);
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      BlastEntryInformation blastEntryInformation0 = new BlastEntryInformation();
      Key key0 = blastEntryInformation0.getDefaultKey();
      Range range0 = new Range((-1520), 0);
      RangeVector rangeVector0 = new RangeVector(range0);
      Location location0 = new Location(rangeVector0, true);
      QualifierVector qualifierVector0 = new QualifierVector();
      ChadoCanonicalGene chadoCanonicalGene0 = new ChadoCanonicalGene();
      DatabaseInferredFeature databaseInferredFeature0 = new DatabaseInferredFeature(key0, location0, qualifierVector0, chadoCanonicalGene0);
      int int0 = ValidateFeature.isCompleteGeneModelOK(databaseInferredFeature0);
      assertEquals(2, int0);
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      StringReader stringReader0 = new StringReader("");
      MSPcrunchEntryInformation mSPcrunchEntryInformation0 = new MSPcrunchEntryInformation();
      QualifierVector qualifierVector0 = PublicDBStreamFeature.readQualifiers(stringReader0, mSPcrunchEntryInformation0);
      String string0 = ValidateFeature.validateGO(qualifierVector0, mSPcrunchEntryInformation0);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test38()  throws Throwable  {
      SimpleEntryGroup simpleEntryGroup0 = new SimpleEntryGroup();
      uk.ac.sanger.artemis.FeatureVector featureVector0 = new uk.ac.sanger.artemis.FeatureVector();
      FilteredEntryGroup filteredEntryGroup0 = new FilteredEntryGroup(simpleEntryGroup0, featureVector0, "");
      ValidateFeature validateFeature0 = new ValidateFeature(filteredEntryGroup0);
      GenbankStreamFeature genbankStreamFeature0 = new GenbankStreamFeature();
      boolean boolean0 = validateFeature0.featureValidate(genbankStreamFeature0, (FileViewer) null, true);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test39()  throws Throwable  {
      GenbankStreamFeature genbankStreamFeature0 = new GenbankStreamFeature();
      EmblStreamFeature emblStreamFeature0 = new EmblStreamFeature(genbankStreamFeature0);
      GFFStreamFeature gFFStreamFeature0 = new GFFStreamFeature(emblStreamFeature0);
      boolean boolean0 = ValidateFeature.isGFF(gFFStreamFeature0, (EntryGroup) null);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test40()  throws Throwable  {
      SimpleEntryGroup simpleEntryGroup0 = new SimpleEntryGroup();
      Key key0 = new Key("...", true);
      QualifierVector qualifierVector0 = new QualifierVector();
      BlastStreamFeature blastStreamFeature0 = new BlastStreamFeature(key0, (Location) null, qualifierVector0);
      boolean boolean0 = ValidateFeature.isGFF(blastStreamFeature0, simpleEntryGroup0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test41()  throws Throwable  {
      boolean boolean0 = ValidateFeature.isGFF((Feature) null, (EntryGroup) null);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test42()  throws Throwable  {
      ValidateFeature.testHeader("snoRNA");
  }
}
