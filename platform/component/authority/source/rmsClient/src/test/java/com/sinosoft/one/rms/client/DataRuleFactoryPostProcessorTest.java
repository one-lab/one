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
//      Assert.assertEquals(dataRuleFactoryPostProcessor.getScript("helloWorld").rule(), "hello");
//    	Assert.assertEquals(dataRuleFactoryPostProcessor.getScript("queryRuleAccordComAndNextCom.groovy").creatSQL(sql, param, loginComCode, comPanyTableName, comCodeColumnName), "hello");
//    	System.out.println(dataRuleFactoryPostProcessor.getScript("queryRuleAccordCompany").creatSQL("", "{comCode:'00'}", "11", "ge_rms_company", "comCode", "upperComCode"));
//    	System.out.println(dataRuleFactoryPostProcessor.getScript("queryRuleAccordCompany").creatSQL("", null, "11", "", "comCode", "upperComCode","c"));
    	System.out.println(dataRuleFactoryPostProcessor.getScript("queryRuleAccordCompany").creatSQL("select *from ge_rms_pany where isvalidate='1'", "{comCode:'00'}", "11", "", "comCode", "upperComCode"));
//    	System.out.println(dataRuleFactoryPostProcessor.getScript("queryRuleAccordCompany").creatHQL("from Employe where usercode='admin'", null, "11", "Employe.company", "ge_rms_company" ,"comCode"));
//     	System.out.println(dataRuleFactoryPostProcessor.getScript("queryRuleAccordCompany").creatHQL("from Employe where usercode='admin'", null, "11", null, "ge_rms_company" ,"comCode"));
    }

    
}
