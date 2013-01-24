package com.sinosoft.one.test.rule.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类PdComboPackId
 */
@Embeddable
public class PdComboPackId implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /** 属性打包号(PackageNo) */
    private String packageNo;

    /** 属性套餐代码 */
    private String comboCode;

    /**
     * 类PdComboPackId的默认构造方法
     */
    public PdComboPackId() {
    }

    /**
     * 属性打包号(PackageNo)的getter方法
     */

    @Column(name = "PACKAGENO")
    public String getPackageNo() {
        return this.packageNo;
    }

    /**
     * 属性打包号(PackageNo)的setter方法
     */
    public void setPackageNo(String packageNo) {
        this.packageNo = packageNo;
    }

    /**
     * 属性套餐代码的getter方法
     */

    @Column(name = "COMBOCODE")
    public String getComboCode() {
        return this.comboCode;
    }

    /**
     * 属性套餐代码的setter方法
     */
    public void setComboCode(String comboCode) {
        this.comboCode = comboCode;
    }

    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof PdComboPackId)) {
            return false;
        }
        PdComboPackId castOther = (PdComboPackId) other;

        return ((this.getPackageNo() == castOther.getPackageNo()) || (this
                .getPackageNo() != null && castOther.getPackageNo() != null && this
                .getPackageNo().equals(castOther.getPackageNo())))
                && ((this.getComboCode() == castOther.getComboCode()) || (this
                        .getComboCode() != null
                        && castOther.getComboCode() != null && this
                        .getComboCode().equals(castOther.getComboCode())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result
                + (getPackageNo() == null ? 0 : this.getPackageNo().hashCode());
        result = 37 * result
                + (getComboCode() == null ? 0 : this.getComboCode().hashCode());
        return result;
    }

}
