package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类PDLMRiskSortId
 */
@Embeddable
public class PDLMRiskSortId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性险种代码 */
	private String riskCode;

	/** 属性险种分类类型 */
	private String riskSortType;

	/** 属性险种分类值 */
	private String riskSortValue;

	/**
	 * 类PDLMRiskSortId的默认构造方法
	 */
	public PDLMRiskSortId() {
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
	 * 属性险种分类类型的getter方法
	 */

	@Column(name = "RISKSORTTYPE")
	public String getRiskSortType() {
		return this.riskSortType;
	}

	/**
	 * 属性险种分类类型的setter方法
	 */
	public void setRiskSortType(String riskSortType) {
		this.riskSortType = riskSortType;
	}

	/**
	 * 属性险种分类值的getter方法
	 */

	@Column(name = "RISKSORTVALUE")
	public String getRiskSortValue() {
		return this.riskSortValue;
	}

	/**
	 * 属性险种分类值的setter方法
	 */
	public void setRiskSortValue(String riskSortValue) {
		this.riskSortValue = riskSortValue;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof PDLMRiskSortId)) {
			return false;
		}
		PDLMRiskSortId castOther = (PDLMRiskSortId) other;

		return ((this.getRiskCode() == castOther.getRiskCode()) || (this
				.getRiskCode() != null && castOther.getRiskCode() != null && this
				.getRiskCode().equals(castOther.getRiskCode())))
				&& ((this.getRiskSortType() == castOther.getRiskSortType()) || (this
						.getRiskSortType() != null
						&& castOther.getRiskSortType() != null && this
						.getRiskSortType().equals(castOther.getRiskSortType())))
				&& ((this.getRiskSortValue() == castOther.getRiskSortValue()) || (this
						.getRiskSortValue() != null
						&& castOther.getRiskSortValue() != null && this
						.getRiskSortValue()
						.equals(castOther.getRiskSortValue())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRiskCode() == null ? 0 : this.getRiskCode().hashCode());
		result = 37
				* result
				+ (getRiskSortType() == null ? 0 : this.getRiskSortType()
						.hashCode());
		result = 37
				* result
				+ (getRiskSortValue() == null ? 0 : this.getRiskSortValue()
						.hashCode());
		return result;
	}

}
