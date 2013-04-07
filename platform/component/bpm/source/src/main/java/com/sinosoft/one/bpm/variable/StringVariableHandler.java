package com.sinosoft.one.bpm.variable;

import org.apache.commons.lang3.StringUtils;

import com.sinosoft.one.bpm.aspect.Variable;
import com.sinosoft.one.bpm.util.BpmCommonUtils;
import com.sinosoft.one.bpm.util.BpmServiceSupport;

public final class StringVariableHandler extends AbstractVariableHandler {
	private  static volatile  StringVariableHandler stringVariableHandler;
	
	private StringVariableHandler(BpmServiceSupport bpmServiceSupport) {
		super(bpmServiceSupport);
	} 

	public static StringVariableHandler build(BpmServiceSupport bpmServiceSupport) {
		if(stringVariableHandler == null) {
			synchronized(StringVariableHandler.class) {
				if(stringVariableHandler == null) {
					stringVariableHandler = new StringVariableHandler(bpmServiceSupport);
				}
			}
		}
		return stringVariableHandler;
	}
	
	
	public void handler(Object[] args,
			Variable variable) throws Exception {
		String variableName = variable.name();
		if(StringUtils.isBlank(variableName)) {
			throw new IllegalArgumentException("The name of @Variable can not be empty and null for String variable type.");
		}
		
		Object variableValue = getVariableValue(args, variable);
		
		switch(variable.operate()) {
			case ADD :{
				String processId = "", businessId = "";
				if (variable.scope() == VariableScope.GLOBAL) {
					bpmServiceSupport.setGlobalVariable(variableName, variableValue);
				} else {
					processId = variable.processId();
					businessId = BpmCommonUtils.parseAttributeValue(args, variable.businessIdBeanOffset(),
							variable.businessIdAttributeName());
					
					BpmCommonUtils.hasText(processId, 
								"The processId of @Variable can not be empty and null for ProcessInstance scope of List variable type.");
					
					BpmCommonUtils.hasText(businessId,
								"The businessId of @Variable can not be empty and null for ProcessInstance scope of List variable type.");
					
					bpmServiceSupport.setProcessInstanceVariable(
							processId, businessId, variableName, variableValue);
				}
				break;
			}
			default : {
				throw new UnsupportedOperationException("The String variable type only support ADD operate");
			}
		}
	}
}
