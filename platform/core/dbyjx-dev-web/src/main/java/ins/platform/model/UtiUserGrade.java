package ins.platform.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * POJO类UtiUserGrade
 */
@Entity
@Table(name = "UTIUSERGRADE")
public class UtiUserGrade implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性ID */
	private UtiUserGradeId id;

	/** 属性utiGrade */
	private UtiGrade utiGrade;

	/** 属性失效日期 */
	private Date inValidDate;

	/** 属性效力状态 */
	private String validStatus;

	/** 属性备注 */
	private String remark;

	/** 属性标志 */
	private String flag;

	/** 属性utiUserGradePowers */
	private List<UtiUserGradePower> utiUserGradePowers = new ArrayList<UtiUserGradePower>(
			0);

	/** 属性utiUserGradeTasks */
	private List<UtiUserGradeTask> utiUserGradeTasks = new ArrayList<UtiUserGradeTask>(
			0);

	/**
	 * 类UtiUserGrade的默认构造方法
	 */
	public UtiUserGrade() {
	}

	/**
	 * 属性ID的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "comCode", column = @Column(name = "COMCODE")),
			@AttributeOverride(name = "userCode", column = @Column(name = "USERCODE")),
			@AttributeOverride(name = "gradeCode", column = @Column(name = "GRADECODE")) })
	public UtiUserGradeId getId() {
		return this.id;
	}

	/**
	 * 属性ID的setter方法
	 */
	public void setId(UtiUserGradeId id) {
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
	 * 属性失效日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "INVALIDDATE")
	public Date getInValidDate() {
		return this.inValidDate;
	}

	/**
	 * 属性失效日期的setter方法
	 */
	public void setInValidDate(Date inValidDate) {
		this.inValidDate = inValidDate;
	}

	/**
	 * 属性效力状态的getter方法
	 */

	@Column(name = "VALIDSTATUS")
	public String getValidStatus() {
		return this.validStatus;
	}

	/**
	 * 属性效力状态的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
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
	 * 属性utiUserGradePowers的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "utiUserGrade")
	public List<UtiUserGradePower> getUtiUserGradePowers() {
		return this.utiUserGradePowers;
	}

	/**
	 * 属性utiUserGradePowers的setter方法
	 */
	public void setUtiUserGradePowers(List<UtiUserGradePower> utiUserGradePowers) {
		this.utiUserGradePowers = utiUserGradePowers;
	}

	/**
	 * 属性utiUserGradeTasks的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "utiUserGrade")
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
