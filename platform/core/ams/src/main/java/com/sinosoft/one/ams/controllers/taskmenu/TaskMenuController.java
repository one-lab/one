package com.sinosoft.one.ams.controllers.taskmenu;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.ams.model.Task;
import com.sinosoft.one.ams.model.TaskAuth;
import com.sinosoft.one.ams.service.facade.TaskService;
import com.sinosoft.one.ams.utils.uiutil.NodeEntity;
import com.sinosoft.one.ams.utils.uiutil.Render;
import com.sinosoft.one.ams.utils.uiutil.TreeRender;
import com.sinosoft.one.ams.utils.uiutil.Treeable;
import com.sinosoft.one.ams.utils.uiutil.UIType;
import com.sinosoft.one.ams.utils.uiutil.UIUtil;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;

@Path
public class TaskMenuController {
	
	@Autowired
	private TaskService taskService;
	
	@Post({"taskTree","parentTask"})
	public Reply taskAll(Invocation inv) throws Exception {
		System.out.println("++++++++++++++++++++++++");
		List<Task>showTasks=taskService.findAllTasks();
		Map<String, Task> filter = new HashMap<String, Task>();
		List<Task> topList = new ArrayList<Task>();
		for (Task task : showTasks) {
			filter.put(task.getTaskID(), task);
			if (task.getParent() == null) {
				topList.add(task);
			}
		}
		Treeable<NodeEntity> treeable = creatTaskTreeAble(topList,filter);
		inv.getResponse().setContentType("text/html;charset=UTF-8");
		TreeRender render = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
		System.out.println(render.getResultForTest());
		render.render(inv.getResponse());
		return null;
	}
	
	//根据功能Id得到Task对象，并返回页面
	@Post("update/{taskId}")
	public Reply update(@Param("taskId") String taskId, Invocation inv) {
		
		Task task = taskService.findTaskByTaskId(taskId);
		
		if(task.getParent() == null){
			inv.addModel("parentName", "");
		}else{
			inv.addModel("parentName", task.getParent().getName());
		}
		
		return Replys.with(task).as(Json.class);
	}
	
	//新建或修改功能，保存
	@Post("saveTask/{parentID}")
	public Reply save(Task task,@Param("parentID")String parentId, Invocation inv) {

		TaskAuth taskAuth = new TaskAuth();
		taskService.save(task,parentId,taskAuth);
		
		return Replys.simple().success("success");
	}

	//-----------------------------------------------------------//
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
				if(!geRmsTask.getChildren().isEmpty()){
					nodeEntity.setChildren(creatSubNode(geRmsTask.getChildren(),filter));
					
				}
				nodeEntitys.add(nodeEntity);
			}
		return nodeEntitys;
	}
	
	
}
