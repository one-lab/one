package com.sinosoft.one.rms.client;

import ins.framework.utils.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.rms.clientService.DataPower;
import com.sinosoft.one.rms.clientService.User;

public class DataRuleStringCreatImpl implements DataRuleStringCreat {
	@Autowired
	private DataRuleFactoryPostProcessor dataRuleFactoryPostProcessor;
	
	private static String rule;
	
	private static String tableAlias;
	
	private static String hqlModelClassName;
	
	
	public String editSqlQueryRule(String sql){
		User user = EnvContext.getLoginInfo();
		rule="";
		if(StringUtils.isNotBlank(sql)){
			rule=sql;
		}
		for (DataPower dataPower : user.getDataPowers()) {
			if (dataPower.getTaskId().toString()
					.equals(EnvContext.getDataAuthorityTaskId().toString())) {
				if(StringUtils.isNotBlank(EnvContext.getTableAlias())){
					tableAlias=EnvContext.getTableAlias();
					rule=dataRuleFactoryPostProcessor.getScript(dataPower.getRuleId()).creatSQL(rule, tableAlias,dataPower);
				}else{
					rule=dataRuleFactoryPostProcessor.getScript(dataPower.getRuleId()).creatSQL(rule, dataPower);
				}
			}
		}
		
		return rule;
	}
	
	public String editHqlQueryRule(String hql){
		hqlModelClassName=EnvContext.getHqlModelClassName();
		User user = EnvContext.getLoginInfo();
		rule="";
		if(StringUtils.isNotBlank(hql)){
			rule=hql;
		}
		for (DataPower dataPower : user.getDataPowers()) {
			if (dataPower.getTaskId().toString()
					.equals(EnvContext.getDataAuthorityTaskId().toString())) {
				if(StringUtils.isNotBlank(EnvContext.getTableAlias())){
					tableAlias=EnvContext.getTableAlias();
					rule=dataRuleFactoryPostProcessor.getScript(dataPower.getRuleId()).creatHQL(rule, hqlModelClassName, tableAlias, dataPower);
				}else{
					rule=dataRuleFactoryPostProcessor.getScript(dataPower.getRuleId()).creatHQL(rule, hqlModelClassName,dataPower);
				}
			}
		}
		return rule;
	}
	
	
}
