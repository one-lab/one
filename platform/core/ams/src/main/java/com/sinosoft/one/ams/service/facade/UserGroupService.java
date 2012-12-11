package com.sinosoft.one.ams.service.facade;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sinosoft.one.ams.model.GeRmsGroup;
import com.sinosoft.one.ams.model.GeRmsGroupRole;
import com.sinosoft.one.ams.model.User;
import com.sinosoft.one.ams.utils.uiutil.Gridable;

@Service
public interface UserGroupService {
	
	//将数据库中的用户组记录保存在Gridable中，并返回
	public Gridable<GeRmsGroup> getGridable(Gridable<GeRmsGroup> gridable,Pageable pageable,List<String> groupAttribute);
	
	//根据组名，将数据库中的用户组记录保存在Gridable中，并返回
	public Gridable<GeRmsGroup> searchGroup(Gridable<GeRmsGroup> gridable,String name,Pageable pageable,List<String> groupAttribute);
	
	public void saveGroupAndGroupRole(String name, String des,String roleIdStr,GeRmsGroup group,GeRmsGroupRole groupRole);
	
	public void del(String groupId);
	
	//根据用户组ID，查出符合条件的用户，存入Gridable对象，并返回
	public Gridable<User> getGridable(Gridable<User>gridable,String groupId,Pageable pageable,List<String> userAttribute);
	
	//根据用户名和用户ID，查出符合条件的用户，存入Gridable对象，并返回
	public Gridable<User> getGridable(Gridable<User>gridable,String userName,String userCode,String groupId,Pageable pageable,List<String>userAttribute);
	
	//根据用户Id和用户组Id修改UserGroup表中数据的isvalidate值
	public void del(String userCode,String groupId);

}
