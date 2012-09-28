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
 * POJO类LCDuty
 */
@Entity
@Table(name = "LCDUTY")
public class LCDuty implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性ID */
	private LCDutyId id;

	/** 属性合同号码 */
	private String contNo;

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

	/** 属性交费间隔 */
	private BigDecimal payIntv;

	/** 属性交费年期 */
	private BigDecimal payYears;

	/** 属性保险年期 */
	private BigDecimal years;

	/** 属性浮动费率 */
	private BigDecimal floatRate;

	/** 属性首期交费日期 */
	private Date firstPayDate;

	/** 属性首期交费月数 */
	private BigDecimal firstMonth;

	/** 属性交至日期 */
	private Date paytoDate;

	/** 属性终交日期 */
	private Date payEndDate;

	/** 属性终交年龄年期标志 */
	private String payEndYearFlag;

	/** 属性终交年龄年期 */
	private BigDecimal payEndYear;

	/** 属性领取年龄年期标志 */
	private String getYearFlag;

	/** 属性领取年龄年期 */
	private BigDecimal getYear;

	/** 属性保险年龄年期标志 */
	private String insuYearFlag;

	/** 属性保险年龄年期 */
	private BigDecimal insuYear;

	/** 属性意外年龄年期标志 */
	private String acciYearFlag;

	/** 属性意外年龄年期 */
	private BigDecimal acciYear;

	/** 属性保险责任终止日期 */
	private Date endDate;

	/** 属性意外责任终止日期 */
	private Date acciEndDate;

	/** 属性免交标志 */
	private String freeFlag;

	/** 属性免交比率 */
	private Double freeRate;

	/** 属性免交起期 */
	private Date freeStartDate;

	/** 属性免交止期 */
	private Date freeEndDate;

	/** 属性起领日期 */
	private Date getStartDate;

	/** 属性起领日期计算类型 */
	private String getStartType;

	/** 属性生存金领取方式 */
	private String liveGetMode;

	/** 属性身故金领取方式 */
	private String deadGetMode;

	/** 属性红利金领取方式 */
	private String bonusGetMode;

	/** 属性社保标记 */
	private String ssFlag;

	/** 属性封顶线 */
	private BigDecimal peakLine;

	/** 属性起付限 */
	private BigDecimal getLimit;

	/** 属性赔付比例 */
	private BigDecimal getRate;

	/** 属性保费计算规则 */
	private String calRule;

	/** 属性保费算保额标志 */
	private String premToAmnt;

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

	/** 属性保单生效日期 */
	private Date cvaliDate;

	/** 属性领取间隔 */
	private BigDecimal getIntv;

	/**
	 * 类LCDuty的默认构造方法
	 */
	public LCDuty() {
	}

	/**
	 * 属性ID的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "polNo", column = @Column(name = "POLNO")),
			@AttributeOverride(name = "dutyCode", column = @Column(name = "DUTYCODE")) })
	public LCDutyId getId() {
		return this.id;
	}

	/**
	 * 属性ID的setter方法
	 */
	public void setId(LCDutyId id) {
		this.id = id;
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
	 * 属性首期交费月数的getter方法
	 */

	@Column(name = "FIRSTMONTH")
	public BigDecimal getFirstMonth() {
		return this.firstMonth;
	}

	/**
	 * 属性首期交费月数的setter方法
	 */
	public void setFirstMonth(BigDecimal firstMonth) {
		this.firstMonth = firstMonth;
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
	 * 属性免交标志的getter方法
	 */

	@Column(name = "FREEFLAG")
	public String getFreeFlag() {
		return this.freeFlag;
	}

	/**
	 * 属性免交标志的setter方法
	 */
	public void setFreeFlag(String freeFlag) {
		this.freeFlag = freeFlag;
	}

	/**
	 * 属性免交比率的getter方法
	 */

	@Column(name = "FREERATE")
	public Double getFreeRate() {
		return this.freeRate;
	}

	/**
	 * 属性免交比率的setter方法
	 */
	public void setFreeRate(Double freeRate) {
		this.freeRate = freeRate;
	}

	/**
	 * 属性免交起期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "FREESTARTDATE")
	public Date getFreeStartDate() {
		return this.freeStartDate;
	}

	/**
	 * 属性免交起期的setter方法
	 */
	public void setFreeStartDate(Date freeStartDate) {
		this.freeStartDate = freeStartDate;
	}

	/**
	 * 属性免交止期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "FREEENDDATE")
	public Date getFreeEndDate() {
		return this.freeEndDate;
	}

	/**
	 * 属性免交止期的setter方法
	 */
	public void setFreeEndDate(Date freeEndDate) {
		this.freeEndDate = freeEndDate;
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
	 * 属性保费计算规则的getter方法
	 */

	@Column(name = "CALRULE")
	public String getCalRule() {
		return this.calRule;
	}

	/**
	 * 属性保费计算规则的setter方法
	 */
	public void setCalRule(String calRule) {
		this.calRule = calRule;
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
	 * 属性领取间隔的getter方法
	 */

	@Column(name = "GETINTV")
	public BigDecimal getGetIntv() {
		return this.getIntv;
	}

	/**
	 * 属性领取间隔的setter方法
	 */
	public void setGetIntv(BigDecimal getIntv) {
		this.getIntv = getIntv;
	}

}
