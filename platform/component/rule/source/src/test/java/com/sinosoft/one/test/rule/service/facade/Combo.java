package com.sinosoft.one.test.rule.service.facade;

import java.util.List;

import com.sinosoft.one.test.rule.model.ComboFlag;


public interface Combo {
	
	
	/**
	 * 获取套餐名称
	 * @return
	 */
	 public String getShowName();
	 
	 /**
	  * 获取套餐类型
	  * @return
	  */
	 public ComboFlag.Type getComboType();
	 
	 /**
	  * 是否允许投保
	  * @return
	  */
	 public boolean isAllowProposal();
	
	/**
	 * 获取套餐
	 * @return
	 */
	 public List<ComboPack> getComboPacks();
	 
	 /**
	 * 获取套餐代码
	 * @return
	 */
	 public String getComboCode();

}
