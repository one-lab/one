package com.sinosoft.one.bpm.variable;

import java.util.ArrayList;
import java.util.List;

import com.sinosoft.one.bpm.aspect.Variable;
import com.sinosoft.one.bpm.util.BpmCommonUtils;
import com.sinosoft.one.bpm.util.BpmServiceSupport;

public class ListVariableHandler extends AbstractVariableHandler {

	private static volatile ListVariableHandler listVariableHandler;

	private ListVariableHandler(BpmServiceSupport bpmServiceSupport) {
		super(bpmServiceSupport);
	}

	public static ListVariableHandler build(BpmServiceSupport bpmServiceSupport) {
		if (listVariableHandler == null) {
			synchronized (ListVariableHandler.class) {
				if (listVariableHandler == null) {
					listVariableHandler = new ListVariableHandler(bpmServiceSupport);
				}
			}
		}
		return listVariableHandler;
	}

	public void handler(String variableName, 
		VariableScope scope,
		VariableOperate variableOperate,
		String processId, String businessId,
		Object toOperateVariableValue) throws Exception {
		
		
		BpmCommonUtils.hasText(variableName, 
					"The name of @Variable can not be empty and null for List variable type.");
		
		Object variableValue = null;
		if (scope == VariableScope.GLOBAL) {
			variableValue = bpmServiceSupport.getGlobalVariable(variableName);
		} else {
			variableValue = bpmServiceSupport.getProcessInstanceVariable(
					processId, businessId, variableName);
		}

		if (variableValue == null) {
			List<Object> toAddList = new ArrayList<Object>();
			toAddList.add(toOperateVariableValue);
			if (scope == VariableScope.GLOBAL) {
				bpmServiceSupport.setGlobalVariable(variableName, toAddList);
			} else {
				bpmServiceSupport.setProcessInstanceVariable(processId, businessId, variableName, toAddList);
			}
			return;
		}

		if (!(variableValue instanceof List)) {
			throw new IllegalArgumentException("The variable [" + variableName
					+ "] is not a List.");
		}

		@SuppressWarnings("unchecked")
		List<Object> listVariableValue = (List<Object>) variableValue;

		switch (variableOperate) {
			case ADD: {
				listVariableValue.add(toOperateVariableValue);
				break;
			}
			case REMOVE: {
				listVariableValue.remove(toOperateVariableValue);
				break;
			}
			default: {
				throw new UnsupportedOperationException(
						"The List variable type only support ADD and REMOVE operate");
			}
		}
	}

	public void handler(Object[] args, Variable variable) throws Exception {
		String processId = "", businessId = "";
		if (variable.scope() == VariableScope.PROCESSINSTANCE) {
			processId = variable.processId();
			businessId = (String)BpmCommonUtils.parseAttributeValue(args, variable.businessBeanOffset(),
					variable.businessIdAttributeName());
			
			BpmCommonUtils.hasText(processId, 
						"The processId of @Variable can not be empty and null for ProcessInstance scope of List variable type.");
			
			BpmCommonUtils.hasText(businessId,
						"The businessId of @Variable can not be empty and null for ProcessInstance scope of List variable type.");
		}

		Object toOperateVariableValue = getVariableValue(args, variable);
		this.handler(variable.name(),
				variable.scope(),
				variable.operate(),
				processId, businessId,
				toOperateVariableValue);
	}

}
