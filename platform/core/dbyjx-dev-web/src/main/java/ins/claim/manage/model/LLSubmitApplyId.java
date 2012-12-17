package ins.claim.manage.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类LLSubmitApplyId
 */
@Embeddable
public class LLSubmitApplyId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性赔案号 */
	private String clmNo;

	/** 属性呈报序号 */
	private String subNo;

	/** 属性呈报次数 */
	private String subCount;

	/**
	 * 类LLSubmitApplyId的默认构造方法
	 */
	public LLSubmitApplyId() {
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
	 * 属性呈报序号的getter方法
	 */

	@Column(name = "SUBNO")
	public String getSubNo() {
		return this.subNo;
	}

	/**
	 * 属性呈报序号的setter方法
	 */
	public void setSubNo(String subNo) {
		this.subNo = subNo;
	}

	/**
	 * 属性呈报次数的getter方法
	 */

	@Column(name = "SUBCOUNT")
	public String getSubCount() {
		return this.subCount;
	}

	/**
	 * 属性呈报次数的setter方法
	 */
	public void setSubCount(String subCount) {
		this.subCount = subCount;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof LLSubmitApplyId)) {
			return false;
		}
		LLSubmitApplyId castOther = (LLSubmitApplyId) other;

		return ((this.getClmNo() == castOther.getClmNo()) || (this.getClmNo() != null
				&& castOther.getClmNo() != null && this.getClmNo().equals(
				castOther.getClmNo())))
				&& ((this.getSubNo() == castOther.getSubNo()) || (this
						.getSubNo() != null && castOther.getSubNo() != null && this
						.getSubNo().equals(castOther.getSubNo())))
				&& ((this.getSubCount() == castOther.getSubCount()) || (this
						.getSubCount() != null
						&& castOther.getSubCount() != null && this
						.getSubCount().equals(castOther.getSubCount())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getClmNo() == null ? 0 : this.getClmNo().hashCode());
		result = 37 * result
				+ (getSubNo() == null ? 0 : this.getSubNo().hashCode());
		result = 37 * result
				+ (getSubCount() == null ? 0 : this.getSubCount().hashCode());
		return result;
	}

}
