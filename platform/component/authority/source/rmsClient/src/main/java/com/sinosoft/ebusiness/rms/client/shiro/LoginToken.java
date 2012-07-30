package com.sinosoft.ebusiness.rms.client.shiro;

import org.apache.shiro.authc.AuthenticationToken;

public class LoginToken implements AuthenticationToken{

	private static final long serialVersionUID = 1L;
	
	private String userCode;
	
	private String passWord;
	
	private String comCode;
	
	public LoginToken(){
	}  
	  
    public LoginToken(String userCode,String passWord,String comCode ){  
        this.userCode=userCode; 
        this.passWord=passWord; 
        this.comCode=comCode; 
    }  
	
	@Override
	public Object getPrincipal() {
		return getUserCode();
	}

	@Override
	public Object getCredentials() {
		return getPassWord();
	}
	
	public void clear() {
		this.userCode = null;
		this.passWord = null;
		this.comCode= null;
//		if (this.password != null) {
//			for (int i = 0; i < password.length; i++) {
//				this.password[i] = 0x00;
//			}
//			this.password = null;
//		}

	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getName());
		sb.append(" - ");
		sb.append(userCode);
		sb.append(" - ");
		sb.append(passWord);
		sb.append(" - ");
		sb.append(comCode);
		return sb.toString();
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	
}
