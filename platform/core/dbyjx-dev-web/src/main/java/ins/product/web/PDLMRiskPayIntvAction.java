package ins.product.web;

import ins.framework.web.Struts2Action;
import ins.product.model.PDLMRiskPayIntv;
import ins.product.service.facade.PDLMRiskPayIntvService;

public class PDLMRiskPayIntvAction extends Struts2Action {
	private static final long serialVersionUID = 1L;
	
	private PDLMRiskPayIntv pdlmRiskPayIntv;
	private PDLMRiskPayIntvService pdlmRiskPayIntvService;
	/**
	 * @title saveRiskPayIntv
	 * @description 保存险种交费间隔数据
	 * @author 党泽
	 * @return
	 */
	public String saveRiskPayIntv(){
		pdlmRiskPayIntv = pdlmRiskPayIntvService.saveRiskPayIntv(pdlmRiskPayIntv);
		//this.writeJSONData(list, args);
		return NONE;
	}
	/**
	 * @title deletRiskPayIntv
	 * @description 删除险种交费间隔数据
	 * @author 党泽
	 * @return
	 */
	public String deleteRiskPayIntv(){
		pdlmRiskPayIntv = pdlmRiskPayIntvService.deleteRiskPayIntv(pdlmRiskPayIntv);
		return NONE;
	}
	/**
	 * @title updateRiskPayIntv
	 * @description 更新险种交费间隔数据
	 * @author 党泽
	 * @return
	 */
	public String updateRiskPayIntv(){
		pdlmRiskPayIntv = pdlmRiskPayIntvService.updateRiskPayIntv(pdlmRiskPayIntv);
		return NONE;
	}
	public PDLMRiskPayIntv getPdlmRiskPayIntv() {
		return pdlmRiskPayIntv;
	}
	public void setPdlmRiskPayIntv(PDLMRiskPayIntv pdlmRiskPayIntv) {
		this.pdlmRiskPayIntv = pdlmRiskPayIntv;
	}
	public PDLMRiskPayIntvService getPdlmRiskPayIntvService() {
		return pdlmRiskPayIntvService;
	}
	public void setPdlmRiskPayIntvService(
			PDLMRiskPayIntvService pdlmRiskPayIntvService) {
		this.pdlmRiskPayIntvService = pdlmRiskPayIntvService;
	}
	
}
