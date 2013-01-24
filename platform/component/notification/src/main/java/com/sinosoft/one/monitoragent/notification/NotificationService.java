package com.sinosoft.one.monitoragent.notification;

import java.util.List;

/**
 * 监控前端理服务接口
 */
public interface NotificationService {
	public void notification(NotificationEvent event);
	/**
	 * 获取方法的配置信息
	 * @return
	 */
	public List<MethodInitConfigure> getMethodInitConfigure();
	/**
	 * 获取url的配置信息
	 * @return
	 */
	public List<UrlInitConfigure> getUrlInitConfigure();
}
