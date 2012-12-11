package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类PDLMRiskRelaId
 */
@Embeddable
public class PDLMRiskRelaId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性险种代码 */
	private String riskCode;

	/** 属性关联险种编码 */
	private String relaRiskCode;

	/** 属性险种之间的关系 */
	private String relaCode;

	/** 属性管理机构 */
	private String manageComGrp;

	/**
	 * 类PDLMRiskRelaId的默认构造方法
	 */
	public PDLMRiskRelaId() {
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
	 * 属性关联险种编码的getter方法
	 */

	@Column(name = "RELARISKCODE")
	public String getRelaRiskCode() {
		return this.relaRiskCode;
	}

	/**
	 * 属性关联险种编码的setter方法
	 */
	public void setRelaRiskCode(String relaRiskCode) {
		this.relaRiskCode = relaRiskCode;
	}

	/**
	 * 属性险种之间的关系的getter方法
	 */

	@Column(name = "RELACODE")
	public String getRelaCode() {
		return this.relaCode;
	}

	/**
	 * 属性险种之间的关系的setter方法
	 */
	public void setRelaCode(String relaCode) {
		this.relaCode = relaCode;
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
		if (!(other instanceof PDLMRiskRelaId)) {
			return false;
		}
		PDLMRiskRelaId castOther = (PDLMRiskRelaId) other;

		return ((this.getRiskCode() == castOther.getRiskCode()) || (this
				.getRiskCode() != null && castOther.getRiskCode() != null && this
				.getRiskCode().equals(castOther.getRiskCode())))
				&& ((this.getRelaRiskCode() == castOther.getRelaRiskCode()) || (this
						.getRelaRiskCode() != null
						&& castOther.getRelaRiskCode() != null && this
						.getRelaRiskCode().equals(castOther.getRelaRiskCode())))
				&& ((this.getRelaCode() == castOther.getRelaCode()) || (this
						.getRelaCode() != null
						&& castOther.getRelaCode() != null && this
						.getRelaCode().equals(castOther.getRelaCode())))
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
				+ (getRelaRiskCode() == null ? 0 : this.getRelaRiskCode()
						.hashCode());
		result = 37 * result
				+ (getRelaCode() == null ? 0 : this.getRelaCode().hashCode());
		result = 37
				* result
				+ (getManageComGrp() == null ? 0 : this.getManageComGrp()
						.hashCode());
		return result;
	}

}
