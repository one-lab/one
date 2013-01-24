package com.sinosoft.one.test.rule.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import com.sinosoft.one.test.rule.service.facade.ComboPack;



/**
 * POJO类PdComboPack
 */
@Entity
@Table(name = "GE_PD_COMBOPACK")
public class PdComboPack implements java.io.Serializable,Comparable<PdComboPack>,ComboPack{
    private static final long serialVersionUID = 1L;

    /** 属性网点编号 */
    private PdComboPackId id;

    /** 属性pdCombo */
    private PdCombo pdCombo;

    /** 属性险种代码(RiskCode) */
    private String riskCode;

    /** 属性关联序列号(ItemSerNoList) */
    private String itemSerNoList;

    /** 属性交通工具(Traffic) */
    private String traffic;
    
    /** 属性方案号(SchemeNo) */
    private String scheme;

    /** 属性描述(Des) */
    private String des;

    /** 属性代码类型(CodeType) */
    private String codeType;

    /** 属性取值范围(ValueRange) */
    private String valueRange;

    /** 属性单位保额(UnitAmount) */
    private BigDecimal unitAmount;

    /** 属性默认取值(DefaultValue) */
    private String defaultValue;

    /** 属性显示序号(OrderNo) */
    private Integer orderNo;

    /** 属性勾选标志(CheckFlag) */
    private String checkFlag;

    /** 属性套餐默认勾选标志(DefaultCheckFlag) */
    private String defaultCheckFlag;

    /** 属性不计免赔标志(NoDeductFlag) */
    private String noDeductFlag;

    /** 属性标志位(Flag) */
    private String flag;

    /**
     * 类PdComboPack的默认构造方法
     */
    public PdComboPack() {
    }

    /**
     * 属性网点编号的getter方法
     */
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "packageNo", column = @Column(name = "PACKAGENO")),
            @AttributeOverride(name = "comboCode", column = @Column(name = "COMBOCODE")) })
    public PdComboPackId getId() {
        return this.id;
    }

    /**
     * 属性网点编号的setter方法
     */
    public void setId(PdComboPackId id) {
        this.id = id;
    }

    /**
     * 属性pdCombo的getter方法
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMBOCODE", nullable = false, insertable = false, updatable = false)
    public PdCombo getPdCombo() {
        return this.pdCombo;
    }

    /**
     * 属性pdCombo的setter方法
     */
    public void setPdCombo(PdCombo pdCombo) {
        this.pdCombo = pdCombo;
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
     * 属性方案号(SchemeNo)的getter方法
     */

    @Column(name = "SCHEME")
    public String getScheme() {
        return this.scheme;
    }

    /**
     * 属性方案号(SchemeNo)的setter方法
     */
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    /**
     * 属性描述(Des)的getter方法
     */

    @Column(name = "DES")
    public String getDes() {
        return this.des;
    }

    /**
     * 属性描述(Des)的setter方法
     */
    public void setDes(String des) {
        this.des = des;
    }

    /**
     * 属性代码类型(CodeType)的getter方法
     */

    @Column(name = "CODETYPE")
    public String getCodeType() {
        return this.codeType;
    }

    /**
     * 属性代码类型(CodeType)的setter方法
     */
    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    /**
     * 属性取值范围(ValueRange)的getter方法
     */

    @Column(name = "VALUERANGE")
    public String getValueRange() {
        return this.valueRange;
    }

    /**
     * 属性取值范围(ValueRange)的setter方法
     */
    public void setValueRange(String valueRange) {
        this.valueRange = valueRange;
    }

    /**
     * 属性单位保额(UnitAmount)的getter方法
     */

    @Column(name = "UNITAMOUNT")
    public BigDecimal getUnitAmount() {
        return this.unitAmount;
    }

    /**
     * 属性单位保额(UnitAmount)的setter方法
     */
    public void setUnitAmount(BigDecimal unitAmount) {
        this.unitAmount = unitAmount;
    }

    /**
     * 属性默认取值(DefaultValue)的getter方法
     */

    @Column(name = "DEFAULTVALUE")
    public String getDefaultValue() {
        return this.defaultValue;
    }

    /**
     * 属性默认取值(DefaultValue)的setter方法
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * 属性显示序号(OrderNo)的getter方法
     */

    @Column(name = "ORDERNO")
    public Integer getOrderNo() {
        return this.orderNo;
    }

    /**
     * 属性显示序号(OrderNo)的setter方法
     */
    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 属性交通工具(Traffic)的getter方法
     */

    @Column(name = "TRAFFIC")
    public String getTraffic() {
        return this.traffic;
    }

    /**
     * 属性交通工具(Traffic)的setter方法
     */
    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }
    
    /**
     * 属性勾选标志(CheckFlag)的getter方法
     */

    @Column(name = "CHECKFLAG")
    public String getCheckFlag() {
        return this.checkFlag;
    }

    /**
     * 属性勾选标志(CheckFlag)的setter方法
     */
    public void setCheckFlag(String checkFlag) {
        this.checkFlag = checkFlag;
    }

    /**
     * 属性套餐默认勾选标志(DefaultCheckFlag)的getter方法
     */

    @Column(name = "DEFAULTCHECKFLAG")
    public String getDefaultCheckFlag() {
        return this.defaultCheckFlag;
    }

    /**
     * 属性套餐默认勾选标志(DefaultCheckFlag)的setter方法
     */
    public void setDefaultCheckFlag(String defaultCheckFlag) {
        this.defaultCheckFlag = defaultCheckFlag;
    }

    /**
     * 属性不计免赔标志(NoDeductFlag)的getter方法
     */

    @Column(name = "NODEDUCTFLAG")
    public String getNoDeductFlag() {
        return this.noDeductFlag;
    }

    /**
     * 属性不计免赔标志(NoDeductFlag)的setter方法
     */
    public void setNoDeductFlag(String noDeductFlag) {
        this.noDeductFlag = noDeductFlag;
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
    
    
    //---------------------以下非自动生成部分-------------//

    @Transient
	private boolean allowProposal;

	/**
	 * 是否允许投保
	 * @return true/false
	 */
	@Transient
	public boolean isAllowProposal() {
		return allowProposal;
	}

	@Transient
	public void setAllowProposal(boolean allowProposal) {
		this.allowProposal = allowProposal;
	}

	public int compareTo(PdComboPack o) {
		if(this.getOrderNo()<o.getOrderNo()){
			return -1;
		}else if(this.getOrderNo()==o.getOrderNo()){
			return 0;
		}else{
			return 1;
		}
	}

	@Transient
	public String getPackageNo() {
		return id.getPackageNo();
	}
	
	private List<String> checkCondtions = new ArrayList<String>(0);

	@Transient
	public List<String> getCheckCondition() {
		return checkCondtions;
	}
	
	public void addCheckCondition(String relateKindCode){
		checkCondtions.add(relateKindCode);
	}
	
	@Transient
	public List<String> getItemsId() {
		return Arrays.asList(StringUtils.split(this.itemSerNoList, ","));
	}

}
