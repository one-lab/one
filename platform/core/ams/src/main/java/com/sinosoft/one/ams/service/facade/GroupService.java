package com.sinosoft.one.ams.service.facade;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sinosoft.one.ams.model.Group;
import com.sinosoft.one.ams.model.Role;
import com.sinosoft.one.ams.utils.uiutil.Gridable;

@Service
public interface GroupService {
	
	public Gridable<Group> getGroupGridable(Gridable<Group> gridable,String comCode,String name,Pageable pageable);
	
	public Group findGroupById(String groupId);
	
	public Gridable<Role> getRoleGridableByGroupId(Gridable<Role> gridable,String groupId,String comCode,Pageable pageable);
	
	public void updateGroup(String groupId,String name,String groupType,List<String> roleIds,String des,String comCode,String userCode);
	
	public void addGroup(String name,String groupType,List<String> roleIds,String des,String comCode,String userCode);
}
