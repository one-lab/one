package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * POJO类PDLAwageCalElement
 */
@Entity
@Table(name = "PD_LAWAGECALELEMENT")
public class PDLAwageCalElement implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性险种代码 */
	private String riskCode;

	/** 属性险种定义 */
	private PDLMRisk PDLMRisk;

	/** 属性计算类型 */
	private String calType;

	/** 属性要素1 */
	private String f1;

	/** 属性要素2 */
	private String f2;

	/** 属性要素3 */
	private String f3;

	/** 属性要素4 */
	private String f4;

	/** 属性要素5 */
	private String f5;

	/** 属性佣金计算编码 */
	private String calCode;

	/** 属性展业类型 */
	private String branchType;

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
	 * 类PDLAwageCalElement的默认构造方法
	 */
	public PDLAwageCalElement() {
	}

	/**
	 * 属性险种代码的getter方法
	 */
	@Id
	@Column(name = "RISKCODE")
	public String getRiskCode() {
		return this.riskCode;
	}

	/**
	 * 属性险种代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	/**
	 * 属性险种定义的getter方法
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RISKCODE", unique = true, nullable = false, insertable = false, updatable = false)
	public PDLMRisk getPDLMRisk() {
		return this.PDLMRisk;
	}

	/**
	 * 属性险种定义的setter方法
	 */
	public void setPDLMRisk(PDLMRisk PDLMRisk) {
		this.PDLMRisk = PDLMRisk;
	}

	/**
	 * 属性计算类型的getter方法
	 */

	@Column(name = "CALTYPE")
	public String getCalType() {
		return this.calType;
	}

	/**
	 * 属性计算类型的setter方法
	 */
	public void setCalType(String calType) {
		this.calType = calType;
	}

	/**
	 * 属性要素1的getter方法
	 */

	@Column(name = "F1")
	public String getF1() {
		return this.f1;
	}

	/**
	 * 属性要素1的setter方法
	 */
	public void setF1(String f1) {
		this.f1 = f1;
	}

	/**
	 * 属性要素2的getter方法
	 */

	@Column(name = "F2")
	public String getF2() {
		return this.f2;
	}

	/**
	 * 属性要素2的setter方法
	 */
	public void setF2(String f2) {
		this.f2 = f2;
	}

	/**
	 * 属性要素3的getter方法
	 */

	@Column(name = "F3")
	public String getF3() {
		return this.f3;
	}

	/**
	 * 属性要素3的setter方法
	 */
	public void setF3(String f3) {
		this.f3 = f3;
	}

	/**
	 * 属性要素4的getter方法
	 */

	@Column(name = "F4")
	public String getF4() {
		return this.f4;
	}

	/**
	 * 属性要素4的setter方法
	 */
	public void setF4(String f4) {
		this.f4 = f4;
	}

	/**
	 * 属性要素5的getter方法
	 */

	@Column(name = "F5")
	public String getF5() {
		return this.f5;
	}

	/**
	 * 属性要素5的setter方法
	 */
	public void setF5(String f5) {
		this.f5 = f5;
	}

	/**
	 * 属性佣金计算编码的getter方法
	 */

	@Column(name = "CALCODE")
	public String getCalCode() {
		return this.calCode;
	}

	/**
	 * 属性佣金计算编码的setter方法
	 */
	public void setCalCode(String calCode) {
		this.calCode = calCode;
	}

	/**
	 * 属性展业类型的getter方法
	 */

	@Column(name = "BRANCHTYPE")
	public String getBranchType() {
		return this.branchType;
	}

	/**
	 * 属性展业类型的setter方法
	 */
	public void setBranchType(String branchType) {
		this.branchType = branchType;
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
