package com.sinosoft.one.log;

import java.io.IOException;
import java.util.Properties;

import junit.framework.Assert;

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
		"/spring/applicationContext-log.xml" })
@TransactionConfiguration(transactionManager = "monitorTransactionManager",defaultRollback=false)
@Transactional(isolation=Isolation.READ_COMMITTED)
public class ProposalServiceImplTest extends SpringTxTestCase {

	@Autowired
	private ProposalService proposalService;

	private static final String LOG_TABLE_NAME = "GE_MONITOR_APPLOG";

	Logger dbLogger = LoggerFactory.getLogger("DBLog");

	@Test
	public void testImpleTraced() {
		int oldLogsCount = this.countRowsInTable(LOG_TABLE_NAME);
		dbLogger.info("[@Trace:MethodTarce]第1次");
		ThreadUtils.sleep(1000);
		dbLogger.info("[@Trace:MethodTarce]第2次");

		dbLogger.info("[@Trace:MethodTarce]第3次");
		dbLogger.info("[@Trace:MethodTarce]第4次");
        //bug级别不应该写入
		dbLogger.debug("[@Trace:MethodTarce]第5次   bug级别写不进去");
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
		Assert.assertEquals(oldLogsCount + 8,
				this.countRowsInTable(LOG_TABLE_NAME));
	}

    @Test
    public void testEnv() {
        LogTraceAspect implTraceAspect = super.applicationContext.getBean(LogTraceAspect.class);
        implTraceAspect.setEnvironment(Environment.TEST);
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
        implTraceAspect.setEnvironment(Environment.PRODUCT);
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
        traceAspect.setEnvironment(Environment.valueOf(props.get("log.environment").toString()));
		// 所谓接口拦截是拦截所有非接口类后分析是否有接口拦截注解，造成所有非实现类可能被拦截两次。因此不适合拦截应用
		int oldLogsCount = this.countRowsInTable(LOG_TABLE_NAME);
		proposalService.testInterfaceTraced();
		//proposalService.save();
		ThreadUtils.sleep(1000 * 3);

		Assert.assertEquals(oldLogsCount + 1,
				this.countRowsInTable(LOG_TABLE_NAME));

	}

}
