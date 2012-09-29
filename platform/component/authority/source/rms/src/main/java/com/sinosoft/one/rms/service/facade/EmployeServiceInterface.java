package com.sinosoft.one.rms.service.facade;

import java.util.List;


import com.sinosoft.one.rms.model.Employe;
import com.sinosoft.one.rms.model.service.CompanyModelInterface;
import com.sinosoft.one.rms.model.service.EmployeModelInterface;

import ins.framework.common.Page;
/**
 * 如果有自定的人员model 需实现该接口
 * @author Administrator
 *
 */
public interface EmployeServiceInterface {
	
	/**
	 * 根据员工代码和机构代码查询员工(未引入员工，引入页面)
	 */
	public Page findEmployees(String userCode, String userName, String comCode,int pageNo, int pageSize);
	
	/**
	 * 根据员工代码查询
	 * 
	 * @param userCode
	 * @return
	 */
	public <T extends EmployeModelInterface>T findUserByCode(String userCode);
	
	/**
	 * 更新密码
	 * 
	 * @param employe
	 */
	public boolean updatePassword(String userCode,String userPassword)throws Exception;
	
	/**
	 * 获取机构下属员工（配送模块）
	 * @param comCode
	 * @return
	 */
	public List<? extends EmployeModelInterface> findUserByComCode(String comCode);
	
	
	/**
	 * 查询不属于 传入的用户代码集合的用户，
	 * @param userCodes 必须
	 * @param userName 可选
	 * @param userCode 可选
	 * @param comCode 必传条件
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page findUserNoInUserCodes(List<String> userCodes,String comCode ,String userName,String userCode,int pageNo, int pageSize);
	
	
	/**
	 * 查询属于传入的用户代码集合查询用户
	 * @param userCodes 必选
	 * @param userName 可选
	 * @param userCode 可选
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page findUserInUserCodes(List<String> userCodes,String userName,String userCode,int pageNo, int pageSize);
}
