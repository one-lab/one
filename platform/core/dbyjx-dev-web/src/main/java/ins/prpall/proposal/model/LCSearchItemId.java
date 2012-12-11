package ins.prpall.proposal.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类LCSearchItemId
 */
@Embeddable
public class LCSearchItemId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性集体合同号码 */
	private String grpContNo;

	/** 属性流水号 */
	private int serialNo;

	/** 属性契调项目编号 */
	private String itemNo;

	/**
	 * 类LCSearchItemId的默认构造方法
	 */
	public LCSearchItemId() {
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
	 * 属性契调项目编号的getter方法
	 */

	@Column(name = "ITEMNO")
	public String getItemNo() {
		return this.itemNo;
	}

	/**
	 * 属性契调项目编号的setter方法
	 */
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof LCSearchItemId)) {
			return false;
		}
		LCSearchItemId castOther = (LCSearchItemId) other;

		return ((this.getGrpContNo() == castOther.getGrpContNo()) || (this
				.getGrpContNo() != null && castOther.getGrpContNo() != null && this
				.getGrpContNo().equals(castOther.getGrpContNo())))
				&& (this.getSerialNo() == castOther.getSerialNo())
				&& ((this.getItemNo() == castOther.getItemNo()) || (this
						.getItemNo() != null && castOther.getItemNo() != null && this
						.getItemNo().equals(castOther.getItemNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getGrpContNo() == null ? 0 : this.getGrpContNo().hashCode());
		result = 37 * result + this.getSerialNo();
		result = 37 * result
				+ (getItemNo() == null ? 0 : this.getItemNo().hashCode());
		return result;
	}

}
