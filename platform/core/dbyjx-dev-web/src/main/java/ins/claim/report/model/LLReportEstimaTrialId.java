package ins.claim.report.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类LLReportEstimaTrialId
 */
@Embeddable
public class LLReportEstimaTrialId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性赔案号 */
	private String caseNo;

	/** 属性出险人客户号 */
	private String customerNo;

	/** 属性理赔类型 */
	private String reasonCode;

	/** 属性赔付结论 */
	private String giveType;

	/** 属性保单号码 */
	private String polNo;

	/**
	 * 类LLReportEstimaTrialId的默认构造方法
	 */
	public LLReportEstimaTrialId() {
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
	 * 属性赔付结论的getter方法
	 */

	@Column(name = "GIVETYPE")
	public String getGiveType() {
		return this.giveType;
	}

	/**
	 * 属性赔付结论的setter方法
	 */
	public void setGiveType(String giveType) {
		this.giveType = giveType;
	}

	/**
	 * 属性保单号码的getter方法
	 */

	@Column(name = "POLNO")
	public String getPolNo() {
		return this.polNo;
	}

	/**
	 * 属性保单号码的setter方法
	 */
	public void setPolNo(String polNo) {
		this.polNo = polNo;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof LLReportEstimaTrialId)) {
			return false;
		}
		LLReportEstimaTrialId castOther = (LLReportEstimaTrialId) other;

		return ((this.getCaseNo() == castOther.getCaseNo()) || (this
				.getCaseNo() != null && castOther.getCaseNo() != null && this
				.getCaseNo().equals(castOther.getCaseNo())))
				&& ((this.getCustomerNo() == castOther.getCustomerNo()) || (this
						.getCustomerNo() != null
						&& castOther.getCustomerNo() != null && this
						.getCustomerNo().equals(castOther.getCustomerNo())))
				&& ((this.getReasonCode() == castOther.getReasonCode()) || (this
						.getReasonCode() != null
						&& castOther.getReasonCode() != null && this
						.getReasonCode().equals(castOther.getReasonCode())))
				&& ((this.getGiveType() == castOther.getGiveType()) || (this
						.getGiveType() != null
						&& castOther.getGiveType() != null && this
						.getGiveType().equals(castOther.getGiveType())))
				&& ((this.getPolNo() == castOther.getPolNo()) || (this
						.getPolNo() != null && castOther.getPolNo() != null && this
						.getPolNo().equals(castOther.getPolNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCaseNo() == null ? 0 : this.getCaseNo().hashCode());
		result = 37
				* result
				+ (getCustomerNo() == null ? 0 : this.getCustomerNo()
						.hashCode());
		result = 37
				* result
				+ (getReasonCode() == null ? 0 : this.getReasonCode()
						.hashCode());
		result = 37 * result
				+ (getGiveType() == null ? 0 : this.getGiveType().hashCode());
		result = 37 * result
				+ (getPolNo() == null ? 0 : this.getPolNo().hashCode());
		return result;
	}

}
