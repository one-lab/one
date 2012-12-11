package com.sinosoft.one.ams.controllers.user_group;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.sinosoft.one.ams.model.GeRmsGroup;
import com.sinosoft.one.ams.model.GeRmsGroupRole;
import com.sinosoft.one.ams.model.User;
import com.sinosoft.one.ams.service.AccountManager;
import com.sinosoft.one.ams.service.facade.UserGroupService;
import com.sinosoft.one.ams.utils.uiutil.GridRender;
import com.sinosoft.one.ams.utils.uiutil.Gridable;
import com.sinosoft.one.ams.utils.uiutil.Render;
import com.sinosoft.one.ams.utils.uiutil.UIType;
import com.sinosoft.one.ams.utils.uiutil.UIUtil;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;

@Path("group")
public class GroupController {
	
	@Autowired
	private AccountManager accountManager;
	@Autowired
	private UserGroupService userGroupService;
	
	private List<String> groupAttribute = new ArrayList<String>();
	private List<String> userAttribute = new ArrayList<String>();
	
	//返回所有的用户组
	@Post("groupAll")
	public Reply list(@Param("pageNo") int pageNo, @Param("rowNum") int rowNum,Invocation inv) throws Exception {
		Pageable pageable = new PageRequest(pageNo - 1, rowNum);
		
		Gridable<GeRmsGroup> ga = new Gridable<GeRmsGroup>(null);
		
		//得到一个Gridable对象
		Gridable<GeRmsGroup> gridable = userGroupService.getGridable(ga,pageable,groupAttribute);
		
		inv.getResponse().setContentType("text/html;charset=UTF-8");
		Render render = (GridRender) UIUtil.with(gridable).as(UIType.Json);
		render.render(inv.getResponse());
		return null;
	}
	
	//根据组名，查询相关的用户组，可以进行模糊查询
	@Post("search/{name}")
	public Reply search(@Param("name") String name,@Param("pageNo") int pageNo, @Param("rowNum") int rowNum,Invocation inv) throws Exception {
		Pageable pageable = new PageRequest(pageNo - 1, rowNum);
		
		Gridable<GeRmsGroup> ga = new Gridable<GeRmsGroup>(null);
		//得到一个Gridable对象
		Gridable<GeRmsGroup> gridable = userGroupService.searchGroup(ga,name,pageable,groupAttribute);
		
		inv.getResponse().setContentType("text/html;charset=UTF-8");
		Render render = (GridRender) UIUtil.with(gridable).as(UIType.Json);
		render.render(inv.getResponse());
		return null;
	}
	
	//添加用户组及其角色
	@Post("insert/{name}/{des}/{roleIdStr}")
	public Reply insert(@Param("name") String name, @Param("des") String des,
			@Param("roleIdStr") String roleIdStr, Invocation inv) {
		
		GeRmsGroup group = new GeRmsGroup();
		GeRmsGroupRole groupRole = new GeRmsGroupRole();
		
		userGroupService.saveGroupAndGroupRole(name,des,roleIdStr,group,groupRole);
		
		return Replys.simple().success("success");
	}
	
	//对用户组进行删除操作
	@Post("del/{groupId}")
	public Reply del(@Param("groupId") String groupId, Invocation inv) {
		
		userGroupService.del(groupId);
		
		return Replys.with("success");
	}
	
	//根据用户组ID查询出其中的用户，并返回页面
	@Post("groupid/{groupId}")
	@Get("groupid/{groupId}")
	public Reply list(@Param("pageNo") int pageNo, @Param("rowNum") int rowNum,@Param("groupId") String groupId, Invocation inv) throws Exception {
		Pageable pageable = new PageRequest(pageNo - 1, rowNum);

		Gridable<User> gridable = new Gridable<User>(null);
		
		gridable = userGroupService.getGridable(gridable,groupId,pageable,userAttribute);		
		
		inv.getResponse().setContentType("text/html;charset=UTF-8");
		Render render = (GridRender) UIUtil.with(gridable).as(UIType.Json);
		render.render(inv.getResponse());
		return null;
	}
	
	@Post("searchUser/{userCode}/{userName}/{groupId}")
	@Get("searchUser/{userCode}/{userName}/{groupId}")
	public Reply find(@Param("pageNo") int pageNo, @Param("rowNum") int rowNum,@Param("userCode") String userCode,
			@Param("userName") String userName,@Param("groupId") String groupId, Invocation inv) throws Exception {
		Pageable pageable = new PageRequest(pageNo - 1, rowNum);
		
		Gridable<User> ga = new Gridable<User>(null);
		
		Gridable<User> gridable = userGroupService.getGridable(ga,userName,userCode,groupId,pageable,userAttribute);
		
		inv.getResponse().setContentType("text/html;charset=UTF-8");
		Render render = (GridRender) UIUtil.with(gridable).as(UIType.Json);
		render.render(inv.getResponse());
		return null;
	}
	
	@Post("delete/{userCode}/{groupId}")
	public Reply del(@Param("userCode") String userCode, @Param("groupId") String groupId, Invocation inv) {
		
		userGroupService.del(userCode, groupId);
		
		return Replys.with("success");
	}
	@Post("update/{groupId}")
	public Reply update(@Param("groupId") String groupId, Invocation inv) {
		System.out.println(groupId + "+++++++++++++++++++++++++++++++++++");
		if (groupId != null) {
			accountManager.updateGroup(groupId);
			return Replys.with("success");
		} else {
			return Replys.with("false");
		}

	}
	
	//将groupId传到dataQuery页面，并跳到dataQuery页面
	@Get("groupId/{groupId}")
	public String page(@Param("groupId") String groupId, Invocation inv) {
		inv.addModel("groupId", groupId);
		return "dataQuery";
	}	
}
