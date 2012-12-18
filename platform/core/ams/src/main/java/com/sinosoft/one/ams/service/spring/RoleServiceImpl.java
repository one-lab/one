package com.sinosoft.one.ams.service.spring;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.sinosoft.one.ams.model.Group;
import com.sinosoft.one.ams.model.GroupRole;
import com.sinosoft.one.ams.model.Role;
import com.sinosoft.one.ams.model.RoleDesignate;
import com.sinosoft.one.ams.model.RoleDesignateId;
import com.sinosoft.one.ams.model.RoleTask;
import com.sinosoft.one.ams.model.Task;
import com.sinosoft.one.ams.model.TaskAuth;
import com.sinosoft.one.ams.repositories.GeRmsGroupRepository;
import com.sinosoft.one.ams.repositories.GeRmsGroupRoleRepositoriy;
import com.sinosoft.one.ams.repositories.GeRmsRoleDesignateRepository;
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
	private GeRmsGroupRepository geRmsGroupRepository; 
	@Autowired
	private GeRmsGroupRoleRepositoriy geRmsGroupRoleRepository;
	@Autowired
	private GeRmsTaskRepository geRmsTaskRepository;
	@Autowired
	private GeRmsTaskAuthRepository geRmsTaskAuthRepository;
	@Autowired
	private GeRmsRoleTaskRepository geRmsRoleTaskRepository;
	@Autowired
	private GeRmsRoleDesignateRepository geRmsRoleDesignateRepository;
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
		List<String> taskIds=geRmsTaskAuthRepository.findTaskAuthByRole(roleId);
		//根据授权获得的功能ID获取功能集合
