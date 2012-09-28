package ins.claim.manage.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类LLInqFeeId
 */
@Embeddable
public class LLInqFeeId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性赔案号 */
	private String clmNo;

	/** 属性调查序号 */
	private String inqNo;

	/** 属性调查机构 */
	private String inqDept;

	/** 属性费用类型 */
	private String feeType;

	/**
	 * 类LLInqFeeId的默认构造方法
	 */
	public LLInqFeeId() {
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
	 * 属性调查机构的getter方法
	 */

	@Column(name = "INQDEPT")
	public String getInqDept() {
		return this.inqDept;
	}

	/**
	 * 属性调查机构的setter方法
	 */
	public void setInqDept(String inqDept) {
		this.inqDept = inqDept;
	}

	/**
	 * 属性费用类型的getter方法
	 */

	@Column(name = "FEETYPE")
	public String getFeeType() {
		return this.feeType;
	}

	/**
	 * 属性费用类型的setter方法
	 */
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof LLInqFeeId)) {
			return false;
		}
		LLInqFeeId castOther = (LLInqFeeId) other;

		return ((this.getClmNo() == castOther.getClmNo()) || (this.getClmNo() != null
				&& castOther.getClmNo() != null && this.getClmNo().equals(
				castOther.getClmNo())))
				&& ((this.getInqNo() == castOther.getInqNo()) || (this
						.getInqNo() != null && castOther.getInqNo() != null && this
						.getInqNo().equals(castOther.getInqNo())))
				&& ((this.getInqDept() == castOther.getInqDept()) || (this
						.getInqDept() != null && castOther.getInqDept() != null && this
						.getInqDept().equals(castOther.getInqDept())))
				&& ((this.getFeeType() == castOther.getFeeType()) || (this
						.getFeeType() != null && castOther.getFeeType() != null && this
						.getFeeType().equals(castOther.getFeeType())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getClmNo() == null ? 0 : this.getClmNo().hashCode());
		result = 37 * result
				+ (getInqNo() == null ? 0 : this.getInqNo().hashCode());
		result = 37 * result
				+ (getInqDept() == null ? 0 : this.getInqDept().hashCode());
		result = 37 * result
				+ (getFeeType() == null ? 0 : this.getFeeType().hashCode());
		return result;
	}

}
