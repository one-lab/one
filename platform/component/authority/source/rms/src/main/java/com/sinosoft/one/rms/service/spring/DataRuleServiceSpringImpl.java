package com.sinosoft.one.rms.service.spring;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.springframework.transaction.annotation.Transactional;


import ins.framework.cache.CacheManager;
import ins.framework.cache.CacheService;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.framework.utils.StringUtils;

import com.sinosoft.one.rms.model.BusPower;
import com.sinosoft.one.rms.model.DataRule;
import com.sinosoft.one.rms.model.Task;
import com.sinosoft.one.rms.model.UserPower;
import com.sinosoft.one.rms.service.facade.DataRuleService;
@Transactional
public class DataRuleServiceSpringImpl extends GenericDaoHibernate<BusPower, String> implements DataRuleService{
	
	
	private static CacheService baseDataRuleTableInfoManager = CacheManager.getInstance("baseDataRuleTableInfo");
	
	
	public void addBusPower( String powerID,String dataRuleID, String taskID,
			String dataRuleParam ) {
		BusPower busPower=new BusPower();
		UserPower userPower=super.get(UserPower.class, powerID);
		Assert.assertNotNull(userPower);
		StringBuffer deletesql=new StringBuffer();
		deletesql.append("delete ge_rms_busPower where dataRuleid='"+dataRuleID + "' and userPowerid='"+ userPower.getUserPowerID() + "' and taskid='"+taskID+"'");
		getSession().createSQLQuery(deletesql.toString()).executeUpdate();
		deletesql.setLength(0);
		busPower.setUserPower(userPower);
		DataRule dataRule=super.get(DataRule.class, dataRuleID);
		Assert.assertNotNull(dataRule);
		busPower.setDataRule(dataRule);
		Task task=super.get(Task.class, taskID);
		busPower.setTask(task);
		if(StringUtils.isNotEmpty(dataRuleParam)){
			busPower.setDataRuleParam(dataRuleParam);
		}
		busPower.setIsValidate("1");
		super.save(busPower);
		baseDataRuleTableInfoManager.clearCache("UserBusPowers");
	}
	
	public void addBusPower( String powerID,String dataRuleID, String taskID,
			String dataRuleParam ,String busDataTable,String busDataColumn) {
		BusPower busPower=new BusPower();
		UserPower userPower=super.get(UserPower.class, powerID);
		Assert.assertNotNull(userPower);
		StringBuffer deletesql=new StringBuffer();
		deletesql.append("delete ge_rms_busPower where dataRuleid='"+dataRuleID + "' and userPowerid='"+ userPower.getUserPowerID() + "' and taskid='"+taskID+"'");
		getSession().createSQLQuery(deletesql.toString()).executeUpdate();
		deletesql.setLength(0);
		busPower.setUserPower(userPower);
		DataRule dataRule=super.get(DataRule.class, dataRuleID);
		Assert.assertNotNull(dataRule);
		busPower.setDataRule(dataRule);
		Task task=super.get(Task.class, taskID);
		busPower.setTask(task);
		if(StringUtils.isNotEmpty(dataRuleParam)){
			busPower.setDataRuleParam(dataRuleParam);
		}
		busPower.setIsValidate("1");
		super.save(busPower);
		baseDataRuleTableInfoManager.clearCache("UserBusPowers");
	}

	public void deleteBusPowerByID(String busPowerID) {
		super.deleteByPK(busPowerID);
		baseDataRuleTableInfoManager.clearCache("UserBusPowers");
	}

	@SuppressWarnings("unchecked")
	public List<DataRule> findAllDataRule() {
		String key = baseDataRuleTableInfoManager.generateCacheKey("AllDataRule", "dataRule");
		Object result = baseDataRuleTableInfoManager.getCache(key);
		if (result != null) {
			return (List<DataRule>) result;
		}
		List<DataRule> dataRules=new ArrayList<DataRule>();
		QueryRule queryRule =QueryRule.getInstance();
		queryRule.addEqual("isValidate", "1");
		dataRules=super.find(DataRule.class, queryRule);
		baseDataRuleTableInfoManager.putCache(key, dataRules);
		return dataRules;
	}

	@SuppressWarnings("unchecked")
	public List<BusPower> findBusPowerByTaskID(String userCode,String comCode,String taskId) {
		List<BusPower>busPowers=new ArrayList<BusPower>();
		StringBuilder hql = new StringBuilder();
		hql.append("from BusPower b where b.userPower.userPowerID =(select userPowerID from UserPower where userCode='"+userCode+"' and comCode='"+comCode+"')");
		hql.append(" and b.task.taskID='"+taskId+"'");
		busPowers=super.findByHql(hql.toString());
		return busPowers;
	}



}
