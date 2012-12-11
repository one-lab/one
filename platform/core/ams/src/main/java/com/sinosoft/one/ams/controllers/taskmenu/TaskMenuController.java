package com.sinosoft.one.ams.controllers.taskmenu;


import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.ams.model.GeRmsTask;
import com.sinosoft.one.ams.model.GeRmsTaskAuth;
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

@Path("task")
public class TaskMenuController {
	
	@Autowired
	private TaskService taskService;
	
	@SuppressWarnings("rawtypes")
	@Post("taskAll")
	public Reply taskAll(Invocation inv) throws Exception {

		NodeEntity nodeEntity = new NodeEntity("RMS001", "权限管理", "close");
		
		// 利用递归,将功能存入nodeEntity
		taskService.recursionTask(nodeEntity, null);

		@SuppressWarnings("unchecked")
		Treeable<NodeEntity> treeable = new Treeable.Builder(nodeEntity.getChildren(), "id", "title", "children", "state").builder();
		inv.getResponse().setContentType("text/html;charset=UTF-8");
		Render render = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
		render.render(inv.getResponse());
		return null;
	}
	
	//根据功能Id得到Task对象，并返回页面
	@Post("update/{taskId}")
	public Reply update(@Param("taskId") String taskId, Invocation inv) {
		GeRmsTask task = taskService.findTaskByTaskId(taskId);
		return Replys.with(task).as(Json.class);
	}
	
	//获取功能并返回到页面
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Post("parentTask")
	public Reply parentTask(Invocation inv) throws Exception {
		
		NodeEntity nodeEntity = new NodeEntity("RMS000", "权限", "close");
		taskService.recursionTask(nodeEntity, null);
		Treeable<NodeEntity> treeable = new Treeable.Builder(nodeEntity.getChildren(), "id", "title", "children", "state").builder();
		
		inv.getResponse().setContentType("text/html;charset=UTF-8");
		Render render = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
		render.render(inv.getResponse());
		return null;
	}
	
	//新建或修改功能，保存
	@Post("saveTask")
	public Reply save(GeRmsTask task, Invocation inv) {
		
		task.setSysFlag("RMS");
		GeRmsTaskAuth taskAuth = new GeRmsTaskAuth();
		taskService.save(task,taskAuth);
		
		return Replys.simple().success("success");
	}

}
