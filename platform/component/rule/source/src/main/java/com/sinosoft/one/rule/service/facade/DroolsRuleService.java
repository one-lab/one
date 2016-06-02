package com.sinosoft.one.rule.service.facade;

import com.sinosoft.one.rule.domain.GlobalBOM;
import com.sinosoft.one.rule.domain.InputBOM;

public interface DroolsRuleService {

	public void executeRules(String changeSetFilePath, Object... facts);

	public void executeRules(String ruleFlowName, String changeSetFilePath,
			Object... facts);

	public void executeRulesWithGlobal(Object global, String changeSetFilePath,
			Object... facts);

	public void executeRulesWithGlobal(String ruleFlowName, Object global,
			String changeSetFilePath, Object... facts);

//	public void executeRules(String ruleFlowName, GlobalBOM global,
//			String changeSetFilePath, Object... facts);
}
