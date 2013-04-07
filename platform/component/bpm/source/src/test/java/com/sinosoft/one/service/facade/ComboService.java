package com.sinosoft.one.service.facade;

import java.util.List;

import com.sinosoft.one.test.domain.Combo;

public interface ComboService {
	public List<Combo> getCombos_StepOne(String condation);

	public List<Combo> getCombos_StepTwo(String condation);

	public List<Combo> getCombos_StepThree(String condation);

	public void processCombo_StepOne(String comboCode, Combo c);

	public void processCombo_StepTwo(String comboCode, Combo c);

	public void processCombo_StepThree(String comboCode, Combo c);
	
	public void processCombo_StepFour(String comboCode, Combo c);

	public void createCombo(String comboCode, Combo c);

}