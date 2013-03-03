package com.sinosoft.one.monitor.os.linux.domain;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.sinosoft.one.monitor.os.linux.model.OsAvailabletemp;
import com.sinosoft.one.monitor.os.linux.util.OsUtil;
@DirtiesContext
@ContextConfiguration(locations = {"/spring/applicationContext-test.xml"})
public class OsDataMathServiceTest extends AbstractJUnit4SpringContextTests{
	
	@Autowired
	private OsDataMathService osDataMathService;
	@Test
	public void statiTodyAvailable(){
		
		SimpleDateFormat simpleDateFormat1=new SimpleDateFormat(OsUtil.DATEFORMATE_DAY);
		Calendar c  = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, new Integer(simpleDateFormat1.format(new Date()))-1);
		c.set(Calendar.HOUR_OF_DAY,20);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		Date currentTime=c.getTime();
		System.out.println(currentTime);
		Calendar c2  = Calendar.getInstance();
		c2.set(Calendar.DAY_OF_MONTH, new Integer(simpleDateFormat1.format(new Date()))-2);
		c2.set(Calendar.HOUR_OF_DAY,0);
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.SECOND, 0);
		Date targetTime=c2.getTime();
		System.out.println(targetTime);
		osDataMathService.statiAvailable("402892163d208194013d208198790000", currentTime, targetTime, 5, currentTime);
	}
	@Test
	public void testMath(){
		System.out.println(BigDecimal.valueOf(17323223).divide(BigDecimal.valueOf(201231223),4,BigDecimal.ROUND_HALF_EVEN));
	}
}
