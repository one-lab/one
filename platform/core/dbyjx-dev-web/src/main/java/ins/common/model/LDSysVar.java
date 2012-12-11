package ins.common.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * POJO类LDSysVar
 */
@Entity
@Table(name = "LDSYSVAR")
public class LDSysVar implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性变量参数 */
	private String sysVar;

	/** 属性参数类型 */
	private String sysVarType;

	/** 属性参数值 */
	private String sysVarValue;

	/**
	 * 类LDSysVar的默认构造方法
	 */
	public LDSysVar() {
	}

	/**
	 * 属性变量参数的getter方法
	 */
	@Id
	@Column(name = "SYSVAR")
	public String getSysVar() {
		return this.sysVar;
	}

	/**
	 * 属性变量参数的setter方法
	 */
	public void setSysVar(String sysVar) {
		this.sysVar = sysVar;
	}

	/**
	 * 属性参数类型的getter方法
	 */

	@Column(name = "SYSVARTYPE")
	public String getSysVarType() {
		return this.sysVarType;
	}

	/**
	 * 属性参数类型的setter方法
	 */
	public void setSysVarType(String sysVarType) {
		this.sysVarType = sysVarType;
	}

	/**
	 * 属性参数值的getter方法
	 */

	@Column(name = "SYSVARVALUE")
	public String getSysVarValue() {
		return this.sysVarValue;
	}

	/**
	 * 属性参数值的setter方法
	 */
	public void setSysVarValue(String sysVarValue) {
		this.sysVarValue = sysVarValue;
	}

}
