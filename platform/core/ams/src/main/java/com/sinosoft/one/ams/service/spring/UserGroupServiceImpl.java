package com.sinosoft.one.ams.service.spring;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.sinosoft.one.ams.model.GeRmsGroup;
import com.sinosoft.one.ams.model.GeRmsGroupRole;
import com.sinosoft.one.ams.model.User;
import com.sinosoft.one.ams.repositories.GeRmsGroupRepository;
import com.sinosoft.one.ams.repositories.GeRmsGroupRoleRepositoriy;
import com.sinosoft.one.ams.repositories.GeRmsUserGroupRepository;
import com.sinosoft.one.ams.repositories.UserDao;
import com.sinosoft.one.ams.service.AccountManager;
import com.sinosoft.one.ams.service.facade.UserGroupService;
import com.sinosoft.one.ams.utils.uiutil.Gridable;
import com.sinosoft.one.mvc.web.Invocation;

@Component
public class UserGroupServiceImpl implements UserGroupService{
	
	@Autowired
	private AccountManager accountManager;
	@Autowired
	private GeRmsGroupRepository geRmsGroupRepository;
	@Autowired
	private GeRmsGroupRoleRepositoriy geRmsGroupRoleRepositoriy;
	@Autowired
	private GeRmsUserGroupRepository geRmsUserGroupRepository;
	@Autowired
	private UserDao userDao;
	@Autowired
	private Invocation inv;
	
	//将数据库中的用户组记录保存在Gridable中，并返回
	public Gridable<GeRmsGroup> getGridable(Gridable<GeRmsGroup> gridable, Pageable pageable,List<String> groupAttribute) {
		// TODO Auto-generated method stub
		Page<GeRmsGroup> page = geRmsGroupRepository.findAll(pageable);
		List<GeRmsGroup> geRmsGroups = page.getContent();
		String button = "<a href='#' class='set' onclick='openWindow(this);'>修 改</a><a href='#' class='set' onclick='delRow(this);'>删 除</a>";
		for (GeRmsGroup group : geRmsGroups) {
			if (group.getCreateTime() != null)
				group.setCreateTimeStr(group.getCreateTime().toString());
			if (group.getOperateTime() != null)
				group.setOperateTimeStr(group.getOperateTime().toString());
			group.setButton(button);
		}
		gridable.setPage(page);
		
		gridable.setIdField("groupID");
		groupAttribute.add("name");
		groupAttribute.add("des");
		groupAttribute.add("createTimeStr");
		groupAttribute.add("operateTimeStr");
		groupAttribute.add("button");
		gridable.setCellListStringField(groupAttribute);
		
		return gridable;
	}
	
	//根据组名，将数据库中的用户组记录保存在Gridable中，并返回
	public Gridable<GeRmsGroup> searchGroup(Gridable<GeRmsGroup> gridable,
			String name, Pageable pageable, List<String> groupAttribute) {
		// TODO Auto-generated method stub
		
		Page<GeRmsGroup> page = null;
		if (!name.equals("null")) {
			page = geRmsGroupRepository.findGroupByName("%"+name+"%", pageable);
		} else {
			page = geRmsGroupRepository.findAll(pageable);
		}
		String button = "<a href='#' class='set' onclick='openWindow(this);'>修 改</a><a href='#' class='set' onclick='delRow(this);'>删 除</a>";
		List<GeRmsGroup> groupList = page.getContent();
		for (GeRmsGroup group : groupList) {
			if (group.getCreateTime() != null)
				group.setCreateTimeStr(group.getCreateTime().toString());
			if (group.getOperateTime() != null)
				group.setOperateTimeStr(group.getOperateTime().toString());
			group.setButton(button);
		}
		gridable.setPage(page);
		gridable.setIdField("groupID");
		groupAttribute.add("name");
		groupAttribute.add("des");
		groupAttribute.add("createTimeStr");
		groupAttribute.add("operateTimeStr");
		groupAttribute.add("button");
		gridable.setCellListStringField(groupAttribute);
		return gridable;
	}
	
