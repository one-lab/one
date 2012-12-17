package ins.prpall.report.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

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
 * POJO类LCContPlanDutyParamReport
 */
@Entity
@Table(name = "LCCONTPLANDUTYPARAMREPORT")
public class LCContPlanDutyParamReport implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性序号 */
	private LCContPlanDutyParamReportId id;

	/** 属性呈报申请人 */
	private String repOperator;

	/** 属性呈报申请日期 */
	private Date repApplyDate;

	/** 属性集体投保单号码 */
	private String proposalGrpContNo;

	/** 属性集体保单险种号码 */
	private String grpPolNo;

	/** 属性主险险种版本 */
	private String mainRiskVersion;

	/** 属性险种版本 */
	private String riskVersion;

	/** 属性保险计划名称 */
	private String contPlanName;

	/** 属性计划要素类型 */
	private String calFactorType;

	/** 属性计划要素值 */
	private String calFactorValue;

	/** 属性描述 */
	private String remark;

	/** 属性SysContPlanCode */
	private String sysContPlanCode;

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

	/**
	 * 类LCContPlanDutyParamReport的默认构造方法
	 */
	public LCContPlanDutyParamReport() {
	}

	/**
	 * 属性序号的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "repNo", column = @Column(name = "REPNO")),
			@AttributeOverride(name = "grpContNo", column = @Column(name = "GRPCONTNO")),
			@AttributeOverride(name = "mainRiskCode", column = @Column(name = "MAINRISKCODE")),
			@AttributeOverride(name = "riskCode", column = @Column(name = "RISKCODE")),
			@AttributeOverride(name = "contPlanCode", column = @Column(name = "CONTPLANCODE")),
			@AttributeOverride(name = "dutyCode", column = @Column(name = "DUTYCODE")),
			@AttributeOverride(name = "calFactor", column = @Column(name = "CALFACTOR")),
			@AttributeOverride(name = "planType", column = @Column(name = "PLANTYPE")) })
	public LCContPlanDutyParamReportId getId() {
		return this.id;
	}

	/**
	 * 属性序号的setter方法
	 */
	public void setId(LCContPlanDutyParamReportId id) {
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
	 * 属性集体保单险种号码的getter方法
	 */

	@Column(name = "GRPPOLNO")
	public String getGrpPolNo() {
		return this.grpPolNo;
	}

	/**
	 * 属性集体保单险种号码的setter方法
	 */
	public void setGrpPolNo(String grpPolNo) {
		this.grpPolNo = grpPolNo;
	}

	/**
	 * 属性主险险种版本的getter方法
	 */

	@Column(name = "MAINRISKVERSION")
	public String getMainRiskVersion() {
		return this.mainRiskVersion;
	}

	/**
	 * 属性主险险种版本的setter方法
	 */
	public void setMainRiskVersion(String mainRiskVersion) {
		this.mainRiskVersion = mainRiskVersion;
	}

	/**
	 * 属性险种版本的getter方法
	 */

	@Column(name = "RISKVERSION")
	public String getRiskVersion() {
		return this.riskVersion;
	}

	/**
	 * 属性险种版本的setter方法
	 */
	public void setRiskVersion(String riskVersion) {
		this.riskVersion = riskVersion;
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
	 * 属性计划要素类型的getter方法
	 */

	@Column(name = "CALFACTORTYPE")
	public String getCalFactorType() {
		return this.calFactorType;
	}

	/**
	 * 属性计划要素类型的setter方法
	 */
	public void setCalFactorType(String calFactorType) {
		this.calFactorType = calFactorType;
	}

	/**
	 * 属性计划要素值的getter方法
	 */

	@Column(name = "CALFACTORVALUE")
	public String getCalFactorValue() {
		return this.calFactorValue;
	}

	/**
	 * 属性计划要素值的setter方法
	 */
	public void setCalFactorValue(String calFactorValue) {
		this.calFactorValue = calFactorValue;
	}

	/**
	 * 属性描述的getter方法
	 */

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	/**
	 * 属性描述的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 属性SysContPlanCode的getter方法
	 */

	@Column(name = "SYSCONTPLANCODE")
	public String getSysContPlanCode() {
		return this.sysContPlanCode;
	}

	/**
	 * 属性SysContPlanCode的setter方法
	 */
	public void setSysContPlanCode(String sysContPlanCode) {
		this.sysContPlanCode = sysContPlanCode;
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

}
