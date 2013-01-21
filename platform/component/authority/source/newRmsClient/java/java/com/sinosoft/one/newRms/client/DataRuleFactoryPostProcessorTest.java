

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext
public class DataRuleFactoryPostProcessorTest {

	
	@Test
	public void testDataRuleFactory(){
		String rule = "";
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/applicationContext-shiro.xml");
		DataRuleFactoryPostProcessor dataRuleFactoryPostProcessor = (DataRuleFactoryPostProcessor) ctx.getBean("dataRuleFactoryPostProcessor");
		rule = dataRuleFactoryPostProcessor.getScript("queryRuleAccordCompany").creatSQL(rule, "com", "admin", "00", "{comCode:11}", "comCode");
		System.out.println(rule);
	}

}
