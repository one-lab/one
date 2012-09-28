package ins.prpall.proposal.model;

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
 * POJO类LCGrpServInfo
 */
@Entity
@Table(name = "LCGRPSERVINFO")
public class LCGrpServInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性序号 */
	private LCGrpServInfoId id;

	/** 属性集体投保单号码 */
	private String proposalGrpContNo;

	/** 属性印刷号码 */
	private String prtNo;

	/** 属性服务选择值 */
	private String servChoose;

	/** 属性服务备注 */
	private String servRemark;

	/** 属性入机日期 */
	private Date makeDate;

	/** 属性入机时间 */
	private String makeTime;

	/** 属性最后一次修改日期 */
	private Date modifyDate;

	/** 属性最后一次修改时间 */
	private String modifyTime;

	/**
	 * 类LCGrpServInfo的默认构造方法
	 */
	public LCGrpServInfo() {
	}

	/**
	 * 属性序号的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "grpContNo", column = @Column(name = "GRPCONTNO")),
			@AttributeOverride(name = "servKind", column = @Column(name = "SERVKIND")),
			@AttributeOverride(name = "servDetail", column = @Column(name = "SERVDETAIL")) })
	public LCGrpServInfoId getId() {
		return this.id;
	}

	/**
	 * 属性序号的setter方法
	 */
	public void setId(LCGrpServInfoId id) {
		this.id = id;
	}

	/**
	 * 属性集体投保单号码的getter方法
	 */

	@Column(name = "PROPOSALGRPCONTNO")
	public String getProposalGrpContNo() {
		return this.proposalGrpContNo;
	}

	/**
	 * 属性集体投保单号码的setter方法
	 */
	public void setProposalGrpContNo(String proposalGrpContNo) {
		this.proposalGrpContNo = proposalGrpContNo;
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
	 * 属性服务选择值的getter方法
	 */

	@Column(name = "SERVCHOOSE")
	public String getServChoose() {
		return this.servChoose;
	}

	/**
	 * 属性服务选择值的setter方法
	 */
	public void setServChoose(String servChoose) {
		this.servChoose = servChoose;
	}

	/**
	 * 属性服务备注的getter方法
	 */

	@Column(name = "SERVREMARK")
	public String getServRemark() {
		return this.servRemark;
	}

	/**
	 * 属性服务备注的setter方法
	 */
	public void setServRemark(String servRemark) {
		this.servRemark = servRemark;
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
