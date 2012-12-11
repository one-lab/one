package com.sinosoft.one.ams.controllers.role;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.ams.model.GeRmsRole;
import com.sinosoft.one.ams.service.facade.RoleService;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;

@Path("role")
public class GeRmsRoleController {
	
	@Autowired
	private RoleService roleService;
	
	//根据角色ID查询角色信息
	@Get("findRoleById/{roleId}")
	public String findRoleById(@Param("roleId") String roleId,Invocation inv){
		GeRmsRole role  = roleService.findRoleById(roleId);
		inv.addModel("name", role.getName());
		inv.addModel("des", role.getDes());
		inv.addModel("roleId", role.getRoleID());
		inv.addModel("flag", role.getFlag());
		return "loadRoleInfo";
	}
	
}