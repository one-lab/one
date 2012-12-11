package com.sinosoft.one.bpm.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.SystemEventListenerFactory;
import org.drools.agent.KnowledgeAgent;
import org.drools.definition.process.Node;
import org.drools.definition.process.NodeContainer;
import org.drools.definition.process.WorkflowProcess;
import org.drools.impl.EnvironmentFactory;
import org.drools.persistence.jpa.JPAKnowledgeService;
import org.drools.runtime.Environment;
import org.drools.runtime.EnvironmentName;
import org.drools.runtime.KnowledgeSessionConfiguration;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.conf.ClockTypeOption;
import org.drools.runtime.process.WorkflowProcessInstance;
import org.jbpm.process.audit.JPAProcessInstanceDbLog;
import org.jbpm.process.audit.JPAWorkingMemoryDbLogger;
import org.jbpm.process.audit.NodeInstanceLog;
import org.jbpm.process.audit.ProcessInstanceLog;
import org.jbpm.process.workitem.wsht.SyncWSHumanTaskHandler;
import org.jbpm.task.TaskService;
import org.jbpm.task.query.TaskSummary;
import org.jbpm.task.service.TaskServiceSession;
import org.jbpm.task.service.local.LocalTaskService;
import org.springframework.orm.jpa.JpaTransactionManager;

import com.sinosoft.one.bpm.model.ActiveNodeInfo;
import com.sinosoft.one.bpm.model.DiagramInfo;
import com.sinosoft.one.bpm.model.DiagramNodeInfo;
import com.sinosoft.one.bpm.model.NodeInstanceLogComparator;

public class BpmServiceSupport {
	static Logger logger = Logger.getLogger(JbpmAPIUtil.class);

	private TaskService taskService;
	private StatefulKnowledgeSession ksession;
	private JPAProcessInstanceDbLog processInstanceDbLog;
	private JPAWorkingMemoryDbLogger dbLogger;
	private KnowledgeBase kbase;
	
	private ProcessInstanceBOCache cache;
	private EntityManagerFactory bpmEmf;
	private JpaTransactionManager bpmTxManager;


	public void init() {
		BpmEnvironment.bpmEmf = bpmEmf;
		BpmEnvironment.bpmTxManager = bpmTxManager;
		
		try {
			loadKnowledgeSession("drools.properties",
					BpmEnvironment.bpmEmf);
			getSession("drools.properties");
			getTaskService();
		} catch (Exception e) {
			logger.error("init BpmService exception.", e);
		}
	}
	
	public void destory() {
		try {
			if (taskService != null)
				taskService.disconnect();
			if (ksession != null)
				ksession.dispose();
			if (dbLogger != null)
				dbLogger.dispose();
			Thread.sleep(1000);
		} catch (Exception e) {
			logger.warn("destory jbpm instance exception.");
		}
	}
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
	private void createKnowledgeBase(String propertiesFilePath) {
		KnowledgeAgent kAgent = KnowledgeAgentGenerator
				.getKnowledgeAgent(propertiesFilePath);
		kbase = kAgent.getKnowledgeBase();
	}

	/**
	 * load session from database
	 * 
	 * @param process
	 * @param emf
	 * @return
	 */
	public StatefulKnowledgeSession loadKnowledgeSession(String process,
			EntityManagerFactory emf) {
		StatefulKnowledgeSession result = null;
		createKnowledgeBase(process);
		final KnowledgeSessionConfiguration conf = KnowledgeBaseFactory
				.newKnowledgeSessionConfiguration();
		Environment env = createEnvironment(emf);
		// 每次启动都加载第一个session
		try {
			result = JPAKnowledgeService.loadStatefulKnowledgeSession(1, kbase,
					conf, env);
			dbLogger = new JPAWorkingMemoryDbLogger(result);
			ksession = result;
		} catch (Exception e) {
			logger.warn("can not load session id =1");
		}
		return result;
	}

