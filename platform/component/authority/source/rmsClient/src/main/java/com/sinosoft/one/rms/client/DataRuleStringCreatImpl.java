package com.sinosoft.one.rms.client;


import java.io.StringReader;

import ins.framework.utils.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.rms.clientService.DataPower;
import com.sinosoft.one.rms.clientService.User;
import com.sinosoft.one.rms.model.BusDataInfo;
import com.sinosoft.one.sqlparser.parser.JSqlParser;
import com.sinosoft.one.sqlparser.statement.select.PlainSelect;
import com.sinosoft.one.sqlparser.statement.select.Select;

public class DataRuleStringCreatImpl implements DataRuleStringCreat {
//	@Autowired
//	private DataRuleFactoryPostProcessor dataRuleFactoryPostProcessor;
	
	@Autowired
	private JSqlParser jSqlParser;
	
	private static String rule;
	
	private static String tableAlias;
	
	
	public String editSqlQueryRule(String sql){
		User user = EnvContext.getLoginInfo();
		rule = "";
		if (StringUtils.isNotBlank(sql)) {
			rule = sql;
		}
		if (EnvContext.getDataAuthorityTaskId() != null&&user!=null) {
			System.out.println("进入groovy----------------------------------");
			for (DataPower dataPower : user.getDataPowers()) {
				if (dataPower.getTaskId().toString()
						.equals(EnvContext.getDataAuthorityTaskId().toString())) {
					if (StringUtils.isNotBlank(EnvContext.getTableAlias())) {
						tableAlias = EnvContext.getTableAlias();
						for (BusDataInfo busDataInfo : dataPower.getBusDataInfos()) {
//							rule = dataRuleFactoryPostProcessor.getScript(dataPower.getRuleId()).creatSQL(rule,tableAlias, dataPower);
						}
						
					} else {
						for (BusDataInfo busDataInfo : dataPower.getBusDataInfos()) {
//							rule = dataRuleFactoryPostProcessor.getScript(dataPower.getRuleId()).creatSQL(rule, dataPower);
						}
					}
				}
			}
		}
		return rule;
	}
//	
//	public String editHqlQueryRule(String hql){
//		hqlModelClassName=EnvContext.getHqlModelClassName();
//		User user = EnvContext.getLoginInfo();
//		rule="";
//		if(StringUtils.isNotBlank(hql)){
//			rule=hql;
//		}
//		for (DataPower dataPower : user.getDataPowers()) {
//			if (dataPower.getTaskId().toString()
//					.equals(EnvContext.getDataAuthorityTaskId().toString())) {
//				if(StringUtils.isNotBlank(EnvContext.getTableAlias())){
//					tableAlias=EnvContext.getTableAlias();
//					rule=dataRuleFactoryPostProcessor.getScript(dataPower.getRuleId()).creatHQL(rule, hqlModelClassName, tableAlias, dataPower);
//				}else{
//					rule=dataRuleFactoryPostProcessor.getScript(dataPower.getRuleId()).creatHQL(rule, hqlModelClassName,dataPower);
//				}
//			}
//		}
//		return rule;
//	}
	
	
}
