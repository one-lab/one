package ins.prpall.proposal.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * POJO类LDGrp
 */
@Entity
@Table(name = "LDGRP")
public class LDGrp implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性客户号码 */
	private String customerNo;

	/** 属性保单口令 */
	private String password;

	/** 属性单位名称 */
	private String grpName;

	/** 属性行业分类 */
	private String businessType;

	/** 属性单位性质 */
	private String grpNature;

	/** 属性人数 */
	private BigDecimal peoples;

	/** 属性注册资本 */
	private BigDecimal rgtMoney;

	/** 属性资产总额 */
	private BigDecimal asset;

	/** 属性净资产收益率 */
	private BigDecimal netProfitRate;

	/** 属性主营业务 */
	private String mainBussiness;

	/** 属性法人 */
	private String corporation;

	/** 属性机构分布区域 */
	private String comAera;

	/** 属性单位传真 */
	private String fax;

	/** 属性单位电话 */
	private String phone;

	/** 属性付款方式 */
	private String getFlag;

	/** 属性负责人 */
	private String satrap;

	/** 属性公司e_mail */
	private String email;

	/** 属性成立日期 */
	private Date foundDate;

	/** 属性银行编码 */
	private String bankCode;

	/** 属性银行帐号 */
	private String bankAccNo;

	/** 属性客户组号码 */
	private String grpGroupNo;

	/** 属性黑名单标记 */
	private String blacklistFlag;

	/** 属性状态 */
	private String state;

	/** 属性备注 */
	private String remark;

	/** 属性VIP值 */
	private String vipValue;

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

	/** 属性子公司标志 */
	private String subCompanyFlag;

	/** 属性上级客户号码 */
	private String supCustoemrNo;

	/** 属性级别代码 */
	private String levelCode;

	/** 属性在职投保人数 */
	private BigDecimal onWorkPeoples;

	/** 属性退休投保人数 */
	private BigDecimal offWorkPeoples;

	/** 属性其它投保人数 */
	private BigDecimal otherPeoples;

	/** 属性行业大类 */
	private String businessBigType;

	/** 属性SocialInsuNo */
	private String socialInsuNo;

	/** 属性税务登记证号 */
	private String taxRegistNo;

	/** 属性组织机构代码 */
	private String organizationNo;

	/** 属性年总收入 */
	private BigDecimal yearGrossIncome;

	/** 属性经营区域 */
	private String operateArea;

	/** 属性单位总人数 */
	private String grpPeoples;
	
	/**
	 * 手动添加呈报基础表
	 * 添加时间：2012-6-20
	 * 添加人：朱超
	 */
	//private LCReport lcReport;
	
	/**
	 * 类LDGrp的默认构造方法
	 */
	public LDGrp() {
	}

	/**
	 * 属性客户号码的getter方法
	 */
	@Id
	@Column(name = "CUSTOMERNO")
	public String getCustomerNo() {
		return this.customerNo;
	}

	/**
	 * 属性客户号码的setter方法
	 */
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	/**
	 * 属性保单口令的getter方法
	 */

	@Column(name = "PASSWORD")
	public String getPassword() {
		return this.password;
	}

	/**
	 * 属性保单口令的setter方法
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 属性单位名称的getter方法
	 */

	@Column(name = "GRPNAME")
	public String getGrpName() {
		return this.grpName;
	}

	/**
	 * 属性单位名称的setter方法
	 */
	public void setGrpName(String grpName) {
		this.grpName = grpName;
	}

	/**
	 * 属性行业分类的getter方法
	 */

	@Column(name = "BUSINESSTYPE")
	public String getBusinessType() {
		return this.businessType;
	}

	/**
	 * 属性行业分类的setter方法
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	/**
	 * 属性单位性质的getter方法
	 */

	@Column(name = "GRPNATURE")
	public String getGrpNature() {
		return this.grpNature;
	}

	/**
	 * 属性单位性质的setter方法
	 */
	public void setGrpNature(String grpNature) {
		this.grpNature = grpNature;
	}

	/**
	 * 属性人数的getter方法
	 */

	@Column(name = "PEOPLES")
	public BigDecimal getPeoples() {
		return this.peoples;
	}

	/**
	 * 属性人数的setter方法
	 */
	public void setPeoples(BigDecimal peoples) {
		this.peoples = peoples;
	}

	/**
	 * 属性注册资本的getter方法
	 */

	@Column(name = "RGTMONEY")
	public BigDecimal getRgtMoney() {
		return this.rgtMoney;
	}

	/**
	 * 属性注册资本的setter方法
	 */
	public void setRgtMoney(BigDecimal rgtMoney) {
		this.rgtMoney = rgtMoney;
	}

	/**
	 * 属性资产总额的getter方法
	 */

	@Column(name = "ASSET")
	public BigDecimal getAsset() {
		return this.asset;
	}

	/**
	 * 属性资产总额的setter方法
	 */
	public void setAsset(BigDecimal asset) {
		this.asset = asset;
	}

	/**
	 * 属性净资产收益率的getter方法
	 */

	@Column(name = "NETPROFITRATE")
	public BigDecimal getNetProfitRate() {
		return this.netProfitRate;
	}

	/**
	 * 属性净资产收益率的setter方法
	 */
	public void setNetProfitRate(BigDecimal netProfitRate) {
		this.netProfitRate = netProfitRate;
	}

	/**
	 * 属性主营业务的getter方法
	 */

	@Column(name = "MAINBUSSINESS")
	public String getMainBussiness() {
		return this.mainBussiness;
	}

	/**
	 * 属性主营业务的setter方法
	 */
	public void setMainBussiness(String mainBussiness) {
		this.mainBussiness = mainBussiness;
	}

	/**
	 * 属性法人的getter方法
	 */

	@Column(name = "CORPORATION")
	public String getCorporation() {
		return this.corporation;
	}

	/**
	 * 属性法人的setter方法
	 */
	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}

	/**
	 * 属性机构分布区域的getter方法
	 */

	@Column(name = "COMAERA")
	public String getComAera() {
		return this.comAera;
	}

	/**
	 * 属性机构分布区域的setter方法
	 */
	public void setComAera(String comAera) {
		this.comAera = comAera;
	}

	/**
	 * 属性单位传真的getter方法
	 */

	@Column(name = "FAX")
	public String getFax() {
		return this.fax;
	}

	/**
	 * 属性单位传真的setter方法
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * 属性单位电话的getter方法
	 */

	@Column(name = "PHONE")
	public String getPhone() {
		return this.phone;
	}

	/**
	 * 属性单位电话的setter方法
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 属性付款方式的getter方法
	 */

	@Column(name = "GETFLAG")
	public String getGetFlag() {
		return this.getFlag;
	}

	/**
	 * 属性付款方式的setter方法
	 */
	public void setGetFlag(String getFlag) {
		this.getFlag = getFlag;
	}

	/**
	 * 属性负责人的getter方法
	 */

	@Column(name = "SATRAP")
	public String getSatrap() {
		return this.satrap;
	}

	/**
	 * 属性负责人的setter方法
	 */
	public void setSatrap(String satrap) {
		this.satrap = satrap;
	}

	/**
	 * 属性公司e_mail的getter方法
	 */

	@Column(name = "EMAIL")
	public String getEmail() {
		return this.email;
	}

	/**
	 * 属性公司e_mail的setter方法
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 属性成立日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "FOUNDDATE")
	public Date getFoundDate() {
		return this.foundDate;
	}

	/**
	 * 属性成立日期的setter方法
	 */
	public void setFoundDate(Date foundDate) {
		this.foundDate = foundDate;
	}

	/**
	 * 属性银行编码的getter方法
	 */

	@Column(name = "BANKCODE")
	public String getBankCode() {
		return this.bankCode;
	}

	/**
	 * 属性银行编码的setter方法
	 */
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	/**
	 * 属性银行帐号的getter方法
	 */

	@Column(name = "BANKACCNO")
	public String getBankAccNo() {
		return this.bankAccNo;
	}

	/**
	 * 属性银行帐号的setter方法
	 */
	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}

	/**
	 * 属性客户组号码的getter方法
	 */

	@Column(name = "GRPGROUPNO")
	public String getGrpGroupNo() {
		return this.grpGroupNo;
	}

	/**
	 * 属性客户组号码的setter方法
	 */
	public void setGrpGroupNo(String grpGroupNo) {
		this.grpGroupNo = grpGroupNo;
	}

	/**
	 * 属性黑名单标记的getter方法
	 */

	@Column(name = "BLACKLISTFLAG")
	public String getBlacklistFlag() {
		return this.blacklistFlag;
	}

	/**
	 * 属性黑名单标记的setter方法
	 */
	public void setBlacklistFlag(String blacklistFlag) {
		this.blacklistFlag = blacklistFlag;
	}

	/**
	 * 属性状态的getter方法
	 */

	@Column(name = "STATE")
	public String getState() {
		return this.state;
	}

	/**
	 * 属性状态的setter方法
	 */
	public void setState(String state) {
		this.state = state;
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
	 * 属性VIP值的getter方法
	 */

	@Column(name = "VIPVALUE")
	public String getVipValue() {
		return this.vipValue;
	}

	/**
	 * 属性VIP值的setter方法
	 */
	public void setVipValue(String vipValue) {
		this.vipValue = vipValue;
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
	 * 属性子公司标志的getter方法
	 */

	@Column(name = "SUBCOMPANYFLAG")
	public String getSubCompanyFlag() {
		return this.subCompanyFlag;
	}

	/**
	 * 属性子公司标志的setter方法
	 */
	public void setSubCompanyFlag(String subCompanyFlag) {
		this.subCompanyFlag = subCompanyFlag;
	}

	/**
	 * 属性上级客户号码的getter方法
	 */

	@Column(name = "SUPCUSTOEMRNO")
	public String getSupCustoemrNo() {
		return this.supCustoemrNo;
	}

	/**
	 * 属性上级客户号码的setter方法
	 */
	public void setSupCustoemrNo(String supCustoemrNo) {
		this.supCustoemrNo = supCustoemrNo;
	}

	/**
	 * 属性级别代码的getter方法
	 */

	@Column(name = "LEVELCODE")
	public String getLevelCode() {
		return this.levelCode;
	}

	/**
	 * 属性级别代码的setter方法
	 */
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	/**
	 * 属性在职投保人数的getter方法
	 */

	@Column(name = "ONWORKPEOPLES")
	public BigDecimal getOnWorkPeoples() {
		return this.onWorkPeoples;
	}

	/**
	 * 属性在职投保人数的setter方法
	 */
	public void setOnWorkPeoples(BigDecimal onWorkPeoples) {
		this.onWorkPeoples = onWorkPeoples;
	}

	/**
	 * 属性退休投保人数的getter方法
	 */

	@Column(name = "OFFWORKPEOPLES")
	public BigDecimal getOffWorkPeoples() {
		return this.offWorkPeoples;
	}

	/**
	 * 属性退休投保人数的setter方法
	 */
	public void setOffWorkPeoples(BigDecimal offWorkPeoples) {
		this.offWorkPeoples = offWorkPeoples;
	}

	/**
	 * 属性其它投保人数的getter方法
	 */

	@Column(name = "OTHERPEOPLES")
	public BigDecimal getOtherPeoples() {
		return this.otherPeoples;
	}

	/**
	 * 属性其它投保人数的setter方法
	 */
	public void setOtherPeoples(BigDecimal otherPeoples) {
		this.otherPeoples = otherPeoples;
	}

	/**
	 * 属性行业大类的getter方法
	 */

	@Column(name = "BUSINESSBIGTYPE")
	public String getBusinessBigType() {
		return this.businessBigType;
	}

	/**
	 * 属性行业大类的setter方法
	 */
	public void setBusinessBigType(String businessBigType) {
		this.businessBigType = businessBigType;
	}

	/**
	 * 属性SocialInsuNo的getter方法
	 */

	@Column(name = "SOCIALINSUNO")
	public String getSocialInsuNo() {
		return this.socialInsuNo;
	}

	/**
	 * 属性SocialInsuNo的setter方法
	 */
	public void setSocialInsuNo(String socialInsuNo) {
		this.socialInsuNo = socialInsuNo;
	}

	/**
	 * 属性税务登记证号的getter方法
	 */

	@Column(name = "TAXREGISTNO")
	public String getTaxRegistNo() {
		return this.taxRegistNo;
	}

	/**
	 * 属性税务登记证号的setter方法
	 */
	public void setTaxRegistNo(String taxRegistNo) {
		this.taxRegistNo = taxRegistNo;
	}

	/**
	 * 属性组织机构代码的getter方法
	 */

	@Column(name = "ORGANIZATIONNO")
	public String getOrganizationNo() {
		return this.organizationNo;
	}

	/**
	 * 属性组织机构代码的setter方法
	 */
	public void setOrganizationNo(String organizationNo) {
		this.organizationNo = organizationNo;
	}

	/**
	 * 属性年总收入的getter方法
	 */

	@Column(name = "YEARGROSSINCOME")
	public BigDecimal getYearGrossIncome() {
		return this.yearGrossIncome;
	}

	/**
	 * 属性年总收入的setter方法
	 */
	public void setYearGrossIncome(BigDecimal yearGrossIncome) {
		this.yearGrossIncome = yearGrossIncome;
	}

	/**
	 * 属性经营区域的getter方法
	 */

	@Column(name = "OPERATEAREA")
	public String getOperateArea() {
		return this.operateArea;
	}

	/**
	 * 属性经营区域的setter方法
	 */
	public void setOperateArea(String operateArea) {
		this.operateArea = operateArea;
	}

	/**
	 * 属性单位总人数的getter方法
	 */

	@Column(name = "GRPPEOPLES")
	public String getGrpPeoples() {
		return this.grpPeoples;
	}

	/**
	 * 属性单位总人数的setter方法
	 */
	public void setGrpPeoples(String grpPeoples) {
		this.grpPeoples = grpPeoples;
	}
	
//	@OneToOne(cascade=CascadeType.ALL)
//	public LCReport getLcReport() {
//		return lcReport;
//	}
//
//	public void setLcReport(LCReport lcReport) {
//		this.lcReport = lcReport;
//	}
}
