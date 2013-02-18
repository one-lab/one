package com.sinosoft.one.log.test;

import java.io.IOException;
import java.util.Properties;

import com.sinosoft.one.log.Environment;
import com.sinosoft.one.log.LogTraceAspect;
import com.sinosoft.one.log.config.LogConfigs;
import com.sinosoft.one.log.statistics.LogStatisticsHandler;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.sinosoft.one.util.test.SpringTxTestCase;
import com.sinosoft.one.util.thread.ThreadUtils;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext-test.xml",
        "/spring/applicationContext-monitorAgent.xml","/spring/applicationContext-log.xml" })
@TransactionConfiguration(transactionManager = "logMonitorTransactionManager",defaultRollback=true)
@Transactional(isolation=Isolation.READ_COMMITTED)
public class ProposalServiceImplTest extends SpringTxTestCase {

	@Autowired
	private ProposalService proposalService;
    @Autowired
    private LogConfigs logConfigs;

    @Autowired
    private LogStatisticsHandler logStatisticsHandler;

	private static final String LOG_TABLE_NAME = "GE_METHOD_TRACE_LOG";

	Logger dbLogger = LoggerFactory.getLogger("DBLog");

    @Before
    public void setUp() {
        if(logConfigs.getLogMethods().size() != 0) {
            logConfigs.getLogMethods().clear();
        }
        logConfigs.addLogMethod("com.sinosoft.one.log.test.ProposalServiceImpl", "testParam", 300, 5, Environment.TEST.name(), "此处演示如何进行参数,第一个参数${[0]},第二个参数${[1]}");
        logConfigs.addLogMethod("com.sinosoft.one.log.test.ProposalServiceImpl", "testProductTraced", 300, 5, Environment.PRODUCT.name(), "");
        logConfigs.addLogMethod("com.sinosoft.one.log.test.ProposalServiceImpl", "testDevelopTraced", 300, 5,Environment.DEVELOP.name(), "");
        logConfigs.addLogMethod("com.sinosoft.one.log.test.ProposalServiceImpl", "testTestTraced", 300, 5,Environment.TEST.name(), "");
        logConfigs.addLogMethod("com.sinosoft.one.log.test.ProposalServiceImpl", "testInterfaceTraced", 300,5, Environment.TEST.name(), "测试Trace");
        logStatisticsHandler.init();
    }

    @After
    public void tearDown() {
        if(logConfigs.getLogMethods().size() != 0) {
            logConfigs.getLogMethods().clear();
        }
    }

	@Test
	public void testImpleTraced() {
		int oldLogsCount = this.countRowsInTable(LOG_TABLE_NAME);
		try {
            dbLogger.info("测试第1次");
        } catch (IllegalStateException e) {
            Assert.assertTrue(e.getMessage().startsWith("This log"));
        }
		ThreadUtils.sleep(1000);
        logConfigs.setEnvironment(Environment.DEVELOP.name());
		String c = "123";
		proposalService.testParam(1, '2');
		// 生产环境拦截一条
		proposalService.testProductTraced();
		// 开发环境拦截一条
		proposalService.testDevelopTraced();
		// 测试环境拦截一条
		proposalService.testTestTraced();
		// 未拦截测试
		proposalService.notTracedService();
		ThreadUtils.sleep(1000 * 3);
		Assert.assertEquals(oldLogsCount + 4,
				this.countRowsInTable(LOG_TABLE_NAME));
	}

    @Test
    public void testEnv() {
        LogTraceAspect implTraceAspect = super.applicationContext.getBean(LogTraceAspect.class);
        logConfigs.setEnvironment(Environment.TEST.name());
        int oldLogsCount = this.countRowsInTable(LOG_TABLE_NAME);
        // 生产环境拦截一条
        proposalService.testProductTraced();
        // 开发环境拦截一条
        proposalService.testDevelopTraced();
        // 测试环境拦截一条
        proposalService.testTestTraced();
        // 未拦截测试
        proposalService.notTracedService();
        ThreadUtils.sleep(1000 * 3);
        Assert.assertEquals(oldLogsCount + 2,
                this.countRowsInTable(LOG_TABLE_NAME));
    }

    /**
     * 生产环境测试
     */
    @Test
    public void productEnv() {
        LogTraceAspect implTraceAspect = super.applicationContext.getBean(LogTraceAspect.class);
        logConfigs.setEnvironment(Environment.PRODUCT.name());
        int oldLogsCount = this.countRowsInTable(LOG_TABLE_NAME);
        // 生产环境拦截一条
        proposalService.testProductTraced();
        // 开发环境拦截一条
        proposalService.testDevelopTraced();
        // 测试环境拦截一条
        proposalService.testTestTraced();
        // 未拦截测试
        proposalService.notTracedService();
        ThreadUtils.sleep(1000 * 3);
        Assert.assertEquals(oldLogsCount + 1,
                this.countRowsInTable(LOG_TABLE_NAME));
    }

	@Test
	public void interfaceTraced() throws IOException {

        Resource resource = new ClassPathResource("/application.test.properties");
        Properties props = PropertiesLoaderUtils.loadProperties(resource);
        LogTraceAspect traceAspect = super.applicationContext.getBean(LogTraceAspect.class);
        logConfigs.setEnvironment(props.get("log.environment").toString());
		// 所谓接口拦截是拦截所有非接口类后分析是否有接口拦截注解，造成所有非实现类可能被拦截两次。因此不适合拦截应用
		int oldLogsCount = this.countRowsInTable(LOG_TABLE_NAME);
		proposalService.testInterfaceTraced();
		//proposalService.save();
		ThreadUtils.sleep(1000 * 3);

		Assert.assertEquals(oldLogsCount + 1,
				this.countRowsInTable(LOG_TABLE_NAME));

	}

}
