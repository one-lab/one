package com.sinosoft.one.monitor.os.linux.domain;
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
public class OsAvailableServiceTest extends AbstractJUnit4SpringContextTests  {
	
	@Autowired
	private OsAvailableServcie osAvailableServcie;
	
	@Test
	public void getAvailableTemps(){
		List<OsAvailabletemp>osAvailabletemps=osAvailableServcie.getAvailableTemps("402892163d208194013d208198790000", "2013-03-01 11:00:00","2013-03-01 19:00:00",OsUtil.ORCL_DATEFORMATE);
		for (OsAvailabletemp osAvailabletemp : osAvailabletemps) {
			System.out.println(osAvailabletemp.getSampleDate());
		}
	}
	@Test
	public void getLastAvailable(){
		System.out.println(osAvailableServcie.getLastAvailable("402892163d208194013d208198790000", "2013-03-01 21:00:00"));
	}
	
	
	@Test
	public void getFFHourAvailale(){
		List<OsAvailabletemp> osAvailabletemps=osAvailableServcie.getFFHourAvailale("402892163d208194013d208198790000",new Date());
		for (OsAvailabletemp osAvailabletemp : osAvailabletemps) {
			System.out.println(osAvailabletemp.getStatus());
		}
	}
}
