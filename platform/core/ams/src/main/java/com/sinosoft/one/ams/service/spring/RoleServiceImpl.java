package com.sinosoft.one.ams.service.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.sinosoft.one.ams.model.GeRmsRole;
import com.sinosoft.one.ams.model.GeRmsTask;
import com.sinosoft.one.ams.model.GeRmsTaskAuth;
import com.sinosoft.one.ams.model.User;
import com.sinosoft.one.ams.repositories.GeRmsGroupRoleRepositoriy;
import com.sinosoft.one.ams.repositories.GeRmsRoleRepository;
import com.sinosoft.one.ams.repositories.GeRmsTaskAuthRepository;
import com.sinosoft.one.ams.repositories.GeRmsTaskRepository;
import com.sinosoft.one.ams.service.AccountManager;
import com.sinosoft.one.ams.service.facade.RoleService;
import com.sinosoft.one.ams.utils.uiutil.Gridable;
import com.sinosoft.one.mvc.web.Invocation;

@Component
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private AccountManager accountManager;
	
	@Autowired
	private GeRmsRoleRepository geRmsRoleRepository;
	@Autowired
	private GeRmsGroupRoleRepositoriy geRmsGroupRoleRepository;
	@Autowired
	private GeRmsTaskRepository geRmsTaskRepository;
	@Autowired
	private GeRmsTaskAuthRepository geRmsTaskAuthRepository;
	@Autowired
	private Invocation inv;
	
	
	private List<String> roleAttribute = new ArrayList<String>();
	
	public Page<GeRmsRole> findRoleByName(String name,  Pageable pageable) {
		if(name.equals("null")){
			name = "";
		}
		Page<GeRmsRole> page = geRmsRoleRepository.findRoleByName("%"+name+"%",pageable);
		List<GeRmsRole> roleList = page.getContent();
		for(GeRmsRole role : roleList){
			role.setButton("<a href='#' class='set' onclick='openWindow()'>修 改</a><a href='#' class='set' onclick='delRow(this)'>删 除</a>");
		}
		return page;
	}

	public Page<GeRmsRole> findAll(Pageable pageable) {
		Page<GeRmsRole> page = geRmsRoleRepository.findAll(pageable);
		List<GeRmsRole> roleAll = page.getContent();
		for(GeRmsRole role : roleAll){
			role.setButton("<a href='#' class='set' onclick='openWindow()'>修 改</a><a href='#' class='set' onclick='delRow(this)'>删 除</a>");
		}
		return page;
	}
	
	public Page<GeRmsRole> roleList(String groupId,Pageable pageable){
		Page<GeRmsRole> roleList = geRmsGroupRoleRepository.findByGroupId(groupId,pageable);
		return roleList;
	}
	
	//查询角色信息
	public GeRmsRole findRoleById(String roleId){
		//查询角色对象
		GeRmsRole role = geRmsRoleRepository.findRoleById(roleId);
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
	
	public Page<GeRmsRole> findRole(String comCode,String name,Pageable pageable){
		Page<GeRmsRole> page =null;
		if(name!=null&&!"".equals(name))
			page = geRmsRoleRepository.findRoleByName(comCode, name, pageable);
		else
			page = geRmsRoleRepository.findRole(comCode, pageable);
		return page;
	}
	
	//根据角色ID查询角色关联的功能
	public List<GeRmsTask> findTaskByRole(String roleId){
		//先查询角色关联的授权
		List<GeRmsTaskAuth> geRmsTaskAuths=geRmsTaskAuthRepository.findTaskAuthByRole(roleId);
		List<String> taskIds=new ArrayList<String>();
		for (GeRmsTaskAuth geRmsTaskAuth : geRmsTaskAuths) {
			taskIds.add(geRmsTaskAuth.getTaskID());
		}
		//根据授权获得的功能ID获取功能集合
		List<GeRmsTask> geRmsTasks =geRmsTaskRepository.findTaskByTaskAuthIds(taskIds);
		
		return geRmsTasks;
	}
	
	//根据机构查询所有可用的功能
	public List<GeRmsTask> findTaskByComCode(String comCode){
		List<GeRmsTask>geRmsTasks =geRmsTaskRepository.findTaskByComCode(comCode);
		return geRmsTasks;
	}

	public Gridable<GeRmsRole> findAllRole(Gridable<GeRmsRole> gridable,
			Pageable pageable,List<String> roleAttribute) {
		// TODO Auto-generated method stub
		
		Page<GeRmsRole> page = null;
		//查询机构下所有可见的角色
		page = geRmsRoleRepository.findAll(pageable);
		String button = "<a href='#' class='set' onclick='openWindow(this);'>修 改</a><a href='#' class='set' onclick='delRow(this);'>删 除</a>";
		List<GeRmsRole> geRmsRoles = page.getContent();
		for (GeRmsRole geRmsRole : geRmsRoles) {
			geRmsRole.setButton(button);
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

	public Gridable<GeRmsRole> getGridable(Pageable pageable,String groupId,
			Gridable<GeRmsRole> gridable, List<String> roleAttribute) {
		// TODO Auto-generated method stub
		
		Page<GeRmsRole> page =  geRmsGroupRoleRepository.findByGroupId(groupId, pageable);
		
		gridable.setPage(page);
		gridable.setIdField("roleID");
		roleAttribute.add("name");
		roleAttribute.add("roleID");
		roleAttribute.add("createTime");
		roleAttribute.add("operateTime");
		roleAttribute.add("button");
		gridable.setCellListStringField(roleAttribute);
		
		return gridable;
	}

	public Gridable<GeRmsRole> getGridable(Gridable<GeRmsRole> gridable,
			String name, Pageable pageable) {
		// TODO Auto-generated method stub
		
		User user = (User) inv.getRequest().getSession().getAttribute("user");
		String comCode = user.getComCode();
		System.out.println(name);
		Page<GeRmsRole> page = null;
		//查询机构下所有可见的角色
		page = findRole(comCode,name,pageable);
		String button = "<a href='#' class='set' onclick='openWindow(this);'>修 改</a><a href='#' class='set' onclick='delRow(this);'>删 除</a>";
		List<GeRmsRole> geRmsRoles = page.getContent();
		for (GeRmsRole geRmsRole : geRmsRoles) {
			geRmsRole.setButton(button);
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
	
}
