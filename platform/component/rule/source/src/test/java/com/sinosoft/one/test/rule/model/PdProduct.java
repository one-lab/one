package com.sinosoft.one.test.rule.model;

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
 * POJO类PdProduct
 */
@Entity
@Table(name = "GE_PD_PRODUCT")
public class PdProduct implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /** 属性产品代码(ProductCode) */
    private String productCode;

    /** 属性版本号(Version) */
    private String version;

    /** 属性产品名称(ProductName) */
    private String productName;

    /** 属性创建人员(CreateUser) */
    private String createUser;

    /** 属性创建时间(CreateDate) */
    private Date createDate;

    /** 属性操作人员(OperateUser) */
    private String operateUser;

    /** 属性操作时间(OperateDate) */
    private Date operateDate;

    /** 属性上架日期(StartDate) */
    private Date startDate;

    /** 属性下架日期(EndDate) */
    private Date endDate;

    /** 属性热销指数(Hot) */
    private BigDecimal hot;

    /** 属性状态(State) */
    private String state;

    /** 属性是否有效(IsValidate) */
    private String isValidate;

    /** 属性标志位(Flag) */
    private String flag;

    /** 属性pdRateFactors */
    private List<PdRateFactor> pdRateFactors = new ArrayList<PdRateFactor>(0);

    /** 属性pdProRates */
    private List<PdProRate> pdProRates = new ArrayList<PdProRate>(0);

    /** 属性pdFactors */
    private List<PdFactor> pdFactors = new ArrayList<PdFactor>(0);

    /** 属性pdProRisks */
    private List<PdProRisk> pdProRisks = new ArrayList<PdProRisk>(0);

    /** 属性pdFeeCalculates */
    private List<PdFeeCalculate> pdFeeCalculates = new ArrayList<PdFeeCalculate>(
            0);

    /** 属性pdCombos */
    private List<PdCombo> pdCombos = new ArrayList<PdCombo>(0);

    /**
     * 类PdProduct的默认构造方法
     */
    public PdProduct() {
    }

    /**
     * 属性产品代码(ProductCode)的getter方法
     */
    @Id
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
     * 属性产品名称(ProductName)的getter方法
     */

    @Column(name = "PRODUCTNAME")
    public String getProductName() {
        return this.productName;
    }

    /**
     * 属性产品名称(ProductName)的setter方法
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 属性创建人员(CreateUser)的getter方法
     */

    @Column(name = "CREATEUSER")
    public String getCreateUser() {
        return this.createUser;
    }

    /**
     * 属性创建人员(CreateUser)的setter方法
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 属性创建时间(CreateDate)的getter方法
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATEDATE")
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * 属性创建时间(CreateDate)的setter方法
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 属性操作人员(OperateUser)的getter方法
     */

    @Column(name = "OPERATEUSER")
    public String getOperateUser() {
        return this.operateUser;
    }

    /**
     * 属性操作人员(OperateUser)的setter方法
     */
    public void setOperateUser(String operateUser) {
        this.operateUser = operateUser;
    }

    /**
     * 属性操作时间(OperateDate)的getter方法
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "OPERATEDATE")
    public Date getOperateDate() {
        return this.operateDate;
    }

    /**
     * 属性操作时间(OperateDate)的setter方法
     */
    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
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
     * 属性热销指数(Hot)的getter方法
     */

    @Column(name = "HOT")
    public BigDecimal getHot() {
        return this.hot;
    }

    /**
     * 属性热销指数(Hot)的setter方法
     */
    public void setHot(BigDecimal hot) {
        this.hot = hot;
    }

    /**
     * 属性状态(State)的getter方法
     */

    @Column(name = "STATE")
    public String getState() {
        return this.state;
    }

    /**
     * 属性状态(State)的setter方法
     */
    public void setState(String state) {
        this.state = state;
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

    /**
     * 属性pdRateFactors的getter方法
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pdProduct")
    public List<PdRateFactor> getPdRateFactors() {
        return this.pdRateFactors;
    }

    /**
     * 属性pdRateFactors的setter方法
     */
    public void setPdRateFactors(List<PdRateFactor> pdRateFactors) {
        this.pdRateFactors = pdRateFactors;
    }

    /**
     * 属性pdProRates的getter方法
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pdProduct")
    public List<PdProRate> getPdProRates() {
        return this.pdProRates;
    }

    /**
     * 属性pdProRates的setter方法
     */
    public void setPdProRates(List<PdProRate> pdProRates) {
        this.pdProRates = pdProRates;
    }

    /**
     * 属性pdFactors的getter方法
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pdProduct")
    public List<PdFactor> getPdFactors() {
        return this.pdFactors;
    }

    /**
     * 属性pdFactors的setter方法
     */
    public void setPdFactors(List<PdFactor> pdFactors) {
        this.pdFactors = pdFactors;
    }

    /**
     * 属性pdProRisks的getter方法
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pdProduct")
    public List<PdProRisk> getPdProRisks() {
        return this.pdProRisks;
    }

    /**
     * 属性pdProRisks的setter方法
     */
    public void setPdProRisks(List<PdProRisk> pdProRisks) {
        this.pdProRisks = pdProRisks;
    }

    /**
     * 属性pdFeeCalculates的getter方法
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pdProduct")
    public List<PdFeeCalculate> getPdFeeCalculates() {
        return this.pdFeeCalculates;
    }

    /**
     * 属性pdFeeCalculates的setter方法
     */
    public void setPdFeeCalculates(List<PdFeeCalculate> pdFeeCalculates) {
        this.pdFeeCalculates = pdFeeCalculates;
    }

    /**
     * 属性pdCombos的getter方法
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pdProduct")
    public List<PdCombo> getPdCombos() {
        return this.pdCombos;
    }

    /**
     * 属性pdCombos的setter方法
     */
    public void setPdCombos(List<PdCombo> pdCombos) {
        this.pdCombos = pdCombos;
    }

}
