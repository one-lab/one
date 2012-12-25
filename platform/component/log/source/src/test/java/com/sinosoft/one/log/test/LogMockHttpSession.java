package com.sinosoft.one.log.test;

import org.springframework.mock.web.MockHttpSession;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionContext;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-12-15
 * Time: 下午11:41
 * To change this template use File | Settings | File Templates.
 */
public class LogMockHttpSession extends MockHttpSession {

    public LogMockHttpSession() {
    }

    public LogMockHttpSession(ServletContext servletContext) {
        super(servletContext);
    }

    public LogMockHttpSession(ServletContext servletContext, String id) {
        super(servletContext, id);
    }

    @Override
    public HttpSessionContext getSessionContext() {
        return null;    //To change body of overridden methods use File | Settings | File Templates.
    }
}
