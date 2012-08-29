package ins.product.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

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

/**
 * POJO类PDLMDutyGetClmcal
 */
@Entity
@Table(name = "PD_LMDUTYGETCLMCAL")
public class PDLMDutyGetClmcal implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性序号 */
	private PDLMDutyGetClmcalId id;

	/** 属性给付名称 */
	private String getDutyName;

	/** 属性算法1 */
	private String calCode1;

	/** 属性赔付金额计算SQL */
	private String calCode2;

	/** 属性算法3 */
	private String calCode3;

	/** 属性算法4 */
	private String calCode4;

	/** 属性算法5 */
	private String calCode5;

	/** 属性算法6 */
	private String calCode6;

	/** 属性算法7 */
	private String calCode7;

	/** 属性算法8 */
	private String calCode8;

	/** 属性算法9 */
	private String calCode9;

	/** 属性算法10 */
	private String calCode10;

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
	 * 类PDLMDutyGetClmcal的默认构造方法
	 */
	public PDLMDutyGetClmcal() {
	}

	/**
	 * 属性序号的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "getDutyCode", column = @Column(name = "GETDUTYCODE")),
			@AttributeOverride(name = "getDutyKind", column = @Column(name = "GETDUTYKIND")) })
	public PDLMDutyGetClmcalId getId() {
		return this.id;
	}

	/**
	 * 属性序号的setter方法
	 */
	public void setId(PDLMDutyGetClmcalId id) {
		this.id = id;
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
	 * 属性算法1的getter方法
	 */

	@Column(name = "CALCODE1")
	public String getCalCode1() {
		return this.calCode1;
	}

	/**
	 * 属性算法1的setter方法
	 */
	public void setCalCode1(String calCode1) {
		this.calCode1 = calCode1;
	}

	/**
	 * 属性赔付金额计算SQL的getter方法
	 */

	@Column(name = "CALCODE2")
	public String getCalCode2() {
		return this.calCode2;
	}

	/**
	 * 属性赔付金额计算SQL的setter方法
	 */
	public void setCalCode2(String calCode2) {
		this.calCode2 = calCode2;
	}

	/**
	 * 属性算法3的getter方法
	 */

	@Column(name = "CALCODE3")
	public String getCalCode3() {
		return this.calCode3;
	}

	/**
	 * 属性算法3的setter方法
	 */
	public void setCalCode3(String calCode3) {
		this.calCode3 = calCode3;
	}

	/**
	 * 属性算法4的getter方法
	 */

	@Column(name = "CALCODE4")
	public String getCalCode4() {
		return this.calCode4;
	}

	/**
	 * 属性算法4的setter方法
	 */
	public void setCalCode4(String calCode4) {
		this.calCode4 = calCode4;
	}

	/**
	 * 属性算法5的getter方法
	 */

	@Column(name = "CALCODE5")
	public String getCalCode5() {
		return this.calCode5;
	}

	/**
	 * 属性算法5的setter方法
	 */
	public void setCalCode5(String calCode5) {
		this.calCode5 = calCode5;
	}

	/**
	 * 属性算法6的getter方法
	 */

	@Column(name = "CALCODE6")
	public String getCalCode6() {
		return this.calCode6;
	}

	/**
	 * 属性算法6的setter方法
	 */
	public void setCalCode6(String calCode6) {
		this.calCode6 = calCode6;
	}

	/**
	 * 属性算法7的getter方法
	 */

	@Column(name = "CALCODE7")
	public String getCalCode7() {
		return this.calCode7;
	}

	/**
	 * 属性算法7的setter方法
	 */
	public void setCalCode7(String calCode7) {
		this.calCode7 = calCode7;
	}

	/**
	 * 属性算法8的getter方法
	 */

	@Column(name = "CALCODE8")
	public String getCalCode8() {
		return this.calCode8;
	}

	/**
	 * 属性算法8的setter方法
	 */
	public void setCalCode8(String calCode8) {
		this.calCode8 = calCode8;
	}

	/**
	 * 属性算法9的getter方法
	 */

	@Column(name = "CALCODE9")
	public String getCalCode9() {
		return this.calCode9;
	}

	/**
	 * 属性算法9的setter方法
	 */
	public void setCalCode9(String calCode9) {
		this.calCode9 = calCode9;
	}

	/**
	 * 属性算法10的getter方法
	 */

	@Column(name = "CALCODE10")
	public String getCalCode10() {
		return this.calCode10;
	}

	/**
	 * 属性算法10的setter方法
	 */
	public void setCalCode10(String calCode10) {
		this.calCode10 = calCode10;
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
