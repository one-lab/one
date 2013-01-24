package com.sinosoft.one.log.userbehavior;

import com.sinosoft.one.log.*;
import com.sinosoft.one.log.event.LogEventSupport;
import com.sinosoft.one.util.encode.JsonBinder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 用户行为日志类
 * User: carvin
 * Date: 12-11-28
 * Time: 上午12:31
 *
 */
public class UserBehaviorLog extends AbstractLoggable implements Loggable {
    private String id;
    private String url;
    private Timestamp visitTime;
    private String paramInfoes;
    private String sessionId;
    private String userIp;

    private LogEventSupport logEventSupport;

    public UserBehaviorLog(boolean isSynchronized) {
        if(isSynchronized) {
            logHandler = Loggables.getUserBehaviorLogSynchronizedHandlerHandler();
        } else {
            logHandler = Loggables.getUserBehaviorLogQueueHandler();
            this.logEventSupport = Loggables.getLogEventSupport();
        }
    }
    public UserBehaviorLog() {
       this(true);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Timestamp visitTime) {
        this.visitTime = visitTime;
    }

    public String getParamInfoes() {
        return paramInfoes;
    }

    public void setParamInfoes(String paramInfoes) {
        this.paramInfoes = paramInfoes;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public static UserBehaviorLog valueOf(HttpServletRequest request, boolean isSynchronized) {
        UserBehaviorLog userBehaviorLog = new UserBehaviorLog(isSynchronized);
        userBehaviorLog.setId(UUID.randomUUID().toString().replace("-", ""));
        userBehaviorLog.setUrl(request.getRequestURI());
        userBehaviorLog.setParamInfoes(JsonBinder.buildNonNullBinder().toJson(request.getParameterMap()));
        userBehaviorLog.setSessionId(request.getSession(false).getId());
        userBehaviorLog.setVisitTime(new Timestamp(System.currentTimeMillis()));
        userBehaviorLog.setUserIp(request.getRemoteAddr());
        return userBehaviorLog;
    }

    public Map<String, Object> toMap() throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(8);
        resultMap.put("id", id);
        resultMap.put("url", url);
        resultMap.put("visitTime", visitTime);
        resultMap.put("paramInfoes", paramInfoes);
        resultMap.put("sessionId", sessionId);
        resultMap.put("userId", userId);
        resultMap.put("userIp", userIp);
        resultMap.put("appName", appName);
        return resultMap;
    }

    public void appendToQueue() {
        logEventSupport.publish(this);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", id)
            .append("url", url)
            .append("visitTime", visitTime)
            .append("paramInfoes", paramInfoes)
            .append("sessionId", sessionId)
            .append("userId", userId)
            .append("userIp", userIp)
            .append("appName", appName)
            .build();
    }
}
