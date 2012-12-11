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
 * POJO类PDLMRiskDutyRateValue
 */
@Entity
@Table(name = "PD_LMRISKDUTYRATEVALUE")
public class PDLMRiskDutyRateValue implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性ID */
	private PDLMRiskDutyRateValueId id;

	/** 属性要素值 */
	private BigDecimal factorValue;

	/** 属性要素属性 */
	private String factorType;

	/**
	 * 类PDLMRiskDutyRateValue的默认构造方法
	 */
	public PDLMRiskDutyRateValue() {
	}

	/**
	 * 属性ID的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "riskCode", column = @Column(name = "RISKCODE")),
			@AttributeOverride(name = "dutyCode", column = @Column(name = "DUTYCODE")),
			@AttributeOverride(name = "comFactor", column = @Column(name = "COMFACTOR")),
			@AttributeOverride(name = "comValue", column = @Column(name = "COMVALUE")) })
	public PDLMRiskDutyRateValueId getId() {
		return this.id;
	}

	/**
	 * 属性ID的setter方法
	 */
	public void setId(PDLMRiskDutyRateValueId id) {
		this.id = id;
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
