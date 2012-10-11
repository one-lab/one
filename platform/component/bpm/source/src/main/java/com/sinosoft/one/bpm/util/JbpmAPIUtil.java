package com.sinosoft.one.bpm.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.SystemEventListenerFactory;
import org.drools.agent.KnowledgeAgent;
import org.drools.impl.EnvironmentFactory;
import org.drools.persistence.jpa.JPAKnowledgeService;
import org.drools.runtime.Environment;
import org.drools.runtime.EnvironmentName;
import org.drools.runtime.KnowledgeSessionConfiguration;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.conf.ClockTypeOption;
import org.jbpm.process.audit.JPAWorkingMemoryDbLogger;
import org.jbpm.process.workitem.wsht.SyncWSHumanTaskHandler;
import org.jbpm.task.TaskService;
import org.jbpm.task.service.TaskServiceSession;
import org.jbpm.task.service.local.LocalTaskService;

public class JbpmAPIUtil {

	static Logger logger = Logger.getLogger(JbpmAPIUtil.class);

	public static TaskService taskService;
	public static StatefulKnowledgeSession ksession;
	public static EntityManagerFactory emf;

	/**
	 * Load and compile the bpmn file into knowledgebase
	 * 
	 * @param process
	 * @return
	 */
	// private static KnowledgeBase createKnowledgeBase(String process) {
	// KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
	// .newKnowledgeBuilder();
	//
	// kbuilder.add(ResourceFactory.newClassPathResource(process),
	// ResourceType.BPMN2);
	//
	// // Check for errors
	// if (kbuilder.hasErrors()) {
	// if (kbuilder.getErrors().size() > 0) {
	// boolean errors = false;
	// for (KnowledgeBuilderError error : kbuilder.getErrors()) {
	// logger.warn(error.toString());
	// errors = true;
	// }
	//
	// }
	// }
	// return kbuilder.newKnowledgeBase();
	// }

	/**
	 * create KnowledgeBase by agent
	 * 
	 * @param propertiesFilePath
	 * @return
	 */
	private static KnowledgeBase createKnowledgeBase(String propertiesFilePath) {
        KnowledgeAgent kAgent = KnowledgeAgentGenerator.getKnowledgeAgent(propertiesFilePath);
		KnowledgeBase kBase = kAgent.getKnowledgeBase();
		return kBase;
	}

	/**
	 * load session from database
	 * 
	 * @param process
	 * @param emf
	 * @return
	 */
	public static StatefulKnowledgeSession loadKnowledgeSession(String process,
			EntityManagerFactory emf) {
		StatefulKnowledgeSession result = null;
		KnowledgeBase kbase = createKnowledgeBase(process);
		final KnowledgeSessionConfiguration conf = KnowledgeBaseFactory
				.newKnowledgeSessionConfiguration();
		Environment env = createEnvironment(emf);
		// 每次启动都加载第一个session
		try {
			result = JPAKnowledgeService.loadStatefulKnowledgeSession(1, kbase,
					conf, env);
			ksession = result;
		} catch (Exception e) {
			logger.warn("can not load session id =1");
		}
		return result;
	}

	private static StatefulKnowledgeSession createKnowledgeSession(
			String propertiesFilePath, EntityManagerFactory emf) {
		KnowledgeBase kbase = createKnowledgeBase(propertiesFilePath);
		return createKnowledgeSession(kbase, emf);
	}

	/*
	 * * Create EntityManagerFactory and register it in the environment
	 */
	public static EntityManagerFactory getEmf(EntityManagerFactory emf) {
		emf = Persistence
				.createEntityManagerFactory("org.jbpm.persistence.jpa");
		return emf;
	}

