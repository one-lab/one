package com.sinosoft.one.rms.model.service;

import java.util.Date;

/**
 * 对于不同的人员MODEL进行实现的接口
 * @author Administrator
 *
 */
public interface EmployeModelInterface extends java.io.Serializable {
	

	/**
	 * 属性员工代码的getter方法
	 */
	public String getUserCode();

	/**
	 * 属性prpDcompanyBycomCode的getter方法
	 */
	public CompanyModelInterface getPrpDcompanyBycomCode();


	/**
	 * 属性prpDcompanyBymakeCom的getter方法
	 */
	public CompanyModelInterface getPrpDcompanyBymakeCom();


	/**
	 * 属性员工名称的getter方法
	 */

	public String getUserName();


	/**
	 * 属性用户的英文名称的getter方法
	 */

	public String getUserEname();


	/**
	 * 属性密码的getter方法
	 */

	public String getPassword();


	/**
	 * 属性seal的getter方法
	 */

	public String getSeal();


	/**
	 * 属性密码设置时间的getter方法
	 */
	public Date getPasswordSetDate();


	/**
	 * 属性密码过期时间的getter方法
	 */
	public Date getPasswordExpireDate();


	/**
	 * 属性账户编号的getter方法
	 */

	public String getAccountCode();


	/**
	 * 属性phone的getter方法
	 */

	public String getPhone();


	/**
	 * 属性手机的getter方法
	 */

	public String getMobile();


	/**
	 * 属性地址的getter方法
	 */

	public String getAddress();


	/**
	 * 属性邮编的getter方法
	 */

	public String getPostCode();


	/**
	 * 属性电子邮件的getter方法
	 */

	public String getEmail();


	/**
	 * 属性用户标志的getter方法
	 */

	public String getUserFlag();


	/**
	 * 属性loginsystem的getter方法
	 */

	public String getLoginsystem();


	/**
	 * 属性最新员工代码的getter方法
	 */

	public String getNewUserCode();


	/**
	 * 属性效力状态的getter方法
	 */

	public String getValidStatus();


	/**
	 * 属性专项代码(对应会计科目)的getter方法
	 */

	public String getArticleCode();


	/**
	 * 属性标志的getter方法
	 */

	public String getFlag();


	/**
	 * 属性销售点终端号的getter方法
	 */

	public String getPosterminalNo();


	/**
	 * 属性usertype的getter方法
	 */

	public String getUsertype();


	/**
	 * 属性是否绑定硬件信息标志 0否 1是的getter方法
	 */
	public String getBindingFlag();


	/**
	 * 属性业务归属人员许可证号（从销售系统同步）的getter方法
	 */
	public String getProfessionalNo();

	
	public CompanyModelInterface getCompany();
	
	
}
