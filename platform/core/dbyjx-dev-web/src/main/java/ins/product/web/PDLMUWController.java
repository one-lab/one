package ins.product.web;

import com.sinosoft.one.mvc.web.Invocation;
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
import ins.product.model.PDLMRisk;
import ins.product.model.PDLMRiskDutyFactor;
import ins.product.model.PDLMUW;
import ins.product.service.facade.PDBaseFieldService;
import ins.product.service.facade.PDLMUWService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/product")
public class PDLMUWController {

	private static final long serialVersionUID = 1L;
	
	private PDLMUWService pdlmUWService;

	private PDBaseFieldService pdBaseFieldService;
    @Autowired
	public void setPdlmUWService(PDLMUWService pdlmUWService) {
		this.pdlmUWService = pdlmUWService;
	}
    @Autowired
	public void setPdBaseFieldService(PDBaseFieldService pdBaseFieldService) {
		this.pdBaseFieldService = pdBaseFieldService;
	}

	public Reply checkRiskExist(@Param("pdLMUW")PDLMUW pdLMUW){
		String returnStr = pdlmUWService.checkRiskExist(pdLMUW);
		return Replys.with(returnStr).as(Text.class);
	}

	/**
	 * 获取已有的核保规则
	 * @return
	 */
	public Reply queryApplingUW(@Param("pageNo")int pageNo,@Param("pageSize")int pageSize ,
                                @Param("riskCode")String riskCode){
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
			
		
		Page page = pdlmUWService.findRiskByCondition(findRiskRule,pageNo,pageSize);
        
		String[] factorArray = new String[]{"uwCode","PDLMRisk.riskCode","uwOrder","remark"};
		return Replys.with(page.getResult()).as(Json.class).includes(factorArray);
	}
	
	/**
	 * 查询核保规则
	 * @return
	 */
	public Reply pdriskUnderwrite(@Param("uwCode")String uwCode){
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
            return Replys.with(list).as(Json.class).includes(factorArray);
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
            return Replys.with(list).as(Json.class).includes(factorArray);
		}
    }
	
	
	/**
	 * 保存核保规则记录
	 * @return
	 */
	public Reply saveLMUW(@Param("pdLMUW")PDLMUW pdLMUW,Invocation invocation){
		 pdlmUWService.saveLMUW(pdLMUW,invocation);
	//	 this.writeJSONMsg("save");
		return Replys.with("save").as(Text.class);
	}
	/**
	 * @title deleteRiskDutyPay
	 * @description 删除一条核保规则定义
	 * @return
	 */
	public Reply deleteLMUW(@Param("uwCode")String uwCode){
		String flag = pdlmUWService.deleteLMUW(uwCode);
//		this.writeJSONMsg(flag);
		return Replys.with(flag).as(Text.class);
	}
	
	
}
