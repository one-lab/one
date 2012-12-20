package com.sinosoft.one.ams.controllers.staffing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.sinosoft.one.ams.model.BusPower;
import com.sinosoft.one.ams.model.Company;
import com.sinosoft.one.ams.model.DataRule;
import com.sinosoft.one.ams.model.Employe;
import com.sinosoft.one.ams.model.Group;
import com.sinosoft.one.ams.model.Role;
import com.sinosoft.one.ams.model.Task;
import com.sinosoft.one.ams.model.UserPower;
import com.sinosoft.one.ams.service.facade.CompanyService;
import com.sinosoft.one.ams.service.facade.EmployeeService;
import com.sinosoft.one.ams.service.facade.RoleService;
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

@Path
public class StaffingController {
	
	@Autowired
	private StuffingService stuffingService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private RoleService roleService;
	
	private List<String> userAttribute = new ArrayList<String>();
	
	//查询出所有的用户，返回页面
	@Post("userAll")
	@Get("userAll")
	public Reply list(@Param("pageNo") int pageNo, @Param("rowNum")int rowNum,Invocation inv) throws Exception{
		Pageable pageable = new PageRequest(pageNo-1, rowNum);
		
		Gridable<Employe> ga = new Gridable<Employe>(null);
		Gridable<Employe> gridable = employeeService.getGridable(ga,pageable,userAttribute);
		
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
		
		Gridable<Employe> gridable = new Gridable<Employe>(null);
		gridable = employeeService.getGridable(gridable,userCode,comCode, pageable, userAttribute);
		
		inv.getResponse().setContentType("text/html;charset=UTF-8");
	    Render render = (GridRender) UIUtil.with(gridable).as(UIType.Json);
		render.render(inv.getResponse());
		return null;
	}
	
	//将用户名和用户ID传到permissionSettings.jsp页面
	@Get("power/{name}/{userCode}")
	public String power(@Param("name")String name,@Param("userCode")String userCode, Invocation inv){
		
		inv.addModel("name", name);
		inv.addModel("userCode", userCode);
		return "permissionSettings";
		
	}
	
	//查询全部机构
	@Get("companyTree")
	public Reply companyList(Invocation inv) throws Exception{

		//查询出全部机构，并出入treeable中
//		Treeable<NodeEntity> treeable = companyService.getTreeable();
		
		List<Company> topCompany = new ArrayList<Company>();
		Map<String,Company> filter = new HashMap<String,Company>();
		List<Company> showCompany = (List<Company>) companyService.findAll();
		for(Company company : showCompany){
			if(company.getUpperComCode() == null){
				topCompany.add(company);
			}
			filter.put(company.getComCode(), company);
			
		}
		
		Treeable<NodeEntity> treeable =companyService.creatCompanyTreeAble(topCompany, filter);
		
		inv.getResponse().setContentType("text/html;charset=UTF-8");
		Render render = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
		render.render(inv.getResponse());
		return null;
	}
	
	//检查机构是否被引入
	@Get("checkCom/{comCode}/{userCode}")
	public Reply checkCom(@Param("comCode")String comCode,@Param("userCode")String userCode, Invocation inv){
		String result = stuffingService.checkIdByUserCodeComCode(userCode, comCode);
		return Replys.with(result);
	}
	//查询机构的用户组，并返回页面
	@Get("group/{comCode}")
	public Reply groupList(@Param("comCode")String comCode,Invocation inv){
		List<Group> groupList = stuffingService.findGroupByComCode(comCode);
		return Replys.with(groupList).as(Json.class);
	}
	//查询当前用户组的角色，并返回页面
	@Get("roleList/{groupId}/{comCode}")
	public Reply role(@Param("groupId")String groupId,@Param("comCode")String comCode,Invocation  inv){
		List<Role> groupRoleList = roleService.findRoleByGroupId(groupId, comCode);
		return Replys.with(groupRoleList).as(Json.class);
	}
	
	//查询当前机构，当前当前用户组，当前角色的根权限
	@Get("taskList/{comCode}/{roleIdStr}")
	public Reply taskList(@Param("comCode")String comCode, @Param("roleIdStr")String roleIdStr,Invocation  inv){
		List<Task> taskList = stuffingService.findTaskByRoleIdComCode(roleIdStr,comCode);
		return Replys.with(taskList).as(Json.class);
	}
	
