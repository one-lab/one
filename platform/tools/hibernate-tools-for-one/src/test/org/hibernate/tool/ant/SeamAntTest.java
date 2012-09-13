/*
 * Created on 13-Feb-2005
 *
 */
package org.hibernate.tool.ant;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.hibernate.tool.test.TestHelper;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * A temporary test class for controlling the seam template generation
 * via an antfile.
 * 
 * @author max
 *
 */
public class SeamAntTest extends BuildFileTestCase {
	
	public SeamAntTest(String name) {
		super(name);
	}
	
	
	protected void tearDown() throws Exception {
		System.out.println(getLog() );
		super.tearDown();
	}
	
	
	protected void setUp() throws Exception {
		//HibernateUberspect.initMethodNotFoundCount(); // enable some tracing of velocity errors
		configureProject("src/testsupport/seamtest-build.xml");
	}
	
	public void testCrudGeneration() {
		executeTarget("generate-crud");
		File baseDir = new File(project.getProperty("destdir"));
		
		assertFileAndExists(new File(baseDir, "build.xml"));
		assertFileAndExists(new File(baseDir, "resources/seam.properties"));
		assertFileAndExists(new File(baseDir, "resources/WEB-INF/components.xml"));
		
		validXMLFile( new File(baseDir, "resources/WEB-INF/web.xml") );
		
		validXMLFile( new File(baseDir, "resources/WEB-INF/faces-config.xml") );
		
		validXMLFile( new File(baseDir, "resources/META-INF/application.xml") );
		
		validXMLFile( new File(baseDir, "resources/META-INF/jboss-app.xml") ); 
		
		// cannot check for valid xml since the jsp's has <%@ in the top 
		validFile( new File(baseDir, "resources/jsp/editIssue.jsp") );
		validFile( new File(baseDir, "resources/jsp/findIssue.jsp") );
		
		validFile(new File(baseDir, "src/org/jboss/seam/example/crud/Issue.java"));
		
		validFile(new File(baseDir, "src/org/jboss/seam/example/crud/IssueFinder.java"));
		validFile(new File(baseDir, "src/org/jboss/seam/example/crud/IssueFinderBean.java"));
		
		validFile(new File(baseDir, "src/org/jboss/seam/example/crud/IssueEditor.java"));
		validFile(new File(baseDir, "src/org/jboss/seam/example/crud/IssueEditorBean.java"));
		
		File srcDir = new File(baseDir, "src");
		List files = TestHelper.visitAllFiles(srcDir, new ArrayList());
		List jars = new ArrayList();
		jars.add("ejb3-persistence.jar");
		jars.add("jboss-ejb3x.jar");
		jars.add("jboss-annotations-ejb3.jar");
		jars.add("hibernate-annotations.jar");
		jars.add("jboss-seam.jar");
		jars.add("myfaces-api.jar");
		
		TestHelper.compile( srcDir, new File(baseDir, "classes"), files, "1.5", TestHelper.buildClasspath(jars));
	}


	private void validXMLFile(File xmlfile) {
		validFile( xmlfile );
		assertParse(xmlfile);		
	}


	private void validFile(File xmlfile) {
		assertFileAndExists(xmlfile);
		assertEquals( "$ found in " + xmlfile, null, TestHelper.findFirstString( "$", xmlfile ));
	}

	
	public static Test suite() {
		return new TestSuite(SeamAntTest.class);
	}

	/** parse the url, fails if not valid xml. Does not validate against the DTD because they are remote */
	public Document assertParse(File url) {
        SAXReader reader = new SAXReader();
        reader.setValidation(false);
        Document document = null;
        try {
			document = reader.read(url);
		}
		catch (DocumentException e) {
			fail("Could not parse " + url + ":" + e); 
		}
		assertNotNull(document);
        return document;
    }
		
}
