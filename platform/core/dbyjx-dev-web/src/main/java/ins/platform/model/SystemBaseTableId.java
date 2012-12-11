package ins.platform.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类SystemBaseTableId
 */
@Embeddable
public class SystemBaseTableId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性系统代码 */
	private String systemCode;

	/** 属性systemname */
	private String systemname;

	/** 属性tablecode */
	private String tablecode;

	/** 属性表名 */
	private String tableName;

	/** 属性memo */
	private String memo;

	/** 属性序号 */
	private Long serialNo;

	/**
	 * 类SystemBaseTableId的默认构造方法
	 */
	public SystemBaseTableId() {
	}

	/**
	 * 属性系统代码的getter方法
	 */

	@Column(name = "SYSTEMCODE")
	public String getSystemCode() {
		return this.systemCode;
	}

	/**
	 * 属性系统代码的setter方法
	 */
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	/**
	 * 属性systemname的getter方法
	 */

	@Column(name = "SYSTEMNAME")
	public String getSystemname() {
		return this.systemname;
	}

	/**
	 * 属性systemname的setter方法
	 */
	public void setSystemname(String systemname) {
		this.systemname = systemname;
	}

	/**
	 * 属性tablecode的getter方法
	 */

	@Column(name = "TABLECODE")
	public String getTablecode() {
		return this.tablecode;
	}

	/**
	 * 属性tablecode的setter方法
	 */
	public void setTablecode(String tablecode) {
		this.tablecode = tablecode;
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
	 * 属性memo的getter方法
	 */

	@Column(name = "MEMO")
	public String getMemo() {
		return this.memo;
	}

	/**
	 * 属性memo的setter方法
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * 属性序号的getter方法
	 */

	@Column(name = "SERIALNO")
	public Long getSerialNo() {
		return this.serialNo;
	}

	/**
	 * 属性序号的setter方法
	 */
	public void setSerialNo(Long serialNo) {
		this.serialNo = serialNo;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof SystemBaseTableId)) {
			return false;
		}
		SystemBaseTableId castOther = (SystemBaseTableId) other;

		return ((this.getSystemCode() == castOther.getSystemCode()) || (this
				.getSystemCode() != null && castOther.getSystemCode() != null && this
				.getSystemCode().equals(castOther.getSystemCode())))
				&& ((this.getSystemname() == castOther.getSystemname()) || (this
						.getSystemname() != null
						&& castOther.getSystemname() != null && this
						.getSystemname().equals(castOther.getSystemname())))
				&& ((this.getTablecode() == castOther.getTablecode()) || (this
						.getTablecode() != null
						&& castOther.getTablecode() != null && this
						.getTablecode().equals(castOther.getTablecode())))
				&& ((this.getTableName() == castOther.getTableName()) || (this
						.getTableName() != null
						&& castOther.getTableName() != null && this
						.getTableName().equals(castOther.getTableName())))
				&& ((this.getMemo() == castOther.getMemo()) || (this.getMemo() != null
						&& castOther.getMemo() != null && this.getMemo()
						.equals(castOther.getMemo())))
				&& ((this.getSerialNo() == castOther.getSerialNo()) || (this
						.getSerialNo() != null
						&& castOther.getSerialNo() != null && this
						.getSerialNo().equals(castOther.getSerialNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getSystemCode() == null ? 0 : this.getSystemCode()
						.hashCode());
		result = 37
				* result
				+ (getSystemname() == null ? 0 : this.getSystemname()
						.hashCode());
		result = 37 * result
				+ (getTablecode() == null ? 0 : this.getTablecode().hashCode());
		result = 37 * result
				+ (getTableName() == null ? 0 : this.getTableName().hashCode());
		result = 37 * result
				+ (getMemo() == null ? 0 : this.getMemo().hashCode());
		result = 37 * result
				+ (getSerialNo() == null ? 0 : this.getSerialNo().hashCode());
		return result;
	}

}
