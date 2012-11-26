package com.sinosoft.ams.controllers.task_auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.ams.service.AccountManager;
import com.sinosoft.ams.task_auth.model.GeRmsCompany;
import com.sinosoft.ams.user_group.model.User;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;

@Path("taskauth")
public class GeRmsTaskAuthController {
	@Autowired  
	private AccountManager accountManager;
	
	@Post("taskId/{strId}/{comCode}")
	public Reply result(@Param("strId") String strId,@Param("comCode") String comCode,Invocation inv){
		
		User user=(User) inv.getRequest().getSession().getAttribute("user");
		String name=user.getUserName();
		
		List<String> taskIdAuth=accountManager.findByComCode(comCode);
		List<String> count =new ArrayList<String>();
		
		String[] taskId=strId.split(" ");

		for(int i=0;i<taskId.length;i++){
			if(taskIdAuth.contains(taskId[i])){
				System.out.println("功能已有："+taskId[i]);
				String parentId=accountManager.findByTaskId(taskId[i]);
				count.add(taskId[i]);
				count.add(parentId);
			}else {
				String parentId=accountManager.findByTaskId(taskId[i]);
				System.out.println(parentId+",===============================");
				if(!taskIdAuth.contains(parentId)){
					accountManager.InsertTask(parentId+comCode, parentId, comCode, name);
				}
				count.add(taskId[i]);
				count.add(parentId);
				taskIdAuth.add(parentId);
				taskIdAuth.add(taskId[i]);
				accountManager.InsertTask(taskId[i]+comCode, taskId[i], comCode, name);
			}
		}
		
		for(int j=0;j<taskIdAuth.size();j++){
			if(!count.contains(taskIdAuth.get(j))){
				accountManager.deleteTask(comCode, taskIdAuth.get(j));
				List<GeRmsCompany> comZi = accountManager.findByUpperComCode(comCode);
				if(comZi !=null)
				for(int i=0;i<comZi.size();i++){
					List<String> comZiTaskId = accountManager.findByComCode(comZi.get(i).getComCode());
					if(comZiTaskId.contains(taskIdAuth.get(j))){
						accountManager.deleteTask(comZi.get(i).getComCode(), taskIdAuth.get(j));
					}
				}
			}
		}

		return Replys.with("success");
	}
	
}
