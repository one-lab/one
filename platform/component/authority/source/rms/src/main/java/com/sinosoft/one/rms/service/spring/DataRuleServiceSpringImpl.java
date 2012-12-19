package com.sinosoft.one.rms.service.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	
	public void addBusPowerExcDataRule(String userCode,String comCode, List<String> taskIDs,
			String dataRuleParam,String dataRuleParamName) {
		QueryRule queryRule=QueryRule.getInstance();
		queryRule.addEqual("userCode", userCode);
		queryRule.addEqual("comCode", comCode);
		UserPower userPower=super.findUnique(UserPower.class, queryRule);
		Assert.assertNotNull(userPower);
		StringBuffer sql=new StringBuffer();
		sql.append("delete ge_rms_busPower where  userPowerid='"+ userPower.getUserPowerID() + "'");
		getSession().createSQLQuery(sql.toString()).executeUpdate();
		sql.setLength(0);
		if(taskIDs.size()>0){
			sql.append("from Task where taskId in(");
			for (String string : taskIDs) {
				sql.append(" '" + string + "',");
			}
			sql.delete(sql.length() - 1, sql.length());
			sql.append(")");
			List<Task> tasks = super.findByHql(sql.toString());
			Assert.assertNotNull(tasks);
			for (Task task : tasks) {
				BusPower busPower = new BusPower();
			
				busPower.setUserPower(userPower);
				busPower.setTask(task);
				busPower.setDataRuleParamName(dataRuleParamName);
				busPower.setDataRule(super.get(DataRule.class, "YJX"));
				if (StringUtils.isNotEmpty(dataRuleParam)) {
					busPower.setDataRuleParam(dataRuleParam);
				}
				busPower.setIsValidate("1");
				super.save(busPower);
			}
		}
		baseDataRuleTableInfoManager.clearCache("UserBusPowers");
		
	}
	
	public void addBusPower( String powerID,String dataRuleID, List<String> taskIDs,
			String dataRuleParam ) {
		
		UserPower userPower=super.get(UserPower.class, powerID);
		Assert.assertNotNull(userPower);
		StringBuffer sql=new StringBuffer();
		sql.append("delete ge_rms_busPower where dataRuleid='"+dataRuleID + "' and userPowerid='"+ userPower.getUserPowerID() + "'");
		getSession().createSQLQuery(sql.toString()).executeUpdate();
		sql.setLength(0);
		if(taskIDs.size()>0){
			sql.append("from Task where taskId in(");
			for (String string : taskIDs) {
				sql.append(" '" + string + "',");
			}
			sql.delete(sql.length() - 1, sql.length());
			sql.append(")");
			List<Task> tasks = super.findByHql(sql.toString());
			Assert.assertNotNull(tasks);
			DataRule dataRule = super.get(DataRule.class, dataRuleID);
			Assert.assertNotNull(dataRule);
			for (Task task : tasks) {
				BusPower busPower = new BusPower();
				busPower.setUserPower(userPower);
				busPower.setDataRule(dataRule);
				busPower.setTask(task);
				if (StringUtils.isNotEmpty(dataRuleParam)) {
					busPower.setDataRuleParam(dataRuleParam);
				}
				busPower.setIsValidate("1");
				super.save(busPower);
			}
		}
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

	public List<BusPower> findBusPowerByUserAndCom(String userCode, String comCode) {
		List<BusPower>userbusPowers=new ArrayList<BusPower>();
		StringBuilder hql = new StringBuilder();
		hql.append("from BusPower b where b.userPower.userPowerID =(select userPowerID from UserPower where userCode='"+userCode+"' and comCode='"+comCode+"')");
		List<BusPower> busPowers=super.findByHql(hql.toString());
		hql.setLength(0);
		hql.append("select dataruleid from ge_rms_dataRule");
		List<String>dataruleids=super.findBySql(hql.toString());
		Map<String,BusPower> temp=new HashMap<String,BusPower>();
		for (BusPower BusPower : busPowers) {
			if(dataruleids.contains(BusPower.getDataRule().getDataRuleID().toString())){
				temp.put(BusPower.getDataRule().getDataRuleID().toString(), BusPower);
			}
		}
		userbusPowers.addAll(temp.values());
		return userbusPowers;
	}




}
