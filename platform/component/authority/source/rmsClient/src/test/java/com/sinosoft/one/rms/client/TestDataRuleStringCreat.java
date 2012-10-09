package com.sinosoft.one.rms.client;

import ins.framework.utils.StringUtils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sinosoft.one.rms.clientService.DataPower;
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
		User user=rmsClientService.login("admin", "00", "RMS");
		EnvContext.setLoginInfo(user);
//		testService.testfindBySql();
//		testService.testfindQueryRule(user.getUserCode());
//		testService.findbyHql(1, 10);
		System.out.println(user.getDataPowers().size());
		for (DataPower dataPower : user.getDataPowers()) {
			System.out.println(dataPower.getComCode());
		}
		testService.testfindQueryRule("admin");
	}
	
	public static void main(String[] args) {
		String tableAlias="a";
		String str="select id,a.*, b.name,		sss.ff,   birthday_aaa  , table._id from ge_rms_role where userCode='asdasd'";
		String str2=" select table1.a ,tabl2.a from  table1 ,table2";
		if(StringUtils.isNotBlank(tableAlias)){
  			tableAlias=tableAlias+".";
  			
  		}else{
  			tableAlias="this.";
  		}
		String Str_from_before=str.substring(str.indexOf(" ")+1, str.indexOf("from"));
		
		String Str_from_affter=str.substring(str.indexOf("from"),str.length()-1);
		
		System.out.println(Str_from_before);
		
		String[] test = Str_from_before.split(",");
		StringBuffer sql = new StringBuffer();
		for (String s : test) {
			if(s.contains(".")){
				s = s.replaceAll("[\\s]*[a-zA-z_[0-9]]+\\.", tableAlias);
			} else {
				s = tableAlias + s.trim();
			}
			System.out.println(s);
			sql.append(s).append(",");
		}
		sql.setCharAt(sql.length()-1, ' ');
		sql.append(Str_from_affter);
		System.out.println(sql);
		
//		if(Str_from_before.contains("*")){
//			Str_from_before = Str_from_before
//				.replaceAll("\\s[a-zA-z_[0-9]]+", "this.[a-zA-z_[0-9]]+");
//		}
//		System.out.println(Str_from_before);
	}

}
