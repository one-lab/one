package ins.product.web;

import ins.framework.web.Struts2Action;
import ins.product.model.PDBaseField;
import ins.product.model.PDLMDutyPay;
import ins.product.service.facade.PDBaseFieldService;
import ins.product.service.facade.PDLMDutyPayService;

import java.util.List;

public class PDLMDutyPayAction extends Struts2Action {
	private static final long serialVersionUID = 1L;
	
	private String riskCode;
	private PDBaseFieldService pdBaseFieldService;
	private PDLMDutyPay pdLmDutyPay;
	private PDLMDutyPayService pdLmDutyPayService;
	private String payPlanCode;
	
	public String getPayPlanCode() {
		return payPlanCode;
	}
	public void setPayPlanCode(String payPlanCode) {
		this.payPlanCode = payPlanCode;
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public PDBaseFieldService getPdBaseFieldService() {
		return pdBaseFieldService;
	}
	public void setPdBaseFieldService(PDBaseFieldService pdBaseFieldService) {
		this.pdBaseFieldService = pdBaseFieldService;
	}
	public PDLMDutyPay getPdLmDutyPay() {
		return pdLmDutyPay;
	}
	public void setPdLmDutyPay(PDLMDutyPay pdLmDutyPay) {
		this.pdLmDutyPay = pdLmDutyPay;
	}
	public PDLMDutyPayService getPdLmDutyPayService() {
		return pdLmDutyPayService;
	}
	public void setPdLmDutyPayService(PDLMDutyPayService pdLmDutyPayService) {
		this.pdLmDutyPayService = pdLmDutyPayService;
	}
	/**
	 * 查询缴费字段
	 * @return
	 */
	public String findDutyPayField(){
		String tableCode = "PD_LMDutyPay";
		List<PDBaseField> dutyPayFields = pdBaseFieldService.findField(tableCode);
		super.getRequest().setAttribute("dutyPayFields", dutyPayFields);
		super.getRequest().setAttribute("dutyPayFlag", "false");
		return SUCCESS;
	}
	/**
	 * 保存缴费记录
	 * @return
	 */
	public String saveRiskDutyPay(){
		pdLmDutyPay = pdLmDutyPayService.saveRiskDutyPay(pdLmDutyPay);
		return NONE;
	}
	/**
	 * @title deleteRiskDutyPay
	 * @description 删除一条缴费责任定义
	 * @author 朱超
	 * @return
	 */
	public String deleteRiskDutyPay(){
		String flag = pdLmDutyPayService.deleteRiskDutyPay(payPlanCode);
		renderText(flag);
		return NONE;
	}
	
	public String  updateRiskDutyPay(){
		pdLmDutyPay = pdLmDutyPayService.updateRiskDutyPay(pdLmDutyPay);
		renderText("");
		return NONE;
	}
}
