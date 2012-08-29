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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.xwork.StringUtils;

/**
 * POJO类PDLMCheckField
 */
@Entity
@Table(name = "PD_LMCHECKFIELD")
public class PDLMCheckField implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性序号 */
	private PDLMCheckFieldId id;

	/** 属性险种定义 */
	private PDLMRisk PDLMRisk;

	/** 属性险种版本 */
	private String riskVer;

	/** 属性佣金计算编码 */
	private String calCode;

	/** 属性页面位置 */
	private String pageLocation;

	/** 属性事件位置 */
	private String location;

	/** 属性提示信息 */
	private String msg;

	/** 属性提示标记 */
	private String msgFlag;

	/** 属性修改变量标记 */
	private String updFlag;

	/** 属性有效结果标记 */
	private String valiFlag;

	/** 属性返回值有效标记 */
	private String returnValiFlag;

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
	 * 类PDLMCheckField的默认构造方法
	 */
	public PDLMCheckField() {
	}

	/**
	 * 属性序号的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "riskCode", column = @Column(name = "RISKCODE")),
			@AttributeOverride(name = "fieldName", column = @Column(name = "FIELDNAME")),
			@AttributeOverride(name = "serialNO", column = @Column(name = "SERIALNO")) })
	public PDLMCheckFieldId getId() {
		return this.id;
	}

	/**
	 * 属性序号的setter方法
	 */
	public void setId(PDLMCheckFieldId id) {
		this.id = id;
	}

	/**
	 * 属性险种定义的getter方法
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RISKCODE", nullable = false, insertable = false, updatable = false)
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
	 * 属性页面位置的getter方法
	 */

	@Column(name = "PAGELOCATION")
	public String getPageLocation() {
		return this.pageLocation;
	}

	/**
	 * 属性页面位置的setter方法
	 */
	public void setPageLocation(String pageLocation) {
		this.pageLocation = pageLocation;
	}

	/**
	 * 属性事件位置的getter方法
	 */

	@Column(name = "LOCATION")
	public String getLocation() {
		return this.location;
	}

	/**
	 * 属性事件位置的setter方法
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * 属性提示信息的getter方法
	 */

	@Column(name = "MSG")
	public String getMsg() {
		return this.msg;
	}

	/**
	 * 属性提示信息的setter方法
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 属性提示标记的getter方法
	 */

	@Column(name = "MSGFLAG")
	public String getMsgFlag() {
		return this.msgFlag;
	}

	/**
	 * 属性提示标记的setter方法
	 */
	public void setMsgFlag(String msgFlag) {
		this.msgFlag = msgFlag;
	}

	/**
	 * 属性修改变量标记的getter方法
	 */

	@Column(name = "UPDFLAG")
	public String getUpdFlag() {
		return this.updFlag;
	}

	/**
	 * 属性修改变量标记的setter方法
	 */
	public void setUpdFlag(String updFlag) {
		this.updFlag = updFlag;
	}

	/**
	 * 属性有效结果标记的getter方法
	 */

	@Column(name = "VALIFLAG")
	public String getValiFlag() {
		return this.valiFlag;
	}

	/**
	 * 属性有效结果标记的setter方法
	 */
	public void setValiFlag(String valiFlag) {
		this.valiFlag = valiFlag;
	}

	/**
	 * 属性返回值有效标记的getter方法
	 */

	@Column(name = "RETURNVALIFLAG")
	public String getReturnValiFlag() {
		return this.returnValiFlag;
	}

	/**
	 * 属性返回值有效标记的setter方法
	 */
	public void setReturnValiFlag(String returnValiFlag) {
		this.returnValiFlag = returnValiFlag;
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
