package com.sinosoft.ams.service;

import java.util.List;


import com.sinosoft.ams.task_auth.model.GeRmsCompany;
import com.sinosoft.ams.user_group.model.User;


public interface AccountManager {
	
	public List getAllgeRmsCompanyRepository() ;
	public List getCompanies();
	
	public List getCompanies(String comCode);
	
	public GeRmsCompany company(String id);

	public User selectByUsername(String userName);
	
	public List findByParentId();
	
	public List findByParentIdIsasMenu(String parentId);
	
	public List findByTaskId(String comCode);
	
	public List findByParentIdTaskId(String parentId,String comCode);
	public void InsertTask(String taskAuthID,String taskID,String comCode, String operateUser);
	
	public List findByComCode(String comCode);


}
