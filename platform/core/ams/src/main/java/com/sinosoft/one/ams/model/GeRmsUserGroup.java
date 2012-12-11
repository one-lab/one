package com.sinosoft.one.ams.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "GE_RMS_USERGROUP")
public class GeRmsUserGroup {
	private String userGropuID;
	private String groupID;
	private String userPowerID;
	private String isValidate;
	@Id
	public String getUserGropuID() {
		return userGropuID;
	}
	public void setUserGropuID(String userGropuID) {
		this.userGropuID = userGropuID;
	}
	public String getGroupID() {
		return groupID;
	}
	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}
	public String getUserPowerID() {
		return userPowerID;
	}
	public void setUserPowerID(String userPowerID) {
		this.userPowerID = userPowerID;
	}
	public String getIsValidate() {
		return isValidate;
	}
	public void setIsValidate(String isValidate) {
		this.isValidate = isValidate;
	}

}
