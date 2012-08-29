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
 * POJO类PDLMDutyGetClmLib
 */
@Entity
@Table(name = "PD_LMDUTYGETCLM_LIB")
public class PDLMDutyGetClmLib implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性责任给付库代码 */
	private String getDutyCode2;

	/** 属性佣金计算编码 */
	private String calCode;

	/** 属性给付名称 */
	private String getDutyName;

	/** 属性给付责任类型 */
	private String getDutyKind;

	/** 属性默认值 */
	private BigDecimal defaultVal;

	/** 属性反算算法 */
	private String cnterCalCode;

	/** 属性其他算法 */
	private String othCalCode;

	/** 属性录入标志 */
	private String inpFlag;

	/** 属性统计类别 */
	private String statType;

	/** 属性起付限 */
	private BigDecimal minGet;

	/** 属性给付后动作 */
	private String afterGet;

	/** 属性赔付限额 */
	private BigDecimal maxGet;

	/** 属性赔付比例 */
	private BigDecimal claimRate;

	/** 属性赔付天数限额 */
	private BigDecimal clmDayLmt;

	/** 属性累计赔付天数限额 */
	private BigDecimal sumClmDayLmt;

	/** 属性免赔额 */
	private BigDecimal deductible;

	/** 属性免赔天数 */
	private BigDecimal deDuctDay;

	/** 属性观察期 */
	private BigDecimal obsPeriod;

	/** 属性被保人死亡后有效标记 */
	private String deadValiFlag;

	/** 属性死亡给付与现值关系 */
	private String deadToPValueFlag;

	/** 属性领取时是否需要重新计算 */
	private String needReCompute;

	/** 属性给付类型 */
	private String casePolType;

	/** 属性伤残级别 */
	private String deformityGrade;

	/** 属性责任匹配算法 */
	private String filterCalCode;

	/** 属性赔付影响主险类型 */
	private String effectOnMainRisk;

	/** 属性额外保障标记 */
	private String extraAmntFlag;

	/** 属性年度免赔额标记 */
	private String yearGetLimitFlag;

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
	 * 类PDLMDutyGetClmLib的默认构造方法
	 */
	public PDLMDutyGetClmLib() {
	}

	/**
	 * 属性责任给付库代码的getter方法
	 */
	@Id
	@Column(name = "GETDUTYCODE2")
	public String getGetDutyCode2() {
		return this.getDutyCode2;
	}

	/**
	 * 属性责任给付库代码的setter方法
	 */
	public void setGetDutyCode2(String getDutyCode2) {
		this.getDutyCode2 = getDutyCode2;
	}

	/**
	 * 属性佣金计算编码的getter方法
	 */

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
	 * 属性给付名称的getter方法
	 */

	@Column(name = "GETDUTYNAME")
	public String getGetDutyName() {
		return this.getDutyName;
	}

	/**
	 * 属性给付名称的setter方法
	 */
	public void setGetDutyName(String getDutyName) {
		this.getDutyName = getDutyName;
	}

	/**
	 * 属性给付责任类型的getter方法
	 */

	@Column(name = "GETDUTYKIND")
	public String getGetDutyKind() {
		return this.getDutyKind;
	}

	/**
	 * 属性给付责任类型的setter方法
	 */
	public void setGetDutyKind(String getDutyKind) {
		this.getDutyKind = getDutyKind;
	}

	/**
	 * 属性默认值的getter方法
	 */

	@Column(name = "DEFAULTVAL")
	public BigDecimal getDefaultVal() {
		return this.defaultVal;
	}

	/**
	 * 属性默认值的setter方法
	 */
	public void setDefaultVal(BigDecimal defaultVal) {
		this.defaultVal = defaultVal;
	}

	/**
	 * 属性反算算法的getter方法
	 */

	@Column(name = "CNTERCALCODE")
	public String getCnterCalCode() {
		return this.cnterCalCode;
	}

	/**
	 * 属性反算算法的setter方法
	 */
	public void setCnterCalCode(String cnterCalCode) {
		this.cnterCalCode = cnterCalCode;
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
	 * 属性录入标志的getter方法
	 */

	@Column(name = "INPFLAG")
	public String getInpFlag() {
		return this.inpFlag;
	}

	/**
	 * 属性录入标志的setter方法
	 */
	public void setInpFlag(String inpFlag) {
		this.inpFlag = inpFlag;
	}

	/**
	 * 属性统计类别的getter方法
	 */

	@Column(name = "STATTYPE")
	public String getStatType() {
		return this.statType;
	}

	/**
	 * 属性统计类别的setter方法
	 */
	public void setStatType(String statType) {
		this.statType = statType;
	}

	/**
	 * 属性起付限的getter方法
	 */

	@Column(name = "MINGET")
	public BigDecimal getMinGet() {
		return this.minGet;
	}

	/**
	 * 属性起付限的setter方法
	 */
	public void setMinGet(BigDecimal minGet) {
		this.minGet = minGet;
	}

	/**
	 * 属性给付后动作的getter方法
	 */

	@Column(name = "AFTERGET")
	public String getAfterGet() {
		return this.afterGet;
	}

	/**
	 * 属性给付后动作的setter方法
	 */
	public void setAfterGet(String afterGet) {
		this.afterGet = afterGet;
	}

	/**
	 * 属性赔付限额的getter方法
	 */

	@Column(name = "MAXGET")
	public BigDecimal getMaxGet() {
		return this.maxGet;
	}

	/**
	 * 属性赔付限额的setter方法
	 */
	public void setMaxGet(BigDecimal maxGet) {
		this.maxGet = maxGet;
	}

	/**
	 * 属性赔付比例的getter方法
	 */

	@Column(name = "CLAIMRATE")
	public BigDecimal getClaimRate() {
		return this.claimRate;
	}

	/**
	 * 属性赔付比例的setter方法
	 */
	public void setClaimRate(BigDecimal claimRate) {
		this.claimRate = claimRate;
	}

	/**
	 * 属性赔付天数限额的getter方法
	 */

	@Column(name = "CLMDAYLMT")
	public BigDecimal getClmDayLmt() {
		return this.clmDayLmt;
	}

	/**
	 * 属性赔付天数限额的setter方法
	 */
	public void setClmDayLmt(BigDecimal clmDayLmt) {
		this.clmDayLmt = clmDayLmt;
	}

	/**
	 * 属性累计赔付天数限额的getter方法
	 */

	@Column(name = "SUMCLMDAYLMT")
	public BigDecimal getSumClmDayLmt() {
		return this.sumClmDayLmt;
	}

	/**
	 * 属性累计赔付天数限额的setter方法
	 */
	public void setSumClmDayLmt(BigDecimal sumClmDayLmt) {
		this.sumClmDayLmt = sumClmDayLmt;
	}

	/**
	 * 属性免赔额的getter方法
	 */

	@Column(name = "DEDUCTIBLE")
	public BigDecimal getDeductible() {
		return this.deductible;
	}

	/**
	 * 属性免赔额的setter方法
	 */
	public void setDeductible(BigDecimal deductible) {
		this.deductible = deductible;
	}

	/**
	 * 属性免赔天数的getter方法
	 */

	@Column(name = "DEDUCTDAY")
	public BigDecimal getDeDuctDay() {
		return this.deDuctDay;
	}

	/**
	 * 属性免赔天数的setter方法
	 */
	public void setDeDuctDay(BigDecimal deDuctDay) {
		this.deDuctDay = deDuctDay;
	}

	/**
	 * 属性观察期的getter方法
	 */

	@Column(name = "OBSPERIOD")
	public BigDecimal getObsPeriod() {
		return this.obsPeriod;
	}

	/**
	 * 属性观察期的setter方法
	 */
	public void setObsPeriod(BigDecimal obsPeriod) {
		this.obsPeriod = obsPeriod;
	}

	/**
	 * 属性被保人死亡后有效标记的getter方法
	 */

	@Column(name = "DEADVALIFLAG")
	public String getDeadValiFlag() {
		return this.deadValiFlag;
	}

	/**
	 * 属性被保人死亡后有效标记的setter方法
	 */
	public void setDeadValiFlag(String deadValiFlag) {
		this.deadValiFlag = deadValiFlag;
	}

	/**
	 * 属性死亡给付与现值关系的getter方法
	 */

	@Column(name = "DEADTOPVALUEFLAG")
	public String getDeadToPValueFlag() {
		return this.deadToPValueFlag;
	}

	/**
	 * 属性死亡给付与现值关系的setter方法
	 */
	public void setDeadToPValueFlag(String deadToPValueFlag) {
		this.deadToPValueFlag = deadToPValueFlag;
	}

	/**
	 * 属性领取时是否需要重新计算的getter方法
	 */

	@Column(name = "NEEDRECOMPUTE")
	public String getNeedReCompute() {
		return this.needReCompute;
	}

	/**
	 * 属性领取时是否需要重新计算的setter方法
	 */
	public void setNeedReCompute(String needReCompute) {
		this.needReCompute = needReCompute;
	}

	/**
	 * 属性给付类型的getter方法
	 */

	@Column(name = "CASEPOLTYPE")
	public String getCasePolType() {
		return this.casePolType;
	}

	/**
	 * 属性给付类型的setter方法
	 */
	public void setCasePolType(String casePolType) {
		this.casePolType = casePolType;
	}

	/**
	 * 属性伤残级别的getter方法
	 */

	@Column(name = "DEFORMITYGRADE")
	public String getDeformityGrade() {
		return this.deformityGrade;
	}

	/**
	 * 属性伤残级别的setter方法
	 */
	public void setDeformityGrade(String deformityGrade) {
		this.deformityGrade = deformityGrade;
	}

	/**
	 * 属性责任匹配算法的getter方法
	 */

	@Column(name = "FILTERCALCODE")
	public String getFilterCalCode() {
		return this.filterCalCode;
	}

	/**
	 * 属性责任匹配算法的setter方法
	 */
	public void setFilterCalCode(String filterCalCode) {
		this.filterCalCode = filterCalCode;
	}

	/**
	 * 属性赔付影响主险类型的getter方法
	 */

	@Column(name = "EFFECTONMAINRISK")
	public String getEffectOnMainRisk() {
		return this.effectOnMainRisk;
	}

	/**
	 * 属性赔付影响主险类型的setter方法
	 */
	public void setEffectOnMainRisk(String effectOnMainRisk) {
		this.effectOnMainRisk = effectOnMainRisk;
	}

	/**
	 * 属性额外保障标记的getter方法
	 */

	@Column(name = "EXTRAAMNTFLAG")
	public String getExtraAmntFlag() {
		return this.extraAmntFlag;
	}

	/**
	 * 属性额外保障标记的setter方法
	 */
	public void setExtraAmntFlag(String extraAmntFlag) {
		this.extraAmntFlag = extraAmntFlag;
	}

	/**
	 * 属性年度免赔额标记的getter方法
	 */

	@Column(name = "YEARGETLIMITFLAG")
	public String getYearGetLimitFlag() {
		return this.yearGetLimitFlag;
	}

	/**
	 * 属性年度免赔额标记的setter方法
	 */
	public void setYearGetLimitFlag(String yearGetLimitFlag) {
		this.yearGetLimitFlag = yearGetLimitFlag;
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
