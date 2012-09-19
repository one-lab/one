package com.sinosoft.one.mvc.testcases;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.sinosoft.one.mvc.MvcFilter;
import junit.framework.TestCase;

import com.sinosoft.one.mvc.testcases.controllers.MvcTestEnv;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.util.WebUtils;

public abstract class AbstractControllerTest extends TestCase {

    public static MvcFilter filter;

    protected ServletContext servletContext;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected MockFilterChain chain = new MockFilterChain();

    public void innerSetUp() throws Exception {

    }

    @Before
    public void setUp() throws Exception {
        filter = MvcTestEnv.instance().getMvcFilter();
        servletContext = filter.getFilterConfig().getServletContext();
        request = new MockHttpServletRequest(servletContext) {

            @Override
            public RequestDispatcher getRequestDispatcher(final String path) {
                return new RequestDispatcher() {

                    public void forward(ServletRequest request, ServletResponse response)
                            throws ServletException, IOException {
                        WebUtils.exposeForwardRequestAttributes((HttpServletRequest) request);
                        String uri = path;
                        if (path.indexOf('?') >= 0) {
                            uri = path.substring(0, path.indexOf('?'));
                            ((MockHttpServletRequest) request).setRequestURI(uri);
                            ((MockHttpServletRequest) request).setQueryString(path.substring(path
                                    .indexOf('?') + 1));
                        } else {
                            ((MockHttpServletRequest) request).setRequestURI(uri);
                            ((MockHttpServletRequest) request).setQueryString("");
                        }

                        AbstractControllerTest.filter.doFilter(request, response, chain);
                    }

                    public void include(ServletRequest request, ServletResponse response)
                            throws ServletException, IOException {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
        response = new MockHttpServletResponse();
        request.setMethod("GET");
        innerSetUp();
    }

    protected Object invoke(String uri) throws ServletException, IOException {
        return invoke(uri, "", "");
    }

    protected Object invoke(String uri, String method, String queryString) throws ServletException,
            IOException {
        request.setRequestURI(uri);
        if (StringUtils.isNotEmpty(method)) {
            request.setMethod(method);
        }
        if (StringUtils.isNotEmpty(queryString)) {
            request.setQueryString(queryString);
        }
        filter.doFilter(request, response, chain);
        return MvcTestEnv.instance().getInstructionExecutor().getInstruction(request);
    }
}
