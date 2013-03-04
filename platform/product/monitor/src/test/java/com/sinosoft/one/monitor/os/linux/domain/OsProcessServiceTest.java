package com.sinosoft.one.monitor.os.linux.domain;

import java.util.Calendar;
import java.util.Date;

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
	public void test(){
		Calendar c  = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, new Date().getDate());
		
		//取当天的前24小时整时点
		Date zeroTime= c.getTime();
		System.out.println(zeroTime);
		c.set(Calendar.HOUR_OF_DAY,-24);
		Date zeroTime2= c.getTime();
		System.out.println(zeroTime2);
	}
}
