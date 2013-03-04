package com.sinosoft.one.monitor.common;

import com.sinosoft.one.monitor.action.domain.ActionService;
import com.sinosoft.one.monitor.alarm.domain.AlarmService;
import com.sinosoft.one.monitor.alarm.model.Alarm;
import com.sinosoft.one.monitor.attribute.domain.AttributeCache;
import com.sinosoft.one.monitor.attribute.model.Attribute;
import com.sinosoft.one.monitor.attribute.model.AttributeAction;
import com.sinosoft.one.monitor.resources.domain.ResourcesCache;
import com.sinosoft.one.monitor.resources.model.Resource;
import com.sinosoft.one.monitor.threshold.domain.ThresholdService;
import com.sinosoft.one.monitor.threshold.model.SeverityLevel;
import com.sinosoft.one.monitor.threshold.model.Threshold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 告警信息处理类.
 * User: carvin
 * Date: 13-3-1
 * Time: 下午3:57
 */

public class AlarmMessageHandler {
	@Autowired
	private AlarmService alarmService;
	@Autowired
	private AttributeCache attributeCache;
	@Autowired
	private ResourcesCache resourcesCache;
	@Autowired
	private ThresholdService thresholdService;
	@Autowired
	private ActionService actionService;

	/**
	 * 处理告警消息
	 * @param messageBase
	 */
	public void doMessage(MessageBase messageBase, String alarmId) {
		ThresholdAlarmParams thresholdAlarmParams = new ThresholdAlarmParams();
		thresholdAlarmParams.alarmId = alarmId;
		List<AlarmMessage> alarmMessageList = messageBase.alarmMessages();
		for(int i=0, len=alarmMessageList.size(); i<len; i++) {
			AlarmMessage alarmMessage = alarmMessageList.get(i);
			String resourceId = alarmMessage.getResourceId();
			if(thresholdAlarmParams.resource == null) {
				//获取资源
				thresholdAlarmParams.resource = resourcesCache.getResource(resourceId);
				if(thresholdAlarmParams.resource == Resource.EMPTY) {
					return;
				}
			}

			if(alarmMessage.isAvailabilityAlarm()) {
				thresholdAlarmParams.isAvailabilityAlarm = true;
				thresholdAlarmParams.severityLevel = SeverityLevel.CRITICAL;
				thresholdAlarmParams.availabilityAttributeActions = actionService.queryAttributeActions(resourceId, AttributeName.Availability.name(), SeverityLevel.CRITICAL);
				if(thresholdAlarmParams.healthAttributeActions == null) {
					thresholdAlarmParams.healthAttributeActions = actionService.queryAttributeActions(resourceId, AttributeName.Health.name(), SeverityLevel.CRITICAL);
				}
				break;
			}

			if(alarmMessage.isExceptionAlarm()) {
				thresholdAlarmParams.isExceptionAlarm = true;
				thresholdAlarmParams.severityLevel = SeverityLevel.CRITICAL;

				thresholdAlarmParams.exceptionAttributeActions = actionService.queryAttributeActions(resourceId, AttributeName.Exception.name(), SeverityLevel.CRITICAL);
				break;
			}

			//获取属性
			Attribute attribute = attributeCache.getAttributeId(thresholdAlarmParams.resource.getResourceType() + "#" + alarmMessage.getAttributeName());
			if(attribute == Attribute.EMPTY) {
				return;
			}

			//获取阈值
			Threshold threshold = thresholdService.queryThreshold(resourceId, attribute.getId());
			//获取严重级别
			SeverityLevel severityLevel = threshold.evalSeverityLevel(alarmMessage.getAttributeValue());

			if(severityLevel == SeverityLevel.CRITICAL || severityLevel == SeverityLevel.WARNING) {
				thresholdAlarmParams.severityLevel = severityLevel;
				ThresholdAlarmInfo thresholdAlarmInfo = new ThresholdAlarmInfo();
				thresholdAlarmInfo.setThreshold(threshold);
				thresholdAlarmInfo.setAttribute(attribute);

				if(thresholdAlarmParams.healthAttributeActions == null) {
					thresholdAlarmParams.healthAttributeActions = actionService.queryAttributeActions(resourceId, AttributeName.Health.name(), severityLevel);
				}
				List<AttributeAction> thresholdAttributeActions = actionService.queryAttributeActions(resourceId, attribute.getId(), severityLevel);
				thresholdAlarmInfo.setThresholdAttributeActions(thresholdAttributeActions);
				thresholdAlarmParams.thresholdAlarmInfos.add(thresholdAlarmInfo);
			}
		}
		doAlarm(thresholdAlarmParams);
	}

