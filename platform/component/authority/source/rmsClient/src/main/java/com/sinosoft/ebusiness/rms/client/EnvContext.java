package com.sinosoft.ebusiness.rms.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//import com.sinosoft.ebusiness.rms.client.cxf.Employe;
//import com.sinosoft.ebusiness.rms.client.model.LoginInfoDTO;

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
    
//    public static void setLoginInfo(LoginInfoDTO employeInfo) {
//        Map<String,LoginInfoDTO>  loginInfo = threadLocal.get();
//        if(loginInfo == null){
//        	loginInfo = new HashMap<String,LoginInfoDTO>();
//            threadLocal.set(loginInfo);
//        }
//        loginInfo.put(EMPLOYE,employeInfo) ;
//    }
//    
//    public static LoginInfoDTO getLoginInfo() {
//        if(threadLocal.get() == null)
//            return null;
//        return (LoginInfoDTO)threadLocal.get().get(EMPLOYE);
//    }
}
