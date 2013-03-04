package com.sinosoft.one.monitor.log;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;


public class AgentFilter implements Filter {

    private UrlTraceLog urlTraceLog;
	private ApplicationContext applicationContext;

    private LogConfigs logConfigs;
	private String url;
	private String urlId;

	private static final String DEFAULT_EXCLUDE_EXTENSIONS = "jspx,js,css,gif,png,jpg,jpeg,bmp,html,htm,swf,jsp";
	private String[] excludeExtensions = new String[0];

	public void destroy() {}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		url = httpServletRequest.getRequestURI();

		if(isExclude(url)) {
			filterChain.doFilter(request, response);
		} else {
			long beginTime = System.currentTimeMillis();
	        doUrlTraceLogBegin(httpServletRequest);
	        filterChain.doFilter(request, response);
	        long endTime = doUrlTraceLogEnd(httpServletRequest);
			UrlResponseTimeEventSupport.build().publish(new UrlResponseTime(url, urlId, endTime-beginTime));
		}
	}

	public void init(FilterConfig config) throws ServletException {
		ApplicationContext oldRootContext = (ApplicationContext) config.getServletContext().getAttribute(
				WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		if(oldRootContext == null) {
	        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-log.xml");
			logConfigs = (LogConfigs)applicationContext.getBean("logConfigs");
			excludeExtensions = DEFAULT_EXCLUDE_EXTENSIONS.split(",");
		}
    }

    private void doUrlTraceLogBegin(HttpServletRequest request) {
        if(logConfigs != null) {
	        urlId = logConfigs.isMonitorUrl(url);
           if(urlId != null) {
	           urlTraceLog = UrlTraceLog.beginTrace();
	           urlTraceLog.setUrlId(urlId);
	           TraceUtils.beginTrace(urlTraceLog, urlId);
           } else {
	           TraceUtils.beginTraceForNoMonitorURL(url, JSON.toJSONString(request.getParameterMap()));
           }
        } else {
	        urlId = null;
        }
    }

    private long doUrlTraceLogEnd(HttpServletRequest request) {
	    long endTime = 0l;
        if(urlTraceLog != null) {
            endTime = UrlTraceLog.endTrace(request, urlTraceLog);
            TraceUtils.endTrace();
        } else {
	        TraceUtils.endTraceForNoMonitorURL();
	        endTime = System.currentTimeMillis();
        }
	    return endTime;
    }

	private boolean isExclude(String url) {
		String extension;
		int lastIndex = url.lastIndexOf(".");
		if(lastIndex != -1) {
			extension = url.substring(lastIndex + 1);
			for(int i=0, len=excludeExtensions.length; i<len; i++) {
				if(extension.equalsIgnoreCase(excludeExtensions[i])) {
					return true;
				}
			}
		}
		return false;
	}
}
