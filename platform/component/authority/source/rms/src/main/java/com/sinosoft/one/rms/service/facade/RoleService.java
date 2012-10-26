package com.sinosoft.one.rms.service.facade;

import ins.framework.common.Page;

import java.util.List;
import java.util.Set;

import com.sinosoft.one.rms.model.Role;
import com.sinosoft.one.rms.model.RoleDesignate;
import com.sinosoft.one.rms.model.RoleDesignateInfo;

public interface RoleService {

	/**
	 *  * 添加角色(角色的可见性类型方式)
	 * @param comCode
	 * @param userCode
	 * @param TaskIDs
	 * @param roleName
	 * @param des
	 * @param type角色的可见性类型 （默认可见类型、全部机构可见类型）
	 */
	public void addRoleByType(String comCode, String userCode, List<String> TaskIDs,String roleName, String des,String type);
	
	/**\
	 * 删除角色
	 * @param roleId
	 * @param comCode
	 */
	public void deleteRole(String roleId,String comCode);
	
	/**
	 * 根据ID查询单个角色
	 * @param roleId
	 * @return
	 */
	public Role findRoleById(String roleId);
	
	/**
	 * 查询机构可见角色（查询页面查询操作）
	 * @param comCode
	 * @param name
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page findRole(String comCode,String  roleName, int pageNo, int pageSize);
	
	/**
	 * 查询机构下角色指派（指派页面）
	 * @param comCode
	 * @return
	 */
	public List<RoleDesignate> findRoleByCom(String comCode );
	
	/**
	 * 查询用户组关联的的角色(人员配置页面)
	 * @param groupIDs
	 * @param comCode
	 * @return
	 */
	public Set<Role> findRoleByGroup(List<String> groupIDs ,String comCode);
	
	/**
	 * 角色指派操作（）
	 * @param roleIDs
	 * @param comCodes
	 * @param userCode
	 */
	public void roleDesignate(List<String> roleIDs, String comCode,String userCode);
	
	
	/**
	 * 根据角色查询指派到的机构 及指派信息
	 * @param RoleID
	 * @param comCode
	 * @return
	 */
	public  List<RoleDesignateInfo> findComByRoleID(String RoleID,String comCode);

	
	/**
	 *  修改角色(角色的可见性类型方式)
	 * @param RoleID
	 * @param comCode
	 * @param logingComCode
	 * @param userCode
	 * @param TaskIDs
	 * @param roleName
	 * @param des
	 * @param type角色的可见性类型 （默认可见类型、全部机构可见类型）
	 */
	public void updataRoleByIDAndType(String roleID, List<String> comCodes,String loginComCode,
			String userCode, List<String> TaskIDs, String roleName, String des,String type);
}
