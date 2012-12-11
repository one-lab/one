package ins.prpall.proposal.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * POJO类LCContPlanDutyParam
 */
@Entity
@Table(name = "LCCONTPLANDUTYPARAM")
public class LCContPlanDutyParam implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性序号 */
	private LCContPlanDutyParamId id;

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

	/**
	 * 类LCContPlanDutyParam的默认构造方法
	 */
	public LCContPlanDutyParam() {
	}

	/**
	 * 属性序号的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "grpContNo", column = @Column(name = "GRPCONTNO")),
			@AttributeOverride(name = "mainRiskCode", column = @Column(name = "MAINRISKCODE")),
			@AttributeOverride(name = "riskCode", column = @Column(name = "RISKCODE")),
			@AttributeOverride(name = "contPlanCode", column = @Column(name = "CONTPLANCODE")),
			@AttributeOverride(name = "dutyCode", column = @Column(name = "DUTYCODE")),
			@AttributeOverride(name = "calFactor", column = @Column(name = "CALFACTOR")),
			@AttributeOverride(name = "planType", column = @Column(name = "PLANTYPE")) })
	public LCContPlanDutyParamId getId() {
		return this.id;
	}

	/**
	 * 属性序号的setter方法
	 */
	public void setId(LCContPlanDutyParamId id) {
		this.id = id;
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

}
