package com.sinosoft.one.rms.service.facade;

import ins.framework.common.Page;

import java.util.List;
import java.util.Set;
 

import com.sinosoft.one.rms.model.Task;
import com.sinosoft.one.rms.model.UserPower;


public interface RmsService {
	
   
	 /**
     * 根据员工代码机构代码用户组代码配置权限 userPower 同时配置除外功能
     * @param userCode
     * @param comCode
     * @param groupIDList
     * @param taskIDs
     */
	public void addUserPower(String userCode,String comCode ,List<String>  groupIDs,List<String>roleIDS,List<String> ExcTaskIDs,String sysFlag);
	
	/**
	 * 根据员工代码 机构代码删除用户权限
	 * @param userCode
	 * @param comCode
	 */
	public void deleteUserPower(String userCode, String comCode);
	
	/**
	 * 根据机构代码查询该机构下的所有员工（配置页面 已引入）
	 * @param comCode
	 * @return
	 */
	public Page findEmployees(String comCode,String userCode,String userName,int pageSize,int pageNo);
	
	/**
	*  根据员工代码机构代码查询用于引入员工(人员引入页面 未引入)
    * @param comCode userCode,pageNo,pageSize
    */
	public Page findNEmployees(String userCode,String comCode,String loginUserComcode,int pageNo,int pageSize);
	
	/**
	 * 获取员工除外权限（功能配置中未打钩选项）
	 * @param userCode
	 * @param comCode
	 * @return
	 */
	public Set<Task> findExcPower(String userCode,String comCode);
	
	
	
	/**
	 * 获取功能集合(多系统类型)
	 * @param userCode
	 * @param comCode
	 *  @param sysFlag
	 * @return
	 */
	public List<Task> findTaskMultSysByUserCode(String userCode,String comCode,String sysFlag);
	
	/**
	 * 获取可配置数据权限功能集合(多系统类型)
	 * @param userCode
	 * @param comCode
	 *  @param sysFlag
	 * @return
	 */
	public List<Task> findDataRuleTaskMultSysByComUser(String userCode,String comCode,String sysFlag);
	
	/**
	 * 根据userCode,comCode查询USERPOWER
	 * @param userCode
	 * @param comCode
	 * @return
	 */
	public UserPower findUserPowerByComUser(String userCode,String comCode);
	
	
	/**
	 * 查询用户的所有权限对象
	 * @param userCode
	 * @return
	 */
	public List<UserPower>findUserPowersByUserCode(String userCode);
	/**
	 * 递归获得父功能节点
	 * @param tasks
	 * @return
	 */
	public void iterateTask(Set<Task> tsks,Set<Task> tasks);
	
	/**
	 * 功能排列
	 */
	public List<Task> taskArrange(Set<Task> ts);

	
	 public  List<Task> findTaskByUserCode(String paramString1, String paramString2);
}
