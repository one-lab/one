package com.sinosoft.ebusiness.rms.service.spring.patch;

import ins.framework.common.QueryRule;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sinosoft.ebusiness.rms.model.Group;
import com.sinosoft.ebusiness.rms.model.GroupRole;
import com.sinosoft.ebusiness.rms.model.Role;
import com.sinosoft.ebusiness.rms.model.RoleTask;
import com.sinosoft.ebusiness.rms.model.Task;
import com.sinosoft.ebusiness.rms.model.TaskAuth;
import com.sinosoft.ebusiness.rms.service.spring.TaskServiceSpringImpl;

public class PatchTaskServiceSpringImpl extends TaskServiceSpringImpl<Task, String> {

	
	/**
	 * 为机构查询授权信息
	 */
	public Set<Task> findTaskAuthByType(String addType) {
		QueryRule queryRule = QueryRule.getInstance();
		if(addType.toString().equals("0")){
			queryRule.addEqual("name", "系统管理组");
		}else if (addType.toString().equals("1")) {
			queryRule.addEqual("name", "省公司管理组");
		}else if (addType.toString().equals("2")) {
			queryRule.addEqual("name", "市公司管理组");
		}else if (addType.toString().equals("3")) {
			queryRule.addEqual("name", "县公司管理组");
		}else if (addType.toString().equals("4")) {
			queryRule.addEqual("name", "团购组");
		}else if (addType.toString().equals("5")) {
			queryRule.addEqual("name", "客服经理组");
		}
		Group group =new Group();
		group=super.findUnique(Group.class, queryRule);
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
		return tasks;
	}
}
