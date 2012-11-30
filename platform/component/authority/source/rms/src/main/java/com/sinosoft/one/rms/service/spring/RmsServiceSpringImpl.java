package com.sinosoft.one.rms.service.spring;

import ins.framework.cache.CacheManager;
import ins.framework.cache.CacheService;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.framework.utils.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.rms.model.ExcPower;
import com.sinosoft.one.rms.model.Group;
import com.sinosoft.one.rms.model.GroupRole;
import com.sinosoft.one.rms.model.RoleDesignate;
import com.sinosoft.one.rms.model.Task;
import com.sinosoft.one.rms.model.UserGroup;
import com.sinosoft.one.rms.model.UserPower;
import com.sinosoft.one.rms.service.facade.EmployeServiceInterface;
import com.sinosoft.one.rms.service.facade.RmsService;
public class RmsServiceSpringImpl<T, E> extends GenericDaoHibernate<Task, String>implements RmsService
		 {
	/**
	 * 初始缓存实例
	 */
	private static CacheService taskCacheManager = CacheManager.getInstance("Task");
	
	private static CacheService userCacheManager = CacheManager.getInstance("User");
	
	private static CacheService groupCacheManager = CacheManager.getInstance("Group");
	
	
	@Autowired
	private EmployeServiceInterface employeServiceInterface;
	
//	@Autowired
//	private CompanyService companyService;
//
//	@Autowired
//	private EmployeService employeService;

	@Autowired
	private UserPowerService<T, E> userpowerSerivce;
	
	public void addUserPower(String userCode, String comCode,
			List<String> groupIDs, List<String> roleIDs, List<String> excTaskIDs,String sysFlag) {
		userpowerSerivce.addUserPower(userCode, comCode, groupIDs,roleIDs, excTaskIDs,sysFlag);
		taskCacheManager.clearCache("userTask");
		groupCacheManager.clearCache("userHasGroups");
		userCacheManager.clearCache("inGroup");
		userCacheManager.clearCache("notInGroup");
		userCacheManager.clearCache("inUserPower");
		userCacheManager.clearCache("notInUserPower");
	}

	public void deleteUserPower(String userCode, String comCode) {
		userpowerSerivce.delete(userCode, comCode);
		taskCacheManager.clearCache("userTask");
		groupCacheManager.clearCache("userHasGroups");
		userCacheManager.clearCache("inGroup");
		userCacheManager.clearCache("notInGroup");
		userCacheManager.clearCache("inUserPower");
		userCacheManager.clearCache("notInUserPower");
	}
	/**
	 * 根据机构代码查询权限员工列表(已引入员工)
	 * @param comCode
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Page findEmployees(String comCode,String userCode,String userName,int pageNo,int pageSize) {
		String key = userCacheManager.generateCacheKey("inUserPower", userCode+userName+comCode+pageNo+pageSize+"in");
		Object result = userCacheManager.getCache(key);
		if (result != null) {
			return (Page) result;
		}
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("comCode", comCode);
		queryRule.addEqual("isValidate", "1");
		if(StringUtils.isNotBlank(userCode)){
			queryRule.addLike("userCode", "%"+userCode+"%");
		}
		//查询权限表信息
		List<UserPower> userPowers = super.find(UserPower.class, queryRule);
		List<String> userCodes = new ArrayList<String>();
		Page page=new Page();
		if (userPowers != null && !userPowers.isEmpty()) {
			//获得权限表中的人员代码
			for (UserPower userPower : userPowers) {
				userCodes.add(userPower.getUserCode());
			}
			page=employeServiceInterface.findUserInUserCodes(userCodes, userName, userCode, pageNo, pageSize);
			userCacheManager.putCache(key, page);
			return page;
		}
		return page;
	}

	/**
	 * 根据员工代码和机构代码查询员工(未引入员工，引入页面)
	 */
	@SuppressWarnings("unchecked")
	public Page findNEmployees(String userCode, String userName,
			String comCode, int pageNo, int pageSize) {
		String key = userCacheManager.generateCacheKey("notInUserPower", userCode+userName+comCode+pageNo+pageSize+"notIn");
		Object result = userCacheManager.getCache(key);
		if (result != null) {
			return (Page) result;
		}
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("comCode", comCode);
		queryRule.addEqual("isValidate", "1");
		if(StringUtils.isNotBlank(userCode)){
			queryRule.addLike("userCode", "%"+userCode+"%");
		}
		//查询权限表信息
		List<UserPower> userPowers = super.find(UserPower.class, queryRule);
		List<String> userCodes = new ArrayList<String>();
		Page page=new Page();
		if (userPowers != null && !userPowers.isEmpty()) {
			//获得权限表中的人员代码
			for (UserPower userPower : userPowers) {
				userCodes.add(userPower.getUserCode());
			}
			page=employeServiceInterface.findUserNoInUserCodes(userCodes, comCode, userName, userCode, pageNo, pageSize);
			userCacheManager.putCache(key, page);
			return page;
		}
		page=employeServiceInterface.findUserNoInUserCodes(userCodes, comCode, userName, userCode, pageNo, pageSize);
		userCacheManager.putCache(key, page);
		return page;
	}
	/**
	 * 查询除外权限
	 */
	public Set<Task> findExcPower(String userCode, String comCode) {
		UserPower userPower=new UserPower();
		userPower=userpowerSerivce.findUserPowerByComUser(userCode, comCode);
		Set<Task> tasks=new HashSet<Task>();
		if(userPower!=null){
			List<ExcPower> excPowers=new ArrayList<ExcPower>();
			excPowers=userPower.getExcPowers();
			for (ExcPower excPower : excPowers) {
				tasks.add(excPower.getTask());
			}
		}
		return tasks;
	}
	
	
	
	
	/**
	 * 获得员工在机构下有效权限集合
	 */
	public List<Task> findTaskMultSysByUserCode(String userCode, String comCode,String sysFlag) {
		Set<Task> result=getTaskResultByComUserMultSysFlag(userCode, comCode, sysFlag);
		Set<Task> ts = new HashSet<Task>();
		iterateTask(ts, result);
		return taskArrange(ts);
	}
	
	/**
	 * 查询人员可配置数据规则的权限
	 */
	public List<Task> findDataRuleTaskMultSysByComUser(String userCode, String comCode,String sysFlag) {
		Set<Task> result=getTaskResultByComUserMultSysFlag(userCode, comCode, sysFlag);
		Set<Task> ts = new HashSet<Task>();
		iterateTask(ts, result);
		return dataRuletask(ts);
	}
	
	/**
	 * 查询人员权限
	 */
	public UserPower findUserPowerByComUser(String userCode, String comCode) {
		return userpowerSerivce.findUserPowerByComUser(userCode, comCode);
	}
	/**
	 * 查询人员权限集合
	 */
	public List<UserPower> findUserPowersByUserCode(String userCode) {
		return userpowerSerivce.findUserPowersByUserCode(userCode);
	}
	
	
	
	
	
	
	/**
	 * 循环获得父节点功能
	 */
	public void iterateTask(Set<Task> tsks,Set<Task> tasks){
		for (Task task : tasks) {
			this.getSuppTask(tsks, task);
		}
	}
	
	void getSuppTask(Set<Task> result,Task task){
		if(task.getIsValidate().toString().equals("1")){
			result.add(task);
		}
		if (task.getParent()!=null) {
			getSuppTask(result,task.getParent());
		}
	}
	
	//对功能集合排序
	@SuppressWarnings("unchecked")
	public List<Task> taskArrange(Set<Task> ts){
		List<String>ids=new ArrayList<String>();
		for (Task task : ts) {
			ids.add(task.getTaskID());
		}
		List<Task> tasks=new ArrayList<Task>();
		if(ids.size()>0){
			QueryRule queryRule = QueryRule.getInstance();
			queryRule.addIn("taskID", ids);
			queryRule.addAscOrder("sort");
			tasks=super.find(Task.class, queryRule);
		}
		return tasks;
	}
	
	//对功能集合排序
	public List<Task> dataRuletask (Set<Task> ts){
		List<Task> tasks=new ArrayList<Task>();
		for (Task task : ts) {
			if(StringUtils.isNotBlank(task.getIsConfigDataRule())&&task.getIsConfigDataRule().toString().equals("1")){
				tasks.add(task);
			}
		}
		return tasks;
	}
	

	@SuppressWarnings("unchecked")
	Set<Task> getTaskResultByComUserMultSysFlag(String userCode, String comCode,String sysFlag ){
		UserPower userPower =new UserPower();
		userPower=	userpowerSerivce.findUserPowerByComUser(userCode, comCode);
		List<UserGroup>userGroups=new  ArrayList<UserGroup>();
		userGroups=userPower.getUserGroups();
		List<Group> groups=new ArrayList<Group>();
		for (UserGroup usergroup : userGroups) {
			//用户组的过滤
			if(usergroup.getIsValidate().toString().equals("1".toString())){
				//过滤获取当前机构的用户组或者 所有可见的用户组
				if(usergroup.getGroup().getComCode().toString().equals(comCode)||usergroup.getGroup().getComCode().toString().equals("*")){
					groups.add(usergroup.getGroup());
				}
			}
		}
		List<GroupRole>groupRoles=new ArrayList<GroupRole>();
		for (Group group :groups) {
			groupRoles.addAll(group.getGroupRoles());
		}
		//根据机构获得指派的信息 取得roleID 过滤用户组关联的角色
		List<RoleDesignate> roleDesignates=new ArrayList<RoleDesignate>();
		QueryRule queryRole = QueryRule.getInstance();
		//查询登陆机构的指派以及所有可见的指派
		queryRole.addIn("id.comCode", comCode,"*");
		roleDesignates=super.find(RoleDesignate.class, queryRole);
		//根据获得的指派角色信息获得角色ID
		List<String> roleids=new ArrayList<String>();
		for (RoleDesignate roleDesignate : roleDesignates) {
			for (GroupRole groupRole : groupRoles) {
				if(roleDesignate.getId().getRoleID().toString().equals(groupRole.getRole().getRoleID().toString())){
					roleids.add(roleDesignate.getId().getRoleID());
				}
			}
		}
		StringBuffer taskIDSQL=new StringBuffer();
		List<String> taskIDs = new ArrayList<String>();
		if (roleids.size() > 0) {
			// 根据角色ID获得 角色关联的功能id集合
			taskIDSQL
					.append(" select taskid from ge_rms_task_auth where taskauthid in (");
			taskIDSQL
					.append(" select taskauthid from ge_rms_roletask g where g.isvalidate='1' ");
			taskIDSQL.append("and g.roleid in (");
			for (String string : roleids) {
				taskIDSQL.append(" '" + string + "',");
			}
			taskIDSQL.delete(taskIDSQL.length() - 1, taskIDSQL.length());
			taskIDSQL.append(")");
			taskIDSQL.append(")");
			taskIDs = (List<String>) getSession().createSQLQuery(taskIDSQL.toString()).list();
		}
		taskIDSQL.setLength(0);
		//获取该机构的功能ID
		taskIDSQL.append("select taskid from ge_rms_task_auth where comcode='"+comCode+"' or comcode='*'");
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
		//获得功能对象
		Set<Task>tasks=new HashSet<Task>();
		if (resultTaskIDs.size() > 0) {
			StringBuffer hql=new StringBuffer();
			hql.append("from Task where taskID in(");
			for (String string : resultTaskIDs) {
				hql.append(" '" + string + "',");
			}
			hql.delete(hql.length() - 1, hql.length());
			hql.append(")");
			hql.append("and isValidate='1'");
			if(StringUtils.isNotBlank(sysFlag)){
				hql.append(" and (sysFlag='"+sysFlag+"' or sysFlag='RMS')");
			}else{
				hql.append(" and sysFlag='RMS'");
			}
			tasks.addAll(super.findByHql(hql.toString()));
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
		return result;
	}

	public List<Task> findTaskByUserCode(String paramString1,
			String paramString2) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
