package ins.prpall.proposal.vo;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerInfoVo {
	
	/** 属性VIP值 */
	private String vipValue;
	
	/** 属性投保单位名称 */
	private String grpName;

	/** 属性组织机构代码 */
	private String organizationNo;

	/** 属性年总收入 */
	private BigDecimal yearGrossIncome;

	/** 属性经营区域 */
	private String operateArea;

	/** 属性资产总额 */
	private BigDecimal asset;

	/** 属性单位性质 */
	private String grpNature;

	/** 属性主营业务 */
	private String mainBussiness;

	/** 属性行业分类 */
	private String businessType;

	/** 属性税务登记证号 */
	private String taxRegistNo;

	/** 属性成立日期 */
	private Date foundDate;

	/** 属性人数 */
	private BigDecimal peoples;

	

	/** 属性已参加过社会统筹 */
	private String societyStat;

	/** 属性联系人 */
	private String name1;

	/** 属性手机 */
	private String phone1;

	/** 属性联系人电话 */
	private String telphone1;

	/** 属性通讯地址 */
	private String postalAddress;

	/** 联系电话 */
	private String phone;
	
    /** 属性社保登记证号 */
	private String societyRegistNo;

	/** 属性联系部门 */
	private String department;

	/** 属性联系人性别 */
	private String sex1;

	/** 属性E-mail */
	private String email;
	
	/** 属性联系邮编 */
	private String zipCode;
	
	/** 属性法人 */
	private String corporation;
	
	/** 属性投保单位人数 */
	private Long grpPeoples;
	
	/** 属性法人有效日期 */
	private Date corporationsDate;
	
	/** 属性费率 */
	private BigDecimal rate;
	
	/** 属性法人证件类型 */
	private String corporationIDType;
	
	/** 属性主被保险人数 */
	private Long mainInsurePersonNumber;
	
	/** 属性法人证件号 */
	private String corporationIDNo;

	
	/** 属性连带被保险人数 */
	private Long relatedInsurePersonNumber;
	

	
	/** 构造函数 */
	public CustomerInfoVo() {

	}

	
	public CustomerInfoVo(String vipValue, String grpName,
			String organizationNo, BigDecimal yearGrossIncome,
			String operateArea, BigDecimal asset, String grpNature,
			String mainBussiness, String businessType, String taxRegistNo,
			Date foundDate, BigDecimal peoples, String societyStat,
			String name1, String phone1, String telphone1,
			String postalAddress, String phone, String societyRegistNo,
			String department, String sex1, String email, String zipCode,
			String corporation, Long grpPeoples, Date corporationsDate,
			BigDecimal rate, String corporationIDType,
			Long mainInsurePersonNumber, String corporationIDNo,
			Long relatedInsurePersonNumber) {
		super();
		this.vipValue = vipValue;
		this.grpName = grpName;
		this.organizationNo = organizationNo;
		this.yearGrossIncome = yearGrossIncome;
		this.operateArea = operateArea;
		this.asset = asset;
		this.grpNature = grpNature;
		this.mainBussiness = mainBussiness;
		this.businessType = businessType;
		this.taxRegistNo = taxRegistNo;
		this.foundDate = foundDate;
		this.peoples = peoples;
		this.societyStat = societyStat;
		this.name1 = name1;
		this.phone1 = phone1;
		this.telphone1 = telphone1;
		this.postalAddress = postalAddress;
		this.phone = phone;
		this.societyRegistNo = societyRegistNo;
		this.department = department;
		this.sex1 = sex1;
		this.email = email;
		this.zipCode = zipCode;
		this.corporation = corporation;
		this.grpPeoples = grpPeoples;
		this.corporationsDate = corporationsDate;
		this.rate = rate;
		this.corporationIDType = corporationIDType;
		this.mainInsurePersonNumber = mainInsurePersonNumber;
		this.corporationIDNo = corporationIDNo;
		this.relatedInsurePersonNumber = relatedInsurePersonNumber;
	}


	public String getVipValue() {
		return vipValue;
	}

	public void setVipValue(String vipValue) {
		this.vipValue = vipValue;
	}
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getGrpName() {
		return grpName;
	}

	public void setGrpName(String grpName) {
		this.grpName = grpName;
	}

	public String getOrganizationNo() {
		return organizationNo;
	}

	public void setOrganizationNo(String organizationNo) {
		this.organizationNo = organizationNo;
	}

	public BigDecimal getYearGrossIncome() {
		return yearGrossIncome;
	}

	public void setYearGrossIncome(BigDecimal yearGrossIncome) {
		this.yearGrossIncome = yearGrossIncome;
	}

	public String getOperateArea() {
		return operateArea;
	}

	public void setOperateArea(String operateArea) {
		this.operateArea = operateArea;
	}

	public BigDecimal getAsset() {
		return asset;
	}

	public void setAsset(BigDecimal asset) {
		this.asset = asset;
	}

	public String getGrpNature() {
		return grpNature;
	}

	public void setGrpNature(String grpNature) {
		this.grpNature = grpNature;
	}

	public String getMainBussiness() {
		return mainBussiness;
	}

	public void setMainBussiness(String mainBussiness) {
		this.mainBussiness = mainBussiness;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getTaxRegistNo() {
		return taxRegistNo;
	}

	public void setTaxRegistNo(String taxRegistNo) {
		this.taxRegistNo = taxRegistNo;
	}

	public Date getFoundDate() {
		return foundDate;
	}

	public void setFoundDate(Date foundDate) {
		this.foundDate = foundDate;
	}

	public BigDecimal getPeoples() {
		return peoples;
	}

	public void setPeoples(BigDecimal peoples) {
		this.peoples = peoples;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getSocietyStat() {
		return societyStat;
	}

	public void setSocietyStat(String societyStat) {
		this.societyStat = societyStat;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getTelphone1() {
		return telphone1;
	}

	public void setTelphone1(String telphone1) {
		this.telphone1 = telphone1;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getSocietyRegistNo() {
		return societyRegistNo;
	}

	public void setSocietyRegistNo(String societyRegistNo) {
		this.societyRegistNo = societyRegistNo;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSex1() {
		return sex1;
	}

	public void setSex1(String sex1) {
		this.sex1 = sex1;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getCorporation() {
		return corporation;
	}

	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}

	public Long getGrpPeoples() {
		return grpPeoples;
	}

	public void setGrpPeoples(Long grpPeoples) {
		this.grpPeoples = grpPeoples;
	}

	public Date getCorporationsDate() {
		return corporationsDate;
	}

	public void setCorporationsDate(Date corporationsDate) {
		this.corporationsDate = corporationsDate;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getCorporationIDType() {
		return corporationIDType;
	}

	public void setCorporationIDType(String corporationIDType) {
		this.corporationIDType = corporationIDType;
	}

	public Long getMainInsurePersonNumber() {
		return mainInsurePersonNumber;
	}

	public void setMainInsurePersonNumber(Long mainInsurePersonNumber) {
		this.mainInsurePersonNumber = mainInsurePersonNumber;
	}

	public String getCorporationIDNo() {
		return corporationIDNo;
	}

	public void setCorporationIDNo(String corporationIDNo) {
		this.corporationIDNo = corporationIDNo;
	}

	public Long getRelatedInsurePersonNumber() {
		return relatedInsurePersonNumber;
	}

	public void setRelatedInsurePersonNumber(Long relatedInsurePersonNumber) {
		this.relatedInsurePersonNumber = relatedInsurePersonNumber;
	}

	
}
