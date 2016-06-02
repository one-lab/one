package com.sinosoft.test;

// default package
// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.math.BigDecimal;
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
 * POJO类SaSettleAccount
 */
@Entity
@Table(name = "SASETTLEACCOUNT")
public class SaSettleAccount implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /** 属性结算单号 */
    private String settleNo;

    /** 属性创建日期 */
    private Date createDate;

    /** 属性手续费金额 */
    private BigDecimal commission;

    /** 属性中介代码 */
    private String agentCode;

    /** 属性中介名称 */
    private String agentName;

    /** 属性实收保费 */
    private BigDecimal refPayFee;

    /** 属性个人所得税 */
    private BigDecimal inComeFax;

    /** 属性营业税 */
    private BigDecimal businessFax;

    /** 属性开户人名称 */
    private String bank;

    /** 属性开户行名称 */
    private String bankName;

    /** 属性银行账户 */
    private String accountNo;

    /** 属性结算单状态 */
    private String status;

    /** 属性教育附加税 */
    private BigDecimal eduTax;

    /** 属性城建税 */
    private BigDecimal urbanTax;

    /** 属性手续费支付日期 */
    private Date payDate;

    /** 属性凭证号 */
    private String voucherNo;

    /** 属性会计区间 */
    private String yearMonth;

    /** 属性中介类型 */
    private String agentType;

    /** 属性结算单类型 */
    private String settleType;

    /** 属性结算单打回原因 */
    private String returnReason;

    /** 属性归属机构 */
    private String comCode;

    /** 属性农业类型(涉农、非农) */
    private String businessType1;

    /** 属性开户行地址省 */
    private String bankOfProvince;

    /** 属性开户行地址市 */
    private String bankOfCity;

    /** 属性开户帐号对公对私 */
    private String bankType;

    /** 属性结算单生成月 */
    private String settleYearMonth;

    /** 属性结算单生成月序号 */
    private BigDecimal settleSerialNo;

    /** 属性水利建设基金 */
    private BigDecimal waterTax;

    /** 属性地方教育附加税 */
    private BigDecimal locEduTax;

    /** 属性银行行号 */
    private String cnap;

    /** 属性结算单回写日期 */
    private Date returnDate;

    /** 属性accCommissionPaies */
    private List<AccCommissionPay> accCommissionPaies = new ArrayList<AccCommissionPay>(
            0);

    /**
     * 类SaSettleAccount的默认构造方法
     */
    public SaSettleAccount() {
    }

    /**
     * 属性结算单号的getter方法
     */
    @Id
    @Column(name = "SETTLENO")
    public String getSettleNo() {
        return this.settleNo;
    }

    /**
     * 属性结算单号的setter方法
     */
    public void setSettleNo(String settleNo) {
        this.settleNo = settleNo;
    }

    /**
     * 属性创建日期的getter方法
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATEDATE")
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * 属性创建日期的setter方法
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 属性手续费金额的getter方法
     */

    @Column(name = "COMMISSION")
    public BigDecimal getCommission() {
        return this.commission;
    }

    /**
     * 属性手续费金额的setter方法
     */
    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    /**
     * 属性中介代码的getter方法
     */

    @Column(name = "AGENTCODE")
    public String getAgentCode() {
        return this.agentCode;
    }

    /**
     * 属性中介代码的setter方法
     */
    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    /**
     * 属性中介名称的getter方法
     */

    @Column(name = "AGENTNAME")
    public String getAgentName() {
        return this.agentName;
    }

    /**
     * 属性中介名称的setter方法
     */
    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    /**
     * 属性实收保费的getter方法
     */

    @Column(name = "REFPAYFEE")
    public BigDecimal getRefPayFee() {
        return this.refPayFee;
    }

    /**
     * 属性实收保费的setter方法
     */
    public void setRefPayFee(BigDecimal refPayFee) {
        this.refPayFee = refPayFee;
    }

    /**
     * 属性个人所得税的getter方法
     */

    @Column(name = "INCOMEFAX")
    public BigDecimal getInComeFax() {
        return this.inComeFax;
    }

    /**
     * 属性个人所得税的setter方法
     */
    public void setInComeFax(BigDecimal inComeFax) {
        this.inComeFax = inComeFax;
    }

    /**
     * 属性营业税的getter方法
     */

    @Column(name = "BUSINESSFAX")
    public BigDecimal getBusinessFax() {
        return this.businessFax;
    }

    /**
     * 属性营业税的setter方法
     */
    public void setBusinessFax(BigDecimal businessFax) {
        this.businessFax = businessFax;
    }

    /**
     * 属性开户人名称的getter方法
     */

    @Column(name = "BANK")
    public String getBank() {
        return this.bank;
    }

    /**
     * 属性开户人名称的setter方法
     */
    public void setBank(String bank) {
        this.bank = bank;
    }

    /**
     * 属性开户行名称的getter方法
     */

    @Column(name = "BANKNAME")
    public String getBankName() {
        return this.bankName;
    }

    /**
     * 属性开户行名称的setter方法
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * 属性银行账户的getter方法
     */

    @Column(name = "ACCOUNTNO")
    public String getAccountNo() {
        return this.accountNo;
    }

    /**
     * 属性银行账户的setter方法
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * 属性结算单状态的getter方法
     */

    @Column(name = "STATUS")
    public String getStatus() {
        return this.status;
    }

    /**
     * 属性结算单状态的setter方法
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 属性教育附加税的getter方法
     */

    @Column(name = "EDUTAX")
    public BigDecimal getEduTax() {
        return this.eduTax;
    }

    /**
     * 属性教育附加税的setter方法
     */
    public void setEduTax(BigDecimal eduTax) {
        this.eduTax = eduTax;
    }

    /**
     * 属性城建税的getter方法
     */

    @Column(name = "URBANTAX")
    public BigDecimal getUrbanTax() {
        return this.urbanTax;
    }

    /**
     * 属性城建税的setter方法
     */
    public void setUrbanTax(BigDecimal urbanTax) {
        this.urbanTax = urbanTax;
    }

    /**
     * 属性手续费支付日期的getter方法
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "PAYDATE")
    public Date getPayDate() {
        return this.payDate;
    }

    /**
     * 属性手续费支付日期的setter方法
     */
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    /**
     * 属性凭证号的getter方法
     */

    @Column(name = "VOUCHERNO")
    public String getVoucherNo() {
        return this.voucherNo;
    }

    /**
     * 属性凭证号的setter方法
     */
    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    /**
     * 属性会计区间的getter方法
     */

    @Column(name = "YEARMONTH")
    public String getYearMonth() {
        return this.yearMonth;
    }

    /**
     * 属性会计区间的setter方法
     */
    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    /**
     * 属性中介类型的getter方法
     */

    @Column(name = "AGENTTYPE")
    public String getAgentType() {
        return this.agentType;
    }

    /**
     * 属性中介类型的setter方法
     */
    public void setAgentType(String agentType) {
        this.agentType = agentType;
    }

    /**
     * 属性结算单类型的getter方法
     */

    @Column(name = "SETTLETYPE")
    public String getSettleType() {
        return this.settleType;
    }

    /**
     * 属性结算单类型的setter方法
     */
    public void setSettleType(String settleType) {
        this.settleType = settleType;
    }

    /**
     * 属性结算单打回原因的getter方法
     */

    @Column(name = "RETURNREASON")
    public String getReturnReason() {
        return this.returnReason;
    }

    /**
     * 属性结算单打回原因的setter方法
     */
    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason;
    }

    /**
     * 属性归属机构的getter方法
     */

    @Column(name = "COMCODE")
    public String getComCode() {
        return this.comCode;
    }

    /**
     * 属性归属机构的setter方法
     */
    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    /**
     * 属性农业类型(涉农、非农)的getter方法
     */

    @Column(name = "BUSINESSTYPE1")
    public String getBusinessType1() {
        return this.businessType1;
    }

    /**
     * 属性农业类型(涉农、非农)的setter方法
     */
    public void setBusinessType1(String businessType1) {
        this.businessType1 = businessType1;
    }

    /**
     * 属性开户行地址省的getter方法
     */

    @Column(name = "BANKOFPROVINCE")
    public String getBankOfProvince() {
        return this.bankOfProvince;
    }

    /**
     * 属性开户行地址省的setter方法
     */
    public void setBankOfProvince(String bankOfProvince) {
        this.bankOfProvince = bankOfProvince;
    }

    /**
     * 属性开户行地址市的getter方法
     */

    @Column(name = "BANKOFCITY")
    public String getBankOfCity() {
        return this.bankOfCity;
    }

    /**
     * 属性开户行地址市的setter方法
     */
    public void setBankOfCity(String bankOfCity) {
        this.bankOfCity = bankOfCity;
    }

    /**
     * 属性开户帐号对公对私的getter方法
     */

    @Column(name = "BANKTYPE")
    public String getBankType() {
        return this.bankType;
    }

    /**
     * 属性开户帐号对公对私的setter方法
     */
    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    /**
     * 属性结算单生成月的getter方法
     */

    @Column(name = "SETTLEYEARMONTH")
    public String getSettleYearMonth() {
        return this.settleYearMonth;
    }

    /**
     * 属性结算单生成月的setter方法
     */
    public void setSettleYearMonth(String settleYearMonth) {
        this.settleYearMonth = settleYearMonth;
    }

    /**
     * 属性结算单生成月序号的getter方法
     */

    @Column(name = "SETTLESERIALNO")
    public BigDecimal getSettleSerialNo() {
        return this.settleSerialNo ;
    }

    /**
     * 属性结算单生成月序号的setter方法
     */
    public void setSettleSerialNo(BigDecimal settleSerialNo) {
        this.settleSerialNo = settleSerialNo;
    }

    /**
     * 属性水利建设基金的getter方法
     */

    @Column(name = "WATERTAX")
    public BigDecimal getWaterTax() {
        return this.waterTax;
    }

    /**
     * 属性水利建设基金的setter方法
     */
    public void setWaterTax(BigDecimal waterTax) {
        this.waterTax = waterTax;
    }

    /**
     * 属性地方教育附加税的getter方法
     */

    @Column(name = "LOCEDUTAX")
    public BigDecimal getLocEduTax() {
        return this.locEduTax;
    }

    /**
     * 属性地方教育附加税的setter方法
     */
    public void setLocEduTax(BigDecimal locEduTax) {
        this.locEduTax = locEduTax;
    }

    /**
     * 属性银行行号的getter方法
     */

    @Column(name = "CNAP")
    public String getCnap() {
        return this.cnap;
    }

    /**
     * 属性银行行号的setter方法
     */
    public void setCnap(String cnap) {
        this.cnap = cnap;
    }

    /**
     * 属性结算单回写日期的getter方法
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "RETURNDATE")
    public Date getReturnDate() {
        return this.returnDate;
    }

    /**
     * 属性结算单回写日期的setter方法
     */
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * 属性accCommissionPaies的getter方法
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "saSettleAccount")
    public List<AccCommissionPay> getAccCommissionPaies() {
        return this.accCommissionPaies;
    }

    /**
     * 属性accCommissionPaies的setter方法
     */
    public void setAccCommissionPaies(List<AccCommissionPay> accCommissionPaies) {
        this.accCommissionPaies = accCommissionPaies;
    }

}