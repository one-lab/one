package com.sinosoft.one.exception;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.sinosoft.one.util.queue.QueuesHolder;
import com.sinosoft.one.util.test.SpringTxTestCase;
import com.sinosoft.one.util.thread.ThreadUtils;
import com.sinosoft.one.exception.service.facade.ExceptionAspectService;

/**
 * 异常拦截测试
 */
@DirtiesContext
@ContextConfiguration(locations = { "/spring/applicationContext-exception.xml",
        "/spring/applicationContext-notification.xml", "/spring/applicationContext-exception-test.xml" })
@TransactionConfiguration(transactionManager = "exceptionMonitorTransactionManager")
public class ExceptionAspectTest extends SpringTxTestCase {
    @Autowired
    private ExceptionAspectService exceptionAspectService;
    // Logger dbLogger = LoggerFactory.getLogger("DBExceptionLog");
    private static final String LOG_TABLE_NAME = "GE_EXCEPTION_INFO";

    @Test
    public void testExceptionAspect() {
        int oldLogsCount = this.countRowsInTable(LOG_TABLE_NAME);
        try {
            int queueSize = QueuesHolder.getQueueLength("exception");
            System.out.print("exception queue length size =" + queueSize);
            // dbLogger.error("testing", new Throwable());
            // dbLogger.info("testing");
            exceptionAspectService.ExceptionThrow();
            System.out.print("xxxxxx2");
        } catch (Exception e) {
            // TODO Auto-generated catch block
//			 e.printStackTrace();
        }
        ThreadUtils.sleep(1000 * 2);

        Assert.assertEquals(oldLogsCount + 1,
                this.countRowsInTable(LOG_TABLE_NAME));

    }

    public ExceptionAspectService getExceptionAspectService() {
        return exceptionAspectService;
    }

    public void setExceptionAspectService(
            ExceptionAspectService exceptionAspectService) {
        this.exceptionAspectService = exceptionAspectService;
    }

}
