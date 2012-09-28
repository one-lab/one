package ins.common.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类ExcelMapperTableId
 */
@Embeddable
public class ExcelMapperTableId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性excelvalue */
	private String excelvalue;

	/** 属性filedvalue */
	private String filedvalue;

	/** 属性marker */
	private String marker;

	/**
	 * 类ExcelMapperTableId的默认构造方法
	 */
	public ExcelMapperTableId() {
	}

	/**
	 * 属性excelvalue的getter方法
	 */

	@Column(name = "EXCELVALUE")
	public String getExcelvalue() {
		return this.excelvalue;
	}

	/**
	 * 属性excelvalue的setter方法
	 */
	public void setExcelvalue(String excelvalue) {
		this.excelvalue = excelvalue;
	}

	/**
	 * 属性filedvalue的getter方法
	 */

	@Column(name = "FILEDVALUE")
	public String getFiledvalue() {
		return this.filedvalue;
	}

	/**
	 * 属性filedvalue的setter方法
	 */
	public void setFiledvalue(String filedvalue) {
		this.filedvalue = filedvalue;
	}

	/**
	 * 属性marker的getter方法
	 */

	@Column(name = "MARKER")
	public String getMarker() {
		return this.marker;
	}

	/**
	 * 属性marker的setter方法
	 */
	public void setMarker(String marker) {
		this.marker = marker;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof ExcelMapperTableId)) {
			return false;
		}
		ExcelMapperTableId castOther = (ExcelMapperTableId) other;

		return ((this.getExcelvalue() == castOther.getExcelvalue()) || (this
				.getExcelvalue() != null && castOther.getExcelvalue() != null && this
				.getExcelvalue().equals(castOther.getExcelvalue())))
				&& ((this.getFiledvalue() == castOther.getFiledvalue()) || (this
						.getFiledvalue() != null
						&& castOther.getFiledvalue() != null && this
						.getFiledvalue().equals(castOther.getFiledvalue())))
				&& ((this.getMarker() == castOther.getMarker()) || (this
						.getMarker() != null && castOther.getMarker() != null && this
						.getMarker().equals(castOther.getMarker())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getExcelvalue() == null ? 0 : this.getExcelvalue()
						.hashCode());
		result = 37
				* result
				+ (getFiledvalue() == null ? 0 : this.getFiledvalue()
						.hashCode());
		result = 37 * result
				+ (getMarker() == null ? 0 : this.getMarker().hashCode());
		return result;
	}

}
