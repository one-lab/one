package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类PDLMRiskAccPayId
 */
@Embeddable
public class PDLMRiskAccPayId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性缴费编码 */
	private String payPlanCode;

	/** 属性保险帐户号码 */
	private String insuAccNo;

	/** 属性险种代码 */
	private String riskCode;

	/**
	 * 类PDLMRiskAccPayId的默认构造方法
	 */
	public PDLMRiskAccPayId() {
	}

	/**
	 * 属性缴费编码的getter方法
	 */

	@Column(name = "PAYPLANCODE")
	public String getPayPlanCode() {
		return this.payPlanCode;
	}

	/**
	 * 属性缴费编码的setter方法
	 */
	public void setPayPlanCode(String payPlanCode) {
		this.payPlanCode = payPlanCode;
	}

	/**
	 * 属性保险帐户号码的getter方法
	 */

	@Column(name = "INSUACCNO")
	public String getInsuAccNo() {
		return this.insuAccNo;
	}

	/**
	 * 属性保险帐户号码的setter方法
	 */
	public void setInsuAccNo(String insuAccNo) {
		this.insuAccNo = insuAccNo;
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

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof PDLMRiskAccPayId)) {
			return false;
		}
		PDLMRiskAccPayId castOther = (PDLMRiskAccPayId) other;

		return ((this.getPayPlanCode() == castOther.getPayPlanCode()) || (this
				.getPayPlanCode() != null && castOther.getPayPlanCode() != null && this
				.getPayPlanCode().equals(castOther.getPayPlanCode())))
				&& ((this.getInsuAccNo() == castOther.getInsuAccNo()) || (this
						.getInsuAccNo() != null
						&& castOther.getInsuAccNo() != null && this
						.getInsuAccNo().equals(castOther.getInsuAccNo())))
				&& ((this.getRiskCode() == castOther.getRiskCode()) || (this
						.getRiskCode() != null
						&& castOther.getRiskCode() != null && this
						.getRiskCode().equals(castOther.getRiskCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getPayPlanCode() == null ? 0 : this.getPayPlanCode()
						.hashCode());
		result = 37 * result
				+ (getInsuAccNo() == null ? 0 : this.getInsuAccNo().hashCode());
		result = 37 * result
				+ (getRiskCode() == null ? 0 : this.getRiskCode().hashCode());
		return result;
	}

}
