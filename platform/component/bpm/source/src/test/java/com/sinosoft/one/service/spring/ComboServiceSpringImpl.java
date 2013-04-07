package com.sinosoft.one.service.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sinosoft.one.bpm.aspect.GetTask;
import com.sinosoft.one.bpm.aspect.Variable;
import com.sinosoft.one.bpm.aspect.ProcessTask;
import com.sinosoft.one.bpm.aspect.StartProcess;
import com.sinosoft.one.bpm.aspect.Variables;
import com.sinosoft.one.bpm.variable.VariableOperate;
import com.sinosoft.one.bpm.variable.VariableScope;
import com.sinosoft.one.bpm.variable.VariableType;
import com.sinosoft.one.service.facade.ComboService;
import com.sinosoft.one.test.domain.Combo;
import com.sinosoft.one.test.domain.Kind;

@Service
public class ComboServiceSpringImpl implements ComboService {

	public void init() {
		System.out.println("--------------init");
	}

	public ComboServiceSpringImpl() {
		System.out.println("--------------ComboServiceSpringImpl");
	}

	/**
	 * 支持嵌套
	 */
	@GetTask(userId = "combo001", businessIdAttibuteName = "comboCode")
	public List<Combo> getCombos_StepOne(String condation) {
		System.out.println("--------------getCombos");
		List<Combo> results = new ArrayList<Combo>();
		for (int i = 0; i < 2; i++) {
			Combo c = new Combo();
			c.setComboCode("00001" + i);
			if (i == 0) {
				Kind k = new Kind();
				k.setKindName("险种abc");
				k.setKindCode("abc");
				k.setComboCode("abc");
				c.setComboCode("abc");
				c.setKind(k);
			} else {
				Kind k = new Kind();
				k.setKindName("险种" + i);
				k.setKindCode("001" + i);
				k.setComboCode("001" + i);
				c.setComboCode("001" + i);
				c.setKind(k);
			}
			results.add(c);
		}
		System.out.println("resturn resutl size:" + results.size());
		return results;
	}

	@GetTask(userId = "combo002", businessIdAttibuteName = "comboCode")
	public List<Combo> getCombos_StepTwo(String condation) {
		//在此处抛异常测试
//		int j=10/0;
		System.out.println("--------------getCombos");
		List<Combo> results = new ArrayList<Combo>();
		for (int i = 0; i < 2; i++) {
			Combo c = new Combo();
			c.setComboCode("00001" + i);
			if (i == 0) {
				Kind k = new Kind();
				k.setKindName("险种abc");
				k.setKindCode("abc");
				k.setComboCode("abc");
				c.setComboCode("abc");
				c.setKind(k);
			} else {
				Kind k = new Kind();
				k.setKindName("险种" + i);
				k.setKindCode("001" + i);
				k.setComboCode("001" + i);
				c.setComboCode("001" + i);
				c.setKind(k);
			}
			results.add(c);
		}
		System.out.println("resturn resutl size:" + results.size());
		return results;
	}

	@GetTask(userId = "combo003", businessIdAttibuteName = "comboCode")
	public List<Combo> getCombos_StepThree(String condation) {
		System.out.println("--------------getCombos");
		List<Combo> results = new ArrayList<Combo>();
		for (int i = 0; i < 2; i++) {
			Combo c = new Combo();
			c.setComboCode("00001" + i);
			if (i == 0) {
				Kind k = new Kind();
				k.setKindName("险种abc");
				k.setKindCode("abc");
				k.setComboCode("abc");
				c.setComboCode("abc");
				c.setKind(k);
			} else {
				Kind k = new Kind();
				k.setKindName("险种" + i);
				k.setKindCode("001" + i);
				k.setComboCode("001" + i);
				c.setComboCode("001" + i);
				c.setKind(k);
			}
			results.add(c);
		}
		System.out.println("resturn resutl size:" + results.size());
		return results;
	}

	/**
	 * 简单类型的解析属性
	 */
	@ProcessTask(userId = "combo001",  businessBeanOffset = 1, businessIdAttibuteName = "comboCode")
	@Variable(name = "myList", variableValue="myList", scope=VariableScope.GLOBAL, operate=VariableOperate.ADD, type=VariableType.LIST)
	public void processCombo_StepOne(String comboCode, Combo c) {
		System.out.println("--------------processCombo_StepOne ");
	}

	/**
	 * 简单复合类型的解析属性
	 */
	@ProcessTask(userId = "combo002", businessBeanOffset = 1, businessIdAttibuteName = "comboCode")
	@Variable(name = "myMap", scope=VariableScope.GLOBAL, variableValue="myMap", operate=VariableOperate.ADD, type=VariableType.MAP, mapKey="myMap")
	public void processCombo_StepTwo(String comboCode, Combo c) {
		System.out.println("--------------processCombo_StepTwo");
	}

	/**
	 * 嵌套复合类型的解析属性
	 */
	@ProcessTask(userId = "combo003", businessBeanOffset = 1, businessIdAttibuteName = "kind.comboCode")
	@Variables(variables = {
			@Variable(name = "listData", variableValue="listData1", scope=VariableScope.PROCESSINSTANCE,
					type = VariableType.LIST,
					processId="comboProcess", businessIdBeanOffset=0),
			@Variable(name = "listData", variableValue="listData2", scope=VariableScope.PROCESSINSTANCE,
					type = VariableType.LIST,
					processId="comboProcess", businessIdBeanOffset=0)		
	})
	public void processCombo_StepThree(String comboCode, Combo c) {
		System.out.println("--------------processCombo_StepThree");
	}
	
	

	/**
	 *  
	 */
	@StartProcess(processId = "comboProcess", businessBeanOffset = 1, businessIdAttibuteName = "comboCode")
	@Variables(variables = {
			@Variable(name = "myData", variableValue="myData", scope=VariableScope.GLOBAL),
			@Variable(name = "myProcessInstanceData", variableValue="myProcessInstanceData", scope=VariableScope.PROCESSINSTANCE,
				processId="comboProcess", businessIdBeanOffset=0)
	})
	public void createCombo(String comboCode, Combo c) {
		System.out.println("--------------comboCode-----------areaCode");
	}

	@ProcessTask(userId = "combo004", businessBeanOffset = 1, businessIdAttibuteName = "kind.comboCode")
	public void processCombo_StepFour(String comboCode, Combo c) {
		System.out.println("--------------processCombo_StepFour-----------");
	}

}
