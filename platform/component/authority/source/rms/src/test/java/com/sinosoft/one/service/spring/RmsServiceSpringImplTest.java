package com.sinosoft.one.service.spring;


import java.util.ArrayList;
import java.util.List;

import oracle.net.aso.r;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.sinosoft.ebusiness.util.test.SpringTxTestCase;
import com.sinosoft.one.rms.model.Company;
import com.sinosoft.one.rms.service.facade.RmsService;
import com.sinosoft.one.rms.service.spring.RmsServiceSpringImpl;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext-rmstest.xml",
        "/spring/applicationContext-rms.xml" })
@TransactionConfiguration(transactionManager = "defaultTransactionManager",defaultRollback=false)
public class RmsServiceSpringImplTest  extends SpringTxTestCase{
	@Autowired
	private RmsService rmsService;
	@Test
	public void testAllNextLevelCompanyByComCode(){
		List<Company> companies=new ArrayList<Company>();
		companies=rmsService.findAllNextLevelCompanyByComCode("11");
		companies.get(0).getComCName();
		System.out.println(companies.get(0).getComCName());
 		Assert.assertEquals(companies.get(0).getComCName(),"北京分公司");
	}
	
	@Test
	public void testfindCompanyBySuperAndType(){
		Assert.assertEquals(rmsService.findCompanyBySuperAndType("00", "1").size(),25);
	}
}
