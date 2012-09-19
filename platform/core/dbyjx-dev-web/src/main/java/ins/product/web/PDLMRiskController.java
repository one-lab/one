package ins.product.web;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Text;
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
import org.springframework.beans.factory.annotation.Autowired;

@Path("/product")
public class PDLMRiskController {

	private static final long serialVersionUID = 1L;
	
    @Autowired
	private PdLmRiskService pdLmRiskService;
    @Autowired
	private PDLMRiskAppService pdlmRiskAppService;
    @Autowired
	private PDBaseFieldService pdBaseFieldService;


	public Reply checkRiskExist(@Param("pdLMRisk") PDLMRisk pdLMRisk){
		String returnStr = pdLmRiskService.checkRiskExist(pdLMRisk);
		return Replys.with(returnStr).as(Text.class);
	}
	
	/**
	 * 获取定义中的险种信息
	 * @return
	 */
	public String queryApplingRisk(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize,
                                   @Param("pdLMRisk") PDLMRisk pdLMRisk,
                                   @Param("riskName") String riskName,
                                   @Param("flag") String flag,
                                   Invocation invocation){
		String returnForward="";
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		QueryRule findRiskRule = QueryRule.getInstance();
		
		/** 参数以对象的方式传入，对应变量进行赋值*/
		String riskCode = pdLMRisk.getRiskCode();
		Date makeDate = pdLMRisk.getMakeDate();
		
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
			returnForward="/product/pddefine/policydefine/pdrisksortquery.jsp";
		   }else if("4".equals(flag)){    //理赔模块查询产品信息时flag标记为4(党泽)
				    String[] riskStatus = new String[]{"1","2"};
	            	findRiskRule.addIn("flag",riskStatus);
				returnForward="/product/pddefine/claimdefine/pdclaimquery.jsp";
		 }else{  //基础信息定义 （查询定义中或退回修改）  
			String[] riskStatus = new String[]{"1","2"};
			
			findRiskRule.addIn("flag",riskStatus);
			returnForward="/product/pddefine/baseinfodefine/pdbasequery.jsp";
		}
		
		Page page = pdLmRiskService.findRiskByCondition(findRiskRule,pageNo,pageSize);
        invocation.addModel("page", page);
        invocation.addModel("riskCode", riskCode);
        invocation.addModel("makeDate", makeDate);
		return returnForward;
	}
	
	/**
	 * 选择定义中的产品进行处理,组织一个大的Map将要定义的所有表的field取出来
	 * @return
	 */
	public String queryModifyApplingRisk(@Param("pdLMRisk") PDLMRisk pdLMRisk,
                                         Invocation invocation){
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
		
		invocation.getRequest().getSession().setAttribute("riskCode", pdLMRisk.getRiskCode());
		invocation.getRequest().setAttribute("allTableFields",allTableFields);
		
		return "/product/pddefine/baseinfodefine/pdRiskDefine.jsp";
	}
	
	public Reply saveRisk(@Param("pdlMRisk") PDLMRisk pdLMRisk,Invocation invocation){
		pdLmRiskService.saveRisk(pdLMRisk,invocation);
		return Replys.simple().success();
	}
}
