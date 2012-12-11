package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类PDLMPayModeId
 */
@Embeddable
public class PDLMPayModeId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性险种代码 */
	private String riskCode;

	/** 属性缴费终止期间单位 */
	private String payEndYearFlag;

	/** 属性缴费终止期间 */
	private BigDecimal payEndYear;

	/** 属性交费间隔 */
	private BigDecimal payIntv;

	/**
	 * 类PDLMPayModeId的默认构造方法
	 */
	public PDLMPayModeId() {
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
	 * 属性缴费终止期间单位的getter方法
	 */

	@Column(name = "PAYENDYEARFLAG")
	public String getPayEndYearFlag() {
		return this.payEndYearFlag;
	}

	/**
	 * 属性缴费终止期间单位的setter方法
	 */
	public void setPayEndYearFlag(String payEndYearFlag) {
		this.payEndYearFlag = payEndYearFlag;
	}

	/**
	 * 属性缴费终止期间的getter方法
	 */

	@Column(name = "PAYENDYEAR")
	public BigDecimal getPayEndYear() {
		return this.payEndYear;
	}

	/**
	 * 属性缴费终止期间的setter方法
	 */
	public void setPayEndYear(BigDecimal payEndYear) {
		this.payEndYear = payEndYear;
	}

	/**
	 * 属性交费间隔的getter方法
	 */

	@Column(name = "PAYINTV")
	public BigDecimal getPayIntv() {
		return this.payIntv;
	}

	/**
	 * 属性交费间隔的setter方法
	 */
	public void setPayIntv(BigDecimal payIntv) {
		this.payIntv = payIntv;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof PDLMPayModeId)) {
			return false;
		}
		PDLMPayModeId castOther = (PDLMPayModeId) other;

		return ((this.getRiskCode() == castOther.getRiskCode()) || (this
				.getRiskCode() != null && castOther.getRiskCode() != null && this
				.getRiskCode().equals(castOther.getRiskCode())))
				&& ((this.getPayEndYearFlag() == castOther.getPayEndYearFlag()) || (this
						.getPayEndYearFlag() != null
						&& castOther.getPayEndYearFlag() != null && this
						.getPayEndYearFlag().equals(
								castOther.getPayEndYearFlag())))
				&& ((this.getPayEndYear() == castOther.getPayEndYear()) || (this
						.getPayEndYear() != null
						&& castOther.getPayEndYear() != null && this
						.getPayEndYear().equals(castOther.getPayEndYear())))
				&& ((this.getPayIntv() == castOther.getPayIntv()) || (this
						.getPayIntv() != null && castOther.getPayIntv() != null && this
						.getPayIntv().equals(castOther.getPayIntv())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRiskCode() == null ? 0 : this.getRiskCode().hashCode());
		result = 37
				* result
				+ (getPayEndYearFlag() == null ? 0 : this.getPayEndYearFlag()
						.hashCode());
		result = 37
				* result
				+ (getPayEndYear() == null ? 0 : this.getPayEndYear()
						.hashCode());
		result = 37 * result
				+ (getPayIntv() == null ? 0 : this.getPayIntv().hashCode());
		return result;
	}

}