	//查询当前机构，当前当前用户组，当前角色的根权限的后代权限
	@Get("taskChildren/{comCode}/{roleId}/{taskId}")
	public Reply taskChildren(@Param("comCode")String comCode,@Param("roleId")String roleId,@Param("taskId")String taskId,Invocation  inv) throws Exception{
		
		Treeable<NodeEntity> treeable = stuffingService.getTreeable(roleId, comCode, taskId);
		
		inv.getResponse().setContentType("text/html;charset=UTF-8");
		Render render = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
		render.render(inv.getResponse());
		return null;
	}
	
	
	
//	//用户的数据权限设置
//	@SuppressWarnings("unchecked")
//	@Get("user/{userCode}")
//	public Reply list(@Param("userCode")String userCode,Invocation inv) throws Exception{
//		
//		List<Company> companyList = new ArrayList<Company>();
//		List<UserPower> userPowerList = new ArrayList<UserPower>();
//		
//		NodeEntity nodeEntity = new NodeEntity("comCode", "comCName", "close");
//		nodeEntity = stuffingService.getNodeEntity(nodeEntity,userCode,companyList,userPowerList);
//		
//		Treeable<NodeEntity> treeable = new Treeable.Builder<NodeEntity>(nodeEntity.getChildren(), "id", "title", "children", "state").builder();
//		inv.getResponse().setContentType("text/html;charset=UTF-8");
//		Render render = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
//		render.render(inv.getResponse());
//		return null;
//	}
//	
//	@Get("ruleAll/{taskId}/{userPowerId}")
//	public Reply ruleAll(@Param("taskId")String taskId,@Param("userPowerId")String userPowerId,Invocation inv) throws Exception {
//		
//		List<DataRule> ruleAll = stuffingService.getRuleAll(userPowerId, taskId);
//		
//		return Replys.with(ruleAll).as(Json.class);
//	}
//	
//	//保存数据设置
//	@Post("save/{ruleIdStr}/{userPowerId}/{taskId}/{paramStr}")
//	public Reply save(@Param("ruleIdStr")String ruleIdStr,@Param("userPowerId")String userPowerId,@Param("taskId")String taskId,@Param("paramStr")String paramStr,Invocation inv){
//		
//		String[]ruleIdArr = ruleIdStr.split(",");
//		String[]paramArr = paramStr.split(",");
//		BusPower busPower = new BusPower();
//		
//		String result = stuffingService.saveBusPower(busPower, ruleIdArr, paramArr, userPowerId, taskId);
//		
//		System.out.println(result);
//		return Replys.with("success");
//	}
//	
//	@Get("companyList/{userCode}")
//	public Reply companyList(@Param("userCode")String userCode, Invocation inv) throws Exception{
//		
//		NodeEntity nodeEntity = new NodeEntity("comCode", "comCName", "close");
//		stuffingService.recursionCompany(nodeEntity, null, userCode);
//		
//		@SuppressWarnings("unchecked")
//		Treeable<NodeEntity> treeable = new Treeable.Builder<NodeEntity>(nodeEntity.getChildren(), "id", "title", "children", "state").builder();
//		inv.getResponse().setContentType("text/html;charset=UTF-8");
//		Render render = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
//		render.render(inv.getResponse());
//		return null;
//	}
//	
//	//查询机构的用户组，并返回页面
//	@Get("group/{comCode}")
//	public Reply groupList(@Param("comCode")String comCode,Invocation inv){
//		List<Group> groupList = stuffingService.findGroupByComCode(comCode);
//		return Replys.with(groupList).as(Json.class);
//	}
//	
//	//查询用户组的角色，并返回页面
//	@Get("roleList/{groupId}")
//	public Reply role(@Param("groupId")String groupId,Invocation  inv){
//		List<Role> groupRoleList = stuffingService.findRoleByGroupId(groupId);
//		System.out.println(groupId);
//		System.out.println(groupRoleList.size()+"+++++++++++++++++++++++++++++++++");
//		return Replys.with(groupRoleList).as(Json.class);
//	}

}
