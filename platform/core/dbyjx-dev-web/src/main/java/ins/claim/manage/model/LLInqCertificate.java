package ins.claim.manage.model;

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
 * POJO类LLInqCertificate
 */
@Entity
@Table(name = "LLINQCERTIFICATE")
public class LLInqCertificate implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性id */
	private LLInqCertificateId id;

	/** 属性单证类型 */
	private String cerType;

	/** 属性单证名称 */
	private String cerName;

	/** 属性原件标志 */
	private String oriFlag;

	/** 属性张数 */
	private BigDecimal cerCount;

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

	/** 属性备注 */
	private String remark;

	/** 属性原件标志值 */
	private String oriFlagValue;

	/**
	 * 类LLInqCertificate的默认构造方法
	 */
	public LLInqCertificate() {
	}

	/**
	 * 属性id的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "clmNo", column = @Column(name = "CLMNO")),
			@AttributeOverride(name = "inqNo", column = @Column(name = "INQNO")),
			@AttributeOverride(name = "couNo", column = @Column(name = "COUNO")),
			@AttributeOverride(name = "cerNo", column = @Column(name = "CERNO")) })
	public LLInqCertificateId getId() {
		return this.id;
	}

	/**
	 * 属性id的setter方法
	 */
	public void setId(LLInqCertificateId id) {
		this.id = id;
	}

	/**
	 * 属性单证类型的getter方法
	 */

	@Column(name = "CERTYPE")
	public String getCerType() {
		return this.cerType;
	}

	/**
	 * 属性单证类型的setter方法
	 */
	public void setCerType(String cerType) {
		this.cerType = cerType;
	}

	/**
	 * 属性单证名称的getter方法
	 */

	@Column(name = "CERNAME")
	public String getCerName() {
		return this.cerName;
	}

	/**
	 * 属性单证名称的setter方法
	 */
	public void setCerName(String cerName) {
		this.cerName = cerName;
	}

	/**
	 * 属性原件标志的getter方法
	 */

	@Column(name = "ORIFLAG")
	public String getOriFlag() {
		return this.oriFlag;
	}

	/**
	 * 属性原件标志的setter方法
	 */
	public void setOriFlag(String oriFlag) {
		this.oriFlag = oriFlag;
	}

	/**
	 * 属性张数的getter方法
	 */

	@Column(name = "CERCOUNT")
	public BigDecimal getCerCount() {
		return this.cerCount;
	}

	/**
	 * 属性张数的setter方法
	 */
	public void setCerCount(BigDecimal cerCount) {
		this.cerCount = cerCount;
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
	 * 属性备注的getter方法
	 */

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	/**
	 * 属性备注的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 属性原件标志值的getter方法
	 */

	@Column(name = "ORIFLAGVALUE")
	public String getOriFlagValue() {
		return this.oriFlagValue;
	}

	/**
	 * 属性原件标志值的setter方法
	 */
	public void setOriFlagValue(String oriFlagValue) {
		this.oriFlagValue = oriFlagValue;
	}

}
