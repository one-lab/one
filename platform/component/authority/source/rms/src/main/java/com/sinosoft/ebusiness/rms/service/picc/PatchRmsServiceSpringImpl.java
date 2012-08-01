package com.sinosoft.ebusiness.rms.service.picc;

import ins.framework.common.QueryRule;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import com.sinosoft.ebusiness.rms.model.Employe;
import com.sinosoft.ebusiness.rms.model.ExcPower;
import com.sinosoft.ebusiness.rms.model.Group;
import com.sinosoft.ebusiness.rms.model.GroupRole;
import com.sinosoft.ebusiness.rms.model.Role;
import com.sinosoft.ebusiness.rms.model.RoleTask;
import com.sinosoft.ebusiness.rms.model.Task;
import com.sinosoft.ebusiness.rms.model.TaskAuth;
import com.sinosoft.ebusiness.rms.model.UserGroup;
import com.sinosoft.ebusiness.rms.model.UserPower;
import com.sinosoft.ebusiness.rms.service.spring.RmsServiceSpringImpl;

public class PatchRmsServiceSpringImpl extends RmsServiceSpringImpl<Task, String> implements RmsService{
		
	 /**
     * 根据员工代码机构代码用户组代码配置权限 userPower 同时配置除外功能（添加到固定用户组）
     * @param userCode
     * @param comCode
     * @param addType
     * @param taskIDs
     */
	public void addUserPower(String userCode, String comCode, String addType,
			List<String> excTaskIDs) {
		UserPower userPowe = super.findUserPowerByComUser(userCode, comCode);
		if (userPowe == null)
			userPowe = new UserPower();
		userPowe.setUserCode(userCode);
		userPowe.setComCode(comCode);
		userPowe.setIsValidate("1");
		super.deleteAll(userPowe.getExcPowers());
//		StringBuffer strsql=new StringBuffer();
//		strsql.append("delete ge_rms_usergroup where usercode='"+ userCode+"'");
//		getSession().createSQLQuery(strsql.toString()).executeUpdate();
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
		}
		userPowe.setExcPowers(excPowers);
		//查询固定用户组
		QueryRule queryRule=QueryRule.getInstance();
		if(addType.toString().equals("0")){
			queryRule.addEqual("name", "系统管理组");
		}else if (addType.toString().equals("1")) {
			queryRule.addEqual("name", "测试删除用户组");
		}else if (addType.toString().equals("2")) {
			queryRule.addEqual("name", "市公司管理组");
		}else if (addType.toString().equals("3")) {
			queryRule.addEqual("name", "县公司管理组");
		}else if (addType.toString().equals("4")) {
			queryRule.addEqual("name", "团购组");
		}else if (addType.toString().equals("5")) {
			queryRule.addEqual("name", "客服经理组");
		}
		Group group=new Group(); 
		List<UserGroup> userGroups=new ArrayList<UserGroup>();
		group=super.findUnique(Group.class, queryRule);
		super.deleteAll(userPowe.getUserGroups());
		UserGroup userGroup = new UserGroup();
		userGroup.setGroup(group);
		userGroup.setUserPower(userPowe);
		userGroup.setIsValidate("1");
		userGroup.setUserCode(userCode);
		userGroups.add(userGroup);
		userPowe.setUserGroups(userGroups);
		super.save(userPowe);
	}
	
	//无角色指派方式获得权限
	public Set<Task> findTaskByUserCodeNoDesinate(String userCode, String comCode){
		//获得用户权限对象
		UserPower userPower =new UserPower();
		userPower=	super.findUserPowerByComUser(userCode, comCode);
		//获得组用户关联对象集合
		List<UserGroup> userGroups=new ArrayList<UserGroup>();
		userGroups=userPower.getUserGroups();
		//获得用户组
		Group group=new Group();
		for (UserGroup userGroup : userGroups) {
			if(userGroup.getIsValidate().toString().equals("1".toString())){
					group=userGroup.getGroup();
			}
		}
		//获得用户组角色集合
		List<GroupRole>groupRoles =new ArrayList<GroupRole>();
		groupRoles.addAll(group.getGroupRoles());
		//获得角色集合
		List<Role> roles =new ArrayList<Role>();
		for (GroupRole groupRole : groupRoles) {
			if(groupRole.getIsValidate().toString().equals("1")){
				roles.add(groupRole.getRole());
			}
		}
		//获得角色功能
		List<RoleTask>roleTasks=new ArrayList<RoleTask>();
		for (Role role : roles) {
			if(role.getIsValidate().toString().equals("1")){
				roleTasks.addAll(role.getRoleTasks());
			}
		}
		//获得功能授权
		List<TaskAuth>taskAuths=new ArrayList<TaskAuth>();
		for (RoleTask roleTask : roleTasks) {
			if(roleTask.getIsValidate().toString().equals("1")){
				taskAuths.add(roleTask.getTaskAuth());
			}
		}
		//获得权限
		Set<Task> tasks=new HashSet<Task>();
		for (TaskAuth taskAuth : taskAuths) {
			if(taskAuth.getTask().getIsValidate().toString().equals("1")){
				tasks.add(taskAuth.getTask());
			}
		}
		//获得除外权限
		Set<Task> excTasks = new HashSet<Task>();
		for (ExcPower excpower : userPower.getExcPowers()) {
			excTasks.add(excpower.getTask());
		}
		Set<Task> result = new HashSet<Task>();
		//除外权限和获得的权限过滤
		for (Task task : tasks) {
			int i = 0;
			for (Task etask : excTasks) {
				if (task.getTaskID().toString()
						.equals(etask.getTaskID().toString()))
					i = i + 1;
			}
			if (i == 0) {
				result.add(task);
			}
		}
		Set<Task> ts = new HashSet<Task>();
		iterateTask(ts, result);
		return result;
	}
	public void addEmploye(Employe employe){
		super.save(employe);
	}
}
