package com.sinosoft.ebusiness.rms.web;

import ins.framework.common.Page;
import ins.framework.utils.StringUtils;
import ins.framework.web.Struts2Action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sinosoft.ebusiness.rms.model.BusPower;
import com.sinosoft.ebusiness.rms.model.Employe;
import com.sinosoft.ebusiness.rms.model.Group;
import com.sinosoft.ebusiness.rms.model.GroupRole;
import com.sinosoft.ebusiness.rms.model.Role;
import com.sinosoft.ebusiness.rms.model.RoleDesignate;
import com.sinosoft.ebusiness.rms.model.Task;
import com.sinosoft.ebusiness.rms.service.facade.DataRuleService;
import com.sinosoft.ebusiness.rms.service.facade.GroupService;
import com.sinosoft.ebusiness.rms.service.facade.RmsService;
import com.sinosoft.ebusiness.rms.service.facade.RoleService;
import com.sinosoft.ebusiness.rms.web.util.Item;
import com.sinosoft.ebusiness.rms.web.util.Tree;
import com.sinosoft.ebusiness.util.encode.JaxbBinder;

@SuppressWarnings("unchecked")
public class GroupAction extends Struts2Action {
	private static final long serialVersionUID = 1L;
	
	private static JaxbBinder jaxbBinder = new JaxbBinder(Tree.class);
	//角色接口
	private RoleService roleService;
	//用户组接口
	private GroupService groupService;
	//数据规则接口
	private DataRuleService dataRuleService;
	//权限接口
	private RmsService rmsService;
	
	private Page page;
	//用户组集合
	private List<Group> groups;
	//角色集合
	private List<Role>roles;
	private List<RoleDesignate> roleDesignates;
	//已选角色集合
	private List<Role> onRoles;
	//人员集合
	private List<Employe> employes;
	//数据权限集合
	private List<BusPower> busPowers;
	//角色ID
	private List<String> roleIDs;
	
	private Group group;
	
	private Employe employee;
	
	private String userCode;
	
	private String comCode;
	/**
	 * 查询用户组列表
	 * @return
	 */
	public String queryGroup(){
		Map<String, Object> employeeMap =(Map<String, Object>)getSession().getAttribute("loginInfo");
		Employe employe=(Employe)employeeMap.get("employe");
		if(this.pageNo ==0){
			this.pageNo = 1;
		}
		if(this.pageSize == 0){
			this.pageSize = 10;
		}
		String name = "";
		if(group != null) {
			name = group.getName();
		}
		groups=new ArrayList<Group>();
		page = groupService.findGroup(name, employe.getCompany().getComCode(), pageNo, pageSize);
		groups= page.getResult();
		//默认用户组置底
		for (Group group : groups) {
			if(!StringUtils.isBlank(group.getName())){
				if (group.getName().toString().equals("默认用户组")) {
					groups.set(groups.indexOf(group),
							groups.get(groups.size() - 1));
					groups.set(groups.size() - 1, group);
				}
			}
//				Set<Role> roles=new HashSet<Role>();
//				roles=roleService.findRoleByGroup(Arrays.asList(group.getGroupID()), employe.getCompany().getComCode());
//				StringBuffer str=new StringBuffer();
//				for (Role role : roles) {
//				str.append(""+role.getName()+",");
//				}
//				str.delete(str.length(), str.length()-1);
//				group.setGroupRole(str.toString());
		}
		return SUCCESS;
	}
	
	/**
	 * 跳转增加用户组
	 * @return
	 */
	public String prepareAddGroup() {
		Map<String, Object> employeeMap =(Map<String, Object>)getSession().getAttribute("loginInfo");
		Employe employe=(Employe)employeeMap.get("employe");
		roleDesignates=new ArrayList<RoleDesignate>();
		roleDesignates = roleService.findRoleByCom(employe.getCompany().getComCode() );
		return SUCCESS;
	}
	
	public String saveGroup() {
		Map<String, Object> employeeMap =(Map<String, Object>)getSession().getAttribute("loginInfo");
		Employe employe=(Employe)employeeMap.get("employe");
		if(roleIDs==null){
			roleIDs=new ArrayList<String>();
		}
		groupService.addGroup(employe.getUserCode(),employe.getCompany().getComCode(), group.getName(), group.getDes(), roleIDs);
		this.getRequest().setAttribute("success","1");
		return SUCCESS;
	}
	// 删除
	public String deleteGroup() {
		groupService.deleteGroup(group.getGroupID());
		return SUCCESS;
	}

	/**
	 * 跳转更新页面
	 */
	public String prepareUpdata() {
		Map<String, Object> employeeMap =(Map<String, Object>)getSession().getAttribute("loginInfo");
		Employe employe=(Employe)employeeMap.get("employe");
		group=groupService.findGroupByID(group.getGroupID());
		List<Role> Rs=new ArrayList<Role>();
		for (Iterator<GroupRole> iterator = group.getGroupRoles().iterator(); iterator.hasNext();) {
			GroupRole groupRole = (GroupRole) iterator.next();
			Rs.add(groupRole.getRole());
		}
		onRoles=Rs;
		roleDesignates=new ArrayList<RoleDesignate>();
		roleDesignates= roleService.findRoleByCom(employe.getCompany().getComCode() );
		return SUCCESS;
	}
	/**
	 * 查询组成员
	 * @return
	 */
	public String findGroupUser(){
		Map<String, Object> employeeMap =(Map<String, Object>)getSession().getAttribute("loginInfo");
		Employe employe=(Employe)employeeMap.get("employe");
		if(this.pageNo ==0){
			this.pageNo = 1;
		}
		if(this.pageSize == 0){
			this.pageSize = 10;
		}
		page=groupService.findEmployeByGroup(group.getGroupID(), employe.getCompany().getComCode(), employee.getUserName(), employee.getUserCode(), pageSize, pageNo);
		employes=page.getResult();
		return SUCCESS;
	} 
	
