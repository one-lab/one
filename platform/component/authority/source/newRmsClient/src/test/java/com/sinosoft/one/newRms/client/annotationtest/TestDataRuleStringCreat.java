package com.sinosoft.one.newRms.client.annotationtest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sinosoft.one.ams.User;
import com.sinosoft.one.ams.facade.RmsClientService;
import com.sinosoft.one.newRms.client.EnvContext;



@ContextConfiguration(locations = { "/spring/applicationContext-test.xml"})
public class TestDataRuleStringCreat extends AbstractJUnit4SpringContextTests{

	@Autowired
	private TestService testService;
	@Autowired
	private RmsClientService rmsClientService;
	@Test
	public void testFindAll(){
		User user;
		try {
			user = rmsClientService.login("admin", "00","RMS");
			EnvContext.setLogin(user);
			testService.testFindAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
