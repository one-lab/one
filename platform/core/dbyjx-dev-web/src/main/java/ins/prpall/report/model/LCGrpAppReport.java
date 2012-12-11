package ins.prpall.report.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * POJO类LCGrpAppReport
 */
@Entity
@Table(name = "LCGRPAPPREPORT")
public class LCGrpAppReport implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性序号 */
	private LCGrpAppReportId id;

	/** 属性呈报申请人 */
	private String repOperator;

	/** 属性呈报申请日期 */
	private Date repApplyDate;

	/** 属性客户号码 */
	private String customerNo;

	/** 属性印刷号码 */
	private String prtNo;

	/** 属性客户地址号码 */
	private String addressNo;

	/** 属性投保人级别 */
	private String appntGrade;

	/** 属性客户姓名 */
	private String name;

	/** 属性通讯地址 */
	private String postalAddress;

	/** 属性单位邮编 */
	private String zipCode;

	/** 属性单位电话 */
	private String phone;

	/** 属性保单口令 */
	private String password;

	/** 属性状态 */
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
	private String people;

	/** 属性联系人性别 */
	private String peopleSex;

	/** 属性联系人电话 */
	private String peopleTel;

	/** 属性手机 */
	private String peoplePhone;

	/** 属性E-MAIL */
	private String email;

	/** 属性操作员 */
	private String operator;

	/** 属性入机日期 */
	private Date makeDate;

	/** 属性入机时间 */
	private String makeTime;

	/** 属性最后一次修改日期 */
	private Date modifyDate;

	/** 属性最后一次修改时间 */
	private String modifyTime;

	/**
	 * 类LCGrpAppReport的默认构造方法
	 */
	public LCGrpAppReport() {
	}

	/**
	 * 属性序号的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "repNo", column = @Column(name = "REPNO")),
			@AttributeOverride(name = "grpContNo", column = @Column(name = "GRPCONTNO")) })
	public LCGrpAppReportId getId() {
		return this.id;
	}

	/**
	 * 属性序号的setter方法
	 */
	public void setId(LCGrpAppReportId id) {
		this.id = id;
	}

	/**
	 * 属性呈报申请人的getter方法
	 */

	@Column(name = "REPOPERATOR")
	public String getRepOperator() {
		return this.repOperator;
	}

	/**
	 * 属性呈报申请人的setter方法
	 */
	public void setRepOperator(String repOperator) {
		this.repOperator = repOperator;
	}

	/**
	 * 属性呈报申请日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "REPAPPLYDATE")
	public Date getRepApplyDate() {
		return this.repApplyDate;
	}

	/**
	 * 属性呈报申请日期的setter方法
	 */
	public void setRepApplyDate(Date repApplyDate) {
		this.repApplyDate = repApplyDate;
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
	 * 属性客户地址号码的getter方法
	 */

	@Column(name = "ADDRESSNO")
	public String getAddressNo() {
		return this.addressNo;
	}

	/**
	 * 属性客户地址号码的setter方法
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
	 * 属性客户姓名的getter方法
	 */

	@Column(name = "NAME")
	public String getName() {
		return this.name;
	}

	/**
	 * 属性客户姓名的setter方法
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
	 * 属性单位邮编的getter方法
	 */

	@Column(name = "ZIPCODE")
	public String getZipCode() {
		return this.zipCode;
	}

	/**
	 * 属性单位邮编的setter方法
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
	 * 属性保单口令的getter方法
	 */

	@Column(name = "PASSWORD")
	public String getPassword() {
		return this.password;
	}

	/**
	 * 属性保单口令的setter方法
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 属性状态的getter方法
	 */

	@Column(name = "STATE")
	public String getState() {
		return this.state;
	}

	/**
	 * 属性状态的setter方法
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

	@Column(name = "PEOPLE")
	public String getPeople() {
		return this.people;
	}

	/**
	 * 属性联系人的setter方法
	 */
	public void setPeople(String people) {
		this.people = people;
	}

	/**
	 * 属性联系人性别的getter方法
	 */

	@Column(name = "PEOPLESEX")
	public String getPeopleSex() {
		return this.peopleSex;
	}

	/**
	 * 属性联系人性别的setter方法
	 */
	public void setPeopleSex(String peopleSex) {
		this.peopleSex = peopleSex;
	}

	/**
	 * 属性联系人电话的getter方法
	 */

	@Column(name = "PEOPLETEL")
	public String getPeopleTel() {
		return this.peopleTel;
	}

	/**
	 * 属性联系人电话的setter方法
	 */
	public void setPeopleTel(String peopleTel) {
		this.peopleTel = peopleTel;
	}

	/**
	 * 属性手机的getter方法
	 */

	@Column(name = "PEOPLEPHONE")
	public String getPeoplePhone() {
		return this.peoplePhone;
	}

	/**
	 * 属性手机的setter方法
	 */
	public void setPeoplePhone(String peoplePhone) {
		this.peoplePhone = peoplePhone;
	}

	/**
	 * 属性E-MAIL的getter方法
	 */

	@Column(name = "EMAIL")
	public String getEmail() {
		return this.email;
	}

	/**
	 * 属性E-MAIL的setter方法
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
	 * 属性入机日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "MAKEDATE")
	public Date getMakeDate() {
		return this.makeDate;
	}

	/**
	 * 属性入机日期的setter方法
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
	 * 属性最后一次修改时间的getter方法
	 */

	@Column(name = "MODIFYTIME")
	public String getModifyTime() {
		return this.modifyTime;
	}

	/**
	 * 属性最后一次修改时间的setter方法
	 */
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

}
