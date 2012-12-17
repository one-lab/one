package ins.claim.report.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * POJO类LLReportRela
 */
@Entity
@Table(name = "LLREPORTRELA")
public class LLReportRela implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性id */
	private LLReportRelaId id;

	/**
	 * 类LLReportRela的默认构造方法
	 */
	public LLReportRela() {
	}

	/**
	 * 属性id的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "subRptNo", column = @Column(name = "SUBRPTNO")),
			@AttributeOverride(name = "rptNo", column = @Column(name = "RPTNO")) })
	public LLReportRelaId getId() {
		return this.id;
	}

	/**
	 * 属性id的setter方法
	 */
	public void setId(LLReportRelaId id) {
		this.id = id;
	}

}
