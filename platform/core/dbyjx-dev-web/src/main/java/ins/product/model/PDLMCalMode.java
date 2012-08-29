package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * POJO类PDLMCalMode
 */
@Entity
@Table(name = "PD_LMCALMODE")
public class PDLMCalMode implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性佣金计算编码 */
	private String calCode;

	/** 属性险种代码 */
	private String riskCode;

	/** 属性算法模板类型 */
	private String type;

	/** 属性算法内容 */
	private String calSQL;

	/** 属性描述 */
	private String remark;

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

	/** 属性PDLMUWs */
	private List<PDLMUW> PDLMUWs = new ArrayList<PDLMUW>(0);

	/** 属性PDLMEdorCals */
	private List<PDLMEdorCal> PDLMEdorCals = new ArrayList<PDLMEdorCal>(0);

	/** 属性PDLMDutyGets */
	private List<PDLMDutyGet> PDLMDutyGets = new ArrayList<PDLMDutyGet>(0);

	/** 属性PDLMCalFactors */
	private List<PDLMCalFactor> PDLMCalFactors = new ArrayList<PDLMCalFactor>(0);

	/** 属性PDLMDutyGetAliveLibs */
	private List<PDLMDutyGetAliveLib> PDLMDutyGetAliveLibs = new ArrayList<PDLMDutyGetAliveLib>(
			0);

	/**
	 * 类PDLMCalMode的默认构造方法
	 */
	public PDLMCalMode() {
	}

	/**
	 * 属性佣金计算编码的getter方法
	 */
	@Id
	@Column(name = "CALCODE")
	public String getCalCode() {
		return this.calCode;
	}

	/**
	 * 属性佣金计算编码的setter方法
	 */
	public void setCalCode(String calCode) {
		this.calCode = calCode;
	}

	/**
	 * 属性险种代码的getter方法
	 */

	@Column(name = "RISKCODE")
	public String getRiskCode() {
		return this.riskCode;
	}

	/**
	 * 属性险种代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	/**
	 * 属性算法模板类型的getter方法
	 */

	@Column(name = "TYPE")
	public String getType() {
		return this.type;
	}

	/**
	 * 属性算法模板类型的setter方法
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 属性算法内容的getter方法
	 */

	@Column(name = "CALSQL")
	public String getCalSQL() {
		return this.calSQL;
	}

	/**
	 * 属性算法内容的setter方法
	 */
	public void setCalSQL(String calSQL) {
		this.calSQL = calSQL;
	}

	/**
	 * 属性描述的getter方法
	 */

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	/**
	 * 属性描述的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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

	/**
	 * 属性PDLMUWs的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PDLMCalMode")
	public List<PDLMUW> getPDLMUWs() {
		return this.PDLMUWs;
	}

	/**
	 * 属性PDLMUWs的setter方法
	 */
	public void setPDLMUWs(List<PDLMUW> PDLMUWs) {
		this.PDLMUWs = PDLMUWs;
	}

	/**
	 * 属性PDLMEdorCals的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PDLMCalMode")
	public List<PDLMEdorCal> getPDLMEdorCals() {
		return this.PDLMEdorCals;
	}

	/**
	 * 属性PDLMEdorCals的setter方法
	 */
	public void setPDLMEdorCals(List<PDLMEdorCal> PDLMEdorCals) {
		this.PDLMEdorCals = PDLMEdorCals;
	}

	/**
	 * 属性PDLMDutyGets的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PDLMCalMode")
	public List<PDLMDutyGet> getPDLMDutyGets() {
		return this.PDLMDutyGets;
	}

	/**
	 * 属性PDLMDutyGets的setter方法
	 */
	public void setPDLMDutyGets(List<PDLMDutyGet> PDLMDutyGets) {
		this.PDLMDutyGets = PDLMDutyGets;
	}

	/**
	 * 属性PDLMCalFactors的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PDLMCalMode")
	public List<PDLMCalFactor> getPDLMCalFactors() {
		return this.PDLMCalFactors;
	}

	/**
	 * 属性PDLMCalFactors的setter方法
	 */
	public void setPDLMCalFactors(List<PDLMCalFactor> PDLMCalFactors) {
		this.PDLMCalFactors = PDLMCalFactors;
	}

	/**
	 * 属性PDLMDutyGetAliveLibs的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PDLMCalMode")
	public List<PDLMDutyGetAliveLib> getPDLMDutyGetAliveLibs() {
		return this.PDLMDutyGetAliveLibs;
	}

	/**
	 * 属性PDLMDutyGetAliveLibs的setter方法
	 */
	public void setPDLMDutyGetAliveLibs(
			List<PDLMDutyGetAliveLib> PDLMDutyGetAliveLibs) {
		this.PDLMDutyGetAliveLibs = PDLMDutyGetAliveLibs;
	}

}
