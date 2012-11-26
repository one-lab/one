package ins.product.web;

import ins.framework.web.Struts2Action;
import ins.product.model.PDLMDuty;
import ins.product.model.PDLMRiskDuty;
import ins.product.service.facade.PDLMDutyService;

public class PDLMDutyAction extends Struts2Action {
	private static final long serialVersionUID = 1L;
	
	private PDLMDuty pdlmDuty;
	private PDLMRiskDuty pdlmRiskDuty;
	private PDLMDutyService pdlmDutyService;
	public PDLMDuty getPdlmDuty() {
		return pdlmDuty;
	}
	public void setPdlmDuty(PDLMDuty pdlmDuty) {
		this.pdlmDuty = pdlmDuty;
	}
	public PDLMRiskDuty getPdlmRiskDuty() {
		return pdlmRiskDuty;
	}
	public void setPdlmRiskDuty(PDLMRiskDuty pdlmRiskDuty) {
		this.pdlmRiskDuty = pdlmRiskDuty;
	}
	
	public PDLMDutyService getPdlmDutyService() {
		return pdlmDutyService;
	}
	public void setPdlmDutyService(PDLMDutyService pdlmDutyService) {
		this.pdlmDutyService = pdlmDutyService;
	}
	/**
	 * @title saveDuty
	 * @description 保存责任
	 * @author Administrator
	 * @return
	 */
	public String saveDuty(){
		
//		String riskCode = (String)this.getSession().getAttribute("riskCode");
//		pdlmDutyService.saveDuty(pdlmDuty,riskCode);
		return NONE;
	}
}
