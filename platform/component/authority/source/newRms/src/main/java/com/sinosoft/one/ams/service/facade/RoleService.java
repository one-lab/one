package com.sinosoft.one.ams.service.facade;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.sinosoft.one.ams.model.Role;
import com.sinosoft.one.ams.model.RoleDesignate;
import com.sinosoft.one.ams.model.RoleDesignateInfo;
import com.sinosoft.one.ams.model.Task;
import com.sinosoft.one.ams.utils.uiutil.Gridable;


@Service
public interface RoleService {
	
	
	//查询角色信息
	public Role findRoleById(String roleId);
	
	//根据角色ID查询角色关联的功能
	public List<Task> findTaskByRole(String roleId);
	
	//根据机构查询所有可用的功能
	public List<Task> findTaskByComCode(String comCode);
	
	//查询机构下所有可见的角色
	public Page<Role> findRole(String comCode,String name,Pageable pageable);

	public Page<RoleDesignateInfo> findRoleDesignate(String superComCode ,String comCode,Pageable pageable);
	
	//根据用户组ID查询相应的角色
	public List<Role> findRoleByGroupId(String groupId,String comCode);
	//更新角色
	public void updateRole(String roleid,String comCode,String userCode,String name,String des,String roleTpe,List<String> taskids);
	
	public void addRole(String comCode,String userCode,String name,String des,String roleTpe,List<String> taskids);
	
	public void deleteRole(String roleId, String comCode);
	
	public void designateRole(String roleId, String comCode);
	
}
