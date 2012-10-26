package com.sinosoft.one.rms.service.facade;

import ins.framework.common.Page;

import java.util.List;

import com.sinosoft.one.rms.model.Group;

public interface GroupService {

	
	/**
	 * 添加角色
	 * @param role 角色对象
	 * @param taskCodes 关联的功能代码集合
	 */
	public void saveGroup(String userCode,String comCode,String groupName,String des,
			List<String> roleIDs);

	/**
	 * 更新用户组信息
	 * @param userCode
	 * @param comcode
	 * @param groupName
	 * @param Des
	 * @param RoleIDs
	 * @return
	 */
	public void updataGroup(String groupID,String userCode,String comcode,String groupName,String Des,List<String> RoleIDs);
   
	
	/**
	 * 主键查询用户组
	 * @param groupId
	 * @return
	 */
	public Group findGroupByID(String groupId);
	
	
	/**
	 * 查询用户组（comCode默认条件,名字查询,查询页面) 
	 * @param name
	 * @param comCode
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page findGroup(String  name,String comCode, int pageNo, int pageSize);
	
	
	
	/**
	 * 查询机构下角色列表(人员配置)
	 * @param comCode
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Group> findGroupByCom(String comCode);
	
	/**
	 * 删除用户组下的组成员
	 * @param userCode
	 * @param groupID
	 */
	public void deleteUserGroupByID(String userCode,String groupID);
	
	
	
	/**
	 * 查询用户组下的成员
	 * @param groupId
	 * @return
	 */
	public Page findEmployeByGroup(String groupId, String comCode, String userName,String usCode,int pageSize,int pageNo);
	
	

	
	
	/**
	 * 查询用户所在的用户组组
	 * @param userCode
	 * @return
	 */
	public List<Group> findGroupByUser(String userCode);
	
	/**
	 * 删除用户组
	 * @param GroupId
	 */
	public void deleteGroup(String GroupId);
	
	/**
	 * 查询未在用户组中的用户
	 * @param groupId
	 * @param comCode
	 * @param userName
	 * @param usCode
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public Page findNEmployeByGroup(String groupId, String comCode, String userName,String usCode,int pageSize,int pageNo);
	
	/**
	 * 校验用户组名是否重复
	 * @param groupName
	 * @return
	 */
	public boolean checkGroupName(String groupName);
	
	/**
	 * 添加用户组用户
	 * @param userCode
	 * @param comCode
	 * @param groupId
	 */
	public void addGroupUser(String userCode, String comCode,String groupId);
}
