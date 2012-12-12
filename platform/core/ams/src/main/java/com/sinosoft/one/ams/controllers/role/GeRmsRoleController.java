package com.sinosoft.one.ams.controllers.role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.sinosoft.one.ams.model.Employe;
import com.sinosoft.one.ams.model.Role;
import com.sinosoft.one.ams.model.Task;
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

@Path
public class GeRmsRoleController {

	@Autowired
	private AccountManager accountManager;
	@Autowired
	private RoleService roleService;
	
	private List<String> roleAttribute = new ArrayList<String>();
	

	// 角色列表
	@Post({ "rolelist/{name}", "rolelist" })
	public Reply list(@Param("name") String name, @Param("pageNo") int pageNo,
			@Param("rowNum") int rowNum, Invocation inv) throws Exception {
		Employe user = (Employe) inv.getRequest().getSession().getAttribute("user");
		String comCode = user.getCompany().getComCode();
		Pageable pageable = new PageRequest(pageNo - 1, rowNum);

		Gridable<Role> ga = new Gridable<Role>(null);
		Gridable<Role> gridable = roleService.getGridable(ga,comCode, name,
				pageable);

		inv.getResponse().setContentType("text/html;charset=UTF-8");
		Render render = (GridRender) UIUtil.with(gridable).as(UIType.Json);
		render.render(inv.getResponse());
		return null;
	}

	// 根据角色查询角色下的功能树 【树的长度为根据机构查询的功能】【选中的节点为角色下已经关联的功能节点】
	@Post("findTaskByRole/{roleId}")
	public Reply findTaskByRole(@Param("roleId") String roleId, Invocation inv)
			throws Exception {
		Employe user = (Employe) inv.getRequest().getSession().getAttribute("user");
		String comCode = user.getCompany().getComCode();
		// 根据角色ID查询角色关联功能
		List<Task> rolesTasks = roleService.findTaskByRole(roleId);
		// 根据机构代码查询可见功能
		List<Task> comsTasks = roleService.findTaskByComCode(comCode);
		// 构建树对象
		Treeable<NodeEntity> treeable = accountManager.creatTaskTreeAble(
				rolesTasks, comsTasks);
		inv.getResponse().setContentType("text/html;charset=UTF-8");
		TreeRender render = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
		System.out.println(render.getResultForTest());
		render.render(inv.getResponse());
		return null;
	}

	// 增加角色页面的查询功能树 
	@Post("findTask")
	public Reply findTask(Invocation inv)
			throws Exception {
		Employe user = (Employe) inv.getRequest().getSession().getAttribute("user");
		String comCode = user.getCompany().getComCode();
		// 根据角色ID查询角色关联功能
		List<Task> rolesTasks =new ArrayList<Task>();
		// 根据机构代码查询可见功能
		List<Task> comsTasks = roleService.findTaskByComCode(comCode);
		// 构建树对象
		Treeable<NodeEntity> treeable = accountManager.creatTaskTreeAble(
				rolesTasks, comsTasks);
		inv.getResponse().setContentType("text/html;charset=UTF-8");
		TreeRender render = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
		System.out.println(render.getResultForTest());
		render.render(inv.getResponse());
		return null;
	}
	
	
	//查询角色页面 修改/查看页面
	@Get("findRoleById/{roleId}")
	public String findRoleById(@Param("roleId") String roleId, Invocation inv) {
		Role role = roleService.findRoleById(roleId);
		inv.addModel("name", role.getName());
		inv.addModel("des", role.getDes());
		inv.addModel("roleId", role.getRoleID());
		inv.addModel("flag", role.getFlag());
		return "loadRoleInfo";
	}
	//准备增加角色 打开增加页面
	@Get("prepareAddRole")
	public String prepareAddRole(){
		return "addRole";
	}
	
	@Post("update/{roleId}/{name}/{des}/{roleType}/{taskId}")
	public Reply updateRole(@Param("roleId") String roleId,@Param("name")String name,@Param("des") String des,@Param("roleType") String roleType,@Param("taskId") String taskid, Invocation inv){
		Employe user = (Employe) inv.getRequest().getSession().getAttribute("user");
		String comCode = user.getCompany().getComCode();
		taskid=taskid.substring(0, taskid.length()-1);
		roleService.updateRole(roleId, comCode, name, des, roleType, Arrays.asList(taskid.split(",")));
		return null;
	}
	
}
