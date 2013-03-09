package com.sinosoft.one.monitor.os.linux.domain;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.sinosoft.one.monitor.os.linux.model.OsAvailabletemp;


@DirtiesContext
@ContextConfiguration(locations = {"/spring/applicationContext-test.xml"})
public class OsAvailableServiceTest extends AbstractJUnit4SpringContextTests  {
	
	@Autowired
	private OsAvailableServcie osAvailableServcie;
	
	@Test
	public void getAvailableTemps(){
		Calendar c  = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 2);
		c.set(Calendar.HOUR_OF_DAY,20);
		c.set(Calendar.MINUTE, 30);
		c.set(Calendar.SECOND, 0);
		Date date=c.getTime();
		List<OsAvailabletemp>osAvailabletemps=osAvailableServcie.getAvailableTemps("402892163d208194013d208198790000", new Date(),date);
		for (OsAvailabletemp osAvailabletemp : osAvailabletemps) {
			System.out.println(osAvailabletemp.getSampleDate());
		}
	}
	@Test
	public void getLastAvailable(){
		System.out.println(osAvailableServcie.getLastAvailable("402892163d208194013d208198790000", new Date()));
	}
	
	
	@Test
	public void getFFHourAvailale(){
		List<OsAvailabletemp> osAvailabletemps=osAvailableServcie.getFFHourAvailale("402892163d208194013d208198790000",new Date());
		for (OsAvailabletemp osAvailabletemp : osAvailabletemps) {
			System.out.println(osAvailabletemp.getStatus());
		}
	}
	
	@Test
	public void deleteTempByLessThanTime(){
		Calendar c  = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 2);
		c.set(Calendar.HOUR_OF_DAY,20);
		c.set(Calendar.MINUTE, 30);
		c.set(Calendar.SECOND, 0);
		Date date=c.getTime();
		osAvailableServcie.deleteTempByLessThanTime("402892163d208194013d208198790000", date);
	}
	
	@Test
	public void groupByinterCycleTime(){
		Calendar c  = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY,0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		Date date=c.getTime();
//		List<AvailableDetail> availableDetails=osAvailableServcie.findGroupByInterCycleTime("402892163d208194013d208198790000", date);
		System.out.println(1);
	}
}
