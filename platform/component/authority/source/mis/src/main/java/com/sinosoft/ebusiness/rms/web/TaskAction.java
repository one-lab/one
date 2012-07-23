package com.sinosoft.ebusiness.rms.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ins.framework.common.Page;
import ins.framework.web.Struts2Action;

import com.sinosoft.ebusiness.rms.model.Company;
import com.sinosoft.ebusiness.rms.model.Employe;
import com.sinosoft.ebusiness.rms.model.Task;
import com.sinosoft.ebusiness.rms.service.facade.TaskService;
import com.sinosoft.ebusiness.rms.web.util.Item;
import com.sinosoft.ebusiness.rms.web.util.Tree;
import com.sinosoft.ebusiness.util.encode.JaxbBinder;

public class TaskAction  extends Struts2Action  {
	private static final long serialVersionUID = 1L;
	private static JaxbBinder jaxbBinder = new JaxbBinder(Tree.class);
	//功能操作接口
	private TaskService rmstaskService;
	//功能MODEL
	private Task task;
	//分页显示工具对象
	private Page page;
	//父功能ID
	private String parentId;

	/**
	 * 功能树
	 * @return
	 */
	public String taskTree() {
		List<Task> tasks = new ArrayList<Task>();
		tasks=rmstaskService.findAllTask();
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
	 * 跳转更新页面
	 * @return
	 */
	public String prepareUpdata(){
		task=rmstaskService.findTaskById(task.getTaskID());
		return SUCCESS;
	}
	
	/**
	 * 更新操作
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String updataTask(){
		Map<String, Object> employeeMap =(Map<String, Object>)getSession().getAttribute("loginInfo");
		Employe loginEmploye=new Employe();
		loginEmploye.setUserCode("321");
		Company company=new Company();
		company.setComCName("2123");
		company.setComCode("222");
		loginEmploye.setCompany(company);
		rmstaskService.updateTask(task.getTaskID(), task.getName(), task.getMenuURL(),task.getIsValidate(), task.getMenuName(), task.getDes(), loginEmploye);
		return SUCCESS;
	}
	/**
	 * 跳转创建页面
	 * @return
	 */
	public String prepareAddTask() {
		return SUCCESS;
	}
	
	/**
	 * 保存
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String saveTask(){
	//	Map<String, Object> employeeMap =(Map<String, Object>)getSession().getAttribute("loginInfo");
		Employe loginEmploye=new Employe();
		loginEmploye.setUserCode("321");
		Company company=new Company();
		company.setComCName("2123");
		company.setComCode("222");
		loginEmploye.setCompany(company);
		rmstaskService.addTask(task.getTaskID(), task.getName(), task.getMenuURL(), task.getMenuName(), task.getDes(), parentId, loginEmploye);
		return SUCCESS;
	}
	/**
	 * 加载页面
	 * @return
	 */
	public String loadtask(){
		return SUCCESS;
	}

	public TaskService getRmstaskService() {
		return rmstaskService;
	}

	public void setRmstaskService(TaskService rmstaskService) {
		this.rmstaskService = rmstaskService;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
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
