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
 * POJO类LCContPlanReport
 */
@Entity
@Table(name = "LCCONTPLANREPORT")
public class LCContPlanReport implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性ID */
	private LCContPlanReportId id;

	/** 属性呈报申请人 */
	private String repOperator;

	/** 属性呈报申请日期 */
	private Date repApplyDate;

	/** 属性集体投保单号码 */
	private String proposalGrpContNo;

	/** 属性保险计划名称 */
	private String contPlanName;

	/** 属性计划规则 */
	private String planRule;

	/** 属性计划规则sql */
	private String planSql;

	/** 属性备注 */
	private String remark;

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

	/** 属性可投保人数 */
	private BigDecimal peoples3;

	/** 属性备注2 */
	private String remark2;

	/** 属性PeopleS2 */
	private BigDecimal peopleS2;

	/**
	 * 类LCContPlanReport的默认构造方法
	 */
	public LCContPlanReport() {
	}

	/**
	 * 属性ID的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "repNo", column = @Column(name = "REPNO")),
			@AttributeOverride(name = "grpContNo", column = @Column(name = "GRPCONTNO")),
			@AttributeOverride(name = "contPlanCode", column = @Column(name = "CONTPLANCODE")),
			@AttributeOverride(name = "planType", column = @Column(name = "PLANTYPE")) })
	public LCContPlanReportId getId() {
		return this.id;
	}

	/**
	 * 属性ID的setter方法
	 */
	public void setId(LCContPlanReportId id) {
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
	 * 属性保险计划名称的getter方法
	 */

	@Column(name = "CONTPLANNAME")
	public String getContPlanName() {
		return this.contPlanName;
	}

	/**
	 * 属性保险计划名称的setter方法
	 */
	public void setContPlanName(String contPlanName) {
		this.contPlanName = contPlanName;
	}

	/**
	 * 属性计划规则的getter方法
	 */

	@Column(name = "PLANRULE")
	public String getPlanRule() {
		return this.planRule;
	}

	/**
	 * 属性计划规则的setter方法
	 */
	public void setPlanRule(String planRule) {
		this.planRule = planRule;
	}

	/**
	 * 属性计划规则sql的getter方法
	 */

	@Column(name = "PLANSQL")
	public String getPlanSql() {
		return this.planSql;
	}

	/**
	 * 属性计划规则sql的setter方法
	 */
	public void setPlanSql(String planSql) {
		this.planSql = planSql;
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
	 * 属性备注2的getter方法
	 */

	@Column(name = "REMARK2")
	public String getRemark2() {
		return this.remark2;
	}

	/**
	 * 属性备注2的setter方法
	 */
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
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

}
