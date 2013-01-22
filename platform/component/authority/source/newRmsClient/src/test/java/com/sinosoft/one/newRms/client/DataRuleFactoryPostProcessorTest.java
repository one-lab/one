package com.sinosoft.one.newRms.client;

/**
 * test  DataRuleFactoryPostProcessor
 * User: Cheng Qi
 * Date: 8/10/12
 * Time: 2:28 PM
 * To change this template use File | Settings | File Templates.
 */


import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.sinosoft.one.newRms.client.DataRuleFactoryPostProcessor;

@DirtiesContext
@ContextConfiguration(locations = { "/spring/applicationContext-test.xml"})
public class DataRuleFactoryPostProcessorTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private DataRuleFactoryPostProcessor dataRuleFactoryPostProcessor;
    @Test
    public void getDataRule(){
    	String rule=dataRuleFactoryPostProcessor.getScript("queryRuleAccordCompany").creatSQL("", "a", "admin", "00", "{comCode:11}", "comCode");
    	System.out.println(dataRuleFactoryPostProcessor.getScript("queryRuleAccordCompany").getClass());
    	Assert.assertEquals("a.comCode=(select comCode from ge_rms_company where comCode='11')",rule);
    	System.out.println(rule);
    	rule=dataRuleFactoryPostProcessor.getScript("queryRuleAccordCompany").creatSQL(rule, "a", "admin", "00", "{comCode:11}", "comCode");
    	Assert.assertEquals("a.comCode=(select comCode from ge_rms_company where comCode='11')"+" and a.comCode=(select comCode from ge_rms_company where comCode='11')",rule);
//    	rule=dataRuleFactoryPostProcessor.getScript("queryRuleAccordComAndNextCom").creatSQL("", "a", "admin", "00", "{comCode:11}", "comCode");
//    	Assert.assertEquals("a.comCode in  (select comCode from ge_rms_company start with comCode in ('11') connect by prior comCode=upperComCode)", rule);
//    	rule=dataRuleFactoryPostProcessor.getScript("queryRuleAccordInsurance").creatSQL("", "a", "admin", "00", "{comCode:'11'}", "test");
    }
    
}
