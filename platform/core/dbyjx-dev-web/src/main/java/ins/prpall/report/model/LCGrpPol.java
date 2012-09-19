package ins.prpall.report.model;
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
 * POJO类LCGrpPol
 */
@Entity
@Table(name = "LCGRPPOL")
public class LCGrpPol implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性集体保单险种号码 */
	private String grpPolNo;

	/** 属性集体合同号码 */
	private String grpContNo;

	/** 属性集体投保单险种号码 */
	private String grpProposalNo;

	/** 属性印刷号码 */
	private String prtNo;

	/** 属性险类编码 */
	private String kindCode;

	/** 属性险种编码 */
	private String riskCode;

	/** 属性险种版本 */
	private String riskVersion;

	/** 属性销售渠道 */
	private String saleChnl;

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

	/** 属性客户号码 */
	private String customerNo;

	/** 属性客户地址号码 */
	private String addressNo;

	/** 属性单位名称 */
	private String grpName;

	/** 属性首期交费日期 */
	private Date firstPayDate;

	/** 属性终交日期 */
	private Date payEndDate;

	/** 属性交至日期 */
	private Date paytoDate;

	/** 属性最后一次催收日期 */
	private Date regetDate;

	/** 属性最后一次保全日期 */
	private Date lastEdorDate;

	/** 属性社保标记 */
	private String ssFlag;

	/** 属性封顶线 */
	private BigDecimal peakLine;

	/** 属性起付限 */
	private BigDecimal getLimit;

	/** 属性赔付比例 */
	private BigDecimal getRate;

	/** 属性分红比率 */
	private BigDecimal bonusRate;

	/** 属性医疗费用限额 */
	private BigDecimal maxMedFee;

	/** 属性溢交处理方式 */
	private String outPayFlag;

	/** 属性雇员自付比例 */
	private BigDecimal employeeRate;

	/** 属性家属自付比例 */
	private BigDecimal familyRate;

	/** 属性团体特殊业务标志 */
	private String specFlag;

	/** 属性预计人数 */
	private BigDecimal expPeoples;

	/** 属性预计保费 */
	private BigDecimal expPremium;

	/** 属性预计保额 */
	private BigDecimal expAmnt;

	/** 属性交费方式 */
	private String payMode;

	/** 属性管理费比例 */
	private Double manageFeeRate;

	/** 属性交费间隔 */
	private BigDecimal payIntv;

	/** 属性保单生效日期 */
	private Date cvaliDate;

	/** 属性PeopleS2 */
	private BigDecimal peopleS2;

	/** 属性份数 */
	private BigDecimal mult;

	/** 属性保费 */
	private BigDecimal prem;

	/** 属性保额 */
	private BigDecimal amnt;

	/** 属性累计保费 */
	private BigDecimal sumPrem;

	/** 属性总累计交费 */
	private BigDecimal sumPay;

	/** 属性余额 */
	private BigDecimal dif;

	/** 属性状态 */
	private String state;

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

	/** 属性核保人 */
	private String uwOperator;

	/** 属性核保完成日期 */
	private Date uwDate;

	/** 属性核保完成时间 */
	private String uwTime;

	/** 属性投保单/保单标志 */
	private String appFlag;

	/** 属性备注 */
	private String remark;

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

	/** 属性在职投保人数 */
	private BigDecimal onWorkPeoples;

	/** 属性退休投保人数 */
	private BigDecimal offWorkPeoples;

	/** 属性其它投保人数 */
	private BigDecimal otherPeoples;

	/** 属性连带投保人数 */
	private BigDecimal relaPeoples;

	/** 属性连带配偶投保人数 */
	private BigDecimal relaMatePeoples;

	/** 属性连带子女投保人数 */
	private BigDecimal relaYoungPeoples;

	/** 属性连带其它投保人数 */
	private BigDecimal relaOtherPeoples;

	/** 属性等待期 */
	private BigDecimal waitPeriod;

	/** 属性BonusFlag */
	private String bonusFlag;

	/** 属性主险险种编码 */
	private String mainRiskCode;

	/** 属性预计加费金额 */
	private BigDecimal expAddFee;

	/**
	 * 类LCGrpPol的默认构造方法
	 */
	public LCGrpPol() {
	}

	/**
	 * 属性集体保单险种号码的getter方法
	 */
	@Id
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
	 * 属性集体投保单险种号码的getter方法
	 */

	@Column(name = "GRPPROPOSALNO")
	public String getGrpProposalNo() {
		return this.grpProposalNo;
	}

	/**
	 * 属性集体投保单险种号码的setter方法
	 */
	public void setGrpProposalNo(String grpProposalNo) {
		this.grpProposalNo = grpProposalNo;
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
	 * 属性最后一次催收日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "REGETDATE")
	public Date getRegetDate() {
		return this.regetDate;
	}

	/**
	 * 属性最后一次催收日期的setter方法
	 */
	public void setRegetDate(Date regetDate) {
		this.regetDate = regetDate;
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
	 * 属性社保标记的getter方法
	 */

	@Column(name = "SSFLAG")
	public String getSsFlag() {
		return this.ssFlag;
	}

	/**
	 * 属性社保标记的setter方法
	 */
	public void setSsFlag(String ssFlag) {
		this.ssFlag = ssFlag;
	}

	/**
	 * 属性封顶线的getter方法
	 */

	@Column(name = "PEAKLINE")
	public BigDecimal getPeakLine() {
		return this.peakLine;
	}

	/**
	 * 属性封顶线的setter方法
	 */
	public void setPeakLine(BigDecimal peakLine) {
		this.peakLine = peakLine;
	}

	/**
	 * 属性起付限的getter方法
	 */

	@Column(name = "GETLIMIT")
	public BigDecimal getGetLimit() {
		return this.getLimit;
	}

	/**
	 * 属性起付限的setter方法
	 */
	public void setGetLimit(BigDecimal getLimit) {
		this.getLimit = getLimit;
	}

	/**
	 * 属性赔付比例的getter方法
	 */

	@Column(name = "GETRATE")
	public BigDecimal getGetRate() {
		return this.getRate;
	}

	/**
	 * 属性赔付比例的setter方法
	 */
	public void setGetRate(BigDecimal getRate) {
		this.getRate = getRate;
	}

	/**
	 * 属性分红比率的getter方法
	 */

	@Column(name = "BONUSRATE")
	public BigDecimal getBonusRate() {
		return this.bonusRate;
	}

	/**
	 * 属性分红比率的setter方法
	 */
	public void setBonusRate(BigDecimal bonusRate) {
		this.bonusRate = bonusRate;
	}

	/**
	 * 属性医疗费用限额的getter方法
	 */

	@Column(name = "MAXMEDFEE")
	public BigDecimal getMaxMedFee() {
		return this.maxMedFee;
	}

	/**
	 * 属性医疗费用限额的setter方法
	 */
	public void setMaxMedFee(BigDecimal maxMedFee) {
		this.maxMedFee = maxMedFee;
	}

	/**
	 * 属性溢交处理方式的getter方法
	 */

	@Column(name = "OUTPAYFLAG")
	public String getOutPayFlag() {
		return this.outPayFlag;
	}

	/**
	 * 属性溢交处理方式的setter方法
	 */
	public void setOutPayFlag(String outPayFlag) {
		this.outPayFlag = outPayFlag;
	}

	/**
	 * 属性雇员自付比例的getter方法
	 */

	@Column(name = "EMPLOYEERATE")
	public BigDecimal getEmployeeRate() {
		return this.employeeRate;
	}

	/**
	 * 属性雇员自付比例的setter方法
	 */
	public void setEmployeeRate(BigDecimal employeeRate) {
		this.employeeRate = employeeRate;
	}

	/**
	 * 属性家属自付比例的getter方法
	 */

	@Column(name = "FAMILYRATE")
	public BigDecimal getFamilyRate() {
		return this.familyRate;
	}

	/**
	 * 属性家属自付比例的setter方法
	 */
	public void setFamilyRate(BigDecimal familyRate) {
		this.familyRate = familyRate;
	}

	/**
	 * 属性团体特殊业务标志的getter方法
	 */

	@Column(name = "SPECFLAG")
	public String getSpecFlag() {
		return this.specFlag;
	}

	/**
	 * 属性团体特殊业务标志的setter方法
	 */
	public void setSpecFlag(String specFlag) {
		this.specFlag = specFlag;
	}

	/**
	 * 属性预计人数的getter方法
	 */

	@Column(name = "EXPPEOPLES")
	public BigDecimal getExpPeoples() {
		return this.expPeoples;
	}

	/**
	 * 属性预计人数的setter方法
	 */
	public void setExpPeoples(BigDecimal expPeoples) {
		this.expPeoples = expPeoples;
	}

	/**
	 * 属性预计保费的getter方法
	 */

	@Column(name = "EXPPREMIUM")
	public BigDecimal getExpPremium() {
		return this.expPremium;
	}

	/**
	 * 属性预计保费的setter方法
	 */
	public void setExpPremium(BigDecimal expPremium) {
		this.expPremium = expPremium;
	}

	/**
	 * 属性预计保额的getter方法
	 */

	@Column(name = "EXPAMNT")
	public BigDecimal getExpAmnt() {
		return this.expAmnt;
	}

	/**
	 * 属性预计保额的setter方法
	 */
	public void setExpAmnt(BigDecimal expAmnt) {
		this.expAmnt = expAmnt;
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
	 * 属性PeopleS2的getter方法
	 */

	@Column(name = "PEOPLES2")
	public BigDecimal getPeopleS2() {
		return this.peopleS2;
	}

	/**
	 * 属性PeopleS2的setter方法
	 */
	public void setPeopleS2(BigDecimal peopleS2) {
		this.peopleS2 = peopleS2;
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
	 * 属性总累计交费的getter方法
	 */

	@Column(name = "SUMPAY")
	public BigDecimal getSumPay() {
		return this.sumPay;
	}

	/**
	 * 属性总累计交费的setter方法
	 */
	public void setSumPay(BigDecimal sumPay) {
		this.sumPay = sumPay;
	}

	/**
	 * 属性余额的getter方法
	 */

	@Column(name = "DIF")
	public BigDecimal getDif() {
		return this.dif;
	}

	/**
	 * 属性余额的setter方法
	 */
	public void setDif(BigDecimal dif) {
		this.dif = dif;
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
	 * 属性核保人的getter方法
	 */

	@Column(name = "UWOPERATOR")
	public String getUwOperator() {
		return this.uwOperator;
	}

	/**
	 * 属性核保人的setter方法
	 */
	public void setUwOperator(String uwOperator) {
		this.uwOperator = uwOperator;
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
	 * 属性在职投保人数的getter方法
	 */

	@Column(name = "ONWORKPEOPLES")
	public BigDecimal getOnWorkPeoples() {
		return this.onWorkPeoples;
	}

	/**
	 * 属性在职投保人数的setter方法
	 */
	public void setOnWorkPeoples(BigDecimal onWorkPeoples) {
		this.onWorkPeoples = onWorkPeoples;
	}

	/**
	 * 属性退休投保人数的getter方法
	 */

	@Column(name = "OFFWORKPEOPLES")
	public BigDecimal getOffWorkPeoples() {
		return this.offWorkPeoples;
	}

	/**
	 * 属性退休投保人数的setter方法
	 */
	public void setOffWorkPeoples(BigDecimal offWorkPeoples) {
		this.offWorkPeoples = offWorkPeoples;
	}

	/**
	 * 属性其它投保人数的getter方法
	 */

	@Column(name = "OTHERPEOPLES")
	public BigDecimal getOtherPeoples() {
		return this.otherPeoples;
	}

	/**
	 * 属性其它投保人数的setter方法
	 */
	public void setOtherPeoples(BigDecimal otherPeoples) {
		this.otherPeoples = otherPeoples;
	}

	/**
	 * 属性连带投保人数的getter方法
	 */

	@Column(name = "RELAPEOPLES")
	public BigDecimal getRelaPeoples() {
		return this.relaPeoples;
	}

	/**
	 * 属性连带投保人数的setter方法
	 */
	public void setRelaPeoples(BigDecimal relaPeoples) {
		this.relaPeoples = relaPeoples;
	}

	/**
	 * 属性连带配偶投保人数的getter方法
	 */

	@Column(name = "RELAMATEPEOPLES")
	public BigDecimal getRelaMatePeoples() {
		return this.relaMatePeoples;
	}

	/**
	 * 属性连带配偶投保人数的setter方法
	 */
	public void setRelaMatePeoples(BigDecimal relaMatePeoples) {
		this.relaMatePeoples = relaMatePeoples;
	}

	/**
	 * 属性连带子女投保人数的getter方法
	 */

	@Column(name = "RELAYOUNGPEOPLES")
	public BigDecimal getRelaYoungPeoples() {
		return this.relaYoungPeoples;
	}

	/**
	 * 属性连带子女投保人数的setter方法
	 */
	public void setRelaYoungPeoples(BigDecimal relaYoungPeoples) {
		this.relaYoungPeoples = relaYoungPeoples;
	}

	/**
	 * 属性连带其它投保人数的getter方法
	 */

	@Column(name = "RELAOTHERPEOPLES")
	public BigDecimal getRelaOtherPeoples() {
		return this.relaOtherPeoples;
	}

	/**
	 * 属性连带其它投保人数的setter方法
	 */
	public void setRelaOtherPeoples(BigDecimal relaOtherPeoples) {
		this.relaOtherPeoples = relaOtherPeoples;
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
	 * 属性BonusFlag的getter方法
	 */

	@Column(name = "BONUSFLAG")
	public String getBonusFlag() {
		return this.bonusFlag;
	}

	/**
	 * 属性BonusFlag的setter方法
	 */
	public void setBonusFlag(String bonusFlag) {
		this.bonusFlag = bonusFlag;
	}

	/**
	 * 属性主险险种编码的getter方法
	 */

	@Column(name = "MAINRISKCODE")
	public String getMainRiskCode() {
		return this.mainRiskCode;
	}

	/**
	 * 属性主险险种编码的setter方法
	 */
	public void setMainRiskCode(String mainRiskCode) {
		this.mainRiskCode = mainRiskCode;
	}

	/**
	 * 属性预计加费金额的getter方法
	 */

	@Column(name = "EXPADDFEE")
	public BigDecimal getExpAddFee() {
		return this.expAddFee;
	}

	/**
	 * 属性预计加费金额的setter方法
	 */
	public void setExpAddFee(BigDecimal expAddFee) {
		this.expAddFee = expAddFee;
	}

}
