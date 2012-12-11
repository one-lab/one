package com.sinosoft.one.ams.service.facade;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.sinosoft.one.ams.model.GeRmsRole;
import com.sinosoft.one.ams.model.GeRmsTask;
import com.sinosoft.one.ams.utils.uiutil.Gridable;


@Service
public interface RoleService {
	
	Page<GeRmsRole> findRoleByName(String name, Pageable pageable);
	
	Page<GeRmsRole> findAll(Pageable pageable);
	
	public Page<GeRmsRole> roleList(String groupId,Pageable pageable);
	
	//查询角色信息
	public GeRmsRole findRoleById(String roleId);
	
	public Page<GeRmsRole> findRole(String comCode,String name,Pageable pageable);
	
	//根据角色ID查询角色关联的功能
	public List<GeRmsTask> findTaskByRole(String roleId);
	
	//根据机构查询所有可用的功能
	public List<GeRmsTask> findTaskByComCode(String comCode);
	
	//查询出所有的角色
	public Gridable<GeRmsRole> findAllRole(Gridable<GeRmsRole>gridable,Pageable pageable, List<String> roleAttribute);
	
	public Gridable<GeRmsRole> getGridable(Pageable pageable,String groupId,Gridable<GeRmsRole> gridable,List<String>roleAttribute);
	
	//查询机构下所有可见的角色
	public Gridable<GeRmsRole> getGridable(Gridable<GeRmsRole> gridable,String name,Pageable pageable);
}
