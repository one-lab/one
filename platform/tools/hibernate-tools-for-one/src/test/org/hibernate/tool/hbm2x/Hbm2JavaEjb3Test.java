/*
 * Created on 2004-12-01
 *
 */
package org.hibernate.tool.hbm2x;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Property;
import org.hibernate.tool.NonReflectiveTestCase;
import org.hibernate.tool.hbm2x.pojo.POJOClass;
import org.hibernate.tool.test.TestHelper;

/**
 * @author max
 *
 */
public class Hbm2JavaEjb3Test extends NonReflectiveTestCase {

	public Hbm2JavaEjb3Test(String name) {
		super( name, "hbm2javaejb3output" );
	}

	protected void setUp() throws Exception {
		super.setUp();

		POJOExporter exporter = new POJOExporter(getCfg(), getOutputDir() );
		exporter.setTemplatePath(new String[0]);
		exporter.getProperties().setProperty("ejb3", "true");
		exporter.getProperties().setProperty("jdk5", "true");

		exporter.start();
	}

	public void testFileExistence() {
		assertFileAndExists( new File(getOutputDir().getAbsolutePath() + "/org/hibernate/tool/hbm2x/Author.java") );
		assertFileAndExists( new File(getOutputDir().getAbsolutePath() + "/org/hibernate/tool/hbm2x/Article.java") );
		assertFileAndExists( new File(getOutputDir().getAbsolutePath() + "/org/hibernate/tool/hbm2x/Train.java") );
		assertFileAndExists( new File(getOutputDir().getAbsolutePath() + "/org/hibernate/tool/hbm2x/Passenger.java") );
		assertFileAndExists( new File(getOutputDir().getAbsolutePath() + "/org/hibernate/tool/hbm2x/TransportationPK.java") );
//		assertFileAndExists( new File(getOutputDir().getAbsolutePath() + "/org/hibernate/tool/hbm2x/GenericObject.java") );
//		assertFileAndExists( new File(getOutputDir().getAbsolutePath() + "/org/hibernate/tool/hbm2x/GenericValue.java") );
	}

	public void testBasicComponent() {
		assertEquals( "@Embeddable", findFirstString( "@Embeddable", new File( getOutputDir(),
		"org/hibernate/tool/hbm2x/TransportationPK.java" ) ) );
		
	//	assertEquals( null, findFirstString( "@Column", new File( getOutputDir(),
		//"org/hibernate/tool/hbm2x/TransportationPK.java" ) ) );

	}

	public void testCompile() {

		File file = new File("ejb3compilable");
		file.mkdir();

		ArrayList list = new ArrayList();
		List jars = new ArrayList();
		jars.add("ejb3-persistence.jar");
		jars.add("hibernate-annotations.jar");
		TestHelper.compile(getOutputDir(), file, TestHelper.visitAllFiles(getOutputDir(), list), "1.5", TestHelper.buildClasspath(jars));

		TestHelper.deleteDir(file);
	}

	public void testEqualsHashCode() {
		PersistentClass classMapping = getCfg().getClassMapping("org.hibernate.tool.hbm2x.Passenger");
		POJOClass clazz = new Cfg2JavaTool().getPOJOClass(classMapping);
		
		assertFalse(clazz.needsEqualsHashCode());
		
		classMapping = getCfg().getClassMapping("org.hibernate.tool.hbm2x.Article");
		clazz = new Cfg2JavaTool().getPOJOClass(classMapping);
		
		assertTrue(clazz.needsEqualsHashCode());
		
	}
	
	
	public void testFieldInitializationAndTypeNames() {
		PersistentClass classMapping = getCfg().getClassMapping("org.hibernate.tool.hbm2x.Article");
		Cfg2JavaTool cfg2java = new Cfg2JavaTool();
		POJOClass clazz = cfg2java.getPOJOClass(classMapping);
		
		Property p = classMapping.getProperty("AMap");
		
		assertEquals("all types should be fully qualified when no importcontext","java.util.Map<java.lang.String,org.hibernate.tool.hbm2x.Article>",cfg2java.getJavaTypeName(p, true));
		assertEquals("Map<String,Article>",cfg2java.getJavaTypeName(p, true, clazz));		
		assertEquals("new HashMap<String,Article>(0)", clazz.getFieldInitialization(p, true));
		assertEquals("new HashMap(0)", clazz.getFieldInitialization(p, false));
	
		p = classMapping.getProperty("aList");
		
		assertEquals("lists should not have the index visible in the declaration", "List<Article>",cfg2java.getJavaTypeName(p, true, clazz));
		assertEquals("all types should be fully qualified when no importcontext","java.util.List<org.hibernate.tool.hbm2x.Article>",cfg2java.getJavaTypeName(p, true));
		
		assertEquals("new ArrayList<Article>(0)", clazz.getFieldInitialization(p, true));
		assertEquals("new ArrayList(0)", clazz.getFieldInitialization(p, false));
		
		p = classMapping.getProperty("content");
		assertEquals("\"what can I say\"",clazz.getFieldInitialization(p, false));
		
		p = classMapping.getProperty("bagarticles");
		
		assertEquals("Should be a list via property-type", "java.util.List", cfg2java.getJavaTypeName( p, false ));
		assertEquals("Should be a a generic'd list when generics=true", "java.util.List<org.hibernate.tool.hbm2x.Article>", cfg2java.getJavaTypeName( p, true ));
		assertEquals("List<Article>",cfg2java.getJavaTypeName(p, true, clazz));		
		assertEquals("new ArrayList<Article>(0)", clazz.getFieldInitialization(p, true));
		assertEquals("new ArrayList(0)", clazz.getFieldInitialization(p, false));
	

	}
	
	
	protected String getBaseForMappings() {
		return "org/hibernate/tool/hbm2x/";
	}

	protected String[] getMappings() {
		return new String[] {
				"Author.hbm.xml",
				"Article.hbm.xml",
				"Train.hbm.xml",
				"Passenger.hbm.xml"
//				"GenericModel.hbm.xml",
//				"Customer.hbm.xml",
//				"Order.hbm.xml",
//				"LineItem.hbm.xml",
//				"Product.hbm.xml"
		};
	}

}
