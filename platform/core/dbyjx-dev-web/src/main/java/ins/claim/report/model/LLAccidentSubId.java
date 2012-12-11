package ins.claim.report.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类LLAccidentSubId
 */
@Embeddable
public class LLAccidentSubId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性事件号 */
	private String accNo;

	/** 属性出险人客户号 */
	private String customerNo;

	/**
	 * 类LLAccidentSubId的默认构造方法
	 */
	public LLAccidentSubId() {
	}

	/**
	 * 属性事件号的getter方法
	 */

	@Column(name = "ACCNO")
	public String getAccNo() {
		return this.accNo;
	}

	/**
	 * 属性事件号的setter方法
	 */
	public void setAccNo(String accNo) {
		this.accNo = accNo;
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
		if (!(other instanceof LLAccidentSubId)) {
			return false;
		}
		LLAccidentSubId castOther = (LLAccidentSubId) other;

		return ((this.getAccNo() == castOther.getAccNo()) || (this.getAccNo() != null
				&& castOther.getAccNo() != null && this.getAccNo().equals(
				castOther.getAccNo())))
				&& ((this.getCustomerNo() == castOther.getCustomerNo()) || (this
						.getCustomerNo() != null
						&& castOther.getCustomerNo() != null && this
						.getCustomerNo().equals(castOther.getCustomerNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getAccNo() == null ? 0 : this.getAccNo().hashCode());
		result = 37
				* result
				+ (getCustomerNo() == null ? 0 : this.getCustomerNo()
						.hashCode());
		return result;
	}

}
