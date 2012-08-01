package com.sinosoft.ebusiness.rms.service.facade;

import ins.framework.common.Page;

import java.util.List;
import java.util.Set;

import javax.jws.WebMethod;

import com.sinosoft.ebusiness.rms.model.Company;
import com.sinosoft.ebusiness.rms.model.Employe;
import com.sinosoft.ebusiness.rms.model.Task;
import com.sinosoft.ebusiness.rms.model.UserPower;


public interface RmsService {
	
   
	 /**
     * 根据员工代码机构代码用户组代码配置权限 userPower 同时配置除外功能
     * @param userCode
     * @param comCode
     * @param groupIDList
     * @param taskIDs
     */
	@WebMethod(operationName="addPower")
	public void addUserPower(String userCode,String comCode ,List<String>  groupIDs,List<String> ExcTaskIDs);
	
	/**
	 * 根据员工代码 机构代码删除用户权限
	 * @param userCode
	 * @param comCode
	 */
	public void deleteUserPower(String userCode, String comCode);
	
	/**
     * 根据人员代码获取引入机构
     * @param userCode
     * @return List<Company>
     */
	public List<Company> findComByUserCode(String userCode) ;
	
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
	 * 查询直属下级机构
	 * @param comCode
	 * @return
	 */
	public List<Company>findNextSubCom(String comCode);
	
	/**
	 * 获取功能集合
	 * @param userCode
	 * @param comCode
	 * @return
	 */
	public List<Task> findTaskByUserCode(String userCode,String comCode);

	/**
	 * 获取功能集合(多系统类型)
	 * @param userCode
	 * @param comCode
	 *  @param sysFlag
	 * @return
	 */
	public List<Task> findTaskMultSysByUserCode(String userCode,String comCode,String sysFlag);
	/**
	 * 查询单个员工
	 * @param userCode
	 * @return
	 */
	public Employe findUserByCode(String userCode);
	
	/**
	 * 判断是否有下属机构
	 * @param comCode
	 * @return
	 */
	public boolean  isExtSubCom(String comCode);
	
	/**
	 * 根据userCode,comCode查询USERPOWER
	 * @param userCode
	 * @param comCode
	 * @return
	 */
	public UserPower findUserPowerByComUser(String userCode,String comCode);
	
	
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
	/**
	 * 修改密码
	 * @param employe
	 */
	public void updatePassword(Employe employe);
	
	
	/**
	 * 查询没有权限的 机构下的员工
	 * @param comCode
	 * @return
	 */
	public List<Employe> findUserByComCode(String comCode);
	/**
	 * 查询四级机构
	 * @param comCode
	 * @return
	 */
	public List<Company>findLevFourCom(String comCode);
	
	/**
	 * 根据机构代码获取机构
	 * @param comCode
	 * @return
	 */
	public Company findCompanyByComCode(String comCode);
	
}
