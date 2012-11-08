package com.sinosoft.one.rms.client;



import ins.framework.utils.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.rms.client.util.ShiroLoginUser;
import com.sinosoft.one.rms.clientService.DataPower;
import com.sinosoft.one.rms.clientService.User;
import com.sinosoft.one.rms.model.BusDataInfo;

public class DataRuleStringCreatImpl implements DataRuleStringCreat {
	@Autowired
	private DataRuleFactoryPostProcessor dataRuleFactoryPostProcessor;
	
	private static String rule;
	
	public String editSqlQueryRule(String sql){
		User user= ShiroLoginUser.getLoginUser();
		rule = "";
		String tableName = null;
		if (StringUtils.isNotBlank(sql)) {
			rule = sql;
			tableName = parserTableName(sql);
		}
		if (EnvContext.getDataAuthorityTaskId() != null && user != null) {
			for (DataPower dataPower : user.getDataPowers()) {
				if (dataPower.getTaskId().toString().equals(EnvContext.getDataAuthorityTaskId().toString())) {
					for (BusDataInfo busDataInfo : dataPower.getBusDataInfos()) {
						if (tableName != null&& tableName.toString().equals(busDataInfo.getBusDataTable().toString()))
							rule = dataRuleFactoryPostProcessor.getScript(
									dataPower.getRuleId()).creatSQL(rule,
									dataPower);
					}

				}
			}
		}
		return rule;
	}
	
	String parserTableName(String sql){
		String tableName=null;
		return tableName;
	}
}
