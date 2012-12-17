package ins.prpall.proposal.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * POJO类LCGrpRepInfoDetail
 */
@Entity
@Table(name = "LCGRPREPINFODETAIL")
public class LCGrpRepInfoDetail implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性集体合同号码 */
	private String grpContNo;

	/** 属性印刷号码 */
	private String prtNo;

	/** 属性同行业竞争状况 */
	private String competitionStatus;

	/** 属性被保险人状况 */
	private String insurStatus;

	/** 属性既往理赔史 */
	private String clmHistory;

	/** 属性保单相关情况及服务要求 */
	private String conStatusAndServ;

	/** 属性备用属性字段1 */
	private String standbyFlag1;

	/** 属性备用属性字段2 */
	private String standbyFlag2;

	/** 属性备用属性字段3 */
	private String standbyFlag3;

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

	/**
	 * 类LCGrpRepInfoDetail的默认构造方法
	 */
	public LCGrpRepInfoDetail() {
	}

	/**
	 * 属性集体合同号码的getter方法
	 */
	@Id
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

	/**
	 * 属性备用属性字段1的getter方法
	 */

	@Column(name = "STANDBYFLAG1")
	public String getStandbyFlag1() {
		return this.standbyFlag1;
	}

	/**
	 * 属性备用属性字段1的setter方法
	 */
	public void setStandbyFlag1(String standbyFlag1) {
		this.standbyFlag1 = standbyFlag1;
	}

	/**
	 * 属性备用属性字段2的getter方法
	 */

	@Column(name = "STANDBYFLAG2")
	public String getStandbyFlag2() {
		return this.standbyFlag2;
	}

	/**
	 * 属性备用属性字段2的setter方法
	 */
	public void setStandbyFlag2(String standbyFlag2) {
		this.standbyFlag2 = standbyFlag2;
	}

	/**
	 * 属性备用属性字段3的getter方法
	 */

	@Column(name = "STANDBYFLAG3")
	public String getStandbyFlag3() {
		return this.standbyFlag3;
	}

	/**
	 * 属性备用属性字段3的setter方法
	 */
	public void setStandbyFlag3(String standbyFlag3) {
		this.standbyFlag3 = standbyFlag3;
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

}
