package com.sinosoft.one.rms.client;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@DirtiesContext
@ContextConfiguration(locations = { "/spring/applicationContext-test.xml",
        "/spring/applicationContext-shiro.xml","/spring/applicationContext-rms.xml" })
public class WebServiceTest extends AbstractJUnit4SpringContextTests{
	
	@Autowired
	private AccountManager accountManager;
	@Test
	public void testWebServiceLogin(){
//		wsAccountManager.findUserByLoginNameWs("admin", "00", "RMS");
	}
	 
}
