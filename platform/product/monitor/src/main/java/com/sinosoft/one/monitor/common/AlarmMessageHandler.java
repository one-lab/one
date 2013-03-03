package com.sinosoft.one.monitor.common;

import com.sinosoft.one.monitor.action.domain.ActionService;
import com.sinosoft.one.monitor.action.model.ActionType;
import com.sinosoft.one.monitor.action.model.MailAction;
import com.sinosoft.one.monitor.action.model.MailInfo;
import com.sinosoft.one.monitor.action.model.SmsAction;
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
import org.apache.commons.lang3.StringUtils;
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
@Component
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
	public void doMessage(MessageBase messageBase) {
		Resource resource = null;
		List<AttributeAction> healthAttributeActions = null;
		List<AttributeAction> availabilityAttributeActions = null;
		boolean isAvailabilityAlarm = false;
		SeverityLevel resourceSeverityLevel = SeverityLevel.UNKNOW;
		List<ThresholdAlarmInfo> thresholdAlarmInfoes = new ArrayList<ThresholdAlarmInfo>();

		List<AlarmMessage> alarmMessageList = messageBase.alarmMessages();
		for(int i=0, len=alarmMessageList.size(); i<len; i++) {
			AlarmMessage alarmMessage = alarmMessageList.get(i);
			String resourceId = alarmMessage.getResourceId();
			if(resource == null) {
				//获取资源
				resource = resourcesCache.getResource(resourceId);
				if(resource == Resource.EMPTY) {
					return;
				}
			}

			if(alarmMessage.isAvailabilityAlarm()) {
				isAvailabilityAlarm = true;
				resourceSeverityLevel = SeverityLevel.CRITICAL;
				availabilityAttributeActions = actionService.queryAttributeActions(resourceId, AttributeNames.Availability.name(), SeverityLevel.CRITICAL.name());
				if(healthAttributeActions == null) {
					healthAttributeActions = actionService.queryAttributeActions(resourceId, AttributeNames.Health.name(), SeverityLevel.CRITICAL.name());
				}
				break;
			}

			//获取属性
			Attribute attribute = attributeCache.getAttributeId(resource.getResourceType() + "#" + alarmMessage.getAttributeName());
			if(attribute == Attribute.EMPTY) {
				return;
			}

			//获取阈值
			Threshold threshold = thresholdService.queryThreshold(resourceId, attribute.getId());
			//获取严重级别
			SeverityLevel severityLevel = threshold.evalSeverityLevel(alarmMessage.getAttributeValue());

			if(severityLevel == SeverityLevel.CRITICAL || severityLevel == SeverityLevel.WARNING) {
				resourceSeverityLevel = severityLevel;
				ThresholdAlarmInfo thresholdAlarmInfo = new ThresholdAlarmInfo();
				thresholdAlarmInfo.setThreshold(threshold);
				thresholdAlarmInfo.setAttribute(attribute);

				if(healthAttributeActions == null) {
					healthAttributeActions = actionService.queryAttributeActions(resourceId, AttributeNames.Health.name(), severityLevel.name());
				}
				List<AttributeAction> thresholdAttributeActions = actionService.queryAttributeActions(resourceId, attribute.getId(), severityLevel.name());
				thresholdAlarmInfo.setThresholdAttributeActions(thresholdAttributeActions);
				thresholdAlarmInfoes.add(thresholdAlarmInfo);
			}
		}
		doAlarm(resource, messageBase.alarmSource(),
				isAvailabilityAlarm, resourceSeverityLevel,
				healthAttributeActions, availabilityAttributeActions, thresholdAlarmInfoes);
	}

	/**
	 * 告警
	 * @param resource 资源
	 * @param alarmSource 告警信息来源
	 * @param isAvailabilityAlarm 是否为可用性告警
	 * @param severityLevel 严重级别
	 * @param healthAttributeActions 健康度动作列表
	 * @param availabilityAttributeActions 可用性动作列表
	 * @param thresholdAlarmInfos 阈值告警信息列表
	 */
	private void doAlarm(Resource resource,
	                   AlarmSource alarmSource,
	                   boolean isAvailabilityAlarm,
	                   SeverityLevel severityLevel,
	                   List<AttributeAction> healthAttributeActions,
	                   List<AttributeAction> availabilityAttributeActions,
	                   List<ThresholdAlarmInfo> thresholdAlarmInfos) {

		if(severityLevel == SeverityLevel.UNKNOW) {
			return;
		}

		StringBuilder alarmMessageBuilder = new StringBuilder();
		List<AttributeAction> allAttributeActions = new ArrayList<AttributeAction>();
		alarmMessageBuilder.append(resource.getResourceName() + "的健康状况为" + severityLevel.cnName());
		alarmMessageBuilder.append("<br>根本原因");

		if(isAvailabilityAlarm) {
			alarmMessageBuilder.append("<br> ").append(resource.getResourceName()).append("不可用");
			if(availabilityAttributeActions != null && availabilityAttributeActions.size() > 0) {
				allAttributeActions.addAll(availabilityAttributeActions);
			}

		} else {
			int index = 1;
			for(ThresholdAlarmInfo thresholdAlarmInfo : thresholdAlarmInfos) {
				Threshold threshold = thresholdAlarmInfo.getThreshold();
				Attribute attribute = thresholdAlarmInfo.getAttribute();

				alarmMessageBuilder.append("<br>").append(index).append(".").append(attribute.getAttributeCn())
						.append(" ").append(threshold.getResultMessage()).append(" ").append(attribute.getUnits())
						.append(" （阈值) ");

				allAttributeActions.addAll(thresholdAlarmInfo.getThresholdAttributeActions());
			}
		}

		if(healthAttributeActions != null && healthAttributeActions.size() > 0) {
			allAttributeActions.addAll(healthAttributeActions);
		}

		// 保存告警信息
		Alarm alarm = new Alarm();
		Attribute attribute = attributeCache.getAttributeId(resource.getResourceId() + "#" + AttributeNames.Health);
		alarm.setAlarmSource(alarmSource);
		alarm.setAttributeId(attribute.getId());
		alarm.setMonitorId(resource.getResourceId());
		alarm.setMonitorType(resource.getResourceType());
		alarm.setSeverity(severityLevel);
		alarm.setMessage(alarmMessageBuilder.toString());
		alarm.setCreateTime(new Date());
		alarmService.saveAlarm(alarm);

		// 处理动作
		if(allAttributeActions != null && allAttributeActions.size() > 0) {
			actionService.doActions(allAttributeActions, resource, attribute, severityLevel, alarmMessageBuilder.toString());
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
}
