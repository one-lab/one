package ins.prpall.report.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类LCContPlanDutyParamReportId
 */
@Embeddable
public class LCContPlanDutyParamReportId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性呈报申请号 */
	private String repNo;

	/** 属性集体合同号码 */
	private String grpContNo;

	/** 属性主险险种编码 */
	private String mainRiskCode;

	/** 属性险种代码 */
	private String riskCode;

	/** 属性保险计划编码 */
	private String contPlanCode;

	/** 属性责任代码 */
	private String dutyCode;

	/** 属性计算要素 */
	private String calFactor;

	/** 属性计划类别 */
	private String planType;

	/**
	 * 类LCContPlanDutyParamReportId的默认构造方法
	 */
	public LCContPlanDutyParamReportId() {
	}

	/**
	 * 属性呈报申请号的getter方法
	 */

	@Column(name = "REPNO")
	public String getRepNo() {
		return this.repNo;
	}

	/**
	 * 属性呈报申请号的setter方法
	 */
	public void setRepNo(String repNo) {
		this.repNo = repNo;
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
	 * 属性主险险种编码的getter方法
	 */

	@Column(name = "MAINRISKCODE")
	public String getMainRiskCode() {
		return this.mainRiskCode;
	}

	/**
	 * 属性主险险种编码的setter方法
	 */
	public void setMainRiskCode(String mainRiskCode) {
		this.mainRiskCode = mainRiskCode;
	}

	/**
	 * 属性险种代码的getter方法
	 */

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
	 * 属性保险计划编码的getter方法
	 */

	@Column(name = "CONTPLANCODE")
	public String getContPlanCode() {
		return this.contPlanCode;
	}

	/**
	 * 属性保险计划编码的setter方法
	 */
	public void setContPlanCode(String contPlanCode) {
		this.contPlanCode = contPlanCode;
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
	 * 属性计算要素的getter方法
	 */

	@Column(name = "CALFACTOR")
	public String getCalFactor() {
		return this.calFactor;
	}

	/**
	 * 属性计算要素的setter方法
	 */
	public void setCalFactor(String calFactor) {
		this.calFactor = calFactor;
	}

	/**
	 * 属性计划类别的getter方法
	 */

	@Column(name = "PLANTYPE")
	public String getPlanType() {
		return this.planType;
	}

	/**
	 * 属性计划类别的setter方法
	 */
	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof LCContPlanDutyParamReportId)) {
			return false;
		}
		LCContPlanDutyParamReportId castOther = (LCContPlanDutyParamReportId) other;

		return ((this.getRepNo() == castOther.getRepNo()) || (this.getRepNo() != null
				&& castOther.getRepNo() != null && this.getRepNo().equals(
				castOther.getRepNo())))
				&& ((this.getGrpContNo() == castOther.getGrpContNo()) || (this
						.getGrpContNo() != null
						&& castOther.getGrpContNo() != null && this
						.getGrpContNo().equals(castOther.getGrpContNo())))
				&& ((this.getMainRiskCode() == castOther.getMainRiskCode()) || (this
						.getMainRiskCode() != null
						&& castOther.getMainRiskCode() != null && this
						.getMainRiskCode().equals(castOther.getMainRiskCode())))
				&& ((this.getRiskCode() == castOther.getRiskCode()) || (this
						.getRiskCode() != null
						&& castOther.getRiskCode() != null && this
						.getRiskCode().equals(castOther.getRiskCode())))
				&& ((this.getContPlanCode() == castOther.getContPlanCode()) || (this
						.getContPlanCode() != null
						&& castOther.getContPlanCode() != null && this
						.getContPlanCode().equals(castOther.getContPlanCode())))
				&& ((this.getDutyCode() == castOther.getDutyCode()) || (this
						.getDutyCode() != null
						&& castOther.getDutyCode() != null && this
						.getDutyCode().equals(castOther.getDutyCode())))
				&& ((this.getCalFactor() == castOther.getCalFactor()) || (this
						.getCalFactor() != null
						&& castOther.getCalFactor() != null && this
						.getCalFactor().equals(castOther.getCalFactor())))
				&& ((this.getPlanType() == castOther.getPlanType()) || (this
						.getPlanType() != null
						&& castOther.getPlanType() != null && this
						.getPlanType().equals(castOther.getPlanType())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRepNo() == null ? 0 : this.getRepNo().hashCode());
		result = 37 * result
				+ (getGrpContNo() == null ? 0 : this.getGrpContNo().hashCode());
		result = 37
				* result
				+ (getMainRiskCode() == null ? 0 : this.getMainRiskCode()
						.hashCode());
		result = 37 * result
				+ (getRiskCode() == null ? 0 : this.getRiskCode().hashCode());
		result = 37
				* result
				+ (getContPlanCode() == null ? 0 : this.getContPlanCode()
						.hashCode());
		result = 37 * result
				+ (getDutyCode() == null ? 0 : this.getDutyCode().hashCode());
		result = 37 * result
				+ (getCalFactor() == null ? 0 : this.getCalFactor().hashCode());
		result = 37 * result
				+ (getPlanType() == null ? 0 : this.getPlanType().hashCode());
		return result;
	}

}
