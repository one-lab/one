package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.xwork.StringUtils;

/**
 * POJO类PDLMUW
 */
@Entity
@Table(name = "PD_LMUW")
public class PDLMUW implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性核保编码 */
	private String uwCode;

	/** 属性险种定义 */
	private PDLMRisk PDLMRisk;

	/** 属性算法表 */
	private PDLMCalMode PDLMCalMode;

	/** 属性险种版本 */
	private String riskVer;

	/** 属性险种名称 */
	private String riskName;

	/** 属性关联保单类型 */
	private String relaPolType;

	/** 属性核保类型 */
	private String uwType;

	/** 属性核保顺序号 */
	private BigDecimal uwOrder;

	/** 属性其他算法 */
	private String othCalCode;

	/** 属性描述 */
	private String remark;

	/** 属性核保级别 */
	private String uwGrade;

	/** 属性核保结果控制 */
	private String uwResult;

	/** 属性核保通过标记 */
	private String passFlag;

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

	/** 属性Standbyflag2 */
	private String standbyflag2;

	/** 属性Standbyflag1 */
	private String standbyflag1;

	/** 属性Standbyflag3 */
	private BigDecimal standbyflag3;

	/** 属性Standbyflag4 */
	private BigDecimal standbyflag4;

	/** 属性Standbyflag6 */
	private BigDecimal standbyflag6;

	/** 属性Standbyflag5 */
	private BigDecimal standbyflag5;

	/**
	 * 类PDLMUW的默认构造方法
	 */
	public PDLMUW() {
	}

	/**
	 * 属性核保编码的getter方法
	 */
	@Id
	@Column(name = "UWCODE")
	public String getUwCode() {
		return this.uwCode;
	}

	/**
	 * 属性核保编码的setter方法
	 */
	public void setUwCode(String uwCode) {
		this.uwCode = uwCode;
	}

	/**
	 * 属性险种定义的getter方法
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RISKCODE", nullable = false)
	public PDLMRisk getPDLMRisk() {
		return this.PDLMRisk;
	}

	/**
	 * 属性险种定义的setter方法
	 */
	public void setPDLMRisk(PDLMRisk PDLMRisk) {
		this.PDLMRisk = PDLMRisk;
	}

	/**
	 * 属性算法表的getter方法
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CALCODE", nullable = false)
	public PDLMCalMode getPDLMCalMode() {
		return this.PDLMCalMode;
	}

	/**
	 * 属性算法表的setter方法
	 */
	public void setPDLMCalMode(PDLMCalMode PDLMCalMode) {
		this.PDLMCalMode = PDLMCalMode;
	}

	/**
	 * 属性险种版本的getter方法
	 */

	@Column(name = "RISKVER")
	public String getRiskVer() {
		return this.riskVer;
	}

	/**
	 * 属性险种版本的setter方法
	 */
	public void setRiskVer(String riskVer) {
		this.riskVer = riskVer;
	}

	/**
	 * 属性险种名称的getter方法
	 */

	@Column(name = "RISKNAME")
	public String getRiskName() {
		return this.riskName;
	}

	/**
	 * 属性险种名称的setter方法
	 */
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	/**
	 * 属性关联保单类型的getter方法
	 */

	@Column(name = "RELAPOLTYPE")
	public String getRelaPolType() {
		return this.relaPolType;
	}

	/**
	 * 属性关联保单类型的setter方法
	 */
	public void setRelaPolType(String relaPolType) {
		this.relaPolType = relaPolType;
	}

	/**
	 * 属性核保类型的getter方法
	 */

	@Column(name = "UWTYPE")
	public String getUwType() {
		return this.uwType;
	}

	/**
	 * 属性核保类型的setter方法
	 */
	public void setUwType(String uwType) {
		this.uwType = uwType;
	}

	/**
	 * 属性核保顺序号的getter方法
	 */

	@Column(name = "UWORDER")
	public BigDecimal getUwOrder() {
		return this.uwOrder;
	}

	/**
	 * 属性核保顺序号的setter方法
	 */
	public void setUwOrder(BigDecimal uwOrder) {
		this.uwOrder = uwOrder;
	}

	/**
	 * 属性其他算法的getter方法
	 */

	@Column(name = "OTHCALCODE")
	public String getOthCalCode() {
		return this.othCalCode;
	}

	/**
	 * 属性其他算法的setter方法
	 */
	public void setOthCalCode(String othCalCode) {
		this.othCalCode = othCalCode;
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
	 * 属性核保级别的getter方法
	 */

	@Column(name = "UWGRADE")
	public String getUwGrade() {
		return this.uwGrade;
	}

	/**
	 * 属性核保级别的setter方法
	 */
	public void setUwGrade(String uwGrade) {
		this.uwGrade = uwGrade;
	}

	/**
	 * 属性核保结果控制的getter方法
	 */

	@Column(name = "UWRESULT")
	public String getUwResult() {
		return this.uwResult;
	}

	/**
	 * 属性核保结果控制的setter方法
	 */
	public void setUwResult(String uwResult) {
		this.uwResult = uwResult;
	}

	/**
	 * 属性核保通过标记的getter方法
	 */

	@Column(name = "PASSFLAG")
	public String getPassFlag() {
		return this.passFlag;
	}

	/**
	 * 属性核保通过标记的setter方法
	 */
	public void setPassFlag(String passFlag) {
		this.passFlag = passFlag;
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
	 * 根据属性名获取值
	 * @param fieldType
	 * @return
	 */
	public String getFieldValue(String fieldType){
		try {
			if(null == BeanUtils.getProperty(this, fieldType)){
				return StringUtils.EMPTY;
			}else{				
				return BeanUtils.getProperty(this, fieldType).toString();
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return StringUtils.EMPTY;
	}
}
