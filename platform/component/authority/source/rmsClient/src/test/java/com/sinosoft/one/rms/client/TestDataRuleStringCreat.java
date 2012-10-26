package com.sinosoft.one.rms.client;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sinosoft.one.rms.client.EnvContext;
import com.sinosoft.one.rms.clientService.User;
import com.sinosoft.one.rms.clientService.facade.RmsClientService;


@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext-test.xml","classpath*:/spring/applicationContext-rms.xml"})
public class TestDataRuleStringCreat extends AbstractJUnit4SpringContextTests{

	@Autowired
	private TestService	testService;
	
	@Autowired
	private RmsClientService rmsClientService;
	@Test
	public void test(){
		User user= rmsClientService.login("admin", "00","RMS");
		EnvContext.setLoginInfo(user);
		testService.testFindByHql();
//		EnvContext.setDataAuthorityTaskId("aaa");
//		EnvContext.setDataAuthorityTaskId("bbb");
//		System.out.println(EnvContext.getDataAuthorityTaskId());
//		System.out.println(EnvContext.getDataAuthorityTaskId());
//		LinkedList s=new LinkedList ();
//		s.add("a");
//		s.add("b");
//		System.out.println(s.listIterator().next());
//		System.out.println(s.listIterator().n);
		System.out.println();
	}
	void test2(){
		System.out.println("doits_____________________________");
	}
	
}
