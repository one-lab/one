package com.sinosoft.one.service.spring;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ins.framework.common.Page;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.sinosoft.one.rms.model.Group;
import com.sinosoft.one.rms.service.facade.GroupService;


@DirtiesContext
@ContextConfiguration(locations = { "/spring/applicationContext-rmstest.xml",
        "/spring/applicationContext-rms.xml" })
@TransactionConfiguration(transactionManager = "defaultTransactionManager",defaultRollback=false)
public class GroupServiceSpringImplTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private GroupService groupService;
	
	@Test
	public void test(){
		//引入的
		Page page=groupService.findEmployeByGroup("8b80c75836ba30800136ba31efb20011", "00", "admin", "admin", 1, 10);
		Assert.assertNotNull(page.getResult());
		Assert.assertTrue( page.getResult() instanceof List );
		groupService.saveGroup("admin", "00", "测试", "测试", Arrays.asList("8b80c758366bb77501366bb000000001"));
		page=groupService.findGroup("测试", "00", 1, 10);
		Assert.assertNotNull(page.getResult());
		Assert.assertTrue( page.getResult() instanceof List );
		for (Object object : page.getResult()) {
			Group group=(Group)object;
			Assert.assertTrue(group.getGroupID() instanceof String);
			groupService.deleteGroup(group.getGroupID());
		}
		page=groupService.findNEmployeByGroup("8b80c75836ba30800136ba31efb20011", "00", "admin", "admin", 1, 10);
		Assert.assertNotNull(page.getResult());
		Assert.assertTrue( page.getResult() instanceof List );
		//为引入的
//		System.out.println(groupService.findNEmployeByGroup("8b80c75836ba30800136ba31efb20011", "00", "", "", 1, 10).getResult().size());
		
	}
}
