package com.sinosoft.one.rule.service.spring;

import org.drools.KnowledgeBase;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.FactHandle;
import org.drools.runtime.rule.WorkingMemoryEntryPoint;
import org.springframework.stereotype.Component;

import com.sinosoft.one.rule.domain.GlobalBOM;
import com.sinosoft.one.rule.domain.InputBOM;
import com.sinosoft.one.rule.service.facade.DroolsRuleService;
import com.sinosoft.one.rule.util.KnowledgeAgentManager;

import java.util.HashMap;
import java.util.Map;

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
       // WorkingMemoryEntryPoint entrypoint = ksession.getWorkingMemoryEntryPoint("ruleFlowName");
		if (global != null) {
			ksession.setGlobal("globalData", global);
		}
		for (Object fact : facts) {
            FactHandle factHandle = ksession.insert(fact);
           // System.out.println("aaaa:" + factHandle.toExternalForm());
            ksession.update(factHandle,fact);
		}
		if (ruleFlowName != null) {
            Map map = new HashMap<String,Object>() ;
            map.put("test",global);
			ksession.startProcess(ruleFlowName,map);
		}

        //System.out.println("-----------start");
		ksession.fireAllRules();
		ksession.dispose();
	}

//	public void executeRules(String ruleFlowName, GlobalBOM global,
//			String changeSetFilePath, Object... facts) {
//		kBase = kAgentManager.getKnowledgeAgent(changeSetFilePath)
//				.getKnowledgeBase();
//		ksession = kBase.newStatefulKnowledgeSession();
//		if (global != null) {
//			ksession.setGlobal("globalData", global);
//		}
//		for (Object fact : facts) {
//			ksession.insert(fact);
//		}
//		if (ruleFlowName != null) {
//			ksession.startProcess(ruleFlowName);
//		}
//		ksession.fireAllRules();
//		ksession.dispose();
//	}

}
