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
 * POJO类PDLMClaimCtrl
 */
@Entity
@Table(name = "PD_LMCLAIMCTRL")
public class PDLMClaimCtrl implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性理赔控制编号 */
	private String claimCtrlCode;

	/** 属性理赔控制名称 */
	private String claimCtrlName;

	/** 属性类型 */
	private String claimCtrlType;

	/** 属性理赔控制描述 */
	private String claimEngineDesc;

	/** 属性有效期间 */
	private String periodFlag;

	/** 属性自定义期间标记 */
	private String defPeriodFlag;

	/** 属性个人家庭标记 */
	private String familyFlag;

	/** 属性保单有效期/内外 */
	private String insPeriodFlag;

	/** 属性赔付期间控制上限 */
	private BigDecimal clmPeriodMAX;

	/** 属性赔付期间上限单位 */
	private String clmPeriodMAXFlag;

	/** 属性赔付期间上限控制计算参考 */
	private String clmPeriodMAXCtrl;

	/** 属性赔付期间下限控制 */
	private BigDecimal clmPeriodMIN;

	/** 属性赔付期间下限控制单位 */
	private String clmPeriodMINFlag;

	/** 属性赔付期间下限控制计算参考 */
	private String clmPeriodMINCtrl;

	/** 属性佣金计算编码 */
	private String calCode;

	/** 属性理赔控制处理值类型 */
	private String calResultType;

	/** 属性理赔控制默认值 */
	private BigDecimal defaultValue;

	/** 属性理赔控制计算方式 */
	private String calCtrlFlag;

	/** 属性理赔费用控制计算SQL */
	private String feeCalCode;

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
	 * 类PDLMClaimCtrl的默认构造方法
	 */
	public PDLMClaimCtrl() {
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
	 * 属性理赔控制名称的getter方法
	 */

	@Column(name = "CLAIMCTRLNAME")
	public String getClaimCtrlName() {
		return this.claimCtrlName;
	}

	/**
	 * 属性理赔控制名称的setter方法
	 */
	public void setClaimCtrlName(String claimCtrlName) {
		this.claimCtrlName = claimCtrlName;
	}

	/**
	 * 属性类型的getter方法
	 */

	@Column(name = "CLAIMCTRLTYPE")
	public String getClaimCtrlType() {
		return this.claimCtrlType;
	}

	/**
	 * 属性类型的setter方法
	 */
	public void setClaimCtrlType(String claimCtrlType) {
		this.claimCtrlType = claimCtrlType;
	}

	/**
	 * 属性理赔控制描述的getter方法
	 */

	@Column(name = "CLAIMENGINEDESC")
	public String getClaimEngineDesc() {
		return this.claimEngineDesc;
	}

	/**
	 * 属性理赔控制描述的setter方法
	 */
	public void setClaimEngineDesc(String claimEngineDesc) {
		this.claimEngineDesc = claimEngineDesc;
	}

	/**
	 * 属性有效期间的getter方法
	 */

	@Column(name = "PERIODFLAG")
	public String getPeriodFlag() {
		return this.periodFlag;
	}

	/**
	 * 属性有效期间的setter方法
	 */
	public void setPeriodFlag(String periodFlag) {
		this.periodFlag = periodFlag;
	}

	/**
	 * 属性自定义期间标记的getter方法
	 */

	@Column(name = "DEFPERIODFLAG")
	public String getDefPeriodFlag() {
		return this.defPeriodFlag;
	}

	/**
	 * 属性自定义期间标记的setter方法
	 */
	public void setDefPeriodFlag(String defPeriodFlag) {
		this.defPeriodFlag = defPeriodFlag;
	}

	/**
	 * 属性个人家庭标记的getter方法
	 */

	@Column(name = "FAMILYFLAG")
	public String getFamilyFlag() {
		return this.familyFlag;
	}

	/**
	 * 属性个人家庭标记的setter方法
	 */
	public void setFamilyFlag(String familyFlag) {
		this.familyFlag = familyFlag;
	}

	/**
	 * 属性保单有效期/内外的getter方法
	 */

	@Column(name = "INSPERIODFLAG")
	public String getInsPeriodFlag() {
		return this.insPeriodFlag;
	}

	/**
	 * 属性保单有效期/内外的setter方法
	 */
	public void setInsPeriodFlag(String insPeriodFlag) {
		this.insPeriodFlag = insPeriodFlag;
	}

	/**
	 * 属性赔付期间控制上限的getter方法
	 */

	@Column(name = "CLMPERIODMAX")
	public BigDecimal getClmPeriodMAX() {
		return this.clmPeriodMAX;
	}

	/**
	 * 属性赔付期间控制上限的setter方法
	 */
	public void setClmPeriodMAX(BigDecimal clmPeriodMAX) {
		this.clmPeriodMAX = clmPeriodMAX;
	}

	/**
	 * 属性赔付期间上限单位的getter方法
	 */

	@Column(name = "CLMPERIODMAXFLAG")
	public String getClmPeriodMAXFlag() {
		return this.clmPeriodMAXFlag;
	}

	/**
	 * 属性赔付期间上限单位的setter方法
	 */
	public void setClmPeriodMAXFlag(String clmPeriodMAXFlag) {
		this.clmPeriodMAXFlag = clmPeriodMAXFlag;
	}

	/**
	 * 属性赔付期间上限控制计算参考的getter方法
	 */

	@Column(name = "CLMPERIODMAXCTRL")
	public String getClmPeriodMAXCtrl() {
		return this.clmPeriodMAXCtrl;
	}

	/**
	 * 属性赔付期间上限控制计算参考的setter方法
	 */
	public void setClmPeriodMAXCtrl(String clmPeriodMAXCtrl) {
		this.clmPeriodMAXCtrl = clmPeriodMAXCtrl;
	}

	/**
	 * 属性赔付期间下限控制的getter方法
	 */

	@Column(name = "CLMPERIODMIN")
	public BigDecimal getClmPeriodMIN() {
		return this.clmPeriodMIN;
	}

	/**
	 * 属性赔付期间下限控制的setter方法
	 */
	public void setClmPeriodMIN(BigDecimal clmPeriodMIN) {
		this.clmPeriodMIN = clmPeriodMIN;
	}

	/**
	 * 属性赔付期间下限控制单位的getter方法
	 */

	@Column(name = "CLMPERIODMINFLAG")
	public String getClmPeriodMINFlag() {
		return this.clmPeriodMINFlag;
	}

	/**
	 * 属性赔付期间下限控制单位的setter方法
	 */
	public void setClmPeriodMINFlag(String clmPeriodMINFlag) {
		this.clmPeriodMINFlag = clmPeriodMINFlag;
	}

	/**
	 * 属性赔付期间下限控制计算参考的getter方法
	 */

	@Column(name = "CLMPERIODMINCTRL")
	public String getClmPeriodMINCtrl() {
		return this.clmPeriodMINCtrl;
	}

	/**
	 * 属性赔付期间下限控制计算参考的setter方法
	 */
	public void setClmPeriodMINCtrl(String clmPeriodMINCtrl) {
		this.clmPeriodMINCtrl = clmPeriodMINCtrl;
	}

	/**
	 * 属性佣金计算编码的getter方法
	 */

	@Column(name = "CALCODE")
	public String getCalCode() {
		return this.calCode;
	}

	/**
	 * 属性佣金计算编码的setter方法
	 */
	public void setCalCode(String calCode) {
		this.calCode = calCode;
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
	 * 属性理赔费用控制计算SQL的getter方法
	 */

	@Column(name = "FEECALCODE")
	public String getFeeCalCode() {
		return this.feeCalCode;
	}

	/**
	 * 属性理赔费用控制计算SQL的setter方法
	 */
	public void setFeeCalCode(String feeCalCode) {
		this.feeCalCode = feeCalCode;
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
