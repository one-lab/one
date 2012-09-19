package com.sinosoft.one.rms.service.picc;

import java.util.List;

public interface RoleService {

	/**
	 * 添加角色（不操作默认用户组）新
	 * @param role 角色对象
	 * @param taskCodes 关联的功能代码集合
	 */
	public void addRoleNoDefGroup(String comCode,String userCode,List<String> TaskIDs,String roleName,String des);
	
	/**
	 * 更新角色 (不操作默认用户组，不操作指派)新
	 * @param roleID
	 * @param loginComCode
	 * @param userCode
	 * @param TaskIDs
	 * @param roleName
	 * @param des
	 */
	public void updataRoleByIdNoDefGroup(String roleID,String loginComCode,
			String userCode, List<String> TaskIDs, String roleName, String des);
	
	
}
