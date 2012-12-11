package ins.prpall.proposal.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类LCRepInfoId
 */
@Embeddable
public class LCRepInfoId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性集体合同号码 */
	private String grpContNo;

	/** 属性告知编码 */
	private String impartCode;

	/** 属性告知版别 */
	private String impartVer;

	/** 属性内部流水号 */
	private int subSerialNo;

	/**
	 * 类LCRepInfoId的默认构造方法
	 */
	public LCRepInfoId() {
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
	 * 属性告知编码的getter方法
	 */

	@Column(name = "IMPARTCODE")
	public String getImpartCode() {
		return this.impartCode;
	}

	/**
	 * 属性告知编码的setter方法
	 */
	public void setImpartCode(String impartCode) {
		this.impartCode = impartCode;
	}

	/**
	 * 属性告知版别的getter方法
	 */

	@Column(name = "IMPARTVER")
	public String getImpartVer() {
		return this.impartVer;
	}

	/**
	 * 属性告知版别的setter方法
	 */
	public void setImpartVer(String impartVer) {
		this.impartVer = impartVer;
	}

	/**
	 * 属性内部流水号的getter方法
	 */

	@Column(name = "SUBSERIALNO")
	public int getSubSerialNo() {
		return this.subSerialNo;
	}

	/**
	 * 属性内部流水号的setter方法
	 */
	public void setSubSerialNo(int subSerialNo) {
		this.subSerialNo = subSerialNo;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof LCRepInfoId)) {
			return false;
		}
		LCRepInfoId castOther = (LCRepInfoId) other;

		return ((this.getGrpContNo() == castOther.getGrpContNo()) || (this
				.getGrpContNo() != null && castOther.getGrpContNo() != null && this
				.getGrpContNo().equals(castOther.getGrpContNo())))
				&& ((this.getImpartCode() == castOther.getImpartCode()) || (this
						.getImpartCode() != null
						&& castOther.getImpartCode() != null && this
						.getImpartCode().equals(castOther.getImpartCode())))
				&& ((this.getImpartVer() == castOther.getImpartVer()) || (this
						.getImpartVer() != null
						&& castOther.getImpartVer() != null && this
						.getImpartVer().equals(castOther.getImpartVer())))
				&& (this.getSubSerialNo() == castOther.getSubSerialNo());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getGrpContNo() == null ? 0 : this.getGrpContNo().hashCode());
		result = 37
				* result
				+ (getImpartCode() == null ? 0 : this.getImpartCode()
						.hashCode());
		result = 37 * result
				+ (getImpartVer() == null ? 0 : this.getImpartVer().hashCode());
		result = 37 * result + this.getSubSerialNo();
		return result;
	}

}
