package ins.product.vo;

import ins.product.model.PDLMRiskDutyFactor;

import java.util.List;

public class PDLMRiskDutyFactorVo {
	private String factorName;
	private List<PDLMRiskDutyFactor> factors ;
	public String getFactorName() {
		return factorName;
	}
	public void setFactorName(String factorName) {
		this.factorName = factorName;
	}
	public List<PDLMRiskDutyFactor> getFactors() {
		return factors;
	}
	public void setFactors(List<PDLMRiskDutyFactor> factors) {
		this.factors = factors;
	}
}
