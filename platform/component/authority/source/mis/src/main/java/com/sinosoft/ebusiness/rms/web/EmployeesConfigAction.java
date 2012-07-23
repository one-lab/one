package com.sinosoft.ebusiness.rms.web;

import ins.framework.common.Page;
import ins.framework.web.Struts2Action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.sinosoft.ebusiness.rms.model.BusPower;
import com.sinosoft.ebusiness.rms.model.Company;
import com.sinosoft.ebusiness.rms.model.DataRule;
import com.sinosoft.ebusiness.rms.model.Employe;
import com.sinosoft.ebusiness.rms.model.Group;
import com.sinosoft.ebusiness.rms.model.Role;
import com.sinosoft.ebusiness.rms.model.Task;
import com.sinosoft.ebusiness.rms.model.UserPower;
import com.sinosoft.ebusiness.rms.service.facade.DataRuleService;
import com.sinosoft.ebusiness.rms.service.facade.GroupService;
import com.sinosoft.ebusiness.rms.service.facade.RmsService;
import com.sinosoft.ebusiness.rms.service.facade.RoleService;
import com.sinosoft.ebusiness.rms.service.facade.TaskService;
import com.sinosoft.ebusiness.rms.web.util.Item;
import com.sinosoft.ebusiness.rms.web.util.Tree;
import com.sinosoft.ebusiness.util.encode.JaxbBinder;

@SuppressWarnings("unchecked")
public class EmployeesConfigAction extends Struts2Action {

    private static final long serialVersionUID = 1L;
    
    private static JaxbBinder jaxbBinder = new JaxbBinder(Tree.class);
    
    private Employe employe;
    
    private UserPower userPower;
    //page
    private Page page;
    //权限service模块
    private RmsService rmsService;
    //用户组service模块
    private GroupService groupService;
    //角色service模块
    private RoleService roleService;
    //功能service模块
    private TaskService rmstaskService;
    //数据权限 service模块
    private DataRuleService dataRuleService;
    //人员列表
    private List<Employe>employes;
    //用户组列表
    private List<Group> groups;
    //角色列表
    private Set<Role> roles;
    //数据权限列表
    private List<BusPower>busPowers;
    //数据规则列表
    private List<DataRule>dataRules;
 	
    private String dataRule;
    //机构树机构ID
    private String id; 
    
    private String comCode;
    
    private String roleID;
    
    private String groupID;
	
    private String taskID;
    
    private String busPowerId;
    /**
     *  机构树
     * @return
     */
    public String treeComCode(){
    	List<Company> companys = null;
    	Map<String, Object> employeeMap =(Map<String, Object>)getSession().getAttribute("loginInfo");
		Employe loginEmploye=(Employe)employeeMap.get("employe");
    	if(loginEmploye==null){
    		return "input";
    	}
    	Tree tree = new Tree();
    	ArrayList<Item> items =new ArrayList<Item>();
    	//第一次加载
    	if(StringUtils.isBlank(id)){
    		companys= rmsService.findNextSubCom(loginEmploye.getCompany().getComCode());
        	Item supperNode=new Item();
        	supperNode.setId("id-"+loginEmploye.getCompany().getComCode());
        	supperNode.setOpen("1");
        	supperNode.setText(loginEmploye.getCompany().getComEName());
        	ArrayList<Item> subItems =new ArrayList<Item>();
        	for (Company company : companys) {
        		Item subtree = new Item();
        		//树形控件全0情况下不显示图片 故添加字符串改变
        		subtree.setId("id-"+company.getComCode());
        		subtree.setText(company.getComEName());
        		if(rmsService.isExtSubCom(company.getComCode().toString())) {
        			subtree.setChild("1");
        		}else{
        			subtree.setChild("0");	
        		}
        		subItems.add(subtree);
    		}
        	supperNode.setItem(subItems);
        	items.add(supperNode);
    	}else{
    		String str[]=id.split("-");
    	    companys= rmsService.findNextSubCom(str[1]);  
        	for (Company company : companys) {
        		Item subtree = new Item();
        		//树形控件全0情况下不显示图片 故添加字符串改变
        		subtree.setId("id-"+company.getComCode());
        		subtree.setText(company.getComEName());
        		if(rmsService.isExtSubCom(company.getComCode().toString())) {
        			subtree.setChild("1");
        		}else{
        			subtree.setChild("0");	
        		}
        		items.add(subtree);
    		}
    	}
    	if(StringUtils.isBlank(id))
    		tree.setId("0");
    	else
    		tree.setId(id);
    	tree.setItems(items);
    	String xml = jaxbBinder.toXml(tree, "gbk2312");
    	System.out.println(xml);
		this.renderXML(xml);
		return NONE; 
    }

