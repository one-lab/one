package com.sinosoft.one.test.rule.service.facade;

import com.sinosoft.one.rule.domain.InputBOM;

public interface ProposalRuleService {
	public void executeRule(InputBOM... fact);
}
