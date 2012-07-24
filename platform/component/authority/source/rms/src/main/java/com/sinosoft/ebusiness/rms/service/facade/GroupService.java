package com.sinosoft.ebusiness.rms.service.facade;

import ins.framework.common.Page;

import java.util.List;

import com.sinosoft.ebusiness.rms.model.Group;

public interface GroupService {

	/**
	 * 添加角色
	 * @param role 角色对象
	 * @param taskCodes 关联的功能代码集合
	 */
	public void addGroup(String userCode,String comCode,String groupName,String des,
			List<String> roleIDs);

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
	 * 主键查询用户组
	 * @param groupId
	 * @return
	 */
	public Group findGroupByID(String groupId);
	
	/**
	 * 查询用户所在的用户组组
	 * @param userCode
	 * @return
	 */
	public List<Group> findGroupByUser(String userCode);
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
	 * 删除用户组
	 * @param GroupId
	 */
	public void deleteGroup(String GroupId);
	
	/**
	 * 查询用户组下成员(根据类型)
	 * @param groupId
	 * @param Type 0-5
	 * @param isValidate 0/1
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public Page findEmployeByGroupType( String Type,String loginComCode,String userName,String comCode,String comCName,String isValidate,int pageSize,int pageNo);

	public Page findNEmployeByGroup(String groupId, String comCode, String userName,String usCode,int pageSize,int pageNo);
}
