package ins.platform.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

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

/**
 * POJO类UtiUserGradePower
 */
@Entity
@Table(name = "UTIUSERGRADEPOWER")
public class UtiUserGradePower implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性ID */
	private UtiUserGradePowerId id;

	/** 属性utiUserGrade */
	private UtiUserGrade utiUserGrade;

	/** 属性 */
	private String permitComCode;

	/** 属性 */
	private String exceptComCode;

	/** 属性员工范围 */
	private String permitUserCode;

	/** 属性险种范围 */
	private String permitRiskCode;

	/** 属性 */
	private String codePermitComCode;

	/** 属性 */
	private String codeExceptComCode;

	/** 属性 */
	private String customerExceptComCode;

	/** 属性customerpermitcomcode */
	private String customerpermitcomcode;

	/**
	 * 类UtiUserGradePower的默认构造方法
	 */
	public UtiUserGradePower() {
	}

	/**
	 * 属性ID的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "comCode", column = @Column(name = "COMCODE")),
			@AttributeOverride(name = "userCode", column = @Column(name = "USERCODE")),
			@AttributeOverride(name = "gradeCode", column = @Column(name = "GRADECODE")),
			@AttributeOverride(name = "serialNo", column = @Column(name = "SERIALNO")) })
	public UtiUserGradePowerId getId() {
		return this.id;
	}

	/**
	 * 属性ID的setter方法
	 */
	public void setId(UtiUserGradePowerId id) {
		this.id = id;
	}

	/**
	 * 属性utiUserGrade的getter方法
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "COMCODE", referencedColumnName = "COMCODE", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "USERCODE", referencedColumnName = "USERCODE", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "GRADECODE", referencedColumnName = "GRADECODE", nullable = false, insertable = false, updatable = false) })
	public UtiUserGrade getUtiUserGrade() {
		return this.utiUserGrade;
	}

	/**
	 * 属性utiUserGrade的setter方法
	 */
	public void setUtiUserGrade(UtiUserGrade utiUserGrade) {
		this.utiUserGrade = utiUserGrade;
	}

	/**
	 * 属性的getter方法
	 */

	@Column(name = "PERMITCOMCODE")
	public String getPermitComCode() {
		return this.permitComCode;
	}

	/**
	 * 属性的setter方法
	 */
	public void setPermitComCode(String permitComCode) {
		this.permitComCode = permitComCode;
	}

	/**
	 * 属性的getter方法
	 */

	@Column(name = "EXCEPTCOMCODE")
	public String getExceptComCode() {
		return this.exceptComCode;
	}

	/**
	 * 属性的setter方法
	 */
	public void setExceptComCode(String exceptComCode) {
		this.exceptComCode = exceptComCode;
	}

	/**
	 * 属性员工范围的getter方法
	 */

	@Column(name = "PERMITUSERCODE")
	public String getPermitUserCode() {
		return this.permitUserCode;
	}

	/**
	 * 属性员工范围的setter方法
	 */
	public void setPermitUserCode(String permitUserCode) {
		this.permitUserCode = permitUserCode;
	}

	/**
	 * 属性险种范围的getter方法
	 */

	@Column(name = "PERMITRISKCODE")
	public String getPermitRiskCode() {
		return this.permitRiskCode;
	}

	/**
	 * 属性险种范围的setter方法
	 */
	public void setPermitRiskCode(String permitRiskCode) {
		this.permitRiskCode = permitRiskCode;
	}

	/**
	 * 属性的getter方法
	 */

	@Column(name = "CODEPERMITCOMCODE")
	public String getCodePermitComCode() {
		return this.codePermitComCode;
	}

	/**
	 * 属性的setter方法
	 */
	public void setCodePermitComCode(String codePermitComCode) {
		this.codePermitComCode = codePermitComCode;
	}

	/**
	 * 属性的getter方法
	 */

	@Column(name = "CODEEXCEPTCOMCODE")
	public String getCodeExceptComCode() {
		return this.codeExceptComCode;
	}

	/**
	 * 属性的setter方法
	 */
	public void setCodeExceptComCode(String codeExceptComCode) {
		this.codeExceptComCode = codeExceptComCode;
	}

	/**
	 * 属性的getter方法
	 */

	@Column(name = "CUSTOMEREXCEPTCOMCODE")
	public String getCustomerExceptComCode() {
		return this.customerExceptComCode;
	}

	/**
	 * 属性的setter方法
	 */
	public void setCustomerExceptComCode(String customerExceptComCode) {
		this.customerExceptComCode = customerExceptComCode;
	}

	/**
	 * 属性customerpermitcomcode的getter方法
	 */

	@Column(name = "CUSTOMERPERMITCOMCODE")
	public String getCustomerpermitcomcode() {
		return this.customerpermitcomcode;
	}

	/**
	 * 属性customerpermitcomcode的setter方法
	 */
	public void setCustomerpermitcomcode(String customerpermitcomcode) {
		this.customerpermitcomcode = customerpermitcomcode;
	}

}
