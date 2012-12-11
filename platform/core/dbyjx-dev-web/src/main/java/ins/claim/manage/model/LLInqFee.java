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
 * POJO类LLInqFee
 */
@Entity
@Table(name = "LLINQFEE")
public class LLInqFee implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性id */
	private LLInqFeeId id;

	/** 属性发生时间 */
	private Date feeDate;

	/** 属性金额 */
	private BigDecimal feeSum;

	/** 属性领款人 */
	private String payee;

	/** 属性领款方式 */
	private String payeeType;

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

	/** 属性银行编码 */
	private String bankCode;

	/** 属性银行帐号 */
	private String bankAccNo;

	/** 属性银行帐户名 */
	private String accName;

	/** 属性账户修改原因代码 */
	private String modiReasonCode;

	/** 属性账户修改原因 */
	private String modiReasonDesc;

	/** 属性原银行编码 */
	private String obankCode;

	/** 属性原银行账号 */
	private String obankAccNo;

	/** 属性原银行账户名 */
	private String oaccName;

	/** 属性确认标志 */
	private String confirmFlag;

	/** 属性领取人编码 */
	private String payeeCode;

	/** 属性打印标志 */
	private String prtFlag;

	/** 属性审核人员 */
	private String auditOperator;

	/** 属性调整前调查费用 */
	private BigDecimal adjFeeSum;

	/** 属性调整调查费用原因 */
	private String adjFeeReason;

	/** 属性调查机构名称 */
	private String inqDeptName;

	/** 属性费用类型值 */
	private String feeTypeValue;

	/** 属性领款方式值 */
	private String payeeTypeValue;

	/**
	 * 类LLInqFee的默认构造方法
	 */
	public LLInqFee() {
	}

	/**
	 * 属性id的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "clmNo", column = @Column(name = "CLMNO")),
			@AttributeOverride(name = "inqNo", column = @Column(name = "INQNO")),
			@AttributeOverride(name = "inqDept", column = @Column(name = "INQDEPT")),
			@AttributeOverride(name = "feeType", column = @Column(name = "FEETYPE")) })
	public LLInqFeeId getId() {
		return this.id;
	}

	/**
	 * 属性id的setter方法
	 */
	public void setId(LLInqFeeId id) {
		this.id = id;
	}

	/**
	 * 属性发生时间的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "FEEDATE")
	public Date getFeeDate() {
		return this.feeDate;
	}

	/**
	 * 属性发生时间的setter方法
	 */
	public void setFeeDate(Date feeDate) {
		this.feeDate = feeDate;
	}

	/**
	 * 属性金额的getter方法
	 */

	@Column(name = "FEESUM")
	public BigDecimal getFeeSum() {
		return this.feeSum;
	}

	/**
	 * 属性金额的setter方法
	 */
	public void setFeeSum(BigDecimal feeSum) {
		this.feeSum = feeSum;
	}

	/**
	 * 属性领款人的getter方法
	 */

	@Column(name = "PAYEE")
	public String getPayee() {
		return this.payee;
	}

	/**
	 * 属性领款人的setter方法
	 */
	public void setPayee(String payee) {
		this.payee = payee;
	}

	/**
	 * 属性领款方式的getter方法
	 */

	@Column(name = "PAYEETYPE")
	public String getPayeeType() {
		return this.payeeType;
	}

	/**
	 * 属性领款方式的setter方法
	 */
	public void setPayeeType(String payeeType) {
		this.payeeType = payeeType;
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
	 * 属性银行编码的getter方法
	 */

	@Column(name = "BANKCODE")
	public String getBankCode() {
		return this.bankCode;
	}

	/**
	 * 属性银行编码的setter方法
	 */
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	/**
	 * 属性银行帐号的getter方法
	 */

	@Column(name = "BANKACCNO")
	public String getBankAccNo() {
		return this.bankAccNo;
	}

	/**
	 * 属性银行帐号的setter方法
	 */
	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}

	/**
	 * 属性银行帐户名的getter方法
	 */

	@Column(name = "ACCNAME")
	public String getAccName() {
		return this.accName;
	}

	/**
	 * 属性银行帐户名的setter方法
	 */
	public void setAccName(String accName) {
		this.accName = accName;
	}

	/**
	 * 属性账户修改原因代码的getter方法
	 */

	@Column(name = "MODIREASONCODE")
	public String getModiReasonCode() {
		return this.modiReasonCode;
	}

	/**
	 * 属性账户修改原因代码的setter方法
	 */
	public void setModiReasonCode(String modiReasonCode) {
		this.modiReasonCode = modiReasonCode;
	}

	/**
	 * 属性账户修改原因的getter方法
	 */

	@Column(name = "MODIREASONDESC")
	public String getModiReasonDesc() {
		return this.modiReasonDesc;
	}

	/**
	 * 属性账户修改原因的setter方法
	 */
	public void setModiReasonDesc(String modiReasonDesc) {
		this.modiReasonDesc = modiReasonDesc;
	}

	/**
	 * 属性原银行编码的getter方法
	 */

	@Column(name = "OBANKCODE")
	public String getObankCode() {
		return this.obankCode;
	}

	/**
	 * 属性原银行编码的setter方法
	 */
	public void setObankCode(String obankCode) {
		this.obankCode = obankCode;
	}

	/**
	 * 属性原银行账号的getter方法
	 */

	@Column(name = "OBANKACCNO")
	public String getObankAccNo() {
		return this.obankAccNo;
	}

	/**
	 * 属性原银行账号的setter方法
	 */
	public void setObankAccNo(String obankAccNo) {
		this.obankAccNo = obankAccNo;
	}

	/**
	 * 属性原银行账户名的getter方法
	 */

	@Column(name = "OACCNAME")
	public String getOaccName() {
		return this.oaccName;
	}

	/**
	 * 属性原银行账户名的setter方法
	 */
	public void setOaccName(String oaccName) {
		this.oaccName = oaccName;
	}

	/**
	 * 属性确认标志的getter方法
	 */

	@Column(name = "CONFIRMFLAG")
	public String getConfirmFlag() {
		return this.confirmFlag;
	}

	/**
	 * 属性确认标志的setter方法
	 */
	public void setConfirmFlag(String confirmFlag) {
		this.confirmFlag = confirmFlag;
	}

	/**
	 * 属性领取人编码的getter方法
	 */

	@Column(name = "PAYEECODE")
	public String getPayeeCode() {
		return this.payeeCode;
	}

	/**
	 * 属性领取人编码的setter方法
	 */
	public void setPayeeCode(String payeeCode) {
		this.payeeCode = payeeCode;
	}

	/**
	 * 属性打印标志的getter方法
	 */

	@Column(name = "PRTFLAG")
	public String getPrtFlag() {
		return this.prtFlag;
	}

	/**
	 * 属性打印标志的setter方法
	 */
	public void setPrtFlag(String prtFlag) {
		this.prtFlag = prtFlag;
	}

	/**
	 * 属性审核人员的getter方法
	 */

	@Column(name = "AUDITOPERATOR")
	public String getAuditOperator() {
		return this.auditOperator;
	}

	/**
	 * 属性审核人员的setter方法
	 */
	public void setAuditOperator(String auditOperator) {
		this.auditOperator = auditOperator;
	}

	/**
	 * 属性调整前调查费用的getter方法
	 */

	@Column(name = "ADJFEESUM")
	public BigDecimal getAdjFeeSum() {
		return this.adjFeeSum;
	}

	/**
	 * 属性调整前调查费用的setter方法
	 */
	public void setAdjFeeSum(BigDecimal adjFeeSum) {
		this.adjFeeSum = adjFeeSum;
	}

	/**
	 * 属性调整调查费用原因的getter方法
	 */

	@Column(name = "ADJFEEREASON")
	public String getAdjFeeReason() {
		return this.adjFeeReason;
	}

	/**
	 * 属性调整调查费用原因的setter方法
	 */
	public void setAdjFeeReason(String adjFeeReason) {
		this.adjFeeReason = adjFeeReason;
	}

	/**
	 * 属性调查机构名称的getter方法
	 */

	@Column(name = "INQDEPTNAME")
	public String getInqDeptName() {
		return this.inqDeptName;
	}

	/**
	 * 属性调查机构名称的setter方法
	 */
	public void setInqDeptName(String inqDeptName) {
		this.inqDeptName = inqDeptName;
	}

	/**
	 * 属性费用类型值的getter方法
	 */

	@Column(name = "FEETYPEVALUE")
	public String getFeeTypeValue() {
		return this.feeTypeValue;
	}

	/**
	 * 属性费用类型值的setter方法
	 */
	public void setFeeTypeValue(String feeTypeValue) {
		this.feeTypeValue = feeTypeValue;
	}

	/**
	 * 属性领款方式值的getter方法
	 */

	@Column(name = "PAYEETYPEVALUE")
	public String getPayeeTypeValue() {
		return this.payeeTypeValue;
	}

	/**
	 * 属性领款方式值的setter方法
	 */
	public void setPayeeTypeValue(String payeeTypeValue) {
		this.payeeTypeValue = payeeTypeValue;
	}

}
