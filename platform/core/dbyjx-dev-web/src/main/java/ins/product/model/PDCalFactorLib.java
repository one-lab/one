package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * POJO类PDCalFactorLib
 */
@Entity
@Table(name = "PD_CALFACTOR_LIB")
public class PDCalFactorLib implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性要素代码 */
	private String factorCode;

	/** 属性要素名称 */
	private String factorName;

	/** 属性要素属性 */
	private String factorType;

	/** 属性要素性质 */
	private String factorKind;

	/** 属性要素模块 */
	private String factorModule;

	/** 属性要素数据类型 */
	private String factorDataType;

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

	/** 属性Standbyflag1 */
	private String standbyflag1;

	/** 属性Standbyflag2 */
	private String standbyflag2;

	/** 属性Standbyflag3 */
	private BigDecimal standbyflag3;

	/** 属性Standbyflag4 */
	private BigDecimal standbyflag4;

	/** 属性Standbyflag5 */
	private BigDecimal standbyflag5;

	/** 属性Standbyflag6 */
	private BigDecimal standbyflag6;

	/**
	 * 类PDCalFactorLib的默认构造方法
	 */
	public PDCalFactorLib() {
	}

	/**
	 * 属性要素代码的getter方法
	 */
	@Id
	@Column(name = "FACTORCODE")
	public String getFactorCode() {
		return this.factorCode;
	}

	/**
	 * 属性要素代码的setter方法
	 */
	public void setFactorCode(String factorCode) {
		this.factorCode = factorCode;
	}

	/**
	 * 属性要素名称的getter方法
	 */

	@Column(name = "FACTORNAME")
	public String getFactorName() {
		return this.factorName;
	}

	/**
	 * 属性要素名称的setter方法
	 */
	public void setFactorName(String factorName) {
		this.factorName = factorName;
	}

	/**
	 * 属性要素属性的getter方法
	 */

	@Column(name = "FACTORTYPE")
	public String getFactorType() {
		return this.factorType;
	}

	/**
	 * 属性要素属性的setter方法
	 */
	public void setFactorType(String factorType) {
		this.factorType = factorType;
	}

	/**
	 * 属性要素性质的getter方法
	 */

	@Column(name = "FACTORKIND")
	public String getFactorKind() {
		return this.factorKind;
	}

	/**
	 * 属性要素性质的setter方法
	 */
	public void setFactorKind(String factorKind) {
		this.factorKind = factorKind;
	}

	/**
	 * 属性要素模块的getter方法
	 */

	@Column(name = "FACTORMODULE")
	public String getFactorModule() {
		return this.factorModule;
	}

	/**
	 * 属性要素模块的setter方法
	 */
	public void setFactorModule(String factorModule) {
		this.factorModule = factorModule;
	}

	/**
	 * 属性要素数据类型的getter方法
	 */

	@Column(name = "FACTORDATATYPE")
	public String getFactorDataType() {
		return this.factorDataType;
	}

	/**
	 * 属性要素数据类型的setter方法
	 */
	public void setFactorDataType(String factorDataType) {
		this.factorDataType = factorDataType;
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
	 * 属性Standbyflag1的getter方法
	 */

	@Column(name = "STANDBYFLAG1")
	public String getStandbyflag1() {
		return this.standbyflag1;
	}

	/**
	 * 属性Standbyflag1的setter方法
	 */
	public void setStandbyflag1(String standbyflag1) {
		this.standbyflag1 = standbyflag1;
	}

	/**
	 * 属性Standbyflag2的getter方法
	 */

	@Column(name = "STANDBYFLAG2")
	public String getStandbyflag2() {
		return this.standbyflag2;
	}

	/**
	 * 属性Standbyflag2的setter方法
	 */
	public void setStandbyflag2(String standbyflag2) {
		this.standbyflag2 = standbyflag2;
	}

	/**
	 * 属性Standbyflag3的getter方法
	 */

	@Column(name = "STANDBYFLAG3")
	public BigDecimal getStandbyflag3() {
		return this.standbyflag3;
	}

	/**
	 * 属性Standbyflag3的setter方法
	 */
	public void setStandbyflag3(BigDecimal standbyflag3) {
		this.standbyflag3 = standbyflag3;
	}

	/**
	 * 属性Standbyflag4的getter方法
	 */

	@Column(name = "STANDBYFLAG4")
	public BigDecimal getStandbyflag4() {
		return this.standbyflag4;
	}

	/**
	 * 属性Standbyflag4的setter方法
	 */
	public void setStandbyflag4(BigDecimal standbyflag4) {
		this.standbyflag4 = standbyflag4;
	}

	/**
	 * 属性Standbyflag5的getter方法
	 */

	@Column(name = "STANDBYFLAG5")
	public BigDecimal getStandbyflag5() {
		return this.standbyflag5;
	}

	/**
	 * 属性Standbyflag5的setter方法
	 */
	public void setStandbyflag5(BigDecimal standbyflag5) {
		this.standbyflag5 = standbyflag5;
	}

	/**
	 * 属性Standbyflag6的getter方法
	 */

	@Column(name = "STANDBYFLAG6")
	public BigDecimal getStandbyflag6() {
		return this.standbyflag6;
	}

	/**
	 * 属性Standbyflag6的setter方法
	 */
	public void setStandbyflag6(BigDecimal standbyflag6) {
		this.standbyflag6 = standbyflag6;
	}

}
