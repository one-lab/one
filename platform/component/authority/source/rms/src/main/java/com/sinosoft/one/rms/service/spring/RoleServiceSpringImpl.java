package com.sinosoft.one.rms.service.spring;

import com.sinosoft.one.rms.model.service.CompanyModelInterface;
import ins.framework.cache.CacheManager;
import ins.framework.cache.CacheService;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.rms.model.Company;
import com.sinosoft.one.rms.model.Group;
import com.sinosoft.one.rms.model.GroupRole;
import com.sinosoft.one.rms.model.Role;
import com.sinosoft.one.rms.model.RoleDesignate;
import com.sinosoft.one.rms.model.RoleDesignateId;
import com.sinosoft.one.rms.model.RoleDesignateInfo;
import com.sinosoft.one.rms.model.RoleTask;
import com.sinosoft.one.rms.model.TaskAuth;
import com.sinosoft.one.rms.service.facade.CompanyServiceInterface;
import com.sinosoft.one.rms.service.facade.RoleService;

public class RoleServiceSpringImpl<T, E> extends GenericDaoHibernate<Role, String>
		implements RoleService {
	@Autowired
	private CompanyServiceInterface companyServiceInterface;
	
	private static CacheService cacheManager = CacheManager.getInstance("Role");
	

	public void addRoleByType(String comCode, String userCode, List<String> TaskIDs,
			String roleName, String des,String type) {
		Role role = new Role();
		StringBuffer sql = new StringBuffer();
		sql.append("from  TaskAuth t where  t.comCode='" + comCode
				+ "'or t.comCode='*' and t.task.taskID in (");
		for (String string : TaskIDs) {
			sql.append(" '" + string + "',");
		}
		sql.delete(sql.length() - 1, sql.length());
		sql.append(")");
		Query queryTaskAuth = getSession().createQuery(sql.toString());
		@SuppressWarnings("unchecked")
		List<TaskAuth> taskAuths = queryTaskAuth.list();
		role.setCreateUser(userCode);
		role.setOperateUser(userCode);
		role.setName(roleName);
		role.setDes(des);
		role.setComCode(comCode);
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
		if(type.toString().equals("default".toString()))
			role.setFlag("");
		if(type.toString().equals("all".toString()))
			role.setFlag("*");
		super.save(role);
		//默认指派角色操作
		RoleDesignate roleDesignate = new RoleDesignate();
		RoleDesignateId roleDesignateId = new RoleDesignateId();
		roleDesignateId.setRoleID(role.getRoleID());
		if(type.toString().equals("default".toString()))
			roleDesignateId.setComCode(comCode);
		if(type.toString().equals("all".toString()))
			roleDesignateId.setComCode("*");
		roleDesignate.setRole(role);
		roleDesignate.setId(roleDesignateId);
		roleDesignate.setCreateUser(userCode);
		roleDesignate.setOperateUser(userCode);
		roleDesignate.setCreateTime(date);
		roleDesignate.setOperateTime(date);
		super.save(roleDesignate);
		//操作默认用户组 默认类型的才操作
		if(type.toString().equals("default".toString()))
			editDefaultGroup(comCode, userCode, role);
		cacheManager.clearCache("comCodeRole");
	}
	
	/**
	 * 删除角色指派
	 */
	public void deleteRole(String roleId, String comCode) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("id.comCode", comCode);
		queryRule.addEqual("id.roleID", roleId);
		RoleDesignate roleDesignate = super.findUnique(RoleDesignate.class,
				queryRule);
		if (roleDesignate == null) {
			//异常
		}
		//删除指派时比较机构标志 如果相等则同时删除角色数据资源
		if(roleDesignate!=null)
			super.delete(roleDesignate);
		Role role=new Role();
		QueryRule queryRole = QueryRule.getInstance();
		queryRole.addEqual("roleID", roleId);
		role =super.findUnique(queryRole);
		if(role.getComCode().toString().equals(comCode.toString())){
			super.delete(role);
		}
		cacheManager.clearCache("comCodeRole");
	}
	/**
	 * 查询单个角色
	 */
	public Role findRoleById(String roleId) {
		return get(roleId);
	}
	
	/**
	 * 查询页面 查询角色
	 */
	public Page findRole(String comCode, String roleName, int pageNo,
			int pageSize) {
		String key = cacheManager.generateCacheKey("comCodeRole", comCode+roleName+pageNo+pageSize);
		Object result = cacheManager.getCache(key);
		if (result != null) {
			return (Page) result;
		}
		//先查询指派角色  根据指派获得角色ID
		List<RoleDesignate> roleDesignates=new ArrayList<RoleDesignate>();
		StringBuffer designSql = new StringBuffer();
		designSql.append("from RoleDesignate d where d.id.comCode='"+comCode+"' or d.id.comCode='*'");
		roleDesignates=super.findByHql(designSql.toString());
		List<String> roleids=new ArrayList<String>();
		for (Iterator<RoleDesignate> iterator = roleDesignates.iterator(); iterator.hasNext();) {
			RoleDesignate roled = (RoleDesignate) iterator.next();
			roleids.add(roled.getId().getRoleID());
		}
		Page page =new Page();
		
		if(roleids.size()>0){
			QueryRule queryRole=QueryRule.getInstance();
			queryRole.addEqual("isValidate", "1");
			
//			//如果输入名字查询
			queryRole.addIn("roleID", roleids);
			if(StringUtils.isNotBlank(roleName)){
				queryRole.addLike("name", "%"+roleName+"%");
			}
			queryRole.addEqual("isValidate", "1");
			queryRole.addDescOrder("createTime");
			page=super.find(queryRole, pageNo, pageSize);
		}
		cacheManager.putCache(key, page);
		return page;
	}
	/**
	 * 根据机构查询 角色指派
	 */
	public List<RoleDesignate> findRoleByCom(String comCode ) {
		QueryRule queryRule = QueryRule.getInstance();
		List<String> comCodes= new ArrayList<String>();
		comCodes.add(comCode);
		//查询*的（所有机构可见类型的角色）
		comCodes.add("*");
		queryRule.addIn("id.comCode", comCodes);
		queryRule.addDescOrder("createTime");
		return  super.find(RoleDesignate.class, queryRule );
	}
	/**
	 * 根据用户组查询关联的角色
	 */
	public Set<Role> findRoleByGroup(List<String> groupIDs ,String comCode) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addIn("groupID", groupIDs);
		List<Group> groups = super.find(Group.class, queryRule);
		if (groups == null) {
			//异常
		}
		Set<GroupRole> groupRoles = new HashSet<GroupRole>();
		for (Group group : groups) {
			groupRoles.addAll(group.getGroupRoles());
		}
		//根据机构获得指派的信息 取得roleID 过滤用户组关联的角色
		List<RoleDesignate> roleDesignates=new ArrayList<RoleDesignate>();
		if(StringUtils.isNotBlank(groupIDs.get(0))){
			QueryRule queryRole = QueryRule.getInstance();
			List<String> comCodes = new ArrayList<String>();
			comCodes.add(comCode);
			// 查询*的（所有机构可见类型的角色）
			comCodes.add("*");
			queryRole.addIn("id.comCode", comCodes);
			roleDesignates = super.find(RoleDesignate.class, queryRole);
		}
		List<String> roleids=new ArrayList<String>();
		for (RoleDesignate roleDesignate : roleDesignates) {
			roleids.add(roleDesignate.getId().getRoleID());
		}
