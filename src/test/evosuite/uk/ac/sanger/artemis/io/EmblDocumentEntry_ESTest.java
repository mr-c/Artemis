/*
 * This file was automatically generated by EvoSuite
 * Thu Sep 20 13:29:58 GMT 2018
 */

package uk.ac.sanger.artemis.io;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.awt.HeadlessException;
import java.io.CharArrayWriter;
import java.io.FileNotFoundException;
import java.io.PipedReader;
import java.io.Writer;
import javax.swing.table.DefaultTableModel;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.System;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.mock.java.io.MockFile;
import org.junit.runner.RunWith;
import uk.ac.sanger.artemis.FeatureKeyQualifierPredicate;
import uk.ac.sanger.artemis.FilteredEntryGroup;
import uk.ac.sanger.artemis.SimpleEntryGroup;
import uk.ac.sanger.artemis.components.LogReadListener;
import uk.ac.sanger.artemis.io.BlastEntryInformation;
import uk.ac.sanger.artemis.io.EmblDocumentEntry;
import uk.ac.sanger.artemis.io.Entry;
import uk.ac.sanger.artemis.io.EntryInformation;
import uk.ac.sanger.artemis.io.GenbankDocumentEntry;
import uk.ac.sanger.artemis.io.Key;
import uk.ac.sanger.artemis.io.KeyVector;
import uk.ac.sanger.artemis.io.PublicDBDocumentEntry;
import uk.ac.sanger.artemis.io.QualifierInfo;
import uk.ac.sanger.artemis.io.QualifierInfoHash;
import uk.ac.sanger.artemis.io.ReadListener;
import uk.ac.sanger.artemis.io.SimpleEntryInformation;
import uk.ac.sanger.artemis.util.Document;
import uk.ac.sanger.artemis.util.LinePushBackReader;
import uk.ac.sanger.artemis.util.TextDocument;
import uk.ac.sanger.artemis.util.ZipFileDocument;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, useJEE = true) 
public class EmblDocumentEntry_ESTest extends EmblDocumentEntry_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      EntryInformation entryInformation0 = mock(EntryInformation.class, new ViolatedAssumptionAnswer());
      doReturn((QualifierInfoHash) null).when(entryInformation0).getAllQualifierInfo();
      doReturn((KeyVector) null).when(entryInformation0).getUserKeys();
      doReturn((KeyVector) null).when(entryInformation0).getValidKeys();
      doReturn(false).when(entryInformation0).useEMBLFormat();
      EmblDocumentEntry emblDocumentEntry0 = new EmblDocumentEntry(entryInformation0);
      EmblDocumentEntry emblDocumentEntry1 = new EmblDocumentEntry(emblDocumentEntry0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Key key0 = new Key("evGe[V");
      KeyVector keyVector0 = new KeyVector(key0);
      KeyVector keyVector1 = keyVector0.copy();
      EntryInformation entryInformation0 = mock(EntryInformation.class, new ViolatedAssumptionAnswer());
      doReturn((QualifierInfoHash) null).when(entryInformation0).getAllQualifierInfo();
      doReturn(keyVector1, keyVector0).when(entryInformation0).getUserKeys();
      doReturn(keyVector1, keyVector0).when(entryInformation0).getValidKeys();
      doReturn(true).when(entryInformation0).useEMBLFormat();
      LinePushBackReader linePushBackReader0 = mock(LinePushBackReader.class, new ViolatedAssumptionAnswer());
      doReturn(":g", (String) null).when(linePushBackReader0).readLine();
      CharArrayWriter charArrayWriter0 = new CharArrayWriter(398);
      Document document0 = mock(Document.class, new ViolatedAssumptionAnswer());
      doReturn(linePushBackReader0).when(document0).getLinePushBackReader();
      ReadListener readListener0 = mock(ReadListener.class, new ViolatedAssumptionAnswer());
      EmblDocumentEntry emblDocumentEntry0 = null;
      try {
        emblDocumentEntry0 = new EmblDocumentEntry(entryInformation0, document0, readListener0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sanger.artemis.io.StreamSequenceFactory", e);
      }
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      BlastEntryInformation blastEntryInformation0 = new BlastEntryInformation();
      blastEntryInformation0.getAllQualifierInfo();
      KeyVector keyVector0 = new KeyVector();
      EntryInformation entryInformation0 = mock(EntryInformation.class, new ViolatedAssumptionAnswer());
      doReturn((QualifierInfoHash) null, (QualifierInfoHash) null).when(entryInformation0).getAllQualifierInfo();
      doReturn((KeyVector) null, (KeyVector) null).when(entryInformation0).getUserKeys();
      doReturn((KeyVector) null, (KeyVector) null).when(entryInformation0).getValidKeys();
      doReturn(false, false).when(entryInformation0).useEMBLFormat();
      EmblDocumentEntry emblDocumentEntry0 = new EmblDocumentEntry(entryInformation0);
      Writer writer0 = mock(Writer.class, new ViolatedAssumptionAnswer());
      emblDocumentEntry0.writeToStream(writer0);
      EmblDocumentEntry emblDocumentEntry1 = new EmblDocumentEntry(entryInformation0, emblDocumentEntry0, true);
      EmblDocumentEntry emblDocumentEntry2 = new EmblDocumentEntry(emblDocumentEntry1);
      EntryInformation entryInformation1 = mock(EntryInformation.class, new ViolatedAssumptionAnswer());
      doReturn((QualifierInfoHash) null).when(entryInformation1).getAllQualifierInfo();
      doReturn(keyVector0, (KeyVector) null).when(entryInformation1).getUserKeys();
      doReturn(keyVector0, (KeyVector) null).when(entryInformation1).getValidKeys();
      EmblDocumentEntry emblDocumentEntry3 = null;
      try {
        emblDocumentEntry3 = new EmblDocumentEntry(entryInformation1, emblDocumentEntry2, true);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sanger.artemis.io.SimpleEntryInformation", e);
      }
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      BlastEntryInformation blastEntryInformation0 = new BlastEntryInformation();
      MockFile mockFile0 = new MockFile("");
      ZipFileDocument zipFileDocument0 = new ZipFileDocument(mockFile0, "'R1V.JhGT|");
      LogReadListener logReadListener0 = new LogReadListener("'R1V.JhGT|");
      EmblDocumentEntry emblDocumentEntry0 = null;
      try {
        emblDocumentEntry0 = new EmblDocumentEntry(blastEntryInformation0, zipFileDocument0, logReadListener0);
        fail("Expecting exception: FileNotFoundException");
      
      } catch(Throwable e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.evosuite.runtime.mock.java.io.MockFileInputStream", e);
      }
  }
  
  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      SimpleEntryGroup simpleEntryGroup0 = new SimpleEntryGroup();
      uk.ac.sanger.artemis.FeatureVector featureVector0 = new uk.ac.sanger.artemis.FeatureVector();
      FilteredEntryGroup filteredEntryGroup0 = new FilteredEntryGroup(simpleEntryGroup0, featureVector0, "``\"DTaz");
      uk.ac.sanger.artemis.Entry entry0 = filteredEntryGroup0.createEntry();
      EntryInformation entryInformation0 = entry0.getEntryInformation();
      GenbankDocumentEntry genbankDocumentEntry0 = new GenbankDocumentEntry(entryInformation0);
      EmblDocumentEntry emblDocumentEntry0 = new EmblDocumentEntry(entryInformation0, genbankDocumentEntry0, true);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      EmblDocumentEntry emblDocumentEntry0 = null;
      try {
        emblDocumentEntry0 = new EmblDocumentEntry((EntryInformation) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sanger.artemis.io.SimpleEntryInformation", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      SimpleEntryGroup simpleEntryGroup0 = new SimpleEntryGroup();
      Key key0 = new Key("IDuk.ac.sanger.artemis.io.EmblMisc@0000000009");
      FeatureKeyQualifierPredicate featureKeyQualifierPredicate0 = new FeatureKeyQualifierPredicate(key0, "N");
      FilteredEntryGroup filteredEntryGroup0 = new FilteredEntryGroup(simpleEntryGroup0, featureKeyQualifierPredicate0, "N");
      uk.ac.sanger.artemis.Entry entry0 = filteredEntryGroup0.createEntry("IDuk.ac.sanger.artemis.io.GFFMisc@0000000151");
      Entry entry1 = entry0.getEMBLEntry();
      EmblDocumentEntry emblDocumentEntry0 = new EmblDocumentEntry(entry1);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      EntryInformation entryInformation0 = mock(EntryInformation.class, new ViolatedAssumptionAnswer());
      doReturn((QualifierInfoHash) null).when(entryInformation0).getAllQualifierInfo();
      doReturn((KeyVector) null).when(entryInformation0).getUserKeys();
      doReturn((KeyVector) null).when(entryInformation0).getValidKeys();
      doReturn(false).when(entryInformation0).useEMBLFormat();
      EmblDocumentEntry emblDocumentEntry0 = new EmblDocumentEntry(entryInformation0);
      emblDocumentEntry0.dispose();
      EmblDocumentEntry emblDocumentEntry1 = null;
      try {
        emblDocumentEntry1 = new EmblDocumentEntry(emblDocumentEntry0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sanger.artemis.io.SimpleDocumentEntry", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      BlastEntryInformation blastEntryInformation0 = new BlastEntryInformation();
      blastEntryInformation0.getAllQualifierInfo();
      KeyVector keyVector0 = new KeyVector();
      Object[] objectArray0 = new Object[2];
      objectArray0[0] = (Object) keyVector0;
      objectArray0[1] = (Object) keyVector0;
      DefaultTableModel defaultTableModel0 = new DefaultTableModel(objectArray0, 1);
      keyVector0.add((Object) defaultTableModel0);
      KeyVector keyVector1 = keyVector0.copy();
      EntryInformation entryInformation0 = mock(EntryInformation.class, new ViolatedAssumptionAnswer());
      doReturn((QualifierInfoHash) null, (QualifierInfoHash) null).when(entryInformation0).getAllQualifierInfo();
      doReturn(keyVector1, keyVector1, (KeyVector) null).when(entryInformation0).getUserKeys();
      doReturn(keyVector1, keyVector0, (KeyVector) null).when(entryInformation0).getValidKeys();
      doReturn(false, false).when(entryInformation0).useEMBLFormat();
      EmblDocumentEntry emblDocumentEntry0 = new EmblDocumentEntry(entryInformation0);
      PublicDBDocumentEntry.IGNORE_OBSOLETE_FEATURES = true;
      EmblDocumentEntry emblDocumentEntry1 = new EmblDocumentEntry(entryInformation0, emblDocumentEntry0, true);
      EntryInformation entryInformation1 = mock(EntryInformation.class, new ViolatedAssumptionAnswer());
      doReturn((QualifierInfoHash) null).when(entryInformation1).getAllQualifierInfo();
      doReturn(keyVector1, (KeyVector) null).when(entryInformation1).getUserKeys();
      doReturn(keyVector1, (KeyVector) null).when(entryInformation1).getValidKeys();
      EmblDocumentEntry emblDocumentEntry2 = null;
      try {
        emblDocumentEntry2 = new EmblDocumentEntry(entryInformation1, emblDocumentEntry1, true);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sanger.artemis.io.SimpleEntryInformation", e);
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Key key0 = new Key("evGe[V");
      KeyVector keyVector0 = new KeyVector(key0);
      KeyVector keyVector1 = keyVector0.copy();
      EntryInformation entryInformation0 = mock(EntryInformation.class, new ViolatedAssumptionAnswer());
      doReturn((QualifierInfoHash) null).when(entryInformation0).getAllQualifierInfo();
      doReturn(keyVector1, (KeyVector) null).when(entryInformation0).getUserKeys();
      doReturn(keyVector1, (KeyVector) null).when(entryInformation0).getValidKeys();
      LinePushBackReader linePushBackReader0 = mock(LinePushBackReader.class, new ViolatedAssumptionAnswer());
      Document document0 = mock(Document.class, new ViolatedAssumptionAnswer());
      ReadListener readListener0 = mock(ReadListener.class, new ViolatedAssumptionAnswer());
      EmblDocumentEntry emblDocumentEntry0 = null;
      try {
        emblDocumentEntry0 = new EmblDocumentEntry(entryInformation0, document0, readListener0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sanger.artemis.io.SimpleEntryInformation", e);
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      BlastEntryInformation blastEntryInformation0 = new BlastEntryInformation();
      EmblDocumentEntry emblDocumentEntry0 = new EmblDocumentEntry(blastEntryInformation0);
      emblDocumentEntry0.setHeaderText("Mk");
      EmblDocumentEntry emblDocumentEntry1 = new EmblDocumentEntry(blastEntryInformation0, emblDocumentEntry0, true);
      assertTrue(PublicDBDocumentEntry.IGNORE_OBSOLETE_FEATURES);
  }
}
