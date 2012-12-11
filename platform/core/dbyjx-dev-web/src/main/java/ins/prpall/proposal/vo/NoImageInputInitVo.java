package ins.prpall.proposal.vo;

import ins.prpall.proposal.model.LCRepInfo;
import ins.prpall.report.model.LCGrpPol;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 
 * @title NoImageInputInitVo
 * @description 初始化无影像录入页面 类
 * @author xu_xinling
 * @version 
 * @create date 2012-8-10
 * @copyright (c) 
 *
 */
public class NoImageInputInitVo {
	
	/**集体保单*/
	//投保单号码
	private String grpContNo;
	//呈报件号
	private String reportNo;
	//投保日期
	private Date firstTrialDate;
	//保单生效日期
	private Date cvaliDate;
	//续保原保单号
	private String cregistNo;
	//管理机构
	private String manageCom;
	//销售方式
	private String grpSellType;
	//协议书号
	private String conferNo;
	
	

	
	
	
	
	/**团体客户表*/
	//VIP客户
	private String vipValue;
	//投保单位名称
	private String grpName;
	//行业类别
	private String businessType;
	//组织机构代码
	private String organizationNo;
	//资产总额（万元）
	private BigDecimal asset;
	//税务登记证号
	private String taxRegistNo;
	//年总收入（万元）
	private BigDecimal yearGrossIncome;
	//单位性质
	private String grpNature;
	//成立日期
	private Date foundDate;
	//经营区域
	private String operateArea;
	//主营业务
	private String mainBussiness;
	//单位总人数
	private String grpAllPeoples;
	
	
	/**团单投保人表*/
	//是否已参加社会统筹
	private String societyStat;
	//社保登记证号
	private String societyRegistNo;
	//联系地址
	private String postalAddress;
	
	//private String addressNo;
	
	//联系邮编
	private String zipCode;
	//联系电话
	private String phone;
	//联系部门
	private String department;
	//联系人
	private String name1;
	//联系人性别
	private String sex1;
	//联系人电话
	private String telphone1;
	//手机
	private String phone1;
	//E-MAIL
	private String email;
	
	/**集体保单表*/
	//单位法人
	private String corporation;
	//法人证件类型
	private String corporationIDType;
	//法人证件号
	private String corporationIDNo;
	//法人有效日期
	private Date corporationsDate;
	//投保单位人数
	private Long grpPeoples;
	//主被保险人数
	private Long mainInsurePersonNumber;
	//连带被保险人数
	private Long relatedInsurePersonNumber;
	//投保率
	private BigDecimal rate;
	
	/**投保单告知信息表*/
	
	//保单付费方式:投保单位全额负担
	private String premClearingForm;
	//单位负担（%）
	private String unitsBurden;
	//特定约定编码
	private String specNo;
	//特定约定内容
	private String specNoName;
	
	//告知部分类（告知版别，告知内容编号，告知内容，录入信息）
	private List<LCRepInfo> lcRepInfoList;
	
	//同业竞争状况
	private String competitionStatus;
	//被保险人情况
	private String insurStatus;
	//既往理赔史
	private String clmHistory;
	//保单相关情况及服务要求
	private String conStatusAndServ;
	
	/** 隐藏域 */
	//客户号
	private String customerNoHidden;
	//集体投保单号
	private String proposalGrpContNoHidden;
	//地址号码
	private String AddressNo;
	
	
	
	/**集体险种表 */
	//险种编码
	private String riskCode;
	//险种名称
	private String riskName;
	// 属性保费 
	private BigDecimal prem;
	// 属性保额 
	private BigDecimal amnt;
	
	/**能过呈报号、客户号 查询的集体险种集合类 */
	private List<LCGrpPolVo> lcGrpPolList;
	
	//空构造方法
	public NoImageInputInitVo(){
		
	}
	
