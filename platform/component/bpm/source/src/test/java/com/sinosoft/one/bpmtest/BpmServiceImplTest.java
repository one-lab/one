package com.sinosoft.one.bpmtest;

import java.util.List;

import junit.framework.Assert;

import org.jbpm.task.query.TaskSummary;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import com.sinosoft.one.bpm.service.facade.BpmService;
import com.sinosoft.one.bpm.util.BpmServiceSupport;
import com.sinosoft.one.service.facade.ComboService;
import com.sinosoft.one.test.domain.Combo;
import com.sinosoft.one.test.domain.Kind;
import com.sinosoft.one.util.test.SpringContextTestCase;

@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext-test.xml" })
public class BpmServiceImplTest extends SpringContextTestCase {

	@Autowired
	public BpmService bpmService;
	@Autowired
	public ComboService comboService;
	@Autowired
	public BpmServiceSupport bpmServiceSupport;

	@Test
	public void testComboService() {
		try {
			bpmServiceSupport.getSession("drools.properties");
			bpmServiceSupport.getTaskService();
			System.out.println("===only in update mode test  begin===");
			List<TaskSummary> tasks = bpmServiceSupport.getTaskService()
					.getTasksOwned("combo001", "en-UK");
			System.out.println("======task belong to combo001 size is:"
					+ tasks.size());
			System.out.println("===only in update mode test  begin===");

			System.out.println("++++++++begin createCombo");
			Combo c = new Combo();
			Kind k = new Kind();
			k.setKindName("险种1");
			k.setKindCode("abc");
			k.setComboCode("abc");
			c.setComboCode("abc");
			c.setKind(k);
			comboService.createCombo("001", c);
			System.out.println("++++++++finish createCombo");
			List<Combo> results = comboService
					.getCombos_StepOne("condation rule");
			Combo c_process = null;
			// 切面过滤后返回的结果
			for (Combo result : results) {
				c_process = result;
				System.out.println("\n combo:" + result.getComboCode() + "  "
						+ result.getKind().getComboCode());
			}
			System.out.println("@@@@@@@@begin  processCombo");
			System.out.println("----------------------step1------------------");
			comboService.processCombo_StepOne("abc", c);
			// 直接用第一次获取的combo给StepTwo和StepThree使用,应该在每一步调用前获取combo
			System.out.println("----------------------step2------------------");
			results = comboService.getCombos_StepTwo("condation rule");
			// 处理combo c , 应该是从results中选取一个
			comboService.processCombo_StepTwo("002", c);
			System.out.println("----------------------step3------------------");
			results = comboService.getCombos_StepThree("condation rule");
			// 处理combo c , 应该是从results中选取一个
			comboService.processCombo_StepThree("002", c);
			System.out.println("@@@@@@@@end  processCombo");
			Assert.assertNotNull(results);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
