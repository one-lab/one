package ins.product.web;

import ins.common.util.DisposeObject;
import ins.framework.web.Struts2Action;
import ins.product.model.PDLMDuty;
import ins.product.model.PDLMRiskDuty;
import ins.product.service.facade.PDLMRiskDutyService;

import java.sql.Date;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class PDLMRiskDutyAction extends Struts2Action {

	private static final long serialVersionUID = 1L;
	private PDLMRiskDuty pdlmRiskDuty;
	private PDLMDuty pdlmDuty;
	private PDLMRiskDutyService pdlmRiskDutyService;
	private String dutyCode;
	private String riskCode;
	

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
	public PDLMRiskDutyService getPdlmRiskDutyService() {
		return pdlmRiskDutyService;
	}
	public void setPdlmRiskDutyService(PDLMRiskDutyService pdlmRiskDutyService) {
		this.pdlmRiskDutyService = pdlmRiskDutyService;
	}
	
	public PDLMRiskDuty getPdlmRiskDuty() {
		return pdlmRiskDuty;
	}
	public void setPdlmRiskDuty(PDLMRiskDuty pdlmRiskDuty) {
		this.pdlmRiskDuty = pdlmRiskDuty;
	}
	public PDLMDuty getPdlmDuty() {
		return pdlmDuty;
	}
	public void setPdlmDuty(PDLMDuty pdlmDuty) {
		this.pdlmDuty = pdlmDuty;
	}
	/**
	 * @title saveRiskDuty
	 * @description 保存险种责任定义，和险种责任关联的定义
	 * @author 朱超
	 * @return
	 */
	public String saveRiskDuty(){
		pdlmRiskDuty = pdlmRiskDutyService.saveRiskDuty(pdlmRiskDuty,pdlmDuty);
		pdlmRiskDuty.setPDLMDuty(null);
		DisposeObject dis = new DisposeObject();
		Map map = dis.dispose(pdlmRiskDuty, new String[]{"id.riskCode","id.dutyCode","riskVer"});
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("pdlmRiskDuty", JSONArray.fromObject(map));
		return NONE;
	}
	/**
	 * @title updateDhtml
	 * @description 更新riskDuty表中的dhtml字段，为契约使用
	 * @author 朱超
	 * @return
	 */
	public String updateDhtml(){
		String flag = pdlmRiskDutyService.updateDhtml(pdlmRiskDuty);
		this.renderText(flag);
		return NONE;
	}
	
	public String deleteRiskDuty(){
		//String flag = pdlmRiskDutyService.deleteRiskDuty();
		return NONE;
	}
	//直接跳转页面
	public String showDefine(){
		
		return SUCCESS;
	}
}
