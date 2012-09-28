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
 * POJO类LCPol
 */
@Entity
@Table(name = "LCPOL")
public class LCPol implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性保单号码 */
	private String polNo;

	/** 属性集体合同号码 */
	private String grpContNo;

	/** 属性集体保单险种号码 */
	private String grpPolNo;

	/** 属性合同号码 */
	private String contNo;

	/** 属性投保单险种号码 */
	private String proposalNo;

	/** 属性印刷号码 */
	private String prtNo;

	/** 属性总单类型 */
	private String contType;

	/** 属性保单类型标记 */
	private String polTypeFlag;

	/** 属性主险保单号码 */
	private String mainPolNo;

	/** 属性主被保人保单号码 */
	private String masterPolNo;

	/** 属性险类编码 */
	private String kindCode;

	/** 属性险种编码 */
	private String riskCode;

	/** 属性险种版本 */
	private String riskVersion;

	/** 属性管理机构 */
	private String manageCom;

	/** 属性代理机构 */
	private String agentCom;

	/** 属性代理机构内部分类 */
	private String agentType;

	/** 属性代理人编码 */
	private String agentCode;

	/** 属性代理人组别 */
	private String agentGroup;

	/** 属性联合代理人代码 */
	private String agentCode1;

	/** 属性销售渠道 */
	private String saleChnl;

	/** 属性经办人 */
	private String handler;

	/** 属性被保人客户号码 */
	private String insuredNo;

	/** 属性被保人名称 */
	private String insuredName;

	/** 属性被保人性别 */
	private String insuredSex;

	/** 属性被保人出生日期 */
	private Date insuredBirthday;

	/** 属性被保人投保年龄 */
	private BigDecimal insuredAppAge;

	/** 属性被保人数目 */
	private BigDecimal insuredPeoples;

	/** 属性职业类别 */
	private String occupationType;

	/** 属性投保人客户号码 */
	private String appntNo;

	/** 属性投保人名称 */
	private String appntName;

	/** 属性保单生效日期 */
	private Date cvaliDate;

	/** 属性签单机构 */
	private String signCom;

	/** 属性签单日期 */
	private Date signDate;

	/** 属性签单时间 */
	private String signTime;

	/** 属性首期交费日期 */
	private Date firstPayDate;

	/** 属性终交日期 */
	private Date payEndDate;

	/** 属性交至日期 */
	private Date paytoDate;

	/** 属性起领日期 */
	private Date getStartDate;

	/** 属性保险责任终止日期 */
	private Date endDate;

	/** 属性意外责任终止日期 */
	private Date acciEndDate;

	/** 属性领取年龄年期标志 */
	private String getYearFlag;

	/** 属性领取年龄年期 */
	private BigDecimal getYear;

	/** 属性终交年龄年期标志 */
	private String payEndYearFlag;

	/** 属性终交年龄年期 */
	private BigDecimal payEndYear;

	/** 属性保险年龄年期标志 */
	private String insuYearFlag;

	/** 属性保险年龄年期 */
	private BigDecimal insuYear;

	/** 属性意外年龄年期标志 */
	private String acciYearFlag;

	/** 属性意外年龄年期 */
	private BigDecimal acciYear;

	/** 属性起领日期计算类型 */
	private String getStartType;

	/** 属性是否指定生效日期 */
	private String specifyValiDate;

	/** 属性交费方式 */
	private String payMode;

	/** 属性交费位置 */
	private String payLocation;

	/** 属性交费间隔 */
	private BigDecimal payIntv;

	/** 属性交费年期 */
	private BigDecimal payYears;

	/** 属性保险年期 */
	private BigDecimal years;

	/** 属性管理费比例 */
	private Double manageFeeRate;

	/** 属性浮动费率 */
	private BigDecimal floatRate;

	/** 属性保费算保额标志 */
	private String premToAmnt;

	/** 属性份数 */
	private BigDecimal mult;

	/** 属性标准保费 */
	private BigDecimal standPrem;

	/** 属性保费 */
	private BigDecimal prem;

	/** 属性累计保费 */
	private BigDecimal sumPrem;

	/** 属性保额 */
	private BigDecimal amnt;

	/** 属性风险保额 */
	private BigDecimal riskAmnt;

	/** 属性余额 */
	private BigDecimal leavingMoney;

	/** 属性批改次数 */
	private BigDecimal endorseTimes;

	/** 属性理赔次数 */
	private BigDecimal claimTimes;

	/** 属性生存领取次数 */
	private BigDecimal liveTimes;

	/** 属性续保次数 */
	private BigDecimal renewCount;

	/** 属性最后一次给付日期 */
	private Date lastGetDate;

	/** 属性最后一次借款日期 */
	private Date lastLoanDate;

	/** 属性最后一次催收日期 */
	private Date lastRegetDate;

	/** 属性最后一次保全日期 */
	private Date lastEdorDate;

	/** 属性最近复效日期 */
	private Date lastRevDate;

	/** 属性续保标志 */
	private BigDecimal rnewFlag;

	/** 属性停交标志 */
	private String stopFlag;

	/** 属性满期标志 */
	private String expiryFlag;

	/** 属性自动垫交标志 */
	private String autoPayFlag;

	/** 属性利差返还方式 */
	private String interestDifFlag;

	/** 属性减额交清标志 */
	private String subFlag;

	/** 属性受益人标记 */
	private String bnfFlag;

	/** 属性是否体检件标志 */
	private String healthCheckFlag;

	/** 属性告知标志 */
	private String impartFlag;

	/** 属性商业分保标记 */
	private String reinsureFlag;

	/** 属性代收标志 */
	private String agentPayFlag;

	/** 属性代付标志 */
	private String agentGetFlag;

	/** 属性生存金领取方式 */
	private String liveGetMode;

	/** 属性身故金领取方式 */
	private String deadGetMode;

	/** 属性红利金领取方式 */
	private String bonusGetMode;

	/** 属性红利金领取人 */
	private String bonusMan;

	/** 属性被保人、投保人死亡标志 */
	private String deadFlag;

	/** 属性是否吸烟标志 */
	private String smokeFlag;

	/** 属性备注 */
	private String remark;

	/** 属性复核状态 */
	private String approveFlag;

	/** 属性复核人编码 */
	private String approveCode;

	/** 属性复核日期 */
	private Date approveDate;

	/** 属性复核时间 */
	private String approveTime;

	/** 属性核保状态 */
	private String uwFlag;

	/** 属性最终核保人编码 */
	private String uwCode;

	/** 属性核保完成日期 */
	private Date uwDate;

	/** 属性核保完成时间 */
	private String uwTime;

	/** 属性投保单申请日期 */
	private Date polApplyDate;

	/** 属性投保单/保单标志 */
	private String appFlag;

	/** 属性其它保单状态 */
	private String polState;

	/** 属性备用属性字段1 */
	private String standbyFlag1;

	/** 属性备用属性字段2 */
	private String standbyFlag2;

	/** 属性备用属性字段3 */
	private String standbyFlag3;

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

	/** 属性等待期 */
	private BigDecimal waitPeriod;

	/** 属性领取形式 */
	private String getForm;

	/** 属性领取银行编码 */
	private String getBankCode;

	/** 属性领取银行账户 */
	private String getBankAccNo;

	/** 属性领取银行户名 */
	private String getAccName;

	/** 属性不丧失价值选择 */
	private String keepValueOpt;

	/** 属性缴费规则编码 */
	private String payRuleCode;

	/** 属性归属规则编码 */
	private String ascriptionRuleCode;

	/** 属性自动应用团体帐户标记 */
	private String autoPubAccFlag;

	/** 属性险种序号 */
	private String riskSelNo;

	/** 属性核保原因 */
	private String uwReason;

	/** 属性核保具体原因 */
	private String uwReasonContent;

	/** 属性投连账户生效日标志 */
	private String tlAccValidFlag;

	/**
	 * 类LCPol的默认构造方法
	 */
	public LCPol() {
	}

	/**
	 * 属性保单号码的getter方法
	 */
	@Id
	@Column(name = "POLNO")
	public String getPolNo() {
		return this.polNo;
	}

	/**
	 * 属性保单号码的setter方法
	 */
	public void setPolNo(String polNo) {
		this.polNo = polNo;
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
	 * 属性集体保单险种号码的getter方法
	 */

	@Column(name = "GRPPOLNO")
	public String getGrpPolNo() {
		return this.grpPolNo;
	}

	/**
	 * 属性集体保单险种号码的setter方法
	 */
	public void setGrpPolNo(String grpPolNo) {
		this.grpPolNo = grpPolNo;
	}

	/**
	 * 属性合同号码的getter方法
	 */

	@Column(name = "CONTNO")
	public String getContNo() {
		return this.contNo;
	}

	/**
	 * 属性合同号码的setter方法
	 */
	public void setContNo(String contNo) {
		this.contNo = contNo;
	}

	/**
	 * 属性投保单险种号码的getter方法
	 */

	@Column(name = "PROPOSALNO")
	public String getProposalNo() {
		return this.proposalNo;
	}

	/**
	 * 属性投保单险种号码的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
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
	 * 属性总单类型的getter方法
	 */

	@Column(name = "CONTTYPE")
	public String getContType() {
		return this.contType;
	}

	/**
	 * 属性总单类型的setter方法
	 */
	public void setContType(String contType) {
		this.contType = contType;
	}

	/**
	 * 属性保单类型标记的getter方法
	 */

	@Column(name = "POLTYPEFLAG")
	public String getPolTypeFlag() {
		return this.polTypeFlag;
	}

	/**
	 * 属性保单类型标记的setter方法
	 */
	public void setPolTypeFlag(String polTypeFlag) {
		this.polTypeFlag = polTypeFlag;
	}

	/**
	 * 属性主险保单号码的getter方法
	 */

	@Column(name = "MAINPOLNO")
	public String getMainPolNo() {
		return this.mainPolNo;
	}

	/**
	 * 属性主险保单号码的setter方法
	 */
	public void setMainPolNo(String mainPolNo) {
		this.mainPolNo = mainPolNo;
	}

	/**
	 * 属性主被保人保单号码的getter方法
	 */

	@Column(name = "MASTERPOLNO")
	public String getMasterPolNo() {
		return this.masterPolNo;
	}

	/**
	 * 属性主被保人保单号码的setter方法
	 */
	public void setMasterPolNo(String masterPolNo) {
		this.masterPolNo = masterPolNo;
	}

	/**
	 * 属性险类编码的getter方法
	 */

	@Column(name = "KINDCODE")
	public String getKindCode() {
		return this.kindCode;
	}

	/**
	 * 属性险类编码的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}

	/**
	 * 属性险种编码的getter方法
	 */

	@Column(name = "RISKCODE")
	public String getRiskCode() {
		return this.riskCode;
	}

	/**
	 * 属性险种编码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	/**
	 * 属性险种版本的getter方法
	 */

	@Column(name = "RISKVERSION")
	public String getRiskVersion() {
		return this.riskVersion;
	}

	/**
	 * 属性险种版本的setter方法
	 */
	public void setRiskVersion(String riskVersion) {
		this.riskVersion = riskVersion;
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
	 * 属性代理机构的getter方法
	 */

	@Column(name = "AGENTCOM")
	public String getAgentCom() {
		return this.agentCom;
	}

	/**
	 * 属性代理机构的setter方法
	 */
	public void setAgentCom(String agentCom) {
		this.agentCom = agentCom;
	}

	/**
	 * 属性代理机构内部分类的getter方法
	 */

	@Column(name = "AGENTTYPE")
	public String getAgentType() {
		return this.agentType;
	}

	/**
	 * 属性代理机构内部分类的setter方法
	 */
	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}

	/**
	 * 属性代理人编码的getter方法
	 */

	@Column(name = "AGENTCODE")
	public String getAgentCode() {
		return this.agentCode;
	}

	/**
	 * 属性代理人编码的setter方法
	 */
	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	/**
	 * 属性代理人组别的getter方法
	 */

	@Column(name = "AGENTGROUP")
	public String getAgentGroup() {
		return this.agentGroup;
	}

	/**
	 * 属性代理人组别的setter方法
	 */
	public void setAgentGroup(String agentGroup) {
		this.agentGroup = agentGroup;
	}

	/**
	 * 属性联合代理人代码的getter方法
	 */

	@Column(name = "AGENTCODE1")
	public String getAgentCode1() {
		return this.agentCode1;
	}

	/**
	 * 属性联合代理人代码的setter方法
	 */
	public void setAgentCode1(String agentCode1) {
		this.agentCode1 = agentCode1;
	}

	/**
	 * 属性销售渠道的getter方法
	 */

	@Column(name = "SALECHNL")
	public String getSaleChnl() {
		return this.saleChnl;
	}

	/**
	 * 属性销售渠道的setter方法
	 */
	public void setSaleChnl(String saleChnl) {
		this.saleChnl = saleChnl;
	}

	/**
	 * 属性经办人的getter方法
	 */

	@Column(name = "HANDLER")
	public String getHandler() {
		return this.handler;
	}

	/**
	 * 属性经办人的setter方法
	 */
	public void setHandler(String handler) {
		this.handler = handler;
	}

	/**
	 * 属性被保人客户号码的getter方法
	 */

	@Column(name = "INSUREDNO")
	public String getInsuredNo() {
		return this.insuredNo;
	}

	/**
	 * 属性被保人客户号码的setter方法
	 */
	public void setInsuredNo(String insuredNo) {
		this.insuredNo = insuredNo;
	}

	/**
	 * 属性被保人名称的getter方法
	 */

	@Column(name = "INSUREDNAME")
	public String getInsuredName() {
		return this.insuredName;
	}

	/**
	 * 属性被保人名称的setter方法
	 */
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	/**
	 * 属性被保人性别的getter方法
	 */

	@Column(name = "INSUREDSEX")
	public String getInsuredSex() {
		return this.insuredSex;
	}

	/**
	 * 属性被保人性别的setter方法
	 */
	public void setInsuredSex(String insuredSex) {
		this.insuredSex = insuredSex;
	}

	/**
	 * 属性被保人出生日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "INSUREDBIRTHDAY")
	public Date getInsuredBirthday() {
		return this.insuredBirthday;
	}

	/**
	 * 属性被保人出生日期的setter方法
	 */
	public void setInsuredBirthday(Date insuredBirthday) {
		this.insuredBirthday = insuredBirthday;
	}

	/**
	 * 属性被保人投保年龄的getter方法
	 */

	@Column(name = "INSUREDAPPAGE")
	public BigDecimal getInsuredAppAge() {
		return this.insuredAppAge;
	}

	/**
	 * 属性被保人投保年龄的setter方法
	 */
	public void setInsuredAppAge(BigDecimal insuredAppAge) {
		this.insuredAppAge = insuredAppAge;
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
	 * 属性投保人名称的getter方法
	 */

	@Column(name = "APPNTNAME")
	public String getAppntName() {
		return this.appntName;
	}

	/**
	 * 属性投保人名称的setter方法
	 */
	public void setAppntName(String appntName) {
		this.appntName = appntName;
	}

	/**
	 * 属性保单生效日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "CVALIDATE")
	public Date getCvaliDate() {
		return this.cvaliDate;
	}

	/**
	 * 属性保单生效日期的setter方法
	 */
	public void setCvaliDate(Date cvaliDate) {
		this.cvaliDate = cvaliDate;
	}

	/**
	 * 属性签单机构的getter方法
	 */

	@Column(name = "SIGNCOM")
	public String getSignCom() {
		return this.signCom;
	}

	/**
	 * 属性签单机构的setter方法
	 */
	public void setSignCom(String signCom) {
		this.signCom = signCom;
	}

	/**
	 * 属性签单日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "SIGNDATE")
	public Date getSignDate() {
		return this.signDate;
	}

	/**
	 * 属性签单日期的setter方法
	 */
	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	/**
	 * 属性签单时间的getter方法
	 */

	@Column(name = "SIGNTIME")
	public String getSignTime() {
		return this.signTime;
	}

	/**
	 * 属性签单时间的setter方法
	 */
	public void setSignTime(String signTime) {
		this.signTime = signTime;
	}

	/**
	 * 属性首期交费日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "FIRSTPAYDATE")
	public Date getFirstPayDate() {
		return this.firstPayDate;
	}

	/**
	 * 属性首期交费日期的setter方法
	 */
	public void setFirstPayDate(Date firstPayDate) {
		this.firstPayDate = firstPayDate;
	}

	/**
	 * 属性终交日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "PAYENDDATE")
	public Date getPayEndDate() {
		return this.payEndDate;
	}

	/**
	 * 属性终交日期的setter方法
	 */
	public void setPayEndDate(Date payEndDate) {
		this.payEndDate = payEndDate;
	}

	/**
	 * 属性交至日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "PAYTODATE")
	public Date getPaytoDate() {
		return this.paytoDate;
	}

	/**
	 * 属性交至日期的setter方法
	 */
	public void setPaytoDate(Date paytoDate) {
		this.paytoDate = paytoDate;
	}

	/**
	 * 属性起领日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "GETSTARTDATE")
	public Date getGetStartDate() {
		return this.getStartDate;
	}

	/**
	 * 属性起领日期的setter方法
	 */
	public void setGetStartDate(Date getStartDate) {
		this.getStartDate = getStartDate;
	}

	/**
	 * 属性保险责任终止日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "ENDDATE")
	public Date getEndDate() {
		return this.endDate;
	}

	/**
	 * 属性保险责任终止日期的setter方法
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * 属性意外责任终止日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "ACCIENDDATE")
	public Date getAcciEndDate() {
		return this.acciEndDate;
	}

	/**
	 * 属性意外责任终止日期的setter方法
	 */
	public void setAcciEndDate(Date acciEndDate) {
		this.acciEndDate = acciEndDate;
	}

	/**
	 * 属性领取年龄年期标志的getter方法
	 */

	@Column(name = "GETYEARFLAG")
	public String getGetYearFlag() {
		return this.getYearFlag;
	}

	/**
	 * 属性领取年龄年期标志的setter方法
	 */
	public void setGetYearFlag(String getYearFlag) {
		this.getYearFlag = getYearFlag;
	}

	/**
	 * 属性领取年龄年期的getter方法
	 */

	@Column(name = "GETYEAR")
	public BigDecimal getGetYear() {
		return this.getYear;
	}

	/**
	 * 属性领取年龄年期的setter方法
	 */
	public void setGetYear(BigDecimal getYear) {
		this.getYear = getYear;
	}

	/**
	 * 属性终交年龄年期标志的getter方法
	 */

	@Column(name = "PAYENDYEARFLAG")
	public String getPayEndYearFlag() {
		return this.payEndYearFlag;
	}

	/**
	 * 属性终交年龄年期标志的setter方法
	 */
	public void setPayEndYearFlag(String payEndYearFlag) {
		this.payEndYearFlag = payEndYearFlag;
	}

	/**
	 * 属性终交年龄年期的getter方法
	 */

	@Column(name = "PAYENDYEAR")
	public BigDecimal getPayEndYear() {
		return this.payEndYear;
	}

	/**
	 * 属性终交年龄年期的setter方法
	 */
	public void setPayEndYear(BigDecimal payEndYear) {
		this.payEndYear = payEndYear;
	}

	/**
	 * 属性保险年龄年期标志的getter方法
	 */

	@Column(name = "INSUYEARFLAG")
	public String getInsuYearFlag() {
		return this.insuYearFlag;
	}

	/**
	 * 属性保险年龄年期标志的setter方法
	 */
	public void setInsuYearFlag(String insuYearFlag) {
		this.insuYearFlag = insuYearFlag;
	}

	/**
	 * 属性保险年龄年期的getter方法
	 */

	@Column(name = "INSUYEAR")
	public BigDecimal getInsuYear() {
		return this.insuYear;
	}

	/**
	 * 属性保险年龄年期的setter方法
	 */
	public void setInsuYear(BigDecimal insuYear) {
		this.insuYear = insuYear;
	}

	/**
	 * 属性意外年龄年期标志的getter方法
	 */

	@Column(name = "ACCIYEARFLAG")
	public String getAcciYearFlag() {
		return this.acciYearFlag;
	}

	/**
	 * 属性意外年龄年期标志的setter方法
	 */
	public void setAcciYearFlag(String acciYearFlag) {
		this.acciYearFlag = acciYearFlag;
	}

	/**
	 * 属性意外年龄年期的getter方法
	 */

	@Column(name = "ACCIYEAR")
	public BigDecimal getAcciYear() {
		return this.acciYear;
	}

	/**
	 * 属性意外年龄年期的setter方法
	 */
	public void setAcciYear(BigDecimal acciYear) {
		this.acciYear = acciYear;
	}

	/**
	 * 属性起领日期计算类型的getter方法
	 */

	@Column(name = "GETSTARTTYPE")
	public String getGetStartType() {
		return this.getStartType;
	}

	/**
	 * 属性起领日期计算类型的setter方法
	 */
	public void setGetStartType(String getStartType) {
		this.getStartType = getStartType;
	}

	/**
	 * 属性是否指定生效日期的getter方法
	 */

	@Column(name = "SPECIFYVALIDATE")
	public String getSpecifyValiDate() {
		return this.specifyValiDate;
	}

	/**
	 * 属性是否指定生效日期的setter方法
	 */
	public void setSpecifyValiDate(String specifyValiDate) {
		this.specifyValiDate = specifyValiDate;
	}

	/**
	 * 属性交费方式的getter方法
	 */

	@Column(name = "PAYMODE")
	public String getPayMode() {
		return this.payMode;
	}

	/**
	 * 属性交费方式的setter方法
	 */
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	/**
	 * 属性交费位置的getter方法
	 */

	@Column(name = "PAYLOCATION")
	public String getPayLocation() {
		return this.payLocation;
	}

	/**
	 * 属性交费位置的setter方法
	 */
	public void setPayLocation(String payLocation) {
		this.payLocation = payLocation;
	}

	/**
	 * 属性交费间隔的getter方法
	 */

	@Column(name = "PAYINTV")
	public BigDecimal getPayIntv() {
		return this.payIntv;
	}

	/**
	 * 属性交费间隔的setter方法
	 */
	public void setPayIntv(BigDecimal payIntv) {
		this.payIntv = payIntv;
	}

	/**
	 * 属性交费年期的getter方法
	 */

	@Column(name = "PAYYEARS")
	public BigDecimal getPayYears() {
		return this.payYears;
	}

	/**
	 * 属性交费年期的setter方法
	 */
	public void setPayYears(BigDecimal payYears) {
		this.payYears = payYears;
	}

	/**
	 * 属性保险年期的getter方法
	 */

	@Column(name = "YEARS")
	public BigDecimal getYears() {
		return this.years;
	}

	/**
	 * 属性保险年期的setter方法
	 */
	public void setYears(BigDecimal years) {
		this.years = years;
	}

	/**
	 * 属性管理费比例的getter方法
	 */

	@Column(name = "MANAGEFEERATE")
	public Double getManageFeeRate() {
		return this.manageFeeRate;
	}

	/**
	 * 属性管理费比例的setter方法
	 */
	public void setManageFeeRate(Double manageFeeRate) {
		this.manageFeeRate = manageFeeRate;
	}

	/**
	 * 属性浮动费率的getter方法
	 */

	@Column(name = "FLOATRATE")
	public BigDecimal getFloatRate() {
		return this.floatRate;
	}

	/**
	 * 属性浮动费率的setter方法
	 */
	public void setFloatRate(BigDecimal floatRate) {
		this.floatRate = floatRate;
	}

	/**
	 * 属性保费算保额标志的getter方法
	 */

	@Column(name = "PREMTOAMNT")
	public String getPremToAmnt() {
		return this.premToAmnt;
	}

	/**
	 * 属性保费算保额标志的setter方法
	 */
	public void setPremToAmnt(String premToAmnt) {
		this.premToAmnt = premToAmnt;
	}

	/**
	 * 属性份数的getter方法
	 */

	@Column(name = "MULT")
	public BigDecimal getMult() {
		return this.mult;
	}

	/**
	 * 属性份数的setter方法
	 */
	public void setMult(BigDecimal mult) {
		this.mult = mult;
	}

	/**
	 * 属性标准保费的getter方法
	 */

	@Column(name = "STANDPREM")
	public BigDecimal getStandPrem() {
		return this.standPrem;
	}

	/**
	 * 属性标准保费的setter方法
	 */
	public void setStandPrem(BigDecimal standPrem) {
		this.standPrem = standPrem;
	}

	/**
	 * 属性保费的getter方法
	 */

	@Column(name = "PREM")
	public BigDecimal getPrem() {
		return this.prem;
	}

	/**
	 * 属性保费的setter方法
	 */
	public void setPrem(BigDecimal prem) {
		this.prem = prem;
	}

	/**
	 * 属性累计保费的getter方法
	 */

	@Column(name = "SUMPREM")
	public BigDecimal getSumPrem() {
		return this.sumPrem;
	}

	/**
	 * 属性累计保费的setter方法
	 */
	public void setSumPrem(BigDecimal sumPrem) {
		this.sumPrem = sumPrem;
	}

	/**
	 * 属性保额的getter方法
	 */

	@Column(name = "AMNT")
	public BigDecimal getAmnt() {
		return this.amnt;
	}

	/**
	 * 属性保额的setter方法
	 */
	public void setAmnt(BigDecimal amnt) {
		this.amnt = amnt;
	}

	/**
	 * 属性风险保额的getter方法
	 */

	@Column(name = "RISKAMNT")
	public BigDecimal getRiskAmnt() {
		return this.riskAmnt;
	}

	/**
	 * 属性风险保额的setter方法
	 */
	public void setRiskAmnt(BigDecimal riskAmnt) {
		this.riskAmnt = riskAmnt;
	}

	/**
	 * 属性余额的getter方法
	 */

	@Column(name = "LEAVINGMONEY")
	public BigDecimal getLeavingMoney() {
		return this.leavingMoney;
	}

	/**
	 * 属性余额的setter方法
	 */
	public void setLeavingMoney(BigDecimal leavingMoney) {
		this.leavingMoney = leavingMoney;
	}

	/**
	 * 属性批改次数的getter方法
	 */

	@Column(name = "ENDORSETIMES")
	public BigDecimal getEndorseTimes() {
		return this.endorseTimes;
	}

	/**
	 * 属性批改次数的setter方法
	 */
	public void setEndorseTimes(BigDecimal endorseTimes) {
		this.endorseTimes = endorseTimes;
	}

	/**
	 * 属性理赔次数的getter方法
	 */

	@Column(name = "CLAIMTIMES")
	public BigDecimal getClaimTimes() {
		return this.claimTimes;
	}

	/**
	 * 属性理赔次数的setter方法
	 */
	public void setClaimTimes(BigDecimal claimTimes) {
		this.claimTimes = claimTimes;
	}

	/**
	 * 属性生存领取次数的getter方法
	 */

	@Column(name = "LIVETIMES")
	public BigDecimal getLiveTimes() {
		return this.liveTimes;
	}

	/**
	 * 属性生存领取次数的setter方法
	 */
	public void setLiveTimes(BigDecimal liveTimes) {
		this.liveTimes = liveTimes;
	}

	/**
	 * 属性续保次数的getter方法
	 */

	@Column(name = "RENEWCOUNT")
	public BigDecimal getRenewCount() {
		return this.renewCount;
	}

	/**
	 * 属性续保次数的setter方法
	 */
	public void setRenewCount(BigDecimal renewCount) {
		this.renewCount = renewCount;
	}

	/**
	 * 属性最后一次给付日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "LASTGETDATE")
	public Date getLastGetDate() {
		return this.lastGetDate;
	}

	/**
	 * 属性最后一次给付日期的setter方法
	 */
	public void setLastGetDate(Date lastGetDate) {
		this.lastGetDate = lastGetDate;
	}

	/**
	 * 属性最后一次借款日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "LASTLOANDATE")
	public Date getLastLoanDate() {
		return this.lastLoanDate;
	}

	/**
	 * 属性最后一次借款日期的setter方法
	 */
	public void setLastLoanDate(Date lastLoanDate) {
		this.lastLoanDate = lastLoanDate;
	}

	/**
	 * 属性最后一次催收日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "LASTREGETDATE")
	public Date getLastRegetDate() {
		return this.lastRegetDate;
	}

	/**
	 * 属性最后一次催收日期的setter方法
	 */
	public void setLastRegetDate(Date lastRegetDate) {
		this.lastRegetDate = lastRegetDate;
	}

	/**
	 * 属性最后一次保全日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "LASTEDORDATE")
	public Date getLastEdorDate() {
		return this.lastEdorDate;
	}

	/**
	 * 属性最后一次保全日期的setter方法
	 */
	public void setLastEdorDate(Date lastEdorDate) {
		this.lastEdorDate = lastEdorDate;
	}

	/**
	 * 属性最近复效日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "LASTREVDATE")
	public Date getLastRevDate() {
		return this.lastRevDate;
	}

	/**
	 * 属性最近复效日期的setter方法
	 */
	public void setLastRevDate(Date lastRevDate) {
		this.lastRevDate = lastRevDate;
	}

	/**
	 * 属性续保标志的getter方法
	 */

	@Column(name = "RNEWFLAG")
	public BigDecimal getRnewFlag() {
		return this.rnewFlag;
	}

	/**
	 * 属性续保标志的setter方法
	 */
	public void setRnewFlag(BigDecimal rnewFlag) {
		this.rnewFlag = rnewFlag;
	}

	/**
	 * 属性停交标志的getter方法
	 */

	@Column(name = "STOPFLAG")
	public String getStopFlag() {
		return this.stopFlag;
	}

	/**
	 * 属性停交标志的setter方法
	 */
	public void setStopFlag(String stopFlag) {
		this.stopFlag = stopFlag;
	}

	/**
	 * 属性满期标志的getter方法
	 */

	@Column(name = "EXPIRYFLAG")
	public String getExpiryFlag() {
		return this.expiryFlag;
	}

	/**
	 * 属性满期标志的setter方法
	 */
	public void setExpiryFlag(String expiryFlag) {
		this.expiryFlag = expiryFlag;
	}

	/**
	 * 属性自动垫交标志的getter方法
	 */

	@Column(name = "AUTOPAYFLAG")
	public String getAutoPayFlag() {
		return this.autoPayFlag;
	}

	/**
	 * 属性自动垫交标志的setter方法
	 */
	public void setAutoPayFlag(String autoPayFlag) {
		this.autoPayFlag = autoPayFlag;
	}

	/**
	 * 属性利差返还方式的getter方法
	 */

	@Column(name = "INTERESTDIFFLAG")
	public String getInterestDifFlag() {
		return this.interestDifFlag;
	}

	/**
	 * 属性利差返还方式的setter方法
	 */
	public void setInterestDifFlag(String interestDifFlag) {
		this.interestDifFlag = interestDifFlag;
	}

	/**
	 * 属性减额交清标志的getter方法
	 */

	@Column(name = "SUBFLAG")
	public String getSubFlag() {
		return this.subFlag;
	}

	/**
	 * 属性减额交清标志的setter方法
	 */
	public void setSubFlag(String subFlag) {
		this.subFlag = subFlag;
	}

	/**
	 * 属性受益人标记的getter方法
	 */

	@Column(name = "BNFFLAG")
	public String getBnfFlag() {
		return this.bnfFlag;
	}

	/**
	 * 属性受益人标记的setter方法
	 */
	public void setBnfFlag(String bnfFlag) {
		this.bnfFlag = bnfFlag;
	}

	/**
	 * 属性是否体检件标志的getter方法
	 */

	@Column(name = "HEALTHCHECKFLAG")
	public String getHealthCheckFlag() {
		return this.healthCheckFlag;
	}

	/**
	 * 属性是否体检件标志的setter方法
	 */
	public void setHealthCheckFlag(String healthCheckFlag) {
		this.healthCheckFlag = healthCheckFlag;
	}

	/**
	 * 属性告知标志的getter方法
	 */

	@Column(name = "IMPARTFLAG")
	public String getImpartFlag() {
		return this.impartFlag;
	}

	/**
	 * 属性告知标志的setter方法
	 */
	public void setImpartFlag(String impartFlag) {
		this.impartFlag = impartFlag;
	}

	/**
	 * 属性商业分保标记的getter方法
	 */

	@Column(name = "REINSUREFLAG")
	public String getReinsureFlag() {
		return this.reinsureFlag;
	}

	/**
	 * 属性商业分保标记的setter方法
	 */
	public void setReinsureFlag(String reinsureFlag) {
		this.reinsureFlag = reinsureFlag;
	}

	/**
	 * 属性代收标志的getter方法
	 */

	@Column(name = "AGENTPAYFLAG")
	public String getAgentPayFlag() {
		return this.agentPayFlag;
	}

	/**
	 * 属性代收标志的setter方法
	 */
	public void setAgentPayFlag(String agentPayFlag) {
		this.agentPayFlag = agentPayFlag;
	}

	/**
	 * 属性代付标志的getter方法
	 */

	@Column(name = "AGENTGETFLAG")
	public String getAgentGetFlag() {
		return this.agentGetFlag;
	}

	/**
	 * 属性代付标志的setter方法
	 */
	public void setAgentGetFlag(String agentGetFlag) {
		this.agentGetFlag = agentGetFlag;
	}

	/**
	 * 属性生存金领取方式的getter方法
	 */

	@Column(name = "LIVEGETMODE")
	public String getLiveGetMode() {
		return this.liveGetMode;
	}

	/**
	 * 属性生存金领取方式的setter方法
	 */
	public void setLiveGetMode(String liveGetMode) {
		this.liveGetMode = liveGetMode;
	}

	/**
	 * 属性身故金领取方式的getter方法
	 */

	@Column(name = "DEADGETMODE")
	public String getDeadGetMode() {
		return this.deadGetMode;
	}

	/**
	 * 属性身故金领取方式的setter方法
	 */
	public void setDeadGetMode(String deadGetMode) {
		this.deadGetMode = deadGetMode;
	}

	/**
	 * 属性红利金领取方式的getter方法
	 */

	@Column(name = "BONUSGETMODE")
	public String getBonusGetMode() {
		return this.bonusGetMode;
	}

	/**
	 * 属性红利金领取方式的setter方法
	 */
	public void setBonusGetMode(String bonusGetMode) {
		this.bonusGetMode = bonusGetMode;
	}

	/**
	 * 属性红利金领取人的getter方法
	 */

	@Column(name = "BONUSMAN")
	public String getBonusMan() {
		return this.bonusMan;
	}

	/**
	 * 属性红利金领取人的setter方法
	 */
	public void setBonusMan(String bonusMan) {
		this.bonusMan = bonusMan;
	}

	/**
	 * 属性被保人、投保人死亡标志的getter方法
	 */

	@Column(name = "DEADFLAG")
	public String getDeadFlag() {
		return this.deadFlag;
	}

	/**
	 * 属性被保人、投保人死亡标志的setter方法
	 */
	public void setDeadFlag(String deadFlag) {
		this.deadFlag = deadFlag;
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
	 * 属性复核状态的getter方法
	 */

	@Column(name = "APPROVEFLAG")
	public String getApproveFlag() {
		return this.approveFlag;
	}

	/**
	 * 属性复核状态的setter方法
	 */
	public void setApproveFlag(String approveFlag) {
		this.approveFlag = approveFlag;
	}

	/**
	 * 属性复核人编码的getter方法
	 */

	@Column(name = "APPROVECODE")
	public String getApproveCode() {
		return this.approveCode;
	}

	/**
	 * 属性复核人编码的setter方法
	 */
	public void setApproveCode(String approveCode) {
		this.approveCode = approveCode;
	}

	/**
	 * 属性复核日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "APPROVEDATE")
	public Date getApproveDate() {
		return this.approveDate;
	}

	/**
	 * 属性复核日期的setter方法
	 */
	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}

	/**
	 * 属性复核时间的getter方法
	 */

	@Column(name = "APPROVETIME")
	public String getApproveTime() {
		return this.approveTime;
	}

	/**
	 * 属性复核时间的setter方法
	 */
	public void setApproveTime(String approveTime) {
		this.approveTime = approveTime;
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
	 * 属性投保单申请日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "POLAPPLYDATE")
	public Date getPolApplyDate() {
		return this.polApplyDate;
	}

	/**
	 * 属性投保单申请日期的setter方法
	 */
	public void setPolApplyDate(Date polApplyDate) {
		this.polApplyDate = polApplyDate;
	}

	/**
	 * 属性投保单/保单标志的getter方法
	 */

	@Column(name = "APPFLAG")
	public String getAppFlag() {
		return this.appFlag;
	}

	/**
	 * 属性投保单/保单标志的setter方法
	 */
	public void setAppFlag(String appFlag) {
		this.appFlag = appFlag;
	}

	/**
	 * 属性其它保单状态的getter方法
	 */

	@Column(name = "POLSTATE")
	public String getPolState() {
		return this.polState;
	}

	/**
	 * 属性其它保单状态的setter方法
	 */
	public void setPolState(String polState) {
		this.polState = polState;
	}

	/**
	 * 属性备用属性字段1的getter方法
	 */

	@Column(name = "STANDBYFLAG1")
	public String getStandbyFlag1() {
		return this.standbyFlag1;
	}

	/**
	 * 属性备用属性字段1的setter方法
	 */
	public void setStandbyFlag1(String standbyFlag1) {
		this.standbyFlag1 = standbyFlag1;
	}

	/**
	 * 属性备用属性字段2的getter方法
	 */

	@Column(name = "STANDBYFLAG2")
	public String getStandbyFlag2() {
		return this.standbyFlag2;
	}

	/**
	 * 属性备用属性字段2的setter方法
	 */
	public void setStandbyFlag2(String standbyFlag2) {
		this.standbyFlag2 = standbyFlag2;
	}

	/**
	 * 属性备用属性字段3的getter方法
	 */

	@Column(name = "STANDBYFLAG3")
	public String getStandbyFlag3() {
		return this.standbyFlag3;
	}

	/**
	 * 属性备用属性字段3的setter方法
	 */
	public void setStandbyFlag3(String standbyFlag3) {
		this.standbyFlag3 = standbyFlag3;
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
	 * 属性等待期的getter方法
	 */

	@Column(name = "WAITPERIOD")
	public BigDecimal getWaitPeriod() {
		return this.waitPeriod;
	}

	/**
	 * 属性等待期的setter方法
	 */
	public void setWaitPeriod(BigDecimal waitPeriod) {
		this.waitPeriod = waitPeriod;
	}

	/**
	 * 属性领取形式的getter方法
	 */

	@Column(name = "GETFORM")
	public String getGetForm() {
		return this.getForm;
	}

	/**
	 * 属性领取形式的setter方法
	 */
	public void setGetForm(String getForm) {
		this.getForm = getForm;
	}

	/**
	 * 属性领取银行编码的getter方法
	 */

	@Column(name = "GETBANKCODE")
	public String getGetBankCode() {
		return this.getBankCode;
	}

	/**
	 * 属性领取银行编码的setter方法
	 */
	public void setGetBankCode(String getBankCode) {
		this.getBankCode = getBankCode;
	}

	/**
	 * 属性领取银行账户的getter方法
	 */

	@Column(name = "GETBANKACCNO")
	public String getGetBankAccNo() {
		return this.getBankAccNo;
	}

	/**
	 * 属性领取银行账户的setter方法
	 */
	public void setGetBankAccNo(String getBankAccNo) {
		this.getBankAccNo = getBankAccNo;
	}

	/**
	 * 属性领取银行户名的getter方法
	 */

	@Column(name = "GETACCNAME")
	public String getGetAccName() {
		return this.getAccName;
	}

	/**
	 * 属性领取银行户名的setter方法
	 */
	public void setGetAccName(String getAccName) {
		this.getAccName = getAccName;
	}

	/**
	 * 属性不丧失价值选择的getter方法
	 */

	@Column(name = "KEEPVALUEOPT")
	public String getKeepValueOpt() {
		return this.keepValueOpt;
	}

	/**
	 * 属性不丧失价值选择的setter方法
	 */
	public void setKeepValueOpt(String keepValueOpt) {
		this.keepValueOpt = keepValueOpt;
	}

	/**
	 * 属性缴费规则编码的getter方法
	 */

	@Column(name = "PAYRULECODE")
	public String getPayRuleCode() {
		return this.payRuleCode;
	}

	/**
	 * 属性缴费规则编码的setter方法
	 */
	public void setPayRuleCode(String payRuleCode) {
		this.payRuleCode = payRuleCode;
	}

	/**
	 * 属性归属规则编码的getter方法
	 */

	@Column(name = "ASCRIPTIONRULECODE")
	public String getAscriptionRuleCode() {
		return this.ascriptionRuleCode;
	}

	/**
	 * 属性归属规则编码的setter方法
	 */
	public void setAscriptionRuleCode(String ascriptionRuleCode) {
		this.ascriptionRuleCode = ascriptionRuleCode;
	}

	/**
	 * 属性自动应用团体帐户标记的getter方法
	 */

	@Column(name = "AUTOPUBACCFLAG")
	public String getAutoPubAccFlag() {
		return this.autoPubAccFlag;
	}

	/**
	 * 属性自动应用团体帐户标记的setter方法
	 */
	public void setAutoPubAccFlag(String autoPubAccFlag) {
		this.autoPubAccFlag = autoPubAccFlag;
	}

	/**
	 * 属性险种序号的getter方法
	 */

	@Column(name = "RISKSELNO")
	public String getRiskSelNo() {
		return this.riskSelNo;
	}

	/**
	 * 属性险种序号的setter方法
	 */
	public void setRiskSelNo(String riskSelNo) {
		this.riskSelNo = riskSelNo;
	}

	/**
	 * 属性核保原因的getter方法
	 */

	@Column(name = "UWREASON")
	public String getUwReason() {
		return this.uwReason;
	}

	/**
	 * 属性核保原因的setter方法
	 */
	public void setUwReason(String uwReason) {
		this.uwReason = uwReason;
	}

	/**
	 * 属性核保具体原因的getter方法
	 */

	@Column(name = "UWREASONCONTENT")
	public String getUwReasonContent() {
		return this.uwReasonContent;
	}

	/**
	 * 属性核保具体原因的setter方法
	 */
	public void setUwReasonContent(String uwReasonContent) {
		this.uwReasonContent = uwReasonContent;
	}

	/**
	 * 属性投连账户生效日标志的getter方法
	 */

	@Column(name = "TLACCVALIDFLAG")
	public String getTlAccValidFlag() {
		return this.tlAccValidFlag;
	}

	/**
	 * 属性投连账户生效日标志的setter方法
	 */
	public void setTlAccValidFlag(String tlAccValidFlag) {
		this.tlAccValidFlag = tlAccValidFlag;
	}

}
