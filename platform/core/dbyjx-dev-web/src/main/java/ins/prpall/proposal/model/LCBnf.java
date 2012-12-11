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
 * POJO类LCBnf
 */
@Entity
@Table(name = "LCBNF")
public class LCBnf implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性ID */
	private LCBnfId id;

	/** 属性合同号码 */
	private String contNo;

	/** 属性与被保人关系 */
	private String relationToInsured;

	/** 属性受益份额 */
	private BigDecimal bnfLot;

	/** 属性客户号码 */
	private String customerNo;

	/** 属性名称 */
	private String name;

	/** 属性性别 */
	private String sex;

	/** 属性出生日期 */
	private Date birthday;

	/** 属性证件类型 */
	private String idType;

	/** 属性证件号码 */
	private String idNo;

	/** 属性操作员 */
	private String operator;

	/** 属性生产日期 */
	private Date makeDate;

	/** 属性入机时间 */
	private String makeTime;

	/** 属性最后一次修改日期 */
	private Date modifyDate;

	/** 属性修改时间 */
	private String modifyTime;

	/**
	 * 类LCBnf的默认构造方法
	 */
	public LCBnf() {
	}

	/**
	 * 属性ID的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "polNo", column = @Column(name = "POLNO")),
			@AttributeOverride(name = "insuredNo", column = @Column(name = "INSUREDNO")),
			@AttributeOverride(name = "bnfType", column = @Column(name = "BNFTYPE")),
			@AttributeOverride(name = "bnfNo", column = @Column(name = "BNFNO")),
			@AttributeOverride(name = "bnfGrade", column = @Column(name = "BNFGRADE")) })
	public LCBnfId getId() {
		return this.id;
	}

	/**
	 * 属性ID的setter方法
	 */
	public void setId(LCBnfId id) {
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
	 * 属性与被保人关系的getter方法
	 */

	@Column(name = "RELATIONTOINSURED")
	public String getRelationToInsured() {
		return this.relationToInsured;
	}

	/**
	 * 属性与被保人关系的setter方法
	 */
	public void setRelationToInsured(String relationToInsured) {
		this.relationToInsured = relationToInsured;
	}

	/**
	 * 属性受益份额的getter方法
	 */

	@Column(name = "BNFLOT")
	public BigDecimal getBnfLot() {
		return this.bnfLot;
	}

	/**
	 * 属性受益份额的setter方法
	 */
	public void setBnfLot(BigDecimal bnfLot) {
		this.bnfLot = bnfLot;
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
	 * 属性名称的getter方法
	 */

	@Column(name = "NAME")
	public String getName() {
		return this.name;
	}

	/**
	 * 属性名称的setter方法
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 属性性别的getter方法
	 */

	@Column(name = "SEX")
	public String getSex() {
		return this.sex;
	}

	/**
	 * 属性性别的setter方法
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 属性出生日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDAY")
	public Date getBirthday() {
		return this.birthday;
	}

	/**
	 * 属性出生日期的setter方法
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * 属性证件类型的getter方法
	 */

	@Column(name = "IDTYPE")
	public String getIdType() {
		return this.idType;
	}

	/**
	 * 属性证件类型的setter方法
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}

	/**
	 * 属性证件号码的getter方法
	 */

	@Column(name = "IDNO")
	public String getIdNo() {
		return this.idNo;
	}

	/**
	 * 属性证件号码的setter方法
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
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

}
