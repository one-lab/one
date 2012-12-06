package com.sinosoft.one.rms.service.picc;

import ins.framework.cache.CacheManager;
import ins.framework.cache.CacheService;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;


import com.sinosoft.one.rms.model.Group;
import com.sinosoft.one.rms.model.UserGroup;
import com.sinosoft.one.rms.model.UserPower;
import com.sinosoft.one.rms.service.spring.GroupServiceSpringImpl;

public class PatchGroupServiceSpringImpl extends GroupServiceSpringImpl implements GroupService{

	/**
	 * 初始缓存实例
	 */
	@SuppressWarnings("unused")
	private static CacheService cacheManager = CacheManager.getInstance("Group");
	/**
	 * 查询用户组下的成员
	 */
	@SuppressWarnings("unchecked")
	public Page findEmployeByGroupType( String Type,String loginComCode,String userName,String comCode,String comCName,String isValidate,int pageSize,int pageNo) {
		List<UserGroup>userGroups=new ArrayList<UserGroup>();
		QueryRule queryRule = QueryRule.getInstance();
		//获得用户组
		if(Type.toString().equals("0")){
			queryRule.addEqual("name", "系统管理组");
		}else if (Type.toString().equals("1")) {
			queryRule.addEqual("name", "省公司管理组");
		}else if (Type.toString().equals("2")) {
			queryRule.addEqual("name", "市公司管理组");
		}else if (Type.toString().equals("3")) {
			queryRule.addEqual("name", "县公司管理组");
		}else if (Type.toString().equals("4")) {
			queryRule.addEqual("name", "团购组");
		}else if (Type.toString().equals("5")) {
			queryRule.addEqual("name", "客服经理组");
		}
		queryRule.addEqual("isValidate","1");
		Group group=new Group();
		group=super.findUnique(queryRule);
		Page page=new Page();
		if(group!=null){
			//获取用户组下的userCode;
			userGroups=group.getUserGroups();
			List<String> userCodes=	new ArrayList<String>();
			for (UserGroup userGroup : userGroups) {
				userCodes.add(userGroup.getUserCode());
			}
			//根据userCode 过滤权限有效状态的用户
			QueryRule queryRuleUserPower = QueryRule.getInstance();
			queryRuleUserPower.addIn("userCode", queryRuleUserPower);
			//查询账户有效状态
			queryRuleUserPower.addEqual("isValidate", isValidate);
			List<UserPower> userPowers =new ArrayList<UserPower>();
			userPowers=	super.find(UserPower.class, queryRuleUserPower);
			List<String> onGroupUserCode=new ArrayList<String>();
			for (UserPower userPower : userPowers) {	
				for (String userCode : userCodes) {
					if(userCode.toString().equals(userPower.getUserCode().toString())){
						onGroupUserCode.add(userCode);
					}
				}
			}
			//查询员工对象集合
			if(onGroupUserCode.size()>0){
				StringBuffer hql = new StringBuffer();
				hql.append("from Employe e where e.userCode in ( ");
				for (String string : onGroupUserCode) {
					hql.append("'" + string + "',");
				}
				hql.delete(hql.length() - 1, hql.length());
				hql.append(")");
				hql.append(" and e.company.upperComCode = '"+ loginComCode+"'");
				if(StringUtils.isNotBlank(comCode)){
					hql.append(" and e.company.comCode like '%"+ comCode+"'%");
				}
				if(StringUtils.isNotBlank(comCName)){
					hql.append(" and e.company.comCName like '%"+ comCName+"'%");
				}
				if(StringUtils.isNotBlank(userName)){
					hql.append(" and e.userName like '%"+ userName+"'%");
				}
				page = super.findByHql(hql.toString(), pageNo, pageSize);
			}
		}
		return page;
	}
}	
 