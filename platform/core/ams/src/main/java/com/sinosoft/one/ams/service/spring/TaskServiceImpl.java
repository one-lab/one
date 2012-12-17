package com.sinosoft.one.ams.service.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.ams.model.Employe;
import com.sinosoft.one.ams.model.Task;
import com.sinosoft.one.ams.model.TaskAuth;
import com.sinosoft.one.ams.repositories.GeRmsTaskRepository;
import com.sinosoft.one.ams.service.facade.TaskService;
import com.sinosoft.one.ams.repositories.GeRmsTaskAuthRepository;
import com.sinosoft.one.mvc.web.Invocation;

@Component
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private GeRmsTaskRepository geRmsTaskRepository;
	@Autowired
	private GeRmsTaskAuthRepository geRmsTaskAuthRepository;
	@Autowired
	private Invocation inv;
	
	//根据主键查出Task对象
	public Task findTaskByTaskId(String taskId) {
		Task task = geRmsTaskRepository.findOne(taskId);
		Employe user = (Employe) inv.getRequest().getSession().getAttribute("user");
		String taskAuthId = geRmsTaskAuthRepository.findTaskAuthIdByComCodeTaskId(user.getCompany().getComCode(), task.getTaskID());
		
		//判断此功能的功能授权是默认类型，还是所有可见类型
		if(taskAuthId != null){
			task.setFlag("");
		}else{
			task.setFlag("*");
		}
		return task;
	}
	
	//保存功能和功能授权
	public void save(Task task,String parentId, TaskAuth taskAuth) {
		Employe user = (Employe) inv.getRequest().getSession().getAttribute("user");
		Task taskCheck = geRmsTaskRepository.findOne(task.getTaskID());
		
		task.setSysFlag("RMS");
		Task parentTask = geRmsTaskRepository.findOne(parentId);
		task.setParent(parentTask);
		
		//保存Task对象
		geRmsTaskRepository.save(task);
		
		//判断功能授权是新增，还是修改
		if(taskCheck == null){
			taskAuth.setTask(task);
			taskAuth.setOperateUser(user.getUserName());
			if (task.getFlag().equals("*")) {
				taskAuth.setComCode("*");
			} else {
				taskAuth.setComCode(user.getCompany().getComCode());
			}
			//新增，并保存TaskAuth对象
			geRmsTaskAuthRepository.save(taskAuth);
		}else{
			
			if(task.getFlag() == ""){
				task.setFlag(user.getCompany().getComCode());
			}
			
			//查询功能授权是否为默认类型，如果是，taskAuthId1不为空
			String taskAuthId1 = geRmsTaskAuthRepository.findTaskAuthIdByComCodeTaskId(user.getCompany().getComCode(), task.getTaskID());
			if(taskAuthId1 != null){
				TaskAuth ta1 = geRmsTaskAuthRepository.findOne(taskAuthId1);
				
				//判断功能授权是否需要修改
				if(!task.getFlag().equals(ta1.getComCode()) && task.getFlag().equals("*")){
					ta1.setComCode("*");
					geRmsTaskAuthRepository.save(ta1);
					return ;
				}
			}
			
			//查询功能授权是否为所有可见类型，如果是，taskAuthId2不为空
			String taskAuthId2 = geRmsTaskAuthRepository.findTaskAuthIdByComCodeTaskId("*", task.getTaskID());
			if(taskAuthId2 != null){
				TaskAuth ta2 = geRmsTaskAuthRepository.findOne(taskAuthId2);
				
				//判断功能授权是否需要修改
				if(!task.getFlag().equals(ta2.getComCode()) && !task.getFlag().equals("*")){
					ta2.setComCode(user.getCompany().getComCode());
					List<String> TaskAuthIdList = geRmsTaskAuthRepository.findTaskAuthIDByTaskId(ta2.getTask().getTaskID());
					List<TaskAuth> taskAuthList = (List<TaskAuth>) geRmsTaskAuthRepository.findAll(TaskAuthIdList);
					geRmsTaskAuthRepository.delete(taskAuthList);
					geRmsTaskAuthRepository.save(ta2);
				}
			}
			
		}
	}
	
	//获取所有Task集合
	public List<Task> findAllTasks() {
		return (List<Task>)geRmsTaskRepository.findAll();
	}	

}
