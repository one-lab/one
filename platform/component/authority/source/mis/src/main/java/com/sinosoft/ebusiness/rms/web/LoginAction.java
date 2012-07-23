package com.sinosoft.ebusiness.rms.web;

import ins.framework.common.EncryptUtils;
import ins.framework.web.Struts2Action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.sinosoft.ebusiness.rms.model.Company;
import com.sinosoft.ebusiness.rms.model.Employe;
import com.sinosoft.ebusiness.rms.model.Task;
import com.sinosoft.ebusiness.rms.service.facade.RmsService;
import com.sinosoft.ebusiness.util.encode.JsonBinder;

public class LoginAction extends Struts2Action {
    private static final long serialVersionUID = 1L;
    
    //用户model模块
    private Employe employe;
    
    //机构model模块
    private Company company;
    
    //权限service模块
    private RmsService rmsService;
    
    //用户service模块
    private List<Map<String, Object>> ls;
    
    private String time ;
    
    /**
     * 检查用户是否存在
     * @return
     */
    public String checkUser(){
        String errorMessage ="";
        //获取查询出得数据
        Employe emp;
        emp= rmsService.findUserByCode(employe.getUserCode());
        //检验用户是否存在
        
        if(emp == null){
            errorMessage = "{\"userCode\":\"用户名不存在\"}";
            renderHtml(errorMessage);
            return NONE;
        }
        //输入密码是否正确
        if(!EncryptUtils.md5(employe.getPassword()).endsWith(emp.getPassword())||emp.getPassword()==null){
            errorMessage = "{\"password\":\"用户名或密码不匹配\"}";
            renderHtml(errorMessage);
            return NONE;
        }
        //查询机构List返回json
        List<Company> companys = null;
        try{
            companys = rmsService.findComByUserCode(employe.getUserCode());
        }catch(Exception unee){
            errorMessage = "{\"employe\":\"用户不存在\"}";
            renderHtml(errorMessage);
            return NONE;
        }
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        for(Company company:companys){
            Map<String,String> map =new HashMap<String,String>();
            map.put("comCode",company.getComCode());
            map.put("comName", company.getComCName());
            list.add(map);
        }
        String comCodes = JsonBinder.buildNonNullBinder().toJson(list);
        this.renderText(comCodes);
        return NONE;
    }
    
    /**
     * 用户登录方法
     * @return
     */
    public String subMitUserInfo() {
        if(employe.getUserCode().equals("")){
        	super.addFieldError("error", "用户名不能为空");
        	return INPUT;
        }
        Employe emp;
        emp= rmsService.findUserByCode(employe.getUserCode());
        if(emp == null){
        	super.addFieldError("error", "用户不存在");
        	return INPUT;
        }
        //输入密码是否正确
        if(!EncryptUtils.md5(employe.getPassword()).endsWith(emp.getPassword())){
        	super.addFieldError("error", "用户名或密码错误");
        	return INPUT;
        }
        List<Company> companys = rmsService.findComByUserCode(employe.getUserCode());
        ArrayList<String> validCom=new ArrayList<String>();
        for (Company com  : companys) {
        	validCom.add(com .getComCode());
        }
        if(!validCom.contains(company.getComCode())){
        	super.addFieldError("error", "登陆机构错误");
        	return INPUT;
        }
        for (Company com  : companys) {
        	if(com.getComCode().toString().equals(company.getComCode().toString())){
        		emp.setCompany(com);
        	}
        }
		List<Task> tasks=new ArrayList<Task>();
		tasks = rmsService.findTaskByUserCode(employe.getUserCode(), company.getComCode());
		List<Task> topList = new ArrayList<Task>();
		Map<String, Task> filter = new HashMap<String, Task>();
		for (Task task : tasks) {
			filter.put(task.getTaskID(), task);
			if (task.getParent() == null) {
				topList.add(task);
			}
		}
		ls = new ArrayList<Map<String, Object>>();
		craeteList(topList, ls, filter);
		SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd"); 
		time = dateFm.format(new Date());
		HttpSession session = super.getSession();
		Map<String, Object> employeeMap = new HashMap<String, Object>();
		employeeMap.put("employe", emp);
		employeeMap.put("tasks", tasks);
		employeeMap.put("time",time);
		employeeMap.put("ls", ls);
		session.setAttribute("loginInfo", employeeMap);
		//用户更换登录处理
		String stat=(String)session.getAttribute(session.getId());
		if(stat==null){
			session.setAttribute(session.getId(), "1");
		}else{
			stat=Integer.parseInt(stat)+1+"";
			session.setAttribute(session.getId(), stat);
		}
		return "success";
	}

	private void craeteList(List<Task> list,
			List<Map<String, Object>> dest, Map<String, Task> filter) {
		for (Iterator<Task> iter = list.iterator(); iter.hasNext();) {
			Task task = iter.next();
			if (!filter.containsKey(task.getTaskID()))
				continue;
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("taskID", task.getTaskID());
			map.put("name", task.getName());
			map.put("menuURL", task.getMenuURL());
			map.put("isChecked", task.getDes());
			if (!task.getChildren().isEmpty()) {
				List<Map<String, Object>> ls = new ArrayList<Map<String, Object>>();
				map.put("children", ls);
				craeteList(task.getChildren(), ls, filter);
			}
			dest.add(map);
		}
	}
 
	/**
     * 用户登出 清空SESSION \application里所有跟用户有关信息
     * @return
     */
	public String logout(){
		HttpSession session = super.getSession();
//		Map<String, Object> employeeMap=(Map)session.getAttribute("loginInfo");
//		System.out.println(1);
//		Employe emp = (Employe) employeeMap.get("employe");
//		System.out.println(emp.getUserCode());
//		String str = emp.getUserCode();
//		ActionContext ctx = ActionContext.getContext();
//		Map<String, Object> application = ctx.getApplication();
//		application.remove(str);
		session.removeAttribute("loginInfo");
		session.removeAttribute(session.getId());
		session.setMaxInactiveInterval(0);
		return "success"; 
	}
	
	
	
	
	public String login(){
		return "success"; 
	}
    public Employe getEmploye() {
        return employe;
    }
    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public RmsService getRmsService() {
        return rmsService;
    }

    public void setRmsService(RmsService rmsService) {
        this.rmsService = rmsService;
    }

	public List<Map<String, Object>> getLs() {
		return ls;
	}

	public void setLs(List<Map<String, Object>> ls) {
		this.ls = ls;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}


}
