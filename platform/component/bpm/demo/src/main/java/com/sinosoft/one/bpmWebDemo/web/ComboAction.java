package com.sinosoft.one.bpmWebDemo.web;

import ins.framework.common.Page;
import ins.framework.web.Struts2Action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.sinosoft.one.bpmWebDemo.data.DataStore;
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
		comboService.createCombo(combo.getComboCode(), combo);
		System.out.println("--------createCombo--------");
	}

	public String getVerify1Combos() {
		this.page = new Page();
		List<Combo> results = comboService.getCombos_StepOne("");

		for (Combo c : results) {
			page.getResult().add(c);
		}
		System.out.println("page size--------" + results.size());
		return SUCCESS;
	}

	public String prepareProcess1() {
		combo = DataStore.dataStore.get(combo.getComboCode());
		return SUCCESS;
	}

	public void verifyCombo1() {
		combo.getKind().setComboCode(combo.getComboCode());
		comboService.processCombo_StepOne(combo.getComboCode(), combo);
		System.out.println("fisrt step--------verifyCombo1--------");
		System.out.println("-------verifyCombo1--------success");
	}

	public String getVerify2Combos() {
		this.page = new Page();
		List<Combo> results = comboService.getCombos_StepTwo("");

		for (Combo c : results) {
			page.getResult().add(c);
		}
		System.out.println("page size--------" + results.size());
		return SUCCESS;
	}

	public String prepareProcess2() {
		combo = DataStore.dataStore.get(combo.getComboCode());
		return SUCCESS;
	}

	public void verifyCombo2() {
		combo.getKind().setComboCode(combo.getComboCode());
		comboService.processCombo_StepTwo(combo.getComboCode(), combo, this.getRequest().getParameter("isPassed"));
		System.out.println("second step--------verifyCombo2--------");

	}

	public String getDeployCombos() {
		this.page = new Page();
		List<Combo> results = comboService.getCombos_StepThree("");

		for (Combo c : results) {
			page.getResult().add(c);
		}
		System.out.println("page size--------" + results.size());
		return SUCCESS;
	}

	public String prepareDeploy() {
		combo = DataStore.dataStore.get(combo.getComboCode());
		return SUCCESS;
	}

	public void deploy() {
		combo.getKind().setComboCode(combo.getComboCode());
		comboService.processCombo_StepThree(combo.getComboCode(), combo);
		System.out.println("third step--------deployCombo--------");

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
