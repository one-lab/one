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
 * POJO类PropallSearchInfo
 */
@Entity
@Table(name = "PROPALLSEARCHINFO")
public class PropallSearchInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性序号 */
	private PropallSearchInfoId id;

	/** 属性呈报申请人 */
	private String repOperator;

	/** 属性客户姓名 */
	private String name;

	/** 属性契调原因 */
	private String reason;

	/** 属性调查人 */
	private String investor;

	/** 属性其他契调项目 */
	private String otherMessage;

	/** 属性文件名 */
	private String fileName;

	/** 属性契调费用 */
	private BigDecimal money;

	/** 属性状态 */
	private String state;

	/** 属性呈报审核结论 */
	private String result;

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
	 * 类PropallSearchInfo的默认构造方法
	 */
	public PropallSearchInfo() {
	}

	/**
	 * 属性序号的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "repNo", column = @Column(name = "REPNO")),
			@AttributeOverride(name = "serialNo", column = @Column(name = "SERIALNO")) })
	public PropallSearchInfoId getId() {
		return this.id;
	}

	/**
	 * 属性序号的setter方法
	 */
	public void setId(PropallSearchInfoId id) {
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
	 * 属性客户姓名的getter方法
	 */

	@Column(name = "NAME")
	public String getName() {
		return this.name;
	}

	/**
	 * 属性客户姓名的setter方法
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 属性契调原因的getter方法
	 */

	@Column(name = "REASON")
	public String getReason() {
		return this.reason;
	}

	/**
	 * 属性契调原因的setter方法
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * 属性调查人的getter方法
	 */

	@Column(name = "INVESTOR")
	public String getInvestor() {
		return this.investor;
	}

	/**
	 * 属性调查人的setter方法
	 */
	public void setInvestor(String investor) {
		this.investor = investor;
	}

	/**
	 * 属性其他契调项目的getter方法
	 */

	@Column(name = "OTHERMESSAGE")
	public String getOtherMessage() {
		return this.otherMessage;
	}

	/**
	 * 属性其他契调项目的setter方法
	 */
	public void setOtherMessage(String otherMessage) {
		this.otherMessage = otherMessage;
	}

	/**
	 * 属性文件名的getter方法
	 */

	@Column(name = "FILENAME")
	public String getFileName() {
		return this.fileName;
	}

	/**
	 * 属性文件名的setter方法
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * 属性契调费用的getter方法
	 */

	@Column(name = "MONEY")
	public BigDecimal getMoney() {
		return this.money;
	}

	/**
	 * 属性契调费用的setter方法
	 */
	public void setMoney(BigDecimal money) {
		this.money = money;
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
	 * 属性呈报审核结论的getter方法
	 */

	@Column(name = "RESULT")
	public String getResult() {
		return this.result;
	}

	/**
	 * 属性呈报审核结论的setter方法
	 */
	public void setResult(String result) {
		this.result = result;
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
