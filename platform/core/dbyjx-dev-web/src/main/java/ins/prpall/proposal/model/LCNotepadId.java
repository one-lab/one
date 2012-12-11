package ins.prpall.proposal.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类LCNotepadId
 */
@Embeddable
public class LCNotepadId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性流水号 */
	private int serialNo;

	/** 属性业务号 */
	private String bussinessNo;

	/**
	 * 类LCNotepadId的默认构造方法
	 */
	public LCNotepadId() {
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
	 * 属性业务号的getter方法
	 */

	@Column(name = "BUSSINESSNO")
	public String getBussinessNo() {
		return this.bussinessNo;
	}

	/**
	 * 属性业务号的setter方法
	 */
	public void setBussinessNo(String bussinessNo) {
		this.bussinessNo = bussinessNo;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof LCNotepadId)) {
			return false;
		}
		LCNotepadId castOther = (LCNotepadId) other;

		return (this.getSerialNo() == castOther.getSerialNo())
				&& ((this.getBussinessNo() == castOther.getBussinessNo()) || (this
						.getBussinessNo() != null
						&& castOther.getBussinessNo() != null && this
						.getBussinessNo().equals(castOther.getBussinessNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getSerialNo();
		result = 37
				* result
				+ (getBussinessNo() == null ? 0 : this.getBussinessNo()
						.hashCode());
		return result;
	}

}
