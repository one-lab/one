package com.sinosoft.ebusiness.rms.client;


import ins.framework.common.Page;

import com.sinosoft.ebusiness.rms.client.operation.ClientOperation;
import com.sinosoft.ebusiness.rms.client.operation.GroovyService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Created by IntelliJ IDEA.
 * User: ChengQi
 * Date: 3/22/12
 * Time: 4:35 PM
 *
 */
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext-test.xml","/spring/applicationContext-groovy.xml" })
@TransactionConfiguration(transactionManager = "defaultTransactionManager",defaultRollback=false)
public class AnnotationTestServiceTest {

    @Autowired
    private TestService annotationTestService;
    @Autowired
    private GroovyService say;
    @Test
    public void findUser(){
        ClientOperation clientOperation =new ClientOperation();
		clientOperation.getLoginUserInfoByClient();
    }
    
    @Test
    public void findUserToPage(){
        ClientOperation clientOperation =new ClientOperation();
		clientOperation.getLoginUserInfoByClient();
		Page page=new Page();
		page= annotationTestService.findUser(1,10);
    }

    @Test
    public void findTest(){
        ClientOperation clientOperation =new ClientOperation();
		clientOperation.getLoginUserInfoByClient();
		Page page=new Page();
		annotationTestService.find(1, 10);
    }
    
    
    @Test
    public void groovy(){
    	say.SayHello();
    }
    
	public TestService getAnnotationTestService() {
		return annotationTestService;
	}

	public void setAnnotationTestService(TestService annotationTestService) {
		this.annotationTestService = annotationTestService;
	}
    
    
}
