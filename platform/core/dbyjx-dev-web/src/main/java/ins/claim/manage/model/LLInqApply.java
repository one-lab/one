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
 * POJO类LLInqApply
 */
@Entity
@Table(name = "LLINQAPPLY")
public class LLInqApply implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性id */
	private LLInqApplyId id;

	/** 属性批次号 */
	private String batNo;

	/** 属性出险人客户号 */
	private String customerNo;

	/** 属性出险人名称 */
	private String customerName;

	/** 属性VIP标志 */
	private String vipFlag;

	/** 属性提起阶段 */
	private String initPhase;

	/** 属性调查原因 */
	private String inqRCode;

	/** 属性调查项目 */
	private String inqItem;

	/** 属性调查描述 */
	private String inqDesc;

	/** 属性调查机构 */
	private String inqDept;

	/** 属性申请人 */
	private String applyPer;

	/** 属性申请日期 */
	private Date applyDate;

	/** 属性发起机构 */
	private String initDept;

	/** 属性调查状态 */
	private String inqState;

	/** 属性本地标志 */
	private String locFlag;

	/** 属性调查分配人 */
	private String inqPer;

	/** 属性调查分配日期 */
	private Date inqStartDate;

	/** 属性调查结束日期 */
	private Date inqEndDate;

	/** 属性调查结论 */
	private String inqConclusion;

	/** 属性结论确定人 */
	private String conPer;

	/** 属性结论确定时间 */
	private Date conDate;

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

	/** 属性调查报告标志 */
	private String surveyFlag;

	/** 属性取消调查原因 */
	private String inqCancel;

	/** 属性提起阶段值 */
	private String initPhaseValue;

	/** 属性调查原因值 */
	private String inqRCodeValue;

	/** 属性调查机构名称 */
	private String inqDeptName;

	/** 属性发起机构名称 */
	private String initDeptValue;

	/** 属性调查状态值 */
	private String inqStateValue;

	/** 属性本地标志值 */
	private String locFlagValue;

	/** 属性委托标志值 */
	private String entrustSignValue;

	/** 属性委托机构名称 */
	private String entrustMngComName;

	/**
	 * 类LLInqApply的默认构造方法
	 */
	public LLInqApply() {
	}

	/**
	 * 属性id的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "clmNo", column = @Column(name = "CLMNO")),
			@AttributeOverride(name = "inqNo", column = @Column(name = "INQNO")) })
	public LLInqApplyId getId() {
		return this.id;
	}

	/**
	 * 属性id的setter方法
	 */
	public void setId(LLInqApplyId id) {
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
	 * 属性调查原因的getter方法
	 */

	@Column(name = "INQRCODE")
	public String getInqRCode() {
		return this.inqRCode;
	}

	/**
	 * 属性调查原因的setter方法
	 */
	public void setInqRCode(String inqRCode) {
		this.inqRCode = inqRCode;
	}

	/**
	 * 属性调查项目的getter方法
	 */

	@Column(name = "INQITEM")
	public String getInqItem() {
		return this.inqItem;
	}

	/**
	 * 属性调查项目的setter方法
	 */
	public void setInqItem(String inqItem) {
		this.inqItem = inqItem;
	}

	/**
	 * 属性调查描述的getter方法
	 */

	@Column(name = "INQDESC")
	public String getInqDesc() {
		return this.inqDesc;
	}

	/**
	 * 属性调查描述的setter方法
	 */
	public void setInqDesc(String inqDesc) {
		this.inqDesc = inqDesc;
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
	 * 属性申请人的getter方法
	 */

	@Column(name = "APPLYPER")
	public String getApplyPer() {
		return this.applyPer;
	}

	/**
	 * 属性申请人的setter方法
	 */
	public void setApplyPer(String applyPer) {
		this.applyPer = applyPer;
	}

	/**
	 * 属性申请日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "APPLYDATE")
	public Date getApplyDate() {
		return this.applyDate;
	}

	/**
	 * 属性申请日期的setter方法
	 */
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
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
	 * 属性调查状态的getter方法
	 */

	@Column(name = "INQSTATE")
	public String getInqState() {
		return this.inqState;
	}

	/**
	 * 属性调查状态的setter方法
	 */
	public void setInqState(String inqState) {
		this.inqState = inqState;
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
	 * 属性调查分配人的getter方法
	 */

	@Column(name = "INQPER")
	public String getInqPer() {
		return this.inqPer;
	}

	/**
	 * 属性调查分配人的setter方法
	 */
	public void setInqPer(String inqPer) {
		this.inqPer = inqPer;
	}

	/**
	 * 属性调查分配日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "INQSTARTDATE")
	public Date getInqStartDate() {
		return this.inqStartDate;
	}

	/**
	 * 属性调查分配日期的setter方法
	 */
	public void setInqStartDate(Date inqStartDate) {
		this.inqStartDate = inqStartDate;
	}

	/**
	 * 属性调查结束日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "INQENDDATE")
	public Date getInqEndDate() {
		return this.inqEndDate;
	}

	/**
	 * 属性调查结束日期的setter方法
	 */
	public void setInqEndDate(Date inqEndDate) {
		this.inqEndDate = inqEndDate;
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
	 * 属性结论确定人的getter方法
	 */

	@Column(name = "CONPER")
	public String getConPer() {
		return this.conPer;
	}

	/**
	 * 属性结论确定人的setter方法
	 */
	public void setConPer(String conPer) {
		this.conPer = conPer;
	}

	/**
	 * 属性结论确定时间的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "CONDATE")
	public Date getConDate() {
		return this.conDate;
	}

	/**
	 * 属性结论确定时间的setter方法
	 */
	public void setConDate(Date conDate) {
		this.conDate = conDate;
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
	 * 属性调查报告标志的getter方法
	 */

	@Column(name = "SURVEYFLAG")
	public String getSurveyFlag() {
		return this.surveyFlag;
	}

	/**
	 * 属性调查报告标志的setter方法
	 */
	public void setSurveyFlag(String surveyFlag) {
		this.surveyFlag = surveyFlag;
	}

	/**
	 * 属性取消调查原因的getter方法
	 */

	@Column(name = "INQCANCEL")
	public String getInqCancel() {
		return this.inqCancel;
	}

	/**
	 * 属性取消调查原因的setter方法
	 */
	public void setInqCancel(String inqCancel) {
		this.inqCancel = inqCancel;
	}

	/**
	 * 属性提起阶段值的getter方法
	 */

	@Column(name = "INITPHASEVALUE")
	public String getInitPhaseValue() {
		return this.initPhaseValue;
	}

	/**
	 * 属性提起阶段值的setter方法
	 */
	public void setInitPhaseValue(String initPhaseValue) {
		this.initPhaseValue = initPhaseValue;
	}

	/**
	 * 属性调查原因值的getter方法
	 */

	@Column(name = "INQRCODEVALUE")
	public String getInqRCodeValue() {
		return this.inqRCodeValue;
	}

	/**
	 * 属性调查原因值的setter方法
	 */
	public void setInqRCodeValue(String inqRCodeValue) {
		this.inqRCodeValue = inqRCodeValue;
	}

	/**
	 * 属性调查机构名称的getter方法
	 */

	@Column(name = "INQDEPTNAME")
	public String getInqDeptName() {
		return this.inqDeptName;
	}

	/**
	 * 属性调查机构名称的setter方法
	 */
	public void setInqDeptName(String inqDeptName) {
		this.inqDeptName = inqDeptName;
	}

	/**
	 * 属性发起机构名称的getter方法
	 */

	@Column(name = "INITDEPTVALUE")
	public String getInitDeptValue() {
		return this.initDeptValue;
	}

	/**
	 * 属性发起机构名称的setter方法
	 */
	public void setInitDeptValue(String initDeptValue) {
		this.initDeptValue = initDeptValue;
	}

	/**
	 * 属性调查状态值的getter方法
	 */

	@Column(name = "INQSTATEVALUE")
	public String getInqStateValue() {
		return this.inqStateValue;
	}

	/**
	 * 属性调查状态值的setter方法
	 */
	public void setInqStateValue(String inqStateValue) {
		this.inqStateValue = inqStateValue;
	}

	/**
	 * 属性本地标志值的getter方法
	 */

	@Column(name = "LOCFLAGVALUE")
	public String getLocFlagValue() {
		return this.locFlagValue;
	}

	/**
	 * 属性本地标志值的setter方法
	 */
	public void setLocFlagValue(String locFlagValue) {
		this.locFlagValue = locFlagValue;
	}

	/**
	 * 属性委托标志值的getter方法
	 */

	@Column(name = "ENTRUSTSIGNVALUE")
	public String getEntrustSignValue() {
		return this.entrustSignValue;
	}

	/**
	 * 属性委托标志值的setter方法
	 */
	public void setEntrustSignValue(String entrustSignValue) {
		this.entrustSignValue = entrustSignValue;
	}

	/**
	 * 属性委托机构名称的getter方法
	 */

	@Column(name = "ENTRUSTMNGCOMNAME")
	public String getEntrustMngComName() {
		return this.entrustMngComName;
	}

	/**
	 * 属性委托机构名称的setter方法
	 */
	public void setEntrustMngComName(String entrustMngComName) {
		this.entrustMngComName = entrustMngComName;
	}

}
