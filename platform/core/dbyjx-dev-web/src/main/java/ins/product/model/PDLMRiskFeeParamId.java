package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类PDLMRiskFeeParamId
 */
@Embeddable
public class PDLMRiskFeeParamId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性账单项目编码 */
	private String feecode;

	/** 属性缴费编码 */
	private String payPlanCode;

	/** 属性保险帐户号码 */
	private String insuAccNo;

	/** 属性管理费计算方式 */
	private String feeCalMode;

	/** 属性FeeID */
	private BigDecimal feeID;

	/**
	 * 类PDLMRiskFeeParamId的默认构造方法
	 */
	public PDLMRiskFeeParamId() {
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
	 * 属性管理费计算方式的getter方法
	 */

	@Column(name = "FEECALMODE")
	public String getFeeCalMode() {
		return this.feeCalMode;
	}

	/**
	 * 属性管理费计算方式的setter方法
	 */
	public void setFeeCalMode(String feeCalMode) {
		this.feeCalMode = feeCalMode;
	}

	/**
	 * 属性FeeID的getter方法
	 */

	@Column(name = "FEEID")
	public BigDecimal getFeeID() {
		return this.feeID;
	}

	/**
	 * 属性FeeID的setter方法
	 */
	public void setFeeID(BigDecimal feeID) {
		this.feeID = feeID;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof PDLMRiskFeeParamId)) {
			return false;
		}
		PDLMRiskFeeParamId castOther = (PDLMRiskFeeParamId) other;

		return ((this.getFeecode() == castOther.getFeecode()) || (this
				.getFeecode() != null && castOther.getFeecode() != null && this
				.getFeecode().equals(castOther.getFeecode())))
				&& ((this.getPayPlanCode() == castOther.getPayPlanCode()) || (this
						.getPayPlanCode() != null
						&& castOther.getPayPlanCode() != null && this
						.getPayPlanCode().equals(castOther.getPayPlanCode())))
				&& ((this.getInsuAccNo() == castOther.getInsuAccNo()) || (this
						.getInsuAccNo() != null
						&& castOther.getInsuAccNo() != null && this
						.getInsuAccNo().equals(castOther.getInsuAccNo())))
				&& ((this.getFeeCalMode() == castOther.getFeeCalMode()) || (this
						.getFeeCalMode() != null
						&& castOther.getFeeCalMode() != null && this
						.getFeeCalMode().equals(castOther.getFeeCalMode())))
				&& ((this.getFeeID() == castOther.getFeeID()) || (this
						.getFeeID() != null && castOther.getFeeID() != null && this
						.getFeeID().equals(castOther.getFeeID())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getFeecode() == null ? 0 : this.getFeecode().hashCode());
		result = 37
				* result
				+ (getPayPlanCode() == null ? 0 : this.getPayPlanCode()
						.hashCode());
		result = 37 * result
				+ (getInsuAccNo() == null ? 0 : this.getInsuAccNo().hashCode());
		result = 37
				* result
				+ (getFeeCalMode() == null ? 0 : this.getFeeCalMode()
						.hashCode());
		result = 37 * result
				+ (getFeeID() == null ? 0 : this.getFeeID().hashCode());
		return result;
	}

}
