package com.sinosoft.one.monitor.os.linux.domain;

import java.util.Date;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@DirtiesContext
@ContextConfiguration(locations = {"/spring/applicationContext-test.xml"})
public class OsViewDataHandleServiceTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private OsViewDataHandleService osViewDataHandleService;
	
	@Test
	public void getAvailableViewData(){
		 Map<String, Object> s=	osViewDataHandleService.getAvailableViewData(new Date(),5);
	}
}
