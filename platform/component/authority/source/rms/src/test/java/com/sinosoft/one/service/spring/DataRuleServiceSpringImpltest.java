package com.sinosoft.one.service.spring;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.sinosoft.one.rms.model.DataRule;
import com.sinosoft.one.rms.service.facade.DataRuleService;



@DirtiesContext
@ContextConfiguration(locations = { "/spring/applicationContext-rmstest.xml",
        "/spring/applicationContext-rms.xml" })
@TransactionConfiguration(transactionManager = "defaultTransactionManager",defaultRollback=false)
public class DataRuleServiceSpringImpltest extends AbstractJUnit4SpringContextTests{
	
	@Autowired
	private DataRuleService dataRuleService;	
	@Test 
	public void test(){
		List<DataRule>dataRules=dataRuleService.findAllDataRule();
		Assert.assertNotNull(dataRules);
		for (Object ob : dataRules) {
			Assert.assertTrue( ob instanceof DataRule);
		}
		dataRuleService.addBusPower("8b80c000000000000000000000000001", "queryRuleAccordComAndNextCom", "RMS001", "");
		dataRuleService.addBusPower("8b80c000000000000000000000000001", "queryRuleAccordCompany", "RMS001", "");
		dataRuleService.addBusPower("8b80c000000000000000000000000001", "queryRuleAccordComAndNextCom", "RMS001", "");
		dataRuleService.addBusPower("8b80c000000000000000000000000001", "queryRuleAccordInsurance", "RMS001", "");
		dataRuleService.addBusPower("8b80c000000000000000000000000001", "queryRuleAccordCompany", "RMS002", "");
	}
}
