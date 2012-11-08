package com.sinosoft.one.rms.client;

/**
 * test  DataRuleFactoryPostProcessor
 * User: Cheng Qi
 * Date: 8/10/12
 * Time: 2:28 PM
 * To change this template use File | Settings | File Templates.
 */


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.sinosoft.one.rms.client.DataRuleFactoryPostProcessor;
import com.sinosoft.one.rms.clientService.facade.RmsClientService;

@DirtiesContext
@ContextConfiguration(locations = { "/spring/applicationContext-test.xml",
        "/spring/applicationContext-shiro.xml","/spring/applicationContext-rms.xml" })
public class DataRuleFactoryPostProcessorTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private DataRuleFactoryPostProcessor dataRuleFactoryPostProcessor;
    @Test
    public void getDataRule(){
////    	User user= rmsClientService.login("admin", "00","RMS");
//  
//    	String rule=null;
//    	for (DataPower dataPower : user.getDataPowers()) {
//    	  	String sqlOrHql="select * from ge_rms_group where isvalidate='1' order by comCode";
//    		rule=dataRuleFactoryPostProcessor.getScript(dataPower.getRuleId()).creatSQL(sqlOrHql, dataPower);
//    	}
//    	Assert.assertEquals(rule,"select * from ge_rms_group where isvalidate='1'  and comCode=(select comCode from ge_rms_company where comCode='00') order by comCode");
//    	testService.find(rule);
    }
}
