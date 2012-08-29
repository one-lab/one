/**
 * @ create_date 2012-8-25
 * @ author long
 * @ version 1.0
 */
package ins.common.model;

/**
 *
 * @title Exception
 * @description 异常信息类
 * @author 于文龙
 * @version 
 * @create date 2012-8-25
 * @copyright (c) SINOSOFT
 * 
 *
 */
public class ExceptionInfo {
	
	/**异常名称*/
	private String name;
	
	/**异常所在的action*/
	private String actionName;
	
	/**异常的详细信息*/
	private String message;
	
	/**
	 *
	 * @title 
	 * @description TODO
	 * @author long
	 * @create date 2012-8-25
	 *
	 */
	public ExceptionInfo() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
