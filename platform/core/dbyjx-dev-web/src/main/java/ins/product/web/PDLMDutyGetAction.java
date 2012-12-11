package ins.product.web;

import ins.common.util.DisposeObject;
import ins.framework.web.Struts2Action;
import ins.product.model.PDBaseField;
import ins.product.model.PDLMDutyGet;
import ins.product.service.facade.PDBaseFieldService;
import ins.product.service.facade.PDLMDutyGetService;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

public class PDLMDutyGetAction extends Struts2Action {
	private static final long serialVersionUID = 1L;
	
	private String riskCode;
	private String getDutyCode;
	private PDBaseFieldService pdBaseFieldService;
	private PDLMDutyGet pdLmDutyGet;
	private PDLMDutyGetService pdLmDutyGetService;
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	
	public String getGetDutyCode() {
		return getDutyCode;
	}
	public void setGetDutyCode(String getDutyCode) {
		this.getDutyCode = getDutyCode;
	}
	public PDBaseFieldService getPdBaseFieldService() {
		return pdBaseFieldService;
	}
	public void setPdBaseFieldService(PDBaseFieldService pdBaseFieldService) {
		this.pdBaseFieldService = pdBaseFieldService;
	}
	public PDLMDutyGet getPdLmDutyGet() {
		return pdLmDutyGet;
	}
	public void setPdLmDutyGet(PDLMDutyGet pdLmDutyGet) {
		this.pdLmDutyGet = pdLmDutyGet;
	}
	public PDLMDutyGetService getPdLmDutyGetService() {
		return pdLmDutyGetService;
	}
	public void setPdLmDutyGetService(PDLMDutyGetService pdLmDutyGetService) {
		this.pdLmDutyGetService = pdLmDutyGetService;
	}
	public String findDutyGetField(){
		String tableCode = "PD_LMDutyGet";
		List<PDBaseField> dutyGetFields = pdBaseFieldService.findField(tableCode);
		super.getRequest().setAttribute("dutyGetFields", dutyGetFields);
		super.getRequest().setAttribute("dutyGetFlag", "false");
		return SUCCESS;
	}
	/**
	 * @title saveRiskDutyGet
	 * @description 保存一条险种给付责任
	 * @author 朱超
	 * @return
	 */
	public String saveRiskDutyGet(){
		//保存注意pdlmCalMode和PDLMDuty的引用
		pdLmDutyGet = pdLmDutyGetService.saveRiskDutyGet(pdLmDutyGet);
		DisposeObject dis = new DisposeObject();
		dis.dispose(pdLmDutyGet, null);
		List<PDLMDutyGet> pdlmDutyGets = new ArrayList<PDLMDutyGet>();
		pdlmDutyGets.add(pdLmDutyGet);
		this.writeJSONData(pdlmDutyGets, null);
		return NONE;
	}
	
	public String deleteRiskDutyGet(){
		String flag = pdLmDutyGetService.deleteRiskDutyGet(getDutyCode);
		System.out.println(flag);
		this.renderText(flag);
		return NONE;
	}
}
