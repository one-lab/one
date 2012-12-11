package com.sinosoft.one.ams.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GE_RMS_USERPOWER")
public class GeRmsUserPower {
	private String userPowerID;
	private String comCode;
	private String userCode;
	private String isValidate;
	private String flag;
	@Id
	public String getUserPowerID() {
		return userPowerID;
	}
	public void setUserPowerID(String userPowerID) {
		this.userPowerID = userPowerID;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getIsValidate() {
		return isValidate;
	}
	public void setIsValidate(String isValidate) {
		this.isValidate = isValidate;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	

}
