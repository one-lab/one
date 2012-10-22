import com.sinosoft.one.rms.clientService.DataPower;
import com.sinosoft.one.rms.client.DataRuleScript
import com.alibaba.fastjson.JSON;
import ins.framework.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;
import groovy.sql.Sql;
import org.springframework.beans.factory.annotation.Autowired;
import com.sinosoft.one.rms.service.facade.CompanyServiceInterface;

public class queryRuleAccordComAndNextCom implements DataRuleScript {

  @Autowired
  private CompanyServiceInterface companyServiceInterface;
  
  public String creatSQL(String sqlOrHql,String param,String loginComCode,String comPanyTableName,String comCodeColumnName,String upperColumnName,String tableAlias,DataPower dataPower){
  		String tempSqlOrHQl=""
  		String orderBy=""
  		String comCode; 
  		String upperComCodeCloName="upperComCode"
  		String comColeCloName="comCode"
  		comCode=loginComCode
  		if(StringUtils.isNotBlank(tableAlias)){
  			tableAlias=tableAlias+"."
  		}else{
  			tableAlias=" "
  		}
  		if(StringUtils.isNotBlank(param)){
  			Map<String,String> tempMap = (Map<String, String>)JSON.parse(param);
  			comCode=tempMap.get("comCode")
  		}
  		if(StringUtils.isNotBlank(upperColumnName)){
  			upperComCodeCloName=upperColumnName
  		}
  		if(StringUtils.isNotBlank(comCodeColumnName)){
  			comColeCloName=comCodeColumnName
  		}
		if(!companyServiceInterface.isExtSubCom(comCode)){
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
		sqlOrHql =tempSqlOrHQl+""+tableAlias+""+comColeCloName+" in (select "+comColeCloName+" from "+comPanyTableName+" start with "+comColeCloName+" = '"+comCode+"' connect by prior "+comColeCloName+" = "+upperComCodeCloName+")"+orderBy
		return sqlOrHql
  }
  
  
  
  public String creatSQL(String sqlOrHql,String param,String loginComCode,String comPanyTableName,String comCodeColumnName,String supperColumnName,DataPower dataPower){
   		String tempSqlOrHQl=""
  		String orderBy=""
  		String comCode; 
		String supperComCodeCloName="upperComCode"
  		String comColeCloName="comCode"
  		comCode=loginComCode
  		if(StringUtils.isNotBlank(supperColumnName)){
  			supperComCodeCloName=supperColumnName
  		}
  		if(StringUtils.isNotBlank(comCodeColumnName)){
  			comColeCloName=comCodeColumnName
  		}
  		if(StringUtils.isNotBlank(param)){
  			Map<String,String> tempMap = (Map<String, String>)JSON.parse(param);
  			comCode=tempMap.get("comCode")
  		}
  		if(!companyServiceInterface.isExtSubCom(comCode)){
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
		sqlOrHql =tempSqlOrHQl+""+comColeCloName+" in (select "+comColeCloName+" from "+comPanyTableName+" start with "+comColeCloName+" = '"+comCode+"' connect by prior "+comColeCloName+" = "+supperComCodeCloName+")"+orderBy
		return sqlOrHql
  }
  
}
