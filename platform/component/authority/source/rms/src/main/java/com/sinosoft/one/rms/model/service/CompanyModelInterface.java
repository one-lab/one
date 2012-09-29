package com.sinosoft.one.rms.model.service;

import java.util.List;

/**
 * 对于不同的机构model实现的接口
 * @author Administrator
 *
 */
public interface CompanyModelInterface extends java.io.Serializable {
	
	public String getComCode();

	/**
	 * 属性机构中文名称(ComCName)的getter方法
	 */

	public String getComCName();


	/**
	 * 属性机构英文名称(ComEName)的getter方法
	 */

	public String getComEName();

	
	/**
	 * 属性地址中文名称(AddressCName)的getter方法
	 */

	public String getAddressCName();

	
	/**
	 * 属性地址英文名称(AddressEName)的getter方法
	 */

	public String getAddressEName();

	
	/**
	 * 属性邮编的getter方法
	 */

	public String getPostCode();

	/**
	 * 属性电话的getter方法
	 */

	public String getPhoneNumber();

	/**
	 * 属性传真(FaxNumber)的getter方法
	 */

	public String getFaxNumber();

	/**
	 * 属性上级机构代码(UpperComCode)的getter方法
	 */

	public String getUpperComCode();

	/**
	 * 属性归属保险公司名称(InsurerName)的getter方法
	 */

	public String getInsurerName();

	/**
	 * 属性机构类型(ComType)的getter方法
	 */
	public String getComType();

	/**
	 * 属性经理(Manager)的getter方法
	 */

	public String getManager();

	/**
	 * 属性会计(Accountant)的getter方法
	 */

	public String getAccountant();

	/**
	 * 属性备注(Remark)的getter方法
	 */

	public String getRemark();

	/**
	 * 属性最新机构代码(NewComCode)的getter方法
	 */

	public String getNewComCode();

	/**
	 * 属性效力状态(ValidStatus)的getter方法
	 */

	public String getValidStatus();

	/**
	 * 属性账户归属机构代码(AcntUnit)的getter方法
	 */

	public String getAcntUnit();

	/**
	 * 属性专项代码(ArticleCode)的getter方法
	 */

	public String getArticleCode();

	/**
	 * 属性标志字段(Flag)的getter方法
	 */

	public String getFlag();

	/**
	 * 属性是否可保字段(Flag)的getter方法
	 */
	public String getIsinSured();

	/**
	 * 属性employes的getter方法
	 */
	public List<? extends EmployeModelInterface> getEmployes();

	
	
	public List<? extends EmployeModelInterface> getPrpDusersFormakeCom();

	/**
	 * 属性prpDusersForcomCode的getter方法
	 */
	public List<? extends EmployeModelInterface> getPrpDusersForcomCode();

}
