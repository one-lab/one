package com.sinosoft.one.rms.service.facade;


import java.util.List;
import java.util.Set;

import com.sinosoft.one.rms.model.Task;

public interface TaskService {

	/**
	 * 功能授权（上级机构将功能授予下级机构）
	 * @param UserCode
	 * @param ComCode
	 * @param TaskIDS
	 */
	public void taskAuth(String userCode,String comCode,List<String> taskIDs);
	
	/**
	 * 根据机构查询功能授权，获得功能集合
	 * @param comCode
	 * @return
	 */
	public Set<Task> findTaskAuthByComCode(String comCode);
	
	
	/**
	 * 根据机构，系统标志查询功能授权，获得功能集合
	 * @param comCode
	 * @return
	 */
	public Set<Task> findTaskAuthByComCodeAndsysFlag(String comCode,String sysFlag);
	/**
	 * 根据角色ID查询角色下的功能（人员功能配置页面）
	 * @param RoleIDs
	 * @return
	 */
	public Set<Task> findTaskByRole(List<String> RoleIDs,String comCode);
	
	/**
	 * 根据角色ID,系统标记查询角色下的功能（人员功能配置页面）
	 * @param RoleIDs
	 * @param sysFlage
	 * @return
	 */
	public Set<Task> findTaskByRoleAndsysFlag(List<String> RoleIDs,String comCode,String sysFlag);
	/**
	 * 添加功能菜单 有系统标志类型
	 * @param taskId
	 * @param Name
	 * @param manuUrl
	 * @param manuName
	 * @param SysFlag
	 * @param des
	 * @param parentId
	 */
	public void addTaskHasSysFlag(String taskId,String name ,String menuURL,String menuName ,String des,String isAsMenu,String parentId,String loginUserCode,String loginComCode,String SysFlag);
	
	/**
	 * 添加功能菜单 无系统标志类型
	 * @param taskId
	 * @param Name
	 * @param manuUrl
	 * @param manuName
	 * @param SysFlag
	 * @param des
	 * @param parentId
	 */
	public void addTask(String taskId,String name ,String menuURL,String menuName ,String des,String isAsMenu,String parentId,String loginUserCode,String loginComCode);
	
	/**
	 * 修改功能菜单 有系统标志类型
	 * @param taskId
	 * @param Name
	 * @param manuUrl
	 * @param manuName
	 * @param SysFlag
	 * @param des
	 * @param parentId
	 */
	public void updateTaskHasSysFlag(String taskId,String name ,String menuURL,String isValidate,String menuName ,String des,String isAsMenu,String SysFlag,String loginComCode);
	
	/**
	 * 修改功能菜单 无系统标志类型
	 * @param taskId
	 * @param Name
	 * @param manuUrl
	 * @param manuName
	 * @param SysFlag
	 * @param des
	 * @param parentId
	 */
	public void updateTask(String taskId,String name ,String menuURL,String isValidate,String menuName ,String des,String isAsMenu);
	
	/**
	 * 查看功能信息
	 * @param TaskId
	 * @return
	 */
	public Task findTaskById(String TaskId);
	
	/**
	 * 查询所有功能
	 * @return
	 */
	public List<Task> findAllTask();
	
	/**
	 * 删除功能
	 */
	public void deleteTaskByID(String TaskId);
	
	
}
