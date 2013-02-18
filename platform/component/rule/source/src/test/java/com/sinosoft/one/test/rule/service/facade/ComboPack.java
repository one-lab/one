package com.sinosoft.one.test.rule.service.facade;

import java.util.List;


public interface ComboPack {

	/**
	 * 获取包装号
	 * @return
	 */
	public String getPackageNo();
	
	
	/**
	 * 获取item号
	 * @return
	 */
	public List<String> getItemsId();
	
	
	/**
	 * 包装描述
	 * @return
	 */
	public String getDes();
	

	/**
	 * 获取代码类型
	 * @return
	 */
	public String getCodeType();

	/**
	 * 获取取值
	 * @return
	 */
	public String getValueRange();

	/**
	 * 缺省取值
	 * @return
	 */
	public String getDefaultValue();

	/**
	 * 获取选择条件
	 * @return
	 */
	public List<String> getCheckCondition();
	
	/**
	 * 不计免赔标识
	 * @return 0 不存在不计免赔标识
	 *         1:是
	 *         2:否
	 */    
	public String getNoDeductFlag();
}
