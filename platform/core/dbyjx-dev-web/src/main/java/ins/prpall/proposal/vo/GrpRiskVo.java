/**
 * @ create_date 2012-8-10
 * @ author long
 * @ version 1.0
 */
package ins.prpall.proposal.vo;

import java.math.BigDecimal;

/**
 *
 * @title GrpRiskVo
 * @description 集体投保单复核时用于查询集体保单险种信息
 * @author 于文龙
 * @create date 2012-8-10
 * @copyright (c) SINOSOFT
 * 
 *
 */
public class GrpRiskVo {
	
	/** 属性险种编码 */
	private String riskCode;
	
	/** 属性保费 */
	private BigDecimal prem;

	/** 属性保额 */
	private BigDecimal amnt;
	
	/**属性险种名称*/
	private String riskName;
	
	/**属性费用率*/
	private BigDecimal rate;

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
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

	public String getRiskName() {
		return riskName;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	
	public GrpRiskVo(){}
	

}
