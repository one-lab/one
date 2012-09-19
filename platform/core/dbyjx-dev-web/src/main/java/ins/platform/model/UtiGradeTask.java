package ins.platform.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * POJO类UtiGradeTask
 */
@Entity
@Table(name = "UTIGRADETASK")
public class UtiGradeTask implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性ID */
	private UtiGradeTaskId id;

	/** 属性utiGrade */
	private UtiGrade utiGrade;

	/** 属性保险价值 */
	private String value;

	/** 属性备注 */
	private String remark;

	/** 属性标志 */
	private String flag;

	/**
	 * 类UtiGradeTask的默认构造方法
	 */
	public UtiGradeTask() {
	}

	/**
	 * 属性ID的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "gradeCode", column = @Column(name = "GRADECODE")),
			@AttributeOverride(name = "taskCode", column = @Column(name = "TASKCODE")) })
	public UtiGradeTaskId getId() {
		return this.id;
	}

	/**
	 * 属性ID的setter方法
	 */
	public void setId(UtiGradeTaskId id) {
		this.id = id;
	}

	/**
	 * 属性utiGrade的getter方法
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GRADECODE", nullable = false, insertable = false, updatable = false)
	public UtiGrade getUtiGrade() {
		return this.utiGrade;
	}

	/**
	 * 属性utiGrade的setter方法
	 */
	public void setUtiGrade(UtiGrade utiGrade) {
		this.utiGrade = utiGrade;
	}

	/**
	 * 属性保险价值的getter方法
	 */

	@Column(name = "VALUE")
	public String getValue() {
		return this.value;
	}

	/**
	 * 属性保险价值的setter方法
	 */
	public void setValue(String value) {
		this.value = value;
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

}
