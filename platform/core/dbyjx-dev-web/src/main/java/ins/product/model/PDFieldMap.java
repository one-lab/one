package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * POJO类PDFieldMap
 */
@Entity
@Table(name = "PD_FIELDMAP")
public class PDFieldMap implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性序号 */
	private PDFieldMapId id;

	/** 属性表映射关系 */
	private PDTableMap PDTableMap;

	/** 属性产品定义平台字段类型 */
	private String pdFieldType;

	/** 属性是否为产品定义平台表的主键 */
	private String isPDTablePrimary;

	/** 属性核心业务系统字段类型 */
	private String coreFieldType;

	/** 属性是否为核心业务系统表的主键 */
	private String isCoreTablePrimary;

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

	/**
	 * 类PDFieldMap的默认构造方法
	 */
	public PDFieldMap() {
	}

	/**
	 * 属性序号的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "tableCode", column = @Column(name = "TABLECODE")),
			@AttributeOverride(name = "coreTableCode", column = @Column(name = "CORETABLECODE")),
			@AttributeOverride(name = "pdFieldCode", column = @Column(name = "PDFIELDCODE")),
			@AttributeOverride(name = "coreFiledCode", column = @Column(name = "COREFILEDCODE")) })
	public PDFieldMapId getId() {
		return this.id;
	}

	/**
	 * 属性序号的setter方法
	 */
	public void setId(PDFieldMapId id) {
		this.id = id;
	}

	/**
	 * 属性表映射关系的getter方法
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "TABLECODE", referencedColumnName = "TABLECODE", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CORETABLECODE", referencedColumnName = "CORETABLECODE", nullable = false, insertable = false, updatable = false) })
	public PDTableMap getPDTableMap() {
		return this.PDTableMap;
	}

	/**
	 * 属性表映射关系的setter方法
	 */
	public void setPDTableMap(PDTableMap PDTableMap) {
		this.PDTableMap = PDTableMap;
	}

	/**
	 * 属性产品定义平台字段类型的getter方法
	 */

	@Column(name = "PDFIELDTYPE")
	public String getPdFieldType() {
		return this.pdFieldType;
	}

	/**
	 * 属性产品定义平台字段类型的setter方法
	 */
	public void setPdFieldType(String pdFieldType) {
		this.pdFieldType = pdFieldType;
	}

	/**
	 * 属性是否为产品定义平台表的主键的getter方法
	 */

	@Column(name = "ISPDTABLEPRIMARY")
	public String getIsPDTablePrimary() {
		return this.isPDTablePrimary;
	}

	/**
	 * 属性是否为产品定义平台表的主键的setter方法
	 */
	public void setIsPDTablePrimary(String isPDTablePrimary) {
		this.isPDTablePrimary = isPDTablePrimary;
	}

	/**
	 * 属性核心业务系统字段类型的getter方法
	 */

	@Column(name = "COREFIELDTYPE")
	public String getCoreFieldType() {
		return this.coreFieldType;
	}

	/**
	 * 属性核心业务系统字段类型的setter方法
	 */
	public void setCoreFieldType(String coreFieldType) {
		this.coreFieldType = coreFieldType;
	}

	/**
	 * 属性是否为核心业务系统表的主键的getter方法
	 */

	@Column(name = "ISCORETABLEPRIMARY")
	public String getIsCoreTablePrimary() {
		return this.isCoreTablePrimary;
	}

	/**
	 * 属性是否为核心业务系统表的主键的setter方法
	 */
	public void setIsCoreTablePrimary(String isCoreTablePrimary) {
		this.isCoreTablePrimary = isCoreTablePrimary;
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

}
