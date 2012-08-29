package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类PDLMDutyCtrlId
 */
@Embeddable
public class PDLMDutyCtrlId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性责任代码 */
	private String dutyCode;

	/** 属性其他编码 */
	private String otherCode;

	/** 属性字段名称 */
	private String fieldName;

	/**
	 * 类PDLMDutyCtrlId的默认构造方法
	 */
	public PDLMDutyCtrlId() {
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

	/**
	 * 属性字段名称的getter方法
	 */

	@Column(name = "FIELDNAME")
	public String getFieldName() {
		return this.fieldName;
	}

	/**
	 * 属性字段名称的setter方法
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof PDLMDutyCtrlId)) {
			return false;
		}
		PDLMDutyCtrlId castOther = (PDLMDutyCtrlId) other;

		return ((this.getDutyCode() == castOther.getDutyCode()) || (this
				.getDutyCode() != null && castOther.getDutyCode() != null && this
				.getDutyCode().equals(castOther.getDutyCode())))
				&& ((this.getOtherCode() == castOther.getOtherCode()) || (this
						.getOtherCode() != null
						&& castOther.getOtherCode() != null && this
						.getOtherCode().equals(castOther.getOtherCode())))
				&& ((this.getFieldName() == castOther.getFieldName()) || (this
						.getFieldName() != null
						&& castOther.getFieldName() != null && this
						.getFieldName().equals(castOther.getFieldName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getDutyCode() == null ? 0 : this.getDutyCode().hashCode());
		result = 37 * result
				+ (getOtherCode() == null ? 0 : this.getOtherCode().hashCode());
		result = 37 * result
				+ (getFieldName() == null ? 0 : this.getFieldName().hashCode());
		return result;
	}

}
