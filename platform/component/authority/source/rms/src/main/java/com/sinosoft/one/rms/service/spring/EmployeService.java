package com.sinosoft.one.rms.service.spring;

import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.framework.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;


import com.sinosoft.one.rms.model.Employe;
import com.sinosoft.one.rms.model.UserPower;

public class EmployeService extends GenericDaoHibernate<Employe, String> {

	/**
	 * 根据员工代码和机构代码查询员工(未引入员工，引入页面)
	 */
	@SuppressWarnings("unchecked")
	Page findEmployees(String userCode, String userName, String comCode,int pageNo, int pageSize) {
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
		return super.find(queryRule, pageNo, pageSize);
	}

	/**
	 * 根据员工代码查询
	 * 
	 * @param userCode
	 * @return
	 */
	Employe findUserByCode(String userCode) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("userCode", userCode);
		queryRule.addEqual("validStatus", "1");
		Employe employe = super.findUnique(Employe.class, queryRule);
		return employe;
	}

	/**
	 * 更新密码
	 * 
	 * @param employe
	 */
	void updatePassword(Employe employe) {
		super.update(employe);
	}

	/**
	 * 获取机构下属员工（配送模块）
	 * 
	 * @param comCode
	 * @return
	 */
	List<Employe> findUserByComCode(String comCode) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("company.comCode", comCode);
		queryRule.addEqual("validStatus", "1");
		return super.find(queryRule);
	}
	
	
	//添加数据
//	public void saveEmploye(BufferedReader br) {
//		int i = 1;
//		try {
//			Session session = super.getSession();
//			String line;
//			while ((line = br.readLine()) != null) {
//				List<String> list = Arrays.asList(line.split(","));
////				System.out.print(convert(list.get(0)));
////				System.out.print(convert(list.get(1)));
////				System.out.print(convert(list.get(3)));
////				System.out.print(convert(list.get(3)));
//				
//				Employe employe = new Employe();
//				employe.setUserCode(convert(list.get(0)));
//				employe.setUserName(convert(list.get(1)));
//				Company company = new Company();
//				company.setComCode(convert(list.get(2)));
//				employe.setCompany(company);
//				employe.setValidStatus(convert(list.get(3)));
//				employe.setPassword("670b14728ad9902aecba32e22fa4f6bd");
//				session.save(employe);
//				if (i % 200 == 0) {
//					session.flush();
//					session.clear();
//					//session.getTransaction().commit();
//				}
//				i++;
//			}	
//		} catch (Exception e) {
//			System.err.println(">>>>>>>>>>>>>>>>>>>>"+i);
//		}
//	}
//	public String convert(String str) {
//		String str1 = str.replace('"', ' ');
//		return str1.trim();
//	}
}
