package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * POJO类PDLMRiskFeeParam
 */
@Entity
@Table(name = "PD_LMRISKFEEPARAM")
public class PDLMRiskFeeParam implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性序号 */
	private PDLMRiskFeeParamId id;

	/** 属性费用下限 */
	private BigDecimal feeMin;

	/** 属性费用上限 */
	private BigDecimal feeMax;

	/** 属性提取管理费比例 */
	private BigDecimal feeRate;

	/** 属性操作员 */
	private String operator;

	/** 属性入机时间 */
	private String makeTime;

	/** 属性入机日期 */
	private Date makeDate;

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
	 * 类PDLMRiskFeeParam的默认构造方法
	 */
	public PDLMRiskFeeParam() {
	}

	/**
	 * 属性序号的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "feecode", column = @Column(name = "FEECODE")),
			@AttributeOverride(name = "payPlanCode", column = @Column(name = "PAYPLANCODE")),
			@AttributeOverride(name = "insuAccNo", column = @Column(name = "INSUACCNO")),
			@AttributeOverride(name = "feeCalMode", column = @Column(name = "FEECALMODE")),
			@AttributeOverride(name = "feeID", column = @Column(name = "FEEID")) })
	public PDLMRiskFeeParamId getId() {
		return this.id;
	}

	/**
	 * 属性序号的setter方法
	 */
	public void setId(PDLMRiskFeeParamId id) {
		this.id = id;
	}

	/**
	 * 属性费用下限的getter方法
	 */

	@Column(name = "FEEMIN")
	public BigDecimal getFeeMin() {
		return this.feeMin;
	}

	/**
	 * 属性费用下限的setter方法
	 */
	public void setFeeMin(BigDecimal feeMin) {
		this.feeMin = feeMin;
	}

	/**
	 * 属性费用上限的getter方法
	 */

	@Column(name = "FEEMAX")
	public BigDecimal getFeeMax() {
		return this.feeMax;
	}

	/**
	 * 属性费用上限的setter方法
	 */
	public void setFeeMax(BigDecimal feeMax) {
		this.feeMax = feeMax;
	}

	/**
	 * 属性提取管理费比例的getter方法
	 */

	@Column(name = "FEERATE")
	public BigDecimal getFeeRate() {
		return this.feeRate;
	}

	/**
	 * 属性提取管理费比例的setter方法
	 */
	public void setFeeRate(BigDecimal feeRate) {
		this.feeRate = feeRate;
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
