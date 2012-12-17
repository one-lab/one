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
 * POJO类PDLMRiskRole
 */
@Entity
@Table(name = "PD_LMRISKROLE")
public class PDLMRiskRole implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性序号 */
	private PDLMRiskRoleId id;

	/** 属性险种版本 */
	private String riskVer;

	/** 属性最小年龄单位 */
	private String minAppAgeFlag;

	/** 属性最小年龄 */
	private BigDecimal minAppAge;

	/** 属性最大年龄单位 */
	private String maxAppAgeFlag;

	/** 属性最大年龄 */
	private BigDecimal maxAppAge;

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
	 * 类PDLMRiskRole的默认构造方法
	 */
	public PDLMRiskRole() {
	}

	/**
	 * 属性序号的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "riskCode", column = @Column(name = "RISKCODE")),
			@AttributeOverride(name = "riskRole", column = @Column(name = "RISKROLE")),
			@AttributeOverride(name = "riskRoleSex", column = @Column(name = "RISKROLESEX")),
			@AttributeOverride(name = "riskRoleNo", column = @Column(name = "RISKROLENO")) })
	public PDLMRiskRoleId getId() {
		return this.id;
	}

	/**
	 * 属性序号的setter方法
	 */
	public void setId(PDLMRiskRoleId id) {
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
	 * 属性最小年龄单位的getter方法
	 */

	@Column(name = "MINAPPAGEFLAG")
	public String getMinAppAgeFlag() {
		return this.minAppAgeFlag;
	}

	/**
	 * 属性最小年龄单位的setter方法
	 */
	public void setMinAppAgeFlag(String minAppAgeFlag) {
		this.minAppAgeFlag = minAppAgeFlag;
	}

	/**
	 * 属性最小年龄的getter方法
	 */

	@Column(name = "MINAPPAGE")
	public BigDecimal getMinAppAge() {
		return this.minAppAge;
	}

	/**
	 * 属性最小年龄的setter方法
	 */
	public void setMinAppAge(BigDecimal minAppAge) {
		this.minAppAge = minAppAge;
	}

	/**
	 * 属性最大年龄单位的getter方法
	 */

	@Column(name = "MAXAPPAGEFLAG")
	public String getMaxAppAgeFlag() {
		return this.maxAppAgeFlag;
	}

	/**
	 * 属性最大年龄单位的setter方法
	 */
	public void setMaxAppAgeFlag(String maxAppAgeFlag) {
		this.maxAppAgeFlag = maxAppAgeFlag;
	}

	/**
	 * 属性最大年龄的getter方法
	 */

	@Column(name = "MAXAPPAGE")
	public BigDecimal getMaxAppAge() {
		return this.maxAppAge;
	}

	/**
	 * 属性最大年龄的setter方法
	 */
	public void setMaxAppAge(BigDecimal maxAppAge) {
		this.maxAppAge = maxAppAge;
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
