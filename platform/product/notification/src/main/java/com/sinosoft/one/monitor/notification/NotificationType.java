package com.sinosoft.one.monitor.notification;

/**
 * 通知类型
 * User: carvin
 * Date: 13-3-2
 * Time: 下午5:23
 */
public enum NotificationType {
	LOG("/application/agent/message"),
	EXCEPTION("/application/agent/message"),
	URLRESPONSETIME("/application/agent/message");

	private String _url;
	private NotificationType(String url) {
		this._url = url;
	}

	public String url() {
		return _url;
	}
}
