package ins.claim.report.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类LLCaseRelaId
 */
@Embeddable
public class LLCaseRelaId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性事故号 */
	private String caseRelaNo;

	/** 属性赔案号 */
	private String caseNo;

	/** 属性其他号码 */
	private String subRptNo;

	/**
	 * 类LLCaseRelaId的默认构造方法
	 */
	public LLCaseRelaId() {
	}

	/**
	 * 属性事故号的getter方法
	 */

	@Column(name = "CASERELANO")
	public String getCaseRelaNo() {
		return this.caseRelaNo;
	}

	/**
	 * 属性事故号的setter方法
	 */
	public void setCaseRelaNo(String caseRelaNo) {
		this.caseRelaNo = caseRelaNo;
	}

	/**
	 * 属性赔案号的getter方法
	 */

	@Column(name = "CASENO")
	public String getCaseNo() {
		return this.caseNo;
	}

	/**
	 * 属性赔案号的setter方法
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	/**
	 * 属性其他号码的getter方法
	 */

	@Column(name = "SUBRPTNO")
	public String getSubRptNo() {
		return this.subRptNo;
	}

	/**
	 * 属性其他号码的setter方法
	 */
	public void setSubRptNo(String subRptNo) {
		this.subRptNo = subRptNo;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof LLCaseRelaId)) {
			return false;
		}
		LLCaseRelaId castOther = (LLCaseRelaId) other;

		return ((this.getCaseRelaNo() == castOther.getCaseRelaNo()) || (this
				.getCaseRelaNo() != null && castOther.getCaseRelaNo() != null && this
				.getCaseRelaNo().equals(castOther.getCaseRelaNo())))
				&& ((this.getCaseNo() == castOther.getCaseNo()) || (this
						.getCaseNo() != null && castOther.getCaseNo() != null && this
						.getCaseNo().equals(castOther.getCaseNo())))
				&& ((this.getSubRptNo() == castOther.getSubRptNo()) || (this
						.getSubRptNo() != null
						&& castOther.getSubRptNo() != null && this
						.getSubRptNo().equals(castOther.getSubRptNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCaseRelaNo() == null ? 0 : this.getCaseRelaNo()
						.hashCode());
		result = 37 * result
				+ (getCaseNo() == null ? 0 : this.getCaseNo().hashCode());
		result = 37 * result
				+ (getSubRptNo() == null ? 0 : this.getSubRptNo().hashCode());
		return result;
	}

}
