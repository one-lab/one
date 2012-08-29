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
 * POJO类LCGrpCont
 */
@Entity
@Table(name = "LCGRPCONT")
public class LCGrpCont implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性集体合同号码 */
	private String grpContNo;

	/** 属性集体投保单号码 */
	private String proposalGrpContNo;

	/** 属性印刷号码 */
	private String prtNo;

	/** 属性销售渠道 */
	private String saleChnl;

	/** 属性管理机构 */
	private String manageCom;

	/** 属性代理机构 */
	private String agentCom;

	/** 属性代理人类型 */
	private String agentType;

	/** 属性代理人代码 */
	private String agentCode;

	/** 属性代理人组别 */
	private String agentGroup;

	/** 属性联合代理人代码 */
	private String agentCode1;

	/** 属性密码 */
	private String password;

	/** 属性密码 */
	private String password2;

	/** 属性投保人客户号码 */
	private String appntNo;

	/** 属性地址序号 */
	private String addressNo;

	/** 属性PeopleS2 */
	private BigDecimal peopleS2;

	/** 属性单位名称 */
	private String grpName;

	/** 属性业务类型 */
	private String businessType;

	/** 属性单位性质 */
	private String grpNature;

	/** 属性注册资本 */
	private BigDecimal rgtMoney;

	/** 属性资产总额 */
	private BigDecimal asset;

	/** 属性净资产收益率 */
	private BigDecimal netProfitRate;

	/** 属性主营业务 */
	private String mainBussiness;

	/** 属性法人 */
	private String corporation;

	/** 属性机构分布区域 */
	private String comAera;

	/** 属性单位传真 */
	private String fax;

	/** 属性单位电话 */
	private String phone;

	/** 属性付款方式 */
	private String getFlag;

	/** 属性负责人 */
	private String satrap;

	/** 属性电子邮件 */
	private String email;

	/** 属性成立日期 */
	private Date foundDate;

	/** 属性客户组号码 */
	private String grpGroupNo;

	/** 属性机构代码 */
	private String bankCode;

	/** 属性银行帐号 */
	private String bankAccNo;

	/** 属性银行帐户名 */
	private String accName;

	/** 属性合同争议处理方式 */
	private String disputedFlag;

	/** 属性溢交处理方式 */
	private String outPayFlag;

	/** 属性保单送达方式 */
	private String getPolMode;

	/** 属性语种标记 */
	private String lang;

	/** 属性币别 */
	private String currency;

	/** 属性遗失补发次数 */
	private BigDecimal lostTimes;

	/** 属性保单打印次数 */
	private BigDecimal printCount;

	/** 属性最后一次催收日期 */
	private Date regetDate;

	/** 属性最后一次保全日期 */
	private Date lastEdorDate;

	/** 属性最后一次给付日期 */
	private Date lastGetDate;

	/** 属性最后一次借款日期 */
	private Date lastLoanDate;

	/** 属性团体特殊业务标志 */
	private String specFlag;

	/** 属性集体特约 */
	private String grpSpec;

	/** 属性交费方式 */
	private String payMode;

	/** 属性签单机构 */
	private String signCom;

	/** 属性签单日期 */
	private Date signDate;

	/** 属性签单时间 */
	private String signTime;

	/** 属性保单生效日期 */
	private Date cvaliDate;

	/** 属性交费间隔 */
	private BigDecimal payIntv;

	/** 属性管理费比例 */
	private Double manageFeeRate;

	/** 属性预计人数 */
	private BigDecimal expPeoples;

	/** 属性预计保费 */
	private BigDecimal expPremium;

	/** 属性预计保额 */
	private BigDecimal expAmnt;

	/** 属性人数 */
	private BigDecimal peoples;

	/** 属性份数 */
	private BigDecimal mult;

	/** 属性保费 */
	private BigDecimal prem;

	/** 属性保额 */
	private BigDecimal amnt;

	/** 属性累计保费 */
	private BigDecimal sumPrem;

	/** 属性赔付金额 */
	private BigDecimal sumPay;

	/** 属性余额 */
	private BigDecimal dif;

	/** 属性备注 */
	private String remark;

	/** 属性备用属性字段1 */
	private String standbyFlag1;

	/** 属性备用属性字段2 */
	private String standbyFlag2;

	/** 属性备用属性字段3 */
	private String standbyFlag3;

	/** 属性录单人 */
	private String inputOperator;

	/** 属性申请日期 */
	private Date inputDate;

	/** 属性录入时间 */
	private String inputTime;

	/** 属性复核状态 */
	private String approveFlag;

	/** 属性复核人编码 */
	private String approveCode;

	/** 属性审核时间 */
	private Date approveDate;

	/** 属性复核时间 */
	private String approveTime;

	/** 属性核保人 */
	private String uwOperator;

	/** 属性核保状态 */
	private String uwFlag;

	/** 属性核保完成日期 */
	private Date uwDate;

	/** 属性核保完成时间 */
	private String uwTime;

	/** 属性投保单/保单标志 */
	private String appFlag;

	/** 属性投保单申请日期 */
	private Date polApplyDate;

	/** 属性保单回执客户签收日期 */
	private Date customGetPolDate;

	/** 属性保单送达日期 */
	private Date getPolDate;

	/** 属性保单送达时间 */
	private String getPolTime;

	/** 属性任务当前状态 */
	private String state;

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

	/** 属性参保形式 */
	private String enterKind;

	/** 属性保额等级 */
	private String amntGrade;

	/** 属性可投保人数 */
	private BigDecimal peoples3;

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

	/** 属性初审人 */
	private String firstTrialOperator;

	/** 属性初审日期 */
	private Date firstTrialDate;

	/** 属性初审时间 */
	private String firstTrialTime;

	/** 属性收单人 */
	private String receiveOperator;

	/** 属性国际驾驶执照领证时间 */
	private Date receiveDate;

	/** 属性接收时间 */
	private String receiveTime;

	/** 属性暂收据号 */
	private String tempFeeNo;

	/** 属性定损人（名称） */
	private String handlerName;

	/** 属性投保单填写日期 */
	private Date handlerDate;

	/** 属性投保单位章 */
	private String handlerPrint;

	/** 属性业务员填写日期 */
	private Date agentDate;

	/** 属性行业大类 */
	private String businessBigType;

	/** 属性市场类型 */
	private String marketType;

	/** 属性呈报号 */
	private String reportNo;

	/** 属性协议书号 */
	private String conferNo;

	/** 属性签报件号 */
	private String signReportNo;

	/** 属性代理协议书号 */
	private String agentConferNo;

	/** 属性续保原保单号 */
	private String cregistNo;

	/** 属性保单打印方式 */
	private String printType;

	/** 属性支持保全定期结算 */
	private String sequenceBalance;

	/** 属性定期结算时间 */
	private Date balanceDate;

	/** 属性单位负担 */
	private BigDecimal unitsBurden;

	/** 属性个人负担 */
	private BigDecimal personBurden;

	/** 属性主被保险人数 */
	private Long mainInsurePersonNumber;

	/** 属性连带被保险人数 */
	private Long relatedInsurePersonNumber;

	/** 属性销售方式 */
	private String grpSellType;

	/** 属性特别约定编码 */
	private String specNo;

	/** 属性特别约定内容 */
	private String specNoName;

	/** 属性预打保单打印标记 */
	private String previewPrintFlag;

	/** 属性保费结算方式 */
	private String premClearingForm;

	/** 属性法人证件类型 */
	private String corporationIDType;

	/** 属性法人证件号 */
	private String corporationIDNo;

	/** 属性法人有效日期 */
	private Date corporationsDate;

	/** 属性投保单位人数 */
	private Long grpPeoples;

	/** 属性费率 */
	private BigDecimal rate;

	/**
	 * 类LCGrpCont的默认构造方法
	 */
	public LCGrpCont() {
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
	 * 属性集体投保单号码的getter方法
	 */

	@Column(name = "PROPOSALGRPCONTNO")
	public String getProposalGrpContNo() {
		return this.proposalGrpContNo;
	}

	/**
	 * 属性集体投保单号码的setter方法
	 */
	public void setProposalGrpContNo(String proposalGrpContNo) {
		this.proposalGrpContNo = proposalGrpContNo;
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
	 * 属性代理人类型的getter方法
	 */

	@Column(name = "AGENTTYPE")
	public String getAgentType() {
		return this.agentType;
	}

	/**
	 * 属性代理人类型的setter方法
	 */
	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}

	/**
	 * 属性代理人代码的getter方法
	 */

	@Column(name = "AGENTCODE")
	public String getAgentCode() {
		return this.agentCode;
	}

	/**
	 * 属性代理人代码的setter方法
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
	 * 属性密码的getter方法
	 */

	@Column(name = "PASSWORD2")
	public String getPassword2() {
		return this.password2;
	}

	/**
	 * 属性密码的setter方法
	 */
	public void setPassword2(String password2) {
		this.password2 = password2;
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
	 * 属性业务类型的getter方法
	 */

	@Column(name = "BUSINESSTYPE")
	public String getBusinessType() {
		return this.businessType;
	}

	/**
	 * 属性业务类型的setter方法
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	/**
	 * 属性单位性质的getter方法
	 */

	@Column(name = "GRPNATURE")
	public String getGrpNature() {
		return this.grpNature;
	}

	/**
	 * 属性单位性质的setter方法
	 */
	public void setGrpNature(String grpNature) {
		this.grpNature = grpNature;
	}

	/**
	 * 属性注册资本的getter方法
	 */

	@Column(name = "RGTMONEY")
	public BigDecimal getRgtMoney() {
		return this.rgtMoney;
	}

	/**
	 * 属性注册资本的setter方法
	 */
	public void setRgtMoney(BigDecimal rgtMoney) {
		this.rgtMoney = rgtMoney;
	}

	/**
	 * 属性资产总额的getter方法
	 */

	@Column(name = "ASSET")
	public BigDecimal getAsset() {
		return this.asset;
	}

	/**
	 * 属性资产总额的setter方法
	 */
	public void setAsset(BigDecimal asset) {
		this.asset = asset;
	}

	/**
	 * 属性净资产收益率的getter方法
	 */

	@Column(name = "NETPROFITRATE")
	public BigDecimal getNetProfitRate() {
		return this.netProfitRate;
	}

	/**
	 * 属性净资产收益率的setter方法
	 */
	public void setNetProfitRate(BigDecimal netProfitRate) {
		this.netProfitRate = netProfitRate;
	}

	/**
	 * 属性主营业务的getter方法
	 */

	@Column(name = "MAINBUSSINESS")
	public String getMainBussiness() {
		return this.mainBussiness;
	}

	/**
	 * 属性主营业务的setter方法
	 */
	public void setMainBussiness(String mainBussiness) {
		this.mainBussiness = mainBussiness;
	}

	/**
	 * 属性法人的getter方法
	 */

	@Column(name = "CORPORATION")
	public String getCorporation() {
		return this.corporation;
	}

	/**
	 * 属性法人的setter方法
	 */
	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}

	/**
	 * 属性机构分布区域的getter方法
	 */

	@Column(name = "COMAERA")
	public String getComAera() {
		return this.comAera;
	}

	/**
	 * 属性机构分布区域的setter方法
	 */
	public void setComAera(String comAera) {
		this.comAera = comAera;
	}

	/**
	 * 属性单位传真的getter方法
	 */

	@Column(name = "FAX")
	public String getFax() {
		return this.fax;
	}

	/**
	 * 属性单位传真的setter方法
	 */
	public void setFax(String fax) {
		this.fax = fax;
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
	 * 属性付款方式的getter方法
	 */

	@Column(name = "GETFLAG")
	public String getGetFlag() {
		return this.getFlag;
	}

	/**
	 * 属性付款方式的setter方法
	 */
	public void setGetFlag(String getFlag) {
		this.getFlag = getFlag;
	}

	/**
	 * 属性负责人的getter方法
	 */

	@Column(name = "SATRAP")
	public String getSatrap() {
		return this.satrap;
	}

	/**
	 * 属性负责人的setter方法
	 */
	public void setSatrap(String satrap) {
		this.satrap = satrap;
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
	 * 属性成立日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "FOUNDDATE")
	public Date getFoundDate() {
		return this.foundDate;
	}

	/**
	 * 属性成立日期的setter方法
	 */
	public void setFoundDate(Date foundDate) {
		this.foundDate = foundDate;
	}

	/**
	 * 属性客户组号码的getter方法
	 */

	@Column(name = "GRPGROUPNO")
	public String getGrpGroupNo() {
		return this.grpGroupNo;
	}

	/**
	 * 属性客户组号码的setter方法
	 */
	public void setGrpGroupNo(String grpGroupNo) {
		this.grpGroupNo = grpGroupNo;
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
	 * 属性合同争议处理方式的getter方法
	 */

	@Column(name = "DISPUTEDFLAG")
	public String getDisputedFlag() {
		return this.disputedFlag;
	}

	/**
	 * 属性合同争议处理方式的setter方法
	 */
	public void setDisputedFlag(String disputedFlag) {
		this.disputedFlag = disputedFlag;
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
	 * 属性保单送达方式的getter方法
	 */

	@Column(name = "GETPOLMODE")
	public String getGetPolMode() {
		return this.getPolMode;
	}

	/**
	 * 属性保单送达方式的setter方法
	 */
	public void setGetPolMode(String getPolMode) {
		this.getPolMode = getPolMode;
	}

	/**
	 * 属性语种标记的getter方法
	 */

	@Column(name = "LANG")
	public String getLang() {
		return this.lang;
	}

	/**
	 * 属性语种标记的setter方法
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}

	/**
	 * 属性币别的getter方法
	 */

	@Column(name = "CURRENCY")
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * 属性币别的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * 属性遗失补发次数的getter方法
	 */

	@Column(name = "LOSTTIMES")
	public BigDecimal getLostTimes() {
		return this.lostTimes;
	}

	/**
	 * 属性遗失补发次数的setter方法
	 */
	public void setLostTimes(BigDecimal lostTimes) {
		this.lostTimes = lostTimes;
	}

	/**
	 * 属性保单打印次数的getter方法
	 */

	@Column(name = "PRINTCOUNT")
	public BigDecimal getPrintCount() {
		return this.printCount;
	}

	/**
	 * 属性保单打印次数的setter方法
	 */
	public void setPrintCount(BigDecimal printCount) {
		this.printCount = printCount;
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
	 * 属性集体特约的getter方法
	 */

	@Column(name = "GRPSPEC")
	public String getGrpSpec() {
		return this.grpSpec;
	}

	/**
	 * 属性集体特约的setter方法
	 */
	public void setGrpSpec(String grpSpec) {
		this.grpSpec = grpSpec;
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
	 * 属性人数的getter方法
	 */

	@Column(name = "PEOPLES")
	public BigDecimal getPeoples() {
		return this.peoples;
	}

	/**
	 * 属性人数的setter方法
	 */
	public void setPeoples(BigDecimal peoples) {
		this.peoples = peoples;
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
	 * 属性赔付金额的getter方法
	 */

	@Column(name = "SUMPAY")
	public BigDecimal getSumPay() {
		return this.sumPay;
	}

	/**
	 * 属性赔付金额的setter方法
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
	 * 属性录单人的getter方法
	 */

	@Column(name = "INPUTOPERATOR")
	public String getInputOperator() {
		return this.inputOperator;
	}

	/**
	 * 属性录单人的setter方法
	 */
	public void setInputOperator(String inputOperator) {
		this.inputOperator = inputOperator;
	}

	/**
	 * 属性申请日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "INPUTDATE")
	public Date getInputDate() {
		return this.inputDate;
	}

	/**
	 * 属性申请日期的setter方法
	 */
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	/**
	 * 属性录入时间的getter方法
	 */

	@Column(name = "INPUTTIME")
	public String getInputTime() {
		return this.inputTime;
	}

	/**
	 * 属性录入时间的setter方法
	 */
	public void setInputTime(String inputTime) {
		this.inputTime = inputTime;
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
	 * 属性审核时间的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "APPROVEDATE")
	public Date getApproveDate() {
		return this.approveDate;
	}

	/**
	 * 属性审核时间的setter方法
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
	 * 属性保单回执客户签收日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "CUSTOMGETPOLDATE")
	public Date getCustomGetPolDate() {
		return this.customGetPolDate;
	}

	/**
	 * 属性保单回执客户签收日期的setter方法
	 */
	public void setCustomGetPolDate(Date customGetPolDate) {
		this.customGetPolDate = customGetPolDate;
	}

	/**
	 * 属性保单送达日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "GETPOLDATE")
	public Date getGetPolDate() {
		return this.getPolDate;
	}

	/**
	 * 属性保单送达日期的setter方法
	 */
	public void setGetPolDate(Date getPolDate) {
		this.getPolDate = getPolDate;
	}

	/**
	 * 属性保单送达时间的getter方法
	 */

	@Column(name = "GETPOLTIME")
	public String getGetPolTime() {
		return this.getPolTime;
	}

	/**
	 * 属性保单送达时间的setter方法
	 */
	public void setGetPolTime(String getPolTime) {
		this.getPolTime = getPolTime;
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

	/**
	 * 属性参保形式的getter方法
	 */

	@Column(name = "ENTERKIND")
	public String getEnterKind() {
		return this.enterKind;
	}

	/**
	 * 属性参保形式的setter方法
	 */
	public void setEnterKind(String enterKind) {
		this.enterKind = enterKind;
	}

	/**
	 * 属性保额等级的getter方法
	 */

	@Column(name = "AMNTGRADE")
	public String getAmntGrade() {
		return this.amntGrade;
	}

	/**
	 * 属性保额等级的setter方法
	 */
	public void setAmntGrade(String amntGrade) {
		this.amntGrade = amntGrade;
	}

	/**
	 * 属性可投保人数的getter方法
	 */

	@Column(name = "PEOPLES3")
	public BigDecimal getPeoples3() {
		return this.peoples3;
	}

	/**
	 * 属性可投保人数的setter方法
	 */
	public void setPeoples3(BigDecimal peoples3) {
		this.peoples3 = peoples3;
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
	 * 属性初审人的getter方法
	 */

	@Column(name = "FIRSTTRIALOPERATOR")
	public String getFirstTrialOperator() {
		return this.firstTrialOperator;
	}

	/**
	 * 属性初审人的setter方法
	 */
	public void setFirstTrialOperator(String firstTrialOperator) {
		this.firstTrialOperator = firstTrialOperator;
	}

	/**
	 * 属性初审日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "FIRSTTRIALDATE")
	public Date getFirstTrialDate() {
		return this.firstTrialDate;
	}

	/**
	 * 属性初审日期的setter方法
	 */
	public void setFirstTrialDate(Date firstTrialDate) {
		this.firstTrialDate = firstTrialDate;
	}

	/**
	 * 属性初审时间的getter方法
	 */

	@Column(name = "FIRSTTRIALTIME")
	public String getFirstTrialTime() {
		return this.firstTrialTime;
	}

	/**
	 * 属性初审时间的setter方法
	 */
	public void setFirstTrialTime(String firstTrialTime) {
		this.firstTrialTime = firstTrialTime;
	}

	/**
	 * 属性收单人的getter方法
	 */

	@Column(name = "RECEIVEOPERATOR")
	public String getReceiveOperator() {
		return this.receiveOperator;
	}

	/**
	 * 属性收单人的setter方法
	 */
	public void setReceiveOperator(String receiveOperator) {
		this.receiveOperator = receiveOperator;
	}

	/**
	 * 属性国际驾驶执照领证时间的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "RECEIVEDATE")
	public Date getReceiveDate() {
		return this.receiveDate;
	}

	/**
	 * 属性国际驾驶执照领证时间的setter方法
	 */
	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	/**
	 * 属性接收时间的getter方法
	 */

	@Column(name = "RECEIVETIME")
	public String getReceiveTime() {
		return this.receiveTime;
	}

	/**
	 * 属性接收时间的setter方法
	 */
	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}

	/**
	 * 属性暂收据号的getter方法
	 */

	@Column(name = "TEMPFEENO")
	public String getTempFeeNo() {
		return this.tempFeeNo;
	}

	/**
	 * 属性暂收据号的setter方法
	 */
	public void setTempFeeNo(String tempFeeNo) {
		this.tempFeeNo = tempFeeNo;
	}

	/**
	 * 属性定损人（名称）的getter方法
	 */

	@Column(name = "HANDLERNAME")
	public String getHandlerName() {
		return this.handlerName;
	}

	/**
	 * 属性定损人（名称）的setter方法
	 */
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}

	/**
	 * 属性投保单填写日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "HANDLERDATE")
	public Date getHandlerDate() {
		return this.handlerDate;
	}

	/**
	 * 属性投保单填写日期的setter方法
	 */
	public void setHandlerDate(Date handlerDate) {
		this.handlerDate = handlerDate;
	}

	/**
	 * 属性投保单位章的getter方法
	 */

	@Column(name = "HANDLERPRINT")
	public String getHandlerPrint() {
		return this.handlerPrint;
	}

	/**
	 * 属性投保单位章的setter方法
	 */
	public void setHandlerPrint(String handlerPrint) {
		this.handlerPrint = handlerPrint;
	}

	/**
	 * 属性业务员填写日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "AGENTDATE")
	public Date getAgentDate() {
		return this.agentDate;
	}

	/**
	 * 属性业务员填写日期的setter方法
	 */
	public void setAgentDate(Date agentDate) {
		this.agentDate = agentDate;
	}

	/**
	 * 属性行业大类的getter方法
	 */

	@Column(name = "BUSINESSBIGTYPE")
	public String getBusinessBigType() {
		return this.businessBigType;
	}

	/**
	 * 属性行业大类的setter方法
	 */
	public void setBusinessBigType(String businessBigType) {
		this.businessBigType = businessBigType;
	}

	/**
	 * 属性市场类型的getter方法
	 */

	@Column(name = "MARKETTYPE")
	public String getMarketType() {
		return this.marketType;
	}

	/**
	 * 属性市场类型的setter方法
	 */
	public void setMarketType(String marketType) {
		this.marketType = marketType;
	}

	/**
	 * 属性呈报号的getter方法
	 */

	@Column(name = "REPORTNO")
	public String getReportNo() {
		return this.reportNo;
	}

	/**
	 * 属性呈报号的setter方法
	 */
	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}

	/**
	 * 属性协议书号的getter方法
	 */

	@Column(name = "CONFERNO")
	public String getConferNo() {
		return this.conferNo;
	}

	/**
	 * 属性协议书号的setter方法
	 */
	public void setConferNo(String conferNo) {
		this.conferNo = conferNo;
	}

	/**
	 * 属性签报件号的getter方法
	 */

	@Column(name = "SIGNREPORTNO")
	public String getSignReportNo() {
		return this.signReportNo;
	}

	/**
	 * 属性签报件号的setter方法
	 */
	public void setSignReportNo(String signReportNo) {
		this.signReportNo = signReportNo;
	}

	/**
	 * 属性代理协议书号的getter方法
	 */

	@Column(name = "AGENTCONFERNO")
	public String getAgentConferNo() {
		return this.agentConferNo;
	}

	/**
	 * 属性代理协议书号的setter方法
	 */
	public void setAgentConferNo(String agentConferNo) {
		this.agentConferNo = agentConferNo;
	}

	/**
	 * 属性续保原保单号的getter方法
	 */

	@Column(name = "CREGISTNO")
	public String getCregistNo() {
		return this.cregistNo;
	}

	/**
	 * 属性续保原保单号的setter方法
	 */
	public void setCregistNo(String cregistNo) {
		this.cregistNo = cregistNo;
	}

	/**
	 * 属性保单打印方式的getter方法
	 */

	@Column(name = "PRINTTYPE")
	public String getPrintType() {
		return this.printType;
	}

	/**
	 * 属性保单打印方式的setter方法
	 */
	public void setPrintType(String printType) {
		this.printType = printType;
	}

	/**
	 * 属性支持保全定期结算的getter方法
	 */

	@Column(name = "SEQUENCEBALANCE")
	public String getSequenceBalance() {
		return this.sequenceBalance;
	}

	/**
	 * 属性支持保全定期结算的setter方法
	 */
	public void setSequenceBalance(String sequenceBalance) {
		this.sequenceBalance = sequenceBalance;
	}

	/**
	 * 属性定期结算时间的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "BALANCEDATE")
	public Date getBalanceDate() {
		return this.balanceDate;
	}

	/**
	 * 属性定期结算时间的setter方法
	 */
	public void setBalanceDate(Date balanceDate) {
		this.balanceDate = balanceDate;
	}

	/**
	 * 属性单位负担的getter方法
	 */

	@Column(name = "UNITSBURDEN")
	public BigDecimal getUnitsBurden() {
		return this.unitsBurden;
	}

	/**
	 * 属性单位负担的setter方法
	 */
	public void setUnitsBurden(BigDecimal unitsBurden) {
		this.unitsBurden = unitsBurden;
	}

	/**
	 * 属性个人负担的getter方法
	 */

	@Column(name = "PERSONBURDEN")
	public BigDecimal getPersonBurden() {
		return this.personBurden;
	}

	/**
	 * 属性个人负担的setter方法
	 */
	public void setPersonBurden(BigDecimal personBurden) {
		this.personBurden = personBurden;
	}

	/**
	 * 属性主被保险人数的getter方法
	 */

	@Column(name = "MAININSUREPERSONNUMBER")
	public Long getMainInsurePersonNumber() {
		return this.mainInsurePersonNumber;
	}

	/**
	 * 属性主被保险人数的setter方法
	 */
	public void setMainInsurePersonNumber(Long mainInsurePersonNumber) {
		this.mainInsurePersonNumber = mainInsurePersonNumber;
	}

	/**
	 * 属性连带被保险人数的getter方法
	 */

	@Column(name = "RELATEDINSUREPERSONNUMBER")
	public Long getRelatedInsurePersonNumber() {
		return this.relatedInsurePersonNumber;
	}

	/**
	 * 属性连带被保险人数的setter方法
	 */
	public void setRelatedInsurePersonNumber(Long relatedInsurePersonNumber) {
		this.relatedInsurePersonNumber = relatedInsurePersonNumber;
	}

	/**
	 * 属性销售方式的getter方法
	 */

	@Column(name = "GRPSELLTYPE")
	public String getGrpSellType() {
		return this.grpSellType;
	}

	/**
	 * 属性销售方式的setter方法
	 */
	public void setGrpSellType(String grpSellType) {
		this.grpSellType = grpSellType;
	}

	/**
	 * 属性特别约定编码的getter方法
	 */

	@Column(name = "SPECNO")
	public String getSpecNo() {
		return this.specNo;
	}

	/**
	 * 属性特别约定编码的setter方法
	 */
	public void setSpecNo(String specNo) {
		this.specNo = specNo;
	}

	/**
	 * 属性特别约定内容的getter方法
	 */

	@Column(name = "SPECNONAME")
	public String getSpecNoName() {
		return this.specNoName;
	}

	/**
	 * 属性特别约定内容的setter方法
	 */
	public void setSpecNoName(String specNoName) {
		this.specNoName = specNoName;
	}

	/**
	 * 属性预打保单打印标记的getter方法
	 */

	@Column(name = "PREVIEWPRINTFLAG")
	public String getPreviewPrintFlag() {
		return this.previewPrintFlag;
	}

	/**
	 * 属性预打保单打印标记的setter方法
	 */
	public void setPreviewPrintFlag(String previewPrintFlag) {
		this.previewPrintFlag = previewPrintFlag;
	}

	/**
	 * 属性保费结算方式的getter方法
	 */

	@Column(name = "PREMCLEARINGFORM")
	public String getPremClearingForm() {
		return this.premClearingForm;
	}

	/**
	 * 属性保费结算方式的setter方法
	 */
	public void setPremClearingForm(String premClearingForm) {
		this.premClearingForm = premClearingForm;
	}

	/**
	 * 属性法人证件类型的getter方法
	 */

	@Column(name = "CORPORATIONIDTYPE")
	public String getCorporationIDType() {
		return this.corporationIDType;
	}

	/**
	 * 属性法人证件类型的setter方法
	 */
	public void setCorporationIDType(String corporationIDType) {
		this.corporationIDType = corporationIDType;
	}

	/**
	 * 属性法人证件号的getter方法
	 */

	@Column(name = "CORPORATIONIDNO")
	public String getCorporationIDNo() {
		return this.corporationIDNo;
	}

	/**
	 * 属性法人证件号的setter方法
	 */
	public void setCorporationIDNo(String corporationIDNo) {
		this.corporationIDNo = corporationIDNo;
	}

	/**
	 * 属性法人有效日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "CORPORATIONSDATE")
	public Date getCorporationsDate() {
		return this.corporationsDate;
	}

	/**
	 * 属性法人有效日期的setter方法
	 */
	public void setCorporationsDate(Date corporationsDate) {
		this.corporationsDate = corporationsDate;
	}

	/**
	 * 属性投保单位人数的getter方法
	 */

	@Column(name = "GRPPEOPLES")
	public Long getGrpPeoples() {
		return this.grpPeoples;
	}

	/**
	 * 属性投保单位人数的setter方法
	 */
	public void setGrpPeoples(Long grpPeoples) {
		this.grpPeoples = grpPeoples;
	}

	/**
	 * 属性费率的getter方法
	 */

	@Column(name = "RATE")
	public BigDecimal getRate() {
		return this.rate;
	}

	/**
	 * 属性费率的setter方法
	 */
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

}
