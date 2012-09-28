package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * POJO类PDLMRiskDuty
 */
@Entity
@Table(name = "PD_LMRISKDUTY")
public class PDLMRiskDuty implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性序号 */
	private PDLMRiskDutyId id;

	/** 属性险种定义 */
	private PDLMRisk PDLMRisk;

	/** 属性责任 */
	private PDLMDuty PDLMDuty;

	/** 属性险种版本 */
	private String riskVer;

	/** 属性选择标记 */
	private String choFlag;

	/** 属性特殊险种标记 */
	private String specFlag;

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
	
	/** 属性险种责任页面 */
	private String dhtml;
	

	/** 属性PDLMPolDutyEdotcals */
	private List<PDLMPolDutyEdotcal> PDLMPolDutyEdotcals = new ArrayList<PDLMPolDutyEdotcal>(
			0);

	/** 属性PDLMEdorBonusZTs */
	private List<PDLMEdorBonusZT> PDLMEdorBonusZTs = new ArrayList<PDLMEdorBonusZT>(
			0);

	/** 属性PDLMDutyPayAddFees */
	private List<PDLMDutyPayAddFee> PDLMDutyPayAddFees = new ArrayList<PDLMDutyPayAddFee>(
			0);

	/**
	 * 类PDLMRiskDuty的默认构造方法
	 */
	public PDLMRiskDuty() {
	}

	/**
	 * 属性序号的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "riskCode", column = @Column(name = "RISKCODE")),
			@AttributeOverride(name = "dutyCode", column = @Column(name = "DUTYCODE")) })
	public PDLMRiskDutyId getId() {
		return this.id;
	}

	/**
	 * 属性序号的setter方法
	 */
	public void setId(PDLMRiskDutyId id) {
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
	 * 属性责任的getter方法
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DUTYCODE", nullable = false, insertable = false, updatable = false)
	public PDLMDuty getPDLMDuty() {
		return this.PDLMDuty;
	}

	/**
	 * 属性责任的setter方法
	 */
	public void setPDLMDuty(PDLMDuty PDLMDuty) {
		this.PDLMDuty = PDLMDuty;
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
	 * 属性选择标记的getter方法
	 */

	@Column(name = "CHOFLAG")
	public String getChoFlag() {
		return this.choFlag;
	}

	/**
	 * 属性选择标记的setter方法
	 */
	public void setChoFlag(String choFlag) {
		this.choFlag = choFlag;
	}

	/**
	 * 属性特殊险种标记的getter方法
	 */

	@Column(name = "SPECFLAG")
	public String getSpecFlag() {
		return this.specFlag;
	}

	/**
	 * 属性特殊险种标记的setter方法
	 */
	public void setSpecFlag(String specFlag) {
		this.specFlag = specFlag;
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
	 * 属性PDLMPolDutyEdotcals的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PDLMRiskDuty")
	public List<PDLMPolDutyEdotcal> getPDLMPolDutyEdotcals() {
		return this.PDLMPolDutyEdotcals;
	}

	/**
	 * 属性PDLMPolDutyEdotcals的setter方法
	 */
	public void setPDLMPolDutyEdotcals(
			List<PDLMPolDutyEdotcal> PDLMPolDutyEdotcals) {
		this.PDLMPolDutyEdotcals = PDLMPolDutyEdotcals;
	}

	/**
	 * 属性PDLMEdorBonusZTs的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PDLMRiskDuty")
	public List<PDLMEdorBonusZT> getPDLMEdorBonusZTs() {
		return this.PDLMEdorBonusZTs;
	}

	/**
	 * 属性PDLMEdorBonusZTs的setter方法
	 */
	public void setPDLMEdorBonusZTs(List<PDLMEdorBonusZT> PDLMEdorBonusZTs) {
		this.PDLMEdorBonusZTs = PDLMEdorBonusZTs;
	}

	/**
	 * 属性PDLMDutyPayAddFees的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PDLMRiskDuty")
	public List<PDLMDutyPayAddFee> getPDLMDutyPayAddFees() {
		return this.PDLMDutyPayAddFees;
	}

	/**
	 * 属性PDLMDutyPayAddFees的setter方法
	 */
	public void setPDLMDutyPayAddFees(List<PDLMDutyPayAddFee> PDLMDutyPayAddFees) {
		this.PDLMDutyPayAddFees = PDLMDutyPayAddFees;
	}

	/**
	 * 属性险种责任页面的getter方法
	 */

	@Column(name = "DHTML")
	public String getDhtml() {
		return this.dhtml;
	}

	/**
	 * 属性险种责任页面的setter方法
	 */
	public void setDhtml(String dhtml) {
		this.dhtml = dhtml;
	}

	
}
