package ins.product.web;

import ins.common.util.FinalCollection;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.web.Struts2Action;
import ins.product.model.PDBaseField;
import ins.product.model.PDLMRisk;
import ins.product.model.PDLMRiskApp;
import ins.product.service.facade.PDBaseFieldService;
import ins.product.service.facade.PDLMRiskAppService;
import ins.product.service.facade.PdLmRiskService;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class PDLMRiskAction extends Struts2Action {

	private static final long serialVersionUID = 1L;
	
	private PDLMRisk pdLMRisk;
	private String riskCode;
	private String riskName;
	private Date makeDate;
	private String comCode;
	private PdLmRiskService pdLmRiskService;
	private PDLMRiskAppService pdlmRiskAppService;
	private PDBaseFieldService pdBaseFieldService;
	private String flag;
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	private Page page;
	
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public PDLMRisk getPdLMRisk() {
		return pdLMRisk;
	}

	public void setPdLMRisk(PDLMRisk pdLMRisk) {
		this.pdLMRisk = pdLMRisk;
	}

	public PdLmRiskService getPdLmRiskService() {
		return pdLmRiskService;
	}

	public void setPdLmRiskService(PdLmRiskService pdLmRiskService) {
		this.pdLmRiskService = pdLmRiskService;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public Date getMakeDate() {
		return makeDate;
	}

	public void setMakeDate(Date makeDate) {
		this.makeDate = makeDate;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public PDLMRiskAppService getPdlmRiskAppService() {
		return pdlmRiskAppService;
	}

	public void setPdlmRiskAppService(PDLMRiskAppService pdlmRiskAppService) {
		this.pdlmRiskAppService = pdlmRiskAppService;
	}

	public PDBaseFieldService getPdBaseFieldService() {
		return pdBaseFieldService;
	}

	public void setPdBaseFieldService(PDBaseFieldService pdBaseFieldService) {
		this.pdBaseFieldService = pdBaseFieldService;
	}

	public String checkRiskExist(){
		String returnStr = pdLmRiskService.checkRiskExist(pdLMRisk);
		this.renderText(returnStr);
		return NONE;
	}
	
	/**
	 * 获取定义中的险种信息
	 * @return
	 */
	public String queryApplingRisk(){
		String returnForward="";
		if(this.pageNo == 0){
			this.pageNo = 1;
		}
		if(this.pageSize == 0){
			this.pageSize = FinalCollection.PAGE_SIZE;
		}
		QueryRule findRiskRule = QueryRule.getInstance();
		
		/** 参数以对象的方式传入，对应变量进行赋值*/
		riskCode = pdLMRisk.getRiskCode();
		makeDate = pdLMRisk.getMakeDate();
		
		if(null != riskCode && !"".equals(riskCode.trim())){
			findRiskRule.addLike("riskCode", riskCode.trim()+"%");
		}
		if(null != riskName && !"".equals(riskName.trim())){
			findRiskRule.addLike("riskName", riskName.trim());
		}
		if(null != makeDate){
			findRiskRule.addEqual("makeDate", makeDate);
		}
		//定义产品状态标记说明 0--发布  1--定义中 2--退回修改  3--基础信息定义完毕
		 if("3".equals(flag)){    //契约模块定义菜单复用此方法改造
			findRiskRule.addEqual("flag", "3"); 
			returnForward="policyDefine";
		   }else if("4".equals(flag)){    //理赔模块查询产品信息时flag标记为4(党泽)
				    String[] riskStatus = new String[]{"1","2"};
	            	findRiskRule.addIn("flag",riskStatus);
				returnForward="claimDefine";
		 }else{  //基础信息定义 （查询定义中或退回修改）  
			String[] riskStatus = new String[]{"1","2"};
			
			findRiskRule.addIn("flag",riskStatus);
			returnForward="baseInfoDefine";
		}
		
		this.page = pdLmRiskService.findRiskByCondition(findRiskRule,pageNo,pageSize);
		return returnForward;
	}
	
	/**
	 * 选择定义中的产品进行处理,组织一个大的Map将要定义的所有表的field取出来
	 * @return
	 */
	public String queryModifyApplingRisk(){
		//存放各表的字段
		Map<String,List<Map<String,Object>>> allTableFields = new HashMap<String, List<Map<String,Object>>>();
		//-------------------------------pdlmRisk---------------------------
		String tableCode = "PD_LMRisk";
		//获得相关属性
		List<PDBaseField> riskField = pdLmRiskService.findFieldsByTableCode(tableCode);
		//获得定义的险种的相关信息
		PDLMRisk risk = pdLmRiskService.findRiskByRiskCode(pdLMRisk.getRiskCode());
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(PDBaseField field: riskField){
			Map<String,Object> temp = new HashMap<String, Object>();
			//序号
			temp.put("displayOrder", field.getDisplayOrder());
			//属性名称
			temp.put("fieldName", field.getFieldName());
			//属性代码
			temp.put("fieldCode", field.getId().getFieldCode());
			//属性数据类型
			temp.put("fieldType", field.getFieldType());			
			//属性值-->对应到一个文本框中的name属性
			temp.put("fieldValueName", "pdlmRisk."+field.getId().getFieldCode());
			//属性值-->对应到文本框中的value属性
			temp.put("fieldValue", risk.getFieldValue(field.getId().getFieldCode()));
			//描述
			temp.put("officialDesc", field.getOfficialDesc());
			//备注
			temp.put("busiDesc", field.getBusiDesc());
			list.add(temp);
		}
		allTableFields.put("pdlmRisk", list);
		
		//-------------------------------pdlmRiskApp---------------------------
		tableCode = "PD_LMRiskAPP";
		List<PDBaseField> riskAppFields = pdBaseFieldService.findField(tableCode);
		PDLMRiskApp riskApp = pdlmRiskAppService.findByRiskCode(pdLMRisk.getRiskCode());
		list = new ArrayList<Map<String,Object>>();
		for(PDBaseField field: riskAppFields){
			Map<String,Object> temp = new HashMap<String, Object>();
			//序号
			temp.put("displayOrder", field.getDisplayOrder());
			//属性名称
			temp.put("fieldName", field.getFieldName());
			//属性代码
			temp.put("fieldCode", field.getId().getFieldCode());
			//属性数据类型
			temp.put("fieldType", field.getFieldType());			
			//属性值-->对应到一个文本框中的name属性
			temp.put("fieldValueName", "pdlmRiskApp."+field.getId().getFieldCode());
			//属性值-->对应到文本框中的value属性
			temp.put("fieldValue", riskApp.getFieldValue(field.getId().getFieldCode()));
			//描述
			temp.put("officialDesc", field.getOfficialDesc());
			//备注
			temp.put("busiDesc", field.getBusiDesc());
			list.add(temp);
		}
		allTableFields.put("pdlmRiskApp", list);
		
		//-------------------------------pdlmDutyGet---------------------------
		tableCode = "PD_LMDutyGet";
		List<PDBaseField> dutyGetFields = pdBaseFieldService.findField(tableCode);
		//PDLMRiskApp riskApp = pdlmRiskAppService.findByRiskCode(riskCode);
		list = new ArrayList<Map<String,Object>>();
		for(PDBaseField field: dutyGetFields){
			Map<String,Object> temp = new HashMap<String, Object>();
			//序号
			temp.put("displayOrder", field.getDisplayOrder());
			//属性名称
			temp.put("fieldName", field.getFieldName());
			//属性代码
			temp.put("fieldCode", field.getId().getFieldCode());
			//属性数据类型
			temp.put("fieldType", field.getFieldType());			
			//属性值-->对应到一个文本框中的name属性
			temp.put("fieldValueName", "pdlmDutyGet."+field.getId().getFieldCode());
			//属性值-->对应到文本框中的value属性
			//temp.put("fieldValue", riskApp.getFieldValue(field.getId().getFieldCode()));
			//描述
			temp.put("officialDesc", field.getOfficialDesc());
			//备注
			temp.put("busiDesc", field.getBusiDesc());
			list.add(temp);
		}
		allTableFields.put("pdlmDutyGet", list);
		
		//-------------------------------pdlmDutyPay---------------------------
		tableCode = "PD_LMDutyPay";
		List<PDBaseField> dutyPayFields = pdBaseFieldService.findField(tableCode);
		//PDLMRiskApp riskApp = pdlmRiskAppService.findByRiskCode(riskCode);
		list = new ArrayList<Map<String,Object>>();
		for(PDBaseField field: dutyPayFields){
			Map<String,Object> temp = new HashMap<String, Object>();
			//序号
			temp.put("displayOrder", field.getDisplayOrder());
			//属性名称
			temp.put("fieldName", field.getFieldName());
			//属性代码
			temp.put("fieldCode", field.getId().getFieldCode());
			//属性数据类型
			
			temp.put("fieldType", field.getFieldType());			
			//属性值-->对应到一个文本框中的name属性
			temp.put("fieldValueName", "pdlmDutyPay."+field.getId().getFieldCode());
			//属性值-->对应到文本框中的value属性
			//temp.put("fieldValue", riskApp.getFieldValue(field.getId().getFieldCode()));
			//描述
			temp.put("officialDesc", field.getOfficialDesc());
			//备注
			temp.put("busiDesc", field.getBusiDesc());
			list.add(temp);
		}
		allTableFields.put("pdlmDutyPay", list);
		
		//-------------------------------PD_LMDuty---------------------------
		tableCode = "PD_LMDuty";
		List<PDBaseField> dutyFields = pdBaseFieldService.findField(tableCode);
		//PDLMRiskApp riskApp = pdlmRiskAppService.findByRiskCode(riskCode);
		list = new ArrayList<Map<String,Object>>();
		for(PDBaseField field: dutyFields){
			Map<String,Object> temp = new HashMap<String, Object>();
			//序号
			temp.put("displayOrder", field.getDisplayOrder());
			//属性名称
			temp.put("fieldName", field.getFieldName());
			//属性代码
			temp.put("fieldCode", field.getId().getFieldCode());
			//属性数据类型
			temp.put("fieldType", field.getFieldType());			
			//属性值-->对应到一个文本框中的name属性
			temp.put("fieldValueName", "pdlmDuty."+field.getId().getFieldCode());
			//属性值-->对应到文本框中的value属性
			//temp.put("fieldValue", riskApp.getFieldValue(field.getId().getFieldCode()));
			//描述
			temp.put("officialDesc", field.getOfficialDesc());
			//备注
			temp.put("busiDesc", field.getBusiDesc());
			list.add(temp);
		}
		allTableFields.put("pdlmDuty", list);
		
		//-------------------------------PD_LMRiskDuty---------------------------
		tableCode = "PD_LMRiskDuty";
		List<PDBaseField> dutyRiskFields = pdBaseFieldService.findField(tableCode);
		//PDLMRiskApp riskApp = pdlmRiskAppService.findByRiskCode(riskCode);
		list = new ArrayList<Map<String,Object>>();
		for(PDBaseField field: dutyRiskFields){
			Map<String,Object> temp = new HashMap<String, Object>();
			//序号
			temp.put("displayOrder", field.getDisplayOrder());
			//属性名称
			temp.put("fieldName", field.getFieldName());
			//属性代码
			temp.put("fieldCode", field.getId().getFieldCode());
			//属性数据类型
			temp.put("fieldType", field.getFieldType());			
			//属性值-->对应到一个文本框中的name属性
			temp.put("fieldValueName", "pdlmRiksDuty."+field.getId().getFieldCode());
			//属性值-->对应到文本框中的value属性
			//temp.put("fieldValue", riskApp.getFieldValue(field.getId().getFieldCode()));
			//描述
			temp.put("officialDesc", field.getOfficialDesc());
			//备注
			temp.put("busiDesc", field.getBusiDesc());
			list.add(temp);
		}
		allTableFields.put("pdlmRiskDuty", list);
		
		super.getSession().setAttribute("riskCode", riskCode);
		super.getRequest().setAttribute("allTableFields",allTableFields);
		
		return "queryModifyRiskInfo";
	}
	
	public String saveRisk(){
		pdLmRiskService.saveRisk(pdLMRisk);
		System.out.println(pdLMRisk.getRiskCode());
		return NONE;
	}
}
