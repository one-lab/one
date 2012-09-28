/**
 * @ create_date 2012-8-25
 * @ author long
 * @ version 1.0
 */
package ins.common.util;

import ins.common.model.ExceptionInfo;
import ins.framework.web.Struts2Action;

import java.util.Map;
import java.util.zip.DataFormatException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 *
 * @title ExceptionInterceptor
 * @description 异常处理拦截器
 * @author 于文龙
 * @version 1.0
 * @create date 2012-8-25
 * @copyright (c) SINOSOFT
 * 
 *
 */
public class ExceptionInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -5399932509977756040L;
	/** 日志	 */
	private static final Logger logger = LoggerFactory.getLogger("business");	
	
	/**
	 * @title intercept
	 * @description 拦截器方法
	 * @param paramActionInvocation
	 * @throws Exception
	 * @author 于文龙
	 */
	@Override
	public String intercept(ActionInvocation invocation)
			throws Exception {
		String result = ""; 
		//国际化
		//Struts2Action action=(Struts2Action)invocation.getAction();
		//action.writeJSONMsg("ok");
		//action.getText("");
		Map<String, Object> exception=invocation.getInvocationContext().getSession();
		String actionName = invocation.getInvocationContext().getName(); 
		try{ 
		 //执行action
		result= invocation.invoke(); 
		 
		}catch(Exception ex){
			if(ex instanceof ClassNotFoundException){
				logger.error("异常拦截器拦截到异常：类未找到异常！"+"<br>"+"action为:"+actionName+"<br>"+"异常 的 详 细信息："+"<br>"+ex.toString());
				ExceptionInfo e=new ExceptionInfo();
				e.setActionName(actionName);
				e.setMessage(ex.toString());
				e.setName("类未找到异常");
				exception.put("exception",e);
				
			}else if(ex instanceof DataFormatException){
				logger.error("异常拦截器拦截到异常：数据格式异常！"+"<br>"+"action为:"+actionName+"<br>"+"异常 的 详 细信息："+"<br>"+ex.toString());
				ExceptionInfo e=new ExceptionInfo();
				e.setActionName(actionName);
				e.setMessage(ex.toString());
				e.setName("数据格式异常");
				exception.put("exception",e);
				
			}else if(ex instanceof IllegalAccessException){
				logger.error("异常拦截器拦截到异常：非法存取异常！"+"<br>"+"action为:"+actionName+"<br>"+"异常 的 详 细信息："+"<br>"+ex.toString());
				ExceptionInfo e=new ExceptionInfo();
				e.setActionName(actionName);
				e.setMessage(ex.toString());
				e.setName("非法存取异常");
				exception.put("exception",e);
				
			}else if(ex instanceof InterruptedException){
				logger.error("异常拦截器拦截到异常：中断异常！"+"<br>"+"action为:"+actionName+"<br>"+"异常 的 详 细信息："+"<br>"+ex.toString());
				ExceptionInfo e=new ExceptionInfo();
				e.setActionName(actionName);
				e.setMessage(ex.toString());
				e.setName("中断异常");
				exception.put("exception",e);
				
			}else if(ex instanceof NoSuchMethodException){
				logger.error("异常拦截器拦截到异常：调用不存在方法异常！"+"<br>"+"action为:"+actionName+"<br>"+"异常 的 详 细信息："+"<br>"+ex.toString());
				ExceptionInfo e=new ExceptionInfo();
				e.setActionName(actionName);
				e.setMessage(ex.toString());
				e.setName("调用不存在方法异常");
				exception.put("exception",e);
				
			}else if(ex instanceof ArithmeticException){
				logger.error("异常拦截器拦截到异常：算术异常！"+"<br>"+"action为:"+actionName+"<br>"+"异常 的 详 细信息："+"<br>"+ex.toString());
				ExceptionInfo e=new ExceptionInfo();
				e.setActionName(actionName);
				e.setMessage(ex.toString());
				e.setName("算术异常");
				exception.put("exception",e);
				
			}else if(ex instanceof ArrayIndexOutOfBoundsException){
				logger.error("异常拦截器拦截到异常：数组越界异常！"+"<br>"+"action为:"+actionName+"<br>"+"异常 的 详 细信息："+"<br>"+ex.toString());
				ExceptionInfo e=new ExceptionInfo();
				e.setActionName(actionName);
				e.setMessage(ex.toString());
				e.setName("数组越界异常");
				exception.put("exception",e);
				
			}else if(ex instanceof ArrayStoreException){
				logger.error("异常拦截器拦截到异常：数组存储异常！"+"<br>"+"action为:"+actionName+"<br>"+"异常 的 详 细信息："+"<br>"+ex.toString());
				ExceptionInfo e=new ExceptionInfo();
				e.setActionName(actionName);
				e.setMessage(ex.toString());
				e.setName("数组存储异常");
				exception.put("exception",e);
				
			}else if(ex instanceof ClassCastException){
				logger.error("异常拦截器拦截到异常：类强制转换异常！"+"<br>"+"action为:"+actionName+"<br>"+"异常 的 详 细信息："+"<br>"+ex.toString());
				ExceptionInfo e=new ExceptionInfo();
				e.setActionName(actionName);
				e.setMessage(ex.toString());
				e.setName("类强制转换异常");
				exception.put("exception",e);
				
			}else if(ex instanceof IllegalAccessException){
				logger.error("异常拦截器拦截到异常：非法参数异常！"+"<br>"+"action为:"+actionName+"<br>"+"异常 的 详 细信息："+"<br>"+ex.toString());
				ExceptionInfo e=new ExceptionInfo();
				e.setActionName(actionName);
				e.setMessage(ex.toString());
				e.setName("非法参数异常");
				exception.put("exception",e);
				
			}else if(ex instanceof IllegalThreadStateException){
				logger.error("异常拦截器拦截到异常：非法线程状态异常！"+"<br>"+"action为:"+actionName+"<br>"+"异常 的 详 细信息："+"<br>"+ex.toString());
				ExceptionInfo e=new ExceptionInfo();
				e.setActionName(actionName);
				e.setMessage(ex.toString());
				e.setName("非法线程状态异常");
				exception.put("exception",e);
				
			}else if(ex instanceof IndexOutOfBoundsException){
				logger.error("异常拦截器拦截到异常：索引越界异常！"+"<br>"+"action为:"+actionName+"<br>"+"异常 的 详 细信息："+"<br>"+ex.toString());
				ExceptionInfo e=new ExceptionInfo();
				e.setActionName(actionName);
				e.setMessage(ex.toString());
				e.setName("索引越界异常");
				exception.put("exception",e);
				
			}else if(ex instanceof NumberFormatException ){
				logger.error("异常拦截器拦截到异常：数值格式异常！"+"<br>"+"action为:"+actionName+"<br>"+"异常 的 详 细信息："+"<br>"+ex.toString());
				ExceptionInfo e=new ExceptionInfo();
				e.setActionName(actionName);
				e.setMessage(ex.toString());
				e.setName("数值格式异常");
				exception.put("exception",e);
				
			}else if(ex instanceof NegativeArraySizeException){
				logger.error("异常拦截器拦截到异常：负值数组大小异常！"+"<br>"+"action为:"+actionName+"<br>"+"异常 的 详 细信息："+"<br>"+ex.toString());
				ExceptionInfo e=new ExceptionInfo();
				e.setActionName(actionName);
				e.setMessage(ex.toString());
				e.setName("负值数组大小异常");
				exception.put("exception",e);
				
			}
			else if(ex instanceof NullPointerException){
				logger.error("异常拦截器拦截到异常：空引用异常！"+"<br>"+"action为:"+actionName+"<br>"+"异常 的 详 细信息："+"<br>"+ex.toString());
				ExceptionInfo e=new ExceptionInfo();
				e.setActionName(actionName);
				e.setMessage(ex.toString());
				e.setName("空引用异常");
				exception.put("exception",e);
				
			}
			else if(ex instanceof SecurityException){
				logger.error("异常拦截器拦截到异常：安全异常！"+"<br>"+"action为:"+actionName+"<br>"+"异常 的 详 细信息："+"<br>"+ex.toString());
				ExceptionInfo e=new ExceptionInfo();
				e.setActionName(actionName);
				e.setMessage(ex.toString());
				e.setName("安全异常");
				exception.put("exception",e);
				
			}
			else if(ex instanceof StringIndexOutOfBoundsException){
				logger.error("异常拦截器拦截到异常：字符串越界异常！"+"<br>"+"action为:"+actionName+"<br>"+"异常 的 详 细信息："+"<br>"+ex.toString());
				ExceptionInfo e=new ExceptionInfo();
				e.setActionName(actionName);
				e.setMessage(ex.toString());
				e.setName("字符串越界异常");
				exception.put("exception",e);
				
			}else {
				logger.error("异常拦截器拦截到异常：未知异常！"+"<br>"+"action为:"+actionName+"<br>"+"异常 的 详 细信息："+"<br>"+ex.toString());
				ExceptionInfo e=new ExceptionInfo();
				e.setActionName(actionName);
				e.setMessage(ex.toString());
				e.setName("未知异常");
				exception.put("exception",e);
			}
			invocation.getInvocationContext().setSession(exception);
			return "error";
		}
		return result;
	}

}
