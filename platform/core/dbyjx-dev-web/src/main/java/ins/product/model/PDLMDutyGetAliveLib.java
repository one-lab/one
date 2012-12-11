package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

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

/**
 * POJO类PDLMDutyGetAliveLib
 */
@Entity
@Table(name = "PD_LMDUTYGETALIVE_LIB")
public class PDLMDutyGetAliveLib implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性责任给付库代码 */
	private String getDutyCode2;

	/** 属性算法表 */
	private PDLMCalMode PDLMCalMode;

	/** 属性给付名称 */
	private String getDutyName;

	/** 属性给付责任类型 */
	private String getDutyKind;

	/** 属性给付间隔 */
	private BigDecimal getIntv;

	/** 属性默认值 */
	private BigDecimal defaultVal;

	/** 属性反算算法 */
	private String cnterCalCode;

	/** 属性其他算法 */
	private String othCalCode;

	/** 属性起领期间 */
	private BigDecimal getStartPeriod;

	/** 属性起领期间单位 */
	private String getStartUnit;

	/** 属性起领日期计算参照 */
	private String startDateCalRef;

	/** 属性起领日期计算方式 */
	private String startDateCalMode;

	/** 属性起领期间上限 */
	private BigDecimal minGetStartPeriod;

	/** 属性止领期间 */
	private BigDecimal getEndPeriod;

	/** 属性止领期间单位 */
	private String getEndUnit;

	/** 属性止领日期计算参照 */
	private String endDateCalRef;

	/** 属性保险终止日期计算方式 */
	private String endDateCalMode;

	/** 属性止领期间下限 */
	private BigDecimal maxGetEndPeriod;

	/** 属性递增标记 */
	private String addFlag;

	/** 属性递增间隔 */
	private BigDecimal addIntv;

	/** 属性递增开始期间 */
	private BigDecimal addStartPeriod;

	/** 属性递增开始期间单位 */
	private String addStartUnit;

	/** 属性递增终止期间 */
	private BigDecimal addEndPeriod;

	/** 属性递增终止期间单位 */
	private String addEndUnit;

	/** 属性递增类型 */
	private String addType;

	/** 属性递增值 */
	private BigDecimal addValue;

	/** 属性给付最大次数 */
	private BigDecimal maxGetCount;

	/** 属性给付后动作 */
	private String afterGet;

	/** 属性领取动作类型 */
	private String getActionType;

	/** 属性催付标记 */
	private String urgeGetFlag;

	/** 属性现金领取标记 */
	private String discntFlag;

	/** 属性领取条件 */
	private String getCond;

	/** 属性给付最大次数类型 */
	private String maxGetCountType;

	/** 属性领取时是否需要重新计算 */
	private String needReCompute;

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
	 * 类PDLMDutyGetAliveLib的默认构造方法
	 */
	public PDLMDutyGetAliveLib() {
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
	 * 属性给付间隔的getter方法
	 */

	@Column(name = "GETINTV")
	public BigDecimal getGetIntv() {
		return this.getIntv;
	}

	/**
	 * 属性给付间隔的setter方法
	 */
	public void setGetIntv(BigDecimal getIntv) {
		this.getIntv = getIntv;
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
	 * 属性起领期间的getter方法
	 */

	@Column(name = "GETSTARTPERIOD")
	public BigDecimal getGetStartPeriod() {
		return this.getStartPeriod;
	}

	/**
	 * 属性起领期间的setter方法
	 */
	public void setGetStartPeriod(BigDecimal getStartPeriod) {
		this.getStartPeriod = getStartPeriod;
	}

	/**
	 * 属性起领期间单位的getter方法
	 */

	@Column(name = "GETSTARTUNIT")
	public String getGetStartUnit() {
		return this.getStartUnit;
	}

	/**
	 * 属性起领期间单位的setter方法
	 */
	public void setGetStartUnit(String getStartUnit) {
		this.getStartUnit = getStartUnit;
	}

	/**
	 * 属性起领日期计算参照的getter方法
	 */

	@Column(name = "STARTDATECALREF")
	public String getStartDateCalRef() {
		return this.startDateCalRef;
	}

	/**
	 * 属性起领日期计算参照的setter方法
	 */
	public void setStartDateCalRef(String startDateCalRef) {
		this.startDateCalRef = startDateCalRef;
	}

	/**
	 * 属性起领日期计算方式的getter方法
	 */

	@Column(name = "STARTDATECALMODE")
	public String getStartDateCalMode() {
		return this.startDateCalMode;
	}

	/**
	 * 属性起领日期计算方式的setter方法
	 */
	public void setStartDateCalMode(String startDateCalMode) {
		this.startDateCalMode = startDateCalMode;
	}

	/**
	 * 属性起领期间上限的getter方法
	 */

	@Column(name = "MINGETSTARTPERIOD")
	public BigDecimal getMinGetStartPeriod() {
		return this.minGetStartPeriod;
	}

	/**
	 * 属性起领期间上限的setter方法
	 */
	public void setMinGetStartPeriod(BigDecimal minGetStartPeriod) {
		this.minGetStartPeriod = minGetStartPeriod;
	}

	/**
	 * 属性止领期间的getter方法
	 */

	@Column(name = "GETENDPERIOD")
	public BigDecimal getGetEndPeriod() {
		return this.getEndPeriod;
	}

	/**
	 * 属性止领期间的setter方法
	 */
	public void setGetEndPeriod(BigDecimal getEndPeriod) {
		this.getEndPeriod = getEndPeriod;
	}

	/**
	 * 属性止领期间单位的getter方法
	 */

	@Column(name = "GETENDUNIT")
	public String getGetEndUnit() {
		return this.getEndUnit;
	}

	/**
	 * 属性止领期间单位的setter方法
	 */
	public void setGetEndUnit(String getEndUnit) {
		this.getEndUnit = getEndUnit;
	}

	/**
	 * 属性止领日期计算参照的getter方法
	 */

	@Column(name = "ENDDATECALREF")
	public String getEndDateCalRef() {
		return this.endDateCalRef;
	}

	/**
	 * 属性止领日期计算参照的setter方法
	 */
	public void setEndDateCalRef(String endDateCalRef) {
		this.endDateCalRef = endDateCalRef;
	}

	/**
	 * 属性保险终止日期计算方式的getter方法
	 */

	@Column(name = "ENDDATECALMODE")
	public String getEndDateCalMode() {
		return this.endDateCalMode;
	}

	/**
	 * 属性保险终止日期计算方式的setter方法
	 */
	public void setEndDateCalMode(String endDateCalMode) {
		this.endDateCalMode = endDateCalMode;
	}

	/**
	 * 属性止领期间下限的getter方法
	 */

	@Column(name = "MAXGETENDPERIOD")
	public BigDecimal getMaxGetEndPeriod() {
		return this.maxGetEndPeriod;
	}

	/**
	 * 属性止领期间下限的setter方法
	 */
	public void setMaxGetEndPeriod(BigDecimal maxGetEndPeriod) {
		this.maxGetEndPeriod = maxGetEndPeriod;
	}

	/**
	 * 属性递增标记的getter方法
	 */

	@Column(name = "ADDFLAG")
	public String getAddFlag() {
		return this.addFlag;
	}

	/**
	 * 属性递增标记的setter方法
	 */
	public void setAddFlag(String addFlag) {
		this.addFlag = addFlag;
	}

	/**
	 * 属性递增间隔的getter方法
	 */

	@Column(name = "ADDINTV")
	public BigDecimal getAddIntv() {
		return this.addIntv;
	}

	/**
	 * 属性递增间隔的setter方法
	 */
	public void setAddIntv(BigDecimal addIntv) {
		this.addIntv = addIntv;
	}

	/**
	 * 属性递增开始期间的getter方法
	 */

	@Column(name = "ADDSTARTPERIOD")
	public BigDecimal getAddStartPeriod() {
		return this.addStartPeriod;
	}

	/**
	 * 属性递增开始期间的setter方法
	 */
	public void setAddStartPeriod(BigDecimal addStartPeriod) {
		this.addStartPeriod = addStartPeriod;
	}

	/**
	 * 属性递增开始期间单位的getter方法
	 */

	@Column(name = "ADDSTARTUNIT")
	public String getAddStartUnit() {
		return this.addStartUnit;
	}

	/**
	 * 属性递增开始期间单位的setter方法
	 */
	public void setAddStartUnit(String addStartUnit) {
		this.addStartUnit = addStartUnit;
	}

	/**
	 * 属性递增终止期间的getter方法
	 */

	@Column(name = "ADDENDPERIOD")
	public BigDecimal getAddEndPeriod() {
		return this.addEndPeriod;
	}

	/**
	 * 属性递增终止期间的setter方法
	 */
	public void setAddEndPeriod(BigDecimal addEndPeriod) {
		this.addEndPeriod = addEndPeriod;
	}

	/**
	 * 属性递增终止期间单位的getter方法
	 */

	@Column(name = "ADDENDUNIT")
	public String getAddEndUnit() {
		return this.addEndUnit;
	}

	/**
	 * 属性递增终止期间单位的setter方法
	 */
	public void setAddEndUnit(String addEndUnit) {
		this.addEndUnit = addEndUnit;
	}

	/**
	 * 属性递增类型的getter方法
	 */

	@Column(name = "ADDTYPE")
	public String getAddType() {
		return this.addType;
	}

	/**
	 * 属性递增类型的setter方法
	 */
	public void setAddType(String addType) {
		this.addType = addType;
	}

	/**
	 * 属性递增值的getter方法
	 */

	@Column(name = "ADDVALUE")
	public BigDecimal getAddValue() {
		return this.addValue;
	}

	/**
	 * 属性递增值的setter方法
	 */
	public void setAddValue(BigDecimal addValue) {
		this.addValue = addValue;
	}

	/**
	 * 属性给付最大次数的getter方法
	 */

	@Column(name = "MAXGETCOUNT")
	public BigDecimal getMaxGetCount() {
		return this.maxGetCount;
	}

	/**
	 * 属性给付最大次数的setter方法
	 */
	public void setMaxGetCount(BigDecimal maxGetCount) {
		this.maxGetCount = maxGetCount;
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
	 * 属性领取动作类型的getter方法
	 */

	@Column(name = "GETACTIONTYPE")
	public String getGetActionType() {
		return this.getActionType;
	}

	/**
	 * 属性领取动作类型的setter方法
	 */
	public void setGetActionType(String getActionType) {
		this.getActionType = getActionType;
	}

	/**
	 * 属性催付标记的getter方法
	 */

	@Column(name = "URGEGETFLAG")
	public String getUrgeGetFlag() {
		return this.urgeGetFlag;
	}

	/**
	 * 属性催付标记的setter方法
	 */
	public void setUrgeGetFlag(String urgeGetFlag) {
		this.urgeGetFlag = urgeGetFlag;
	}

	/**
	 * 属性现金领取标记的getter方法
	 */

	@Column(name = "DISCNTFLAG")
	public String getDiscntFlag() {
		return this.discntFlag;
	}

	/**
	 * 属性现金领取标记的setter方法
	 */
	public void setDiscntFlag(String discntFlag) {
		this.discntFlag = discntFlag;
	}

	/**
	 * 属性领取条件的getter方法
	 */

	@Column(name = "GETCOND")
	public String getGetCond() {
		return this.getCond;
	}

	/**
	 * 属性领取条件的setter方法
	 */
	public void setGetCond(String getCond) {
		this.getCond = getCond;
	}

	/**
	 * 属性给付最大次数类型的getter方法
	 */

	@Column(name = "MAXGETCOUNTTYPE")
	public String getMaxGetCountType() {
		return this.maxGetCountType;
	}

	/**
	 * 属性给付最大次数类型的setter方法
	 */
	public void setMaxGetCountType(String maxGetCountType) {
		this.maxGetCountType = maxGetCountType;
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
