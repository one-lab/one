package com.sinosoft.one.monitor.log;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;

import com.sinosoft.one.monitor.notification.NotificationConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;


public class AgentFilter implements Filter {
	private ApplicationContext applicationContext;
    private LogConfigs logConfigs;
    private static Logger logger = LoggerFactory.getLogger(AgentFilter.class);
	private static final String DEFAULT_EXCLUDE_EXTENSIONS = "jspx,js,css,gif,png,jpg,jpeg,bmp,html,htm,swf";
	private String[] excludeExtensions = new String[0];

	public void destroy() {}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String url = httpServletRequest.getRequestURI();

		String extension = getExtension(url);
		if(isExclude(extension)) {
			filterChain.doFilter(request, response);
		} else {
			String ip = TraceUtils.getIPAddr(httpServletRequest);
			logger.debug("本地IP",ip);
			logger.info("监控服务IP",NotificationConfiguration.getInstance().getMonitorServerIp());
			if(ip.equals(NotificationConfiguration.getInstance().getMonitorServerIp())) {
				filterChain.doFilter(request, response);
				return;
			}
			TraceModel traceModel = TraceUtils.getTraceModel();
			if(traceModel == null) {
				traceModel = new TraceModel();

				if(logConfigs != null) {
					String urlId = logConfigs.isMonitorUrl(url);
					if(urlId != null) {
						UrlTraceLog urlTraceLog = new UrlTraceLog();
						urlTraceLog.setUrlId(urlId);
						urlTraceLog.setBeginTime(new Timestamp(traceModel.getBeginTime()));
						urlTraceLog.setAlarmId(UUID.randomUUID().toString().replace("-", ""));
						urlTraceLog.setUserIp(ip);
						traceModel.setUrlId(urlId);
						traceModel.setUrlTraceLog(urlTraceLog);
					}

					Enumeration<String> paramNames = httpServletRequest.getParameterNames();
					Map<String, String> requestParameterMap = new HashMap<String, String>();
					while(paramNames.hasMoreElements()) {
						String paramName = paramNames.nextElement();
						requestParameterMap.put(paramName, httpServletRequest.getParameter(paramName));

					}
					traceModel.setRequestParams(JSON.toJSONString(requestParameterMap));
				}
				traceModel.setUrl(logConfigs.getRealPath(url));
				TraceUtils.beginTrace(traceModel);
			} else {
				traceModel.increaseIndex();
			}

			try {
	            filterChain.doFilter(request, response);
			} finally {
				TraceModel resultTraceModel = TraceUtils.getTraceModel();
				if(resultTraceModel.getIndex() == 0 || traceModel.hasException()) {
					doUrlTraceLogEnd(httpServletRequest, resultTraceModel);
				} else {
					resultTraceModel.decreaseIndex();
				}
			}
		}
	}

	public void init(FilterConfig config) throws ServletException {
		ApplicationContext oldRootContext = (ApplicationContext) config.getServletContext().getAttribute(
				WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		if(oldRootContext == null) {
	        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-log.xml");
			logConfigs = (LogConfigs)applicationContext.getBean("logConfigs");
		} else {
			logConfigs = (LogConfigs)oldRootContext.getBean("logConfigs");
		}
		LogTraceAspect.setLogConfigs(logConfigs);
		excludeExtensions = DEFAULT_EXCLUDE_EXTENSIONS.split(",");
    }

    private void doUrlTraceLogEnd(HttpServletRequest request, TraceModel traceModel) {
	    long endTime;
        if(traceModel.getUrlId() != null) {
            endTime = UrlTraceLog.endTrace(request, traceModel);
        } else {
	        endTime = System.currentTimeMillis();
        }
	    try {
	    	logger.debug("获取响应时间");
		    if(!traceModel.hasException()) {
		    	logger.debug("获取响应时间成功");
			    UrlResponseTimeEventSupport.build().publish(new UrlResponseTime(traceModel.getUrl(), traceModel.getUrlId(), endTime-traceModel.getBeginTime()));
		    }
	    } finally {
		    TraceUtils.endTrace();
	    }
    }

	private boolean isExclude(String extension) {
		if(null != extension && !"".equals(extension)) {
			for(int i=0, len=excludeExtensions.length; i<len; i++) {
				if(extension.equalsIgnoreCase(excludeExtensions[i])) {
					return true;
				}
			}
		}
		return false;
	}

	private String getExtension(String url) {
		String extension = "";
		int lastIndex = url.lastIndexOf(".");
		if(lastIndex != -1) {
			extension = url.substring(lastIndex + 1);
		}
		return extension;
	}

	private boolean isAjaxRequest(HttpServletRequest request) {
		String requestType = request.getHeader("X-Requested-With");
		return "XMLHttpRequest".equals(requestType);
	}
}
