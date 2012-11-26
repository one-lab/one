package ins.product.web;

import ins.framework.web.Struts2Action;
import ins.product.model.PDLMRiskDutyFactor;
import ins.product.service.facade.PDLMDutyParamsService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

public class PDLMDutyParamsAction extends Struts2Action{

	private static final long serialVersionUID = 1L;
	private String dutyCode;
	private PDLMDutyParamsService pdLmDutyParamsService;
	public PDLMDutyParamsService getPdLmDutyParamsService() {
		return pdLmDutyParamsService;
	}
	public void setPdLmDutyParamsService(PDLMDutyParamsService pdLmDutyParamsService) {
		this.pdLmDutyParamsService = pdLmDutyParamsService;
	}
	public String getDutyCode() {
		return dutyCode;
	}
	public void setDutyCode(String dutyCode) {
		this.dutyCode = dutyCode;
	}
	public String findDutyParams(){
		List<PDLMRiskDutyFactor> pdLmRiskDutyFactorList = pdLmDutyParamsService.findDutyParams(dutyCode);
		writeJSONData(pdLmRiskDutyFactorList, new String[]{"factorName","factorNoti","id.calFactor"});
		return NONE;
	}
}
