package com.sinosoft.one.ams.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "GE_RMS_ROLETASK")
public class GeRmsRoleTask implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性角色功能ID(RoleTaskID) */
	private String roleTaskID;

	/** 属性taskAuth */
	private GeRmsTaskAuth taskAuth;

	/** 属性role */
	private GeRmsRole role;

	/** 属性是否有效(IsValidate) */
	private String isValidate;

	/** 属性标志字段(Flag) */
	private String flag;

	/**
	 * 类roleTask的默认构造方法
	 */
	public GeRmsRoleTask() {
	}

	/**
	 * 属性角色功能ID(RoleTaskID)的getter方法
	 */
	@Id
	@Column(name = "ROLETASKID")
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
	public String getRoleTaskID() {
		return this.roleTaskID;
	}

	/**
	 * 属性角色功能ID(RoleTaskID)的setter方法
	 */
	public void setRoleTaskID(String roleTaskID) {
		this.roleTaskID = roleTaskID;
	}

	/**
	 * 属性taskAuth的getter方法
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TASKAUTHID")
	public GeRmsTaskAuth getTaskAuth() {
		return this.taskAuth;
	}

	/**
	 * 属性taskAuth的setter方法
	 */
	public void setTaskAuth(GeRmsTaskAuth taskAuth) {
		this.taskAuth = taskAuth;
	}

	/**
	 * 属性role的getter方法
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLEID")
	public GeRmsRole getRole() {
		return this.role;
	}

	/**
	 * 属性role的setter方法
	 */
	public void setRole(GeRmsRole role) {
		this.role = role;
	}

	/**
	 * 属性是否有效(IsValidate)的getter方法
	 */

	@Column(name = "ISVALIDATE")
	public String getIsValidate() {
		return this.isValidate;
	}

	/**
	 * 属性是否有效(IsValidate)的setter方法
	 */
	public void setIsValidate(String isValidate) {
		this.isValidate = isValidate;
	}

	/**
	 * 属性标志字段(Flag)的getter方法
	 */

	@Column(name = "FLAG")
	public String getFlag() {
		return this.flag;
	}

	/**
	 * 属性标志字段(Flag)的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
}