package com.sinosoft.one.monitor.os.linux.domain;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
@DirtiesContext
@ContextConfiguration(locations = {"/spring/applicationContext-test.xml"})
public class OsProcessServiceTest extends AbstractJUnit4SpringContextTests{
	@Autowired
	private OsProcessService osProcessService;
	
	@Test
	public void getLastAvailableTime(){
		System.out.println(osProcessService.getLastSampleTime("402892163d208194013d208198790000", "2013-03-01 21:00:00"));
	}
}
