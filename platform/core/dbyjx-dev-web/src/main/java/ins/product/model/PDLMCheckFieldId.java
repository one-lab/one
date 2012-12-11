package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类PDLMCheckFieldId
 */
@Embeddable
public class PDLMCheckFieldId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性险种代码 */
	private String riskCode;

	/** 属性字段名称 */
	private String fieldName;

	/** 属性序列号 */
	private String serialNO;

	/**
	 * 类PDLMCheckFieldId的默认构造方法
	 */
	public PDLMCheckFieldId() {
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

	/**
	 * 属性序列号的getter方法
	 */

	@Column(name = "SERIALNO")
	public String getSerialNO() {
		return this.serialNO;
	}

	/**
	 * 属性序列号的setter方法
	 */
	public void setSerialNO(String serialNO) {
		this.serialNO = serialNO;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof PDLMCheckFieldId)) {
			return false;
		}
		PDLMCheckFieldId castOther = (PDLMCheckFieldId) other;

		return ((this.getRiskCode() == castOther.getRiskCode()) || (this
				.getRiskCode() != null && castOther.getRiskCode() != null && this
				.getRiskCode().equals(castOther.getRiskCode())))
				&& ((this.getFieldName() == castOther.getFieldName()) || (this
						.getFieldName() != null
						&& castOther.getFieldName() != null && this
						.getFieldName().equals(castOther.getFieldName())))
				&& ((this.getSerialNO() == castOther.getSerialNO()) || (this
						.getSerialNO() != null
						&& castOther.getSerialNO() != null && this
						.getSerialNO().equals(castOther.getSerialNO())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRiskCode() == null ? 0 : this.getRiskCode().hashCode());
		result = 37 * result
				+ (getFieldName() == null ? 0 : this.getFieldName().hashCode());
		result = 37 * result
				+ (getSerialNO() == null ? 0 : this.getSerialNO().hashCode());
		return result;
	}

}