	/**
	 * 获取session,如果没有创建,则创建一个
	 * 
	 * @param propertiesFilePath
	 * @return
	 * @throws Exception
	 */
	public static StatefulKnowledgeSession getSession(String propertiesFilePath)
			throws Exception {

		/*
		 * * Create EntityManagerFactory and register it in the environment
		 */
		// if (emf == null)
		// emf = Persistence
		// .createEntityManagerFactory("org.jbpm.persistence.jpa");

		/*
		 * Create the knowledge session that uses JPA to persists runtime state
		 */
		if (ksession == null) {
			ksession = JbpmAPIUtil.createKnowledgeSession(propertiesFilePath,
					emf);
		}
		return ksession;
	}

	/**
	 * get a task server
	 * 
	 * @return
	 * @throws Exception
	 */
	public static TaskService getTaskService() throws Exception {

		if (taskService == null) {
			org.jbpm.task.service.TaskService tservice = getService(emf);
            if (ksession == null) {
				ksession = getSession("drools.properties");
			}
			taskService = getTskService(ksession, tservice, emf);
			System.setProperty("jbpm.usergroup.callback",
					"org.jbpm.task.service.DefaultUserGroupCallbackImpl");
		}
		return taskService;
	}

	/**
	 * Create the knowledge session that uses JPA to persists runtime state
	 * 
	 * @param kbase
	 * @param emf
	 * @return
	 */
	public static StatefulKnowledgeSession createKnowledgeSession(
			KnowledgeBase kbase, EntityManagerFactory emf) {
		StatefulKnowledgeSession result;
		final KnowledgeSessionConfiguration conf = KnowledgeBaseFactory
				.newKnowledgeSessionConfiguration();
		ClockTypeOption.get("realtime");
		Environment env = createEnvironment(emf);
		result = JPAKnowledgeService.newStatefulKnowledgeSession(kbase, conf,
				env);
		new JPAWorkingMemoryDbLogger(result);
		return result;
	}

	/**
	 * create Environment and set some attributes
	 * 
	 * @param emf
	 * @return
	 */
	private static Environment createEnvironment(EntityManagerFactory emf) {
		Environment env = EnvironmentFactory.newEnvironment();
        env.set(EnvironmentName.ENTITY_MANAGER_FACTORY, BpmEnvironment.bpmEmf);
		env.set(EnvironmentName.TRANSACTION_MANAGER,
				BpmEnvironment.bpmTxManager);
		return env;
	}

	/**
	 * Get local task service as a server
	 * 
	 * @param ksession
	 * @param taskService
	 * @param emf
	 * @return
	 */
	public static TaskService getTskService(StatefulKnowledgeSession ksession,
			org.jbpm.task.service.TaskService taskService,
			EntityManagerFactory emf) {
		if (taskService == null) {
			taskService = new org.jbpm.task.service.TaskService(emf,
					SystemEventListenerFactory.getSystemEventListener());
		}
		TaskServiceSession taskServiceSession = taskService.createSession();
		/**
		 * TaskServiceSession自带缺省事务
		 */
		taskServiceSession.setTransactionType("default");
		SyncWSHumanTaskHandler humanTaskHandler = new SyncWSHumanTaskHandler(
				new LocalTaskService(taskServiceSession), ksession);
		humanTaskHandler.setLocal(true);
		humanTaskHandler.connect();
		ksession.getWorkItemManager().registerWorkItemHandler("Human Task",
				humanTaskHandler);
		return new LocalTaskService(taskServiceSession);
/*		HornetQHTWorkItemHandler humanTaskHandler = new HornetQHTWorkItemHandler(ksession);
		humanTaskHandler.setLocal(true);
		humanTaskHandler.connect();
		ksession.getWorkItemManager().registerWorkItemHandler("Human Task", humanTaskHandler);
		
		return new LocalTaskService(taskService);*/
		
	}

	/**
	 * get a service that contains task session
	 * 
	 * @param emf
	 * @return
	 */
	public static org.jbpm.task.service.TaskService getService(
			EntityManagerFactory emf) {
		return new org.jbpm.task.service.TaskService(emf,
				SystemEventListenerFactory.getSystemEventListener());
	}

 
}
