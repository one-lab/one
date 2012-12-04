package com.sinosoft.one.rms.model;
// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


import com.sinosoft.one.rms.model.service.CompanyModelInterface;
import com.sinosoft.one.rms.model.service.EmployeModelInterface;


/**
 * POJO类employe
 */
@Entity
@Table(name = "GE_RMS_EMPLOYE")
public class Employe implements EmployeModelInterface {
	private static final long serialVersionUID = 1L;

	/** 属性员工代码(UserCode) */
	private String userCode;

	/** 属性company */
	private Company company;

	/** 属性员工名称(UserName) */
	private String userName;

	/** 属性密码(Password) */
	private String password;

	/** 属性密码设置日期(PasswdSetDate) */
	private Date passwdSetDate;

	/** 属性密码过期日期(PasswdExpireDate) */
	private Date passwdExpireDate;

	/** 属性最新员工代码(NewUserCode) */
	private String newUserCode;

	/** 属性效力状态(ValidStatus) */
	private String validStatus;

	/** 属性专项代码(ArticleCode) */
	private String articleCode;

	/** 属性标志字段(Flag) */
	private String flag;

	/**
	 * 类employe的默认构造方法
	 */
	public Employe() {
	}

	/**
	 * 属性员工代码(UserCode)的getter方法
	 */
	@Id
	@Column(name = "USERCODE")
	public String getUserCode() {
		return this.userCode;
	}

	/**
	 * 属性员工代码(UserCode)的setter方法
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/**
	 * 属性company的getter方法
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMCODE")
	public Company getCompany() {
		return this.company;
	}

	/**
	 * 属性company的setter方法
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * 属性员工名称(UserName)的getter方法
	 */

	@Column(name = "USERNAME")
	public String getUserName() {
		return this.userName;
	}

	/**
	 * 属性员工名称(UserName)的setter方法
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 属性密码(Password)的getter方法
	 */

	@Column(name = "PASSWORD")
	public String getPassword() {
		return this.password;
	}

	/**
	 * 属性密码(Password)的setter方法
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 属性密码设置日期(PasswdSetDate)的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "PASSWDSETDATE")
	public Date getPasswdSetDate() {
		return this.passwdSetDate;
	}

	/**
	 * 属性密码设置日期(PasswdSetDate)的setter方法
	 */
	public void setPasswdSetDate(Date passwdSetDate) {
		this.passwdSetDate = passwdSetDate;
	}

	/**
	 * 属性密码过期日期(PasswdExpireDate)的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "PASSWDEXPIREDATE")
	public Date getPasswdExpireDate() {
		return this.passwdExpireDate;
	}

	/**
	 * 属性密码过期日期(PasswdExpireDate)的setter方法
	 */
	public void setPasswdExpireDate(Date passwdExpireDate) {
		this.passwdExpireDate = passwdExpireDate;
	}

	/**
	 * 属性最新员工代码(NewUserCode)的getter方法
	 */

	@Column(name = "NEWUSERCODE")
	public String getNewUserCode() {
		return this.newUserCode;
	}

	/**
	 * 属性最新员工代码(NewUserCode)的setter方法
	 */
	public void setNewUserCode(String newUserCode) {
		this.newUserCode = newUserCode;
	}

	/**
	 * 属性效力状态(ValidStatus)的getter方法
	 */

	@Column(name = "VALIDSTATUS")
	public String getValidStatus() {
		return this.validStatus;
	}

	/**
	 * 属性效力状态(ValidStatus)的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}

	/**
	 * 属性专项代码(ArticleCode)的getter方法
	 */

	@Column(name = "ARTICLECODE")
	public String getArticleCode() {
		return this.articleCode;
	}

	/**
	 * 属性专项代码(ArticleCode)的setter方法
	 */
	public void setArticleCode(String articleCode) {
		this.articleCode = articleCode;
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
	@Transient
	public CompanyModelInterface getPrpDcompanyBycomCode() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transient
	public CompanyModelInterface getPrpDcompanyBymakeCom() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transient
	public String getUserEname() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transient
	public String getSeal() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transient
	public Date getPasswordSetDate() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transient
	public Date getPasswordExpireDate() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transient
	public String getAccountCode() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transient
	public String getPhone() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transient
	public String getMobile() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transient
	public String getAddress() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transient
	public String getPostCode() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transient
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transient
	public String getUserFlag() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transient
	public String getLoginsystem() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transient
	public String getPosterminalNo() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transient
	public String getUsertype() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transient
	public String getBindingFlag() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transient
	public String getProfessionalNo() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transient
	public CompanyModelInterface getPrpDcaompany() {
		// TODO Auto-generated method stub
		return null;
	}

}
