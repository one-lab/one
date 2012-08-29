package ins.product.vo;

import ins.product.model.PDLMRiskDutyFactor;

public class PDLMRiskDutyFactorValueVo {
	/**
	 * 确定算法公式
	 */
	private String calCode;
	/**
	 * 险种编码
	 */
	private String riskCode;
	/**
	 * 责任编码
	 */
	private String dutyCode;
	/**
	 * 责任要素
	 */
	private String calFactor;
	/**
	 * 责任要素值
	 */
	private Double calFactorValue;
	/**
	 * 要素算法，可能是组合要素这样就要匹配多个要素
	 */
	private String calSQL;
	
	/** 
	 *  计划要素类型
	 *  1 直接值      2 算法计算结果值
	 */
	private String calFactorType;
	
	public String getCalCode() {
		return calCode;
	}
	public void setCalCode(String calCode) {
		this.calCode = calCode;
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getDutyCode() {
		return dutyCode;
	}
	public void setDutyCode(String dutyCode) {
		this.dutyCode = dutyCode;
	}
	public String getCalFactor() {
		return calFactor;
	}
	public void setCalFactor(String calFactor) {
		this.calFactor = calFactor;
	}
	public Double getCalFactorValue() {
		return calFactorValue;
	}
	public void setCalFactorValue(Double calFactorValue) {
		this.calFactorValue = calFactorValue;
	}
	public String getCalFactorType() {
		return calFactorType;
	}
	public void setCalFactorType(String calFactorType) {
		this.calFactorType = calFactorType;
	}
	public String getCalSQL() {
		return calSQL;
	}
	public void setCalSQL(String calSQL) {
		this.calSQL = calSQL;
	}
	public PDLMRiskDutyFactorValueVo(){
		
	}
	
	public PDLMRiskDutyFactorValueVo(String calCode, String riskCode,
			String dutyCode, String calFactor, Double calFactorValue,
			String calSQL, String calFactorType) {
		super();
		this.calCode = calCode;
		this.riskCode = riskCode;
		this.dutyCode = dutyCode;
		this.calFactor = calFactor;
		this.calFactorValue = calFactorValue;
		this.calSQL = calSQL;
		this.calFactorType = calFactorType;
	}
	public PDLMRiskDutyFactorValueVo(String calCode ,double calFactorValue ,PDLMRiskDutyFactor pdlmRiskDutyFactor){
		super();
		this.calCode = calCode;
		this.riskCode = pdlmRiskDutyFactor.getId().getRiskCode();
		this.dutyCode = pdlmRiskDutyFactor.getId().getDutyCode();
		this.calFactor = pdlmRiskDutyFactor.getId().getCalFactor();
		this.calFactorValue = calFactorValue;
		this.calFactorType = pdlmRiskDutyFactor.getCalFactorType();
		this.calSQL = pdlmRiskDutyFactor.getCalSQL();
	}
}
