package com.sinosoft.ams.controllers.role;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.sinosoft.ams.role.model.GeRmsRole;
import com.sinosoft.ams.service.AccountManager;
import com.sinosoft.ams.task.model.GeRmsTask;
import com.sinosoft.ams.user_group.model.User;
import com.sinosoft.ams.utils.uiutil.GridRender;
import com.sinosoft.ams.utils.uiutil.Gridable;
import com.sinosoft.ams.utils.uiutil.NodeEntity;
import com.sinosoft.ams.utils.uiutil.Render;
import com.sinosoft.ams.utils.uiutil.TreeRender;
import com.sinosoft.ams.utils.uiutil.Treeable;
import com.sinosoft.ams.utils.uiutil.UIType;
import com.sinosoft.ams.utils.uiutil.UIUtil;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;

@Path("role")
public class GeRmsRoleController {
	
	@Autowired
	private AccountManager accountManager;
	
	private List<String> roleAttribute = new ArrayList<String>();
	
	//角色列表
	@Post({"rolelist/{name}","rolelist"})
	public Reply list(@Param("name")String name,@Param("pageNo") int pageNo,@Param("rowNum")int rowNum,Invocation inv) throws Exception{
		User user = (User) inv.getRequest().getSession().getAttribute("user");
		String comCode = user.getComCode();
		Pageable pageable = new PageRequest(pageNo-1, rowNum);
		System.out.println(name);
		Page<GeRmsRole> page = null;
		//查询机构下所有可见的角色
		page = accountManager.findRole(comCode,name,pageable);
		String button = "<a href='#' class='set' onclick='openWindow(this);'>修 改</a><a href='#' class='set' onclick='delRow(this);'>删 除</a>";
		List<GeRmsRole> geRmsRoles = page.getContent();
		for (GeRmsRole geRmsRole : geRmsRoles) {
			geRmsRole.setButton(button);
		} 
		Gridable<GeRmsRole> gridable = new Gridable<GeRmsRole>(page);
		gridable.setIdField("roleID");
		roleAttribute.add("name");
		roleAttribute.add("des");
		roleAttribute.add("createTime");
		roleAttribute.add("operateTime");
		roleAttribute.add("button");
		gridable.setCellListStringField(roleAttribute);
		
		inv.getResponse().setContentType("text/html;charset=UTF-8");
		Render render = (GridRender) UIUtil.with(gridable).as(UIType.Json);
		render.render(inv.getResponse());
		return null;
	} 
	
	//根据角色ID查询角色信息
	@Get("findRoleById/{roleId}")
	public String findRoleById(@Param("roleId") String roleId,Invocation inv){
		GeRmsRole role  = accountManager.findRoleById(roleId);
		inv.addModel("name", role.getName());
		inv.addModel("des", role.getDes());
		inv.addModel("roleId", role.getRoleID());
		inv.addModel("flag", role.getFlag());
		return "loadRoleInfo";
	}
	
	//根据角色查询角色下的功能树 【树的长度为根据机构查询的功能】【选中的节点为角色下已经关联的功能节点】
	@Post("findTaskByRole/{roleId}")
	public Reply findTaskByRole(@Param("roleId") String roleId,Invocation inv)throws Exception{
		User user = (User) inv.getRequest().getSession().getAttribute("user");
		String comCode = user.getComCode();
		//根据角色ID查询角色关联功能
		List<GeRmsTask> rolesTasks= accountManager.findTaskByRole(roleId);
		//根据机构代码查询可见功能
		List<GeRmsTask> comsTasks=accountManager.findTaskByComCode(comCode);
		//构建树对象
		Treeable<NodeEntity> treeable=accountManager.creatTaskTreeAble(rolesTasks,comsTasks);
		inv.getResponse().setContentType("text/html;charset=UTF-8");
		TreeRender render=(TreeRender)UIUtil.with(treeable).as(UIType.Json);
		System.out.println(render.getResultForTest());
		render.render(inv.getResponse());
		return null;
	}
	
	
}
