package ins.claim.report.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类LLCaseId
 */
@Embeddable
public class LLCaseId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性赔案号 */
	private String caseNo;

	/** 属性出险人客户号 */
	private String customerNo;

	/**
	 * 类LLCaseId的默认构造方法
	 */
	public LLCaseId() {
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
	 * 属性出险人客户号的getter方法
	 */

	@Column(name = "CUSTOMERNO")
	public String getCustomerNo() {
		return this.customerNo;
	}

	/**
	 * 属性出险人客户号的setter方法
	 */
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof LLCaseId)) {
			return false;
		}
		LLCaseId castOther = (LLCaseId) other;

		return ((this.getCaseNo() == castOther.getCaseNo()) || (this
				.getCaseNo() != null && castOther.getCaseNo() != null && this
				.getCaseNo().equals(castOther.getCaseNo())))
				&& ((this.getCustomerNo() == castOther.getCustomerNo()) || (this
						.getCustomerNo() != null
						&& castOther.getCustomerNo() != null && this
						.getCustomerNo().equals(castOther.getCustomerNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCaseNo() == null ? 0 : this.getCaseNo().hashCode());
		result = 37
				* result
				+ (getCustomerNo() == null ? 0 : this.getCustomerNo()
						.hashCode());
		return result;
	}

}
