package com.sinosoft.one.ams.service.spring;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.ams.User;
import com.sinosoft.one.ams.model.TaskAuth;
import com.sinosoft.one.ams.repositories.CompanyDao;
import com.sinosoft.one.ams.repositories.GeRmsTaskAuthRepository;
import com.sinosoft.one.ams.repositories.GeRmsTaskRepository;
import com.sinosoft.one.ams.service.facade.TaskAuthService;

@Component
public class TaskAuthServiceImpl implements TaskAuthService{

	@Autowired
	private GeRmsTaskAuthRepository geRmsTaskAuthRepository;
	@Autowired
	private GeRmsTaskRepository geRmsTaskRepository;
	@Autowired
	private CompanyDao companyDao;
	
	//保存修改后的功能授权
	public void save(String strId, String comCode, TaskAuth taskAuth) {
		Subject currentUser = SecurityUtils.getSubject();
		User user=(User) currentUser.getPrincipals().getPrimaryPrincipal();
		String name = user.getUserName();
		
		//查询当前机构已有的功能
		List<String> taskIdAuth = geRmsTaskAuthRepository.findAllTaskIdByComCode(comCode);
		
		//从页面传到后台的功能ID
		String[] taskId = strId.split(",");
		List<String> taskID = new ArrayList<String>();
		
		for(String id : taskId){
			taskID.add(id);
		}
		
		for (int i = 0; i < taskId.length; i++) {
			//新增功能			
			if (!taskIdAuth.contains(taskId[i])) {
				List<String> grandId = new ArrayList<String>();
				List<String> grand = new ArrayList<String>();
				//取得此功能的上辈功能
				grandId = grandTaskId(grand,taskId[i]);

				//如果没有上辈功能，先保存子功能的上辈功能
				if(!grandId.isEmpty())
					for(String id : grandId){
						if (!taskIdAuth.contains(id)) {
							TaskAuth grandtaskAuth = new TaskAuth();
							grandtaskAuth.setComCode(comCode);
							grandtaskAuth.setOperateUser(name);
							grandtaskAuth.setTask(geRmsTaskRepository.findOne(id));
							taskIdAuth.add(id);
							geRmsTaskAuthRepository.save(grandtaskAuth);
						}
					}
				TaskAuth grandtaskAuth = new TaskAuth();
				grandtaskAuth.setComCode(comCode);
				grandtaskAuth.setOperateUser(name);
				grandtaskAuth.setTask(geRmsTaskRepository.findOne(taskId[i]));
				taskIdAuth.add(taskId[i]);
				geRmsTaskAuthRepository.save(grandtaskAuth);
			}
		}
		
		//删除功能
		for(String id : taskIdAuth){
			
			if(!taskID.contains(id)){
				List<String> childComCode = new ArrayList<String>();
				
				//查出后代comCode
				childComCode = childComId(childComCode,comCode);
				//添加当前机构的comCode
				childComCode.add(comCode);
				
				List<TaskAuth> delTaskAuth = new ArrayList<TaskAuth>();
				for(String childId : childComCode){
					//查出功能授权ID
					String taskAuthId = geRmsTaskAuthRepository.findTaskAuthIdByComCodeTaskId(childId, id);
					if(taskAuthId != null){
						//将将要删除的功能授权存入delTaskAuth集合中
						delTaskAuth.add(geRmsTaskAuthRepository.findOne(taskAuthId));
					}
				}
				//删除功能授权
				geRmsTaskAuthRepository.delete(delTaskAuth);
			}
			
		}
		
	}
	
	
	
	//查询此功能的上辈功能ID
	List<String> grandTaskId(List<String> grandId,String taskId){
		String parentId = geRmsTaskRepository.findParentIdByTaskId(taskId);
		if(parentId != null){
			grandId.add(parentId);
			grandTaskId(grandId,parentId);
		}
		return grandId;
	}
	
	//查询此机构的后代机构ID
	List<String> childComId(List<String> childComCode,String comCode){
		List<String> childId = companyDao.findComCodeByUppercomcode(comCode);
		if(!childId.isEmpty()){
			
			childComCode.addAll(childId);
			for(String id : childId){
				childComId(childComCode,id);
			}
		}
		return childComCode;
	}

	public List<String> findAllTaskIdByComCode(String comCode) {
		return geRmsTaskAuthRepository.findAllTaskIdByComCode(comCode);
	}	

}
