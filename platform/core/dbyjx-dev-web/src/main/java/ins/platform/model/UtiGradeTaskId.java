package ins.platform.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类UtiGradeTaskId
 */
@Embeddable
public class UtiGradeTaskId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性岗位代码 */
	private String gradeCode;

	/** 属性功能代码 */
	private String taskCode;

	/**
	 * 类UtiGradeTaskId的默认构造方法
	 */
	public UtiGradeTaskId() {
	}

	/**
	 * 属性岗位代码的getter方法
	 */

	@Column(name = "GRADECODE")
	public String getGradeCode() {
		return this.gradeCode;
	}

	/**
	 * 属性岗位代码的setter方法
	 */
	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	/**
	 * 属性功能代码的getter方法
	 */

	@Column(name = "TASKCODE")
	public String getTaskCode() {
		return this.taskCode;
	}

	/**
	 * 属性功能代码的setter方法
	 */
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof UtiGradeTaskId)) {
			return false;
		}
		UtiGradeTaskId castOther = (UtiGradeTaskId) other;

		return ((this.getGradeCode() == castOther.getGradeCode()) || (this
				.getGradeCode() != null && castOther.getGradeCode() != null && this
				.getGradeCode().equals(castOther.getGradeCode())))
				&& ((this.getTaskCode() == castOther.getTaskCode()) || (this
						.getTaskCode() != null
						&& castOther.getTaskCode() != null && this
						.getTaskCode().equals(castOther.getTaskCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getGradeCode() == null ? 0 : this.getGradeCode().hashCode());
		result = 37 * result
				+ (getTaskCode() == null ? 0 : this.getTaskCode().hashCode());
		return result;
	}

}
