package com.sinosoft.one.monitor.common;

import java.util.List;
import java.util.UUID;

/**
 * MessageBase 的默认实现类.
 * User: carvin
 * Date: 13-3-6
 * Time: 下午11:18
 */
public abstract class AbstractMessageBase implements MessageBase {
	@Override
	public abstract List<AlarmMessage> alarmMessages();

	@Override
	public abstract AlarmSource alarmSource();

	@Override
	public ResourceType subResourceType() {
		return ResourceType.NONE;
	};

	@Override
	public String subResourceId() {
		return "";
	}
}
