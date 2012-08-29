package ins.product.model;

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
 * POJO类PDLMRiskFee
 */
@Entity
@Table(name = "PD_LMRISKFEE")
public class PDLMRiskFee implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性序号 */
	private PDLMRiskFeeId id;

	/** 属性账单项目名称 */
	private String feeName;

	/** 属性管理费说明 */
	private String feeNoti;

	/** 属性关系说明 */
	private String payInsuAccName;

	/** 属性管理费分类 */
	private String feeKind;

	/** 属性费用项目分类 */
	private String feeItemType;

	/** 属性费用收取位置 */
	private String feeTakePlace;

	/** 属性计算类型 */
	private String feeCalModeType;

	/** 属性理赔费用控制计算SQL */
	private String feeCalCode;

	/** 属性固定值 */
	private BigDecimal feeValue;

	/** 属性比较值 */
	private BigDecimal compareValue;

	/** 属性扣除管理费周期 */
	private String feePeriod;

	/** 属性扣除管理费最大次数 */
	private BigDecimal maxTime;

	/** 属性缺省标记 */
	private String defaultFlag;

	/** 属性扣除管理费起始时间 */
	private Date feeStartDate;

	/** 属性管理费顺序 */
	private BigDecimal feeNum;

	/** 属性计价基数类型 */
	private String feeBaseType;

	/** 属性后续处理类名 */
	private String interfaceClassName;

	/** 属性收取类型 */
	private String feeType;

	/** 属性收取时点 */
	private String periodType;

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
	 * 类PDLMRiskFee的默认构造方法
	 */
	public PDLMRiskFee() {
	}

	/**
	 * 属性序号的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "feecode", column = @Column(name = "FEECODE")),
			@AttributeOverride(name = "payPlanCode", column = @Column(name = "PAYPLANCODE")),
			@AttributeOverride(name = "insuAccNo", column = @Column(name = "INSUACCNO")),
			@AttributeOverride(name = "feeCalMode", column = @Column(name = "FEECALMODE")) })
	public PDLMRiskFeeId getId() {
		return this.id;
	}

	/**
	 * 属性序号的setter方法
	 */
	public void setId(PDLMRiskFeeId id) {
		this.id = id;
	}

	/**
	 * 属性账单项目名称的getter方法
	 */

	@Column(name = "FEENAME")
	public String getFeeName() {
		return this.feeName;
	}

	/**
	 * 属性账单项目名称的setter方法
	 */
	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}

	/**
	 * 属性管理费说明的getter方法
	 */

	@Column(name = "FEENOTI")
	public String getFeeNoti() {
		return this.feeNoti;
	}

	/**
	 * 属性管理费说明的setter方法
	 */
	public void setFeeNoti(String feeNoti) {
		this.feeNoti = feeNoti;
	}

	/**
	 * 属性关系说明的getter方法
	 */

	@Column(name = "PAYINSUACCNAME")
	public String getPayInsuAccName() {
		return this.payInsuAccName;
	}

	/**
	 * 属性关系说明的setter方法
	 */
	public void setPayInsuAccName(String payInsuAccName) {
		this.payInsuAccName = payInsuAccName;
	}

	/**
	 * 属性管理费分类的getter方法
	 */

	@Column(name = "FEEKIND")
	public String getFeeKind() {
		return this.feeKind;
	}

	/**
	 * 属性管理费分类的setter方法
	 */
	public void setFeeKind(String feeKind) {
		this.feeKind = feeKind;
	}

	/**
	 * 属性费用项目分类的getter方法
	 */

	@Column(name = "FEEITEMTYPE")
	public String getFeeItemType() {
		return this.feeItemType;
	}

	/**
	 * 属性费用项目分类的setter方法
	 */
	public void setFeeItemType(String feeItemType) {
		this.feeItemType = feeItemType;
	}

	/**
	 * 属性费用收取位置的getter方法
	 */

	@Column(name = "FEETAKEPLACE")
	public String getFeeTakePlace() {
		return this.feeTakePlace;
	}

	/**
	 * 属性费用收取位置的setter方法
	 */
	public void setFeeTakePlace(String feeTakePlace) {
		this.feeTakePlace = feeTakePlace;
	}

	/**
	 * 属性计算类型的getter方法
	 */

	@Column(name = "FEECALMODETYPE")
	public String getFeeCalModeType() {
		return this.feeCalModeType;
	}

	/**
	 * 属性计算类型的setter方法
	 */
	public void setFeeCalModeType(String feeCalModeType) {
		this.feeCalModeType = feeCalModeType;
	}

	/**
	 * 属性理赔费用控制计算SQL的getter方法
	 */

	@Column(name = "FEECALCODE")
	public String getFeeCalCode() {
		return this.feeCalCode;
	}

	/**
	 * 属性理赔费用控制计算SQL的setter方法
	 */
	public void setFeeCalCode(String feeCalCode) {
		this.feeCalCode = feeCalCode;
	}

	/**
	 * 属性固定值的getter方法
	 */

	@Column(name = "FEEVALUE")
	public BigDecimal getFeeValue() {
		return this.feeValue;
	}

	/**
	 * 属性固定值的setter方法
	 */
	public void setFeeValue(BigDecimal feeValue) {
		this.feeValue = feeValue;
	}

	/**
	 * 属性比较值的getter方法
	 */

	@Column(name = "COMPAREVALUE")
	public BigDecimal getCompareValue() {
		return this.compareValue;
	}

	/**
	 * 属性比较值的setter方法
	 */
	public void setCompareValue(BigDecimal compareValue) {
		this.compareValue = compareValue;
	}

	/**
	 * 属性扣除管理费周期的getter方法
	 */

	@Column(name = "FEEPERIOD")
	public String getFeePeriod() {
		return this.feePeriod;
	}

	/**
	 * 属性扣除管理费周期的setter方法
	 */
	public void setFeePeriod(String feePeriod) {
		this.feePeriod = feePeriod;
	}

	/**
	 * 属性扣除管理费最大次数的getter方法
	 */

	@Column(name = "MAXTIME")
	public BigDecimal getMaxTime() {
		return this.maxTime;
	}

	/**
	 * 属性扣除管理费最大次数的setter方法
	 */
	public void setMaxTime(BigDecimal maxTime) {
		this.maxTime = maxTime;
	}

	/**
	 * 属性缺省标记的getter方法
	 */

	@Column(name = "DEFAULTFLAG")
	public String getDefaultFlag() {
		return this.defaultFlag;
	}

	/**
	 * 属性缺省标记的setter方法
	 */
	public void setDefaultFlag(String defaultFlag) {
		this.defaultFlag = defaultFlag;
	}

	/**
	 * 属性扣除管理费起始时间的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "FEESTARTDATE")
	public Date getFeeStartDate() {
		return this.feeStartDate;
	}

	/**
	 * 属性扣除管理费起始时间的setter方法
	 */
	public void setFeeStartDate(Date feeStartDate) {
		this.feeStartDate = feeStartDate;
	}

	/**
	 * 属性管理费顺序的getter方法
	 */

	@Column(name = "FEENUM")
	public BigDecimal getFeeNum() {
		return this.feeNum;
	}

	/**
	 * 属性管理费顺序的setter方法
	 */
	public void setFeeNum(BigDecimal feeNum) {
		this.feeNum = feeNum;
	}

	/**
	 * 属性计价基数类型的getter方法
	 */

	@Column(name = "FEEBASETYPE")
	public String getFeeBaseType() {
		return this.feeBaseType;
	}

	/**
	 * 属性计价基数类型的setter方法
	 */
	public void setFeeBaseType(String feeBaseType) {
		this.feeBaseType = feeBaseType;
	}

	/**
	 * 属性后续处理类名的getter方法
	 */

	@Column(name = "INTERFACECLASSNAME")
	public String getInterfaceClassName() {
		return this.interfaceClassName;
	}

	/**
	 * 属性后续处理类名的setter方法
	 */
	public void setInterfaceClassName(String interfaceClassName) {
		this.interfaceClassName = interfaceClassName;
	}

	/**
	 * 属性收取类型的getter方法
	 */

	@Column(name = "FEETYPE")
	public String getFeeType() {
		return this.feeType;
	}

	/**
	 * 属性收取类型的setter方法
	 */
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	/**
	 * 属性收取时点的getter方法
	 */

	@Column(name = "PERIODTYPE")
	public String getPeriodType() {
		return this.periodType;
	}

	/**
	 * 属性收取时点的setter方法
	 */
	public void setPeriodType(String periodType) {
		this.periodType = periodType;
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
