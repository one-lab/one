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
	
	private static String companyTableName;
	
	private static String comCodeColumnName;
	
	private static String hqlModelClassName;
	
	public String editSqlQueryRule(String sql){
		User user = EnvContext.getLoginInfo();
		companyTableName=EnvContext.getComPanyTableName();
		comCodeColumnName=EnvContext.getComCodeColumnName();
		String str="";
		if(StringUtils.isNotBlank(sql)){
			str=sql;
		}
		for (DataPower dataPower : user.getDataPowers()) {
			if (dataPower.getTaskId().toString()
					.equals(EnvContext.getDataAuthorityTaskId().toString())) {
				if(StringUtils.isNotBlank(EnvContext.getTableAlias())){
					tableAlias=EnvContext.getTableAlias();
					rule=dataRuleFactoryPostProcessor.getScript(dataPower.getRuleId()).creatSQL(str, dataPower.getParam(), user.getLoginComCode(), companyTableName, comCodeColumnName, tableAlias);
				}else{
					rule=dataRuleFactoryPostProcessor.getScript(dataPower.getRuleId()).creatSQL(str, dataPower.getParam(), user.getLoginComCode(), companyTableName,comCodeColumnName);
						
				}
				
			}
		}
		return rule;
	}
	
	public String editHqlQueryRule(String hql){
		User user = EnvContext.getLoginInfo();
		companyTableName=EnvContext.getComPanyTableName();
		hqlModelClassName=EnvContext.getHqlModelClassName();
		for (DataPower dataPower : user.getDataPowers()) {
			if (dataPower.getTaskId().toString()
					.equals(EnvContext.getDataAuthorityTaskId().toString())) {
				if(StringUtils.isNotBlank(EnvContext.getTableAlias())){
					tableAlias=EnvContext.getTableAlias();
					rule=dataRuleFactoryPostProcessor.getScript(dataPower.getRuleId()).creatHQL(hql,  dataPower.getParam(), user.getLoginComCode(), hqlModelClassName, companyTableName, hql);
				}else{
					
					rule=dataRuleFactoryPostProcessor.getScript(dataPower.getRuleId()).creatHQL(hql,  dataPower.getParam(), user.getLoginComCode(), hqlModelClassName, companyTableName);
						
				}
				
			}
		}
		
		return rule;
	}
}
