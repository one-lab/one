package ins.prpall.report.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类LCContReportId
 */
@Embeddable
public class LCContReportId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性呈报申请号 */
	private String repNo;

	/** 属性合同号码 */
	private String contNo;

	/**
	 * 类LCContReportId的默认构造方法
	 */
	public LCContReportId() {
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

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof LCContReportId)) {
			return false;
		}
		LCContReportId castOther = (LCContReportId) other;

		return ((this.getRepNo() == castOther.getRepNo()) || (this.getRepNo() != null
				&& castOther.getRepNo() != null && this.getRepNo().equals(
				castOther.getRepNo())))
				&& ((this.getContNo() == castOther.getContNo()) || (this
						.getContNo() != null && castOther.getContNo() != null && this
						.getContNo().equals(castOther.getContNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRepNo() == null ? 0 : this.getRepNo().hashCode());
		result = 37 * result
				+ (getContNo() == null ? 0 : this.getContNo().hashCode());
		return result;
	}

}
