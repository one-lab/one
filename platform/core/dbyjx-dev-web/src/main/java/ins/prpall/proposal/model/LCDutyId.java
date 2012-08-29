package ins.prpall.proposal.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类LCDutyId
 */
@Embeddable
public class LCDutyId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性保单号码 */
	private String polNo;

	/** 属性责任编码 */
	private String dutyCode;

	/**
	 * 类LCDutyId的默认构造方法
	 */
	public LCDutyId() {
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

	/**
	 * 属性责任编码的getter方法
	 */

	@Column(name = "DUTYCODE")
	public String getDutyCode() {
		return this.dutyCode;
	}

	/**
	 * 属性责任编码的setter方法
	 */
	public void setDutyCode(String dutyCode) {
		this.dutyCode = dutyCode;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof LCDutyId)) {
			return false;
		}
		LCDutyId castOther = (LCDutyId) other;

		return ((this.getPolNo() == castOther.getPolNo()) || (this.getPolNo() != null
				&& castOther.getPolNo() != null && this.getPolNo().equals(
				castOther.getPolNo())))
				&& ((this.getDutyCode() == castOther.getDutyCode()) || (this
						.getDutyCode() != null
						&& castOther.getDutyCode() != null && this
						.getDutyCode().equals(castOther.getDutyCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getPolNo() == null ? 0 : this.getPolNo().hashCode());
		result = 37 * result
				+ (getDutyCode() == null ? 0 : this.getDutyCode().hashCode());
		return result;
	}

}
