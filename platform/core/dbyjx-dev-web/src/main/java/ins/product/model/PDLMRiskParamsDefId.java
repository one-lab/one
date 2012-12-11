package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类PDLMRiskParamsDefId
 */
@Embeddable
public class PDLMRiskParamsDefId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性险种代码 */
	private String riskCode;

	/** 属性责任代码 */
	private String dutyCode;

	/** 属性险种参数名 */
	private String paramsType;

	/** 属性险种参数值 */
	private String paramsCode;

	/** 属性其他编码 */
	private String otherCode;

	/**
	 * 类PDLMRiskParamsDefId的默认构造方法
	 */
	public PDLMRiskParamsDefId() {
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

	/**
	 * 属性险种参数名的getter方法
	 */

	@Column(name = "PARAMSTYPE")
	public String getParamsType() {
		return this.paramsType;
	}

	/**
	 * 属性险种参数名的setter方法
	 */
	public void setParamsType(String paramsType) {
		this.paramsType = paramsType;
	}

	/**
	 * 属性险种参数值的getter方法
	 */

	@Column(name = "PARAMSCODE")
	public String getParamsCode() {
		return this.paramsCode;
	}

	/**
	 * 属性险种参数值的setter方法
	 */
	public void setParamsCode(String paramsCode) {
		this.paramsCode = paramsCode;
	}

	/**
	 * 属性其他编码的getter方法
	 */

	@Column(name = "OTHERCODE")
	public String getOtherCode() {
		return this.otherCode;
	}

	/**
	 * 属性其他编码的setter方法
	 */
	public void setOtherCode(String otherCode) {
		this.otherCode = otherCode;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof PDLMRiskParamsDefId)) {
			return false;
		}
		PDLMRiskParamsDefId castOther = (PDLMRiskParamsDefId) other;

		return ((this.getRiskCode() == castOther.getRiskCode()) || (this
				.getRiskCode() != null && castOther.getRiskCode() != null && this
				.getRiskCode().equals(castOther.getRiskCode())))
				&& ((this.getDutyCode() == castOther.getDutyCode()) || (this
						.getDutyCode() != null
						&& castOther.getDutyCode() != null && this
						.getDutyCode().equals(castOther.getDutyCode())))
				&& ((this.getParamsType() == castOther.getParamsType()) || (this
						.getParamsType() != null
						&& castOther.getParamsType() != null && this
						.getParamsType().equals(castOther.getParamsType())))
				&& ((this.getParamsCode() == castOther.getParamsCode()) || (this
						.getParamsCode() != null
						&& castOther.getParamsCode() != null && this
						.getParamsCode().equals(castOther.getParamsCode())))
				&& ((this.getOtherCode() == castOther.getOtherCode()) || (this
						.getOtherCode() != null
						&& castOther.getOtherCode() != null && this
						.getOtherCode().equals(castOther.getOtherCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRiskCode() == null ? 0 : this.getRiskCode().hashCode());
		result = 37 * result
				+ (getDutyCode() == null ? 0 : this.getDutyCode().hashCode());
		result = 37
				* result
				+ (getParamsType() == null ? 0 : this.getParamsType()
						.hashCode());
		result = 37
				* result
				+ (getParamsCode() == null ? 0 : this.getParamsCode()
						.hashCode());
		result = 37 * result
				+ (getOtherCode() == null ? 0 : this.getOtherCode().hashCode());
		return result;
	}

}
