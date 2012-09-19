package ins.claim.report.model;

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
import javax.persistence.UniqueConstraint;

/**
 * POJO类LLCase
 */
@Entity
@Table(name = "LLCASE", uniqueConstraints = @UniqueConstraint(columnNames = "CUSTOMERNO"))
public class LLCase implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性id */
	private LLCaseId id;

	/** 属性申请登记号 */
	private String rgtNo;

	/** 属性案件类型 */
	private String rgtType;

	/** 属性案件状态 */
	private String rgtState;

	/** 属性出险人名称 */
	private String customerName;

	/** 属性出险类型 */
	private String accidentType;

	/** 属性收据信息标志 */
	private String receiptFlag;

	/** 属性医院信息标志 */
	private String hospitalFlag;

	/** 属性立案日期 */
	private Date rgtDate;

	/** 属性理算日期 */
	private Date claimCalDate;

	/** 属性材料齐备日期 */
	private Date affixGetDate;

	/** 属性入院日期 */
	private Date inHospitalDate;

	/** 属性出院日期 */
	private Date outHospitalDate;

	/** 属性无效住院天数 */
	private BigDecimal invaliHosDays;

	/** 属性实际住院天数 */
	private BigDecimal inHospitalDays;

	/** 属性确诊日期 */
	private Date dianoseDate;

	/** 属性联系地址 */
	private String postalAddress;

	/** 属性联系电话 */
	private String phone;

	/** 属性出险开始日期 */
	private Date accStartDate;

	/** 属性出险结束日期 */
	private Date accidentDate;

	/** 属性出险地点 */
	private String accidentSite;

	/** 属性死亡日期 */
	private Date deathDate;

	/** 属性死亡标志 */
	private String dieFlag;

	/** 属性非正常修改状态 */
	private String custState;

	/** 属性事故经过描述 */
	private String accdentDesc;

	/** 属性出险人生日 */
	private Date custBirthday;

	/** 属性出险人性别 */
	private String customerSex;

	/** 属性出险人年龄 */
	private Double customerAge;

	/** 属性受益人证件类型 */
	private String idType;

	/** 属性受益人证件号码 */
	private String idNo;

	/** 属性审核人 */
	private String handler;

	/** 属性审核日期 */
	private Date handleDate;

	/** 属性审核状态 */
	private String uwState;

	/** 属性当前处理人 */
	private String dealer;

	/** 属性申诉标志 */
	private String appealFlag;

	/** 属性全部保单是否统一给付 */
	private String togetherGet;

	/** 属性团体批处理标志 */
	private String grpDealFlag;

	/** 属性赔付金领取方式 */
	private String getMode;

	/** 属性赔付金领取间隔 */
	private BigDecimal getIntv;

	/** 属性核算标记 */
	private String calFlag;

	/** 属性核赔标记 */
	private String uwFlag;

	/** 属性拒赔标记 */
	private String declineFlag;

	/** 属性结案标记 */
	private String endCaseFlag;

	/** 属性结案日期 */
	private Date endCaseDate;

	/** 属性管理机构 */
	private String mngCom;

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

	/** 属性银行编码 */
	private String bankCode;

	/** 属性银行帐号 */
	private String bankAccNo;

	/** 属性银行帐户名 */
	private String accName;

	/** 属性保险金领取方式 */
	private String caseGetMode;

	/** 属性账户修改原因 */
	private String accModifyReason;

	/** 属性报备产生日期 */
	private Date caseNoDate;

	/** 属性VIP标志 */
	private String vipFlag;

	/** 属性出险细节 */
	private String accidentDetail;

	/** 属性治疗情况 */
	private String cureDesc;

	/** 属性单证检查结论 */
	private String affixConclusion;

	/** 属性单证不全原因 */
	private String affixReason;

	/** 属性账单录入标记 */
	private String feeInputFlag;

	/** 属性调查报告标志 */
	private String surveyFlag;

	/** 属性发起呈报标志 */
	private String submitFlag;

	/** 属性提起慰问标志 */
	private String condoleFlag;

	/** 属性信息修改标志 */
	private String editFlag;

	/** 属性二核标志 */
	private String secondUWFlag;

	/** 属性事故发生日期 */
	private Date accDate;

	/** 属性出险结果1 */
	private String accResult1;

	/** 属性出险结果2 */
	private String accResult2;

	/** 属性阳性标志 */
	private String masculineFlag;

	/** 属性医院代码 */
	private String hospitalCode;

	/** 属性医院名称 */
	private String hospitalName;

	/** 属性备注 */
	private String remark;

	/** 属性客户序号 */
	private BigDecimal seqNo;

	/** 属性出险人联系电话 */
	private String contactNo;

	/** 属性住院科室 */
	private String sectionOffice;

	/** 属性承保机构 */
	private String acceptMngCom;

	/**
	 * 类LLCase的默认构造方法
	 */
	public LLCase() {
	}

	/**
	 * 属性id的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "caseNo", column = @Column(name = "CASENO")),
			@AttributeOverride(name = "customerNo", column = @Column(name = "CUSTOMERNO")) })
	public LLCaseId getId() {
		return this.id;
	}

	/**
	 * 属性id的setter方法
	 */
	public void setId(LLCaseId id) {
		this.id = id;
	}

	/**
	 * 属性申请登记号的getter方法
	 */

	@Column(name = "RGTNO")
	public String getRgtNo() {
		return this.rgtNo;
	}

	/**
	 * 属性申请登记号的setter方法
	 */
	public void setRgtNo(String rgtNo) {
		this.rgtNo = rgtNo;
	}

	/**
	 * 属性案件类型的getter方法
	 */

	@Column(name = "RGTTYPE")
	public String getRgtType() {
		return this.rgtType;
	}

	/**
	 * 属性案件类型的setter方法
	 */
	public void setRgtType(String rgtType) {
		this.rgtType = rgtType;
	}

	/**
	 * 属性案件状态的getter方法
	 */

	@Column(name = "RGTSTATE")
	public String getRgtState() {
		return this.rgtState;
	}

	/**
	 * 属性案件状态的setter方法
	 */
	public void setRgtState(String rgtState) {
		this.rgtState = rgtState;
	}

	/**
	 * 属性出险人名称的getter方法
	 */

	@Column(name = "CUSTOMERNAME")
	public String getCustomerName() {
		return this.customerName;
	}

	/**
	 * 属性出险人名称的setter方法
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * 属性出险类型的getter方法
	 */

	@Column(name = "ACCIDENTTYPE")
	public String getAccidentType() {
		return this.accidentType;
	}

	/**
	 * 属性出险类型的setter方法
	 */
	public void setAccidentType(String accidentType) {
		this.accidentType = accidentType;
	}

	/**
	 * 属性收据信息标志的getter方法
	 */

	@Column(name = "RECEIPTFLAG")
	public String getReceiptFlag() {
		return this.receiptFlag;
	}

	/**
	 * 属性收据信息标志的setter方法
	 */
	public void setReceiptFlag(String receiptFlag) {
		this.receiptFlag = receiptFlag;
	}

	/**
	 * 属性医院信息标志的getter方法
	 */

	@Column(name = "HOSPITALFLAG")
	public String getHospitalFlag() {
		return this.hospitalFlag;
	}

	/**
	 * 属性医院信息标志的setter方法
	 */
	public void setHospitalFlag(String hospitalFlag) {
		this.hospitalFlag = hospitalFlag;
	}

	/**
	 * 属性立案日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "RGTDATE")
	public Date getRgtDate() {
		return this.rgtDate;
	}

	/**
	 * 属性立案日期的setter方法
	 */
	public void setRgtDate(Date rgtDate) {
		this.rgtDate = rgtDate;
	}

	/**
	 * 属性理算日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "CLAIMCALDATE")
	public Date getClaimCalDate() {
		return this.claimCalDate;
	}

	/**
	 * 属性理算日期的setter方法
	 */
	public void setClaimCalDate(Date claimCalDate) {
		this.claimCalDate = claimCalDate;
	}

	/**
	 * 属性材料齐备日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "AFFIXGETDATE")
	public Date getAffixGetDate() {
		return this.affixGetDate;
	}

	/**
	 * 属性材料齐备日期的setter方法
	 */
	public void setAffixGetDate(Date affixGetDate) {
		this.affixGetDate = affixGetDate;
	}

	/**
	 * 属性入院日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "INHOSPITALDATE")
	public Date getInHospitalDate() {
		return this.inHospitalDate;
	}

	/**
	 * 属性入院日期的setter方法
	 */
	public void setInHospitalDate(Date inHospitalDate) {
		this.inHospitalDate = inHospitalDate;
	}

	/**
	 * 属性出院日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "OUTHOSPITALDATE")
	public Date getOutHospitalDate() {
		return this.outHospitalDate;
	}

	/**
	 * 属性出院日期的setter方法
	 */
	public void setOutHospitalDate(Date outHospitalDate) {
		this.outHospitalDate = outHospitalDate;
	}

	/**
	 * 属性无效住院天数的getter方法
	 */

	@Column(name = "INVALIHOSDAYS")
	public BigDecimal getInvaliHosDays() {
		return this.invaliHosDays;
	}

	/**
	 * 属性无效住院天数的setter方法
	 */
	public void setInvaliHosDays(BigDecimal invaliHosDays) {
		this.invaliHosDays = invaliHosDays;
	}

	/**
	 * 属性实际住院天数的getter方法
	 */

	@Column(name = "INHOSPITALDAYS")
	public BigDecimal getInHospitalDays() {
		return this.inHospitalDays;
	}

	/**
	 * 属性实际住院天数的setter方法
	 */
	public void setInHospitalDays(BigDecimal inHospitalDays) {
		this.inHospitalDays = inHospitalDays;
	}

	/**
	 * 属性确诊日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "DIANOSEDATE")
	public Date getDianoseDate() {
		return this.dianoseDate;
	}

	/**
	 * 属性确诊日期的setter方法
	 */
	public void setDianoseDate(Date dianoseDate) {
		this.dianoseDate = dianoseDate;
	}

	/**
	 * 属性联系地址的getter方法
	 */

	@Column(name = "POSTALADDRESS")
	public String getPostalAddress() {
		return this.postalAddress;
	}

	/**
	 * 属性联系地址的setter方法
	 */
	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	/**
	 * 属性联系电话的getter方法
	 */

	@Column(name = "PHONE")
	public String getPhone() {
		return this.phone;
	}

	/**
	 * 属性联系电话的setter方法
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 属性出险开始日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "ACCSTARTDATE")
	public Date getAccStartDate() {
		return this.accStartDate;
	}

	/**
	 * 属性出险开始日期的setter方法
	 */
	public void setAccStartDate(Date accStartDate) {
		this.accStartDate = accStartDate;
	}

	/**
	 * 属性出险结束日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "ACCIDENTDATE")
	public Date getAccidentDate() {
		return this.accidentDate;
	}

	/**
	 * 属性出险结束日期的setter方法
	 */
	public void setAccidentDate(Date accidentDate) {
		this.accidentDate = accidentDate;
	}

	/**
	 * 属性出险地点的getter方法
	 */

	@Column(name = "ACCIDENTSITE")
	public String getAccidentSite() {
		return this.accidentSite;
	}

	/**
	 * 属性出险地点的setter方法
	 */
	public void setAccidentSite(String accidentSite) {
		this.accidentSite = accidentSite;
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
	 * 属性死亡标志的getter方法
	 */

	@Column(name = "DIEFLAG")
	public String getDieFlag() {
		return this.dieFlag;
	}

	/**
	 * 属性死亡标志的setter方法
	 */
	public void setDieFlag(String dieFlag) {
		this.dieFlag = dieFlag;
	}

	/**
	 * 属性非正常修改状态的getter方法
	 */

	@Column(name = "CUSTSTATE")
	public String getCustState() {
		return this.custState;
	}

	/**
	 * 属性非正常修改状态的setter方法
	 */
	public void setCustState(String custState) {
		this.custState = custState;
	}

	/**
	 * 属性事故经过描述的getter方法
	 */

	@Column(name = "ACCDENTDESC")
	public String getAccdentDesc() {
		return this.accdentDesc;
	}

	/**
	 * 属性事故经过描述的setter方法
	 */
	public void setAccdentDesc(String accdentDesc) {
		this.accdentDesc = accdentDesc;
	}

	/**
	 * 属性出险人生日的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "CUSTBIRTHDAY")
	public Date getCustBirthday() {
		return this.custBirthday;
	}

	/**
	 * 属性出险人生日的setter方法
	 */
	public void setCustBirthday(Date custBirthday) {
		this.custBirthday = custBirthday;
	}

	/**
	 * 属性出险人性别的getter方法
	 */

	@Column(name = "CUSTOMERSEX")
	public String getCustomerSex() {
		return this.customerSex;
	}

	/**
	 * 属性出险人性别的setter方法
	 */
	public void setCustomerSex(String customerSex) {
		this.customerSex = customerSex;
	}

	/**
	 * 属性出险人年龄的getter方法
	 */

	@Column(name = "CUSTOMERAGE")
	public Double getCustomerAge() {
		return this.customerAge;
	}

	/**
	 * 属性出险人年龄的setter方法
	 */
	public void setCustomerAge(Double customerAge) {
		this.customerAge = customerAge;
	}

	/**
	 * 属性受益人证件类型的getter方法
	 */

	@Column(name = "IDTYPE")
	public String getIdType() {
		return this.idType;
	}

	/**
	 * 属性受益人证件类型的setter方法
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}

	/**
	 * 属性受益人证件号码的getter方法
	 */

	@Column(name = "IDNO")
	public String getIdNo() {
		return this.idNo;
	}

	/**
	 * 属性受益人证件号码的setter方法
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	/**
	 * 属性审核人的getter方法
	 */

	@Column(name = "HANDLER")
	public String getHandler() {
		return this.handler;
	}

	/**
	 * 属性审核人的setter方法
	 */
	public void setHandler(String handler) {
		this.handler = handler;
	}

	/**
	 * 属性审核日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "HANDLEDATE")
	public Date getHandleDate() {
		return this.handleDate;
	}

	/**
	 * 属性审核日期的setter方法
	 */
	public void setHandleDate(Date handleDate) {
		this.handleDate = handleDate;
	}

	/**
	 * 属性审核状态的getter方法
	 */

	@Column(name = "UWSTATE")
	public String getUwState() {
		return this.uwState;
	}

	/**
	 * 属性审核状态的setter方法
	 */
	public void setUwState(String uwState) {
		this.uwState = uwState;
	}

	/**
	 * 属性当前处理人的getter方法
	 */

	@Column(name = "DEALER")
	public String getDealer() {
		return this.dealer;
	}

	/**
	 * 属性当前处理人的setter方法
	 */
	public void setDealer(String dealer) {
		this.dealer = dealer;
	}

	/**
	 * 属性申诉标志的getter方法
	 */

	@Column(name = "APPEALFLAG")
	public String getAppealFlag() {
		return this.appealFlag;
	}

	/**
	 * 属性申诉标志的setter方法
	 */
	public void setAppealFlag(String appealFlag) {
		this.appealFlag = appealFlag;
	}

	/**
	 * 属性全部保单是否统一给付的getter方法
	 */

	@Column(name = "TOGETHERGET")
	public String getTogetherGet() {
		return this.togetherGet;
	}

	/**
	 * 属性全部保单是否统一给付的setter方法
	 */
	public void setTogetherGet(String togetherGet) {
		this.togetherGet = togetherGet;
	}

	/**
	 * 属性团体批处理标志的getter方法
	 */

	@Column(name = "GRPDEALFLAG")
	public String getGrpDealFlag() {
		return this.grpDealFlag;
	}

	/**
	 * 属性团体批处理标志的setter方法
	 */
	public void setGrpDealFlag(String grpDealFlag) {
		this.grpDealFlag = grpDealFlag;
	}

	/**
	 * 属性赔付金领取方式的getter方法
	 */

	@Column(name = "GETMODE")
	public String getGetMode() {
		return this.getMode;
	}

	/**
	 * 属性赔付金领取方式的setter方法
	 */
	public void setGetMode(String getMode) {
		this.getMode = getMode;
	}

	/**
	 * 属性赔付金领取间隔的getter方法
	 */

	@Column(name = "GETINTV")
	public BigDecimal getGetIntv() {
		return this.getIntv;
	}

	/**
	 * 属性赔付金领取间隔的setter方法
	 */
	public void setGetIntv(BigDecimal getIntv) {
		this.getIntv = getIntv;
	}

	/**
	 * 属性核算标记的getter方法
	 */

	@Column(name = "CALFLAG")
	public String getCalFlag() {
		return this.calFlag;
	}

	/**
	 * 属性核算标记的setter方法
	 */
	public void setCalFlag(String calFlag) {
		this.calFlag = calFlag;
	}

	/**
	 * 属性核赔标记的getter方法
	 */

	@Column(name = "UWFLAG")
	public String getUwFlag() {
		return this.uwFlag;
	}

	/**
	 * 属性核赔标记的setter方法
	 */
	public void setUwFlag(String uwFlag) {
		this.uwFlag = uwFlag;
	}

	/**
	 * 属性拒赔标记的getter方法
	 */

	@Column(name = "DECLINEFLAG")
	public String getDeclineFlag() {
		return this.declineFlag;
	}

	/**
	 * 属性拒赔标记的setter方法
	 */
	public void setDeclineFlag(String declineFlag) {
		this.declineFlag = declineFlag;
	}

	/**
	 * 属性结案标记的getter方法
	 */

	@Column(name = "ENDCASEFLAG")
	public String getEndCaseFlag() {
		return this.endCaseFlag;
	}

	/**
	 * 属性结案标记的setter方法
	 */
	public void setEndCaseFlag(String endCaseFlag) {
		this.endCaseFlag = endCaseFlag;
	}

	/**
	 * 属性结案日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "ENDCASEDATE")
	public Date getEndCaseDate() {
		return this.endCaseDate;
	}

	/**
	 * 属性结案日期的setter方法
	 */
	public void setEndCaseDate(Date endCaseDate) {
		this.endCaseDate = endCaseDate;
	}

	/**
	 * 属性管理机构的getter方法
	 */

	@Column(name = "MNGCOM")
	public String getMngCom() {
		return this.mngCom;
	}

	/**
	 * 属性管理机构的setter方法
	 */
	public void setMngCom(String mngCom) {
		this.mngCom = mngCom;
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
	 * 属性银行编码的getter方法
	 */

	@Column(name = "BANKCODE")
	public String getBankCode() {
		return this.bankCode;
	}

	/**
	 * 属性银行编码的setter方法
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
	 * 属性保险金领取方式的getter方法
	 */

	@Column(name = "CASEGETMODE")
	public String getCaseGetMode() {
		return this.caseGetMode;
	}

	/**
	 * 属性保险金领取方式的setter方法
	 */
	public void setCaseGetMode(String caseGetMode) {
		this.caseGetMode = caseGetMode;
	}

	/**
	 * 属性账户修改原因的getter方法
	 */

	@Column(name = "ACCMODIFYREASON")
	public String getAccModifyReason() {
		return this.accModifyReason;
	}

	/**
	 * 属性账户修改原因的setter方法
	 */
	public void setAccModifyReason(String accModifyReason) {
		this.accModifyReason = accModifyReason;
	}

	/**
	 * 属性报备产生日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "CASENODATE")
	public Date getCaseNoDate() {
		return this.caseNoDate;
	}

	/**
	 * 属性报备产生日期的setter方法
	 */
	public void setCaseNoDate(Date caseNoDate) {
		this.caseNoDate = caseNoDate;
	}

	/**
	 * 属性VIP标志的getter方法
	 */

	@Column(name = "VIPFLAG")
	public String getVipFlag() {
		return this.vipFlag;
	}

	/**
	 * 属性VIP标志的setter方法
	 */
	public void setVipFlag(String vipFlag) {
		this.vipFlag = vipFlag;
	}

	/**
	 * 属性出险细节的getter方法
	 */

	@Column(name = "ACCIDENTDETAIL")
	public String getAccidentDetail() {
		return this.accidentDetail;
	}

	/**
	 * 属性出险细节的setter方法
	 */
	public void setAccidentDetail(String accidentDetail) {
		this.accidentDetail = accidentDetail;
	}

	/**
	 * 属性治疗情况的getter方法
	 */

	@Column(name = "CUREDESC")
	public String getCureDesc() {
		return this.cureDesc;
	}

	/**
	 * 属性治疗情况的setter方法
	 */
	public void setCureDesc(String cureDesc) {
		this.cureDesc = cureDesc;
	}

	/**
	 * 属性单证检查结论的getter方法
	 */

	@Column(name = "AFFIXCONCLUSION")
	public String getAffixConclusion() {
		return this.affixConclusion;
	}

	/**
	 * 属性单证检查结论的setter方法
	 */
	public void setAffixConclusion(String affixConclusion) {
		this.affixConclusion = affixConclusion;
	}

	/**
	 * 属性单证不全原因的getter方法
	 */

	@Column(name = "AFFIXREASON")
	public String getAffixReason() {
		return this.affixReason;
	}

	/**
	 * 属性单证不全原因的setter方法
	 */
	public void setAffixReason(String affixReason) {
		this.affixReason = affixReason;
	}

	/**
	 * 属性账单录入标记的getter方法
	 */

	@Column(name = "FEEINPUTFLAG")
	public String getFeeInputFlag() {
		return this.feeInputFlag;
	}

	/**
	 * 属性账单录入标记的setter方法
	 */
	public void setFeeInputFlag(String feeInputFlag) {
		this.feeInputFlag = feeInputFlag;
	}

	/**
	 * 属性调查报告标志的getter方法
	 */

	@Column(name = "SURVEYFLAG")
	public String getSurveyFlag() {
		return this.surveyFlag;
	}

	/**
	 * 属性调查报告标志的setter方法
	 */
	public void setSurveyFlag(String surveyFlag) {
		this.surveyFlag = surveyFlag;
	}

	/**
	 * 属性发起呈报标志的getter方法
	 */

	@Column(name = "SUBMITFLAG")
	public String getSubmitFlag() {
		return this.submitFlag;
	}

	/**
	 * 属性发起呈报标志的setter方法
	 */
	public void setSubmitFlag(String submitFlag) {
		this.submitFlag = submitFlag;
	}

	/**
	 * 属性提起慰问标志的getter方法
	 */

	@Column(name = "CONDOLEFLAG")
	public String getCondoleFlag() {
		return this.condoleFlag;
	}

	/**
	 * 属性提起慰问标志的setter方法
	 */
	public void setCondoleFlag(String condoleFlag) {
		this.condoleFlag = condoleFlag;
	}

	/**
	 * 属性信息修改标志的getter方法
	 */

	@Column(name = "EDITFLAG")
	public String getEditFlag() {
		return this.editFlag;
	}

	/**
	 * 属性信息修改标志的setter方法
	 */
	public void setEditFlag(String editFlag) {
		this.editFlag = editFlag;
	}

	/**
	 * 属性二核标志的getter方法
	 */

	@Column(name = "SECONDUWFLAG")
	public String getSecondUWFlag() {
		return this.secondUWFlag;
	}

	/**
	 * 属性二核标志的setter方法
	 */
	public void setSecondUWFlag(String secondUWFlag) {
		this.secondUWFlag = secondUWFlag;
	}

	/**
	 * 属性事故发生日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "ACCDATE")
	public Date getAccDate() {
		return this.accDate;
	}

	/**
	 * 属性事故发生日期的setter方法
	 */
	public void setAccDate(Date accDate) {
		this.accDate = accDate;
	}

	/**
	 * 属性出险结果1的getter方法
	 */

	@Column(name = "ACCRESULT1")
	public String getAccResult1() {
		return this.accResult1;
	}

	/**
	 * 属性出险结果1的setter方法
	 */
	public void setAccResult1(String accResult1) {
		this.accResult1 = accResult1;
	}

	/**
	 * 属性出险结果2的getter方法
	 */

	@Column(name = "ACCRESULT2")
	public String getAccResult2() {
		return this.accResult2;
	}

	/**
	 * 属性出险结果2的setter方法
	 */
	public void setAccResult2(String accResult2) {
		this.accResult2 = accResult2;
	}

	/**
	 * 属性阳性标志的getter方法
	 */

	@Column(name = "MASCULINEFLAG")
	public String getMasculineFlag() {
		return this.masculineFlag;
	}

	/**
	 * 属性阳性标志的setter方法
	 */
	public void setMasculineFlag(String masculineFlag) {
		this.masculineFlag = masculineFlag;
	}

	/**
	 * 属性医院代码的getter方法
	 */

	@Column(name = "HOSPITALCODE")
	public String getHospitalCode() {
		return this.hospitalCode;
	}

	/**
	 * 属性医院代码的setter方法
	 */
	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	/**
	 * 属性医院名称的getter方法
	 */

	@Column(name = "HOSPITALNAME")
	public String getHospitalName() {
		return this.hospitalName;
	}

	/**
	 * 属性医院名称的setter方法
	 */
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
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
	 * 属性客户序号的getter方法
	 */

	@Column(name = "SEQNO")
	public BigDecimal getSeqNo() {
		return this.seqNo;
	}

	/**
	 * 属性客户序号的setter方法
	 */
	public void setSeqNo(BigDecimal seqNo) {
		this.seqNo = seqNo;
	}

	/**
	 * 属性出险人联系电话的getter方法
	 */

	@Column(name = "CONTACTNO")
	public String getContactNo() {
		return this.contactNo;
	}

	/**
	 * 属性出险人联系电话的setter方法
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	/**
	 * 属性住院科室的getter方法
	 */

	@Column(name = "SECTIONOFFICE")
	public String getSectionOffice() {
		return this.sectionOffice;
	}

	/**
	 * 属性住院科室的setter方法
	 */
	public void setSectionOffice(String sectionOffice) {
		this.sectionOffice = sectionOffice;
	}

	/**
	 * 属性承保机构的getter方法
	 */

	@Column(name = "ACCEPTMNGCOM")
	public String getAcceptMngCom() {
		return this.acceptMngCom;
	}

	/**
	 * 属性承保机构的setter方法
	 */
	public void setAcceptMngCom(String acceptMngCom) {
		this.acceptMngCom = acceptMngCom;
	}

}
