package ins.product.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Text;
import ins.common.util.FinalCollection;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.web.Struts2Action;
import ins.product.model.PDBaseField;
import ins.product.model.PDLMCheckField;
import ins.product.model.PDLMCheckFieldId;
import ins.product.service.facade.PDBaseFieldService;
import ins.product.service.facade.PDLMCheckFieldService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/product")
public class PDLMCheckFieldController  {
	private static final long serialVersionUID = 1L;
	
    @Autowired
	private PDLMCheckFieldService pdlmCheckFieldService;
    @Autowired
	private PDBaseFieldService pdBaseFieldService;
	/**
	 * @title saveCheckField
	 * @description 保存险种投保规则数据
	 * @author 党泽
	 * @return
	 */
	public Reply saveCheckField(@Param("pdlmCheckField")PDLMCheckField pdlmCheckField){
		pdlmCheckField = pdlmCheckFieldService.saveCheckField(pdlmCheckField);
		//this.writeJSONData(list, args);
		return Replys.simple().fail();
	}
	/**
	 * @title deletCheckField
	 * @description 删除险种投保规则数据
	 * @author 党泽
	 * @return
	 */
	public Reply deleteCheckField(@Param("pdlmCheckField")PDLMCheckField pdlmCheckField){
		pdlmCheckField = pdlmCheckFieldService.deleteCheckField(pdlmCheckField);
		return Replys.simple().fail();
	}
	/**
	 * @title updateCheckField
	 * @description 更新险种投保规则数据
	 * @author 党泽
	 * @return
	 */
	public Reply updateCheckField(@Param("pdlmCheckField")PDLMCheckField pdlmCheckField){
		pdlmCheckField = pdlmCheckFieldService.updateCheckField(pdlmCheckField);
		return Replys.simple().fail();
	}


	public void setPdlmCheckFieldService(PDLMCheckFieldService pdlmCheckFieldService) {
		this.pdlmCheckFieldService = pdlmCheckFieldService;
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
	public Reply queryApplingCF(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize,
                                @Param("riskCode") String riskCode){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		QueryRule findRiskRule = QueryRule.getInstance();
		
		/** 参数以对象的方式传入，对应变量进行赋值*/
		
		if(null != riskCode && !"".equals(riskCode.trim())){
			findRiskRule.addLike("PDLMRisk.riskCode", riskCode.trim()+"%");
		}
			
		
		 Page page = pdlmCheckFieldService.findRiskByCondition(findRiskRule,pageNo,pageSize);
        
		String[] factorArray = new String[]{"PDLMRisk.riskCode","id.fieldName","id.serialNO","msg","id"};

		return Replys.with(page.getResult()).as(Json.class).includes(factorArray);
	}
	
	
	
	/**
	 * 修改/新增核保规则
	 * @return
	 */
	public Reply insertCF(@Param("id")String id){
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
	public Reply deleteCF(@Param("id")String id){
		//获得定义的险种的相关信息
		String[] idList=id.toString().split(",");
		PDLMCheckFieldId idKey=new PDLMCheckFieldId();
		idKey.setRiskCode(idList[0].toString());
		idKey.setFieldName(idList[1].toString());
		idKey.setSerialNO(idList[2].toString());
		
		String flag = pdlmCheckFieldService.deleteCF(idKey);
        return Replys.with(flag).as(Text.class);
    }
	
	
	
	/**
	 * 保存投保规则记录
	 * @return
	 */
	public Reply saveCF(@Param("pdlmCheckField")PDLMCheckField pdlmCheckField){
		pdlmCheckFieldService.saveCheckField(pdlmCheckField);
		return Replys.simple().fail();
	}
}
