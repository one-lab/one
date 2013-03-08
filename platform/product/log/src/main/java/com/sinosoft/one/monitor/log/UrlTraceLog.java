package com.sinosoft.one.monitor.log;

import com.alibaba.fastjson.JSON;
import com.sinosoft.one.monitor.notification.NotificationModel;
import com.sinosoft.one.monitor.notification.NotificationServiceFactory;
import com.sinosoft.one.monitor.notification.NotificationType;
import org.apache.commons.lang3.builder.ToStringBuilder;

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
	 * URL ID
	 */
	private String urlId;

	List<MethodTraceLog> methodTraceLogList = new ArrayList<MethodTraceLog>();

    public UrlTraceLog() {
		userId = Loggables.getUserId();
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

	public void addMethodTraceLog(MethodTraceLog methodTraceLog) {
		this.methodTraceLogList.add(methodTraceLog);
	}

	public List<MethodTraceLog> getMethodTraceLogList() {
		return methodTraceLogList;
	}

	public static UrlTraceLog beginTrace() {
        UrlTraceLog urlTraceLog = new UrlTraceLog();
        urlTraceLog.setBeginTime(new Timestamp(System.currentTimeMillis()));
        return urlTraceLog;
    }

    public static long endTrace(HttpServletRequest request, TraceModel traceModel) {
	    UrlTraceLog targetURLTraceLog = traceModel.getUrlTraceLog();
        targetURLTraceLog.setUrl(traceModel.getUrl());
        long endTime = System.currentTimeMillis();
        targetURLTraceLog.setEndTime(new Timestamp(endTime));
        targetURLTraceLog.setConsumeTime(endTime - targetURLTraceLog.getBeginTime().getTime());
        targetURLTraceLog.setSessionId(request.getSession().getId());
        targetURLTraceLog.setUserIp(TraceUtils.getIPAddr(request));
        targetURLTraceLog.setRequestParams(traceModel.getRequestParams());
	    NotificationServiceFactory.buildNotificationService().notification(targetURLTraceLog);
	    return endTime;
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
