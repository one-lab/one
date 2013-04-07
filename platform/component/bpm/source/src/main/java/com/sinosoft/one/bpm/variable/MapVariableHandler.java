package com.sinosoft.one.bpm.variable;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.sinosoft.one.bpm.aspect.Variable;
import com.sinosoft.one.bpm.util.BpmCommonUtils;
import com.sinosoft.one.bpm.util.BpmServiceSupport;

public class MapVariableHandler extends AbstractVariableHandler {
	
	private  static volatile  MapVariableHandler mapVariableHandler;
	
	private MapVariableHandler(BpmServiceSupport bpmServiceSupport) {
		super(bpmServiceSupport);
	} 

	public static MapVariableHandler build(BpmServiceSupport bpmServiceSupport) {
		if(mapVariableHandler == null) {
			synchronized(MapVariableHandler.class) {
				if(mapVariableHandler == null) {
					mapVariableHandler = new MapVariableHandler(bpmServiceSupport);
				}
			}
		}
		return mapVariableHandler;
	}

	@SuppressWarnings("unchecked")
	public void handler(String variableName, 
			VariableScope scope,
			VariableOperate variableOperate,
			String processId, String businessId,
			String mapKey, Object toOperateVariableValue) throws Exception {
		
		if(StringUtils.isBlank(variableName) || StringUtils.isBlank(mapKey)) {
			throw new IllegalArgumentException("The name and mapKey of @GlobalVariable can not be empty and null for Map variable type.");
		}
		
		Object variableValue = null;
		
		if (scope == VariableScope.GLOBAL) {
			variableValue = bpmServiceSupport.getGlobalVariable(variableName);
		} else {
			variableValue = bpmServiceSupport.getProcessInstanceVariable(
					processId, businessId, variableName);
		}

		
		if(variableValue == null) {
			Map<String, Object> toAddMap = new HashMap<String, Object>();
			toAddMap.put(mapKey, toOperateVariableValue);
			if (scope == VariableScope.GLOBAL) {
				bpmServiceSupport.setGlobalVariable(variableName, toAddMap);
			} else {
				bpmServiceSupport.setProcessInstanceVariable(processId, businessId, variableName, toAddMap);
			}
			return;
		}
		
		if(!(variableValue instanceof Map)) {
			throw new IllegalArgumentException("The variable [" + variableName + "] is not a Map.");
		}
		
		Map<String, Object> mapVariableValue = (Map<String, Object>)variableValue;
		
		switch(variableOperate) {
			case ADD : {
				mapVariableValue.put(mapKey, toOperateVariableValue);
				break;
			}
			case REMOVE : {
				mapVariableValue.remove(mapKey);
				break;
			}
			default : {
				throw new UnsupportedOperationException("The Map variable type only support ADD and REMOVE operate");
			}
		}
		
	}

	public void handler(Object[] args,
			Variable variable) throws Exception {
		String processId = "", businessId = "";
		
		VariableScope scope = variable.scope();
		if(scope == VariableScope.PROCESSINSTANCE) {
			processId = variable.processId();
			businessId = BpmCommonUtils.parseAttributeValue(args, variable.businessIdBeanOffset(),
					variable.businessIdAttributeName());
			
			BpmCommonUtils.hasText(processId, 
						"The processId of @Variable can not be empty and null for ProcessInstance scope of Map variable type.");
			
			BpmCommonUtils.hasText(businessId,
						"The businessId of @Variable can not be empty and null for ProcessInstance scope of Map variable type.");
		}
		Object toOperateVariableValue = getVariableValue(args, variable);
		handler(variable.name(), 
				scope,
				variable.operate(),
				processId, businessId,
				variable.mapKey(), toOperateVariableValue);
	}

}
