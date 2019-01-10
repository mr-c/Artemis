/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Fri Jun 08 18:03:36 GMT 2018
 */

package uk.ac.sanger.artemis.components;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

@EvoSuiteClassExclude
public class SelectionMenu_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "uk.ac.sanger.artemis.components.SelectionMenu"; 
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
    java.lang.System.setProperty("log4j.configuration", "SUT.log4j.properties"); 
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(SelectionMenu_ESTest_scaffolding.class.getClassLoader() ,
      "uk.ac.sanger.artemis.components.LogViewer$1",
      "org.apache.log4j.AppenderSkeleton",
      "uk.ac.sanger.artemis.OptionChangeEvent",
      "uk.ac.sanger.artemis.components.genebuilder.JExtendedComboBox",
      "uk.ac.sanger.artemis.io.SimpleDocumentFeature",
      "uk.ac.sanger.artemis.sequence.BasePatternFormatException",
      "uk.ac.sanger.artemis.components.BasePlotGroup",
      "uk.ac.sanger.artemis.components.SelectionInfoDisplay$1",
      "com.sshtools.j2ssh.authentication.PasswordAuthenticationClient",
      "com.sshtools.j2ssh.authentication.PasswordChangePrompt",
      "uk.ac.sanger.artemis.plot.CodonUsageAlgorithm",
      "com.sshtools.j2ssh.SshClient",
      "uk.ac.sanger.artemis.EntryChangeListener",
      "org.biojava.ontology.Term",
      "uk.ac.sanger.artemis.sequence.AminoAcidSequence",
      "uk.ac.sanger.artemis.Selectable",
      "uk.ac.sanger.artemis.components.SelectionMenu$1",
      "org.apache.log4j.spi.Filter",
      "uk.ac.sanger.artemis.io.RangeVector",
      "uk.ac.sanger.artemis.io.FeatureTable",
      "htsjdk.variant.vcf.VCFIDHeaderLine",
      "uk.ac.sanger.artemis.plot.NcAlgorithm",
      "uk.ac.sanger.artemis.io.PublicDBDocumentEntry",
      "uk.ac.sanger.artemis.util.StringVector",
      "org.emboss.jemboss.JembossParams",
      "uk.ac.sanger.artemis.io.GenbankDocumentEntry",
      "htsjdk.samtools.AbstractSAMHeaderRecord",
      "org.biojava.bio.seq.Feature$Template",
      "com.sshtools.j2ssh.transport.AsyncService",
      "uk.ac.sanger.artemis.plot.CumulativeATSkewAlgorithm",
      "org.gmod.schema.sequence.Synonym",
      "org.gmod.schema.sequence.FeatureCvTermProp",
      "uk.ac.sanger.artemis.components.genebuilder.gff.PropertiesPanel",
      "org.apache.log4j.Hierarchy",
      "uk.ac.sanger.artemis.sequence.MarkerRange",
      "org.emboss.jemboss.gui.Browser$3",
      "org.emboss.jemboss.gui.Browser$4",
      "org.biojava.utils.Changeable",
      "uk.ac.sanger.artemis.FeaturePatternPredicate",
      "uk.ac.sanger.artemis.plot.GCFrameAlgorithm",
      "org.emboss.jemboss.gui.Browser$6",
      "uk.ac.sanger.artemis.components.genebuilder.ReferencesPanel",
      "uk.ac.sanger.artemis.io.QualifierInfoHash",
      "com.sshtools.j2ssh.connection.Channel",
      "htsjdk.variant.vcf.VCFHeaderLineType",
      "org.apache.log4j.spi.OptionHandler",
      "uk.ac.sanger.artemis.SimpleEntryGroup",
      "uk.ac.sanger.artemis.plot.PositionalAsymmetryAlgorithm",
      "org.biojava.utils.ChangeVetoException",
      "org.biojava.bio.symbol.IllegalAlphabetException",
      "htsjdk.samtools.seekablestream.SeekableStream",
      "uk.ac.sanger.artemis.sequence.MarkerInternal",
      "com.sshtools.j2ssh.connection.ChannelEventListener",
      "uk.ac.sanger.artemis.components.Splash$2",
      "org.gmod.schema.dao.GeneralDaoI",
      "org.apache.log4j.helpers.OptionConverter",
      "org.gmod.schema.dao.BaseDaoI",
      "org.biojava.bio.symbol.Edit",
      "uk.ac.sanger.artemis.io.MiscLineGroup",
      "uk.ac.sanger.artemis.components.SelectionViewer",
      "uk.ac.sanger.artemis.io.LazyQualifierValue",
      "uk.ac.sanger.artemis.components.FeatureDisplay$10",
      "uk.ac.sanger.artemis.components.FeatureDisplay$11",
      "org.gmod.schema.cv.CvTerm",
      "uk.ac.sanger.artemis.sequence.SequenceChangeListener",
      "org.apache.xmlgraphics.java2d.GraphicsConfigurationWithoutTransparency",
      "uk.ac.sanger.artemis.components.ZoomScrollBar$1",
      "uk.ac.sanger.artemis.io.InvalidRelationException",
      "uk.ac.sanger.artemis.components.genebuilder.cv.CVPanel",
      "org.biojava.bio.Annotation",
      "com.sshtools.j2ssh.authentication.AuthenticationProtocolClient",
      "org.apache.log4j.Category",
      "uk.ac.sanger.artemis.io.LocationParseException",
      "uk.ac.sanger.artemis.AlignmentSelectionChangeListener",
      "htsjdk.samtools.SAMException",
      "uk.ac.sanger.artemis.util.FastVector",
      "com.sshtools.j2ssh.sftp.SftpFileOutputStream",
      "uk.ac.sanger.artemis.components.ShortCut",
      "com.sshtools.j2ssh.transport.TransportProtocolEventHandler",
      "org.gmod.schema.sequence.FeatureDbXRef",
      "uk.ac.sanger.artemis.Action",
      "uk.ac.sanger.artemis.util.URLDocument",
      "org.biojava.utils.ChangeEvent",
      "org.gmod.schema.pub.Pub",
      "uk.ac.sanger.artemis.SSAHAComparisonData",
      "uk.ac.sanger.artemis.io.ChadoCanonicalGene",
      "uk.ac.sanger.artemis.components.MessageDialog",
      "htsjdk.tribble.util.RemoteURLHelper",
      "uk.ac.sanger.artemis.components.Plot",
      "com.sshtools.j2ssh.transport.TransportProtocolState",
      "org.gmod.schema.sequence.FeatureCvTermDbXRef",
      "uk.ac.sanger.artemis.EntrySource",
      "uk.ac.sanger.artemis.io.GenbankStreamSequence",
      "uk.ac.sanger.artemis.components.SegmentBorder",
      "uk.ac.sanger.artemis.plot.CodonUsageWeight",
      "com.sshtools.j2ssh.io.UnsignedInteger32",
      "htsjdk.samtools.util.RuntimeIOException",
      "uk.ac.sanger.artemis.components.FeatureList$1",
      "uk.ac.sanger.artemis.plot.KarlinSigAlgorithm",
      "com.sshtools.j2ssh.forwarding.ForwardingClient",
      "htsjdk.samtools.util.Locatable",
      "org.gmod.schema.utils.propinterface.PropertyI",
      "uk.ac.sanger.artemis.plot.EntropyAlgorithm",
      "uk.ac.sanger.artemis.components.DisplayAdjustmentEvent",
      "htsjdk.samtools.SAMSequenceDictionary",
      "uk.ac.sanger.artemis.chado.FeatureForUpdatingResidues",
      "org.apache.log4j.spi.AppenderAttachable",
      "com.sshtools.j2ssh.SshException",
      "uk.ac.sanger.artemis.j2ssh.FTProgress",
      "uk.ac.sanger.artemis.io.GFF3AttributeAggregator",
      "org.gmod.schema.cv.Cv",
      "uk.ac.sanger.artemis.util.InputStreamProgressListenerVector",
      "uk.ac.sanger.artemis.util.PushBackException",
      "uk.ac.sanger.artemis.components.FeatureDisplay$12",
      "com.sshtools.j2ssh.connection.IOChannel",
      "org.biojava.bio.symbol.SymbolList",
      "com.sshtools.j2ssh.DirectoryOperation",
      "org.biojava.bio.BioException",
      "com.sshtools.j2ssh.sftp.SftpFileInputStream",
      "uk.ac.sanger.artemis.io.DatabaseDocumentEntry",
      "org.apache.xmlgraphics.java2d.GraphicsConfigurationWithTransparency",
      "uk.ac.sanger.artemis.io.LocationParseNode",
      "uk.ac.sanger.artemis.plot.Codon12CorrelationAlgorithm",
      "uk.ac.sanger.artemis.util.WorkingGZIPInputStream",
      "htsjdk.variant.vcf.VCFCompoundHeaderLine",
      "uk.ac.sanger.artemis.components.EditMenu",
      "uk.ac.sanger.artemis.SelectionChangeEvent",
      "uk.ac.sanger.artemis.io.ComparableFeature",
      "uk.ac.sanger.artemis.plot.BaseAlgorithm",
      "uk.ac.sanger.artemis.io.Key",
      "org.apache.xmlgraphics.java2d.GenericGraphicsDevice",
      "uk.ac.sanger.artemis.Options",
      "uk.ac.sanger.artemis.io.SimpleDocumentEntry",
      "htsjdk.variant.vcf.VCFSimpleHeaderLine",
      "org.biojava.ontology.InvalidTermException",
      "com.sshtools.j2ssh.connection.ChannelFactory",
      "uk.ac.sanger.artemis.io.FeatureHeader",
      "uk.ac.sanger.artemis.components.filetree.FileList",
      "com.sshtools.j2ssh.connection.ConnectionProtocol",
      "uk.ac.sanger.artemis.components.FeaturePopup",
      "uk.ac.sanger.artemis.chado.Graph",
      "org.apache.batik.gvt.text.GVTAttributedCharacterIterator$TextAttribute",
      "uk.ac.sanger.artemis.plot.ATDeviationAlgorithm",
      "uk.ac.sanger.artemis.FeatureKeyQualifierPredicate",
      "uk.ac.sanger.artemis.MUMmerComparisonData",
      "uk.ac.sanger.artemis.ChangeListener",
      "uk.ac.sanger.artemis.components.MarkerRangeRequesterListener",
      "uk.ac.sanger.artemis.io.FeatureTree",
      "uk.ac.sanger.artemis.ChangeEventVector",
      "uk.ac.sanger.artemis.plot.LineAttributes",
      "org.apache.log4j.helpers.Loader",
      "uk.ac.sanger.artemis.sequence.MarkerChangeEvent",
      "uk.ac.sanger.artemis.components.genebuilder.GeneEditorPanel",
      "uk.ac.sanger.artemis.components.SelectionMenu",
      "uk.ac.sanger.artemis.components.KeyChoice",
      "uk.ac.sanger.artemis.io.RawStreamSequence",
      "uk.ac.sanger.artemis.io.QualifierInfoException",
      "uk.ac.sanger.artemis.FilteredEntryGroup",
      "uk.ac.sanger.artemis.sequence.SequenceChangeEvent",
      "org.gmod.schema.dao.SequenceDaoI",
      "com.sshtools.j2ssh.transport.HostKeyVerification",
      "org.apache.xmlgraphics.java2d.AbstractGraphicsConfiguration",
      "org.biojava.bio.symbol.Symbol",
      "com.sshtools.j2ssh.io.UnsignedInteger64",
      "org.gmod.schema.sequence.FeatureCvTerm",
      "com.sshtools.j2ssh.ScpClient",
      "uk.ac.sanger.artemis.io.DatabaseStreamFeature",
      "uk.ac.sanger.artemis.components.database.DatabaseJPanel",
      "org.gmod.schema.dao.CvDaoI",
      "uk.ac.sanger.artemis.plot.GCWindowAlgorithm",
      "htsjdk.tribble.TribbleException",
      "uk.ac.sanger.artemis.io.ReadListener",
      "org.biojava.bio.seq.Feature",
      "uk.ac.sanger.artemis.io.InvalidKeyException",
      "uk.ac.sanger.artemis.AlignmentSelectionChangeEvent",
      "uk.ac.sanger.artemis.io.Packing",
      "uk.ac.sanger.artemis.io.LocationLexer",
      "org.biojava.bio.seq.Sequence",
      "uk.ac.sanger.artemis.util.ByteBuffer",
      "uk.ac.sanger.artemis.io.SimpleEntryInformation",
      "uk.ac.sanger.artemis.components.DisplayAdjustmentListener",
      "uk.ac.sanger.artemis.components.ZoomScrollBar",
      "uk.ac.sanger.artemis.io.StreamSequence",
      "uk.ac.sanger.artemis.io.GFF3AttributeBuilder",
      "uk.ac.sanger.artemis.io.Range",
      "uk.ac.sanger.artemis.sequence.Bases",
      "uk.ac.sanger.artemis.EntryGroupChangeListener",
      "uk.ac.sanger.artemis.components.LogViewer",
      "uk.ac.sanger.artemis.ActionController",
      "uk.ac.sanger.artemis.io.BetweenRange",
      "uk.ac.sanger.artemis.ExternalProgramMonitor",
      "com.sshtools.j2ssh.transport.SshMessage",
      "com.sshtools.j2ssh.util.State",
      "uk.ac.sanger.artemis.j2ssh.SshLogin",
      "uk.ac.sanger.artemis.plot.CumulativeGCSkewAlgorithm",
      "uk.ac.sanger.artemis.FeatureFromVectorPredicate",
      "org.apache.log4j.PropertyConfigurator",
      "htsjdk.tribble.TribbleException$InvalidHeader",
      "uk.ac.sanger.artemis.util.Document",
      "org.apache.log4j.spi.ThrowableRenderer",
      "uk.ac.sanger.artemis.components.SelectionMenu$2",
      "uk.ac.sanger.artemis.components.FileViewer",
      "uk.ac.sanger.artemis.Selection",
      "uk.ac.sanger.artemis.FeaturePredicateVector",
      "uk.ac.sanger.artemis.sequence.NoSequenceException",
      "uk.ac.sanger.artemis.BlastM8ComparisonData",
      "htsjdk.variant.vcf.VCFFilterHeaderLine",
      "uk.ac.sanger.artemis.components.QualifierTextArea",
      "uk.ac.sanger.artemis.components.SelectionInfoDisplay",
      "uk.ac.sanger.artemis.plot.ICDIAlgorithm",
      "uk.ac.sanger.artemis.MegaBlastComparisonData",
      "org.apache.log4j.spi.LoggerRepository",
      "com.sshtools.j2ssh.transport.TransportProtocolException",
      "htsjdk.samtools.SAMSequenceRecord",
      "uk.ac.sanger.artemis.components.Splash",
      "uk.ac.sanger.artemis.components.TextRequesterListener",
      "uk.ac.sanger.artemis.io.EntryInformationException",
      "com.sshtools.j2ssh.authentication.SshMsgUserAuthRequest",
      "uk.ac.sanger.artemis.io.GFFMisc",
      "uk.ac.sanger.artemis.FeatureSegmentVector",
      "htsjdk.samtools.util.Log$LogLevel",
      "uk.ac.sanger.artemis.chado.IBatisDAO",
      "uk.ac.sanger.artemis.components.filetree.RemoteFileNode",
      "uk.ac.sanger.artemis.io.SimpleDocumentEntry$1",
      "uk.ac.sanger.artemis.plot.GCDeviationAlgorithm",
      "org.apache.log4j.Level",
      "uk.ac.sanger.artemis.io.FuzzyRange",
      "uk.ac.sanger.artemis.components.FeatureDisplay",
      "com.sshtools.j2ssh.authentication.TerminatedStateException",
      "uk.ac.sanger.artemis.io.EntryInformation",
      "uk.ac.sanger.artemis.sequence.MarkerChangeListener",
      "org.biojava.utils.ChangeType",
      "uk.ac.sanger.artemis.io.ReadFormatException",
      "com.sshtools.j2ssh.sftp.SftpSubsystemClient",
      "htsjdk.variant.variantcontext.VariantContextComparator",
      "org.biojava.utils.ChangeListener",
      "uk.ac.sanger.artemis.GotoEvent",
      "uk.ac.sanger.artemis.components.BasePlot",
      "org.gmod.schema.sequence.FeaturePub",
      "org.apache.log4j.Layout",
      "uk.ac.sanger.artemis.EntrySourceVector",
      "org.biojava.bio.symbol.EmptyAlphabet",
      "uk.ac.sanger.artemis.components.ViewMenu",
      "org.gmod.schema.analysis.AnalysisFeature",
      "uk.ac.sanger.artemis.LastSegmentException",
      "org.gmod.schema.dao.SchemaDaoI",
      "uk.ac.sanger.artemis.ChangeEvent",
      "org.gmod.schema.sequence.FeatureRelationship",
      "uk.ac.sanger.artemis.util.OutOfRangeException",
      "uk.ac.sanger.artemis.io.GenbankStreamFeature",
      "org.emboss.jemboss.gui.MemoryComboBox",
      "uk.ac.sanger.artemis.io.EMBLObject",
      "uk.ac.sanger.artemis.components.AlignmentListener",
      "uk.ac.sanger.artemis.ActionVector",
      "uk.ac.sanger.artemis.sequence.Strand",
      "uk.ac.sanger.artemis.chado.GmodDAO",
      "org.emboss.jemboss.gui.Browser",
      "uk.ac.sanger.artemis.components.FeatureEdit",
      "org.apache.log4j.spi.DefaultRepositorySelector",
      "org.biojava.ontology.OntologyException",
      "uk.ac.sanger.artemis.OptionChangeListener",
      "uk.ac.sanger.artemis.io.Sequence",
      "com.sshtools.j2ssh.sftp.SftpFile",
      "uk.ac.sanger.artemis.util.LargeObjectDocument",
      "uk.ac.sanger.artemis.io.GenbankMisc",
      "htsjdk.variant.vcf.VCFFormatHeaderLine",
      "uk.ac.sanger.artemis.chado.JdbcDAO",
      "uk.ac.sanger.artemis.io.Location",
      "uk.ac.sanger.artemis.util.RemoteFileDocument",
      "uk.ac.sanger.artemis.components.SwingWorker",
      "uk.ac.sanger.artemis.io.PublicDBStreamFeature",
      "org.apache.log4j.or.ObjectRenderer",
      "uk.ac.sanger.artemis.FilteredEntryGroup$FeatureEnumerator",
      "uk.ac.sanger.artemis.io.FastaStreamSequence",
      "uk.ac.sanger.artemis.io.FeatureEnumeration",
      "uk.ac.sanger.artemis.components.CanvasPanel",
      "htsjdk.tribble.util.URLHelper",
      "uk.ac.sanger.artemis.io.StreamFeature",
      "uk.ac.sanger.artemis.components.EntryGroupPanel$1",
      "uk.ac.sanger.artemis.util.ReadOnlyException",
      "com.sshtools.j2ssh.transport.publickey.SshPublicKey",
      "uk.ac.sanger.artemis.FilteredEntryGroup$3",
      "uk.ac.sanger.artemis.EntryChangeEvent",
      "uk.ac.sanger.artemis.FilteredEntryGroup$2",
      "uk.ac.sanger.artemis.FilteredEntryGroup$1",
      "uk.ac.sanger.artemis.components.PlotMouseListener",
      "com.sshtools.j2ssh.SshEventAdapter",
      "org.biojava.bio.seq.FeatureFilter",
      "uk.ac.sanger.artemis.Feature",
      "uk.ac.sanger.artemis.io.EmblDocumentEntry",
      "uk.ac.sanger.artemis.components.SelectMenu",
      "com.sshtools.j2ssh.subsystem.SubsystemChannel",
      "uk.ac.sanger.artemis.io.DocumentFeature",
      "com.sshtools.j2ssh.FileTransferProgress",
      "uk.ac.sanger.artemis.plot.Algorithm",
      "uk.ac.sanger.artemis.util.StringVector$1",
      "org.apache.log4j.spi.LoggerFactory",
      "uk.ac.sanger.artemis.SimpleComparisonData",
      "org.apache.log4j.spi.Configurator",
      "htsjdk.variant.vcf.VCFInfoHeaderLine",
      "uk.ac.sanger.artemis.io.MSPcrunchStreamFeature",
      "htsjdk.variant.vcf.VCFHeaderLineCount",
      "org.apache.log4j.spi.LocationInfo",
      "uk.ac.sanger.artemis.components.SelectionSubMenu",
      "org.gmod.schema.sequence.Feature",
      "org.biojava.bio.symbol.FiniteAlphabet",
      "uk.ac.sanger.artemis.io.KeyVector",
      "uk.ac.sanger.artemis.AlignMatchVector",
      "org.gmod.schema.sequence.FeatureProp",
      "org.gmod.schema.sequence.FeatureCvTermPub",
      "org.biojava.bio.Annotatable",
      "org.gmod.schema.utils.Rankable",
      "uk.ac.sanger.artemis.io.MSPcrunchEntryInformation",
      "uk.ac.sanger.artemis.components.FileViewer$2",
      "htsjdk.samtools.seekablestream.SeekablePathStream",
      "uk.ac.sanger.artemis.ComparisonDataParseException",
      "uk.ac.sanger.artemis.FeatureVector",
      "uk.ac.sanger.artemis.io.BioJavaSequence",
      "uk.ac.sanger.artemis.SimpleGotoEventSource",
      "uk.ac.sanger.artemis.io.EmblStreamSequence",
      "uk.ac.sanger.artemis.components.SwingWorker$ThreadVar",
      "uk.ac.sanger.artemis.io.FeatureComparator",
      "htsjdk.tribble.TribbleException$InternalCodecException",
      "org.biojava.bio.seq.FeatureHolder",
      "uk.ac.sanger.artemis.components.AlignmentViewer$ColorChooserShades",
      "org.gmod.schema.dao.OrganismDaoI",
      "com.sshtools.j2ssh.session.SessionChannelClient",
      "com.sshtools.j2ssh.SftpClient",
      "uk.ac.sanger.artemis.FeaturePredicateConjunction",
      "uk.ac.sanger.artemis.io.QualifierInfo",
      "org.biojava.utils.Unchangeable",
      "org.apache.log4j.Priority",
      "uk.ac.sanger.artemis.components.FeatureDisplay$7",
      "uk.ac.sanger.artemis.components.FeatureDisplay$8",
      "uk.ac.sanger.artemis.components.FeatureDisplay$3",
      "org.apache.log4j.LogManager",
      "org.gmod.schema.sequence.FeatureLoc",
      "uk.ac.sanger.artemis.components.FeatureDisplay$6",
      "uk.ac.sanger.artemis.components.FeatureDisplay$1",
      "uk.ac.sanger.artemis.components.FeatureDisplay$2",
      "org.biojava.bio.seq.FeatureHolder$EmptyFeatureHolder",
      "uk.ac.sanger.artemis.components.TextRequesterEvent",
      "uk.ac.sanger.artemis.io.DocumentEntry",
      "uk.ac.sanger.artemis.j2ssh.SshFileManager",
      "htsjdk.variant.vcf.VCFHeader",
      "org.biojava.bio.symbol.EmptySymbolList",
      "org.apache.log4j.DefaultCategoryFactory",
      "uk.ac.sanger.artemis.io.BlastStreamFeature",
      "htsjdk.tribble.util.ParsingUtils",
      "uk.ac.sanger.artemis.components.genebuilder.ortholog.MatchPanel",
      "uk.ac.sanger.artemis.FeatureKeyPredicate",
      "org.apache.log4j.or.RendererMap",
      "uk.ac.sanger.artemis.io.OutOfDateException",
      "uk.ac.sanger.artemis.ExternalProgram",
      "com.sshtools.j2ssh.transport.Service",
      "uk.ac.sanger.artemis.io.EmblMisc",
      "org.gmod.schema.pub.PubDbXRef",
      "org.gmod.schema.general.DbXRef",
      "uk.ac.sanger.artemis.io.PartialSequence",
      "uk.ac.sanger.artemis.components.ComboBoxRenderer",
      "uk.ac.sanger.artemis.EntryGroupChangeEvent",
      "uk.ac.sanger.artemis.plot.ScaledChiAlgorithm",
      "uk.ac.sanger.artemis.Entry",
      "uk.ac.sanger.artemis.components.MarkerRangeRequesterEvent",
      "uk.ac.sanger.artemis.io.EmblStreamFeature",
      "uk.ac.sanger.artemis.io.QualifierParseException",
      "org.biojava.bio.symbol.IllegalSymbolException",
      "uk.ac.sanger.artemis.ExternalProgramVector",
      "org.apache.log4j.CategoryKey",
      "uk.ac.sanger.artemis.plot.MRIAlgorithm",
      "uk.ac.sanger.artemis.io.Qualifier",
      "uk.ac.sanger.artemis.util.InputStreamProgressListener",
      "uk.ac.sanger.artemis.io.LocationLexer$TokenEnumeration",
      "org.apache.log4j.helpers.OnlyOnceErrorHandler",
      "uk.ac.sanger.artemis.io.DocumentEntryAutosaveThread",
      "uk.ac.sanger.artemis.components.EntryGroupPanel",
      "com.sshtools.j2ssh.sftp.FileAttributes",
      "uk.ac.sanger.artemis.sequence.Marker",
      "org.biojava.bio.seq.Feature$ByLocationComparator",
      "org.apache.batik.gvt.text.GVTAttributedCharacterIterator$AttributeFilter",
      "uk.ac.sanger.artemis.plot.CSCSAlgorithm",
      "uk.ac.sanger.artemis.components.UserDefinedQualifiers",
      "org.apache.log4j.ProvisionNode",
      "com.sshtools.j2ssh.TransferCancelledException",
      "com.sshtools.j2ssh.authentication.SshAuthenticationClient",
      "uk.ac.sanger.artemis.io.GFFDocumentEntry",
      "uk.ac.sanger.artemis.io.GFFStreamFeature",
      "uk.ac.sanger.artemis.components.QualifierChoice",
      "org.apache.log4j.spi.RootLogger",
      "org.emboss.jemboss.gui.Browser$JIconButton",
      "uk.ac.sanger.artemis.EntryVector",
      "htsjdk.variant.vcf.VCFContigHeaderLine",
      "org.apache.log4j.spi.ErrorHandler",
      "uk.ac.sanger.artemis.ExternalProgramException",
      "uk.ac.sanger.artemis.io.QualifierVector",
      "org.apache.log4j.spi.RendererSupport",
      "uk.ac.sanger.artemis.FeatureChangeListener",
      "uk.ac.sanger.artemis.FeatureChangeEvent",
      "uk.ac.sanger.artemis.util.FileDocument",
      "htsjdk.samtools.util.Log",
      "uk.ac.sanger.artemis.plot.CodonWeight",
      "uk.ac.sanger.artemis.io.LocationParseNodeVector",
      "uk.ac.sanger.artemis.io.LineGroup",
      "uk.ac.sanger.artemis.Entry$FeatureEnumerator",
      "uk.ac.sanger.artemis.io.GFFEntryInformation",
      "uk.ac.sanger.artemis.util.InputStreamProgressEvent",
      "uk.ac.sanger.artemis.GotoEventSource",
      "uk.ac.sanger.artemis.components.genebuilder.ortholog.MatchPanel$3",
      "uk.ac.sanger.artemis.plot.GCSDWindowAlgorithm",
      "org.apache.log4j.Logger",
      "uk.ac.sanger.artemis.FeatureSegment",
      "uk.ac.sanger.artemis.EntryGroup",
      "uk.ac.sanger.artemis.io.Feature",
      "com.sshtools.j2ssh.authentication.AuthenticationProtocolListener",
      "org.apache.log4j.helpers.LogLog",
      "uk.ac.sanger.artemis.io.QualifierInfoVector",
      "uk.ac.sanger.artemis.io.BlastEntryInformation",
      "uk.ac.sanger.artemis.components.DisplayComponent",
      "org.apache.batik.gvt.text.GVTAttributedCharacterIterator",
      "org.apache.log4j.spi.RepositorySelector",
      "uk.ac.sanger.artemis.io.GFF3AttributeBuilder$1",
      "uk.ac.sanger.artemis.plot.AGWindowAlgorithm",
      "uk.ac.sanger.artemis.io.ReadEvent",
      "uk.ac.sanger.artemis.MSPcrunchComparisonData",
      "htsjdk.variant.variantcontext.VariantContext",
      "uk.ac.sanger.artemis.io.Entry",
      "uk.ac.sanger.artemis.util.LinePushBackReader",
      "org.apache.log4j.or.DefaultRenderer",
      "uk.ac.sanger.artemis.util.ProgressInputStream",
      "htsjdk.variant.vcf.VCFHeaderLine",
      "uk.ac.sanger.artemis.AlignMatch",
      "uk.ac.sanger.artemis.io.FeatureVector",
      "uk.ac.sanger.artemis.chado.ChadoTransactionManager",
      "org.apache.log4j.spi.ThrowableRendererSupport",
      "org.apache.commons.logging.impl.Log4JLogger",
      "com.sshtools.j2ssh.authentication.SshAuthenticationPrompt",
      "org.biojava.bio.symbol.Location",
      "org.gmod.schema.organism.Organism",
      "org.gmod.schema.general.Db",
      "org.apache.log4j.Appender",
      "uk.ac.sanger.artemis.components.AlignmentEvent",
      "htsjdk.tribble.Feature",
      "uk.ac.sanger.artemis.ComparisonData",
      "org.biojava.bio.symbol.Alphabet",
      "uk.ac.sanger.artemis.components.AlignmentViewer",
      "uk.ac.sanger.artemis.chado.ChadoTransaction",
      "uk.ac.sanger.artemis.ExternalProgramListener",
      "org.biojava.utils.AssertionFailure",
      "uk.ac.sanger.artemis.FeaturePredicate",
      "com.sshtools.j2ssh.authentication.AuthenticationProtocolException",
      "org.apache.log4j.spi.HierarchyEventListener",
      "uk.ac.sanger.artemis.Logger",
      "com.sshtools.j2ssh.configuration.SshConnectionProperties",
      "uk.ac.sanger.artemis.components.LogReadListener",
      "org.gmod.schema.sequence.FeatureSynonym",
      "org.apache.log4j.spi.LoggingEvent",
      "uk.ac.sanger.artemis.io.QualifierLazyLoading",
      "uk.ac.sanger.artemis.util.DatabaseDocument",
      "org.apache.log4j.spi.ThrowableInformation",
      "uk.ac.sanger.artemis.FeatureEnumeration",
      "uk.ac.sanger.artemis.components.FeatureList",
      "uk.ac.sanger.artemis.io.StreamFeatureTable",
      "uk.ac.sanger.artemis.SelectionChangeListener",
      "org.gmod.schema.dao.PubDaoI",
      "uk.ac.sanger.artemis.GotoListener"
    );
  } 

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(SelectionMenu_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "uk.ac.sanger.artemis.components.SelectionMenu",
      "uk.ac.sanger.artemis.components.SelectionMenu$1",
      "uk.ac.sanger.artemis.components.SelectionMenu$2",
      "org.apache.log4j.Category",
      "org.apache.log4j.Logger",
      "org.apache.log4j.Priority",
      "org.apache.log4j.Level",
      "org.apache.log4j.helpers.OptionConverter",
      "org.apache.log4j.helpers.LogLog",
      "org.apache.log4j.helpers.Loader",
      "org.apache.log4j.Hierarchy",
      "org.apache.log4j.spi.RootLogger",
      "org.apache.log4j.or.DefaultRenderer",
      "org.apache.log4j.or.RendererMap",
      "org.apache.log4j.DefaultCategoryFactory",
      "org.apache.log4j.spi.DefaultRepositorySelector",
      "org.apache.log4j.PropertyConfigurator",
      "org.apache.log4j.LogManager",
      "uk.ac.sanger.artemis.util.Document",
      "org.apache.log4j.CategoryKey",
      "org.apache.log4j.ProvisionNode",
      "uk.ac.sanger.artemis.util.DatabaseDocument",
      "uk.ac.sanger.artemis.util.StringVector",
      "uk.ac.sanger.artemis.util.FileDocument",
      "uk.ac.sanger.artemis.util.InputStreamProgressListenerVector",
      "org.apache.log4j.AppenderSkeleton",
      "uk.ac.sanger.artemis.components.LogViewer",
      "org.apache.log4j.helpers.OnlyOnceErrorHandler",
      "uk.ac.sanger.artemis.components.Splash",
      "uk.ac.sanger.artemis.io.QualifierInfoVector",
      "uk.ac.sanger.artemis.util.FastVector",
      "uk.ac.sanger.artemis.io.KeyVector",
      "uk.ac.sanger.artemis.io.Key",
      "uk.ac.sanger.artemis.io.QualifierInfo",
      "uk.ac.sanger.artemis.io.SimpleEntryInformation",
      "uk.ac.sanger.artemis.io.QualifierInfoHash",
      "uk.ac.sanger.artemis.ExternalProgramVector",
      "uk.ac.sanger.artemis.ExternalProgram",
      "uk.ac.sanger.artemis.Options",
      "uk.ac.sanger.artemis.components.ShortCut",
      "org.apache.xmlgraphics.java2d.AbstractGraphicsConfiguration",
      "org.apache.commons.logging.impl.Log4JLogger",
      "org.apache.xmlgraphics.java2d.GraphicsConfigurationWithoutTransparency",
      "org.apache.xmlgraphics.java2d.GraphicsConfigurationWithTransparency",
      "uk.ac.sanger.artemis.Selection",
      "uk.ac.sanger.artemis.FeatureVector",
      "uk.ac.sanger.artemis.FeatureSegmentVector",
      "uk.ac.sanger.artemis.EntryVector",
      "uk.ac.sanger.artemis.SimpleEntryGroup",
      "uk.ac.sanger.artemis.ActionController",
      "uk.ac.sanger.artemis.ActionVector",
      "uk.ac.sanger.artemis.FilteredEntryGroup",
      "uk.ac.sanger.artemis.FilteredEntryGroup$1",
      "uk.ac.sanger.artemis.FilteredEntryGroup$2",
      "uk.ac.sanger.artemis.FilteredEntryGroup$3",
      "uk.ac.sanger.artemis.SimpleGotoEventSource",
      "uk.ac.sanger.artemis.components.BasePlotGroup",
      "uk.ac.sanger.artemis.components.MessageDialog",
      "uk.ac.sanger.artemis.io.EMBLObject",
      "uk.ac.sanger.artemis.io.LineGroup",
      "uk.ac.sanger.artemis.io.StreamSequence",
      "uk.ac.sanger.artemis.io.RawStreamSequence",
      "uk.ac.sanger.artemis.io.Packing",
      "uk.ac.sanger.artemis.sequence.Bases",
      "uk.ac.sanger.artemis.sequence.Strand",
      "uk.ac.sanger.artemis.sequence.AminoAcidSequence",
      "uk.ac.sanger.artemis.FeaturePatternPredicate",
      "uk.ac.sanger.artemis.Entry",
      "uk.ac.sanger.artemis.io.SimpleDocumentEntry",
      "uk.ac.sanger.artemis.io.PublicDBDocumentEntry",
      "uk.ac.sanger.artemis.io.EmblDocumentEntry",
      "uk.ac.sanger.artemis.io.FeatureVector",
      "uk.ac.sanger.artemis.io.SimpleDocumentEntry$1",
      "uk.ac.sanger.artemis.Entry$FeatureEnumerator",
      "uk.ac.sanger.artemis.ChangeEvent",
      "uk.ac.sanger.artemis.EntryGroupChangeEvent",
      "uk.ac.sanger.artemis.io.QualifierVector",
      "uk.ac.sanger.artemis.io.Location",
      "uk.ac.sanger.artemis.io.LocationLexer",
      "uk.ac.sanger.artemis.io.LocationLexer$TokenEnumeration",
      "uk.ac.sanger.artemis.io.LocationParseNodeVector",
      "uk.ac.sanger.artemis.io.LocationParseNode",
      "uk.ac.sanger.artemis.io.Range",
      "uk.ac.sanger.artemis.io.FuzzyRange",
      "uk.ac.sanger.artemis.io.SimpleDocumentFeature",
      "uk.ac.sanger.artemis.io.PublicDBStreamFeature",
      "uk.ac.sanger.artemis.io.EmblStreamFeature",
      "uk.ac.sanger.artemis.io.FeatureTable",
      "uk.ac.sanger.artemis.io.StreamFeatureTable",
      "uk.ac.sanger.artemis.io.FeatureTree",
      "uk.ac.sanger.artemis.io.FeatureComparator",
      "uk.ac.sanger.artemis.io.RangeVector",
      "uk.ac.sanger.artemis.Feature",
      "uk.ac.sanger.artemis.FeatureSegment",
      "uk.ac.sanger.artemis.sequence.Marker",
      "uk.ac.sanger.artemis.sequence.MarkerInternal",
      "uk.ac.sanger.artemis.EntryChangeEvent",
      "uk.ac.sanger.artemis.plot.Algorithm",
      "uk.ac.sanger.artemis.plot.BaseAlgorithm",
      "uk.ac.sanger.artemis.plot.GCWindowAlgorithm",
      "uk.ac.sanger.artemis.components.Plot",
      "uk.ac.sanger.artemis.components.BasePlot",
      "uk.ac.sanger.artemis.components.CanvasPanel",
      "uk.ac.sanger.artemis.components.EntryGroupPanel",
      "uk.ac.sanger.artemis.components.FeatureList",
      "uk.ac.sanger.artemis.components.EntryGroupPanel$1",
      "uk.ac.sanger.artemis.components.FeatureList$1",
      "uk.ac.sanger.artemis.io.GenbankStreamSequence",
      "org.emboss.jemboss.JembossParams",
      "org.emboss.jemboss.gui.Browser",
      "uk.ac.sanger.artemis.components.ViewMenu",
      "uk.ac.sanger.artemis.FeatureKeyQualifierPredicate",
      "uk.ac.sanger.artemis.io.EmblStreamSequence",
      "uk.ac.sanger.artemis.io.FastaStreamSequence",
      "uk.ac.sanger.artemis.components.FeatureDisplay$2",
      "uk.ac.sanger.artemis.components.FeatureDisplay$3",
      "uk.ac.sanger.artemis.components.FeatureDisplay",
      "uk.ac.sanger.artemis.components.FeatureDisplay$1",
      "uk.ac.sanger.artemis.components.FeatureDisplay$10",
      "uk.ac.sanger.artemis.components.ZoomScrollBar",
      "uk.ac.sanger.artemis.components.SelectionInfoDisplay",
      "uk.ac.sanger.artemis.components.SelectionInfoDisplay$1",
      "uk.ac.sanger.artemis.SelectionChangeEvent",
      "uk.ac.sanger.artemis.components.filetree.RemoteFileNode",
      "uk.ac.sanger.artemis.components.filetree.FileList",
      "uk.ac.sanger.artemis.j2ssh.SshFileManager",
      "uk.ac.sanger.artemis.j2ssh.SshLogin",
      "uk.ac.sanger.artemis.FeatureFromVectorPredicate",
      "uk.ac.sanger.artemis.util.OutOfRangeException",
      "uk.ac.sanger.artemis.components.SelectMenu",
      "uk.ac.sanger.artemis.components.EditMenu",
      "uk.ac.sanger.artemis.SimpleComparisonData",
      "uk.ac.sanger.artemis.MUMmerComparisonData",
      "uk.ac.sanger.artemis.io.MSPcrunchEntryInformation",
      "uk.ac.sanger.artemis.util.URLDocument",
      "uk.ac.sanger.artemis.components.LogReadListener",
      "uk.ac.sanger.artemis.io.GenbankDocumentEntry",
      "uk.ac.sanger.artemis.util.LinePushBackReader",
      "uk.ac.sanger.artemis.io.BlastEntryInformation",
      "uk.ac.sanger.artemis.components.ZoomScrollBar$1",
      "uk.ac.sanger.artemis.components.DisplayAdjustmentEvent",
      "uk.ac.sanger.artemis.components.FeatureDisplay$6",
      "uk.ac.sanger.artemis.components.FeatureDisplay$7",
      "uk.ac.sanger.artemis.components.FeatureDisplay$8",
      "uk.ac.sanger.artemis.MegaBlastComparisonData",
      "org.biojava.utils.ChangeType",
      "org.biojava.bio.seq.Feature$ByLocationComparator",
      "org.biojava.bio.seq.Feature",
      "uk.ac.sanger.artemis.components.SelectionViewer",
      "uk.ac.sanger.artemis.components.FileViewer",
      "com.sshtools.j2ssh.io.UnsignedInteger64",
      "uk.ac.sanger.artemis.components.AlignmentViewer",
      "uk.ac.sanger.artemis.plot.AGWindowAlgorithm",
      "uk.ac.sanger.artemis.io.ChadoCanonicalGene",
      "uk.ac.sanger.artemis.plot.GCDeviationAlgorithm",
      "uk.ac.sanger.artemis.FilteredEntryGroup$FeatureEnumerator",
      "uk.ac.sanger.artemis.FeaturePredicateConjunction",
      "uk.ac.sanger.artemis.FeaturePredicateVector",
      "htsjdk.variant.vcf.VCFHeader",
      "htsjdk.tribble.util.ParsingUtils",
      "htsjdk.samtools.AbstractSAMHeaderRecord",
      "htsjdk.samtools.SAMSequenceRecord",
      "uk.ac.sanger.artemis.io.GFFDocumentEntry",
      "uk.ac.sanger.artemis.io.DatabaseDocumentEntry",
      "uk.ac.sanger.artemis.io.GFFEntryInformation",
      "uk.ac.sanger.artemis.SSAHAComparisonData",
      "uk.ac.sanger.artemis.io.PartialSequence",
      "org.apache.batik.gvt.text.GVTAttributedCharacterIterator$TextAttribute",
      "uk.ac.sanger.artemis.sequence.SequenceChangeEvent",
      "uk.ac.sanger.artemis.io.EntryInformationException",
      "uk.ac.sanger.artemis.GotoEvent",
      "uk.ac.sanger.artemis.sequence.MarkerRange",
      "uk.ac.sanger.artemis.ComparisonDataParseException",
      "uk.ac.sanger.artemis.components.ComboBoxRenderer",
      "uk.ac.sanger.artemis.io.BioJavaSequence",
      "uk.ac.sanger.artemis.FeatureKeyPredicate",
      "uk.ac.sanger.artemis.BlastM8ComparisonData",
      "uk.ac.sanger.artemis.io.GFFStreamFeature",
      "uk.ac.sanger.artemis.io.ReadFormatException",
      "uk.ac.sanger.artemis.MSPcrunchComparisonData",
      "uk.ac.sanger.artemis.util.StringVector$1",
      "uk.ac.sanger.artemis.io.LocationParseException"
    );
  }
}
