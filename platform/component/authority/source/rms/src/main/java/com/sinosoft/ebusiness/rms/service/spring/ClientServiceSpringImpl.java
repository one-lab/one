package com.sinosoft.ebusiness.rms.service.spring;

import ins.framework.common.EncryptUtils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

import com.sinosoft.ebusiness.rms.clientService.User;
import com.sinosoft.ebusiness.rms.model.BusPower;
import com.sinosoft.ebusiness.rms.model.Company;
import com.sinosoft.ebusiness.rms.model.Employe;
import com.sinosoft.ebusiness.rms.model.Task;
import com.sinosoft.ebusiness.rms.model.UserPower;
import com.sinosoft.ebusiness.rms.service.facade.DataRuleService;
import com.sinosoft.ebusiness.rms.service.facade.ClientService;
import com.sinosoft.ebusiness.rms.service.facade.RmsService;

public class ClientServiceSpringImpl implements ClientService{

	 private RmsService rmsService;
	 private DataRuleService dataRuleService;
	 
	
	public User getUserByUserCodeComCode(String userCode,String comCode) {
		Employe employe = rmsService.findUserByCode(userCode);
		UserPower userPower=rmsService.findUserPowerByComUser(userCode, comCode);
		Assert.notNull(userPower);
		Company company= rmsService.findCompanyByComCode(comCode);
		Assert.notNull(company);
		List<Task> tasklist=new ArrayList<Task>();
		tasklist=rmsService.findTaskByUserCode(userCode, comCode);
		List<String>taskIdList=new ArrayList<String>();
		for (Task task : tasklist) {
			taskIdList.add(task.getTaskID());
		}
		return new User(employe.getUserCode(),employe.getPassword(),employe.getUserName(),company.getComCode(),company.getComCName(),taskIdList);
	}


	/**
	 * 客户端远程调用 选择机构
	 */
	public List<Company> findCompanysByUserCodeAnyPassword(String userCode, String passWord) {
		List<Company> companies=new ArrayList<Company>();
		Employe employe = rmsService.findUserByCode(userCode);
		if (employe == null&&(!EncryptUtils.md5(employe.getPassword()).toString().equals(passWord))) {
			return companies;
		} else {
			 companies=rmsService.findComByUserCode(userCode);
		}
		return companies;
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
