package com.sinosoft.ebusiness.test.rule.service.facade;

public interface ComboRuleService {
	public void executeRule(Object... facts) throws Exception;

	public void executeRule(String ruleFlowName, Object... facts)
			throws Exception;

	public void executeRule3(Object inputBOM) throws Exception;

	public void executeRule2(Object inputBOM) throws Exception;
	public void executeRuleWithGlobal(String ruleFlowName, Object global,
			Object... facts) throws Exception;
	public void executeRuleWithGlobal(Object global,
			Object... facts) throws Exception;
}
