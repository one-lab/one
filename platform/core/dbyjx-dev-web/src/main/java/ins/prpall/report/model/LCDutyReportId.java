package ins.prpall.report.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类LCDutyReportId
 */
@Embeddable
public class LCDutyReportId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性呈报申请号 */
	private String repNo;

	/** 属性保单号码 */
	private String polNo;

	/** 属性责任编码 */
	private String dutyCode;

	/**
	 * 类LCDutyReportId的默认构造方法
	 */
	public LCDutyReportId() {
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
		if (!(other instanceof LCDutyReportId)) {
			return false;
		}
		LCDutyReportId castOther = (LCDutyReportId) other;

		return ((this.getRepNo() == castOther.getRepNo()) || (this.getRepNo() != null
				&& castOther.getRepNo() != null && this.getRepNo().equals(
				castOther.getRepNo())))
				&& ((this.getPolNo() == castOther.getPolNo()) || (this
						.getPolNo() != null && castOther.getPolNo() != null && this
						.getPolNo().equals(castOther.getPolNo())))
				&& ((this.getDutyCode() == castOther.getDutyCode()) || (this
						.getDutyCode() != null
						&& castOther.getDutyCode() != null && this
						.getDutyCode().equals(castOther.getDutyCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRepNo() == null ? 0 : this.getRepNo().hashCode());
		result = 37 * result
				+ (getPolNo() == null ? 0 : this.getPolNo().hashCode());
		result = 37 * result
				+ (getDutyCode() == null ? 0 : this.getDutyCode().hashCode());
		return result;
	}

}