	public NoImageInputInitVo(
	/**集体保单*/
	//投保单号码
	 String grpContNo,
	//呈报件号
	 String reportNo,
	//投保日期
	 Date firstTrialDate,
	//保单生效日期
	 Date cvaliDate,
	//续保原保单号
	 String cregistNo,
	//管理机构
	 String manageCom,
	//销售方式
	 String grpSellType,
	//协议书号
	 String conferNo,
	
	 
	

	 
	/**团体客户表*/
	//VIP客户
	 String vipValue,
	//投保单位名称
	 String grpName,
	//行业类别
	 String businessType,
	//组织机构代码
	 String organizationNo,
	//资产总额（万元）
	 BigDecimal asset,
	//税务登记证号
	 String taxRegistNo,
	//年总收入（万元）
	 BigDecimal yearGrossIncome,
	//单位性质
	 String grpNature,
	//成立日期
	 Date foundDate,
	//经营区域
	 String operateArea,
	//主营业务
	 String mainBussiness,
	//单位总人数
	 String grpAllPeoples,
	
	
	/**团单投保人表*/
	//是否已参加社会统筹
	 String societyStat,
	//社保登记证号
	 String societyRegistNo,
	//联系地址
	 String postalAddress,
	
	// String addressNo,
	
	//联系邮编
	 String zipCode,
	//联系电话
	 String phone,
	//联系部门
	 String department,
	//联系人
	 String name1,
	//联系人性别
	 String sex1,
	//联系人电话
	 String telphone1,
	//手机
	 String phone1,
	//E-MAIL
	 String email,
	
	/**集体保单表*/
	//单位法人
	 String corporation,
	//法人证件类型
	 String corporationIDType,
	//法人证件号
	 String corporationIDNo,
	//法人有效日期
	 Date corporationsDate,
	//投保单位人数
	 Long grpPeoples,
	//主被保险人数
	 Long mainInsurePersonNumber,
	//连带被保险人数
	 Long relatedInsurePersonNumber,
	//投保率
	 BigDecimal rate,
	
	/**投保单告知信息表*/
	
	//保单付费方式:投保单位全额负担
	// String premClearingForm,
	//单位负担（%）
	// String unitsBurden,
	//特定约定编码
	// String specNo,
	//特定约定内容
	// String specNoName,
	 
	//被保险人情况	
	 String competitionStatus,
	//既往理赔史
	 String insurStatus,
	//保单相关情况及服务要求
	 String clmHistory,
	//同业竞争状况
	 String conStatusAndServ
	){
		super();
		/**集体保单*/
		//投保单号码
		 this.grpContNo=grpContNo;
		//呈报件号
		 this.reportNo=reportNo;
		//投保日期
		 this.firstTrialDate=firstTrialDate;
		//保单生效日期
		 this.cvaliDate=cvaliDate;
		//续保原保单号
		 this.cregistNo=cregistNo;
		//管理机构
		 this.manageCom=manageCom;
		//销售方式
		 this.grpSellType=grpSellType;
		//协议书号
		 this.conferNo=conferNo;
		
		/**团体客户表*/
		//VIP客户
		 this.vipValue=vipValue;
		//投保单位名称
		 this.grpName=grpName;
		//行业类别
		 this.businessType=businessType;
		//组织机构代码
		 this.organizationNo=organizationNo;
		//资产总额（万元）
		 this.asset=asset;
		//税务登记证号
		 this.taxRegistNo=taxRegistNo;
		//年总收入（万元）
		 this.yearGrossIncome=yearGrossIncome;
		//单位性质
		 this.grpNature=grpNature;
		//成立日期
		 this.foundDate=foundDate;
		//经营区域
		 this.operateArea=operateArea;
		//主营业务
		 this.mainBussiness=mainBussiness;
		//单位总人数
		 this.grpAllPeoples=grpAllPeoples;
		
		
		/**团单投保人表*/
		//是否已参加社会统筹
		 this.societyStat=societyStat;
		//社保登记证号
		 this.societyRegistNo=societyRegistNo;
		//联系地址
		 this.postalAddress=postalAddress;
		
		// this. addressNo=;
		
		//联系邮编
		 this.zipCode=zipCode;
		//联系电话
		 this.phone=phone;
		//联系部门
		 this.department=department;
		//联系人
		 this.name1=name1;
		//联系人性别
		 this.sex1=sex1;
		//联系人电话
		 this.telphone1=telphone1;
		//手机
		 this.phone1=phone1;
		//E-MAIL
		 this.email=email;
		
		/**集体保单表*/
		//单位法人
		 this.corporation=corporation;
		//法人证件类型
		 this.corporationIDType=corporationIDType;
		//法人证件号
		 this.corporationIDNo=corporationIDNo;
		//法人有效日期
		 this.corporationsDate=corporationsDate;
		//投保单位人数
		 this.grpPeoples=grpPeoples;
		//主被保险人数
		 this.mainInsurePersonNumber=mainInsurePersonNumber;
		//连带被保险人数
		 this.relatedInsurePersonNumber=relatedInsurePersonNumber;
		//投保率
		 this.rate=rate;
		
		/**投保单告知信息表*/
		
		//保单付费方式:投保单位全额负担
		// this.premClearingForm=premClearingForm;
		//单位负担（%）
		// this.unitsBurden=unitsBurden;
		//特定约定编码
		// this.specNo=specNo;
		//特定约定内容
		// this.specNoName=specNoName;
		//被保险人情况	
		 this.competitionStatus=competitionStatus;
		//既往理赔史
		 this.insurStatus=insurStatus;
		//保单相关情况及服务要求
		 this.clmHistory=clmHistory;
		//同业竞争状况
		 this.conStatusAndServ=conStatusAndServ;
	}

