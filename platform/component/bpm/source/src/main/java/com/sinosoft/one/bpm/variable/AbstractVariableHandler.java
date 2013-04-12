package com.sinosoft.one.bpm.variable;

import org.apache.commons.lang3.StringUtils;

import com.sinosoft.one.bpm.aspect.Variable;
import com.sinosoft.one.bpm.util.BpmCommonUtils;
import com.sinosoft.one.bpm.util.BpmServiceSupport;

public abstract class AbstractVariableHandler implements VariableHandler {
	protected BpmServiceSupport bpmServiceSupport;
	
	protected AbstractVariableHandler(BpmServiceSupport bpmServiceSupport) {
		this.bpmServiceSupport = bpmServiceSupport;
	}
	
	public abstract void handler(Object[] args,
			Variable variable) throws Exception;

	

	public void setBpmServiceSupport(BpmServiceSupport bpmServiceSupport) {
		this.bpmServiceSupport = bpmServiceSupport;
	}
	
	public Object getVariableValue(Object[] args, Variable variable) throws Exception {
		return StringUtils.isBlank(variable.variableValue()) 
				? BpmCommonUtils.parseVariableValue(args, variable.variableValueBeanOffset(), variable.variableValueAttributeName()) 
				: variable.variableValue();
	}
}
