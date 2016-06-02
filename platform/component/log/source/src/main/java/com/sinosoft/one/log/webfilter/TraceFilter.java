package com.sinosoft.one.log.webfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.sinosoft.one.log.Loggables;
import com.sinosoft.one.log.config.LogConfigs;
import com.sinosoft.one.log.TraceUtils;
import com.sinosoft.one.log.config.LogUrl;
import com.sinosoft.one.log.urltrace.URLTraceLog;
import com.sinosoft.one.log.userbehavior.UserBehaviorLog;
import com.sinosoft.one.monitoragent.notification.NotificationEvent;
import com.sinosoft.one.monitoragent.notification.NotificationModule;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class TraceFilter implements Filter {

    private boolean userBehaviorLogSynchronized = true;

    private LogConfigs logConfigs;

    private Boolean urlTraceFlag =false;

    public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        URLTraceLog urlTraceLog= null;

        if(urlTraceFlag){
            doUserBehaviorLog(httpServletRequest);
            urlTraceLog= doUrlTraceLogBegin(httpServletRequest);
        }

        TraceUtils.beginTrace();
        filterChain.doFilter(request, response);
        TraceUtils.endTrace();

        if(urlTraceFlag&&urlTraceLog!=null)
            doUrlTraceLogEnd(httpServletRequest,urlTraceLog);
	}

	public void init(FilterConfig config) throws ServletException {
        String userBehaviorLogSynchronizedStr = config.getInitParameter("userBehaviorLogSynchronized");
        String urlFlag = config.getInitParameter("url");
        if(!StringUtils.isBlank(userBehaviorLogSynchronizedStr)) {
            userBehaviorLogSynchronized = Boolean.valueOf(userBehaviorLogSynchronizedStr);
        }
        if(!StringUtils.isNotBlank(urlFlag)){
            urlTraceFlag = Boolean.valueOf(urlFlag);
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

    private URLTraceLog doUrlTraceLogBegin(HttpServletRequest request) {
        String url = request.getRequestURI();
        URLTraceLog urlTraceLog =null;
        LogUrl logUrl =null;
        if(logConfigs == null) {
            setLogConfigsFromRequest(request);
        }
        if(logConfigs != null) {
             logUrl = logConfigs.getLogUrl(url);
        }
        if(logUrl != null) {
            urlTraceLog = URLTraceLog.beginTrace(logUrl);
        }
        return urlTraceLog;
    }

    private void doUrlTraceLogEnd(HttpServletRequest request, URLTraceLog urlTraceLog) {
            URLTraceLog.endTrace(request, urlTraceLog);
            if(urlTraceLog.getConsumeTime() > urlTraceLog.getLogUrl().getMaxExecuteTime()) {
                String title = "URL [" + urlTraceLog.getUrl() + "] 追踪日志预警";
                String content = "URL [" + urlTraceLog.getUrl() + "] 响应超时，最大响应时间为["
                        + urlTraceLog.getLogUrl().getMaxExecuteTime() + "]ms，实际响应时间为[" + urlTraceLog.getConsumeTime() + "]ms.";
                NotificationEvent notificationEvent = new NotificationEvent(title, content, "",
                        NotificationModule.RESPONSE, "");
                Loggables.notification(notificationEvent);
            }

            Loggables.doLogStatistics(urlTraceLog.getUrl(), urlTraceLog.getConsumeTime());
    }

    private void setLogConfigsFromRequest(HttpServletRequest request) {
        WebApplicationContext webApplicationContext = getWebApplicationContext(request);
        logConfigs = webApplicationContext != null ? webApplicationContext.getBean(LogConfigs.class) : null;
        if(logConfigs!=null&&urlTraceFlag)
            logConfigs.loadRemoteConfig();
    }


    private WebApplicationContext getWebApplicationContext(HttpServletRequest request) {
        return WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
    }

    public void setLogConfigs(LogConfigs logConfigs) {
        this.logConfigs = logConfigs;
    }
}
