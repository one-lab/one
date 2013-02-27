package com.sinosoft.one.ams.service.facade;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sinosoft.one.ams.model.Group;
import com.sinosoft.one.ams.model.Role;
import com.sinosoft.one.uiutil.Gridable;

@Service
public interface GroupService {
	
	/**
	 * 查询用户组
	 * 
	 * @param gridable
	 * @param comCode
	 * @param name
	 * @param pageable
	 * @return
	 */
	public Gridable<Group> getGroupGridable(Gridable<Group> gridable,String comCode,String name,Pageable pageable);
	
	/**
	 * 根据用户组ID查询用户组
	 * @param groupId
	 * @return
	 */
	public Group findGroupById(String groupId);
	
	/**
	 * 根据用户组ID查询角色
	 * @param gridable
	 * @param groupId
	 * @param comCode
	 * @param pageable
	 * @return
	 */
	public Gridable<Role> getRoleGridableByGroupId(Gridable<Role> gridable,String groupId,String comCode,Pageable pageable);
	
	public void updateGroup(String groupId,String name,String groupType,List<String> roleIds,String des,String comCode,String userCode);
	
	/**
	 * 添加用户组
	 * 
	 * @param name
	 * @param groupType
	 * @param roleIds
	 * @param des
	 * @param comCode
	 * @param userCode
	 */
	
	public void addGroup(String name,String groupType,List<String> roleIds,String des,String comCode,String userCode);
	
	/**
	 * 根据机构Id，查询机构的用户组
	 * 
	 * @param comCode
	 * @return
	 */
	public List<Group> findGroupByComCode(String comCode);
	
	/**
	 * 根据机构Id，查询机构的用户组,并对已引入用户的组进行标记
	 * 
	 * @param comCode
	 * @param userCode
	 * @return
	 */
	public List<Group> findGroupByComCode(String comCode,String userCode);
	
	/**
	 * 根据用户组ID查询用户组
	 * 
	 * @param groupIds
	 * @return
	 */
	public List<Group> findGroupById(List<String> groupIds);
	
	/**
	 * 根据用户组ID删除用户组
	 * 
	 * @param groupIds
	 * @return
	 */
	public boolean deleteGroupById(String groupIds);
}
