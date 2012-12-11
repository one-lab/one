package com.sinosoft.ebusiness.test.rule.service.spring;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.ebusiness.rule.service.facade.DroolsRuleService;
import com.sinosoft.ebusiness.test.rule.service.facade.SpecialClausRuleService;

public class SpecialClausRuleServiceSpringImpl implements
		SpecialClausRuleService {
	@Autowired
	public DroolsRuleService droolsRuleService;

	public void executeRule(Object global, Object... facts) throws Exception {
		droolsRuleService.executeRulesWithGlobal(global,
				"specialClausChangeSet.xml", facts);
	}
}