	/**
	 * @return the grpContNo
	 */
	public String getGrpContNo() {
		return grpContNo;
	}

	/**
	 * @param grpContNo the grpContNo to set
	 */
	public void setGrpContNo(String grpContNo) {
		this.grpContNo = grpContNo;
	}

	/**
	 * @return the reportNo
	 */
	public String getReportNo() {
		return reportNo;
	}

	/**
	 * @param reportNo the reportNo to set
	 */
	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}

	/**
	 * @return the firstTrialDate
	 */
	public Date getFirstTrialDate() {
		return firstTrialDate;
	}

	/**
	 * @param firstTrialDate the firstTrialDate to set
	 */
	public void setFirstTrialDate(Date firstTrialDate) {
		this.firstTrialDate = firstTrialDate;
	}

	/**
	 * @return the cvaliDate
	 */
	public Date getCvaliDate() {
		return cvaliDate;
	}

	/**
	 * @param cvaliDate the cvaliDate to set
	 */
	public void setCvaliDate(Date cvaliDate) {
		this.cvaliDate = cvaliDate;
	}

	/**
	 * @return the cregistNo
	 */
	public String getCregistNo() {
		return cregistNo;
	}

	/**
	 * @param cregistNo the cregistNo to set
	 */
	public void setCregistNo(String cregistNo) {
		this.cregistNo = cregistNo;
	}

	/**
	 * @return the manageCom
	 */
	public String getManageCom() {
		return manageCom;
	}

	/**
	 * @param manageCom the manageCom to set
	 */
	public void setManageCom(String manageCom) {
		this.manageCom = manageCom;
	}

	/**
	 * @return the grpSellType
	 */
	public String getGrpSellType() {
		return grpSellType;
	}

	/**
	 * @param grpSellType the grpSellType to set
	 */
	public void setGrpSellType(String grpSellType) {
		this.grpSellType = grpSellType;
	}

	/**
	 * @return the conferNo
	 */
	public String getConferNo() {
		return conferNo;
	}

	/**
	 * @param conferNo the conferNo to set
	 */
	public void setConferNo(String conferNo) {
		this.conferNo = conferNo;
	}

	/**
	 * @return the vipValue
	 */
	public String getVipValue() {
		return vipValue;
	}

	/**
	 * @param vipValue the vipValue to set
	 */
	public void setVipValue(String vipValue) {
		this.vipValue = vipValue;
	}

	/**
	 * @return the grpName
	 */
	public String getGrpName() {
		return grpName;
	}

	/**
	 * @param grpName the grpName to set
	 */
	public void setGrpName(String grpName) {
		this.grpName = grpName;
	}

	/**
	 * @return the businessType
	 */
	public String getBusinessType() {
		return businessType;
	}

	/**
	 * @param businessType the businessType to set
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	/**
	 * @return the organizationNo
	 */
	public String getOrganizationNo() {
		return organizationNo;
	}

	/**
	 * @param organizationNo the organizationNo to set
	 */
	public void setOrganizationNo(String organizationNo) {
		this.organizationNo = organizationNo;
	}

	/**
	 * @return the asset
	 */
	public BigDecimal getAsset() {
		return asset;
	}

	/**
	 * @param asset the asset to set
	 */
	public void setAsset(BigDecimal asset) {
		this.asset = asset;
	}

	/**
	 * @return the taxRegistNo
	 */
	public String getTaxRegistNo() {
		return taxRegistNo;
	}

	/**
	 * @param taxRegistNo the taxRegistNo to set
	 */
	public void setTaxRegistNo(String taxRegistNo) {
		this.taxRegistNo = taxRegistNo;
	}

	/**
	 * @return the yearGrossIncome
	 */
	public BigDecimal getYearGrossIncome() {
		return yearGrossIncome;
	}

	/**
	 * @param yearGrossIncome the yearGrossIncome to set
	 */
	public void setYearGrossIncome(BigDecimal yearGrossIncome) {
		this.yearGrossIncome = yearGrossIncome;
	}

	/**
	 * @return the grpNature
	 */
	public String getGrpNature() {
		return grpNature;
	}

	/**
	 * @param grpNature the grpNature to set
	 */
	public void setGrpNature(String grpNature) {
		this.grpNature = grpNature;
	}

	/**
	 * @return the foundDate
	 */
	public Date getFoundDate() {
		return foundDate;
	}

	/**
	 * @param foundDate the foundDate to set
	 */
	public void setFoundDate(Date foundDate) {
		this.foundDate = foundDate;
	}

	/**
	 * @return the operateArea
	 */
	public String getOperateArea() {
		return operateArea;
	}

	/**
	 * @param operateArea the operateArea to set
	 */
	public void setOperateArea(String operateArea) {
		this.operateArea = operateArea;
	}

	/**
	 * @return the mainBussiness
	 */
	public String getMainBussiness() {
		return mainBussiness;
	}

	/**
	 * @param mainBussiness the mainBussiness to set
	 */
	public void setMainBussiness(String mainBussiness) {
		this.mainBussiness = mainBussiness;
	}

	/**
	 * @return the grpAllPeoples
	 */
	public String getGrpAllPeoples() {
		return grpAllPeoples;
	}

	/**
	 * @param grpAllPeoples the grpAllPeoples to set
	 */
	public void setGrpAllPeoples(String grpAllPeoples) {
		this.grpAllPeoples = grpAllPeoples;
	}

	/**
	 * @return the societyStat
	 */
	public String getSocietyStat() {
		return societyStat;
	}

	/**
	 * @param societyStat the societyStat to set
	 */
	public void setSocietyStat(String societyStat) {
		this.societyStat = societyStat;
	}

	/**
	 * @return the societyRegistNo
	 */
	public String getSocietyRegistNo() {
		return societyRegistNo;
	}

	/**
	 * @param societyRegistNo the societyRegistNo to set
	 */
	public void setSocietyRegistNo(String societyRegistNo) {
		this.societyRegistNo = societyRegistNo;
	}

	/**
	 * @return the postalAddress
	 */
	public String getPostalAddress() {
		return postalAddress;
	}

	/**
	 * @param postalAddress the postalAddress to set
	 */
	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the name1
	 */
	public String getName1() {
		return name1;
	}

	/**
	 * @param name1 the name1 to set
	 */
	public void setName1(String name1) {
		this.name1 = name1;
	}

	/**
	 * @return the sex1
	 */
	public String getSex1() {
		return sex1;
	}

	/**
	 * @param sex1 the sex1 to set
	 */
	public void setSex1(String sex1) {
		this.sex1 = sex1;
	}

	/**
	 * @return the telphone1
	 */
	public String getTelphone1() {
		return telphone1;
	}

	/**
	 * @param telphone1 the telphone1 to set
	 */
	public void setTelphone1(String telphone1) {
		this.telphone1 = telphone1;
	}

	/**
	 * @return the phone1
	 */
	public String getPhone1() {
		return phone1;
	}

	/**
	 * @param phone1 the phone1 to set
	 */
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the corporation
	 */
	public String getCorporation() {
		return corporation;
	}

	/**
	 * @param corporation the corporation to set
	 */
	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}

	/**
	 * @return the corporationIDType
	 */
	public String getCorporationIDType() {
		return corporationIDType;
	}

	/**
	 * @param corporationIDType the corporationIDType to set
	 */
	public void setCorporationIDType(String corporationIDType) {
		this.corporationIDType = corporationIDType;
	}

	/**
	 * @return the corporationIDNo
	 */
	public String getCorporationIDNo() {
		return corporationIDNo;
	}

	/**
	 * @param corporationIDNo the corporationIDNo to set
	 */
	public void setCorporationIDNo(String corporationIDNo) {
		this.corporationIDNo = corporationIDNo;
	}

	/**
	 * @return the corporationsDate
	 */
	public Date getCorporationsDate() {
		return corporationsDate;
	}

	/**
	 * @param corporationsDate the corporationsDate to set
	 */
	public void setCorporationsDate(Date corporationsDate) {
		this.corporationsDate = corporationsDate;
	}

	/**
	 * @return the grpPeoples
	 */
	public Long getGrpPeoples() {
		return grpPeoples;
	}

	/**
	 * @param grpPeoples the grpPeoples to set
	 */
	public void setGrpPeoples(Long grpPeoples) {
		this.grpPeoples = grpPeoples;
	}

	/**
	 * @return the mainInsurePersonNumber
	 */
	public Long getMainInsurePersonNumber() {
		return mainInsurePersonNumber;
	}

	/**
	 * @param mainInsurePersonNumber the mainInsurePersonNumber to set
	 */
	public void setMainInsurePersonNumber(Long mainInsurePersonNumber) {
		this.mainInsurePersonNumber = mainInsurePersonNumber;
	}

	/**
	 * @return the relatedInsurePersonNumber
	 */
	public Long getRelatedInsurePersonNumber() {
		return relatedInsurePersonNumber;
	}

	/**
	 * @param relatedInsurePersonNumber the relatedInsurePersonNumber to set
	 */
	public void setRelatedInsurePersonNumber(Long relatedInsurePersonNumber) {
		this.relatedInsurePersonNumber = relatedInsurePersonNumber;
	}

	/**
	 * @return the rate
	 */
	public BigDecimal getRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	/**
	 * @return the premClearingForm
	 */
	public String getPremClearingForm() {
		return premClearingForm;
	}

	/**
	 * @param premClearingForm the premClearingForm to set
	 */
	public void setPremClearingForm(String premClearingForm) {
		this.premClearingForm = premClearingForm;
	}

	/**
	 * @return the unitsBurden
	 */
	public String getUnitsBurden() {
		return unitsBurden;
	}

	/**
	 * @param unitsBurden the unitsBurden to set
	 */
	public void setUnitsBurden(String unitsBurden) {
		this.unitsBurden = unitsBurden;
	}

	/**
	 * @return the specNo
	 */
	public String getSpecNo() {
		return specNo;
	}

	/**
	 * @param specNo the specNo to set
	 */
	public void setSpecNo(String specNo) {
		this.specNo = specNo;
	}

	/**
	 * @return the specNoName
	 */
	public String getSpecNoName() {
		return specNoName;
	}

	/**
	 * @param specNoName the specNoName to set
	 */
	public void setSpecNoName(String specNoName) {
		this.specNoName = specNoName;
	}

	/**
	 * @return the lcRepInfoList
	 */
	public List<LCRepInfo> getLcRepInfoList() {
		return lcRepInfoList;
	}

	/**
	 * @param lcRepInfoList the lcRepInfoList to set
	 */
	public void setLcRepInfoList(List<LCRepInfo> lcRepInfoList) {
		this.lcRepInfoList = lcRepInfoList;
	}

	/**
	 * @return the competitionStatus
	 */
	public String getCompetitionStatus() {
		return competitionStatus;
	}

	/**
	 * @param competitionStatus the competitionStatus to set
	 */
	public void setCompetitionStatus(String competitionStatus) {
		this.competitionStatus = competitionStatus;
	}

	/**
	 * @return the insurStatus
	 */
	public String getInsurStatus() {
		return insurStatus;
	}

	/**
	 * @param insurStatus the insurStatus to set
	 */
	public void setInsurStatus(String insurStatus) {
		this.insurStatus = insurStatus;
	}

	/**
	 * @return the clmHistory
	 */
	public String getClmHistory() {
		return clmHistory;
	}

	/**
	 * @param clmHistory the clmHistory to set
	 */
	public void setClmHistory(String clmHistory) {
		this.clmHistory = clmHistory;
	}

	/**
	 * @return the conStatusAndServ
	 */
	public String getConStatusAndServ() {
		return conStatusAndServ;
	}

	/**
	 * @param conStatusAndServ the conStatusAndServ to set
	 */
	public void setConStatusAndServ(String conStatusAndServ) {
		this.conStatusAndServ = conStatusAndServ;
	}

	/**
	 * @return the customerNoHidden
	 */
	public String getCustomerNoHidden() {
		return customerNoHidden;
	}

	/**
	 * @param customerNoHidden the customerNoHidden to set
	 */
	public void setCustomerNoHidden(String customerNoHidden) {
		this.customerNoHidden = customerNoHidden;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getRiskName() {
		return riskName;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	public BigDecimal getPrem() {
		return prem;
	}

	public void setPrem(BigDecimal prem) {
		this.prem = prem;
	}

	public BigDecimal getAmnt() {
		return amnt;
	}

	public void setAmnt(BigDecimal amnt) {
		this.amnt = amnt;
	}

	public String getProposalGrpContNoHidden() {
		return proposalGrpContNoHidden;
	}

	public void setProposalGrpContNoHidden(String proposalGrpContNoHidden) {
		this.proposalGrpContNoHidden = proposalGrpContNoHidden;
	}

	public String getAddressNo() {
		return AddressNo;
	}

	public void setAddressNo(String addressNo) {
		AddressNo = addressNo;
	}

	public List<LCGrpPolVo> getLcGrpPolList() {
		return lcGrpPolList;
	}

	public void setLcGrpPolList(List<LCGrpPolVo> lcGrpPolList) {
		this.lcGrpPolList = lcGrpPolList;
	}

	

	
	
	
	
	
	


}
