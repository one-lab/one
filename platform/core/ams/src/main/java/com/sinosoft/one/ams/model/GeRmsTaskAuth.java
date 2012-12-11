package com.sinosoft.one.ams.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GE_RMS_TASK_AUTH")
public class GeRmsTaskAuth {
	private String taskAuthID;
	private String taskID;
	private String comCode;
	private String operateUser;
	private String flag;
	
	@Id
	public String getTaskAuthID() {
		return taskAuthID;
	}
	public void setTaskAuthID(String taskAuthID) {
		this.taskAuthID = taskAuthID;
	}
	public String getTaskID() {
		return taskID;
	}
	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getOperateUser() {
		return operateUser;
	}
	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}

}
