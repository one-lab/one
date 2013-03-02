package com.sinosoft.one.monitor.log;


/**
 * 响应时间.
 * User: carvin
 * Date: 13-3-2
 * Time: 下午10:47
 * To change this template use File | Settings | File Templates.
 */
public class UrlResponseTime {
	private String url;
	private String urlId;
	private long responseTime;
	private long recordTime = System.currentTimeMillis();

	public UrlResponseTime(String url, String urlId, long responseTime) {
		this.url = url;
		this.urlId = urlId;
		this.responseTime = responseTime;
	}
}
