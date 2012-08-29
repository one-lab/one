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
 * POJO类LCCont
 */
@Entity
@Table(name = "LCCONT")
public class LCCont implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性合同号码 */
	private String contNo;

	/** 属性集体合同号码 */
	private String grpContNo;

	/** 属性总单投保单号码 */
	private String proposalContNo;

	/** 属性印刷号码 */
	private String prtNo;

	/** 属性总单类型 */
	private String contType;

	/** 属性家庭单类型 */
	private String familyType;

	/** 属性家庭保障号 */
	private String familyID;

	/** 属性保单类型标记 */
	private String polType;

	/** 属性卡单标志 */
	private String cardFlag;

	/** 属性管理机构 */
	private String manageCom;

	/** 属性处理机构 */
	private String executeCom;

	/** 属性代理机构 */
	private String agentCom;

	/** 属性代理人编码 */
	private String agentCode;

	/** 属性代理人组别 */
	private String agentGroup;

	/** 属性联合代理人代码 */
	private String agentCode1;

	/** 属性代理机构内部分类 */
	private String agentType;

	/** 属性销售渠道 */
	private String saleChnl;

	/** 属性经办人 */
	private String handler;

	/** 属性保单口令 */
	private String password;

	/** 属性投保人客户号码 */
	private String appntNo;

	/** 属性投保人名称 */
	private String appntName;

	/** 属性投保人性别 */
	private String appntSex;

	/** 属性投保人出生日期 */
	private Date appntBirthday;

	/** 属性投保人证件类型 */
	private String appntIDType;

	/** 属性投保人证件号码 */
	private String appntIDNo;

	/** 属性被保人客户号码 */
	private String insuredNo;

	/** 属性被保人名称 */
	private String insuredName;

	/** 属性被保人性别 */
	private String insuredSex;

	/** 属性被保人出生日期 */
	private Date insuredBirthday;

	/** 属性证件类型 */
	private String insuredIDType;

	/** 属性证件号码 */
	private String insuredIDNo;

	/** 属性交费间隔 */
	private BigDecimal payIntv;

	/** 属性交费方式 */
	private String payMode;

	/** 属性交费位置 */
	private String payLocation;

	/** 属性合同争议处理方式 */
	private String disputedFlag;

	/** 属性溢交处理方式 */
	private String outPayFlag;

	/** 属性保单送达方式 */
	private String getPolMode;

	/** 属性签单机构 */
	private String signCom;

	/** 属性签单日期 */
	private Date signDate;

	/** 属性签单时间 */
	private String signTime;

	/** 属性银行委托书号码 */
	private String consignNo;

	/** 属性银行编码 */
	private String bankCode;

	/** 属性银行帐号 */
	private String bankAccNo;

	/** 属性银行帐户名 */
	private String accName;

	/** 属性保单打印次数 */
	private BigDecimal printCount;

	/** 属性遗失补发次数 */
	private BigDecimal lostTimes;

	/** 属性语种标记 */
	private String lang;

	/** 属性币别 */
	private String currency;

	/** 属性备注 */
	private String remark;

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

	/** 属性余额 */
	private BigDecimal dif;

	/** 属性交至日期 */
	private Date paytoDate;

	/** 属性首期交费日期 */
	private Date firstPayDate;

	/** 属性保单生效日期 */
	private Date cvaliDate;

	/** 属性录单人 */
	private String inputOperator;

	/** 属性录单完成日期 */
	private Date inputDate;

	/** 属性录单完成时间 */
	private String inputTime;

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

	/** 属性投保单申请日期 */
	private Date polApplyDate;

	/** 属性保单送达日期 */
	private Date getPolDate;

	/** 属性保单送达时间 */
	private String getPolTime;

	/** 属性保单回执客户签收日期 */
	private Date customGetPolDate;

	/** 属性状态 */
	private String state;

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

	/** 属性初审人 */
	private String firstTrialOperator;

	/** 属性初审日期 */
	private Date firstTrialDate;

	/** 属性初审时间 */
	private String firstTrialTime;

	/** 属性收单人 */
	private String receiveOperator;

	/** 属性收单日期 */
	private Date receiveDate;

	/** 属性收单时间 */
	private String receiveTime;

	/** 属性暂收据号 */
	private String tempFeeNo;

	/** 属性销售方式 */
	private String sellType;

	/** 属性强制人工核保标志 */
	private String forceUWFlag;

	/** 属性强制人工核保原因 */
	private String forceUWReason;

	/** 属性首期银行编码 */
	private String newBankCode;

	/** 属性首期银行帐号 */
	private String newBankAccNo;

	/** 属性首期银行帐户名 */
	private String newAccName;

	/** 属性首期交费方式 */
	private String newPayMode;

	/** 属性银代银行代码 */
	private String agentBankCode;

	/** 属性银代柜员 */
	private String bankAgent;

	/** 属性绿色通道 */
	private String greenChannel;

	/** 属性被保人同时投保件数 */
	private String appnCount;

	/** 属性初审标记 */
	private String firstTrialFlag;

	/** 属性初审人员说明栏 */
	private String firstTrialRemark;

	/** 属性红利金领取方式 */
	private String bonusGetMode;

	/** 属性自动垫交标志 */
	private String autoPayFlag;

	/**
	 * 类LCCont的默认构造方法
	 */
	public LCCont() {
	}

	/**
	 * 属性合同号码的getter方法
	 */
	@Id
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
	 * 属性总单投保单号码的getter方法
	 */

	@Column(name = "PROPOSALCONTNO")
	public String getProposalContNo() {
		return this.proposalContNo;
	}

	/**
	 * 属性总单投保单号码的setter方法
	 */
	public void setProposalContNo(String proposalContNo) {
		this.proposalContNo = proposalContNo;
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
	 * 属性家庭单类型的getter方法
	 */

	@Column(name = "FAMILYTYPE")
	public String getFamilyType() {
		return this.familyType;
	}

	/**
	 * 属性家庭单类型的setter方法
	 */
	public void setFamilyType(String familyType) {
		this.familyType = familyType;
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
	 * 属性保单类型标记的getter方法
	 */

	@Column(name = "POLTYPE")
	public String getPolType() {
		return this.polType;
	}

	/**
	 * 属性保单类型标记的setter方法
	 */
	public void setPolType(String polType) {
		this.polType = polType;
	}

	/**
	 * 属性卡单标志的getter方法
	 */

	@Column(name = "CARDFLAG")
	public String getCardFlag() {
		return this.cardFlag;
	}

	/**
	 * 属性卡单标志的setter方法
	 */
	public void setCardFlag(String cardFlag) {
		this.cardFlag = cardFlag;
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
	 * 属性投保人性别的getter方法
	 */

	@Column(name = "APPNTSEX")
	public String getAppntSex() {
		return this.appntSex;
	}

	/**
	 * 属性投保人性别的setter方法
	 */
	public void setAppntSex(String appntSex) {
		this.appntSex = appntSex;
	}

	/**
	 * 属性投保人出生日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "APPNTBIRTHDAY")
	public Date getAppntBirthday() {
		return this.appntBirthday;
	}

	/**
	 * 属性投保人出生日期的setter方法
	 */
	public void setAppntBirthday(Date appntBirthday) {
		this.appntBirthday = appntBirthday;
	}

	/**
	 * 属性投保人证件类型的getter方法
	 */

	@Column(name = "APPNTIDTYPE")
	public String getAppntIDType() {
		return this.appntIDType;
	}

	/**
	 * 属性投保人证件类型的setter方法
	 */
	public void setAppntIDType(String appntIDType) {
		this.appntIDType = appntIDType;
	}

	/**
	 * 属性投保人证件号码的getter方法
	 */

	@Column(name = "APPNTIDNO")
	public String getAppntIDNo() {
		return this.appntIDNo;
	}

	/**
	 * 属性投保人证件号码的setter方法
	 */
	public void setAppntIDNo(String appntIDNo) {
		this.appntIDNo = appntIDNo;
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
	 * 属性证件类型的getter方法
	 */

	@Column(name = "INSUREDIDTYPE")
	public String getInsuredIDType() {
		return this.insuredIDType;
	}

	/**
	 * 属性证件类型的setter方法
	 */
	public void setInsuredIDType(String insuredIDType) {
		this.insuredIDType = insuredIDType;
	}

	/**
	 * 属性证件号码的getter方法
	 */

	@Column(name = "INSUREDIDNO")
	public String getInsuredIDNo() {
		return this.insuredIDNo;
	}

	/**
	 * 属性证件号码的setter方法
	 */
	public void setInsuredIDNo(String insuredIDNo) {
		this.insuredIDNo = insuredIDNo;
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
	 * 属性银行委托书号码的getter方法
	 */

	@Column(name = "CONSIGNNO")
	public String getConsignNo() {
		return this.consignNo;
	}

	/**
	 * 属性银行委托书号码的setter方法
	 */
	public void setConsignNo(String consignNo) {
		this.consignNo = consignNo;
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
	 * 属性录单完成日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "INPUTDATE")
	public Date getInputDate() {
		return this.inputDate;
	}

	/**
	 * 属性录单完成日期的setter方法
	 */
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	/**
	 * 属性录单完成时间的getter方法
	 */

	@Column(name = "INPUTTIME")
	public String getInputTime() {
		return this.inputTime;
	}

	/**
	 * 属性录单完成时间的setter方法
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
	 * 属性收单日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "RECEIVEDATE")
	public Date getReceiveDate() {
		return this.receiveDate;
	}

	/**
	 * 属性收单日期的setter方法
	 */
	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	/**
	 * 属性收单时间的getter方法
	 */

	@Column(name = "RECEIVETIME")
	public String getReceiveTime() {
		return this.receiveTime;
	}

	/**
	 * 属性收单时间的setter方法
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
	 * 属性销售方式的getter方法
	 */

	@Column(name = "SELLTYPE")
	public String getSellType() {
		return this.sellType;
	}

	/**
	 * 属性销售方式的setter方法
	 */
	public void setSellType(String sellType) {
		this.sellType = sellType;
	}

	/**
	 * 属性强制人工核保标志的getter方法
	 */

	@Column(name = "FORCEUWFLAG")
	public String getForceUWFlag() {
		return this.forceUWFlag;
	}

	/**
	 * 属性强制人工核保标志的setter方法
	 */
	public void setForceUWFlag(String forceUWFlag) {
		this.forceUWFlag = forceUWFlag;
	}

	/**
	 * 属性强制人工核保原因的getter方法
	 */

	@Column(name = "FORCEUWREASON")
	public String getForceUWReason() {
		return this.forceUWReason;
	}

	/**
	 * 属性强制人工核保原因的setter方法
	 */
	public void setForceUWReason(String forceUWReason) {
		this.forceUWReason = forceUWReason;
	}

	/**
	 * 属性首期银行编码的getter方法
	 */

	@Column(name = "NEWBANKCODE")
	public String getNewBankCode() {
		return this.newBankCode;
	}

	/**
	 * 属性首期银行编码的setter方法
	 */
	public void setNewBankCode(String newBankCode) {
		this.newBankCode = newBankCode;
	}

	/**
	 * 属性首期银行帐号的getter方法
	 */

	@Column(name = "NEWBANKACCNO")
	public String getNewBankAccNo() {
		return this.newBankAccNo;
	}

	/**
	 * 属性首期银行帐号的setter方法
	 */
	public void setNewBankAccNo(String newBankAccNo) {
		this.newBankAccNo = newBankAccNo;
	}

	/**
	 * 属性首期银行帐户名的getter方法
	 */

	@Column(name = "NEWACCNAME")
	public String getNewAccName() {
		return this.newAccName;
	}

	/**
	 * 属性首期银行帐户名的setter方法
	 */
	public void setNewAccName(String newAccName) {
		this.newAccName = newAccName;
	}

	/**
	 * 属性首期交费方式的getter方法
	 */

	@Column(name = "NEWPAYMODE")
	public String getNewPayMode() {
		return this.newPayMode;
	}

	/**
	 * 属性首期交费方式的setter方法
	 */
	public void setNewPayMode(String newPayMode) {
		this.newPayMode = newPayMode;
	}

	/**
	 * 属性银代银行代码的getter方法
	 */

	@Column(name = "AGENTBANKCODE")
	public String getAgentBankCode() {
		return this.agentBankCode;
	}

	/**
	 * 属性银代银行代码的setter方法
	 */
	public void setAgentBankCode(String agentBankCode) {
		this.agentBankCode = agentBankCode;
	}

	/**
	 * 属性银代柜员的getter方法
	 */

	@Column(name = "BANKAGENT")
	public String getBankAgent() {
		return this.bankAgent;
	}

	/**
	 * 属性银代柜员的setter方法
	 */
	public void setBankAgent(String bankAgent) {
		this.bankAgent = bankAgent;
	}

	/**
	 * 属性绿色通道的getter方法
	 */

	@Column(name = "GREENCHANNEL")
	public String getGreenChannel() {
		return this.greenChannel;
	}

	/**
	 * 属性绿色通道的setter方法
	 */
	public void setGreenChannel(String greenChannel) {
		this.greenChannel = greenChannel;
	}

	/**
	 * 属性被保人同时投保件数的getter方法
	 */

	@Column(name = "APPNCOUNT")
	public String getAppnCount() {
		return this.appnCount;
	}

	/**
	 * 属性被保人同时投保件数的setter方法
	 */
	public void setAppnCount(String appnCount) {
		this.appnCount = appnCount;
	}

	/**
	 * 属性初审标记的getter方法
	 */

	@Column(name = "FIRSTTRIALFLAG")
	public String getFirstTrialFlag() {
		return this.firstTrialFlag;
	}

	/**
	 * 属性初审标记的setter方法
	 */
	public void setFirstTrialFlag(String firstTrialFlag) {
		this.firstTrialFlag = firstTrialFlag;
	}

	/**
	 * 属性初审人员说明栏的getter方法
	 */

	@Column(name = "FIRSTTRIALREMARK")
	public String getFirstTrialRemark() {
		return this.firstTrialRemark;
	}

	/**
	 * 属性初审人员说明栏的setter方法
	 */
	public void setFirstTrialRemark(String firstTrialRemark) {
		this.firstTrialRemark = firstTrialRemark;
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

}
