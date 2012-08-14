package com.sinosoft.one.rms.clientService;

import java.util.Collections;
import java.util.List;
import org.springframework.util.Assert;


/** 
 * webService服务端传输对象
 * @author Administrator
 */
public class User {
	//用户信息
	private String userCode;

	private String userName;
	
	private String passWord;
	
	
	//权限生效的机构代码
	private String loginComCode;
	
	private String loginComName;
	
	private List<String> roleIdList;

	//功能权限集合
	private List<String> taskIdList;
	
	private List<Menu> menuList;
	
	private List<DataPower> dataPowers;
	
	public User(){
	}

	public User(final String userCode,final String passWord,final String userName,final String loginComCode,final String loginComName,
		final List<String> roleIdList,final List<String> taskIdList,final List<Menu> menuList, final List<DataPower> dataPowers){
		Assert.hasText(userCode);
		Assert.hasText(userName);
		Assert.hasText(passWord);
		Assert.hasText(loginComCode);
		Assert.hasText(loginComName);
		Assert.notNull(taskIdList);
		this.userCode=userCode;
		this.passWord=passWord;
		this.userName=userName;
		this.loginComCode=loginComCode;
		this.loginComName=loginComName;
		this.roleIdList = roleIdList;
		this.taskIdList=taskIdList;
		this.menuList=menuList;
		this.dataPowers=dataPowers;
	}

	public String getLoginComCode() {
		return loginComCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public String getUserName() {
		return userName;
	}

	public String getLoginComName() {
		return loginComName;
	}

	public List<String> getTaskIdList() {
		return Collections.unmodifiableList(taskIdList);
	}
	
	public String getPassWord() {
		return passWord;
	}

	public List<String> getRoleIdList() {
		return Collections.unmodifiableList(roleIdList);
	}
	
	public List<Menu> getMenuList() {
		return Collections.unmodifiableList(menuList);
	}

	public List<DataPower> getDataPowers() {
		return dataPowers;
	}
	
}
