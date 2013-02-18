package com.sinosoft.one.test.rule.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * POJO类PdComboArea
 */
@Entity
@Table(name = "GE_PD_COMBOAREA")
public class PdComboArea implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性序号 */
	private String serialNo;

	/** 属性pdCombo */
	private PdCombo pdCombo;

	/** 属性所在地区代码 */
	private String areaCode;

	/** 属性showname */
	private String showName;

	/** 属性ordernumber */
	private Integer ordernumber;

	/** 属性renewalflag */
	private String renewalflag;

	/** 属性hot */
	private BigDecimal hot;

	/** 属性createcode */
	private String createcode;

	/** 属性createname */
	private String createname;

	/** 属性创建时间 */
	private Date createTime;

	/** 属性最后修改人 */
	private String updateCode;

	/** 属性updatename */
	private String updatename;

	/** 属性最后修改时间 */
	private Date updateTime;

	/** 属性标志 */
	private String flag;

	/**
	 * 类PdComboArea的默认构造方法
	 */
	public PdComboArea() {
	}

	/**
	 * 属性序号的getter方法
	 */
	@Id
	@Column(name = "SERIALNO")
    @GeneratedValue(generator = "hibernate-uuid.hex")
    @GenericGenerator(name = "hibernate-uuid.hex", strategy = "uuid.hex")
	public String getSerialNo() {
		return this.serialNo;
	}

	/**
	 * 属性序号的setter方法
	 */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	/**
	 * 属性pdCombo的getter方法
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMBOCODE", nullable = false)
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
	 * 属性所在地区代码的getter方法
	 */

	@Column(name = "AREACODE")
	public String getAreaCode() {
		return this.areaCode;
	}

	/**
	 * 属性所在地区代码的setter方法
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * 属性showname的getter方法
	 */

	@Column(name = "SHOWNAME")
	public String getShowName() {
		return this.showName;
	}

	/**
	 * 属性showname的setter方法
	 */
	public void setShowName(String showName) {
		this.showName = showName;
	}

	/**
	 * 属性ordernumber的getter方法
	 */

	@Column(name = "ORDERNUMBER")
	public Integer getOrdernumber() {
		return this.ordernumber;
	}

	/**
	 * 属性ordernumber的setter方法
	 */
	public void setOrdernumber(Integer ordernumber) {
		this.ordernumber = ordernumber;
	}

	/**
	 * 属性renewalflag的getter方法
	 */

	@Column(name = "RENEWALFLAG")
	public String getRenewalflag() {
		return this.renewalflag;
	}

	/**
	 * 属性renewalflag的setter方法
	 */
	public void setRenewalflag(String renewalflag) {
		this.renewalflag = renewalflag;
	}

	/**
	 * 属性hot的getter方法
	 */

	@Column(name = "HOT")
	public BigDecimal getHot() {
		return this.hot;
	}

	/**
	 * 属性hot的setter方法
	 */
	public void setHot(BigDecimal hot) {
		this.hot = hot;
	}

	/**
	 * 属性createcode的getter方法
	 */

	@Column(name = "CREATECODE")
	public String getCreatecode() {
		return this.createcode;
	}

	/**
	 * 属性createcode的setter方法
	 */
	public void setCreatecode(String createcode) {
		this.createcode = createcode;
	}

	/**
	 * 属性createname的getter方法
	 */

	@Column(name = "CREATENAME")
	public String getCreatename() {
		return this.createname;
	}

	/**
	 * 属性createname的setter方法
	 */
	public void setCreatename(String createname) {
		this.createname = createname;
	}

	/**
	 * 属性创建时间的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATETIME")
	public Date getCreateTime() {
		return this.createTime;
	}

	/**
	 * 属性创建时间的setter方法
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 属性最后修改人的getter方法
	 */

	@Column(name = "UPDATECODE")
	public String getUpdateCode() {
		return this.updateCode;
	}

	/**
	 * 属性最后修改人的setter方法
	 */
	public void setUpdateCode(String updateCode) {
		this.updateCode = updateCode;
	}

	/**
	 * 属性updatename的getter方法
	 */

	@Column(name = "UPDATENAME")
	public String getUpdatename() {
		return this.updatename;
	}

	/**
	 * 属性updatename的setter方法
	 */
	public void setUpdatename(String updatename) {
		this.updatename = updatename;
	}

	/**
	 * 属性最后修改时间的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATETIME")
	public Date getUpdateTime() {
		return this.updateTime;
	}

	/**
	 * 属性最后修改时间的setter方法
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 属性标志的getter方法
	 */

	@Column(name = "FLAG")
	public String getFlag() {
		return this.flag;
	}

	/**
	 * 属性标志的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

}
