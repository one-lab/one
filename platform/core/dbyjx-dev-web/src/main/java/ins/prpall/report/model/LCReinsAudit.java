package ins.prpall.report.model;

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
 * POJO类LCReinsAudit
 */
@Entity
@Table(name = "LCREINSAUDIT")
public class LCReinsAudit implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性序号 */
	private LCReinsAuditId id;

	/** 属性精算审核员 */
	private String repAuditOperator;

	/** 属性精算审核意见 */
	private String repAuditIdea;

	/** 属性管理机构 */
	private String manageCom;

	/** 属性入机日期 */
	private Date makeDate;

	/** 属性入机时间 */
	private String makeTime;

	/** 属性最后一次修改日期 */
	private Date modifyDate;

	/** 属性最后一次修改时间 */
	private String modifyTime;

	/**
	 * 类LCReinsAudit的默认构造方法
	 */
	public LCReinsAudit() {
	}

	/**
	 * 属性序号的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "repNo", column = @Column(name = "REPNO")),
			@AttributeOverride(name = "serialNo", column = @Column(name = "SERIALNO")) })
	public LCReinsAuditId getId() {
		return this.id;
	}

	/**
	 * 属性序号的setter方法
	 */
	public void setId(LCReinsAuditId id) {
		this.id = id;
	}

	/**
	 * 属性精算审核员的getter方法
	 */

	@Column(name = "REPAUDITOPERATOR")
	public String getRepAuditOperator() {
		return this.repAuditOperator;
	}

	/**
	 * 属性精算审核员的setter方法
	 */
	public void setRepAuditOperator(String repAuditOperator) {
		this.repAuditOperator = repAuditOperator;
	}

	/**
	 * 属性精算审核意见的getter方法
	 */

	@Column(name = "REPAUDITIDEA")
	public String getRepAuditIdea() {
		return this.repAuditIdea;
	}

	/**
	 * 属性精算审核意见的setter方法
	 */
	public void setRepAuditIdea(String repAuditIdea) {
		this.repAuditIdea = repAuditIdea;
	}

	/**
	 * 属性管理机构的getter方法
	 */

	@Column(name = "MANAGECOM")
	public String getManageCom() {
		return this.manageCom;
	}

	/**
	 * 属性管理机构的setter方法
	 */
	public void setManageCom(String manageCom) {
		this.manageCom = manageCom;
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

}
