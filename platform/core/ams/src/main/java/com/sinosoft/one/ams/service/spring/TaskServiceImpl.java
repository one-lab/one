package com.sinosoft.one.ams.service.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.TaskUtils;
import org.springframework.stereotype.Component;

import com.sinosoft.one.ams.model.Employe;
import com.sinosoft.one.ams.model.Task;
import com.sinosoft.one.ams.model.TaskAuth;
import com.sinosoft.one.ams.repositories.GeRmsTaskRepository;
import com.sinosoft.one.ams.service.facade.TaskService;
import com.sinosoft.one.ams.utils.uiutil.NodeEntity;
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
	public void pushTask(NodeEntity nodeEntity, List<Task> taskList) {
		// TODO Auto-generated method stub
		
	}
	public void recursionTask(NodeEntity nodeEntity, String parentId) {
		// TODO Auto-generated method stub
		
	}
	
	//根据主键查出Task对象
	public Task findTaskByTaskId(String taskId) {
		Task task = geRmsTaskRepository.findOne(taskId);
		return task;
	}
	
	//保存功能和功能授权
	public void save(Task task,String parentId, TaskAuth taskAuth) {
		Employe user = (Employe) inv.getRequest().getSession().getAttribute("user");
		Task taskCheck = geRmsTaskRepository.findOne(task.getTaskID());
		
		if(taskCheck == null){
			task.setSysFlag("RMS");
			Task parentTask = geRmsTaskRepository.findOne(parentId);
			task.setParent(parentTask);
			geRmsTaskRepository.save(task);
			taskAuth.setTask(task);
			taskAuth.setOperateUser(user.getUserName());
			if (task.getFlag().equals("*")) {
				taskAuth.setComCode("*");
			} else {
				taskAuth.setComCode(user.getCompany().getComCode());
			}
			System.out.println("check----------1");
			geRmsTaskAuthRepository.save(taskAuth);
			System.out.println("check----------2");
		}else{
			Task parentTask = geRmsTaskRepository.findOne(parentId);
//			geRmsTaskRepository.updateTask(task.getName(), task.getMenuName(), task.getMenuURL(), task.getDes(), parentTask.getTaskID(), task.getIsValidate(), task.getIsAsMenu(),task.getFlag(), task.getTaskID());
			
			if(task.getFlag() == ""){
				System.out.println("+++++++++++++++++++"+user.getCompany().getComCode());
				task.setFlag(user.getCompany().getComCode());
			}
//			taskAuth = geRmsTaskAuthRepository.findTaskAuthByComCode(user.getCompany().getComCode(), task.getTaskID());
			System.out.println(taskAuth+"+++++++++++++==============");
			if(!task.getFlag().equals(taskAuth.getComCode())){
				geRmsTaskAuthRepository.updateTaskAuth(task.getFlag(), user.getCompany().getComCode(), task.getTaskID());
			}
			
		}
	}
	
	//获取所有Task集合
	public List<Task> findAllTasks() {
		return (List<Task>)geRmsTaskRepository.findAll();
	}
	
	
//	public void save(Task task, TaskAuth taskAuth) {
//<<<<<<< HEAD
//=======
//		User user = (User) inv.getRequest().getSession().getAttribute("user");
//		GeRmsTask taskCheck = geRmsTaskRepository.findOne(task.getTaskID());
//		if(task.getFlag().equals("")){
//			task.setFlag(user.getComCode());
//		}
//		if(taskCheck == null){
//			geRmsTaskRepository.save(task);
//			taskAuth.setTaskID(task.getTaskID());
//			taskAuth.setOperateUser(user.getUserName());
//			if (task.getFlag().equals("*")) {
//				taskAuth.setComCode("*");
//				taskAuth.setTaskAuthID(task.getTaskID() + "*");
//			} else {
//				taskAuth.setComCode(user.getComCode());
//				taskAuth.setTaskAuthID(task.getTaskID() + user.getComCode());
//			}
//			
//			geRmsTaskAuthRepository.save(taskAuth);
//		}else{
//			geRmsTaskRepository.updateTask(task.getName(), task.getMenuName(), task.getMenuURL(), task.getDes(), task.getParentID(), task.getIsValidate(), task.getIsAsMenu(),task.getFlag(), task.getTaskID());
//			if(!task.getFlag().equals(taskCheck.getFlag())){
//				geRmsTaskAuthRepository.updateTaskAuth(task.getFlag(), user.getComCode(), task.getTaskID());
//			}
//		}
//		
//>>>>>>> 961820694854296cf69d9822b5b44a369d2ee74b
//		
//	}

	
//	//将功能集合送入NodeEntity对象保存
//	public void pushTask(NodeEntity nodeEntity, List<GeRmsTask> taskList) {
//		List<NodeEntity> nodeEntities = new ArrayList<NodeEntity>();
//
//		for (GeRmsTask task : taskList) {
//			NodeEntity ne = new NodeEntity();
//
//			ne.setId(task.getTaskID());
//			ne.setTitle(task.getName());
//			ne.setState("close");
//			nodeEntities.add(ne);
//		}
//		nodeEntity.setChildren(nodeEntities);
//		
//	}
//	
//	//利用递归，将全部功能存入NodeEntity对象中
//	public void recursionTask(NodeEntity nodeEntity, String parentId) {
//		List<GeRmsTask> taskList;
//		if(parentId != null){
//			taskList = geRmsTaskRepository.findTaskByParentId(parentId);
//			
//		}else{
//			//根据parentId为空查询出Task集合
//			taskList = geRmsTaskRepository.findTaskByParentId();
//		}
//		//将功能集合送入NodeEntity对象保存
//		pushTask(nodeEntity, taskList);
//		if (taskList != null)
//			for (NodeEntity ne : nodeEntity.getChildren()) {
//				recursionTask(ne, ne.getId());
//			}
//	}
//	
//	//根据功能Id查出Task对象
//	public GeRmsTask findTaskByTaskId(String taskId) {
//		GeRmsTask task = geRmsTaskRepository.findTaskByTaskId(taskId);
//		return task;
//	}
//	
//	
//	public void save(GeRmsTask task,GeRmsTaskAuth taskAuth) {
//		User user = (User) inv.getRequest().getSession().getAttribute("user");
//		GeRmsTask taskCheck = geRmsTaskRepository.findOne(task.getTaskID());
//		
//		if(taskCheck == null){
//			geRmsTaskRepository.save(task);
//			taskAuth.setTaskID(task.getTaskID());
//			taskAuth.setOperateUser(user.getUserName());
//			if (task.getFlag().equals("*")) {
//				taskAuth.setComCode("*");
//				taskAuth.setTaskAuthID(task.getTaskID() + "*");
//			} else {
//				taskAuth.setComCode(user.getComCode());
//				taskAuth.setTaskAuthID(task.getTaskID() + user.getComCode());
//			}
//			
//			geRmsTaskAuthRepository.save(taskAuth);
//		}else{
//			geRmsTaskRepository.updateTask(task.getName(), task.getMenuName(), task.getMenuURL(), task.getDes(), task.getParentID(), task.getIsValidate(), task.getIsAsMenu(),task.getFlag(), task.getTaskID());
//		}
//		
//		
//	}
	

}
