package com.sinosoft.one.service.spring;
//package com.sinosoft.ebusiness.rms.service.spring;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import org.hibernate.Session;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.transaction.TransactionConfiguration;
//
//import com.sinosoft.ebusiness.rms.model.Company;
//import com.sinosoft.ebusiness.rms.model.Employe;
//import com.sinosoft.ebusiness.rms.service.facade.TaskService;
//import com.sinosoft.ebusiness.util.test.SpringTxTestCase;
//import com.sun.org.apache.bcel.internal.generic.GETSTATIC;
//
//@DirtiesContext
//@ContextConfiguration(locations = { "/spring/applicationContext-test.xml",
//        "/spring/applicationContext-rms.xml" })
//@TransactionConfiguration(transactionManager = "defaultTransactionManager",defaultRollback=false)
//public class TaskServiceSpringImplTest extends SpringTxTestCase{
//	@Autowired
//	private EmployeService employeService;
//	@Autowired
//	private CompanyService companyService;
//	@Autowired
//	private TaskService taskService;
//	@Test
//	public void test(){
//		System.out.println(taskService.findTaskAuthByComCode("003").size());
//		List<String> ids=new ArrayList<String>();
//		ids.add("8b80c75836bf87bf0136bf8975730003");
//		ids.add("8b80c75836f7df260136f7fde01d0006");
//		System.out.println(taskService.findTaskByRole(ids,"12").size());
////		InputStream in = TaskServiceSpringImplTest.class.getClassLoader().getResourceAsStream("employee.txt");
////		BufferedReader br = new BufferedReader(new InputStreamReader(in));
////		employeService.saveEmploye(br);
//////		int i=1;
////		try {
////			String line;
////			while ((line = br.readLine()) != null) {
////				List<String> list = Arrays.asList(line.split(","));
////				companyService.addData(list,i);
////				i++;
////			}
////		} catch (Exception e) {
////			System.out.println(">>>>>>>>>>>>>>>"+i);
////		}
//	}
//	
//}
