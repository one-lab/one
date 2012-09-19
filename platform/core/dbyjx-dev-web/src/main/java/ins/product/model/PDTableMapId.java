package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类PDTableMapId
 */
@Embeddable
public class PDTableMapId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性表名代码 */
	private String tableCode;

	/** 属性核心业务系统表代码 */
	private String coreTableCode;

	/**
	 * 类PDTableMapId的默认构造方法
	 */
	public PDTableMapId() {
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
	 * 属性核心业务系统表代码的getter方法
	 */

	@Column(name = "CORETABLECODE")
	public String getCoreTableCode() {
		return this.coreTableCode;
	}

	/**
	 * 属性核心业务系统表代码的setter方法
	 */
	public void setCoreTableCode(String coreTableCode) {
		this.coreTableCode = coreTableCode;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof PDTableMapId)) {
			return false;
		}
		PDTableMapId castOther = (PDTableMapId) other;

		return ((this.getTableCode() == castOther.getTableCode()) || (this
				.getTableCode() != null && castOther.getTableCode() != null && this
				.getTableCode().equals(castOther.getTableCode())))
				&& ((this.getCoreTableCode() == castOther.getCoreTableCode()) || (this
						.getCoreTableCode() != null
						&& castOther.getCoreTableCode() != null && this
						.getCoreTableCode()
						.equals(castOther.getCoreTableCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTableCode() == null ? 0 : this.getTableCode().hashCode());
		result = 37
				* result
				+ (getCoreTableCode() == null ? 0 : this.getCoreTableCode()
						.hashCode());
		return result;
	}

}
