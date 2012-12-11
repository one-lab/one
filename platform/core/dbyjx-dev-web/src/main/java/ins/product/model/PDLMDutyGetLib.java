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
 * POJO类PDLMDutyGetLib
 */
@Entity
@Table(name = "PD_LMDUTYGET_LIB")
public class PDLMDutyGetLib implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性责任给付库代码 */
	private String getDutyCode2;

	/** 属性佣金计算编码 */
	private String calCode;

	/** 属性给付名称 */
	private String getDutyName;

	/** 属性算法模板类型 */
	private String type;

	/** 属性给付间隔 */
	private BigDecimal getIntv;

	/** 属性默认值 */
	private BigDecimal defaultVal;

	/** 属性反算算法 */
	private String cnterCalCode;

	/** 属性其他算法 */
	private String othCalCode;

	/** 属性起领期间 */
	private BigDecimal getYear;

	/** 属性起领期间单位 */
	private String getYearFlag;

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

	/** 属性性别关联标记 */
	private String sexRelaFlag;

	/** 属性单位投保关联标记 */
	private String unitAppRelaFlag;

	/** 属性是否加入保额标记 */
	private String addAmntFlag;

	/** 属性现金领取标记 */
	private String discntFlag;

	/** 属性利率标记 */
	private String interestFlag;

	/** 属性多被保人分享标记 */
	private String shareFlag;

	/** 属性录入标志 */
	private String inpFlag;

	/** 属性受益人标记 */
	private String bnfFlag;

	/** 属性催付标记 */
	private String urgeGetFlag;

	/** 属性被保人死亡后有效标记 */
	private String deadValiFlag;

	/** 属性给付初始化标记 */
	private String getInitFlag;

	/** 属性起付限 */
	private BigDecimal getLimit;

	/** 属性赔付限额 */
	private BigDecimal maxGet;

	/** 属性赔付比例 */
	private BigDecimal getRate;

	/** 属性是否和账户相关 */
	private String needAcc;

	/** 属性默认申请标志 */
	private String canGet;

	/** 属性是否是账户结清后才能申请 */
	private String needCancelAcc;

	/** 属性给付分类1 */
	private String getType1;

	/** 属性是否允许零值标记 */
	private String zeroFlag;

	/** 属性给付分类2 */
	private String getType2;

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
	 * 类PDLMDutyGetLib的默认构造方法
	 */
	public PDLMDutyGetLib() {
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

	@Column(name = "GETYEAR")
	public BigDecimal getGetYear() {
		return this.getYear;
	}

	/**
	 * 属性起领期间的setter方法
	 */
	public void setGetYear(BigDecimal getYear) {
		this.getYear = getYear;
	}

	/**
	 * 属性起领期间单位的getter方法
	 */

	@Column(name = "GETYEARFLAG")
	public String getGetYearFlag() {
		return this.getYearFlag;
	}

	/**
	 * 属性起领期间单位的setter方法
	 */
	public void setGetYearFlag(String getYearFlag) {
		this.getYearFlag = getYearFlag;
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
	 * 属性性别关联标记的getter方法
	 */

	@Column(name = "SEXRELAFLAG")
	public String getSexRelaFlag() {
		return this.sexRelaFlag;
	}

	/**
	 * 属性性别关联标记的setter方法
	 */
	public void setSexRelaFlag(String sexRelaFlag) {
		this.sexRelaFlag = sexRelaFlag;
	}

	/**
	 * 属性单位投保关联标记的getter方法
	 */

	@Column(name = "UNITAPPRELAFLAG")
	public String getUnitAppRelaFlag() {
		return this.unitAppRelaFlag;
	}

	/**
	 * 属性单位投保关联标记的setter方法
	 */
	public void setUnitAppRelaFlag(String unitAppRelaFlag) {
		this.unitAppRelaFlag = unitAppRelaFlag;
	}

	/**
	 * 属性是否加入保额标记的getter方法
	 */

	@Column(name = "ADDAMNTFLAG")
	public String getAddAmntFlag() {
		return this.addAmntFlag;
	}

	/**
	 * 属性是否加入保额标记的setter方法
	 */
	public void setAddAmntFlag(String addAmntFlag) {
		this.addAmntFlag = addAmntFlag;
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
	 * 属性利率标记的getter方法
	 */

	@Column(name = "INTERESTFLAG")
	public String getInterestFlag() {
		return this.interestFlag;
	}

	/**
	 * 属性利率标记的setter方法
	 */
	public void setInterestFlag(String interestFlag) {
		this.interestFlag = interestFlag;
	}

	/**
	 * 属性多被保人分享标记的getter方法
	 */

	@Column(name = "SHAREFLAG")
	public String getShareFlag() {
		return this.shareFlag;
	}

	/**
	 * 属性多被保人分享标记的setter方法
	 */
	public void setShareFlag(String shareFlag) {
		this.shareFlag = shareFlag;
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
	 * 属性受益人标记的getter方法
	 */

	@Column(name = "BNFFLAG")
	public String getBnfFlag() {
		return this.bnfFlag;
	}

	/**
	 * 属性受益人标记的setter方法
	 */
	public void setBnfFlag(String bnfFlag) {
		this.bnfFlag = bnfFlag;
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
	 * 属性给付初始化标记的getter方法
	 */

	@Column(name = "GETINITFLAG")
	public String getGetInitFlag() {
		return this.getInitFlag;
	}

	/**
	 * 属性给付初始化标记的setter方法
	 */
	public void setGetInitFlag(String getInitFlag) {
		this.getInitFlag = getInitFlag;
	}

	/**
	 * 属性起付限的getter方法
	 */

	@Column(name = "GETLIMIT")
	public BigDecimal getGetLimit() {
		return this.getLimit;
	}

	/**
	 * 属性起付限的setter方法
	 */
	public void setGetLimit(BigDecimal getLimit) {
		this.getLimit = getLimit;
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

	@Column(name = "GETRATE")
	public BigDecimal getGetRate() {
		return this.getRate;
	}

	/**
	 * 属性赔付比例的setter方法
	 */
	public void setGetRate(BigDecimal getRate) {
		this.getRate = getRate;
	}

	/**
	 * 属性是否和账户相关的getter方法
	 */

	@Column(name = "NEEDACC")
	public String getNeedAcc() {
		return this.needAcc;
	}

	/**
	 * 属性是否和账户相关的setter方法
	 */
	public void setNeedAcc(String needAcc) {
		this.needAcc = needAcc;
	}

	/**
	 * 属性默认申请标志的getter方法
	 */

	@Column(name = "CANGET")
	public String getCanGet() {
		return this.canGet;
	}

	/**
	 * 属性默认申请标志的setter方法
	 */
	public void setCanGet(String canGet) {
		this.canGet = canGet;
	}

	/**
	 * 属性是否是账户结清后才能申请的getter方法
	 */

	@Column(name = "NEEDCANCELACC")
	public String getNeedCancelAcc() {
		return this.needCancelAcc;
	}

	/**
	 * 属性是否是账户结清后才能申请的setter方法
	 */
	public void setNeedCancelAcc(String needCancelAcc) {
		this.needCancelAcc = needCancelAcc;
	}

	/**
	 * 属性给付分类1的getter方法
	 */

	@Column(name = "GETTYPE1")
	public String getGetType1() {
		return this.getType1;
	}

	/**
	 * 属性给付分类1的setter方法
	 */
	public void setGetType1(String getType1) {
		this.getType1 = getType1;
	}

	/**
	 * 属性是否允许零值标记的getter方法
	 */

	@Column(name = "ZEROFLAG")
	public String getZeroFlag() {
		return this.zeroFlag;
	}

	/**
	 * 属性是否允许零值标记的setter方法
	 */
	public void setZeroFlag(String zeroFlag) {
		this.zeroFlag = zeroFlag;
	}

	/**
	 * 属性给付分类2的getter方法
	 */

	@Column(name = "GETTYPE2")
	public String getGetType2() {
		return this.getType2;
	}

	/**
	 * 属性给付分类2的setter方法
	 */
	public void setGetType2(String getType2) {
		this.getType2 = getType2;
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
