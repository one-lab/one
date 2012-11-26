package com.sinosoft.ams.controllers.user_group;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.sinosoft.ams.service.AccountManager;
import com.sinosoft.ams.user_group.model.GeRmsGroup;
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
import com.sinosoft.one.mvc.web.instruction.reply.Replys;


@Path("group")
public class GeRmsGroupController {
	
	@Autowired  //必须加的一句话，spring调用
	private AccountManager accountManager;
	
	private List<String> groupAttribute = new ArrayList<String>();
	
	@Post("grouplist")
	public Reply list(@Param("pageNo") int pageNo,@Param("rowNum")int rowNum,Invocation inv) throws Exception {
		 Pageable pageable = new PageRequest(pageNo-1,rowNum);
		 Page<GeRmsGroup> page = accountManager.findAllGroup(pageable);
		 List<GeRmsGroup> geRmsGroups = page.getContent();
		 String button = "<a href='#' class='set' onclick='openWindow(this);'>修 改</a><a href='#' class='set' onclick='delRow(this);'>删 除</a>";
		 for(GeRmsGroup gg:geRmsGroups){
			 gg.setButton(button);
		 }
		 Gridable<GeRmsGroup> gridable = new Gridable<GeRmsGroup>(page);
	        gridable.setIdField("groupID");
	        groupAttribute.add("name");
	        groupAttribute.add("des");
	        groupAttribute.add("createTime");
	        groupAttribute.add("operateTime");
	        groupAttribute.add("button");
	        gridable.setCellListStringField(groupAttribute);
	        
	        inv.getResponse().setContentType("text/html;charset=UTF-8");
		    Render render = (GridRender) UIUtil.with(gridable).as(UIType.Json);
			render.render(inv.getResponse());
			return null;
	}
	
	@Post("search/{name}")
	public Reply search(@Param("name") String name,@Param("pageNo") int pageNo,@Param("rowNum")int rowNum,Invocation inv) throws Exception {
		Pageable pageable = new PageRequest(pageNo-1, rowNum);
		Page<GeRmsGroup> page = null;
		if(!name.equals("null")){
			 page = accountManager.findByName(name,pageable);
		}else{
			 page = accountManager.findAllGroup(pageable);
		}
		String button = "<a href='#' class='set' onclick='openWindow(this);'>修 改</a><a href='#' class='set' onclick='delRow(this);'>删 除</a>";
		List<GeRmsGroup> groupList = page.getContent();
		 for(GeRmsGroup gg:groupList){
			 gg.setButton(button);
		 }
		 Gridable<GeRmsGroup> gridable = new Gridable<GeRmsGroup>(page);
	        gridable.setIdField("groupID");
	        groupAttribute.add("name");
	        groupAttribute.add("des");
	        groupAttribute.add("createTime");
	        groupAttribute.add("operateTime");
	        groupAttribute.add("button");
	        gridable.setCellListStringField(groupAttribute);
	        
	        inv.getResponse().setContentType("text/html;charset=UTF-8");
		    Render render = (GridRender) UIUtil.with(gridable).as(UIType.Json);
			render.render(inv.getResponse());
			return null;
	}
	
	@Post("update/{groupId}")
	public Reply update(@Param("groupId") String groupId ,Invocation inv){
		System.out.println(groupId+"+++++++++++++++++++++++++++++++++++");
		if(groupId !=null){
			accountManager.updateGroup(groupId);
			return Replys.with("success");
			
		}else{
			return Replys.with("false");
		}
		
	}
	
	@Post("insert")
	public Reply insert(GeRmsGroup group,@Param("groupId") String groupId,@Param("name")String name,@Param("des")String des,Invocation inv){
		User user = (User) inv.getRequest().getSession().getAttribute("user");
		
//		group.setGroupID(group.getName());
//		String groupId = group.getGroupID();
//		String name = group.getName();
//		String des = group.getDes();
		Date createTime = new Date();
		String comcode = user.getComCode();
		String createUser = user.getUserName();
		
		accountManager.insertGroup(groupId, name, des, comcode, createTime, createUser);
		
//		return Replys.with("success");
		return Replys.simple().success("success");
	}
	
	@Get("find/{groupId}")
	public String find(@Param("groupId") String groupId,Invocation inv){
		System.out.println("++++++++++++++++++++++++++++++++++");
		GeRmsGroup group = accountManager.findByGroupId(groupId);
		inv.addModel("name", group.getName());
		inv.addModel("des", group.getDes());
		inv.addModel("groupId", groupId);
		return "addUser";
	}
	
	@Post("updategroup")
	public Reply update(GeRmsGroup group,Invocation inv){
		
		return null;
	}

}
