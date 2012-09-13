package org.hibernate.tool.hbm2x.hbm2hbmxml;

import junit.framework.Test;
import junit.framework.TestSuite;

public class Cfg2HbmAllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite( "Test for org.hibernate.tool.cfg2hbm" );
		//$JUnit-BEGIN$
		suite.addTest( ManyToManyTest.suite() );
		suite.addTest( Hbm2HbmXmlTest.suite() );
		suite.addTest( InheritanceTest.suite() );
		//$JUnit-END$
		return suite;
	}

}
