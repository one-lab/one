package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类PDLMDutyGetClmId
 */
@Embeddable
public class PDLMDutyGetClmId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性给付代码 */
	private String getDutyCode;

	/** 属性给付责任类型 */
	private String getDutyKind;

	/**
	 * 类PDLMDutyGetClmId的默认构造方法
	 */
	public PDLMDutyGetClmId() {
	}

	/**
	 * 属性给付代码的getter方法
	 */

	@Column(name = "GETDUTYCODE")
	public String getGetDutyCode() {
		return this.getDutyCode;
	}

	/**
	 * 属性给付代码的setter方法
	 */
	public void setGetDutyCode(String getDutyCode) {
		this.getDutyCode = getDutyCode;
	}

	/**
	 * 属性给付责任类型的getter方法
	 */

	@Column(name = "GETDUTYKIND")
	public String getGetDutyKind() {
		return this.getDutyKind;
	}

	/**
	 * 属性给付责任类型的setter方法
	 */
	public void setGetDutyKind(String getDutyKind) {
		this.getDutyKind = getDutyKind;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof PDLMDutyGetClmId)) {
			return false;
		}
		PDLMDutyGetClmId castOther = (PDLMDutyGetClmId) other;

		return ((this.getGetDutyCode() == castOther.getGetDutyCode()) || (this
				.getGetDutyCode() != null && castOther.getGetDutyCode() != null && this
				.getGetDutyCode().equals(castOther.getGetDutyCode())))
				&& ((this.getGetDutyKind() == castOther.getGetDutyKind()) || (this
						.getGetDutyKind() != null
						&& castOther.getGetDutyKind() != null && this
						.getGetDutyKind().equals(castOther.getGetDutyKind())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getGetDutyCode() == null ? 0 : this.getGetDutyCode()
						.hashCode());
		result = 37
				* result
				+ (getGetDutyKind() == null ? 0 : this.getGetDutyKind()
						.hashCode());
		return result;
	}

}
