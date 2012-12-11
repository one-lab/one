package com.sinosoft.ebusiness.test;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.DecisionTableConfiguration;
import org.drools.builder.DecisionTableInputType;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
//import org.junit.Test;

public class DecisionTableTeest {
//	@Test
//	public void test() {
//		System.out.println("         3333");
//	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		KnowledgeBase kbase = null;
		try {
			kbase = readKnowledgeBase();
			// StatefulKnowledgeSession ksession =
			// kbase.newStatefulKnowledgeSession();
			// KnowledgeRuntimeLogger logger =
			// KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
			// QuickPriceInputBOM qpib = new QuickPriceInputBOM();
			// qpib.setVehicleAge(1);
			// qpib.setReplacementValue(20000.00);
			// ksession.insert(qpib);
			// ksession.fireAllRules();
			// ksession.dispose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static KnowledgeBase readKnowledgeBase() throws Exception {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		// Resource resource
		// =ResourceFactory.newClassPathResource("ruleflow.rf");
		DecisionTableConfiguration config = KnowledgeBuilderFactory
				.newDecisionTableConfiguration();
		config.setInputType(DecisionTableInputType.XLS);
//		kbuilder.add(
//				ResourceFactory
//						.newClassPathResource("proposalRules/proposalRule.xls"),
//				ResourceType.DTABLE, config);
		kbuilder.add(
				ResourceFactory
						.newClassPathResource("comboRules/comboRule-shandong.xls"),
				ResourceType.DTABLE, config);
		kbuilder.add(
				ResourceFactory
						.newClassPathResource("comboRules/comboRule-shenzhen.xls"),
				ResourceType.DTABLE, config);
		kbuilder.add(
				ResourceFactory
						.newClassPathResource("comboRules/comboRuleFlow.rf"),
				ResourceType.DRF, config);
		kbuilder.add(
				ResourceFactory
						.newClassPathResource("specialClausRule/specialClausRule.xls"),
				ResourceType.DTABLE, config);
		kbuilder.add(
				ResourceFactory
						.newClassPathResource("quickPriceRules/quickPriceRule-shandong.xls"),
				ResourceType.DTABLE, config);
		kbuilder.add(
				ResourceFactory
						.newClassPathResource("quickPriceRules/quickPriceRule-shenzhen.xls"),
				ResourceType.DTABLE, config);
		kbuilder.add(ResourceFactory
				.newClassPathResource("quickPriceRules/quickPriceRuleFlow.rf"),
				ResourceType.DRF, config);
		KnowledgeBuilderErrors errors = kbuilder.getErrors();
		if (errors.size() > 0) {
			for (KnowledgeBuilderError error : errors) {
				System.err.println("error is :" + error);
			}
			throw new IllegalArgumentException("Could not parse knowledge.....");
		}
		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		System.out.println("[debug]finish read base!");
		return kbase;
	}
}
