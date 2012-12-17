package ins.prpall.report.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * POJO类LCReport
 */
@Entity
@Table(name = "LCREPORT")
public class LCReport implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性呈报申请号 */
	private String repNo;

	/** 属性流水号 */
	private int serialNo;

	/** 属性呈报申请人 */
	private String repOperator;

	/** 属性呈报申请日期 */
	private Date repApplyDate;

	/** 属性客户姓名 */
	private String name;

	/** 属性投保单位客户号 */
	private String appNo;

	/** 属性状态 */
	private String state;

	/** 属性代理人编码 */
	private String agentCode;

	/** 属性代理人组别 */
	private String agentGroup;

	/** 属性服务方式 */
	private String serviceType;

	/** 属性是否中介业务标志 */
	private String bussinessFlag;

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
	 * 类LCReport的默认构造方法
	 */
	public LCReport() {
	}

	/**
	 * 属性呈报申请号的getter方法
	 */
	@Id
	@Column(name = "REPNO")
	public String getRepNo() {
		return this.repNo;
	}

	/**
	 * 属性呈报申请号的setter方法
	 */
	public void setRepNo(String repNo) {
		this.repNo = repNo;
	}

	/**
	 * 属性流水号的getter方法
	 */

	@Column(name = "SERIALNO")
	public int getSerialNo() {
		return this.serialNo;
	}

	/**
	 * 属性流水号的setter方法
	 */
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
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
	 * 属性呈报申请日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "REPAPPLYDATE")
	public Date getRepApplyDate() {
		return this.repApplyDate;
	}

	/**
	 * 属性呈报申请日期的setter方法
	 */
	public void setRepApplyDate(Date repApplyDate) {
		this.repApplyDate = repApplyDate;
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
	 * 属性投保单位客户号的getter方法
	 */

	@Column(name = "APPNO")
	public String getAppNo() {
		return this.appNo;
	}

	/**
	 * 属性投保单位客户号的setter方法
	 */
	public void setAppNo(String appNo) {
		this.appNo = appNo;
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
	 * 属性代理人编码的getter方法
	 */

	@Column(name = "AGENTCODE")
	public String getAgentCode() {
		return this.agentCode;
	}

	/**
	 * 属性代理人编码的setter方法
	 */
	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	/**
	 * 属性代理人组别的getter方法
	 */

	@Column(name = "AGENTGROUP")
	public String getAgentGroup() {
		return this.agentGroup;
	}

	/**
	 * 属性代理人组别的setter方法
	 */
	public void setAgentGroup(String agentGroup) {
		this.agentGroup = agentGroup;
	}

	/**
	 * 属性服务方式的getter方法
	 */

	@Column(name = "SERVICETYPE")
	public String getServiceType() {
		return this.serviceType;
	}

	/**
	 * 属性服务方式的setter方法
	 */
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	/**
	 * 属性是否中介业务标志的getter方法
	 */

	@Column(name = "BUSSINESSFLAG")
	public String getBussinessFlag() {
		return this.bussinessFlag;
	}

	/**
	 * 属性是否中介业务标志的setter方法
	 */
	public void setBussinessFlag(String bussinessFlag) {
		this.bussinessFlag = bussinessFlag;
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