	/**
	 * 查询未添加到用户组的用户
	 * @return
	 */
	public String findNIntroduced(){
		if(this.pageNo ==0){
			this.pageNo = 1;
		}
		if(this.pageSize == 0){
			this.pageSize = 10;
		}
		page=groupService.findNEmployeByGroup(group.getGroupID(),group.getComCode(), employee.getUserName(), employee.getUserCode(),pageSize, pageNo);
		employes=page.getResult();
		return SUCCESS;
	}
	
	public String addGroupUser(){
		List<String> groupIDs=new ArrayList<String>();
		groupIDs.add(group.getGroupID());
		List<String> ExcTaskIDs=new ArrayList<String>();
		rmsService.addUserPower(employee.getUserCode(), group.getComCode(), groupIDs, ExcTaskIDs);
		return NONE;
	}
	public String deleteGroupUser(){
		groupService.deleteUserGroupByID(userCode, group.getGroupID());
		return SUCCESS;
	}
	/**
	 * 更新操作
	 * @return
	 */
	public String updataGroup() {
		Map<String, Object> employeeMap =(Map<String, Object>)getSession().getAttribute("loginInfo");
		Employe employe=(Employe)employeeMap.get("employe");
		List<String> roleids=new ArrayList<String>();
		if(roleIDs!=null){
			roleids=roleIDs;
		}
		groupService.updataGroup(group.getGroupID(),employe.getUserCode(),employe.getCompany().getComCode(), group.getName(), group.getDes(), roleids);
		return SUCCESS;
	}
	
	public String findGroupUserInfo(){
		employee=rmsService.findUserByCode(userCode);
		groups=groupService.findGroupByUser(userCode);
		List<String> groupIDs=new ArrayList<String>();
		for (Group group : groups) {
			groupIDs.add(group.getGroupID());
		}
		Set<Role> rols =new HashSet<Role>();
		rols=roleService.findRoleByGroup(groupIDs,employee.getCompany().getComCode());
		List<Role>rList=new ArrayList<Role>();
		for (Role role : rols) {
			rList.add(role);
		}
		roles=rList;
		busPowers=dataRuleService.findBusPowerByUserCode(userCode);
		return SUCCESS;
	}
	/**
	 * 功能树
	 * @return
	 */
	public String userTaskTree() {
		List<Task> tasks = new ArrayList<Task>();
		tasks = rmsService.findTaskByUserCode(userCode, comCode);
		// 创建XML
		Map<String, Task> filter = new HashMap<String, Task>();
		List<Task> topList = new ArrayList<Task>();
		for (Task task : tasks) {
			filter.put(task.getTaskID(), task);
			if (task.getParent() == null) {
				topList.add(task);
			}
		}
		String xml = getTreeXML(topList, filter);
		this.renderXML(xml);
		return NONE;
	}
	//加载页面
	public String loadGroup(){
		return "success";
	}
	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}
	public RoleService getRoleService() {
		return roleService;
	}
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	public List<Group> getGroups() {
		return groups;
	}
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public List<Role> getOnRoles() {
		return onRoles;
	}
	public void setOnRoles(List<Role> onRoles) {
		this.onRoles = onRoles;
	}
	public List<String> getRoleIDs() {
		return roleIDs;
	}
	public void setRoleIDs(List<String> roleIDs) {
		this.roleIDs = roleIDs;
	}
	public List<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public DataRuleService getDataRuleService() {
		return dataRuleService;
	}
	public void setDataRuleService(DataRuleService dataRuleService) {
		this.dataRuleService = dataRuleService;
	}
	public List<BusPower> getBusPowers() {
		return busPowers;
	}
	public void setBusPowers(List<BusPower> busPowers) {
		this.busPowers = busPowers;
	}
	public RmsService getRmsService() {
		return rmsService;
	}
	public void setRmsService(RmsService rmsService) {
		this.rmsService = rmsService;
	}
	public Employe getEmployee() {
		return employee;
	}
	public void setEmployee(Employe employee) {
		this.employee = employee;
	}
	public List<RoleDesignate> getRoleDesignates() {
		return roleDesignates;
	}

	public void setRoleDesignates(List<RoleDesignate> roleDesignates) {
		this.roleDesignates = roleDesignates;
	}

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
//			if(task.getDes()!=null&&task.getDes()!=""){	
//				if(task.getDes().toString().equals("true")){
//					item.setChecked("1");
//				}
//				if(task.getDes().toString().equals("radio")){
//					item.setChecked("1");
//					item.setRadio("1");
//				}  
//			}	
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
