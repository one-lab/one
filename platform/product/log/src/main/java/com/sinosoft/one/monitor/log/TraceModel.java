package com.sinosoft.one.monitor.log;

/**
 * 跟踪对象.
 * User: carvin
 * Date: 13-3-7
 * Time: 下午7:16
 */
public class TraceModel {
	private int index;
	private long beginTime = System.currentTimeMillis();
	private String url;
	private String urlId;
	private String traceId;
	private UrlTraceLog urlTraceLog;
	private String requestParams;
	private boolean exception;

	public boolean hasException() {
		return exception;
	}

	public void setException(boolean exception) {
		this.exception = exception;
	}

	public long getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(long beginTime) {
		this.beginTime = beginTime;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public UrlTraceLog getUrlTraceLog() {
		return urlTraceLog;
	}

	public void setUrlTraceLog(UrlTraceLog urlTraceLog) {
		this.urlTraceLog = urlTraceLog;
	}

	public String getUrlId() {
		return urlId;
	}

	public void setUrlId(String urlId) {
		this.urlId = urlId;
	}

	public String getRequestParams() {
		return requestParams;
	}

	public void setRequestParams(String requestParams) {
		this.requestParams = requestParams;
	}

	public void increaseIndex() {
		this.index++;
	}

	public void decreaseIndex() {
		this.index--;
	}

	public int getIndex() {
		return index;
	}
}
