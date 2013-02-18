package com.sinosoft.one.test.rule.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * POJO类PdFeeCalculate
 */
@Entity
@Table(name = "GE_PD_FEECALCULATE")
public class PdFeeCalculate implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /** 属性序列号(SerialNo) */
    private String serialNo;

    /** 属性版本号(Version) */
    private String version;

    /** 属性pdProduct */
    private PdProduct pdProduct;

    /** 属性险种代码(RiskCode) */
    private String riskCode;

    /** 属性险别代码(KindCode) */
    private String kindCode;

    /** 属性标的代码(ItemCode) */
    private String itemCode;

    /** 属性计算公式(Formula) */
    private String formula;

    /** 属性是否计入险别总保费(sumPremiumFlag) */
    private String sumPremiumFlag;

    /** 属性是否有效(IsValidate) */
    private String isValidate;

    /** 属性标志位(Flag) */
    private String flag;

    /**
     * 类PdFeeCalculate的默认构造方法
     */
    public PdFeeCalculate() {
    }

    /**
     * 属性序列号(SerialNo)的getter方法
     */
    @Id
    @GeneratedValue(generator="system-uuid")  
    @GenericGenerator(name="system-uuid", strategy = "uuid.hex")
    @Column(name = "SERIALNO")
    public String getSerialNo() {
        return this.serialNo;
    }

    /**
     * 属性序列号(SerialNo)的setter方法
     */
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * 属性版本号(Version)的getter方法
     */
    @Column(name = "VERSION")
    public String getVersion() {
        return this.version;
    }

    /**
     * 属性版本号(Version)的setter方法
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 属性pdProduct的getter方法
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCTCODE", nullable = false)
    public PdProduct getPdProduct() {
        return this.pdProduct;
    }

    /**
     * 属性pdProduct的setter方法
     */
    public void setPdProduct(PdProduct pdProduct) {
        this.pdProduct = pdProduct;
    }

    /**
     * 属性险种代码(RiskCode)的getter方法
     */

    @Column(name = "RISKCODE")
    public String getRiskCode() {
        return this.riskCode;
    }

    /**
     * 属性险种代码(RiskCode)的setter方法
     */
    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    /**
     * 属性险别代码(KindCode)的getter方法
     */

    @Column(name = "KINDCODE")
    public String getKindCode() {
        return this.kindCode;
    }

    /**
     * 属性险别代码(KindCode)的setter方法
     */
    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }

    /**
     * 属性标的代码(ItemCode)的getter方法
     */

    @Column(name = "ITEMCODE")
    public String getItemCode() {
        return this.itemCode;
    }

    /**
     * 属性标的代码(ItemCode)的setter方法
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * 属性计算公式(Formula)的getter方法
     */

    @Column(name = "FORMULA")
    public String getFormula() {
        return this.formula;
    }

    /**
     * 属性计算公式(Formula)的setter方法
     */
    public void setFormula(String formula) {
        this.formula = formula;
    }

    /**
     * 属性是否计入险别总保费(sumPremiumFlag)的getter方法
     */

    @Column(name = "SUMPREMIUMFLAG")
    public String getSumPremiumFlag() {
        return this.sumPremiumFlag;
    }

    /**
     * 属性是否计入险别总保费(sumPremiumFlag)的setter方法
     */
    public void setSumPremiumFlag(String sumPremiumFlag) {
        this.sumPremiumFlag = sumPremiumFlag;
    }

    /**
     * 属性是否有效(IsValidate)的getter方法
     */

    @Column(name = "ISVALIDATE")
    public String getIsValidate() {
        return this.isValidate;
    }

    /**
     * 属性是否有效(IsValidate)的setter方法
     */
    public void setIsValidate(String isValidate) {
        this.isValidate = isValidate;
    }

    /**
     * 属性标志位(Flag)的getter方法
     */

    @Column(name = "FLAG")
    public String getFlag() {
        return this.flag;
    }

    /**
     * 属性标志位(Flag)的setter方法
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

}
