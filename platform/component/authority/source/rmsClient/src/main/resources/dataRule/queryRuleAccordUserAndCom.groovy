import com.sinosoft.one.rms.clientService.DataPower;
import com.sinosoft.one.rms.model.BusDataInfo;
import com.sinosoft.one.rms.client.DataRuleScript
import com.alibaba.fastjson.JSON;
import ins.framework.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;
import com.sinosoft.one.rms.client.DataRuleScript;

public class testqueryRuleAccordUserAndCom implements DataRuleScript {
 	
  	public String creatSQL(String sqlOrHql,String tableAlias,DataPower dataPower){
  		String tempSqlOrHQl=""
  		String orderBy=""
  		if(StringUtils.isNotBlank(tableAlias)){
  			tableAlias=tableAlias+"."
  		}else{
  			tableAlias=""
  		}
  		if(StringUtils.isNotBlank(sqlOrHql)){
  			if(sqlOrHql.contains("order by")){
  				if(sqlOrHql.contains(")")&&(sqlOrHql.substring(sqlOrHql.lastIndexOf(")"), sqlOrHql.length()).contains("order by"))){
					tempSqlOrHQl=sqlOrHql.substring(0, sqlOrHql.lastIndexOf(")")+1)+" and ";
					orderBy=sqlOrHql.substring(sqlOrHql.lastIndexOf(")")+1, sqlOrHql.length());
				}else{
					tempSqlOrHQl=sqlOrHql.substring(0,sqlOrHql.lastIndexOf("order by"))+" and ";
					orderBy=sqlOrHql.substring(sqlOrHql.lastIndexOf("order by"), sqlOrHql.length());
				}
  			}else{
  				tempSqlOrHQl=sqlOrHql+" and "
  			}
		}else{
			tempSqlOrHQl=sqlOrHql
		}
		if(StringUtils.isNotBlank(dataPower.getParam())){
			Map<String,String> tempMap = (Map<String, String>)JSON.parse(dataPower.getParam());
			int i=0;
			for (BusDataInfo busDataInfo : dataPower.getBusDataInfos()) {
    			String table=busDataInfo.getBusDataTable()
    			String column=busDataInfo.getBusDataColumn()
    			if(i>0){
    				tempSqlOrHQl=tempSqlOrHQl+" and "+tableAlias+column+"=(select "+column+" from "+table+" where "+column+"='"+tempMap.get(column)+"')"
    			}else{
    				tempSqlOrHQl=tempSqlOrHQl+" "+tableAlias+column+"=(select "+column+" from "+table+" where "+column+"='"+tempMap.get(column)+"')"
    			}
    			i++
			}	
			return tempSqlOrHQl+" "+orderBy
		}else{
			int i=0;
			for (BusDataInfo busDataInfo : dataPower.getBusDataInfos()) {
    			String table=busDataInfo.getBusDataTable()
    			String column=busDataInfo.getBusDataColumn()
    			
    			if(i>0){
    				if("comCode".equals(column))
    					tempSqlOrHQl=tempSqlOrHQl+" and "+tableAlias+column+"=(select "+column+" from "+table+" where "+column+"='"+ dataPower.getComCode()+"')"
    				if("userCode".equals(column))
    					tempSqlOrHQl=tempSqlOrHQl+" and "+tableAlias+column+"=(select "+column+" from "+table+" where "+column+"='"+ dataPower.getUserCode()+"')"
				}else{
					if("comCode".equals(column))
    					tempSqlOrHQl=tempSqlOrHQl+" "+tableAlias+column+"=(select "+column+" from "+table+" where "+column+"='"+ dataPower.getComCode()+"')"
    				if("userCode".equals(column))
    					tempSqlOrHQl=tempSqlOrHQl+" "+tableAlias+column+"=(select "+column+" from "+table+" where "+column+"='"+ dataPower.getUserCode()+"')"
				}
				i++
			}	
			return tempSqlOrHQl+" "+orderBy
		}
		println tempSqlOrHQl
  		return tempSqlOrHQl
  	}
  
  	public String creatSQL(String sqlOrHql,DataPower dataPower){
		return creatSQL( sqlOrHql, null, dataPower)
	}
  
}
