package com.sinosoft.one.rms.client;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
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


	private static ThreadLocal<Map<String,Object  >>  threadLocal  = new ThreadLocal<Map<String, Object>>();

    private static final String DATA = "DATA";
    
    private static final String CLASSNAME="MATHOD";
      
    public static void setDataAuthorityTaskId(String value) {
		Map<String,Object >  context = threadLocal.get();
        if(context == null){
        	 context = new HashMap<String,Object >();
        	 threadLocal.set(context);
        }
        if( context.get(DATA)==null){
        	context.put(DATA, new LinkedList ());
        }
        LinkedList linkedList= (LinkedList) context.get(DATA);
        linkedList.add(value);
    }

    public static String getDataAuthorityTaskId() {
        if(threadLocal.get() == null)
            return null;
        LinkedList linkedList= (LinkedList) threadLocal.get().get(DATA);
        return (String)linkedList.peek();
    }
    
    public static void removeDataAuthorityTaskId (){
		LinkedList linkedList= (LinkedList) threadLocal.get().get(DATA);
		linkedList.remove();
	}
    
    
    
    
	public static void setClassName(String calssName) {
		Map<String,Object >  context = threadLocal.get();
        if(context == null){
        	 context = new HashMap<String,Object >();
        	 threadLocal.set(context);
        }
        if( context.get(CLASSNAME)==null){
        	context.put(CLASSNAME, new LinkedList ());
        }
        LinkedList linkedList= (LinkedList) context.get(CLASSNAME);
        linkedList.add(calssName);
	}
	
	public static String getClassName(){
    	if(threadLocal.get() == null)
    		 return null;
    	LinkedList linkedList= (LinkedList) threadLocal.get().get(CLASSNAME);
        return (String)linkedList.peek();
    }
	
	public static void removeClassName(){
		LinkedList linkedList= (LinkedList) threadLocal.get().get(CLASSNAME);
		linkedList.remove();
	}
	
}
