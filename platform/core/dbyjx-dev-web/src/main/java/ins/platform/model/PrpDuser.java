package ins.platform.model;

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

/**
 * POJO类PrpDuser
 */
@Entity
@Table(name = "PRPDUSER")
public class PrpDuser implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性员工代码 */
	private String userCode;

	/** 属性prpDcompanyBycomCode */
	private PrpDcompany prpDcompanyBycomCode;

	/** 属性prpDcompanyBymakeCom */
	private PrpDcompany prpDcompanyBymakeCom;

	/** 属性员工名称 */
	private String userName;

	/** 属性用户的英文名称 */
	private String userEname;

	/** 属性密码 */
	private String password;

	/** 属性seal */
	private String seal;

	/** 属性密码设置时间 */
	private Date passwordSetDate;

	/** 属性密码过期时间 */
	private Date passwordExpireDate;

	/** 属性账户编号 */
	private String accountCode;

	/** 属性phone */
	private String phone;

	/** 属性手机 */
	private String mobile;

	/** 属性地址 */
	private String address;

	/** 属性邮编 */
	private String postCode;

	/** 属性电子邮件 */
	private String email;

	/** 属性用户标志 */
	private String userFlag;

	/** 属性loginsystem */
	private String loginsystem;

	/** 属性最新员工代码 */
	private String newUserCode;

	/** 属性效力状态 */
	private String validStatus;

	/** 属性专项代码(对应会计科目) */
	private String articleCode;

	/** 属性标志 */
	private String flag;

	/** 属性销售点终端号 */
	private String posterminalNo;

	/** 属性usertype */
	private String usertype;

	/** 属性是否绑定硬件信息标志 0否 1是 */
	private String bindingFlag;

	/** 属性业务归属人员许可证号（从销售系统同步） */
	private String professionalNo;

	/**
	 * 类PrpDuser的默认构造方法
	 */
	public PrpDuser() {
	}

	/**
	 * 属性员工代码的getter方法
	 */
	@Id
	@Column(name = "USERCODE")
	public String getUserCode() {
		return this.userCode;
	}

	/**
	 * 属性员工代码的setter方法
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/**
	 * 属性prpDcompanyBycomCode的getter方法
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMCODE", nullable = false)
	public PrpDcompany getPrpDcompanyBycomCode() {
		return this.prpDcompanyBycomCode;
	}

	/**
	 * 属性prpDcompanyBycomCode的setter方法
	 */
	public void setPrpDcompanyBycomCode(PrpDcompany prpDcompanyBycomCode) {
		this.prpDcompanyBycomCode = prpDcompanyBycomCode;
	}

	/**
	 * 属性prpDcompanyBymakeCom的getter方法
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MAKECOM", nullable = false)
	public PrpDcompany getPrpDcompanyBymakeCom() {
		return this.prpDcompanyBymakeCom;
	}

	/**
	 * 属性prpDcompanyBymakeCom的setter方法
	 */
	public void setPrpDcompanyBymakeCom(PrpDcompany prpDcompanyBymakeCom) {
		this.prpDcompanyBymakeCom = prpDcompanyBymakeCom;
	}

	/**
	 * 属性员工名称的getter方法
	 */

	@Column(name = "USERNAME")
	public String getUserName() {
		return this.userName;
	}

	/**
	 * 属性员工名称的setter方法
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 属性用户的英文名称的getter方法
	 */

	@Column(name = "USERENAME")
	public String getUserEname() {
		return this.userEname;
	}

	/**
	 * 属性用户的英文名称的setter方法
	 */
	public void setUserEname(String userEname) {
		this.userEname = userEname;
	}

	/**
	 * 属性密码的getter方法
	 */

	@Column(name = "PASSWORD")
	public String getPassword() {
		return this.password;
	}

	/**
	 * 属性密码的setter方法
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 属性seal的getter方法
	 */

	@Column(name = "SEAL")
	public String getSeal() {
		return this.seal;
	}

	/**
	 * 属性seal的setter方法
	 */
	public void setSeal(String seal) {
		this.seal = seal;
	}

	/**
	 * 属性密码设置时间的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "PASSWORDSETDATE")
	public Date getPasswordSetDate() {
		return this.passwordSetDate;
	}

	/**
	 * 属性密码设置时间的setter方法
	 */
	public void setPasswordSetDate(Date passwordSetDate) {
		this.passwordSetDate = passwordSetDate;
	}

	/**
	 * 属性密码过期时间的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "PASSWORDEXPIREDATE")
	public Date getPasswordExpireDate() {
		return this.passwordExpireDate;
	}

	/**
	 * 属性密码过期时间的setter方法
	 */
	public void setPasswordExpireDate(Date passwordExpireDate) {
		this.passwordExpireDate = passwordExpireDate;
	}

	/**
	 * 属性账户编号的getter方法
	 */

	@Column(name = "ACCOUNTCODE")
	public String getAccountCode() {
		return this.accountCode;
	}

	/**
	 * 属性账户编号的setter方法
	 */
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	/**
	 * 属性phone的getter方法
	 */

	@Column(name = "PHONE")
	public String getPhone() {
		return this.phone;
	}

	/**
	 * 属性phone的setter方法
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 属性手机的getter方法
	 */

	@Column(name = "MOBILE")
	public String getMobile() {
		return this.mobile;
	}

	/**
	 * 属性手机的setter方法
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 属性地址的getter方法
	 */

	@Column(name = "ADDRESS")
	public String getAddress() {
		return this.address;
	}

	/**
	 * 属性地址的setter方法
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 属性邮编的getter方法
	 */

	@Column(name = "POSTCODE")
	public String getPostCode() {
		return this.postCode;
	}

	/**
	 * 属性邮编的setter方法
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	/**
	 * 属性电子邮件的getter方法
	 */

	@Column(name = "EMAIL")
	public String getEmail() {
		return this.email;
	}

	/**
	 * 属性电子邮件的setter方法
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 属性用户标志的getter方法
	 */

	@Column(name = "USERFLAG")
	public String getUserFlag() {
		return this.userFlag;
	}

	/**
	 * 属性用户标志的setter方法
	 */
	public void setUserFlag(String userFlag) {
		this.userFlag = userFlag;
	}

	/**
	 * 属性loginsystem的getter方法
	 */

	@Column(name = "LOGINSYSTEM")
	public String getLoginsystem() {
		return this.loginsystem;
	}

	/**
	 * 属性loginsystem的setter方法
	 */
	public void setLoginsystem(String loginsystem) {
		this.loginsystem = loginsystem;
	}

	/**
	 * 属性最新员工代码的getter方法
	 */

	@Column(name = "NEWUSERCODE")
	public String getNewUserCode() {
		return this.newUserCode;
	}

	/**
	 * 属性最新员工代码的setter方法
	 */
	public void setNewUserCode(String newUserCode) {
		this.newUserCode = newUserCode;
	}

	/**
	 * 属性效力状态的getter方法
	 */

	@Column(name = "VALIDSTATUS")
	public String getValidStatus() {
		return this.validStatus;
	}

	/**
	 * 属性效力状态的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}

	/**
	 * 属性专项代码(对应会计科目)的getter方法
	 */

	@Column(name = "ARTICLECODE")
	public String getArticleCode() {
		return this.articleCode;
	}

	/**
	 * 属性专项代码(对应会计科目)的setter方法
	 */
	public void setArticleCode(String articleCode) {
		this.articleCode = articleCode;
	}

	/**
	 * 属性标志的getter方法
	 */

	@Column(name = "FLAG")
	public String getFlag() {
		return this.flag;
	}

	/**
	 * 属性标志的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * 属性销售点终端号的getter方法
	 */

	@Column(name = "POSTERMINALNO")
	public String getPosterminalNo() {
		return this.posterminalNo;
	}

	/**
	 * 属性销售点终端号的setter方法
	 */
	public void setPosterminalNo(String posterminalNo) {
		this.posterminalNo = posterminalNo;
	}

	/**
	 * 属性usertype的getter方法
	 */

	@Column(name = "USERTYPE")
	public String getUsertype() {
		return this.usertype;
	}

	/**
	 * 属性usertype的setter方法
	 */
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	/**
	 * 属性是否绑定硬件信息标志 0否 1是的getter方法
	 */

	@Column(name = "BINDINGFLAG")
	public String getBindingFlag() {
		return this.bindingFlag;
	}

	/**
	 * 属性是否绑定硬件信息标志 0否 1是的setter方法
	 */
	public void setBindingFlag(String bindingFlag) {
		this.bindingFlag = bindingFlag;
	}

	/**
	 * 属性业务归属人员许可证号（从销售系统同步）的getter方法
	 */

	@Column(name = "PROFESSIONALNO")
	public String getProfessionalNo() {
		return this.professionalNo;
	}

	/**
	 * 属性业务归属人员许可证号（从销售系统同步）的setter方法
	 */
	public void setProfessionalNo(String professionalNo) {
		this.professionalNo = professionalNo;
	}

}
