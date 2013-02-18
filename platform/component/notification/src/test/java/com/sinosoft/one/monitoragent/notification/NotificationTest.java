package com.sinosoft.one.monitoragent.notification;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@DirtiesContext
@ContextConfiguration(locations = { "/spring/applicationContext-monitorAgent-test.xml" })
public class NotificationTest extends AbstractJUnit4SpringContextTests{
	@Autowired
	NotificationService notificationService;
	
	@Test
	public void testInitMethod(){
		notificationService.getMethodInitConfigure();
	}
}
