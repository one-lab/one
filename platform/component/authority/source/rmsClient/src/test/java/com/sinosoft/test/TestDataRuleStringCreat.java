package com.sinosoft.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sinosoft.one.rms.User;
import com.sinosoft.one.rms.client.EnvContext;
import com.sinosoft.one.rms.facade.RmsClientService;


@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext-test.xml","classpath*:spring/applicationContext-rms.xml" })
public class TestDataRuleStringCreat extends AbstractJUnit4SpringContextTests{

	@Autowired
	private TestService	testService;
	@Autowired
	private RmsClientService rmsClientService;
	@Test
	public void testFindBySql(){
		User user= rmsClientService.login("admin", "00","RMS");
		EnvContext.setLogin(user);
		testService.testFindBySql();
		
	}
	@Test
	public void testGetAll(){
		User user= rmsClientService.login("admin", "00","RMS");
		EnvContext.setLogin(user);
		testService.testGetAll();
		
	}
	
	@Test
	public void testFindByHql(){
		User user= rmsClientService.login("admin", "00","RMS");
		EnvContext.setLogin(user);
		testService.testFindByHql();
		
	}
}
