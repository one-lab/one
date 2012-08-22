package com.sinosoft.one.rms.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sinosoft.one.rms.client.webservice.Menu;
import com.sinosoft.one.rms.client.webservice.RmsClientService;
import com.sinosoft.one.rms.client.webservice.RmsClientServiceImplService;
import com.sinosoft.one.rms.client.webservice.User;


@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext-test.xml"})
public class WebServiceTest {
	
	@Test
	public void TestWebServerService(){
//		RmsClientService rmsServiceClient = new RmsClientServiceImplService().getRmsClientServiceImplPort();
//		User user =rmsServiceClient.login("admin", "00");
//		System.out.println(user.getUserCode());
//		user.setUserCode("asd");
//		System.out.println(user.getUserCode());
	}
	
	
}
