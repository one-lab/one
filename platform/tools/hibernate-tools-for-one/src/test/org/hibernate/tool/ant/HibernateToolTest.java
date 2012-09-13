/*
 * Created on 13-Feb-2005
 *
 */
package org.hibernate.tool.ant;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.hibernate.tool.test.TestHelper;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author max
 *
 */
public class HibernateToolTest extends BuildFileTestCase {

	private String property;
	
	public HibernateToolTest(String name) {
		super(name);
	}
	
	protected void tearDown() throws Exception {
		executeTarget("cleanup");
		System.out.println(getLog());
		super.tearDown();
	}
	protected void setUp() throws Exception {
		configureProject("src/testsupport/anttest-build.xml");
	}
	
	public void testHbm2DDLLogic() {
		executeTarget("testantcfg");
		File baseDir = new File(project.getProperty("build.dir"), "topdown");
		File onlyCreate = new File(baseDir, "onlycreate.sql");
		File onlyDrop = new File(baseDir, "onlydrop.sql");
		File dropAndCreate = new File(baseDir, "dropandcreate.sql");
		
		assertTrue(onlyCreate.exists());
		assertTrue(onlyDrop.exists());
		assertTrue(dropAndCreate.exists());
		
		assertNotNull(TestHelper.findFirstString("drop", dropAndCreate));
		assertNotNull(TestHelper.findFirstString("create", dropAndCreate));
		
		assertEquals(null, TestHelper.findFirstString("create", onlyDrop));
		assertNotNull(TestHelper.findFirstString("drop", onlyDrop));
		
		assertEquals(null, TestHelper.findFirstString("drop", onlyCreate));
		assertNotNull(TestHelper.findFirstString("create", onlyCreate));		
		
	}

	public void testJDBCConfiguration() {
		executeTarget("testantjdbccfg");
	}
	
	public void testAnnotationConfigurationFailureExpected() {
		executeTarget("testantannotationcfg");
	}
	
	public void testEJB3ConfigurationFailureExpected() {
		executeTarget("testantejb3cfg");
		File baseDir = new File(project.getProperty("build.dir"));
		File ejb3 = new File(baseDir, "ejb3.sql");
		
		assertTrue(ejb3.exists());
		assertEquals(null, TestHelper.findFirstString("drop", ejb3));
		
		assertTrue(getLog().indexOf("<ejb3configuration> is deprecated")>0);
		
	}
	
	public void testJPABogusPUnit() {
		try {
			executeTarget("jpa-bogusunit");
			fail("Bogus unit accepted");
		} catch(BuildException be) {
			// should happen
		}
	}
	
	public void testJPAPUnit() {
		executeTarget("jpa-punit");		
	}
	
	public void testHbm2JavaConfiguration() {
		executeTarget("testanthbm2java");
	}
	
	public void testHbm2JavaEJB3Configuration() {
		executeTarget("testantejb3hbm2java");
	}
	
    public void testCfg2HbmNoError() {
        executeTarget("testantcfg2hbm1");
    }
    
    public void testCfg2HbmWithCustomReverseNamingStrategy() {
        executeTarget("testantcfg2hbm2");
    }
    
    public void testCfg2HbmWithInvalidReverseNamingStrategy() {
        expectSpecificBuildException("testantcfg2hbm3", 
                "namingStrategy attribute should not be loaded", 
                "Could not create or find invalid.classname with one argument delegate constructor");
    }
    
    public void testCfg2HbmWithPackageName() {
        executeTarget("testantcfg2hbm4");
    }
    
    public void testCfg2HbmWithPackageNameAndReverseNamingStrategy() {
        executeTarget("testantcfg2hbm5");
    }
    
  
	public void testJDBCConfigWithRevEngXml() {
		executeTarget("testantjdbccfgoverrides");
	}
	
	public void testProperties() {
		executeTarget("testproperties");		
	}
	
	public void testGenericExport() {
		executeTarget("testgeneric");
		
		property = project.getProperty("build.dir");
		assertTrue(new File(property, "generic").exists());
		assertTrue(new File(property, "generic/org/hibernate/tool/hbm2x/ant/TopDown.quote").exists());
	}
	
	public void testNoConnInfoExport() {
		executeTarget("noconinfoexport");
		File baseDir = new File(project.getProperty("build.dir"), "noconinfo");
		File onlyCreate = new File(baseDir, "noconinfo.sql");
		
		assertTrue(onlyCreate.toString() + " should exist", onlyCreate.exists());
		
		assertTrue(onlyCreate.length()>0);
		
		assertNotNull(TestHelper.findFirstString("create", onlyCreate));
		
		
	}

	public void testNoExporters() {
		try {
		executeTarget("testnoexporters");
		fail("should have failed with no exporters!");
		} catch(BuildException be) {
			// should happen!
			assertTrue(be.getMessage().indexOf("No exporters specified")>=0);
		}
		
	}
	
	public void testException() {
		try {
		executeTarget("testexceptions");
		fail("should have failed with an exception!");
		} catch(BuildException be) {
			// should happen!			
		}
	}

	public void testQuery() {
		executeTarget("testquery");
		
		File baseDir = new File(project.getProperty("build.dir"), "querytest");
		
		assertTrue(new File(baseDir, "queryresult.txt").exists());
		
	}
	
	public void testHbmLint() {
		executeTarget("testhbmlint");
		
		File baseDir = new File(project.getProperty("build.dir"), "linttest");
		
		assertTrue(new File(baseDir, "hbmlint-result.txt").exists());
		
	}
	
	public void testNoConfig() {
		try {
			executeTarget("noconfig-shoulderror");
		} catch(BuildException e) {
			assertTrue(e.getMessage().indexOf("No configuration specified")>=0);
		}
		
	}
	public static Test suite() {
		return new TestSuite(HibernateToolTest.class);
	}

	
}
