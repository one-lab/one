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
 * POJO类PDLMClaimCtrlFee
 */
@Entity
@Table(name = "PD_LMCLAIMCTRLFEE")
public class PDLMClaimCtrlFee implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性理赔控制编号 */
	private String claimCtrlCode;

	/** 属性起始费用 */
	private BigDecimal clmFeeMIN;

	/** 属性起始费用单位 */
	private String clmFeeMINFlag;

	/** 属性费用期间间隔 */
	private BigDecimal clmFeeInterval;

	/** 属性费用期间间隔单位 */
	private String clmFeeFlag;

	/** 属性赔付金额计算SQL */
	private String calCode2;

	/** 属性理赔控制处理值类型 */
	private String calResultType;

	/** 属性理赔控制默认值 */
	private BigDecimal defaultValue;

	/** 属性理赔控制计算方式 */
	private String calCtrlFlag;

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
	 * 类PDLMClaimCtrlFee的默认构造方法
	 */
	public PDLMClaimCtrlFee() {
	}

	/**
	 * 属性理赔控制编号的getter方法
	 */
	@Id
	@Column(name = "CLAIMCTRLCODE")
	public String getClaimCtrlCode() {
		return this.claimCtrlCode;
	}

	/**
	 * 属性理赔控制编号的setter方法
	 */
	public void setClaimCtrlCode(String claimCtrlCode) {
		this.claimCtrlCode = claimCtrlCode;
	}

	/**
	 * 属性起始费用的getter方法
	 */

	@Column(name = "CLMFEEMIN")
	public BigDecimal getClmFeeMIN() {
		return this.clmFeeMIN;
	}

	/**
	 * 属性起始费用的setter方法
	 */
	public void setClmFeeMIN(BigDecimal clmFeeMIN) {
		this.clmFeeMIN = clmFeeMIN;
	}

	/**
	 * 属性起始费用单位的getter方法
	 */

	@Column(name = "CLMFEEMINFLAG")
	public String getClmFeeMINFlag() {
		return this.clmFeeMINFlag;
	}

	/**
	 * 属性起始费用单位的setter方法
	 */
	public void setClmFeeMINFlag(String clmFeeMINFlag) {
		this.clmFeeMINFlag = clmFeeMINFlag;
	}

	/**
	 * 属性费用期间间隔的getter方法
	 */

	@Column(name = "CLMFEEINTERVAL")
	public BigDecimal getClmFeeInterval() {
		return this.clmFeeInterval;
	}

	/**
	 * 属性费用期间间隔的setter方法
	 */
	public void setClmFeeInterval(BigDecimal clmFeeInterval) {
		this.clmFeeInterval = clmFeeInterval;
	}

	/**
	 * 属性费用期间间隔单位的getter方法
	 */

	@Column(name = "CLMFEEFLAG")
	public String getClmFeeFlag() {
		return this.clmFeeFlag;
	}

	/**
	 * 属性费用期间间隔单位的setter方法
	 */
	public void setClmFeeFlag(String clmFeeFlag) {
		this.clmFeeFlag = clmFeeFlag;
	}

	/**
	 * 属性赔付金额计算SQL的getter方法
	 */

	@Column(name = "CALCODE2")
	public String getCalCode2() {
		return this.calCode2;
	}

	/**
	 * 属性赔付金额计算SQL的setter方法
	 */
	public void setCalCode2(String calCode2) {
		this.calCode2 = calCode2;
	}

	/**
	 * 属性理赔控制处理值类型的getter方法
	 */

	@Column(name = "CALRESULTTYPE")
	public String getCalResultType() {
		return this.calResultType;
	}

	/**
	 * 属性理赔控制处理值类型的setter方法
	 */
	public void setCalResultType(String calResultType) {
		this.calResultType = calResultType;
	}

	/**
	 * 属性理赔控制默认值的getter方法
	 */

	@Column(name = "DEFAULTVALUE")
	public BigDecimal getDefaultValue() {
		return this.defaultValue;
	}

	/**
	 * 属性理赔控制默认值的setter方法
	 */
	public void setDefaultValue(BigDecimal defaultValue) {
		this.defaultValue = defaultValue;
	}

	/**
	 * 属性理赔控制计算方式的getter方法
	 */

	@Column(name = "CALCTRLFLAG")
	public String getCalCtrlFlag() {
		return this.calCtrlFlag;
	}

	/**
	 * 属性理赔控制计算方式的setter方法
	 */
	public void setCalCtrlFlag(String calCtrlFlag) {
		this.calCtrlFlag = calCtrlFlag;
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
