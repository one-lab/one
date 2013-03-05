package com.sinosoft.one.monitor.log;


import java.util.Date;

/**
 * 响应时间.
 * User: carvin
 * Date: 13-3-2
 * Time: 下午10:47
 */
public class UrlResponseTime {
	/**
	 * URL
	 */
	private String url;
	/**
	 * URLID
	 */
	private String urlId;
	/**
	 * 响应时间
	 */
	private long responseTime;
	/**
	 * 记录时间
	 */
	private Date recordTime = new Date();

	public UrlResponseTime(String url, String urlId, long responseTime) {
		this.url = url;
		this.urlId = urlId;
		this.responseTime = responseTime;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlId() {
		return urlId;
	}

	public void setUrlId(String urlId) {
		this.urlId = urlId;
	}

	public long getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(long responseTime) {
		this.responseTime = responseTime;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
}
