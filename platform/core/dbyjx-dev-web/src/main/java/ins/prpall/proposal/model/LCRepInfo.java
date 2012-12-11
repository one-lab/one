package ins.prpall.proposal.model;

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
 * POJO类LCRepInfo
 */
@Entity
@Table(name = "LCREPINFO")
public class LCRepInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性序号 */
	private LCRepInfoId id;

	/** 属性合同号码 */
	private String contNo;

	/** 属性总单投保单号码 */
	private String proposalContNo;

	/** 属性印刷号码 */
	private String prtNo;

	/** 属性告知内容 */
	private String impartDetailContent;

	/** 属性开始时间 */
	private Date startDate;

	/** 属性保险责任终止日期 */
	private Date endDate;

	/** 属性证明人 */
	private String prover;

	/** 属性目前状况 */
	private String currCondition;

	/** 属性能否证明 */
	private String isProved;

	/** 属性客户号码 */
	private String customerNo;

	/** 属性客户号码类型 */
	private String customerNoType;

	/** 属性是否参与核保核赔标志 */
	private String uwClaimFlg;

	/** 属性打印标志 */
	private String prtFlag;

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

	/** 属性批次号 */
	private BigDecimal patchNo;

	/** 属性录入信息 */
	private String message;

	/** 属性同行业竞争状况 */
	private String competitionStatus;

	/** 属性被保险人状况 */
	private String insurStatus;

	/** 属性既往理赔史 */
	private String clmHistory;

	/** 属性保单相关情况及服务要求 */
	private String conStatusAndServ;

	/**
	 * 类LCRepInfo的默认构造方法
	 */
	public LCRepInfo() {
	}

	/**
	 * 属性序号的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "grpContNo", column = @Column(name = "GRPCONTNO")),
			@AttributeOverride(name = "impartCode", column = @Column(name = "IMPARTCODE")),
			@AttributeOverride(name = "impartVer", column = @Column(name = "IMPARTVER")),
			@AttributeOverride(name = "subSerialNo", column = @Column(name = "SUBSERIALNO")) })
	public LCRepInfoId getId() {
		return this.id;
	}

	/**
	 * 属性序号的setter方法
	 */
	public void setId(LCRepInfoId id) {
		this.id = id;
	}

	/**
	 * 属性合同号码的getter方法
	 */

	@Column(name = "CONTNO")
	public String getContNo() {
		return this.contNo;
	}

	/**
	 * 属性合同号码的setter方法
	 */
	public void setContNo(String contNo) {
		this.contNo = contNo;
	}

	/**
	 * 属性总单投保单号码的getter方法
	 */

	@Column(name = "PROPOSALCONTNO")
	public String getProposalContNo() {
		return this.proposalContNo;
	}

	/**
	 * 属性总单投保单号码的setter方法
	 */
	public void setProposalContNo(String proposalContNo) {
		this.proposalContNo = proposalContNo;
	}

	/**
	 * 属性印刷号码的getter方法
	 */

	@Column(name = "PRTNO")
	public String getPrtNo() {
		return this.prtNo;
	}

	/**
	 * 属性印刷号码的setter方法
	 */
	public void setPrtNo(String prtNo) {
		this.prtNo = prtNo;
	}

	/**
	 * 属性告知内容的getter方法
	 */

	@Column(name = "IMPARTDETAILCONTENT")
	public String getImpartDetailContent() {
		return this.impartDetailContent;
	}

	/**
	 * 属性告知内容的setter方法
	 */
	public void setImpartDetailContent(String impartDetailContent) {
		this.impartDetailContent = impartDetailContent;
	}

	/**
	 * 属性开始时间的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "STARTDATE")
	public Date getStartDate() {
		return this.startDate;
	}

	/**
	 * 属性开始时间的setter方法
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * 属性保险责任终止日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "ENDDATE")
	public Date getEndDate() {
		return this.endDate;
	}

	/**
	 * 属性保险责任终止日期的setter方法
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * 属性证明人的getter方法
	 */

	@Column(name = "PROVER")
	public String getProver() {
		return this.prover;
	}

	/**
	 * 属性证明人的setter方法
	 */
	public void setProver(String prover) {
		this.prover = prover;
	}

	/**
	 * 属性目前状况的getter方法
	 */

	@Column(name = "CURRCONDITION")
	public String getCurrCondition() {
		return this.currCondition;
	}

	/**
	 * 属性目前状况的setter方法
	 */
	public void setCurrCondition(String currCondition) {
		this.currCondition = currCondition;
	}

	/**
	 * 属性能否证明的getter方法
	 */

	@Column(name = "ISPROVED")
	public String getIsProved() {
		return this.isProved;
	}

	/**
	 * 属性能否证明的setter方法
	 */
	public void setIsProved(String isProved) {
		this.isProved = isProved;
	}

	/**
	 * 属性客户号码的getter方法
	 */

	@Column(name = "CUSTOMERNO")
	public String getCustomerNo() {
		return this.customerNo;
	}

	/**
	 * 属性客户号码的setter方法
	 */
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	/**
	 * 属性客户号码类型的getter方法
	 */

	@Column(name = "CUSTOMERNOTYPE")
	public String getCustomerNoType() {
		return this.customerNoType;
	}

	/**
	 * 属性客户号码类型的setter方法
	 */
	public void setCustomerNoType(String customerNoType) {
		this.customerNoType = customerNoType;
	}

	/**
	 * 属性是否参与核保核赔标志的getter方法
	 */

	@Column(name = "UWCLAIMFLG")
	public String getUwClaimFlg() {
		return this.uwClaimFlg;
	}

	/**
	 * 属性是否参与核保核赔标志的setter方法
	 */
	public void setUwClaimFlg(String uwClaimFlg) {
		this.uwClaimFlg = uwClaimFlg;
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
	 * 属性批次号的getter方法
	 */

	@Column(name = "PATCHNO")
	public BigDecimal getPatchNo() {
		return this.patchNo;
	}

	/**
	 * 属性批次号的setter方法
	 */
	public void setPatchNo(BigDecimal patchNo) {
		this.patchNo = patchNo;
	}

	/**
	 * 属性录入信息的getter方法
	 */

	@Column(name = "MESSAGE")
	public String getMessage() {
		return this.message;
	}

	/**
	 * 属性录入信息的setter方法
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 属性同行业竞争状况的getter方法
	 */

	@Column(name = "COMPETITIONSTATUS")
	public String getCompetitionStatus() {
		return this.competitionStatus;
	}

	/**
	 * 属性同行业竞争状况的setter方法
	 */
	public void setCompetitionStatus(String competitionStatus) {
		this.competitionStatus = competitionStatus;
	}

	/**
	 * 属性被保险人状况的getter方法
	 */

	@Column(name = "INSURSTATUS")
	public String getInsurStatus() {
		return this.insurStatus;
	}

	/**
	 * 属性被保险人状况的setter方法
	 */
	public void setInsurStatus(String insurStatus) {
		this.insurStatus = insurStatus;
	}

	/**
	 * 属性既往理赔史的getter方法
	 */

	@Column(name = "CLMHISTORY")
	public String getClmHistory() {
		return this.clmHistory;
	}

	/**
	 * 属性既往理赔史的setter方法
	 */
	public void setClmHistory(String clmHistory) {
		this.clmHistory = clmHistory;
	}

	/**
	 * 属性保单相关情况及服务要求的getter方法
	 */

	@Column(name = "CONSTATUSANDSERV")
	public String getConStatusAndServ() {
		return this.conStatusAndServ;
	}

	/**
	 * 属性保单相关情况及服务要求的setter方法
	 */
	public void setConStatusAndServ(String conStatusAndServ) {
		this.conStatusAndServ = conStatusAndServ;
	}

}