	//保存用户组和用户组的角色
	public void saveGroupAndGroupRole(String name, String des,String roleIdStr,GeRmsGroup group,GeRmsGroupRole groupRole) {
		// TODO Auto-generated method stub
		
		User user = (User) inv.getRequest().getSession().getAttribute("user");

		group.setName(name);
		group.setGroupID(name);
		group.setDes(des);
		group.setCreateTime(new Date());
		group.setComCode(user.getComCode());
		group.setCreateUser(user.getUserName());
		group.setIsValidate("1");
		geRmsGroupRepository.save(group);

		String[] roleId = roleIdStr.split(",");
		for (int i = 0; i < roleId.length; i++) {
			
			groupRole.setGroupRoleID(group.getGroupID()
					+ roleId[i].substring(3, 10));
			groupRole.setGroupID(group.getGroupID());
			groupRole.setRoleID(roleId[i]);
			groupRole.setIsValidate("1");
			geRmsGroupRoleRepositoriy.save(groupRole);
		}
		
		
	}
	
	//根据用户组Id修改Group和GroupRole表中数据的isvalidate值
	public void del(String groupId) {
		// TODO Auto-generated method stub
		System.out.println("check----1");
		geRmsGroupRepository.updateIsvalidateByGroupId(groupId);
		System.out.println("check----2");
		geRmsGroupRoleRepositoriy.updateIsvalidateByGroupId(groupId);
		System.out.println("check----3");
	}

	//根据用户组ID，查出符合条件的用户，存入Gridable对象，并返回
	public Gridable<User> getGridable(Gridable<User> gridable, String groupId,Pageable pageable,
			List<String> userAttribute) {
		// TODO Auto-generated method stub
		
		Page<User> page = geRmsUserGroupRepository.findUserByGroupId(groupId, pageable);
		List<User> userList = page.getContent();
		String button = "<a href='#' class='set' onclick='delRow(this);'>删 除</a>";
		for (User user : userList) {
			user.setButton(button);
		}

		gridable.setPage(page);
		gridable.setIdField("userCode");
		userAttribute.add("userCode");
		userAttribute.add("userName");
		userAttribute.add("button");
		gridable.setCellListStringField(userAttribute);
		
		return gridable;
	}
	
	//根据用户名和用户ID，查出符合条件的用户，存入Gridable对象，并返回
	public Gridable<User> getGridable(Gridable<User> gridable, String userName,
			String userCode,String groupId, Pageable pageable, List<String> userAttribute) {
		// TODO Auto-generated method stub
		
		Page<User> page = null;
		if (userCode.equals("null") && userName.equals("null")) {
			page = geRmsUserGroupRepository.findUserByGroupId(groupId, pageable);
		} else if (!userCode.equals("null") && userName.equals("null")) {
			page = geRmsUserGroupRepository.findUserByUserCode("%"+userCode+"%",groupId, pageable);
		} else if (userCode.equals("null") && !userName.equals("null")) {
			page = userDao.searchUserByUserName("%"+userName+"%",groupId, pageable);
		} else {
			page = userDao.searchUserByNameCode("%"+userName+"%", "%"+userCode+"%",groupId, pageable);
		}

		List<User> userList = page.getContent();
		String button = "<a href='#' class='set' onclick='delRow(this);'>删 除</a>";
		for (User user : userList) {
			user.setButton(button);
		}
		
		gridable.setPage(page);
		gridable.setIdField("userCode");
		userAttribute.add("userCode");
		userAttribute.add("userName");
		userAttribute.add("button");
		gridable.setCellListStringField(userAttribute);
		
		return gridable;
	}
	
	//根据用户Id和用户组Id修改UserGroup表中数据的isvalidate值
	public void del(String userCode, String groupId) {
		// TODO Auto-generated method stub
		
		geRmsUserGroupRepository.updateIsvalidateByUserCodeGroupId(userCode, groupId);
		
	}

}
