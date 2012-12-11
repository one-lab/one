package ins.claim.report.model;

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
 * POJO类LLReportEstimaTrial
 */
@Entity
@Table(name = "LLREPORTESTIMATRIAL")
public class LLReportEstimaTrial implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性id */
	private LLReportEstimaTrialId id;

	/** 属性合同号码 */
	private String contNo;

	/** 属性险类编码 */
	private String kindCode;

	/** 属性险种编码 */
	private String riskCode;

	/** 属性责任编码 */
	private String dutyCode;

	/** 属性预估试算金额 */
	private BigDecimal beAdjAmount;

	/** 属性管理机构 */
	private String mngCom;

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

	/** 属性备注 */
	private String remark;

	/**
	 * 类LLReportEstimaTrial的默认构造方法
	 */
	public LLReportEstimaTrial() {
	}

	/**
	 * 属性id的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "caseNo", column = @Column(name = "CASENO")),
			@AttributeOverride(name = "customerNo", column = @Column(name = "CUSTOMERNO")),
			@AttributeOverride(name = "reasonCode", column = @Column(name = "REASONCODE")),
			@AttributeOverride(name = "giveType", column = @Column(name = "GIVETYPE")),
			@AttributeOverride(name = "polNo", column = @Column(name = "POLNO")) })
	public LLReportEstimaTrialId getId() {
		return this.id;
	}

	/**
	 * 属性id的setter方法
	 */
	public void setId(LLReportEstimaTrialId id) {
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
	 * 属性责任编码的getter方法
	 */

	@Column(name = "DUTYCODE")
	public String getDutyCode() {
		return this.dutyCode;
	}

	/**
	 * 属性责任编码的setter方法
	 */
	public void setDutyCode(String dutyCode) {
		this.dutyCode = dutyCode;
	}

	/**
	 * 属性预估试算金额的getter方法
	 */

	@Column(name = "BEADJAMOUNT")
	public BigDecimal getBeAdjAmount() {
		return this.beAdjAmount;
	}

	/**
	 * 属性预估试算金额的setter方法
	 */
	public void setBeAdjAmount(BigDecimal beAdjAmount) {
		this.beAdjAmount = beAdjAmount;
	}

	/**
	 * 属性管理机构的getter方法
	 */

	@Column(name = "MNGCOM")
	public String getMngCom() {
		return this.mngCom;
	}

	/**
	 * 属性管理机构的setter方法
	 */
	public void setMngCom(String mngCom) {
		this.mngCom = mngCom;
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

}
