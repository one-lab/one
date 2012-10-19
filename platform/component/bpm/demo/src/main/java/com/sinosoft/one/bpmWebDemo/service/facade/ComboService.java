package com.sinosoft.one.bpmWebDemo.service.facade;

import java.util.List;

import com.sinosoft.one.bpmWebDemo.domain.Combo;
import com.sinosoft.one.bpmWebDemo.domain.Student;


public interface ComboService {
	public List<Combo> getCombos_StepOne(String condation);

	public List<Combo> getCombos_StepTwo(String condation);

	public List<Combo> getCombos_StepThree(String condation);
	
	public List<Combo> getCombos_StepFour(String condation);

	public void processCombo_StepOne(String comboCode, Combo c);

	public void processCombo_StepTwo(String comboCode, Combo c, String isPassed);

	public void processCombo_StepThree(String comboCode, Combo c);
	
	public void processCombo_StepFour(String comboCode, Combo c);

	public Student createCombo(String comboCode, Combo c);

}