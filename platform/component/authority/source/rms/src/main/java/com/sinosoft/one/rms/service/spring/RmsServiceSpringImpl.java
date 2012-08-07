package com.sinosoft.one.rms.service.spring;

import ins.framework.cache.CacheManager;
import ins.framework.cache.CacheService;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.framework.utils.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.sinosoft.one.rms.model.Company;
import com.sinosoft.one.rms.model.Employe;
import com.sinosoft.one.rms.model.ExcPower;
import com.sinosoft.one.rms.model.Group;
import com.sinosoft.one.rms.model.GroupRole;
import com.sinosoft.one.rms.model.RoleDesignate;
import com.sinosoft.one.rms.model.Task;
import com.sinosoft.one.rms.model.UserGroup;
import com.sinosoft.one.rms.model.UserPower;
import com.sinosoft.one.rms.service.facade.RmsService;
public class RmsServiceSpringImpl<T, E> extends GenericDaoHibernate<Task, String>implements RmsService
		 {
	/**
	 * 初始缓存实例
	 */
	private static CacheService cacheManager = CacheManager.getInstance("Task");
	
	@Autowired
	private CompanyService companyService;

	@Autowired
	private EmployeService employeService;

	@Autowired
	private UserPowerService<T, E> userpowerSerivce;
	
	public void addUserPower(String userCode, String comCode,
			List<String> groupIDs, List<String> excTaskIDs) {
		userpowerSerivce.addUserPower(userCode, comCode, groupIDs, excTaskIDs);
		cacheManager.clearCache("userTask");
	}

	public void deleteUserPower(String userCode, String comCode) {
		userpowerSerivce.delete(userCode, comCode);
		cacheManager.clearCache("userTask");
	}
	/**
	 * 根据用户代码 获取机构列表(引入机构,登陆时已引入机构)
	 */
	public List<Company> findComByUserCode(String userCode){
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("userCode", userCode);
		List<UserPower> userPower = super.find(UserPower.class, queryRule);
		if (userPower == null || userPower.isEmpty()) {
			//异常
		}
		List<String> comCodes = new ArrayList<String>();
		for (Iterator<UserPower> iter = userPower.iterator(); iter.hasNext();) {
			comCodes.add(iter.next().getComCode());
		}
		List<Company> companies=new ArrayList<Company>();
		if(comCodes.size()>0){ 
			QueryRule queryRuleComcode=QueryRule.getInstance();
			queryRuleComcode.addIn("comCode", comCodes);
			companies=super.find(Company.class, queryRuleComcode);
		}
//		QueryRule queryComCode = QueryRule.getInstance();
//		queryComCode.addIn("comCode", comCodes);
		return companies;
	}
	/**
	 * 根据机构代码查询权限员工列表(已引入员工)
	 * @param comCode
	 * @return
	 */
	public Page findEmployees(String comCode,String userCode,String userName,int pageNo,int pageSize) {
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
			QueryRule queryEmploye = QueryRule.getInstance();
			queryEmploye.addIn("userCode", userCodes);
			if(StringUtils.isNotEmpty(userName)){
				queryEmploye.addLike("userName", "%"+ userName + "%");
			}
			//获得引入人员
			page=super.find(Employe.class, queryEmploye, pageNo,pageSize );
			return page;
		}
		return page;
	}

	/**
	 * 根据员工代码和机构代码查询员工(未引入员工，引入页面)
	 */
	public Page findNEmployees(String userCode, String userName,
			String comCode, int pageNo, int pageSize) {
		return employeService.findEmployees(userCode, userName, comCode, pageNo, pageSize);
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
	 * 查询下级子机构
	 */
	public List<Company> findNextSubCom(String comCode) {
		return companyService.findNextSubCom(comCode);
	}
	
	/**
	 * 获得员工在机构下有效权限集合
	 */
	public List<Task> findTaskByUserCode(String userCode, String comCode) {
		String key = cacheManager.generateCacheKey("userTask", comCode
				+ userCode);
		Object resut = cacheManager.getCache(key);
		if (resut != null) {
			return (List<Task>) resut;
		}
		List<Task> userTasksResult = new ArrayList<Task>();
		UserPower userPower = new UserPower();
		userPower = userpowerSerivce.findUserPowerByComUser(userCode, comCode);
		List<UserGroup> userGroups = new ArrayList<UserGroup>();
		if (userPower != null) {
			userGroups = userPower.getUserGroups();
			List<Group> groups = new ArrayList<Group>();
			for (UserGroup usergroup : userGroups) {
				// 用户组的过滤
				if (usergroup.getIsValidate().toString().equals("1".toString())) {
					if (usergroup.getGroup().getComCode().toString()
							.equals(comCode)) {
						groups.add(usergroup.getGroup());
					}
				}
			}
			List<GroupRole> groupRoles = new ArrayList<GroupRole>();
			for (Group group : groups) {
				groupRoles.addAll(group.getGroupRoles());
			}
			// 根据机构获得指派的信息 取得roleID 过滤用户组关联的角色
			List<RoleDesignate> roleDesignates = new ArrayList<RoleDesignate>();
			QueryRule queryRole = QueryRule.getInstance();
			queryRole.addIn("id.comCode", comCode);
			roleDesignates = super.find(RoleDesignate.class, queryRole);
			// 根据获得的指派角色信息获得角色ID
			List<String> roleids = new ArrayList<String>();
			for (RoleDesignate roleDesignate : roleDesignates) {
				for (GroupRole groupRole : groupRoles) {
					if (roleDesignate.getId().getRoleID().toString()
							.equals(groupRole.getRole().getRoleID().toString())) {
						roleids.add(roleDesignate.getId().getRoleID());
					}
				}
			}
			StringBuffer taskIDSQL = new StringBuffer();
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
				taskIDs = (List<String>) getSession().createSQLQuery(
						taskIDSQL.toString()).list();
			}
			taskIDSQL.setLength(0);
			// 获取该机构的功能ID
			taskIDSQL
					.append("select taskid from ge_rms_task_auth where comcode='"
							+ comCode + "'");
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
			// 获得功能对象
			Set<Task> tasks = new HashSet<Task>();
			if (resultTaskIDs.size() > 0) {
				QueryRule queryTask = QueryRule.getInstance();
				queryTask.addIn("taskID", resultTaskIDs);
				queryTask.addEqual("isValidate", "1");
				tasks.addAll(super.find(Task.class, queryTask));
			}
			// 获得除外权限 
			Set<Task> excTasks = new HashSet<Task>();
			if (userPower != null) {
				for (ExcPower excpower : userPower.getExcPowers()) {
					excTasks.add(excpower.getTask());
				}
			}
			Set<Task> result = new HashSet<Task>();
			// 除外权限和获得的权限过滤
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
			userTasksResult = taskArrange(ts);
			cacheManager.putCache(key, userTasksResult);
			return userTasksResult;
		} else {
			return userTasksResult;
		}
	}
	
	/**
	 * 获得员工在机构下有效权限集合
	 */
	public List<Task> findTaskMultSysByUserCode(String userCode, String comCode,String sysFlag) {
		UserPower userPower =new UserPower();
		userPower=	userpowerSerivce.findUserPowerByComUser(userCode, comCode);
		List<UserGroup>userGroups=new  ArrayList<UserGroup>();
		userGroups=userPower.getUserGroups();
		List<Group> groups=new ArrayList<Group>();
		for (UserGroup usergroup : userGroups) {
			//用户组的过滤
			if(usergroup.getIsValidate().toString().equals("1".toString())){
				if(usergroup.getGroup().getComCode().toString().equals(comCode)){
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
		queryRole.addIn("id.comCode", comCode);
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
		//获得功能对象
		Set<Task>tasks=new HashSet<Task>();
		if (resultTaskIDs.size() > 0) {
			QueryRule queryTask = QueryRule.getInstance();
			queryTask.addIn("taskID", resultTaskIDs);
			queryTask.addEqual("isValidate", "1");
			queryTask.addEqual("sysFalg", sysFlag);
			tasks.addAll(super.find(Task.class, queryTask));
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
		return taskArrange(ts);
	}
	/**
	 * 查询单个人员对象
	 */
	public Employe findUserByCode(String userCode) {
		return 	employeService.findUserByCode(userCode);
	}
	
	/**
	 * 查询是否有下级机构
	 */
	public boolean isExtSubCom(String comCode) {
		return companyService.isExtSubCom(comCode);
	}
	
	/**
	 * 查询人员权限
	 */
	public UserPower findUserPowerByComUser(String userCode, String comCode) {
		return userpowerSerivce.findUserPowerByComUser(userCode, comCode);
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
	public List<Task> taskArrange(Set<Task> ts){
		List<String>ids=new ArrayList<String>();
		for (Task task : ts) {
			ids.add(task.getTaskID());
		}
		List<Task> tasks=new ArrayList<Task>();
		if(ids.size()>0){
			QueryRule queryRule = QueryRule.getInstance();
			queryRule.addIn("taskID", ids);
			queryRule.addAscOrder("taskID");
			tasks=super.find(Task.class, queryRule);
		}
		return tasks;
	}
	/**
	 * 更新密码
	 */
	public void updatePassword(Employe employe) {
		employeService.updatePassword(employe);
	}
	
	/**
	 * 获取4级机构 配送模块
	 * @param comCode
	 * @return
	 */
	public List<Company> findLevFourCom(String comCode) {
		return companyService.findLevFourCom(comCode);
	}
	
	/**
	 * 查询机构下的人员（未引入权限）配送模块
	 */
	public List<Employe> findUserByComCode(String comCode){
		return employeService.findUserByComCode(comCode);
	}

	public Company findCompanyByComCode(String comCode){
		Assert.hasText(comCode);
		return companyService.findCompanyByComCode(comCode);
	}
	

}
