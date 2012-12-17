package ins.claim.report.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类LLReportReasonId
 */
@Embeddable
public class LLReportReasonId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性报案号 */
	private String rpNo;

	/** 属性出险人客户号 */
	private String customerNo;

	/** 属性理赔类型 */
	private String reasonCode;

	/** 属性其他号码 */
	private String subRptNo;

	/**
	 * 类LLReportReasonId的默认构造方法
	 */
	public LLReportReasonId() {
	}

	/**
	 * 属性报案号的getter方法
	 */

	@Column(name = "RPNO")
	public String getRpNo() {
		return this.rpNo;
	}

	/**
	 * 属性报案号的setter方法
	 */
	public void setRpNo(String rpNo) {
		this.rpNo = rpNo;
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

	/**
	 * 属性理赔类型的getter方法
	 */

	@Column(name = "REASONCODE")
	public String getReasonCode() {
		return this.reasonCode;
	}

	/**
	 * 属性理赔类型的setter方法
	 */
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
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
		if (!(other instanceof LLReportReasonId)) {
			return false;
		}
		LLReportReasonId castOther = (LLReportReasonId) other;

		return ((this.getRpNo() == castOther.getRpNo()) || (this.getRpNo() != null
				&& castOther.getRpNo() != null && this.getRpNo().equals(
				castOther.getRpNo())))
				&& ((this.getCustomerNo() == castOther.getCustomerNo()) || (this
						.getCustomerNo() != null
						&& castOther.getCustomerNo() != null && this
						.getCustomerNo().equals(castOther.getCustomerNo())))
				&& ((this.getReasonCode() == castOther.getReasonCode()) || (this
						.getReasonCode() != null
						&& castOther.getReasonCode() != null && this
						.getReasonCode().equals(castOther.getReasonCode())))
				&& ((this.getSubRptNo() == castOther.getSubRptNo()) || (this
						.getSubRptNo() != null
						&& castOther.getSubRptNo() != null && this
						.getSubRptNo().equals(castOther.getSubRptNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRpNo() == null ? 0 : this.getRpNo().hashCode());
		result = 37
				* result
				+ (getCustomerNo() == null ? 0 : this.getCustomerNo()
						.hashCode());
		result = 37
				* result
				+ (getReasonCode() == null ? 0 : this.getReasonCode()
						.hashCode());
		result = 37 * result
				+ (getSubRptNo() == null ? 0 : this.getSubRptNo().hashCode());
		return result;
	}

}
