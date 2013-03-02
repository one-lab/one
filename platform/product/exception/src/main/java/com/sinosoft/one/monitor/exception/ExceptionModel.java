package com.sinosoft.one.monitor.exception;

import com.alibaba.fastjson.JSON;
import com.sinosoft.one.monitor.notification.NotificationModel;
import com.sinosoft.one.monitor.notification.NotificationType;

/**
 * 异常信息.
 * User: carvin
 * Date: 13-3-3
 * Time: 上午12:14
 * To change this template use File | Settings | File Templates.
 */
public class ExceptionModel implements NotificationModel {
	private String urlTraceId;
	private String recordTime;
	private String exceptionStackTrace;

	public ExceptionModel(String urlTraceId, String recordTime, String exceptionStackTrace) {
		this.urlTraceId = urlTraceId;
		this.recordTime = recordTime;
		this.exceptionStackTrace = exceptionStackTrace;
	}

	public String getUrlTraceId() {
		return urlTraceId;
	}

	public void setUrlTraceId(String urlTraceId) {
		this.urlTraceId = urlTraceId;
	}

	public String getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}

	public String getExceptionStackTrace() {
		return exceptionStackTrace;
	}

	public void setExceptionStackTrace(String exceptionStackTrace) {
		this.exceptionStackTrace = exceptionStackTrace;
	}

	@Override
	public NotificationType notificationType() {
		return NotificationType.EXCEPTION;
	}

	@Override
	public String data() {
		return JSON.toJSONString(this);
	}
}