//		List<Task> geRmsTasks =geRmsTaskRepository.findTaskByTaskIds(taskIds);
		List<Task> geRmsTasks=(List<Task>) geRmsTaskRepository.findAll(taskIds);
		return geRmsTasks;
	}
	
	//根据机构查询所有可用的功能
	public List<Task> findTaskByComCode(String comCode){
		List<String> taskIds=geRmsTaskAuthRepository.findTaskIdByComCode(comCode);
		List<Task> geRmsTasks=(List<Task>) geRmsTaskRepository.findAll(taskIds);
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
		roleAttribute.add("flag");
		gridable.setCellListStringField(roleAttribute);
		
		return gridable;
	}

	public void updateRole(String roleId,String  comCode, String userCode,String name, String des,
			String roleTpe, List<String> taskids) {
		Role role=geRmsRoleRepository.findOne(roleId);
		//删除角色关联的功能
		geRmsRoleRepository.deleteRoleTask(roleId, comCode);
		List<TaskAuth> geRmsTaskAuths=geRmsTaskAuthRepository.findTaskAuthByComCode(comCode, taskids);
		List<RoleTask> roleTasks = new ArrayList<RoleTask>();
		for (TaskAuth geRmsTaskAuth : geRmsTaskAuths) {
			RoleTask geRmsRoleTask=new RoleTask();
			geRmsRoleTask.setRole(role);
			geRmsRoleTask.setTaskAuth(geRmsTaskAuth);
			geRmsRoleTask.setIsValidate("1");
			roleTasks.add(geRmsRoleTask);
		}
		role.setRoleTasks(roleTasks);
		role.setName(name);
		role.setDes(des);
		Date date = new Date();
		role.setOperateTime(date);
		role.setOperateUser(userCode);
		geRmsRoleRepository.save(role);
		if(roleTpe.toString().equals("default")){
			//修改类型
			geRmsRoleRepository.updateRoleToDefault(comCode, roleId);
			// comCodes为选中的机构 不 delete comCodes的机构指派
			geRmsRoleRepository.deleteRoleDesignate(comCode, roleId);
			//删除不指派的用户组角色数据
			geRmsGroupRoleRepository.deleteGroupRoleByComCode(comCode);
			editDefaultGroup(comCode, userCode, role);
		}
		if(roleTpe.toString().equals("all")){
			geRmsRoleRepository.updateRoleToAll(comCode, roleId);
		}
	}
	
	public void addRole(String comCode, String userCode, String name,
			String des, String roleTpe, List<String> taskids) {
		Role role = new Role();
		role.setCreateUser(userCode);
		role.setOperateUser(userCode);
		role.setName(name);
		role.setDes(des);
		role.setComCode(comCode);
		List<TaskAuth> taskAuths=geRmsTaskAuthRepository.findTaskAuthByComCode(comCode, taskids);
		List<RoleTask> roleTasks = new ArrayList<RoleTask>();
		for (TaskAuth taskAuth : taskAuths) {
			RoleTask roleTask = new RoleTask();
			roleTask.setRole(role);
			roleTask.setIsValidate("1");
			roleTask.setTaskAuth(taskAuth);
			roleTasks.add(roleTask);
		}
		role.setRoleTasks(roleTasks);
		role.setIsValidate("1");
		Date date = new Date();
		role.setCreateTime(date);
		role.setOperateTime(date);
		if(roleTpe.toString().equals("default".toString()))
			role.setFlag("");
		if(roleTpe.toString().equals("all".toString()))
			role.setFlag("*");
		geRmsRoleRepository.save(role);
		RoleDesignate roleDesignate = new RoleDesignate();
		RoleDesignateId roleDesignateId = new RoleDesignateId();
		roleDesignateId.setRoleID(role.getRoleID());
		if(roleTpe.toString().equals("default".toString()))
			roleDesignateId.setComCode(comCode);
		if(roleTpe.toString().equals("all".toString()))
			roleDesignateId.setComCode("*");
		roleDesignate.setRole(role);
		roleDesignate.setId(roleDesignateId);
		roleDesignate.setCreateUser(userCode);
		roleDesignate.setOperateUser(userCode);
		roleDesignate.setCreateTime(date);
		roleDesignate.setOperateTime(date);
		geRmsRoleDesignateRepository.save(roleDesignate);
		//操作默认用户组 默认类型的才操作
		if(roleTpe.toString().equals("default".toString()))
			editDefaultGroup(comCode, userCode, role);
	}
	
	//操作默认用户组
	void editDefaultGroup(String comCode,String userCode,Role role){
		String groupid=  geRmsGroupRepository.findGroupIdbyName("默认用户组", comCode);
		Group group= geRmsGroupRepository.findOne(groupid);
		if(group==null){
			//如果该机构没有用户组则先建立默认用户组
			group=new Group();
			group.setComCode(comCode);
			group.setName("默认用户组");
			group.setIsValidate("1");
			Date date = new Date();
			group.setCreateTime(date);
			group.setOperateTime(date);
			group.setCreateUser(userCode);
			group.setOperateUser(userCode);
			geRmsGroupRepository.save(group);
		}
		//获取关联表是否为空
		if (role != null) {
			List<GroupRole> groupRoles=group.getGroupRoles();
			// 如果没有组-角色的关联表则建立关联表数据
			if (groupRoles.size() == 0) {
				// 为空则建立关联
				List<GroupRole> groupRols = new ArrayList<GroupRole>();
				GroupRole groupRole = new GroupRole();
				groupRole.setGroup(group);
				groupRole.setRole(role);
				groupRole.setIsValidate("1");
				groupRols.add(groupRole);
				group.setGroupRoles(groupRols);
				geRmsGroupRepository.save(group);
			} else {
				// 如果不为空 则循环判断是否有相等的 则不再新建
				int i = 0;
				for (GroupRole groupRole : groupRoles) {
					if (!groupRole.getRole().getRoleID().toString()
							.equals(role.getRoleID())) {
						i++;
					}
				}
				if (i == groupRoles.size()) {
					GroupRole groupRole = new GroupRole();
					groupRole.setGroup(group);
					groupRole.setRole(role);
					groupRole.setIsValidate("1");
					groupRoles.add(groupRole);
					group.setGroupRoles(groupRoles);
					geRmsGroupRepository.save(group);
				}
			}
		}
	}
	
}
