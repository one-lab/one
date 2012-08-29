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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * POJO类PDLMCalFactor
 */
@Entity
@Table(name = "PD_LMCALFACTOR")
public class PDLMCalFactor implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性序号 */
	private PDLMCalFactorId id;

	/** 属性算法表 */
	private PDLMCalMode PDLMCalMode;

	/** 属性要素名称 */
	private String factorName;

	/** 属性要素属性 */
	private String factorType;

	/** 属性要素优先级 */
	private String factorGrade;

	/** 属性要素算法编码 */
	private String factorCalCode;

	/** 属性默认值 */
	private String factorDefault;

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
	 * 类PDLMCalFactor的默认构造方法
	 */
	public PDLMCalFactor() {
	}

	/**
	 * 属性序号的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "calCode", column = @Column(name = "CALCODE")),
			@AttributeOverride(name = "factorCode", column = @Column(name = "FACTORCODE")) })
	public PDLMCalFactorId getId() {
		return this.id;
	}

	/**
	 * 属性序号的setter方法
	 */
	public void setId(PDLMCalFactorId id) {
		this.id = id;
	}

	/**
	 * 属性算法表的getter方法
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CALCODE", nullable = false, insertable = false, updatable = false)
	public PDLMCalMode getPDLMCalMode() {
		return this.PDLMCalMode;
	}

	/**
	 * 属性算法表的setter方法
	 */
	public void setPDLMCalMode(PDLMCalMode PDLMCalMode) {
		this.PDLMCalMode = PDLMCalMode;
	}

	/**
	 * 属性要素名称的getter方法
	 */

	@Column(name = "FACTORNAME")
	public String getFactorName() {
		return this.factorName;
	}

	/**
	 * 属性要素名称的setter方法
	 */
	public void setFactorName(String factorName) {
		this.factorName = factorName;
	}

	/**
	 * 属性要素属性的getter方法
	 */

	@Column(name = "FACTORTYPE")
	public String getFactorType() {
		return this.factorType;
	}

	/**
	 * 属性要素属性的setter方法
	 */
	public void setFactorType(String factorType) {
		this.factorType = factorType;
	}

	/**
	 * 属性要素优先级的getter方法
	 */

	@Column(name = "FACTORGRADE")
	public String getFactorGrade() {
		return this.factorGrade;
	}

	/**
	 * 属性要素优先级的setter方法
	 */
	public void setFactorGrade(String factorGrade) {
		this.factorGrade = factorGrade;
	}

	/**
	 * 属性要素算法编码的getter方法
	 */

	@Column(name = "FACTORCALCODE")
	public String getFactorCalCode() {
		return this.factorCalCode;
	}

	/**
	 * 属性要素算法编码的setter方法
	 */
	public void setFactorCalCode(String factorCalCode) {
		this.factorCalCode = factorCalCode;
	}

	/**
	 * 属性默认值的getter方法
	 */

	@Column(name = "FACTORDEFAULT")
	public String getFactorDefault() {
		return this.factorDefault;
	}

	/**
	 * 属性默认值的setter方法
	 */
	public void setFactorDefault(String factorDefault) {
		this.factorDefault = factorDefault;
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
