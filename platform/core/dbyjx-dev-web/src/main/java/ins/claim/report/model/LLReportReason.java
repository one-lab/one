package ins.claim.report.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

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
 * POJO类LLReportReason
 */
@Entity
@Table(name = "LLREPORTREASON")
public class LLReportReason implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性id */
	private LLReportReasonId id;

	/** 属性类型 */
	private String reasonType;

	/** 属性原因 */
	private String reason;

	/** 属性材料齐备日期 */
	private Date affixGetDate;

	/** 属性管理机构 */
	private String mngCom;

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

	/** 属性理赔类型值 */
	private String reasonCodeValue;

	/**
	 * 类LLReportReason的默认构造方法
	 */
	public LLReportReason() {
	}

	/**
	 * 属性id的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "rpNo", column = @Column(name = "RPNO")),
			@AttributeOverride(name = "customerNo", column = @Column(name = "CUSTOMERNO")),
			@AttributeOverride(name = "reasonCode", column = @Column(name = "REASONCODE")),
			@AttributeOverride(name = "subRptNo", column = @Column(name = "SUBRPTNO")) })
	public LLReportReasonId getId() {
		return this.id;
	}

	/**
	 * 属性id的setter方法
	 */
	public void setId(LLReportReasonId id) {
		this.id = id;
	}

	/**
	 * 属性类型的getter方法
	 */

	@Column(name = "REASONTYPE")
	public String getReasonType() {
		return this.reasonType;
	}

	/**
	 * 属性类型的setter方法
	 */
	public void setReasonType(String reasonType) {
		this.reasonType = reasonType;
	}

	/**
	 * 属性原因的getter方法
	 */

	@Column(name = "REASON")
	public String getReason() {
		return this.reason;
	}

	/**
	 * 属性原因的setter方法
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * 属性材料齐备日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "AFFIXGETDATE")
	public Date getAffixGetDate() {
		return this.affixGetDate;
	}

	/**
	 * 属性材料齐备日期的setter方法
	 */
	public void setAffixGetDate(Date affixGetDate) {
		this.affixGetDate = affixGetDate;
	}

	/**
	 * 属性管理机构的getter方法
	 */

	@Column(name = "MNGCOM")
	public String getMngCom() {
		return this.mngCom;
	}

	/**
	 * 属性管理机构的setter方法
	 */
	public void setMngCom(String mngCom) {
		this.mngCom = mngCom;
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
	 * 属性理赔类型值的getter方法
	 */

	@Column(name = "REASONCODEVALUE")
	public String getReasonCodeValue() {
		return this.reasonCodeValue;
	}

	/**
	 * 属性理赔类型值的setter方法
	 */
	public void setReasonCodeValue(String reasonCodeValue) {
		this.reasonCodeValue = reasonCodeValue;
	}

}
