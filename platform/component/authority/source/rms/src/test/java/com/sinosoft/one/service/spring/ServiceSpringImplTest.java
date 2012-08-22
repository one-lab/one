package com.sinosoft.one.service.spring;
//package com.sinosoft.ebusiness.rms.service.spring;
//
//import ins.framework.common.Page;
//import ins.framework.common.QueryRule;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import org.hibernate.Query;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.transaction.TransactionConfiguration;
//
//import sun.security.provider.MD5;
//
//import com.sinosoft.ebusiness.rms.model.Role;
//import com.sinosoft.ebusiness.rms.model.RoleDesignate;
//import com.sinosoft.ebusiness.rms.model.Task;
//import com.sinosoft.ebusiness.rms.model.UserPower;
//import com.sinosoft.ebusiness.rms.service.facade.RmsService;
//import com.sinosoft.ebusiness.rms.service.facade.RoleService;
//import com.sinosoft.ebusiness.rms.service.facade.TaskService;
//import com.sinosoft.ebusiness.util.test.SpringTxTestCase;
//
//
//@DirtiesContext
//@ContextConfiguration(locations = { "/spring/applicationContext-test.xml",
//        "/spring/applicationContext-rms.xml" })
//@TransactionConfiguration(transactionManager = "defaultTransactionManager",defaultRollback=false)
//public class ServiceSpringImplTest extends SpringTxTestCase {
//
//	@Autowired
//	private TaskServiceSpringImpl taskService;
//	@Autowired
//	private RoleServiceSpringImpl roleService;
//	@Test
//	public void testFindTaskByUser(){
////		List<String> ids= new ArrayList<String>();
////		ids.add("001");
////		ids.add("002");	
////		roleService.addRole( "002", "001",ids , "333", "22");
////		
////		QueryRule queryRule = QueryRule.getInstance();
////		queryRule.addEqual("id.comCode", "002");
////		RoleDesignate roleDesignate=roleService.findUnique(RoleDesignate.class, queryRule);
////		System.out.println(roleDesignate.getRole().getRoleID());
////		Page page =roleService.findRole("002", "", 1, 1);
////		List<RoleDesignate> roleDesignates=page.getResult();
////		System.out.println(roleDesignates.get(0).getRole().getRoleID());
//		List<String> roleIDs= new ArrayList<String>();
//		roleIDs.add("8b80c758360fce8401360fcf6b2e0001");
//		List<String> comCodes= new ArrayList<String>();
//		comCodes.add("002");
//		roleService.roleDesignate(roleIDs, comCodes, "01");
//	}
//	@Test
//	public void testdelete(){
//		roleService.deleteRole("8b80c758360f1b3201360f1c00c30001","002");
//	}
//}
