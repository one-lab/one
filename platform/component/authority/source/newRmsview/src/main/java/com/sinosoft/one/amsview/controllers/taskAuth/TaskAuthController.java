package com.sinosoft.one.amsview.controllers.taskAuth;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.ams.User;
import com.sinosoft.one.ams.model.Company;
import com.sinosoft.one.ams.model.Task;
import com.sinosoft.one.ams.model.TaskAuth;
import com.sinosoft.one.ams.service.facade.CompanyService;
import com.sinosoft.one.ams.service.facade.TaskAuthService;
import com.sinosoft.one.ams.service.facade.TaskService;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.newRms.client.ShiroLoginUser;
import com.sinosoft.one.uiutil.NodeEntity;
import com.sinosoft.one.uiutil.Render;
import com.sinosoft.one.uiutil.TreeRender;
import com.sinosoft.one.uiutil.Treeable;
import com.sinosoft.one.uiutil.UIType;
import com.sinosoft.one.uiutil.UIUtil;

@Path
public class TaskAuthController {

	@Autowired
	private TaskAuthService taskAuthService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private CompanyService companyService;
	
	//取得机构
	@Post("companyAll")
	public Reply list(Invocation inv) throws Exception {
		
		User user=ShiroLoginUser.getLoginUser();
		String supercomCode=user.getLoginComCode();
		List<Company> showCompany=companyService.findAllNextComBySupper(supercomCode);
		Map<String, Company> filter = new HashMap<String, Company>();
		List<Company> topList = new ArrayList<Company>();
		for (Company company : showCompany) {
			if(company.getUpperComCode().toString().equals(supercomCode))
				topList.add(company);
			filter.put(company.getComCode(), company);
		}
		Treeable<NodeEntity> treeable=companyService.creatCompanyTreeAble(topList, filter);
		inv.getResponse().setContentType("text/html;charset=UTF-8");
		Render render = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
		render.render(inv.getResponse());
		return null;
	}
	
	//返回机构的功能，在页面功能已被授权给此机构，则打钩
	@Post("tasklist/{comCode}")
	public Reply list(@Param("comCode") String comCode, Invocation inv) throws Exception {		
		Treeable<NodeEntity> treeable = treeAble(comCode);
		inv.getResponse().setContentType("text/html;charset=UTF-8");
		Render render = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
		render.render(inv.getResponse());
		return null;
	}
	
	//保存机构的功能
	@Post("taskId/{strId}/{comCode}")
	public Reply result(@Param("strId") String strId,@Param("comCode") String comCode, Invocation inv) {
		TaskAuth taskAuth = new TaskAuth();
		//保存当前机构的功能
		taskAuthService.save(strId,comCode,taskAuth);
		inv.addModel("comCode", comCode);
		return Replys.with("success");
	}
	
//--------------------------------------------------------------------------------//
	
	
	
	
	//把满足条件的task存入Treeable对象，并返回
	 Treeable<NodeEntity> treeAble(String comCode) {
		Company company = companyService.findCompanyByComCode(comCode);
		
		String parentComCode = company.getUpperComCode();

		List<Task> topList = new ArrayList<Task>();
		List<Task>showTasks= (List<Task>) taskService.findAllTasks();
		for (Task task : showTasks) {
			if (task.getParent() == null) {
				topList.add(task);
			}
		} 
		
		List<String> taskIdList = taskAuthService.findAllTaskIdByComCode(comCode);
		List<String> parentTaskIdList = new ArrayList<String>();
		if(parentComCode != null){
			parentTaskIdList = taskAuthService.findAllTaskIdByComCode(parentComCode);
		}
		
		Treeable<NodeEntity> treeable = creatTaskTreeAble(topList,taskIdList,parentTaskIdList);
		return treeable;
	}
	
	/**
	 * 构建功能树 topTasks父节点 filter所有节点
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	Treeable<NodeEntity> creatTaskTreeAble(List<Task> topTasks,List<String> taskIdList,List<String> parentTaskIdList){
		List<NodeEntity> nodeEntitys=new ArrayList<NodeEntity>();
		nodeEntitys=creatSubNode(topTasks,taskIdList,parentTaskIdList);
		Treeable<NodeEntity> treeable =new Treeable.Builder(nodeEntitys,"id", "title", "children", "state").classField("classField").urlField("urlField").builder();
		return treeable;
	}
	
	List<NodeEntity> creatSubNode(List<Task> topTasks,List<String> taskIdList,List<String> parentTaskIdList){
		ArrayList<NodeEntity> nodeEntitys=new ArrayList<NodeEntity>();
		for (Task geRmsTask : topTasks) {
			if(!parentTaskIdList.isEmpty()){
				if(!parentTaskIdList.contains(geRmsTask.getTaskID()))
	                continue;
			}
			NodeEntity nodeEntity = new NodeEntity();
			nodeEntity.setId(geRmsTask.getTaskID());
			nodeEntity.setTitle(geRmsTask.getName());
			if(taskIdList.contains(geRmsTask.getTaskID())){
				nodeEntity.setClassField("jstree-checked jstree-disable");
			}else{
				nodeEntity.setClassField("");
			}

			if(!geRmsTask.getChildren().isEmpty()){
				nodeEntity.setChildren(creatSubNode(geRmsTask.getChildren(),taskIdList,parentTaskIdList));
				int count = 0;
				
				//判断父节点的checkbox的状态
				if(!nodeEntity.getChildren().isEmpty()){
					for(NodeEntity ne : nodeEntity.getChildren()){
						if(ne.getClassField().equals("jstree-checked jstree-disable")){
							count++;
						}
					}
				//子节点全部被选中，父节点为选中
				if(count == nodeEntity.getChildren().size()){
					nodeEntity.setClassField("jstree-checked jstree-open jstree-disable");
					
					//子节点部分被选中，父节点的checkbox的状态为jstree-undetermined
				}else if(count>0){
					nodeEntity.setClassField("jstree-undetermined jstree-open jstree-disable");
				}else{
					//子节点全没选中，父节点的checkbox的状态为jstree-unchecked
					nodeEntity.setClassField("jstree-unchecked jstree-disable");
				}
				}
			}
				
				nodeEntitys.add(nodeEntity);
			}
		return nodeEntitys;
	}
}
