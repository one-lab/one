package ins.prpall.proposal.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类LCInsuredId
 */
@Embeddable
public class LCInsuredId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性合同号码 */
	private String contNo;

	/** 属性被保人客户号码 */
	private String insuredNo;

	/**
	 * 类LCInsuredId的默认构造方法
	 */
	public LCInsuredId() {
	}

	/**
	 * 属性合同号码的getter方法
	 */

	@Column(name = "CONTNO")
	public String getContNo() {
		return this.contNo;
	}

	/**
	 * 属性合同号码的setter方法
	 */
	public void setContNo(String contNo) {
		this.contNo = contNo;
	}

	/**
	 * 属性被保人客户号码的getter方法
	 */

	@Column(name = "INSUREDNO")
	public String getInsuredNo() {
		return this.insuredNo;
	}

	/**
	 * 属性被保人客户号码的setter方法
	 */
	public void setInsuredNo(String insuredNo) {
		this.insuredNo = insuredNo;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof LCInsuredId)) {
			return false;
		}
		LCInsuredId castOther = (LCInsuredId) other;

		return ((this.getContNo() == castOther.getContNo()) || (this
				.getContNo() != null && castOther.getContNo() != null && this
				.getContNo().equals(castOther.getContNo())))
				&& ((this.getInsuredNo() == castOther.getInsuredNo()) || (this
						.getInsuredNo() != null
						&& castOther.getInsuredNo() != null && this
						.getInsuredNo().equals(castOther.getInsuredNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getContNo() == null ? 0 : this.getContNo().hashCode());
		result = 37 * result
				+ (getInsuredNo() == null ? 0 : this.getInsuredNo().hashCode());
		return result;
	}

}
