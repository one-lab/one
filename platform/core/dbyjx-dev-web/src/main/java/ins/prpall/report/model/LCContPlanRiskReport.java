package ins.prpall.report.model;

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
 * POJO类LCContPlanRiskReport
 */
@Entity
@Table(name = "LCCONTPLANRISKREPORT")
public class LCContPlanRiskReport implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性序号 */
	private LCContPlanRiskReportId id;

	/** 属性呈报申请人 */
	private String repOperator;

	/** 属性呈报申请日期 */
	private Date repApplyDate;

	/** 属性集体合同号码 */
	private String grpContNo;

	/** 属性主险险种版本 */
	private String mainRiskVersion;

	/** 属性险种版本 */
	private String riskVersion;

	/** 属性保险计划名称 */
	private String contPlanName;

	/** 属性描述 */
	private String remark;

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

	/** 属性RiskPrem */
	private BigDecimal riskPrem;

	/** 属性SysContPlanCode */
	private String sysContPlanCode;

	/** 属性SysContPlanMult */
	private BigDecimal sysContPlanMult;

	/** 属性SysContPlanRate */
	private BigDecimal sysContPlanRate;

	/**
	 * 类LCContPlanRiskReport的默认构造方法
	 */
	public LCContPlanRiskReport() {
	}

	/**
	 * 属性序号的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "repNo", column = @Column(name = "REPNO")),
			@AttributeOverride(name = "proposalGrpContNo", column = @Column(name = "PROPOSALGRPCONTNO")),
			@AttributeOverride(name = "mainRiskCode", column = @Column(name = "MAINRISKCODE")),
			@AttributeOverride(name = "riskCode", column = @Column(name = "RISKCODE")),
			@AttributeOverride(name = "contPlanCode", column = @Column(name = "CONTPLANCODE")),
			@AttributeOverride(name = "planType", column = @Column(name = "PLANTYPE")) })
	public LCContPlanRiskReportId getId() {
		return this.id;
	}

	/**
	 * 属性序号的setter方法
	 */
	public void setId(LCContPlanRiskReportId id) {
		this.id = id;
	}

	/**
	 * 属性呈报申请人的getter方法
	 */

	@Column(name = "REPOPERATOR")
	public String getRepOperator() {
		return this.repOperator;
	}

	/**
	 * 属性呈报申请人的setter方法
	 */
	public void setRepOperator(String repOperator) {
		this.repOperator = repOperator;
	}

	/**
	 * 属性呈报申请日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "REPAPPLYDATE")
	public Date getRepApplyDate() {
		return this.repApplyDate;
	}

	/**
	 * 属性呈报申请日期的setter方法
	 */
	public void setRepApplyDate(Date repApplyDate) {
		this.repApplyDate = repApplyDate;
	}

	/**
	 * 属性集体合同号码的getter方法
	 */

	@Column(name = "GRPCONTNO")
	public String getGrpContNo() {
		return this.grpContNo;
	}

	/**
	 * 属性集体合同号码的setter方法
	 */
	public void setGrpContNo(String grpContNo) {
		this.grpContNo = grpContNo;
	}

	/**
	 * 属性主险险种版本的getter方法
	 */

	@Column(name = "MAINRISKVERSION")
	public String getMainRiskVersion() {
		return this.mainRiskVersion;
	}

	/**
	 * 属性主险险种版本的setter方法
	 */
	public void setMainRiskVersion(String mainRiskVersion) {
		this.mainRiskVersion = mainRiskVersion;
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
	 * 属性保险计划名称的getter方法
	 */

	@Column(name = "CONTPLANNAME")
	public String getContPlanName() {
		return this.contPlanName;
	}

	/**
	 * 属性保险计划名称的setter方法
	 */
	public void setContPlanName(String contPlanName) {
		this.contPlanName = contPlanName;
	}

	/**
	 * 属性描述的getter方法
	 */

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	/**
	 * 属性描述的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
	 * 属性RiskPrem的getter方法
	 */

	@Column(name = "RISKPREM")
	public BigDecimal getRiskPrem() {
		return this.riskPrem;
	}

	/**
	 * 属性RiskPrem的setter方法
	 */
	public void setRiskPrem(BigDecimal riskPrem) {
		this.riskPrem = riskPrem;
	}

	/**
	 * 属性SysContPlanCode的getter方法
	 */

	@Column(name = "SYSCONTPLANCODE")
	public String getSysContPlanCode() {
		return this.sysContPlanCode;
	}

	/**
	 * 属性SysContPlanCode的setter方法
	 */
	public void setSysContPlanCode(String sysContPlanCode) {
		this.sysContPlanCode = sysContPlanCode;
	}

	/**
	 * 属性SysContPlanMult的getter方法
	 */

	@Column(name = "SYSCONTPLANMULT")
	public BigDecimal getSysContPlanMult() {
		return this.sysContPlanMult;
	}

	/**
	 * 属性SysContPlanMult的setter方法
	 */
	public void setSysContPlanMult(BigDecimal sysContPlanMult) {
		this.sysContPlanMult = sysContPlanMult;
	}

	/**
	 * 属性SysContPlanRate的getter方法
	 */

	@Column(name = "SYSCONTPLANRATE")
	public BigDecimal getSysContPlanRate() {
		return this.sysContPlanRate;
	}

	/**
	 * 属性SysContPlanRate的setter方法
	 */
	public void setSysContPlanRate(BigDecimal sysContPlanRate) {
		this.sysContPlanRate = sysContPlanRate;
	}

}
