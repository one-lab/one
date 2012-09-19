import com.alibaba.fastjson.JSON;
import ins.framework.utils.StringUtils;
import com.sinosoft.one.rms.client.DataRuleScript;

public class queryRuleAccordCompany implements DataRuleScript {
 	
  public String creatSQL(String sqlOrHql,String param,String loginComCode,String comPanyTableName,String comCodeColumnName,String upperColumnName,String tableAlias){
  	
  }
  
  public String creatSQL(String sqlOrHql,String param,String loginComCode,String comPanyTableName,String comCodeColumnName,String upperColumnName){
		return creatSQL(sqlOrHql, param, loginComCode, comPanyTableName, comCodeColumnName, upperColumnName, null)
  }
  
  public String creatHQL(String sqlOrHql,String param,String loginComCode,String ModelName,String comPanyTableName,String comCodeColumnName,String tableAlias){
		
  }
  
  public String creatHQL(String sqlOrHql,String param,String loginComCode,String ModelName,String comPanyTableName,String comCodeColumnName){
  		return creatHQL(sqlOrHql, param, loginComCode, ModelName, comPanyTableName,comCodeColumnName,null)
  }

  
}
