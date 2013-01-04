package com.sinosoft.one.ams.service.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.ams.model.Employe;
import com.sinosoft.one.ams.model.ExcPower;
import com.sinosoft.one.ams.model.Task;
import com.sinosoft.one.ams.model.TaskAuth;
import com.sinosoft.one.ams.model.UserPower;
import com.sinosoft.one.ams.repositories.GeRmsTaskRepository;
import com.sinosoft.one.ams.repositories.GeRmsUserPowerRepository;
import com.sinosoft.one.ams.service.facade.TaskService;
import com.sinosoft.one.ams.utils.uiutil.NodeEntity;
import com.sinosoft.one.ams.utils.uiutil.Treeable;
import com.sinosoft.one.ams.repositories.GeRmsTaskAuthRepository;
import com.sinosoft.one.mvc.web.Invocation;

@Component
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private GeRmsTaskRepository geRmsTaskRepository;
	@Autowired
	private GeRmsTaskAuthRepository geRmsTaskAuthRepository;
	@Autowired
	private GeRmsUserPowerRepository geRmsUserPowerRepository;
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
	
	//查询当前机构，当前用户组的根权限
	public List<Task> findTaskByRoleIds(List<String> roleids,String comCode) {
		List<Task> resultTask = new ArrayList<Task>();
		
		List<String>roletaskids = geRmsTaskAuthRepository.findTaskAuthByRole(roleids);
		List<String>comtaskids = geRmsTaskAuthRepository.findAllTaskIdByComCode(comCode);
		
		List<String> resultid = new ArrayList<String>();
		
		for (String comtaskid : comtaskids) {
			for (String roletaskid : roletaskids) {
				if (comtaskid.toString().equals(roletaskid.toString())) {
					resultid.add(comtaskid);
					break;
				}
			}
		}
		List<Task> tasks = null;
		if(!resultid.isEmpty()){
			tasks = (List<Task>) geRmsTaskRepository.findAll(resultid);
		}
		if(tasks != null)
			for(Task task : tasks){
				if(task.getParent() == null && task.getIsValidate().toString().equals("1")){
					resultTask.add(task);
				}
			}
		return resultTask;
	}

	/**
	 * 构建功能树 topTasks父节点 filter所有节点
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  Treeable<NodeEntity> creatTaskTreeAble(List<Task> topTasks,Map<String,Task> filter){
		List<NodeEntity> nodeEntitys=new ArrayList<NodeEntity>();
		nodeEntitys=creatSubNode(topTasks, filter);
		Treeable<NodeEntity> treeable =new Treeable.Builder(nodeEntitys,"id", "title", "children", "state").classField("classField").urlField("urlField").builder();
		return treeable;
	}
	
	List<NodeEntity> creatSubNode(List<Task> topTasks,Map<String,Task> filter){
		ArrayList<NodeEntity> nodeEntitys=new ArrayList<NodeEntity>();
		for (Task geRmsTask : topTasks) {
			if(!filter.containsKey(geRmsTask.getTaskID()))
                continue;
			NodeEntity nodeEntity = new NodeEntity();
			nodeEntity.setId(geRmsTask.getTaskID());
			nodeEntity.setTitle(geRmsTask.getName());
			if(!filter.get(geRmsTask.getTaskID()).getFlag().toString().equals("1")){
				nodeEntity.setClassField("jstree-checked");
			}else{
				nodeEntity.setClassField("jstree-unchecked");
			}
			if(!geRmsTask.getChildren().isEmpty()){
				nodeEntity.setChildren(creatSubNode(geRmsTask.getChildren(),filter));
				int n1 = nodeEntity.getChildren().size();
				int n2 = 0;
				for(NodeEntity no : nodeEntity.getChildren()){
					if(no.getClassField().equals("jstree-checked")){
						n2 ++;
					}
				}
				if(n2 > 0 && n2 < n1){
					nodeEntity.setClassField("jstree-undetermined");
				}else if(n2 == 0){
					nodeEntity.setClassField("jstree-unchecked");
				}else{
					nodeEntity.setClassField("jstree-checked");
				}
			}
			nodeEntitys.add(nodeEntity);
			}
		return nodeEntitys;
	}

	//查询当前机构的角色的当前根权限的后代权限
	public Treeable<NodeEntity> getTreeable(String roleIdStr, String comCode,
			String taskId) {
		
		//查询当前机构的角色的当前根权限的后代权限(集合)
		List<Task> tasks = taskChildren(roleIdStr, comCode, taskId);
		
		List<Task> topTasks = new ArrayList<Task>();
		Map<String,Task> filter = new HashMap<String, Task>();
		Task topTask = geRmsTaskRepository.findOne(taskId);
		topTask.setFlag("0");
		topTasks.add(topTask);
		
		for(Task task : tasks){
			task.setFlag("0");
			filter.put(task.getTaskID(), task);
		}
		Treeable<NodeEntity> treeable = creatTaskTreeAble(topTasks, filter);
		return treeable;
	}
	
	//查询当前机构的角色的当前根权限的后代权限(集合)
	public List<Task> taskChildren(String roleIdStr, String comCode,
			String taskId){
		String[] roleIds = roleIdStr.split(",");
		List<String> roleids = new ArrayList<String>();
		for(String id : roleIds){
			roleids.add(id);
		}
		
		List<String>roletaskids = geRmsTaskAuthRepository.findTaskAuthByRole(roleids);
		List<String>comtaskids = geRmsTaskAuthRepository.findAllTaskIdByComCode(comCode);
		
		List<String> resultid = new ArrayList<String>();
		
		for (String comtaskid : comtaskids) {
			for (String roletaskid : roletaskids) {
				if (comtaskid.toString().equals(roletaskid.toString())) {
					resultid.add(comtaskid);
					break;
				}
			}
		}
		List<Task> tasks = (List<Task>) geRmsTaskRepository.findAll(resultid);
		return tasks;
	}

	//查询当前机构，当前用户组的根权限，并标记权限是否赋了给用户
	public List<Task> findTaskByRoleIds(List<String> roleids, String comCode,
			String userCode) {
		List<String> taskIds = new ArrayList<String>();
		
		//获取根权限
		List<Task> tasks = findTaskByRoleIds(roleids, comCode);
		for(Task task : tasks){
			taskIds.add(task.getTaskID());
		}
		
		//检查权限在权限出外表中是否存在
		checkTask (userCode,comCode,tasks);
		
		return tasks;
	}
	
	//查询当前机构的角色的当前根权限的后代权限，并检查权限在权限除外表中是否存在
	public Treeable<NodeEntity> getTreeable(String roleIdStr, String comCode,
			String userCode, String taskId) {
		
		//查询当前机构的角色的当前根权限的后代权限(集合)
		List<Task> tasks = taskChildren(roleIdStr, comCode, taskId);
		
		//检查权限在权限除外表中是否存在
		checkTask (userCode,comCode,tasks);
		
		List<Task> topTasks = new ArrayList<Task>();
		Map<String,Task> filter = new HashMap<String, Task>();
		Task topTask = geRmsTaskRepository.findOne(taskId);
		topTasks.add(topTask);
		
		for(Task task : tasks){
			filter.put(task.getTaskID(), task);
		}
		Treeable<NodeEntity> treeable = creatTaskTreeAble(topTasks, filter);
		return treeable;
	}
	
	//检查权限在权限出外表中是否存在
	public void checkTask (String userCode,String comCode,List<Task> tasks){
		String userPowerId = geRmsUserPowerRepository.findIdByUserCodeComCode(userCode, comCode);
		
		UserPower userPower = geRmsUserPowerRepository.findOne(userPowerId);
		
		List<String> CheckTaskIds = new ArrayList<String>();
		List<ExcPower> excPowers = userPower.getExcPowers();
		for(ExcPower excPower : excPowers){
			CheckTaskIds.add(excPower.getTask().getTaskID());
		}
		
		for(Task task : tasks){
			if(CheckTaskIds.contains(task.getTaskID())){
				task.setFlag("1");
			}else{
				task.setFlag("0");
			}
			
		}
	}
	
	

}
