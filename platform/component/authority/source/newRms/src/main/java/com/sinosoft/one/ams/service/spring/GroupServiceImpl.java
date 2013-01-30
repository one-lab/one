package com.sinosoft.one.ams.service.spring;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.sinosoft.one.ams.model.Group;
import com.sinosoft.one.ams.model.GroupRole;
import com.sinosoft.one.ams.model.Role;
import com.sinosoft.one.ams.model.UserGroup;
import com.sinosoft.one.ams.repositories.GeRmsGroupRepository;
import com.sinosoft.one.ams.repositories.GeRmsGroupRoleRepositoriy;
import com.sinosoft.one.ams.repositories.GeRmsRoleRepository;
import com.sinosoft.one.ams.repositories.GeRmsUserGroupRepository;
import com.sinosoft.one.ams.service.facade.GroupService;
import com.sinosoft.one.uiutil.Gridable;

@Component
public class GroupServiceImpl implements GroupService{
	
	@Resource(name="geRmsGroupRepository")
	private GeRmsGroupRepository geRmsGroupRepository;
	@Resource(name="geRmsRoleRepository")
	private GeRmsRoleRepository geRmsRoleRepository;
	@Resource(name="geRmsGroupRoleRepositoriy")
	private GeRmsGroupRoleRepositoriy geRmsGroupRoleRepositoriy;
	@Resource(name="geRmsUserGroupRepository")
	private GeRmsUserGroupRepository geRmsUserGroupRepository;
	
	
	
	//根据机构ID查询本机构的用户组
	public List<Group> findGroupByComCode(String comCode) {
		List<Group> groupList = geRmsGroupRepository.findGroupByComCode(comCode);
		return groupList;
	}
	
	public Gridable<Group> getGroupGridable(Gridable<Group> gridable,
			String comCode, String name, Pageable pageable) {
		//查询机构下所有可见的角色
		Page<Group> page = null;
		page = findGroup(comCode,name,pageable);
		String button = "<a href='#' class='set' onclick='openUpdateWindow(this);'>修 改</a><a href='#' class='set' onclick='delRow(this);'>删 除</a>";
		List<Group> groups = page.getContent();
		for (Group group : groups) {
			group.setFlag(button);
		} 
		gridable.setPage(page);
		gridable.setIdField("groupID");
		List<String> groupAttribute = new ArrayList<String>();
		groupAttribute.add("name");
		groupAttribute.add("des");
		groupAttribute.add("createTime");
		groupAttribute.add("operateTime");
		groupAttribute.add("flag");
		gridable.setCellListStringField(groupAttribute);
		return gridable;
	}
	
	Page<Group> findGroup(String comCode,String name,Pageable pageable){
		Page<Group> page =null;
		if(name!=null&&!"".equals(name))
			page = geRmsGroupRepository.findGroupByName(comCode, "%"+name+"%", pageable);
		else
			page = geRmsGroupRepository.findGroup(comCode, pageable);
		return page;
	}

	public Group findGroupById(String groupId) {
		return geRmsGroupRepository.findOne(groupId);	
	}

	public Gridable<Role> getRoleGridableByGroupId(Gridable<Role> gridable,
			String groupId,String comCode, Pageable pageable) {
		Page<Role> page = geRmsRoleRepository.findRole(comCode, pageable);
	
		Group group =geRmsGroupRepository.findOne(groupId);
		List<String> roleids=new ArrayList<String>();
		for (GroupRole groupRole : 	group.getGroupRoles()) {
			roleids.add(groupRole.getRole().getRoleID());
		}
		for (Role role: page.getContent()) {
			for (String string : roleids) {
			
				if(role.getRoleID().toString().equals(string)){
					role.setChecked("true");
					break;
				} 
			}
		}
		gridable.setPage(page);
		gridable.setIdField("roleID");
		List<String> roleAttribute = new ArrayList<String>();
		roleAttribute.add("name");
		roleAttribute.add("des");
		roleAttribute.add("createTime");
		roleAttribute.add("operateTime");
		roleAttribute.add("checked");
		gridable.setCellListStringField(roleAttribute);
		return gridable;
	}

	public void updateGroup(String groupId, String name, String groupType,
			List<String> roleIds, String des, String comCode, String userCode) {
		Group group=geRmsGroupRepository.findOne(groupId);
		if (group!=null) {
			geRmsGroupRoleRepositoriy.delete(group.getGroupRoles());
			group.setName(name);
			group.setOperateUser(userCode);
			if (des!=null) {
				group.setDes(des);
			}
			if(groupType.equals("all")){
				group.setComCode("*");
			}else {
				group.setComCode(comCode);
			}
			List<Role>roles=(List<Role>) geRmsRoleRepository.findAll(roleIds);
			List<GroupRole>groupRoles=new ArrayList<GroupRole>();
			for (Role role : roles) {
				GroupRole groupRole=new GroupRole();
				groupRole.setGroup(group);
				groupRole.setRole(role);
				groupRole.setIsValidate("1");
				groupRoles.add(groupRole);
			}
			group.setGroupRoles(groupRoles);
			geRmsGroupRepository.save(group);
		}
		
	}

	public void addGroup(String name, String groupType, List<String> roleIds,
			String des, String comCode, String userCode) {
		Group group=new Group();
		group.setName(name);
		if (des!=null) {
			group.setDes(des);
		}
		group.setCreateUser(userCode);
		group.setOperateTime(new Date());
		group.setIsValidate("1");
		if(groupType.equals("all")){
			group.setComCode("*");
		}else {
			group.setComCode(comCode);
		}
		List<GroupRole> groupRoles=new ArrayList<GroupRole>();
		for (String string : roleIds) {
			GroupRole groupRole=new GroupRole();
			groupRole.setGroup(group);
			groupRole.setIsValidate("1");
			groupRole.setRole(geRmsRoleRepository.findOne(string));
			groupRoles.add(groupRole);
		}
		group.setGroupRoles(groupRoles);
		geRmsGroupRepository.save(group);
	}

	//根据机构Id，查询机构的用户组,并对已引入用户的组进行标记
	public List<Group> findGroupByComCode(String comCode, String userCode) {
		
		List<Group> groups = geRmsGroupRepository.findGroupByComCode(comCode);
		List<String> userGroupIds = geRmsUserGroupRepository.findUserGroupIdByUserCode(userCode);
		if(!userGroupIds.isEmpty()){
			List<UserGroup> userGroups = (List<UserGroup>) geRmsUserGroupRepository.findAll(userGroupIds);
			List<String> checkGroupIds = new ArrayList<String>();
			for(UserGroup userGroup : userGroups){
				checkGroupIds.add(userGroup.getGroup().getGroupID());
			}

			for(Group group : groups){
				if(checkGroupIds.contains(group.getGroupID().toString())){
					group.setFlag("1");
				}else{
					group.setFlag("0");
				}
			}
		}
		return groups;
	}

	public List<Group> findGroupById(List<String> groupIds) {
		System.out.println(groupIds);
		List<Group> groups = new ArrayList<Group>();
		if(!groupIds.isEmpty()){
			
			groups = (List<Group>) geRmsGroupRepository.findAll(groupIds);
		}
		return groups;
	}
	
}
