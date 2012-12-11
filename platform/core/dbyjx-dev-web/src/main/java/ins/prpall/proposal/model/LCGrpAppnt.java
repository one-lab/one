package ins.prpall.proposal.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * POJO类LCGrpAppnt
 */
@Entity
@Table(name = "LCGRPAPPNT")
public class LCGrpAppnt implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性集体合同号码 */
	private String grpContNo;

	/** 属性客户号码 */
	private String customerNo;

	/** 属性印刷号码 */
	private String prtNo;

	/** 属性地址序号 */
	private String addressNo;

	/** 属性投保人级别 */
	private String appntGrade;

	/** 属性名称 */
	private String name;

	/** 属性通讯地址 */
	private String postalAddress;

	/** 属性邮政编码 */
	private String zipCode;

	/** 属性单位电话 */
	private String phone;

	/** 属性密码 */
	private String password;

	/** 属性任务当前状态 */
	private String state;

	/** 属性投保人类型 */
	private String appntType;

	/** 属性与被保人关系 */
	private String relationToInsured;

	/** 属性已参加过社会统筹 */
	private String societyStat;

	/** 属性社保登记证号 */
	private String societyRegistNo;

	/** 属性联系部门 */
	private String department;

	/** 属性联系人 */
	private String name1;

	/** 属性联系人性别 */
	private String sex1;

	/** 属性联系人电话 */
	private String telphone1;

	/** 属性手机 */
	private String phone1;

	/** 属性电子邮件 */
	private String email;

	/** 属性操作员 */
	private String operator;

	/** 属性生产日期 */
	private Date makeDate;

	/** 属性入机时间 */
	private String makeTime;

	/** 属性最后一次修改日期 */
	private Date modifyDate;

	/** 属性修改时间 */
	private String modifyTime;

	/**
	 * 类LCGrpAppnt的默认构造方法
	 */
	public LCGrpAppnt() {
	}

	/**
	 * 属性集体合同号码的getter方法
	 */
	@Id
	@Column(name = "GRPCONTNO")
	public String getGrpContNo() {
		return this.grpContNo;
	}

	/**
	 * 属性集体合同号码的setter方法
	 */
	public void setGrpContNo(String grpContNo) {
		this.grpContNo = grpContNo;
	}

	/**
	 * 属性客户号码的getter方法
	 */

	@Column(name = "CUSTOMERNO")
	public String getCustomerNo() {
		return this.customerNo;
	}

	/**
	 * 属性客户号码的setter方法
	 */
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	/**
	 * 属性印刷号码的getter方法
	 */

	@Column(name = "PRTNO")
	public String getPrtNo() {
		return this.prtNo;
	}

	/**
	 * 属性印刷号码的setter方法
	 */
	public void setPrtNo(String prtNo) {
		this.prtNo = prtNo;
	}

	/**
	 * 属性地址序号的getter方法
	 */

	@Column(name = "ADDRESSNO")
	public String getAddressNo() {
		return this.addressNo;
	}

	/**
	 * 属性地址序号的setter方法
	 */
	public void setAddressNo(String addressNo) {
		this.addressNo = addressNo;
	}

	/**
	 * 属性投保人级别的getter方法
	 */

	@Column(name = "APPNTGRADE")
	public String getAppntGrade() {
		return this.appntGrade;
	}

	/**
	 * 属性投保人级别的setter方法
	 */
	public void setAppntGrade(String appntGrade) {
		this.appntGrade = appntGrade;
	}

	/**
	 * 属性名称的getter方法
	 */

	@Column(name = "NAME")
	public String getName() {
		return this.name;
	}

	/**
	 * 属性名称的setter方法
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 属性通讯地址的getter方法
	 */

	@Column(name = "POSTALADDRESS")
	public String getPostalAddress() {
		return this.postalAddress;
	}

	/**
	 * 属性通讯地址的setter方法
	 */
	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	/**
	 * 属性邮政编码的getter方法
	 */

	@Column(name = "ZIPCODE")
	public String getZipCode() {
		return this.zipCode;
	}

	/**
	 * 属性邮政编码的setter方法
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * 属性单位电话的getter方法
	 */

	@Column(name = "PHONE")
	public String getPhone() {
		return this.phone;
	}

	/**
	 * 属性单位电话的setter方法
	 */
	public void setPhone(String phone) {
		this.phone = phone;
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
	 * 属性任务当前状态的getter方法
	 */

	@Column(name = "STATE")
	public String getState() {
		return this.state;
	}

	/**
	 * 属性任务当前状态的setter方法
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 属性投保人类型的getter方法
	 */

	@Column(name = "APPNTTYPE")
	public String getAppntType() {
		return this.appntType;
	}

	/**
	 * 属性投保人类型的setter方法
	 */
	public void setAppntType(String appntType) {
		this.appntType = appntType;
	}

	/**
	 * 属性与被保人关系的getter方法
	 */

	@Column(name = "RELATIONTOINSURED")
	public String getRelationToInsured() {
		return this.relationToInsured;
	}

	/**
	 * 属性与被保人关系的setter方法
	 */
	public void setRelationToInsured(String relationToInsured) {
		this.relationToInsured = relationToInsured;
	}

	/**
	 * 属性已参加过社会统筹的getter方法
	 */

	@Column(name = "SOCIETYSTAT")
	public String getSocietyStat() {
		return this.societyStat;
	}

	/**
	 * 属性已参加过社会统筹的setter方法
	 */
	public void setSocietyStat(String societyStat) {
		this.societyStat = societyStat;
	}

	/**
	 * 属性社保登记证号的getter方法
	 */

	@Column(name = "SOCIETYREGISTNO")
	public String getSocietyRegistNo() {
		return this.societyRegistNo;
	}

	/**
	 * 属性社保登记证号的setter方法
	 */
	public void setSocietyRegistNo(String societyRegistNo) {
		this.societyRegistNo = societyRegistNo;
	}

	/**
	 * 属性联系部门的getter方法
	 */

	@Column(name = "DEPARTMENT")
	public String getDepartment() {
		return this.department;
	}

	/**
	 * 属性联系部门的setter方法
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * 属性联系人的getter方法
	 */

	@Column(name = "NAME1")
	public String getName1() {
		return this.name1;
	}

	/**
	 * 属性联系人的setter方法
	 */
	public void setName1(String name1) {
		this.name1 = name1;
	}

	/**
	 * 属性联系人性别的getter方法
	 */

	@Column(name = "SEX1")
	public String getSex1() {
		return this.sex1;
	}

	/**
	 * 属性联系人性别的setter方法
	 */
	public void setSex1(String sex1) {
		this.sex1 = sex1;
	}

	/**
	 * 属性联系人电话的getter方法
	 */

	@Column(name = "TELPHONE1")
	public String getTelphone1() {
		return this.telphone1;
	}

	/**
	 * 属性联系人电话的setter方法
	 */
	public void setTelphone1(String telphone1) {
		this.telphone1 = telphone1;
	}

	/**
	 * 属性手机的getter方法
	 */

	@Column(name = "PHONE1")
	public String getPhone1() {
		return this.phone1;
	}

	/**
	 * 属性手机的setter方法
	 */
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	/**
	 * 属性电子邮件的getter方法
	 */

	@Column(name = "E_MAIL")
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
	 * 属性操作员的getter方法
	 */

	@Column(name = "OPERATOR")
	public String getOperator() {
		return this.operator;
	}

	/**
	 * 属性操作员的setter方法
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * 属性生产日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "MAKEDATE")
	public Date getMakeDate() {
		return this.makeDate;
	}

	/**
	 * 属性生产日期的setter方法
	 */
	public void setMakeDate(Date makeDate) {
		this.makeDate = makeDate;
	}

	/**
	 * 属性入机时间的getter方法
	 */

	@Column(name = "MAKETIME")
	public String getMakeTime() {
		return this.makeTime;
	}

	/**
	 * 属性入机时间的setter方法
	 */
	public void setMakeTime(String makeTime) {
		this.makeTime = makeTime;
	}

	/**
	 * 属性最后一次修改日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFYDATE")
	public Date getModifyDate() {
		return this.modifyDate;
	}

	/**
	 * 属性最后一次修改日期的setter方法
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	/**
	 * 属性修改时间的getter方法
	 */

	@Column(name = "MODIFYTIME")
	public String getModifyTime() {
		return this.modifyTime;
	}

	/**
	 * 属性修改时间的setter方法
	 */
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

}
