package com.sinosoft.one.ams.controllers;


import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.ams.model.GeRmsTaskAuth;
import com.sinosoft.one.ams.service.facade.TaskAuthService;
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

@Path("taskAuth")
public class TaskAuthController {

	@Autowired
	private TaskAuthService taskAuthService;
	
	@Post("companyAll")
	public Reply list(Invocation inv) throws Exception {
		NodeEntity nodeEntity = new NodeEntity("comCode", "name", "close");
		
		taskAuthService.recursionCompany(nodeEntity, null);
		@SuppressWarnings("unchecked")
		Treeable<NodeEntity> treeable = new Treeable.Builder<NodeEntity>(nodeEntity.getChildren(), "id", "title", "children", "state").builder();

		inv.getResponse().setContentType("text/html;charset=UTF-8");
		Render render = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
		render.render(inv.getResponse());

		return null;
	}
	
	//返回机构的功能
	@Post("tasklist/{comCode}")
	public Reply list(@Param("comCode") String comCode, Invocation inv) throws Exception {		
		Treeable<NodeEntity> treeable = taskAuthService.treeAble(comCode);
		inv.getResponse().setContentType("text/html;charset=UTF-8");
		Render render = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
		render.render(inv.getResponse());
		return null;
	}
	
	//保存机构的功能
	@Post("taskId/{strId}/{comCode}")
	public Reply result(@Param("strId") String strId,@Param("comCode") String comCode, Invocation inv) {
		
		GeRmsTaskAuth taskAuth = new GeRmsTaskAuth();
		//保存当前机构的功能
		taskAuthService.save(strId,comCode,taskAuth);
		return Replys.with("success");
	}

	

}
