import com.alibaba.fastjson.JSON;
import ins.framework.utils.StringUtils;

public class queryRuleAccordCompany  {
 	
  public String creatSQL(String sqlOrHql,String param,String loginComCode,String comPanyTableName,String tableAlias){
  		String tempSqlOrHQl=""
  		String orderBy=""
  		String comCode 
  		tableAlias=tableAlias+"."
  		if(StringUtils.isNotBlank(sqlOrHql)&&sqlOrHql.contains("order by")){
			if(sqlOrHql.contains(")")&&(sqlOrHql.substring(sqlOrHql.lastIndexOf(")"), sqlOrHql.length()).contains("order by"))){
				tempSqlOrHQl=sqlOrHql.substring(0, sqlOrHql.lastIndexOf(")")+1);
				orderBy=sqlOrHql.substring(sqlOrHql.lastIndexOf(")")+1, sqlOrHql.length());
			}else{
				tempSqlOrHQl=sqlOrHql.substring(0,sqlOrHql.lastIndexOf("order by"));
				orderBy=sqlOrHql.substring(sqlOrHql.lastIndexOf("order by"), sqlOrHql.length());
			}
		}
		if(StringUtils.isNotBlank(param)){
			Map<String,String> tempMap = (Map<String, String>)JSON.parse(param);
			comCode=tempMap.get("comCode")
			sqlOrHql =tempSqlOrHQl+" and "+tableAlias+"comCode='"+comCode+"'"+orderBy
			return sqlOrHql
		}else{
			sqlOrHql =tempSqlOrHQl+" and "+tableAlias+"comCode='"+loginComCode+"'"+orderBy
			return sqlOrHql
		}
  }
  
  public String creatSQL(String sqlOrHql,String param,String loginComCode,String comPanyTableName){
		String tempSqlOrHQl=""
  		String orderBy=""
  		String comCode 
  		tableAlias=tableAlias+"."
  		if(StringUtils.isNotBlank(sqlOrHql)&&sqlOrHql.contains("order by")){
			if(sqlOrHql.contains(")")&&(sqlOrHql.substring(sqlOrHql.lastIndexOf(")"), sqlOrHql.length()).contains("order by"))){
				tempSqlOrHQl=sqlOrHql.substring(0, sqlOrHql.lastIndexOf(")")+1);
				orderBy=sqlOrHql.substring(sqlOrHql.lastIndexOf(")")+1, sqlOrHql.length());
			}else{
				tempSqlOrHQl=sqlOrHql.substring(0,sqlOrHql.lastIndexOf("order by"));
				orderBy=sqlOrHql.substring(sqlOrHql.lastIndexOf("order by"), sqlOrHql.length());
			}
		}
		if(StringUtils.isNotBlank(param)){
			Map<String,String> tempMap = (Map<String, String>)JSON.parse(param);
			comCode=tempMap.get("comCode")
			sqlOrHql =tempSqlOrHQl+" and "+tableAlias+"comCode='"+comCode+"'"+orderBy
			return sqlOrHql
		}else{
			sqlOrHql =tempSqlOrHQl+" and "+tableAlias+"comCode='"+loginComCode+"'"+orderBy
			return sqlOrHql
		}
  }
  
  public String creatHQL(String sqlOrHql,String param,String loginComCode,String ModelName,String ModelNerComParamName,String tableAlias){
		String tempSqlOrHQl=""
  		String orderBy=""
  		String comCode
		if(StringUtils.isNotBlank(sqlOrHql)&&sqlOrHql.contains("order by")){
			if(sqlOrHql.contains(")")&&(sqlOrHql.substring(sqlOrHql.lastIndexOf(")"), sqlOrHql.length()).contains("order by"))){
				tempSqlOrHQl=sqlOrHql.substring(0, sqlOrHql.lastIndexOf(")")+1);
				orderBy=sqlOrHql.substring(sqlOrHql.lastIndexOf(")")+1, sqlOrHql.length());
			}else{
				tempSqlOrHQl=sqlOrHql.substring(0,sqlOrHql.lastIndexOf("order by"));
				orderBy=sqlOrHql.substring(sqlOrHql.lastIndexOf("order by"), sqlOrHql.length());
			}
		}
		if(StringUtils.isNotBlank(ModelNerComParamName)){
			ModelNerComParamName=ModelNerComParamName+"." 
		}else(
			ModelNerComParamName=" "
		)
  		if(StringUtils.isNotBlank(tableAlias)){
  			tableAlias=tableAlias+"."
  		}else{
  			tableAlias=" "
  		}
		if(StringUtils.isNotBlank(param)){
			Map<String,String> tempMap = (Map<String, String>)JSON.parse(param);
			comCode=tempMap.get("comCode")
			sqlOrHql =tempSqlOrHQl+" and "+tableAlias+""+ModelNerComParamName+"comCode ='"+comCode+"'"+orderBy
			return sqlOrHql
		}else{
			sqlOrHql =tempSqlOrHQl+" and "+tableAlias+""+ModelNerComParamName+"comCode ='"+loginComCode+"'"+orderBy
			return sqlOrHql
		}
  }
  
  public String creatHQL(String sqlOrHql,String param,String loginComCode,String ModelName,String ModelNerComParamName){
  		return creatHQL(sqlOrHql, param, loginComCode, ModelName, ModelNerComParamName,null)
  }
  
  
  
}
