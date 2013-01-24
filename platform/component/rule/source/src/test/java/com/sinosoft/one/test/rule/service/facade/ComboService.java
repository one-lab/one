package com.sinosoft.one.test.rule.service.facade;


import java.util.List;

import com.sinosoft.one.test.rule.model.ComboFlag;
import com.sinosoft.one.test.rule.model.PdCombo;
import com.sinosoft.one.test.rule.model.PdComboArea;



/**
 * 套餐服务
 * @author qc
 *
 */
public interface ComboService {
	
	/**
	 * 增加套餐
	 * @param combo 套餐
	 * 
	 */
	public void addCombo(PdCombo combo);
	
//	/**
//	 * 根据区域获取套餐
//	 * @param areaCode  区域代码
//	 * @param isRenewal 续保标识
//	 * @return
//	 */
//	public List<PdCombo> findComboByAreaCode(String areaCode,boolean isRenewal,ProposalCheck proposalCheck);

	
//	/**
//	 * 根据套餐代码获取套餐
//	 * @param comboCode
//	 * @return
//	 */
//	public PdCombo findComboByComboCode(String comboCode);


    /**
     * 根据comboCode来删除套餐
     * @param comboCode
     */
    public void delCombo(String comboCode);

	
	/**
	 * 更新套餐
	 * @param combo
	 */
	public void updateCombo(PdCombo combo);


	/**
	 * 更改套餐状态
	 * @param comboCode 套餐代码
	 * @param statue 套餐状态
	 */
	public void changeComboStatue(String comboCode,ComboFlag.Statue statue);

	
	/**
	 * 保存套餐区域
	 * @param comboAreas
	 */
	public void addComboAreaList(List<PdComboArea> comboAreas);
	
	
	/**
	 * 修改套餐区域
	 * @param comboAreas
	 */
	public void updateComboAreaList(List<PdComboArea> comboAreas);

	/**
	 * 根据区域代码与是否续保标志获取套餐区域
	 * @param areaCode
	 * @param renewalflag
	 */
	public List<PdComboArea> findComboAreaByAreaAndRenew(String areaCode,String renewalflag);
	
}
