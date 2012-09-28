package ins.prpall.report.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类LCRepInfoReportId
 */
@Embeddable
public class LCRepInfoReportId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性告知编码 */
	private String impartCode;

	/** 属性告知版别 */
	private String impartVer;

	/** 属性内部流水号 */
	private int subSerialNo;

	/** 属性呈报申请号 */
	private String repNo;

	/**
	 * 类LCRepInfoReportId的默认构造方法
	 */
	public LCRepInfoReportId() {
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

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof LCRepInfoReportId)) {
			return false;
		}
		LCRepInfoReportId castOther = (LCRepInfoReportId) other;

		return ((this.getImpartCode() == castOther.getImpartCode()) || (this
				.getImpartCode() != null && castOther.getImpartCode() != null && this
				.getImpartCode().equals(castOther.getImpartCode())))
				&& ((this.getImpartVer() == castOther.getImpartVer()) || (this
						.getImpartVer() != null
						&& castOther.getImpartVer() != null && this
						.getImpartVer().equals(castOther.getImpartVer())))
				&& (this.getSubSerialNo() == castOther.getSubSerialNo())
				&& ((this.getRepNo() == castOther.getRepNo()) || (this
						.getRepNo() != null && castOther.getRepNo() != null && this
						.getRepNo().equals(castOther.getRepNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getImpartCode() == null ? 0 : this.getImpartCode()
						.hashCode());
		result = 37 * result
				+ (getImpartVer() == null ? 0 : this.getImpartVer().hashCode());
		result = 37 * result + this.getSubSerialNo();
		result = 37 * result
				+ (getRepNo() == null ? 0 : this.getRepNo().hashCode());
		return result;
	}

}
