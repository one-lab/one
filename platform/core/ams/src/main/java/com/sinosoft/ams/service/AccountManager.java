package com.sinosoft.ams.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.sinosoft.ams.person_allocation.repositories.GeRmsUserGroupRepository;
import com.sinosoft.ams.role.model.GeRmsRole;
import com.sinosoft.ams.role.repositories.GeRmsGroupRoleRepositoriy;
import com.sinosoft.ams.role.repositories.GeRmsRoleRepository;
import com.sinosoft.ams.task.model.GeRmsTask;
import com.sinosoft.ams.task.repositories.GeRmsTaskRepository;
import com.sinosoft.ams.task_auth.model.GeRmsCompany;
import com.sinosoft.ams.task_auth.repositories.GeRmsCompanyRepository;
import com.sinosoft.ams.task_auth.repositories.GeRmsTaskAuthRepository;
import com.sinosoft.ams.user_group.model.GeRmsGroup;
import com.sinosoft.ams.user_group.model.User;
import com.sinosoft.ams.user_group.repositories.GeRmsGroupRepository;
import com.sinosoft.ams.user_group.repositories.UserDao;

@Component
public class AccountManager {

	@Autowired
	private GeRmsCompanyRepository geRmsCompanyRepository; 
	@Autowired
	private UserDao userDao;
	@Autowired
	private GeRmsTaskRepository geRmsTaskRepository;
	@Autowired
	private GeRmsTaskAuthRepository geRmsTaskAuthRepository;
	@Autowired
	private GeRmsGroupRepository geRmsGroupRepository;
	@Autowired
	private GeRmsGroupRoleRepositoriy geRmsGroupRoleRepository;
	@Autowired
	private GeRmsRoleRepository geRmsRoleRepository;
	@Autowired
	private GeRmsUserGroupRepository geRmsUserGroupRepository;
	
	public List<GeRmsCompany> getAllgeRmsCompanyRepository() {
		List<GeRmsCompany> list=(List<GeRmsCompany>) geRmsCompanyRepository.findAll();
		return list;
	} 
	
	public List<GeRmsCompany> findByUpperComCode(String comCode){
		List<GeRmsCompany> list= geRmsCompanyRepository.findByUpperComCode(comCode);
		return list;
	}
	
	public GeRmsCompany company(String comCode){
		GeRmsCompany company=geRmsCompanyRepository.findByComCode(comCode);
		return company;
	}

	public User findByUsername(String userName){
		User user =userDao.findByUsername(userName);
		return user;
	}
	
	public Page<User> findAllUser(Pageable pageable){
		Page<User> page = userDao.findAll(pageable);
		return page;
	}
	
	public Page<User> searchByUserCode(String userCode,Pageable pageable){
		Page<User> userList = userDao.searchByUserCode(userCode, pageable);
		return userList;
	}
	
	public Page<User> searchByComCode(String comCode,Pageable pageable){
		Page<User> userList = userDao.searchByComCode(comCode, pageable);
		return userList;
	}
	
	public Page<User> searchByComCodeUserCode(String comCode,String userCode,Pageable pageable){
		Page<User> userList = userDao.searchByComCodeUserCode(comCode, userCode, pageable);
		return userList;
	}
	
	public Page<User> searchByUserName(String userName,Pageable pageable){
		Page<User> userList = userDao.searchByUserName(userName, pageable);
		return userList;
	}
	
	public Page<User> searchByNameCode(String userName,String userCode,Pageable pageable){
		Page<User> userList = userDao.searchByNameCode( userName, userCode, pageable);
		return userList;
	}
	
	public List<GeRmsTask> findByTaskId(){
		List<GeRmsTask> tasks=geRmsTaskRepository.findByTaskId();
		return tasks;
	}
	
	public List<GeRmsTask> findByParentIdIsasMenu(String parentId){
		List<GeRmsTask> tasks=geRmsTaskRepository.findByParentId(parentId);
		return tasks;
	}
	
	public List<GeRmsTask> findByIsasmenuTaskId(String comCode){
		List<GeRmsTask> tasks=geRmsTaskRepository.findByIsasmenuTaskId(comCode);
		return tasks;
	}
	
	public List<GeRmsTask> findByParentIdTaskId(String parentId,String comCode){
		List<GeRmsTask> tasks=geRmsTaskRepository.findByParentIdTaskId(parentId, comCode);
		return tasks;
	}
	
	public void InsertTask(String taskAuthID,String taskID,String comCode, String operateUser){
		geRmsTaskAuthRepository.InsertTask(taskAuthID, taskID, comCode, operateUser);
		
	}
	
	public void deleteTask(String comCode,String taskId){
		geRmsTaskAuthRepository.deleteTask(comCode, taskId);
	}
	
	public void updateTask(String comCode,String taskId){
		geRmsTaskAuthRepository.updateTask(comCode, taskId);
	}
	
	public List<String> findByComCode(String comCode){
		List<String> taskId=geRmsTaskAuthRepository.findByComCode(comCode);		
		return taskId;
	}
	
	public String findByTaskId(String taskId){
		String parentId=geRmsTaskRepository.findByTaskId(taskId);
		return parentId;
	}
	
	public Page<GeRmsGroup> findAll(Pageable pageable){
		Page<GeRmsGroup> page = (Page<GeRmsGroup>) geRmsGroupRepository.findAll(pageable);
		return page;
	}
	
	public Page<GeRmsGroup> findAllGroup(Pageable pageable){
		Page<GeRmsGroup> page = (Page<GeRmsGroup>) geRmsGroupRepository.findAllGroup(pageable);
		return page;	
	}
	
	public Page<GeRmsGroup> findByName(String name,Pageable pageable){
		Page<GeRmsGroup> page = geRmsGroupRepository.findByName(name,pageable);
		return page;
	}
	
	public void updateGroup(String groupId){
		geRmsGroupRepository.updateGroup(groupId);
	}
	
	public void updateGroup(String name,String des,String groupId){
		geRmsGroupRepository.updateGroup(name, des, groupId);
	}
	
	public void insertGroup(String groupId,String name,String des,String comcode,Date createTime,String createUser){
		geRmsGroupRepository.insertGroup(groupId, name, des, comcode, createTime, createUser);
	}
	
	public GeRmsGroup findByGroupId(String groupId){
		GeRmsGroup group = geRmsGroupRepository.findByGroupId(groupId);
		return group;
	}
	
	public Page<GeRmsRole> roleList(String groupId,Pageable pageable){
		Page<GeRmsRole> roleList = geRmsGroupRoleRepository.findByGroupId(groupId,pageable);
		return roleList;
	}
	
	public GeRmsRole findByRoleId(String roleId){
		GeRmsRole role = geRmsRoleRepository.findByRoleId(roleId);
		return role;
	}
	
	public Page<User> findUserByGroupId(String groupId,Pageable pageable){
		Page<User> userList = geRmsUserGroupRepository.findUserByGroupId(groupId,pageable);
		return userList;
	}
	
	public Page<User> findUserByUserCode(String userCode,Pageable pageable){
		Page<User> userList = geRmsUserGroupRepository.findUserByUserCode(userCode,pageable);
		return userList;
	}
	
	

}
