package ins.platform.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * POJO类UtiGrade
 */
@Entity
@Table(name = "UTIGRADE")
public class UtiGrade implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性岗位代码 */
	private String gradeCode;

	/** 属性岗位名称 */
	private String gradeName;

	/** 属性备注 */
	private String remark;

	/** 属性标志 */
	private String flag;

	/** 属性岗位级别 */
	private String gradeLevel;

	/** 属性utiGradeTasks */
	private List<UtiGradeTask> utiGradeTasks = new ArrayList<UtiGradeTask>(0);

	/** 属性utiUserGrades */
	private List<UtiUserGrade> utiUserGrades = new ArrayList<UtiUserGrade>(0);

	/**
	 * 类UtiGrade的默认构造方法
	 */
	public UtiGrade() {
	}

	/**
	 * 属性岗位代码的getter方法
	 */
	@Id
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
	 * 属性岗位名称的getter方法
	 */

	@Column(name = "GRADENAME")
	public String getGradeName() {
		return this.gradeName;
	}

	/**
	 * 属性岗位名称的setter方法
	 */
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	/**
	 * 属性备注的getter方法
	 */

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	/**
	 * 属性备注的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 属性标志的getter方法
	 */

	@Column(name = "FLAG")
	public String getFlag() {
		return this.flag;
	}

	/**
	 * 属性标志的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * 属性岗位级别的getter方法
	 */

	@Column(name = "GRADELEVEL")
	public String getGradeLevel() {
		return this.gradeLevel;
	}

	/**
	 * 属性岗位级别的setter方法
	 */
	public void setGradeLevel(String gradeLevel) {
		this.gradeLevel = gradeLevel;
	}

	/**
	 * 属性utiGradeTasks的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "utiGrade")
	public List<UtiGradeTask> getUtiGradeTasks() {
		return this.utiGradeTasks;
	}

	/**
	 * 属性utiGradeTasks的setter方法
	 */
	public void setUtiGradeTasks(List<UtiGradeTask> utiGradeTasks) {
		this.utiGradeTasks = utiGradeTasks;
	}

	/**
	 * 属性utiUserGrades的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "utiGrade")
	public List<UtiUserGrade> getUtiUserGrades() {
		return this.utiUserGrades;
	}

	/**
	 * 属性utiUserGrades的setter方法
	 */
	public void setUtiUserGrades(List<UtiUserGrade> utiUserGrades) {
		this.utiUserGrades = utiUserGrades;
	}

}
