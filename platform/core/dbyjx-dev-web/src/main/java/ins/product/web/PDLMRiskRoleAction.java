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
import ins.product.model.PDLMCheckFieldId;
import ins.product.model.PDLMRiskRole;
import ins.product.model.PDLMRiskRoleId;
import ins.product.service.facade.PDBaseFieldService;
import ins.product.service.facade.PDLMRiskRoleService;

public class PDLMRiskRoleAction extends Struts2Action {
	private static final long serialVersionUID = 1L;
	
	private PDLMRiskRole pdlmRiskRole;
	private PDLMRiskRoleService pdlmRiskRoleService;
	private String riskCode;
	private String riskRole;
	private String riskRoleSex;
	private String riskRoleNo;
	private String riskRoleUnion;
	private PDBaseFieldService pdBaseFieldService;
	private Page page;
	/**
	 * @title findRiskRoleByRisk
	 * @description 通过险种代码查询险种角色数据
	 * @author 党泽
	 * @return
	 */
	public String findRiskRoleByRisk() {
		if(this.pageNo == 0){
			this.pageNo = 1;
		}
		if(this.pageSize == 0){
			this.pageSize = FinalCollection.PAGE_SIZE;
		}
		QueryRule findRiskRule = QueryRule.getInstance();
        /** 参数以对象的方式传入，对应变量进行赋值*/
		
		if(null != riskCode && !"".equals(riskCode.trim())){
			findRiskRule.addEqual("id.riskCode", riskCode.trim());
		}
		this.page = pdlmRiskRoleService.findRiskByCondition(findRiskRule,pageNo,pageSize);
		String[] RoleArray = new String[]{"id.riskCode","riskVer","id.riskRole","id.riskRoleSex","id.riskRoleNo","minAppAgeFlag","minAppAge","maxAppAgeFlag","maxAppAge"};
		this.writeJSONData(page.getResult(), RoleArray);
		return NONE;
	}
	/**
	 * @title findRiskRoleByRisk
	 * @description 通过险种角色主键查询险种角色数据
	 * @author 党泽
	 * @return
	 */
	public String findRiskRole(){
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
			this.writeJSONData(list, factorArray);
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
			this.writeJSONData(list, factorArray);
		}
		
		return NONE;
		
	}
	/**
	 * @title saveRiskRole
	 * @description 保存险种角色数据
	 * @author 党泽
	 * @return
	 */
	public String saveRiskRole(){
		pdlmRiskRole = pdlmRiskRoleService.saveRiskRole(pdlmRiskRole);
		//this.writeJSONData(list, args);
		return NONE;
	}
	/**
	 * @title deletRiskRole
	 * @description 删除险种角色数据
	 * @author 党泽
	 * @return
	 */
	public String deleteRiskRole(){
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
		this.writeJSONMsg(msg);
		return NONE;
	}
	/**
	 * @title updateRiskRole
	 * @description 更新险种角色数据
	 * @author 党泽
	 * @return
	 */
	public String updateRiskRole(){
		pdlmRiskRole = pdlmRiskRoleService.updateRiskRole(pdlmRiskRole);
		return NONE;
	}
	public PDLMRiskRole getPdlmRiskRole() {
		return pdlmRiskRole;
	}
	public void setPdlmRiskRole(PDLMRiskRole pdlmRiskRole) {
		this.pdlmRiskRole = pdlmRiskRole;
	}
	public PDLMRiskRoleService getPdlmRiskRoleService() {
		return pdlmRiskRoleService;
	}
	public void setPdlmRiskRoleService(PDLMRiskRoleService pdlmRiskRoleService) {
		this.pdlmRiskRoleService = pdlmRiskRoleService;
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getRiskRole() {
		return riskRole;
	}
	public void setRiskRole(String riskRole) {
		this.riskRole = riskRole;
	}
	public String getRiskRoleSex() {
		return riskRoleSex;
	}
	public void setRiskRoleSex(String riskRoleSex) {
		this.riskRoleSex = riskRoleSex;
	}
	public String getRiskRoleNo() {
		return riskRoleNo;
	}
	public void setRiskRoleNo(String riskRoleNo) {
		this.riskRoleNo = riskRoleNo;
	}
	public String getRiskRoleUnion() {
		return riskRoleUnion;
	}
	public void setRiskRoleUnion(String riskRoleUnion) {
		this.riskRoleUnion = riskRoleUnion;
	}
	public PDBaseFieldService getPdBaseFieldService() {
		return pdBaseFieldService;
	}
	public void setPdBaseFieldService(PDBaseFieldService pdBaseFieldService) {
		this.pdBaseFieldService = pdBaseFieldService;
	}
	
}
