package ins.claim.report.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * POJO类LLCaseRela
 */
@Entity
@Table(name = "LLCASERELA")
public class LLCaseRela implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性id */
	private LLCaseRelaId id;

	/**
	 * 类LLCaseRela的默认构造方法
	 */
	public LLCaseRela() {
	}

	/**
	 * 属性id的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "caseRelaNo", column = @Column(name = "CASERELANO")),
			@AttributeOverride(name = "caseNo", column = @Column(name = "CASENO")),
			@AttributeOverride(name = "subRptNo", column = @Column(name = "SUBRPTNO")) })
	public LLCaseRelaId getId() {
		return this.id;
	}

	/**
	 * 属性id的setter方法
	 */
	public void setId(LLCaseRelaId id) {
		this.id = id;
	}

}
