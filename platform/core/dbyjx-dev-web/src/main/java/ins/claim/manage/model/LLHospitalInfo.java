package ins.claim.manage.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * POJO类LLHospitalInfo
 */
@Entity
@Table(name = "LLHOSPITALINFO")
public class LLHospitalInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性医院代码 */
	private String hospitalCode;

	/** 属性医院名称 */
	private String hospitalName;

	/** 属性医院等级 */
	private String hospitalGrade;

	/** 属性定点标志 */
	private String appointFlag;

	/** 属性医院状态 */
	private String hospitalState;

	/** 属性医院地址 */
	private String hospitalAdd;

	/** 属性省 */
	private String province;

	/** 属性市 */
	private String city;

	/** 属性区/县 */
	private String county;

	/** 属性街道 */
	private String street;

	/** 属性残疾鉴定资质标志 */
	private String defoAppraFlag;

	/** 属性联系电话 */
	private String tel;

	/** 属性区号 */
	private String areaCode;

	/** 属性电话号码 */
	private String telephone;

	/** 属性分机号 */
	private String extenNo;

	/** 属性评估分数 */
	private String assessGoal;

	/** 属性管理机构 */
	private String mngCom;

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

	/**
	 * 类LLHospitalInfo的默认构造方法
	 */
	public LLHospitalInfo() {
	}

	/**
	 * 属性医院代码的getter方法
	 */
	@Id
	@Column(name = "HOSPITALCODE")
	public String getHospitalCode() {
		return this.hospitalCode;
	}

	/**
	 * 属性医院代码的setter方法
	 */
	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	/**
	 * 属性医院名称的getter方法
	 */

	@Column(name = "HOSPITALNAME")
	public String getHospitalName() {
		return this.hospitalName;
	}

	/**
	 * 属性医院名称的setter方法
	 */
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	/**
	 * 属性医院等级的getter方法
	 */

	@Column(name = "HOSPITALGRADE")
	public String getHospitalGrade() {
		return this.hospitalGrade;
	}

	/**
	 * 属性医院等级的setter方法
	 */
	public void setHospitalGrade(String hospitalGrade) {
		this.hospitalGrade = hospitalGrade;
	}

	/**
	 * 属性定点标志的getter方法
	 */

	@Column(name = "APPOINTFLAG")
	public String getAppointFlag() {
		return this.appointFlag;
	}

	/**
	 * 属性定点标志的setter方法
	 */
	public void setAppointFlag(String appointFlag) {
		this.appointFlag = appointFlag;
	}

	/**
	 * 属性医院状态的getter方法
	 */

	@Column(name = "HOSPITALSTATE")
	public String getHospitalState() {
		return this.hospitalState;
	}

	/**
	 * 属性医院状态的setter方法
	 */
	public void setHospitalState(String hospitalState) {
		this.hospitalState = hospitalState;
	}

	/**
	 * 属性医院地址的getter方法
	 */

	@Column(name = "HOSPITALADD")
	public String getHospitalAdd() {
		return this.hospitalAdd;
	}

	/**
	 * 属性医院地址的setter方法
	 */
	public void setHospitalAdd(String hospitalAdd) {
		this.hospitalAdd = hospitalAdd;
	}

	/**
	 * 属性省的getter方法
	 */

	@Column(name = "PROVINCE")
	public String getProvince() {
		return this.province;
	}

	/**
	 * 属性省的setter方法
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * 属性市的getter方法
	 */

	@Column(name = "CITY")
	public String getCity() {
		return this.city;
	}

	/**
	 * 属性市的setter方法
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 属性区/县的getter方法
	 */

	@Column(name = "COUNTY")
	public String getCounty() {
		return this.county;
	}

	/**
	 * 属性区/县的setter方法
	 */
	public void setCounty(String county) {
		this.county = county;
	}

	/**
	 * 属性街道的getter方法
	 */

	@Column(name = "STREET")
	public String getStreet() {
		return this.street;
	}

	/**
	 * 属性街道的setter方法
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * 属性残疾鉴定资质标志的getter方法
	 */

	@Column(name = "DEFOAPPRAFLAG")
	public String getDefoAppraFlag() {
		return this.defoAppraFlag;
	}

	/**
	 * 属性残疾鉴定资质标志的setter方法
	 */
	public void setDefoAppraFlag(String defoAppraFlag) {
		this.defoAppraFlag = defoAppraFlag;
	}

	/**
	 * 属性联系电话的getter方法
	 */

	@Column(name = "TEL")
	public String getTel() {
		return this.tel;
	}

	/**
	 * 属性联系电话的setter方法
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * 属性区号的getter方法
	 */

	@Column(name = "AREACODE")
	public String getAreaCode() {
		return this.areaCode;
	}

	/**
	 * 属性区号的setter方法
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * 属性电话号码的getter方法
	 */

	@Column(name = "TELEPHONE")
	public String getTelephone() {
		return this.telephone;
	}

	/**
	 * 属性电话号码的setter方法
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * 属性分机号的getter方法
	 */

	@Column(name = "EXTENNO")
	public String getExtenNo() {
		return this.extenNo;
	}

	/**
	 * 属性分机号的setter方法
	 */
	public void setExtenNo(String extenNo) {
		this.extenNo = extenNo;
	}

	/**
	 * 属性评估分数的getter方法
	 */

	@Column(name = "ASSESSGOAL")
	public String getAssessGoal() {
		return this.assessGoal;
	}

	/**
	 * 属性评估分数的setter方法
	 */
	public void setAssessGoal(String assessGoal) {
		this.assessGoal = assessGoal;
	}

	/**
	 * 属性管理机构的getter方法
	 */

	@Column(name = "MNGCOM")
	public String getMngCom() {
		return this.mngCom;
	}

	/**
	 * 属性管理机构的setter方法
	 */
	public void setMngCom(String mngCom) {
		this.mngCom = mngCom;
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

}
