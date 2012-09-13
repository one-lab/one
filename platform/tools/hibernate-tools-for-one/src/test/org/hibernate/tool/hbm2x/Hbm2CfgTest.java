/*
 * Created on 2004-12-01
 *
 */
package org.hibernate.tool.hbm2x;

import java.io.File;

import org.hibernate.tool.NonReflectiveTestCase;

/**
 * @author max
 *
 */
public class Hbm2CfgTest extends NonReflectiveTestCase {

	private HibernateConfigurationExporter cfgexporter;

	public Hbm2CfgTest(String name) {
		super( name, "cfg2cfgxmloutput" );
	}

	protected void setUp() throws Exception {
		super.setUp();
		
		cfgexporter = new HibernateConfigurationExporter(getCfg(), getOutputDir() );
		cfgexporter.start();
	}
	

	public void testFileExistence() {
		
		assertFileAndExists(new File(getOutputDir(), "hibernate.cfg.xml") );
		
	}

	public void testArtifactCollection() {
		assertEquals(1,cfgexporter.getArtifactCollector().getFileCount("cfg.xml"));
	}
	
	public void testNoVelocityLeftOvers() {
		
        assertEquals(null,findFirstString("$",new File(getOutputDir(), "hibernate.cfg.xml") ) );
        
	}

	protected String getBaseForMappings() {
		return "org/hibernate/tool/hbm2x/";
	}
	
	protected String[] getMappings() {
		return new String[] { 
				"Customer.hbm.xml",
				"Order.hbm.xml",
				"LineItem.hbm.xml",
				"Product.hbm.xml",
				"HelloWorld.hbm.xml"
		};
	}
	
}
