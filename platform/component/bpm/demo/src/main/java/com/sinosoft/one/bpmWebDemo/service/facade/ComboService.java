package com.sinosoft.one.bpmWebDemo.service.facade;


import ins.framework.common.Page;

import java.util.List;
import java.util.Map;

import com.sinosoft.one.bpmWebDemo.domain.Combo;


public interface ComboService {
	public Page getCombos(String userId, String condation);
	
	public List<Combo> getCombosStepFour(String condation);
	
	public List<Combo> getCombosStepFive(String condation);

	public void processComboStepOne(String userId, String comboCode, Combo c);

	public void processComboStepTwo(String comboCode, Combo c, String isPassed) throws Exception;

	public void processComboStepThree(String comboCode, Combo c);
	
	public void processComboStepFour(String comboCode, Combo c, List<String> listData);
	
	public void processComboStepFive(String comboCode, Combo c);
	
	public void createCombo(String comboCode, Combo c, Map<String, Object> mapData);
	
	public Combo getCombo(String comboCode);

}