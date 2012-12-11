package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类PDLMRiskRoleId
 */
@Embeddable
public class PDLMRiskRoleId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性险种代码 */
	private String riskCode;

	/** 属性角色 */
	private String riskRole;

	/** 属性性别 */
	private String riskRoleSex;

	/** 属性序号（级别） */
	private String riskRoleNo;

	/**
	 * 类PDLMRiskRoleId的默认构造方法
	 */
	public PDLMRiskRoleId() {
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
	 * 属性角色的getter方法
	 */

	@Column(name = "RISKROLE")
	public String getRiskRole() {
		return this.riskRole;
	}

	/**
	 * 属性角色的setter方法
	 */
	public void setRiskRole(String riskRole) {
		this.riskRole = riskRole;
	}

	/**
	 * 属性性别的getter方法
	 */

	@Column(name = "RISKROLESEX")
	public String getRiskRoleSex() {
		return this.riskRoleSex;
	}

	/**
	 * 属性性别的setter方法
	 */
	public void setRiskRoleSex(String riskRoleSex) {
		this.riskRoleSex = riskRoleSex;
	}

	/**
	 * 属性序号（级别）的getter方法
	 */

	@Column(name = "RISKROLENO")
	public String getRiskRoleNo() {
		return this.riskRoleNo;
	}

	/**
	 * 属性序号（级别）的setter方法
	 */
	public void setRiskRoleNo(String riskRoleNo) {
		this.riskRoleNo = riskRoleNo;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof PDLMRiskRoleId)) {
			return false;
		}
		PDLMRiskRoleId castOther = (PDLMRiskRoleId) other;

		return ((this.getRiskCode() == castOther.getRiskCode()) || (this
				.getRiskCode() != null && castOther.getRiskCode() != null && this
				.getRiskCode().equals(castOther.getRiskCode())))
				&& ((this.getRiskRole() == castOther.getRiskRole()) || (this
						.getRiskRole() != null
						&& castOther.getRiskRole() != null && this
						.getRiskRole().equals(castOther.getRiskRole())))
				&& ((this.getRiskRoleSex() == castOther.getRiskRoleSex()) || (this
						.getRiskRoleSex() != null
						&& castOther.getRiskRoleSex() != null && this
						.getRiskRoleSex().equals(castOther.getRiskRoleSex())))
				&& ((this.getRiskRoleNo() == castOther.getRiskRoleNo()) || (this
						.getRiskRoleNo() != null
						&& castOther.getRiskRoleNo() != null && this
						.getRiskRoleNo().equals(castOther.getRiskRoleNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRiskCode() == null ? 0 : this.getRiskCode().hashCode());
		result = 37 * result
				+ (getRiskRole() == null ? 0 : this.getRiskRole().hashCode());
		result = 37
				* result
				+ (getRiskRoleSex() == null ? 0 : this.getRiskRoleSex()
						.hashCode());
		result = 37
				* result
				+ (getRiskRoleNo() == null ? 0 : this.getRiskRoleNo()
						.hashCode());
		return result;
	}

}
