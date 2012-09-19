package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

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

/**
 * POJO类PDLMRiskPay
 */
@Entity
@Table(name = "PD_LMRISKPAY")
public class PDLMRiskPay implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性险种代码 */
	private String riskCode;

	/** 属性险种定义 */
	private PDLMRisk PDLMRisk;

	/** 属性险种版本 */
	private String riskVer;

	/** 属性险种名称 */
	private String riskName;

	/** 属性催缴标记 */
	private String urgePayFlag;

	/** 属性手续费类型 */
	private String chargeType;

	/** 属性分解缴费间隔 */
	private String cutPayIntv;

	/** 属性免交涉及加费 */
	private String payAvoidType;

	/** 属性手续费与保费关系 */
	private String chargeAndPrem;

	/** 属性结算日类型 */
	private String balaDateType;

	/** 属性免交标记 */
	private String payAvoidFlag;

	/** 属性缴费与复效关系 */
	private String payAndRevEffe;

	/** 属性缴费宽限期 */
	private BigDecimal gracePeriod;

	/** 属性宽限期单位 */
	private String gracePeriodUnit;

	/** 属性宽限日期计算方式 */
	private String graceDateCalMode;

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
	 * 类PDLMRiskPay的默认构造方法
	 */
	public PDLMRiskPay() {
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
	 * 属性催缴标记的getter方法
	 */

	@Column(name = "URGEPAYFLAG")
	public String getUrgePayFlag() {
		return this.urgePayFlag;
	}

	/**
	 * 属性催缴标记的setter方法
	 */
	public void setUrgePayFlag(String urgePayFlag) {
		this.urgePayFlag = urgePayFlag;
	}

	/**
	 * 属性手续费类型的getter方法
	 */

	@Column(name = "CHARGETYPE")
	public String getChargeType() {
		return this.chargeType;
	}

	/**
	 * 属性手续费类型的setter方法
	 */
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	/**
	 * 属性分解缴费间隔的getter方法
	 */

	@Column(name = "CUTPAYINTV")
	public String getCutPayIntv() {
		return this.cutPayIntv;
	}

	/**
	 * 属性分解缴费间隔的setter方法
	 */
	public void setCutPayIntv(String cutPayIntv) {
		this.cutPayIntv = cutPayIntv;
	}

	/**
	 * 属性免交涉及加费的getter方法
	 */

	@Column(name = "PAYAVOIDTYPE")
	public String getPayAvoidType() {
		return this.payAvoidType;
	}

	/**
	 * 属性免交涉及加费的setter方法
	 */
	public void setPayAvoidType(String payAvoidType) {
		this.payAvoidType = payAvoidType;
	}

	/**
	 * 属性手续费与保费关系的getter方法
	 */

	@Column(name = "CHARGEANDPREM")
	public String getChargeAndPrem() {
		return this.chargeAndPrem;
	}

	/**
	 * 属性手续费与保费关系的setter方法
	 */
	public void setChargeAndPrem(String chargeAndPrem) {
		this.chargeAndPrem = chargeAndPrem;
	}

	/**
	 * 属性结算日类型的getter方法
	 */

	@Column(name = "BALADATETYPE")
	public String getBalaDateType() {
		return this.balaDateType;
	}

	/**
	 * 属性结算日类型的setter方法
	 */
	public void setBalaDateType(String balaDateType) {
		this.balaDateType = balaDateType;
	}

	/**
	 * 属性免交标记的getter方法
	 */

	@Column(name = "PAYAVOIDFLAG")
	public String getPayAvoidFlag() {
		return this.payAvoidFlag;
	}

	/**
	 * 属性免交标记的setter方法
	 */
	public void setPayAvoidFlag(String payAvoidFlag) {
		this.payAvoidFlag = payAvoidFlag;
	}

	/**
	 * 属性缴费与复效关系的getter方法
	 */

	@Column(name = "PAYANDREVEFFE")
	public String getPayAndRevEffe() {
		return this.payAndRevEffe;
	}

	/**
	 * 属性缴费与复效关系的setter方法
	 */
	public void setPayAndRevEffe(String payAndRevEffe) {
		this.payAndRevEffe = payAndRevEffe;
	}

	/**
	 * 属性缴费宽限期的getter方法
	 */

	@Column(name = "GRACEPERIOD")
	public BigDecimal getGracePeriod() {
		return this.gracePeriod;
	}

	/**
	 * 属性缴费宽限期的setter方法
	 */
	public void setGracePeriod(BigDecimal gracePeriod) {
		this.gracePeriod = gracePeriod;
	}

	/**
	 * 属性宽限期单位的getter方法
	 */

	@Column(name = "GRACEPERIODUNIT")
	public String getGracePeriodUnit() {
		return this.gracePeriodUnit;
	}

	/**
	 * 属性宽限期单位的setter方法
	 */
	public void setGracePeriodUnit(String gracePeriodUnit) {
		this.gracePeriodUnit = gracePeriodUnit;
	}

	/**
	 * 属性宽限日期计算方式的getter方法
	 */

	@Column(name = "GRACEDATECALMODE")
	public String getGraceDateCalMode() {
		return this.graceDateCalMode;
	}

	/**
	 * 属性宽限日期计算方式的setter方法
	 */
	public void setGraceDateCalMode(String graceDateCalMode) {
		this.graceDateCalMode = graceDateCalMode;
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

}
