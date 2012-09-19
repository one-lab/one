package ins.product.model;

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
 * POJO类PDIsSue
 */
@Entity
@Table(name = "PD_ISSUE")
public class PDIsSue implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性ID */
	private PDIsSueId id;

	/** 属性issuetype */
	private String issuetype;

	/** 属性operpost */
	private String operpost;

	/** 属性operpostman */
	private String operpostman;

	/** 属性issuecont */
	private String issuecont;

	/** 属性replyman */
	private String replyman;

	/** 属性replycont */
	private String replycont;

	/** 属性backpost */
	private String backpost;

	/** 属性issuestate */
	private String issuestate;

	/** 属性issuefilepath */
	private String issuefilepath;

	/** 属性operator */
	private String operator;

	/** 属性生产日期 */
	private Date makeDate;

	/** 属性maketime */
	private String maketime;

	/** 属性modifydate */
	private Date modifydate;

	/** 属性修改时间 */
	private String modifyTime;

	/** 属性standbyflag1 */
	private String standbyflag1;

	/** 属性standbyflag2 */
	private String standbyflag2;

	/**
	 * 类PDIsSue的默认构造方法
	 */
	public PDIsSue() {
	}

	/**
	 * 属性ID的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "riskCode", column = @Column(name = "RISKCODE")),
			@AttributeOverride(name = "serialNo", column = @Column(name = "SERIALNO")) })
	public PDIsSueId getId() {
		return this.id;
	}

	/**
	 * 属性ID的setter方法
	 */
	public void setId(PDIsSueId id) {
		this.id = id;
	}

	/**
	 * 属性issuetype的getter方法
	 */

	@Column(name = "ISSUETYPE")
	public String getIssuetype() {
		return this.issuetype;
	}

	/**
	 * 属性issuetype的setter方法
	 */
	public void setIssuetype(String issuetype) {
		this.issuetype = issuetype;
	}

	/**
	 * 属性operpost的getter方法
	 */

	@Column(name = "OPERPOST")
	public String getOperpost() {
		return this.operpost;
	}

	/**
	 * 属性operpost的setter方法
	 */
	public void setOperpost(String operpost) {
		this.operpost = operpost;
	}

	/**
	 * 属性operpostman的getter方法
	 */

	@Column(name = "OPERPOSTMAN")
	public String getOperpostman() {
		return this.operpostman;
	}

	/**
	 * 属性operpostman的setter方法
	 */
	public void setOperpostman(String operpostman) {
		this.operpostman = operpostman;
	}

	/**
	 * 属性issuecont的getter方法
	 */

	@Column(name = "ISSUECONT")
	public String getIssuecont() {
		return this.issuecont;
	}

	/**
	 * 属性issuecont的setter方法
	 */
	public void setIssuecont(String issuecont) {
		this.issuecont = issuecont;
	}

	/**
	 * 属性replyman的getter方法
	 */

	@Column(name = "REPLYMAN")
	public String getReplyman() {
		return this.replyman;
	}

	/**
	 * 属性replyman的setter方法
	 */
	public void setReplyman(String replyman) {
		this.replyman = replyman;
	}

	/**
	 * 属性replycont的getter方法
	 */

	@Column(name = "REPLYCONT")
	public String getReplycont() {
		return this.replycont;
	}

	/**
	 * 属性replycont的setter方法
	 */
	public void setReplycont(String replycont) {
		this.replycont = replycont;
	}

	/**
	 * 属性backpost的getter方法
	 */

	@Column(name = "BACKPOST")
	public String getBackpost() {
		return this.backpost;
	}

	/**
	 * 属性backpost的setter方法
	 */
	public void setBackpost(String backpost) {
		this.backpost = backpost;
	}

	/**
	 * 属性issuestate的getter方法
	 */

	@Column(name = "ISSUESTATE")
	public String getIssuestate() {
		return this.issuestate;
	}

	/**
	 * 属性issuestate的setter方法
	 */
	public void setIssuestate(String issuestate) {
		this.issuestate = issuestate;
	}

	/**
	 * 属性issuefilepath的getter方法
	 */

	@Column(name = "ISSUEFILEPATH")
	public String getIssuefilepath() {
		return this.issuefilepath;
	}

	/**
	 * 属性issuefilepath的setter方法
	 */
	public void setIssuefilepath(String issuefilepath) {
		this.issuefilepath = issuefilepath;
	}

	/**
	 * 属性operator的getter方法
	 */

	@Column(name = "OPERATOR")
	public String getOperator() {
		return this.operator;
	}

	/**
	 * 属性operator的setter方法
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * 属性生产日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "MAKEDATE")
	public Date getMakeDate() {
		return this.makeDate;
	}

	/**
	 * 属性生产日期的setter方法
	 */
	public void setMakeDate(Date makeDate) {
		this.makeDate = makeDate;
	}

	/**
	 * 属性maketime的getter方法
	 */

	@Column(name = "MAKETIME")
	public String getMaketime() {
		return this.maketime;
	}

	/**
	 * 属性maketime的setter方法
	 */
	public void setMaketime(String maketime) {
		this.maketime = maketime;
	}

	/**
	 * 属性modifydate的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFYDATE")
	public Date getModifydate() {
		return this.modifydate;
	}

	/**
	 * 属性modifydate的setter方法
	 */
	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

	/**
	 * 属性修改时间的getter方法
	 */

	@Column(name = "MODIFYTIME")
	public String getModifyTime() {
		return this.modifyTime;
	}

	/**
	 * 属性修改时间的setter方法
	 */
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * 属性standbyflag1的getter方法
	 */

	@Column(name = "STANDBYFLAG1")
	public String getStandbyflag1() {
		return this.standbyflag1;
	}

	/**
	 * 属性standbyflag1的setter方法
	 */
	public void setStandbyflag1(String standbyflag1) {
		this.standbyflag1 = standbyflag1;
	}

	/**
	 * 属性standbyflag2的getter方法
	 */

	@Column(name = "STANDBYFLAG2")
	public String getStandbyflag2() {
		return this.standbyflag2;
	}

	/**
	 * 属性standbyflag2的setter方法
	 */
	public void setStandbyflag2(String standbyflag2) {
		this.standbyflag2 = standbyflag2;
	}

}