    /**
     * 根据机构代码查询该机构下引入的所有员工
     * @return
     */
    public String findIntroduced(){
    	if(this.pageNo ==0){
            this.pageNo = 1;
        }
        if(this.pageSize == 0){
            this.pageSize = 10;
        }
    	page=rmsService.findEmployees(comCode, employe.getUserCode(), employe.getUserName(), pageNo, pageSize);
    	employes=page.getResult();
    	getRequest().setAttribute("querytype", "findIntroduced");
    	return SUCCESS;
    }
    
    /**
     * 根据机构代码查询可用于引入的员工
     * @return
     */
    public String findNoIntroduced(){
    	if(this.pageNo ==0){
            this.pageNo = 1;
        }
        if(this.pageSize == 0){
            this.pageSize = 10;
        }
    	page=rmsService.findNEmployees(employe.getUserCode(), employe.getUserName(), comCode, pageNo, pageSize);
    	employes=page.getResult();
    	getRequest().setAttribute("querytype", "findNoIntroduced");
    	return SUCCESS;
    }
    /**
     * 根据用户代码获取用户组
     */
    public String findGroupByUser(){
    	groups= groupService.findGroupByCom(comCode);
    	userPower=rmsService.findUserPowerByComUser(employe.getUserCode(), comCode);
    	List<Group> usGroups=groupService.findGroupByUser(employe.getUserCode());
    	List<String>groupids=new ArrayList<String>();
    	for (Group group : groups) {
    		group.setDes("false");
    		for (Group usgroup : usGroups) {
				if(group.getGroupID().toString().equals(usgroup.getGroupID().toString())){
					group.setDes("true");
				}
				groupids.add(usgroup.getGroupID());
			}
		}
    	getRequest().setAttribute("comCode", comCode);
    	return SUCCESS;
    }
    /**
     * 加载用户组下的角色信息页面
     * @return
     */
    public String loadGroupInfo(){
    	String[] ids =groupID.split(",");
		List<String>idList=Arrays.asList(ids);
		roles=roleService.findRoleByGroup(idList,comCode);
    	return SUCCESS;
    }
    /**
	 * 功能树
	 * @return
	 */
	public String taskTree() {
		List<String> roleIds = new ArrayList<String>();
		roleIds = Arrays.asList(roleID.split(","));
		Set<Task> tasks = new HashSet<Task>();
		if(!roleIds.get(0).toString().equals(""))
			tasks = rmstaskService.findTaskByRole(roleIds, comCode);
		Set<Task> ExcTasks = new HashSet<Task>();
		ExcTasks = rmsService.findExcPower(employe.getUserCode(), comCode);
		for (Task task : tasks) {
			task.setDes("true");
			if(ExcTasks!=null){
				for (Task userExcTask : ExcTasks) {
					if (task.getTaskID().equals(userExcTask.getTaskID())) {
						task.setDes("false");
						break;
					}
				}
			}
		}
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
    /**
     * 编辑/增加人员权限
     * @return
     */
	public String saveUserPower(){
		List<String> groupIDList = new ArrayList<String>();
		if (!"".equals(groupID)) {
			groupIDList = Arrays.asList(groupID.split(","));
		}
		List<String> excTaskIdList=new ArrayList<String>();
        if(!"".equals(taskID)){
            excTaskIdList = Arrays.asList(taskID.split(","));
        }
		rmsService.addUserPower(employe.getUserCode(), comCode, groupIDList, excTaskIdList);
		return NONE;
	}
	
	public String deleteUserPower(){
		rmsService.deleteUserPower(employe.getUserCode(), comCode);
		return NONE;
	}	
	/**
	 * 查询数据权限相关信息
	 * @return
	 */
	public String findBusPowerInfo(){
		busPowers=dataRuleService.findBusPowerByTaskID(employe.getUserCode(), taskID);
		dataRules=new ArrayList<DataRule>();;
		List<DataRule> datarules=dataRuleService.findAllDataRule();
		for (DataRule dataRule : datarules) {
			int i=0;
			for (BusPower busPower : busPowers) {
				if(!dataRule.getDataRuleID().toString().equals(busPower.getDataRule().getDataRuleID()))
					i++;
			}
			if(i==busPowers.size()){
				dataRules.add(dataRule);
			}
		}
		return SUCCESS;
	}
	/**
	 * 数据权限页面功能树
	 * @return
	 */
	public String busPowertaskTree(){
		List<Task> tasks = new ArrayList<Task>();
		tasks = rmsService.findTaskByUserCode(employe.getUserCode(), comCode);
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
	/**、
	 * 保存数据权限
	 * @return
	 */
	public String saveBusPower(){
		UserPower usPower =rmsService.findUserPowerByComUser(employe.getUserCode(), comCode);
		List<String> datarule=new ArrayList<String>();
		datarule= Arrays.asList(dataRule.split(","));
		for (String str : datarule) {
			String idAndPranm[]=str.split("-");
			if(idAndPranm.length==1)
				dataRuleService.addBusPower(usPower.getUserPowerID(), idAndPranm[0], taskID, "");
			else
				dataRuleService.addBusPower(usPower.getUserPowerID(), idAndPranm[0], taskID, idAndPranm[1]);
		}
		return SUCCESS;
	}
	//加载页面
	public String loadEmployeesConfig(){
		return "success";
	}
    public Employe getEmploye() {
        return employe;
    }
    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
    public RmsService getRmsService() {
        return rmsService;
    }
    public void setRmsService(RmsService rmsService) {
        this.rmsService = rmsService;
    }
    public Page getPage() {
        return page;
    }
    public void setPage(Page page) {
        this.page = page;
    }
	public List<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public GroupService getGroupService() {
		return groupService;
	}
	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}
	public List<Group> getGroups() {
		return groups;
	}
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	public RoleService getRoleService() {
		return roleService;
	}
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	public TaskService getRmstaskService() {
		return rmstaskService;
	}

	public void setRmstaskService(TaskService rmstaskService) {
		this.rmstaskService = rmstaskService;
	}

	public DataRuleService getDataRuleService() {
		return dataRuleService;
	}
	public void setDataRuleService(DataRuleService dataRuleService) {
		this.dataRuleService = dataRuleService;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public String getRoleID() {
		return roleID;
	}
	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}
	public String getGroupID() {
		return groupID;
	}
	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}
	public String getTaskID() {
		return taskID;
	}
	public List<BusPower> getBusPowers() {
		return busPowers;
	}
	public void setBusPowers(List<BusPower> busPowers) {
		this.busPowers = busPowers;
	}
	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}
	public String getBusPowerId() {
		return busPowerId;
	}
	public void setBusPowerId(String busPowerId) {
		this.busPowerId = busPowerId;
	}
	public List<DataRule> getDataRules() {
		return dataRules;
	}
	public void setDataRules(List<DataRule> dataRules) {
		this.dataRules = dataRules;
	}
	public String getDataRule() {
		return dataRule;
	}
	public void setDataRule(String dataRule) {
		this.dataRule = dataRule;
	}
	public UserPower getUserPower() {
		return userPower;
	}
	public void setUserPower(UserPower userPower) {
		this.userPower = userPower;
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
			if(task.getDes()!=null&&task.getDes()!=""){	
				if(task.getDes().toString().equals("true")){
					item.setChecked("1");
				}
//				if(task.getDes().toString().equals("radio")){
//					item.setChecked("1");
//					item.setRadio("1");
//				}  
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
