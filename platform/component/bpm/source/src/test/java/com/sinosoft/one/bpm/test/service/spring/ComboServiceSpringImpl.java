package com.sinosoft.one.bpm.test.service.spring;

import ins.framework.common.Page;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sinosoft.one.bpm.aspect.GetTask;
import com.sinosoft.one.bpm.aspect.ProcessTask;
import com.sinosoft.one.bpm.aspect.StartProcess;
import com.sinosoft.one.bpm.aspect.TaskParam;
import com.sinosoft.one.bpm.aspect.TaskParams;
import com.sinosoft.one.bpm.aspect.Variable;
import com.sinosoft.one.bpm.test.data.DataStore;
import com.sinosoft.one.bpm.test.data.StudentStore;
import com.sinosoft.one.bpm.test.domain.Combo;
import com.sinosoft.one.bpm.test.domain.Student;
import com.sinosoft.one.bpm.test.jndi.Jndis;
import com.sinosoft.one.bpm.test.service.facade.ComboService;
import com.sinosoft.one.bpm.util.JbpmAPIUtil;
import com.sinosoft.one.bpm.variable.VariableOperate;
import com.sinosoft.one.bpm.variable.VariableScope;
import com.sinosoft.one.bpm.variable.VariableType;
import com.sinosoft.sysframework.reference.DBFactory;
import com.sinosoft.sysframework.reference.DBManager;

@Service
public class ComboServiceSpringImpl implements ComboService {
    @Autowired
    private StudentStore studentStore;
    @Autowired
    private DataStore dataStore;

    @Autowired
    private JdbcTemplate jdbcTemplate;

	public void init() {
		System.out.println("--------------init");
	}

	public ComboServiceSpringImpl() {
		System.out.println("--------------ComboServiceSpringImpl");
	}

	/**
	 * 支持嵌套
	 */
	@SuppressWarnings("unchecked")
	@GetTask(userIdBeanOffset=0, businessIdAttributeName = "result.comboCode")
	public Page getCombos(String userId, String condation) {
		System.out.println("--------------getCombos");
		List<Combo> results = dataStore.getCombos();
		System.out.println("resturn resutl size:" + results.size());
		Page page = new Page();
		page.getResult().addAll(results);
		return page;
	}

	
	@GetTask(userId = "combo004", businessIdAttributeName = "comboCode")
	public List<Combo> getCombosStepFour(String condation) {
		System.out.println("--------------getCombos");
		List<Combo> results = dataStore.getCombos();
		System.out.println("resturn resutl size:" + results.size());
		return results;
	}
	
	@GetTask(userId = "combo005", businessIdAttributeName = "comboCode")
	public List<Combo> getCombosStepFive(String condation) {
		System.out.println("--------------getCombos");
		List<Combo> results = dataStore.getCombos();
		System.out.println("resturn resutl size:" + results.size());
		return results;
	}

	/**
	 * 简单类型的解析属性
	 */
	@ProcessTask(userIdBeanOffset=0, businessBeanOffset = 1)
	@Variable(name = "mapData", scope = VariableScope.PROCESSINSTANCE, 
				type = VariableType.MAP, operate = VariableOperate.ADD,
				mapKey = "one", variableValue = "one",
				processId = "comboProcess", businessBeanOffset = 1)
	public void processComboStepOne(String userId, String comboCode, Combo c) {
		System.out.println("--------------processCombo_StepOne ");
	}

	/**
	 * 简单复合类型的解析属性
	 * @throws Exception 
	 */
	@ProcessTask(userId = "combo002", businessBeanOffset = 1, businessIdAttributeName = "comboCode")
	@TaskParams(taskParams={@TaskParam(key="isPassed", paramValueBeanOffset=2)})
//	@Variable(name="isPassed", scope=VariableScope.PROCESSINSTANCE, processId="comboProcess", businessBeanOffset=0, variableValueBeanOffset=2)
	public void processComboStepTwo(String comboCode, Combo c, String isPassed) throws Exception {
		System.out.println("--------------processCombo_StepTwo");
		System.out.print(((Map<String, Object>)JbpmAPIUtil.getProcessInstanceVariable("comboProcess", comboCode, "mapData")).get("one") + "++++++++++++");
	}

	/**
	 * 嵌套复合类型的解析属性
	 */
	@ProcessTask(userId = "combo003", businessBeanOffset = 1, businessIdAttributeName = "kind.comboCode")
	public void processComboStepThree(String comboCode, Combo c) {
		System.out.println("--------------processCombo_StepThree");
	}

	/**
	 *  
	 */
	@StartProcess(processId = "comboProcess", businessBeanOffset = 1, businessIdAttributeName = "comboCode")
	@Variable(name = "mapData", scope = VariableScope.PROCESSINSTANCE, variableValueBeanOffset=2, 
			processId = "comboProcess", businessBeanOffset = 1, businessIdAttributeName = "comboCode")
	public void createCombo(String comboCode, Combo c, Map<String, Object> mapData) {
		DBManager dbManager = null;
		try {
			if(c==null) System.out.println("c==null");
			dataStore.store(c);
            studentStore.saveStudent(new Student(UUID.randomUUID().toString().replaceAll("-", ""), "carvin"));
            
//            Jndis.bind();
            System.out.println(System.getProperty("user.dir") + File.separator +"src" + File.separator +"test"+ File.separator +"resources");

//            DBFactory.configure("/Volumes/LACIE/work/platform/gitPlatform/platform/component/bpm/source/src/test/resources/dbmanager-config.xml");
//            dbManager = new DBManager();
//    		dbManager.open("myDataSource");
//    		dbManager.beginTransaction();
//    		dbManager.executeUpdate("update bpm_demo_student set name='2222' where id='cdefb6b1b9a24dd9a822bdcf313acd01'");
//    		dbManager.executeUpdate("update bpm_demo_student set name='22' where id='e8771e02850c4b3b9f08b7674864179c'");
//    		dbManager.commitTransaction();
//    		dbManager.close();
            jdbcTemplate.getDataSource().getConnection().setAutoCommit(false);
            jdbcTemplate.update("update bpm_demo_student set name='2222' where id='cdefb6b1b9a24dd9a822bdcf313acd01'");
            jdbcTemplate.update("update bpm_demo_student set name='22' where id='e8771e02850c4b3b9f08b7674864179c'");
            //jdbcTemplate.
		} catch (Exception e) {
			if(dbManager != null) {
				try {
					dbManager.rollbackTransaction();
				} catch (Exception e1) {
					throw new RuntimeException(e1);
				}
			}
			throw new RuntimeException(e);
		}

		System.out.println("------creat--------combo:" + comboCode);
        throw  new RuntimeException();
	}

    public Student findStudent(String id) {
        return studentStore.findStudent(id);
    }

    @ProcessTask(userId = "combo004", businessBeanOffset = 1, businessIdAttributeName = "comboCode")
    @Variable(name = "listData", scope = VariableScope.PROCESSINSTANCE, variableValueBeanOffset=2, 
	processId = "comboProcess", businessBeanOffset = 1, businessIdAttributeName = "comboCode")
	public void processComboStepFour(String comboCode, Combo c, List<String> listData) {
		System.out.println("--------------processCombo_StepFour");
	}

	public Combo getCombo(String comboCode) {
		return dataStore.getCombo(comboCode);
	}

	 @ProcessTask(userId = "combo005", businessBeanOffset = 1, businessIdAttributeName = "comboCode")
	public void processComboStepFive(String comboCode, Combo c) {
		
	}

}
