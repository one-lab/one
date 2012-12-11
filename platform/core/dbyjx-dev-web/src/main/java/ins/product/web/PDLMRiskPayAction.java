package ins.product.web;

import ins.framework.web.Struts2Action;
import ins.product.model.PDLMRiskPay;
import ins.product.service.facade.PDLMRiskPayService;

public class PDLMRiskPayAction extends Struts2Action {
	private static final long serialVersionUID = 1L;
	
	private PDLMRiskPay pdlmRiskPay;
	private PDLMRiskPayService pdlmRiskPayService;
	/**
	 * @title saveRiskPay
	 * @description 保存险种缴费数据
	 * @author 党泽
	 * @return
	 */
	public String saveRiskPay(){
		pdlmRiskPay = pdlmRiskPayService.saveRiskPay(pdlmRiskPay);
		//this.writeJSONData(list, args);
		return NONE;
	}
	/**
	 * @title deletRiskPay
	 * @description 删除险种缴费数据
	 * @author 党泽
	 * @return
	 */
	public String deleteRiskPay(){
		pdlmRiskPay = pdlmRiskPayService.deleteRiskPay(pdlmRiskPay);
		return NONE;
	}
	/**
	 * @title updateRiskPay
	 * @description 更新险种缴费数据
	 * @author 党泽
	 * @return
	 */
	public String updateRiskPay(){
		pdlmRiskPay = pdlmRiskPayService.updateRiskPay(pdlmRiskPay);
		return NONE;
	}
	public PDLMRiskPay getPdlmRiskPay() {
		return pdlmRiskPay;
	}
	public void setPdlmRiskPay(PDLMRiskPay pdlmRiskPay) {
		this.pdlmRiskPay = pdlmRiskPay;
	}
	public PDLMRiskPayService getPdlmRiskPayService() {
		return pdlmRiskPayService;
	}
	public void setPdlmRiskPayService(PDLMRiskPayService pdlmRiskPayService) {
		this.pdlmRiskPayService = pdlmRiskPayService;
	}
}
