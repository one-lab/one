package com.sinosoft.one.log.webfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.sinosoft.one.log.config.LogConfigs;
import com.sinosoft.one.log.TraceUtils;
import com.sinosoft.one.log.config.LogUrl;
import com.sinosoft.one.log.urltrace.URLTraceLog;
import com.sinosoft.one.log.userbehavior.UserBehaviorLog;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class TraceFilter implements Filter {

    private URLTraceLog urlTraceLog;
    private Logger dbLogger = LoggerFactory.getLogger("DBLog");
    private boolean userBehaviorLogSynchronized = true;
    private LogUrl logUrl;

    private LogConfigs logConfigs;
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        doUserBehaviorLog(httpServletRequest);
        doUrlTraceLogBegin(httpServletRequest);
        filterChain.doFilter(request, response);
        doUrlTraceLogEnd(httpServletRequest);
	}

	public void init(FilterConfig config) throws ServletException {
        String userBehaviorLogSynchronizedStr = config.getInitParameter("userBehaviorLogSynchronized");
        if(!StringUtils.isBlank(userBehaviorLogSynchronizedStr)) {
            userBehaviorLogSynchronized = Boolean.valueOf(userBehaviorLogSynchronizedStr);
        }
    }

    private void doUserBehaviorLog(HttpServletRequest request) {
        UserBehaviorLog userBehaviorLog = UserBehaviorLog.valueOf(request, userBehaviorLogSynchronized);
        if(userBehaviorLogSynchronized) {
            userBehaviorLog.doHandler();
        } else {
            userBehaviorLog.appendToQueue();
        }
    }

    private void doUrlTraceLogBegin(HttpServletRequest request) {
        String url = request.getRequestURI();
        if(logConfigs == null) {
            setLogConfigsFromRequest(request);
        }
        if(logConfigs != null) {
            logUrl = logConfigs.getLogUrl(url);
        }
        if(logUrl != null) {
            TraceUtils.beginTrace();
            urlTraceLog = URLTraceLog.beginTrace();
        }
    }

    private void doUrlTraceLogEnd(HttpServletRequest request) {
        if(urlTraceLog != null) {
            URLTraceLog.endTrace(request, urlTraceLog);
            if(urlTraceLog.getConsumeTime() > logUrl.getMaxExecuteTime()) {
                // TODO 向监控系统发送预警信息
            }
            TraceUtils.endTrace();
        }
    }

    private void setLogConfigsFromRequest(HttpServletRequest request) {
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
        logConfigs = webApplicationContext != null ? webApplicationContext.getBean(LogConfigs.class) : null;
    }

    public void setLogConfigs(LogConfigs logConfigs) {
        this.logConfigs = logConfigs;
    }
}
