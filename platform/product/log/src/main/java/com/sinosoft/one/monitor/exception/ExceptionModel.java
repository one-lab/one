package com.sinosoft.one.monitor.exception;

import com.alibaba.fastjson.JSON;
import com.sinosoft.one.monitor.notification.NotificationModel;
import com.sinosoft.one.monitor.notification.NotificationType;

import java.util.Date;

/**
 * 异常信息.
 * User: carvin
 * Date: 13-3-3
 * Time: 上午12:14
 * To change this template use File | Settings | File Templates.
 */
public class ExceptionModel implements NotificationModel {
	private static final String FORMAT_STRING_PREFIX = "[@Exception]";
	public static final String FORMAT_STRING = FORMAT_STRING_PREFIX  + "[@traceId={}], 访问URL{}发生异常， 请求参数为{}, 异常信息为{}";
	/**
	 * URL追踪ID
	 */
	private String urlTraceId;
	/**
	 * 记录时间
	 */
	private Date recordTime = new Date();
	/**
	 * 异常堆栈
	 */
	private String exceptionStackTrace;
	/**
	 * 异常描述
	 */
	private String exceptionDescription;
	/**
	 * URL地址
	 */
	private String url;
	/**
	 * URL请求参数
	 */
	private String requestParams;

	public ExceptionModel(String urlTraceId,  String exceptionDescription,  String exceptionStackTrace) {
		this.urlTraceId = urlTraceId;
		this.exceptionDescription = exceptionDescription;
		this.exceptionStackTrace = exceptionStackTrace;
	}

	public String getUrlTraceId() {
		return urlTraceId;
	}

	public void setUrlTraceId(String urlTraceId) {
		this.urlTraceId = urlTraceId;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	public String getExceptionDescription() {
		return exceptionDescription;
	}

	public void setExceptionDescription(String exceptionDescription) {
		this.exceptionDescription = exceptionDescription;
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

	public Object[] toObjectArray() {
		return new Object[]{
				urlTraceId,
				url,
				requestParams,
				exceptionStackTrace
		};
	}

	@Override
	public NotificationType notificationType() {
		return NotificationType.EXCEPTION;
	}

	@Override
	public String data() {
		return JSON.toJSONStringWithDateFormat(this, "yyyy-MM-dd HH:mm:ss");
	}
}
