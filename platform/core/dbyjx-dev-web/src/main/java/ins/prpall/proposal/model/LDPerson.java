package ins.prpall.proposal.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * POJO类LDPerson
 */
@Entity
@Table(name = "LDPERSON")
public class LDPerson implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性客户号码 */
	private String customerNo;

	/** 属性客户姓名 */
	private String name;

	/** 属性客户性别 */
	private String sex;

	/** 属性客户出生日期 */
	private Date birthday;

	/** 属性证件类型 */
	private String idType;

	/** 属性证件号码 */
	private String idNo;

	/** 属性保单口令 */
	private String password;

	/** 属性国籍 */
	private String nativePlace;

	/** 属性民族 */
	private String nationality;

	/** 属性户口所在地 */
	private String rgtAddress;

	/** 属性婚姻状况 */
	private String marriage;

	/** 属性结婚日期 */
	private Date marriageDate;

	/** 属性健康状况 */
	private String health;

	/** 属性身高 */
	private BigDecimal stature;

	/** 属性体重 */
	private BigDecimal avoirdupois;

	/** 属性学历 */
	private String degree;

	/** 属性信用等级 */
	private String creditGrade;

	/** 属性其它证件类型 */
	private String othIDType;

	/** 属性其它证件号码 */
	private String othIDNo;

	/** 属性ic卡号 */
	private String icNo;

	/** 属性单位编码 */
	private String grpNo;

	/** 属性入司日期 */
	private Date joinCompanyDate;

	/** 属性参加工作日期 */
	private Date startWorkDate;

	/** 属性职位 */
	private String position;

	/** 属性工资 */
	private BigDecimal salary;

	/** 属性职业类别 */
	private String occupationType;

	/** 属性职业代码 */
	private String occupationCode;

	/** 属性职业（工种） */
	private String workType;

	/** 属性无名单保障计划 */
	private String pluralityType;

	/** 属性死亡日期 */
	private Date deathDate;

	/** 属性是否吸烟标志 */
	private String smokeFlag;

	/** 属性黑名单标记 */
	private String blacklistFlag;

	/** 属性属性 */
	private String proterty;

	/** 属性备注 */
	private String remark;

	/** 属性状态 */
	private String state;

	/** 属性VIP值 */
	private String vipValue;

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

	/** 属性单位名称 */
	private String grpName;

	/** 属性驾照 */
	private String license;

	/** 属性驾照类型 */
	private String licenseType;

	/** 属性SocialInsuNo */
	private String socialInsuNo;

	/** 属性兼职（工种） */
	private String partTime;

	/** 属性行业 */
	private String industry;

	/** 属性客户合并标记 */
	private String customerUnionFlag;

	/** 属性被保险人关联标记 */
	private BigDecimal insuredRelatedFlag;

	/**
	 * 类LDPerson的默认构造方法
	 */
	public LDPerson() {
	}

	/**
	 * 属性客户号码的getter方法
	 */
	@Id
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
	 * 属性客户性别的getter方法
	 */

	@Column(name = "SEX")
	public String getSex() {
		return this.sex;
	}

	/**
	 * 属性客户性别的setter方法
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 属性客户出生日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDAY")
	public Date getBirthday() {
		return this.birthday;
	}

	/**
	 * 属性客户出生日期的setter方法
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * 属性证件类型的getter方法
	 */

	@Column(name = "IDTYPE")
	public String getIdType() {
		return this.idType;
	}

	/**
	 * 属性证件类型的setter方法
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}

	/**
	 * 属性证件号码的getter方法
	 */

	@Column(name = "IDNO")
	public String getIdNo() {
		return this.idNo;
	}

	/**
	 * 属性证件号码的setter方法
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
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
	 * 属性国籍的getter方法
	 */

	@Column(name = "NATIVEPLACE")
	public String getNativePlace() {
		return this.nativePlace;
	}

	/**
	 * 属性国籍的setter方法
	 */
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	/**
	 * 属性民族的getter方法
	 */

	@Column(name = "NATIONALITY")
	public String getNationality() {
		return this.nationality;
	}

	/**
	 * 属性民族的setter方法
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * 属性户口所在地的getter方法
	 */

	@Column(name = "RGTADDRESS")
	public String getRgtAddress() {
		return this.rgtAddress;
	}

	/**
	 * 属性户口所在地的setter方法
	 */
	public void setRgtAddress(String rgtAddress) {
		this.rgtAddress = rgtAddress;
	}

	/**
	 * 属性婚姻状况的getter方法
	 */

	@Column(name = "MARRIAGE")
	public String getMarriage() {
		return this.marriage;
	}

	/**
	 * 属性婚姻状况的setter方法
	 */
	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	/**
	 * 属性结婚日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "MARRIAGEDATE")
	public Date getMarriageDate() {
		return this.marriageDate;
	}

	/**
	 * 属性结婚日期的setter方法
	 */
	public void setMarriageDate(Date marriageDate) {
		this.marriageDate = marriageDate;
	}

	/**
	 * 属性健康状况的getter方法
	 */

	@Column(name = "HEALTH")
	public String getHealth() {
		return this.health;
	}

	/**
	 * 属性健康状况的setter方法
	 */
	public void setHealth(String health) {
		this.health = health;
	}

	/**
	 * 属性身高的getter方法
	 */

	@Column(name = "STATURE")
	public BigDecimal getStature() {
		return this.stature;
	}

	/**
	 * 属性身高的setter方法
	 */
	public void setStature(BigDecimal stature) {
		this.stature = stature;
	}

	/**
	 * 属性体重的getter方法
	 */

	@Column(name = "AVOIRDUPOIS")
	public BigDecimal getAvoirdupois() {
		return this.avoirdupois;
	}

	/**
	 * 属性体重的setter方法
	 */
	public void setAvoirdupois(BigDecimal avoirdupois) {
		this.avoirdupois = avoirdupois;
	}

	/**
	 * 属性学历的getter方法
	 */

	@Column(name = "DEGREE")
	public String getDegree() {
		return this.degree;
	}

	/**
	 * 属性学历的setter方法
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}

	/**
	 * 属性信用等级的getter方法
	 */

	@Column(name = "CREDITGRADE")
	public String getCreditGrade() {
		return this.creditGrade;
	}

	/**
	 * 属性信用等级的setter方法
	 */
	public void setCreditGrade(String creditGrade) {
		this.creditGrade = creditGrade;
	}

	/**
	 * 属性其它证件类型的getter方法
	 */

	@Column(name = "OTHIDTYPE")
	public String getOthIDType() {
		return this.othIDType;
	}

	/**
	 * 属性其它证件类型的setter方法
	 */
	public void setOthIDType(String othIDType) {
		this.othIDType = othIDType;
	}

	/**
	 * 属性其它证件号码的getter方法
	 */

	@Column(name = "OTHIDNO")
	public String getOthIDNo() {
		return this.othIDNo;
	}

	/**
	 * 属性其它证件号码的setter方法
	 */
	public void setOthIDNo(String othIDNo) {
		this.othIDNo = othIDNo;
	}

	/**
	 * 属性ic卡号的getter方法
	 */

	@Column(name = "ICNO")
	public String getIcNo() {
		return this.icNo;
	}

	/**
	 * 属性ic卡号的setter方法
	 */
	public void setIcNo(String icNo) {
		this.icNo = icNo;
	}

	/**
	 * 属性单位编码的getter方法
	 */

	@Column(name = "GRPNO")
	public String getGrpNo() {
		return this.grpNo;
	}

	/**
	 * 属性单位编码的setter方法
	 */
	public void setGrpNo(String grpNo) {
		this.grpNo = grpNo;
	}

	/**
	 * 属性入司日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "JOINCOMPANYDATE")
	public Date getJoinCompanyDate() {
		return this.joinCompanyDate;
	}

	/**
	 * 属性入司日期的setter方法
	 */
	public void setJoinCompanyDate(Date joinCompanyDate) {
		this.joinCompanyDate = joinCompanyDate;
	}

	/**
	 * 属性参加工作日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "STARTWORKDATE")
	public Date getStartWorkDate() {
		return this.startWorkDate;
	}

	/**
	 * 属性参加工作日期的setter方法
	 */
	public void setStartWorkDate(Date startWorkDate) {
		this.startWorkDate = startWorkDate;
	}

	/**
	 * 属性职位的getter方法
	 */

	@Column(name = "POSITION")
	public String getPosition() {
		return this.position;
	}

	/**
	 * 属性职位的setter方法
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * 属性工资的getter方法
	 */

	@Column(name = "SALARY")
	public BigDecimal getSalary() {
		return this.salary;
	}

	/**
	 * 属性工资的setter方法
	 */
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	/**
	 * 属性职业类别的getter方法
	 */

	@Column(name = "OCCUPATIONTYPE")
	public String getOccupationType() {
		return this.occupationType;
	}

	/**
	 * 属性职业类别的setter方法
	 */
	public void setOccupationType(String occupationType) {
		this.occupationType = occupationType;
	}

	/**
	 * 属性职业代码的getter方法
	 */

	@Column(name = "OCCUPATIONCODE")
	public String getOccupationCode() {
		return this.occupationCode;
	}

	/**
	 * 属性职业代码的setter方法
	 */
	public void setOccupationCode(String occupationCode) {
		this.occupationCode = occupationCode;
	}

	/**
	 * 属性职业（工种）的getter方法
	 */

	@Column(name = "WORKTYPE")
	public String getWorkType() {
		return this.workType;
	}

	/**
	 * 属性职业（工种）的setter方法
	 */
	public void setWorkType(String workType) {
		this.workType = workType;
	}

	/**
	 * 属性无名单保障计划的getter方法
	 */

	@Column(name = "PLURALITYTYPE")
	public String getPluralityType() {
		return this.pluralityType;
	}

	/**
	 * 属性无名单保障计划的setter方法
	 */
	public void setPluralityType(String pluralityType) {
		this.pluralityType = pluralityType;
	}

	/**
	 * 属性死亡日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "DEATHDATE")
	public Date getDeathDate() {
		return this.deathDate;
	}

	/**
	 * 属性死亡日期的setter方法
	 */
	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	/**
	 * 属性是否吸烟标志的getter方法
	 */

	@Column(name = "SMOKEFLAG")
	public String getSmokeFlag() {
		return this.smokeFlag;
	}

	/**
	 * 属性是否吸烟标志的setter方法
	 */
	public void setSmokeFlag(String smokeFlag) {
		this.smokeFlag = smokeFlag;
	}

	/**
	 * 属性黑名单标记的getter方法
	 */

	@Column(name = "BLACKLISTFLAG")
	public String getBlacklistFlag() {
		return this.blacklistFlag;
	}

	/**
	 * 属性黑名单标记的setter方法
	 */
	public void setBlacklistFlag(String blacklistFlag) {
		this.blacklistFlag = blacklistFlag;
	}

	/**
	 * 属性属性的getter方法
	 */

	@Column(name = "PROTERTY")
	public String getProterty() {
		return this.proterty;
	}

	/**
	 * 属性属性的setter方法
	 */
	public void setProterty(String proterty) {
		this.proterty = proterty;
	}

	/**
	 * 属性备注的getter方法
	 */

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	/**
	 * 属性备注的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
	 * 属性VIP值的getter方法
	 */

	@Column(name = "VIPVALUE")
	public String getVipValue() {
		return this.vipValue;
	}

	/**
	 * 属性VIP值的setter方法
	 */
	public void setVipValue(String vipValue) {
		this.vipValue = vipValue;
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

	/**
	 * 属性单位名称的getter方法
	 */

	@Column(name = "GRPNAME")
	public String getGrpName() {
		return this.grpName;
	}

	/**
	 * 属性单位名称的setter方法
	 */
	public void setGrpName(String grpName) {
		this.grpName = grpName;
	}

	/**
	 * 属性驾照的getter方法
	 */

	@Column(name = "LICENSE")
	public String getLicense() {
		return this.license;
	}

	/**
	 * 属性驾照的setter方法
	 */
	public void setLicense(String license) {
		this.license = license;
	}

	/**
	 * 属性驾照类型的getter方法
	 */

	@Column(name = "LICENSETYPE")
	public String getLicenseType() {
		return this.licenseType;
	}

	/**
	 * 属性驾照类型的setter方法
	 */
	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	/**
	 * 属性SocialInsuNo的getter方法
	 */

	@Column(name = "SOCIALINSUNO")
	public String getSocialInsuNo() {
		return this.socialInsuNo;
	}

	/**
	 * 属性SocialInsuNo的setter方法
	 */
	public void setSocialInsuNo(String socialInsuNo) {
		this.socialInsuNo = socialInsuNo;
	}

	/**
	 * 属性兼职（工种）的getter方法
	 */

	@Column(name = "PARTTIME")
	public String getPartTime() {
		return this.partTime;
	}

	/**
	 * 属性兼职（工种）的setter方法
	 */
	public void setPartTime(String partTime) {
		this.partTime = partTime;
	}

	/**
	 * 属性行业的getter方法
	 */

	@Column(name = "INDUSTRY")
	public String getIndustry() {
		return this.industry;
	}

	/**
	 * 属性行业的setter方法
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
	}

	/**
	 * 属性客户合并标记的getter方法
	 */

	@Column(name = "CUSTOMERUNIONFLAG")
	public String getCustomerUnionFlag() {
		return this.customerUnionFlag;
	}

	/**
	 * 属性客户合并标记的setter方法
	 */
	public void setCustomerUnionFlag(String customerUnionFlag) {
		this.customerUnionFlag = customerUnionFlag;
	}

	/**
	 * 属性被保险人关联标记的getter方法
	 */

	@Column(name = "INSUREDRELATEDFLAG")
	public BigDecimal getInsuredRelatedFlag() {
		return this.insuredRelatedFlag;
	}

	/**
	 * 属性被保险人关联标记的setter方法
	 */
	public void setInsuredRelatedFlag(BigDecimal insuredRelatedFlag) {
		this.insuredRelatedFlag = insuredRelatedFlag;
	}

}
