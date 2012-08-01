package com.sinosoft.ebusiness.rms.service.spring;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.sinosoft.ebusiness.rms.clientService.facade.RmsClientService;
import com.sinosoft.ebusiness.util.test.SpringTxTestCase;

@DirtiesContext
@ContextConfiguration(locations = { "/spring/applicationContext-test.xml",
      "/spring/applicationContext-rms.xml" })
@TransactionConfiguration(transactionManager = "defaultTransactionManager",defaultRollback=false)
public class RmsServiceTest  extends SpringTxTestCase{
	@Autowired
	private RmsClientService rmsClientService; 
	@Test
	public void ServiceTest(){
		rmsClientService.login("admin", "00");
	}
	public RmsClientService getRmsClientService() {
		return rmsClientService;
	}
	public void setRmsClientService(RmsClientService rmsClientService) {
		this.rmsClientService = rmsClientService;
	}

}