	/**
	 * 告警
	 * @param thresholdAlarmParams 参数
	 */
	private void doAlarm(ThresholdAlarmParams thresholdAlarmParams) {

		if(thresholdAlarmParams.severityLevel == SeverityLevel.UNKNOW) {
			return;
		}

		StringBuilder alarmMessageBuilder = new StringBuilder();
		List<AttributeAction> allAttributeActions = new ArrayList<AttributeAction>();
		alarmMessageBuilder.append(thresholdAlarmParams.resource.getResourceName() + "的健康状况为" + thresholdAlarmParams.severityLevel.cnName());
		alarmMessageBuilder.append("<br>根本原因");

		if(thresholdAlarmParams.isAvailabilityAlarm) {
			alarmMessageBuilder.append("<br> ").append(thresholdAlarmParams.resource.getResourceName()).append("不可用");
			if(thresholdAlarmParams.availabilityAttributeActions != null && thresholdAlarmParams.availabilityAttributeActions.size() > 0) {
				allAttributeActions.addAll(thresholdAlarmParams.availabilityAttributeActions);
			}
		} else if(thresholdAlarmParams.isExceptionAlarm) {
			alarmMessageBuilder.append("<br> ").append(thresholdAlarmParams.resource.getResourceName()).append("发生异常");
			if(thresholdAlarmParams.exceptionAttributeActions != null && thresholdAlarmParams.exceptionAttributeActions.size() > 0) {
				allAttributeActions.addAll(thresholdAlarmParams.exceptionAttributeActions);
			}
		} else {
			int index = 1;
			for(ThresholdAlarmInfo thresholdAlarmInfo : thresholdAlarmParams.thresholdAlarmInfos) {
				Threshold threshold = thresholdAlarmInfo.getThreshold();
				Attribute attribute = thresholdAlarmInfo.getAttribute();

				alarmMessageBuilder.append("<br>").append(index).append(".").append(attribute.getAttributeCn())
						.append(" ").append(threshold.getResultMessage()).append(" ").append(attribute.getUnits())
						.append(" （阈值) ");

				allAttributeActions.addAll(thresholdAlarmInfo.getThresholdAttributeActions());
			}
		}

		if(thresholdAlarmParams.healthAttributeActions != null && thresholdAlarmParams.healthAttributeActions.size() > 0) {
			allAttributeActions.addAll(thresholdAlarmParams.healthAttributeActions);
		}

		// 保存告警信息
		Alarm alarm = new Alarm(thresholdAlarmParams.alarmId);
		Attribute attribute = attributeCache.getAttributeId(thresholdAlarmParams.resource.getResourceType() + "#" + AttributeName.Health);
		alarm.setAlarmSource(thresholdAlarmParams.alarmSource);
		alarm.setAttributeId(attribute.getId());
		alarm.setMonitorId(thresholdAlarmParams.resource.getResourceId());
		alarm.setMonitorType(thresholdAlarmParams.resource.getResourceType());
		alarm.setSeverity(thresholdAlarmParams.severityLevel);
		alarm.setMessage(alarmMessageBuilder.toString());
		alarm.setCreateTime(new Date());
		alarmService.saveAlarm(alarm);

		// 处理动作
		if(allAttributeActions != null && allAttributeActions.size() > 0) {
			actionService.doActions(allAttributeActions, thresholdAlarmParams.resource, attribute, thresholdAlarmParams.severityLevel, alarmMessageBuilder.toString());
		}
	}


	private class ThresholdAlarmInfo {
		private Threshold threshold;
		private Attribute attribute;
		private List<AttributeAction> thresholdAttributeActions;

		public Threshold getThreshold() {
			return threshold;
		}

		public void setThreshold(Threshold threshold) {
			this.threshold = threshold;
		}


		public Attribute getAttribute() {
			return attribute;
		}

		public void setAttribute(Attribute attribute) {
			this.attribute = attribute;
		}

		public List<AttributeAction> getThresholdAttributeActions() {
			return thresholdAttributeActions;
		}

		public void setThresholdAttributeActions(List<AttributeAction> thresholdAttributeActions) {
			this.thresholdAttributeActions = thresholdAttributeActions;
		}
	}

	private class ThresholdAlarmParams {
		private String alarmId;
		private Resource resource;
		private AlarmSource alarmSource;
		private boolean isAvailabilityAlarm;
		private boolean isExceptionAlarm;
		private SeverityLevel severityLevel = SeverityLevel.UNKNOW;
		private List<AttributeAction> healthAttributeActions;
		private List<AttributeAction> availabilityAttributeActions;
		private List<AttributeAction> exceptionAttributeActions;
		private List<ThresholdAlarmInfo> thresholdAlarmInfos = new ArrayList<ThresholdAlarmInfo>();;
	}
}
