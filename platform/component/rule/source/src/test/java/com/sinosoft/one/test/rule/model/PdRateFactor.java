package com.sinosoft.one.test.rule.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * POJO类PdRateFactor
 */
@Entity
@Table(name = "GE_PD_RATEFACTOR")
public class PdRateFactor implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /** 属性序列号(SerialNo) */
    private String serialNo;

    /** 属性pdProduct */
    private PdProduct pdProduct;

    /** 属性关联序列号(ItemSerNoList) */
    private String itemSerNoList;

    /** 属性费率因子类型(FactorType) */
    private String factorType;

    /** 属性费率因子代码(FactorCode) */
    private String factorCode;

    /** 属性因子数值(FactorValue) */
    private BigDecimal factorValue;

    /** 属性上架日期(StartDate) */
    private Date startDate;

    /** 属性下架日期(EndDate) */
    private Date endDate;

    /** 属性是否有效(IsValidate) */
    private String isValidate;

    /**
     * 类PdRateFactor的默认构造方法
     */
    public PdRateFactor() {
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
     * 属性pdProduct的getter方法
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCTCODE")
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
     * 属性因子数值(FactorValue)的getter方法
     */

    @Column(name = "FACTORVALUE")
    public BigDecimal getFactorValue() {
        return this.factorValue;
    }

    /**
     * 属性因子数值(FactorValue)的setter方法
     */
    public void setFactorValue(BigDecimal factorValue) {
        this.factorValue = factorValue;
    }

    /**
     * 属性上架日期(StartDate)的getter方法
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "STARTDATE")
    public Date getStartDate() {
        return this.startDate;
    }

    /**
     * 属性上架日期(StartDate)的setter方法
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 属性下架日期(EndDate)的getter方法
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "ENDDATE")
    public Date getEndDate() {
        return this.endDate;
    }

    /**
     * 属性下架日期(EndDate)的setter方法
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
     * 属性关联序列号(ItemSerNoList)的getter方法
     */

    @Column(name = "ITEMSERNOLIST")
    public String getItemSerNoList() {
        return this.itemSerNoList;
    }

    /**
     * 属性关联序列号(ItemSerNoList)的setter方法
     */
    public void setItemSerNoList(String itemSerNoList) {
        this.itemSerNoList = itemSerNoList;
    }

}
