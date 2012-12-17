package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * POJO类PDBaseField
 */
@Entity
@Table(name = "PD_BASEFIELD")
public class PDBaseField implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性序号 */
	private PDBaseFieldId id;

	/** 属性产品定义基础表 */
	private PDBaseTable PDBaseTable;

	/** 属性字段名称 */
	private String fieldName;

	/** 属性字段类型 */
	private String fieldType;

	/** 属性官方描述 */
	private String officialDesc;

	/** 属性业务描述 */
	private String busiDesc;

	/** 属性是否显示 */
	private String isDisplay;

	/** 属性显示顺序 */
	private BigDecimal displayOrder;

	/** 属性是否主键 */
	private String isPrimary;

	/** 属性下拉标识码 */
	private String selectCode;

	/** 属性操作员 */
	private String operator;

	/** 属性入机日期 */
	private Date makeDate;

	/** 属性入机时间 */
	private String makeTime;

	/** 属性最后一次修改日期 */
	private Date modifyDate;

	/** 属性最后一次修改时间 */
	private String modifyTime;

	/** 属性Standbyflag1 */
	private String standbyflag1;

	/** 属性Standbyflag2 */
	private String standbyflag2;

	/** 属性Standbyflag3 */
	private BigDecimal standbyflag3;

	/** 属性Standbyflag4 */
	private BigDecimal standbyflag4;

	/** 属性Standbyflag5 */
	private BigDecimal standbyflag5;

	/** 属性Standbyflag6 */
	private BigDecimal standbyflag6;

	/** 属性PDTestPointClewLibs */
	private List<PDTestPointClewLib> PDTestPointClewLibs = new ArrayList<PDTestPointClewLib>(
			0);

	/**
	 * 类PDBaseField的默认构造方法
	 */
	public PDBaseField() {
	}

	/**
	 * 属性序号的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "tableCode", column = @Column(name = "TABLECODE")),
			@AttributeOverride(name = "fieldCode", column = @Column(name = "FIELDCODE")) })
	public PDBaseFieldId getId() {
		return this.id;
	}

	/**
	 * 属性序号的setter方法
	 */
	public void setId(PDBaseFieldId id) {
		this.id = id;
	}

	/**
	 * 属性产品定义基础表的getter方法
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TABLECODE", nullable = false, insertable = false, updatable = false)
	public PDBaseTable getPDBaseTable() {
		return this.PDBaseTable;
	}

	/**
	 * 属性产品定义基础表的setter方法
	 */
	public void setPDBaseTable(PDBaseTable PDBaseTable) {
		this.PDBaseTable = PDBaseTable;
	}

	/**
	 * 属性字段名称的getter方法
	 */

	@Column(name = "FIELDNAME")
	public String getFieldName() {
		return this.fieldName;
	}

	/**
	 * 属性字段名称的setter方法
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * 属性字段类型的getter方法
	 */

	@Column(name = "FIELDTYPE")
	public String getFieldType() {
		return this.fieldType;
	}

	/**
	 * 属性字段类型的setter方法
	 */
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	/**
	 * 属性官方描述的getter方法
	 */

	@Column(name = "OFFICIALDESC")
	public String getOfficialDesc() {
		return this.officialDesc;
	}

	/**
	 * 属性官方描述的setter方法
	 */
	public void setOfficialDesc(String officialDesc) {
		this.officialDesc = officialDesc;
	}

	/**
	 * 属性业务描述的getter方法
	 */

	@Column(name = "BUSIDESC")
	public String getBusiDesc() {
		return this.busiDesc;
	}

	/**
	 * 属性业务描述的setter方法
	 */
	public void setBusiDesc(String busiDesc) {
		this.busiDesc = busiDesc;
	}

	/**
	 * 属性是否显示的getter方法
	 */

	@Column(name = "ISDISPLAY")
	public String getIsDisplay() {
		return this.isDisplay;
	}

	/**
	 * 属性是否显示的setter方法
	 */
	public void setIsDisplay(String isDisplay) {
		this.isDisplay = isDisplay;
	}

	/**
	 * 属性显示顺序的getter方法
	 */

	@Column(name = "DISPLAYORDER")
	public BigDecimal getDisplayOrder() {
		return this.displayOrder;
	}

	/**
	 * 属性显示顺序的setter方法
	 */
	public void setDisplayOrder(BigDecimal displayOrder) {
		this.displayOrder = displayOrder;
	}

	/**
	 * 属性是否主键的getter方法
	 */

	@Column(name = "ISPRIMARY")
	public String getIsPrimary() {
		return this.isPrimary;
	}

	/**
	 * 属性是否主键的setter方法
	 */
	public void setIsPrimary(String isPrimary) {
		this.isPrimary = isPrimary;
	}

	/**
	 * 属性下拉标识码的getter方法
	 */

	@Column(name = "SELECTCODE")
	public String getSelectCode() {
		return this.selectCode;
	}

	/**
	 * 属性下拉标识码的setter方法
	 */
	public void setSelectCode(String selectCode) {
		this.selectCode = selectCode;
	}

	/**
	 * 属性操作员的getter方法
	 */

	@Column(name = "OPERATOR")
	public String getOperator() {
		return this.operator;
	}

	/**
	 * 属性操作员的setter方法
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * 属性入机日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "MAKEDATE")
	public Date getMakeDate() {
		return this.makeDate;
	}

	/**
	 * 属性入机日期的setter方法
	 */
	public void setMakeDate(Date makeDate) {
		this.makeDate = makeDate;
	}

	/**
	 * 属性入机时间的getter方法
	 */

	@Column(name = "MAKETIME")
	public String getMakeTime() {
		return this.makeTime;
	}

	/**
	 * 属性入机时间的setter方法
	 */
	public void setMakeTime(String makeTime) {
		this.makeTime = makeTime;
	}

	/**
	 * 属性最后一次修改日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFYDATE")
	public Date getModifyDate() {
		return this.modifyDate;
	}

	/**
	 * 属性最后一次修改日期的setter方法
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	/**
	 * 属性最后一次修改时间的getter方法
	 */

	@Column(name = "MODIFYTIME")
	public String getModifyTime() {
		return this.modifyTime;
	}

	/**
	 * 属性最后一次修改时间的setter方法
	 */
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * 属性Standbyflag1的getter方法
	 */

	@Column(name = "STANDBYFLAG1")
	public String getStandbyflag1() {
		return this.standbyflag1;
	}

	/**
	 * 属性Standbyflag1的setter方法
	 */
	public void setStandbyflag1(String standbyflag1) {
		this.standbyflag1 = standbyflag1;
	}

	/**
	 * 属性Standbyflag2的getter方法
	 */

	@Column(name = "STANDBYFLAG2")
	public String getStandbyflag2() {
		return this.standbyflag2;
	}

	/**
	 * 属性Standbyflag2的setter方法
	 */
	public void setStandbyflag2(String standbyflag2) {
		this.standbyflag2 = standbyflag2;
	}

	/**
	 * 属性Standbyflag3的getter方法
	 */

	@Column(name = "STANDBYFLAG3")
	public BigDecimal getStandbyflag3() {
		return this.standbyflag3;
	}

	/**
	 * 属性Standbyflag3的setter方法
	 */
	public void setStandbyflag3(BigDecimal standbyflag3) {
		this.standbyflag3 = standbyflag3;
	}

	/**
	 * 属性Standbyflag4的getter方法
	 */

	@Column(name = "STANDBYFLAG4")
	public BigDecimal getStandbyflag4() {
		return this.standbyflag4;
	}

	/**
	 * 属性Standbyflag4的setter方法
	 */
	public void setStandbyflag4(BigDecimal standbyflag4) {
		this.standbyflag4 = standbyflag4;
	}

	/**
	 * 属性Standbyflag5的getter方法
	 */

	@Column(name = "STANDBYFLAG5")
	public BigDecimal getStandbyflag5() {
		return this.standbyflag5;
	}

	/**
	 * 属性Standbyflag5的setter方法
	 */
	public void setStandbyflag5(BigDecimal standbyflag5) {
		this.standbyflag5 = standbyflag5;
	}

	/**
	 * 属性Standbyflag6的getter方法
	 */

	@Column(name = "STANDBYFLAG6")
	public BigDecimal getStandbyflag6() {
		return this.standbyflag6;
	}

	/**
	 * 属性Standbyflag6的setter方法
	 */
	public void setStandbyflag6(BigDecimal standbyflag6) {
		this.standbyflag6 = standbyflag6;
	}

	/**
	 * 属性PDTestPointClewLibs的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PDBaseField")
	public List<PDTestPointClewLib> getPDTestPointClewLibs() {
		return this.PDTestPointClewLibs;
	}

	/**
	 * 属性PDTestPointClewLibs的setter方法
	 */
	public void setPDTestPointClewLibs(
			List<PDTestPointClewLib> PDTestPointClewLibs) {
		this.PDTestPointClewLibs = PDTestPointClewLibs;
	}

}
