package com.sinosoft.ebusiness.rms.client;

//import com.sinosoft.ebusiness.rms.client.operation.ClientOperation;
import com.sinosoft.ebusiness.util.test.SpringContextTestCase;
import com.sinosoft.ebusiness.util.test.SpringTxTestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
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
@ContextConfiguration(locations = { "/applicationContext-test.xml" })
@TransactionConfiguration(transactionManager = "defaultTransactionManager",defaultRollback=false)
public class AnnotationTestServiceTest {

    @Autowired
    private TestService annotationTestService;

    @Test
    public void findUser(){
//    	ClientOperation clientOperation =new ClientOperation();
//    	clientOperation.getLoginUserInfoByClient();
        annotationTestService.findUser();
    }

}
