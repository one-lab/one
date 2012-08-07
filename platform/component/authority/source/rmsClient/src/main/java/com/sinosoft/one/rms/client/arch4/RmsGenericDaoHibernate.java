package com.sinosoft.one.rms.client.arch4;

import java.util.List;

import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;

import com.sinosoft.one.rms.client.EnvContext;


/**
 * rms GenericDaoHibernate
 * basic is arch4 GenericDaoHibernate; fill rms control task in it
 * User: ChengQi
 * Date: 3/22/12
 * Time: 11:07 AM
 */
public class RmsGenericDaoHibernate <T extends java.io.Serializable, PK extends java.io.Serializable> extends GenericDaoHibernate<T, PK> {
	String  EditqueryRule(){
		String rule="";
		String newRule="";
//		LoginInfoDO loginInfoDO=EnvContext.getLoginInfo();
//		if (loginInfoDO != null) {
//			String taskID=EnvContext.getDataAuthorityTaskId();
//			List<BusPower> busPowers = loginInfoDO.getBusPowers();
//			for (BusPower busPower : busPowers) {
//				if (busPower.getTask().getTaskID().toString().equals(taskID)) {
//				if (StringUtils.isNotBlank(busPower.getDataRule().getRule())) {
//						rule=busPower.getDataRule().getRule();
//                      获得SQL中'号出现的位置
//				    	Matcher slashMatcher = Pattern.compile("'").matcher(rule);
//				    	String[]con=rule.split("'");
//				    	int mIdx = 0;
//				    	for (int i = 0; i < con.length-1; i++) {
//				    		 mIdx=i;
//				    		while(slashMatcher.find()) {
//			    			//SQL中'号在偶数位置开始替换''号的内容
//				    			if (mIdx%2==0) {
////									rule.substring(slashMatcher.start()+1, slashMatcher.start()+rule.substring(slashMatcher.start()+1).indexOf("'")+1);
////									String val=rule.substring(slashMatcher.start(), slashMatcher.start()+rule.substring(slashMatcher.start()+1).indexOf("'")+2);
////									if( Pattern.compile(val).matcher(rule).find()){
////										if(StringUtils.isNotBlank(busPower.getDataRuleParam()))
////											newRule=rule.replace(val, "'"+busPower.getDataRuleParam()+"'");
////										else{
////											newRule=rule.replace(val, "'"+loginInfoDO.getLoginComCode()+"'");
////										}
////									}
////								}
////				    			break;
//				    		}
//						}
//					}
//				}
//			}
//		}
		return newRule;
	}
	
	public java.util.List<T> find(QueryRule queryRule){
        if(EnvContext.getDataAuthorityTaskId()!=null){
        	queryRule.addSql(EditqueryRule());
        }
        return super.find(queryRule);
    }

	public Page find(QueryRule queryRule, int pageNo, int pageSize){
        if(EnvContext.getDataAuthorityTaskId()!=null){
        	queryRule.addSql(EditqueryRule());
        }
        return super.find(queryRule,pageNo,pageSize);
    }

	public <T> Page find(Class<T> arg0, QueryRule queryRule, int arg2, int arg3) {
		 if(EnvContext.getDataAuthorityTaskId()!=null){
			 queryRule.addSql(EditqueryRule());
		 }
		return super.find(arg0, queryRule, arg2, arg3);
	}

	public <T> List find(Class<T> entityClass, QueryRule queryRule) {
		if(EnvContext.getDataAuthorityTaskId()!=null){
			queryRule.addSql(EditqueryRule());
     
	 }
		return super.find(entityClass, queryRule);
	}

	public Page findByHql(String arg0, int arg1, int arg2, Object... arg3) {
		if(EnvContext.getDataAuthorityTaskId()!=null){
			arg0=arg0+" and "+EditqueryRule();
		}
		return super.findByHql(arg0, arg1, arg2, arg3);
	}

	public List findByHql(String arg0, Object... arg1) {
		if(EnvContext.getDataAuthorityTaskId()!=null){
			arg0=arg0+" and "+EditqueryRule();
		}
		return super.findByHql(arg0, arg1);
	}

	public Page findByHqlNoLimit(String arg0, int arg1, int arg2,
			Object... arg3) {
		if(EnvContext.getDataAuthorityTaskId()!=null){
			arg0=arg0+" and "+EditqueryRule();
		}
		return super.findByHqlNoLimit(arg0, arg1, arg2, arg3);
	}

	public List findBySql(String sql, Object... values) {
		sql=sql+" and "+EditqueryRule();
		return super.findBySql(sql, values);
	}

	public List findTopByHql(String arg0, int arg1, Object... arg2) {
		arg0=arg0+" and "+EditqueryRule();
		return super.findTopByHql(arg0, arg1, arg2);
	}
    
}
