package ins.claim.report.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * POJO类LLAccident
 */
@Entity
@Table(name = "LLACCIDENT")
public class LLAccident implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性事件号 */
	private String accNo;

	/** 属性事故发生日期 */
	private Date accDate;

	/** 属性事故类型 */
	private String accType;

	/** 属性事件主题 */
	private String accSubject;

	/** 属性事故描述 */
	private String accDesc;

	/** 属性事故地点 */
	private String accPlace;

	/** 属性重大事件标志 */
	private String accGrade;

	/** 属性操作员 */
	private String operator;

	/** 属性管理机构 */
	private String mngCom;

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

	/** 属性事故类型值 */
	private String accTypeValue;

	/**
	 * 类LLAccident的默认构造方法
	 */
	public LLAccident() {
	}

	/**
	 * 属性事件号的getter方法
	 */
	@Id
	@Column(name = "ACCNO")
	public String getAccNo() {
		return this.accNo;
	}

	/**
	 * 属性事件号的setter方法
	 */
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	/**
	 * 属性事故发生日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "ACCDATE")
	public Date getAccDate() {
		return this.accDate;
	}

	/**
	 * 属性事故发生日期的setter方法
	 */
	public void setAccDate(Date accDate) {
		this.accDate = accDate;
	}

	/**
	 * 属性事故类型的getter方法
	 */

	@Column(name = "ACCTYPE")
	public String getAccType() {
		return this.accType;
	}

	/**
	 * 属性事故类型的setter方法
	 */
	public void setAccType(String accType) {
		this.accType = accType;
	}

	/**
	 * 属性事件主题的getter方法
	 */

	@Column(name = "ACCSUBJECT")
	public String getAccSubject() {
		return this.accSubject;
	}

	/**
	 * 属性事件主题的setter方法
	 */
	public void setAccSubject(String accSubject) {
		this.accSubject = accSubject;
	}

	/**
	 * 属性事故描述的getter方法
	 */

	@Column(name = "ACCDESC")
	public String getAccDesc() {
		return this.accDesc;
	}

	/**
	 * 属性事故描述的setter方法
	 */
	public void setAccDesc(String accDesc) {
		this.accDesc = accDesc;
	}

	/**
	 * 属性事故地点的getter方法
	 */

	@Column(name = "ACCPLACE")
	public String getAccPlace() {
		return this.accPlace;
	}

	/**
	 * 属性事故地点的setter方法
	 */
	public void setAccPlace(String accPlace) {
		this.accPlace = accPlace;
	}

	/**
	 * 属性重大事件标志的getter方法
	 */

	@Column(name = "ACCGRADE")
	public String getAccGrade() {
		return this.accGrade;
	}

	/**
	 * 属性重大事件标志的setter方法
	 */
	public void setAccGrade(String accGrade) {
		this.accGrade = accGrade;
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
	 * 属性事故类型值的getter方法
	 */

	@Column(name = "ACCTYPEVALUE")
	public String getAccTypeValue() {
		return this.accTypeValue;
	}

	/**
	 * 属性事故类型值的setter方法
	 */
	public void setAccTypeValue(String accTypeValue) {
		this.accTypeValue = accTypeValue;
	}

}
