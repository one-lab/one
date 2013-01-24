package com.sinosoft.one.log.test;

import com.sinosoft.one.log.Environment;
import com.sinosoft.one.log.config.LogConfigs;
import com.sinosoft.one.log.event.LogEventSupport;
import com.sinosoft.one.log.statistics.LogStatisticsHandler;
import com.sinosoft.one.log.statistics.LogStatisticsModel;
import com.sinosoft.one.log.statistics.LogStatisticsType;
import com.sinosoft.one.log.webfilter.TraceFilter;
import com.sinosoft.one.util.thread.ThreadUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.*;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

/**
 * 日志统计测试类.
 * User: carvin
 * Date: 13-1-16
 * Time: 下午3:27
 */
@DirtiesContext
@ContextConfiguration(locations = {"classpath:spring/applicationContext-log.xml",
        "classpath:applicationContext-test.xml",
        "classpath:spring/applicationContext-monitorAgent.xml"})
@TransactionConfiguration(transactionManager = "logMonitorTransactionManager",defaultRollback=true)
@Transactional(isolation= Isolation.READ_COMMITTED)
public class LogStatisticsTest extends AbstractFilterTest {
    @Autowired
    private LogConfigs logConfigs;
    @Autowired
    private LogStatisticsHandler logStatisticsHandler;
    @Autowired
    private ProposalService proposalService;

    private final static String LOG_STAIISTICS_TABLE_NAME = "GE_LOG_STATISTICS";
    @Before
    public void setUp() throws Exception {
        super.setUp();
        if(logConfigs.getLogMethods().size() != 0) {
            logConfigs.getLogMethods().clear();
        }
        if(logConfigs.getLogUrls().size() != 0) {
            logConfigs.getLogUrls().clear();
        }
        logConfigs.addLogUrl("/test", "DEVELOP", 300, 1);

        logConfigs.addLogMethod("com.sinosoft.one.log.test.ProposalServiceImpl", "testParam", 300, 1, Environment.TEST.name(), "此处演示如何进行参数,第一个参数${[0]},第二个参数${[1]}");
        logConfigs.addLogMethod("com.sinosoft.one.log.test.ProposalServiceImpl", "testProductTraced", 300, 1, Environment.PRODUCT.name(), "");
        logConfigs.addLogMethod("com.sinosoft.one.log.test.ProposalServiceImpl", "testDevelopTraced", 300, 1,Environment.DEVELOP.name(), "");
        logConfigs.addLogMethod("com.sinosoft.one.log.test.ProposalServiceImpl", "testTestTraced", 300, 1,Environment.TEST.name(), "");
        logConfigs.addLogMethod("com.sinosoft.one.log.test.ProposalServiceImpl", "testInterfaceTraced", 300,1, Environment.TEST.name(), "测试Trace");

        logStatisticsHandler.init();
    }

    @After
    public void tearDown() {
        if(logConfigs.getLogMethods().size() != 0) {
            logConfigs.getLogMethods().clear();
        }
        if(logConfigs.getLogUrls().size() != 0) {
            logConfigs.getLogUrls().clear();
        }
    }

    @Test
    public void testLogStatistics() throws Exception{
        int oldUrlLogsCount = this.countRowsInTable(LOG_STAIISTICS_TABLE_NAME);

        MockFilterConfig mockFilterConfig = new MockFilterConfig(servletContext, "traceFilter");
        mockFilterConfig.addInitParameter("userBehaviorLogSynchronized", "true");
        TraceFilter filter = new TraceFilter();
        filter.init(mockFilterConfig);
        filter.setLogConfigs(logConfigs);
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        request.addPreferredLocale(Locale.SIMPLIFIED_CHINESE);

        MockHttpServletResponse response = new MockHttpServletResponse();
        request.setMethod("POST");
        request.setSession(session);
        request.setRequestURI("/test");

        LogTestFilter logTestFilter = new LogTestFilter();
        logTestFilter.init(mockFilterConfig);

        filter.doFilter(request, response, new PassThroughFilterChain(logTestFilter, new MockFilterChain()));

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
        Thread.sleep(1000 * 70);

        int newUrlLogsCount = this.countRowsInTable(LOG_STAIISTICS_TABLE_NAME);
        Assert.assertEquals(oldUrlLogsCount + 6, newUrlLogsCount);

        long executeTime = logStatisticsHandler.selectExecuteTime(LogStatisticsType.URL.name(), "/test");
        Assert.assertTrue(executeTime >= 0);
    }
}
