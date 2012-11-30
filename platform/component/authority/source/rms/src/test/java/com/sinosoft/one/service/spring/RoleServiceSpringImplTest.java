package com.sinosoft.one.service.spring;

import ins.framework.common.Page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.sinosoft.one.rms.model.Group;
import com.sinosoft.one.rms.model.Role;
import com.sinosoft.one.rms.service.facade.RoleService;

@DirtiesContext
@ContextConfiguration(locations = { "/spring/applicationContext-rmstest.xml",
        "/spring/applicationContext-rms.xml" })
@TransactionConfiguration(transactionManager = "defaultTransactionManager",defaultRollback=false)
public class RoleServiceSpringImplTest extends AbstractJUnit4SpringContextTests{
	@Autowired
	private RoleService roleService;
	
	@Test
	public void test(){
		roleService.addRoleByType("00", "admin", Arrays.asList("RMS001"), "测试", "测试", "default");
		Page page=roleService.findRole("00", "测试", 1, 10	);
		Assert.assertNotNull(page.getResult());
		Assert.assertTrue( page.getResult() instanceof List );
		for (Object object : page.getResult()) {
			Role role=(Role)object;
			Assert.assertTrue(role.getRoleID() instanceof String);
			roleService.deleteRole(role.getRoleID(), "00");
		}
	}
}
