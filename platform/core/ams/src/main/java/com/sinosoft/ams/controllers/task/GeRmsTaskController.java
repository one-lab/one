package com.sinosoft.ams.controllers.task;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.ams.service.AccountManager;
import com.sinosoft.ams.task.model.GeRmsTask;
import com.sinosoft.ams.task_auth.model.GeRmsCompany;
import com.sinosoft.ams.user_group.model.User;
import com.sinosoft.ams.utils.uiutil.NodeEntity;
import com.sinosoft.ams.utils.uiutil.Render;
import com.sinosoft.ams.utils.uiutil.TreeRender;
import com.sinosoft.ams.utils.uiutil.Treeable;
import com.sinosoft.ams.utils.uiutil.UIType;
import com.sinosoft.ams.utils.uiutil.UIUtil;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;

@Path("task")
public class GeRmsTaskController {
	@Autowired  
	private AccountManager accountManager;
	
	@Post("tasklist/{comCode}")
	public Reply list(@Param("comCode") String comCode ,Invocation inv) throws Exception{
		User user = (User) inv.getRequest().getSession().getAttribute("user");
		String comCodeUser = user.getComCode();
		GeRmsCompany company=accountManager.company(comCode);
		
		NodeEntity nodeEntity=new NodeEntity("RMS001", "权限管理", "close");
		GeRmsTaskController obj=new GeRmsTaskController();
		
		if(comCodeUser.equals(company.getUpperComCode())){
			List<GeRmsTask> taskList=accountManager.findByTaskId();
			obj.push(nodeEntity,taskList ,comCode,accountManager);
			Treeable<NodeEntity> treeable=new Treeable.Builder(nodeEntity.getChildren(),"id", "title", "children", "state").builder();
			
			for(int i=0;i<taskList.size();i++){
				NodeEntity ne=nodeEntity.getChildren().get(i);
				List<GeRmsTask> listTaskZi=accountManager.findByParentIdIsasMenu(taskList.get(i).getTaskID());
				obj.push(ne, listTaskZi,comCode,accountManager);
			}
			
			inv.getResponse().setContentType("text/html;charset=UTF-8");
			Render render=(TreeRender)UIUtil.with(treeable).as(UIType.Json);
			render.render(inv.getResponse());
			return null;
		}else{
			
			List<GeRmsTask> taskList=accountManager.findByIsasmenuTaskId(company.getUpperComCode());
			obj.push(nodeEntity, taskList ,comCode,accountManager);
			Treeable<NodeEntity> treeable=new Treeable.Builder(nodeEntity.getChildren(),"id", "title", "children", "state").builder();
			
			for(int i=0;i<taskList.size();i++){
				NodeEntity ne=nodeEntity.getChildren().get(i);
				List<GeRmsTask> taskZi=accountManager.findByParentIdTaskId(taskList.get(i).getTaskID(),company.getUpperComCode());
				obj.push(ne, taskZi,comCode,accountManager);
			}
			
			inv.getResponse().setContentType("text/html;charset=UTF-8");
			Render render=(TreeRender)UIUtil.with(treeable).as(UIType.Json);
			render.render(inv.getResponse());
			return null;
		}
	}

	void push(NodeEntity nodeEntity,List<GeRmsTask> taskList,String comCode,AccountManager accountManager){
        List<NodeEntity> nodeEntities = new ArrayList<NodeEntity>();
        List<String> taskIdAuth=accountManager.findByComCode(comCode);

        for(GeRmsTask task: taskList){
            NodeEntity ne = new NodeEntity();
            
            ne.setId(task.getTaskID());
            ne.setTitle(task.getName());
            ne.setState("close");
            
            if(taskIdAuth!=null)
            for(int i=0;i<taskIdAuth.size();i++){
            	if(task.getTaskID().equals(taskIdAuth.get(i)) && task.getParentID()!=null && !(task.getParentID().equals("RMS001"))){
            		ne.setState("rms");
            	}
            }
            nodeEntities.add(ne);
        }
        nodeEntity.setChildren(nodeEntities);
   }
}
