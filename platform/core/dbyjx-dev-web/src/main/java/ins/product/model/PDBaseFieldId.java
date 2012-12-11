package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类PDBaseFieldId
 */
@Embeddable
public class PDBaseFieldId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性表名代码 */
	private String tableCode;

	/** 属性字段编码 */
	private String fieldCode;

	/**
	 * 类PDBaseFieldId的默认构造方法
	 */
	public PDBaseFieldId() {
	}

	/**
	 * 属性表名代码的getter方法
	 */

	@Column(name = "TABLECODE")
	public String getTableCode() {
		return this.tableCode;
	}

	/**
	 * 属性表名代码的setter方法
	 */
	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}

	/**
	 * 属性字段编码的getter方法
	 */

	@Column(name = "FIELDCODE")
	public String getFieldCode() {
		return this.fieldCode;
	}

	/**
	 * 属性字段编码的setter方法
	 */
	public void setFieldCode(String fieldCode) {
		this.fieldCode = fieldCode;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof PDBaseFieldId)) {
			return false;
		}
		PDBaseFieldId castOther = (PDBaseFieldId) other;

		return ((this.getTableCode() == castOther.getTableCode()) || (this
				.getTableCode() != null && castOther.getTableCode() != null && this
				.getTableCode().equals(castOther.getTableCode())))
				&& ((this.getFieldCode() == castOther.getFieldCode()) || (this
						.getFieldCode() != null
						&& castOther.getFieldCode() != null && this
						.getFieldCode().equals(castOther.getFieldCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTableCode() == null ? 0 : this.getTableCode().hashCode());
		result = 37 * result
				+ (getFieldCode() == null ? 0 : this.getFieldCode().hashCode());
		return result;
	}

}
