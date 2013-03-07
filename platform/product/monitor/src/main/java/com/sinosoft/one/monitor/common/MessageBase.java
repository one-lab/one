package com.sinosoft.one.monitor.common;

import java.util.List;

/**
 * 告警信息接口.
 * User: carvin
 * Date: 13-3-1
 * Time: 下午2:24
 */
public interface MessageBase {
	List<AlarmMessage> alarmMessages();
	AlarmSource alarmSource();
	ResourceType subResourceType();
	String subResourceId();
}
