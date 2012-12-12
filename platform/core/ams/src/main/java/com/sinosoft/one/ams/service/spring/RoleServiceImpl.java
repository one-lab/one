package com.sinosoft.one.ams.service.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.sinosoft.one.ams.model.Role;
import com.sinosoft.one.ams.model.RoleTask;
import com.sinosoft.one.ams.model.Task;
import com.sinosoft.one.ams.model.TaskAuth;
import com.sinosoft.one.ams.repositories.GeRmsGroupRoleRepositoriy;
import com.sinosoft.one.ams.repositories.GeRmsRoleRepository;
import com.sinosoft.one.ams.repositories.GeRmsRoleTaskRepository;
import com.sinosoft.one.ams.repositories.GeRmsTaskAuthRepository;
import com.sinosoft.one.ams.repositories.GeRmsTaskRepository;
import com.sinosoft.one.ams.service.facade.RoleService;
import com.sinosoft.one.ams.utils.uiutil.Gridable;
import com.sinosoft.one.mvc.web.Invocation;

@Component
public class RoleServiceImpl implements RoleService{
	
	
	@Autowired
	private GeRmsRoleRepository geRmsRoleRepository;
	@Autowired
	private GeRmsGroupRoleRepositoriy geRmsGroupRoleRepository;
	@Autowired
	private GeRmsTaskRepository geRmsTaskRepository;
	@Autowired
	private GeRmsTaskAuthRepository geRmsTaskAuthRepository;
	@Autowired
	private GeRmsRoleTaskRepository geRmsRoleTaskRepository;
	@Autowired
	private Invocation inv;
	
	
	private List<String> roleAttribute = new ArrayList<String>();
	

	
	public Page<Role> roleList(String groupId,Pageable pageable){
		Page<Role> roleList = geRmsGroupRoleRepository.findByGroupId(groupId,pageable);
		return roleList;
	}
	
	//查询角色信息
	public Role findRoleById(String roleId){
		//查询角色对象
		Role role = geRmsRoleRepository.findOne(roleId);
		//查询角色类型  default/all
		List<String> rolesComCodes=geRmsRoleRepository.findRoleTypById(roleId);
		if(rolesComCodes.size()>0&&rolesComCodes!=null){
			role.setFlag("default");
			for (String comcode : rolesComCodes) {
				if(comcode.toString().equals("*"))
					role.setFlag("all");
					break;
			}
		}
		return role;
	}
	
	public Page<Role> findRole(String comCode,String name,Pageable pageable){
		Page<Role> page =null;
		if(name!=null&&!"".equals(name))
			page = geRmsRoleRepository.findRoleByName(comCode, name, pageable);
		else
			page = geRmsRoleRepository.findRole(comCode, pageable);
		return page;
	}
	
	//根据角色ID查询角色关联的功能
	public List<Task> findTaskByRole(String roleId){
		//先查询角色关联的授权
		List<TaskAuth> geRmsTaskAuths=geRmsTaskAuthRepository.findTaskAuthByRole(roleId);
		List<String> taskIds=new ArrayList<String>();
		for (TaskAuth geRmsTaskAuth : geRmsTaskAuths) {
			taskIds.add(geRmsTaskAuth.getTask().getTaskID());
		}
		//根据授权获得的功能ID获取功能集合
		List<Task> geRmsTasks =geRmsTaskRepository.findTaskByTaskAuthIds(taskIds);
		return geRmsTasks;
	}
	
	//根据机构查询所有可用的功能
	public List<Task> findTaskByComCode(String comCode){
		List<Task>geRmsTasks =geRmsTaskRepository.findTaskByComCode(comCode);
		return geRmsTasks;
	}


	public Gridable<Role> getGridable(Gridable<Role> gridable,
			String comCode,String name, Pageable pageable) {
		
		Page<Role> page = null;
		//查询机构下所有可见的角色
		page = findRole(comCode,name,pageable);
		String button = "<a href='#' class='set' onclick='openUpdateWindow(this);'>修 改</a><a href='#' class='set' onclick='delRow(this);'>删 除</a>";
		List<Role> geRmsRoles = page.getContent();
		for (Role geRmsRole : geRmsRoles) {
			geRmsRole.setFlag(button);
		} 
		gridable.setPage(page);
		gridable.setIdField("roleID");
		roleAttribute.add("name");
		roleAttribute.add("des");
		roleAttribute.add("createTime");
		roleAttribute.add("operateTime");
		roleAttribute.add("button");
		gridable.setCellListStringField(roleAttribute);
		
		return gridable;
	}

	public void updateRole(String roleId,  String comCode,String name, String des,
			String roleTpe, List<String> taskids) {
		Role geRmsRole=geRmsRoleRepository.findOne(roleId);
		//删除角色关联的功能
		geRmsRoleRepository.deleteRoleTask(roleId, comCode);
		List<TaskAuth> geRmsTaskAuths=geRmsTaskAuthRepository.findTaskAuthByComCode(comCode, taskids);
		for (TaskAuth geRmsTaskAuth : geRmsTaskAuths) {
			RoleTask geRmsRoleTask=new RoleTask();
			geRmsRoleTask.setRole(geRmsRole);
			geRmsRoleTask.setTaskAuth(geRmsTaskAuth);
			geRmsRoleTask.setIsValidate("1");
			geRmsRoleTaskRepository.save(geRmsRoleTask);
		}
	}
	
}
