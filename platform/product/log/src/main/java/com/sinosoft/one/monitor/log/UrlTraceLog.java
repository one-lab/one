package com.sinosoft.one.monitor.log;

import com.alibaba.fastjson.JSON;
import com.sinosoft.one.monitor.notification.NotificationModel;
import com.sinosoft.one.monitor.notification.NotificationServiceFactory;
import com.sinosoft.one.monitor.notification.NotificationType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.*;

/**
 * URL 追踪类
 * User: carvin
 * Date: 12-11-28
 * Time: 上午1:57
 * 用于记录URL追踪信息.
 */
public class UrlTraceLog implements NotificationModel {
	private static final String FORMAT_STRING_PREFIX = "[@UrlTrace]";
	private static final String FORMAT_STRING = FORMAT_STRING_PREFIX  +"{} 在 {} 访问URL {}, 在 {} 结束,经历时长为 " +
			"{}, 访问用户为 {}, 用户IP为 {}, Session Id 为 {}";
	private static final Logger logger = LoggerFactory.getLogger(UrlTraceLog.class);
	/**
	 * 主键ID
	 */
    private String id;
	/**
	 * URL地址
	 */
    private String url;
	/**
	 * 开始时间
	 */
    private Timestamp beginTime;
	/**
	 * 结束时间
	 */
    private Timestamp endTime;
	/**
	 * 花费时间
	 */
    private long consumeTime;
	/**
	 * 会话ID
	 */
    private String sessionId;
	/**
	 * 用户IP
	 */
    private String userIp;
	/**
	 * 请求参数信息
	 */
    private String requestParams;
	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * URL ID
	 */
	private String urlId;
	/**
	 * 告警信息ID
	 */
	private String alarmId;
	/**
	 * 是否有异常
	 */
	private boolean hasException;


	List<MethodTraceLog> methodTraceLogList = new ArrayList<MethodTraceLog>();

    public UrlTraceLog() {
		userId = Loggables.getUserId();
		username = Loggables.getUserName();
	    id = UUID.randomUUID().toString().replace("-", "");
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
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

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public long getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(long consumeTime) {
        this.consumeTime = consumeTime;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

	public String getRequestParams() {
		return requestParams;
	}

	public void setRequestParams(String requestParams) {
		this.requestParams = requestParams;
	}

	public String getUrlId() {
		return urlId;
	}

	public void setUrlId(String urlId) {
		this.urlId = urlId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(String alarmId) {
		this.alarmId = alarmId;
	}

	public boolean getHasException() {
		return hasException;
	}

	public void setHasException(boolean hasException) {
		this.hasException = hasException;
	}

	public void addMethodTraceLog(MethodTraceLog methodTraceLog) {
		this.methodTraceLogList.add(methodTraceLog);
	}

	public List<MethodTraceLog> getMethodTraceLogList() {
		return methodTraceLogList;
	}

    public static long endTrace(HttpServletRequest request, TraceModel traceModel) {
	    UrlTraceLog targetURLTraceLog = traceModel.getUrlTraceLog();
        targetURLTraceLog.setUrl(traceModel.getUrl());
        long endTime = System.currentTimeMillis();
        targetURLTraceLog.setEndTime(new Timestamp(endTime));
        targetURLTraceLog.setConsumeTime(endTime - targetURLTraceLog.getBeginTime().getTime());
        targetURLTraceLog.setSessionId(request.getSession().getId());
        targetURLTraceLog.setRequestParams(traceModel.getRequestParams());
	    targetURLTraceLog.setHasException(traceModel.hasException());
		logger.debug(FORMAT_STRING, targetURLTraceLog.toObjectArray());
	    NotificationServiceFactory.buildNotificationService().notification(targetURLTraceLog);
	    return endTime;
    }



	public Object[] toObjectArray() {
		return new Object[]{
			id,
			url,
			beginTime,
			endTime,
			consumeTime,
			userId,
			userIp,
			sessionId
		};
	}
    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", id)
            .append("url", url)
            .append("beginTime", beginTime)
            .append("endTime", endTime)
            .append("consumeTime", consumeTime)
            .append("sessionId", sessionId)
            .append("userId", userId)
            .append("userIp", userIp)
            .build();
    }

	@Override
	public NotificationType notificationType() {
		return NotificationType.LOG;
	}

	@Override
	public String data() {
		return JSON.toJSONStringWithDateFormat(this, "yyyy-MM-dd HH:mm:ss");
	}
}
