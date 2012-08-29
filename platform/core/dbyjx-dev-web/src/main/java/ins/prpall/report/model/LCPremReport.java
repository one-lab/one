package ins.prpall.report.model;

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
 * POJO类LCPremReport
 */
@Entity
@Table(name = "LCPREMREPORT")
public class LCPremReport implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性序号 */
	private LCPremReportId id;

	/** 属性呈报申请人 */
	private String repOperator;

	/** 属性呈报申请日期 */
	private Date repApplyDate;

	/** 属性集体合同号码 */
	private String grpContNo;

	/** 属性合同号码 */
	private String contNo;

	/** 属性交费计划类型 */
	private String payPlanType;

	/** 属性投保人类型 */
	private String appntType;

	/** 属性投保人客户号码 */
	private String appntNo;

	/** 属性催缴标记 */
	private String urgePayFlag;

	/** 属性是否和账户相关 */
	private String needAcc;

	/** 属性约定分期交费次数 */
	private BigDecimal payTimes;

	/** 属性保证利率 */
	private BigDecimal rate;

	/** 属性起交日期 */
	private Date payStartDate;

	/** 属性终交日期 */
	private Date payEndDate;

	/** 属性交至日期 */
	private Date paytoDate;

	/** 属性交费间隔 */
	private BigDecimal payIntv;

	/** 属性标准保费 */
	private BigDecimal standPrem;

	/** 属性保费 */
	private BigDecimal prem;

	/** 属性累计保费 */
	private BigDecimal sumPrem;

	/** 属性额外风险评分 */
	private BigDecimal suppRiskScore;

	/** 属性免交标志 */
	private String freeFlag;

	/** 属性免交比率 */
	private Double freeRate;

	/** 属性免交起期 */
	private Date freeStartDate;

	/** 属性免交止期 */
	private Date freeEndDate;

	/** 属性任务当前状态 */
	private String state;

	/** 属性管理机构 */
	private String manageCom;

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

	/** 属性加费指向标记 */
	private String addFeeDirect;

	/** 属性第二被保人加费评点 */
	private BigDecimal secInsuAddPoint;

	/**
	 * 类LCPremReport的默认构造方法
	 */
	public LCPremReport() {
	}

	/**
	 * 属性序号的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "repNo", column = @Column(name = "REPNO")),
			@AttributeOverride(name = "polNo", column = @Column(name = "POLNO")),
			@AttributeOverride(name = "dutyCode", column = @Column(name = "DUTYCODE")),
			@AttributeOverride(name = "payPlanCode", column = @Column(name = "PAYPLANCODE")) })
	public LCPremReportId getId() {
		return this.id;
	}

	/**
	 * 属性序号的setter方法
	 */
	public void setId(LCPremReportId id) {
		this.id = id;
	}

	/**
	 * 属性呈报申请人的getter方法
	 */

	@Column(name = "REPOPERATOR")
	public String getRepOperator() {
		return this.repOperator;
	}

	/**
	 * 属性呈报申请人的setter方法
	 */
	public void setRepOperator(String repOperator) {
		this.repOperator = repOperator;
	}

	/**
	 * 属性呈报申请日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "REPAPPLYDATE")
	public Date getRepApplyDate() {
		return this.repApplyDate;
	}

	/**
	 * 属性呈报申请日期的setter方法
	 */
	public void setRepApplyDate(Date repApplyDate) {
		this.repApplyDate = repApplyDate;
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
	 * 属性交费计划类型的getter方法
	 */

	@Column(name = "PAYPLANTYPE")
	public String getPayPlanType() {
		return this.payPlanType;
	}

	/**
	 * 属性交费计划类型的setter方法
	 */
	public void setPayPlanType(String payPlanType) {
		this.payPlanType = payPlanType;
	}

	/**
	 * 属性投保人类型的getter方法
	 */

	@Column(name = "APPNTTYPE")
	public String getAppntType() {
		return this.appntType;
	}

	/**
	 * 属性投保人类型的setter方法
	 */
	public void setAppntType(String appntType) {
		this.appntType = appntType;
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
	 * 属性约定分期交费次数的getter方法
	 */

	@Column(name = "PAYTIMES")
	public BigDecimal getPayTimes() {
		return this.payTimes;
	}

	/**
	 * 属性约定分期交费次数的setter方法
	 */
	public void setPayTimes(BigDecimal payTimes) {
		this.payTimes = payTimes;
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
	 * 属性起交日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "PAYSTARTDATE")
	public Date getPayStartDate() {
		return this.payStartDate;
	}

	/**
	 * 属性起交日期的setter方法
	 */
	public void setPayStartDate(Date payStartDate) {
		this.payStartDate = payStartDate;
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
	 * 属性额外风险评分的getter方法
	 */

	@Column(name = "SUPPRISKSCORE")
	public BigDecimal getSuppRiskScore() {
		return this.suppRiskScore;
	}

	/**
	 * 属性额外风险评分的setter方法
	 */
	public void setSuppRiskScore(BigDecimal suppRiskScore) {
		this.suppRiskScore = suppRiskScore;
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
	 * 属性加费指向标记的getter方法
	 */

	@Column(name = "ADDFEEDIRECT")
	public String getAddFeeDirect() {
		return this.addFeeDirect;
	}

	/**
	 * 属性加费指向标记的setter方法
	 */
	public void setAddFeeDirect(String addFeeDirect) {
		this.addFeeDirect = addFeeDirect;
	}

	/**
	 * 属性第二被保人加费评点的getter方法
	 */

	@Column(name = "SECINSUADDPOINT")
	public BigDecimal getSecInsuAddPoint() {
		return this.secInsuAddPoint;
	}

	/**
	 * 属性第二被保人加费评点的setter方法
	 */
	public void setSecInsuAddPoint(BigDecimal secInsuAddPoint) {
		this.secInsuAddPoint = secInsuAddPoint;
	}

}
