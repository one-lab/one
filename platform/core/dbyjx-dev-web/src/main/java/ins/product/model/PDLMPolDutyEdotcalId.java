package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类PDLMPolDutyEdotcalId
 */
@Embeddable
public class PDLMPolDutyEdotcalId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性险种代码 */
	private String riskCode;

	/** 属性责任代码 */
	private String dutyCode;

	/** 属性保全项目代码 */
	private String edorType;

	/**
	 * 类PDLMPolDutyEdotcalId的默认构造方法
	 */
	public PDLMPolDutyEdotcalId() {
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
	 * 属性保全项目代码的getter方法
	 */

	@Column(name = "EDORTYPE")
	public String getEdorType() {
		return this.edorType;
	}

	/**
	 * 属性保全项目代码的setter方法
	 */
	public void setEdorType(String edorType) {
		this.edorType = edorType;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof PDLMPolDutyEdotcalId)) {
			return false;
		}
		PDLMPolDutyEdotcalId castOther = (PDLMPolDutyEdotcalId) other;

		return ((this.getRiskCode() == castOther.getRiskCode()) || (this
				.getRiskCode() != null && castOther.getRiskCode() != null && this
				.getRiskCode().equals(castOther.getRiskCode())))
				&& ((this.getDutyCode() == castOther.getDutyCode()) || (this
						.getDutyCode() != null
						&& castOther.getDutyCode() != null && this
						.getDutyCode().equals(castOther.getDutyCode())))
				&& ((this.getEdorType() == castOther.getEdorType()) || (this
						.getEdorType() != null
						&& castOther.getEdorType() != null && this
						.getEdorType().equals(castOther.getEdorType())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRiskCode() == null ? 0 : this.getRiskCode().hashCode());
		result = 37 * result
				+ (getDutyCode() == null ? 0 : this.getDutyCode().hashCode());
		result = 37 * result
				+ (getEdorType() == null ? 0 : this.getEdorType().hashCode());
		return result;
	}

}
