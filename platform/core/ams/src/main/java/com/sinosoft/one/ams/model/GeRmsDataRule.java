package com.sinosoft.one.ams.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "GE_RMS_DATARULE")
public class GeRmsDataRule {
	private String dataRuleID;
	private String des;
	private String rule;
	private String isValidate;
	private String dataRuleParam;
	
	@Id
	public String getDataRuleID() {
		return dataRuleID;
	}
	public void setDataRuleID(String dataRuleID) {
		this.dataRuleID = dataRuleID;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public String getIsValidate() {
		return isValidate;
	}
	public void setIsValidate(String isValidate) {
		this.isValidate = isValidate;
	}
	@Transient
	public String getDataRuleParam() {
		return dataRuleParam;
	}
	public void setDataRuleParam(String dataRuleParam) {
		this.dataRuleParam = dataRuleParam;
	}
	
}
