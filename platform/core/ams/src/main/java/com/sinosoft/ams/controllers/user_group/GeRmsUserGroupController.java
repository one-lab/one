package com.sinosoft.ams.controllers.user_group;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.sinosoft.ams.service.AccountManager;
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

@Path("usergroup")
public class GeRmsUserGroupController {
	
	@Autowired
	private AccountManager accountManager;
	
	private List<String> userAttribute = new ArrayList<String>();
	
	@Get("groupId/{groupId}")
	public String page(@Param("groupId") String groupId,Invocation inv){
		inv.addModel("groupId",groupId);
		return "dataquery";
	}
	@Post("groupid/{groupId}")
	@Get("groupid/{groupId}")
	public Reply list(@Param("pageNo") int pageNo,@Param("rowNum")int rowNum,@Param("groupId") String groupId,Invocation inv) throws Exception{
		Pageable pageable = new PageRequest(pageNo-1,rowNum);
		Page<User> page = accountManager.findUserByGroupId(groupId,pageable);
		List<User> userList = page.getContent();
		String button = "<a href='#' class='set' onclick='openWindow(this);'>修 改</a><a href='#' class='set' onclick='delRow(this);'>删 除</a>";
		for(User user:userList){
			user.setButton(button);
		}
		
		Gridable<User> gridable = new Gridable<User>(page);
		gridable.setIdField("userCode");
		userAttribute.add("userCode");
		userAttribute.add("userName");
		userAttribute.add("button");
		gridable.setCellListStringField(userAttribute);
		
		inv.getResponse().setContentType("text/html;charset=UTF-8");
	    Render render = (GridRender) UIUtil.with(gridable).as(UIType.Json);
		render.render(inv.getResponse());
		return null;
	}
	@Post("usercode/{userCode}/{userName}/{groupId}")
	@Get("usercode/{userCode}/{userName}/{groupId}")
	public Reply find(@Param("pageNo") int pageNo,@Param("rowNum")int rowNum,@Param("userCode") String userCode,@Param("userName") String userName,@Param("groupId") String groupId,Invocation inv) throws Exception{
		Pageable pageable = new PageRequest(pageNo-1,rowNum);
		Page<User> page = null;
		if(userCode.equals("null") && userName.equals("null")){
			page = accountManager.findUserByGroupId(groupId,pageable);
		}else if(!userCode.equals("null") && userName.equals("null")){
			page = accountManager.findUserByUserCode(userCode,pageable);
		}else if(userCode.equals("null") && !userName.equals("null")){
			page = accountManager.searchByUserName(userName, pageable);
		}else {
			page = accountManager.searchByNameCode(userName, userCode, pageable);
		}
		
		List<User> userList = page.getContent();
		String button = "<a href='#' class='set' onclick='openWindow(this);'>修 改</a><a href='#' class='set' onclick='delRow(this);'>删 除</a>";
		for(User user:userList){
			user.setButton(button);
		}
		
		Gridable<User> gridable = new Gridable<User>(page);
		gridable.setIdField("userCode");
		userAttribute.add("userCode");
		userAttribute.add("userName");
		userAttribute.add("button");
		gridable.setCellListStringField(userAttribute);
		
		inv.getResponse().setContentType("text/html;charset=UTF-8");
	    Render render = (GridRender) UIUtil.with(gridable).as(UIType.Json);
		render.render(inv.getResponse());
		return null;
	}

}
