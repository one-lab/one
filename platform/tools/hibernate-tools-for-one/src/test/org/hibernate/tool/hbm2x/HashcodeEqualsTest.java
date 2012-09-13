/*
 * Created on 2004-12-01
 *
 */
package org.hibernate.tool.hbm2x;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.mapping.Component;
import org.hibernate.mapping.MetaAttribute;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Property;
import org.hibernate.mapping.RootClass;
import org.hibernate.mapping.SingleTableSubclass;
import org.hibernate.mapping.Value;
import org.hibernate.tool.NonReflectiveTestCase;
import org.hibernate.tool.hbm2x.pojo.BasicPOJOClass;
import org.hibernate.tool.hbm2x.pojo.ImportContext;
import org.hibernate.tool.hbm2x.pojo.ImportContextImpl;
import org.hibernate.tool.hbm2x.pojo.NoopImportContext;
import org.hibernate.tool.hbm2x.pojo.POJOClass;
import org.hibernate.tool.test.TestHelper;

/**
 * @author max
 * 
 */
public class HashcodeEqualsTest extends NonReflectiveTestCase {

	private ArtifactCollector artifactCollector;
	
	public HashcodeEqualsTest(String name) {
		super( name, "hashcodeequals" );
	}

	protected void setUp() throws Exception {
		super.setUp();

		Exporter exporter = new POJOExporter( getCfg(), getOutputDir() );
		artifactCollector = new ArtifactCollector();
		exporter.setArtifactCollector(artifactCollector);
		exporter.start();
	}

	
	public void testJDK5FailureExpectedOnJDK4() {
		
		POJOExporter exporter = new POJOExporter( getCfg(), getOutputDir() );
		exporter.getProperties().setProperty("jdk5", "true");

		artifactCollector = new ArtifactCollector();
		exporter.setArtifactCollector(artifactCollector);
		exporter.start();
		
		testFileExistence();
		testNoVelocityLeftOvers();
		testCompilable();
		
	}
	
	
	public void testFileExistence() {

		assertFileAndExists( new File( getOutputDir(),
				"org/hibernate/tool/hbm2x/HashEquals.java" ) );
		assertFileAndExists( new File( getOutputDir(),
		"org/hibernate/tool/hbm2x/Address.java" ) );

		assertEquals(2, artifactCollector.getFileCount("java"));
	}
	
	public void testCompilable() {

		File file = new File( "compilable" );
		file.mkdir();

		ArrayList list = new ArrayList();
		TestHelper.compile( getOutputDir(), file, TestHelper.visitAllFiles(
				getOutputDir(), list ) );

		TestHelper.deleteDir( file );
	}

	
	
	public void testNoVelocityLeftOvers() {

		assertEquals( null, findFirstString( "$", new File( getOutputDir(),
				"org/hibernate/tool/hbm2x/HashEquals.java" ) ) );
		assertEquals( null, findFirstString( "$", new File( getOutputDir(),
				"org/hibernate/tool/hbm2x/Address.java" ) ) );

	}

	protected String getBaseForMappings() {
		return "org/hibernate/tool/hbm2x/";
	}

	protected String[] getMappings() {
		return new String[] { "HashEquals.hbm.xml" };
	}	
	
}
