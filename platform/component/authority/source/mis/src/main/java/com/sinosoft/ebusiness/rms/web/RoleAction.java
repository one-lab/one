package com.sinosoft.ebusiness.rms.web;

import ins.framework.common.Page;
import ins.framework.web.Struts2Action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.sinosoft.ebusiness.rms.model.Company;
import com.sinosoft.ebusiness.rms.model.Employe;
import com.sinosoft.ebusiness.rms.model.Role;
import com.sinosoft.ebusiness.rms.model.RoleDesignate;
import com.sinosoft.ebusiness.rms.model.RoleDesignateInfo;
import com.sinosoft.ebusiness.rms.model.RoleTask;
import com.sinosoft.ebusiness.rms.model.Task;
import com.sinosoft.ebusiness.rms.service.facade.RmsService;
import com.sinosoft.ebusiness.rms.service.facade.RoleService;
import com.sinosoft.ebusiness.rms.service.facade.TaskService;
import com.sinosoft.ebusiness.rms.web.util.Item;
import com.sinosoft.ebusiness.rms.web.util.Tree;
import com.sinosoft.ebusiness.util.encode.JaxbBinder;

@SuppressWarnings("unchecked")
public class RoleAction extends Struts2Action {

	private static final long serialVersionUID = 1L;
	private static JaxbBinder jaxbBinder = new JaxbBinder(Tree.class);

	private String id;
	
	private List<Task> canAuthTasks;
 
	private TaskService rmstaskService;
	
	private RoleService roleService;
	
	private RmsService rmsService;
	
	private Role role;
	
	//角色指派类集合
	private List<RoleDesignate> roleDesignates;
	
	//角色指派信息集合
	private List<RoleDesignateInfo> roleDesignateInfos;
	
	//角色集合
	private List<Role> roles;
	
	private Page page;
	
	private String taskIds;
	
	private String comCode;
	
	private String upperComCode;
	
