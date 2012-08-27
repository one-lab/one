package com.sinosoft.one.service.spring;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

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
		System.out.println(groupService.findEmployeByGroup("8b80c75836ba30800136ba31efb20011", "00", "admin", "admin", 1, 10).getResult().size());
		//为引入的
		System.out.println(groupService.findNEmployeByGroup("8b80c75836ba30800136ba31efb20011", "00", "", "", 1, 10).getResult().size());
		
	}
}
