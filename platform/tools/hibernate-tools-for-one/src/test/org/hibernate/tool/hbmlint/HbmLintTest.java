package org.hibernate.tool.hbmlint;

import java.util.List;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.JDBCMetaDataBinderTestCase;
import org.hibernate.tool.hbm2x.HbmLintExporter;
import org.hibernate.tool.hbmlint.detector.BadCachingDetector;
import org.hibernate.tool.hbmlint.detector.InstrumentationDetector;
import org.hibernate.tool.hbmlint.detector.ShadowedIdentifierDetector;

public class HbmLintTest extends JDBCMetaDataBinderTestCase {

	public HbmLintTest() {
		super();
	}

	protected String[] getMappings() {
		return new String[] { "hbmlint/CachingSettings.hbm.xml", "hbmlint/IdentifierIssues.hbm.xml", "hbmlint/BrokenLazy.hbm.xml" };
	}
	
	public void testExporter() {
	
		Configuration cfg = new Configuration();
		addMappings( getMappings(), cfg );
		cfg.buildMappings();
	
		new HbmLintExporter(cfg, getOutputDir()).start();
		
	}
	public void testValidateCache() {
		
		Configuration cfg = new Configuration();
		addMappings( getMappings(), cfg );
		cfg.buildMappings();
		
		HbmLint analyzer = new HbmLint(new Detector[] { new BadCachingDetector() });
		
		analyzer.analyze(cfg);
		
		List result = analyzer.getResults();
		
		assertEquals(1,result.size());

		System.out.println(result);
		
	}

	public void testValidateIdentifier() {
		
		Configuration cfg = new Configuration();
		addMappings( getMappings(), cfg );
		cfg.buildMappings();
		
		HbmLint analyzer = new HbmLint(new Detector[] { new ShadowedIdentifierDetector() });
		
		analyzer.analyze(cfg);
		
		List result = analyzer.getResults();
		
		assertEquals(1,result.size());

		System.out.println(result);
		
	}
	
	public void testBytecodeRestrictions() {
		
		Configuration cfg = new Configuration();
		addMappings( getMappings(), cfg );
		cfg.buildMappings();
		
		HbmLint analyzer = new HbmLint(new Detector[] { new InstrumentationDetector() });
		
		analyzer.analyze(cfg);
		
		List result = analyzer.getResults();
		
		assertEquals(2,result.size());

		System.out.println(result);
		
	}
	
	protected String[] getCreateSQL() {
		return new String[0];// { "create table Category (id numeric(5), parent_id numeric(5))" };
	}

	protected String[] getDropSQL() {
		return new String[0];// { "drop table Category" };
	}
	
	
}
