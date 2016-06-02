package com.sinosoft.one.test.rule.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * POJO类PdProRate
 */
@Entity
@Table(name = "GE_PD_PRORATE")
public class PdProRate implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /** 属性序列号(SerialNo) */
    private String serialNo;

    /** 属性pdProduct */
    private PdProduct pdProduct;

    /** 属性险别代码(KindCode) */
    private String kindCode;

    /** 属性标的代码(ItemCode) */
    private String itemCode;

    /** 属性费率类型(RateType) */
    private String rateType;

    /** 属性费率因子类型(FactorType) */
    private String factorType;
    
    /** 属性险种版本号(version) */
    private String version;

    /** 属性费率因子代码(FactorCode) */
    private String factorCode;

    /** 属性数值(Rate) */
    private BigDecimal rate;

    /** 属性是否有效(IsValidate) */
    private String isValidate;

    /** 属性标志位(Flag) */
    private String flag;

    /**
     * 类PdProRate的默认构造方法
     */
    public PdProRate() {
    }

    /**
     * 属性序列号(SerialNo)的getter方法
     */
    @Id
    @GeneratedValue(generator="system-uuid")  
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
     * 属性费率类型(RateType)的getter方法
     */

    @Column(name = "RATETYPE")
    public String getRateType() {
        return this.rateType;
    }

    /**
     * 属性费率类型(RateType)的setter方法
     */
    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    /**
     * 属性费率因子类型(FactorType)的getter方法
     */

    @Column(name = "FACTORTYPE")
    public String getFactorType() {
        return this.factorType;
    }

    /**
     * 属性费率因子类型(FactorType)的setter方法
     */
    public void setFactorType(String factorType) {
        this.factorType = factorType;
    }
    
    /**
     * 属性费率因子代码(FactorCode)的getter方法
     */
    
    @Column(name = "FACTORCODE")
    public String getFactorCode() {
        return this.factorCode;
    }
    
    /**
     * 属性费率因子代码(FactorCode)的setter方法
     */
    public void setFactorCode(String factorCode) {
        this.factorCode = factorCode;
    }

    /**
     * 属性险种版本号(version)的getter方法
     */

    @Column(name = "VERSION")
    public String getVersion() {
        return this.version;
    }

    /**
     * 属性险种版本号(version)的setter方法
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 属性数值(Rate)的getter方法
     */

    @Column(name = "RATE")
    public BigDecimal getRate() {
        return this.rate;
    }

    /**
     * 属性数值(Rate)的setter方法
     */
    public void setRate(BigDecimal rate) {
        this.rate = rate;
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
