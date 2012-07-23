package com.sinosoft.ebusiness.rms.service.webService.spring;

import java.util.ArrayList;
import java.util.List;

import com.sinosoft.ebusiness.rms.model.BusPower;
import com.sinosoft.ebusiness.rms.model.Company;
import com.sinosoft.ebusiness.rms.model.Employe;
import com.sinosoft.ebusiness.rms.model.Task;
import com.sinosoft.ebusiness.rms.service.facade.DataRuleService;
import com.sinosoft.ebusiness.rms.service.facade.RmsService;
import com.sinosoft.ebusiness.rms.service.webService.WebServiceDTO;
import com.sinosoft.ebusiness.rms.service.webService.facade.RMSWebService;

public class RMSWebServiceSpirngImpl implements RMSWebService{

	 private RmsService rmsService;
	 private DataRuleService dataRuleService;
	 
	 
	public List<String> webServiceSelectCom(String userCode, String passWord) {
		List<String> serverMaseege=new ArrayList<String>();
		Employe employe = rmsService.findUserByCode(userCode);
		if (employe == null) {
			serverMaseege.add("用户不存在");
		} else if (!employe.getPassword().toString().equals(passWord)) {
			serverMaseege.add("密码错误");
		}else {
			List<Company> companies=rmsService.findComByUserCode(userCode);
			for (Company company : companies) {
				serverMaseege.add(company.getComCode());
			}
		}
		return serverMaseege;
	}

	public WebServiceDTO webServiceLogin(String userCode, String passWord,String comCode) {
		Employe employe = rmsService.findUserByCode(userCode);
		WebServiceDTO webServiceDTO = new WebServiceDTO();
		if (employe == null) {
			webServiceDTO.setServerMassege("用户不存在");
		} else if (!employe.getPassword().toString().equals(passWord)) {
			webServiceDTO.setServerMassege("密码错误");
		}else {
			webServiceDTO.setEmploye(employe);
			webServiceDTO.setLoginComCode(comCode);
			List<Task> tasks=rmsService.findTaskByUserCode(userCode, comCode);
			webServiceDTO.setTasks(tasks);
			List<BusPower>busPowers= dataRuleService.findBusPowerByUserCode(userCode);
			webServiceDTO.setBusPowers(busPowers);
			webServiceDTO.setServerMassege("获取信息成功.");
		}
		return webServiceDTO;
	}
	 
	public RmsService getRmsService() {
		return rmsService;
	}

	public void setRmsService(RmsService rmsService) {
		this.rmsService = rmsService;
	}

	public DataRuleService getDataRuleService() {
		return dataRuleService;
	}

	public void setDataRuleService(DataRuleService dataRuleService) {
		this.dataRuleService = dataRuleService;
	}
}
