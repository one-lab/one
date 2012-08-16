package com.sinosoft.one.rms.clientService;

import org.springframework.util.Assert;

import ins.framework.utils.StringUtils;

public class DataPower  {
	
	private  String taskId;
	
	private  String ruleId;
	
	private  String rule;
	
	private  String param;
	
	public DataPower(){
		
	}
	
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

	public void setTaskId(String taskId) {
		if(this.taskId ==null){
			this.taskId = taskId;
		}
	}

	public void setRuleId(String ruleId) {
		if(this.ruleId ==null){
			this.ruleId = ruleId;
		}
	}

	public void setRule(String rule) {
		if(this.rule ==null){
			this.rule = rule;
		}
	}

	public void setParam(String param) {
		if(this.param ==null){
			this.param = param;
		}
	}
	
	
}
