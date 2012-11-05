package com.sinosoft.one.bpmWebDemo.service.spring;

import ins.framework.common.Page;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.one.bpm.aspect.GetTask;
import com.sinosoft.one.bpm.aspect.ProcessTask;
import com.sinosoft.one.bpm.aspect.StartProcess;
import com.sinosoft.one.bpm.aspect.TaskParam;
import com.sinosoft.one.bpm.aspect.TaskParams;
import com.sinosoft.one.bpmWebDemo.data.DataStore;
import com.sinosoft.one.bpmWebDemo.data.StudentStore;
import com.sinosoft.one.bpmWebDemo.domain.Combo;
import com.sinosoft.one.bpmWebDemo.domain.Kind;
import com.sinosoft.one.bpmWebDemo.domain.Student;
import com.sinosoft.one.bpmWebDemo.service.facade.ComboService;

@Service
public class ComboServiceSpringImpl implements ComboService {
    @Autowired
    private StudentStore studentStore;
	public void init() {
		System.out.println("--------------init");
	}

	public ComboServiceSpringImpl() {
		System.out.println("--------------ComboServiceSpringImpl");
	}

	/**
	 * 支持嵌套
	 */
	@GetTask(userIdBeanOffset=0, businessIdAttibuteName = "result.comboCode")
	public Page getCombos(String userId, String condation) {
		System.out.println("--------------getCombos");
		List<Combo> results = DataStore.getCombos();
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
		Page page = new Page();
		page.getResult().addAll(results);
		return page;
	}

	
	@GetTask(userId = "combo004", businessIdAttibuteName = "comboCode")
	public List<Combo> getCombos_StepFour(String condation) {
		System.out.println("--------------getCombos");
		List<Combo> results = DataStore.getCombos();
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
	@ProcessTask(userId = "combo001", businessBeanOffset = 0)
	public void processCombo_StepOne(String comboCode, Combo c) {
		System.out.println("--------------processCombo_StepOne ");
	}

	/**
	 * 简单复合类型的解析属性
	 */
	@ProcessTask(userId = "combo002", businessBeanOffset = 1, businessIdAttibuteName = "comboCode")
	@TaskParams(taskParams={@TaskParam(key="isPassed1", paramValueBeanOffset=2)})
	public void processCombo_StepTwo(String comboCode, Combo c, String isPassed) {
		System.out.println("--------------processCombo_StepTwo");
	}

	/**
	 * 嵌套复合类型的解析属性
	 */
	@ProcessTask(userId = "combo003", businessBeanOffset = 1, businessIdAttibuteName = "kind.comboCode")
	public void processCombo_StepThree(String comboCode, Combo c) {
		System.out.println("--------------processCombo_StepThree");
	}

	/**
	 *  
	 */
	@StartProcess(processId = "comboProcess", businessBeanOffset = 1, businessIdAttibuteName = "comboCode")
	public Student createCombo(String comboCode, Combo c) {
		try {
			if(c==null)System.out.println("c==null");
			DataStore.store(c);
            studentStore.saveStudent(new Student(UUID.randomUUID().toString().replaceAll("-", ""), "carvin"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("------creat--------combo:" + comboCode);
        return this.findStudent("111");
	}

    public Student findStudent(String id) {
        return studentStore.findStudent(id);
    }

    @ProcessTask(userId = "combo004", businessBeanOffset = 1, businessIdAttibuteName = "comboCode")
	public void processCombo_StepFour(String comboCode, Combo c) {
		System.out.println("--------------processCombo_StepFour");
	}

}
