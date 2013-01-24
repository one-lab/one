package com.sinosoft.one.rule.service.spring;

import org.drools.KnowledgeBase;
import org.drools.runtime.StatefulKnowledgeSession;
import org.springframework.stereotype.Component;

import com.sinosoft.one.rule.domain.GlobalBOM;
import com.sinosoft.one.rule.domain.InputBOM;
import com.sinosoft.one.rule.service.facade.DroolsRuleService;
import com.sinosoft.one.rule.util.KnowledgeAgentManager;

@Component
public class DroolsRuleServiceSpringImpl implements DroolsRuleService {
	private KnowledgeBase kBase = null;
	private StatefulKnowledgeSession ksession = null;
	private KnowledgeAgentManager kAgentManager = null;

	public DroolsRuleServiceSpringImpl() {
		// init, get KnowledgeAgentManager instance
		kAgentManager = KnowledgeAgentManager.getInstance();
	}

	public void executeRules(String changeSetFilePath, Object... facts) {
		this.executeRules(null, changeSetFilePath, facts);
	}

	public void executeRules(String ruleFlowName, String changeSetFilePath,
			Object... facts) {
		this.executeRulesWithGlobal(ruleFlowName, null, changeSetFilePath,
				facts);
	}

	public void executeRulesWithGlobal(Object global, String changeSetFilePath,
			Object... facts) {
		this.executeRulesWithGlobal(null, global, changeSetFilePath, facts);
	}

	public void executeRulesWithGlobal(String ruleFlowName, Object global,
			String changeSetFilePath, Object... facts) {
		kBase = kAgentManager.getKnowledgeAgent(changeSetFilePath)
				.getKnowledgeBase();
		ksession = kBase.newStatefulKnowledgeSession();
		if (global != null) {
			ksession.setGlobal("globalData", global);
		}
		for (Object fact : facts) {
			ksession.insert(fact);
		}
		if (ruleFlowName != null) {
			ksession.startProcess(ruleFlowName);
		}
		ksession.fireAllRules();
		ksession.dispose();
	}

	public void executeRules(String ruleFlowName, GlobalBOM global,
			String changeSetFilePath, InputBOM... facts) {
		kBase = kAgentManager.getKnowledgeAgent(changeSetFilePath)
				.getKnowledgeBase();
		ksession = kBase.newStatefulKnowledgeSession();
		if (global != null) {
			ksession.setGlobal("globalData", global);
		}
		for (InputBOM fact : facts) {
			ksession.insert(fact);
		}
		if (ruleFlowName != null) {
			ksession.startProcess(ruleFlowName);
		}
		ksession.fireAllRules();
		ksession.dispose();
	}

}
