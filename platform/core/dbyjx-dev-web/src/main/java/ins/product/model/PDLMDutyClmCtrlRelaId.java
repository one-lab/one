package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类PDLMDutyClmCtrlRelaId
 */
@Embeddable
public class PDLMDutyClmCtrlRelaId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性给付代码 */
	private String getDutyCode;

	/** 属性给付责任类型 */
	private String getDutyKind;

	/** 属性理赔控制编号 */
	private String claimCtrlCode;

	/** 属性账单项目编码 */
	private String feecode;

	/** 属性险种代码 */
	private String riskCode;

	/** 属性责任代码 */
	private String dutyCode;

	/**
	 * 类PDLMDutyClmCtrlRelaId的默认构造方法
	 */
	public PDLMDutyClmCtrlRelaId() {
	}

	/**
	 * 属性给付代码的getter方法
	 */

	@Column(name = "GETDUTYCODE")
	public String getGetDutyCode() {
		return this.getDutyCode;
	}

	/**
	 * 属性给付代码的setter方法
	 */
	public void setGetDutyCode(String getDutyCode) {
		this.getDutyCode = getDutyCode;
	}

	/**
	 * 属性给付责任类型的getter方法
	 */

	@Column(name = "GETDUTYKIND")
	public String getGetDutyKind() {
		return this.getDutyKind;
	}

	/**
	 * 属性给付责任类型的setter方法
	 */
	public void setGetDutyKind(String getDutyKind) {
		this.getDutyKind = getDutyKind;
	}

	/**
	 * 属性理赔控制编号的getter方法
	 */

	@Column(name = "CLAIMCTRLCODE")
	public String getClaimCtrlCode() {
		return this.claimCtrlCode;
	}

	/**
	 * 属性理赔控制编号的setter方法
	 */
	public void setClaimCtrlCode(String claimCtrlCode) {
		this.claimCtrlCode = claimCtrlCode;
	}

	/**
	 * 属性账单项目编码的getter方法
	 */

	@Column(name = "FEECODE")
	public String getFeecode() {
		return this.feecode;
	}

	/**
	 * 属性账单项目编码的setter方法
	 */
	public void setFeecode(String feecode) {
		this.feecode = feecode;
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

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof PDLMDutyClmCtrlRelaId)) {
			return false;
		}
		PDLMDutyClmCtrlRelaId castOther = (PDLMDutyClmCtrlRelaId) other;

		return ((this.getGetDutyCode() == castOther.getGetDutyCode()) || (this
				.getGetDutyCode() != null && castOther.getGetDutyCode() != null && this
				.getGetDutyCode().equals(castOther.getGetDutyCode())))
				&& ((this.getGetDutyKind() == castOther.getGetDutyKind()) || (this
						.getGetDutyKind() != null
						&& castOther.getGetDutyKind() != null && this
						.getGetDutyKind().equals(castOther.getGetDutyKind())))
				&& ((this.getClaimCtrlCode() == castOther.getClaimCtrlCode()) || (this
						.getClaimCtrlCode() != null
						&& castOther.getClaimCtrlCode() != null && this
						.getClaimCtrlCode()
						.equals(castOther.getClaimCtrlCode())))
				&& ((this.getFeecode() == castOther.getFeecode()) || (this
						.getFeecode() != null && castOther.getFeecode() != null && this
						.getFeecode().equals(castOther.getFeecode())))
				&& ((this.getRiskCode() == castOther.getRiskCode()) || (this
						.getRiskCode() != null
						&& castOther.getRiskCode() != null && this
						.getRiskCode().equals(castOther.getRiskCode())))
				&& ((this.getDutyCode() == castOther.getDutyCode()) || (this
						.getDutyCode() != null
						&& castOther.getDutyCode() != null && this
						.getDutyCode().equals(castOther.getDutyCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getGetDutyCode() == null ? 0 : this.getGetDutyCode()
						.hashCode());
		result = 37
				* result
				+ (getGetDutyKind() == null ? 0 : this.getGetDutyKind()
						.hashCode());
		result = 37
				* result
				+ (getClaimCtrlCode() == null ? 0 : this.getClaimCtrlCode()
						.hashCode());
		result = 37 * result
				+ (getFeecode() == null ? 0 : this.getFeecode().hashCode());
		result = 37 * result
				+ (getRiskCode() == null ? 0 : this.getRiskCode().hashCode());
		result = 37 * result
				+ (getDutyCode() == null ? 0 : this.getDutyCode().hashCode());
		return result;
	}

}
