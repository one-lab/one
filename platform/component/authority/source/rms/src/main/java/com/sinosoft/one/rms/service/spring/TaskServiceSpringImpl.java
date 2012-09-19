package com.sinosoft.one.rms.service.spring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;


import ins.framework.cache.CacheManager;
import ins.framework.cache.CacheService;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.framework.utils.StringUtils;

import com.sinosoft.one.rms.model.Task;
import com.sinosoft.one.rms.model.TaskAuth;
import com.sinosoft.one.rms.service.facade.CompanyServiceInterface;
import com.sinosoft.one.rms.service.facade.TaskService;

public class TaskServiceSpringImpl<T, E> extends GenericDaoHibernate<Task, String>
		 implements TaskService{
	private static CacheService cacheManager = CacheManager.getInstance("Task");
	
	@Autowired
	private CompanyServiceInterface comService;
	/**
	 * 为机构授权操作
	 */
	@SuppressWarnings("unchecked")
	public void taskAuth(String userCode, String comCode, List<String> taskIDs) {
		QueryRule queryComTask=QueryRule.getInstance();
		queryComTask.addEqual("comCode", comCode);
		List<TaskAuth> tasksAuths=super.find(TaskAuth.class, queryComTask);
		//授权操作没有的保留
		//新的才创建
		for (String string : taskIDs) {
			int flag=0;
			if(StringUtils.isNotEmpty(string)||!"".equals(string)){
				for (TaskAuth taskAuth : tasksAuths) {
					if(!taskAuth.getTask().getTaskID().toString().equals(string.toString())){
						flag++;
					}
				}
				if(flag==tasksAuths.size()){
					QueryRule queryRule = QueryRule.getInstance();
					queryRule.addEqual("taskID", string);
					queryRule.addEqual("isValidate", "1");
					Task task = new Task();
					task = super.findUnique(Task.class, queryRule);
					TaskAuth taskA = new TaskAuth();
					taskA.setTask(task);
					taskA.setOperateUser(userCode);
					taskA.setComCode(comCode);
					super.save(taskA);
				}
			}
		}
		//没有的删除 
		List<String> deleteTaskIDs=new ArrayList<String>();
		List<String> comCods=new ArrayList<String>();
		for (TaskAuth taskAuth : tasksAuths) {
			int deleteFalg=0;
			for (String string : taskIDs) {
				if(StringUtils.isNotEmpty(string)||!"".equals(string)){
					if(!taskAuth.getTask().getTaskID().toString().equals(string.toString())){
						deleteFalg++;
					}
				}else{
					//添加需要删除的ID
					deleteTaskIDs.add(taskAuth.getTask().getTaskID());
				}
			}
			if(deleteFalg==taskIDs.size()){
				deleteTaskIDs.add(taskAuth.getTask().getTaskID());
			}
		}
		comCods.add(comCode);
		if(deleteTaskIDs.size()>0){
			iteraterComCode(comCods, deleteTaskIDs);
		}
		cacheManager.clearCache("comCodeTask");
	}

	/**
	 * 为机构查询授权信息
	 */
	@SuppressWarnings("unchecked")
	public Set<Task> findTaskAuthByComCode(String comCode) {
		List<TaskAuth> taskaAuths=new ArrayList<TaskAuth>();
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("comCode", comCode);
		taskaAuths = super.find(TaskAuth.class, queryRule);
		if (taskaAuths == null) {
			// 异常处理
		}
		Set<Task> tasks=new HashSet<Task>();
		for (TaskAuth taskAuth : taskaAuths) {
			tasks.add(taskAuth.getTask());
		}
		return tasks;
	}
	
	/**
	 * 根据角色查询关联的功能
	 */
	@SuppressWarnings("unchecked")
	public Set<Task> findTaskByRole(List<String> RoleIDs,String comCode) {
		//获取角色关联的功能ID
		StringBuffer taskIDSQL=new StringBuffer();
		taskIDSQL.append(" select taskid from ge_rms_task_auth where taskauthid in (" );
		taskIDSQL.append(" select taskauthid from ge_rms_roletask g where g.isvalidate='1' and g.roleid in (");
		for (String string : RoleIDs) {
			taskIDSQL.append(" '" + string + "',");
		}
		taskIDSQL.delete(taskIDSQL.length() - 1, taskIDSQL.length());
		taskIDSQL.append("))");
		List<String>taskIDs=new ArrayList<String>();
		taskIDs=(List<String>)getSession().createSQLQuery(taskIDSQL.toString()).list();
		taskIDSQL.setLength(0);
		//获取该机构的功能ID
		taskIDSQL.append("select taskid from ge_rms_task_auth where comcode='"+comCode+"'");
		List<String> comtaskIDs=new ArrayList<String>();
		comtaskIDs=(List<String>)getSession().createSQLQuery(taskIDSQL.toString()).list();
		List<String> resultTaskIDs=new ArrayList<String>();
		//两功能ID集合去重
		for (String com_TaskID : comtaskIDs) {
			for (String role_TaskID : taskIDs) {
				if(com_TaskID.toString().equals(role_TaskID.toString())){
					resultTaskIDs.add(com_TaskID);
					break;
				}
			}
		}
		Set<Task>tasks=new HashSet<Task>();
		if (resultTaskIDs.size() > 0) {
			QueryRule queryTask = QueryRule.getInstance();
			queryTask.addIn("taskID", resultTaskIDs);
			tasks.addAll(super.find(Task.class, queryTask));
		}
		return tasks;
	}
	/**
	 * 删除机构授权信息
	 */
	@SuppressWarnings("unchecked")
	public void deleteTaskAuth(String comCode) {
		List<TaskAuth> taskaAuths = new ArrayList<TaskAuth>();
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("comCode", comCode);
		taskaAuths = super.find(TaskAuth.class, queryRule);
		if (taskaAuths == null) {
			// 异常处理
		}
		super.deleteAll(taskaAuths);
		cacheManager.clearCache("comCodeTask");
	}
	
	//迭代删除机构的所有子机构 的功能
	@SuppressWarnings("unchecked")
	void iteraterComCode(List<String> comCodes ,List<String> taskIds){
		// 每次执行 先进行删除操作
		//删除操作时先删外键记录
		deleteRoleTask(comCodes, taskIds);
		StringBuffer delteComCodeSQL = new StringBuffer();
		delteComCodeSQL.append("delete ge_rms_task_auth where  taskId in (");
		for (String string : taskIds) {
			delteComCodeSQL.append(" '" + string + "',");
		}
		delteComCodeSQL.delete(delteComCodeSQL.length() - 1,
				delteComCodeSQL.length());
		delteComCodeSQL.append(")");
		delteComCodeSQL.append("and comcode in(");
		int i=0;
		for ( i = 0; i < comCodes.size() ; i++) {
			delteComCodeSQL.append(" '" + comCodes.get(i) + "',");
			//每如果到了1000则用OR处理
			if(i>=999&&i%999==0){
				System.out.println(i+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				delteComCodeSQL.delete(delteComCodeSQL.length() - 1,
						delteComCodeSQL.length());
				delteComCodeSQL.append(")");
				delteComCodeSQL.append(" or comcode in(");
			}
		}
		delteComCodeSQL.delete(delteComCodeSQL.length() - 1,
				delteComCodeSQL.length());
		delteComCodeSQL.append(")");
		getSession().createSQLQuery(delteComCodeSQL.toString()).executeUpdate();
		// 然后进行查询下一级机构
		//下面部分交予comService 
//		StringBuffer comCodesSQL = new StringBuffer();
//		comCodesSQL.append("select comCode from ge_rms_company where uppercomcode in (");
//		List<String> subcomCodes = new ArrayList<String>();
//		i=0;
//		for (i = 0; i < comCodes.size(); i++) {
//			comCodesSQL.append(" '" + comCodes.get(i) + "',");
//			//每如果到了1000则用OR处理
//			if(i%999==0&&i>=999){
//				System.out.println(i+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//				comCodesSQL.delete(comCodesSQL.length() - 1,comCodesSQL.length());
//				comCodesSQL.append(")");
//				comCodesSQL.append(" or uppercomcode in(");
//			}
//		}
//		comCodesSQL.delete(comCodesSQL.length() - 1,comCodesSQL.length());
//		comCodesSQL.append(")");
//		//是否要删除OR语句的结尾
//		subcomCodes = (List<String>) getSession().createSQLQuery(comCodesSQL.toString()).list();
		List<String> subcomCodes = comService.findComCodebySuperComCode(comCodes);
		if (subcomCodes.size() > 0) {
			iteraterComCode(subcomCodes, taskIds);
		}
		// 继续循环
	}
	void deleteRoleTask(List<String> comCodes ,List<String> taskIds){
		//先删除外键记录(RoleTask)
		StringBuffer deleteRoleTaskSQL=new StringBuffer();
		deleteRoleTaskSQL.append("select taskauthid from ge_rms_task_auth where  taskId in (");
		for (String string : taskIds) {
			deleteRoleTaskSQL.append(" '" + string + "',");
		}
		deleteRoleTaskSQL.delete(deleteRoleTaskSQL.length() - 1,
				deleteRoleTaskSQL.length());
		deleteRoleTaskSQL.append(")");
		deleteRoleTaskSQL.append("and comcode in(");
		int i=0;
		for ( i = 0; i < comCodes.size() ; i++) {
			deleteRoleTaskSQL.append(" '" + comCodes.get(i) + "',");
			//每如果到了1000则用OR处理
			if(i>=999&&i%999==0){
				System.out.println(i+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				deleteRoleTaskSQL.delete(deleteRoleTaskSQL.length() - 1,
						deleteRoleTaskSQL.length());
				deleteRoleTaskSQL.append(")");
				deleteRoleTaskSQL.append(" or comcode in(");
			}
		}
		deleteRoleTaskSQL.delete(deleteRoleTaskSQL.length() - 1,deleteRoleTaskSQL.length());
		deleteRoleTaskSQL.append(")");
		List<String> taskauthids = new ArrayList<String>();
		taskauthids=(List<String>) getSession().createSQLQuery(deleteRoleTaskSQL.toString()).list();
		if(taskauthids.size()>0){
			StringBuffer delteComCodeSQL = new StringBuffer();
			delteComCodeSQL
					.append("delete ge_rms_roletask where  taskauthid in (");
			for (i = 0; i < taskauthids.size(); i++) {
				delteComCodeSQL.append(" '" + taskauthids.get(i) + "',");
				// 每如果到了1000则用OR处理
				if (i >= 999 && i % 999 == 0) {
					System.out.println(i + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
					delteComCodeSQL.delete(delteComCodeSQL.length() - 1,
							delteComCodeSQL.length());
					delteComCodeSQL.append(")");
					delteComCodeSQL.append(" or taskauthid in(");
				}
			}
			delteComCodeSQL.delete(delteComCodeSQL.length() - 1,
					delteComCodeSQL.length());
			delteComCodeSQL.append(")");
			getSession().createSQLQuery(delteComCodeSQL.toString()).executeUpdate();
		}
	}
	
	public void addTaskHasSysFlag(String taskId, String name, String menuURL,
			String menuName, String des,String isAsMenu, String parentId,String loginUserCode,String loginComCode,
			String SysFlag) {
		Task task=new Task();
		task.setTaskID(taskId);
		task.setName(name);
		task.setMenuURL(menuURL);
		task.setMenuName(menuName);
		task.setDes(des);
		task.setSysFalg(SysFlag);
		task.setIsValidate("1");
		task.setParent(super.get(Task.class, parentId));
		task.setIsAsMenu(isAsMenu);
		List<TaskAuth> taskAuths=new ArrayList<TaskAuth>();
		TaskAuth taskAuth=new TaskAuth();
		taskAuth.setTask(task);
		taskAuth.setComCode(loginComCode);
		taskAuth.setOperateUser(loginUserCode);
		taskAuth.setTask(task);
		taskAuths.add(taskAuth);
		task.setTaskAuths(taskAuths);
		super.save(task);
	}

	public void addTask(String taskId, String name, String menuURL,
			String menuName, String des,String isAsMenu, String parentId, String loginUserCode,String loginComCode) {
		Task task=new Task();
		task.setTaskID(taskId);
		task.setName(name);
		task.setMenuURL(menuURL);
		task.setMenuName(menuName);
		task.setDes(des);
		task.setIsValidate("1");
		task.setIsAsMenu(isAsMenu);
		if(StringUtils.isNotBlank(parentId))
			task.setParent(super.get(Task.class, parentId));
		List<TaskAuth> taskAuths=new ArrayList<TaskAuth>();
		TaskAuth taskAuth=new TaskAuth();
		taskAuth.setTask(task);
		taskAuth.setComCode(loginComCode);
		taskAuth.setOperateUser(loginUserCode);
		taskAuth.setTask(task);
		taskAuths.add(taskAuth);
		task.setTaskAuths(taskAuths);
		super.save(task);
		
	}

	public void updateTaskHasSysFlag(String taskId, String name, String menuURL,String isValidate,
			String menuName, String des,String isAsMenu,String SysFlag) {
		Task task=super.get(Task.class, taskId);
		if (task!=null) {
			task.setTaskID(taskId);
			task.setName(name);
			task.setMenuURL(menuURL);
			task.setMenuName(menuName);
			task.setDes(des);
			task.setIsValidate(isValidate);
			task.setSysFalg(SysFlag);
			task.setIsAsMenu(isAsMenu);
			super.update(task);
		}
	}

	public void updateTask(String taskId, String name, String menuURL,String isValidate,
			String menuName, String des,String isAsMenu) {
		Task task=super.get(Task.class, taskId);
		if (task!=null) {
			task.setTaskID(taskId);
			task.setName(name);
			task.setMenuURL(menuURL);
			task.setMenuName(menuName);
			task.setDes(des);
			task.setIsValidate(isValidate);
			task.setIsAsMenu(isAsMenu);
			super.update(task);
		}
	}

	public Task findTaskById(String TaskId) {
		return super.get(Task.class, TaskId);
	}
	
	public List<Task>findAllTask(){
		return super.getAll(Task.class);
	}
	
	public void deleteTaskByID(String TaskId){
		Task task=new Task();
		task=super.get(TaskId);
		task.setIsValidate("");
		super.save(task);
	//	super.deleteByPK(TaskId);
	}
}
