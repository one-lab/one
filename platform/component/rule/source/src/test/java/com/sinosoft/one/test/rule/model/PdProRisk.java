package com.sinosoft.one.test.rule.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * POJO类PdProRisk
 */
@Entity
@Table(name = "GE_PD_PRORISK")
public class PdProRisk implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /** 属性网点编号 */
    private PdProRiskId id;

    /** 属性pdProduct */
    private PdProduct pdProduct;

    /**
     * 类PdProRisk的默认构造方法
     */
    public PdProRisk() {
    }

    /**
     * 属性网点编号的getter方法
     */
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "productCode", column = @Column(name = "PRODUCTCODE")),
            @AttributeOverride(name = "riskCode", column = @Column(name = "RISKCODE")) })
    public PdProRiskId getId() {
        return this.id;
    }

    /**
     * 属性网点编号的setter方法
     */
    public void setId(PdProRiskId id) {
        this.id = id;
    }

    /**
     * 属性pdProduct的getter方法
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCTCODE", nullable = false, insertable = false, updatable = false)
    public PdProduct getPdProduct() {
        return this.pdProduct;
    }

    /**
     * 属性pdProduct的setter方法
     */
    public void setPdProduct(PdProduct pdProduct) {
        this.pdProduct = pdProduct;
    }

}
