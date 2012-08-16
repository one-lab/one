import com.alibaba.fastjson.JSON;
import ins.framework.utils.StringUtils;
import com.sinosoft.one.rms.client.DataRuleScript;

public class queryRuleAccordCompany implements DataRuleScript {
 	
  public String creatSQL(String sqlOrHql,String param,String loginComCode,String comPanyTableName,String comCodeColumnName,String upperColumnName,String tableAlias){
  		String tempSqlOrHQl=""
  		String orderBy=""
  		String comCode 
  		if(StringUtils.isNotBlank(tableAlias)){
  			tableAlias=tableAlias+"."
  		}else{
  			tableAlias=" "
  		}
  		String comColeCloName="comCode"
  		if(StringUtils.isNotBlank(comCodeColumnName)){
  			comColeCloName=comCodeColumnName
  		}
  		if(StringUtils.isNotBlank(sqlOrHql)&&sqlOrHql.contains("order by")){
			if(sqlOrHql.contains(")")&&(sqlOrHql.substring(sqlOrHql.lastIndexOf(")"), sqlOrHql.length()).contains("order by"))){
				tempSqlOrHQl=sqlOrHql.substring(0, sqlOrHql.lastIndexOf(")")+1);
				orderBy=sqlOrHql.substring(sqlOrHql.lastIndexOf(")")+1, sqlOrHql.length());
			}else{
				tempSqlOrHQl=sqlOrHql.substring(0,sqlOrHql.lastIndexOf("order by"));
				orderBy=sqlOrHql.substring(sqlOrHql.lastIndexOf("order by"), sqlOrHql.length());
			}
		}else{
			tempSqlOrHQl=sqlOrHql
		}
		if(StringUtils.isNotBlank(param)){
			Map<String,String> tempMap = (Map<String, String>)JSON.parse(param);
			comCode=tempMap.get("comCode")
			sqlOrHql =tempSqlOrHQl+" and "+tableAlias+""+comCodeColumnName+"='"+comCode+"'"+orderBy
			return sqlOrHql
		}else{
			sqlOrHql =tempSqlOrHQl+" and "+tableAlias+""+comCodeColumnName+"='"+loginComCode+"'"+orderBy
			return sqlOrHql
		}
  }
  
  public String creatSQL(String sqlOrHql,String param,String loginComCode,String comPanyTableName,String comCodeColumnName,String upperColumnName){
		 return creatSQL( sqlOrHql, param, loginComCode, comPanyTableName, comCodeColumnName, upperColumnName, null)
  }
  
  public String creatHQL(String sqlOrHql,String param,String loginComCode,String ModelName,String comPanyTableName,String comCodeColumnName,String tableAlias){
		String tempSqlOrHQl=""
  		String orderBy=""
  		String comCode
  		String comPanyModelName=""
  		if(StringUtils.isNotBlank(tableAlias)){
  			tableAlias=tableAlias+"."
  		}else{
  			tableAlias=" "
  		}
  		if(StringUtils.isNotBlank(ModelName)){
  			if(ModelName.contains(".")){
  				comPanyModelName=ModelName.split("\\.")[1].toString();
				comPanyModelName=comPanyModelName.substring(0, 1).toLowerCase()+comPanyModelName.substring(1, comPanyModelName.length())+".";
  			}else{
				comPanyModelName=ModelName.substring(0, 1).toLowerCase()+ModelName.substring(1, ModelName.length())+".";
			}
		}
		if(StringUtils.isNotBlank(sqlOrHql)&&sqlOrHql.contains("order by")){
			if(sqlOrHql.contains(")")&&(sqlOrHql.substring(sqlOrHql.lastIndexOf(")"), sqlOrHql.length()).contains("order by"))){
				tempSqlOrHQl=sqlOrHql.substring(0, sqlOrHql.lastIndexOf(")")+1);
				orderBy=sqlOrHql.substring(sqlOrHql.lastIndexOf(")")+1, sqlOrHql.length());
			}else{
				tempSqlOrHQl=sqlOrHql.substring(0,sqlOrHql.lastIndexOf("order by"));
				orderBy=sqlOrHql.substring(sqlOrHql.lastIndexOf("order by"), sqlOrHql.length());
			}
		}else{
			tempSqlOrHQl=sqlOrHql
		}
		if(StringUtils.isNotBlank(param)){
			Map<String,String> tempMap = (Map<String, String>)JSON.parse(param);
			comCode=tempMap.get("comCode")
			sqlOrHql =tempSqlOrHQl+" and "+tableAlias+""+comPanyModelName+""+comCodeColumnName+" ='"+comCode+"'"+orderBy
			return sqlOrHql
		}else{
			sqlOrHql =tempSqlOrHQl+" and "+tableAlias+""+comPanyModelName+""+comCodeColumnName+" ='"+loginComCode+"'"+orderBy
			return sqlOrHql
		}
  }
  
  public String creatHQL(String sqlOrHql,String param,String loginComCode,String ModelName,String comPanyTableName,String comCodeColumnName){
  		return creatHQL(sqlOrHql, param, loginComCode, ModelName, comPanyTableName,comCodeColumnName,null)
  }
  
  
  
}
