package com.sinosoft.test;

// default package
// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * POJO类AccCommissionPay
 */
@Entity
@Table(name = "ACCCOMMISSIONPAY")
public class AccCommissionPay implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /** 属性SERIALNO */
    private Long serialNo;

    /** 属性结算单主表 */
    private SaSettleAccount saSettleAccount;

    /** 属性RISKCODE */
    private String riskCode;

    /** 属性业务类型 */
    private String certiType;

    /** 属性业务号 */
    private String certiNo;

    /** 属性POLICYNO */
    private String policyNo;

    /** 属性核算单位 */
    private String branchCode;

    /** 属性核算单位 */
    private String centerCode;

    /** 属性手续费金额 */
    private BigDecimal sumMoney;

    /** 属性手续费比例 */
    private BigDecimal commissionRate;

    /** 属性中介代码 */
    private String agentCode;

    /** 属性中介名称 */
    private String agentName;

    /** 属性保费实收日期 */
    private Date policyDate;

    /** 属性业务员 */
    private String handlerCode1;

    /** 属性业务员 */
    private String handlerName1;

    /** 属性收据号 */
    private String receiptNo;

    /** 属性银行账户 */
    private String accountNo;

    /** 属性开户人名称 */
    private String bankCode;

    /** 属性开户行名称 */
    private String bankName;

    /** 属性激活卡发放号 */
    private String jfaFangHao;

    /** 属性激活卡号 */
    private String jkaHao;

    /** 属性结算单状态 */
    private String endFlag;

    /** 属性业务次数 */
    private String recenfence1;

    /** 属性会计区间 */
    private String yearMonth;

    /** 属性凭证号 */
    private String voucherNo;

    /** 属性备用自动 */
    private String recenfence4;

    /** 属性归属机构 */
    private String comCode;

    /** 实收金额*/
    private BigDecimal payRefFee;

    /**
     * 类AccCommissionPay的默认构造方法
     */
    public AccCommissionPay() {
    }
    @Transient
    public BigDecimal getPayRefFee() {
        return payRefFee;
    }

    public void setPayRefFee(BigDecimal payRefFee) {
        this.payRefFee = payRefFee;
    }

    /**
     * 属性SERIALNO的getter方法
     */
    @Id
    @Column(name = "SERIALNO")
  //  @GeneratedValue(strategy=GenerationType.SEQUENCE)
    public Long getSerialNo() {
        return this.serialNo;
    }

    /**
     * 属性SERIALNO的setter方法
     */
    public void setSerialNo(Long serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * 属性结算单主表的getter方法
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUFFIXNO2", nullable = false)
    public SaSettleAccount getSaSettleAccount() {
        return this.saSettleAccount;
    }

    /**
     * 属性结算单主表的setter方法
     */
    public void setSaSettleAccount(SaSettleAccount saSettleAccount) {
        this.saSettleAccount = saSettleAccount;
    }

    /**
     * 属性RISKCODE的getter方法
     */

    @Column(name = "RISKCODE")
    public String getRiskCode() {
        return this.riskCode;
    }

    /**
     * 属性RISKCODE的setter方法
     */
    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    /**
     * 属性业务类型的getter方法
     */

    @Column(name = "CERTITYPE")
    public String getCertiType() {
        return this.certiType;
    }

    /**
     * 属性业务类型的setter方法
     */
    public void setCertiType(String certiType) {
        this.certiType = certiType;
    }

    /**
     * 属性业务号的getter方法
     */

    @Column(name = "CERTINO")
    public String getCertiNo() {
        return this.certiNo;
    }

    /**
     * 属性业务号的setter方法
     */
    public void setCertiNo(String certiNo) {
        this.certiNo = certiNo;
    }

    /**
     * 属性POLICYNO的getter方法
     */

    @Column(name = "POLICYNO")
    public String getPolicyNo() {
        return this.policyNo;
    }

    /**
     * 属性POLICYNO的setter方法
     */
    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    /**
     * 属性核算单位的getter方法
     */

    @Column(name = "BRANCHCODE")
    public String getBranchCode() {
        return this.branchCode;
    }

    /**
     * 属性核算单位的setter方法
     */
    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    /**
     * 属性核算单位的getter方法
     */

    @Column(name = "CENTERCODE")
    public String getCenterCode() {
        return this.centerCode;
    }

    /**
     * 属性核算单位的setter方法
     */
    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    /**
     * 属性手续费金额的getter方法
     */

    @Column(name = "SUMMONEY")
    public BigDecimal getSumMoney() {
        return this.sumMoney;
    }

    /**
     * 属性手续费金额的setter方法
     */
    public void setSumMoney(BigDecimal sumMoney) {
        this.sumMoney = sumMoney;
    }

    /**
     * 属性手续费比例的getter方法
     */

    @Column(name = "COMMISSIONRATE")
    public BigDecimal getCommissionRate() {
        return this.commissionRate;
    }

    /**
     * 属性手续费比例的setter方法
     */
    public void setCommissionRate(BigDecimal commissionRate) {
        this.commissionRate = commissionRate;
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
     * 属性保费实收日期的getter方法
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "POLICYDATE")
    public Date getPolicyDate() {
        return this.policyDate;
    }

    /**
     * 属性保费实收日期的setter方法
     */
    public void setPolicyDate(Date policyDate) {
        this.policyDate = policyDate;
    }

    /**
     * 属性业务员的getter方法
     */

    @Column(name = "HANDLERCODE1")
    public String getHandlerCode1() {
        return this.handlerCode1;
    }

    /**
     * 属性业务员的setter方法
     */
    public void setHandlerCode1(String handlerCode1) {
        this.handlerCode1 = handlerCode1;
    }

    /**
     * 属性收据号的getter方法
     */

    @Column(name = "RECEIPTNO")
    public String getReceiptNo() {
        return this.receiptNo;
    }

    /**
     * 属性收据号的setter方法
     */
    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
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
     * 属性开户人名称的getter方法
     */

    @Column(name = "BANKCODE")
    public String getBankCode() {
        return this.bankCode;
    }

    /**
     * 属性开户人名称的setter方法
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
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
     * 属性激活卡发放号的getter方法
     */

    @Column(name = "JFAFANGHAO")
    public String getJfaFangHao() {
        return this.jfaFangHao;
    }

    /**
     * 属性激活卡发放号的setter方法
     */
    public void setJfaFangHao(String jfaFangHao) {
        this.jfaFangHao = jfaFangHao;
    }

    /**
     * 属性激活卡号的getter方法
     */

    @Column(name = "JKAHAO")
    public String getJkaHao() {
        return this.jkaHao;
    }

    /**
     * 属性激活卡号的setter方法
     */
    public void setJkaHao(String jkaHao) {
        this.jkaHao = jkaHao;
    }

    /**
     * 属性结算单状态的getter方法
     */

    @Column(name = "ENDFLAG")
    public String getEndFlag() {
        return this.endFlag;
    }

    /**
     * 属性结算单状态的setter方法
     */
    public void setEndFlag(String endFlag) {
        this.endFlag = endFlag;
    }

    /**
     * 属性业务次数的getter方法
     */

    @Column(name = "RECENFENCE1")
    public String getRecenfence1() {
        return this.recenfence1;
    }

    /**
     * 属性业务次数的setter方法
     */
    public void setRecenfence1(String recenfence1) {
        this.recenfence1 = recenfence1;
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
     * 属性备用自动的getter方法
     */

    @Column(name = "RECENFENCE4")
    public String getRecenfence4() {
        return this.recenfence4;
    }

    /**
     * 属性备用自动的setter方法
     */
    public void setRecenfence4(String recenfence4) {
        this.recenfence4 = recenfence4;
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
    @Transient
    public String getHandlerName1() {
        return handlerName1;
    }

    public void setHandlerName1(String handlerName1) {
        this.handlerName1 = handlerName1;
    }

}