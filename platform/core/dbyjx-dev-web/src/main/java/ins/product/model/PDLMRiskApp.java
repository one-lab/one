package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
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

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.xwork.StringUtils;

/**
 * POJO类PDLMRiskApp
 */
@Entity
@Table(name = "PD_LMRISKAPP")
public class PDLMRiskApp implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性险种代码 */
	private String riskCode;

	/** 属性险种定义 */
	private PDLMRisk PDLMRisk;

	/** 属性险种版本 */
	private String riskVer;

	/** 属性险种名称 */
	private String riskName;

	/** 属性险类编码 */
	private String kindCode;

	/** 属性险种分类 */
	private String riskType;

	/** 属性险种分类1 */
	private String riskType1;

	/** 属性险种分类2 */
	private String riskType2;

	/** 属性险种性质 */
	private String riskProp;

	/** 属性险种类别 */
	private String riskPeriod;

	/** 属性险种细分 */
	private String riskTypeDetail;

	/** 属性险种标记 */
	private String riskFlag;

	/** 属性保单类型 */
	private String polType;

	/** 属性投资标记 */
	private String investFlag;

	/** 属性分红标记 */
	private String bonusFlag;

	/** 属性红利领取方式 */
	private String bonusMode;

	/** 属性有无名单标记 */
	private String listFlag;

	/** 属性主附险标记 */
	private String subRiskFlag;

	/** 属性计算精确位 */
	private BigDecimal calDigital;

	/** 属性计算取舍方法 */
	private String calChoMode;

	/** 属性风险保额倍数 */
	private BigDecimal riskAmntMult;

	/** 属性保险期限标志 */
	private String insuPeriodFlag;

	/** 属性保险期间上限 */
	private BigDecimal maxEndPeriod;

	/** 属性满期截至年龄 */
	private BigDecimal ageLmt;

	/** 属性签单日算法 */
	private BigDecimal signDateCalMode;

	/** 属性协议险标记 */
	private String protocolFlag;

	/** 属性协议险给付金改变标记 */
	private String getChgFlag;

	/** 属性协议缴费标记 */
	private String protocolPayFlag;

	/** 属性保障计划标记 */
	private String ensuPlanFlag;

	/** 属性保障计划调整标记 */
	private String ensuPlanAdjFlag;

	/** 属性开办日期 */
	private Date startDate;

	/** 属性停办日期 */
	private Date endDate;

	/** 属性最小投保人年龄 */
	private BigDecimal minAppntAge;

	/** 属性最大投保人年龄 */
	private BigDecimal maxAppntAge;

	/** 属性最大被保人年龄 */
	private BigDecimal maxInsuredAge;

	/** 属性最小被保人年龄 */
	private BigDecimal minInsuredAge;

	/** 属性投保使用利率 */
	private BigDecimal appInterest;

	/** 属性投保使用费率 */
	private BigDecimal appPremRate;

	/** 属性多被保人标记 */
	private String insuredFlag;

	/** 属性多被保人分享标记 */
	private String shareFlag;

	/** 属性受益人标记 */
	private String bnfFlag;

	/** 属性暂缴费标记 */
	private String tempPayFlag;

	/** 属性录入缴费项标记 */
	private String inpPayPlan;

	/** 属性告知标记 */
	private String impartFlag;

	/** 属性保险经历标记 */
	private String insuExpeFlag;

	/** 属性提供借款标记 */
	private String loanFalg;

	/** 属性抵押标记 */
	private String mortagageFlag;

	/** 属性备注 */
	private String idifReturnFlag;

	/** 属性减额缴清标记 */
	private String cutAmntStopPay;

	/** 属性分保率 */
	private BigDecimal rinsRate;

	/** 属性销售标记 */
	private String saleFlag;

	/** 属性磁盘文件投保标记 */
	private String fileAppFlag;

	/** 属性管理部门 */
	private String mngCom;

	/** 属性自动垫缴标志 */
	private String autoPayFlag;

	/** 属性是否打印医院列表标记 */
	private String needPrintHospital;

	/** 属性是否打印伤残给付表标记 */
	private String needPrintGet;

	/** 属性险种分类3 */
	private String riskType3;

	/** 属性险种分类4 */
	private String riskType4;

	/** 属性险种分类5 */
	private String riskType5;

	/** 属性签单后不需要打印 */
	private String notPrintPol;

	/** 属性录单时是否需要设置保单送达日期 */
	private String needGetPolDate;

	/** 属性是否从暂缴费表中读取银行的账号和户名 */
	private String needReReadBank;

	/** 属性特殊险种标记 */
	private String specFlag;

	/** 属性利差返还标记 */
	private String interestDifFlag;

	/** 属性险种分类6 */
	private String riskType6;

	/** 属性险种分类7 */
	private String riskType7;

	/** 属性险种分类8 */
	private String riskType8;

	/** 属性险种分类9 */
	private String riskType9;

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

	/** 属性Standbyflag1 */
	private String standbyflag1;

	/** 属性Standbyflag2 */
	private String standbyflag2;

	/** 属性Standbyflag3 */
	private BigDecimal standbyflag3;

	/** 属性Standbyflag4 */
	private BigDecimal standbyflag4;

	/** 属性Standbyflag5 */
	private BigDecimal standbyflag5;

	/** 属性Standbyflag6 */
	private BigDecimal standbyflag6;

	/**
	 * 类PDLMRiskApp的默认构造方法
	 */
	public PDLMRiskApp() {
	}

	/**
	 * 属性险种代码的getter方法
	 */
	@Id
	@Column(name = "RISKCODE")
	public String getRiskCode() {
		return this.riskCode;
	}

	/**
	 * 属性险种代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	/**
	 * 属性险种定义的getter方法
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RISKCODE", unique = true, nullable = false, insertable = false, updatable = false)
	public PDLMRisk getPDLMRisk() {
		return this.PDLMRisk;
	}

	/**
	 * 属性险种定义的setter方法
	 */
	public void setPDLMRisk(PDLMRisk PDLMRisk) {
		this.PDLMRisk = PDLMRisk;
	}

	/**
	 * 属性险种版本的getter方法
	 */

	@Column(name = "RISKVER")
	public String getRiskVer() {
		return this.riskVer;
	}

	/**
	 * 属性险种版本的setter方法
	 */
	public void setRiskVer(String riskVer) {
		this.riskVer = riskVer;
	}

	/**
	 * 属性险种名称的getter方法
	 */

	@Column(name = "RISKNAME")
	public String getRiskName() {
		return this.riskName;
	}

	/**
	 * 属性险种名称的setter方法
	 */
	public void setRiskName(String riskName) {
		this.riskName = riskName;
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
	 * 属性险种分类的getter方法
	 */

	@Column(name = "RISKTYPE")
	public String getRiskType() {
		return this.riskType;
	}

	/**
	 * 属性险种分类的setter方法
	 */
	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}

	/**
	 * 属性险种分类1的getter方法
	 */

	@Column(name = "RISKTYPE1")
	public String getRiskType1() {
		return this.riskType1;
	}

	/**
	 * 属性险种分类1的setter方法
	 */
	public void setRiskType1(String riskType1) {
		this.riskType1 = riskType1;
	}

	/**
	 * 属性险种分类2的getter方法
	 */

	@Column(name = "RISKTYPE2")
	public String getRiskType2() {
		return this.riskType2;
	}

	/**
	 * 属性险种分类2的setter方法
	 */
	public void setRiskType2(String riskType2) {
		this.riskType2 = riskType2;
	}

	/**
	 * 属性险种性质的getter方法
	 */

	@Column(name = "RISKPROP")
	public String getRiskProp() {
		return this.riskProp;
	}

	/**
	 * 属性险种性质的setter方法
	 */
	public void setRiskProp(String riskProp) {
		this.riskProp = riskProp;
	}

	/**
	 * 属性险种类别的getter方法
	 */

	@Column(name = "RISKPERIOD")
	public String getRiskPeriod() {
		return this.riskPeriod;
	}

	/**
	 * 属性险种类别的setter方法
	 */
	public void setRiskPeriod(String riskPeriod) {
		this.riskPeriod = riskPeriod;
	}

	/**
	 * 属性险种细分的getter方法
	 */

	@Column(name = "RISKTYPEDETAIL")
	public String getRiskTypeDetail() {
		return this.riskTypeDetail;
	}

	/**
	 * 属性险种细分的setter方法
	 */
	public void setRiskTypeDetail(String riskTypeDetail) {
		this.riskTypeDetail = riskTypeDetail;
	}

	/**
	 * 属性险种标记的getter方法
	 */

	@Column(name = "RISKFLAG")
	public String getRiskFlag() {
		return this.riskFlag;
	}

	/**
	 * 属性险种标记的setter方法
	 */
	public void setRiskFlag(String riskFlag) {
		this.riskFlag = riskFlag;
	}

	/**
	 * 属性保单类型的getter方法
	 */

	@Column(name = "POLTYPE")
	public String getPolType() {
		return this.polType;
	}

	/**
	 * 属性保单类型的setter方法
	 */
	public void setPolType(String polType) {
		this.polType = polType;
	}

	/**
	 * 属性投资标记的getter方法
	 */

	@Column(name = "INVESTFLAG")
	public String getInvestFlag() {
		return this.investFlag;
	}

	/**
	 * 属性投资标记的setter方法
	 */
	public void setInvestFlag(String investFlag) {
		this.investFlag = investFlag;
	}

	/**
	 * 属性分红标记的getter方法
	 */

	@Column(name = "BONUSFLAG")
	public String getBonusFlag() {
		return this.bonusFlag;
	}

	/**
	 * 属性分红标记的setter方法
	 */
	public void setBonusFlag(String bonusFlag) {
		this.bonusFlag = bonusFlag;
	}

	/**
	 * 属性红利领取方式的getter方法
	 */

	@Column(name = "BONUSMODE")
	public String getBonusMode() {
		return this.bonusMode;
	}

	/**
	 * 属性红利领取方式的setter方法
	 */
	public void setBonusMode(String bonusMode) {
		this.bonusMode = bonusMode;
	}

	/**
	 * 属性有无名单标记的getter方法
	 */

	@Column(name = "LISTFLAG")
	public String getListFlag() {
		return this.listFlag;
	}

	/**
	 * 属性有无名单标记的setter方法
	 */
	public void setListFlag(String listFlag) {
		this.listFlag = listFlag;
	}

	/**
	 * 属性主附险标记的getter方法
	 */

	@Column(name = "SUBRISKFLAG")
	public String getSubRiskFlag() {
		return this.subRiskFlag;
	}

	/**
	 * 属性主附险标记的setter方法
	 */
	public void setSubRiskFlag(String subRiskFlag) {
		this.subRiskFlag = subRiskFlag;
	}

	/**
	 * 属性计算精确位的getter方法
	 */

	@Column(name = "CALDIGITAL")
	public BigDecimal getCalDigital() {
		return this.calDigital;
	}

	/**
	 * 属性计算精确位的setter方法
	 */
	public void setCalDigital(BigDecimal calDigital) {
		this.calDigital = calDigital;
	}

	/**
	 * 属性计算取舍方法的getter方法
	 */

	@Column(name = "CALCHOMODE")
	public String getCalChoMode() {
		return this.calChoMode;
	}

	/**
	 * 属性计算取舍方法的setter方法
	 */
	public void setCalChoMode(String calChoMode) {
		this.calChoMode = calChoMode;
	}

	/**
	 * 属性风险保额倍数的getter方法
	 */

	@Column(name = "RISKAMNTMULT")
	public BigDecimal getRiskAmntMult() {
		return this.riskAmntMult;
	}

	/**
	 * 属性风险保额倍数的setter方法
	 */
	public void setRiskAmntMult(BigDecimal riskAmntMult) {
		this.riskAmntMult = riskAmntMult;
	}

	/**
	 * 属性保险期限标志的getter方法
	 */

	@Column(name = "INSUPERIODFLAG")
	public String getInsuPeriodFlag() {
		return this.insuPeriodFlag;
	}

	/**
	 * 属性保险期限标志的setter方法
	 */
	public void setInsuPeriodFlag(String insuPeriodFlag) {
		this.insuPeriodFlag = insuPeriodFlag;
	}

	/**
	 * 属性保险期间上限的getter方法
	 */

	@Column(name = "MAXENDPERIOD")
	public BigDecimal getMaxEndPeriod() {
		return this.maxEndPeriod;
	}

	/**
	 * 属性保险期间上限的setter方法
	 */
	public void setMaxEndPeriod(BigDecimal maxEndPeriod) {
		this.maxEndPeriod = maxEndPeriod;
	}

	/**
	 * 属性满期截至年龄的getter方法
	 */

	@Column(name = "AGELMT")
	public BigDecimal getAgeLmt() {
		return this.ageLmt;
	}

	/**
	 * 属性满期截至年龄的setter方法
	 */
	public void setAgeLmt(BigDecimal ageLmt) {
		this.ageLmt = ageLmt;
	}

	/**
	 * 属性签单日算法的getter方法
	 */

	@Column(name = "SIGNDATECALMODE")
	public BigDecimal getSignDateCalMode() {
		return this.signDateCalMode;
	}

	/**
	 * 属性签单日算法的setter方法
	 */
	public void setSignDateCalMode(BigDecimal signDateCalMode) {
		this.signDateCalMode = signDateCalMode;
	}

	/**
	 * 属性协议险标记的getter方法
	 */

	@Column(name = "PROTOCOLFLAG")
	public String getProtocolFlag() {
		return this.protocolFlag;
	}

	/**
	 * 属性协议险标记的setter方法
	 */
	public void setProtocolFlag(String protocolFlag) {
		this.protocolFlag = protocolFlag;
	}

	/**
	 * 属性协议险给付金改变标记的getter方法
	 */

	@Column(name = "GETCHGFLAG")
	public String getGetChgFlag() {
		return this.getChgFlag;
	}

	/**
	 * 属性协议险给付金改变标记的setter方法
	 */
	public void setGetChgFlag(String getChgFlag) {
		this.getChgFlag = getChgFlag;
	}

	/**
	 * 属性协议缴费标记的getter方法
	 */

	@Column(name = "PROTOCOLPAYFLAG")
	public String getProtocolPayFlag() {
		return this.protocolPayFlag;
	}

	/**
	 * 属性协议缴费标记的setter方法
	 */
	public void setProtocolPayFlag(String protocolPayFlag) {
		this.protocolPayFlag = protocolPayFlag;
	}

	/**
	 * 属性保障计划标记的getter方法
	 */

	@Column(name = "ENSUPLANFLAG")
	public String getEnsuPlanFlag() {
		return this.ensuPlanFlag;
	}

	/**
	 * 属性保障计划标记的setter方法
	 */
	public void setEnsuPlanFlag(String ensuPlanFlag) {
		this.ensuPlanFlag = ensuPlanFlag;
	}

	/**
	 * 属性保障计划调整标记的getter方法
	 */

	@Column(name = "ENSUPLANADJFLAG")
	public String getEnsuPlanAdjFlag() {
		return this.ensuPlanAdjFlag;
	}

	/**
	 * 属性保障计划调整标记的setter方法
	 */
	public void setEnsuPlanAdjFlag(String ensuPlanAdjFlag) {
		this.ensuPlanAdjFlag = ensuPlanAdjFlag;
	}

	/**
	 * 属性开办日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "STARTDATE")
	public Date getStartDate() {
		return this.startDate;
	}

	/**
	 * 属性开办日期的setter方法
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * 属性停办日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "ENDDATE")
	public Date getEndDate() {
		return this.endDate;
	}

	/**
	 * 属性停办日期的setter方法
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * 属性最小投保人年龄的getter方法
	 */

	@Column(name = "MINAPPNTAGE")
	public BigDecimal getMinAppntAge() {
		return this.minAppntAge;
	}

	/**
	 * 属性最小投保人年龄的setter方法
	 */
	public void setMinAppntAge(BigDecimal minAppntAge) {
		this.minAppntAge = minAppntAge;
	}

	/**
	 * 属性最大投保人年龄的getter方法
	 */

	@Column(name = "MAXAPPNTAGE")
	public BigDecimal getMaxAppntAge() {
		return this.maxAppntAge;
	}

	/**
	 * 属性最大投保人年龄的setter方法
	 */
	public void setMaxAppntAge(BigDecimal maxAppntAge) {
		this.maxAppntAge = maxAppntAge;
	}

	/**
	 * 属性最大被保人年龄的getter方法
	 */

	@Column(name = "MAXINSUREDAGE")
	public BigDecimal getMaxInsuredAge() {
		return this.maxInsuredAge;
	}

	/**
	 * 属性最大被保人年龄的setter方法
	 */
	public void setMaxInsuredAge(BigDecimal maxInsuredAge) {
		this.maxInsuredAge = maxInsuredAge;
	}

	/**
	 * 属性最小被保人年龄的getter方法
	 */

	@Column(name = "MININSUREDAGE")
	public BigDecimal getMinInsuredAge() {
		return this.minInsuredAge;
	}

	/**
	 * 属性最小被保人年龄的setter方法
	 */
	public void setMinInsuredAge(BigDecimal minInsuredAge) {
		this.minInsuredAge = minInsuredAge;
	}

	/**
	 * 属性投保使用利率的getter方法
	 */

	@Column(name = "APPINTEREST")
	public BigDecimal getAppInterest() {
		return this.appInterest;
	}

	/**
	 * 属性投保使用利率的setter方法
	 */
	public void setAppInterest(BigDecimal appInterest) {
		this.appInterest = appInterest;
	}

	/**
	 * 属性投保使用费率的getter方法
	 */

	@Column(name = "APPPREMRATE")
	public BigDecimal getAppPremRate() {
		return this.appPremRate;
	}

	/**
	 * 属性投保使用费率的setter方法
	 */
	public void setAppPremRate(BigDecimal appPremRate) {
		this.appPremRate = appPremRate;
	}

	/**
	 * 属性多被保人标记的getter方法
	 */

	@Column(name = "INSUREDFLAG")
	public String getInsuredFlag() {
		return this.insuredFlag;
	}

	/**
	 * 属性多被保人标记的setter方法
	 */
	public void setInsuredFlag(String insuredFlag) {
		this.insuredFlag = insuredFlag;
	}

	/**
	 * 属性多被保人分享标记的getter方法
	 */

	@Column(name = "SHAREFLAG")
	public String getShareFlag() {
		return this.shareFlag;
	}

	/**
	 * 属性多被保人分享标记的setter方法
	 */
	public void setShareFlag(String shareFlag) {
		this.shareFlag = shareFlag;
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
	 * 属性暂缴费标记的getter方法
	 */

	@Column(name = "TEMPPAYFLAG")
	public String getTempPayFlag() {
		return this.tempPayFlag;
	}

	/**
	 * 属性暂缴费标记的setter方法
	 */
	public void setTempPayFlag(String tempPayFlag) {
		this.tempPayFlag = tempPayFlag;
	}

	/**
	 * 属性录入缴费项标记的getter方法
	 */

	@Column(name = "INPPAYPLAN")
	public String getInpPayPlan() {
		return this.inpPayPlan;
	}

	/**
	 * 属性录入缴费项标记的setter方法
	 */
	public void setInpPayPlan(String inpPayPlan) {
		this.inpPayPlan = inpPayPlan;
	}

	/**
	 * 属性告知标记的getter方法
	 */

	@Column(name = "IMPARTFLAG")
	public String getImpartFlag() {
		return this.impartFlag;
	}

	/**
	 * 属性告知标记的setter方法
	 */
	public void setImpartFlag(String impartFlag) {
		this.impartFlag = impartFlag;
	}

	/**
	 * 属性保险经历标记的getter方法
	 */

	@Column(name = "INSUEXPEFLAG")
	public String getInsuExpeFlag() {
		return this.insuExpeFlag;
	}

	/**
	 * 属性保险经历标记的setter方法
	 */
	public void setInsuExpeFlag(String insuExpeFlag) {
		this.insuExpeFlag = insuExpeFlag;
	}

	/**
	 * 属性提供借款标记的getter方法
	 */

	@Column(name = "LOANFALG")
	public String getLoanFalg() {
		return this.loanFalg;
	}

	/**
	 * 属性提供借款标记的setter方法
	 */
	public void setLoanFalg(String loanFalg) {
		this.loanFalg = loanFalg;
	}

	/**
	 * 属性抵押标记的getter方法
	 */

	@Column(name = "MORTAGAGEFLAG")
	public String getMortagageFlag() {
		return this.mortagageFlag;
	}

	/**
	 * 属性抵押标记的setter方法
	 */
	public void setMortagageFlag(String mortagageFlag) {
		this.mortagageFlag = mortagageFlag;
	}

	/**
	 * 属性备注的getter方法
	 */

	@Column(name = "IDIFRETURNFLAG")
	public String getIdifReturnFlag() {
		return this.idifReturnFlag;
	}

	/**
	 * 属性备注的setter方法
	 */
	public void setIdifReturnFlag(String idifReturnFlag) {
		this.idifReturnFlag = idifReturnFlag;
	}

	/**
	 * 属性减额缴清标记的getter方法
	 */

	@Column(name = "CUTAMNTSTOPPAY")
	public String getCutAmntStopPay() {
		return this.cutAmntStopPay;
	}

	/**
	 * 属性减额缴清标记的setter方法
	 */
	public void setCutAmntStopPay(String cutAmntStopPay) {
		this.cutAmntStopPay = cutAmntStopPay;
	}

	/**
	 * 属性分保率的getter方法
	 */

	@Column(name = "RINSRATE")
	public BigDecimal getRinsRate() {
		return this.rinsRate;
	}

	/**
	 * 属性分保率的setter方法
	 */
	public void setRinsRate(BigDecimal rinsRate) {
		this.rinsRate = rinsRate;
	}

	/**
	 * 属性销售标记的getter方法
	 */

	@Column(name = "SALEFLAG")
	public String getSaleFlag() {
		return this.saleFlag;
	}

	/**
	 * 属性销售标记的setter方法
	 */
	public void setSaleFlag(String saleFlag) {
		this.saleFlag = saleFlag;
	}

	/**
	 * 属性磁盘文件投保标记的getter方法
	 */

	@Column(name = "FILEAPPFLAG")
	public String getFileAppFlag() {
		return this.fileAppFlag;
	}

	/**
	 * 属性磁盘文件投保标记的setter方法
	 */
	public void setFileAppFlag(String fileAppFlag) {
		this.fileAppFlag = fileAppFlag;
	}

	/**
	 * 属性管理部门的getter方法
	 */

	@Column(name = "MNGCOM")
	public String getMngCom() {
		return this.mngCom;
	}

	/**
	 * 属性管理部门的setter方法
	 */
	public void setMngCom(String mngCom) {
		this.mngCom = mngCom;
	}

	/**
	 * 属性自动垫缴标志的getter方法
	 */

	@Column(name = "AUTOPAYFLAG")
	public String getAutoPayFlag() {
		return this.autoPayFlag;
	}

	/**
	 * 属性自动垫缴标志的setter方法
	 */
	public void setAutoPayFlag(String autoPayFlag) {
		this.autoPayFlag = autoPayFlag;
	}

	/**
	 * 属性是否打印医院列表标记的getter方法
	 */

	@Column(name = "NEEDPRINTHOSPITAL")
	public String getNeedPrintHospital() {
		return this.needPrintHospital;
	}

	/**
	 * 属性是否打印医院列表标记的setter方法
	 */
	public void setNeedPrintHospital(String needPrintHospital) {
		this.needPrintHospital = needPrintHospital;
	}

	/**
	 * 属性是否打印伤残给付表标记的getter方法
	 */

	@Column(name = "NEEDPRINTGET")
	public String getNeedPrintGet() {
		return this.needPrintGet;
	}

	/**
	 * 属性是否打印伤残给付表标记的setter方法
	 */
	public void setNeedPrintGet(String needPrintGet) {
		this.needPrintGet = needPrintGet;
	}

	/**
	 * 属性险种分类3的getter方法
	 */

	@Column(name = "RISKTYPE3")
	public String getRiskType3() {
		return this.riskType3;
	}

	/**
	 * 属性险种分类3的setter方法
	 */
	public void setRiskType3(String riskType3) {
		this.riskType3 = riskType3;
	}

	/**
	 * 属性险种分类4的getter方法
	 */

	@Column(name = "RISKTYPE4")
	public String getRiskType4() {
		return this.riskType4;
	}

	/**
	 * 属性险种分类4的setter方法
	 */
	public void setRiskType4(String riskType4) {
		this.riskType4 = riskType4;
	}

	/**
	 * 属性险种分类5的getter方法
	 */

	@Column(name = "RISKTYPE5")
	public String getRiskType5() {
		return this.riskType5;
	}

	/**
	 * 属性险种分类5的setter方法
	 */
	public void setRiskType5(String riskType5) {
		this.riskType5 = riskType5;
	}

	/**
	 * 属性签单后不需要打印的getter方法
	 */

	@Column(name = "NOTPRINTPOL")
	public String getNotPrintPol() {
		return this.notPrintPol;
	}

	/**
	 * 属性签单后不需要打印的setter方法
	 */
	public void setNotPrintPol(String notPrintPol) {
		this.notPrintPol = notPrintPol;
	}

	/**
	 * 属性录单时是否需要设置保单送达日期的getter方法
	 */

	@Column(name = "NEEDGETPOLDATE")
	public String getNeedGetPolDate() {
		return this.needGetPolDate;
	}

	/**
	 * 属性录单时是否需要设置保单送达日期的setter方法
	 */
	public void setNeedGetPolDate(String needGetPolDate) {
		this.needGetPolDate = needGetPolDate;
	}

	/**
	 * 属性是否从暂缴费表中读取银行的账号和户名的getter方法
	 */

	@Column(name = "NEEDREREADBANK")
	public String getNeedReReadBank() {
		return this.needReReadBank;
	}

	/**
	 * 属性是否从暂缴费表中读取银行的账号和户名的setter方法
	 */
	public void setNeedReReadBank(String needReReadBank) {
		this.needReReadBank = needReReadBank;
	}

	/**
	 * 属性特殊险种标记的getter方法
	 */

	@Column(name = "SPECFLAG")
	public String getSpecFlag() {
		return this.specFlag;
	}

	/**
	 * 属性特殊险种标记的setter方法
	 */
	public void setSpecFlag(String specFlag) {
		this.specFlag = specFlag;
	}

	/**
	 * 属性利差返还标记的getter方法
	 */

	@Column(name = "INTERESTDIFFLAG")
	public String getInterestDifFlag() {
		return this.interestDifFlag;
	}

	/**
	 * 属性利差返还标记的setter方法
	 */
	public void setInterestDifFlag(String interestDifFlag) {
		this.interestDifFlag = interestDifFlag;
	}

	/**
	 * 属性险种分类6的getter方法
	 */

	@Column(name = "RISKTYPE6")
	public String getRiskType6() {
		return this.riskType6;
	}

	/**
	 * 属性险种分类6的setter方法
	 */
	public void setRiskType6(String riskType6) {
		this.riskType6 = riskType6;
	}

	/**
	 * 属性险种分类7的getter方法
	 */

	@Column(name = "RISKTYPE7")
	public String getRiskType7() {
		return this.riskType7;
	}

	/**
	 * 属性险种分类7的setter方法
	 */
	public void setRiskType7(String riskType7) {
		this.riskType7 = riskType7;
	}

	/**
	 * 属性险种分类8的getter方法
	 */

	@Column(name = "RISKTYPE8")
	public String getRiskType8() {
		return this.riskType8;
	}

	/**
	 * 属性险种分类8的setter方法
	 */
	public void setRiskType8(String riskType8) {
		this.riskType8 = riskType8;
	}

	/**
	 * 属性险种分类9的getter方法
	 */

	@Column(name = "RISKTYPE9")
	public String getRiskType9() {
		return this.riskType9;
	}

	/**
	 * 属性险种分类9的setter方法
	 */
	public void setRiskType9(String riskType9) {
		this.riskType9 = riskType9;
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
	 * 属性Standbyflag1的getter方法
	 */

	@Column(name = "STANDBYFLAG1")
	public String getStandbyflag1() {
		return this.standbyflag1;
	}

	/**
	 * 属性Standbyflag1的setter方法
	 */
	public void setStandbyflag1(String standbyflag1) {
		this.standbyflag1 = standbyflag1;
	}

	/**
	 * 属性Standbyflag2的getter方法
	 */

	@Column(name = "STANDBYFLAG2")
	public String getStandbyflag2() {
		return this.standbyflag2;
	}

	/**
	 * 属性Standbyflag2的setter方法
	 */
	public void setStandbyflag2(String standbyflag2) {
		this.standbyflag2 = standbyflag2;
	}

	/**
	 * 属性Standbyflag3的getter方法
	 */

	@Column(name = "STANDBYFLAG3")
	public BigDecimal getStandbyflag3() {
		return this.standbyflag3;
	}

	/**
	 * 属性Standbyflag3的setter方法
	 */
	public void setStandbyflag3(BigDecimal standbyflag3) {
		this.standbyflag3 = standbyflag3;
	}

	/**
	 * 属性Standbyflag4的getter方法
	 */

	@Column(name = "STANDBYFLAG4")
	public BigDecimal getStandbyflag4() {
		return this.standbyflag4;
	}

	/**
	 * 属性Standbyflag4的setter方法
	 */
	public void setStandbyflag4(BigDecimal standbyflag4) {
		this.standbyflag4 = standbyflag4;
	}

	/**
	 * 属性Standbyflag5的getter方法
	 */

	@Column(name = "STANDBYFLAG5")
	public BigDecimal getStandbyflag5() {
		return this.standbyflag5;
	}

	/**
	 * 属性Standbyflag5的setter方法
	 */
	public void setStandbyflag5(BigDecimal standbyflag5) {
		this.standbyflag5 = standbyflag5;
	}

	/**
	 * 属性Standbyflag6的getter方法
	 */

	@Column(name = "STANDBYFLAG6")
	public BigDecimal getStandbyflag6() {
		return this.standbyflag6;
	}

	/**
	 * 属性Standbyflag6的setter方法
	 */
	public void setStandbyflag6(BigDecimal standbyflag6) {
		this.standbyflag6 = standbyflag6;
	}
	/**
	 * 根据属性名获取值
	 * @param fieldType
	 * @return
	 */
	public String getFieldValue(String fieldType){
		try {
			if(null == BeanUtils.getProperty(this, fieldType)){
				return StringUtils.EMPTY;
			}else{				
				return BeanUtils.getProperty(this, fieldType).toString();
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return StringUtils.EMPTY;
	}
}
