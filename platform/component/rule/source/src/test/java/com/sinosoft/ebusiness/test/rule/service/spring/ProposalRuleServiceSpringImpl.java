package com.sinosoft.ebusiness.test.rule.service.spring;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.ebusiness.rule.domain.InputBOM;
import com.sinosoft.ebusiness.rule.service.facade.DroolsRuleService;
import com.sinosoft.ebusiness.test.rule.service.facade.ProposalRuleService;

public class ProposalRuleServiceSpringImpl implements ProposalRuleService {
	@Autowired
	public DroolsRuleService droolsRuleService;

	public void executeRule(InputBOM... fact) {
		droolsRuleService.executeRules(null, null, "proposalChangeSet.xml",
				fact);
	}

}