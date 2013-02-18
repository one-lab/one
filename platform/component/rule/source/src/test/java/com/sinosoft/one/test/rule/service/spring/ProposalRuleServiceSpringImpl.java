package com.sinosoft.one.test.rule.service.spring;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.rule.domain.InputBOM;
import com.sinosoft.one.rule.service.facade.DroolsRuleService;
import com.sinosoft.one.test.rule.service.facade.ProposalRuleService;

public class ProposalRuleServiceSpringImpl implements ProposalRuleService {
	@Autowired
	public DroolsRuleService droolsRuleService;

	public void executeRule(InputBOM... fact) {
		droolsRuleService.executeRules(null, null, "proposalChangeSet.xml",
				fact);
	}

}