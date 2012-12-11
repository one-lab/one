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
 * POJO类PDLFRisk
 */
@Entity
@Table(name = "PD_LFRISK")
public class PDLFRisk implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性险种代码 */
	private String riskCode;

	/** 属性险种定义 */
	private PDLMRisk PDLMRisk;

	/** 属性险种版本 */
	private String riskVer;

	/** 属性险种名称 */
	private String riskName;

	/** 属性险种分类 */
	private String riskType;

	/** 属性险种类别 */
	private String riskPeriod;

	/** 属性主附险标记 */
	private String subRiskFlag;

	/** 属性寿险分类 */
	private String lifeType;

	/** 属性险种事故责任分类（寿险） */
	private String riskDutyType;

	/** 属性健康险和意外险期限分类 */
	private String riskYearType;

	/** 属性健康险细分 */
	private String healthType;

	/** 属性意外险细分 */
	private String accidentType;

	/** 属性养老险细分 */
	private String endowmentFlag;

	/** 属性养老险细分1 */
	private String endowmentType1;

	/** 属性养老险细分2 */
	private String endowmentType2;

	/** 属性险种的销售渠道 */
	private String riskSaleChnl;

	/** 属性险种的团个单标志 */
	private String riskGrpFlag;

	/** 属性手续费销售渠道 */
	private String chargeSaleChnl;

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
	 * 类PDLFRisk的默认构造方法
	 */
	public PDLFRisk() {
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
	 * 属性险种版本的getter方法
	 */

	@Column(name = "RISKVER")
	public String getRiskVer() {
		return this.riskVer;
	}

	/**
	 * 属性险种版本的setter方法
	 */
	public void setRiskVer(String riskVer) {
		this.riskVer = riskVer;
	}

	/**
	 * 属性险种名称的getter方法
	 */

	@Column(name = "RISKNAME")
	public String getRiskName() {
		return this.riskName;
	}

	/**
	 * 属性险种名称的setter方法
	 */
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	/**
	 * 属性险种分类的getter方法
	 */

	@Column(name = "RISKTYPE")
	public String getRiskType() {
		return this.riskType;
	}

	/**
	 * 属性险种分类的setter方法
	 */
	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}

	/**
	 * 属性险种类别的getter方法
	 */

	@Column(name = "RISKPERIOD")
	public String getRiskPeriod() {
		return this.riskPeriod;
	}

	/**
	 * 属性险种类别的setter方法
	 */
	public void setRiskPeriod(String riskPeriod) {
		this.riskPeriod = riskPeriod;
	}

	/**
	 * 属性主附险标记的getter方法
	 */

	@Column(name = "SUBRISKFLAG")
	public String getSubRiskFlag() {
		return this.subRiskFlag;
	}

	/**
	 * 属性主附险标记的setter方法
	 */
	public void setSubRiskFlag(String subRiskFlag) {
		this.subRiskFlag = subRiskFlag;
	}

	/**
	 * 属性寿险分类的getter方法
	 */

	@Column(name = "LIFETYPE")
	public String getLifeType() {
		return this.lifeType;
	}

	/**
	 * 属性寿险分类的setter方法
	 */
	public void setLifeType(String lifeType) {
		this.lifeType = lifeType;
	}

	/**
	 * 属性险种事故责任分类（寿险）的getter方法
	 */

	@Column(name = "RISKDUTYTYPE")
	public String getRiskDutyType() {
		return this.riskDutyType;
	}

	/**
	 * 属性险种事故责任分类（寿险）的setter方法
	 */
	public void setRiskDutyType(String riskDutyType) {
		this.riskDutyType = riskDutyType;
	}

	/**
	 * 属性健康险和意外险期限分类的getter方法
	 */

	@Column(name = "RISKYEARTYPE")
	public String getRiskYearType() {
		return this.riskYearType;
	}

	/**
	 * 属性健康险和意外险期限分类的setter方法
	 */
	public void setRiskYearType(String riskYearType) {
		this.riskYearType = riskYearType;
	}

	/**
	 * 属性健康险细分的getter方法
	 */

	@Column(name = "HEALTHTYPE")
	public String getHealthType() {
		return this.healthType;
	}

	/**
	 * 属性健康险细分的setter方法
	 */
	public void setHealthType(String healthType) {
		this.healthType = healthType;
	}

	/**
	 * 属性意外险细分的getter方法
	 */

	@Column(name = "ACCIDENTTYPE")
	public String getAccidentType() {
		return this.accidentType;
	}

	/**
	 * 属性意外险细分的setter方法
	 */
	public void setAccidentType(String accidentType) {
		this.accidentType = accidentType;
	}

	/**
	 * 属性养老险细分的getter方法
	 */

	@Column(name = "ENDOWMENTFLAG")
	public String getEndowmentFlag() {
		return this.endowmentFlag;
	}

	/**
	 * 属性养老险细分的setter方法
	 */
	public void setEndowmentFlag(String endowmentFlag) {
		this.endowmentFlag = endowmentFlag;
	}

	/**
	 * 属性养老险细分1的getter方法
	 */

	@Column(name = "ENDOWMENTTYPE1")
	public String getEndowmentType1() {
		return this.endowmentType1;
	}

	/**
	 * 属性养老险细分1的setter方法
	 */
	public void setEndowmentType1(String endowmentType1) {
		this.endowmentType1 = endowmentType1;
	}

	/**
	 * 属性养老险细分2的getter方法
	 */

	@Column(name = "ENDOWMENTTYPE2")
	public String getEndowmentType2() {
		return this.endowmentType2;
	}

	/**
	 * 属性养老险细分2的setter方法
	 */
	public void setEndowmentType2(String endowmentType2) {
		this.endowmentType2 = endowmentType2;
	}

	/**
	 * 属性险种的销售渠道的getter方法
	 */

	@Column(name = "RISKSALECHNL")
	public String getRiskSaleChnl() {
		return this.riskSaleChnl;
	}

	/**
	 * 属性险种的销售渠道的setter方法
	 */
	public void setRiskSaleChnl(String riskSaleChnl) {
		this.riskSaleChnl = riskSaleChnl;
	}

	/**
	 * 属性险种的团个单标志的getter方法
	 */

	@Column(name = "RISKGRPFLAG")
	public String getRiskGrpFlag() {
		return this.riskGrpFlag;
	}

	/**
	 * 属性险种的团个单标志的setter方法
	 */
	public void setRiskGrpFlag(String riskGrpFlag) {
		this.riskGrpFlag = riskGrpFlag;
	}

	/**
	 * 属性手续费销售渠道的getter方法
	 */

	@Column(name = "CHARGESALECHNL")
	public String getChargeSaleChnl() {
		return this.chargeSaleChnl;
	}

	/**
	 * 属性手续费销售渠道的setter方法
	 */
	public void setChargeSaleChnl(String chargeSaleChnl) {
		this.chargeSaleChnl = chargeSaleChnl;
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
