package com.sinosoft.ebusiness.rms.web;

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
import com.sinosoft.ebusiness.rms.model.Task;
import com.sinosoft.ebusiness.rms.service.facade.RmsService;
import com.sinosoft.ebusiness.rms.service.facade.TaskService;
import com.sinosoft.ebusiness.rms.web.util.Item;
import com.sinosoft.ebusiness.rms.web.util.Tree;
import com.sinosoft.ebusiness.util.encode.JaxbBinder;

import ins.framework.web.Struts2Action;

public class TaskAuthAction extends Struts2Action {

	private static final long serialVersionUID = 1L;

	private static JaxbBinder jaxbBinder = new JaxbBinder(Tree.class);

	private String id;
	 
	private String upperComCode;
	
	private String authComCode;
	
	private String taskAuthComCode;
	
	private String taskIds;
	
	private RmsService rmsService;

	private TaskService rmstaskService;
	/**
	 * 机构树
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String treeComCode() {
		List<Company> companys = null;
		Map<String, Object> employeeMap =(Map<String, Object>)getSession().getAttribute("loginInfo");
		Employe loginEmploye=(Employe)employeeMap.get("employe");
		if (StringUtils.isBlank(id)) {
			//首次加载页面 由登陆人获得机构父机构
			companys = rmsService.findNextSubCom(loginEmploye.getCompany().getComCode());
		} else {
			//点击机构后 根据点击机构为父机构 加“-”号处理全零的机构代码图
			String str[]=id.split("-");
			companys = rmsService.findNextSubCom( str[1]);
		}
		Tree tree = new Tree();
		ArrayList<Item> items = new ArrayList<Item>();
		for (Company company : companys) {
			Item subtree = new Item();
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
	 * 功能树
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String taskTree(){
		Map<String, Object> employeeMap =(Map<String, Object>)getSession().getAttribute("loginInfo");
		Employe loginEmploye=(Employe)employeeMap.get("employe");
		Set<Task> canAuthTasks=new HashSet<Task>();
		//获得可以授权的功能集
		if(upperComCode.toString().equals("0"))
			canAuthTasks=rmstaskService.findTaskAuthByComCode(loginEmploye.getCompany().getComCode());
		else
			canAuthTasks=rmstaskService.findTaskAuthByComCode(upperComCode);
		Set<Task> authTasks=new HashSet<Task>();
		//获得已授权的功能集
		authTasks=rmstaskService.findTaskAuthByComCode(taskAuthComCode);
		//选择的机构权限标记到 权限集合中
		for (Iterator<Task> iterator = canAuthTasks.iterator(); iterator.hasNext();) {
            Task canAuthtask = iterator.next();
        	canAuthtask.setDes("false");
            for (Iterator<Task> iterator2 = authTasks.iterator(); iterator2.hasNext();) {
                Task authTask = (Task) iterator2.next();
                if(canAuthtask.getTaskID().equals(authTask.getTaskID())){
                	canAuthtask.setDes("true");
                    break;
                }
            }
        }
		Map<String,Task> filter=new HashMap<String,Task>();
		List<Task> topList = new ArrayList<Task>();
		for(Task task : canAuthTasks) {
			filter.put(task.getTaskID(), task);
			if(task.getParent()==null) {
				topList.add(task);
			}
		}
		String  xml=getTreeXML(topList, filter);
		this.renderXML(xml);
		return NONE;
	}
	/**
	 * 授权操作
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String taskAuth(){
		Map<String, Object> employeeMap =(Map<String, Object>)getSession().getAttribute("loginInfo");
		Employe loginEmploye=(Employe)employeeMap.get("employe");
		rmstaskService.taskAuth(loginEmploye.getCompany().getComCode(), authComCode, Arrays.asList(taskIds.split(",")));
		return "success";
	}
	//加载页面
	public String loadtaskAuth(){
		return "success";
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
	
	public String getTaskAuthComCode() {
		return taskAuthComCode;
	}
	public void setTaskAuthComCode(String taskAuthComCode) {
		this.taskAuthComCode = taskAuthComCode;
	}
	public String getUpperComCode() {
		return upperComCode;
	}
	public void setUpperComCode(String upperComCode) {
		this.upperComCode = upperComCode;
	}
	public String getAuthComCode() {
		return authComCode;
	}
	public void setAuthComCode(String authComCode) {
		this.authComCode = authComCode;
	}
	public String getTaskIds() {
		return taskIds;
	}
	public void setTaskIds(String taskIds) {
		this.taskIds = taskIds;
	}
	public void setRmsService(RmsService rmsService) {
		this.rmsService = rmsService;
	}
	public TaskService getRmstaskService() {
		return rmstaskService;
	}
	public void setRmstaskService(TaskService rmstaskService) {
		this.rmstaskService = rmstaskService;
	}
	/**
	 * 创建功能树XML
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
			if(task.getDes()!=null&&task.getDes().toString()!=""){	
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
