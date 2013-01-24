package com.sinosoft.one.monitoragent.notification;

public enum Grade {
	/**
	 * 普通
	 */
	COMMON("00"),
	/**
	 * 紧急
	 */
	URGENT("01"),
	/**
	 * 非常紧急
	 */
	URGENTER("02"),

	/**
	 * 异常紧急
	 */
	URGENTEST("03");

	private String value;

	private Grade(String value) {
		this.value = value;
	}

	public String toString() {
		return this.value;
	}
}
