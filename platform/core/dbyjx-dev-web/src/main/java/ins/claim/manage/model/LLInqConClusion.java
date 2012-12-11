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
 * POJO类LLInqConClusion
 */
@Entity
@Table(name = "LLINQCONCLUSION")
public class LLInqConClusion implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性id */
	private LLInqConClusionId id;

	/** 属性批次号 */
	private String batNo;

	/** 属性发起机构 */
	private String initDept;

	/** 属性调查机构 */
	private String inqDept;

	/** 属性调查结论 */
	private String inqConclusion;

	/** 属性完成标志 */
	private String finiFlag;

	/** 属性本地标志 */
	private String locFlag;

	/** 属性汇总标志 */
	private String colFlag;

	/** 属性阳性结论 */
	private String masFlag;

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
	 * 类LLInqConClusion的默认构造方法
	 */
	public LLInqConClusion() {
	}

	/**
	 * 属性id的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "clmNo", column = @Column(name = "CLMNO")),
			@AttributeOverride(name = "conNo", column = @Column(name = "CONNO")) })
	public LLInqConClusionId getId() {
		return this.id;
	}

	/**
	 * 属性id的setter方法
	 */
	public void setId(LLInqConClusionId id) {
		this.id = id;
	}

	/**
	 * 属性批次号的getter方法
	 */

	@Column(name = "BATNO")
	public String getBatNo() {
		return this.batNo;
	}

	/**
	 * 属性批次号的setter方法
	 */
	public void setBatNo(String batNo) {
		this.batNo = batNo;
	}

	/**
	 * 属性发起机构的getter方法
	 */

	@Column(name = "INITDEPT")
	public String getInitDept() {
		return this.initDept;
	}

	/**
	 * 属性发起机构的setter方法
	 */
	public void setInitDept(String initDept) {
		this.initDept = initDept;
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
	 * 属性调查结论的getter方法
	 */

	@Column(name = "INQCONCLUSION")
	public String getInqConclusion() {
		return this.inqConclusion;
	}

	/**
	 * 属性调查结论的setter方法
	 */
	public void setInqConclusion(String inqConclusion) {
		this.inqConclusion = inqConclusion;
	}

	/**
	 * 属性完成标志的getter方法
	 */

	@Column(name = "FINIFLAG")
	public String getFiniFlag() {
		return this.finiFlag;
	}

	/**
	 * 属性完成标志的setter方法
	 */
	public void setFiniFlag(String finiFlag) {
		this.finiFlag = finiFlag;
	}

	/**
	 * 属性本地标志的getter方法
	 */

	@Column(name = "LOCFLAG")
	public String getLocFlag() {
		return this.locFlag;
	}

	/**
	 * 属性本地标志的setter方法
	 */
	public void setLocFlag(String locFlag) {
		this.locFlag = locFlag;
	}

	/**
	 * 属性汇总标志的getter方法
	 */

	@Column(name = "COLFLAG")
	public String getColFlag() {
		return this.colFlag;
	}

	/**
	 * 属性汇总标志的setter方法
	 */
	public void setColFlag(String colFlag) {
		this.colFlag = colFlag;
	}

	/**
	 * 属性阳性结论的getter方法
	 */

	@Column(name = "MASFLAG")
	public String getMasFlag() {
		return this.masFlag;
	}

	/**
	 * 属性阳性结论的setter方法
	 */
	public void setMasFlag(String masFlag) {
		this.masFlag = masFlag;
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
