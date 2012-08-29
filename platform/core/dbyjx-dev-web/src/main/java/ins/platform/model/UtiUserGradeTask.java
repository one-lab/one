package ins.platform.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * POJO类UtiUserGradeTask
 */
@Entity
@Table(name = "UTIUSERGRADETASK")
public class UtiUserGradeTask implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性ID */
	private UtiUserGradeTaskId id;

	/** 属性utiUserGrade */
	private UtiUserGrade utiUserGrade;

	/** 属性utiTask */
	private UtiTask utiTask;

	/** 属性 */
	private String grantLevel;

	/** 属性 */
	private String grantValue;

	/** 属性保险价值 */
	private String value;

	/** 属性备注 */
	private String remark;

	/** 属性标志 */
	private String flag;

	/**
	 * 类UtiUserGradeTask的默认构造方法
	 */
	public UtiUserGradeTask() {
	}

	/**
	 * 属性ID的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "comCode", column = @Column(name = "COMCODE")),
			@AttributeOverride(name = "userCode", column = @Column(name = "USERCODE")),
			@AttributeOverride(name = "gradeCode", column = @Column(name = "GRADECODE")),
			@AttributeOverride(name = "taskCode", column = @Column(name = "TASKCODE")) })
	public UtiUserGradeTaskId getId() {
		return this.id;
	}

	/**
	 * 属性ID的setter方法
	 */
	public void setId(UtiUserGradeTaskId id) {
		this.id = id;
	}

	/**
	 * 属性utiUserGrade的getter方法
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "COMCODE", referencedColumnName = "COMCODE", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "USERCODE", referencedColumnName = "USERCODE", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "GRADECODE", referencedColumnName = "GRADECODE", nullable = false, insertable = false, updatable = false) })
	public UtiUserGrade getUtiUserGrade() {
		return this.utiUserGrade;
	}

	/**
	 * 属性utiUserGrade的setter方法
	 */
	public void setUtiUserGrade(UtiUserGrade utiUserGrade) {
		this.utiUserGrade = utiUserGrade;
	}

	/**
	 * 属性utiTask的getter方法
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TASKCODE", nullable = false, insertable = false, updatable = false)
	public UtiTask getUtiTask() {
		return this.utiTask;
	}

	/**
	 * 属性utiTask的setter方法
	 */
	public void setUtiTask(UtiTask utiTask) {
		this.utiTask = utiTask;
	}

	/**
	 * 属性的getter方法
	 */

	@Column(name = "GRANTLEVEL")
	public String getGrantLevel() {
		return this.grantLevel;
	}

	/**
	 * 属性的setter方法
	 */
	public void setGrantLevel(String grantLevel) {
		this.grantLevel = grantLevel;
	}

	/**
	 * 属性的getter方法
	 */

	@Column(name = "GRANTVALUE")
	public String getGrantValue() {
		return this.grantValue;
	}

	/**
	 * 属性的setter方法
	 */
	public void setGrantValue(String grantValue) {
		this.grantValue = grantValue;
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
