package ins.common.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * POJO类LDMaxNo
 */
@Entity
@Table(name = "LDMAXNO")
public class LDMaxNo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性ID */
	private LDMaxNoId id;

	/** 属性编号 */
	private String maxNo;

	/** 属性标志 */
	private String flag;

	/**
	 * 类LDMaxNo的默认构造方法
	 */
	public LDMaxNo() {
	}

	/**
	 * 属性ID的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "groupNo", column = @Column(name = "GROUPNO")),
			@AttributeOverride(name = "yearno", column = @Column(name = "YEARNO")),
			@AttributeOverride(name = "tableName", column = @Column(name = "TABLENAME")),
			@AttributeOverride(name = "fieldName", column = @Column(name = "FIELDNAME")) })
	public LDMaxNoId getId() {
		return this.id;
	}

	/**
	 * 属性ID的setter方法
	 */
	public void setId(LDMaxNoId id) {
		this.id = id;
	}

	/**
	 * 属性编号的getter方法
	 */

	@Column(name = "MAXNO")
	public String getMaxNo() {
		return this.maxNo;
	}

	/**
	 * 属性编号的setter方法
	 */
	public void setMaxNo(String maxNo) {
		this.maxNo = maxNo;
	}

	/**
	 * 属性标志的getter方法
	 */

	@Column(name = "FLAG")
	public String getFlag() {
		return this.flag;
	}

	/**
	 * 属性标志的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

}
