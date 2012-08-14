package com.sinosoft.one.rms.client;

import ins.framework.utils.StringUtils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sinosoft.one.rms.clientService.User;
import com.sinosoft.one.rms.service.facade.ClientService;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext-test.xml"})
public class TestDataRule {
	@Autowired
	private TestService testService;
	@Autowired
	private ClientService clientService;

	@Test
	public void testGroovyClass() {
//		DynamicLoadBeanByGroovyPath groov = new DynamicLoadBeanByGroovyPath();
//		// //
//		String str = "{comCode:'00'}";
//		System.out.println(groov.creatGroovyClass(
//				"groovy/queryRuleAccordCompany.groovy").creatSQL("",str, "00", "c"));
//	//	System.out.println(groov.creatGroovyClass("groovy/bythisCom.groovy")
//		//		.creatSQL(str, "00"));
	}

	@Test
	public void testFind() {
//		String tempSqlOrHQl="" ;
//		String orderBy="";
//		String sqlOrHql="from Group  where comCode='00'  order by comCode";
//		if(StringUtils.isNotBlank(sqlOrHql)&&sqlOrHql.contains("order by")){
//			if(sqlOrHql.contains(")")&&(sqlOrHql.substring(sqlOrHql.lastIndexOf(")"), sqlOrHql.length()).contains("order by"))){
//				tempSqlOrHQl=sqlOrHql.substring(0, sqlOrHql.lastIndexOf(")")+1);
//				orderBy=sqlOrHql.substring(sqlOrHql.lastIndexOf(")")+1, sqlOrHql.length());
//			}else{
//				tempSqlOrHQl=sqlOrHql.substring(0,sqlOrHql.lastIndexOf("order by"));
//				orderBy=sqlOrHql.substring(sqlOrHql.lastIndexOf("order by"), sqlOrHql.length());
//			}
//		}
//		System.out.println(sqlOrHql.lastIndexOf(orderBy));
//		System.out.println(tempSqlOrHQl+" ----- "+orderBy);
//		System.out.println(StringUtils.isNotBlank(sqlOrHql)&&sqlOrHql.contains("order by")&&(sqlOrHql.length()-sqlOrHql.lastIndexOf("order by")<10));
		User user = clientService.getUserByUserCodeComCode("admin", "00");
		EnvContext.setLoginInfo(user);
//      testService.findUser();
		testService.findBySql();
//		testService.find(1,10);
//		testService.findUser();
//		testService.findUser(1, 10);
//		testService.findtest();
//		String comPanyModelName="company";
//	  	comPanyModelName=comPanyModelName.substring(0, 1).toUpperCase()+comPanyModelName.substring(1, comPanyModelName.length())+".";
//	  	System.out.println(comPanyModelName);
		String ModelName="Employe.company";
		String comPanyModelName="";
		if(StringUtils.isNotBlank(ModelName)&&ModelName.contains(".")){
			comPanyModelName=ModelName.split(".")[1].toString();
			comPanyModelName=comPanyModelName.substring(0, 1).toLowerCase()+comPanyModelName.substring(1, comPanyModelName.length())+".";
		}
		
	}
	
	@Test
	public void testStr(){
		String s="select * from xxxxx where xxx order by";
		String orderby="order by";
		System.out.println(s.lastIndexOf(orderby));
		System.out.println(s.substring(0,s.lastIndexOf(orderby)));
		System.out.println(s.contains(orderby));
	}
}
