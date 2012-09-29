package com.sinosoft.one.rms.client;

import com.sinosoft.one.rms.clientService.DataPower;

/**
 * 数据权限规则接口，所有数据规则的groovy文件必须实现此接口
 * User: ChengQi
 * Date: 8/13/12
 * Time: 3:57 PM
 */
public interface DataRuleScript {
	
	//以下为改进的接口 
	public String creatSQL(String sqlOrHql,String tableAlias,DataPower dataPower);
	
	public String creatSQL(String sqlOrHql,DataPower dataPower);
	
	public String creatHQL(String sqlOrHql,String ModelName,String tableAlias,DataPower dataPower);
	
	public String creatHQL(String sqlOrHql,String ModelName,DataPower dataPower);
}
