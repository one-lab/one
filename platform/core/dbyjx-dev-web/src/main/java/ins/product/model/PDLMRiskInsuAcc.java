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
 * POJO类PDLMRiskInsuAcc
 */
@Entity
@Table(name = "PD_LMRISKINSUACC")
public class PDLMRiskInsuAcc implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性保险帐户号码 */
	private String insuAccNo;

	/** 属性账户分类 */
	private String accKind;

	/** 属性账号类型 */
	private String accType;

	/** 属性保险帐户名称 */
	private String insuAccName;

	/** 属性账户产生位置 */
	private String accCreatePos;

	/** 属性账号产生规则 */
	private String accCreateType;

	/** 属性账户固定利率 */
	private BigDecimal accRate;

	/** 属性账户对应利率表 */
	private String accRateTable;

	/** 属性账户结清计算公式 */
	private String accCancelCode;

	/** 属性账户结算方式 */
	private String accComputeFlag;

	/** 属性投资类型 */
	private String investType;

	/** 属性基金公司代码 */
	private String fundCompanyCode;

	/** 属性账户所有者 */
	private String owner;

	/** 属性是否参与分红 */
	private String accBonusFlag;

	/** 属性分红记入账户的方式 */
	private String accBonusMode;

	/** 属性分红记入账户代码 */
	private String bonusToInsuAccNo;

	/** 属性分红时是否进行账户结算 */
	private String insuAccCalBalaFlag;

	/** 属性红利领取方式 */
	private String bonusMode;

	/** 属性投资标记 */
	private String investFlag;

	/** 属性计价周期 */
	private String calValueFreq;

	/** 属性计价价格获取规则 */
	private String calValueRule;

	/** 属性小数位数 */
	private String unitDecimal;

	/** 属性四舍五入标记 */
	private String roundMethod;

	/** 属性分红标记 */
	private String bonusFlag;

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

	/** 属性PDLMRiskAccGets */
	private List<PDLMRiskAccGet> PDLMRiskAccGets = new ArrayList<PDLMRiskAccGet>(
			0);

	/** 属性PDLMRiskToAccs */
	private List<PDLMRiskToAcc> PDLMRiskToAccs = new ArrayList<PDLMRiskToAcc>(0);

	/**
	 * 类PDLMRiskInsuAcc的默认构造方法
	 */
	public PDLMRiskInsuAcc() {
	}

	/**
	 * 属性保险帐户号码的getter方法
	 */
	@Id
	@Column(name = "INSUACCNO")
	public String getInsuAccNo() {
		return this.insuAccNo;
	}

	/**
	 * 属性保险帐户号码的setter方法
	 */
	public void setInsuAccNo(String insuAccNo) {
		this.insuAccNo = insuAccNo;
	}

	/**
	 * 属性账户分类的getter方法
	 */

	@Column(name = "ACCKIND")
	public String getAccKind() {
		return this.accKind;
	}

	/**
	 * 属性账户分类的setter方法
	 */
	public void setAccKind(String accKind) {
		this.accKind = accKind;
	}

	/**
	 * 属性账号类型的getter方法
	 */

	@Column(name = "ACCTYPE")
	public String getAccType() {
		return this.accType;
	}

	/**
	 * 属性账号类型的setter方法
	 */
	public void setAccType(String accType) {
		this.accType = accType;
	}

	/**
	 * 属性保险帐户名称的getter方法
	 */

	@Column(name = "INSUACCNAME")
	public String getInsuAccName() {
		return this.insuAccName;
	}

	/**
	 * 属性保险帐户名称的setter方法
	 */
	public void setInsuAccName(String insuAccName) {
		this.insuAccName = insuAccName;
	}

	/**
	 * 属性账户产生位置的getter方法
	 */

	@Column(name = "ACCCREATEPOS")
	public String getAccCreatePos() {
		return this.accCreatePos;
	}

	/**
	 * 属性账户产生位置的setter方法
	 */
	public void setAccCreatePos(String accCreatePos) {
		this.accCreatePos = accCreatePos;
	}

	/**
	 * 属性账号产生规则的getter方法
	 */

	@Column(name = "ACCCREATETYPE")
	public String getAccCreateType() {
		return this.accCreateType;
	}

	/**
	 * 属性账号产生规则的setter方法
	 */
	public void setAccCreateType(String accCreateType) {
		this.accCreateType = accCreateType;
	}

	/**
	 * 属性账户固定利率的getter方法
	 */

	@Column(name = "ACCRATE")
	public BigDecimal getAccRate() {
		return this.accRate;
	}

	/**
	 * 属性账户固定利率的setter方法
	 */
	public void setAccRate(BigDecimal accRate) {
		this.accRate = accRate;
	}

	/**
	 * 属性账户对应利率表的getter方法
	 */

	@Column(name = "ACCRATETABLE")
	public String getAccRateTable() {
		return this.accRateTable;
	}

	/**
	 * 属性账户对应利率表的setter方法
	 */
	public void setAccRateTable(String accRateTable) {
		this.accRateTable = accRateTable;
	}

	/**
	 * 属性账户结清计算公式的getter方法
	 */

	@Column(name = "ACCCANCELCODE")
	public String getAccCancelCode() {
		return this.accCancelCode;
	}

	/**
	 * 属性账户结清计算公式的setter方法
	 */
	public void setAccCancelCode(String accCancelCode) {
		this.accCancelCode = accCancelCode;
	}

	/**
	 * 属性账户结算方式的getter方法
	 */

	@Column(name = "ACCCOMPUTEFLAG")
	public String getAccComputeFlag() {
		return this.accComputeFlag;
	}

	/**
	 * 属性账户结算方式的setter方法
	 */
	public void setAccComputeFlag(String accComputeFlag) {
		this.accComputeFlag = accComputeFlag;
	}

	/**
	 * 属性投资类型的getter方法
	 */

	@Column(name = "INVESTTYPE")
	public String getInvestType() {
		return this.investType;
	}

	/**
	 * 属性投资类型的setter方法
	 */
	public void setInvestType(String investType) {
		this.investType = investType;
	}

	/**
	 * 属性基金公司代码的getter方法
	 */

	@Column(name = "FUNDCOMPANYCODE")
	public String getFundCompanyCode() {
		return this.fundCompanyCode;
	}

	/**
	 * 属性基金公司代码的setter方法
	 */
	public void setFundCompanyCode(String fundCompanyCode) {
		this.fundCompanyCode = fundCompanyCode;
	}

	/**
	 * 属性账户所有者的getter方法
	 */

	@Column(name = "OWNER")
	public String getOwner() {
		return this.owner;
	}

	/**
	 * 属性账户所有者的setter方法
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * 属性是否参与分红的getter方法
	 */

	@Column(name = "ACCBONUSFLAG")
	public String getAccBonusFlag() {
		return this.accBonusFlag;
	}

	/**
	 * 属性是否参与分红的setter方法
	 */
	public void setAccBonusFlag(String accBonusFlag) {
		this.accBonusFlag = accBonusFlag;
	}

	/**
	 * 属性分红记入账户的方式的getter方法
	 */

	@Column(name = "ACCBONUSMODE")
	public String getAccBonusMode() {
		return this.accBonusMode;
	}

	/**
	 * 属性分红记入账户的方式的setter方法
	 */
	public void setAccBonusMode(String accBonusMode) {
		this.accBonusMode = accBonusMode;
	}

	/**
	 * 属性分红记入账户代码的getter方法
	 */

	@Column(name = "BONUSTOINSUACCNO")
	public String getBonusToInsuAccNo() {
		return this.bonusToInsuAccNo;
	}

	/**
	 * 属性分红记入账户代码的setter方法
	 */
	public void setBonusToInsuAccNo(String bonusToInsuAccNo) {
		this.bonusToInsuAccNo = bonusToInsuAccNo;
	}

	/**
	 * 属性分红时是否进行账户结算的getter方法
	 */

	@Column(name = "INSUACCCALBALAFLAG")
	public String getInsuAccCalBalaFlag() {
		return this.insuAccCalBalaFlag;
	}

	/**
	 * 属性分红时是否进行账户结算的setter方法
	 */
	public void setInsuAccCalBalaFlag(String insuAccCalBalaFlag) {
		this.insuAccCalBalaFlag = insuAccCalBalaFlag;
	}

	/**
	 * 属性红利领取方式的getter方法
	 */

	@Column(name = "BONUSMODE")
	public String getBonusMode() {
		return this.bonusMode;
	}

	/**
	 * 属性红利领取方式的setter方法
	 */
	public void setBonusMode(String bonusMode) {
		this.bonusMode = bonusMode;
	}

	/**
	 * 属性投资标记的getter方法
	 */

	@Column(name = "INVESTFLAG")
	public String getInvestFlag() {
		return this.investFlag;
	}

	/**
	 * 属性投资标记的setter方法
	 */
	public void setInvestFlag(String investFlag) {
		this.investFlag = investFlag;
	}

	/**
	 * 属性计价周期的getter方法
	 */

	@Column(name = "CALVALUEFREQ")
	public String getCalValueFreq() {
		return this.calValueFreq;
	}

	/**
	 * 属性计价周期的setter方法
	 */
	public void setCalValueFreq(String calValueFreq) {
		this.calValueFreq = calValueFreq;
	}

	/**
	 * 属性计价价格获取规则的getter方法
	 */

	@Column(name = "CALVALUERULE")
	public String getCalValueRule() {
		return this.calValueRule;
	}

	/**
	 * 属性计价价格获取规则的setter方法
	 */
	public void setCalValueRule(String calValueRule) {
		this.calValueRule = calValueRule;
	}

	/**
	 * 属性小数位数的getter方法
	 */

	@Column(name = "UNITDECIMAL")
	public String getUnitDecimal() {
		return this.unitDecimal;
	}

	/**
	 * 属性小数位数的setter方法
	 */
	public void setUnitDecimal(String unitDecimal) {
		this.unitDecimal = unitDecimal;
	}

	/**
	 * 属性四舍五入标记的getter方法
	 */

	@Column(name = "ROUNDMETHOD")
	public String getRoundMethod() {
		return this.roundMethod;
	}

	/**
	 * 属性四舍五入标记的setter方法
	 */
	public void setRoundMethod(String roundMethod) {
		this.roundMethod = roundMethod;
	}

	/**
	 * 属性分红标记的getter方法
	 */

	@Column(name = "BONUSFLAG")
	public String getBonusFlag() {
		return this.bonusFlag;
	}

	/**
	 * 属性分红标记的setter方法
	 */
	public void setBonusFlag(String bonusFlag) {
		this.bonusFlag = bonusFlag;
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
	 * 属性PDLMRiskAccGets的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PDLMRiskInsuAcc")
	public List<PDLMRiskAccGet> getPDLMRiskAccGets() {
		return this.PDLMRiskAccGets;
	}

	/**
	 * 属性PDLMRiskAccGets的setter方法
	 */
	public void setPDLMRiskAccGets(List<PDLMRiskAccGet> PDLMRiskAccGets) {
		this.PDLMRiskAccGets = PDLMRiskAccGets;
	}

	/**
	 * 属性PDLMRiskToAccs的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PDLMRiskInsuAcc")
	public List<PDLMRiskToAcc> getPDLMRiskToAccs() {
		return this.PDLMRiskToAccs;
	}

	/**
	 * 属性PDLMRiskToAccs的setter方法
	 */
	public void setPDLMRiskToAccs(List<PDLMRiskToAcc> PDLMRiskToAccs) {
		this.PDLMRiskToAccs = PDLMRiskToAccs;
	}

}
