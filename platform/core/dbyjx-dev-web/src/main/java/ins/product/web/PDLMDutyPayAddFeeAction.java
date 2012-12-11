package ins.product.web;

import ins.framework.web.Struts2Action;
import ins.product.model.PDBaseField;
import ins.product.model.PDLMDutyPayAddFee;
import ins.product.model.PDLMDutyPayAddFeeId;
import ins.product.service.facade.PDBaseFieldService;
import ins.product.service.facade.PDLMDutyPayAddFeeService;

import java.util.ArrayList;
import java.util.List;

public class PDLMDutyPayAddFeeAction extends Struts2Action {
	private static final long serialVersionUID = 1L;
	
	private PDLMDutyPayAddFee pdlmDutyPayAddFee;
	private PDLMDutyPayAddFeeService pdlmDutyPayAddFeeService; 
	private PDBaseFieldService pdBaseFieldService;
	private PDLMDutyPayAddFeeId id;
	
	
	public PDLMDutyPayAddFeeId getId() {
		return id;
	}
	public void setId(PDLMDutyPayAddFeeId id) {
		this.id = id;
	}
	public PDBaseFieldService getPdBaseFieldService() {
		return pdBaseFieldService;
	}
	public void setPdBaseFieldService(PDBaseFieldService pdBaseFieldService) {
		this.pdBaseFieldService = pdBaseFieldService;
	}
	public PDLMDutyPayAddFee getPdlmDutyPayAddFee() {
		return pdlmDutyPayAddFee;
	}
	public void setPdlmDutyPayAddFee(PDLMDutyPayAddFee pdlmDutyPayAddFee) {
		this.pdlmDutyPayAddFee = pdlmDutyPayAddFee;
	}
	public PDLMDutyPayAddFeeService getPdlmDutyPayAddFeeService() {
		return pdlmDutyPayAddFeeService;
	}
	public void setPdlmDutyPayAddFeeService(
			PDLMDutyPayAddFeeService pdlmDutyPayAddFeeService) {
		this.pdlmDutyPayAddFeeService = pdlmDutyPayAddFeeService;
	}
	
	/**
	 * @title saveDutyPayAddFee
	 * @description 保存一条加费记录
	 * @author 朱超
	 * @return
	 */
	public String saveDutyPayAddFee(){
		pdlmDutyPayAddFee = pdlmDutyPayAddFeeService.saveDutyPayAddFee(pdlmDutyPayAddFee);
		List<PDLMDutyPayAddFee> pdlmDutyPayAddFees = new ArrayList<PDLMDutyPayAddFee>();
		pdlmDutyPayAddFees.add(pdlmDutyPayAddFee);
		String[] show = new String[]{"id.riskCode","id.dutyCode","id.addFeeType","id.addFeeObject","addFeeCalCode","addPointLimit"};
		this.writeJSONData(pdlmDutyPayAddFees, show);
		return NONE;
	}
	
	/**
	 * @title updateDutyPayAddFee
	 * @description 更新一条加费记录
	 * @author 朱超
	 * @return
	 */
	public String updateDutyPayAddFee(){
		pdlmDutyPayAddFee = pdlmDutyPayAddFeeService.updateDutyPayAddFee(pdlmDutyPayAddFee);
		List<PDLMDutyPayAddFee> pdlmDutyPayAddFees = new ArrayList<PDLMDutyPayAddFee>();
		pdlmDutyPayAddFees.add(pdlmDutyPayAddFee);
		String[] show = new String[]{"id.riskCode","id.dutyCode","id.addFeeType","id.addFeeObject","addFeeCalCode","addPointLimit"};
		this.writeJSONData(pdlmDutyPayAddFees, show);
		return NONE;
	}
	
	/**
	 * @title deleteDutyPayAddFee
	 * @description 删除一条加费记录
	 * @author 朱超
	 * @return
	 */
	public String deleteDutyPayAddFee(){
		String flag = pdlmDutyPayAddFeeService.deleteDutyPayAddFee(pdlmDutyPayAddFee);
		this.renderText(flag);
		return NONE;
	}
	
	/**
	 * @title findRiskDutyAddFeeField
	 * @description 查询pd_lmdutypayaddfee表的字段
	 * @author 朱超
	 * @return
	 */
	public String findRiskDutyAddFeeField(){
		String tableCode = "PD_LMDutyPayAddFee";
		List<PDBaseField> fields = pdBaseFieldService.findField(tableCode);
		String[] fieldsArr = new String[]{"id.fieldCode","fieldName","fieldType","officialDesc","busiDesc","displayOrder"}; 
		this.writeJSONData(fields, fieldsArr);
		
		return NONE;
	}
	
	public String findByPK(){
		PDLMDutyPayAddFee resultDutyPayAddFee = pdlmDutyPayAddFeeService.findByPK(id);
		List<PDLMDutyPayAddFee> list = new ArrayList<PDLMDutyPayAddFee>();
		this.writeJSONData(list, null);
		return NONE;
	}
}
