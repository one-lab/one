package com.sinosoft.one.ams.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.sinosoft.one.ams.model.GeRmsBusPower;
import com.sinosoft.one.ams.model.GeRmsCompany;
import com.sinosoft.one.ams.model.GeRmsDataRule;
import com.sinosoft.one.ams.model.GeRmsGroup;
import com.sinosoft.one.ams.model.GeRmsRole;
import com.sinosoft.one.ams.model.GeRmsUserPower;
import com.sinosoft.one.ams.model.User;
import com.sinosoft.one.ams.service.facade.StuffingService;
import com.sinosoft.one.ams.utils.uiutil.GridRender;
import com.sinosoft.one.ams.utils.uiutil.Gridable;
import com.sinosoft.one.ams.utils.uiutil.NodeEntity;
import com.sinosoft.one.ams.utils.uiutil.Render;
import com.sinosoft.one.ams.utils.uiutil.TreeRender;
import com.sinosoft.one.ams.utils.uiutil.Treeable;
import com.sinosoft.one.ams.utils.uiutil.UIType;
import com.sinosoft.one.ams.utils.uiutil.UIUtil;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;

@Path("staffing")
public class StaffingController {
	
	@Autowired
	private StuffingService stuffingService;
	
	private List<String> userAttribute = new ArrayList<String>();
	
	//查询出所有的用户，返回页面
	@Post("userAll")
	@Get("userAll")
	public Reply list(@Param("pageNo") int pageNo, @Param("rowNum")int rowNum,Invocation inv) throws Exception{
		Pageable pageable = new PageRequest(pageNo-1, rowNum);
		
		Gridable<User> ga = new Gridable<User>(null);
		Gridable<User> gridable = stuffingService.getGridable(ga,pageable,userAttribute);
		
		inv.getResponse().setContentType("text/html;charset=UTF-8");
	    Render render = (GridRender) UIUtil.with(gridable).as(UIType.Json);
		render.render(inv.getResponse());
		return null;
	}
	
	//查询用户，并返回相应页面
	@Post("search/{userCode}/{comCode}")
	@Get("search/{userCode}/{comCode}")
	public Reply search(@Param("pageNo") int pageNo, @Param("rowNum")int rowNum,@Param("userCode")String userCode,@Param("comCode")String comCode,Invocation inv) throws Exception{
		Pageable pageable = new PageRequest(pageNo-1, rowNum);
		
		Gridable<User> ga = new Gridable<User>(null);
		Gridable<User> gridable = stuffingService.getGridable(ga,userCode,comCode, pageable, userAttribute);
		
		inv.getResponse().setContentType("text/html;charset=UTF-8");
	    Render render = (GridRender) UIUtil.with(gridable).as(UIType.Json);
		render.render(inv.getResponse());
		return null;
	}
	
	//用户的数据权限设置
	@SuppressWarnings("unchecked")
	@Get("user/{userCode}")
	public Reply list(@Param("userCode")String userCode,Invocation inv) throws Exception{
		
		List<GeRmsCompany> companyList = new ArrayList<GeRmsCompany>();
		List<GeRmsUserPower> userPowerList = new ArrayList<GeRmsUserPower>();
		
		NodeEntity nodeEntity = new NodeEntity("comCode", "comCName", "close");
		nodeEntity = stuffingService.getNodeEntity(nodeEntity,userCode,companyList,userPowerList);
		
		Treeable<NodeEntity> treeable = new Treeable.Builder<NodeEntity>(nodeEntity.getChildren(), "id", "title", "children", "state").builder();
		inv.getResponse().setContentType("text/html;charset=UTF-8");
		Render render = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
		render.render(inv.getResponse());
		return null;
	}
	
	@Get("ruleAll/{taskId}/{userPowerId}")
	public Reply ruleAll(@Param("taskId")String taskId,@Param("userPowerId")String userPowerId,Invocation inv) throws Exception {
		
		List<GeRmsDataRule> ruleAll = stuffingService.getRuleAll(userPowerId, taskId);
		
		return Replys.with(ruleAll).as(Json.class);
	}
	
	//保存数据设置
	@Post("save/{ruleIdStr}/{userPowerId}/{taskId}/{paramStr}")
	public Reply save(@Param("ruleIdStr")String ruleIdStr,@Param("userPowerId")String userPowerId,@Param("taskId")String taskId,@Param("paramStr")String paramStr,Invocation inv){
		
		String[]ruleIdArr = ruleIdStr.split(",");
		String[]paramArr = paramStr.split(",");
		GeRmsBusPower busPower = new GeRmsBusPower();
		
		String result = stuffingService.saveBusPower(busPower, ruleIdArr, paramArr, userPowerId, taskId);
		
		System.out.println(result);
		return Replys.with("success");
	}
	
	@Get("companyList/{userCode}")
	public Reply companyList(@Param("userCode")String userCode, Invocation inv) throws Exception{
		
		NodeEntity nodeEntity = new NodeEntity("comCode", "comCName", "close");
		stuffingService.recursionCompany(nodeEntity, null, userCode);
		
		@SuppressWarnings("unchecked")
		Treeable<NodeEntity> treeable = new Treeable.Builder<NodeEntity>(nodeEntity.getChildren(), "id", "title", "children", "state").builder();
		inv.getResponse().setContentType("text/html;charset=UTF-8");
		Render render = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
		render.render(inv.getResponse());
		return null;
	}
	
	//查询机构的用户组，并返回页面
	@Get("group/{comCode}")
	public Reply groupList(@Param("comCode")String comCode,Invocation inv){
		List<GeRmsGroup> groupList = stuffingService.findGroupByComCode(comCode);
		return Replys.with(groupList).as(Json.class);
	}
	
	//查询用户组的角色，并返回页面
	@Get("roleList/{groupId}")
	public Reply role(@Param("groupId")String groupId,Invocation  inv){
		List<GeRmsRole> groupRoleList = stuffingService.findRoleByGroupId(groupId);
		System.out.println(groupId);
		System.out.println(groupRoleList.size()+"+++++++++++++++++++++++++++++++++");
		return Replys.with(groupRoleList).as(Json.class);
	}

}
