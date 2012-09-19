package com.sinosoft.one.rms.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Assert;

import com.sinosoft.one.rms.clientService.User;
import com.sinosoft.one.rms.clientService.facade.RmsClientService;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext-test.xml","/spring/applicationContext-shiro.xml"
		,"/spring/applicationContext-rms.xml"})
public class TestDataRuleStringCreat {

	@Autowired
	private TestService	testService;
	@Autowired
	private RmsClientService rmsClientService;
	@Test
	public void testCreatSQl(){
		User user= rmsClientService.login("admin", "00");
		EnvContext.setLoginInfo(user);
//		Assert.assertEquals(testService.findBySql().size(),477);//自写SQL方式
//		Assert.assertEquals(testService.findUser().size(),477);//arch4 queryRule 方式
//		Assert.assertEquals(testService.findUser(1, 10).getResult().size(),477);//arch4 queryRule 分页
		Assert.assertEquals(testService.findbyHql(1, 10).getResult().size(),1);
	}

}
