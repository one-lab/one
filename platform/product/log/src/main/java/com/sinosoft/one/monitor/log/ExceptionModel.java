package com.sinosoft.one.monitor.log;

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
	/**
	 * 记录时间
	 */
	private String recordTime;
	/**
	 * 请求URL
	 */
	private String url;
	/**
	 * 请求参数信息
	 */
	private String requestParams;
	/**
	 * 异常堆栈
	 */
	private String exceptionStackTrace;

	public ExceptionModel(String url, String recordTime, String exceptionStackTrace) {
		this.url = url;
		this.recordTime = recordTime;
		this.exceptionStackTrace = exceptionStackTrace;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRequestParams() {
		return requestParams;
	}

	public void setRequestParams(String requestParams) {
		this.requestParams = requestParams;
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
