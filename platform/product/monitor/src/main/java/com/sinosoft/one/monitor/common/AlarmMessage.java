package com.sinosoft.one.monitor.common;

import java.math.BigDecimal;
import java.util.List;

/**
 * 告警消息
 * User: carvin
 * Date: 13-3-1
 * Time: 下午2:34
 *
 */
public final class AlarmMessage {
	private String resourceId;
	private String attributeName;
	private BigDecimal attributeValue;
	private AlarmMessage() {

	}

	public static AlarmMessage valueOf(String resourceId, String attributeName, String attributeValue) {
		AlarmMessage alarmMessage = new AlarmMessage();
		alarmMessage.resourceId = resourceId;
		alarmMessage.attributeName = attributeName;
		alarmMessage.attributeValue = new BigDecimal(attributeValue);
		return alarmMessage;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public BigDecimal getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(BigDecimal attributeValue) {
		this.attributeValue = attributeValue;
	}

	public boolean isAvailabilityAlarm() {
		return AttributeNames.Availability.name().equals(this.attributeName);
	}

	public boolean isExceptionAlarm() {
		return AttributeNames.Health.name().equals(this.attributeName);
	}
}
