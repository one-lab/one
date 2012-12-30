package com.sinosoft.one.log.test;

import com.sinosoft.one.log.webfilter.TraceFilter;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.*;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.Filter;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;


/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-12-12
 * Time: 上午11:23
 * To change this template use File | Settings | File Templates.
 */
@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext-test.xml",
        "/spring/applicationContext-notification.xml","/spring/applicationContext-log.xml" })
@TransactionConfiguration(transactionManager = "logMonitorTransactionManager",defaultRollback=true)
@Transactional(isolation= Isolation.READ_COMMITTED)
public class UserBehaviorLogTest extends AbstractFilterTest{
    private int    threadCount     = 10;
    final int      LOOP_COUNT      = 10;

    private static final String BEHAVIOR_LOG_TABLE = "ge_user_behavior_log";
    @Test
    public void testTraceFilterSynchronized() throws Exception {
        int oldCount = countRowsInTable(BEHAVIOR_LOG_TABLE);
        MockFilterConfig mockFilterConfig = new MockFilterConfig(servletContext, "traceFilter");
        mockFilterConfig.addInitParameter("userBehaviorLogSynchronized", "true");
        TraceFilter filter = new TraceFilter();
        filter.init(mockFilterConfig);
        p0("synchronized", filter);
        int newCount = countRowsInTable(BEHAVIOR_LOG_TABLE);
        Assert.assertEquals(oldCount + 100, newCount);
    }

    @Test
    public void testTraceFilterASynchronized() throws Exception {
        int oldCount = countRowsInTable(BEHAVIOR_LOG_TABLE);
        MockFilterConfig mockFilterConfig = new MockFilterConfig(servletContext, "traceFilter");
        mockFilterConfig.addInitParameter("userBehaviorLogSynchronized", "false");
        TraceFilter filter = new TraceFilter();
        filter.init(mockFilterConfig);
        p0("Asynchronized", filter);
        Thread.sleep(1000 * 10);
        int newCount = countRowsInTable(BEHAVIOR_LOG_TABLE);
        Assert.assertEquals(oldCount + 100, newCount);

    }


    private void p0(String name, final Filter filter) throws Exception {

        final CountDownLatch startLatch = new CountDownLatch(1);
        final CountDownLatch endLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; ++i) {
            Thread thread = new Thread() {

                public void run() {
                    try {
                        startLatch.await();

                        for (int i = 0; i < LOOP_COUNT; ++i) {
                            MockHttpServletRequest request = new MockHttpServletRequest();
                            request.setCharacterEncoding("UTF-8");
                            request.addPreferredLocale(Locale.SIMPLIFIED_CHINESE);

                            MockHttpServletResponse response = new MockHttpServletResponse();
                            request.setMethod("POST");
//                            session = new MockHttpSession(servletContext, RandomStringUtils.randomAlphabetic(8));
                            request.setSession(session);
                            request.addParameter("test1", "测试参数1");
                            request.setRequestURI("/aaaaaaaa");

                            filter.doFilter(request, response, new MockFilterChain());
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    endLatch.countDown();
                }
            };
            thread.start();
        }
        long startMillis = System.currentTimeMillis();
        long startYGC = TestUtil.getYoungGC();
        long startFullGC = TestUtil.getFullGC();
        startLatch.countDown();
        endLatch.await();

        long millis = System.currentTimeMillis() - startMillis;
        long ygc = TestUtil.getYoungGC() - startYGC;
        long fullGC = TestUtil.getFullGC() - startFullGC;

        System.out.println("thread " + threadCount + " " + name + " millis : "
                + NumberFormat.getInstance().format(millis) + ", YGC " + ygc + " FGC " + fullGC);


    }

}
