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
 * POJO类LLHospitalAssess
 */
@Entity
@Table(name = "LLHOSPITALASSESS")
public class LLHospitalAssess implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性id */
	private LLHospitalAssessId id;

	/** 属性医院名称 */
	private String hospitalName;

	/** 属性评估项目名称 */
	private String assessName;

	/** 属性分数 */
	private String goal;

	/** 属性评估分数 */
	private String assessGoal;

	/** 属性管理机构 */
	private String mngCom;

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

	/**
	 * 类LLHospitalAssess的默认构造方法
	 */
	public LLHospitalAssess() {
	}

	/**
	 * 属性id的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "hospitalCode", column = @Column(name = "HOSPITALCODE")),
			@AttributeOverride(name = "assessCode", column = @Column(name = "ASSESSCODE")) })
	public LLHospitalAssessId getId() {
		return this.id;
	}

	/**
	 * 属性id的setter方法
	 */
	public void setId(LLHospitalAssessId id) {
		this.id = id;
	}

	/**
	 * 属性医院名称的getter方法
	 */

	@Column(name = "HOSPITALNAME")
	public String getHospitalName() {
		return this.hospitalName;
	}

	/**
	 * 属性医院名称的setter方法
	 */
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	/**
	 * 属性评估项目名称的getter方法
	 */

	@Column(name = "ASSESSNAME")
	public String getAssessName() {
		return this.assessName;
	}

	/**
	 * 属性评估项目名称的setter方法
	 */
	public void setAssessName(String assessName) {
		this.assessName = assessName;
	}

	/**
	 * 属性分数的getter方法
	 */

	@Column(name = "GOAL")
	public String getGoal() {
		return this.goal;
	}

	/**
	 * 属性分数的setter方法
	 */
	public void setGoal(String goal) {
		this.goal = goal;
	}

	/**
	 * 属性评估分数的getter方法
	 */

	@Column(name = "ASSESSGOAL")
	public String getAssessGoal() {
		return this.assessGoal;
	}

	/**
	 * 属性评估分数的setter方法
	 */
	public void setAssessGoal(String assessGoal) {
		this.assessGoal = assessGoal;
	}

	/**
	 * 属性管理机构的getter方法
	 */

	@Column(name = "MNGCOM")
	public String getMngCom() {
		return this.mngCom;
	}

	/**
	 * 属性管理机构的setter方法
	 */
	public void setMngCom(String mngCom) {
		this.mngCom = mngCom;
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

}
