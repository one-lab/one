package com.sinosoft.one.newRms.client;

/**
 * test  DataRuleFactoryPostProcessor
 * User: Cheng Qi
 * Date: 8/10/12
 * Time: 2:28 PM
 * To change this template use File | Settings | File Templates.
 */


import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.sinosoft.one.ams.model.BusDataInfo;
import com.sinosoft.one.ams.model.Company;
import com.sinosoft.one.ams.model.DataRule;
import com.sinosoft.one.ams.repositories.CompanyDao;
import com.sinosoft.one.ams.repositories.GeRmsDataRuleRepository;
import com.sinosoft.one.ams.service.facade.CompanyService;
import com.sinosoft.one.ams.service.facade.EmployeeService;
import com.sinosoft.one.ams.service.facade.StaffingService;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.newRms.client.DataRuleFactoryPostProcessor;

@DirtiesContext
@ContextConfiguration(locations = { "/spring/applicationContext-test.xml"})
@Path
public class DataRuleFactoryPostProcessorTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private DataRuleFactoryPostProcessor dataRuleFactoryPostProcessor;
    @Autowired
    private StaffingService staffingService;
    @Autowired
    private EmployeeService employeeService;
    @Test
    public void getDataRule(){
    	String rule=dataRuleFactoryPostProcessor.getScript("queryRuleAccordCompany").creatSQL("", "a", "admin", "00", "{comCode:11}", "comCode");
    	System.out.println(dataRuleFactoryPostProcessor.getScript("queryRuleAccordCompany").getClass());
    	Assert.assertEquals("a.comCode=(select comCode from ge_rms_company where comCode='11')",rule);
    	System.out.println("1,"+rule);
    	rule=dataRuleFactoryPostProcessor.getScript("queryRuleAccordCompany").creatSQL(rule, "a", "admin", "00", "{comCode:11}", "comCode");
    	Assert.assertEquals("a.comCode=(select comCode from ge_rms_company where comCode='11')"+" and a.comCode=(select comCode from ge_rms_company where comCode='11')",rule);
    	System.out.println("2,"+rule);
    	rule=dataRuleFactoryPostProcessor.getScript("queryRuleAccordComAndNextCom").creatSQL("", "a", "admin", "00", "{comCode:11}", "comCode");
    	Assert.assertEquals("a.comCode in  (select comCode from ge_rms_company start with comCode in ('11') connect by prior comCode=upperComCode)", rule);
    	System.out.println("3,"+rule);
    	rule=dataRuleFactoryPostProcessor.getScript("queryRuleAccordInsurance").creatSQL("", "a", "admin", "00", "{comCode:'11'}", "test");
    	System.out.println("4,"+rule);
    }
    
    
    
}
