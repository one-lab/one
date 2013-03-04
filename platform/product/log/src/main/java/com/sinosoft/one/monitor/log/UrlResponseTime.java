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
}
