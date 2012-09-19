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
 * POJO类UtiTask
 */
@Entity
@Table(name = "UTITASK")
public class UtiTask implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性功能代码 */
	private String taskCode;

	/** 属性上级功能代码 */
	private String parentCode;

	/** 属性任务名称 */
	private String taskName;

	/** 属性备注 */
	private String remark;

	/** 属性标志 */
	private String flag;

	/** 属性utiUserGradeTasks */
	private List<UtiUserGradeTask> utiUserGradeTasks = new ArrayList<UtiUserGradeTask>(
			0);

	/**
	 * 类UtiTask的默认构造方法
	 */
	public UtiTask() {
	}

	/**
	 * 属性功能代码的getter方法
	 */
	@Id
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

	/**
	 * 属性上级功能代码的getter方法
	 */

	@Column(name = "PARENTCODE")
	public String getParentCode() {
		return this.parentCode;
	}

	/**
	 * 属性上级功能代码的setter方法
	 */
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	/**
	 * 属性任务名称的getter方法
	 */

	@Column(name = "TASKNAME")
	public String getTaskName() {
		return this.taskName;
	}

	/**
	 * 属性任务名称的setter方法
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
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
	 * 属性utiUserGradeTasks的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "utiTask")
	public List<UtiUserGradeTask> getUtiUserGradeTasks() {
		return this.utiUserGradeTasks;
	}

	/**
	 * 属性utiUserGradeTasks的setter方法
	 */
	public void setUtiUserGradeTasks(List<UtiUserGradeTask> utiUserGradeTasks) {
		this.utiUserGradeTasks = utiUserGradeTasks;
	}

}
