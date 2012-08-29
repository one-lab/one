package ins.product.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;

import ins.framework.web.Struts2Action;
import ins.product.model.PDBaseField;
import ins.product.model.PDLMRisk;
import ins.product.model.PDLMRiskApp;
import ins.product.service.facade.PDBaseFieldService;
import ins.product.service.facade.PDLMRiskAppService;
import ins.product.service.facade.PdLmRiskService;

public class PDLMRiskAppAction extends Struts2Action {
	private static final long serialVersionUID = 1L;
	private String riskCode;
	private PDBaseFieldService pdBaseFieldService;
	private PDLMRiskAppService pdlmRiskAppService;
	private PDLMRiskApp pdlmRiskApp;
	
	public PDLMRiskApp getPdlmRiskApp() {
		return pdlmRiskApp;
	}

	public void setPdlmRiskApp(PDLMRiskApp pdlmRiskApp) {
		this.pdlmRiskApp = pdlmRiskApp;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public PDBaseFieldService getPdBaseFieldService() {
		return pdBaseFieldService;
	}

	public void setPdBaseFieldService(PDBaseFieldService pdBaseFieldService) {
		this.pdBaseFieldService = pdBaseFieldService;
	}
	
	public PDLMRiskAppService getPdlmRiskAppService() {
		return pdlmRiskAppService;
	}

	public void setPdlmRiskAppService(PDLMRiskAppService pdlmRiskAppService) {
		this.pdlmRiskAppService = pdlmRiskAppService;
	}

	/**
	 * 险种承保定义——查询字段
	 * @return
	 */
	public String findRiskAppField(){
		String tableCode = "PD_LMRiskAPP";
		List<PDBaseField> riskAppFields = pdBaseFieldService.findField(tableCode);
		
		//获得定义的险种的相关信息
		if(null == riskCode){
			riskCode = (String)ActionContext.getContext().getSession().get("riskCode");
		}
		PDLMRiskApp riskApp = pdlmRiskAppService.findByRiskCode(riskCode);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(PDBaseField field: riskAppFields){
			Map<String,Object> temp = new HashMap<String, Object>();
			temp.put("displayOrder", field.getDisplayOrder());
			temp.put("fieldCName", field.getFieldName());
			temp.put("fieldType", field.getFieldType());
			temp.put("fieldName", "pdlmRiskApp."+field.getId().getFieldCode());
			temp.put("fieldCode", riskApp.getFieldValue(field.getId().getFieldCode()));
			temp.put("officialDesc", field.getOfficialDesc());
			temp.put("busiDesc", field.getBusiDesc());
			list.add(temp);
		}
		super.getRequest().setAttribute("list",list);
		super.getRequest().setAttribute("flag", "false");
		//将list放在request中
		return SUCCESS;
	}
	/**
	 * @title saveRiskApp
	 * @description 保存一条险种承保定义
	 * @author 朱超
	 * @return
	 */
	public String saveRiskApp(){
		pdlmRiskApp = pdlmRiskAppService.saveRiskApp(pdlmRiskApp);
		renderText("保存成功！险种代码为："+pdlmRiskApp.getRiskCode());
		return NONE;
	}
	
	/**
	 * @title deleteRiskApp
	 * @description 删除一条险种承保定义，通过ID
	 * @author 朱超
	 * @return
	 */
	public String deleteRiskApp(){
		String flag = pdlmRiskAppService.deleteRiskApp(riskCode);
		renderText(flag);
		return NONE;
	}
}
