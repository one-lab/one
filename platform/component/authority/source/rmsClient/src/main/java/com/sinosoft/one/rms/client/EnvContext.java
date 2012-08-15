package com.sinosoft.one.rms.client;

import java.util.HashMap;
import java.util.Map;

import com.sinosoft.one.rms.clientService.User;


/**
 * Created by IntelliJ IDEA.
 * User: ChengQi
 * Date: 3/22/12
 * Time: 11:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class EnvContext {


	private static ThreadLocal<Map>  threadLocal  = new ThreadLocal<Map>();

    private static final String DATA = "DATA";
    
    private static final String EMPLOYE="EMPLOYE";
    
    private static final String TABLENAME="TABLENAME";
    
    private static final String HQLMODELCLASSNAME="HQLMODELCLASSNAME";
    
    private static final String TABLEALIAS="TABLEALIAS";
    
    private static final String COMLUMNNAME="COMLUMNNAME";

    public static void setDataAuthorityTaskId(String value) {
		Map<String,Object>  context = threadLocal.get();
        if(context == null){
            context = new HashMap<String,Object>();
            threadLocal.set(context);
        }
        context.put(DATA,value) ;
    }

    public static String getDataAuthorityTaskId() {
        if(threadLocal.get() == null)
            return null;
        return (String)threadLocal.get().get(DATA);
    }
    
    public static void setLoginInfo(User loginUser) {
        Map<String,User>  loginInfo = threadLocal.get();
        if(loginInfo == null){
        	loginInfo = new HashMap<String,User>();
            threadLocal.set(loginInfo);
        }
        loginInfo.put(EMPLOYE,loginUser) ;
    }
    
    public static User getLoginInfo() {
        if(threadLocal.get() == null)
            return null;
        return (User)threadLocal.get().get(EMPLOYE);
    }
    
    public static void setComPanyTableName(String tableName){
    	 Map<String,String>  table = threadLocal.get();
         if(table == null){
        	 table = new HashMap<String,String>();
             threadLocal.set(table);
         }
         table.put(TABLENAME,tableName) ;
    }
    
    public static String getComPanyTableName(){
    	if(threadLocal.get() == null)
    		 return null;
    	return (String) threadLocal.get().get(TABLENAME);
    }
    
    public static void setHqlModelClassName(String hqlModelClassName){
   	 Map<String,String>  modelname = threadLocal.get();
        if(modelname == null){
        	modelname = new HashMap<String,String>();
            threadLocal.set(modelname);
        }
        modelname.put(HQLMODELCLASSNAME,hqlModelClassName) ;
    }
    
    public static String getHqlModelClassName(){
    	if(threadLocal.get() == null)
    		 return null;
    	return (String) threadLocal.get().get(HQLMODELCLASSNAME);
    }

	public static void setTableAlias(String tableAlias) {
		Map<String, String> alias = threadLocal.get();
		if (alias == null) {
			alias = new HashMap<String, String>();
			threadLocal.set(alias);
		}
		alias.put(TABLEALIAS, tableAlias);
	}
	
	public static String getTableAlias(){
    	if(threadLocal.get() == null)
    		 return null;
    	return (String) threadLocal.get().get(TABLEALIAS);
    }
	
	public static void setComCodeColumnName(String comCodeClomnName) {
		Map<String, String> ClomnName = threadLocal.get();
		if (ClomnName == null) {
			ClomnName = new HashMap<String, String>();
			threadLocal.set(ClomnName);
		}
		ClomnName.put(COMLUMNNAME, comCodeClomnName);
	}
	
	public static String getComCodeColumnName(){
    	if(threadLocal.get() == null)
    		 return null;
    	return (String) threadLocal.get().get(COMLUMNNAME);
    }
}
