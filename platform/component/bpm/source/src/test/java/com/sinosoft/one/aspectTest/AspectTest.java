package com.sinosoft.one.aspectTest;

import javax.persistence.EntityManagerFactory;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;

import com.sinosoft.one.service.facade.ComboService;
import com.sinosoft.one.util.test.SpringContextTestCase;

@DirtiesContext
@ContextConfiguration(locations = { "/spring/applicationContext-bpm.xml","/applicationContext-test.xml" })
public class AspectTest extends SpringContextTestCase {
	@Autowired
	ComboService comboService;
	@Autowired
	public AbstractPlatformTransactionManager bpmTxManager;
	@Autowired
	public EntityManagerFactory bpmEmf;

	 @Test
	public void testAspect() {
//		BpmEnvironment.bpmEmf = bpmEmf;
//		BpmEnvironment.bpmTxManager = bpmTxManager;

		// comboService.processCombo("1111");
		// comboService.createCombo("1111", "2222");
	}

}
