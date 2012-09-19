package com.sinosoft.one.service.spring;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.sinosoft.ebusiness.util.test.SpringTxTestCase;
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
		List<String> comCodes =new ArrayList<String>();
		comCodes.add("11");
		List<String> tasks =new ArrayList<String>();
//		roleService.updataRoleByIDAndType("402892163951996e0139519e1dc50016", comCodes, "00", "admin", tasks, "测试", "", "all");
	}
}
