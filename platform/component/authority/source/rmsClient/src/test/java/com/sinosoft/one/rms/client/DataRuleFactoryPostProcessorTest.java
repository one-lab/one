package com.sinosoft.one.rms.client;

/**
 * test  DataRuleFactoryPostProcessor
 * User: Cheng Qi
 * Date: 8/10/12
 * Time: 2:28 PM
 * To change this template use File | Settings | File Templates.
 */

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@DirtiesContext
@ContextConfiguration(locations = { "/spring/applicationContext-test.xml",
        "/spring/applicationContext-shiro.xml","/spring/applicationContext-rms.xml" })
public class DataRuleFactoryPostProcessorTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private DataRuleFactoryPostProcessor dataRuleFactoryPostProcessor;


    @Test
    public void getDataRule(){
        //Assert.assertEquals(hello.say(),"hello" )   ;
//        Assert.assertEquals(dataRuleFactoryPostProcessor.getScript("helloWorld").rule(), "hello");
    	Assert.assertEquals(dataRuleFactoryPostProcessor.getScript("helloWorld"), "hello");
    }

}