	private String roleIDs;
	
	
	/**
	 * 查询角色信息
	 * 
	 * @return
	 */
	public String queryRole() {
		Map<String, Object> employeeMap =(Map<String, Object>)getSession().getAttribute("loginInfo");
		Employe loginEmploye=(Employe)employeeMap.get("employe");
		//设定首页为1
		System.out.println(pageNo+"-=============================");
		if(pageNo ==0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = 10;
		}
		//角色查询
		String name = "";
		if(role != null) {
			name = role.getName();
		}
		page = roleService.findRole(loginEmploye.getCompany().getComCode(), name, pageNo, pageSize);
		roles = page.getResult();
//		for (Role iterable_element : roles) {
//			Set<Task> tasks=new HashSet<Task>();
//			tasks=taskService.findTaskByRole(Arrays.asList(iterable_element.getRoleID()),loginEmploye.getCompany().getComCode() );
//			StringBuffer str=new StringBuffer();
//			for (Task task : tasks) {
//			str.append(""+task.getName()+",");
//			}
//			str.delete(str.length(), str.length()-1);
//			iterable_element.setRoleTask(str.toString());
//			} 
		return SUCCESS;
	}
	/**
	 * 跳转创建角色页面
	 * @return
	 */
	public String prepareAddRole() {
		return SUCCESS;
	}
	/**
	 * 创建角色操作
	 * @return
	 */
	public String saveRole(){
		Map<String, Object> employeeMap =(Map<String, Object>)getSession().getAttribute("loginInfo");
		Employe employe=(Employe)employeeMap.get("employe");
		String[] ids =taskIds.split(",");
		List<String>idList=Arrays.asList(ids);
		roleService.addRole(employe.getCompany().getComCode(), employe.getUserCode(), idList, role.getName(), role.getDes());
		return SUCCESS;
	}
	/**
	 * 功能树
	 * @return
	 */
	public String taskTree() {
		Map<String, Object> employeeMap =(Map<String, Object>)getSession().getAttribute("loginInfo");
		Employe loginEmploye=(Employe)employeeMap.get("employe");
		role = roleService.findRoleById(role.getRoleID());
		Set<Task> tasks = new HashSet<Task>();
		if (role != null) {
			List<String> roleid = new ArrayList<String>();
			roleid.add(role.getRoleID());
			//机构为当前操作人员机构
			tasks = rmstaskService.findTaskByRole(roleid,loginEmploye.getCompany().getComCode());
		}
		Set<Task> canAuthTasks = new HashSet<Task>();
		//机构为当前操作人员机构 获得机构下权限
		canAuthTasks = rmstaskService.findTaskAuthByComCode(loginEmploye.getCompany().getComCode());
		// 角色下的权限标记到 权限集合中
		for (Iterator<Task> iterator = canAuthTasks.iterator(); iterator
				.hasNext();) {
			Task allTask = iterator.next();
			for (Iterator<Task> iterator2 = tasks.iterator(); iterator2
					.hasNext();) {
				Task userTask = (Task) iterator2.next();
				if (allTask.getTaskID().equals(userTask.getTaskID())) {
					allTask.setDes("true");
					break;
				} else {
					allTask.setDes("false");
				}
			}
		}
		// 创建XML
		Map<String, Task> filter = new HashMap<String, Task>();
		List<Task> topList = new ArrayList<Task>();
		for (Task task : canAuthTasks) {
			filter.put(task.getTaskID(), task);
			if (task.getParent() == null) {
				topList.add(task);
			}
		}
		String xml = getTreeXML(topList, filter);
		this.renderXML(xml);
		return NONE;
	}
	/**
	 * 机构树
	 * @return
	 */
	public String treeComCode() {
		List<Company> companys = null;
		Map<String, Object> employeeMap =(Map<String, Object>)getSession().getAttribute("loginInfo");
		Employe loginEmploye=(Employe)employeeMap.get("employe");
		if (StringUtils.isBlank(id)) {
			//机构为当前操作人员机构
			companys = rmsService.findNextSubCom(loginEmploye.getCompany().getComCode());
		} else {
			String str[]=id.split("-");
    	    companys= rmsService.findNextSubCom(str[1]);
		}
		Tree tree = new Tree();
		ArrayList<Item> items = new ArrayList<Item>();
		for (Company company : companys) {
			Item subtree = new Item();
			//解决树形页面全零显示添加"id-" 标志
			subtree.setId("id-"+company.getComCode());
			subtree.setText(company.getComEName());
			if (rmsService.isExtSubCom(company.getComCode().toString())) 
				subtree.setChild("1");
			else
				subtree.setChild("0");
			items.add(subtree);
		}
		if (StringUtils.isBlank(id))
			tree.setId("0");
		else
			tree.setId(id);
		tree.setItems(items);
		String xml = jaxbBinder.toXml(tree, "gbk2312");
		this.renderXML(xml);
		return NONE;
	}
	/**
	 * 角色指派操作
	 * @return
	 */
	public String designate(){
		Map<String, Object> employeeMap =(Map<String, Object>)getSession().getAttribute("loginInfo");
		Employe loginEmploye=(Employe)employeeMap.get("employe");
		List<String> roleids=new ArrayList<String>();
		if (roleIDs != null) {
			String[] ids = roleIDs.split(",");
			roleids = Arrays.asList(ids);
		}
		//机构为当前操作人员机构
		roleService.roleDesignate(roleids, comCode,loginEmploye.getUserCode());
		return SUCCESS;
	}
	/**
	 * 查询指派信息
	 * @return
	 */
	public String querydesignate(){
		Map<String, Object> employeeMap =(Map<String, Object>)getSession().getAttribute("loginInfo");
		Employe loginEmploye=(Employe)employeeMap.get("employe");
		roleDesignates=new ArrayList<RoleDesignate>();
		//机构为当前操作人员机构
		if(upperComCode.toString().equals("0")){
			roleDesignates = roleService.findRoleByCom(loginEmploye.getCompany().getComCode());
		}else{
			roleDesignates = roleService.findRoleByCom(upperComCode);
		}
		List<RoleDesignate>isDesignates=new ArrayList<RoleDesignate>();
		isDesignates=roleService.findRoleByCom(comCode);
		List<String>OnRoleIds=new ArrayList<String>();
		for (RoleDesignate roleDesignate : isDesignates) {
			OnRoleIds.add(roleDesignate.getRole().getRoleID());
		}
		for (RoleDesignate roleDesignate : roleDesignates) {
			if(OnRoleIds.contains(roleDesignate.getRole().getRoleID().toString())){
				roleDesignate.setFlag("true");
			}
		}
		return SUCCESS;
	}
	/**
	 * 准备查看/更新角色信息跳转
	 * @return
	 */
	public String prepareUpdata() {
		Map<String, Object> employeeMap =(Map<String, Object>)getSession().getAttribute("loginInfo");
		Employe loginEmploye=(Employe)employeeMap.get("employe");
		//机构为当前操作人员机构获以用来获取下级机构
		roleDesignateInfos=new ArrayList<RoleDesignateInfo>();
		roleDesignateInfos=roleService.findComByRoleID(role.getRoleID(),loginEmploye.getCompany().getComCode());
 		role = roleService.findRoleById(role.getRoleID());
 		for (RoleTask iterable_element : role.getRoleTasks()) {
			System.out.println(iterable_element.getTaskAuth().getTask().getTaskID());
		}
 		return SUCCESS;
	}
	/**
	 * 更新角色信息
	 * 
	 * @return
	 */
	public String updateRole() {
		Map<String, Object> employeeMap =(Map<String, Object>)getSession().getAttribute("loginInfo");
		Employe employe=(Employe)employeeMap.get("employe");
		if(!employe.getCompany().getComCode().toString().equals(role.getComCode())){
			return INPUT;
		}
		String[] taskids =taskIds.split(",");
		List<String>taskidList=Arrays.asList(taskids);
		List<String>comcodeList=new ArrayList<String>();
		if(StringUtils.isNotBlank(comCode)){
			String[] comcodes =comCode.split(",");
			comcodeList=Arrays.asList(comcodes);
		}
		roleService.updataRoleByID(role.getRoleID(), comcodeList,employe.getCompany().getComCode(), employe.getUserCode(), taskidList, role.getName(), role.getDes());
		return SUCCESS;
	}
	
