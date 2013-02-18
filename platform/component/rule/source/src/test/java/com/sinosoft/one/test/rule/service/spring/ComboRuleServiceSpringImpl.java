package com.sinosoft.one.test.rule.service.spring;

import org.drools.runtime.StatefulKnowledgeSession;
import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.sinosoft.one.rule.service.facade.DroolsRuleService;
import com.sinosoft.one.rule.util.KnowledgeAgentManager;
import com.sinosoft.one.test.rule.domain.ComboInputBOM;
import com.sinosoft.one.test.rule.service.facade.ComboRuleService;

public class ComboRuleServiceSpringImpl implements ComboRuleService {
	@Autowired
	public DroolsRuleService droolsRuleService;

	public void executeRuleWithGlobal(String ruleFlowName, Object global,
			Object... facts) throws Exception {
		droolsRuleService.executeRulesWithGlobal(ruleFlowName, global,
				"comboChangeSet.xml", facts);
	}

	public void executeRuleWithGlobal(Object global, Object... facts)
			throws Exception {
		droolsRuleService.executeRulesWithGlobal(global,
				"comboChangeSet.xml", facts);
	}

	public void executeRule(Object... facts) throws Exception {

		droolsRuleService.executeRules("comboChangeSet.xml", facts);
	}

	public void executeRule(String ruleFlowName, Object... facts)
			throws Exception {

		droolsRuleService.executeRules(ruleFlowName, "comboChangeSet.xml",
				facts);
	}

	public void executeRule2(Object inputBOM) throws Exception {
		// StatefulKnowledgeSession ksession = KnowledgeAgentManager
		// .getKnowledgeAgent("comboChangeSet.xml").getKnowledgeBase()
		// .newStatefulKnowledgeSession();
		// ComboInputBOM o = new ComboInputBOM();
		// o.setUpdateFlag(2);
		// ksession.insert(o);
		// // ksession.startProcess("com.chinalife");
		// ksession.fireAllRules();
		// ksession.dispose();
	}

	public void executeRule3(Object inputBOM) throws Exception {
		// StatefulKnowledgeSession ksession = KnowledgeAgentManager
		// .getKnowledgeAgent("comboChangeSet.xml").getKnowledgeBase()
		// .newStatefulKnowledgeSession();
		// ComboInputBOM o = new ComboInputBOM();
		// o.setAreaCode("0001");
		// o.setUpdateFlag(2);
		// ksession.insert(o);
		// // ksession.startProcess("com.chinalife");
		// ksession.fireAllRules();
		// ksession.dispose();
		// System.out.println("----- ---" + o.getAreaCode());
	}

	// public static void main(String[] args) {
	// ComboRuleServiceSpringImpl a = new ComboRuleServiceSpringImpl();
	//
	// try {
	// a.executeRule3(null);
	// Thread.sleep(30 * 1000);
	// a.executeRule3(null);
	// Thread.sleep(30 * 1000);
	// a.executeRule2(null);
	// Thread.sleep(30 * 1000);
	// a.executeRule2(null);
	// // Logger logger =
	// // LoggerFactory.getLogger(ComboRuleServiceSpringImpl.class);
	// // logger.info("------ok");
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }

	// try {
	// KnowledgeBase kbase =readKnowledgeBase();
	// StatefulKnowledgeSession
	// ksession=kbase.newStatefulKnowledgeSession();
	// ComboInputBOM o=new ComboInputBOM();
	// o.setUpdateFlag(3);
	// ksession.insert(o);
	// ksession.fireAllRules();
	// ksession.dispose();
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	// private static KnowledgeBase readKnowledgeBase() throws Exception {
	// KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
	// .newKnowledgeBuilder();
	// DecisionTableConfiguration config = KnowledgeBuilderFactory
	// .newDecisionTableConfiguration();
	// config.setInputType(DecisionTableInputType.XLS);
	// System.out.println("------0---------");
	// kbuilder.add(
	// ResourceFactory.newClassPathResource("rules/comboRule.xls"),
	// ResourceType.DTABLE, config);
	// System.out.println("------1----------");
	// KnowledgeBuilderErrors errors = kbuilder.getErrors();
	// if (errors.size() > 0) {
	// for (KnowledgeBuilderError error : errors) {
	// System.out.println("--------2--------");
	// System.err.println("===" + error);
	// }
	// throw new IllegalArgumentException("Could not parse knowledge.");
	// }
	// KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
	// kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
	// return kbase;
	// }

}