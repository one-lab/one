package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类PDLMDutyPayAddFeeId
 */
@Embeddable
public class PDLMDutyPayAddFeeId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性险种代码 */
	private String riskCode;

	/** 属性责任代码 */
	private String dutyCode;

	/** 属性加费类型 */
	private String addFeeType;

	/** 属性加费对象 */
	private String addFeeObject;

	/**
	 * 类PDLMDutyPayAddFeeId的默认构造方法
	 */
	public PDLMDutyPayAddFeeId() {
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
	 * 属性加费类型的getter方法
	 */

	@Column(name = "ADDFEETYPE")
	public String getAddFeeType() {
		return this.addFeeType;
	}

	/**
	 * 属性加费类型的setter方法
	 */
	public void setAddFeeType(String addFeeType) {
		this.addFeeType = addFeeType;
	}

	/**
	 * 属性加费对象的getter方法
	 */

	@Column(name = "ADDFEEOBJECT")
	public String getAddFeeObject() {
		return this.addFeeObject;
	}

	/**
	 * 属性加费对象的setter方法
	 */
	public void setAddFeeObject(String addFeeObject) {
		this.addFeeObject = addFeeObject;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof PDLMDutyPayAddFeeId)) {
			return false;
		}
		PDLMDutyPayAddFeeId castOther = (PDLMDutyPayAddFeeId) other;

		return ((this.getRiskCode() == castOther.getRiskCode()) || (this
				.getRiskCode() != null && castOther.getRiskCode() != null && this
				.getRiskCode().equals(castOther.getRiskCode())))
				&& ((this.getDutyCode() == castOther.getDutyCode()) || (this
						.getDutyCode() != null
						&& castOther.getDutyCode() != null && this
						.getDutyCode().equals(castOther.getDutyCode())))
				&& ((this.getAddFeeType() == castOther.getAddFeeType()) || (this
						.getAddFeeType() != null
						&& castOther.getAddFeeType() != null && this
						.getAddFeeType().equals(castOther.getAddFeeType())))
				&& ((this.getAddFeeObject() == castOther.getAddFeeObject()) || (this
						.getAddFeeObject() != null
						&& castOther.getAddFeeObject() != null && this
						.getAddFeeObject().equals(castOther.getAddFeeObject())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRiskCode() == null ? 0 : this.getRiskCode().hashCode());
		result = 37 * result
				+ (getDutyCode() == null ? 0 : this.getDutyCode().hashCode());
		result = 37
				* result
				+ (getAddFeeType() == null ? 0 : this.getAddFeeType()
						.hashCode());
		result = 37
				* result
				+ (getAddFeeObject() == null ? 0 : this.getAddFeeObject()
						.hashCode());
		return result;
	}

}
