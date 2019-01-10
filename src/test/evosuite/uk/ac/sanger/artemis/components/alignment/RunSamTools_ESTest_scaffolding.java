/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Thu Jun 07 14:59:25 GMT 2018
 */

package uk.ac.sanger.artemis.components.alignment;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

@EvoSuiteClassExclude
public class RunSamTools_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "uk.ac.sanger.artemis.components.alignment.RunSamTools"; 
    org.evosuite.runtime.GuiSupport.initialize(); 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfThreads = 100; 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000; 
    org.evosuite.runtime.RuntimeSettings.mockSystemIn = true; 
    org.evosuite.runtime.RuntimeSettings.sandboxMode = org.evosuite.runtime.sandbox.Sandbox.SandboxMode.RECOMMENDED; 
    org.evosuite.runtime.sandbox.Sandbox.initializeSecurityManagerForSUT(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.init();
    setSystemProperties();
    initializeClasses();
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
  } 

  @AfterClass 
  public static void clearEvoSuiteFramework(){ 
    Sandbox.resetDefaultSecurityManager(); 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
  } 

  @Before 
  public void initTestCase(){ 
    threadStopper.storeCurrentThreads();
    threadStopper.startRecordingTime();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().initHandler(); 
    org.evosuite.runtime.sandbox.Sandbox.goingToExecuteSUTCode(); 
    setSystemProperties(); 
    org.evosuite.runtime.GuiSupport.setHeadless(); 
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    org.evosuite.runtime.agent.InstrumentingAgent.activate(); 
  } 

  @After 
  public void doneWithTestCase(){ 
    threadStopper.killAndJoinClientThreads();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().safeExecuteAddedHooks(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.reset(); 
    resetClasses(); 
    org.evosuite.runtime.sandbox.Sandbox.doneWithExecutingSUTCode(); 
    org.evosuite.runtime.agent.InstrumentingAgent.deactivate(); 
    org.evosuite.runtime.GuiSupport.restoreHeadlessMode(); 
  } 

  public static void setSystemProperties() {
 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
    java.lang.System.setProperty("file.encoding", "UTF-8"); 
    java.lang.System.setProperty("java.awt.headless", "true"); 
    java.lang.System.setProperty("java.io.tmpdir", "/var/folders/r3/l648tx8s7hn8ppds6z2bk5cc000h2n/T/"); 
    java.lang.System.setProperty("user.country", "GB"); 
    java.lang.System.setProperty("user.dir", "/Users/kp11/workspace/applications/Artemis-build-ci/Artemis"); 
    java.lang.System.setProperty("user.home", "/Users/kp11"); 
    java.lang.System.setProperty("user.language", "en"); 
    java.lang.System.setProperty("user.name", "kp11"); 
    java.lang.System.setProperty("user.timezone", ""); 
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(RunSamTools_ESTest_scaffolding.class.getClassLoader() ,
      "htsjdk.samtools.TextCigarCodec",
      "htsjdk.samtools.DuplicateScoringStrategy$ScoringStrategy",
      "htsjdk.samtools.SAMRecordDuplicateComparator",
      "htsjdk.samtools.Defaults",
      "uk.ac.sanger.artemis.components.alignment.RunSamTools$StderrHandler",
      "htsjdk.variant.vcf.VCFHeader",
      "htsjdk.samtools.CigarElement",
      "htsjdk.samtools.CigarOperator",
      "htsjdk.samtools.util.Log$LogLevel",
      "htsjdk.tribble.util.ParsingUtils",
      "htsjdk.variant.vcf.VCFHeaderVersion",
      "htsjdk.samtools.SAMFileHeader",
      "htsjdk.tribble.TribbleException",
      "htsjdk.samtools.SAMRecordQueryNameComparator",
      "htsjdk.samtools.SAMFileSpan",
      "htsjdk.samtools.BAMRecord",
      "uk.ac.sanger.artemis.components.alignment.RunSamTools$StdoutHandler",
      "htsjdk.samtools.util.StringUtil",
      "htsjdk.variant.vcf.VCFCompoundHeaderLine",
      "htsjdk.tribble.util.URLHelper",
      "htsjdk.samtools.util.SequenceUtil$SequenceListsDifferException",
      "htsjdk.samtools.SAMBinaryTagAndUnsignedArrayValue",
      "htsjdk.variant.vcf.VCFSimpleHeaderLine",
      "htsjdk.samtools.DuplicateScoringStrategy$Attr",
      "htsjdk.samtools.SAMException",
      "htsjdk.samtools.SAMTagUtil",
      "htsjdk.samtools.util.BinaryCodec",
      "htsjdk.samtools.TextTagCodec",
      "htsjdk.samtools.SAMBinaryTagAndValue",
      "htsjdk.samtools.SAMValidationError$Severity",
      "htsjdk.samtools.SAMRecord",
      "htsjdk.variant.variantcontext.VariantContextComparator",
      "htsjdk.samtools.SAMTextHeaderCodec$HeaderRecordType",
      "htsjdk.variant.vcf.VCFIDHeaderLine",
      "htsjdk.samtools.SAMReadGroupRecord",
      "htsjdk.samtools.SAMProgramRecord",
      "htsjdk.samtools.SAMFileHeader$PgIdGenerator",
      "htsjdk.samtools.SAMFlag",
      "htsjdk.samtools.SAMHeaderRecordComparator",
      "htsjdk.samtools.util.CoordMath",
      "htsjdk.samtools.SamFlagField$3",
      "htsjdk.variant.vcf.VCFInfoHeaderLine",
      "htsjdk.samtools.SamFlagField$4",
      "htsjdk.variant.variantcontext.VariantContext",
      "htsjdk.samtools.util.Iso8601Date",
      "htsjdk.samtools.SamFlagField$5",
      "uk.ac.sanger.artemis.components.alignment.RunSamTools",
      "htsjdk.variant.vcf.VCFHeaderLineCount",
      "htsjdk.samtools.SamFlagField$1",
      "htsjdk.tribble.util.RemoteURLHelper",
      "htsjdk.samtools.SamFlagField$2",
      "htsjdk.samtools.SamFlagField",
      "htsjdk.variant.vcf.VCFHeaderLine",
      "htsjdk.samtools.Cigar",
      "htsjdk.samtools.util.RuntimeEOFException",
      "htsjdk.samtools.AbstractSAMHeaderRecord",
      "htsjdk.samtools.util.SequenceUtil",
      "htsjdk.samtools.SAMUtils",
      "htsjdk.samtools.SAMFormatException",
      "htsjdk.tribble.TribbleException$InvalidHeader",
      "htsjdk.samtools.SAMFileHeader$SortOrder",
      "htsjdk.samtools.ValidationStringency",
      "htsjdk.samtools.util.CollectionUtil$Partitioner",
      "htsjdk.samtools.SAMTextHeaderCodec",
      "htsjdk.samtools.seekablestream.SeekablePathStream",
      "htsjdk.samtools.SAMTag",
      "htsjdk.samtools.util.Interval",
      "htsjdk.tribble.Feature",
      "htsjdk.samtools.util.RuntimeIOException",
      "htsjdk.samtools.SAMRecordFactory",
      "htsjdk.samtools.SAMTextHeaderCodec$ParsedHeaderLine",
      "htsjdk.samtools.SAMFileSource",
      "htsjdk.samtools.util.CollectionUtil",
      "htsjdk.samtools.DuplicateScoringStrategy",
      "htsjdk.tribble.TribbleException$InternalCodecException",
      "htsjdk.samtools.util.Locatable",
      "htsjdk.samtools.SAMValidationError",
      "htsjdk.variant.vcf.VCFFilterHeaderLine",
      "htsjdk.variant.vcf.VCFHeaderLineType",
      "htsjdk.samtools.util.LineReader",
      "htsjdk.samtools.util.DateParser$InvalidDateException",
      "htsjdk.samtools.SAMValidationError$Type",
      "htsjdk.variant.vcf.VCFContigHeaderLine",
      "htsjdk.samtools.SAMSequenceDictionary",
      "htsjdk.samtools.util.Murmur3",
      "htsjdk.samtools.util.BufferedLineReader",
      "htsjdk.samtools.SamReader",
      "htsjdk.samtools.seekablestream.SeekableStream",
      "htsjdk.samtools.util.Log",
      "htsjdk.samtools.SAMFileHeader$GroupOrder",
      "htsjdk.samtools.util.Iso8601Date$1",
      "htsjdk.samtools.SAMRecordCoordinateComparator",
      "htsjdk.samtools.SAMRecordComparator",
      "htsjdk.variant.vcf.VCFFormatHeaderLine",
      "htsjdk.samtools.SAMSequenceRecord"
    );
  } 

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(RunSamTools_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "uk.ac.sanger.artemis.components.alignment.RunSamTools",
      "uk.ac.sanger.artemis.components.alignment.RunSamTools$StdoutHandler",
      "uk.ac.sanger.artemis.components.alignment.RunSamTools$StderrHandler",
      "htsjdk.samtools.util.Log$LogLevel",
      "htsjdk.samtools.util.Log",
      "htsjdk.samtools.SAMSequenceDictionary",
      "htsjdk.samtools.AbstractSAMHeaderRecord",
      "htsjdk.samtools.util.CollectionUtil",
      "htsjdk.samtools.SAMFileHeader",
      "htsjdk.samtools.SAMTag",
      "htsjdk.samtools.SAMRecord",
      "htsjdk.samtools.ValidationStringency",
      "htsjdk.samtools.TextCigarCodec",
      "htsjdk.samtools.Cigar",
      "htsjdk.samtools.SAMHeaderRecordComparator",
      "htsjdk.samtools.SAMUtils",
      "htsjdk.samtools.SAMTagUtil",
      "htsjdk.samtools.util.SequenceUtil",
      "htsjdk.samtools.SAMTextHeaderCodec$HeaderRecordType",
      "htsjdk.samtools.SAMTextHeaderCodec",
      "htsjdk.samtools.TextTagCodec",
      "htsjdk.samtools.util.StringUtil",
      "htsjdk.samtools.util.BufferedLineReader",
      "htsjdk.samtools.SamFlagField",
      "htsjdk.samtools.Defaults",
      "htsjdk.samtools.SAMReadGroupRecord",
      "htsjdk.samtools.SAMSequenceRecord",
      "htsjdk.samtools.SAMException",
      "htsjdk.samtools.SAMFlag",
      "htsjdk.samtools.SAMFileHeader$SortOrder",
      "htsjdk.samtools.SAMFileHeader$GroupOrder",
      "htsjdk.samtools.SAMProgramRecord",
      "htsjdk.samtools.SAMRecordCoordinateComparator",
      "htsjdk.samtools.util.Interval",
      "htsjdk.variant.vcf.VCFHeader",
      "htsjdk.variant.vcf.VCFHeaderLine",
      "htsjdk.variant.vcf.VCFHeaderVersion",
      "htsjdk.samtools.SAMValidationError",
      "htsjdk.samtools.SAMRecordQueryNameComparator",
      "htsjdk.tribble.util.ParsingUtils",
      "htsjdk.samtools.SAMRecordDuplicateComparator",
      "htsjdk.samtools.DuplicateScoringStrategy$ScoringStrategy",
      "htsjdk.samtools.util.CoordMath"
    );
  }
}
