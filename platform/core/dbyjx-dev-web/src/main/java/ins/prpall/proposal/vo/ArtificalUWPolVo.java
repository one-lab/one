package ins.prpall.proposal.vo;

import java.math.BigDecimal;
import java.util.Date;

public class ArtificalUWPolVo {
	/** 属性险种代码 */
	private String riskCode;
	
	/** 属性险种名称 */
	private String riskName;
	
	/** 属性缴纳周期 */
	private BigDecimal payIntv;
	
	/** 属性交费年期 */
	private BigDecimal payYears;
	
	/** 属性人数 */
	private BigDecimal peoples;
	
	/** 属性保费 */
	private BigDecimal prem;

	/** 属性保额 */
	private BigDecimal amnt;
	
	/** 属性首期交费日期 */
	private Date firstPayDate;

	/** 属性终交日期 */
	private Date payEndDate;
	
	/**折扣费率*/
	private BigDecimal discountRate;

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getRiskName() {
		return riskName;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	public BigDecimal getPayIntv() {
		return payIntv;
	}

	public void setPayIntv(BigDecimal payIntv) {
		this.payIntv = payIntv;
	}

	public BigDecimal getPeoples() {
		return peoples;
	}

	public void setPeoples(BigDecimal peoples) {
		this.peoples = peoples;
	}

	public BigDecimal getPrem() {
		return prem;
	}

	public void setPrem(BigDecimal prem) {
		this.prem = prem;
	}

	public BigDecimal getAmnt() {
		return amnt;
	}

	public void setAmnt(BigDecimal amnt) {
		this.amnt = amnt;
	}

	public Date getFirstPayDate() {
		return firstPayDate;
	}

	public void setFirstPayDate(Date firstPayDate) {
		this.firstPayDate = firstPayDate;
	}

	public Date getPayEndDate() {
		return payEndDate;
	}

	public void setPayEndDate(Date payEndDate) {
		this.payEndDate = payEndDate;
	}

	public BigDecimal getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(BigDecimal discountRate) {
		this.discountRate = discountRate;
	}

	public BigDecimal getPayYears() {
		return payYears;
	}

	public void setPayYears(BigDecimal payYears) {
		this.payYears = payYears;
	}

	

}
