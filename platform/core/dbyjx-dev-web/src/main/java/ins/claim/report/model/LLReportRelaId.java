package ins.claim.report.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类LLReportRelaId
 */
@Embeddable
public class LLReportRelaId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性其他号码 */
	private String subRptNo;

	/** 属性团体报案号 */
	private String rptNo;

	/**
	 * 类LLReportRelaId的默认构造方法
	 */
	public LLReportRelaId() {
	}

	/**
	 * 属性其他号码的getter方法
	 */

	@Column(name = "SUBRPTNO")
	public String getSubRptNo() {
		return this.subRptNo;
	}

	/**
	 * 属性其他号码的setter方法
	 */
	public void setSubRptNo(String subRptNo) {
		this.subRptNo = subRptNo;
	}

	/**
	 * 属性团体报案号的getter方法
	 */

	@Column(name = "RPTNO")
	public String getRptNo() {
		return this.rptNo;
	}

	/**
	 * 属性团体报案号的setter方法
	 */
	public void setRptNo(String rptNo) {
		this.rptNo = rptNo;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof LLReportRelaId)) {
			return false;
		}
		LLReportRelaId castOther = (LLReportRelaId) other;

		return ((this.getSubRptNo() == castOther.getSubRptNo()) || (this
				.getSubRptNo() != null && castOther.getSubRptNo() != null && this
				.getSubRptNo().equals(castOther.getSubRptNo())))
				&& ((this.getRptNo() == castOther.getRptNo()) || (this
						.getRptNo() != null && castOther.getRptNo() != null && this
						.getRptNo().equals(castOther.getRptNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSubRptNo() == null ? 0 : this.getSubRptNo().hashCode());
		result = 37 * result
				+ (getRptNo() == null ? 0 : this.getRptNo().hashCode());
		return result;
	}

}
