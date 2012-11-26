package com.sinosoft.ams.controllers.stuffing;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.sinosoft.ams.service.AccountManager;
import com.sinosoft.ams.task_auth.model.GeRmsCompany;
import com.sinosoft.ams.user_group.model.User;
import com.sinosoft.ams.utils.uiutil.GridRender;
import com.sinosoft.ams.utils.uiutil.Gridable;
import com.sinosoft.ams.utils.uiutil.Render;
import com.sinosoft.ams.utils.uiutil.UIType;
import com.sinosoft.ams.utils.uiutil.UIUtil;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;

@Path("user")
public class GeRmsUserController {
	
	@Autowired
	private AccountManager accountManager;
	
	private List<String> userAttribute = new ArrayList<String>();
	
	@Post("userlist")
	@Get("userlist")
	public Reply list(@Param("pageNo") int pageNo, @Param("rowNum")int rowNum,Invocation inv) throws Exception{
		Pageable pageable = new PageRequest(pageNo-1, rowNum);
		Page<User> page = accountManager.findAllUser(pageable);
		List<User> userList = page.getContent();
		String button = "<a href='javascript:;' class='set' onclick='openQX();'>权限设置</a><a href='#' title='该人员未配置权限，无法操作' class='set dis'>数据设置</a>";
		String button2 = "<a href='#' class='agency' onclick='openWindow()'></a>";
		for(User user: userList){
			user.setButton(button);
			user.setButton2(button2);
			String comCode = user.getComCode();
			GeRmsCompany com = accountManager.company(comCode);
			user.setComCName(com.getComCName());
		}
		Gridable<User> gridable = new Gridable<User>(page);
		gridable.setIdField("userCode");
		userAttribute.add("userCode");
		userAttribute.add("userName");
		userAttribute.add("comCName");
		userAttribute.add("button2");
		userAttribute.add("button");
		gridable.setCellListStringField(userAttribute);
		
		inv.getResponse().setContentType("text/html;charset=UTF-8");
	    Render render = (GridRender) UIUtil.with(gridable).as(UIType.Json);
		render.render(inv.getResponse());
		return null;
	}
	
	@Post("search/{userCode}/{comCode}")
	@Get("search/{userCode}/{comCode}")
	public Reply search(@Param("pageNo") int pageNo, @Param("rowNum")int rowNum,@Param("userCode")String userCode,@Param("comCode")String companyCode,Invocation inv) throws Exception{
		Pageable pageable = new PageRequest(pageNo-1, rowNum);
		Page<User> page = null;
		
		if(userCode.equals("null") && companyCode.equals("null")){
			page = accountManager.findAllUser(pageable);
		}else if(!userCode.equals("null") && companyCode.equals("null")){
			page = accountManager.searchByUserCode(userCode, pageable);
		}else if(userCode.equals("null") && !companyCode.equals("null")){
			page = accountManager.searchByComCode(companyCode, pageable);
		}else {
			page = accountManager.searchByComCodeUserCode(companyCode, userCode, pageable);
		}
		List<User> userList = page.getContent();
		String button = "<a href='javascript:;' class='set' onclick='openQX();'>权限设置</a><a href='#' title='该人员未配置权限，无法操作' class='set dis'>数据设置</a>";
		String button2 = "<a href='#' class='agency' onclick='openWindow()'></a>";
		for(User user: userList){
			user.setButton(button);
			user.setButton2(button2);
			String comCode = user.getComCode();
			GeRmsCompany com = accountManager.company(comCode);
			user.setComCName(com.getComCName());
		}
		Gridable<User> gridable = new Gridable<User>(page);
		gridable.setIdField("userCode");
		userAttribute.add("userCode");
		userAttribute.add("userName");
		userAttribute.add("comCName");
		userAttribute.add("button2");
		userAttribute.add("button");
		gridable.setCellListStringField(userAttribute);
		
		inv.getResponse().setContentType("text/html;charset=UTF-8");
	    Render render = (GridRender) UIUtil.with(gridable).as(UIType.Json);
		render.render(inv.getResponse());
		return null;
	}
	

}
