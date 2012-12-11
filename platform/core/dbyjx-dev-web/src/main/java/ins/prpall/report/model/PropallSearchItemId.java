package ins.prpall.report.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类PropallSearchItemId
 */
@Embeddable
public class PropallSearchItemId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性呈报申请号 */
	private String repNo;

	/** 属性流水号 */
	private int serialNo;

	/** 属性契调项目编号 */
	private String itemNo;

	/**
	 * 类PropallSearchItemId的默认构造方法
	 */
	public PropallSearchItemId() {
	}

	/**
	 * 属性呈报申请号的getter方法
	 */

	@Column(name = "REPNO")
	public String getRepNo() {
		return this.repNo;
	}

	/**
	 * 属性呈报申请号的setter方法
	 */
	public void setRepNo(String repNo) {
		this.repNo = repNo;
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
		if (!(other instanceof PropallSearchItemId)) {
			return false;
		}
		PropallSearchItemId castOther = (PropallSearchItemId) other;

		return ((this.getRepNo() == castOther.getRepNo()) || (this.getRepNo() != null
				&& castOther.getRepNo() != null && this.getRepNo().equals(
				castOther.getRepNo())))
				&& (this.getSerialNo() == castOther.getSerialNo())
				&& ((this.getItemNo() == castOther.getItemNo()) || (this
						.getItemNo() != null && castOther.getItemNo() != null && this
						.getItemNo().equals(castOther.getItemNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRepNo() == null ? 0 : this.getRepNo().hashCode());
		result = 37 * result + this.getSerialNo();
		result = 37 * result
				+ (getItemNo() == null ? 0 : this.getItemNo().hashCode());
		return result;
	}

}
