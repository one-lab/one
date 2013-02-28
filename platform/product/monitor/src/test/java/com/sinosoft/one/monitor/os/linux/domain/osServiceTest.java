package com.sinosoft.one.monitor.os.linux.domain;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@DirtiesContext
@ContextConfiguration(locations = {"/spring/applicationContext-test.xml"})
public class osServiceTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private OsService osService;
	
	@Test
	public void saveOsBasic(){
		osService.saveOsBasic( "test", "linux", "192.168.18.217", "255.255.255.0", 5);
	}

}
