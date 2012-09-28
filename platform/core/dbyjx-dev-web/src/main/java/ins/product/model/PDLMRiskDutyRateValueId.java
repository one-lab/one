package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类PDLMRiskDutyRateValueId
 */
@Embeddable
public class PDLMRiskDutyRateValueId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性险种代码 */
	private String riskCode;

	/** 属性责任代码 */
	private String dutyCode;

	/** 属性要素代码集合 */
	private String comFactor;

	/** 属性值区间集合 */
	private String comValue;

	/**
	 * 类PDLMRiskDutyRateValueId的默认构造方法
	 */
	public PDLMRiskDutyRateValueId() {
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
	 * 属性要素代码集合的getter方法
	 */

	@Column(name = "COMFACTOR")
	public String getComFactor() {
		return this.comFactor;
	}

	/**
	 * 属性要素代码集合的setter方法
	 */
	public void setComFactor(String comFactor) {
		this.comFactor = comFactor;
	}

	/**
	 * 属性值区间集合的getter方法
	 */

	@Column(name = "COMVALUE")
	public String getComValue() {
		return this.comValue;
	}

	/**
	 * 属性值区间集合的setter方法
	 */
	public void setComValue(String comValue) {
		this.comValue = comValue;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof PDLMRiskDutyRateValueId)) {
			return false;
		}
		PDLMRiskDutyRateValueId castOther = (PDLMRiskDutyRateValueId) other;

		return ((this.getRiskCode() == castOther.getRiskCode()) || (this
				.getRiskCode() != null && castOther.getRiskCode() != null && this
				.getRiskCode().equals(castOther.getRiskCode())))
				&& ((this.getDutyCode() == castOther.getDutyCode()) || (this
						.getDutyCode() != null
						&& castOther.getDutyCode() != null && this
						.getDutyCode().equals(castOther.getDutyCode())))
				&& ((this.getComFactor() == castOther.getComFactor()) || (this
						.getComFactor() != null
						&& castOther.getComFactor() != null && this
						.getComFactor().equals(castOther.getComFactor())))
				&& ((this.getComValue() == castOther.getComValue()) || (this
						.getComValue() != null
						&& castOther.getComValue() != null && this
						.getComValue().equals(castOther.getComValue())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRiskCode() == null ? 0 : this.getRiskCode().hashCode());
		result = 37 * result
				+ (getDutyCode() == null ? 0 : this.getDutyCode().hashCode());
		result = 37 * result
				+ (getComFactor() == null ? 0 : this.getComFactor().hashCode());
		result = 37 * result
				+ (getComValue() == null ? 0 : this.getComValue().hashCode());
		return result;
	}

}
