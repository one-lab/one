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
import ins.common.util.FinalCollection;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.web.Struts2Action;
import ins.product.model.PDBaseField;
import ins.product.model.PDLMCheckFieldId;
import ins.product.model.PDLMRiskRole;
import ins.product.model.PDLMRiskRoleId;
import ins.product.service.facade.PDBaseFieldService;
import ins.product.service.facade.PDLMRiskRoleService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/product")
public class PDLMRiskRoleController {
	private static final long serialVersionUID = 1L;
	
//	private PDLMRiskRole pdlmRiskRole;
	private PDLMRiskRoleService pdlmRiskRoleService;

	private PDBaseFieldService pdBaseFieldService;

	/**
	 * @title findRiskRoleByRisk
	 * @description 通过险种代码查询险种角色数据
	 * @author 党泽
	 * @return
	 */
	public Reply findRiskRoleByRisk(@Param("pageNo")int pageNo,@Param("pageSize")int pageSize,
                                     @Param("riskCode")String riskCode) {
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		QueryRule findRiskRule = QueryRule.getInstance();
        /** 参数以对象的方式传入，对应变量进行赋值*/
		
		if(null != riskCode && !"".equals(riskCode.trim())){
			findRiskRule.addEqual("id.riskCode", riskCode.trim());
		}
		 Page page = pdlmRiskRoleService.findRiskByCondition(findRiskRule,pageNo,pageSize);
		String[] RoleArray = new String[]{"id.riskCode","riskVer","id.riskRole","id.riskRoleSex","id.riskRoleNo","minAppAgeFlag","minAppAge","maxAppAgeFlag","maxAppAge"};
	//	this.writeJSONData(page.getResult(), RoleArray);
		return Replys.with(page.getResult()).as(Json.class).includes(RoleArray);
	}
	/**
	 * @title findRiskRoleByRisk
	 * @description 通过险种角色主键查询险种角色数据
	 * @author 党泽
	 * @return
	 */
	public Reply findRiskRole(@Param("riskRoleUnion")String riskRoleUnion,@Param("riskCode")String riskCode,
                               @Param("riskRole")String riskRole,@Param("riskRoleSex")String riskRoleSex,
                               @Param("riskRoleNo")String riskRoleNo){
		if(!"".equals(riskRoleUnion)){
			String [] unionCode=riskRoleUnion.split(",");
			riskCode=unionCode[0];
			riskRole=unionCode[1];
			riskRoleSex=unionCode[2];
			riskRoleNo=unionCode[3];}
		if(null!=riskCode&&!"".equals(riskCode.trim())&&null!=riskRole&&!"".equals(riskRole.trim())&&null!=riskRoleSex&&!"".equals(riskRoleSex.trim())&&null!=riskRoleNo&&!"".equals(riskRoleNo.trim())){
			String tableCode = "PD_LMRiskRole";
			//获得相关属性
			List<PDBaseField> roleFields = pdBaseFieldService.findField(tableCode);
			//获得定义的险种角色的相关信息
			PDLMRiskRoleId id=new PDLMRiskRoleId();
			id.setRiskCode(riskCode);
			id.setRiskRole(riskRole);
			id.setRiskRoleSex(riskRoleSex);
			id.setRiskRoleNo(riskRoleNo);
			PDLMRiskRole RiskRole = pdlmRiskRoleService.findRiskRole(id);
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			for(PDBaseField field: roleFields){
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
				temp.put("fieldValueName", "pdlmRiskRole."+field.getId().getFieldCode());
				//属性值-->对应到文本框中的value属性
				temp.put("fieldValue", RiskRole.getFieldValue(field.getId().getFieldCode()));
				//描述
				temp.put("officialDesc", field.getOfficialDesc());
				//备注
				temp.put("busiDesc", field.getBusiDesc());
				list.add(temp);
			}
			
			String[] factorArray = new String[]{"displayOrder","fieldName","fieldCode","fieldType","fieldValueName","fieldValue","officialDesc","busiDesc"};
		//	this.writeJSONData(list, factorArray);
            return Replys.with(list).as(Json.class).includes(factorArray);
		}else{
			String tableCode = "PD_LMRiskRole";
			//获得相关属性
			List<PDBaseField> roleFields = pdBaseFieldService.findField(tableCode);
			
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			for(PDBaseField field: roleFields){
				Map<String,Object> temp = new HashMap<String, Object>();
				//序号
				temp.put("displayOrder", field.getDisplayOrder());
				//属性代码
				temp.put("fieldCode", field.getId().getFieldCode());
				//属性名称
				temp.put("fieldName", field.getFieldName());
				//属性数据类型
				temp.put("fieldType", field.getFieldType());	
				//属性值-->对应到一个文本框中的name属性
				temp.put("fieldValueName", "pdlmRiskRole."+field.getId().getFieldCode());
				//属性值-->对应到文本框中的value属性
				temp.put("fieldValue", "");
				//描述
				temp.put("officialDesc", field.getOfficialDesc());
				//备注
				temp.put("busiDesc", field.getBusiDesc());
				list.add(temp);
			}
			String[] factorArray = new String[]{"displayOrder","fieldName","fieldCode","fieldType","fieldValueName","fieldValue","officialDesc","busiDesc"};
//			this.writeJSONData(list, factorArray);
            return Replys.with(list).as(Json.class).includes(factorArray);
		}
	}
	/**
	 * @title saveRiskRole
	 * @description 保存险种角色数据
	 * @author 党泽
	 * @return
	 */
	public Reply saveRiskRole(@Param("pdlmRiskRole")PDLMRiskRole pdlmRiskRole){
		pdlmRiskRole = pdlmRiskRoleService.saveRiskRole(pdlmRiskRole);
		//this.writeJSONData(list, args);
		return Replys.simple().success();
	}
	/**
	 * @title deletRiskRole
	 * @description 删除险种角色数据
	 * @author 党泽
	 * @return
	 */
	public Reply deleteRiskRole(@Param("riskRoleUnion")String riskRoleUnion,
                                 @Param("riskCode")String riskCode,@Param("riskRole")String riskRole,
                                 @Param("riskRoleSex")String riskRoleSex,
                                 @Param("riskRoleNo")String riskRoleNo){
		String msg="";
		if(!"".equals(riskRoleUnion)){
			String [] unionCode=riskRoleUnion.split(",");
			riskCode=unionCode[0];
			riskRole=unionCode[1];
			riskRoleSex=unionCode[2];
			riskRoleNo=unionCode[3];
			PDLMRiskRoleId id=new PDLMRiskRoleId();
			id.setRiskCode(riskCode);
			id.setRiskRole(riskRole);
			id.setRiskRoleSex(riskRoleSex);
			id.setRiskRoleNo(riskRoleNo);
			msg = pdlmRiskRoleService.deleteRiskRole(id);
		}else{
			msg="险种编码、险种角色、性别和序号不能为空!";
		}
//		this.writeJSONMsg(msg);
		return Replys.with(msg).as(Json.class);
	}
	/**
	 * @title updateRiskRole
	 * @description 更新险种角色数据
	 * @author 党泽
	 * @return
	 */
	public Reply updateRiskRole(@Param("pdlmRiskRole")PDLMRiskRole pdlmRiskRole){
		pdlmRiskRole = pdlmRiskRoleService.updateRiskRole(pdlmRiskRole);
		return Replys.simple().success();
	}

    @Autowired
	public void setPdlmRiskRoleService(PDLMRiskRoleService pdlmRiskRoleService) {
		this.pdlmRiskRoleService = pdlmRiskRoleService;
	}

    @Autowired
	public void setPdBaseFieldService(PDBaseFieldService pdBaseFieldService) {
		this.pdBaseFieldService = pdBaseFieldService;
	}
	
}
