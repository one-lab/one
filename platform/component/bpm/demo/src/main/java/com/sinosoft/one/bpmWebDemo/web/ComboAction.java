package com.sinosoft.one.bpmWebDemo.web;

import ins.framework.common.Page;
import ins.framework.web.Struts2Action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.sinosoft.one.bpm.util.JbpmAPIUtil;
import com.sinosoft.one.bpmWebDemo.domain.Combo;
import com.sinosoft.one.bpmWebDemo.service.facade.ComboService;

@SuppressWarnings("serial")
public class ComboAction extends Struts2Action {
	@Autowired
	private ComboService comboService;

	private Combo combo;

	public void createCombo() {
		ActionContext.getContext().put("userId", "combo001");
		System.out.println("--------createCombo：" + combo.getComboCode());
		System.out.println("--------createCombo kind:" + combo.getKind().getKindCode());
		combo.getKind().setComboCode(combo.getComboCode());
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("111", "1111");
		comboService.createCombo(combo.getComboCode(), combo, mapData);
		System.out.println("--------createCombo--------");
	}

	public String getVerify1Combos() {
		this.page = comboService.getCombos("combo001", "");
		System.out.println("page size--------" + page.getResult().size());
		return SUCCESS;
	}

	public String prepareProcess1() {
		combo = comboService.getCombo(combo.getComboCode());
		return SUCCESS;
	}

	public void verifyCombo1() {
		combo.getKind().setComboCode(combo.getComboCode());
		comboService.processComboStepOne("combo001", combo.getComboCode(), combo);
		System.out.println("fisrt step--------verifyCombo1--------");
		System.out.println("-------verifyCombo1--------success");
	}

	public String getVerify2Combos() {
		this.page = comboService.getCombos("combo002", "");
		System.out.println("page size--------" + page.getResult().size());
		return SUCCESS;
	}

	public String prepareProcess2() {
		combo = comboService.getCombo(combo.getComboCode());
		return SUCCESS;
	}

	public void verifyCombo2() throws Exception {
		combo.getKind().setComboCode(combo.getComboCode());
		comboService.processComboStepTwo(combo.getComboCode(), combo, this.getRequest().getParameter("isPassed"));
		System.out.println("second step--------verifyCombo2--------");

	}
	
	public String getVerify3Combos() {
		this.page = comboService.getCombos("combo003", "");
		System.out.println("page size--------" + page.getResult().size());
		return SUCCESS;
	}

	public String prepareProcess3() {
		combo = comboService.getCombo(combo.getComboCode());
		return SUCCESS;
	}

	public void verifyCombo3() throws Exception {
		combo.getKind().setComboCode(combo.getComboCode());
		comboService.processComboStepTwo(combo.getComboCode(), combo, this.getRequest().getParameter("isPassed"));
		System.out.println("second step--------verifyCombo3--------");

	}

	public String getDeployCombos() {
		this.page = comboService.getCombos("combo003", "");
		System.out.println("page size--------" + page.getResult().size());
		return SUCCESS;
	}

	public String prepareDeploy() {
		combo = comboService.getCombo(combo.getComboCode());
		return SUCCESS;
	}
	
	public void deploy() {
		combo.getKind().setComboCode(combo.getComboCode());
		comboService.processComboStepThree(combo.getComboCode(), combo);
		System.out.println("third step--------deployCombo--------");

	}
	
	public String getDeploy2Combos() {
		this.page = new Page();
		List<Combo> results = comboService.getCombosStepFour("");

		for (Combo c : results) {
			page.getResult().add(c);
		}
		System.out.println("page size--------" + results.size());
		return SUCCESS;
	}

	public String prepareDeploy2() {
		combo = comboService.getCombo(combo.getComboCode());
		return SUCCESS;
	}
	

	public void deploy2() {
		combo.getKind().setComboCode(combo.getComboCode());
		List<String> strList = new ArrayList<String>();
		strList.add("aaa");
		strList.add("bbb");
		comboService.processComboStepFour(combo.getComboCode(), combo, strList);
		System.out.println("four step--------deployCombo-2222222-------");

	}
	
	
	
	public String getDeploy3Combos() {
		this.page = new Page();
		List<Combo> results = comboService.getCombosStepFive("");

		for (Combo c : results) {
			page.getResult().add(c);
		}
		System.out.println("page size--------" + results.size());
		return SUCCESS;
	}
	
	public String prepareDeploy3() {
		combo = comboService.getCombo(combo.getComboCode());
		return SUCCESS;
	}
	
	public void deploy3() {
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
	
	public String showImage() {
		String contextPath = this.getRequest().getContextPath();
		String s = JbpmAPIUtil.getImageInfoes("comboProcess", combo.getComboCode(), contextPath + "/process-images/ComboProcess-image.png", contextPath);
		this.renderHtml(s);
		return NONE;
	}

	public Combo getCombo() {
		return combo;
	}

	public void setCombo(Combo combo) {
		this.combo = combo;
	}

	public ComboService getComboService() {
		return comboService;
	}

	public void setComboService(ComboService comboService) {
		this.comboService = comboService;
	}

	private Page page;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
