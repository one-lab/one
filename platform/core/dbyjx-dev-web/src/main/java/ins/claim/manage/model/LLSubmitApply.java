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
 * POJO类LLSubmitApply
 */
@Entity
@Table(name = "LLSUBMITAPPLY")
public class LLSubmitApply implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性id */
	private LLSubmitApplyId id;

	/** 属性出险人客户号 */
	private String customerNo;

	/** 属性出险人名称 */
	private String customerName;

	/** 属性VIP标志 */
	private String vipFlag;

	/** 属性提起阶段 */
	private String initPhase;

	/** 属性呈报类型 */
	private String subType;

	/** 属性呈报原因 */
	private String subRCode;

	/** 属性呈报描述 */
	private String subDesc;

	/** 属性呈报人 */
	private String subPer;

	/** 属性呈报日期 */
	private Date subDate;

	/** 属性呈报机构 */
	private String subDept;

	/** 属性呈报状态 */
	private String subState;

	/** 属性承接机构代码 */
	private String dispDept;

	/** 属性承接人员编号 */
	private String dispPer;

	/** 属性处理日期 */
	private Date dispDate;

	/** 属性处理类型 */
	private String dispType;

	/** 属性处理意见 */
	private String dispIdea;

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
	 * 类LLSubmitApply的默认构造方法
	 */
	public LLSubmitApply() {
	}

	/**
	 * 属性id的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "clmNo", column = @Column(name = "CLMNO")),
			@AttributeOverride(name = "subNo", column = @Column(name = "SUBNO")),
			@AttributeOverride(name = "subCount", column = @Column(name = "SUBCOUNT")) })
	public LLSubmitApplyId getId() {
		return this.id;
	}

	/**
	 * 属性id的setter方法
	 */
	public void setId(LLSubmitApplyId id) {
		this.id = id;
	}

	/**
	 * 属性出险人客户号的getter方法
	 */

	@Column(name = "CUSTOMERNO")
	public String getCustomerNo() {
		return this.customerNo;
	}

	/**
	 * 属性出险人客户号的setter方法
	 */
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	/**
	 * 属性出险人名称的getter方法
	 */

	@Column(name = "CUSTOMERNAME")
	public String getCustomerName() {
		return this.customerName;
	}

	/**
	 * 属性出险人名称的setter方法
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * 属性VIP标志的getter方法
	 */

	@Column(name = "VIPFLAG")
	public String getVipFlag() {
		return this.vipFlag;
	}

	/**
	 * 属性VIP标志的setter方法
	 */
	public void setVipFlag(String vipFlag) {
		this.vipFlag = vipFlag;
	}

	/**
	 * 属性提起阶段的getter方法
	 */

	@Column(name = "INITPHASE")
	public String getInitPhase() {
		return this.initPhase;
	}

	/**
	 * 属性提起阶段的setter方法
	 */
	public void setInitPhase(String initPhase) {
		this.initPhase = initPhase;
	}

	/**
	 * 属性呈报类型的getter方法
	 */

	@Column(name = "SUBTYPE")
	public String getSubType() {
		return this.subType;
	}

	/**
	 * 属性呈报类型的setter方法
	 */
	public void setSubType(String subType) {
		this.subType = subType;
	}

	/**
	 * 属性呈报原因的getter方法
	 */

	@Column(name = "SUBRCODE")
	public String getSubRCode() {
		return this.subRCode;
	}

	/**
	 * 属性呈报原因的setter方法
	 */
	public void setSubRCode(String subRCode) {
		this.subRCode = subRCode;
	}

	/**
	 * 属性呈报描述的getter方法
	 */

	@Column(name = "SUBDESC")
	public String getSubDesc() {
		return this.subDesc;
	}

	/**
	 * 属性呈报描述的setter方法
	 */
	public void setSubDesc(String subDesc) {
		this.subDesc = subDesc;
	}

	/**
	 * 属性呈报人的getter方法
	 */

	@Column(name = "SUBPER")
	public String getSubPer() {
		return this.subPer;
	}

	/**
	 * 属性呈报人的setter方法
	 */
	public void setSubPer(String subPer) {
		this.subPer = subPer;
	}

	/**
	 * 属性呈报日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "SUBDATE")
	public Date getSubDate() {
		return this.subDate;
	}

	/**
	 * 属性呈报日期的setter方法
	 */
	public void setSubDate(Date subDate) {
		this.subDate = subDate;
	}

	/**
	 * 属性呈报机构的getter方法
	 */

	@Column(name = "SUBDEPT")
	public String getSubDept() {
		return this.subDept;
	}

	/**
	 * 属性呈报机构的setter方法
	 */
	public void setSubDept(String subDept) {
		this.subDept = subDept;
	}

	/**
	 * 属性呈报状态的getter方法
	 */

	@Column(name = "SUBSTATE")
	public String getSubState() {
		return this.subState;
	}

	/**
	 * 属性呈报状态的setter方法
	 */
	public void setSubState(String subState) {
		this.subState = subState;
	}

	/**
	 * 属性承接机构代码的getter方法
	 */

	@Column(name = "DISPDEPT")
	public String getDispDept() {
		return this.dispDept;
	}

	/**
	 * 属性承接机构代码的setter方法
	 */
	public void setDispDept(String dispDept) {
		this.dispDept = dispDept;
	}

	/**
	 * 属性承接人员编号的getter方法
	 */

	@Column(name = "DISPPER")
	public String getDispPer() {
		return this.dispPer;
	}

	/**
	 * 属性承接人员编号的setter方法
	 */
	public void setDispPer(String dispPer) {
		this.dispPer = dispPer;
	}

	/**
	 * 属性处理日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "DISPDATE")
	public Date getDispDate() {
		return this.dispDate;
	}

	/**
	 * 属性处理日期的setter方法
	 */
	public void setDispDate(Date dispDate) {
		this.dispDate = dispDate;
	}

	/**
	 * 属性处理类型的getter方法
	 */

	@Column(name = "DISPTYPE")
	public String getDispType() {
		return this.dispType;
	}

	/**
	 * 属性处理类型的setter方法
	 */
	public void setDispType(String dispType) {
		this.dispType = dispType;
	}

	/**
	 * 属性处理意见的getter方法
	 */

	@Column(name = "DISPIDEA")
	public String getDispIdea() {
		return this.dispIdea;
	}

	/**
	 * 属性处理意见的setter方法
	 */
	public void setDispIdea(String dispIdea) {
		this.dispIdea = dispIdea;
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
