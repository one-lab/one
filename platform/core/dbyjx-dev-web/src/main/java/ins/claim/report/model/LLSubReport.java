package ins.claim.report.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.math.BigDecimal;
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
 * POJO类LLSubReport
 */
@Entity
@Table(name = "LLSUBREPORT")
public class LLSubReport implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性id */
	private LLSubReportId id;

	/** 属性出险人名称 */
	private String customerName;

	/** 属性关联客户类型 */
	private String customerType;

	/** 属性事件主题 */
	private String accSubject;

	/** 属性出险类型 */
	private String accidentType;

	/** 属性事故发生日期 */
	private Date accDate;

	/** 属性终止日期 */
	private Date accEndDate;

	/** 属性事故描述 */
	private String accDesc;

	/** 属性事故者状况 */
	private String custSituation;

	/** 属性事故地点 */
	private String accPlace;

	/** 属性医院代码 */
	private String hospitalCode;

	/** 属性医院名称 */
	private String hospitalName;

	/** 属性入院日期 */
	private Date inHospitalDate;

	/** 属性出院日期 */
	private Date outHospitalDate;

	/** 属性备注 */
	private String remark;

	/** 属性重大事件标志 */
	private String seriousGrade;

	/** 属性调查报告标志 */
	private String surveyFlag;

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

	/** 属性首诊日 */
	private Date firstDiaDate;

	/** 属性医院等级 */
	private String hosGrade;

	/** 属性所在地 */
	private String localPlace;

	/** 属性医院联系电话 */
	private String hosTel;

	/** 属性死亡日期 */
	private Date dieDate;

	/** 属性事件原因 */
	private String accCause;

	/** 属性VIP标志 */
	private String vipFlag;

	/** 属性出险细节 */
	private String accidentDetail;

	/** 属性治疗情况 */
	private String cureDesc;

	/** 属性发起呈报标志 */
	private String submitFlag;

	/** 属性提起慰问标志 */
	private String condoleFlag;

	/** 属性死亡标志 */
	private String dieFlag;

	/** 属性出险结果1 */
	private String accResult1;

	/** 属性出险结果2 */
	private String accResult2;

	/** 属性客户序号 */
	private BigDecimal seqNo;

	/** 属性出险人联系电话 */
	private String contactNo;

	/** 属性住院科室 */
	private String sectionOffice;

	/** 属性承保机构 */
	private String acceptMngCom;

	/** 属性出险人生日 */
	private Date custBirthday;

	/** 属性出险人性别 */
	private String customerSex;

	/** 属性出险人年龄 */
	private Double customerAge;

	/** 属性受益人证件类型 */
	private String idType;

	/** 属性受益人证件号码 */
	private String idNo;

	/** 属性集体合同号码 */
	private String grpContNo;

	/** 属性保单号码 */
	private String polNo;

	/** 属性管理机构名称 */
	private String mngComName;

	/** 属性事件原因值 */
	private String accCauseValue;

	/** 属性出险细节值 */
	private String accidentDetailValue;

	/** 属性治疗情况值 */
	private String cureDescValue;

	/** 属性出险结果1值 */
	private String accResult1Value;

	/** 属性出险结果2值 */
	private String accResult2Value;

	/** 属性出险人性别值 */
	private String sexValue;

	/** 属性证件类型值 */
	private String idTypeValue;

	/**
	 * 类LLSubReport的默认构造方法
	 */
	public LLSubReport() {
	}

	/**
	 * 属性id的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "subRptNo", column = @Column(name = "SUBRPTNO")),
			@AttributeOverride(name = "customerNo", column = @Column(name = "CUSTOMERNO")) })
	public LLSubReportId getId() {
		return this.id;
	}

	/**
	 * 属性id的setter方法
	 */
	public void setId(LLSubReportId id) {
		this.id = id;
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
	 * 属性关联客户类型的getter方法
	 */

	@Column(name = "CUSTOMERTYPE")
	public String getCustomerType() {
		return this.customerType;
	}

	/**
	 * 属性关联客户类型的setter方法
	 */
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
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
	 * 属性出险类型的getter方法
	 */

	@Column(name = "ACCIDENTTYPE")
	public String getAccidentType() {
		return this.accidentType;
	}

	/**
	 * 属性出险类型的setter方法
	 */
	public void setAccidentType(String accidentType) {
		this.accidentType = accidentType;
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
	 * 属性终止日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "ACCENDDATE")
	public Date getAccEndDate() {
		return this.accEndDate;
	}

	/**
	 * 属性终止日期的setter方法
	 */
	public void setAccEndDate(Date accEndDate) {
		this.accEndDate = accEndDate;
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
	 * 属性事故者状况的getter方法
	 */

	@Column(name = "CUSTSITUATION")
	public String getCustSituation() {
		return this.custSituation;
	}

	/**
	 * 属性事故者状况的setter方法
	 */
	public void setCustSituation(String custSituation) {
		this.custSituation = custSituation;
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
	 * 属性医院代码的getter方法
	 */

	@Column(name = "HOSPITALCODE")
	public String getHospitalCode() {
		return this.hospitalCode;
	}

	/**
	 * 属性医院代码的setter方法
	 */
	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
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
	 * 属性入院日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "INHOSPITALDATE")
	public Date getInHospitalDate() {
		return this.inHospitalDate;
	}

	/**
	 * 属性入院日期的setter方法
	 */
	public void setInHospitalDate(Date inHospitalDate) {
		this.inHospitalDate = inHospitalDate;
	}

	/**
	 * 属性出院日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "OUTHOSPITALDATE")
	public Date getOutHospitalDate() {
		return this.outHospitalDate;
	}

	/**
	 * 属性出院日期的setter方法
	 */
	public void setOutHospitalDate(Date outHospitalDate) {
		this.outHospitalDate = outHospitalDate;
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
	 * 属性重大事件标志的getter方法
	 */

	@Column(name = "SERIOUSGRADE")
	public String getSeriousGrade() {
		return this.seriousGrade;
	}

	/**
	 * 属性重大事件标志的setter方法
	 */
	public void setSeriousGrade(String seriousGrade) {
		this.seriousGrade = seriousGrade;
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
	 * 属性首诊日的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "FIRSTDIADATE")
	public Date getFirstDiaDate() {
		return this.firstDiaDate;
	}

	/**
	 * 属性首诊日的setter方法
	 */
	public void setFirstDiaDate(Date firstDiaDate) {
		this.firstDiaDate = firstDiaDate;
	}

	/**
	 * 属性医院等级的getter方法
	 */

	@Column(name = "HOSGRADE")
	public String getHosGrade() {
		return this.hosGrade;
	}

	/**
	 * 属性医院等级的setter方法
	 */
	public void setHosGrade(String hosGrade) {
		this.hosGrade = hosGrade;
	}

	/**
	 * 属性所在地的getter方法
	 */

	@Column(name = "LOCALPLACE")
	public String getLocalPlace() {
		return this.localPlace;
	}

	/**
	 * 属性所在地的setter方法
	 */
	public void setLocalPlace(String localPlace) {
		this.localPlace = localPlace;
	}

	/**
	 * 属性医院联系电话的getter方法
	 */

	@Column(name = "HOSTEL")
	public String getHosTel() {
		return this.hosTel;
	}

	/**
	 * 属性医院联系电话的setter方法
	 */
	public void setHosTel(String hosTel) {
		this.hosTel = hosTel;
	}

	/**
	 * 属性死亡日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "DIEDATE")
	public Date getDieDate() {
		return this.dieDate;
	}

	/**
	 * 属性死亡日期的setter方法
	 */
	public void setDieDate(Date dieDate) {
		this.dieDate = dieDate;
	}

	/**
	 * 属性事件原因的getter方法
	 */

	@Column(name = "ACCCAUSE")
	public String getAccCause() {
		return this.accCause;
	}

	/**
	 * 属性事件原因的setter方法
	 */
	public void setAccCause(String accCause) {
		this.accCause = accCause;
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
	 * 属性出险细节的getter方法
	 */

	@Column(name = "ACCIDENTDETAIL")
	public String getAccidentDetail() {
		return this.accidentDetail;
	}

	/**
	 * 属性出险细节的setter方法
	 */
	public void setAccidentDetail(String accidentDetail) {
		this.accidentDetail = accidentDetail;
	}

	/**
	 * 属性治疗情况的getter方法
	 */

	@Column(name = "CUREDESC")
	public String getCureDesc() {
		return this.cureDesc;
	}

	/**
	 * 属性治疗情况的setter方法
	 */
	public void setCureDesc(String cureDesc) {
		this.cureDesc = cureDesc;
	}

	/**
	 * 属性发起呈报标志的getter方法
	 */

	@Column(name = "SUBMITFLAG")
	public String getSubmitFlag() {
		return this.submitFlag;
	}

	/**
	 * 属性发起呈报标志的setter方法
	 */
	public void setSubmitFlag(String submitFlag) {
		this.submitFlag = submitFlag;
	}

	/**
	 * 属性提起慰问标志的getter方法
	 */

	@Column(name = "CONDOLEFLAG")
	public String getCondoleFlag() {
		return this.condoleFlag;
	}

	/**
	 * 属性提起慰问标志的setter方法
	 */
	public void setCondoleFlag(String condoleFlag) {
		this.condoleFlag = condoleFlag;
	}

	/**
	 * 属性死亡标志的getter方法
	 */

	@Column(name = "DIEFLAG")
	public String getDieFlag() {
		return this.dieFlag;
	}

	/**
	 * 属性死亡标志的setter方法
	 */
	public void setDieFlag(String dieFlag) {
		this.dieFlag = dieFlag;
	}

	/**
	 * 属性出险结果1的getter方法
	 */

	@Column(name = "ACCRESULT1")
	public String getAccResult1() {
		return this.accResult1;
	}

	/**
	 * 属性出险结果1的setter方法
	 */
	public void setAccResult1(String accResult1) {
		this.accResult1 = accResult1;
	}

	/**
	 * 属性出险结果2的getter方法
	 */

	@Column(name = "ACCRESULT2")
	public String getAccResult2() {
		return this.accResult2;
	}

	/**
	 * 属性出险结果2的setter方法
	 */
	public void setAccResult2(String accResult2) {
		this.accResult2 = accResult2;
	}

	/**
	 * 属性客户序号的getter方法
	 */

	@Column(name = "SEQNO")
	public BigDecimal getSeqNo() {
		return this.seqNo;
	}

	/**
	 * 属性客户序号的setter方法
	 */
	public void setSeqNo(BigDecimal seqNo) {
		this.seqNo = seqNo;
	}

	/**
	 * 属性出险人联系电话的getter方法
	 */

	@Column(name = "CONTACTNO")
	public String getContactNo() {
		return this.contactNo;
	}

	/**
	 * 属性出险人联系电话的setter方法
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	/**
	 * 属性住院科室的getter方法
	 */

	@Column(name = "SECTIONOFFICE")
	public String getSectionOffice() {
		return this.sectionOffice;
	}

	/**
	 * 属性住院科室的setter方法
	 */
	public void setSectionOffice(String sectionOffice) {
		this.sectionOffice = sectionOffice;
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
	 * 属性出险人生日的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "CUSTBIRTHDAY")
	public Date getCustBirthday() {
		return this.custBirthday;
	}

	/**
	 * 属性出险人生日的setter方法
	 */
	public void setCustBirthday(Date custBirthday) {
		this.custBirthday = custBirthday;
	}

	/**
	 * 属性出险人性别的getter方法
	 */

	@Column(name = "CUSTOMERSEX")
	public String getCustomerSex() {
		return this.customerSex;
	}

	/**
	 * 属性出险人性别的setter方法
	 */
	public void setCustomerSex(String customerSex) {
		this.customerSex = customerSex;
	}

	/**
	 * 属性出险人年龄的getter方法
	 */

	@Column(name = "CUSTOMERAGE")
	public Double getCustomerAge() {
		return this.customerAge;
	}

	/**
	 * 属性出险人年龄的setter方法
	 */
	public void setCustomerAge(Double customerAge) {
		this.customerAge = customerAge;
	}

	/**
	 * 属性受益人证件类型的getter方法
	 */

	@Column(name = "IDTYPE")
	public String getIdType() {
		return this.idType;
	}

	/**
	 * 属性受益人证件类型的setter方法
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}

	/**
	 * 属性受益人证件号码的getter方法
	 */

	@Column(name = "IDNO")
	public String getIdNo() {
		return this.idNo;
	}

	/**
	 * 属性受益人证件号码的setter方法
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	/**
	 * 属性集体合同号码的getter方法
	 */

	@Column(name = "GRPCONTNO")
	public String getGrpContNo() {
		return this.grpContNo;
	}

	/**
	 * 属性集体合同号码的setter方法
	 */
	public void setGrpContNo(String grpContNo) {
		this.grpContNo = grpContNo;
	}

	/**
	 * 属性保单号码的getter方法
	 */

	@Column(name = "POLNO")
	public String getPolNo() {
		return this.polNo;
	}

	/**
	 * 属性保单号码的setter方法
	 */
	public void setPolNo(String polNo) {
		this.polNo = polNo;
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
	 * 属性事件原因值的getter方法
	 */

	@Column(name = "ACCCAUSEVALUE")
	public String getAccCauseValue() {
		return this.accCauseValue;
	}

	/**
	 * 属性事件原因值的setter方法
	 */
	public void setAccCauseValue(String accCauseValue) {
		this.accCauseValue = accCauseValue;
	}

	/**
	 * 属性出险细节值的getter方法
	 */

	@Column(name = "ACCIDENTDETAILVALUE")
	public String getAccidentDetailValue() {
		return this.accidentDetailValue;
	}

	/**
	 * 属性出险细节值的setter方法
	 */
	public void setAccidentDetailValue(String accidentDetailValue) {
		this.accidentDetailValue = accidentDetailValue;
	}

	/**
	 * 属性治疗情况值的getter方法
	 */

	@Column(name = "CUREDESCVALUE")
	public String getCureDescValue() {
		return this.cureDescValue;
	}

	/**
	 * 属性治疗情况值的setter方法
	 */
	public void setCureDescValue(String cureDescValue) {
		this.cureDescValue = cureDescValue;
	}

	/**
	 * 属性出险结果1值的getter方法
	 */

	@Column(name = "ACCRESULT1VALUE")
	public String getAccResult1Value() {
		return this.accResult1Value;
	}

	/**
	 * 属性出险结果1值的setter方法
	 */
	public void setAccResult1Value(String accResult1Value) {
		this.accResult1Value = accResult1Value;
	}

	/**
	 * 属性出险结果2值的getter方法
	 */

	@Column(name = "ACCRESULT2VALUE")
	public String getAccResult2Value() {
		return this.accResult2Value;
	}

	/**
	 * 属性出险结果2值的setter方法
	 */
	public void setAccResult2Value(String accResult2Value) {
		this.accResult2Value = accResult2Value;
	}

	/**
	 * 属性出险人性别值的getter方法
	 */

	@Column(name = "SEXVALUE")
	public String getSexValue() {
		return this.sexValue;
	}

	/**
	 * 属性出险人性别值的setter方法
	 */
	public void setSexValue(String sexValue) {
		this.sexValue = sexValue;
	}

	/**
	 * 属性证件类型值的getter方法
	 */

	@Column(name = "IDTYPEVALUE")
	public String getIdTypeValue() {
		return this.idTypeValue;
	}

	/**
	 * 属性证件类型值的setter方法
	 */
	public void setIdTypeValue(String idTypeValue) {
		this.idTypeValue = idTypeValue;
	}

}
