package com.sinosoft.one.rms.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext-test.xml","/spring/applicationContext-shiro.xml",
		"/spring/applicationContext-rms.xml"
})
public class ShiroTest {
	@Autowired
	private AccountManager accountManager;
	
	@Test
	public void testShiroDbRealm(){
		accountManager.findUserByLoginName("admin", "00");
	}

}
