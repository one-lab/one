package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * POJO类PDLMRiskDutyRate
 */
@Entity
@Table(name = "PD_LMRISKDUTYRATE")
public class PDLMRiskDutyRate implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性ID */
	private PDLMRiskDutyRateId id;

	/** 属性起始值 */
	private BigDecimal startValue;

	/** 属性终止值 */
	private BigDecimal endValue;

	/** 属性要素值 */
	private BigDecimal factorValue;

	/** 属性要素属性 */
	private String factorType;

	/**
	 * 类PDLMRiskDutyRate的默认构造方法
	 */
	public PDLMRiskDutyRate() {
	}

	/**
	 * 属性ID的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "riskCode", column = @Column(name = "RISKCODE")),
			@AttributeOverride(name = "dutyCode", column = @Column(name = "DUTYCODE")),
			@AttributeOverride(name = "calfactor", column = @Column(name = "CALFACTOR")),
			@AttributeOverride(name = "serialNo", column = @Column(name = "SERIALNO")) })
	public PDLMRiskDutyRateId getId() {
		return this.id;
	}

	/**
	 * 属性ID的setter方法
	 */
	public void setId(PDLMRiskDutyRateId id) {
		this.id = id;
	}

	/**
	 * 属性起始值的getter方法
	 */

	@Column(name = "STARTVALUE")
	public BigDecimal getStartValue() {
		return this.startValue;
	}

	/**
	 * 属性起始值的setter方法
	 */
	public void setStartValue(BigDecimal startValue) {
		this.startValue = startValue;
	}

	/**
	 * 属性终止值的getter方法
	 */

	@Column(name = "ENDVALUE")
	public BigDecimal getEndValue() {
		return this.endValue;
	}

	/**
	 * 属性终止值的setter方法
	 */
	public void setEndValue(BigDecimal endValue) {
		this.endValue = endValue;
	}

	/**
	 * 属性要素值的getter方法
	 */

	@Column(name = "FACTORVALUE")
	public BigDecimal getFactorValue() {
		return this.factorValue;
	}

	/**
	 * 属性要素值的setter方法
	 */
	public void setFactorValue(BigDecimal factorValue) {
		this.factorValue = factorValue;
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

}
