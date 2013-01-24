package com.sinosoft.one.test.rule.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.util.Assert;

import com.sinosoft.one.test.rule.service.facade.Combo;
import com.sinosoft.one.test.rule.service.facade.ComboPack;



/**
 * POJO类PdCombo
 */
@Entity
@Table(name = "GE_PD_COMBO")
public class PdCombo implements java.io.Serializable,Combo {
    private static final long serialVersionUID = 1L;

    /** 属性套餐代码 */
    private String comboCode;

    /** 属性pdProduct */
    private PdProduct pdProduct;

    /** 属性套餐名称(Name) */
    private String name;

    /** 属性类型(Type) */
    private String type;

    /** 属性套餐描述(Des) */
    private String des;

    /** 属性创建者代码 */
    private String createCode;

    /** 属性创建时间(CreateDate) */
    private Date createDate;

    /** 属性修改者代码 */
    private String updateCode;

    /** 属性修改时间 */
    private Date updateTime;

    /** 属性银联返回状态(Status) */
    private String status;

    /** 属性标志位(Flag) */
    private String flag;
    

    /** 属性pdComboPacks */
    private List<PdComboPack> pdComboPacks = new ArrayList<PdComboPack>(0);
    
	/** 属性pdComboAreas */
	private List<PdComboArea> pdComboAreas = new ArrayList<PdComboArea>(0);

    /**
     * 类PdCombo的默认构造方法
     */
    public PdCombo() {
    }

    /**
     * 属性套餐代码的getter方法
     */
    @Id
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
     * 属性套餐名称(Name)的getter方法
     */

    @Column(name = "NAME")
    public String getName() {
        return this.name;
    }

    /**
     * 属性套餐名称(Name)的setter方法
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 属性类型(Type)的getter方法
     */

    @Column(name = "TYPE")
    public String getType() {
        return this.type;
    }

    /**
     * 属性类型(Type)的setter方法
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 属性套餐描述(Des)的getter方法
     */
    @Column(name = "Des")
    public String getDes() {
        return this.des;
    }

    /**
     * 属性套餐描述(Des)的setter方法
     */
    public void setDes(String des) {
        this.des = des;
    }

    /**
     * 属性创建者代码的getter方法
     */

    @Column(name = "CREATECODE")
    public String getCreateCode() {
        return this.createCode;
    }

    /**
     * 属性创建者代码的setter方法
     */
    public void setCreateCode(String createCode) {
        this.createCode = createCode;
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
     * 属性修改者代码的getter方法
     */

    @Column(name = "UPDATECODE")
    public String getUpdateCode() {
        return this.updateCode;
    }

    /**
     * 属性修改者代码的setter方法
     */
    public void setUpdateCode(String updateCode) {
        this.updateCode = updateCode;
    }

    /**
     * 属性修改时间的getter方法
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "UPDATETIME")
    public Date getUpdateTime() {
        return this.updateTime;
    }

    /**
     * 属性修改时间的setter方法
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 属性银联返回状态(Status)的getter方法
     */

    @Column(name = "STATUS")
    public String getStatus() {
        return this.status;
    }

    /**
     * 属性银联返回状态(Status)的setter方法
     */
    public void setStatus(String status) {
        this.status = status;
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
     * 属性pdComboPacks的getter方法
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pdCombo")
    public List<PdComboPack> getPdComboPacks() {
        return this.pdComboPacks;
    }

    /**
     * 属性pdComboPacks的setter方法
     */
    public void setPdComboPacks(List<PdComboPack> pdComboPacks) {
        this.pdComboPacks = pdComboPacks;
    }
    
    /**
	 * 属性pdComboAreas的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pdCombo")
	public List<PdComboArea> getPdComboAreas() {
		return this.pdComboAreas;
	}

	/**
	 * 属性pdComboAreas的setter方法
	 */
	public void setPdComboAreas(List<PdComboArea> pdComboAreas) {
		this.pdComboAreas = pdComboAreas;
	}
    
	//---------------------以下非自动生成部分------------- //
	
	
	private String showName;
	

	private HashMap<String,PdComboPack> kindCodeComboPack = new HashMap<String,PdComboPack>();
	
	
	public void addKindCodePack(String kindCode,PdComboPack comboPack){
		Assert.hasText(kindCode);
		Assert.notNull(comboPack);
		kindCodeComboPack.put(kindCode, comboPack);
	}
	
	
	@Transient
	public void setShowName(String showName){
		this.showName = showName;
	}
	
	@Transient
	/**
	 * 获取展示名称
	 */
	public String getShowName(){
		return this.showName;
	}
    
    /**
	 * 是否允许投保
	 * @return true/false
	 */
	@Transient
	public boolean isAllowProposal(){
		for(Iterator<PdComboPack> iter = getPdComboPacks().iterator();iter.hasNext();){
			boolean flag = iter.next().isAllowProposal();
			if(!flag){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 根据险别代码获取套餐包装
	 * @param kindCode
	 * @return
	 */
	@Transient
	public PdComboPack getPackByKindCode(String kindCode){
		Assert.hasText(kindCode);
		return kindCodeComboPack.get(kindCode);
	}

	@Transient
	public List<ComboPack> getComboPacks() {
		List<ComboPack> l = new ArrayList<ComboPack>();
		for(PdComboPack pdComboPack : this.pdComboPacks) {
			l.add(pdComboPack);
		}
		return l;
	}

	@Transient
	public ComboFlag.Type getComboType() {
		if(type.equals(ComboFlag.Type.POP.toString())){
			return ComboFlag.Type.POP;
		}
		else
			return ComboFlag.Type.CUSTOM;
	}

}
