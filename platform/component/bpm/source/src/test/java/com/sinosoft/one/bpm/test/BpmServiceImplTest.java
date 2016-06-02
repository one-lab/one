package com.sinosoft.one.bpm.test;

import ins.framework.common.Page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.sinosoft.one.bpm.service.facade.BpmService;
import com.sinosoft.one.bpm.test.domain.Combo;
import com.sinosoft.one.bpm.test.domain.Kind;
import com.sinosoft.one.bpm.test.service.facade.ComboService;
import com.sinosoft.one.bpm.util.BpmServiceSupport;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.Transaction;

@DirtiesContext
@ContextConfiguration(locations = { "/spring/applicationContext-bpm.xml", "/applicationContext-test.xml" })
public class BpmServiceImplTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	public BpmService bpmService;
	@Autowired
	public ComboService comboService;
	@Autowired
	public BpmServiceSupport bpmServiceSupport;

	private Combo combo;
	
	private Page page;
	@Test
	public void testComboProcess() throws Exception {
		createCombo();
		
//		getStep1();
//		processStep1();
//		
//		getStep2();
//		processStep2();
//		
//		getStep3();
//		processStep3();
//		
//		getStep4();
//		processStep4();
//		
//		getStep5();
//		processStep5();
	}

	public void createCombo() {
		combo = new Combo();
		combo.setNo(new Random().nextInt());
		String uuid = System.currentTimeMillis() + "";
		combo.setComboCode(uuid);
		
		Kind kind = new Kind();
		kind.setKindCode(uuid);
		kind.setComboCode(uuid);
		kind.setKindName("Kind-" + uuid);
		
		combo.setKind(kind);
		
		System.out.println("--------createCombo：" + combo.getComboCode());
		System.out.println("--------createCombo kind:" + combo.getKind().getKindCode());
		combo.getKind().setComboCode(combo.getComboCode());
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("111", "1111");
		comboService.createCombo(combo.getComboCode(), combo, mapData);
		System.out.println("--------createCombo--------");
	}

	public String getStep1() {
		this.page = comboService.getCombos("combo001", "");
		System.out.println("page size--------" + page.getResult().size());
		return "SUCCESS";
	}

	public void processStep1() {
		combo.getKind().setComboCode(combo.getComboCode());
		comboService.processComboStepOne("combo001", combo.getComboCode(), combo);
		System.out.println("fisrt step--------verifyCombo1--------");
		System.out.println("-------verifyCombo1--------success");
	}

	public String getStep2() {
		this.page = comboService.getCombos("combo002", "");
		System.out.println("page size--------" + page.getResult().size());
		return "SUCCESS";
	}

	public void processStep2() throws Exception {
		combo.getKind().setComboCode(combo.getComboCode());
		comboService.processComboStepTwo(combo.getComboCode(), combo, "true");
		System.out.println("second step--------verifyCombo2--------");

	}
	
	public String getStep3() {
		this.page = comboService.getCombos("combo003", "");
		System.out.println("page size--------" + page.getResult().size());
		return "SUCCESS";
	}

	public void processStep3() throws Exception {
		combo.getKind().setComboCode(combo.getComboCode());
		comboService.processComboStepThree(combo.getComboCode(), combo);
		System.out.println("third step--------verifyCombo3--------");

	}

	public String getStep4() {
		this.page = new Page();
		List<Combo> results = comboService.getCombosStepFour("");

		for (Combo c : results) {
			page.getResult().add(c);
		}
		System.out.println("page size--------" + results.size());
		return "SUCCESS";
	}

	public void processStep4() {
		combo.getKind().setComboCode(combo.getComboCode());
		List<String> strList = new ArrayList<String>();
		strList.add("aaa");
		strList.add("bbb");
		comboService.processComboStepFour(combo.getComboCode(), combo, strList);
		System.out.println("four step--------deployCombo-2222222-------");

	}
	
	public String getStep5() {
		this.page = new Page();
		List<Combo> results = comboService.getCombosStepFive("");

		for (Combo c : results) {
			page.getResult().add(c);
		}
		System.out.println("page size--------" + results.size());
		return "SUCCESS";
	}
	
	public void processStep5() {
		combo.getKind().setComboCode(combo.getComboCode());
		List<String> listData = new ArrayList<String>() {
			{
				add("aaaa");
				add("bbbb");
			}
		};
		for(String strData : listData) {
			comboService.processComboStepFive(combo.getComboCode(), combo);
		}
		System.out.println("five step--------deployCombo-3333-------");

	}
	

	public void setComboService(ComboService comboService) {
		this.comboService = comboService;
	}

}
