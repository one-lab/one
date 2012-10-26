import com.sinosoft.one.rms.clientService.DataPower;
import com.sinosoft.one.rms.model.BusDataInfo;
import com.alibaba.fastjson.JSON;
import ins.framework.utils.StringUtils;
import com.sinosoft.one.rms.client.DataRuleScript;
import org.springframework.beans.factory.annotation.Autowired;
import com.sinosoft.one.sqlparser.JSQLParserException;
import com.sinosoft.one.sqlparser.parser.JSqlParser;
import com.sinosoft.one.sqlparser.statement.select.Limit;
import com.sinosoft.one.sqlparser.statement.select.OrderByElement;
import com.sinosoft.one.sqlparser.statement.select.PlainSelect;
import com.sinosoft.one.sqlparser.statement.select.Select;
import java.util.ArrayList;
import java.util.List;

public class queryRuleAccordCompany implements DataRuleScript {
 	
   @Autowired
   private JSqlParser jSqlParser;
 	
   public String creatSQL(String sqlOrHql,String tableAlias,DataPower dataPower){
  		String tempSqlOrHQl=""
  		String comCode 
  		if(StringUtils.isNotBlank(tableAlias)){
  			tableAlias=tableAlias+"."
  		}else{
  			tableAlias=" "
  		}
  		List groupBy=new ArrayList();
  		List orderBy=new ArrayList();
  		Limit limit=new Limit();
  		PlainSelect plainSelect
  		if(StringUtils.isNotBlank(sqlOrHql)){
  			plainSelect = (PlainSelect) ((Select) jSqlParser.parse(new StringReader(sqlOrHql))).getSelectBody();
			if(plainSelect.getGroupByColumnReferences()!=null){
				groupBy=plainSelect.getGroupByColumnReferences();
				plainSelect.setGroupByColumnReferences(null);
			}
			if(plainSelect.getOrderByElements()!=null){
				orderBy=plainSelect.getOrderByElements();
				plainSelect.setOrderByElements(null);
			}
			if(plainSelect.getLimit()!=null){
				limit=plainSelect.getLimit();
				plainSelect.setLimit(null);
				
			}
			tempSqlOrHQl=plainSelect.toString();
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
	//		plainSelect = (PlainSelect) ((Select) jSqlParser.parse(new StringReader(tempSqlOrHQl))).getSelectBody();
	//		plainSelect.setGroupByColumnReferences(groupBy);
	//		plainSelect.setOrderByElements(orderBy);
	//		plainSelect.setLimit(limit);	
			return tempSqlOrHQl 
		}else{
			int i=0;
			for (BusDataInfo busDataInfo : dataPower.getBusDataInfos()) {
    			String table=busDataInfo.getBusDataTable()
    			String column=busDataInfo.getBusDataColumn()
    			if(i>0){
    				if("comCode".equals(column))
    					tempSqlOrHQl=tempSqlOrHQl+" and "+tableAlias+column+"=(select "+column+" from "+table+" where "+column+"='"+ dataPower.getComCode()+"')"
				}else{
					if("comCode".equals(column))
    					tempSqlOrHQl=tempSqlOrHQl+" "+tableAlias+column+"=(select "+column+" from "+table+" where "+column+"='"+ dataPower.getComCode()+"')"
				}
				i++
			}
	//		plainSelect = (PlainSelect) ((Select) jSqlParser.parse(new StringReader(tempSqlOrHQl))).getSelectBody();
		//	plainSelect.setGroupByColumnReferences(groupBy);
	//		plainSelect.setOrderByElements(orderBy);
	//		plainSelect.setLimit(limit);	
			return tempSqlOrHQl 
		}
  	}
  
  	public String creatSQL(String sqlOrHql,DataPower dataPower){
		 return creatSQL(sqlOrHql,null,dataPower)
  	}
  	
}
