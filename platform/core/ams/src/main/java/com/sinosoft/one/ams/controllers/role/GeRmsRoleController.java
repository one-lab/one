package com.sinosoft.one.ams.controllers.role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.sinosoft.one.ams.model.Employe;
import com.sinosoft.one.ams.model.Role;
import com.sinosoft.one.ams.model.Task;
import com.sinosoft.one.ams.service.AccountManager;
import com.sinosoft.one.ams.service.facade.CompanyService;
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
	private RoleService roleService;
	
	@Autowired
	private CompanyService companyService;
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
		roleService.deleteRole(roleId, comCode);
		Map<String, Task> filter = new HashMap<String, Task>();
		List<Task> topList = new ArrayList<Task>();
		for (Task task : comsTasks) {
			filter.put(task.getTaskID(), task);
			if (task.getParent() == null) {
				topList.add(task);
			}
		}
		Treeable<NodeEntity> treeable = creatTaskTreeAble(topList,filter,rolesTasks);
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
		
		Map<String, Task> filter = new HashMap<String, Task>();
		List<Task> topList = new ArrayList<Task>();
		for (Task task : comsTasks) {
			filter.put(task.getTaskID(), task);
			if (task.getParent() == null) {
				topList.add(task);
			}
		}
		Treeable<NodeEntity> treeable = creatTaskTreeAble(topList,filter,rolesTasks);
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
	
	
	@Post("add/{name}/{des}/{roleType}/{taskId}")
	public Reply addRole(@Param("name")String name,@Param("des") String des,@Param("roleType") String roleType,@Param("taskId") String taskid, Invocation inv){
		Employe user = (Employe) inv.getRequest().getSession().getAttribute("user");
		String comCode = user.getCompany().getComCode();
		taskid=taskid.substring(0, taskid.length()-1);
		roleService.addRole(comCode, user.getUserCode(), name, des, roleType, Arrays.asList(taskid.split(",")));
		return null;
	}
	
	@Post("update/{roleId}/{name}/{des}/{roleType}/{taskId}")
	public Reply updateRole(@Param("roleId") String roleId,@Param("name")String name,@Param("des") String des,@Param("roleType") String roleType,@Param("taskId") String taskid, Invocation inv){
		Employe user = (Employe) inv.getRequest().getSession().getAttribute("user");
		String comCode = user.getCompany().getComCode();
		taskid=taskid.substring(0, taskid.length()-1);
		roleService.updateRole(roleId, comCode,user.getUserCode(), name, des, roleType, Arrays.asList(taskid.split(",")));
		return null;
	}

	@Post("findDesigNateComTree")
	public Reply findComTree(Invocation inv){
		Employe user = (Employe) inv.getRequest().getSession().getAttribute("user");
		String comCode = user.getCompany().getComCode();
		return null;
	}
	
	//-----------------------------------------------------------//
	/**
	 * 构建功能树 topTasks父节点 filter所有节点
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  Treeable<NodeEntity> creatTaskTreeAble(List<Task> topTasks,Map<String,Task> filter,List<Task>checkedTask){
		List<NodeEntity> nodeEntitys=new ArrayList<NodeEntity>();
		nodeEntitys=creatSubNode(topTasks, filter,checkedTask);
		Treeable<NodeEntity> treeable =new Treeable.Builder(nodeEntitys,"id", "title", "children", "state").classField("classField").urlField("urlField").builder();
		return treeable;
	}
	
	List<NodeEntity> creatSubNode(List<Task> topTasks,Map<String,Task> filter,List<Task>checkedTask){
		ArrayList<NodeEntity> nodeEntitys=new ArrayList<NodeEntity>();
		for (Task geRmsTask : topTasks) {
			if(!filter.containsKey(geRmsTask.getTaskID()))
                continue;
				NodeEntity nodeEntity = new NodeEntity();
				nodeEntity.setId(geRmsTask.getTaskID());
				nodeEntity.setTitle(geRmsTask.getName());
				for (Task checkTask : checkedTask) {
					if(geRmsTask.getTaskID().toString().equals(checkTask.getTaskID().toString())){
						nodeEntity.setClassField("jstree-checked");
					}
				}
				if(!geRmsTask.getChildren().isEmpty()){
					nodeEntity.setChildren(creatSubNode(geRmsTask.getChildren(),filter,checkedTask));
				}
				nodeEntitys.add(nodeEntity);
			}
		return nodeEntitys;
	}
}
