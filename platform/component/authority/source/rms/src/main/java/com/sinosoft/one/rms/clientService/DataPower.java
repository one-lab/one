package com.sinosoft.one.rms.clientService;

import org.springframework.util.Assert;

import ins.framework.utils.StringUtils;

public class DataPower  {
	
	private final String taskId;
	
	private final String ruleId;
	
	private final String rule;
	
	private final String param;
	
	
	public  DataPower(final String taskId,final String ruleId,final String param,final String rule){
		Assert.hasText(taskId);
		Assert.hasText(ruleId);
		Assert.hasText(rule);
		this.taskId=taskId;
		this.ruleId=ruleId;
		if(StringUtils.isNotBlank(param))
			this.param=param;
		else
			this.param=null;
		this.rule=rule;
	}

	public String getTaskId() {
		return taskId;
	}

	public String getRuleId() {
		return ruleId;
	}

	public String getParam() {
		return param;
	}

	public String getRule() {
		return rule;
	}
}
