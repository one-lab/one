//package com.sinosoft.ebusiness.rms.service.spring;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.transaction.TransactionConfiguration;
//
//import com.sinosoft.ebusiness.util.test.SpringTxTestCase;
//
//@DirtiesContext
//@ContextConfiguration(locations = { "/spring/applicationContext-test.xml",
//        "/spring/applicationContext-rms.xml" })
//@TransactionConfiguration(transactionManager = "defaultTransactionManager",defaultRollback=false)
//public class RoleServiceSpringImplTest extends SpringTxTestCase{
//	@Autowired
//	private RoleServiceSpringImpl roleService;
//	
//	@Test
//	public void test(){
////		roleService.addRole(comCode, userCode, TaskIDs, roleName, des);
//		List<String> ids=new ArrayList<String>();
//		ids.add("8b80c758361592c20136159332be0004");
//		ids.add("8b80c758361593ab013615941f120004");
////		System.out.println(roleService.findRoleByGroup(ids).size());
////		List<String> taskids=new ArrayList<String>();
////		taskids.add("004");
////		taskids.add("002");
//		List<String> cids=new ArrayList<String>();
//		cids.add("8b80c758361593ab013615941f120004");
////		roleService.updataRoleByID("8b80c758360fce8401360fcf6b2e0001", cids, "002", taskids, "bbaaaa", "123");
//		for (String roleid : ids) {
//			if(!cids.contains(roleid)){
//				System.out.println(roleid);
//			}
//		}
//	}
//}
