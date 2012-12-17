package ins.claim.manage.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类LLHospitalAssessId
 */
@Embeddable
public class LLHospitalAssessId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性医院代码 */
	private String hospitalCode;

	/** 属性评估项目编码 */
	private String assessCode;

	/**
	 * 类LLHospitalAssessId的默认构造方法
	 */
	public LLHospitalAssessId() {
	}

	/**
	 * 属性医院代码的getter方法
	 */

	@Column(name = "HOSPITALCODE")
	public String getHospitalCode() {
		return this.hospitalCode;
	}

	/**
	 * 属性医院代码的setter方法
	 */
	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	/**
	 * 属性评估项目编码的getter方法
	 */

	@Column(name = "ASSESSCODE")
	public String getAssessCode() {
		return this.assessCode;
	}

	/**
	 * 属性评估项目编码的setter方法
	 */
	public void setAssessCode(String assessCode) {
		this.assessCode = assessCode;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof LLHospitalAssessId)) {
			return false;
		}
		LLHospitalAssessId castOther = (LLHospitalAssessId) other;

		return ((this.getHospitalCode() == castOther.getHospitalCode()) || (this
				.getHospitalCode() != null
				&& castOther.getHospitalCode() != null && this
				.getHospitalCode().equals(castOther.getHospitalCode())))
				&& ((this.getAssessCode() == castOther.getAssessCode()) || (this
						.getAssessCode() != null
						&& castOther.getAssessCode() != null && this
						.getAssessCode().equals(castOther.getAssessCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getHospitalCode() == null ? 0 : this.getHospitalCode()
						.hashCode());
		result = 37
				* result
				+ (getAssessCode() == null ? 0 : this.getAssessCode()
						.hashCode());
		return result;
	}

}
