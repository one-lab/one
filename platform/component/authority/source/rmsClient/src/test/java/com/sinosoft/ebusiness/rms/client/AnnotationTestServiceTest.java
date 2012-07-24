package com.sinosoft.ebusiness.rms.client;


import ins.framework.common.Page;


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
    @Test
    public void findUserToPage(){
    }

    @Test
    public void findTest(){
    }
    
    
    @Test
    public void groovy(){
    }
    
	public TestService getAnnotationTestService() {
		return annotationTestService;
	}

	public void setAnnotationTestService(TestService annotationTestService) {
		this.annotationTestService = annotationTestService;
	}
    
    
}
