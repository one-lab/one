package com.sinosoft.one.ams.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GE_RMS_GROUPROLE")
public class GeRmsGroupRole {
	private String groupRoleID;
	private String groupID;
	private String roleID;
	private String isValidate;

	@Id
	public String getGroupRoleID() {
		return groupRoleID;
	}

	public void setGroupRoleID(String groupRoleID) {
		this.groupRoleID = groupRoleID;
	}

	public String getGroupID() {
		return groupID;
	}

	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

	public String getIsValidate() {
		return isValidate;
	}

	public void setIsValidate(String isValidate) {
		this.isValidate = isValidate;
	}

}
