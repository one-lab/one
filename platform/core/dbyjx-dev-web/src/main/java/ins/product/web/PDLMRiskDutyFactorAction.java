package ins.product.web;

import ins.framework.web.Struts2Action;
import ins.platform.vo.QueryCodeVo;
import ins.product.model.PDLMRiskDutyFactor;
import ins.product.service.facade.PDLMRiskDutyFactorService;
import ins.product.vo.PDLMRiskDutyFactorVo;

import java.util.ArrayList;
import java.util.List;

public class PDLMRiskDutyFactorAction extends Struts2Action {
	private static final long serialVersionUID = 1L;
	private List<PDLMRiskDutyFactor> pdLmRiskDutyFactorList;
	private PDLMRiskDutyFactor pdLMRiskDutyFactor;
	private PDLMRiskDutyFactorService pdLmRiskDutyFactorService;
	private String riskCode;
	private String dutyCode;

	public PDLMRiskDutyFactor getPdLMRiskDutyFactor() {
		return pdLMRiskDutyFactor;
	}
	public void setPdLMRiskDutyFactor(PDLMRiskDutyFactor pdLMRiskDutyFactor) {
		this.pdLMRiskDutyFactor = pdLMRiskDutyFactor;
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getDutyCode() {
		return dutyCode;
	}
	public void setDutyCode(String dutyCode) {
		this.dutyCode = dutyCode;
	}
	public PDLMRiskDutyFactorService getPdLmRiskDutyFactorService() {
		return pdLmRiskDutyFactorService;
	}

	public void setPdLmRiskDutyFactorService(
			PDLMRiskDutyFactorService pdLmRiskDutyFactorService) {
		this.pdLmRiskDutyFactorService = pdLmRiskDutyFactorService;
	}

	public List<PDLMRiskDutyFactor> getPdLmRiskDutyFactorList() {
		return pdLmRiskDutyFactorList;
	}

	public void setPdLmRiskDutyFactorList(
			List<PDLMRiskDutyFactor> pdLmRiskDutyFactorList) {
		this.pdLmRiskDutyFactorList = pdLmRiskDutyFactorList;
	}

	/**
	 * 增加险种责任要素
	 * 
	 * @return
	 */
	public String addRiskDutyFactor() {
		if(null != pdLmRiskDutyFactorList && pdLmRiskDutyFactorList.size() > 0){
			pdLmRiskDutyFactorList = pdLmRiskDutyFactorService.addRiskDutyFactor(pdLmRiskDutyFactorList);			
			this.writeJSONData(pdLmRiskDutyFactorList, new String[] {"factorOrder", "factorName" });
		}else{
			pdLmRiskDutyFactorList = new ArrayList<PDLMRiskDutyFactor>();
			pdLMRiskDutyFactor = pdLmRiskDutyFactorService.addRiskDutyFactor(pdLMRiskDutyFactor);
			pdLmRiskDutyFactorList.add(pdLMRiskDutyFactor);
			this.writeJSONData(pdLmRiskDutyFactorList, new String[] {"factorOrder", "factorName" });
		}
		return NONE;
	}
	/**
	 * 根据险种和责任查询出要素
	 * @return
	 */
	public String findFactorByRiskAndDuty() {
		List<PDLMRiskDutyFactor> resultFactor = pdLmRiskDutyFactorService.findFactorByRiskAndDuty(riskCode, dutyCode);
		String[] factorArray = new String[]{"factorOrder","calFactorType","factorName","id.calFactor","calSQL","factorNoti","standbyflag1","dhtmlType","comFactorCode","comFactorName","id.calFactor"};
		this.writeJSONData(resultFactor, factorArray);
		return NONE;
	}
	/**
	 * 
	 * @title findFactorDistinct
	 * @description 根据险种和责任查询要素，并且使用distinct去重
	 * @author 朱超
	 * @return
	 */
	public String findFactorDistinct(){
		List<QueryCodeVo> list = pdLmRiskDutyFactorService.findFactorDistinct(riskCode, dutyCode);
		return NONE;
	}
}
