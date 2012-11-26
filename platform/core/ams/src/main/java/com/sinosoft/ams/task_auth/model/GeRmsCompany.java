package com.sinosoft.ams.task_auth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "GE_RMS_COMPANY")
public class GeRmsCompany {
	
	private String comCode;
	private String comCName;
	private String comEName;
	private String addressCName;
	private String addressEName;
	private String postCode;
	private String phoneNumber;
	private String faxNumber;
	private String upperComCode;
	private String insurerName;
	private String comType;
	private String manager;
	private String accountant;
	private String remark;
	private String newComCode;
	@Column(name="validstatus")
	private String valIdStatus;
	private String acntUnit;
	private String articleCode;
	private String flag;
	private String isInsured;
	
	public GeRmsCompany() {
		// TODO Auto-generated constructor stub
	}
	
	public GeRmsCompany(String comCode, String comCName, String comEName,
			String addressCName, String addressEName, String postCode,
			String phoneNumber, String faxNumber, String upperComCode,
			String insurerName, String comType, String manager,
			String accountant, String remark, String newComCode,
			String validStatus, String acntUnit, String articleCode,
			String flag, String isInsured) {
		super();
		this.comCode = comCode;
		this.comCName = comCName;
		this.comEName = comEName;
		this.addressCName = addressCName;
		this.addressEName = addressEName;
		this.postCode = postCode;
		this.phoneNumber = phoneNumber;
		this.faxNumber = faxNumber;
		this.upperComCode = upperComCode;
		this.insurerName = insurerName;
		this.comType = comType;
		this.manager = manager;
		this.accountant = accountant;
		this.remark = remark;
		this.newComCode = newComCode;
		this.valIdStatus = validStatus;
		this.acntUnit = acntUnit;
		this.articleCode = articleCode;
		this.flag = flag;
		this.isInsured = isInsured;
	}
	@Id
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getComCName() {
		return comCName;
	}
	public void setComCName(String comCName) {
		this.comCName = comCName;
	}
	public String getComEName() {
		return comEName;
	}
	public void setComEName(String comEName) {
		this.comEName = comEName;
	}
	public String getAddressCName() {
		return addressCName;
	}
	public void setAddressCName(String addressCName) {
		this.addressCName = addressCName;
	}
	public String getAddressEName() {
		return addressEName;
	}
	public void setAddressEName(String addressEName) {
		this.addressEName = addressEName;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getFaxNumber() {
		return faxNumber;
	}
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
	public String getUpperComCode() {
		return upperComCode;
	}
	public void setUpperComCode(String upperComCode) {
		this.upperComCode = upperComCode;
	}
	public String getInsurerName() {
		return insurerName;
	}
	public void setInsurerName(String insurerName) {
		this.insurerName = insurerName;
	}
	public String getComType() {
		return comType;
	}
	public void setComType(String comType) {
		this.comType = comType;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getAccountant() {
		return accountant;
	}
	public void setAccountant(String accountant) {
		this.accountant = accountant;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getNewComCode() {
		return newComCode;
	}
	public void setNewComCode(String newComCode) {
		this.newComCode = newComCode;
	}
	@Column(name="ValIdStatus")
	public String getValIdStatus() {
		return valIdStatus;
	}
	public void setValIdStatus(String validStatus) {
		this.valIdStatus = validStatus;
	}
	public String getAcntUnit() {
		return acntUnit;
	}
	public void setAcntUnit(String acntUnit) {
		this.acntUnit = acntUnit;
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
	public String getIsInsured() {
		return isInsured;
	}
	public void setIsInsured(String isInsured) {
		this.isInsured = isInsured;
	}
	
	
 
}
