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
 * POJO类PDLMEdorZT1
 */
@Entity
@Table(name = "PD_LMEDORZT1")
public class PDLMEdorZT1 implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性序号 */
	private PDLMEdorZT1Id id;

	/** 属性算法编码 */
	private String cycPayCalCode;

	/** 属性退保生存金计算类型 */
	private String liveGetType;

	/** 属性死亡退保金计算类型 */
	private String deadGetType;

	/** 属性计算方式参考 */
	private String calCodeType;

	/** 属性退保年度计算类型 */
	private String ztYearType;

	/** 属性趸交算法编码（备用） */
	private String onePayCalCode;

	/** 属性趸缴时间间隔（备用） */
	private String onePayIntvType;

	/** 属性备用 */
	private String outGetType;

	/** 属性现金价值计算公式（备用） */
	private String cashValueCode;

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
	 * 类PDLMEdorZT1的默认构造方法
	 */
	public PDLMEdorZT1() {
	}

	/**
	 * 属性序号的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "riskCode", column = @Column(name = "RISKCODE")),
			@AttributeOverride(name = "dutyCode", column = @Column(name = "DUTYCODE")),
			@AttributeOverride(name = "payPlanCode", column = @Column(name = "PAYPLANCODE")),
			@AttributeOverride(name = "surrCalType", column = @Column(name = "SURRCALTYPE")),
			@AttributeOverride(name = "cycPayIntvType", column = @Column(name = "CYCPAYINTVTYPE")) })
	public PDLMEdorZT1Id getId() {
		return this.id;
	}

	/**
	 * 属性序号的setter方法
	 */
	public void setId(PDLMEdorZT1Id id) {
		this.id = id;
	}

	/**
	 * 属性算法编码的getter方法
	 */

	@Column(name = "CYCPAYCALCODE")
	public String getCycPayCalCode() {
		return this.cycPayCalCode;
	}

	/**
	 * 属性算法编码的setter方法
	 */
	public void setCycPayCalCode(String cycPayCalCode) {
		this.cycPayCalCode = cycPayCalCode;
	}

	/**
	 * 属性退保生存金计算类型的getter方法
	 */

	@Column(name = "LIVEGETTYPE")
	public String getLiveGetType() {
		return this.liveGetType;
	}

	/**
	 * 属性退保生存金计算类型的setter方法
	 */
	public void setLiveGetType(String liveGetType) {
		this.liveGetType = liveGetType;
	}

	/**
	 * 属性死亡退保金计算类型的getter方法
	 */

	@Column(name = "DEADGETTYPE")
	public String getDeadGetType() {
		return this.deadGetType;
	}

	/**
	 * 属性死亡退保金计算类型的setter方法
	 */
	public void setDeadGetType(String deadGetType) {
		this.deadGetType = deadGetType;
	}

	/**
	 * 属性计算方式参考的getter方法
	 */

	@Column(name = "CALCODETYPE")
	public String getCalCodeType() {
		return this.calCodeType;
	}

	/**
	 * 属性计算方式参考的setter方法
	 */
	public void setCalCodeType(String calCodeType) {
		this.calCodeType = calCodeType;
	}

	/**
	 * 属性退保年度计算类型的getter方法
	 */

	@Column(name = "ZTYEARTYPE")
	public String getZtYearType() {
		return this.ztYearType;
	}

	/**
	 * 属性退保年度计算类型的setter方法
	 */
	public void setZtYearType(String ztYearType) {
		this.ztYearType = ztYearType;
	}

	/**
	 * 属性趸交算法编码（备用）的getter方法
	 */

	@Column(name = "ONEPAYCALCODE")
	public String getOnePayCalCode() {
		return this.onePayCalCode;
	}

	/**
	 * 属性趸交算法编码（备用）的setter方法
	 */
	public void setOnePayCalCode(String onePayCalCode) {
		this.onePayCalCode = onePayCalCode;
	}

	/**
	 * 属性趸缴时间间隔（备用）的getter方法
	 */

	@Column(name = "ONEPAYINTVTYPE")
	public String getOnePayIntvType() {
		return this.onePayIntvType;
	}

	/**
	 * 属性趸缴时间间隔（备用）的setter方法
	 */
	public void setOnePayIntvType(String onePayIntvType) {
		this.onePayIntvType = onePayIntvType;
	}

	/**
	 * 属性备用的getter方法
	 */

	@Column(name = "OUTGETTYPE")
	public String getOutGetType() {
		return this.outGetType;
	}

	/**
	 * 属性备用的setter方法
	 */
	public void setOutGetType(String outGetType) {
		this.outGetType = outGetType;
	}

	/**
	 * 属性现金价值计算公式（备用）的getter方法
	 */

	@Column(name = "CASHVALUECODE")
	public String getCashValueCode() {
		return this.cashValueCode;
	}

	/**
	 * 属性现金价值计算公式（备用）的setter方法
	 */
	public void setCashValueCode(String cashValueCode) {
		this.cashValueCode = cashValueCode;
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
