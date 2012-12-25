package com.sinosoft.one.ams.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.mysema.query.group.Group;
import com.sinosoft.one.ams.model.BusPower;
import com.sinosoft.one.ams.model.Company;
import com.sinosoft.one.ams.model.Employe;
import com.sinosoft.one.ams.model.Role;
import com.sinosoft.one.ams.model.Task;
import com.sinosoft.one.ams.model.UserPower;
import com.sinosoft.one.ams.repositories.GeRmsBusPowerRepository;
import com.sinosoft.one.ams.repositories.GeRmsCompanyRepository;
import com.sinosoft.one.ams.repositories.GeRmsGroupRepository;
import com.sinosoft.one.ams.repositories.GeRmsGroupRoleRepositoriy;
import com.sinosoft.one.ams.repositories.GeRmsRoleRepository;
import com.sinosoft.one.ams.repositories.GeRmsUserPowerRepository;
import com.sinosoft.one.ams.repositories.UserDao;
import com.sinosoft.one.ams.utils.uiutil.NodeEntity;
import com.sinosoft.one.ams.utils.uiutil.Treeable;

/**
 * 公共使用业务接口 人员/机构
 * @author Administrator
 *
 */
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

//
//	public Company company(String comCode) {
//		Company company = geRmsCompanyRepository.findByComCode(comCode);
//		return company;
//	}
//
	
//	public Page<Employe> findAllUser(Pageable pageable) {
//		Page<Employe> page = userDao.findAll(pageable);
//		return page;
//	}
//
//	public Page<Employe> searchUserByUserCode(String userCode, Pageable pageable) {
//		Page<Employe> userList = userDao.searchUserByUserCode(userCode, pageable);
//		return userList;
//	}
//
//	public Page<Employe> searchUserByComCode(String comCode, Pageable pageable) {
//		Page<Employe> userList = userDao.searchUserByComCode(comCode, pageable);
//		return userList;
//	}
//
//	public Page<Employe> searchUserByComCodeUserCode(String comCode, String userCode,
//			Pageable pageable) {
//		Page<Employe> userList = userDao.searchUserByComCodeUserCode(comCode,
//				userCode, pageable);
//		return userList;
//	}
//
//	public void updateGroup(String groupId) {
//		geRmsGroupRepository.updateIsvalidateByGroupId(groupId);
//	}
//
//
//	public Group findGroupByGroupId(String groupId) {
//		Group group = geRmsGroupRepository.findGroupByGroupId(groupId);
//		return group;
//	}
//
//	public Page<Role> roleList(String groupId, Pageable pageable) {
//		Page<Role> roleList = geRmsGroupRoleRepository.findByGroupId(
//				groupId, pageable);
//		return roleList;
//	}
//
//	public Role findByRoleId(String roleId) {
//		Role role = geRmsRoleRepository.findOne(roleId);
//		return role;
//	}
//	
//	public List<String> findComCodeByUserCode(String userCode){
//		List<String> comCodeList = geRmsUserPowerRepository.findComCodeByUserCode(userCode);
//		return comCodeList;
//	}
//
//	public List<BusPower> findByUserPowerIdTaskId(String userPowerId,String taskId){
//		List<Role> busPowerList = geRmsBusPowerRepository.findByUserPowerIdTaskId(userPowerId, taskId);
//		return busPowerList;
//	}
//	
	//----------------------------------工具------------------------------//
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  Treeable<NodeEntity> creatTaskTreeAble(List<Task> checkedTasks,List<Task> showTasks){
		ArrayList<NodeEntity> nodeEntitys=new ArrayList<NodeEntity>();
		
		for (Task geRmsTask : showTasks) {
			if(geRmsTask.getParent()==null){
				NodeEntity nodeEntity=new NodeEntity();
				nodeEntity.setId(geRmsTask.getTaskID());
				nodeEntity.setTitle(geRmsTask.getName());
				nodeEntity.setChildren(creatSubNode(geRmsTask,checkedTasks, showTasks));
				for (Task checkedTask : checkedTasks) {
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
	
	List<NodeEntity> creatSubNode(Task superTask ,List<Task> checkedTasks,List<Task> showTasks){
		ArrayList<NodeEntity> nodeEntitys=new ArrayList<NodeEntity>();
		for (Task geRmsTask : showTasks) {
			if(geRmsTask.getParent()!=null&&!geRmsTask.getParent().getTaskID().toString().equals("")){
				if (geRmsTask.getTaskID().toString().toString().equals(superTask.getTaskID().toString())) {
					NodeEntity nodeEntity = new NodeEntity();
					nodeEntity.setId(geRmsTask.getTaskID());
					nodeEntity.setTitle(geRmsTask.getName());
					nodeEntity.setChildren(creatSubNode(geRmsTask,checkedTasks,showTasks));
					for (Task checkedTask : checkedTasks) {
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
