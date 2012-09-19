package ins.claim.report.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类LLSubReportId
 */
@Embeddable
public class LLSubReportId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性其他号码 */
	private String subRptNo;

	/** 属性出险人客户号 */
	private String customerNo;

	/**
	 * 类LLSubReportId的默认构造方法
	 */
	public LLSubReportId() {
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
		if (!(other instanceof LLSubReportId)) {
			return false;
		}
		LLSubReportId castOther = (LLSubReportId) other;

		return ((this.getSubRptNo() == castOther.getSubRptNo()) || (this
				.getSubRptNo() != null && castOther.getSubRptNo() != null && this
				.getSubRptNo().equals(castOther.getSubRptNo())))
				&& ((this.getCustomerNo() == castOther.getCustomerNo()) || (this
						.getCustomerNo() != null
						&& castOther.getCustomerNo() != null && this
						.getCustomerNo().equals(castOther.getCustomerNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSubRptNo() == null ? 0 : this.getSubRptNo().hashCode());
		result = 37
				* result
				+ (getCustomerNo() == null ? 0 : this.getCustomerNo()
						.hashCode());
		return result;
	}

}
