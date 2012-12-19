package com.sinosoft.one.log.test;

import com.sinosoft.one.log.webfilter.TraceFilter;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.springframework.mock.web.*;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.servlet.ServletContext;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-12-12
 * Time: 下午3:02
 * To change this template use File | Settings | File Templates.
 */

public abstract class AbstractFilterTest extends AbstractTransactionalJUnit4SpringContextTests {
    protected  ServletContext servletContext;

    protected MockHttpSession session;
    @Before
    public void setUp() throws Exception {
        servletContext = new MockServletContext();
        session = new LogMockHttpSession(servletContext, RandomStringUtils.randomAlphabetic(8));
    }
}
