/**
 * Copyright (c) 2005-2012 sinosoft.com.cn
 *
 */
package com.sinosoft.one.monitoragent.notification;

/**
 * 通知来源的枚举类
 * 
 * @author zhujinwei
 */
public enum NotificationModule {
	/**
	 * 所有模块
	 */
	ALL("00"),
	/**
	 * 异常模块
	 */
	EXCEPTION("01"),
	/**
	 * 异常模块
	 */
	OSAGENT("02"),

	/**
	 * 测试响应模块
	 */
	RESPONSE("03"),
	/**
	 * 其它模块
	 */
	OTHER("04");

	private String value;

	private NotificationModule(String value) {
		this.value = value;
	}

	public String toString() {
		return this.value;
	}
}
