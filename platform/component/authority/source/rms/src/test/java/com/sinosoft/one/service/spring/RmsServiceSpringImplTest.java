package com.sinosoft.one.service.spring;


import java.util.ArrayList;
import java.util.List;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import com.sinosoft.one.rms.model.Company;
import com.sinosoft.one.rms.service.facade.CompanyServiceInterface;
import com.sinosoft.one.rms.service.facade.RmsService;

@DirtiesContext
@ContextConfiguration(locations = { "/spring/applicationContext-rmstest.xml",
        "/spring/applicationContext-rms.xml" })
@TransactionConfiguration(transactionManager = "defaultTransactionManager",defaultRollback=false)
public class RmsServiceSpringImplTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private CompanyServiceInterface companyServiceInterface;
	@Autowired
	private RmsService rmsService;
	@Test
	public void testAllNextLevelCompanyByComCode(){
		List<Company> companies=new ArrayList<Company>();
		companies=(List<Company>) companyServiceInterface.findAllNextLevelCompanybyComCode("11");
		companies.get(0).getComCName();
		System.out.println(companies.get(0).getComCName());
 		Assert.assertEquals(companies.get(0).getComCName(),"北京分公司");
	}
	
	@Test
	public void testfindCompanyBySuperAndType(){
		Assert.assertEquals(companyServiceInterface.findCompanyBySuperAndType("00", "1").size(),25);
	}
	
}
