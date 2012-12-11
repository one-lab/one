package com.sinosoft.one.ams.service.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.ams.model.GeRmsTask;
import com.sinosoft.one.ams.model.GeRmsTaskAuth;
import com.sinosoft.one.ams.model.User;
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
	
	//将功能集合送入NodeEntity对象保存
	public void pushTask(NodeEntity nodeEntity, List<GeRmsTask> taskList) {
		// TODO Auto-generated method stub
		List<NodeEntity> nodeEntities = new ArrayList<NodeEntity>();

		for (GeRmsTask task : taskList) {
			NodeEntity ne = new NodeEntity();

			ne.setId(task.getTaskID());
			ne.setTitle(task.getName());
			ne.setState("close");
			nodeEntities.add(ne);
		}
		nodeEntity.setChildren(nodeEntities);
		
	}
	
	//利用递归，将全部功能存入NodeEntity对象中
	public void recursionTask(NodeEntity nodeEntity, String parentId) {
		// TODO Auto-generated method stub
		List<GeRmsTask> taskList;
		if(parentId != null){
			taskList = geRmsTaskRepository.findTaskByParentId(parentId);
			
		}else{
			//根据parentId为空查询出Task集合
			taskList = geRmsTaskRepository.findTaskByParentId();
		}
		//将功能集合送入NodeEntity对象保存
		pushTask(nodeEntity, taskList);
		if (taskList != null)
			for (NodeEntity ne : nodeEntity.getChildren()) {
				recursionTask(ne, ne.getId());
			}
	}
	
	//根据功能Id查出Task对象
	public GeRmsTask findTaskByTaskId(String taskId) {
		// TODO Auto-generated method stub
		GeRmsTask task = geRmsTaskRepository.findTaskByTaskId(taskId);
		return task;
	}
	
	//保存功能和功能授权
	public void save(GeRmsTask task,GeRmsTaskAuth taskAuth) {
		// TODO Auto-generated method stub
		User user = (User) inv.getRequest().getSession().getAttribute("user");
		GeRmsTask taskCheck = geRmsTaskRepository.findOne(task.getTaskID());
		if(task.getFlag().equals("")){
			task.setFlag(user.getComCode());
		}
		if(taskCheck == null){
			geRmsTaskRepository.save(task);
			taskAuth.setTaskID(task.getTaskID());
			taskAuth.setOperateUser(user.getUserName());
			if (task.getFlag().equals("*")) {
				taskAuth.setComCode("*");
				taskAuth.setTaskAuthID(task.getTaskID() + "*");
			} else {
				taskAuth.setComCode(user.getComCode());
				taskAuth.setTaskAuthID(task.getTaskID() + user.getComCode());
			}
			
			geRmsTaskAuthRepository.save(taskAuth);
		}else{
			geRmsTaskRepository.updateTask(task.getName(), task.getMenuName(), task.getMenuURL(), task.getDes(), task.getParentID(), task.getIsValidate(), task.getIsAsMenu(),task.getFlag(), task.getTaskID());
			if(!task.getFlag().equals(taskCheck.getFlag())){
				geRmsTaskAuthRepository.updateTaskAuth(task.getFlag(), user.getComCode(), task.getTaskID());
			}
		}
		
		
	}
	

}
