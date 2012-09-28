package ins.prpall.proposal.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类LCSearchInfoId
 */
@Embeddable
public class LCSearchInfoId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性流水号 */
	private int serialNo;

	/** 属性集体合同号码 */
	private String grpContNo;

	/**
	 * 类LCSearchInfoId的默认构造方法
	 */
	public LCSearchInfoId() {
	}

	/**
	 * 属性流水号的getter方法
	 */

	@Column(name = "SERIALNO")
	public int getSerialNo() {
		return this.serialNo;
	}

	/**
	 * 属性流水号的setter方法
	 */
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	/**
	 * 属性集体合同号码的getter方法
	 */

	@Column(name = "GRPCONTNO")
	public String getGrpContNo() {
		return this.grpContNo;
	}

	/**
	 * 属性集体合同号码的setter方法
	 */
	public void setGrpContNo(String grpContNo) {
		this.grpContNo = grpContNo;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof LCSearchInfoId)) {
			return false;
		}
		LCSearchInfoId castOther = (LCSearchInfoId) other;

		return (this.getSerialNo() == castOther.getSerialNo())
				&& ((this.getGrpContNo() == castOther.getGrpContNo()) || (this
						.getGrpContNo() != null
						&& castOther.getGrpContNo() != null && this
						.getGrpContNo().equals(castOther.getGrpContNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getSerialNo();
		result = 37 * result
				+ (getGrpContNo() == null ? 0 : this.getGrpContNo().hashCode());
		return result;
	}

}
