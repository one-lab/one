package com.sinosoft.one.test.rule.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类PdProRiskId
 */
@Embeddable
public class PdProRiskId implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /** 属性产品代码(ProductCode) */
    private String productCode;

    /** 属性险种代码(RiskCode) */
    private String riskCode;

    /**
     * 类PdProRiskId的默认构造方法
     */
    public PdProRiskId() {
    }

    /**
     * 属性产品代码(ProductCode)的getter方法
     */

    @Column(name = "PRODUCTCODE")
    public String getProductCode() {
        return this.productCode;
    }

    /**
     * 属性产品代码(ProductCode)的setter方法
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof PdProRiskId)) {
            return false;
        }
        PdProRiskId castOther = (PdProRiskId) other;

        return ((this.getProductCode() == castOther.getProductCode()) || (this
                .getProductCode() != null && castOther.getProductCode() != null && this
                .getProductCode().equals(castOther.getProductCode())))
                && ((this.getRiskCode() == castOther.getRiskCode()) || (this
                        .getRiskCode() != null
                        && castOther.getRiskCode() != null && this
                        .getRiskCode().equals(castOther.getRiskCode())));
    }

    public int hashCode() {
        int result = 17;

        result = 37
                * result
                + (getProductCode() == null ? 0 : this.getProductCode()
                        .hashCode());
        result = 37 * result
                + (getRiskCode() == null ? 0 : this.getRiskCode().hashCode());
        return result;
    }

}
