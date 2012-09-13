package org.hibernate.tool.hbm2x;

import java.io.File;
import java.util.Properties;

import org.hibernate.tool.NonReflectiveTestCase;

public class DocExporterTest extends NonReflectiveTestCase {

	public DocExporterTest(String name) {
		super( name, "docoutput" );
	}


	protected String[] getMappings() {
		return new String[] { 
				"Customer.hbm.xml",
				"Order.hbm.xml",
				"LineItem.hbm.xml",
				"Product.hbm.xml",
				"HelloWorld.hbm.xml",
				"UnionSubclass.hbm.xml"
		};
	}
	
	protected String getBaseForMappings() {
		return "org/hibernate/tool/hbm2x/";
	}
	protected void setUp() throws Exception {
		super.setUp();
		DocExporter exporter = new DocExporter(getCfg(), getOutputDir() );
		Properties properties = new Properties();
		properties.put("dot.executable", System.getProperties().getProperty("dot.executable","dot.exe"));
		exporter.setProperties( properties );
		exporter.start();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
    public void testExporter() {
    	
    	assertFileAndExists(new File(getOutputDir(), "header.html") );
    	assertFileAndExists(new File(getOutputDir(), "index.html") );
	 
    	assertFileAndExists(new File(getOutputDir(), "assets/doc-style.css") );
    	assertFileAndExists(new File(getOutputDir(), "assets/hibernate_logo.gif") );
    	
    	assertFileAndExists(new File(getOutputDir(), "tables/PUBLIC/summary.html") );
    	assertFileAndExists(new File(getOutputDir(), "tables/PUBLIC/Customer.html") );
    	assertFalse(new File(getOutputDir(), "tables/PUBLIC/UPerson.html").exists() );
    	assertFileAndExists(new File(getOutputDir(), "tables/PUBLIC/CROWN_USERS.html") );
    	
    	assertFileAndExists(new File(getOutputDir(), "entities/org/hibernate/tool/hbm2x/Customer.html") );
    	assertTrue(new File(getOutputDir(), "entities/org/hibernate/tool/hbm2x/UPerson.html").exists() );
    	assertFileAndExists(new File(getOutputDir(), "entities/org/hibernate/tool/hbm2x/UUser.html") );
    	
    	assertFileAndExists(new File(getOutputDir(), "entities/entitygraph.dot"));
    	assertFileAndExists(new File(getOutputDir(), "entities/entitygraph.png"));
    	
    	assertFileAndExists(new File(getOutputDir(), "tables/tablegraph.dot"));
    	assertFileAndExists(new File(getOutputDir(), "tables/tablegraph.png"));
    	
				
	}
    
    public void testCommentIncluded() {
    	//A unique customer comment!
    	File tableFile = new File(getOutputDir(), "tables/PUBLIC/Customer.html");
		assertFileAndExists(tableFile );
		
		assertNotNull(findFirstString("A unique customer comment!", tableFile));
    }

}
