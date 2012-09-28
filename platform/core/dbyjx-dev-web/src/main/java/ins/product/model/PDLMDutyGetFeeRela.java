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
 * POJO类PDLMDutyGetFeeRela
 */
@Entity
@Table(name = "PD_LMDUTYGETFEERELA")
public class PDLMDutyGetFeeRela implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性序号 */
	private PDLMDutyGetFeeRelaId id;

	/** 属性给付名称 */
	private String getDutyName;

	/** 属性账单项目名称 */
	private String feeName;

	/** 属性费用计算方式 */
	private String clmFeeCalType;

	/** 属性费用明细计算公式 */
	private String clmFeeCalCode;

	/** 属性费用默认值 */
	private String clmFeeDefValue;

	/** 属性每日限额控制方式 */
	private String dayFeeMAXCtrl;

	/** 属性每日限额计算公式 */
	private String dayFeeMaxCalCode;

	/** 属性每日限额固定值 */
	private BigDecimal dayFeeMaxValue;

	/** 属性总限额控制方式 */
	private String totalFeeMaxCtrl;

	/** 属性总限额计算公式 */
	private String totalFeeMaxCalCode;

	/** 属性总限额固定值 */
	private BigDecimal totalFeeMaxValue;

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
	 * 类PDLMDutyGetFeeRela的默认构造方法
	 */
	public PDLMDutyGetFeeRela() {
	}

	/**
	 * 属性序号的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "getDutyCode", column = @Column(name = "GETDUTYCODE")),
			@AttributeOverride(name = "getDutyKind", column = @Column(name = "GETDUTYKIND")),
			@AttributeOverride(name = "feecode", column = @Column(name = "FEECODE")) })
	public PDLMDutyGetFeeRelaId getId() {
		return this.id;
	}

	/**
	 * 属性序号的setter方法
	 */
	public void setId(PDLMDutyGetFeeRelaId id) {
		this.id = id;
	}

	/**
	 * 属性给付名称的getter方法
	 */

	@Column(name = "GETDUTYNAME")
	public String getGetDutyName() {
		return this.getDutyName;
	}

	/**
	 * 属性给付名称的setter方法
	 */
	public void setGetDutyName(String getDutyName) {
		this.getDutyName = getDutyName;
	}

	/**
	 * 属性账单项目名称的getter方法
	 */

	@Column(name = "FEENAME")
	public String getFeeName() {
		return this.feeName;
	}

	/**
	 * 属性账单项目名称的setter方法
	 */
	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}

	/**
	 * 属性费用计算方式的getter方法
	 */

	@Column(name = "CLMFEECALTYPE")
	public String getClmFeeCalType() {
		return this.clmFeeCalType;
	}

	/**
	 * 属性费用计算方式的setter方法
	 */
	public void setClmFeeCalType(String clmFeeCalType) {
		this.clmFeeCalType = clmFeeCalType;
	}

	/**
	 * 属性费用明细计算公式的getter方法
	 */

	@Column(name = "CLMFEECALCODE")
	public String getClmFeeCalCode() {
		return this.clmFeeCalCode;
	}

	/**
	 * 属性费用明细计算公式的setter方法
	 */
	public void setClmFeeCalCode(String clmFeeCalCode) {
		this.clmFeeCalCode = clmFeeCalCode;
	}

	/**
	 * 属性费用默认值的getter方法
	 */

	@Column(name = "CLMFEEDEFVALUE")
	public String getClmFeeDefValue() {
		return this.clmFeeDefValue;
	}

	/**
	 * 属性费用默认值的setter方法
	 */
	public void setClmFeeDefValue(String clmFeeDefValue) {
		this.clmFeeDefValue = clmFeeDefValue;
	}

	/**
	 * 属性每日限额控制方式的getter方法
	 */

	@Column(name = "DAYFEEMAXCTRL")
	public String getDayFeeMAXCtrl() {
		return this.dayFeeMAXCtrl;
	}

	/**
	 * 属性每日限额控制方式的setter方法
	 */
	public void setDayFeeMAXCtrl(String dayFeeMAXCtrl) {
		this.dayFeeMAXCtrl = dayFeeMAXCtrl;
	}

	/**
	 * 属性每日限额计算公式的getter方法
	 */

	@Column(name = "DAYFEEMAXCALCODE")
	public String getDayFeeMaxCalCode() {
		return this.dayFeeMaxCalCode;
	}

	/**
	 * 属性每日限额计算公式的setter方法
	 */
	public void setDayFeeMaxCalCode(String dayFeeMaxCalCode) {
		this.dayFeeMaxCalCode = dayFeeMaxCalCode;
	}

	/**
	 * 属性每日限额固定值的getter方法
	 */

	@Column(name = "DAYFEEMAXVALUE")
	public BigDecimal getDayFeeMaxValue() {
		return this.dayFeeMaxValue;
	}

	/**
	 * 属性每日限额固定值的setter方法
	 */
	public void setDayFeeMaxValue(BigDecimal dayFeeMaxValue) {
		this.dayFeeMaxValue = dayFeeMaxValue;
	}

	/**
	 * 属性总限额控制方式的getter方法
	 */

	@Column(name = "TOTALFEEMAXCTRL")
	public String getTotalFeeMaxCtrl() {
		return this.totalFeeMaxCtrl;
	}

	/**
	 * 属性总限额控制方式的setter方法
	 */
	public void setTotalFeeMaxCtrl(String totalFeeMaxCtrl) {
		this.totalFeeMaxCtrl = totalFeeMaxCtrl;
	}

	/**
	 * 属性总限额计算公式的getter方法
	 */

	@Column(name = "TOTALFEEMAXCALCODE")
	public String getTotalFeeMaxCalCode() {
		return this.totalFeeMaxCalCode;
	}

	/**
	 * 属性总限额计算公式的setter方法
	 */
	public void setTotalFeeMaxCalCode(String totalFeeMaxCalCode) {
		this.totalFeeMaxCalCode = totalFeeMaxCalCode;
	}

	/**
	 * 属性总限额固定值的getter方法
	 */

	@Column(name = "TOTALFEEMAXVALUE")
	public BigDecimal getTotalFeeMaxValue() {
		return this.totalFeeMaxValue;
	}

	/**
	 * 属性总限额固定值的setter方法
	 */
	public void setTotalFeeMaxValue(BigDecimal totalFeeMaxValue) {
		this.totalFeeMaxValue = totalFeeMaxValue;
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
