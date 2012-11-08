package com.sinosoft.one.bpm.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
import org.jbpm.process.audit.JPAProcessInstanceDbLog;
import org.jbpm.process.audit.JPAWorkingMemoryDbLogger;
import org.jbpm.process.audit.NodeInstanceLog;
import org.jbpm.process.audit.ProcessInstanceLog;
import org.jbpm.process.workitem.wsht.SyncWSHumanTaskHandler;
import org.jbpm.task.TaskService;
import org.jbpm.task.service.TaskServiceSession;
import org.jbpm.task.service.local.LocalTaskService;

import com.sinosoft.one.bpm.model.ActiveNodeInfo;
import com.sinosoft.one.bpm.model.DiagramInfo;
import com.sinosoft.one.bpm.model.DiagramNodeInfo;
import com.sinosoft.one.bpm.model.NodeInstanceLogComparator;

public class JbpmAPIUtil {

	static Logger logger = Logger.getLogger(JbpmAPIUtil.class);

	public static TaskService taskService;
	public static StatefulKnowledgeSession ksession;
	public static EntityManagerFactory emf;
	public static JPAWorkingMemoryDbLogger dbLogger;
	public static JPAProcessInstanceDbLog processInstanceDbLog;
	public static ConcurrentHashMap<String, Long> processInstanceIds = new ConcurrentHashMap<String, Long>();
	private static KnowledgeBase kbase;

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
	private static void createKnowledgeBase(String propertiesFilePath) {
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
	public static StatefulKnowledgeSession loadKnowledgeSession(String process,
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

	private static StatefulKnowledgeSession createKnowledgeSession(
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
		dbLogger = new JPAWorkingMemoryDbLogger(result);
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
	public static org.jbpm.task.service.TaskService getService(
			EntityManagerFactory emf) {
		return new org.jbpm.task.service.TaskService(emf,
				SystemEventListenerFactory.getSystemEventListener());
	}

	public static String getImageInfoes(String processId, String businessId,
			String imageUrl) {
		if (StringUtils.isBlank(processId)) {
			throw new IllegalArgumentException("the process id is not blank.");
		}
		if (StringUtils.isBlank(businessId)) {
			throw new IllegalArgumentException("the bussiness id is not blank.");
		}

		List<ActiveNodeInfo> activeNodeInfos = getActiveNodeInfo(processInstanceIds
				.get(businessId).toString());
		String s = "<div style='width:1024px; height:768px; background-color:#ffffff;'>"
				+ "<div id=\"imageContainer\" style=\"position:relative;top:-1;left:-1;\">"
				+ "<img src=\""
				+ imageUrl
				+ "\" style=\"position:absolute;top:0;left:0\" />";
		for (ActiveNodeInfo activeNodeInfo : activeNodeInfos) {

			s += "<div class=\"bpm-graphView-activityImage\" style=\"position:absolute;top:"
					+ (activeNodeInfo.getActiveNode().getY() - 8)
					+ "px;left:"
					+ (activeNodeInfo.getActiveNode().getX() - 8)
					+ "px;width:50px;height:50px; z-index:1000;background-image: url(images/play_red_big.png);background-repeat:no-repeat;\"></div>";
		}
		s += "</div>" + "</div>";
		return s;
	}

	public static List<ActiveNodeInfo> getActiveNodeInfo(String instanceId) {
		ProcessInstanceLog processInstance = processInstanceDbLog
				.findProcessInstance(new Long(instanceId));
		if (processInstance == null) {
			throw new IllegalArgumentException(
					"Could not find process instance " + instanceId);
		}
		Map<String, NodeInstanceLog> nodeInstances = new HashMap<String, NodeInstanceLog>();
		List<NodeInstanceLog> nodeInstanceList = processInstanceDbLog.findNodeInstances(new Long(instanceId));
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

	public static DiagramInfo getDiagramInfo(String processId) {
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

	private static void addNodesInfo(List<DiagramNodeInfo> nodeInfos,
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

}
