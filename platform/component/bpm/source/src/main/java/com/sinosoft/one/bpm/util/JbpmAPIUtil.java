package com.sinosoft.one.bpm.util;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.sinosoft.one.bpm.model.ActiveNodeInfo;
import com.sinosoft.one.bpm.variable.ListVariableHandler;
import com.sinosoft.one.bpm.variable.MapVariableHandler;
import com.sinosoft.one.bpm.variable.VariableOperate;
import com.sinosoft.one.bpm.variable.VariableScope;

public class JbpmAPIUtil {

	private static BpmServiceSupport bpmServiceSupport;

	public static String getImageInfoes(String processId, String businessId,
			String imageUrl, String contextPath) {
		if (StringUtils.isBlank(processId)) {
			throw new IllegalArgumentException("the process id is not blank.");
		}
		if (StringUtils.isBlank(businessId)) {
			throw new IllegalArgumentException("the bussiness id is not blank.");
		}

		List<ActiveNodeInfo> activeNodeInfos = bpmServiceSupport
				.getActiveNodeInfo(processId, businessId);
		String s = "<div style='width:1024px; height:768px; background-color:#ffffff;'>"
				+ "<div id=\"imageContainer\" style=\"position:relative;top:-1;left:-1;\">"
				+ "<img src=\""
				+ imageUrl
				+ "\" style=\"position:absolute;top:0;left:0\" />";
		for (ActiveNodeInfo activeNodeInfo : activeNodeInfos) {

			s += "<div class=\"bpm-graphView-activityImage\" style=\"position:absolute;top:"
					+ (activeNodeInfo.getActiveNode().getY() - 8)
					+ "px;left:"
					+ (activeNodeInfo.getActiveNode().getX() - 8)
					+ "px;width:50px;height:50px; z-index:1000;background-image: url("
					+ contextPath
					+ "/images/play_red_big.png);background-repeat:no-repeat;\"></div>";
		}
		s += "</div>" + "</div>";
		return s;
	}

	public static List<String> getBusinessIds(String userId) throws Exception {
		return bpmServiceSupport.getBusinessIds(userId);
	}

	public static Object getGlobalVariable(String variableName)
			throws Exception {
		return bpmServiceSupport.getGlobalVariable(variableName);
	}

	public static void setGlobalVariable(String variableName,
			Object variableValue) throws Exception {
		bpmServiceSupport.setGlobalVariable(variableName, variableValue);
	}

	public static Object getProcessInstanceVariable(String processId,
			String businessId, String variableName) throws Exception {
		return bpmServiceSupport.getProcessInstanceVariable(processId,
				businessId, variableName);
	}

	public static void setProcessInstanceVariable(String processId,
			String businessId, String variableName, Object variableValue)
			throws Exception {
		bpmServiceSupport.setProcessInstanceVariable(processId, businessId,
				variableName, variableValue);
	}

	public static void putGlobalVariableWithMap(String variableName,
			String mapKey, Object variableValue) throws Exception {
		MapVariableHandler.build(bpmServiceSupport).handler(variableName,
				VariableScope.GLOBAL, VariableOperate.ADD, null, null, mapKey,
				variableValue);
	}

	public static void removeGlobalVariableWithMap(String variableName,
			String mapKey) throws Exception {
		MapVariableHandler.build(bpmServiceSupport).handler(variableName,
				VariableScope.GLOBAL, VariableOperate.REMOVE, null, null,
				mapKey, null);
	}

	public static void addGlobalVariableWithList(String variableName,
			Object variableValue) throws Exception {
		ListVariableHandler.build(bpmServiceSupport).handler(variableName,
				VariableScope.GLOBAL, VariableOperate.ADD, null, null,
				variableValue);
	}

	public static void removeGlobalVariableWithList(String variableName,
			Object variableValue) throws Exception {
		ListVariableHandler.build(bpmServiceSupport).handler(variableName,
				VariableScope.GLOBAL, VariableOperate.REMOVE, null, null,
				variableValue);
	}

	public static void putProcessInstanceVariableWithMap(String processId,
			String businessId, String variableName, String mapKey,
			Object variableValue) throws Exception {
		MapVariableHandler.build(bpmServiceSupport).handler(variableName,
				VariableScope.PROCESSINSTANCE, VariableOperate.ADD, processId,
				businessId, mapKey, variableValue);
	}

	public static void removeProcessInstanceVariableWithMap(String processId,
			String businessId, String variableName, String mapKey)
			throws Exception {
		MapVariableHandler.build(bpmServiceSupport).handler(variableName,
				VariableScope.PROCESSINSTANCE, VariableOperate.REMOVE,
				processId, businessId, mapKey, null);
	}

	public static void addProcessInstanceVariableWithList(String processId,
			String businessId, String variableName, Object variableValue)
			throws Exception {
		ListVariableHandler.build(bpmServiceSupport).handler(variableName,
				VariableScope.PROCESSINSTANCE, VariableOperate.ADD, processId,
				businessId, variableValue);
	}

	public static void removeProcessInstanceVariableWithList(String processId,
			String businessId, String variableName, Object variableValue)
			throws Exception {
		ListVariableHandler.build(bpmServiceSupport).handler(variableName,
				VariableScope.PROCESSINSTANCE, VariableOperate.REMOVE,
				processId, businessId, variableValue);
	}

	public void setBpmServiceSupport(BpmServiceSupport bpmServiceSupport) {
		JbpmAPIUtil.bpmServiceSupport = bpmServiceSupport;
	}
}
