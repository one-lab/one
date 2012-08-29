package ins.prpall.proposal.vo;

import java.math.BigDecimal;

/**
 * 
 * @title LCGrpPolVo
 * @description 集体保单险种类
 * @author xu_xinling
 * @version 
 * @create date 2012-8-16
 * @copyright (c) 
 *
 */
public class LCGrpPolVo {
	//集体保单险种号码
	private String grpPolNo;
	//险种编码
      private String riskCode;
      //险种名称
      private String riskName;
      //保额
      private BigDecimal prem;
      //保费
      private BigDecimal amnt;
      //费用率
      private BigDecimal floatRate;
    
      public LCGrpPolVo(){
    	  
      }
      public LCGrpPolVo(String grpPolNo,String riskCode,String riskName,BigDecimal prem,BigDecimal amnt,BigDecimal floatRate){
    	  this.riskCode=riskCode;
    	  this.grpPolNo=grpPolNo;
    	  this.riskName=riskName;
    	  this.prem=prem;
    	  this.amnt=amnt;
    	  this.floatRate=floatRate;
    	  
      }
      
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
	public BigDecimal getPrem() {
		return prem;
	}
	public void setPrem(BigDecimal prem) {
		this.prem = prem;
	}

	public BigDecimal getFloatRate() {
		return floatRate;
	}
	public void setFloatRate(BigDecimal floatRate) {
		this.floatRate = floatRate;
	}
	public BigDecimal getAmnt() {
		return amnt;
	}
	public void setAmnt(BigDecimal amnt) {
		this.amnt = amnt;
	}
	public String getGrpPolNo() {
		return grpPolNo;
	}
	public void setGrpPolNo(String grpPolNo) {
		this.grpPolNo = grpPolNo;
	}

      
}
