package ins.product.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Text;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;

import ins.framework.web.Struts2Action;
import ins.product.model.PDBaseField;
import ins.product.model.PDLMRisk;
import ins.product.model.PDLMRiskApp;
import ins.product.service.facade.PDBaseFieldService;
import ins.product.service.facade.PDLMRiskAppService;
import ins.product.service.facade.PdLmRiskService;
@Path("/product")
public class PDLMRiskAppController {
	private static final long serialVersionUID = 1L;
	private PDBaseFieldService pdBaseFieldService;
	private PDLMRiskAppService pdlmRiskAppService;

	@Autowired
	public void setPdBaseFieldService(PDBaseFieldService pdBaseFieldService) {
		this.pdBaseFieldService = pdBaseFieldService;
	}
	
	@Autowired
	public void setPdlmRiskAppService(PDLMRiskAppService pdlmRiskAppService) {
		this.pdlmRiskAppService = pdlmRiskAppService;
	}

	/**
	 * 险种承保定义——查询字段
	 * @return
	 */
	public String findRiskAppField(@Param("riskCode") String riskCode,
                                   Invocation invocation){
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
	    invocation.addModel("list", list);
        invocation.addModel("flag", "false");
		//将list放在request中
		return "/product/pddefine/baseinfodefine/pdlmriskappedit.jsp";
	}
	/**
	 * @title saveRiskApp
	 * @description 保存一条险种承保定义
	 * @author 朱超
	 * @return
	 */
	public Reply saveRiskApp(@Param("pdlmRiskApp") PDLMRiskApp pdlmRiskApp){
        PDLMRiskApp pdlmRiskAppTarget = pdlmRiskAppService.saveRiskApp(pdlmRiskApp);
		return Replys.with("保存成功！险种代码为："+pdlmRiskApp.getRiskCode()).as(Text.class);
	}
	
	/**
	 * @title deleteRiskApp
	 * @description 删除一条险种承保定义，通过ID
	 * @author 朱超
	 * @return
	 */
	public Reply deleteRiskApp(@Param("riskCode") String riskCode){
		String flag = pdlmRiskAppService.deleteRiskApp(riskCode);
		return Replys.with(flag);
	}
}
