package ins.prpall.report.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类LCGrpPolReportId
 */
@Embeddable
public class LCGrpPolReportId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性呈报申请号 */
	private String repNo;

	/** 属性集体保单险种号码 */
	private String grpPolNo;

	/**
	 * 类LCGrpPolReportId的默认构造方法
	 */
	public LCGrpPolReportId() {
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
	 * 属性集体保单险种号码的getter方法
	 */

	@Column(name = "GRPPOLNO")
	public String getGrpPolNo() {
		return this.grpPolNo;
	}

	/**
	 * 属性集体保单险种号码的setter方法
	 */
	public void setGrpPolNo(String grpPolNo) {
		this.grpPolNo = grpPolNo;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof LCGrpPolReportId)) {
			return false;
		}
		LCGrpPolReportId castOther = (LCGrpPolReportId) other;

		return ((this.getRepNo() == castOther.getRepNo()) || (this.getRepNo() != null
				&& castOther.getRepNo() != null && this.getRepNo().equals(
				castOther.getRepNo())))
				&& ((this.getGrpPolNo() == castOther.getGrpPolNo()) || (this
						.getGrpPolNo() != null
						&& castOther.getGrpPolNo() != null && this
						.getGrpPolNo().equals(castOther.getGrpPolNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRepNo() == null ? 0 : this.getRepNo().hashCode());
		result = 37 * result
				+ (getGrpPolNo() == null ? 0 : this.getGrpPolNo().hashCode());
		return result;
	}

}
