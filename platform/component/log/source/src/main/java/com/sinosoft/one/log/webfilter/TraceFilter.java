package com.sinosoft.one.log.webfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.sinosoft.one.log.TraceUtils;

public class TraceFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		TraceUtils.beginTrace();
		filterChain.doFilter(request, response);
		TraceUtils.endTrace();
	}

	public void init(FilterConfig config) throws ServletException {
	}

}
