package com.sinosoft.one.monitor.notification;

/**
 * 通知类型
 * User: carvin
 * Date: 13-3-2
 * Time: 下午5:23
 */
public enum NotificationType {
	LOG("/"),
	EXCEPTION(""),
	URLRESPONSETIME("");

	private String _url;
	private NotificationType(String url) {
		this._url = url;
	}

	public String url() {
		return _url;
	}
}
