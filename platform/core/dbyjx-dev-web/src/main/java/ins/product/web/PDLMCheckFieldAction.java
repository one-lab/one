package ins.product.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ins.common.util.FinalCollection;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.web.Struts2Action;
import ins.product.model.PDBaseField;
import ins.product.model.PDLMCheckField;
import ins.product.model.PDLMCheckFieldId;
import ins.product.service.facade.PDBaseFieldService;
import ins.product.service.facade.PDLMCheckFieldService;

public class PDLMCheckFieldAction extends Struts2Action {
	private static final long serialVersionUID = 1L;
	
	private PDLMCheckField pdlmCheckField;
	private PDLMCheckFieldService pdlmCheckFieldService;
	private String riskCode;
	private Page page;
	private String id;
	private PDBaseFieldService pdBaseFieldService;
	/**
	 * @title saveCheckField
	 * @description 保存险种投保规则数据
	 * @author 党泽
	 * @return
	 */
	public String saveCheckField(){
		pdlmCheckField = pdlmCheckFieldService.saveCheckField(pdlmCheckField);
		//this.writeJSONData(list, args);
		return NONE;
	}
	/**
	 * @title deletCheckField
	 * @description 删除险种投保规则数据
	 * @author 党泽
	 * @return
	 */
	public String deleteCheckField(){
		pdlmCheckField = pdlmCheckFieldService.deleteCheckField(pdlmCheckField);
		return NONE;
	}
	/**
	 * @title updateCheckField
	 * @description 更新险种投保规则数据
	 * @author 党泽
	 * @return
	 */
	public String updateCheckField(){
		pdlmCheckField = pdlmCheckFieldService.updateCheckField(pdlmCheckField);
		return NONE;
	}
	public PDLMCheckField getPdlmCheckField() {
		return pdlmCheckField;
	}
	public void setPdlmCheckField(PDLMCheckField pdlmCheckField) {
		this.pdlmCheckField = pdlmCheckField;
	}
	public PDLMCheckFieldService getPdlmCheckFieldService() {
		return pdlmCheckFieldService;
	}
	public void setPdlmCheckFieldService(PDLMCheckFieldService pdlmCheckFieldService) {
		this.pdlmCheckFieldService = pdlmCheckFieldService;
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public PDBaseFieldService getPdBaseFieldService() {
		return pdBaseFieldService;
	}

	public void setPdBaseFieldService(PDBaseFieldService pdBaseFieldService) {
		this.pdBaseFieldService = pdBaseFieldService;
	}
	
	
	/**
	 * 获取已有的投保规则
	 * @return
	 */
	public String queryApplingCF(){
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
			
		
		this.page = pdlmCheckFieldService.findRiskByCondition(findRiskRule,pageNo,pageSize);
        
		String[] factorArray = new String[]{"PDLMRisk.riskCode","id.fieldName","id.serialNO","msg","id"};
		this.writeJSONData(page.getResult(), factorArray);
		
		return NONE;
	}
	
	
	
	/**
	 * 修改/新增核保规则
	 * @return
	 */
	public String insertCF(){
		if(null!=id){
			String tableCode = "PD_LMCheckField";
			//获得相关属性
			List<PDBaseField> cfAppFields = pdBaseFieldService.findField(tableCode);
			//获得定义的险种的相关信息
			String[] idList=id.toString().split(",");
			PDLMCheckFieldId idKey=new PDLMCheckFieldId();
			idKey.setRiskCode(idList[0].toString());
			idKey.setFieldName(idList[1].toString());
			idKey.setSerialNO(idList[2].toString());
			
			
			PDLMCheckField cf = pdlmCheckFieldService.findCFByID(idKey);
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			for(PDBaseField field: cfAppFields){
				Map<String,Object> temp = new HashMap<String, Object>();
				//序号
				temp.put("displayOrder", field.getDisplayOrder());
				//属性名称
				temp.put("fieldName", field.getFieldName());
				//属性数据类型
				temp.put("fieldType", field.getFieldType());
				//属性值-->对应到一个文本框中的name属性
				temp.put("fieldValueName", "pdlmCheckField."+field.getId().getFieldCode());
				//属性值-->对应到文本框中的value属性
				temp.put("fieldValue", cf.getFieldValue(field.getId().getFieldCode()));
				//描述
				temp.put("officialDesc", field.getOfficialDesc());
				//备注
				temp.put("busiDesc", field.getBusiDesc());
				list.add(temp);
			}
			
			String[] factorArray = new String[]{"displayOrder","fieldName","fieldCode","fieldType","fieldValueName","fieldValue","officialDesc","busiDesc"};
			this.writeJSONData(list, factorArray);
		}else{
			String tableCode = "PD_LMCheckField";
			//获得相关属性
			List<PDBaseField> cfAppFields = pdBaseFieldService.findField(tableCode);
			
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			for(PDBaseField field: cfAppFields){
				Map<String,Object> temp = new HashMap<String, Object>();
				//序号
				temp.put("displayOrder", field.getDisplayOrder());
				//属性名称
				temp.put("fieldName", field.getFieldName());
				//属性数据类型
				temp.put("fieldType", field.getFieldType());	
				//属性值-->对应到一个文本框中的name属性
				temp.put("fieldValueName", "pdlmCheckField."+field.getId().getFieldCode());
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
	 * @title deleteRiskDutyPay
	 * @description 删除一条投保规则定义
	 * @return
	 */
	public String deleteCF(){
		//获得定义的险种的相关信息
		String[] idList=id.toString().split(",");
		PDLMCheckFieldId idKey=new PDLMCheckFieldId();
		idKey.setRiskCode(idList[0].toString());
		idKey.setFieldName(idList[1].toString());
		idKey.setSerialNO(idList[2].toString());
		
		String flag = pdlmCheckFieldService.deleteCF(idKey);
		this.writeJSONMsg(flag);
		return NONE;
	}
	
	
	
	/**
	 * 保存投保规则记录
	 * @return
	 */
	public String saveCF(){
		pdlmCheckFieldService.saveCheckField(pdlmCheckField);
		 this.writeJSONMsg("save");
		return NONE;
	}
}
