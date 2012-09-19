package com.sinosoft.one.rms.service.spring;

import java.util.ArrayList;
import java.util.List;

import ins.framework.cache.CacheManager;
import ins.framework.cache.CacheService;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.framework.utils.StringUtils;

import com.sinosoft.one.rms.model.Employe;
import com.sinosoft.one.rms.model.UserPower;
import com.sinosoft.one.rms.model.service.EmployeModelInterface;
import com.sinosoft.one.rms.service.facade.EmployeServiceInterface;

public class EmployeServiceInterfaceImpl extends GenericDaoHibernate<Employe, String> implements EmployeServiceInterface{
	
	/**
	 * 根据员工代码和机构代码查询员工)
	 */
	public Page findEmployees(String userCode, String userName, String comCode,
			int pageNo, int pageSize) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("company.comCode", comCode);
		// 查询已引入权限获取人员代码 过滤查询结果
		QueryRule queryPowerRule = QueryRule.getInstance();
		queryPowerRule.addEqual("comCode", comCode);
		List<UserPower> userPower = super.find(UserPower.class, queryPowerRule);
		List<String> userCodes = new ArrayList<String>();
		if (userPower != null) {
			for (UserPower userPower2 : userPower) {
				userCodes.add(userPower2.getUserCode());
			}
			if (userCodes.size() > 0) {
				StringBuffer sql = new StringBuffer();
				sql.append("userCode not in(");
				for (String string : userCodes) {
					sql.append(" '" + string + "',");
				}
				sql.delete(sql.length() - 1, sql.length());
				sql.append(")");
				queryRule.addSql(sql.toString());
			}
		}
		if (StringUtils.isNotEmpty(userName)
				&& StringUtils.isNotEmpty(userCode)) {
			queryRule.addLike("userCode", "%"+userCode + "%");
			queryRule.addLike("userName","%"+ userName + "%");
		} else {
			if (StringUtils.isNotEmpty(userCode)) {
				queryRule.addLike("userCode", "%"+userCode + "%");
			}
			if (StringUtils.isNotEmpty(userName)) {
				queryRule.addLike("userName", "%"+userName + "%");
			}
		}
		Page page =super.find(queryRule, pageNo, pageSize);
		return page;
	}
	
	/**
	 * 根据员工代码查询
	 * @param userCode
	 * @return
	 */
	public Employe findUserByCode(String userCode) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("userCode", userCode);
		queryRule.addEqual("validStatus", "1");
		return  super.findUnique(Employe.class, queryRule);
		
	}
	/**
	 * 更新密码
	 * @param employe
	 */
	public void updatePassword(String userCode) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("userCode", userCode);
		Employe employe = super.findUnique(Employe.class, queryRule);
		super.update(employe);
	}
	
	/**
	 * 获取机构下属员工（配送模块）
	 * @param comCode
	 * @return
	 */
	public List<Employe> findUserByComCode(
			String comCode) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("company.comCode", comCode);
		queryRule.addEqual("validStatus", "1");
		return super.find(queryRule);
	}
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
	public Page findUserNoInUserCodes(List<String> userCodes, String comCode,
			String userName, String userCode, int pageNo, int pageSize) {
		QueryRule queryRuleUserCode = QueryRule.getInstance();
		StringBuffer sql = new StringBuffer();
		if(userCodes.size()>0){
		sql.append(" userCode not in ( ");
			for (String string : userCodes) {
				sql.append("'" + string + "',");
			}
			sql.delete(sql.length() - 1, sql.length());
			sql.append(")");
			queryRuleUserCode.addSql(sql.toString());
		}
		if(StringUtils.isNotEmpty(userName))
			queryRuleUserCode.addLike("userName", "%"+userName+"%");
		if(StringUtils.isNotEmpty(userCode))
			queryRuleUserCode.addLike("userCode", "%"+userCode+"%");
		queryRuleUserCode.addEqual("company.comCode", comCode);
		return super.find(Employe.class,queryRuleUserCode, pageNo, pageSize);
	}

	/**
	 * 根据传入的用户代码集合查询用户
	 * @param userCodes 必选
	 * @param userName 可选
	 * @param userCode 可选
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page findUserInUserCodes(List<String> userCodes, String userName,
			String userCode, int pageNo, int pageSize) {
	
		QueryRule queryRuleUserCode=QueryRule.getInstance();
		queryRuleUserCode.addIn("userCode", userCodes);
		if(StringUtils.isNotEmpty(userName))
			queryRuleUserCode.addLike("userName", "%"+userName+"%");
		if(StringUtils.isNotEmpty(userCode))
			queryRuleUserCode.addLike("userCode", "%"+userCode+"%");
		return super.find(Employe.class,queryRuleUserCode, pageNo, pageSize);
		
	}


}
