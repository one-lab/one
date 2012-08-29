package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类PDLMRiskEdorItemId
 */
@Embeddable
public class PDLMRiskEdorItemId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性险种代码 */
	private String riskCode;

	/** 属性保全项目编码 */
	private String edorCode;

	/** 属性保全申请对象 */
	private String appObj;

	/**
	 * 类PDLMRiskEdorItemId的默认构造方法
	 */
	public PDLMRiskEdorItemId() {
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
	 * 属性保全项目编码的getter方法
	 */

	@Column(name = "EDORCODE")
	public String getEdorCode() {
		return this.edorCode;
	}

	/**
	 * 属性保全项目编码的setter方法
	 */
	public void setEdorCode(String edorCode) {
		this.edorCode = edorCode;
	}

	/**
	 * 属性保全申请对象的getter方法
	 */

	@Column(name = "APPOBJ")
	public String getAppObj() {
		return this.appObj;
	}

	/**
	 * 属性保全申请对象的setter方法
	 */
	public void setAppObj(String appObj) {
		this.appObj = appObj;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof PDLMRiskEdorItemId)) {
			return false;
		}
		PDLMRiskEdorItemId castOther = (PDLMRiskEdorItemId) other;

		return ((this.getRiskCode() == castOther.getRiskCode()) || (this
				.getRiskCode() != null && castOther.getRiskCode() != null && this
				.getRiskCode().equals(castOther.getRiskCode())))
				&& ((this.getEdorCode() == castOther.getEdorCode()) || (this
						.getEdorCode() != null
						&& castOther.getEdorCode() != null && this
						.getEdorCode().equals(castOther.getEdorCode())))
				&& ((this.getAppObj() == castOther.getAppObj()) || (this
						.getAppObj() != null && castOther.getAppObj() != null && this
						.getAppObj().equals(castOther.getAppObj())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRiskCode() == null ? 0 : this.getRiskCode().hashCode());
		result = 37 * result
				+ (getEdorCode() == null ? 0 : this.getEdorCode().hashCode());
		result = 37 * result
				+ (getAppObj() == null ? 0 : this.getAppObj().hashCode());
		return result;
	}

}
