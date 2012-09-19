package ins.claim.report.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * POJO类LLReport
 */
@Entity
@Table(name = "LLREPORT")
public class LLReport implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性团体报案号 */
	private String rptNo;

	/** 属性申请类型 */
	private String rgtClass;

	/** 属性号码类型 */
	private String rgtObj;

	/** 属性其他号码 */
	private String rgtObjNo;

	/** 属性报案方式 */
	private String rptMode;

	/** 属性立案人/申请人与被保人关系 */
	private String relation;

	/** 属性报案人姓名 */
	private String rptorName;

	/** 属性报案人通讯地址 */
	private String rptorAddress;

	/** 属性报案人电话 */
	private String rptorPhone;

	/** 属性报案人手机 */
	private String rptorMobile;

	/** 属性立案人/申请人电邮 */
	private String email;

	/** 属性立案人/申请人邮政编码 */
	private String postCode;

	/** 属性回执发送方式 */
	private String returnMode;

	/** 属性出险结束日期 */
	private Date accidentDate;

	/** 属性出险地点 */
	private String accidentSite;

	/** 属性出险原因 */
	private String accidentReason;

	/** 属性出险过程和结果 */
	private String accidentCourse;

	/** 属性报案日期 */
	private Date rptDate;

	/** 属性报备产生日期 */
	private Date caseNoDate;

	/** 属性报备结束日期 */
	private Date caseEndDate;

	/** 属性立案撤销原因 */
	private String rgtReason;

	/** 属性不立案原因 */
	private String noRgtReason;

	/** 属性备注 */
	private String remark;

	/** 属性立案标志 */
	private String rgtFlag;

	/** 属性案件有效标志 */
	private String avaiFlag;

	/** 属性案件有效原因 */
	private String avaliReason;

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

	/** 属性受托人类型 */
	private String assigneeType;

	/** 属性受托人代码 */
	private String assigneeCode;

	/** 属性受托人姓名 */
	private String assigneeName;

	/** 属性受托人性别 */
	private String assigneeSex;

	/** 属性受托人电话 */
	private String assigneePhone;

	/** 属性受托人地址 */
	private String assigneeAddr;

	/** 属性受托人邮编 */
	private String assigneeZip;

	/** 属性承保机构 */
	private String acceptMngCom;

	/** 属性不予受理理由 */
	private String noAcceptReason;

	/** 属性受理标志 */
	private String acceptFlag;

	/** 属性受理结论 */
	private String acceptConclusion;

	/** 属性委托标志 */
	private String entrustSign;

	/** 属性委托机构 */
	private String entrustMngCom;

	/** 属性询问委托标志 */
	private String askEntrustSign;

	/** 属性受理日期 */
	private Date acceptDate;

	/** 属性预估金额 */
	private BigDecimal appraisalAmount;

	/** 属性申请类型值 */
	private String rgtClassValue;

	/** 属性报案方式值 */
	private String rptModeValue;

	/** 属性报案人与被保人关系值 */
	private String relationValue;

	/** 属性案件有效标志值 */
	private String avaiFlagValue;

	/** 属性管理机构名称 */
	private String mngComName;

	/** 属性受托人类型值 */
	private String assigneeTypeValue;

	/** 属性受托人性别值 */
	private String assigneeSexValue;

	/** 属性委托机构名称 */
	private String entrustMngComValue;

	/**
	 * 类LLReport的默认构造方法
	 */
	public LLReport() {
	}

	/**
	 * 属性团体报案号的getter方法
	 */
	@Id
	@Column(name = "RPTNO")
	public String getRptNo() {
		return this.rptNo;
	}

	/**
	 * 属性团体报案号的setter方法
	 */
	public void setRptNo(String rptNo) {
		this.rptNo = rptNo;
	}

	/**
	 * 属性申请类型的getter方法
	 */

	@Column(name = "RGTCLASS")
	public String getRgtClass() {
		return this.rgtClass;
	}

	/**
	 * 属性申请类型的setter方法
	 */
	public void setRgtClass(String rgtClass) {
		this.rgtClass = rgtClass;
	}

	/**
	 * 属性号码类型的getter方法
	 */

	@Column(name = "RGTOBJ")
	public String getRgtObj() {
		return this.rgtObj;
	}

	/**
	 * 属性号码类型的setter方法
	 */
	public void setRgtObj(String rgtObj) {
		this.rgtObj = rgtObj;
	}

	/**
	 * 属性其他号码的getter方法
	 */

	@Column(name = "RGTOBJNO")
	public String getRgtObjNo() {
		return this.rgtObjNo;
	}

	/**
	 * 属性其他号码的setter方法
	 */
	public void setRgtObjNo(String rgtObjNo) {
		this.rgtObjNo = rgtObjNo;
	}

	/**
	 * 属性报案方式的getter方法
	 */

	@Column(name = "RPTMODE")
	public String getRptMode() {
		return this.rptMode;
	}

	/**
	 * 属性报案方式的setter方法
	 */
	public void setRptMode(String rptMode) {
		this.rptMode = rptMode;
	}

	/**
	 * 属性立案人/申请人与被保人关系的getter方法
	 */

	@Column(name = "RELATION")
	public String getRelation() {
		return this.relation;
	}

	/**
	 * 属性立案人/申请人与被保人关系的setter方法
	 */
	public void setRelation(String relation) {
		this.relation = relation;
	}

	/**
	 * 属性报案人姓名的getter方法
	 */

	@Column(name = "RPTORNAME")
	public String getRptorName() {
		return this.rptorName;
	}

	/**
	 * 属性报案人姓名的setter方法
	 */
	public void setRptorName(String rptorName) {
		this.rptorName = rptorName;
	}

	/**
	 * 属性报案人通讯地址的getter方法
	 */

	@Column(name = "RPTORADDRESS")
	public String getRptorAddress() {
		return this.rptorAddress;
	}

	/**
	 * 属性报案人通讯地址的setter方法
	 */
	public void setRptorAddress(String rptorAddress) {
		this.rptorAddress = rptorAddress;
	}

	/**
	 * 属性报案人电话的getter方法
	 */

	@Column(name = "RPTORPHONE")
	public String getRptorPhone() {
		return this.rptorPhone;
	}

	/**
	 * 属性报案人电话的setter方法
	 */
	public void setRptorPhone(String rptorPhone) {
		this.rptorPhone = rptorPhone;
	}

	/**
	 * 属性报案人手机的getter方法
	 */

	@Column(name = "RPTORMOBILE")
	public String getRptorMobile() {
		return this.rptorMobile;
	}

	/**
	 * 属性报案人手机的setter方法
	 */
	public void setRptorMobile(String rptorMobile) {
		this.rptorMobile = rptorMobile;
	}

	/**
	 * 属性立案人/申请人电邮的getter方法
	 */

	@Column(name = "EMAIL")
	public String getEmail() {
		return this.email;
	}

	/**
	 * 属性立案人/申请人电邮的setter方法
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 属性立案人/申请人邮政编码的getter方法
	 */

	@Column(name = "POSTCODE")
	public String getPostCode() {
		return this.postCode;
	}

	/**
	 * 属性立案人/申请人邮政编码的setter方法
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	/**
	 * 属性回执发送方式的getter方法
	 */

	@Column(name = "RETURNMODE")
	public String getReturnMode() {
		return this.returnMode;
	}

	/**
	 * 属性回执发送方式的setter方法
	 */
	public void setReturnMode(String returnMode) {
		this.returnMode = returnMode;
	}

	/**
	 * 属性出险结束日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "ACCIDENTDATE")
	public Date getAccidentDate() {
		return this.accidentDate;
	}

	/**
	 * 属性出险结束日期的setter方法
	 */
	public void setAccidentDate(Date accidentDate) {
		this.accidentDate = accidentDate;
	}

	/**
	 * 属性出险地点的getter方法
	 */

	@Column(name = "ACCIDENTSITE")
	public String getAccidentSite() {
		return this.accidentSite;
	}

	/**
	 * 属性出险地点的setter方法
	 */
	public void setAccidentSite(String accidentSite) {
		this.accidentSite = accidentSite;
	}

	/**
	 * 属性出险原因的getter方法
	 */

	@Column(name = "ACCIDENTREASON")
	public String getAccidentReason() {
		return this.accidentReason;
	}

	/**
	 * 属性出险原因的setter方法
	 */
	public void setAccidentReason(String accidentReason) {
		this.accidentReason = accidentReason;
	}

	/**
	 * 属性出险过程和结果的getter方法
	 */

	@Column(name = "ACCIDENTCOURSE")
	public String getAccidentCourse() {
		return this.accidentCourse;
	}

	/**
	 * 属性出险过程和结果的setter方法
	 */
	public void setAccidentCourse(String accidentCourse) {
		this.accidentCourse = accidentCourse;
	}

	/**
	 * 属性报案日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "RPTDATE")
	public Date getRptDate() {
		return this.rptDate;
	}

	/**
	 * 属性报案日期的setter方法
	 */
	public void setRptDate(Date rptDate) {
		this.rptDate = rptDate;
	}

	/**
	 * 属性报备产生日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "CASENODATE")
	public Date getCaseNoDate() {
		return this.caseNoDate;
	}

	/**
	 * 属性报备产生日期的setter方法
	 */
	public void setCaseNoDate(Date caseNoDate) {
		this.caseNoDate = caseNoDate;
	}

	/**
	 * 属性报备结束日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "CASEENDDATE")
	public Date getCaseEndDate() {
		return this.caseEndDate;
	}

	/**
	 * 属性报备结束日期的setter方法
	 */
	public void setCaseEndDate(Date caseEndDate) {
		this.caseEndDate = caseEndDate;
	}

	/**
	 * 属性立案撤销原因的getter方法
	 */

	@Column(name = "RGTREASON")
	public String getRgtReason() {
		return this.rgtReason;
	}

	/**
	 * 属性立案撤销原因的setter方法
	 */
	public void setRgtReason(String rgtReason) {
		this.rgtReason = rgtReason;
	}

	/**
	 * 属性不立案原因的getter方法
	 */

	@Column(name = "NORGTREASON")
	public String getNoRgtReason() {
		return this.noRgtReason;
	}

	/**
	 * 属性不立案原因的setter方法
	 */
	public void setNoRgtReason(String noRgtReason) {
		this.noRgtReason = noRgtReason;
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
	 * 属性立案标志的getter方法
	 */

	@Column(name = "RGTFLAG")
	public String getRgtFlag() {
		return this.rgtFlag;
	}

	/**
	 * 属性立案标志的setter方法
	 */
	public void setRgtFlag(String rgtFlag) {
		this.rgtFlag = rgtFlag;
	}

	/**
	 * 属性案件有效标志的getter方法
	 */

	@Column(name = "AVAIFLAG")
	public String getAvaiFlag() {
		return this.avaiFlag;
	}

	/**
	 * 属性案件有效标志的setter方法
	 */
	public void setAvaiFlag(String avaiFlag) {
		this.avaiFlag = avaiFlag;
	}

	/**
	 * 属性案件有效原因的getter方法
	 */

	@Column(name = "AVALIREASON")
	public String getAvaliReason() {
		return this.avaliReason;
	}

	/**
	 * 属性案件有效原因的setter方法
	 */
	public void setAvaliReason(String avaliReason) {
		this.avaliReason = avaliReason;
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
	 * 属性受托人类型的getter方法
	 */

	@Column(name = "ASSIGNEETYPE")
	public String getAssigneeType() {
		return this.assigneeType;
	}

	/**
	 * 属性受托人类型的setter方法
	 */
	public void setAssigneeType(String assigneeType) {
		this.assigneeType = assigneeType;
	}

	/**
	 * 属性受托人代码的getter方法
	 */

	@Column(name = "ASSIGNEECODE")
	public String getAssigneeCode() {
		return this.assigneeCode;
	}

	/**
	 * 属性受托人代码的setter方法
	 */
	public void setAssigneeCode(String assigneeCode) {
		this.assigneeCode = assigneeCode;
	}

	/**
	 * 属性受托人姓名的getter方法
	 */

	@Column(name = "ASSIGNEENAME")
	public String getAssigneeName() {
		return this.assigneeName;
	}

	/**
	 * 属性受托人姓名的setter方法
	 */
	public void setAssigneeName(String assigneeName) {
		this.assigneeName = assigneeName;
	}

	/**
	 * 属性受托人性别的getter方法
	 */

	@Column(name = "ASSIGNEESEX")
	public String getAssigneeSex() {
		return this.assigneeSex;
	}

	/**
	 * 属性受托人性别的setter方法
	 */
	public void setAssigneeSex(String assigneeSex) {
		this.assigneeSex = assigneeSex;
	}

	/**
	 * 属性受托人电话的getter方法
	 */

	@Column(name = "ASSIGNEEPHONE")
	public String getAssigneePhone() {
		return this.assigneePhone;
	}

	/**
	 * 属性受托人电话的setter方法
	 */
	public void setAssigneePhone(String assigneePhone) {
		this.assigneePhone = assigneePhone;
	}

	/**
	 * 属性受托人地址的getter方法
	 */

	@Column(name = "ASSIGNEEADDR")
	public String getAssigneeAddr() {
		return this.assigneeAddr;
	}

	/**
	 * 属性受托人地址的setter方法
	 */
	public void setAssigneeAddr(String assigneeAddr) {
		this.assigneeAddr = assigneeAddr;
	}

	/**
	 * 属性受托人邮编的getter方法
	 */

	@Column(name = "ASSIGNEEZIP")
	public String getAssigneeZip() {
		return this.assigneeZip;
	}

	/**
	 * 属性受托人邮编的setter方法
	 */
	public void setAssigneeZip(String assigneeZip) {
		this.assigneeZip = assigneeZip;
	}

	/**
	 * 属性承保机构的getter方法
	 */

	@Column(name = "ACCEPTMNGCOM")
	public String getAcceptMngCom() {
		return this.acceptMngCom;
	}

	/**
	 * 属性承保机构的setter方法
	 */
	public void setAcceptMngCom(String acceptMngCom) {
		this.acceptMngCom = acceptMngCom;
	}

	/**
	 * 属性不予受理理由的getter方法
	 */

	@Column(name = "NOACCEPTREASON")
	public String getNoAcceptReason() {
		return this.noAcceptReason;
	}

	/**
	 * 属性不予受理理由的setter方法
	 */
	public void setNoAcceptReason(String noAcceptReason) {
		this.noAcceptReason = noAcceptReason;
	}

	/**
	 * 属性受理标志的getter方法
	 */

	@Column(name = "ACCEPTFLAG")
	public String getAcceptFlag() {
		return this.acceptFlag;
	}

	/**
	 * 属性受理标志的setter方法
	 */
	public void setAcceptFlag(String acceptFlag) {
		this.acceptFlag = acceptFlag;
	}

	/**
	 * 属性受理结论的getter方法
	 */

	@Column(name = "ACCEPTCONCLUSION")
	public String getAcceptConclusion() {
		return this.acceptConclusion;
	}

	/**
	 * 属性受理结论的setter方法
	 */
	public void setAcceptConclusion(String acceptConclusion) {
		this.acceptConclusion = acceptConclusion;
	}

	/**
	 * 属性委托标志的getter方法
	 */

	@Column(name = "ENTRUSTSIGN")
	public String getEntrustSign() {
		return this.entrustSign;
	}

	/**
	 * 属性委托标志的setter方法
	 */
	public void setEntrustSign(String entrustSign) {
		this.entrustSign = entrustSign;
	}

	/**
	 * 属性委托机构的getter方法
	 */

	@Column(name = "ENTRUSTMNGCOM")
	public String getEntrustMngCom() {
		return this.entrustMngCom;
	}

	/**
	 * 属性委托机构的setter方法
	 */
	public void setEntrustMngCom(String entrustMngCom) {
		this.entrustMngCom = entrustMngCom;
	}

	/**
	 * 属性询问委托标志的getter方法
	 */

	@Column(name = "ASKENTRUSTSIGN")
	public String getAskEntrustSign() {
		return this.askEntrustSign;
	}

	/**
	 * 属性询问委托标志的setter方法
	 */
	public void setAskEntrustSign(String askEntrustSign) {
		this.askEntrustSign = askEntrustSign;
	}

	/**
	 * 属性受理日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "ACCEPTDATE")
	public Date getAcceptDate() {
		return this.acceptDate;
	}

	/**
	 * 属性受理日期的setter方法
	 */
	public void setAcceptDate(Date acceptDate) {
		this.acceptDate = acceptDate;
	}

	/**
	 * 属性预估金额的getter方法
	 */

	@Column(name = "APPRAISALAMOUNT")
	public BigDecimal getAppraisalAmount() {
		return this.appraisalAmount;
	}

	/**
	 * 属性预估金额的setter方法
	 */
	public void setAppraisalAmount(BigDecimal appraisalAmount) {
		this.appraisalAmount = appraisalAmount;
	}

	/**
	 * 属性申请类型值的getter方法
	 */

	@Column(name = "RGTCLASSVALUE")
	public String getRgtClassValue() {
		return this.rgtClassValue;
	}

	/**
	 * 属性申请类型值的setter方法
	 */
	public void setRgtClassValue(String rgtClassValue) {
		this.rgtClassValue = rgtClassValue;
	}

	/**
	 * 属性报案方式值的getter方法
	 */

	@Column(name = "RPTMODEVALUE")
	public String getRptModeValue() {
		return this.rptModeValue;
	}

	/**
	 * 属性报案方式值的setter方法
	 */
	public void setRptModeValue(String rptModeValue) {
		this.rptModeValue = rptModeValue;
	}

	/**
	 * 属性报案人与被保人关系值的getter方法
	 */

	@Column(name = "RELATIONVALUE")
	public String getRelationValue() {
		return this.relationValue;
	}

	/**
	 * 属性报案人与被保人关系值的setter方法
	 */
	public void setRelationValue(String relationValue) {
		this.relationValue = relationValue;
	}

	/**
	 * 属性案件有效标志值的getter方法
	 */

	@Column(name = "AVAIFLAGVALUE")
	public String getAvaiFlagValue() {
		return this.avaiFlagValue;
	}

	/**
	 * 属性案件有效标志值的setter方法
	 */
	public void setAvaiFlagValue(String avaiFlagValue) {
		this.avaiFlagValue = avaiFlagValue;
	}

	/**
	 * 属性管理机构名称的getter方法
	 */

	@Column(name = "MNGCOMNAME")
	public String getMngComName() {
		return this.mngComName;
	}

	/**
	 * 属性管理机构名称的setter方法
	 */
	public void setMngComName(String mngComName) {
		this.mngComName = mngComName;
	}

	/**
	 * 属性受托人类型值的getter方法
	 */

	@Column(name = "ASSIGNEETYPEVALUE")
	public String getAssigneeTypeValue() {
		return this.assigneeTypeValue;
	}

	/**
	 * 属性受托人类型值的setter方法
	 */
	public void setAssigneeTypeValue(String assigneeTypeValue) {
		this.assigneeTypeValue = assigneeTypeValue;
	}

	/**
	 * 属性受托人性别值的getter方法
	 */

	@Column(name = "ASSIGNEESEXVALUE")
	public String getAssigneeSexValue() {
		return this.assigneeSexValue;
	}

	/**
	 * 属性受托人性别值的setter方法
	 */
	public void setAssigneeSexValue(String assigneeSexValue) {
		this.assigneeSexValue = assigneeSexValue;
	}

	/**
	 * 属性委托机构名称的getter方法
	 */

	@Column(name = "ENTRUSTMNGCOMVALUE")
	public String getEntrustMngComValue() {
		return this.entrustMngComValue;
	}

	/**
	 * 属性委托机构名称的setter方法
	 */
	public void setEntrustMngComValue(String entrustMngComValue) {
		this.entrustMngComValue = entrustMngComValue;
	}

}
