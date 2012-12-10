package com.sinosoft.one.ams.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GE_RMS_BUSPOWER")
public class GeRmsBusPower {
	
	private String busPowerID;
	private String dataRuleID;
	private String userPowerID;
	private String taskID;
	private String dataRuleParam;
	private String isValidate;
	@Id
	public String getBusPowerID() {
		return busPowerID;
	}
	public void setBusPowerID(String busPowerID) {
		this.busPowerID = busPowerID;
	}
	public String getDataRuleID() {
		return dataRuleID;
	}
	public void setDataRuleID(String dataRuleID) {
		this.dataRuleID = dataRuleID;
	}
	public String getUserPowerID() {
		return userPowerID;
	}
	public void setUserPowerID(String userPowerID) {
		this.userPowerID = userPowerID;
	}
	public String getTaskID() {
		return taskID;
	}
	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}
	public String getDataRuleParam() {
		return dataRuleParam;
	}
	public void setDataRuleParam(String dataRuleParam) {
		this.dataRuleParam = dataRuleParam;
	}
	public String getIsValidate() {
		return isValidate;
	}
	public void setIsValidate(String isValidate) {
		this.isValidate = isValidate;
	}

}
