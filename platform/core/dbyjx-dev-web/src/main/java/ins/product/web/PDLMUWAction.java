package ins.product.web;

import ins.common.util.FinalCollection;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.web.Struts2Action;
import ins.product.model.PDBaseField;
import ins.product.model.PDLMRisk;
import ins.product.model.PDLMRiskDutyFactor;
import ins.product.model.PDLMUW;
import ins.product.service.facade.PDBaseFieldService;
import ins.product.service.facade.PDLMUWService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PDLMUWAction extends Struts2Action {

	private static final long serialVersionUID = 1L;
	
	private PDLMUW pdLMUW;
	private String riskCode;
	private String uwCode;
	private String makeDate;
	private String comCode;
	private String selectApplingRadio;
	private PDLMUWService pdlmUWService;
	private PDBaseFieldService pdBaseFieldService;
	
	private Page page;
	

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public PDLMUW getPdLMUW() {
		return pdLMUW;
	}

	public void setPdLMUW(PDLMUW pdLMUW) {
		this.pdLMUW = pdLMUW;
	}



	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getMakeDate() {
		return makeDate;
	}

	public void setMakeDate(String makeDate) {
		this.makeDate = makeDate;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}



	public PDLMUWService getPdlmUWService() {
		return pdlmUWService;
	}

	public void setPdlmUWService(PDLMUWService pdlmUWService) {
		this.pdlmUWService = pdlmUWService;
	}

	public PDBaseFieldService getPdBaseFieldService() {
		return pdBaseFieldService;
	}

	public void setPdBaseFieldService(PDBaseFieldService pdBaseFieldService) {
		this.pdBaseFieldService = pdBaseFieldService;
	}

	public String checkRiskExist(){
		String returnStr = pdlmUWService.checkRiskExist(pdLMUW);
		this.renderText(returnStr);
		return NONE;
	}
	


	public String getSelectApplingRadio() {
		return selectApplingRadio;
	}

	public void setSelectApplingRadio(String selectApplingRadio) {
		this.selectApplingRadio = selectApplingRadio;
	}

	public String getUwCode() {
		return uwCode;
	}

	public void setUwCode(String uwCode) {
		this.uwCode = uwCode;
	}

	/**
	 * 获取已有的核保规则
	 * @return
	 */
	public String queryApplingUW(){
		if(this.pageNo == 0){
			this.pageNo = 1;
		}
		if(this.pageSize == 0){
			this.pageSize = FinalCollection.PAGE_SIZE;
		}
		QueryRule findRiskRule = QueryRule.getInstance();
		
		/** 参数以对象的方式传入，对应变量进行赋值*/
		
		if(null != riskCode && !"".equals(riskCode.trim())){
			findRiskRule.addLike("PDLMRisk.riskCode", riskCode.trim()+"%");
		}
			
		
		this.page = pdlmUWService.findRiskByCondition(findRiskRule,pageNo,pageSize);
        
		String[] factorArray = new String[]{"uwCode","PDLMRisk.riskCode","uwOrder","remark"};
		this.writeJSONData(page.getResult(), factorArray);
		
		return NONE;
	}
	
	/**
	 * 查询核保规则
	 * @return
	 */
	public String pdriskUnderwrite(){
		if(null!=uwCode&&!"".equals(uwCode.trim())){
			String tableCode = "PD_LMUW";
			//获得相关属性
			List<PDBaseField> uwAppFields = pdBaseFieldService.findField(tableCode);
			//获得定义的险种的相关信息
			PDLMUW uw = pdlmUWService.findUWByUWCode(uwCode);
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			for(PDBaseField field: uwAppFields){
				Map<String,Object> temp = new HashMap<String, Object>();
				//序号
				temp.put("displayOrder", field.getDisplayOrder());
				//属性名称
				temp.put("fieldName", field.getFieldName());
				//属性数据类型
				temp.put("fieldType", field.getFieldType());
				//属性值-->对应到一个文本框中的name属性
				temp.put("fieldValueName", "pdLMUW."+field.getId().getFieldCode());
				//属性值-->对应到文本框中的value属性
				temp.put("fieldValue", uw.getFieldValue(field.getId().getFieldCode()));
				//描述
				temp.put("officialDesc", field.getOfficialDesc());
				//备注
				temp.put("busiDesc", field.getBusiDesc());
				list.add(temp);
			}
			
			String[] factorArray = new String[]{"displayOrder","fieldName","fieldCode","fieldType","fieldValueName","fieldValue","officialDesc","busiDesc"};
			this.writeJSONData(list, factorArray);
		}else{
			String tableCode = "PD_LMUW";
			//获得相关属性
			List<PDBaseField> uwAppFields = pdBaseFieldService.findField(tableCode);
			
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			for(PDBaseField field: uwAppFields){
				Map<String,Object> temp = new HashMap<String, Object>();
				//序号
				temp.put("displayOrder", field.getDisplayOrder());
				//属性名称
				temp.put("fieldName", field.getFieldName());
				//属性数据类型
				temp.put("fieldType", field.getFieldType());	
				//属性值-->对应到一个文本框中的name属性
				temp.put("fieldValueName", "pdLMUW."+field.getId().getFieldCode());
				//属性值-->对应到文本框中的value属性
				temp.put("fieldValue", "");
				//描述
				temp.put("officialDesc", field.getOfficialDesc());
				//备注
				temp.put("busiDesc", field.getBusiDesc());
				list.add(temp);
			}
			String[] factorArray = new String[]{"displayOrder","fieldName","fieldType","fieldValueName","fieldValue","officialDesc","busiDesc"};
			this.writeJSONData(list, factorArray);
		}
		
		return NONE;
		
	}
	
	
	/**
	 * 保存核保规则记录
	 * @return
	 */
	public String saveLMUW(){
		 pdlmUWService.saveLMUW(pdLMUW);
		 this.writeJSONMsg("save");
		return NONE;
	}
	/**
	 * @title deleteRiskDutyPay
	 * @description 删除一条核保规则定义
	 * @return
	 */
	public String deleteLMUW(){
		String flag = pdlmUWService.deleteLMUW(uwCode);
		this.writeJSONMsg(flag);
		return NONE;
	}
	
	
}
