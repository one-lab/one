package com.sinosoft.ebusiness.rms.service.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import ins.framework.cache.CacheManager;
import ins.framework.cache.CacheService;
import ins.framework.dao.GenericDaoHibernate;
import ins.framework.utils.StringUtils;

import com.sinosoft.ebusiness.rms.model.BusPower;
import com.sinosoft.ebusiness.rms.model.DataRule;
import com.sinosoft.ebusiness.rms.model.Task;
import com.sinosoft.ebusiness.rms.model.UserPower;
import com.sinosoft.ebusiness.rms.service.facade.DataRuleService;
@Transactional
public class DataRuleServiceSpringImpl extends GenericDaoHibernate<BusPower, String> implements DataRuleService{
	
	private static CacheService cacheManager = CacheManager.getInstance("Role");
	public void addBusPower( String powerID,String dataRuleID, String taskID,
			String dataRuleParam) {
		BusPower busPower=new BusPower();
		UserPower userPower=super.get(UserPower.class, powerID);
		StringBuffer deletesql=new StringBuffer();
		for (BusPower busP : userPower.getBusPowers()) {
			if(busP.getTask().getTaskID().toString().equals(taskID)){
				deletesql.append("delete ge_rms_busPower where buspowerid='"+busP.getBusPowerID()+"'");
				getSession().createSQLQuery(deletesql.toString())
				.executeUpdate();
			}
		}
		busPower.setUserPower(userPower);
		DataRule dataRule=super.get(DataRule.class, dataRuleID);
		busPower.setDataRule(dataRule);
		Task task=super.get(Task.class, taskID);
		busPower.setTask(task);
		if(StringUtils.isNotEmpty(dataRuleParam)){
			busPower.setDataRuleParam(dataRuleParam);
		}
		busPower.setIsValidate("1");
		super.save(busPower);
		cacheManager.clearCache("UserBusPowers");
	}

	public void deleteBusPowerByID(String busPowerID) {
		super.deleteByPK(busPowerID);
		cacheManager.clearCache("UserBusPowers");
	}

	@SuppressWarnings("unchecked")
	public List<DataRule> findAllDataRule() {
		String key = cacheManager.generateCacheKey("AllDataRule", "dataRule");
		Object result = cacheManager.getCache(key);
		if (result != null) {
			return (List<DataRule>) result;
		}
		List<DataRule> dataRules=new ArrayList<DataRule>();
		dataRules=super.getAll(DataRule.class);
		cacheManager.putCache(key, dataRules);
		return dataRules;
	}

	@SuppressWarnings("unchecked")
	public List<BusPower> findBusPowerByTaskID(String userCode,String taskId) {
		List<BusPower>busPowers=new ArrayList<BusPower>();
		StringBuilder hql = new StringBuilder();
		hql.append("from BusPower b where b.userPower.userPowerID =(select userPowerID from UserPower where userCode='"+userCode+"')");
		hql.append(" and b.task.taskID='"+taskId+"'");
		busPowers=super.findByHql(hql.toString());
		return busPowers;
	}

	@SuppressWarnings("unchecked")
	public List<BusPower> findBusPowerByUserCode(String userCode) {
		String key = cacheManager.generateCacheKey("UserBusPowers", userCode);
		Object result = cacheManager.getCache(key);
		if (result != null) {
			return (List<BusPower>) result;
		}
		List<BusPower>busPowers=new ArrayList<BusPower>();
		StringBuilder hql = new StringBuilder();
		hql.append("from BusPower b where b.userPower.userPowerID in(select userPowerID from UserPower where userCode='"+userCode+"')");
		busPowers=super.findByHql(hql.toString());
		cacheManager.putCache(key, busPowers);
		return busPowers;
	}

}
