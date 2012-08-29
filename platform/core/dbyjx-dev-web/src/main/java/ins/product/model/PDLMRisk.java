package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.lang.reflect.InvocationTargetException;
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

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.xwork.StringUtils;
/**
 * POJO类PDLMRisk
 */
@Entity
@Table(name = "PD_LMRISK")
public class PDLMRisk implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性险种代码 */
	private String riskCode;

	/** 属性险种版本 */
	private String riskVer;

	/** 属性险种名称 */
	private String riskName;

	/** 属性险种简称 */
	private String riskShortName;

	/** 属性险种英文名称 */
	private String riskEnName;

	/** 属性险种英文简称 */
	private String riskEnShortName;

	/** 属性选择责任标记 */
	private String choDutyFlag;

	/** 属性续期收费标记 */
	private String cpayFlag;

	/** 属性生存给付标记 */
	private String getFlag;

	/** 属性保全标记 */
	private String edorFlag;

	/** 属性续保标记 */
	private String rnewFlag;

	/** 属性核保标记 */
	private String uwFlag;

	/** 属性分保标记 */
	private String rinsFlag;

	/** 属性保险帐户标记 */
	private String insuAccFlag;

	/** 属性预定利率 */
	private Double destRate;

	/** 属性原险种编码 */
	private String origRiskCode;

	/** 属性子版本号 */
	private String subRiskVer;

	/** 属性险种统计名称 */
	private String riskStatName;

	/** 属性公共保额标记 */
	private String pubAmntFlag;

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

	/** 属性定义状态  0--定义完毕   1-定义中   2-退回 */
	private String flag;

	/** 属性PDLDRiskComOperates */
	private List<PDLDRiskComOperate> PDLDRiskComOperates = new ArrayList<PDLDRiskComOperate>(
			0);

	/** 属性PDLMRiskPaies */
	private List<PDLMRiskPay> PDLMRiskPaies = new ArrayList<PDLMRiskPay>(0);

	/** 属性PDLMRiskAccGets */
	private List<PDLMRiskAccGet> PDLMRiskAccGets = new ArrayList<PDLMRiskAccGet>(
			0);

	/** 属性PDLAwageCalElements */
	private List<PDLAwageCalElement> PDLAwageCalElements = new ArrayList<PDLAwageCalElement>(
			0);

	/** 属性PDLMRiskDuties */
	private List<PDLMRiskDuty> PDLMRiskDuties = new ArrayList<PDLMRiskDuty>(0);

	/** 属性PDLMRiskApps */
	private List<PDLMRiskApp> PDLMRiskApps = new ArrayList<PDLMRiskApp>(0);

	/** 属性PDLMPayModes */
	private List<PDLMPayMode> PDLMPayModes = new ArrayList<PDLMPayMode>(0);

	/** 属性PDLMCheckFields */
	private List<PDLMCheckField> PDLMCheckFields = new ArrayList<PDLMCheckField>(
			0);

	/** 属性PDLMLoans */
	private List<PDLMLoan> PDLMLoans = new ArrayList<PDLMLoan>(0);

	/** 属性PDLFRisks */
	private List<PDLFRisk> PDLFRisks = new ArrayList<PDLFRisk>(0);

	/** 属性PDLMUWs */
	private List<PDLMUW> PDLMUWs = new ArrayList<PDLMUW>(0);

	/**
	 * 类PDLMRisk的默认构造方法
	 */
	public PDLMRisk() {
	}

	/**
	 * 属性险种代码的getter方法
	 */
	@Id
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
	 * 属性险种简称的getter方法
	 */

	@Column(name = "RISKSHORTNAME")
	public String getRiskShortName() {
		return this.riskShortName;
	}

	/**
	 * 属性险种简称的setter方法
	 */
	public void setRiskShortName(String riskShortName) {
		this.riskShortName = riskShortName;
	}

	/**
	 * 属性险种英文名称的getter方法
	 */

	@Column(name = "RISKENNAME")
	public String getRiskEnName() {
		return this.riskEnName;
	}

	/**
	 * 属性险种英文名称的setter方法
	 */
	public void setRiskEnName(String riskEnName) {
		this.riskEnName = riskEnName;
	}

	/**
	 * 属性险种英文简称的getter方法
	 */

	@Column(name = "RISKENSHORTNAME")
	public String getRiskEnShortName() {
		return this.riskEnShortName;
	}

	/**
	 * 属性险种英文简称的setter方法
	 */
	public void setRiskEnShortName(String riskEnShortName) {
		this.riskEnShortName = riskEnShortName;
	}

	/**
	 * 属性选择责任标记的getter方法
	 */

	@Column(name = "CHODUTYFLAG")
	public String getChoDutyFlag() {
		return this.choDutyFlag;
	}

	/**
	 * 属性选择责任标记的setter方法
	 */
	public void setChoDutyFlag(String choDutyFlag) {
		this.choDutyFlag = choDutyFlag;
	}

	/**
	 * 属性续期收费标记的getter方法
	 */

	@Column(name = "CPAYFLAG")
	public String getCpayFlag() {
		return this.cpayFlag;
	}

	/**
	 * 属性续期收费标记的setter方法
	 */
	public void setCpayFlag(String cpayFlag) {
		this.cpayFlag = cpayFlag;
	}

	/**
	 * 属性生存给付标记的getter方法
	 */

	@Column(name = "GETFLAG")
	public String getGetFlag() {
		return this.getFlag;
	}

	/**
	 * 属性生存给付标记的setter方法
	 */
	public void setGetFlag(String getFlag) {
		this.getFlag = getFlag;
	}

	/**
	 * 属性保全标记的getter方法
	 */

	@Column(name = "EDORFLAG")
	public String getEdorFlag() {
		return this.edorFlag;
	}

	/**
	 * 属性保全标记的setter方法
	 */
	public void setEdorFlag(String edorFlag) {
		this.edorFlag = edorFlag;
	}

	/**
	 * 属性续保标记的getter方法
	 */

	@Column(name = "RNEWFLAG")
	public String getRnewFlag() {
		return this.rnewFlag;
	}

	/**
	 * 属性续保标记的setter方法
	 */
	public void setRnewFlag(String rnewFlag) {
		this.rnewFlag = rnewFlag;
	}

	/**
	 * 属性核保标记的getter方法
	 */

	@Column(name = "UWFLAG")
	public String getUwFlag() {
		return this.uwFlag;
	}

	/**
	 * 属性核保标记的setter方法
	 */
	public void setUwFlag(String uwFlag) {
		this.uwFlag = uwFlag;
	}

	/**
	 * 属性分保标记的getter方法
	 */

	@Column(name = "RINSFLAG")
	public String getRinsFlag() {
		return this.rinsFlag;
	}

	/**
	 * 属性分保标记的setter方法
	 */
	public void setRinsFlag(String rinsFlag) {
		this.rinsFlag = rinsFlag;
	}

	/**
	 * 属性保险帐户标记的getter方法
	 */

	@Column(name = "INSUACCFLAG")
	public String getInsuAccFlag() {
		return this.insuAccFlag;
	}

	/**
	 * 属性保险帐户标记的setter方法
	 */
	public void setInsuAccFlag(String insuAccFlag) {
		this.insuAccFlag = insuAccFlag;
	}

	/**
	 * 属性预定利率的getter方法
	 */

	@Column(name = "DESTRATE")
	public Double getDestRate() {
		return this.destRate;
	}

	/**
	 * 属性预定利率的setter方法
	 */
	public void setDestRate(Double destRate) {
		this.destRate = destRate;
	}

	/**
	 * 属性原险种编码的getter方法
	 */

	@Column(name = "ORIGRISKCODE")
	public String getOrigRiskCode() {
		return this.origRiskCode;
	}

	/**
	 * 属性原险种编码的setter方法
	 */
	public void setOrigRiskCode(String origRiskCode) {
		this.origRiskCode = origRiskCode;
	}

	/**
	 * 属性子版本号的getter方法
	 */

	@Column(name = "SUBRISKVER")
	public String getSubRiskVer() {
		return this.subRiskVer;
	}

	/**
	 * 属性子版本号的setter方法
	 */
	public void setSubRiskVer(String subRiskVer) {
		this.subRiskVer = subRiskVer;
	}

	/**
	 * 属性险种统计名称的getter方法
	 */

	@Column(name = "RISKSTATNAME")
	public String getRiskStatName() {
		return this.riskStatName;
	}

	/**
	 * 属性险种统计名称的setter方法
	 */
	public void setRiskStatName(String riskStatName) {
		this.riskStatName = riskStatName;
	}

	/**
	 * 属性公共保额标记的getter方法
	 */

	@Column(name = "PUBAMNTFLAG")
	public String getPubAmntFlag() {
		return this.pubAmntFlag;
	}

	/**
	 * 属性公共保额标记的setter方法
	 */
	public void setPubAmntFlag(String pubAmntFlag) {
		this.pubAmntFlag = pubAmntFlag;
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
	 * 属性定义状态的getter方法  0--定义完毕   1-定义中   2-退回 
	 */

	@Column(name = "FLAG")
	public String getFlag() {
		return this.flag;
	}

	/**
	 * 属性定义状态的setter方法 0--定义完毕   1-定义中   2-退回 
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * 属性PDLDRiskComOperates的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PDLMRisk")
	public List<PDLDRiskComOperate> getPDLDRiskComOperates() {
		return this.PDLDRiskComOperates;
	}

	/**
	 * 属性PDLDRiskComOperates的setter方法
	 */
	public void setPDLDRiskComOperates(
			List<PDLDRiskComOperate> PDLDRiskComOperates) {
		this.PDLDRiskComOperates = PDLDRiskComOperates;
	}

	/**
	 * 属性PDLMRiskPaies的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PDLMRisk")
	public List<PDLMRiskPay> getPDLMRiskPaies() {
		return this.PDLMRiskPaies;
	}

	/**
	 * 属性PDLMRiskPaies的setter方法
	 */
	public void setPDLMRiskPaies(List<PDLMRiskPay> PDLMRiskPaies) {
		this.PDLMRiskPaies = PDLMRiskPaies;
	}

	/**
	 * 属性PDLMRiskAccGets的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PDLMRisk")
	public List<PDLMRiskAccGet> getPDLMRiskAccGets() {
		return this.PDLMRiskAccGets;
	}

	/**
	 * 属性PDLMRiskAccGets的setter方法
	 */
	public void setPDLMRiskAccGets(List<PDLMRiskAccGet> PDLMRiskAccGets) {
		this.PDLMRiskAccGets = PDLMRiskAccGets;
	}

	/**
	 * 属性PDLAwageCalElements的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PDLMRisk")
	public List<PDLAwageCalElement> getPDLAwageCalElements() {
		return this.PDLAwageCalElements;
	}

	/**
	 * 属性PDLAwageCalElements的setter方法
	 */
	public void setPDLAwageCalElements(
			List<PDLAwageCalElement> PDLAwageCalElements) {
		this.PDLAwageCalElements = PDLAwageCalElements;
	}

	/**
	 * 属性PDLMRiskDuties的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PDLMRisk")
	public List<PDLMRiskDuty> getPDLMRiskDuties() {
		return this.PDLMRiskDuties;
	}

	/**
	 * 属性PDLMRiskDuties的setter方法
	 */
	public void setPDLMRiskDuties(List<PDLMRiskDuty> PDLMRiskDuties) {
		this.PDLMRiskDuties = PDLMRiskDuties;
	}

	/**
	 * 属性PDLMRiskApps的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PDLMRisk")
	public List<PDLMRiskApp> getPDLMRiskApps() {
		return this.PDLMRiskApps;
	}

	/**
	 * 属性PDLMRiskApps的setter方法
	 */
	public void setPDLMRiskApps(List<PDLMRiskApp> PDLMRiskApps) {
		this.PDLMRiskApps = PDLMRiskApps;
	}

	/**
	 * 属性PDLMPayModes的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PDLMRisk")
	public List<PDLMPayMode> getPDLMPayModes() {
		return this.PDLMPayModes;
	}

	/**
	 * 属性PDLMPayModes的setter方法
	 */
	public void setPDLMPayModes(List<PDLMPayMode> PDLMPayModes) {
		this.PDLMPayModes = PDLMPayModes;
	}

	/**
	 * 属性PDLMCheckFields的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PDLMRisk")
	public List<PDLMCheckField> getPDLMCheckFields() {
		return this.PDLMCheckFields;
	}

	/**
	 * 属性PDLMCheckFields的setter方法
	 */
	public void setPDLMCheckFields(List<PDLMCheckField> PDLMCheckFields) {
		this.PDLMCheckFields = PDLMCheckFields;
	}

	/**
	 * 属性PDLMLoans的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PDLMRisk")
	public List<PDLMLoan> getPDLMLoans() {
		return this.PDLMLoans;
	}

	/**
	 * 属性PDLMLoans的setter方法
	 */
	public void setPDLMLoans(List<PDLMLoan> PDLMLoans) {
		this.PDLMLoans = PDLMLoans;
	}

	/**
	 * 属性PDLFRisks的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PDLMRisk")
	public List<PDLFRisk> getPDLFRisks() {
		return this.PDLFRisks;
	}

	/**
	 * 属性PDLFRisks的setter方法
	 */
	public void setPDLFRisks(List<PDLFRisk> PDLFRisks) {
		this.PDLFRisks = PDLFRisks;
	}

	/**
	 * 属性PDLMUWs的getter方法
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PDLMRisk")
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
