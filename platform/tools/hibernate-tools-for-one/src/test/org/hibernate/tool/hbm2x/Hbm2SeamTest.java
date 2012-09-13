/*
 * Created on 2004-12-01
 *
 */
package org.hibernate.tool.hbm2x;

import java.io.File;

import org.hibernate.tool.NonReflectiveTestCase;
import org.hibernate.tool.hbm2x.seam.SeamExporter;

/**
 * @author max
 *
 */
public class Hbm2SeamTest extends NonReflectiveTestCase {

	private ArtifactCollector artifactCollector;

	public Hbm2SeamTest(String name) {
		super( name, "hbm2seamoutput" );
	}

	protected void setUp() throws Exception {
		super.setUp();
		
		SeamExporter exporter = new SeamExporter(getCfg(), getOutputDir() );
		exporter.start();
		
		artifactCollector = exporter.getArtifactCollector();
		
	}
	
	
	public void testFileExistence() {
		assertFileAndExists(new File(getOutputDir(), "src/org/hibernate/tool/hbm2x/Article.java") );
		assertFileAndExists(new File(getOutputDir(), "src/org/hibernate/tool/hbm2x/Author.java") );
		assertFileAndExists(new File(getOutputDir(), "resources/jsp/editAuthor.jsp") );
		assertFileAndExists(new File(getOutputDir(), "build.xml") );		
	}
	
	public void testArtifactCollection() {
		assertEquals(12,artifactCollector.getFileCount("java"));
		assertEquals(1,artifactCollector.getFileCount("html"));
		assertEquals(4,artifactCollector.getFileCount("jsp"));
		assertEquals(7,artifactCollector.getFileCount("xml"));
		assertEquals(3,artifactCollector.getFileCount("properties"));
		assertEquals(1,artifactCollector.getFileCount("txt"));
		assertEquals(1,artifactCollector.getFileCount("css"));
		
		assertEquals(7,artifactCollector.getFileTypes().size());
	}
	
	protected String getBaseForMappings() {
		return "org/hibernate/tool/hbm2x/";
	}
	
	protected String[] getMappings() {
		return new String[] { 
				"Article.hbm.xml",
				"Author.hbm.xml"				
		};
	}

}
