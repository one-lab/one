package ins.claim.report.vo;

import java.util.Date;

/**
 * @title ClaimReportInfoVo
 * @description 报案出险信息类
 * @author zhangkai
 * @version 
 * @create date 2012-8-20
 */
public class ClaimReportInfoVo {
	
	//报案信息
	/** 属性事件号 */
	private String accNo;
	
	/** 属性报案号 */
	private String rptNo;
	
	/** 属性报案人与被保人关系 */
	private String relation;
	
	/** 属性报案日期 */
	private Date rptDate;

	/** 属性报案人姓名 */
	private String rptorName;
	
	/** 属性报案人电话 */
	private String rptorPhone;
	
	/** 属性报案人地址 */
	private String rptorAddress;

	/** 属性报案人邮政编码 */
	private String postCode;

	/** 属性报案方式 */
	private String rptMode;
	
	/** 属性管理部门 */
	private String mngCom;

	/** 属性操作员 */
	private String operator;
	
	//出险详细信息
	/** 属性出险人客户号 */
	private String customerNo;

	/** 出险人姓名 */
	private String customerName;
	
	/** 属性出险人年龄 */
	private Double customerAge;

	/** 出险人性别 */
	private String customerSex;
	
	/** 属性出险人生日 */
	private Date custBirthday;
	
	/** 属性出险人证件类型 */
	private String idType;

	/** 属性出险人证件号码 */
	private String idNo;
	
	/** 属性出险人联系电话 */
	private String contactNo;
	
	/** 属性事故发生日期 */
	private Date accDate;

	/** 属性出险原因 */
	private String accidentReason;
	
	/** 属性出险地点 */
	private String accidentSite;
	
	/** 出险日期 */
	private Date accidentDate;
	
	/** 属性医院代码 */
	private String hospitalCode;
	
	/** 属性治疗情况 */
	private String cureDesc;
	
	/** 属性出险结果1 */
	private String accResult1;

	/** 属性出险结果2 */
	private String accResult2;
	
	/** 属性住院科室 */
	private String sectionOffice;
	
	/** 属性死亡日期 */
	private Date dieDate;
	
	/** 属性出险细节 */
	private String accidentDetail;
	
	/** 属性理赔类型 */
	private String reasonCode;
	
	/** 属性事故描述 */
	private String accDesc;

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getRptNo() {
		return rptNo;
	}

	public void setRptNo(String rptNo) {
		this.rptNo = rptNo;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public Date getRptDate() {
		return rptDate;
	}

	public void setRptDate(Date rptDate) {
		this.rptDate = rptDate;
	}

	public String getRptorName() {
		return rptorName;
	}

	public void setRptorName(String rptorName) {
		this.rptorName = rptorName;
	}

	public String getRptorPhone() {
		return rptorPhone;
	}

	public void setRptorPhone(String rptorPhone) {
		this.rptorPhone = rptorPhone;
	}

	public String getRptorAddress() {
		return rptorAddress;
	}

	public void setRptorAddress(String rptorAddress) {
		this.rptorAddress = rptorAddress;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getRptMode() {
		return rptMode;
	}

	public void setRptMode(String rptMode) {
		this.rptMode = rptMode;
	}

	public String getMngCom() {
		return mngCom;
	}

	public void setMngCom(String mngCom) {
		this.mngCom = mngCom;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Double getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(Double customerAge) {
		this.customerAge = customerAge;
	}

	public String getCustomerSex() {
		return customerSex;
	}

	public void setCustomerSex(String customerSex) {
		this.customerSex = customerSex;
	}

	public Date getCustBirthday() {
		return custBirthday;
	}

	public void setCustBirthday(Date custBirthday) {
		this.custBirthday = custBirthday;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Date getAccDate() {
		return accDate;
	}

	public void setAccDate(Date accDate) {
		this.accDate = accDate;
	}

	public String getAccidentReason() {
		return accidentReason;
	}

	public void setAccidentReason(String accidentReason) {
		this.accidentReason = accidentReason;
	}

	public String getAccidentSite() {
		return accidentSite;
	}

	public void setAccidentSite(String accidentSite) {
		this.accidentSite = accidentSite;
	}

	public Date getAccidentDate() {
		return accidentDate;
	}

	public void setAccidentDate(Date accidentDate) {
		this.accidentDate = accidentDate;
	}

	public String getHospitalCode() {
		return hospitalCode;
	}
	
	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	public String getCureDesc() {
		return cureDesc;
	}
	
	public void setCureDesc(String cureDesc) {
		this.cureDesc = cureDesc;
	}

	public String getAccResult1() {
		return accResult1;
	}

	public void setAccResult1(String accResult1) {
		this.accResult1 = accResult1;
	}

	public String getAccResult2() {
		return accResult2;
	}

	public void setAccResult2(String accResult2) {
		this.accResult2 = accResult2;
	}

	public String getSectionOffice() {
		return sectionOffice;
	}

	public void setSectionOffice(String sectionOffice) {
		this.sectionOffice = sectionOffice;
	}

	public Date getDieDate() {
		return dieDate;
	}

	public void setDieDate(Date dieDate) {
		this.dieDate = dieDate;
	}

	public String getAccidentDetail() {
		return accidentDetail;
	}

	public void setAccidentDetail(String accidentDetail) {
		this.accidentDetail = accidentDetail;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getAccDesc() {
		return accDesc;
	}

	public void setAccDesc(String accDesc) {
		this.accDesc = accDesc;
	}

	public ClaimReportInfoVo() {
	}
}
