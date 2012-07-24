
package com.sinosoft.ebusiness.rms.service.spring;

import ins.framework.cache.CacheManager;
import ins.framework.cache.CacheService;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;

import com.sinosoft.ebusiness.rms.model.Employe;
import com.sinosoft.ebusiness.rms.model.Group;
import com.sinosoft.ebusiness.rms.model.GroupRole;
import com.sinosoft.ebusiness.rms.model.Role;
import com.sinosoft.ebusiness.rms.model.UserGroup;
import com.sinosoft.ebusiness.rms.model.UserPower;
import com.sinosoft.ebusiness.rms.service.facade.GroupService;

public class GroupServiceSpringImpl<T,E> extends GenericDaoHibernate<Group, String> implements GroupService{

	/**
	 * 初始缓存实例
	 */
	private static CacheService cacheManager = CacheManager.getInstance("Group");
	
	/**
	 * 增加用户组
	 */
	public void addGroup(String userCode,String comCode,String groupName,String des,
			List<String> roleIDs) {
		Group group =new Group();
		group.setComCode(comCode);
		group.setName(groupName);
		group.setDes(des);
		group.setIsValidate("1");
		List<GroupRole> groupRoles=new ArrayList<GroupRole>();
		//根据ROLEID处理中间对象
		for (String string : roleIDs) {
			GroupRole groupRole=new GroupRole();
			Role role=new Role();
			role.setRoleID(string);
			groupRole.setRole(role);
			groupRole.setIsValidate("1");
			groupRole.setGroup(group);
			groupRoles.add(groupRole);
		}
		group.setGroupRoles(groupRoles);
		group.setCreateUser(userCode);
		group.setOperateUser(userCode);
		Date date=new Date();
		group.setCreateTime(date);
		group.setOperateTime(date);
		super.save(group);
		cacheManager.clearCache("comCodeGroup");
	}
	
	
	/**
	 * 删除用户组下的组成员
	 */
	public void deleteUserGroupByID(String userCode, String groupID) {
		StringBuffer sql=new StringBuffer();
		sql.append("delete ge_rms_usergroup t where t.groupid='"+groupID+"' and t.usercode='"+userCode+"' ");
		getSession().createSQLQuery(sql.toString()).executeUpdate();
		cacheManager.clearCache("userGroup");
	}
	/**
	 * 查询用户组下的成员
	 */
	@SuppressWarnings("unchecked")
	public Page findEmployeByGroup(String groupId, String comCode, String userName,String usCode,int pageSize,int pageNo) {
		List<UserGroup>userGroups=new ArrayList<UserGroup>();
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("groupID", groupId);
		queryRule.addEqual("isValidate", "1");
		Group group=new Group();
		group=super.findUnique(queryRule);
		Page page=new Page();
		if(group!=null){
			//获取用户组下的userCode;
			userGroups=group.getUserGroups();
			List<String> userCodes=	new ArrayList<String>();
			for (UserGroup userGroup : userGroups) {
				userCodes.add(userGroup.getUserCode());
			}
			//根据引入的userPower获得userCode 过滤userCodes集合获得机构下的usercode
			QueryRule queryRuleUserPower = QueryRule.getInstance();
			queryRuleUserPower.addEqual("comCode", comCode);
			queryRuleUserPower.addEqual("isValidate", "1");
			List<UserPower> userPowers =new ArrayList<UserPower>();
			userPowers=	super.find(UserPower.class, queryRuleUserPower);
			List<String> onGroupUserCode=new ArrayList<String>();
			for (UserPower userPower : userPowers) {
				for (String userCode : userCodes) {
					if(userCode.toString().equals(userPower.getUserCode().toString())){
						onGroupUserCode.add(userCode);
					}
				}
			}
			//查询员工对象集合
			if(onGroupUserCode.size()>0){
				QueryRule queryRuleUserCode=QueryRule.getInstance();
				queryRuleUserCode.addIn("userCode", onGroupUserCode);
				if(StringUtils.isNotEmpty(userName))
					queryRuleUserCode.addLike("userName", "%"+userName+"%");
				if(StringUtils.isNotEmpty(usCode))
					queryRuleUserCode.addLike("userCode", "%"+usCode+"%");
				page = super.find(Employe.class,queryRuleUserCode, pageNo, pageSize);
//				StringBuffer hql = new StringBuffer();
//				hql.append("from Employe e where e.userCode in ( ");
//				for (String string : onGroupUserCode) {
//					hql.append("'" + string + "',");
//				}
//				hql.delete(hql.length() - 1, hql.length());
//				hql.append(")");
//				page = super.findByHql(hql.toString(), pageNo, pageSize);
			}
		}
		return page;
	}
	/**
	 * 查询未添加到用户组下的成员
	 */
	@SuppressWarnings("unchecked")
	public Page findNEmployeByGroup(String groupId, String comCode, String userName,String usCode,int pageSize,int pageNo) {
		List<UserGroup>userGroups=new ArrayList<UserGroup>();
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("groupID", groupId);
		queryRule.addEqual("isValidate", "1");
		Group group=new Group();
		group=super.findUnique(queryRule);
		Page page=new Page();
		if(group!=null){
			//获取用户组下的userCode;
			userGroups=group.getUserGroups();
			List<String> userCodes=	new ArrayList<String>();
			for (UserGroup userGroup : userGroups) {
				userCodes.add(userGroup.getUserCode());
			}
			//根据引入的userPower获得userCode 过滤userCodes集合获得机构下的usercode
			QueryRule queryRuleUserPower = QueryRule.getInstance();
			queryRuleUserPower.addEqual("comCode", comCode);
			queryRuleUserPower.addEqual("isValidate", "1");
			List<UserPower> userPowers =new ArrayList<UserPower>();
			userPowers=	super.find(UserPower.class, queryRuleUserPower);
			List<String> onGroupUserCode=new ArrayList<String>();
			for (UserPower userPower : userPowers) {
				for (String userCode : userCodes) {
					if(userCode.toString().equals(userPower.getUserCode().toString())){
						onGroupUserCode.add(userCode);
					}
				}
			}
			//查询员工对象集合
			if(onGroupUserCode.size()>0){
				StringBuffer sql = new StringBuffer();
				sql.append(" userCode not in ( ");
				for (String string : onGroupUserCode) {
					sql.append("'" + string + "',");
				}
				sql.delete(sql.length() - 1, sql.length());
				sql.append(")");
				QueryRule queryRuleUserCode=QueryRule.getInstance();
				queryRuleUserCode.addSql(sql.toString());
				if(StringUtils.isNotEmpty(userName))
					queryRuleUserCode.addLike("userName", "%"+userName+"%");
				if(StringUtils.isNotEmpty(usCode))
					queryRuleUserCode.addLike("userCode", "%"+usCode+"%");
				queryRuleUserCode.addEqual("company.comCode", comCode);
				page = super.find(Employe.class,queryRuleUserCode, pageNo, pageSize);
			
//				page = super.findByHql(hql.toString(), pageNo, pageSize);
			}
		}
		return page;
	}
	
