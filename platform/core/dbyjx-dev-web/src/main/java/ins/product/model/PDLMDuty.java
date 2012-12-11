package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * POJO类PDLMDuty
 */
@Entity
@Table(name = "PD_LMDUTY")
public class PDLMDuty implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性责任代码 */
	private String dutyCode;

	/** 属性责任名称 */
	private String dutyName;

	/** 属性缴费终止期间 */
	private BigDecimal payEndYear;

	/** 属性缴费终止期间单位 */
	private String payEndYearFlag;

	/** 属性缴费终止日期计算参照 */
	private String payEndDateCalRef;

	/** 属性缴费终止日期计算方式 */
	private String payEndDateCalMode;

	/** 属性起领期间 */
	private BigDecimal getYear;

	/** 属性起领期间单位 */
	private String getYearFlag;

	/** 属性保险期间 */
	private BigDecimal insuYear;

	/** 属性保险期间单位 */
	private String insuYearFlag;

	/** 属性意外责任期间 */
	private BigDecimal acciYear;

	/** 属性意外责任期间单位 */
	private String acciYearFlag;

	/** 属性计算方法 */
	private String calMode;

	/** 属性缴费终止期间关系 */
	private String payEndYearRela;

	/** 属性起领期间关系 */
	private String getYearRela;

	/** 属性保险期间关系 */
	private String insuYearRela;

	/** 属性基本保额算法 */
	private String basicCalCode;

	/** 属性风险保额算法 */
	private String riskCalCode;

	/** 属性保额标记 */
	private String amntFlag;

	/** 属性单位保额 */
	private BigDecimal vpu;

	/** 属性加费类型 */
	private String addFeeFlag;

	/** 属性保险终止日期计算方式 */
	private String endDateCalMode;

	/** 属性是否加入保额标记 */
	private String addAmntFlag;

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

	/** 属性PDLMDutyGets */
	private List<PDLMDutyGet> PDLMDutyGets = new ArrayList<PDLMDutyGet>(0);

	/** 属性PDLMDutyCtrls */
	private List<PDLMDutyCtrl> PDLMDutyCtrls = new ArrayList<PDLMDutyCtrl>(0);

	/** 属性PDLMRiskDuties */
	private List<PDLMRiskDuty> PDLMRiskDuties = new ArrayList<PDLMRiskDuty>(0);

	/**
	 * 类PDLMDuty的默认构造方法
	 */
	public PDLMDuty() {
	}

	/**
	 * 属性责任代码的getter方法
	 */
	@Id
	@Column(name = "DUTYCODE")
	public String getDutyCode() {
		return this.dutyCode;
	}

	/**
	 * 属性责任代码的setter方法
	 */
	public void setDutyCode(String dutyCode) {
		this.dutyCode = dutyCode;
	}

	/**
	 * 属性责任名称的getter方法
	 */

	@Column(name = "DUTYNAME")
	public String getDutyName() {
		return this.dutyName;
	}

	/**
	 * 属性责任名称的setter方法
	 */
	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	/**
	 * 属性缴费终止期间的getter方法
	 */

	@Column(name = "PAYENDYEAR")
	public BigDecimal getPayEndYear() {
		return this.payEndYear;
	}

	/**
	 * 属性缴费终止期间的setter方法
	 */
	public void setPayEndYear(BigDecimal payEndYear) {
		this.payEndYear = payEndYear;
	}

	/**
	 * 属性缴费终止期间单位的getter方法
	 */

	@Column(name = "PAYENDYEARFLAG")
	public String getPayEndYearFlag() {
		return this.payEndYearFlag;
	}

	/**
	 * 属性缴费终止期间单位的setter方法
	 */
	public void setPayEndYearFlag(String payEndYearFlag) {
		this.payEndYearFlag = payEndYearFlag;
	}

	/**
	 * 属性缴费终止日期计算参照的getter方法
	 */

	@Column(name = "PAYENDDATECALREF")
	public String getPayEndDateCalRef() {
		return this.payEndDateCalRef;
	}

	/**
	 * 属性缴费终止日期计算参照的setter方法
	 */
	public void setPayEndDateCalRef(String payEndDateCalRef) {
		this.payEndDateCalRef = payEndDateCalRef;
	}

	/**
	 * 属性缴费终止日期计算方式的getter方法
	 */

	@Column(name = "PAYENDDATECALMODE")
	public String getPayEndDateCalMode() {
		return this.payEndDateCalMode;
	}

	/**
	 * 属性缴费终止日期计算方式的setter方法
	 */
	public void setPayEndDateCalMode(String payEndDateCalMode) {
		this.payEndDateCalMode = payEndDateCalMode;
	}

	/**
	 * 属性起领期间的getter方法
	 */

	@Column(name = "GETYEAR")
	public BigDecimal getGetYear() {
		return this.getYear;
	}

	/**
	 * 属性起领期间的setter方法
	 */
	public void setGetYear(BigDecimal getYear) {
		this.getYear = getYear;
	}

	/**
	 * 属性起领期间单位的getter方法
	 */

	@Column(name = "GETYEARFLAG")
	public String getGetYearFlag() {
		return this.getYearFlag;
	}

	/**
	 * 属性起领期间单位的setter方法
	 */
	public void setGetYearFlag(String getYearFlag) {
		this.getYearFlag = getYearFlag;
	}

	/**
	 * 属性保险期间的getter方法
	 */

	@Column(name = "INSUYEAR")
	public BigDecimal getInsuYear() {
		return this.insuYear;
	}

	/**
	 * 属性保险期间的setter方法
	 */
	public void setInsuYear(BigDecimal insuYear) {
		this.insuYear = insuYear;
	}

	/**
	 * 属性保险期间单位的getter方法
	 */

	@Column(name = "INSUYEARFLAG")
	public String getInsuYearFlag() {
		return this.insuYearFlag;
	}

	/**
	 * 属性保险期间单位的setter方法
	 */
	public void setInsuYearFlag(String insuYearFlag) {
		this.insuYearFlag = insuYearFlag;
	}

	/**
	 * 属性意外责任期间的getter方法
	 */

	@Column(name = "ACCIYEAR")
	public BigDecimal getAcciYear() {
		return this.acciYear;
	}

	/**
	 * 属性意外责任期间的setter方法
	 */
	public void setAcciYear(BigDecimal acciYear) {
		this.acciYear = acciYear;
	}

	/**
	 * 属性意外责任期间单位的getter方法
	 */

	@Column(name = "ACCIYEARFLAG")
	public String getAcciYearFlag() {
		return this.acciYearFlag;
	}

	/**
	 * 属性意外责任期间单位的setter方法
	 */
	public void setAcciYearFlag(String acciYearFlag) {
		this.acciYearFlag = acciYearFlag;
	}

	/**
	 * 属性计算方法的getter方法
	 */

	@Column(name = "CALMODE")
	public String getCalMode() {
		return this.calMode;
	}

	/**
	 * 属性计算方法的setter方法
	 */
	public void setCalMode(String calMode) {
		this.calMode = calMode;
	}

	/**
	 * 属性缴费终止期间关系的getter方法
	 */

	@Column(name = "PAYENDYEARRELA")
	public String getPayEndYearRela() {
		return this.payEndYearRela;
	}

	/**
	 * 属性缴费终止期间关系的setter方法
	 */
	public void setPayEndYearRela(String payEndYearRela) {
		this.payEndYearRela = payEndYearRela;
	}

	/**
	 * 属性起领期间关系的getter方法
	 */

	@Column(name = "GETYEARRELA")
	public String getGetYearRela() {
		return this.getYearRela;
	}

	/**
	 * 属性起领期间关系的setter方法
	 */
	public void setGetYearRela(String getYearRela) {
		this.getYearRela = getYearRela;
	}

	/**
	 * 属性保险期间关系的getter方法
	 */

	@Column(name = "INSUYEARRELA")
	public String getInsuYearRela() {
		return this.insuYearRela;
	}

	/**
	 * 属性保险期间关系的setter方法
	 */
	public void setInsuYearRela(String insuYearRela) {
		this.insuYearRela = insuYearRela;
	}

	/**
	 * 属性基本保额算法的getter方法
	 */

	@Column(name = "BASICCALCODE")
	public String getBasicCalCode() {
		return this.basicCalCode;
	}

	/**
	 * 属性基本保额算法的setter方法
	 */
	public void setBasicCalCode(String basicCalCode) {
		this.basicCalCode = basicCalCode;
	}

	/**
	 * 属性风险保额算法的getter方法
	 */

	@Column(name = "RISKCALCODE")
	public String getRiskCalCode() {
		return this.riskCalCode;
	}

	/**
	 * 属性风险保额算法的setter方法
	 */
	public void setRiskCalCode(String riskCalCode) {
		this.riskCalCode = riskCalCode;
	}

	/**
	 * 属性保额标记的getter方法
	 */

	@Column(name = "AMNTFLAG")
	public String getAmntFlag() {
		return this.amntFlag;
	}

	/**
	 * 属性保额标记的setter方法
	 */
	public void setAmntFlag(String amntFlag) {
		this.amntFlag = amntFlag;
	}

	/**
	 * 属性单位保额的getter方法
	 */

	@Column(name = "VPU")
	public BigDecimal getVpu() {
		return this.vpu;
	}

	/**
	 * 属性单位保额的setter方法
	 */
	public void setVpu(BigDecimal vpu) {
		this.vpu = vpu;
	}

	/**
	 * 属性加费类型的getter方法
	 */

	@Column(name = "ADDFEEFLAG")
	public String getAddFeeFlag() {
		return this.addFeeFlag;
	}

	/**
	 * 属性加费类型的setter方法
	 */
	public void setAddFeeFlag(String addFeeFlag) {
		this.addFeeFlag = addFeeFlag;
	}

	/**
	 * 属性保险终止日期计算方式的getter方法
	 */

	@Column(name = "ENDDATECALMODE")
	public String getEndDateCalMode() {
		return this.endDateCalMode;
	}

	/**
	 * 属性保险终止日期计算方式的setter方法
	 */
	public void setEndDateCalMode(String endDateCalMode) {
		this.endDateCalMode = endDateCalMode;
	}

	/**
	 * 属性是否加入保额标记的getter方法
	 */

	@Column(name = "ADDAMNTFLAG")
	public String getAddAmntFlag() {
		return this.addAmntFlag;
	}

	/**
	 * 属性是否加入保额标记的setter方法
	 */
	public void setAddAmntFlag(String addAmntFlag) {
		this.addAmntFlag = addAmntFlag;
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
	 * 属性PDLMDutyGets的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PDLMDuty")
	public List<PDLMDutyGet> getPDLMDutyGets() {
		return this.PDLMDutyGets;
	}

	/**
	 * 属性PDLMDutyGets的setter方法
	 */
	public void setPDLMDutyGets(List<PDLMDutyGet> PDLMDutyGets) {
		this.PDLMDutyGets = PDLMDutyGets;
	}

	/**
	 * 属性PDLMDutyCtrls的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PDLMDuty")
	public List<PDLMDutyCtrl> getPDLMDutyCtrls() {
		return this.PDLMDutyCtrls;
	}

	/**
	 * 属性PDLMDutyCtrls的setter方法
	 */
	public void setPDLMDutyCtrls(List<PDLMDutyCtrl> PDLMDutyCtrls) {
		this.PDLMDutyCtrls = PDLMDutyCtrls;
	}

	/**
	 * 属性PDLMRiskDuties的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PDLMDuty")
	public List<PDLMRiskDuty> getPDLMRiskDuties() {
		return this.PDLMRiskDuties;
	}

	/**
	 * 属性PDLMRiskDuties的setter方法
	 */
	public void setPDLMRiskDuties(List<PDLMRiskDuty> PDLMRiskDuties) {
		this.PDLMRiskDuties = PDLMRiskDuties;
	}

}
