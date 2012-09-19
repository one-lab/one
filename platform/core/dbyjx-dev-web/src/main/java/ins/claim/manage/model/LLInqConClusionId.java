package ins.claim.manage.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类LLInqConClusionId
 */
@Embeddable
public class LLInqConClusionId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性赔案号 */
	private String clmNo;

	/** 属性结论序号 */
	private String conNo;

	/**
	 * 类LLInqConClusionId的默认构造方法
	 */
	public LLInqConClusionId() {
	}

	/**
	 * 属性赔案号的getter方法
	 */

	@Column(name = "CLMNO")
	public String getClmNo() {
		return this.clmNo;
	}

	/**
	 * 属性赔案号的setter方法
	 */
	public void setClmNo(String clmNo) {
		this.clmNo = clmNo;
	}

	/**
	 * 属性结论序号的getter方法
	 */

	@Column(name = "CONNO")
	public String getConNo() {
		return this.conNo;
	}

	/**
	 * 属性结论序号的setter方法
	 */
	public void setConNo(String conNo) {
		this.conNo = conNo;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof LLInqConClusionId)) {
			return false;
		}
		LLInqConClusionId castOther = (LLInqConClusionId) other;

		return ((this.getClmNo() == castOther.getClmNo()) || (this.getClmNo() != null
				&& castOther.getClmNo() != null && this.getClmNo().equals(
				castOther.getClmNo())))
				&& ((this.getConNo() == castOther.getConNo()) || (this
						.getConNo() != null && castOther.getConNo() != null && this
						.getConNo().equals(castOther.getConNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getClmNo() == null ? 0 : this.getClmNo().hashCode());
		result = 37 * result
				+ (getConNo() == null ? 0 : this.getConNo().hashCode());
		return result;
	}

}
