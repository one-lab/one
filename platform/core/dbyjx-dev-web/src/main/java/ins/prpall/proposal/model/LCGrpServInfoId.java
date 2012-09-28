package ins.prpall.proposal.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类LCGrpServInfoId
 */
@Embeddable
public class LCGrpServInfoId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性集体合同号码 */
	private String grpContNo;

	/** 属性服务类型 */
	private String servKind;

	/** 属性服务明细 */
	private String servDetail;

	/**
	 * 类LCGrpServInfoId的默认构造方法
	 */
	public LCGrpServInfoId() {
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
	 * 属性服务类型的getter方法
	 */

	@Column(name = "SERVKIND")
	public String getServKind() {
		return this.servKind;
	}

	/**
	 * 属性服务类型的setter方法
	 */
	public void setServKind(String servKind) {
		this.servKind = servKind;
	}

	/**
	 * 属性服务明细的getter方法
	 */

	@Column(name = "SERVDETAIL")
	public String getServDetail() {
		return this.servDetail;
	}

	/**
	 * 属性服务明细的setter方法
	 */
	public void setServDetail(String servDetail) {
		this.servDetail = servDetail;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof LCGrpServInfoId)) {
			return false;
		}
		LCGrpServInfoId castOther = (LCGrpServInfoId) other;

		return ((this.getGrpContNo() == castOther.getGrpContNo()) || (this
				.getGrpContNo() != null && castOther.getGrpContNo() != null && this
				.getGrpContNo().equals(castOther.getGrpContNo())))
				&& ((this.getServKind() == castOther.getServKind()) || (this
						.getServKind() != null
						&& castOther.getServKind() != null && this
						.getServKind().equals(castOther.getServKind())))
				&& ((this.getServDetail() == castOther.getServDetail()) || (this
						.getServDetail() != null
						&& castOther.getServDetail() != null && this
						.getServDetail().equals(castOther.getServDetail())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getGrpContNo() == null ? 0 : this.getGrpContNo().hashCode());
		result = 37 * result
				+ (getServKind() == null ? 0 : this.getServKind().hashCode());
		result = 37
				* result
				+ (getServDetail() == null ? 0 : this.getServDetail()
						.hashCode());
		return result;
	}

}
