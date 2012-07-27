package com.sinosoft.ebusiness.rms.clientService;

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
	//功能权限集合
	private List<String> taskIdList;
	
	public User(){
		
	}
	
	public User(String userCode,String passWord,String userName,String loginComCode,String loginComName,List<String> taskIdList){
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
		this.taskIdList=taskIdList;
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
		return taskIdList;
	}

	
	public String getPassWord() {
		return passWord;
	}



	
}
