package ins.product.model;

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
 * POJO类PDLMDutyPay
 */
@Entity
@Table(name = "PD_LMDUTYPAY")
public class PDLMDutyPay implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性缴费编码 */
	private String payPlanCode;

	/** 属性责任代码 */
	private String dutyCode;

	/** 属性佣金计算编码 */
	private String calCode;

	/** 属性缴费名称 */
	private String payPlanName;

	/** 属性算法模板类型 */
	private String type;

	/** 属性交费间隔 */
	private BigDecimal payIntv;

	/** 属性缴费终止期间单位 */
	private String payEndYearFlag;

	/** 属性缴费终止期间 */
	private BigDecimal payEndYear;

	/** 属性缴费终止日期计算参照 */
	private String payEndDateCalRef;

	/** 属性缴费终止日期计算方式 */
	private String payEndDateCalMode;

	/** 属性默认值 */
	private BigDecimal defaultVal;

	/** 属性反算算法 */
	private String cnterCalCode;

	/** 属性其他算法 */
	private String othCalCode;

	/** 属性保证利率 */
	private BigDecimal rate;

	/** 属性最低限额 */
	private BigDecimal minPay;

	/** 属性保证收益率 */
	private BigDecimal assuYield;

	/** 属性提取管理费比例 */
	private BigDecimal feeRate;

	/** 属性缴至日期计算方法 */
	private String payToDateCalMode;

	/** 属性催缴标记 */
	private String urgePayFlag;

	/** 属性部分缴费标记 */
	private String payLackFlag;

	/** 属性挂帐标记 */
	private String payOverFlag;

	/** 属性挂帐处理 */
	private String payOverDeal;

	/** 属性免交标记 */
	private String avoidPayFlag;

	/** 属性缴费宽限期 */
	private BigDecimal gracePeriod;

	/** 属性公用标记 */
	private String pubFlag;

	/** 属性是否允许零值标记 */
	private String zeroFlag;

	/** 属性是否和账户相关 */
	private String needAcc;

	/** 属性交费目的分类 */
	private String payAimClass;

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
	 * 类PDLMDutyPay的默认构造方法
	 */
	public PDLMDutyPay() {
	}

	/**
	 * 属性缴费编码的getter方法
	 */
	@Id
	@Column(name = "PAYPLANCODE")
	public String getPayPlanCode() {
		return this.payPlanCode;
	}

	/**
	 * 属性缴费编码的setter方法
	 */
	public void setPayPlanCode(String payPlanCode) {
		this.payPlanCode = payPlanCode;
	}

	/**
	 * 属性责任代码的getter方法
	 */

	@Column(name = "DUTYCODE")
	public String getDutyCode() {
		return this.dutyCode;
	}

	/**
	 * 属性责任代码的setter方法
	 */
	public void setDutyCode(String dutyCode) {
		this.dutyCode = dutyCode;
	}

	/**
	 * 属性佣金计算编码的getter方法
	 */

	@Column(name = "CALCODE")
	public String getCalCode() {
		return this.calCode;
	}

	/**
	 * 属性佣金计算编码的setter方法
	 */
	public void setCalCode(String calCode) {
		this.calCode = calCode;
	}

	/**
	 * 属性缴费名称的getter方法
	 */

	@Column(name = "PAYPLANNAME")
	public String getPayPlanName() {
		return this.payPlanName;
	}

	/**
	 * 属性缴费名称的setter方法
	 */
	public void setPayPlanName(String payPlanName) {
		this.payPlanName = payPlanName;
	}

	/**
	 * 属性算法模板类型的getter方法
	 */

	@Column(name = "TYPE")
	public String getType() {
		return this.type;
	}

	/**
	 * 属性算法模板类型的setter方法
	 */
	public void setType(String type) {
		this.type = type;
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
	 * 属性缴费终止期间单位的getter方法
	 */

	@Column(name = "PAYENDYEARFLAG")
	public String getPayEndYearFlag() {
		return this.payEndYearFlag;
	}

	/**
	 * 属性缴费终止期间单位的setter方法
	 */
	public void setPayEndYearFlag(String payEndYearFlag) {
		this.payEndYearFlag = payEndYearFlag;
	}

	/**
	 * 属性缴费终止期间的getter方法
	 */

	@Column(name = "PAYENDYEAR")
	public BigDecimal getPayEndYear() {
		return this.payEndYear;
	}

	/**
	 * 属性缴费终止期间的setter方法
	 */
	public void setPayEndYear(BigDecimal payEndYear) {
		this.payEndYear = payEndYear;
	}

	/**
	 * 属性缴费终止日期计算参照的getter方法
	 */

	@Column(name = "PAYENDDATECALREF")
	public String getPayEndDateCalRef() {
		return this.payEndDateCalRef;
	}

	/**
	 * 属性缴费终止日期计算参照的setter方法
	 */
	public void setPayEndDateCalRef(String payEndDateCalRef) {
		this.payEndDateCalRef = payEndDateCalRef;
	}

	/**
	 * 属性缴费终止日期计算方式的getter方法
	 */

	@Column(name = "PAYENDDATECALMODE")
	public String getPayEndDateCalMode() {
		return this.payEndDateCalMode;
	}

	/**
	 * 属性缴费终止日期计算方式的setter方法
	 */
	public void setPayEndDateCalMode(String payEndDateCalMode) {
		this.payEndDateCalMode = payEndDateCalMode;
	}

	/**
	 * 属性默认值的getter方法
	 */

	@Column(name = "DEFAULTVAL")
	public BigDecimal getDefaultVal() {
		return this.defaultVal;
	}

	/**
	 * 属性默认值的setter方法
	 */
	public void setDefaultVal(BigDecimal defaultVal) {
		this.defaultVal = defaultVal;
	}

	/**
	 * 属性反算算法的getter方法
	 */

	@Column(name = "CNTERCALCODE")
	public String getCnterCalCode() {
		return this.cnterCalCode;
	}

	/**
	 * 属性反算算法的setter方法
	 */
	public void setCnterCalCode(String cnterCalCode) {
		this.cnterCalCode = cnterCalCode;
	}

	/**
	 * 属性其他算法的getter方法
	 */

	@Column(name = "OTHCALCODE")
	public String getOthCalCode() {
		return this.othCalCode;
	}

	/**
	 * 属性其他算法的setter方法
	 */
	public void setOthCalCode(String othCalCode) {
		this.othCalCode = othCalCode;
	}

	/**
	 * 属性保证利率的getter方法
	 */

	@Column(name = "RATE")
	public BigDecimal getRate() {
		return this.rate;
	}

	/**
	 * 属性保证利率的setter方法
	 */
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	/**
	 * 属性最低限额的getter方法
	 */

	@Column(name = "MINPAY")
	public BigDecimal getMinPay() {
		return this.minPay;
	}

	/**
	 * 属性最低限额的setter方法
	 */
	public void setMinPay(BigDecimal minPay) {
		this.minPay = minPay;
	}

	/**
	 * 属性保证收益率的getter方法
	 */

	@Column(name = "ASSUYIELD")
	public BigDecimal getAssuYield() {
		return this.assuYield;
	}

	/**
	 * 属性保证收益率的setter方法
	 */
	public void setAssuYield(BigDecimal assuYield) {
		this.assuYield = assuYield;
	}

	/**
	 * 属性提取管理费比例的getter方法
	 */

	@Column(name = "FEERATE")
	public BigDecimal getFeeRate() {
		return this.feeRate;
	}

	/**
	 * 属性提取管理费比例的setter方法
	 */
	public void setFeeRate(BigDecimal feeRate) {
		this.feeRate = feeRate;
	}

	/**
	 * 属性缴至日期计算方法的getter方法
	 */

	@Column(name = "PAYTODATECALMODE")
	public String getPayToDateCalMode() {
		return this.payToDateCalMode;
	}

	/**
	 * 属性缴至日期计算方法的setter方法
	 */
	public void setPayToDateCalMode(String payToDateCalMode) {
		this.payToDateCalMode = payToDateCalMode;
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
	 * 属性部分缴费标记的getter方法
	 */

	@Column(name = "PAYLACKFLAG")
	public String getPayLackFlag() {
		return this.payLackFlag;
	}

	/**
	 * 属性部分缴费标记的setter方法
	 */
	public void setPayLackFlag(String payLackFlag) {
		this.payLackFlag = payLackFlag;
	}

	/**
	 * 属性挂帐标记的getter方法
	 */

	@Column(name = "PAYOVERFLAG")
	public String getPayOverFlag() {
		return this.payOverFlag;
	}

	/**
	 * 属性挂帐标记的setter方法
	 */
	public void setPayOverFlag(String payOverFlag) {
		this.payOverFlag = payOverFlag;
	}

	/**
	 * 属性挂帐处理的getter方法
	 */

	@Column(name = "PAYOVERDEAL")
	public String getPayOverDeal() {
		return this.payOverDeal;
	}

	/**
	 * 属性挂帐处理的setter方法
	 */
	public void setPayOverDeal(String payOverDeal) {
		this.payOverDeal = payOverDeal;
	}

	/**
	 * 属性免交标记的getter方法
	 */

	@Column(name = "AVOIDPAYFLAG")
	public String getAvoidPayFlag() {
		return this.avoidPayFlag;
	}

	/**
	 * 属性免交标记的setter方法
	 */
	public void setAvoidPayFlag(String avoidPayFlag) {
		this.avoidPayFlag = avoidPayFlag;
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
	 * 属性公用标记的getter方法
	 */

	@Column(name = "PUBFLAG")
	public String getPubFlag() {
		return this.pubFlag;
	}

	/**
	 * 属性公用标记的setter方法
	 */
	public void setPubFlag(String pubFlag) {
		this.pubFlag = pubFlag;
	}

	/**
	 * 属性是否允许零值标记的getter方法
	 */

	@Column(name = "ZEROFLAG")
	public String getZeroFlag() {
		return this.zeroFlag;
	}

	/**
	 * 属性是否允许零值标记的setter方法
	 */
	public void setZeroFlag(String zeroFlag) {
		this.zeroFlag = zeroFlag;
	}

	/**
	 * 属性是否和账户相关的getter方法
	 */

	@Column(name = "NEEDACC")
	public String getNeedAcc() {
		return this.needAcc;
	}

	/**
	 * 属性是否和账户相关的setter方法
	 */
	public void setNeedAcc(String needAcc) {
		this.needAcc = needAcc;
	}

	/**
	 * 属性交费目的分类的getter方法
	 */

	@Column(name = "PAYAIMCLASS")
	public String getPayAimClass() {
		return this.payAimClass;
	}

	/**
	 * 属性交费目的分类的setter方法
	 */
	public void setPayAimClass(String payAimClass) {
		this.payAimClass = payAimClass;
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
