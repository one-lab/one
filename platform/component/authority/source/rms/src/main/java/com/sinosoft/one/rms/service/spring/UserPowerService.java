package com.sinosoft.one.rms.service.spring;

import ins.framework.cache.CacheManager;
import ins.framework.cache.CacheService;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sinosoft.one.rms.model.ExcPower;
import com.sinosoft.one.rms.model.Group;
import com.sinosoft.one.rms.model.Task;
import com.sinosoft.one.rms.model.UserGroup;
import com.sinosoft.one.rms.model.UserPower;

@Component
class UserPowerService<T, E> extends GenericDaoHibernate<UserPower, String>{
	private static CacheService cacheManager = CacheManager.getInstance("Group");
	 /**
     * 根据员工代码机构代码用户组代码配置权限 userPower 同时配置除外功能
     * @param userCode
     * @param comCode
     * @param groupIDList
     * @param taskIDs
     */
	void addUserPower(String userCode, String comCode, List<String > groupIDs,List<String> excTaskIDs) {
		UserPower userPowe = findUserPowerByComUser(userCode, comCode);
		if (userPowe == null)
			userPowe = new UserPower();
		userPowe.setUserCode(userCode);
		userPowe.setComCode(comCode);
		userPowe.setIsValidate("1");
		super.deleteAll(userPowe.getExcPowers());
		List<Task> tasks = new ArrayList<Task>();
		for (String taskid : excTaskIDs) {
			Task task = new Task();
			task.setTaskID(taskid);
			tasks.add(task);
		}
		List<ExcPower>excPowers= new ArrayList<ExcPower>();
		for (Task task : tasks) {
			ExcPower excPower = new ExcPower();
			excPower.setTask(task);
			excPower.setUserPower(userPowe);
			excPower.setIsValidate("1");
			excPowers.add(excPower);
			//如果不ID不为空 则为修改 需要更新数据规则表
			if(userPowe.equals(null)){
				StringBuffer sql=new StringBuffer();
				sql.append("delete ge_rms_buspower t where t.userpowerid='"+userPowe.getUserPowerID()+"' and t.taskid='"+task.getTaskID()+"' ");
				getSession().createSQLQuery(sql.toString()).executeUpdate();
			}
		}
		userPowe.setExcPowers(excPowers);
		super.deleteAll(userPowe.getUserGroups());
		List<UserGroup> userGroups=new ArrayList<UserGroup>();
		for (String groupid : groupIDs) {
			UserGroup userGroup=new UserGroup();
			Group group=new Group(); 
			group.setGroupID(groupid);
			userGroup.setGroup(group);
			userGroup.setUserPower(userPowe);
			userGroup.setIsValidate("1");
			userGroup.setUserCode(userCode);
			userGroups.add(userGroup);
		}
		userPowe.setUserGroups(userGroups);
		super.save(userPowe);
		cacheManager.clearCache("Groups");
	}
	
	
	/**
	 * 删除用户权限
	 * @param userCode
	 * @param comCode
	 */
	void delete(String userCode,String comCode){
		UserPower userPowe = findUserPowerByComUser(userCode, comCode);
		super.delete(userPowe);
	}
	
	/**
	 * 根据用户代码机构代码查询权限
	 * @param userCode
	 * @param comCode
	 * @return
	 */
	UserPower findUserPowerByComUser(String userCode,String comCode){
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("userCode", userCode);
		queryRule.addEqual("comCode", comCode);
		queryRule.addEqual("isValidate", "1");
		return super.findUnique(UserPower.class, queryRule);
	}

}
