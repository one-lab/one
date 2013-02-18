package com.sinosoft.one.test.rule.service.spring;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.rule.service.facade.DroolsRuleService;
import com.sinosoft.one.test.rule.service.facade.SpecialClausRuleService;

public class SpecialClausRuleServiceSpringImpl implements
		SpecialClausRuleService {
	@Autowired
	public DroolsRuleService droolsRuleService;

	public void executeRule(Object global, Object... facts) throws Exception {
		droolsRuleService.executeRulesWithGlobal(global,
				"specialClausChangeSet.xml", facts);
	}
}