	/**
	 * 查询用户组（comCode默认条件,名字查询,查询页面) 
	 */
	public Page findGroup(String groupName, String comCode, int pageNo, int pageSize) {
		String key = cacheManager.generateCacheKey("comCodeGroup", comCode+groupName);
		Object result = cacheManager.getCache(key);
		if (result != null) {
			return (Page) result;
		}
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("comCode", comCode);
		if(StringUtils.isNotBlank(groupName))
			queryRule.addLike("name", "%"+groupName+"%");
		queryRule.addEqual("isValidate", "1");
		queryRule.addDescOrder("createTime");
		Page page=super.find(Group.class,queryRule, pageNo, pageSize);
		cacheManager.putCache(key, page);
		return page;
	}
	
	/**
	 * 查询机构下用户组列表(人员配置)
	 */
	public List<Group> findGroupByCom(String comCode) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("comCode", comCode);
		queryRule.addEqual("isValidate", "1");
		queryRule.addDescOrder("createTime");
		return super.find(queryRule);
	} 
	
	/**
	 * 获取单个用户组对象
	 */
	public Group findGroupByID(String groupId) {
		return super.get(groupId);
	}
	
	/**
	 * 查询用户所在的用户组
	 */
	@SuppressWarnings("unchecked")
	public List<Group> findGroupByUser(String userCode) {
		String key = cacheManager.generateCacheKey("Groups", userCode);
		Object result = cacheManager.getCache(key);
		if (result != null) {
			return (List<Group>) result;
		}
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("userCode", userCode);
		queryRule.addEqual("isValidate", "1");
		List<UserPower> userPowers=new ArrayList<UserPower>();
		userPowers=	super.find(UserPower.class, queryRule);
		List<Group> groups=new ArrayList<Group>();
		if(userPowers!=null){
			for (UserPower userPower : userPowers) {
				List<UserGroup> userGroups=userPower.getUserGroups();
				if(userGroups!=null){
					for (UserGroup userGroup : userGroups) {
						groups.add(userGroup.getGroup());
					}
				}
			}
		}
		cacheManager.putCache(key, groups);
		return groups;
	}
	
	/**
	 * 更新用户组信息
	 */
	public void updataGroup(String groupID,String userCode, String comCode, String groupName,
			String Des, List<String> RoleIDs) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("comCode", comCode);
		queryRule.addEqual("groupID",groupID);
		queryRule.addEqual("isValidate", "1");
		Group group=super.findUnique(queryRule);
		if(group==null||group.getName().toString().equals("默认用户组")){
			//异常
		}
		group.setName(groupName);
		group.setDes(Des);
		super.deleteAll(group.getGroupRoles());
		List<GroupRole> groupRoles=new ArrayList<GroupRole>();
		for (String roleid : RoleIDs) {
			GroupRole groupRole=new GroupRole();
			Role role=new Role();
			role.setRoleID(roleid);
			groupRole.setGroup(group);
			groupRole.setRole(role);
			groupRole.setIsValidate("1");
			groupRoles.add(groupRole);
		}
		group.setGroupRoles(groupRoles);
		super.update(group);
		cacheManager.clearCache("comCodeGroup");
	}
	
	/**
	 * 删除用户组
	 */
	public void deleteGroup(String GroupId) {
		Group group = new Group();
		group=	super.findUnique("groupID", GroupId);
		if(group.getName().toString().equals("默认用户组")){
			//异常
		}else{
			super.delete(group);
			cacheManager.clearCache("comCodeGroup");
			cacheManager.clearCache("Groups");
			cacheManager.clearCache("userGroup");
		}
	}

	public Page findEmployeByGroupType( String Type,String loginComCode,String userName,String comCode,String comCName,String isValidate,int pageSize,int pageNo) {
		return null;
	}


}	
 