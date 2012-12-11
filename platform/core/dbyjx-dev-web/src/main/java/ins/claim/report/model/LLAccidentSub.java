package ins.claim.report.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * POJO类LLAccidentSub
 */
@Entity
@Table(name = "LLACCIDENTSUB")
public class LLAccidentSub implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性id */
	private LLAccidentSubId id;

	/** 属性出险人状态 */
	private String customerState;

	/**
	 * 类LLAccidentSub的默认构造方法
	 */
	public LLAccidentSub() {
	}

	/**
	 * 属性id的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "accNo", column = @Column(name = "ACCNO")),
			@AttributeOverride(name = "customerNo", column = @Column(name = "CUSTOMERNO")) })
	public LLAccidentSubId getId() {
		return this.id;
	}

	/**
	 * 属性id的setter方法
	 */
	public void setId(LLAccidentSubId id) {
		this.id = id;
	}

	/**
	 * 属性出险人状态的getter方法
	 */

	@Column(name = "CUSTOMERSTATE")
	public String getCustomerState() {
		return this.customerState;
	}

	/**
	 * 属性出险人状态的setter方法
	 */
	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

}