	public String deleteRole(){
		Map<String, Object> employeeMap =(Map<String, Object>)getSession().getAttribute("loginInfo");
		Employe employe=(Employe)employeeMap.get("employe");
		roleService.deleteRole(role.getRoleID(), employe.getCompany().getComCode());
		return SUCCESS;
	}
	
	//加载页面
	public String loadRole(){
		return "success";
	}
	//加载页面
	public String loadroleDesignate(){
		return "success";
	}
/*.....................................自 动 生 成..............................*/
	
	public TaskService getRmstaskService() {
		return rmstaskService;
	}
	public void setRmstaskService(TaskService rmstaskService) {
		this.rmstaskService = rmstaskService;
	}
	public List<Task> getCanAuthTasks() {
		return canAuthTasks;
	}
	public void setCanAuthTasks(List<Task> canAuthTasks) {
		this.canAuthTasks = canAuthTasks;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public RoleService getRoleService() {
		return roleService;
	}
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<RoleDesignate> getRoleDesignates() {
		return roleDesignates;
	}
	public void setRoleDesignates(List<RoleDesignate> roleDesignates) {
		this.roleDesignates = roleDesignates;
	}
	public List<RoleDesignateInfo> getRoleDesignateInfos() {
		return roleDesignateInfos;
	}
	public void setRoleDesignateInfos(List<RoleDesignateInfo> roleDesignateInfos) {
		this.roleDesignateInfos = roleDesignateInfos;
	}
	public String getTaskIds() {
		return taskIds;
	}
	public void setTaskIds(String taskIds) {
		this.taskIds = taskIds;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public RmsService getRmsService() {
		return rmsService;
	}
	public void setRmsService(RmsService rmsService) {
		this.rmsService = rmsService;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getRoleIDs() {
		return roleIDs;
	}
	public void setRoleIDs(String roleIDs) {
		this.roleIDs = roleIDs;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public String getUpperComCode() {
		return upperComCode;
	}
	public void setUpperComCode(String upperComCode) {
		this.upperComCode = upperComCode;
	}
	/**
	 * 构建功能树XML
	 * @param topList
	 * @param filter
	 * @return
	 */
	public String getTreeXML( List<Task> topList ,Map<String,Task> filter){
		Tree tree = new Tree();
		List<Task> tasks= new ArrayList<Task>();
		for (Task task : topList) {
			tasks.add(task);
		}
		tree.setId("0");
		tree.setItems(creatTaskTree(tasks, filter));
		String xmlString = jaxbBinder.toXml(tree, "gbk2312");
		return xmlString;
	}
	public ArrayList<Item>  creatTaskTree(List<Task> topList ,Map<String,Task> filter){
		ArrayList<Item> items=new ArrayList<Item>();
		for (Task task : topList) {
			if(!filter.containsKey(task.getTaskID()))
                continue;
			Item item=new Item();
			if(task.getDes()!=null&&task.getDes()!=""){	
				if(task.getDes().toString().equals("true")){
					item.setChecked("1");
				} 
			}	
			item.setId(task.getTaskID());
			item.setText(task.getName().toString());
			item.setOpen("1");
			if(!task.getChildren().isEmpty()){
				item.setItem(creatTaskTree(task.getChildren(), filter));
			}
			items.add(item);
		}
		return items;
	}
}
