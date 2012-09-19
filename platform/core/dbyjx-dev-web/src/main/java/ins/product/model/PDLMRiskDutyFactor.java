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
 * POJO类PDLMRiskDutyFactor
 */
@Entity
@Table(name = "PD_LMRISKDUTYFACTOR")
public class PDLMRiskDutyFactor implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性序号 */
	private PDLMRiskDutyFactorId id;

	/** 属性要素名称 */
	private String factorName;

	/** 属性计划要素类型 */
	private String calFactorType;

	/** 属性算法内容 */
	private String calSQL;

	/** 属性可选属性 */
	private String chooseFlag;

	/** 属性要素描述 */
	private String factorNoti;

	/** 属性要素顺序 */
	private BigDecimal factorOrder;

	/** 属性缴费编码 */
	private String payPlanCode;

	/** 属性给付代码 */
	private String getDutyCode;

	/** 属性保险帐户号码 */
	private String insuAccNo;

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

	/** 属性组合要素代码 */
	private String comFactorCode;

	/** 属性组合要素名 */
	private String comFactorName;

	/** 属性责任页面要素类型 */
	private String dhtmlType;

	/**
	 * 类PDLMRiskDutyFactor的默认构造方法
	 */
	public PDLMRiskDutyFactor() {
	}

	/**
	 * 属性序号的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "riskCode", column = @Column(name = "RISKCODE")),
			@AttributeOverride(name = "dutyCode", column = @Column(name = "DUTYCODE")),
			@AttributeOverride(name = "calFactor", column = @Column(name = "CALFACTOR")) })
	public PDLMRiskDutyFactorId getId() {
		return this.id;
	}

	/**
	 * 属性序号的setter方法
	 */
	public void setId(PDLMRiskDutyFactorId id) {
		this.id = id;
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
	 * 属性计划要素类型的getter方法
	 */

	@Column(name = "CALFACTORTYPE")
	public String getCalFactorType() {
		return this.calFactorType;
	}

	/**
	 * 属性计划要素类型的setter方法
	 */
	public void setCalFactorType(String calFactorType) {
		this.calFactorType = calFactorType;
	}

	/**
	 * 属性算法内容的getter方法
	 */

	@Column(name = "CALSQL")
	public String getCalSQL() {
		return this.calSQL;
	}

	/**
	 * 属性算法内容的setter方法
	 */
	public void setCalSQL(String calSQL) {
		this.calSQL = calSQL;
	}

	/**
	 * 属性可选属性的getter方法
	 */

	@Column(name = "CHOOSEFLAG")
	public String getChooseFlag() {
		return this.chooseFlag;
	}

	/**
	 * 属性可选属性的setter方法
	 */
	public void setChooseFlag(String chooseFlag) {
		this.chooseFlag = chooseFlag;
	}

	/**
	 * 属性要素描述的getter方法
	 */

	@Column(name = "FACTORNOTI")
	public String getFactorNoti() {
		return this.factorNoti;
	}

	/**
	 * 属性要素描述的setter方法
	 */
	public void setFactorNoti(String factorNoti) {
		this.factorNoti = factorNoti;
	}

	/**
	 * 属性要素顺序的getter方法
	 */

	@Column(name = "FACTORORDER")
	public BigDecimal getFactorOrder() {
		return this.factorOrder;
	}

	/**
	 * 属性要素顺序的setter方法
	 */
	public void setFactorOrder(BigDecimal factorOrder) {
		this.factorOrder = factorOrder;
	}

	/**
	 * 属性缴费编码的getter方法
	 */

	@Column(name = "PAYPLANCODE")
	public String getPayPlanCode() {
		return this.payPlanCode;
	}

	/**
	 * 属性缴费编码的setter方法
	 */
	public void setPayPlanCode(String payPlanCode) {
		this.payPlanCode = payPlanCode;
	}

	/**
	 * 属性给付代码的getter方法
	 */

	@Column(name = "GETDUTYCODE")
	public String getGetDutyCode() {
		return this.getDutyCode;
	}

	/**
	 * 属性给付代码的setter方法
	 */
	public void setGetDutyCode(String getDutyCode) {
		this.getDutyCode = getDutyCode;
	}

	/**
	 * 属性保险帐户号码的getter方法
	 */

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
	 * 属性组合要素代码的getter方法
	 */

	@Column(name = "COMFACTORCODE")
	public String getComFactorCode() {
		return this.comFactorCode;
	}

	/**
	 * 属性组合要素代码的setter方法
	 */
	public void setComFactorCode(String comFactorCode) {
		this.comFactorCode = comFactorCode;
	}

	/**
	 * 属性组合要素名的getter方法
	 */

	@Column(name = "COMFACTORNAME")
	public String getComFactorName() {
		return this.comFactorName;
	}

	/**
	 * 属性组合要素名的setter方法
	 */
	public void setComFactorName(String comFactorName) {
		this.comFactorName = comFactorName;
	}

	/**
	 * 属性责任页面要素类型的getter方法
	 */

	@Column(name = "DHTMLTYPE")
	public String getDhtmlType() {
		return this.dhtmlType;
	}

	/**
	 * 属性责任页面要素类型的setter方法
	 */
	public void setDhtmlType(String dhtmlType) {
		this.dhtmlType = dhtmlType;
	}

}
