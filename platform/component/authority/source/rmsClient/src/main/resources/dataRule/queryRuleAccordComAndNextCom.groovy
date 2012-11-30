import com.sinosoft.one.rms.DataPower;
import com.sinosoft.one.rms.client.DataRuleScript
import com.alibaba.fastjson.JSON;
import ins.framework.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import com.sinosoft.one.rms.service.facade.CompanyServiceInterface;

public class queryRuleAccordComAndNextCom implements DataRuleScript {

  @Autowired
  private CompanyServiceInterface companyServiceInterface;
  
  private String TABLENAME="ge_rms_company";
 	
  private String CLOUNMNAME="comCode";
  
  private String CLOUNMNAME2="upperComCode";
  
  	public String creatSQL(String rule,String tableNameAlias,String userCode,String comCode,String prama,String clounmName){
		String alias="";
		if(StringUtils.isNotBlank(tableNameAlias)){
			alias=tableNameAlias+".";
		}
		if(StringUtils.isNotBlank(prama)){
			Map<String,String> tempMap = (Map<String, String>)JSON.parse(prama);
			String prams=tempMap.get(clounmName);
			List<String> strings=Arrays.asList(prams.split(","));
			if(strings.size()>1){
				prams="";
				for (String string : strings) {
					prams+="'"+string+"',";
				}
				prams=prams.substring(0, prams.length()-1);
			}else{
				prams="'"+tempMap.get(clounmName)+"'";;
			}
    		if(StringUtils.isNotBlank(rule)){
    			rule=rule+" and "+alias+clounmName+" in (select "+CLOUNMNAME+" from "+TABLENAME+" start with "+CLOUNMNAME+" in ("+prams+") connect by prior "+CLOUNMNAME+"="+CLOUNMNAME2+")"
    		}else{
    			rule=rule+""+alias+clounmName+" in  (select "+CLOUNMNAME+" from "+TABLENAME+" start with "+CLOUNMNAME+" in ("+prams+") connect by prior "+CLOUNMNAME+"="+CLOUNMNAME2+")"
    		}
			return rule 
		}else{
    		if(StringUtils.isNotBlank(rule)){
    			rule=rule+" and "+alias+clounmName+" in (select "+CLOUNMNAME+" from "+TABLENAME+" start with "+CLOUNMNAME+" in ('"+ comCode+"') connect by prior "+CLOUNMNAME+"="+CLOUNMNAME2+")"
			}else{
    			rule=rule+""+alias+clounmName+" in (select "+CLOUNMNAME+" from "+TABLENAME+" start with "+CLOUNMNAME+" in ('"+ comCode+"') connect by prior "+CLOUNMNAME+"="+CLOUNMNAME2+")"
			}
			return rule 
		}
  	}
  
}
