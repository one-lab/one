package com.sinosoft.one.newRms.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.sinosoft.one.ams.service.facade.CompanyService;

@DirtiesContext
@ContextConfiguration(locations = { "/spring/applicationContext-test.xml"})
public class CompanyServiceTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private CompanyService companyService;
	
	@Test
	public void test(){
		companyService.findCompanyByUpperComCode("00");
	}

}
