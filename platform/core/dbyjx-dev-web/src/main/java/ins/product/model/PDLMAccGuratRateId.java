package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类PDLMAccGuratRateId
 */
@Embeddable
public class PDLMAccGuratRateId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性保险帐户号码 */
	private String insuAccNo;

	/** 属性险种代码 */
	private String riskCode;

	/** 属性起始日期 */
	private Date rateStartDate;

	/** 属性利率类型 */
	private String rateIntv;

	/**
	 * 类PDLMAccGuratRateId的默认构造方法
	 */
	public PDLMAccGuratRateId() {
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

	/**
	 * 属性起始日期的getter方法
	 */

	@Column(name = "RATESTARTDATE")
	public Date getRateStartDate() {
		return this.rateStartDate;
	}

	/**
	 * 属性起始日期的setter方法
	 */
	public void setRateStartDate(Date rateStartDate) {
		this.rateStartDate = rateStartDate;
	}

	/**
	 * 属性利率类型的getter方法
	 */

	@Column(name = "RATEINTV")
	public String getRateIntv() {
		return this.rateIntv;
	}

	/**
	 * 属性利率类型的setter方法
	 */
	public void setRateIntv(String rateIntv) {
		this.rateIntv = rateIntv;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof PDLMAccGuratRateId)) {
			return false;
		}
		PDLMAccGuratRateId castOther = (PDLMAccGuratRateId) other;

		return ((this.getInsuAccNo() == castOther.getInsuAccNo()) || (this
				.getInsuAccNo() != null && castOther.getInsuAccNo() != null && this
				.getInsuAccNo().equals(castOther.getInsuAccNo())))
				&& ((this.getRiskCode() == castOther.getRiskCode()) || (this
						.getRiskCode() != null
						&& castOther.getRiskCode() != null && this
						.getRiskCode().equals(castOther.getRiskCode())))
				&& ((this.getRateStartDate() == castOther.getRateStartDate()) || (this
						.getRateStartDate() != null
						&& castOther.getRateStartDate() != null && this
						.getRateStartDate()
						.equals(castOther.getRateStartDate())))
				&& ((this.getRateIntv() == castOther.getRateIntv()) || (this
						.getRateIntv() != null
						&& castOther.getRateIntv() != null && this
						.getRateIntv().equals(castOther.getRateIntv())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getInsuAccNo() == null ? 0 : this.getInsuAccNo().hashCode());
		result = 37 * result
				+ (getRiskCode() == null ? 0 : this.getRiskCode().hashCode());
		result = 37
				* result
				+ (getRateStartDate() == null ? 0 : this.getRateStartDate()
						.hashCode());
		result = 37 * result
				+ (getRateIntv() == null ? 0 : this.getRateIntv().hashCode());
		return result;
	}

}
