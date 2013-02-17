package com.sinosoft.one.ams.service.facade;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sinosoft.one.ams.model.Role;
import com.sinosoft.one.ams.model.RoleDesignateInfo;
import com.sinosoft.one.ams.model.Task;

@Service
public interface RoleService {
	
	/**
	 * 查询角色信息
	 * 
	 * @param roleId
	 * @return
	 */
	public Role findRoleById(String roleId);
	
	/**
	 * 根据角色ID查询角色关联的功能
	 * 
	 * @param roleId
	 * @return
	 */
	public List<Task> findTaskByRole(String roleId);
	
	/**
	 * 根据机构查询所有可用的功能
	 * @param comCode
	 * @return
	 */
	public List<Task> findTaskByComCode(String comCode);
	
	/**
	 * 查询机构下所有可见的角色
	 * 
	 * @param comCode
	 * @param name
	 * @param pageable
	 * @return
	 */
	public Page<Role> findRole(String comCode,String name,Pageable pageable);

	/**
	 * 根据父机构ID查询角色
	 * 
	 * @param superComCode
	 * @param comCode
	 * @param pageable
	 * @return
	 */
	public Page<RoleDesignateInfo> findRoleDesignate(String superComCode ,Pageable pageable);
	
	/**
	 * 根据用户组ID查询相应的角色
	 * 
	 * @param groupId
	 * @param comCode
	 * @return
	 */
	public List<Role> findRoleByGroupId(String groupId,String comCode);

	/**
	 * 更新角色
	 * 
	 * @param roleid
	 * @param comCode
	 * @param userCode
	 * @param name
	 * @param des
	 * @param roleTpe
	 * @param taskids
	 */
	public void updateRole(String roleid,String comCode,String userCode,String name,String des,String roleTpe,List<String> taskids);
	
	/**
	 * 新增角色
	 * 
	 * @param comCode
	 * @param userCode
	 * @param name
	 * @param des
	 * @param roleTpe
	 * @param taskids
	 */
	public void addRole(String comCode,String userCode,String name,String des,String roleTpe,List<String> taskids);
	
	/**
	 * 删除角色指派
	 * 
	 * @param roleId
	 * @param comCode
	 */
	public void deleteRole(String roleId, String comCode);
	
	/**
	 * 根据机构Id查询角色ID
	 * 
	 * @param comCode
	 * @return
	 */
	public List<String> findRoleIdByComCode(String comCode);
	
	/**
	 * 保存机构的角色
	 * 
	 * @param comCode
	 * @param roleIdStr
	 */
	public void saveRoleDesignate(String comCode,String roleIdStr);
}
