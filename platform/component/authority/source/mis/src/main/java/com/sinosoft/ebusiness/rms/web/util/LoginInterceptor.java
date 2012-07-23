package com.sinosoft.ebusiness.rms.web.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sinosoft.ebusiness.rms.model.Task;

public class LoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("----------------------------");
		//系统服务器启动后获得的系统权限值
		Map<String, Object> application = ServletActionContext.getContext().getApplication();
		Map<String, Object> globalAuthorityMap = (Map<String, Object>)application.get("authorityMap");
		String action=invocation.getProxy().getActionName();
		System.out.println(action);
		String taskid=(String)globalAuthorityMap.get(action);
		System.out.println(taskid);
		System.out.println("----------------------------");
		HttpSession httpSession=ServletActionContext.getRequest().getSession();
		Map<String, Object> employeeMap = (HashMap<String, Object>)httpSession.getAttribute("loginInfo");
		if(employeeMap!=null){
			//用户更换登录处理
			String stat=(String)httpSession.getAttribute(httpSession.getId());
			if(stat!=null&&!stat.toString().equals("1")){
				httpSession.setAttribute(httpSession.getId(), "1");
				return Action.INPUT;
			} 
			//权限与action请求处理
			if (globalAuthorityMap.get(action) != null) {
				List<Task> tasks=(List<Task>)employeeMap.get("tasks");
				List<String> taskIds=new ArrayList<String>();
				for (Task task : tasks) {
					taskIds.add(task.getTaskID());
				}
				if (taskIds.containsAll(Arrays.asList(taskid.split(" ")))||taskIds.contains(taskid)) {
					return invocation.invoke();
				}
			}else {
				return invocation.invoke();
			}
		}
		return Action.LOGIN;
	}
		
}
