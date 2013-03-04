package com.sinosoft.one.monitor.common;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 13-3-5
 * Time: 上午1:00
 * To change this template use File | Settings | File Templates.
 */

public class AlarmMessageHandlerHelpers {
	private static AlarmMessageHandler alarmMessageHandler;

	public void setAlarmMessageHandler(AlarmMessageHandler alarmMessageHandler) {
		AlarmMessageHandlerHelpers.alarmMessageHandler = alarmMessageHandler;
	}

	public static AlarmMessageHandler getAlarmMessageHandler() {
		return alarmMessageHandler;
	}
}
