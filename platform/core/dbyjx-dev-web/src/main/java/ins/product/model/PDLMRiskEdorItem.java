package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.xwork.StringUtils;

/**
 * POJO类PDLMRiskEdorItem
 */
@Entity
@Table(name = "PD_LMRISKEDORITEM")
public class PDLMRiskEdorItem implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性序号 */
	private PDLMRiskEdorItemId id;

	/** 属性险种版本 */
	private String riskVer;

	/** 属性险种名称 */
	private String riskName;

	/** 属性保全项目名称 */
	private String edorName;

	/** 属性冲减保费标记 */
	private String cutPremFlag;

	/** 属性变动标记 */
	private String chgFlag;

	/** 属性改金额标记 */
	private String chgValueFlag;

	/** 属性账户转出计算标志 */
	private String calFlag;

	/** 属性界面中是否显示项目明细 */
	private String needDetail;

	/** 属性间隔类型 */
	private String intvType;

	/** 属性集体保全批单中是否需要打印保全清单 */
	private String grpNeedList;

	/** 属性保全权限 */
	private String edorPopedom;

	/** 属性财务处理类型 */
	private String finType;

	/** 属性保全项目属性 */
	private String edorProperty;

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
	 * 类PDLMRiskEdorItem的默认构造方法
	 */
	public PDLMRiskEdorItem() {
	}

	/**
	 * 属性序号的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "riskCode", column = @Column(name = "RISKCODE")),
			@AttributeOverride(name = "edorCode", column = @Column(name = "EDORCODE")),
			@AttributeOverride(name = "appObj", column = @Column(name = "APPOBJ")) })
	public PDLMRiskEdorItemId getId() {
		return this.id;
	}

	/**
	 * 属性序号的setter方法
	 */
	public void setId(PDLMRiskEdorItemId id) {
		this.id = id;
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
	 * 属性保全项目名称的getter方法
	 */

	@Column(name = "EDORNAME")
	public String getEdorName() {
		return this.edorName;
	}

	/**
	 * 属性保全项目名称的setter方法
	 */
	public void setEdorName(String edorName) {
		this.edorName = edorName;
	}

	/**
	 * 属性冲减保费标记的getter方法
	 */

	@Column(name = "CUTPREMFLAG")
	public String getCutPremFlag() {
		return this.cutPremFlag;
	}

	/**
	 * 属性冲减保费标记的setter方法
	 */
	public void setCutPremFlag(String cutPremFlag) {
		this.cutPremFlag = cutPremFlag;
	}

	/**
	 * 属性变动标记的getter方法
	 */

	@Column(name = "CHGFLAG")
	public String getChgFlag() {
		return this.chgFlag;
	}

	/**
	 * 属性变动标记的setter方法
	 */
	public void setChgFlag(String chgFlag) {
		this.chgFlag = chgFlag;
	}

	/**
	 * 属性改金额标记的getter方法
	 */

	@Column(name = "CHGVALUEFLAG")
	public String getChgValueFlag() {
		return this.chgValueFlag;
	}

	/**
	 * 属性改金额标记的setter方法
	 */
	public void setChgValueFlag(String chgValueFlag) {
		this.chgValueFlag = chgValueFlag;
	}

	/**
	 * 属性账户转出计算标志的getter方法
	 */

	@Column(name = "CALFLAG")
	public String getCalFlag() {
		return this.calFlag;
	}

	/**
	 * 属性账户转出计算标志的setter方法
	 */
	public void setCalFlag(String calFlag) {
		this.calFlag = calFlag;
	}

	/**
	 * 属性界面中是否显示项目明细的getter方法
	 */

	@Column(name = "NEEDDETAIL")
	public String getNeedDetail() {
		return this.needDetail;
	}

	/**
	 * 属性界面中是否显示项目明细的setter方法
	 */
	public void setNeedDetail(String needDetail) {
		this.needDetail = needDetail;
	}

	/**
	 * 属性间隔类型的getter方法
	 */

	@Column(name = "INTVTYPE")
	public String getIntvType() {
		return this.intvType;
	}

	/**
	 * 属性间隔类型的setter方法
	 */
	public void setIntvType(String intvType) {
		this.intvType = intvType;
	}

	/**
	 * 属性集体保全批单中是否需要打印保全清单的getter方法
	 */

	@Column(name = "GRPNEEDLIST")
	public String getGrpNeedList() {
		return this.grpNeedList;
	}

	/**
	 * 属性集体保全批单中是否需要打印保全清单的setter方法
	 */
	public void setGrpNeedList(String grpNeedList) {
		this.grpNeedList = grpNeedList;
	}

	/**
	 * 属性保全权限的getter方法
	 */

	@Column(name = "EDORPOPEDOM")
	public String getEdorPopedom() {
		return this.edorPopedom;
	}

	/**
	 * 属性保全权限的setter方法
	 */
	public void setEdorPopedom(String edorPopedom) {
		this.edorPopedom = edorPopedom;
	}

	/**
	 * 属性财务处理类型的getter方法
	 */

	@Column(name = "FINTYPE")
	public String getFinType() {
		return this.finType;
	}

	/**
	 * 属性财务处理类型的setter方法
	 */
	public void setFinType(String finType) {
		this.finType = finType;
	}

	/**
	 * 属性保全项目属性的getter方法
	 */

	@Column(name = "EDORPROPERTY")
	public String getEdorProperty() {
		return this.edorProperty;
	}

	/**
	 * 属性保全项目属性的setter方法
	 */
	public void setEdorProperty(String edorProperty) {
		this.edorProperty = edorProperty;
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
