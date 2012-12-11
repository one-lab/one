package ins.common.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * POJO类LDUtiKey
 */
@Entity
@Table(name = "LDUTIKEY")
public class LDUtiKey implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性ID */
	private LDUtiKeyId id;

	/** 属性名称 */
	private String fieldMeaning;

	/** 属性单号长度 */
	private Long colLength;

	/** 属性单号首字符 */
	private String headId;

	/** 属性标志 */
	private String flag;

	/** 属性comcodelength */
	private Long comcodelength;

	/**
	 * 类LDUtiKey的默认构造方法
	 */
	public LDUtiKey() {
	}

	/**
	 * 属性ID的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "tableName", column = @Column(name = "TABLENAME")),
			@AttributeOverride(name = "fieldName", column = @Column(name = "FIELDNAME")) })
	public LDUtiKeyId getId() {
		return this.id;
	}

	/**
	 * 属性ID的setter方法
	 */
	public void setId(LDUtiKeyId id) {
		this.id = id;
	}

	/**
	 * 属性名称的getter方法
	 */

	@Column(name = "FIELDMEANING")
	public String getFieldMeaning() {
		return this.fieldMeaning;
	}

	/**
	 * 属性名称的setter方法
	 */
	public void setFieldMeaning(String fieldMeaning) {
		this.fieldMeaning = fieldMeaning;
	}

	/**
	 * 属性单号长度的getter方法
	 */

	@Column(name = "COLLENGTH")
	public Long getColLength() {
		return this.colLength;
	}

	/**
	 * 属性单号长度的setter方法
	 */
	public void setColLength(Long colLength) {
		this.colLength = colLength;
	}

	/**
	 * 属性单号首字符的getter方法
	 */

	@Column(name = "HEADID")
	public String getHeadId() {
		return this.headId;
	}

	/**
	 * 属性单号首字符的setter方法
	 */
	public void setHeadId(String headId) {
		this.headId = headId;
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

	/**
	 * 属性comcodelength的getter方法
	 */

	@Column(name = "COMCODELENGTH")
	public Long getComcodelength() {
		return this.comcodelength;
	}

	/**
	 * 属性comcodelength的setter方法
	 */
	public void setComcodelength(Long comcodelength) {
		this.comcodelength = comcodelength;
	}

}
