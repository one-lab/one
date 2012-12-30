package com.sinosoft.one.log.test;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-12-26
 * Time: 下午5:11
 * To change this template use File | Settings | File Templates.
 */
public class LogTestFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {

    }
}
