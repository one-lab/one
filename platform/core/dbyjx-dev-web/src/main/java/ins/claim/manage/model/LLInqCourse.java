package ins.claim.manage.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * POJO类LLInqCourse
 */
@Entity
@Table(name = "LLINQCOURSE")
public class LLInqCourse implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性id */
	private LLInqCourseId id;

	/** 属性调查日期 */
	private Date inqDate;

	/** 属性调查方式 */
	private String inqMode;

	/** 属性调查地点 */
	private String inqSite;

	/** 属性被调查人 */
	private String inqByPer;

	/** 属性调查过程 */
	private String inqCourse;

	/** 属性调查机构 */
	private String inqDept;

	/** 属性第一调查人 */
	private String inqPer1;

	/** 属性第二调查人 */
	private String inqPer2;

	/** 属性操作员 */
	private String operator;

	/** 属性入机日期 */
	private Date makeDate;

	/** 属性入机时间 */
	private String makeTime;

	/** 属性最后一次修改日期 */
	private Date modifyDate;

	/** 属性最后一次修改时间 */
	private String modifyTime;

	/** 属性备注 */
	private String remark;

	/** 属性调查方式值 */
	private String inqModeValue;

	/**
	 * 类LLInqCourse的默认构造方法
	 */
	public LLInqCourse() {
	}

	/**
	 * 属性id的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "clmNo", column = @Column(name = "CLMNO")),
			@AttributeOverride(name = "inqNo", column = @Column(name = "INQNO")),
			@AttributeOverride(name = "couNo", column = @Column(name = "COUNO")) })
	public LLInqCourseId getId() {
		return this.id;
	}

	/**
	 * 属性id的setter方法
	 */
	public void setId(LLInqCourseId id) {
		this.id = id;
	}

	/**
	 * 属性调查日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "INQDATE")
	public Date getInqDate() {
		return this.inqDate;
	}

	/**
	 * 属性调查日期的setter方法
	 */
	public void setInqDate(Date inqDate) {
		this.inqDate = inqDate;
	}

	/**
	 * 属性调查方式的getter方法
	 */

	@Column(name = "INQMODE")
	public String getInqMode() {
		return this.inqMode;
	}

	/**
	 * 属性调查方式的setter方法
	 */
	public void setInqMode(String inqMode) {
		this.inqMode = inqMode;
	}

	/**
	 * 属性调查地点的getter方法
	 */

	@Column(name = "INQSITE")
	public String getInqSite() {
		return this.inqSite;
	}

	/**
	 * 属性调查地点的setter方法
	 */
	public void setInqSite(String inqSite) {
		this.inqSite = inqSite;
	}

	/**
	 * 属性被调查人的getter方法
	 */

	@Column(name = "INQBYPER")
	public String getInqByPer() {
		return this.inqByPer;
	}

	/**
	 * 属性被调查人的setter方法
	 */
	public void setInqByPer(String inqByPer) {
		this.inqByPer = inqByPer;
	}

	/**
	 * 属性调查过程的getter方法
	 */

	@Column(name = "INQCOURSE")
	public String getInqCourse() {
		return this.inqCourse;
	}

	/**
	 * 属性调查过程的setter方法
	 */
	public void setInqCourse(String inqCourse) {
		this.inqCourse = inqCourse;
	}

	/**
	 * 属性调查机构的getter方法
	 */

	@Column(name = "INQDEPT")
	public String getInqDept() {
		return this.inqDept;
	}

	/**
	 * 属性调查机构的setter方法
	 */
	public void setInqDept(String inqDept) {
		this.inqDept = inqDept;
	}

	/**
	 * 属性第一调查人的getter方法
	 */

	@Column(name = "INQPER1")
	public String getInqPer1() {
		return this.inqPer1;
	}

	/**
	 * 属性第一调查人的setter方法
	 */
	public void setInqPer1(String inqPer1) {
		this.inqPer1 = inqPer1;
	}

	/**
	 * 属性第二调查人的getter方法
	 */

	@Column(name = "INQPER2")
	public String getInqPer2() {
		return this.inqPer2;
	}

	/**
	 * 属性第二调查人的setter方法
	 */
	public void setInqPer2(String inqPer2) {
		this.inqPer2 = inqPer2;
	}

	/**
	 * 属性操作员的getter方法
	 */

	@Column(name = "OPERATOR")
	public String getOperator() {
		return this.operator;
	}

	/**
	 * 属性操作员的setter方法
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * 属性入机日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "MAKEDATE")
	public Date getMakeDate() {
		return this.makeDate;
	}

	/**
	 * 属性入机日期的setter方法
	 */
	public void setMakeDate(Date makeDate) {
		this.makeDate = makeDate;
	}

	/**
	 * 属性入机时间的getter方法
	 */

	@Column(name = "MAKETIME")
	public String getMakeTime() {
		return this.makeTime;
	}

	/**
	 * 属性入机时间的setter方法
	 */
	public void setMakeTime(String makeTime) {
		this.makeTime = makeTime;
	}

	/**
	 * 属性最后一次修改日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFYDATE")
	public Date getModifyDate() {
		return this.modifyDate;
	}

	/**
	 * 属性最后一次修改日期的setter方法
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	/**
	 * 属性最后一次修改时间的getter方法
	 */

	@Column(name = "MODIFYTIME")
	public String getModifyTime() {
		return this.modifyTime;
	}

	/**
	 * 属性最后一次修改时间的setter方法
	 */
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
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
	 * 属性调查方式值的getter方法
	 */

	@Column(name = "INQMODEVALUE")
	public String getInqModeValue() {
		return this.inqModeValue;
	}

	/**
	 * 属性调查方式值的setter方法
	 */
	public void setInqModeValue(String inqModeValue) {
		this.inqModeValue = inqModeValue;
	}

}
