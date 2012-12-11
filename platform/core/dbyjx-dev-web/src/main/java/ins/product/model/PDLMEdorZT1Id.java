package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类PDLMEdorZT1Id
 */
@Embeddable
public class PDLMEdorZT1Id implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性险种代码 */
	private String riskCode;

	/** 属性责任代码 */
	private String dutyCode;

	/** 属性缴费编码 */
	private String payPlanCode;

	/** 属性退保计算类型 */
	private String surrCalType;

	/** 属性期缴时间间隔 */
	private String cycPayIntvType;

	/**
	 * 类PDLMEdorZT1Id的默认构造方法
	 */
	public PDLMEdorZT1Id() {
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
	 * 属性退保计算类型的getter方法
	 */

	@Column(name = "SURRCALTYPE")
	public String getSurrCalType() {
		return this.surrCalType;
	}

	/**
	 * 属性退保计算类型的setter方法
	 */
	public void setSurrCalType(String surrCalType) {
		this.surrCalType = surrCalType;
	}

	/**
	 * 属性期缴时间间隔的getter方法
	 */

	@Column(name = "CYCPAYINTVTYPE")
	public String getCycPayIntvType() {
		return this.cycPayIntvType;
	}

	/**
	 * 属性期缴时间间隔的setter方法
	 */
	public void setCycPayIntvType(String cycPayIntvType) {
		this.cycPayIntvType = cycPayIntvType;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof PDLMEdorZT1Id)) {
			return false;
		}
		PDLMEdorZT1Id castOther = (PDLMEdorZT1Id) other;

		return ((this.getRiskCode() == castOther.getRiskCode()) || (this
				.getRiskCode() != null && castOther.getRiskCode() != null && this
				.getRiskCode().equals(castOther.getRiskCode())))
				&& ((this.getDutyCode() == castOther.getDutyCode()) || (this
						.getDutyCode() != null
						&& castOther.getDutyCode() != null && this
						.getDutyCode().equals(castOther.getDutyCode())))
				&& ((this.getPayPlanCode() == castOther.getPayPlanCode()) || (this
						.getPayPlanCode() != null
						&& castOther.getPayPlanCode() != null && this
						.getPayPlanCode().equals(castOther.getPayPlanCode())))
				&& ((this.getSurrCalType() == castOther.getSurrCalType()) || (this
						.getSurrCalType() != null
						&& castOther.getSurrCalType() != null && this
						.getSurrCalType().equals(castOther.getSurrCalType())))
				&& ((this.getCycPayIntvType() == castOther.getCycPayIntvType()) || (this
						.getCycPayIntvType() != null
						&& castOther.getCycPayIntvType() != null && this
						.getCycPayIntvType().equals(
								castOther.getCycPayIntvType())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRiskCode() == null ? 0 : this.getRiskCode().hashCode());
		result = 37 * result
				+ (getDutyCode() == null ? 0 : this.getDutyCode().hashCode());
		result = 37
				* result
				+ (getPayPlanCode() == null ? 0 : this.getPayPlanCode()
						.hashCode());
		result = 37
				* result
				+ (getSurrCalType() == null ? 0 : this.getSurrCalType()
						.hashCode());
		result = 37
				* result
				+ (getCycPayIntvType() == null ? 0 : this.getCycPayIntvType()
						.hashCode());
		return result;
	}

}
