package com.sinosoft.one.rms.service.picc;

import ins.framework.cache.CacheManager;
import ins.framework.cache.CacheService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.sinosoft.one.rms.model.Role;
import com.sinosoft.one.rms.model.RoleDesignate;
import com.sinosoft.one.rms.model.RoleDesignateId;
import com.sinosoft.one.rms.model.RoleTask;
import com.sinosoft.one.rms.model.TaskAuth;
import com.sinosoft.one.rms.service.spring.RoleServiceSpringImpl;

public class PatchRoleServiceSpringImpl extends RoleServiceSpringImpl<Role, String>  implements RoleService{

	private static CacheService cacheManager = CacheManager.getInstance("Role");
	
	@SuppressWarnings("unchecked")
	public void addRoleNoDefGroup(String comCode, String userCode, List<String> TaskIDs,
			String roleName, String des) {
		Role role = new Role();
		StringBuffer sql = new StringBuffer();
		//根据传入功能ID获得机构的功能授权
		sql.append("from  TaskAuth t where  t.comCode='" + comCode
				+ "' and t.task.taskID in (");
		for (String string : TaskIDs) {
			sql.append(" '" + string + "',");
		}
		sql.delete(sql.length() - 1, sql.length());
		sql.append(")");
		Query queryTaskAuth = getSession().createQuery(sql.toString());
		List<TaskAuth> taskAuths = queryTaskAuth.list();
		role.setCreateUser(userCode);
		role.setOperateUser(userCode);
		role.setName(roleName);
		role.setDes(des);
		role.setComCode(comCode);
		//创建角色功能
		List<RoleTask> roleTasks = new ArrayList<RoleTask>();
		for (TaskAuth taskAuth : taskAuths) {
			RoleTask roleTask = new RoleTask();
			roleTask.setRole(role);
			roleTask.setIsValidate("1");
			roleTask.setTaskAuth(taskAuth);
			roleTasks.add(roleTask);
		}
		role.setRoleTasks(roleTasks);
		role.setIsValidate("1");
		Date date = new Date();
		role.setCreateTime(date);
		role.setOperateTime(date);
		super.save(role);
		//默认指派角色操作
		RoleDesignate roleDesignate = new RoleDesignate();
		RoleDesignateId roleDesignateId = new RoleDesignateId();
		roleDesignateId.setRoleID(role.getRoleID());
		roleDesignateId.setComCode(comCode);
		roleDesignate.setRole(role);
		roleDesignate.setId(roleDesignateId);
		roleDesignate.setCreateUser(userCode);
		roleDesignate.setOperateUser(userCode);
		roleDesignate.setCreateTime(date);
		roleDesignate.setOperateTime(date);
		super.save(roleDesignate);
	}
	
	/**
	 * 更新角色 (不操作默认用户组，不操作指派)
	 */
	@SuppressWarnings("unchecked")
	public void updataRoleByIdNoDefGroup(String roleID,String loginComCode,
			String userCode, List<String> TaskIDs, String roleName, String des) {
		Role role = super.get(roleID);
		// 删除角色关联的功能
		StringBuffer deleteRoleTasksql = new StringBuffer();
		deleteRoleTasksql.append("delete ge_rms_roletask t where t.roleID='"+roleID+"' and t.taskAuthid in (");
		deleteRoleTasksql.append(" select taskauthid from ge_rms_task_auth a where a.comcode=");
		deleteRoleTasksql.append("'" + loginComCode + "')");
		getSession().createSQLQuery(deleteRoleTasksql.toString())
				.executeUpdate();
		// 查询功能集合,重新添加角色功能信息
		StringBuffer hql = new StringBuffer();
		hql.append("from  TaskAuth t where t.comCode='"+loginComCode+"' and t.task.taskID in (");
		for (String string : TaskIDs) {
			hql.append(" '" + string + "',");
		}
		hql.delete(hql.length() - 1, hql.length());
		hql.append(")");
		Query queryTaskAuth = getSession().createQuery(hql.toString());
		List<TaskAuth> taskAuths = queryTaskAuth.list();
		List<RoleTask> roleTasks = new ArrayList<RoleTask>();
		for (TaskAuth taskAuth : taskAuths) {
			RoleTask roleTask = new RoleTask();
			roleTask.setIsValidate("1");
			roleTask.setTaskAuth(taskAuth);
			roleTask.setRole(role);
			roleTasks.add(roleTask);
		}
		role.setRoleTasks(roleTasks);
		role.setName(roleName);
		role.setDes(des);
		Date date = new Date();
		role.setOperateTime(date);
		role.setOperateUser(userCode);
		super.update(role);
		cacheManager.clearCache("comCodeRole");
	}
}
