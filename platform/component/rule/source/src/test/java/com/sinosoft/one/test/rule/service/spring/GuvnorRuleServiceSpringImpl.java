package com.sinosoft.one.test.rule.service.spring;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.rule.service.facade.DroolsRuleService;
import com.sinosoft.one.test.rule.service.facade.GuvnorRuleService;

public class GuvnorRuleServiceSpringImpl implements GuvnorRuleService {

	@Autowired
	public DroolsRuleService droolsRuleService;

	public void executeRule(Object... facts) throws Exception {
		droolsRuleService
				.executeRules(
						"http://localhost:8080/drools-guvnor/org.drools.guvnor.Guvnor/package/rule/LATEST/ChangeSet.xml",
						facts);
	}

}