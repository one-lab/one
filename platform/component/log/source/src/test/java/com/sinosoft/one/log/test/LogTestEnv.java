package com.sinosoft.one.log.test;

import com.sinosoft.one.log.webfilter.TraceFilter;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.mock.web.MockFilterConfig;
import org.springframework.mock.web.MockServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-12-12
 * Time: 上午11:17
 * To change this template use File | Settings | File Templates.
 */
public class LogTestEnv {
    private static LogTestEnv env;

    private TraceFilter traceFilter;

    public synchronized static LogTestEnv instance() throws ServletException {
        if (env == null) {
            env = new LogTestEnv();
        }
        return env;
    }

    private LogTestEnv() throws ServletException {
        ServletContext servletContext = new MockServletContext();

        traceFilter = new TraceFilter();
        traceFilter.init(new MockFilterConfig(servletContext, "traceFilter"));
    }

    public TraceFilter getTraceFilter() {
        return traceFilter;
    }
}
