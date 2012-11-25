package com.sinosoft.one.bpmWebDemo.service.facade;


import ins.framework.common.Page;

import java.util.List;

import com.sinosoft.one.bpmWebDemo.domain.Combo;
import com.sinosoft.one.bpmWebDemo.domain.Student;


public interface ComboService {
	public Page getCombos(String userId, String condation);
	
	public List<Combo> getCombos_StepFour(String condation);

	public void processCombo_StepOne(String userId, String comboCode, Combo c);

	public void processCombo_StepTwo(String comboCode, Combo c, String isPassed);

	public void processCombo_StepThree(String comboCode, Combo c);
	
	public void processCombo_StepFour(String comboCode, Combo c);

	public void createCombo(String comboCode, Combo c);
	
	public Combo getCombo(String comboCode);

}