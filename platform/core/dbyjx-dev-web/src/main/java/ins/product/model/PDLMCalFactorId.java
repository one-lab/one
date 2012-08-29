package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类PDLMCalFactorId
 */
@Embeddable
public class PDLMCalFactorId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性佣金计算编码 */
	private String calCode;

	/** 属性要素代码 */
	private String factorCode;

	/**
	 * 类PDLMCalFactorId的默认构造方法
	 */
	public PDLMCalFactorId() {
	}

	/**
	 * 属性佣金计算编码的getter方法
	 */

	@Column(name = "CALCODE")
	public String getCalCode() {
		return this.calCode;
	}

	/**
	 * 属性佣金计算编码的setter方法
	 */
	public void setCalCode(String calCode) {
		this.calCode = calCode;
	}

	/**
	 * 属性要素代码的getter方法
	 */

	@Column(name = "FACTORCODE")
	public String getFactorCode() {
		return this.factorCode;
	}

	/**
	 * 属性要素代码的setter方法
	 */
	public void setFactorCode(String factorCode) {
		this.factorCode = factorCode;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof PDLMCalFactorId)) {
			return false;
		}
		PDLMCalFactorId castOther = (PDLMCalFactorId) other;

		return ((this.getCalCode() == castOther.getCalCode()) || (this
				.getCalCode() != null && castOther.getCalCode() != null && this
				.getCalCode().equals(castOther.getCalCode())))
				&& ((this.getFactorCode() == castOther.getFactorCode()) || (this
						.getFactorCode() != null
						&& castOther.getFactorCode() != null && this
						.getFactorCode().equals(castOther.getFactorCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCalCode() == null ? 0 : this.getCalCode().hashCode());
		result = 37
				* result
				+ (getFactorCode() == null ? 0 : this.getFactorCode()
						.hashCode());
		return result;
	}

}