//		//根据指派获得的ID过滤用户组角色  获得角色集合.
		Set<Role> roles = new HashSet<Role>();
		for (GroupRole groupRole : groupRoles){
			for (String roleid : roleids){
				if(groupRole.getRole().getRoleID().toString().equals(roleid.toString())){
					roles.add(groupRole.getRole());
				}
			}
		}
		return roles;
	}
	/**
	 * 指派页面 单独指派的方法
	 */
	public void roleDesignate(List<String> roleIDs, String comCode,String userCode) {
		//comCodes 以机构为维度操作指派
		
		StringBuffer roleIdSQL = new StringBuffer();
		// 以机构为维度删除该机构的指派从新添加
		roleIdSQL.append("select roleid from ge_rms_role_designate t where  t.comcode = ");
		roleIdSQL.append("'" + comCode + "'");
		//查询结果ID集合
		List<String> roldids=new ArrayList<String>();
		//需要删除的ID集合
		List<String> deleteRoldIDs=new ArrayList<String>();
		//需要指派的ID集合
		List<String> designateRoldIDs=new ArrayList<String>();
		roldids=getSession().createSQLQuery(roleIdSQL.toString()).list();
		roleIdSQL.setLength(0);
		//查询已经是全可见类型的角色 用于不做指派的角色ID
		roleIdSQL.append("select roleid from ge_rms_role_designate t where  t.comcode = '*'");
		List<String> alradyDesignateRoldids=new ArrayList<String>();
		alradyDesignateRoldids=getSession().createSQLQuery(roleIdSQL.toString()).list();
		roleIdSQL.setLength(0);
		//如果查询的ID没有包含在传入的ID中则删除这个ID在机构的指派 包括所有子机构
		for (String roleid : roldids) {
			if(!roleIDs.contains(roleid)){
				deleteRoldIDs.add(roleid);
			}
		}
		//如果传入的ID没有包含在查询出的ID中则添加指派
		for (String roleid : roleIDs) {
			if(!roldids.contains(roleid)){
				designateRoldIDs.add(roleid);
			}
		}
		//调用递归删除子机构的指派
		if(deleteRoldIDs.size()>0){
			List<String> comCodes=new ArrayList<String>();
			comCodes.add(comCode);
			iteraterComCode(comCodes, deleteRoldIDs);
		}
		//指派操做开始
		List<RoleDesignate> roleDesignates = new ArrayList<RoleDesignate>();
		for (String roleID : designateRoldIDs) {
			if(!alradyDesignateRoldids.contains(roleID.toString())){
				Role role = new Role();
				role = super.get(roleID);
				if (role != null) {
					// 如果不等于空 则进行指派操纵 否则不进行指派操作
					RoleDesignate roleDesignate = new RoleDesignate();
					RoleDesignateId roleDesignateId = new RoleDesignateId();
					roleDesignateId.setComCode(comCode);
					roleDesignateId.setRoleID(roleID);
					roleDesignate.setId(roleDesignateId);
					Date date = new Date();
					roleDesignate.setCreateTime(date);
					roleDesignate.setOperateTime(date);
					roleDesignate.setCreateUser(userCode);
					roleDesignate.setOperateUser(userCode);
					roleDesignate.setRole(role);
					roleDesignates.add(roleDesignate);
					super.save(roleDesignate);
					// 操作该机构的默认用户组
					role.setRoleDesignates(roleDesignates);
					// editRoleTask(comCode, role);
				}
				editDefaultGroup(comCode, userCode, role);
				cacheManager.clearCache("comCodeRole");
			}
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	public void updataRoleByIDAndType(String roleID, List<String> comCodes,String loginComCode,
			String userCode, List<String> TaskIDs, String roleName, String des,String type) {
		Role role = super.get(roleID);
		// 删除角色关联的功能
		StringBuffer deleteRoleTasksql = new StringBuffer();
		List<RoleDesignate> roleDesignates = new ArrayList<RoleDesignate>();
		deleteRoleTasksql.append("delete ge_rms_roletask t where t.roleID='"+roleID+"' and t.taskAuthid in (");
		deleteRoleTasksql.append(" select taskauthid from ge_rms_task_auth a where a.comCode='*' or a.comcode=");
		deleteRoleTasksql.append("'" + loginComCode + "')");
		getSession().createSQLQuery(deleteRoleTasksql.toString())
		.executeUpdate();
		// 查询功能集合,重新添加角色功能信息
		List<TaskAuth> taskAuths=new ArrayList<TaskAuth>();
		if(TaskIDs.size()>0){
			QueryRule queryTaskAuth=QueryRule.getInstance();
			queryTaskAuth.addIn("comCode", loginComCode,"*");
			queryTaskAuth.addIn("task.taskID", TaskIDs);
			taskAuths =super.find(TaskAuth.class, queryTaskAuth);
		}
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
		if(type.toString().equals("default")){
			role.setFlag("");
		}
		if(type.toString().equals("all")){
			role.setFlag("*");
		}
		super.update(role);
		//判断修改的角色类型 当改成默认类型"default"时
		if(type.toString().equals("default")){
			//修改类型
			StringBuffer sql = new StringBuffer();
			sql.append("update ge_rms_role_designate t set  t.comcode='"+loginComCode+"' where  t.comcode='*'  and t.roleid ='"+roleID+"'");
			getSession().createSQLQuery(sql.toString()).executeUpdate();
			// comCodes为选中的机构 不 delete comCodes的机构指派
			sql.setLength(0);
			sql.append("delete ge_rms_role_designate t where t.comcode!='"+loginComCode+"' and t.roleid ='"+roleID+"'");
			//删除不指派的用户组角色数据
			StringBuffer deleteGroupRoleSql = new StringBuffer();
			deleteGroupRoleSql.append("delete ge_rms_grouprole gr where gr.groupid  in (select groupid from ge_rms_group where comcode!='"+loginComCode+"'");
			if (comCodes.size() > 0) {
				List<String >alradyComCodes=new ArrayList<String>();
				for (RoleDesignate roleDesignate : role.getRoleDesignates()) {
					alradyComCodes.add(roleDesignate.getId().getComCode().toString());
				}
				sql.append(" and t.comcode not in (");
				deleteGroupRoleSql.append("and comCode not in (");
				for (String comCode : comCodes) {
					sql.append("'" + comCode + "',");
					deleteGroupRoleSql.append("'" + comCode + "',");
					//不包含的表示新增的需要新增指派
					if (!alradyComCodes.contains(comCode.toString())) {
						RoleDesignate roleDesignate = new RoleDesignate();
						RoleDesignateId roleDesignateId = new RoleDesignateId();
						roleDesignateId.setComCode(comCode);
						roleDesignateId.setRoleID(roleID);
						roleDesignate.setId(roleDesignateId);
						roleDesignate.setCreateTime(date);
						roleDesignate.setOperateTime(date);
						roleDesignate.setCreateUser(userCode);
						roleDesignate.setOperateUser(userCode);
						roleDesignate.setRole(role);
						roleDesignates.add(roleDesignate);
						super.save(roleDesignate);
					}
					// 操作当前循环的机构默认用户组
					editDefaultGroup(comCode, userCode, role);
				}
				sql.delete(sql.length() - 1, sql.length());
				sql.append(")");
				//删除不指派的用户组角色数据
				
				deleteGroupRoleSql.delete(deleteGroupRoleSql.length() - 1, deleteGroupRoleSql.length());
				deleteGroupRoleSql.append(")");
			}
			getSession().createSQLQuery(sql.toString()).executeUpdate();	
			deleteGroupRoleSql.append(") and gr.roleid='"+roleID+"'");
			getSession().createSQLQuery(deleteGroupRoleSql.toString()).executeUpdate();
		}
		//判断修改的角色类型 当改成全可见类型"all"时
		if(type.toString().equals("all")){
			StringBuffer sql = new StringBuffer();
			//修改类型
			sql.append("update ge_rms_role_designate t set t.comcode='*' where (t.comcode='"+loginComCode+"' or t.comcode='*' ) and t.roleid ='"+roleID+"'");
			getSession().createSQLQuery(sql.toString()).executeUpdate();
		}
		cacheManager.clearCache("comCodeRole");
	}
	
	
	/**
	 * 根据角色查询已指派到的信息
	 */
	
	public List<RoleDesignateInfo> findComByRoleID(String RoleID, String comCode) {
		List<RoleDesignateInfo> roleDesignateInfos = new ArrayList<RoleDesignateInfo>();
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("id.roleID", RoleID);
		List<RoleDesignate> designates = super.find(RoleDesignate.class,queryRule);
		//获取子机构代码 /交予companyServiceInterface  
		List<String>  comCodes= companyServiceInterface.findAllNextSubComCodesByComCode(comCode) ;
		for (RoleDesignate roleDesignate : designates) {
			//从指派的角色中过滤下级机构代码
			if(roleDesignate.getId().getComCode().toString().equals("*")){
				RoleDesignateInfo roleDesignateInfo = new RoleDesignateInfo();
				roleDesignateInfo.setRole(roleDesignate.getRole());
				roleDesignateInfo.setType("*");
				roleDesignateInfo.setComCode("*");
				roleDesignateInfo.setCreateUser(roleDesignate.getCreateUser());
				roleDesignateInfo.setCreateTime(roleDesignate.getCreateTime());
				roleDesignateInfos.add(roleDesignateInfo);
			}else{
				for (String  cCode : comCodes) {
					if (roleDesignate.getId().getComCode().toString().equals(cCode.toString())) {
						RoleDesignateInfo roleDesignateInfo = new RoleDesignateInfo();
						roleDesignateInfo.setRole(roleDesignate.getRole());
						roleDesignateInfo.setComCode(cCode);
                        CompanyModelInterface cmi =  companyServiceInterface.findCompanyByComCode(cCode);
                        String comCName = cmi.getComCName();
						roleDesignateInfo.setComCName(comCName);
						roleDesignateInfo.setCreateUser(roleDesignate.getCreateUser());
						roleDesignateInfo.setCreateTime(roleDesignate.getCreateTime());
						roleDesignateInfos.add(roleDesignateInfo);
					}
				}
			}
		}
		return roleDesignateInfos;
	}
	
	//查询机构下用户组 如果没有 创建默认用户组 并关联当前角色 
	void editDefaultGroup(String comCode,String userCode,Role role){
		QueryRule queryRule =QueryRule.getInstance();
		queryRule.addEqual("comCode", comCode);
		queryRule.addEqual("name", "默认用户组");
		queryRule.addEqual("isValidate", "1");
		Group group= super.findUnique(Group.class, queryRule);
		if(group==null){
			//如果该机构没有用户组则先建立默认用户组
			group=new Group();
			group.setComCode(comCode);
			group.setName("默认用户组");
			group.setIsValidate("1");
			Date date = new Date();
			group.setCreateTime(date);
			group.setOperateTime(date);
			group.setCreateUser(userCode);
			group.setOperateUser(userCode);
			super.save(group);
		}
		//获取关联表是否为空
		if (role != null) {
			QueryRule queryGroupRole =QueryRule.getInstance();
			queryGroupRole.addEqual("group.groupID", group.getGroupID());
			List<GroupRole> groupRoles=super.find(GroupRole.class, queryGroupRole);
			// 如果没有组-角色的关联表则建立关联表数据
			if (groupRoles.size() == 0) {
				// 为空则建立关联
				List<GroupRole> groupRols = new ArrayList<GroupRole>();
				GroupRole groupRole = new GroupRole();
				groupRole.setGroup(group);
				groupRole.setRole(role);
				groupRole.setIsValidate("1");
				groupRols.add(groupRole);
				group.setGroupRoles(groupRols);
				super.update(group);
			} else {
				// 如果不为空 则循环判断是否有相等的 则不再新建
				int i = 0;
				for (GroupRole groupRole : groupRoles) {
					if (!groupRole.getRole().getRoleID().toString()
							.equals(role.getRoleID())) {
						i++;
					}
				}
				if (i == groupRoles.size()) {
					GroupRole groupRole = new GroupRole();
					groupRole.setGroup(group);
					groupRole.setRole(role);
					groupRole.setIsValidate("1");
					groupRoles.add(groupRole);
					group.setGroupRoles(groupRoles);
					super.update(group);
				}
			}
		}
	}
	
	
	//操作角色功能的关联
	@SuppressWarnings("unchecked")
	void editRoleTask(String comCode,Role role){
		//获取创建这个角色时所关联的功能id
		StringBuffer taskIDSQL=new StringBuffer();
		taskIDSQL.append("  select taskid FROM ge_rms_task_auth where taskauthid in (" );
		taskIDSQL.append(" select taskauthid from ge_rms_roletask g where g.isvalidate='1' and g.roleid='"+role.getRoleID()+"' and g.taskauthid in (");
		taskIDSQL.append(" select TASKAUTHID from ge_rms_task_auth where comcode='"+role.getComCode()+"'))");
		List<String> taskIDs=new ArrayList<String>();
		taskIDs=(List<String>)getSession().createSQLQuery(taskIDSQL.toString()).list();
		//先删除原有关联
		List<RoleTask> roleTaskss = new ArrayList<RoleTask>();
		StringBuffer sql=new StringBuffer();
		sql.append("delete ge_rms_roletask t where t.roleid='"+role.getRoleID()+"' and  t.taskAuthid in (");
		sql.append(" select taskauthid from ge_rms_task_auth a where a.comcode=");
		sql.append("'" + comCode + "')");
		getSession().createSQLQuery(sql.toString()).executeUpdate();
		//与当前这个机构的授权中的功能比较过滤
		List<TaskAuth> taskAuths = new ArrayList<TaskAuth>();
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("comCode", comCode);
		queryRule.addIn("task.taskID", taskIDs);
		taskAuths = super.find(TaskAuth.class, queryRule);
		//为当前机构建立角色与授权的关联//重新建立关联
		for (TaskAuth taskAuth : taskAuths) {
			RoleTask roleTask = new RoleTask();
			roleTask.setIsValidate("1");
			roleTask.setTaskAuth(taskAuth);
			roleTask.setRole(role);
			roleTaskss.add(roleTask);
		}
		role.setRoleTasks(roleTaskss);
		super.update(role);
	}
	
	//递归删除操作
	@SuppressWarnings("unchecked")
	void iteraterComCode(List<String> comCodes ,List<String> roleids){
		// 每次执行 先进行删除操作
		StringBuffer delteDesignatSQL = new StringBuffer();
		StringBuffer delteGroupRoleSQL = new StringBuffer();
		delteDesignatSQL.append("delete ge_rms_role_designate where  roleid in (");
		delteGroupRoleSQL.append("delete ge_rms_grouprole gr where gr.roleid in(");
		for (String string : roleids) {
			delteDesignatSQL.append(" '" + string + "',");
			delteGroupRoleSQL.append(" '" + string + "',");
		}
		delteDesignatSQL.delete(delteDesignatSQL.length() - 1,delteDesignatSQL.length());
		delteDesignatSQL.append(")");
		delteDesignatSQL.append("and comcode in(");
		delteGroupRoleSQL.delete(delteGroupRoleSQL.length() - 1,delteGroupRoleSQL.length());
		delteGroupRoleSQL.append(")");
		delteGroupRoleSQL.append("and gr.groupid in(select groupid from ge_rms_group where comcode in (");
		int i=0;
		for ( i = 0; i < comCodes.size() ; i++) {
			delteDesignatSQL.append(" '" + comCodes.get(i) + "',");
			delteGroupRoleSQL.append(" '" + comCodes.get(i) + "',");
			//每如果到了1000则用OR处理
			if(i>=999&&i%999==0){
				delteDesignatSQL.delete(delteDesignatSQL.length() - 1,delteDesignatSQL.length());
				delteDesignatSQL.append(")");
				delteDesignatSQL.append(" or comcode in(");
				delteGroupRoleSQL.delete(delteDesignatSQL.length() - 1,delteDesignatSQL.length());
				delteGroupRoleSQL.append(")");
				delteGroupRoleSQL.append(" or comcode in(");
			}
		}
		delteDesignatSQL.delete(delteDesignatSQL.length() - 1,	delteDesignatSQL.length());
		delteDesignatSQL.append(")");
		delteGroupRoleSQL.delete(delteGroupRoleSQL.length() - 1,	delteGroupRoleSQL.length());
		delteGroupRoleSQL.append("))");
		getSession().createSQLQuery(delteDesignatSQL.toString()).executeUpdate();
		getSession().createSQLQuery(delteGroupRoleSQL.toString()).executeUpdate();
		//删除所有已经指派的角色关联到的用户组中的记录
		delteDesignatSQL.setLength(0);
		delteGroupRoleSQL.setLength(0);
		// 然后进行查询下一级机构
		//交予companyServiceInterface
		List<String> subcomCodes = companyServiceInterface.findComCodebySuperComCode(comCodes);
		//递归的判断点
		if (subcomCodes.size() > 0) {
			iteraterComCode(subcomCodes, roleids);
		}
	}

}
