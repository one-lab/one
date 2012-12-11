package com.sinosoft.one.ams.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.sinosoft.one.ams.model.GeRmsRole;
import com.sinosoft.one.ams.model.GeRmsTask;
import com.sinosoft.one.ams.model.User;
import com.sinosoft.one.ams.service.AccountManager;
import com.sinosoft.one.ams.service.facade.RoleService;
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

@Path("role")
public class RoleController {

	@Autowired
	private AccountManager accountManager;
	@Autowired
	private RoleService roleService;
	
	private List<String> roleAttribute = new ArrayList<String>();
	
	//角色列表
		@Post({"roleAll"})
		public Reply roleAll(@Param("name")String name,@Param("pageNo") int pageNo,@Param("rowNum")int rowNum,Invocation inv) throws Exception{
			Pageable pageable = new PageRequest(pageNo-1, rowNum);
			System.out.println(name);
			
			Gridable<GeRmsRole> ge = new Gridable<GeRmsRole>(null);
			
			Gridable<GeRmsRole> gridable = roleService.findAllRole(ge, pageable, roleAttribute);
			
			inv.getResponse().setContentType("text/html;charset=UTF-8");
			Render render = (GridRender) UIUtil.with(gridable).as(UIType.Json);
			render.render(inv.getResponse());
			return null;
		} 
		
		@Post("roleList/{groupId}")
		@Get("roleList/{groupId}")
		public Reply roleList(@Param("groupId") String groupId,@Param("pageNo") int pageNo, @Param("rowNum") int rowNum,Invocation inv) throws Exception {
			
			Pageable pageable = new PageRequest(pageNo - 1, rowNum);
			
			Gridable<GeRmsRole> gridable = new Gridable<GeRmsRole>(null);
			
			gridable = roleService.getGridable(pageable,groupId,gridable,roleAttribute);
			
			inv.getResponse().setContentType("text/html;charset=UTF-8");
			Render render = (GridRender) UIUtil.with(gridable).as(UIType.Json);
			render.render(inv.getResponse());
			return null;
		}
		
		//角色列表
		@Post({"rolelist/{name}","rolelist"})
		public Reply list(@Param("name")String name,@Param("pageNo") int pageNo,@Param("rowNum")int rowNum,Invocation inv) throws Exception{
			Pageable pageable = new PageRequest(pageNo-1, rowNum);

			Gridable<GeRmsRole> ga = new Gridable<GeRmsRole>(null);
			Gridable<GeRmsRole> gridable = roleService.getGridable(ga,name,pageable);
			
			inv.getResponse().setContentType("text/html;charset=UTF-8");
			Render render = (GridRender) UIUtil.with(gridable).as(UIType.Json);
			render.render(inv.getResponse());
			return null;
		} 
		
		//根据角色查询角色下的功能树 【树的长度为根据机构查询的功能】【选中的节点为角色下已经关联的功能节点】
		@Post("findTaskByRole/{roleId}")
		public Reply findTaskByRole(@Param("roleId") String roleId,Invocation inv)throws Exception{
			User user = (User) inv.getRequest().getSession().getAttribute("user");
			String comCode = user.getComCode();
			//根据角色ID查询角色关联功能
			List<GeRmsTask> rolesTasks= roleService.findTaskByRole(roleId);
			//根据机构代码查询可见功能
			List<GeRmsTask> comsTasks=roleService.findTaskByComCode(comCode);
			//构建树对象
			Treeable<NodeEntity> treeable=accountManager.creatTaskTreeAble(rolesTasks,comsTasks);
			inv.getResponse().setContentType("text/html;charset=UTF-8");
			TreeRender render=(TreeRender)UIUtil.with(treeable).as(UIType.Json);
			System.out.println(render.getResultForTest());
			render.render(inv.getResponse());
			return null;
		}

}
