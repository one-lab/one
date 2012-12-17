package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类PDLDcode1Id
 */
@Embeddable
public class PDLDcode1Id implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性编码类型 */
	private String codeType;

	/** 属性算法模板代码 */
	private String code;

	/**
	 * 类PDLDcode1Id的默认构造方法
	 */
	public PDLDcode1Id() {
	}

	/**
	 * 属性编码类型的getter方法
	 */

	@Column(name = "CODETYPE")
	public String getCodeType() {
		return this.codeType;
	}

	/**
	 * 属性编码类型的setter方法
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	/**
	 * 属性算法模板代码的getter方法
	 */

	@Column(name = "CODE")
	public String getCode() {
		return this.code;
	}

	/**
	 * 属性算法模板代码的setter方法
	 */
	public void setCode(String code) {
		this.code = code;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof PDLDcode1Id)) {
			return false;
		}
		PDLDcode1Id castOther = (PDLDcode1Id) other;

		return ((this.getCodeType() == castOther.getCodeType()) || (this
				.getCodeType() != null && castOther.getCodeType() != null && this
				.getCodeType().equals(castOther.getCodeType())))
				&& ((this.getCode() == castOther.getCode()) || (this.getCode() != null
						&& castOther.getCode() != null && this.getCode()
						.equals(castOther.getCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCodeType() == null ? 0 : this.getCodeType().hashCode());
		result = 37 * result
				+ (getCode() == null ? 0 : this.getCode().hashCode());
		return result;
	}

}
