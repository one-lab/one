package com.sinosoft.one.ams.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GE_RMS_EXCPOWER")
public class GeRmsExcPower {
	private String excPowerID;
	private String powerID;
	private String taskID;
	private String isValidate;
	@Id
	public String getExcPowerID() {
		return excPowerID;
	}
	public void setExcPowerID(String excPowerID) {
		this.excPowerID = excPowerID;
	}
	public String getPowerID() {
		return powerID;
	}
	public void setPowerID(String powerID) {
		this.powerID = powerID;
	}
	public String getTaskID() {
		return taskID;
	}
	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}
	public String getIsValidate() {
		return isValidate;
	}
	public void setIsValidate(String isValidate) {
		this.isValidate = isValidate;
	}

}
