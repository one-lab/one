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
//
//@DirtiesContext
//@ContextConfiguration(locations = { "/spring/applicationContext-test.xml",
//        "/spring/applicationContext-rms.xml" })
//@TransactionConfiguration(transactionManager = "defaultTransactionManager",defaultRollback=false)
//
//public class GroupServiceSpringImplTest extends SpringTxTestCase{
//	@Autowired
//	private GroupServiceSpringImpl groupService;
//	
//	@Test
//	public void test(){
////		List<String> roleIDs=new ArrayList<String>();
////		roleIDs.add("8b80c758360fcf6801360fcfdd610001");
////		roleIDs.add("8b80c758360fce8401360fcf6b2e0001");
////		groupService.addGroup("001", "002", "0022", "321", roleIDs);
////		groupService.addGroup("001", "003", "0022", "321", roleIDs);
////		List<String> ids=new ArrayList<String>();
////		ids.add("8b80c75836bf87bf0136bf8975730003");
////		ids.add("8b80c75836382bd001363859cd260001");
//		groupService.findGroup("2", "00", 1, 10);
////		groupService.updataGroup("8b80c75836ce6b7f0136ce7bfabf0001", "admin", "11", "北京测试", "111", ids);
//	}
//}
