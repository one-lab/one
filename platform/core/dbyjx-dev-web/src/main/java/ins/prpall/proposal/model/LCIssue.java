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
 * POJO类LCIssue
 */
@Entity
@Table(name = "LCISSUE")
public class LCIssue implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性序号 */
	private LCIssueId id;

	/** 属性合同号码 */
	private String contNo;

	/** 属性总单投保单号码 */
	private String proposalContNo;

	/** 属性打印流水号 */
	private String prtSeq;

	/** 属性问题件类型 */
	private String issueType;

	/** 属性操作位置 */
	private String operatePos;

	/** 属性退回对象类型 */
	private String backObjType;

	/** 属性退回对象 */
	private String backObj;

	/** 属性问题件所在管理机构 */
	private String isueManageCom;

	/** 属性问题件内容 */
	private String issueCont;

	/** 属性保单打印次数 */
	private BigDecimal printCount;

	/** 属性是否打印标志 */
	private String needPrint;

	/** 属性回复人 */
	private String replyMan;

	/** 属性回复结果 */
	private String replyResult;

	/** 属性状态 */
	private String state;

	/** 属性操作员 */
	private String operator;

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
	 * 类LCIssue的默认构造方法
	 */
	public LCIssue() {
	}

	/**
	 * 属性序号的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "grpContNo", column = @Column(name = "GRPCONTNO")),
			@AttributeOverride(name = "serialNo", column = @Column(name = "SERIALNO")) })
	public LCIssueId getId() {
		return this.id;
	}

	/**
	 * 属性序号的setter方法
	 */
	public void setId(LCIssueId id) {
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
	 * 属性打印流水号的getter方法
	 */

	@Column(name = "PRTSEQ")
	public String getPrtSeq() {
		return this.prtSeq;
	}

	/**
	 * 属性打印流水号的setter方法
	 */
	public void setPrtSeq(String prtSeq) {
		this.prtSeq = prtSeq;
	}

	/**
	 * 属性问题件类型的getter方法
	 */

	@Column(name = "ISSUETYPE")
	public String getIssueType() {
		return this.issueType;
	}

	/**
	 * 属性问题件类型的setter方法
	 */
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	/**
	 * 属性操作位置的getter方法
	 */

	@Column(name = "OPERATEPOS")
	public String getOperatePos() {
		return this.operatePos;
	}

	/**
	 * 属性操作位置的setter方法
	 */
	public void setOperatePos(String operatePos) {
		this.operatePos = operatePos;
	}

	/**
	 * 属性退回对象类型的getter方法
	 */

	@Column(name = "BACKOBJTYPE")
	public String getBackObjType() {
		return this.backObjType;
	}

	/**
	 * 属性退回对象类型的setter方法
	 */
	public void setBackObjType(String backObjType) {
		this.backObjType = backObjType;
	}

	/**
	 * 属性退回对象的getter方法
	 */

	@Column(name = "BACKOBJ")
	public String getBackObj() {
		return this.backObj;
	}

	/**
	 * 属性退回对象的setter方法
	 */
	public void setBackObj(String backObj) {
		this.backObj = backObj;
	}

	/**
	 * 属性问题件所在管理机构的getter方法
	 */

	@Column(name = "ISUEMANAGECOM")
	public String getIsueManageCom() {
		return this.isueManageCom;
	}

	/**
	 * 属性问题件所在管理机构的setter方法
	 */
	public void setIsueManageCom(String isueManageCom) {
		this.isueManageCom = isueManageCom;
	}

	/**
	 * 属性问题件内容的getter方法
	 */

	@Column(name = "ISSUECONT")
	public String getIssueCont() {
		return this.issueCont;
	}

	/**
	 * 属性问题件内容的setter方法
	 */
	public void setIssueCont(String issueCont) {
		this.issueCont = issueCont;
	}

	/**
	 * 属性保单打印次数的getter方法
	 */

	@Column(name = "PRINTCOUNT")
	public BigDecimal getPrintCount() {
		return this.printCount;
	}

	/**
	 * 属性保单打印次数的setter方法
	 */
	public void setPrintCount(BigDecimal printCount) {
		this.printCount = printCount;
	}

	/**
	 * 属性是否打印标志的getter方法
	 */

	@Column(name = "NEEDPRINT")
	public String getNeedPrint() {
		return this.needPrint;
	}

	/**
	 * 属性是否打印标志的setter方法
	 */
	public void setNeedPrint(String needPrint) {
		this.needPrint = needPrint;
	}

	/**
	 * 属性回复人的getter方法
	 */

	@Column(name = "REPLYMAN")
	public String getReplyMan() {
		return this.replyMan;
	}

	/**
	 * 属性回复人的setter方法
	 */
	public void setReplyMan(String replyMan) {
		this.replyMan = replyMan;
	}

	/**
	 * 属性回复结果的getter方法
	 */

	@Column(name = "REPLYRESULT")
	public String getReplyResult() {
		return this.replyResult;
	}

	/**
	 * 属性回复结果的setter方法
	 */
	public void setReplyResult(String replyResult) {
		this.replyResult = replyResult;
	}

	/**
	 * 属性状态的getter方法
	 */

	@Column(name = "STATE")
	public String getState() {
		return this.state;
	}

	/**
	 * 属性状态的setter方法
	 */
	public void setState(String state) {
		this.state = state;
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
