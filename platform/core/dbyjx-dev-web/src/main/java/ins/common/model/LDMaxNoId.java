package ins.common.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类LDMaxNoId
 */
@Embeddable
public class LDMaxNoId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性合编组 */
	private String groupNo;

	/** 属性yearno */
	private String yearno;

	/** 属性表名 */
	private String tableName;

	/** 属性字段名 */
	private String fieldName;

	/**
	 * 类LDMaxNoId的默认构造方法
	 */
	public LDMaxNoId() {
	}

	/**
	 * 属性合编组的getter方法
	 */

	@Column(name = "GROUPNO")
	public String getGroupNo() {
		return this.groupNo;
	}

	/**
	 * 属性合编组的setter方法
	 */
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}

	/**
	 * 属性yearno的getter方法
	 */

	@Column(name = "YEARNO")
	public String getYearno() {
		return this.yearno;
	}

	/**
	 * 属性yearno的setter方法
	 */
	public void setYearno(String yearno) {
		this.yearno = yearno;
	}

	/**
	 * 属性表名的getter方法
	 */

	@Column(name = "TABLENAME")
	public String getTableName() {
		return this.tableName;
	}

	/**
	 * 属性表名的setter方法
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * 属性字段名的getter方法
	 */

	@Column(name = "FIELDNAME")
	public String getFieldName() {
		return this.fieldName;
	}

	/**
	 * 属性字段名的setter方法
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
		if (!(other instanceof LDMaxNoId)) {
			return false;
		}
		LDMaxNoId castOther = (LDMaxNoId) other;

		return ((this.getGroupNo() == castOther.getGroupNo()) || (this
				.getGroupNo() != null && castOther.getGroupNo() != null && this
				.getGroupNo().equals(castOther.getGroupNo())))
				&& ((this.getYearno() == castOther.getYearno()) || (this
						.getYearno() != null && castOther.getYearno() != null && this
						.getYearno().equals(castOther.getYearno())))
				&& ((this.getTableName() == castOther.getTableName()) || (this
						.getTableName() != null
						&& castOther.getTableName() != null && this
						.getTableName().equals(castOther.getTableName())))
				&& ((this.getFieldName() == castOther.getFieldName()) || (this
						.getFieldName() != null
						&& castOther.getFieldName() != null && this
						.getFieldName().equals(castOther.getFieldName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getGroupNo() == null ? 0 : this.getGroupNo().hashCode());
		result = 37 * result
				+ (getYearno() == null ? 0 : this.getYearno().hashCode());
		result = 37 * result
				+ (getTableName() == null ? 0 : this.getTableName().hashCode());
		result = 37 * result
				+ (getFieldName() == null ? 0 : this.getFieldName().hashCode());
		return result;
	}

}
