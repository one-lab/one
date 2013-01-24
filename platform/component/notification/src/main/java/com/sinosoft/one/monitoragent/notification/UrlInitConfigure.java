package com.sinosoft.one.monitoragent.notification;

public interface UrlInitConfigure {
	/**
	 * url路径
	 */
	public String getUrl() ;
	/**
	 * url名称
	 */
	public String getName() ;
	/**
	 * 阀值
	 */
	public String getThreshold() ;
	/**
	 * 环境信息
	 */
	public String getEnvironment();

	/**
	 * 统计频率
	 */
	public String getInterval() ;
}
