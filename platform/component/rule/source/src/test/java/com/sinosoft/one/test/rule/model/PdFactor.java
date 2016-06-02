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


/**
 * POJO类PdFactor
 */
@Entity
@Table(name = "GE_PD_FACTOR")
public class PdFactor implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /** 属性序列号(SerialNo) */
    private String serialNo;

    /** 属性pdProduct */
    private PdProduct pdProduct;

    /** 属性关联序列号(ItemSerNoList) */
    private String itemSerNoList;

    /** 属性费率因子类型(FactorType) */
    private String factorType;

    /** 属性needfactortype */
    private String needFactorType;

    /**
     * 类PdFactor的默认构造方法
     */
    public PdFactor() {
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
     * 属性needfactortype的getter方法
     */

    @Column(name = "NEEDFACTORTYPE")
    public String getNeedFactorType() {
        return this.needFactorType;
    }

    /**
     * 属性needfactortype的setter方法
     */
    public void setNeedFactorType(String needFactorType) {
        this.needFactorType = needFactorType;
    }

}
