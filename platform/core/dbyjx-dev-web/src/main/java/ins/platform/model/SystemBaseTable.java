package ins.platform.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * POJO类SystemBaseTable
 */
@Entity
@Table(name = "SYSTEM_BASETABLE")
public class SystemBaseTable implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性ID */
	private SystemBaseTableId id;

	/**
	 * 类SystemBaseTable的默认构造方法
	 */
	public SystemBaseTable() {
	}

	/**
	 * 属性ID的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "systemCode", column = @Column(name = "SYSTEMCODE")),
			@AttributeOverride(name = "systemname", column = @Column(name = "SYSTEMNAME")),
			@AttributeOverride(name = "tablecode", column = @Column(name = "TABLECODE")),
			@AttributeOverride(name = "tableName", column = @Column(name = "TABLENAME")),
			@AttributeOverride(name = "memo", column = @Column(name = "MEMO")),
			@AttributeOverride(name = "serialNo", column = @Column(name = "SERIALNO")) })
	public SystemBaseTableId getId() {
		return this.id;
	}

	/**
	 * 属性ID的setter方法
	 */
	public void setId(SystemBaseTableId id) {
		this.id = id;
	}

}
