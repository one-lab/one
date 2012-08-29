package ins.platform.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * POJO类PrpDcompany
 */
@Entity
@Table(name = "PRPDCOMPANY")
public class PrpDcompany implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性机构代码 */
	private String comCode;

	/** 属性机构中文名称 */
	private String comCName;

	/** 属性机构英文名称 */
	private String comEName;

	/** 属性地址中文名称 */
	private String addressCName;

	/** 属性地址英文名称 */
	private String addressEName;

	/** 属性邮编 */
	private String postCode;

	/** 属性电话 */
	private String phoneNumber;

	/** 属性纳税编码 */
	private String taxNumber;

	/** 属性传真 */
	private String faxNumber;

	/** 属性机构代码 */
	private String upperComCode;

	/** 属性归属保险公司名称 */
	private String insurerName;

	/** 属性属于哪个机构 */
	private String comAttribute;

	/** 属性机构类型 */
	private String comType;

	/** 属性机构级别 */
	private String comlevel;

	/** 属性经理 */
	private String manager;

	/** 属性 */
	private String accountLeader;

	/** 属性出纳员 */
	private String cashier;

	/** 属性会计 */
	private String accountant;

	/** 属性备注 */
	private String remark;

	/** 属性最新机构代码 */
	private String newComCode;

	/** 属性效力状态 */
	private String validStatus;

	/** 属性账户归属机构代码 */
	private String acntUnit;

	/** 属性专项代码(对应会计科目) */
	private String articleCode;

	/** 属性财务专项代码 */
	private String accCode;

	/** 属性核算单位的标志 */
	private String centerFlag;

	/** 属性 */
	private String outerPayCode;

	/** 属性 */
	private String innerPayCode;

	/** 属性标志 */
	private String flag;

	/** 属性 */
	private String webAddress;

	/** 属性服务电话 */
	private String servicePhone;

	/** 属性 */
	private String reportPhone;

	/** 属性 */
	private String sysAreaCode;

	/** 属性 */
	private Date createDate;

	/** 属性 */
	private String attemperFlag;

	/** 属性生效日期 */
	private String validDate;

	/** 属性prpDusersFormakeCom */
	private List<PrpDuser> prpDusersFormakeCom = new ArrayList<PrpDuser>(0);

	/** 属性prpDusersForcomCode */
	private List<PrpDuser> prpDusersForcomCode = new ArrayList<PrpDuser>(0);

	/**
	 * 类PrpDcompany的默认构造方法
	 */
	public PrpDcompany() {
	}

	/**
	 * 属性机构代码的getter方法
	 */
	@Id
	@Column(name = "COMCODE")
	public String getComCode() {
		return this.comCode;
	}

	/**
	 * 属性机构代码的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	/**
	 * 属性机构中文名称的getter方法
	 */

	@Column(name = "COMCNAME")
	public String getComCName() {
		return this.comCName;
	}

	/**
	 * 属性机构中文名称的setter方法
	 */
	public void setComCName(String comCName) {
		this.comCName = comCName;
	}

	/**
	 * 属性机构英文名称的getter方法
	 */

	@Column(name = "COMENAME")
	public String getComEName() {
		return this.comEName;
	}

	/**
	 * 属性机构英文名称的setter方法
	 */
	public void setComEName(String comEName) {
		this.comEName = comEName;
	}

	/**
	 * 属性地址中文名称的getter方法
	 */

	@Column(name = "ADDRESSCNAME")
	public String getAddressCName() {
		return this.addressCName;
	}

	/**
	 * 属性地址中文名称的setter方法
	 */
	public void setAddressCName(String addressCName) {
		this.addressCName = addressCName;
	}

	/**
	 * 属性地址英文名称的getter方法
	 */

	@Column(name = "ADDRESSENAME")
	public String getAddressEName() {
		return this.addressEName;
	}

	/**
	 * 属性地址英文名称的setter方法
	 */
	public void setAddressEName(String addressEName) {
		this.addressEName = addressEName;
	}

	/**
	 * 属性邮编的getter方法
	 */

	@Column(name = "POSTCODE")
	public String getPostCode() {
		return this.postCode;
	}

	/**
	 * 属性邮编的setter方法
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	/**
	 * 属性电话的getter方法
	 */

	@Column(name = "PHONENUMBER")
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	/**
	 * 属性电话的setter方法
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * 属性纳税编码的getter方法
	 */

	@Column(name = "TAXNUMBER")
	public String getTaxNumber() {
		return this.taxNumber;
	}

	/**
	 * 属性纳税编码的setter方法
	 */
	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	/**
	 * 属性传真的getter方法
	 */

	@Column(name = "FAXNUMBER")
	public String getFaxNumber() {
		return this.faxNumber;
	}

	/**
	 * 属性传真的setter方法
	 */
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	/**
	 * 属性机构代码的getter方法
	 */

	@Column(name = "UPPERCOMCODE")
	public String getUpperComCode() {
		return this.upperComCode;
	}

	/**
	 * 属性机构代码的setter方法
	 */
	public void setUpperComCode(String upperComCode) {
		this.upperComCode = upperComCode;
	}

	/**
	 * 属性归属保险公司名称的getter方法
	 */

	@Column(name = "INSURERNAME")
	public String getInsurerName() {
		return this.insurerName;
	}

	/**
	 * 属性归属保险公司名称的setter方法
	 */
	public void setInsurerName(String insurerName) {
		this.insurerName = insurerName;
	}

	/**
	 * 属性属于哪个机构的getter方法
	 */

	@Column(name = "COMATTRIBUTE")
	public String getComAttribute() {
		return this.comAttribute;
	}

	/**
	 * 属性属于哪个机构的setter方法
	 */
	public void setComAttribute(String comAttribute) {
		this.comAttribute = comAttribute;
	}

	/**
	 * 属性机构类型的getter方法
	 */

	@Column(name = "COMTYPE")
	public String getComType() {
		return this.comType;
	}

	/**
	 * 属性机构类型的setter方法
	 */
	public void setComType(String comType) {
		this.comType = comType;
	}

	/**
	 * 属性机构级别的getter方法
	 */

	@Column(name = "COMLEVEL")
	public String getComlevel() {
		return this.comlevel;
	}

	/**
	 * 属性机构级别的setter方法
	 */
	public void setComlevel(String comlevel) {
		this.comlevel = comlevel;
	}

	/**
	 * 属性经理的getter方法
	 */

	@Column(name = "MANAGER")
	public String getManager() {
		return this.manager;
	}

	/**
	 * 属性经理的setter方法
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}

	/**
	 * 属性的getter方法
	 */

	@Column(name = "ACCOUNTLEADER")
	public String getAccountLeader() {
		return this.accountLeader;
	}

	/**
	 * 属性的setter方法
	 */
	public void setAccountLeader(String accountLeader) {
		this.accountLeader = accountLeader;
	}

	/**
	 * 属性出纳员的getter方法
	 */

	@Column(name = "CASHIER")
	public String getCashier() {
		return this.cashier;
	}

	/**
	 * 属性出纳员的setter方法
	 */
	public void setCashier(String cashier) {
		this.cashier = cashier;
	}

	/**
	 * 属性会计的getter方法
	 */

	@Column(name = "ACCOUNTANT")
	public String getAccountant() {
		return this.accountant;
	}

	/**
	 * 属性会计的setter方法
	 */
	public void setAccountant(String accountant) {
		this.accountant = accountant;
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
	 * 属性最新机构代码的getter方法
	 */

	@Column(name = "NEWCOMCODE")
	public String getNewComCode() {
		return this.newComCode;
	}

	/**
	 * 属性最新机构代码的setter方法
	 */
	public void setNewComCode(String newComCode) {
		this.newComCode = newComCode;
	}

	/**
	 * 属性效力状态的getter方法
	 */

	@Column(name = "VALIDSTATUS")
	public String getValidStatus() {
		return this.validStatus;
	}

	/**
	 * 属性效力状态的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}

	/**
	 * 属性账户归属机构代码的getter方法
	 */

	@Column(name = "ACNTUNIT")
	public String getAcntUnit() {
		return this.acntUnit;
	}

	/**
	 * 属性账户归属机构代码的setter方法
	 */
	public void setAcntUnit(String acntUnit) {
		this.acntUnit = acntUnit;
	}

	/**
	 * 属性专项代码(对应会计科目)的getter方法
	 */

	@Column(name = "ARTICLECODE")
	public String getArticleCode() {
		return this.articleCode;
	}

	/**
	 * 属性专项代码(对应会计科目)的setter方法
	 */
	public void setArticleCode(String articleCode) {
		this.articleCode = articleCode;
	}

	/**
	 * 属性财务专项代码的getter方法
	 */

	@Column(name = "ACCCODE")
	public String getAccCode() {
		return this.accCode;
	}

	/**
	 * 属性财务专项代码的setter方法
	 */
	public void setAccCode(String accCode) {
		this.accCode = accCode;
	}

	/**
	 * 属性核算单位的标志的getter方法
	 */

	@Column(name = "CENTERFLAG")
	public String getCenterFlag() {
		return this.centerFlag;
	}

	/**
	 * 属性核算单位的标志的setter方法
	 */
	public void setCenterFlag(String centerFlag) {
		this.centerFlag = centerFlag;
	}

	/**
	 * 属性的getter方法
	 */

	@Column(name = "OUTERPAYCODE")
	public String getOuterPayCode() {
		return this.outerPayCode;
	}

	/**
	 * 属性的setter方法
	 */
	public void setOuterPayCode(String outerPayCode) {
		this.outerPayCode = outerPayCode;
	}

	/**
	 * 属性的getter方法
	 */

	@Column(name = "INNERPAYCODE")
	public String getInnerPayCode() {
		return this.innerPayCode;
	}

	/**
	 * 属性的setter方法
	 */
	public void setInnerPayCode(String innerPayCode) {
		this.innerPayCode = innerPayCode;
	}

	/**
	 * 属性标志的getter方法
	 */

	@Column(name = "FLAG")
	public String getFlag() {
		return this.flag;
	}

	/**
	 * 属性标志的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * 属性的getter方法
	 */

	@Column(name = "WEBADDRESS")
	public String getWebAddress() {
		return this.webAddress;
	}

	/**
	 * 属性的setter方法
	 */
	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}

	/**
	 * 属性服务电话的getter方法
	 */

	@Column(name = "SERVICEPHONE")
	public String getServicePhone() {
		return this.servicePhone;
	}

	/**
	 * 属性服务电话的setter方法
	 */
	public void setServicePhone(String servicePhone) {
		this.servicePhone = servicePhone;
	}

	/**
	 * 属性的getter方法
	 */

	@Column(name = "REPORTPHONE")
	public String getReportPhone() {
		return this.reportPhone;
	}

	/**
	 * 属性的setter方法
	 */
	public void setReportPhone(String reportPhone) {
		this.reportPhone = reportPhone;
	}

	/**
	 * 属性的getter方法
	 */

	@Column(name = "SYSAREACODE")
	public String getSysAreaCode() {
		return this.sysAreaCode;
	}

	/**
	 * 属性的setter方法
	 */
	public void setSysAreaCode(String sysAreaCode) {
		this.sysAreaCode = sysAreaCode;
	}

	/**
	 * 属性的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATEDATE")
	public Date getCreateDate() {
		return this.createDate;
	}

	/**
	 * 属性的setter方法
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 属性的getter方法
	 */

	@Column(name = "ATTEMPERFLAG")
	public String getAttemperFlag() {
		return this.attemperFlag;
	}

	/**
	 * 属性的setter方法
	 */
	public void setAttemperFlag(String attemperFlag) {
		this.attemperFlag = attemperFlag;
	}

	/**
	 * 属性生效日期的getter方法
	 */

	@Column(name = "VALIDDATE")
	public String getValidDate() {
		return this.validDate;
	}

	/**
	 * 属性生效日期的setter方法
	 */
	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	/**
	 * 属性prpDusersFormakeCom的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "prpDcompanyBymakeCom")
	public List<PrpDuser> getPrpDusersFormakeCom() {
		return this.prpDusersFormakeCom;
	}

	/**
	 * 属性prpDusersFormakeCom的setter方法
	 */
	public void setPrpDusersFormakeCom(List<PrpDuser> prpDusersFormakeCom) {
		this.prpDusersFormakeCom = prpDusersFormakeCom;
	}

	/**
	 * 属性prpDusersForcomCode的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "prpDcompanyBycomCode")
	public List<PrpDuser> getPrpDusersForcomCode() {
		return this.prpDusersForcomCode;
	}

	/**
	 * 属性prpDusersForcomCode的setter方法
	 */
	public void setPrpDusersForcomCode(List<PrpDuser> prpDusersForcomCode) {
		this.prpDusersForcomCode = prpDusersForcomCode;
	}

}
