package ins.prpall.proposal.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.math.BigDecimal;
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
 * POJO类LCInsured
 */
@Entity
@Table(name = "LCINSURED")
public class LCInsured implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性ID */
	private LCInsuredId id;

	/** 属性集体合同号码 */
	private String grpContNo;

	/** 属性印刷号码 */
	private String prtNo;

	/** 属性投保人客户号码 */
	private String appntNo;

	/** 属性管理机构 */
	private String manageCom;

	/** 属性处理机构 */
	private String executeCom;

	/** 属性家庭保障号 */
	private String familyID;

	/** 属性与主被保人关系 */
	private String relationToMainInsured;

	/** 属性与投保人关系 */
	private String relationToAppnt;

	/** 属性地址序号 */
	private String addressNo;

	/** 属性客户内部号码 */
	private String sequenceNo;

	/** 属性名称 */
	private String name;

	/** 属性性别 */
	private String sex;

	/** 属性出生日期 */
	private Date birthday;

	/** 属性证件类型 */
	private String idType;

	/** 属性证件号码 */
	private String idNo;

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

	/** 属性机构代码 */
	private String bankCode;

	/** 属性银行帐号 */
	private String bankAccNo;

	/** 属性银行帐户名 */
	private String accName;

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

	/** 属性是否吸烟标志 */
	private String smokeFlag;

	/** 属性保险计划编码 */
	private String contPlanCode;

	/** 属性操作员 */
	private String operator;

	/** 属性被保人状态 */
	private String insuredStat;

	/** 属性生产日期 */
	private Date makeDate;

	/** 属性入机时间 */
	private String makeTime;

	/** 属性最后一次修改日期 */
	private Date modifyDate;

	/** 属性修改时间 */
	private String modifyTime;

	/** 属性核保状态 */
	private String uwFlag;

	/** 属性最终核保人编码 */
	private String uwCode;

	/** 属性核保完成日期 */
	private Date uwDate;

	/** 属性核保完成时间 */
	private String uwTime;

	/** 属性身体指标 */
	private BigDecimal bmi;

	/** 属性被保人数目 */
	private BigDecimal insuredPeoples;

	/** 属性驾照 */
	private String license;

	/** 属性车牌种类 */
	private String licenseType;

	/** 属性团体客户序号 */
	private BigDecimal customerSeqNo;

	/** 属性SocialInsuNo */
	private String socialInsuNo;

	/** 属性兼职（工种） */
	private String partTime;

	/** 属性行业 */
	private String industry;

	/** 属性备注 */
	private String remark;

	/** 属性备注1 */
	private String remark1;

	/** 属性被保险人关联标记 */
	private BigDecimal insuredRelatedFlag;

	/**
	 * 类LCInsured的默认构造方法
	 */
	public LCInsured() {
	}

	/**
	 * 属性ID的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "contNo", column = @Column(name = "CONTNO")),
			@AttributeOverride(name = "insuredNo", column = @Column(name = "INSUREDNO")) })
	public LCInsuredId getId() {
		return this.id;
	}

	/**
	 * 属性ID的setter方法
	 */
	public void setId(LCInsuredId id) {
		this.id = id;
	}

	/**
	 * 属性集体合同号码的getter方法
	 */

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
	 * 属性投保人客户号码的getter方法
	 */

	@Column(name = "APPNTNO")
	public String getAppntNo() {
		return this.appntNo;
	}

	/**
	 * 属性投保人客户号码的setter方法
	 */
	public void setAppntNo(String appntNo) {
		this.appntNo = appntNo;
	}

	/**
	 * 属性管理机构的getter方法
	 */

	@Column(name = "MANAGECOM")
	public String getManageCom() {
		return this.manageCom;
	}

	/**
	 * 属性管理机构的setter方法
	 */
	public void setManageCom(String manageCom) {
		this.manageCom = manageCom;
	}

	/**
	 * 属性处理机构的getter方法
	 */

	@Column(name = "EXECUTECOM")
	public String getExecuteCom() {
		return this.executeCom;
	}

	/**
	 * 属性处理机构的setter方法
	 */
	public void setExecuteCom(String executeCom) {
		this.executeCom = executeCom;
	}

	/**
	 * 属性家庭保障号的getter方法
	 */

	@Column(name = "FAMILYID")
	public String getFamilyID() {
		return this.familyID;
	}

	/**
	 * 属性家庭保障号的setter方法
	 */
	public void setFamilyID(String familyID) {
		this.familyID = familyID;
	}

	/**
	 * 属性与主被保人关系的getter方法
	 */

	@Column(name = "RELATIONTOMAININSURED")
	public String getRelationToMainInsured() {
		return this.relationToMainInsured;
	}

	/**
	 * 属性与主被保人关系的setter方法
	 */
	public void setRelationToMainInsured(String relationToMainInsured) {
		this.relationToMainInsured = relationToMainInsured;
	}

	/**
	 * 属性与投保人关系的getter方法
	 */

	@Column(name = "RELATIONTOAPPNT")
	public String getRelationToAppnt() {
		return this.relationToAppnt;
	}

	/**
	 * 属性与投保人关系的setter方法
	 */
	public void setRelationToAppnt(String relationToAppnt) {
		this.relationToAppnt = relationToAppnt;
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
	 * 属性客户内部号码的getter方法
	 */

	@Column(name = "SEQUENCENO")
	public String getSequenceNo() {
		return this.sequenceNo;
	}

	/**
	 * 属性客户内部号码的setter方法
	 */
	public void setSequenceNo(String sequenceNo) {
		this.sequenceNo = sequenceNo;
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
	 * 属性性别的getter方法
	 */

	@Column(name = "SEX")
	public String getSex() {
		return this.sex;
	}

	/**
	 * 属性性别的setter方法
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 属性出生日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDAY")
	public Date getBirthday() {
		return this.birthday;
	}

	/**
	 * 属性出生日期的setter方法
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
	 * 属性机构代码的getter方法
	 */

	@Column(name = "BANKCODE")
	public String getBankCode() {
		return this.bankCode;
	}

	/**
	 * 属性机构代码的setter方法
	 */
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	/**
	 * 属性银行帐号的getter方法
	 */

	@Column(name = "BANKACCNO")
	public String getBankAccNo() {
		return this.bankAccNo;
	}

	/**
	 * 属性银行帐号的setter方法
	 */
	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}

	/**
	 * 属性银行帐户名的getter方法
	 */

	@Column(name = "ACCNAME")
	public String getAccName() {
		return this.accName;
	}

	/**
	 * 属性银行帐户名的setter方法
	 */
	public void setAccName(String accName) {
		this.accName = accName;
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
	 * 属性保险计划编码的getter方法
	 */

	@Column(name = "CONTPLANCODE")
	public String getContPlanCode() {
		return this.contPlanCode;
	}

	/**
	 * 属性保险计划编码的setter方法
	 */
	public void setContPlanCode(String contPlanCode) {
		this.contPlanCode = contPlanCode;
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
	 * 属性被保人状态的getter方法
	 */

	@Column(name = "INSUREDSTAT")
	public String getInsuredStat() {
		return this.insuredStat;
	}

	/**
	 * 属性被保人状态的setter方法
	 */
	public void setInsuredStat(String insuredStat) {
		this.insuredStat = insuredStat;
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

	/**
	 * 属性核保状态的getter方法
	 */

	@Column(name = "UWFLAG")
	public String getUwFlag() {
		return this.uwFlag;
	}

	/**
	 * 属性核保状态的setter方法
	 */
	public void setUwFlag(String uwFlag) {
		this.uwFlag = uwFlag;
	}

	/**
	 * 属性最终核保人编码的getter方法
	 */

	@Column(name = "UWCODE")
	public String getUwCode() {
		return this.uwCode;
	}

	/**
	 * 属性最终核保人编码的setter方法
	 */
	public void setUwCode(String uwCode) {
		this.uwCode = uwCode;
	}

	/**
	 * 属性核保完成日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "UWDATE")
	public Date getUwDate() {
		return this.uwDate;
	}

	/**
	 * 属性核保完成日期的setter方法
	 */
	public void setUwDate(Date uwDate) {
		this.uwDate = uwDate;
	}

	/**
	 * 属性核保完成时间的getter方法
	 */

	@Column(name = "UWTIME")
	public String getUwTime() {
		return this.uwTime;
	}

	/**
	 * 属性核保完成时间的setter方法
	 */
	public void setUwTime(String uwTime) {
		this.uwTime = uwTime;
	}

	/**
	 * 属性身体指标的getter方法
	 */

	@Column(name = "BMI")
	public BigDecimal getBmi() {
		return this.bmi;
	}

	/**
	 * 属性身体指标的setter方法
	 */
	public void setBmi(BigDecimal bmi) {
		this.bmi = bmi;
	}

	/**
	 * 属性被保人数目的getter方法
	 */

	@Column(name = "INSUREDPEOPLES")
	public BigDecimal getInsuredPeoples() {
		return this.insuredPeoples;
	}

	/**
	 * 属性被保人数目的setter方法
	 */
	public void setInsuredPeoples(BigDecimal insuredPeoples) {
		this.insuredPeoples = insuredPeoples;
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
	 * 属性车牌种类的getter方法
	 */

	@Column(name = "LICENSETYPE")
	public String getLicenseType() {
		return this.licenseType;
	}

	/**
	 * 属性车牌种类的setter方法
	 */
	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	/**
	 * 属性团体客户序号的getter方法
	 */

	@Column(name = "CUSTOMERSEQNO")
	public BigDecimal getCustomerSeqNo() {
		return this.customerSeqNo;
	}

	/**
	 * 属性团体客户序号的setter方法
	 */
	public void setCustomerSeqNo(BigDecimal customerSeqNo) {
		this.customerSeqNo = customerSeqNo;
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
	 * 属性备注1的getter方法
	 */

	@Column(name = "REMARK1")
	public String getRemark1() {
		return this.remark1;
	}

	/**
	 * 属性备注1的setter方法
	 */
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
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
