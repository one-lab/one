package com.sinosoft.ebusiness.test.rule.service.spring;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.ebusiness.rule.service.facade.DroolsRuleService;
import com.sinosoft.ebusiness.test.rule.service.facade.QuickPriceRuleService;

public class QuickPriceRuleServiceSpringImpl implements QuickPriceRuleService {
	@Autowired
	public DroolsRuleService droolsRuleService;

	public void executeRule(Object... facts) throws Exception {
		droolsRuleService.executeRules("quickPriceChangeSet.xml", facts);
	}

	public void executeRule(String ruleFlowName, Object... facts)
			throws Exception {
		droolsRuleService.executeRules(ruleFlowName, "quickPriceChangeSet.xml",
				facts);
	}

	public void executeRuleWithGlobal(Object global, Object... facts)
			throws Exception {
		droolsRuleService.executeRulesWithGlobal(global,
				"quickPriceChangeSet.xml", facts);
	}

	public void executeRuleWithGlobal(String ruleFlowName, Object global,
			Object... facts) throws Exception {
		droolsRuleService.executeRulesWithGlobal(ruleFlowName, global,
				"quickPriceChangeSet.xml", facts);
	}
}