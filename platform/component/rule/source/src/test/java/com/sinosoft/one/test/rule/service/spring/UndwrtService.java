package com.sinosoft.one.test.rule.service.spring;

import com.sinosoft.one.rule.service.spring.DroolsRuleServiceSpringImpl;
import com.sinosoft.one.test.rule.domain.PrpUISechema;
import com.sinosoft.one.test.rule.domain.UndwrtCondition;
import com.sinosoft.undwrt.undwrtRule.vo.BusinessProposalData;
import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.rule.service.facade.DroolsRuleService;
import org.springframework.stereotype.Component;

@Component
public class UndwrtService {
	
//	@Autowired
	private DroolsRuleService service = new DroolsRuleServiceSpringImpl();
	
	public boolean undwrt(String level,UndwrtCondition condition){


		service.executeRules("undwrtRuleFlow","undwrtChangeSet.xml",level,condition);

        return condition.getResult();

	}

    public void executeRule(PrpUISechema facts) throws Exception {
        //ControlMessage globa=new ControlMessage();
        service.executeRulesWithGlobal("jfRuleFlow",facts, "JFChangeSet.xml", facts);
        //droolsRuleService.executeRules("jfRuleFlow", "JFChangeSet.xml", facts);
        //droolsRuleService.executeRules("JFChangeSet.xml", facts);
    }
}
