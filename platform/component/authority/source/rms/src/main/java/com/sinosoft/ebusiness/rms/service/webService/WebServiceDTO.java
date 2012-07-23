package com.sinosoft.ebusiness.rms.service.webService;

import java.util.List;

import com.sinosoft.ebusiness.rms.model.BusPower;
import com.sinosoft.ebusiness.rms.model.Employe;
import com.sinosoft.ebusiness.rms.model.Task;

/** 
 * webService服务端传输对象
 * @author Administrator
 */
public class WebServiceDTO {
	//用户信息
	private Employe employe;
	//权限生效的机构代码
	private String loginComCode;
	//功能权限集合
	private List<Task> tasks;
	//数据权限集合
	private List<BusPower> busPowers;
	//服务器信息（错误信息、失败信息）
	private String serverMassege;

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
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
