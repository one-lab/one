package ins.platform.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类UtiMenuStyleId
 */
@Embeddable
public class UtiMenuStyleId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性菜单层级 */
	private BigDecimal menuLevel;

	/** 属性系统代码 */
	private String systemCode;

	/**
	 * 类UtiMenuStyleId的默认构造方法
	 */
	public UtiMenuStyleId() {
	}

	/**
	 * 属性菜单层级的getter方法
	 */

	@Column(name = "MENULEVEL")
	public BigDecimal getMenuLevel() {
		return this.menuLevel;
	}

	/**
	 * 属性菜单层级的setter方法
	 */
	public void setMenuLevel(BigDecimal menuLevel) {
		this.menuLevel = menuLevel;
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

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof UtiMenuStyleId)) {
			return false;
		}
		UtiMenuStyleId castOther = (UtiMenuStyleId) other;

		return ((this.getMenuLevel() == castOther.getMenuLevel()) || (this
				.getMenuLevel() != null && castOther.getMenuLevel() != null && this
				.getMenuLevel().equals(castOther.getMenuLevel())))
				&& ((this.getSystemCode() == castOther.getSystemCode()) || (this
						.getSystemCode() != null
						&& castOther.getSystemCode() != null && this
						.getSystemCode().equals(castOther.getSystemCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getMenuLevel() == null ? 0 : this.getMenuLevel().hashCode());
		result = 37
				* result
				+ (getSystemCode() == null ? 0 : this.getSystemCode()
						.hashCode());
		return result;
	}

}
