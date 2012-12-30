package com.sinosoft.one.log.test;

import com.sinosoft.one.log.Environment;
import com.sinosoft.one.log.config.LogConfigs;
import com.sinosoft.one.log.config.LogUrl;
import com.sinosoft.one.log.webfilter.TraceFilter;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.*;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-12-12
 * Time: 下午3:22
 * To change this template use File | Settings | File Templates.
 */
@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext-test.xml",
        "/spring/applicationContext-log.xml", "classpath:/spring/applicationContext-notification.xml" })
@TransactionConfiguration(transactionManager = "logMonitorTransactionManager",defaultRollback=true)
@Transactional(isolation= Isolation.READ_COMMITTED)
public class UrlTraceLogTest extends AbstractFilterTest{
    private static final String URL_LOG_TABLE_NAME = "GE_URL_TRACE_LOG";
    @Autowired
    private LogConfigs logConfigs;
    public void setUp() throws Exception{
        super.setUp();
        logConfigs.addLogUrl("/test", "DEVELOP", 300, 1);
    }

    @Test
    public void testUrlTraceLog() throws Exception {
        int oldUrlLogsCount = this.countRowsInTable(URL_LOG_TABLE_NAME);

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

        Thread.sleep(3000);

        int newUrlLogsCount = this.countRowsInTable(URL_LOG_TABLE_NAME);
        Assert.assertEquals(newUrlLogsCount, oldUrlLogsCount + 1);
    }
}
