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
 * POJO类LCGrpInsuredInfoReport
 */
@Entity
@Table(name = "LCGRPINSUREDINFOREPORT")
public class LCGrpInsuredInfoReport implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性ID */
	private LCGrpInsuredInfoReportId id;

	/** 属性类别 */
	private String type;

	/** 属性类别名称 */
	private String typeName;

	/** 属性类别数值 */
	private String typeValue;

	/** 属性人数 */
	private String peoples;

	/** 属性投保率 */
	private String rate;

	/** 属性被保人最大年龄 */
	private String maxAge;

	/** 属性被保人最小年龄 */
	private String minAge;

	/** 属性被保人平均年龄 */
	private String averAge;

	/** 属性保险计划编码 */
	private String contPlanCode;

	/** 属性保险计划名称 */
	private String contPlanName;

	/** 属性管理机构 */
	private String manageCom;

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

	/** 属性备用属性字段1 */
	private String standbyFlag1;

	/**
	 * 类LCGrpInsuredInfoReport的默认构造方法
	 */
	public LCGrpInsuredInfoReport() {
	}

	/**
	 * 属性ID的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "repNo", column = @Column(name = "REPNO")),
			@AttributeOverride(name = "serialNo", column = @Column(name = "SERIALNO")) })
	public LCGrpInsuredInfoReportId getId() {
		return this.id;
	}

	/**
	 * 属性ID的setter方法
	 */
	public void setId(LCGrpInsuredInfoReportId id) {
		this.id = id;
	}

	/**
	 * 属性类别的getter方法
	 */

	@Column(name = "TYPE")
	public String getType() {
		return this.type;
	}

	/**
	 * 属性类别的setter方法
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 属性类别名称的getter方法
	 */

	@Column(name = "TYPENAME")
	public String getTypeName() {
		return this.typeName;
	}

	/**
	 * 属性类别名称的setter方法
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * 属性类别数值的getter方法
	 */

	@Column(name = "TYPEVALUE")
	public String getTypeValue() {
		return this.typeValue;
	}

	/**
	 * 属性类别数值的setter方法
	 */
	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
	}

	/**
	 * 属性人数的getter方法
	 */

	@Column(name = "PEOPLES")
	public String getPeoples() {
		return this.peoples;
	}

	/**
	 * 属性人数的setter方法
	 */
	public void setPeoples(String peoples) {
		this.peoples = peoples;
	}

	/**
	 * 属性投保率的getter方法
	 */

	@Column(name = "RATE")
	public String getRate() {
		return this.rate;
	}

	/**
	 * 属性投保率的setter方法
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}

	/**
	 * 属性被保人最大年龄的getter方法
	 */

	@Column(name = "MAXAGE")
	public String getMaxAge() {
		return this.maxAge;
	}

	/**
	 * 属性被保人最大年龄的setter方法
	 */
	public void setMaxAge(String maxAge) {
		this.maxAge = maxAge;
	}

	/**
	 * 属性被保人最小年龄的getter方法
	 */

	@Column(name = "MINAGE")
	public String getMinAge() {
		return this.minAge;
	}

	/**
	 * 属性被保人最小年龄的setter方法
	 */
	public void setMinAge(String minAge) {
		this.minAge = minAge;
	}

	/**
	 * 属性被保人平均年龄的getter方法
	 */

	@Column(name = "AVERAGE")
	public String getAverAge() {
		return this.averAge;
	}

	/**
	 * 属性被保人平均年龄的setter方法
	 */
	public void setAverAge(String averAge) {
		this.averAge = averAge;
	}

	/**
	 * 属性保险计划编码的getter方法
	 */

	@Column(name = "CONTPLANCODE")
	public String getContPlanCode() {
		return this.contPlanCode;
	}

	/**
	 * 属性保险计划编码的setter方法
	 */
	public void setContPlanCode(String contPlanCode) {
		this.contPlanCode = contPlanCode;
	}

	/**
	 * 属性保险计划名称的getter方法
	 */

	@Column(name = "CONTPLANNAME")
	public String getContPlanName() {
		return this.contPlanName;
	}

	/**
	 * 属性保险计划名称的setter方法
	 */
	public void setContPlanName(String contPlanName) {
		this.contPlanName = contPlanName;
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

}
