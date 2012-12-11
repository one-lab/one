package com.sinosoft.ebusiness.test.rule.service.facade;

import com.sinosoft.ebusiness.rule.domain.InputBOM;

public interface ProposalRuleService {
	public void executeRule(InputBOM... fact);
}
