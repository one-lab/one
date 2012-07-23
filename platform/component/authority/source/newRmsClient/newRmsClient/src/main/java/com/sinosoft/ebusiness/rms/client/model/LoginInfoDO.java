package com.sinosoft.ebusiness.rms.client.model;

import java.util.List;

import com.sinosoft.ebusiness.rms.client.cxf.BusPower;
import com.sinosoft.ebusiness.rms.client.cxf.Task;



public class LoginInfoDO {
	//用户信息
	private String userCode;

	/** 属性员工名称(UserName) */
	private String userName;
	
	/** 属性密码(Password) */
	private String password;
	
	/** 属性效力状态(ValidStatus) */
	private String validStatus;
	
	//权限生效的机构代码
	private String loginComCode;
	//功能权限集合
	private List<Task> tasks;
	//数据权限集合
	private List<BusPower> busPowers;
	//服务器信息（错误信息、失败信息）
	private String serverMassege;


	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getValidStatus() {
		return validStatus;
	}

	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}

	public String getLoginComCode() {
		return loginComCode;
	}

	public void setLoginComCode(String loginComCode) {
		this.loginComCode = loginComCode;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<BusPower> getBusPowers() {
		return busPowers;
	}

	public void setBusPowers(List<BusPower> busPowers) {
		this.busPowers = busPowers;
	}

	public String getServerMassege() {
		return serverMassege;
	}

	public void setServerMassege(String serverMassege) {
		this.serverMassege = serverMassege;
	}

	
}
