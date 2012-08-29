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
import ins.framework.web.Struts2Action;
import ins.product.model.PDBaseField;
import ins.product.model.PDLMRiskEdorItem;
import ins.product.service.facade.PDBaseFieldService;
import ins.product.service.facade.PDLMRiskEdorItemService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/product")
public class PDLMRiskEdorItemController {

	private static final long serialVersionUID = 1L;

	private PDLMRiskEdorItemService pdlmRiskEdorItemService;
	private PDBaseFieldService pdBaseFieldService;
    @Autowired
	public void setPdBaseFieldService(PDBaseFieldService pdBaseFieldService) {
		this.pdBaseFieldService = pdBaseFieldService;
	}
    @Autowired
	public void setPdlmRiskEdorItemService(
			PDLMRiskEdorItemService pdlmRiskEdorItemService) {
		this.pdlmRiskEdorItemService = pdlmRiskEdorItemService;
	}

	/**
	 * @title findRiskEdorItemFields
	 * @description 查询字段表，得到表PD_LMRiskEdorItem里面的字段
	 * @author 朱超
	 * @return
	 */
	public String findRiskEdorItemFields(Invocation invocation){
		List<PDBaseField> fields = pdBaseFieldService.findField("PD_LMRiskEdorItem");
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		//序号，属性名称，属性代码，属性数据类型，属性值，描述，备注
		for(PDBaseField field: fields){
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
			temp.put("fieldValueName", "pdlmRiskEdorItem."+field.getId().getFieldCode());
			//属性值-->对应到文本框中的value属性
			//temp.put("fieldValue", risk.getFieldValue(field.getId().getFieldCode()));
			//描述
			temp.put("officialDesc", field.getOfficialDesc());
			//备注
			temp.put("busiDesc", field.getBusiDesc());
			list.add(temp);
		}
		invocation.getRequest().setAttribute("fields", list);
		return "/product/pddefine/endordefine/pdendoredit.jsp";
	}
	
	/**
	 * @title addRiskEdorItem
	 * @description 增加一个保全项
	 * @author 朱超
	 * @return
	 */
	public Reply addRiskEdorItem(@Param("pdlmRiskEdorItem") PDLMRiskEdorItem pdlmRiskEdorItem){
		 pdlmRiskEdorItemService.addRiskEdorItem(pdlmRiskEdorItem);
		return Replys.simple().success();
	}
}
