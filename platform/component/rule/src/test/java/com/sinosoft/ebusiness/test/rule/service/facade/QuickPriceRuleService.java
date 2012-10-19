package com.sinosoft.ebusiness.test.rule.service.facade;

public interface QuickPriceRuleService {
	public void executeRule(Object... facts) throws Exception;

	public void executeRuleWithGlobal(Object global, Object... facts)
			throws Exception;

	public void executeRule(String ruleFlowName, Object... facts)
			throws Exception;
	public void executeRuleWithGlobal(String ruleFlowName, Object global,
			Object... facts) throws Exception;
}
