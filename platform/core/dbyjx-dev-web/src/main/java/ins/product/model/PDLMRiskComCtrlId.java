package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类PDLMRiskComCtrlId
 */
@Embeddable
public class PDLMRiskComCtrlId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性险种代码 */
	private String riskCode;

	/** 属性管理机构 */
	private String manageComGrp;

	/**
	 * 类PDLMRiskComCtrlId的默认构造方法
	 */
	public PDLMRiskComCtrlId() {
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

	@Column(name = "MANAGECOMGRP")
	public String getManageComGrp() {
		return this.manageComGrp;
	}

	/**
	 * 属性管理机构的setter方法
	 */
	public void setManageComGrp(String manageComGrp) {
		this.manageComGrp = manageComGrp;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof PDLMRiskComCtrlId)) {
			return false;
		}
		PDLMRiskComCtrlId castOther = (PDLMRiskComCtrlId) other;

		return ((this.getRiskCode() == castOther.getRiskCode()) || (this
				.getRiskCode() != null && castOther.getRiskCode() != null && this
				.getRiskCode().equals(castOther.getRiskCode())))
				&& ((this.getManageComGrp() == castOther.getManageComGrp()) || (this
						.getManageComGrp() != null
						&& castOther.getManageComGrp() != null && this
						.getManageComGrp().equals(castOther.getManageComGrp())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRiskCode() == null ? 0 : this.getRiskCode().hashCode());
		result = 37
				* result
				+ (getManageComGrp() == null ? 0 : this.getManageComGrp()
						.hashCode());
		return result;
	}

}
