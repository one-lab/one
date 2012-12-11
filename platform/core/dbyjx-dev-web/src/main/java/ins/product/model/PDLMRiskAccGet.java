package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * POJO类PDLMRiskAccGet
 */
@Entity
@Table(name = "PD_LMRISKACCGET")
public class PDLMRiskAccGet implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性序号 */
	private PDLMRiskAccGetId id;

	/** 属性险种定义 */
	private PDLMRisk PDLMRisk;

	/** 属性责任给付 */
	private PDLMDutyGet PDLMDutyGet;

	/** 属性险种保险帐户 */
	private PDLMRiskInsuAcc PDLMRiskInsuAcc;

	/** 属性险种版本 */
	private String riskVer;

	/** 属性默认比例 */
	private Double defaultRate;

	/** 属性是否需要录入 */
	private String needInput;

	/** 属性转出账户时的算法编码(现金) */
	private String calCodeMoney;

	/** 属性处理方向 */
	private String dealDirection;

	/** 属性账户转出计算标志 */
	private String calFlag;

	/** 属性账户产生位置 */
	private String accCreatePos;

	/** 属性给付名称 */
	private String getDutyName;

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
	 * 类PDLMRiskAccGet的默认构造方法
	 */
	public PDLMRiskAccGet() {
	}

	/**
	 * 属性序号的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "getDutyCode", column = @Column(name = "GETDUTYCODE")),
			@AttributeOverride(name = "insuAccNo", column = @Column(name = "INSUACCNO")),
			@AttributeOverride(name = "riskCode", column = @Column(name = "RISKCODE")) })
	public PDLMRiskAccGetId getId() {
		return this.id;
	}

	/**
	 * 属性序号的setter方法
	 */
	public void setId(PDLMRiskAccGetId id) {
		this.id = id;
	}

	/**
	 * 属性险种定义的getter方法
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RISKCODE", nullable = false, insertable = false, updatable = false)
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
	 * 属性责任给付的getter方法
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GETDUTYCODE", nullable = false, insertable = false, updatable = false)
	public PDLMDutyGet getPDLMDutyGet() {
		return this.PDLMDutyGet;
	}

	/**
	 * 属性责任给付的setter方法
	 */
	public void setPDLMDutyGet(PDLMDutyGet PDLMDutyGet) {
		this.PDLMDutyGet = PDLMDutyGet;
	}

	/**
	 * 属性险种保险帐户的getter方法
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INSUACCNO", nullable = false, insertable = false, updatable = false)
	public PDLMRiskInsuAcc getPDLMRiskInsuAcc() {
		return this.PDLMRiskInsuAcc;
	}

	/**
	 * 属性险种保险帐户的setter方法
	 */
	public void setPDLMRiskInsuAcc(PDLMRiskInsuAcc PDLMRiskInsuAcc) {
		this.PDLMRiskInsuAcc = PDLMRiskInsuAcc;
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
	 * 属性默认比例的getter方法
	 */

	@Column(name = "DEFAULTRATE")
	public Double getDefaultRate() {
		return this.defaultRate;
	}

	/**
	 * 属性默认比例的setter方法
	 */
	public void setDefaultRate(Double defaultRate) {
		this.defaultRate = defaultRate;
	}

	/**
	 * 属性是否需要录入的getter方法
	 */

	@Column(name = "NEEDINPUT")
	public String getNeedInput() {
		return this.needInput;
	}

	/**
	 * 属性是否需要录入的setter方法
	 */
	public void setNeedInput(String needInput) {
		this.needInput = needInput;
	}

	/**
	 * 属性转出账户时的算法编码(现金)的getter方法
	 */

	@Column(name = "CALCODEMONEY")
	public String getCalCodeMoney() {
		return this.calCodeMoney;
	}

	/**
	 * 属性转出账户时的算法编码(现金)的setter方法
	 */
	public void setCalCodeMoney(String calCodeMoney) {
		this.calCodeMoney = calCodeMoney;
	}

	/**
	 * 属性处理方向的getter方法
	 */

	@Column(name = "DEALDIRECTION")
	public String getDealDirection() {
		return this.dealDirection;
	}

	/**
	 * 属性处理方向的setter方法
	 */
	public void setDealDirection(String dealDirection) {
		this.dealDirection = dealDirection;
	}

	/**
	 * 属性账户转出计算标志的getter方法
	 */

	@Column(name = "CALFLAG")
	public String getCalFlag() {
		return this.calFlag;
	}

	/**
	 * 属性账户转出计算标志的setter方法
	 */
	public void setCalFlag(String calFlag) {
		this.calFlag = calFlag;
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
