package com.sinosoft.one.rms.client.arch4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.framework.utils.StringUtils;

import com.sinosoft.one.rms.client.DataRuleStringCreat;
import com.sinosoft.one.rms.client.EnvContext;


/**
 * rms GenericDaoHibernate
 * basic is arch4 GenericDaoHibernate; fill rms control task in it
 * User: ChengQi
 * Date: 3/22/12
 * Time: 11:07 AM
 */
public class RmsGenericDaoHibernate <T extends java.io.Serializable, PK extends java.io.Serializable> extends GenericDaoHibernate<T, PK>{
	
	@Autowired
	private DataRuleStringCreat dataRuleStringCreat;
	
	public java.util.List<T> find(QueryRule queryRule){
        if(EnvContext.getDataAuthorityTaskId()!=null){
        	String rule =dataRuleStringCreat.editSqlQueryRule("");
        	if(StringUtils.isNotBlank(rule))
        		queryRule.addSql(rule);
        }
        return super.find(queryRule);
    }

	public Page find(QueryRule queryRule, int pageNo, int pageSize){
        if(EnvContext.getDataAuthorityTaskId()!=null){
        	String rule =dataRuleStringCreat.editSqlQueryRule("");
        	if(StringUtils.isNotBlank(rule))
        		queryRule.addSql(rule);
        }
        return super.find(queryRule,pageNo,pageSize);
    }

	@SuppressWarnings("hiding")
	public <T> Page find(Class<T> arg0, QueryRule queryRule, int arg2, int arg3 ) {
		 if(EnvContext.getDataAuthorityTaskId()!=null){
			 String rule =dataRuleStringCreat.editSqlQueryRule("");
	        if(StringUtils.isNotBlank(rule))
	        	queryRule.addSql(rule);
		 }
		return super.find(arg0, queryRule, arg2, arg3);
	}

	@SuppressWarnings({ "rawtypes", "hiding" })
	public <T> List find(Class<T> entityClass, QueryRule queryRule) {
		if(EnvContext.getDataAuthorityTaskId()!=null){
			String rule =dataRuleStringCreat.editSqlQueryRule("");
        	if(StringUtils.isNotBlank(rule))
        		queryRule.addSql(rule);
		}
		return super.find(entityClass, queryRule);
	}
	
	@SuppressWarnings("rawtypes")
	public List findBySql(String sql, Object... values) {
//		sql=sql+" and "+EditqueryRule();
		if(EnvContext.getDataAuthorityTaskId()!=null){
			sql=dataRuleStringCreat.editSqlQueryRule(sql);
		}
		return super.findBySql(sql, values);
	}

	public Page findByHql(String arg0, int arg1, int arg2,Object... arg3) {
		if(EnvContext.getDataAuthorityTaskId()!=null){
			arg0=dataRuleStringCreat.editHqlQueryRule(arg0);
			System.out.println(arg0);
		}
		return super.findByHql(arg0, arg1, arg2, arg3);
	}

	@SuppressWarnings("rawtypes")
	public List findByHql(String arg0, Object... arg1) {
		if(EnvContext.getDataAuthorityTaskId()!=null){
			arg0=dataRuleStringCreat.editHqlQueryRule(arg0);
		}
		return super.findByHql(arg0, arg1);
	}

	public Page findByHqlNoLimit(String arg0, int arg1, int arg2,
			Object... arg3) {
		if(EnvContext.getDataAuthorityTaskId()!=null){
			arg0=dataRuleStringCreat.editHqlQueryRule(arg0);
		}
		return super.findByHqlNoLimit(arg0, arg1, arg2, arg3);
	}


	@SuppressWarnings("rawtypes")
	public List findTopByHql(String arg0, int arg1, Object... arg2) {
		if(EnvContext.getDataAuthorityTaskId()!=null){
			arg0=dataRuleStringCreat.editHqlQueryRule(arg0);
		}
		return super.findTopByHql(arg0, arg1, arg2);
	}


    
}