	private StatefulKnowledgeSession createKnowledgeSession(
			String propertiesFilePath, EntityManagerFactory emf) {
		createKnowledgeBase(propertiesFilePath);
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
	public StatefulKnowledgeSession getSession(String propertiesFilePath)
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
			ksession = createKnowledgeSession(propertiesFilePath,
					bpmEmf);
		}
		return ksession;
	}

	/**
	 * get a task server
	 * 
	 * @return
	 * @throws Exception
	 */
	public TaskService getTaskService() throws Exception {
		if (taskService == null) {
			org.jbpm.task.service.TaskService tservice = getService(bpmEmf);
			if (ksession == null) {
				ksession = getSession("drools.properties");
			}
			taskService = getTskService(ksession, tservice, bpmEmf);
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
	public StatefulKnowledgeSession createKnowledgeSession(
			KnowledgeBase kbase, EntityManagerFactory emf) {
		StatefulKnowledgeSession result;
		final KnowledgeSessionConfiguration conf = KnowledgeBaseFactory
				.newKnowledgeSessionConfiguration();
		ClockTypeOption.get("realtime");
		Environment env = createEnvironment(emf);
		result = JPAKnowledgeService.newStatefulKnowledgeSession(kbase, conf,
				env);
		dbLogger = new JPAWorkingMemoryDbLogger(result);
		return result;
	}

	/**
	 * create Environment and set some attributes
	 * 
	 * @param emf
	 * @return
	 */
	private Environment createEnvironment(EntityManagerFactory emf) {
		Environment env = EnvironmentFactory.newEnvironment();
		env.set(EnvironmentName.ENTITY_MANAGER_FACTORY, BpmEnvironment.bpmEmf);
		env.set(EnvironmentName.TRANSACTION_MANAGER,
				BpmEnvironment.bpmTxManager);
		if(processInstanceDbLog == null) {
			processInstanceDbLog = new JPAProcessInstanceDbLog(env);
		}
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
	public TaskService getTskService(StatefulKnowledgeSession ksession,
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
		/*
		 * HornetQHTWorkItemHandler humanTaskHandler = new
		 * HornetQHTWorkItemHandler(ksession); humanTaskHandler.setLocal(true);
		 * humanTaskHandler.connect();
		 * ksession.getWorkItemManager().registerWorkItemHandler("Human Task",
		 * humanTaskHandler);
		 * 
		 * return new LocalTaskService(taskService);
		 */

	}

	/**
	 * get a service that contains task session
	 * 
	 * @param emf
	 * @return
	 */
	public org.jbpm.task.service.TaskService getService(
			EntityManagerFactory emf) {
		return new org.jbpm.task.service.TaskService(emf,
				SystemEventListenerFactory.getSystemEventListener());
	}
	
	public String getBusinessId(long processInstanceId) throws Exception {
		String businessId = cache.getBusinessId(processInstanceId);
		if(StringUtils.isBlank(businessId)) {
			WorkflowProcessInstance wpi = (WorkflowProcessInstance) getSession("drools.properties").getProcessInstance(
					processInstanceId);
			if (wpi != null) {
				businessId = (String) wpi.getVariable("businessId");
				if(StringUtils.isNotBlank(businessId)) {
					cache.put(wpi.getProcessId(), businessId, processInstanceId);
				}
			}
		}
		return businessId;
	}
	
	public List<String> getBusinessIds(String userId) throws Exception {
		List<String> results = new ArrayList<String>();
		List<TaskSummary> tasks = getTasks(userId);
		for (TaskSummary task : tasks) {
            String businessId = getBusinessId(task.getProcessInstanceId());
            if (StringUtils.isNotBlank(businessId)) {
                results.add(businessId);
            }
        }
		return results;
	}
	
	public List<TaskSummary> getTasks(String userId) throws Exception {
		TaskService taskService = getTaskService();
		List<TaskSummary> tasks = taskService.getTasksAssignedAsPotentialOwner(
				userId, "en-UK");
		return tasks;
	}

	public List<ActiveNodeInfo> getActiveNodeInfo(String processId, String businessId) {
		Long instanceId = cache.getProcessInstanceId(processId, businessId);
		if (instanceId == null) {
			throw new IllegalArgumentException(
					"Could not find process instance by [ " + processId + ", " + businessId + " ]" );
		}
		ProcessInstanceLog processInstance = processInstanceDbLog
				.findProcessInstance(instanceId);
		if (processInstance == null) {
			throw new IllegalArgumentException(
					"Could not find process instance by instance id : " + instanceId);
		}
		Map<String, NodeInstanceLog> nodeInstances = new HashMap<String, NodeInstanceLog>();
		List<NodeInstanceLog> nodeInstanceList = processInstanceDbLog.findNodeInstances(instanceId);
		Collections.sort(nodeInstanceList, new NodeInstanceLogComparator());
		for (NodeInstanceLog nodeInstance : nodeInstanceList) {
			if (nodeInstance.getType() == NodeInstanceLog.TYPE_ENTER) {
				nodeInstances.put(nodeInstance.getNodeInstanceId(),
						nodeInstance);
			} else {
				nodeInstances.remove(nodeInstance.getNodeInstanceId());
			}
		}
		if (!nodeInstances.isEmpty()) {
			List<ActiveNodeInfo> result = new ArrayList<ActiveNodeInfo>();
			for (NodeInstanceLog nodeInstance : nodeInstances.values()) {
				boolean found = false;
				DiagramInfo diagramInfo = getDiagramInfo(processInstance
						.getProcessId());
				if (diagramInfo != null) {
					for (DiagramNodeInfo nodeInfo : diagramInfo.getNodeList()) {
						if (nodeInfo.getName().equals(
								"id=" + nodeInstance.getNodeId())) {
							result.add(new ActiveNodeInfo(diagramInfo
									.getWidth(), diagramInfo.getHeight(),
									nodeInfo));
							found = true;
							break;
						}
					}
				} else {
					throw new IllegalArgumentException(
							"Could not find info for diagram for process "
									+ processInstance.getProcessId());
				}
				if (!found) {
					throw new IllegalArgumentException(
							"Could not find info for node "
									+ nodeInstance.getNodeId() + " of process "
									+ processInstance.getProcessId());
				}
			}
			return result;
		}
		return null;
	}

	public DiagramInfo getDiagramInfo(String processId) {
		org.drools.definition.process.Process process = kbase
				.getProcess(processId);
		if (process == null) {
			return null;
		}

		DiagramInfo result = new DiagramInfo();
		// TODO: diagram width and height?
		result.setWidth(932);
		result.setHeight(541);
		List<DiagramNodeInfo> nodeList = new ArrayList<DiagramNodeInfo>();
		if (process instanceof WorkflowProcess) {
			addNodesInfo(nodeList, ((WorkflowProcess) process).getNodes(),
					"id=");
		}
		result.setNodeList(nodeList);
		return result;
	}

	private void addNodesInfo(List<DiagramNodeInfo> nodeInfos,
			Node[] nodes, String prefix) {
		for (Node node : nodes) {
			nodeInfos.add(new DiagramNodeInfo(prefix + node.getId(),
					(Integer) node.getMetaData().get("x"), (Integer) node
							.getMetaData().get("y"), (Integer) node
							.getMetaData().get("width"), (Integer) node
							.getMetaData().get("height")));
			if (node instanceof NodeContainer) {
				addNodesInfo(nodeInfos, ((NodeContainer) node).getNodes(),
						prefix + node.getId() + ":");
			}
		}
	}

	public void setCache(ProcessInstanceBOCache cache) {
		this.cache = cache;
	}

	public void setBpmEmf(EntityManagerFactory bpmEmf) {
		this.bpmEmf = bpmEmf;
	}

	public void setBpmTxManager(JpaTransactionManager bpmTxManager) {
		this.bpmTxManager = bpmTxManager;
	}

}
