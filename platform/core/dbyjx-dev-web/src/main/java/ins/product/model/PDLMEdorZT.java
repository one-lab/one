package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * POJO类PDLMEdorZT
 */
@Entity
@Table(name = "PD_LMEDORZT")
public class PDLMEdorZT implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性险种代码 */
	private String riskCode;

	/** 属性险种版本 */
	private String riskVersion;

	/** 属性期交是否允许通融退保 */
	private String cycFlag;

	/** 属性期交退保控制范围类型 */
	private String cycType;

	/** 属性期交退保控制范围，起点 */
	private BigDecimal cycStart;

	/** 属性期交退保控制范围，终点 */
	private BigDecimal cycEnd;

	/** 属性趸交是否允许通融退保 */
	private String onePayFlag;

	/** 属性趸交退保控制范围类型 */
	private String onePayType;

	/** 属性趸交退保控制范围起点 */
	private BigDecimal onePayStart;

	/** 属性趸交退保控制范围终点 */
	private BigDecimal onePayEnd;

	/** 属性补/退费财务类型 */
	private String feeFinalType;

	/** 属性加费是否退费标记 */
	private String addFeeBackFlag;

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
	 * 类PDLMEdorZT的默认构造方法
	 */
	public PDLMEdorZT() {
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
	 * 属性险种版本的getter方法
	 */

	@Column(name = "RISKVERSION")
	public String getRiskVersion() {
		return this.riskVersion;
	}

	/**
	 * 属性险种版本的setter方法
	 */
	public void setRiskVersion(String riskVersion) {
		this.riskVersion = riskVersion;
	}

	/**
	 * 属性期交是否允许通融退保的getter方法
	 */

	@Column(name = "CYCFLAG")
	public String getCycFlag() {
		return this.cycFlag;
	}

	/**
	 * 属性期交是否允许通融退保的setter方法
	 */
	public void setCycFlag(String cycFlag) {
		this.cycFlag = cycFlag;
	}

	/**
	 * 属性期交退保控制范围类型的getter方法
	 */

	@Column(name = "CYCTYPE")
	public String getCycType() {
		return this.cycType;
	}

	/**
	 * 属性期交退保控制范围类型的setter方法
	 */
	public void setCycType(String cycType) {
		this.cycType = cycType;
	}

	/**
	 * 属性期交退保控制范围，起点的getter方法
	 */

	@Column(name = "CYCSTART")
	public BigDecimal getCycStart() {
		return this.cycStart;
	}

	/**
	 * 属性期交退保控制范围，起点的setter方法
	 */
	public void setCycStart(BigDecimal cycStart) {
		this.cycStart = cycStart;
	}

	/**
	 * 属性期交退保控制范围，终点的getter方法
	 */

	@Column(name = "CYCEND")
	public BigDecimal getCycEnd() {
		return this.cycEnd;
	}

	/**
	 * 属性期交退保控制范围，终点的setter方法
	 */
	public void setCycEnd(BigDecimal cycEnd) {
		this.cycEnd = cycEnd;
	}

	/**
	 * 属性趸交是否允许通融退保的getter方法
	 */

	@Column(name = "ONEPAYFLAG")
	public String getOnePayFlag() {
		return this.onePayFlag;
	}

	/**
	 * 属性趸交是否允许通融退保的setter方法
	 */
	public void setOnePayFlag(String onePayFlag) {
		this.onePayFlag = onePayFlag;
	}

	/**
	 * 属性趸交退保控制范围类型的getter方法
	 */

	@Column(name = "ONEPAYTYPE")
	public String getOnePayType() {
		return this.onePayType;
	}

	/**
	 * 属性趸交退保控制范围类型的setter方法
	 */
	public void setOnePayType(String onePayType) {
		this.onePayType = onePayType;
	}

	/**
	 * 属性趸交退保控制范围起点的getter方法
	 */

	@Column(name = "ONEPAYSTART")
	public BigDecimal getOnePayStart() {
		return this.onePayStart;
	}

	/**
	 * 属性趸交退保控制范围起点的setter方法
	 */
	public void setOnePayStart(BigDecimal onePayStart) {
		this.onePayStart = onePayStart;
	}

	/**
	 * 属性趸交退保控制范围终点的getter方法
	 */

	@Column(name = "ONEPAYEND")
	public BigDecimal getOnePayEnd() {
		return this.onePayEnd;
	}

	/**
	 * 属性趸交退保控制范围终点的setter方法
	 */
	public void setOnePayEnd(BigDecimal onePayEnd) {
		this.onePayEnd = onePayEnd;
	}

	/**
	 * 属性补/退费财务类型的getter方法
	 */

	@Column(name = "FEEFINALTYPE")
	public String getFeeFinalType() {
		return this.feeFinalType;
	}

	/**
	 * 属性补/退费财务类型的setter方法
	 */
	public void setFeeFinalType(String feeFinalType) {
		this.feeFinalType = feeFinalType;
	}

	/**
	 * 属性加费是否退费标记的getter方法
	 */

	@Column(name = "ADDFEEBACKFLAG")
	public String getAddFeeBackFlag() {
		return this.addFeeBackFlag;
	}

	/**
	 * 属性加费是否退费标记的setter方法
	 */
	public void setAddFeeBackFlag(String addFeeBackFlag) {
		this.addFeeBackFlag = addFeeBackFlag;
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
