package com.sinosoft.one.ams.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.sinosoft.one.ams.model.GeRmsBusPower;
import com.sinosoft.one.ams.model.GeRmsCompany;
import com.sinosoft.one.ams.model.GeRmsGroup;
import com.sinosoft.one.ams.model.GeRmsRole;
import com.sinosoft.one.ams.model.GeRmsTask;
import com.sinosoft.one.ams.model.User;
import com.sinosoft.one.ams.repositories.GeRmsBusPowerRepository;
import com.sinosoft.one.ams.repositories.GeRmsCompanyRepository;
import com.sinosoft.one.ams.repositories.GeRmsGroupRepository;
import com.sinosoft.one.ams.repositories.GeRmsGroupRoleRepositoriy;
import com.sinosoft.one.ams.repositories.GeRmsRoleRepository;
import com.sinosoft.one.ams.repositories.GeRmsUserPowerRepository;
import com.sinosoft.one.ams.repositories.UserDao;
import com.sinosoft.one.ams.utils.uiutil.NodeEntity;
import com.sinosoft.one.ams.utils.uiutil.Treeable;

@Component
public class AccountManager {
	
	@Autowired
	private GeRmsCompanyRepository geRmsCompanyRepository;
	@Autowired
	private UserDao userDao;
	@Autowired
	private GeRmsGroupRepository geRmsGroupRepository;
	@Autowired
	private GeRmsGroupRoleRepositoriy geRmsGroupRoleRepository;
	@Autowired
	private GeRmsRoleRepository geRmsRoleRepository;
	@Autowired
	private GeRmsUserPowerRepository geRmsUserPowerRepository;
	@Autowired
	private GeRmsBusPowerRepository geRmsBusPowerRepository;


	public GeRmsCompany company(String comCode) {
		GeRmsCompany company = geRmsCompanyRepository.findByComCode(comCode);
		return company;
	}

	public User findByUsername(String userName) {
		User user = userDao.findByUsername(userName);
		return user;
	}

	public Page<User> findAllUser(Pageable pageable) {
		Page<User> page = userDao.findAll(pageable);
		return page;
	}

	public Page<User> searchUserByUserCode(String userCode, Pageable pageable) {
		Page<User> userList = userDao.searchUserByUserCode(userCode, pageable);
		return userList;
	}

	public Page<User> searchUserByComCode(String comCode, Pageable pageable) {
		Page<User> userList = userDao.searchUserByComCode(comCode, pageable);
		return userList;
	}

	public Page<User> searchUserByComCodeUserCode(String comCode, String userCode,
			Pageable pageable) {
		Page<User> userList = userDao.searchUserByComCodeUserCode(comCode,
				userCode, pageable);
		return userList;
	}

	public void updateGroup(String groupId) {
		geRmsGroupRepository.updateIsvalidateByGroupId(groupId);
	}


	public GeRmsGroup findGroupByGroupId(String groupId) {
		GeRmsGroup group = geRmsGroupRepository.findGroupByGroupId(groupId);
		return group;
	}

	public Page<GeRmsRole> roleList(String groupId, Pageable pageable) {
		Page<GeRmsRole> roleList = geRmsGroupRoleRepository.findByGroupId(
				groupId, pageable);
		return roleList;
	}

	public GeRmsRole findByRoleId(String roleId) {
		GeRmsRole role = geRmsRoleRepository.findRoleById(roleId);
		return role;
	}
	
	public List<String> findComCodeByUserCode(String userCode){
		List<String> comCodeList = geRmsUserPowerRepository.findComCodeByUserCode(userCode);
		return comCodeList;
	}

	public List<GeRmsBusPower> findByUserPowerIdTaskId(String userPowerId,String taskId){
		List<GeRmsBusPower> busPowerList = geRmsBusPowerRepository.findByUserPowerIdTaskId(userPowerId, taskId);
		return busPowerList;
	}
	
	//----------------------------------工具------------------------------//
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  Treeable<NodeEntity> creatTaskTreeAble(List<GeRmsTask> checkedTasks,List<GeRmsTask> showTasks){
		ArrayList<NodeEntity> nodeEntitys=new ArrayList<NodeEntity>();
		
		for (GeRmsTask geRmsTask : showTasks) {
			if(geRmsTask.getParentID()==null){
				NodeEntity nodeEntity=new NodeEntity();
				nodeEntity.setId(geRmsTask.getTaskID());
				nodeEntity.setTitle(geRmsTask.getName());
				nodeEntity.setChildren(creatSubNode(geRmsTask,checkedTasks, showTasks));
				for (GeRmsTask checkedTask : checkedTasks) {
					if(checkedTask.getTaskID().toString().equals(geRmsTask.getTaskID().toString())){
						nodeEntity.setClassField("jstree-checked");
					}
				}
				nodeEntitys.add(nodeEntity);
			}
		}
		Treeable<NodeEntity> treeable =new Treeable.Builder(nodeEntitys,"id", "title", "children", "state").classField("classField").urlField("urlField").builder();
		return treeable;
	}
	
	List<NodeEntity> creatSubNode(GeRmsTask superTask ,List<GeRmsTask> checkedTasks,List<GeRmsTask> showTasks){
		ArrayList<NodeEntity> nodeEntitys=new ArrayList<NodeEntity>();
		for (GeRmsTask geRmsTask : showTasks) {
			if(geRmsTask.getParentID()!=null&&!geRmsTask.getParentID().toString().equals("")){
				if (geRmsTask.getParentID().toString().equals(superTask.getTaskID().toString())) {
					NodeEntity nodeEntity = new NodeEntity();
					nodeEntity.setId(geRmsTask.getTaskID());
					nodeEntity.setTitle(geRmsTask.getName());
					nodeEntity.setChildren(creatSubNode(geRmsTask,checkedTasks,showTasks));
					for (GeRmsTask checkedTask : checkedTasks) {
						if(checkedTask.getTaskID().toString().equals(geRmsTask.getTaskID().toString())){
							nodeEntity.setClassField("jstree-closed jstree-unchecked");
						}
					}
					nodeEntitys.add(nodeEntity);
				}
			}
		}
		return nodeEntitys;
	}

}
