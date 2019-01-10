/*
 * This file was automatically generated by EvoSuite
 * Fri Jun 08 20:18:43 GMT 2018
 */

package uk.ac.sanger.artemis.util;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.zip.ZipException;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.io.MockFile;
import org.evosuite.runtime.mock.java.net.MockURI;
import org.evosuite.runtime.testdata.EvoSuiteFile;
import org.evosuite.runtime.testdata.FileSystemHandling;
import org.junit.runner.RunWith;
import uk.ac.sanger.artemis.util.Document;
import uk.ac.sanger.artemis.util.FileDocument;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false, useJEE = true) 
public class FileDocument_ESTest extends FileDocument_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      MockFile mockFile0 = new MockFile("Insensitive");
      FileSystemHandling.shouldAllThrowIOExceptions();
      FileDocument fileDocument0 = new FileDocument(mockFile0);
      Document document0 = fileDocument0.getParent();
      assertNull(document0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      MockFile mockFile0 = new MockFile("", "");
      FileDocument fileDocument0 = new FileDocument(mockFile0);
      String string0 = fileDocument0.getName();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      MockFile mockFile0 = new MockFile("CZhO=Nd~4Gdp;w><");
      FileDocument fileDocument0 = new FileDocument(mockFile0);
      fileDocument0.setLocation((Object) null);
      File file0 = fileDocument0.getFile();
      assertNull(file0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      File file0 = MockFile.createTempFile("/^',x}!&+T", ".gz");
      FileDocument fileDocument0 = new FileDocument(file0);
      fileDocument0.getOutputStream();
      fileDocument0.getFile();
      assertEquals(10L, file0.length());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      MockFile mockFile0 = new MockFile(".gz");
      FileDocument fileDocument0 = new FileDocument(mockFile0);
      File file0 = fileDocument0.getFile();
      assertFalse(file0.exists());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      MockFile mockFile0 = new MockFile("", "");
      FileDocument fileDocument0 = new FileDocument(mockFile0);
      File file0 = fileDocument0.getFile();
      assertNull(file0.getParent());
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      MockFile mockFile0 = new MockFile("Unknown count type: ");
      FileDocument fileDocument0 = new FileDocument(mockFile0);
      fileDocument0.setLocation((Object) null);
      // Undeclared exception!
      try { 
        fileDocument0.writable();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sanger.artemis.util.FileDocument", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      MockFile mockFile0 = new MockFile(" values but the header says this should have ", " values but the header says this should have ");
      FileDocument fileDocument0 = new FileDocument(mockFile0);
      Object object0 = new Object();
      fileDocument0.setLocation(object0);
      // Undeclared exception!
      try { 
        fileDocument0.writable();
        fail("Expecting exception: ClassCastException");
      
      } catch(ClassCastException e) {
         //
         // java.lang.Object cannot be cast to java.io.File
         //
         verifyException("uk.ac.sanger.artemis.util.FileDocument", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      MockFile mockFile0 = new MockFile("e: ");
      FileDocument fileDocument0 = new FileDocument(mockFile0);
      fileDocument0.setLocation((Object) null);
      // Undeclared exception!
      try { 
        fileDocument0.readable();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sanger.artemis.util.FileDocument", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      MockFile mockFile0 = new MockFile("", "");
      FileDocument fileDocument0 = new FileDocument(mockFile0);
      fileDocument0.setLocation("");
      // Undeclared exception!
      try { 
        fileDocument0.readable();
        fail("Expecting exception: ClassCastException");
      
      } catch(ClassCastException e) {
         //
         // java.lang.String cannot be cast to java.io.File
         //
         verifyException("uk.ac.sanger.artemis.util.FileDocument", e);
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      MockFile mockFile0 = new MockFile("R<", "H3EC[om~9");
      FileDocument fileDocument0 = new FileDocument(mockFile0);
      Object object0 = new Object();
      fileDocument0.setLocation(object0);
      // Undeclared exception!
      try { 
        fileDocument0.getParent();
        fail("Expecting exception: ClassCastException");
      
      } catch(ClassCastException e) {
         //
         // java.lang.Object cannot be cast to java.io.File
         //
         verifyException("uk.ac.sanger.artemis.util.FileDocument", e);
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      MockFile mockFile0 = new MockFile("CZhO=Nd~4Gdp;w><");
      FileDocument fileDocument0 = new FileDocument(mockFile0);
      fileDocument0.setLocation((Object) null);
      // Undeclared exception!
      try { 
        fileDocument0.getOutputStream();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.io.File", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      MockFile mockFile0 = new MockFile((File) null, "");
      FileDocument fileDocument0 = new FileDocument(mockFile0);
      fileDocument0.setLocation("");
      // Undeclared exception!
      try { 
        fileDocument0.getOutputStream();
        fail("Expecting exception: ClassCastException");
      
      } catch(ClassCastException e) {
         //
         // java.lang.String cannot be cast to java.io.File
         //
         verifyException("uk.ac.sanger.artemis.util.FileDocument", e);
      }
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      URI uRI0 = MockURI.aFileURI;
      MockFile mockFile0 = new MockFile(uRI0);
      MockFile mockFile1 = new MockFile(mockFile0, "&VGv,0&VGv,.gz");
      FileSystemHandling.shouldAllThrowIOExceptions();
      FileDocument fileDocument0 = new FileDocument(mockFile1);
      try { 
        fileDocument0.getOutputStream();
        fail("Expecting exception: IOException");
      
      } catch(IOException e) {
         //
         // Simulated IOException
         //
         verifyException("org.evosuite.runtime.vfs.VirtualFileSystem", e);
      }
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      MockFile mockFile0 = new MockFile("&xR=7kO]F.", "&xR=7kO]F.");
      FileDocument fileDocument0 = new FileDocument(mockFile0);
      mockFile0.mkdirs();
      try { 
        fileDocument0.getOutputStream();
        fail("Expecting exception: FileNotFoundException");
      
      } catch(FileNotFoundException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.evosuite.runtime.mock.java.io.MockFileOutputStream", e);
      }
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      File file0 = MockFile.createTempFile("original name cannot be null", "P8", (File) null);
      FileDocument fileDocument0 = new FileDocument(file0);
      fileDocument0.setLocation((Object) null);
      // Undeclared exception!
      try { 
        fileDocument0.getName();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("uk.ac.sanger.artemis.util.FileDocument", e);
      }
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      File file0 = MockFile.createTempFile("1.5.", "1.5.");
      FileDocument fileDocument0 = new FileDocument(file0);
      fileDocument0.setLocation("1.5.");
      // Undeclared exception!
      try { 
        fileDocument0.getName();
        fail("Expecting exception: ClassCastException");
      
      } catch(ClassCastException e) {
         //
         // java.lang.String cannot be cast to java.io.File
         //
         verifyException("uk.ac.sanger.artemis.util.FileDocument", e);
      }
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      File file0 = MockFile.createTempFile(":V.gz", ":V.gz");
      FileDocument fileDocument0 = new FileDocument(file0);
      EvoSuiteFile evoSuiteFile0 = new EvoSuiteFile("/var/folders/r3/l648tx8s7hn8ppds6z2bk5cc000h2n/T/:V.gz0:V.gz");
      FileSystemHandling.appendStringToFile(evoSuiteFile0, ">lQ/PyH");
      try { 
        fileDocument0.getInputStream();
        fail("Expecting exception: ZipException");
      
      } catch(ZipException e) {
         //
         // Not in GZIP format
         //
         verifyException("java.util.zip.GZIPInputStream", e);
      }
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      URI uRI0 = MockURI.aFileURI;
      MockFile mockFile0 = new MockFile(uRI0);
      FileDocument fileDocument0 = new FileDocument(mockFile0);
      fileDocument0.setLocation((Object) null);
      // Undeclared exception!
      try { 
        fileDocument0.getInputStream();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.evosuite.runtime.mock.java.io.MockFileInputStream", e);
      }
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      MockFile mockFile0 = new MockFile("");
      FileDocument fileDocument0 = new FileDocument(mockFile0);
      Object object0 = new Object();
      fileDocument0.setLocation(object0);
      // Undeclared exception!
      try { 
        fileDocument0.getInputStream();
        fail("Expecting exception: ClassCastException");
      
      } catch(ClassCastException e) {
         //
         // java.lang.Object cannot be cast to java.io.File
         //
         verifyException("uk.ac.sanger.artemis.util.FileDocument", e);
      }
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      File file0 = MockFile.createTempFile("/^',x}!&+T", ".gz");
      FileDocument fileDocument0 = new FileDocument(file0);
      FileSystemHandling.shouldAllThrowIOExceptions();
      try { 
        fileDocument0.getInputStream();
        fail("Expecting exception: IOException");
      
      } catch(IOException e) {
         //
         // Simulated IOException
         //
         verifyException("org.evosuite.runtime.vfs.VirtualFileSystem", e);
      }
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      MockFile mockFile0 = new MockFile("", "Invalid IOCase name: ");
      FileDocument fileDocument0 = new FileDocument(mockFile0);
      try { 
        fileDocument0.getInputStream();
        fail("Expecting exception: FileNotFoundException");
      
      } catch(FileNotFoundException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.evosuite.runtime.mock.java.io.MockFileInputStream", e);
      }
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      File file0 = MockFile.createTempFile("java.version", "");
      FileDocument fileDocument0 = new FileDocument(file0);
      Object object0 = new Object();
      fileDocument0.setLocation(object0);
      // Undeclared exception!
      try { 
        fileDocument0.getFile();
        fail("Expecting exception: ClassCastException");
      
      } catch(ClassCastException e) {
         //
         // java.lang.Object cannot be cast to java.io.File
         //
         verifyException("uk.ac.sanger.artemis.util.FileDocument", e);
      }
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      File file0 = MockFile.createTempFile(".gz", ".gz");
      FileDocument fileDocument0 = new FileDocument(file0);
      // Undeclared exception!
      try { 
        fileDocument0.append((String) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.evosuite.runtime.mock.java.io.MockFile", e);
      }
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      MockFile mockFile0 = new MockFile("", "");
      FileDocument fileDocument0 = new FileDocument(mockFile0);
      fileDocument0.setLocation("");
      // Undeclared exception!
      try { 
        fileDocument0.append("");
        fail("Expecting exception: ClassCastException");
      
      } catch(ClassCastException e) {
         //
         // java.lang.String cannot be cast to java.io.File
         //
         verifyException("uk.ac.sanger.artemis.util.FileDocument", e);
      }
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      FileDocument fileDocument0 = null;
      try {
        fileDocument0 = new FileDocument((File) null);
        fail("Expecting exception: Error");
      
      } catch(Error e) {
         //
         // internal error - created a null Document
         //
         verifyException("uk.ac.sanger.artemis.util.Document", e);
      }
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      MockFile mockFile0 = new MockFile("R<", "H3EC[om~9");
      FileDocument fileDocument0 = new FileDocument(mockFile0);
      fileDocument0.getOutputStream();
      assertEquals(0L, mockFile0.length());
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      File file0 = MockFile.createTempFile("/^',x}!&+T", "`31Rr59NKn)V~Z@4n.gz");
      FileDocument fileDocument0 = new FileDocument(file0);
      try { 
        fileDocument0.getInputStream();
        fail("Expecting exception: EOFException");
      
      } catch(EOFException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.zip.GZIPInputStream", e);
      }
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      MockFile mockFile0 = new MockFile("R<", "H3EC[om~9");
      File file0 = MockFile.createTempFile("H3EC[om~9", "R<", (File) mockFile0);
      FileDocument fileDocument0 = new FileDocument(file0);
      InputStream inputStream0 = fileDocument0.getInputStream();
      assertNotNull(inputStream0);
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      MockFile mockFile0 = new MockFile("&xR=7kO]F.", "&xR=7kO]F.");
      FileDocument fileDocument0 = new FileDocument(mockFile0);
      mockFile0.mkdirs();
      mockFile0.setWritable(false, false);
      boolean boolean0 = fileDocument0.writable();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      File file0 = MockFile.createTempFile("/^',x}!&+T", "`31Rr59NKn)V~Z@4n.gz");
      FileDocument fileDocument0 = new FileDocument(file0);
      boolean boolean0 = fileDocument0.writable();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      MockFile mockFile0 = new MockFile(" values but the header says this should have ", " values but the header says this should have ");
      FileDocument fileDocument0 = new FileDocument(mockFile0);
      boolean boolean0 = fileDocument0.writable();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      MockFile mockFile0 = new MockFile("=ZQE,", "=ZQE,");
      File file0 = MockFile.createTempFile("=ZQE,", "8Y", (File) mockFile0);
      FileDocument fileDocument0 = new FileDocument(file0);
      assertTrue(fileDocument0.readable());
      
      file0.setReadable(false, true);
      boolean boolean0 = fileDocument0.readable();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      File file0 = MockFile.createTempFile("/^',x}!&+T", ".gz");
      FileDocument fileDocument0 = new FileDocument(file0);
      boolean boolean0 = fileDocument0.readable();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      File file0 = MockFile.createTempFile("/^',x}!&+T", "`31Rr59NKn)V~Z@4n.gz");
      FileDocument fileDocument0 = new FileDocument(file0);
      Document document0 = fileDocument0.getParent();
      boolean boolean0 = document0.readable();
      assertTrue(fileDocument0.readable());
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      MockFile mockFile0 = new MockFile("&xR=7kO]F.", "&xR=7kO]F.");
      FileDocument fileDocument0 = new FileDocument(mockFile0);
      String string0 = fileDocument0.getName();
      assertEquals("&xR=7kO]F.", string0);
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      File file0 = MockFile.createTempFile("}VZVN\"v#?;^C", (String) null, (File) null);
      FileDocument fileDocument0 = new FileDocument(file0);
      Document document0 = fileDocument0.append("7ayOE`Ti3Y5U)?]&0");
      assertNotSame(fileDocument0, document0);
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      MockFile mockFile0 = new MockFile("", "");
      FileDocument fileDocument0 = new FileDocument(mockFile0);
      // Undeclared exception!
      try { 
        fileDocument0.getParent();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.io.File", e);
      }
  }
}
