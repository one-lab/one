import com.alibaba.fastjson.JSON;
import ins.framework.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;
import groovy.sql.Sql;


public class queryRuleAccordComAndNextCom  {
 
  public String creatSQL(String sqlOrHql,String param,String loginComCode,String comPanyTableName,String tableAlias){
  		String tempSqlOrHQl=""
  		String orderBy=""
  		String comCode; 
  		comCode=loginComCode
  		tableAlias=tableAlias+"."
  		if(StringUtils.isNotBlank(param)){
  			Map<String,String> tempMap = (Map<String, String>)JSON.parse(param);
  			comCode=tempMap.get("comCode")
  		}
  		def sql=Sql.newInstance("jdbc:oracle:thin:@localhost:1521:orcl","localcic","localcic","oracle.jdbc.driver.OracleDriver")
		if(sql.firstRow("select upperComCode from "+comPanyTableName+" where comCode='"+11+"'")==null){
			return sqlOrHql
		}
		if(StringUtils.isNotBlank(sqlOrHql)&&sqlOrHql.contains("order by")){
			if(sqlOrHql.contains(")")&&(sqlOrHql.substring(sqlOrHql.lastIndexOf(")"), sqlOrHql.length()).contains("order by"))){
				tempSqlOrHQl=sqlOrHql.substring(0, sqlOrHql.lastIndexOf(")")+1)+"and ";;
				orderBy=sqlOrHql.substring(sqlOrHql.lastIndexOf(")")+1, sqlOrHql.length());
			}else{
				tempSqlOrHQl=sqlOrHql.substring(0,sqlOrHql.lastIndexOf("order by"))+"and ";;
				orderBy=sqlOrHql.substring(sqlOrHql.lastIndexOf("order by"), sqlOrHql.length());
			}
		}else{
			tempSqlOrHQl=sqlOrHql+"and "
		}
		sqlOrHql =tempSqlOrHQl+""+tableAlias+"comCode in (select comCode from "+comPanyTableName+" start with comCode = '"+comCode+"' connect by prior comCode = upperComCode)"+orderBy
		return sqlOrHql
  }
  
  
  
  
  public String creatSQL(String sqlOrHql,String param,String loginComCode,String comPanyTableName){
   		String tempSqlOrHQl=""
  		String orderBy=""
  		String comCode; 
  		comCode=loginComCode
  		if(StringUtils.isNotBlank(param)){
  			Map<String,String> tempMap = (Map<String, String>)JSON.parse(param);
  			comCode=tempMap.get("comCode")
  		}
  		def sql=Sql.newInstance("jdbc:oracle:thin:@localhost:1521:orcl","localcic","localcic","oracle.jdbc.driver.OracleDriver")
		if(sql.firstRow("select upperComCode from "+comPanyTableName+" where comCode='"+11+"'")==null){
			return sqlOrHql
		}
		if(StringUtils.isNotBlank(sqlOrHql)&&sqlOrHql.contains("order by")){
			if(sqlOrHql.contains(")")&&(sqlOrHql.substring(sqlOrHql.lastIndexOf(")"), sqlOrHql.length()).contains("order by"))){
				tempSqlOrHQl=sqlOrHql.substring(0, sqlOrHql.lastIndexOf(")")+1)+"and ";
				orderBy=sqlOrHql.substring(sqlOrHql.lastIndexOf(")")+1, sqlOrHql.length());
			}else{
				tempSqlOrHQl=sqlOrHql.substring(0,sqlOrHql.lastIndexOf("order by"))+"and ";
				orderBy=sqlOrHql.substring(sqlOrHql.lastIndexOf("order by"), sqlOrHql.length());
			}
		}else{
			tempSqlOrHQl=sqlOrHql+"and "
		}
		sqlOrHql =tempSqlOrHQl+"comCode in (select comCode from "+comPanyTableName+" start with comCode = '"+comCode+"' connect by prior comCode = upperComCode)"+orderBy
		return sqlOrHql
  }
  
  
  
  public String creatHQL(String sqlOrHql,String param,String loginComCode,String ModelName,String comPanyTableName,String tableAlias){
  		String tempSqlOrHQl=""
  		if(StringUtils.isNotBlank(tableAlias)){
  			tableAlias=tableAlias+"."
  		}else{
  			tableAlias=""
  		}
  		String comPanyModelName=""
  		String orderBy=""
  		String comCode
  		comCode=loginComCode
		if(StringUtils.isNotBlank(ModelName)&&ModelName.contains(".")){
			comPanyModelName=ModelName.split("\\.")[1].toString();
			comPanyModelName=comPanyModelName.substring(0, 1).toLowerCase()+comPanyModelName.substring(1, comPanyModelName.length())+".";
		}else{
			comPanyModelName=ModelName.substring(0, 1).toLowerCase()+ModelName.substring(1, ModelName.length())+".";
		}
		if(StringUtils.isNotBlank(param)){
  			Map<String,String> tempMap = (Map<String, String>)JSON.parse(param);
  			comCode=tempMap.get("comCode")
  		}
		def sql=Sql.newInstance("jdbc:oracle:thin:@localhost:1521:orcl","localcic","localcic","oracle.jdbc.driver.OracleDriver")
		if(sql.firstRow("select upperComCode from "+comPanyTableName+" where comCode='"+11+"'")==null){
			return sqlOrHql
		}
		if(StringUtils.isNotBlank(sqlOrHql)&&sqlOrHql.contains("order by")){
			if(sqlOrHql.contains(")")&&(sqlOrHql.substring(sqlOrHql.lastIndexOf(")"), sqlOrHql.length()).contains("order by"))){
				tempSqlOrHQl=sqlOrHql.substring(0, sqlOrHql.lastIndexOf(")")+1)+"and ";
				orderBy=sqlOrHql.substring(sqlOrHql.lastIndexOf(")")+1, sqlOrHql.length());
			}else{
				tempSqlOrHQl=sqlOrHql.substring(0,sqlOrHql.lastIndexOf("order by"))+"and ";
				orderBy=sqlOrHql.substring(sqlOrHql.lastIndexOf("order by"), sqlOrHql.length());
			}
		}else{
			tempSqlOrHQl=sqlOrHql+"and "
		}
		int offset=0
		StringBuffer comCodesSQL = new StringBuffer();
		comCodesSQL.append(""+tableAlias+"comCode in (");
	  	sql.eachRow("select comCode from "+comPanyTableName+" start with comCode = '"+11+"' connect by prior comCode = upperComCode" ) { row ->
 			offset++
 			comCodesSQL.append(" '" + row.comCode + "',");
			if(offset%999==0&&offset>=999){
				comCodesSQL.delete(comCodesSQL.length() - 1,comCodesSQL.length());
				comCodesSQL.append(")");
				comCodesSQL.append(" or "+tableAlias+"comCode in(");
			}
 		}
 		comCodesSQL.delete(comCodesSQL.length() - 1,comCodesSQL.length());
		comCodesSQL.append(")");
		println comCodesSQL.toString()
		println sqlOrHql =tempSqlOrHQl+comCodesSQL.toString()+orderBy
	  	return sqlOrHql
  }
  
  
  
  public String creatHQL(String sqlOrHql,String param,String loginComCode,String ModelName,String comPanyTableName){
  			
  		return creatHQL(sqlOrHql,param,loginComCode,ModelName,comPanyTableName,tableAlias)
  }
  
  
}
