package com.sinosoft.ams.user_group.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="GE_RMS_EMPLOYE")
public class User {
	private String userCode;
	private String userName;
	private String password;
	private Date passwdSetDate;
	private Date passwdExpireDate;
	private String comCode;
	private String newUserCode;
	private String validStatus;
	private String articleCode;
	private String flag;
	private String button;
	private String button2;
	private String comCName;
	
	@Id
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
	public Date getPasswdSetDate() {
		return passwdSetDate;
	}
	public void setPasswdSetDate(Date passwdSetDate) {
		this.passwdSetDate = passwdSetDate;
	}
	public Date getPasswdExpireDate() {
		return passwdExpireDate;
	}
	public void setPasswdExpireDate(Date passwdExpireDate) {
		this.passwdExpireDate = passwdExpireDate;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getNewUserCode() {
		return newUserCode;
	}
	public void setNewUserCode(String newUserCode) {
		this.newUserCode = newUserCode;
	}
	public String getValidStatus() {
		return validStatus;
	}
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}
	public String getArticleCode() {
		return articleCode;
	}
	public void setArticleCode(String articleCode) {
		this.articleCode = articleCode;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	@Transient
	public String getButton() {
		return button;
	}
	public void setButton(String button) {
		this.button = button;
	}
	@Transient
	public String getButton2() {
		return button2;
	}
	public void setButton2(String button2) {
		this.button2 = button2;
	}
	@Transient
	public String getComCName() {
		return comCName;
	}
	public void setComCName(String comCName) {
		this.comCName = comCName;
	}
	

}
