package ins.claim.manage.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类LLInqCourseId
 */
@Embeddable
public class LLInqCourseId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性赔案号 */
	private String clmNo;

	/** 属性调查序号 */
	private String inqNo;

	/** 属性过程序号 */
	private String couNo;

	/**
	 * 类LLInqCourseId的默认构造方法
	 */
	public LLInqCourseId() {
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
	 * 属性调查序号的getter方法
	 */

	@Column(name = "INQNO")
	public String getInqNo() {
		return this.inqNo;
	}

	/**
	 * 属性调查序号的setter方法
	 */
	public void setInqNo(String inqNo) {
		this.inqNo = inqNo;
	}

	/**
	 * 属性过程序号的getter方法
	 */

	@Column(name = "COUNO")
	public String getCouNo() {
		return this.couNo;
	}

	/**
	 * 属性过程序号的setter方法
	 */
	public void setCouNo(String couNo) {
		this.couNo = couNo;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof LLInqCourseId)) {
			return false;
		}
		LLInqCourseId castOther = (LLInqCourseId) other;

		return ((this.getClmNo() == castOther.getClmNo()) || (this.getClmNo() != null
				&& castOther.getClmNo() != null && this.getClmNo().equals(
				castOther.getClmNo())))
				&& ((this.getInqNo() == castOther.getInqNo()) || (this
						.getInqNo() != null && castOther.getInqNo() != null && this
						.getInqNo().equals(castOther.getInqNo())))
				&& ((this.getCouNo() == castOther.getCouNo()) || (this
						.getCouNo() != null && castOther.getCouNo() != null && this
						.getCouNo().equals(castOther.getCouNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getClmNo() == null ? 0 : this.getClmNo().hashCode());
		result = 37 * result
				+ (getInqNo() == null ? 0 : this.getInqNo().hashCode());
		result = 37 * result
				+ (getCouNo() == null ? 0 : this.getCouNo().hashCode());
		return result;
	}

}
