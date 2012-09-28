package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类PDLDRiskComOperateId
 */
@Embeddable
public class PDLDRiskComOperateId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性险种代码 */
	private String riskCode;

	/** 属性管理机构 */
	private String manageCom;

	/** 属性机构代码 */
	private String comCode;

	/** 属性功能标识 */
	private String operateType;

	/**
	 * 类PDLDRiskComOperateId的默认构造方法
	 */
	public PDLDRiskComOperateId() {
	}

	/**
	 * 属性险种代码的getter方法
	 */

	@Column(name = "RISKCODE")
	public String getRiskCode() {
		return this.riskCode;
	}

	/**
	 * 属性险种代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	/**
	 * 属性管理机构的getter方法
	 */

	@Column(name = "MANAGECOM")
	public String getManageCom() {
		return this.manageCom;
	}

	/**
	 * 属性管理机构的setter方法
	 */
	public void setManageCom(String manageCom) {
		this.manageCom = manageCom;
	}

	/**
	 * 属性机构代码的getter方法
	 */

	@Column(name = "COMCODE")
	public String getComCode() {
		return this.comCode;
	}

	/**
	 * 属性机构代码的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	/**
	 * 属性功能标识的getter方法
	 */

	@Column(name = "OPERATETYPE")
	public String getOperateType() {
		return this.operateType;
	}

	/**
	 * 属性功能标识的setter方法
	 */
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof PDLDRiskComOperateId)) {
			return false;
		}
		PDLDRiskComOperateId castOther = (PDLDRiskComOperateId) other;

		return ((this.getRiskCode() == castOther.getRiskCode()) || (this
				.getRiskCode() != null && castOther.getRiskCode() != null && this
				.getRiskCode().equals(castOther.getRiskCode())))
				&& ((this.getManageCom() == castOther.getManageCom()) || (this
						.getManageCom() != null
						&& castOther.getManageCom() != null && this
						.getManageCom().equals(castOther.getManageCom())))
				&& ((this.getComCode() == castOther.getComCode()) || (this
						.getComCode() != null && castOther.getComCode() != null && this
						.getComCode().equals(castOther.getComCode())))
				&& ((this.getOperateType() == castOther.getOperateType()) || (this
						.getOperateType() != null
						&& castOther.getOperateType() != null && this
						.getOperateType().equals(castOther.getOperateType())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRiskCode() == null ? 0 : this.getRiskCode().hashCode());
		result = 37 * result
				+ (getManageCom() == null ? 0 : this.getManageCom().hashCode());
		result = 37 * result
				+ (getComCode() == null ? 0 : this.getComCode().hashCode());
		result = 37
				* result
				+ (getOperateType() == null ? 0 : this.getOperateType()
						.hashCode());
		return result;
	}

}
