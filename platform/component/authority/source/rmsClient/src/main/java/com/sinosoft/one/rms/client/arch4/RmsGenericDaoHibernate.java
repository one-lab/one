package com.sinosoft.one.rms.client.arch4;

import java.util.List;

import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.framework.utils.StringUtils;

import com.sinosoft.one.rms.client.DynamicLoadBeanByGroovyPath;
import com.sinosoft.one.rms.client.EnvContext;
import com.sinosoft.one.rms.clientService.DataPower;
import com.sinosoft.one.rms.clientService.User;


/**
 * rms GenericDaoHibernate
 * basic is arch4 GenericDaoHibernate; fill rms control task in it
 * User: ChengQi
 * Date: 3/22/12
 * Time: 11:07 AM
 */
public class RmsGenericDaoHibernate <T extends java.io.Serializable, PK extends java.io.Serializable> extends GenericDaoHibernate<T, PK>{
	
	
	String editqueryRule() {
		return editqueryRule(null);
	}
	String editqueryRule(String sqlOrHql) {
		//缺少判断SQL是否有表的别名
		String rule = "";
		User user = EnvContext.getLoginInfo();
		for (DataPower dataPower : user.getDataPowers()) {
			if (dataPower.getTaskId().toString()
					.equals(EnvContext.getDataAuthorityTaskId().toString())) {
//				rule = dataPower.getRuleId();// rule即为Beanid
				DynamicLoadBeanByGroovyPath groovyPath=new DynamicLoadBeanByGroovyPath();
																	//测试类型1  简单query方式查询 拼接SQL  无别名
				rule=groovyPath.creatGroovyClass(dataPower.getRule()).creatHQL(sqlOrHql, dataPower.getParam(), user.getLoginComCode(), "Employe.company","ge_rms_company","e");
				System.out.println(rule);
			}
		}
		return rule;
	}
	
	
	
	public java.util.List<T> find(QueryRule queryRule){
        if(EnvContext.getDataAuthorityTaskId()!=null){
        	if(StringUtils.isNotBlank(editqueryRule()))
        		queryRule.addSql(editqueryRule());
        }
        return super.find(queryRule);
    }

	public Page find(QueryRule queryRule, int pageNo, int pageSize){
        if(EnvContext.getDataAuthorityTaskId()!=null){
        	if(StringUtils.isNotBlank(editqueryRule()))
        		queryRule.addSql(editqueryRule());
        }
        return super.find(queryRule,pageNo,pageSize);
    }

	public <T> Page find(Class<T> arg0, QueryRule queryRule, int arg2, int arg3 ) {
		 if(EnvContext.getDataAuthorityTaskId()!=null){
			 if(StringUtils.isNotBlank(editqueryRule()))
	        		queryRule.addSql(editqueryRule());
		 }
		return super.find(arg0, queryRule, arg2, arg3);
	}

	public <T> List find(Class<T> entityClass, QueryRule queryRule) {
		if(EnvContext.getDataAuthorityTaskId()!=null){
			if(StringUtils.isNotBlank(editqueryRule()))
        		queryRule.addSql(editqueryRule());
		}
		return super.find(entityClass, queryRule);
	}

	public Page findByHql(String arg0, int arg1, int arg2,Object... arg3) {
		if(EnvContext.getDataAuthorityTaskId()!=null){
			arg0=editqueryRule(arg0);
		}
		return super.findByHql(arg0, arg1, arg2, arg3);
	}

	@SuppressWarnings("rawtypes")
	public List findByHql(String arg0, Object... arg1) {
		if(EnvContext.getDataAuthorityTaskId()!=null){
			arg0=editqueryRule(arg0);
		}
		return super.findByHql(arg0, arg1);
	}

	public Page findByHqlNoLimit(String arg0, int arg1, int arg2,
			Object... arg3) {
		if(EnvContext.getDataAuthorityTaskId()!=null){
			arg0=editqueryRule(arg0);
		}
		return super.findByHqlNoLimit(arg0, arg1, arg2, arg3);
	}

	@SuppressWarnings("rawtypes")
	public List findBySql(String sql, Object... values) {
//		sql=sql+" and "+EditqueryRule();
		if(EnvContext.getDataAuthorityTaskId()!=null){
			sql=editqueryRule(sql);
		}
		return super.findBySql(sql, values);
	}

	@SuppressWarnings("rawtypes")
	public List findTopByHql(String arg0, int arg1, Object... arg2) {
		if(EnvContext.getDataAuthorityTaskId()!=null){
			arg0=editqueryRule(arg0);
		}
		return super.findTopByHql(arg0, arg1, arg2);
	}


    
}
