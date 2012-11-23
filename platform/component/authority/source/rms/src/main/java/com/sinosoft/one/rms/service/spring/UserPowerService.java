package com.sinosoft.one.rms.service.spring;

import ins.framework.cache.CacheManager;
import ins.framework.cache.CacheService;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.framework.utils.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.sinosoft.one.rms.model.ExcPower;
import com.sinosoft.one.rms.model.Group;
import com.sinosoft.one.rms.model.Task;
import com.sinosoft.one.rms.model.UserGroup;
import com.sinosoft.one.rms.model.UserPower;
import com.sinosoft.one.rms.service.facade.TaskService;

@Component
class UserPowerService<T, E> extends GenericDaoHibernate<UserPower, String>{

	private TaskService rmstaskService;
	
	private static CacheService cacheManager = CacheManager.getInstance("Group");
	 /**
     * 根据员工代码机构代码用户组代码配置权限 userPower 同时配置除外功能
     * @param userCode
     * @param comCode
     * @param groupIDList
     * @param taskIDs
     */
	
	void addUserPower(String userCode, String comCode, List<String > groupIDs,List<String> roleIDs,List<String> excTaskIDs,String sysFlag) {
		UserPower userPowe = findUserPowerByComUser(userCode, comCode);
		if (userPowe == null)
			userPowe = new UserPower();
		userPowe.setUserCode(userCode);
		userPowe.setComCode(comCode);
		userPowe.setIsValidate("1");
		super.deleteAll(userPowe.getExcPowers());
		if(roleIDs.size()>0){
			List<String> rolesTasks;
			rolesTasks=findTaskByRoleAndsysFlag(roleIDs, comCode, sysFlag);
			excTaskIDs.addAll(rolesTasks);
		}
		
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
//		super.deleteAll(userPowe.getUserGroups());
		List<String>userGroupIDs=new ArrayList<String>();
		for (UserGroup userGroup : userPowe.getUserGroups()) {
			userGroupIDs.add(userGroup.getUserGropuID());
		}
		
		if(userGroupIDs.size()>0){
			StringBuffer sql=new StringBuffer();
			sql.append("delete ge_rms_usergroup t where t.USERGROPUID in(");
			for (String userGroupID : userGroupIDs) {
				sql.append("'"+userGroupID+"',");
				
			}
			sql.delete(sql.length() - 1, sql.length());
			sql.append(")");
			getSession().createSQLQuery(sql.toString()).executeUpdate();
		}
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
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("userCode", userCode);
		queryRule.addEqual("comCode", comCode);
		queryRule.addEqual("isValidate", "1");
		UserPower userPowe= super.findUnique(UserPower.class, queryRule);
		StringBuffer sql=new StringBuffer();
		sql.append("delete ge_rms_usergroup t where t.userpowerid='"+userPowe.getUserPowerID()+"' ");
		getSession().createSQLQuery(sql.toString()).executeUpdate();
		sql.setLength(0);
		sql.append("delete ge_rms_buspower t where t.userpowerid='"+userPowe.getUserPowerID()+"' ");
		getSession().createSQLQuery(sql.toString()).executeUpdate();
		sql.setLength(0);
		sql.append("delete ge_rms_userpower t where t.comCode='"+comCode+"' and t.usercode='"+userCode+"' ");
		getSession().createSQLQuery(sql.toString()).executeUpdate();
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


	 List<String> findTaskByRoleAndsysFlag(List<String> roleIDs,String comCode,String sysFlag) {
		StringBuffer taskIDSQL = new StringBuffer();
		taskIDSQL
				.append(" select taskid from ge_rms_task_auth where taskauthid in (");
		taskIDSQL
				.append(" select taskauthid from ge_rms_roletask g where g.isvalidate='1' and g.roleid in (");
		for (String string : roleIDs) {
			taskIDSQL.append(" '" + string + "',");
		}
		taskIDSQL.delete(taskIDSQL.length() - 1, taskIDSQL.length());
		taskIDSQL.append("))");
		List<String> taskIDs = new ArrayList<String>();
		taskIDs = (List<String>) getSession().createSQLQuery(
				taskIDSQL.toString()).list();
		taskIDSQL.setLength(0);
		// 获取该机构的功能ID
		taskIDSQL.append("select taskid from ge_rms_task_auth where comcode='"
				+ comCode + "' or comcode='*'");
		List<String> comtaskIDs = new ArrayList<String>();
		comtaskIDs = (List<String>) getSession().createSQLQuery(
				taskIDSQL.toString()).list();
		List<String> resultTaskIDs = new ArrayList<String>();
		// 两功能ID集合去重
		for (String com_TaskID : comtaskIDs) {
			for (String role_TaskID : taskIDs) {
				if (com_TaskID.toString().equals(role_TaskID.toString())) {
					resultTaskIDs.add(com_TaskID);
					break;
				}
			}
		}
		return resultTaskIDs;
	 }
	 
	 List<UserPower> findUserPowersByUserCode(String userCode) {
		 QueryRule queryRule = QueryRule.getInstance();
		 queryRule.addEqual("userCode", userCode);
		 return super.find(UserPower.class, queryRule);
	 }
	 
}
