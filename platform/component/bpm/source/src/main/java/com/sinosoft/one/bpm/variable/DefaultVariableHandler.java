package com.sinosoft.one.bpm.variable;

import org.apache.commons.lang3.StringUtils;

import com.sinosoft.one.bpm.aspect.Variable;
import com.sinosoft.one.bpm.util.BpmCommonUtils;
import com.sinosoft.one.bpm.util.BpmServiceSupport;

public final class DefaultVariableHandler extends AbstractVariableHandler {
	private  static volatile  DefaultVariableHandler stringVariableHandler;
	
	private DefaultVariableHandler(BpmServiceSupport bpmServiceSupport) {
		super(bpmServiceSupport);
	} 

	public static DefaultVariableHandler build(BpmServiceSupport bpmServiceSupport) {
		if(stringVariableHandler == null) {
			synchronized(DefaultVariableHandler.class) {
				if(stringVariableHandler == null) {
					stringVariableHandler = new DefaultVariableHandler(bpmServiceSupport);
				}
			}
		}
		return stringVariableHandler;
	}
	
	
	public void handler(Object[] args,
			Variable variable) throws Exception {
		String variableName = variable.name();
		if(StringUtils.isBlank(variableName)) {
			throw new IllegalArgumentException("The name of @Variable can not be empty and null for default variable type.");
		}
		
		Object variableValue = getVariableValue(args, variable);
		
		switch(variable.operate()) {
			case ADD :{
				String processId = "", businessId = "";
				if (variable.scope() == VariableScope.GLOBAL) {
					bpmServiceSupport.setGlobalVariable(variableName, variableValue);
				} else {
					processId = variable.processId();
					businessId = BpmCommonUtils.parseAttributeValue(args, variable.businessBeanOffset(),
							variable.businessIdAttributeName());
					
					BpmCommonUtils.hasText(processId, 
								"The processId of @Variable can not be empty and null for ProcessInstance scope of default variable type.");
					
					BpmCommonUtils.hasText(businessId,
								"The businessId of @Variable can not be empty and null for ProcessInstance scope of default variable type.");
					
					bpmServiceSupport.setProcessInstanceVariable(
							processId, businessId, variableName, variableValue);
				}
				break;
			}
			default : {
				throw new UnsupportedOperationException("The Default variable type only support ADD operate");
			}
		}
	}
}
