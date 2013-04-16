package com.sinosoft.one.bpm.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.SystemEventListenerFactory;
import org.drools.agent.KnowledgeAgent;
import org.drools.definition.process.Node;
import org.drools.definition.process.NodeContainer;
import org.drools.definition.process.WorkflowProcess;
import org.drools.event.process.ProcessEventListener;
import org.drools.impl.EnvironmentFactory;
import org.drools.persistence.TransactionManager;
import org.drools.persistence.jpa.JPAKnowledgeService;
import org.drools.runtime.Environment;
import org.drools.runtime.EnvironmentName;
import org.drools.runtime.KnowledgeSessionConfiguration;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.conf.ClockTypeOption;
import org.drools.runtime.process.ProcessInstance;
import org.drools.runtime.process.WorkflowProcessInstance;
import org.jbpm.process.audit.JPAProcessInstanceDbLog;
import org.jbpm.process.audit.JPAWorkingMemoryDbLogger;
import org.jbpm.process.audit.NodeInstanceLog;
import org.jbpm.process.audit.ProcessInstanceLog;
import org.jbpm.process.workitem.wsht.LocalHTWorkItemHandler;
import org.jbpm.task.TaskService;
import org.jbpm.task.identity.UserGroupCallbackManager;
import org.jbpm.task.query.TaskSummary;
import org.jbpm.task.service.local.LocalTaskService;
import org.jbpm.task.service.persistence.TaskSessionSpringFactoryImpl;
import org.jbpm.task.utils.OnErrorAction;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;

import com.sinosoft.one.bpm.model.ActiveNodeInfo;
import com.sinosoft.one.bpm.model.DiagramInfo;
import com.sinosoft.one.bpm.model.DiagramNodeInfo;
import com.sinosoft.one.bpm.model.NodeInstanceLogComparator;
import com.sinosoft.one.bpm.service.facade.ProcessInstanceBOService;
import com.sinosoft.one.bpm.service.spring.ProcessInstanceBOServiceSupport;

public class BpmServiceSupport {
	static Logger logger = Logger.getLogger(JbpmAPIUtil.class);

	private TaskService taskService;
	private StatefulKnowledgeSession ksession;
	private JPAWorkingMemoryDbLogger dbLogger;
	private KnowledgeBase kbase;
	
	private ProcessInstanceBOCache cache;
	private EntityManagerFactory bpmEMF;
	private AbstractPlatformTransactionManager bpmTxManager;
	private ProcessEventListener bpmProcessEventListener;
	private ProcessInstanceBOService processInstanceBOService;
	private boolean useJTA;
	
	private Environment env;

	public void init() {
		try {
			loadKnowledgeSession("drools.properties");
			getSession("drools.properties");
			getTaskService();
			initServiceInstances();
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
	public void loadKnowledgeSession(String process) {
		createKnowledgeBase(process);
		final KnowledgeSessionConfiguration conf = KnowledgeBaseFactory
				.newKnowledgeSessionConfiguration();
		createEnvironment();
		// 每次启动都加载第一个session
		try {
			ksession = JPAKnowledgeService.loadStatefulKnowledgeSession(1, kbase,
					conf, env);
			if(ksession == null) {
				ksession = createKnowledgeSession("drools.properties");
			}
			dbLogger = new JPAWorkingMemoryDbLogger(ksession);
		} catch (Exception e) {
			logger.warn("can not load session id =1");
		}
	}

	private StatefulKnowledgeSession createKnowledgeSession(
			String propertiesFilePath) {
		createKnowledgeBase(propertiesFilePath);
		return createKnowledgeSession();
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
		if (ksession == null) {
			ksession = createKnowledgeSession(propertiesFilePath);
			if(bpmProcessEventListener == null) {
				initServiceInstances();
			} else {
				ksession.addEventListener(bpmProcessEventListener);
			}
		}
		return ksession;
	}
	
	/**
	 * 获取session,如果没有创建,则创建一个
	 * 
	 * @param propertiesFilePath
	 * @return
	 * @throws Exception
	 */
	public StatefulKnowledgeSession getSession()
			throws Exception {
		return getSession("drools.properties");
	}

	/**
	 * get a task server
	 * 
	 * @return
	 * @throws Exception
	 */
	public TaskService getTaskService() throws Exception {
		if (taskService == null) {
			org.jbpm.task.service.TaskService tservice = getService();
			taskService = getTskService(tservice);
			System.setProperty(UserGroupCallbackManager.USER_GROUP_CALLBACK_KEY, "com.sinosoft.one.bpm.identity.BpmDefaultUserGroupCallback");
//			System.setProperty(UserGroupCallbackManager.USER_GROUP_CALLBACK_KEY, "org.jbpm.task.identity.DefaultUserGroupCallbackImpl");
//			System.setProperty("jbpm.user.group.mapping", "classpath:/roles.properties");
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
	public StatefulKnowledgeSession createKnowledgeSession() {
		StatefulKnowledgeSession result;
		final KnowledgeSessionConfiguration conf = KnowledgeBaseFactory
				.newKnowledgeSessionConfiguration();
		ClockTypeOption.get("realtime");
		createEnvironment();
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
	private void createEnvironment() {
		env = EnvironmentFactory.newEnvironment();  
		env.set(EnvironmentName.ENTITY_MANAGER_FACTORY, bpmEMF);     
		env.set(EnvironmentName.TRANSACTION_MANAGER, bpmTxManager);
		JPAProcessInstanceDbLog.setEnvironment(env);
	}

	/**
	 * Get local task service as a server
	 * 
	 * @param ksession
	 * @param taskService
	 * @param emf
	 * @return
	 */
	public TaskService getTskService(org.jbpm.task.service.TaskService taskService) {
		if (taskService == null) {
			taskService = getService();
		}
		
		LocalTaskService localTaskService = new LocalTaskService(taskService);
		LocalHTWorkItemHandler humanTaskHandler = new LocalHTWorkItemHandler(localTaskService, ksession, OnErrorAction.RETHROW);
		humanTaskHandler.connect();
		ksession.getWorkItemManager().registerWorkItemHandler("Human Task", humanTaskHandler);
		
		return localTaskService;
	}

	/**
	 * get a service that contains task session
	 * 
	 * @param emf
	 * @return
	 */
	public org.jbpm.task.service.TaskService getService() {
		org.jbpm.task.service.TaskService taskService = new org.jbpm.task.service.TaskService();
		//bpmEMF, SystemEventListenerFactory.getSystemEventListener()
		taskService.setSystemEventListener(SystemEventListenerFactory.getSystemEventListener());
		TaskSessionSpringFactoryImpl taskSessionSpringFactory = new TaskSessionSpringFactoryImpl();
		taskSessionSpringFactory.setEntityManagerFactory(bpmEMF);
		taskSessionSpringFactory.setTransactionManager((TransactionManager) env.get(EnvironmentName.TRANSACTION_MANAGER));
		taskService.setTaskSessionFactory(taskSessionSpringFactory);
		taskSessionSpringFactory.setTaskService(taskService);
		taskSessionSpringFactory.setUseJTA(useJTA);
		
		taskService.initialize();
		return taskService;
	}
	
	public void initServiceInstances() {
		if(processInstanceBOService == null) {
			TransactionManager tm = (TransactionManager) env.get(EnvironmentName.TRANSACTION_MANAGER);
			processInstanceBOService = new ProcessInstanceBOServiceSupport(bpmEMF, tm, useJTA);
		} 
		if(cache == null) {
			cache = new ProcessInstanceBOCache(processInstanceBOService);
		}
		if(bpmProcessEventListener == null) {
			bpmProcessEventListener = new BpmProcessEventListener(cache);
		}
		ksession.addEventListener(bpmProcessEventListener);
	}
	
	public Object getGlobalVariable(String variableName) throws Exception {
		return getSession().getGlobal(variableName);
	}
	
	public void setGlobalVariable(String variableName, Object variableValue) throws Exception {
		getSession().setGlobal(variableName, variableValue);
	}
	
	public Object getProcessInstanceVariable(String processId, String businessId, String variableName) throws Exception {
		ProcessInstance pi = getSession().getProcessInstance(getProcessInstanceId(processId, businessId));
		if(pi instanceof WorkflowProcessInstance) {
			return ((WorkflowProcessInstance)pi).getVariable(variableName);
		}
		return null;
	}
	
	public void setProcessInstanceVariable(String processId, String businessId, String variableName, Object variableValue) throws Exception {
		TransactionManager tx = null;
		tx = (TransactionManager) env.get(EnvironmentName.TRANSACTION_MANAGER);
		boolean transactionOwner = false;
		transactionOwner = tx.begin();
		try {
			ProcessInstance pi = getSession().getProcessInstance(getProcessInstanceId(processId, businessId));
			if(pi instanceof WorkflowProcessInstance) {
					((WorkflowProcessInstance)pi).setVariable(variableName, variableValue);
			}
			tx.commit(transactionOwner);
		} catch(Throwable t) {
			if(tx != null) {
				tx.rollback(transactionOwner);
			} 
			throw new RuntimeException(t);
		}
	}
	
	public String getBusinessId(long processInstanceId) throws Exception {
		String businessId = cache.getBusinessId(processInstanceId);
		if(StringUtils.isBlank(businessId)) {
			ProcessInstance processInstance = getSession("drools.properties").getProcessInstance(processInstanceId);
			if(processInstance instanceof WorkflowProcessInstance) {
				WorkflowProcessInstance wpi = (WorkflowProcessInstance) processInstance;
				if (wpi != null) {
					businessId = (String) wpi.getVariable("businessId");
					if(StringUtils.isNotBlank(businessId)) {
						cache.putAndSave(wpi.getProcessId(), businessId, processInstanceId);
					}
				}
			}
		}
		return businessId;
	}
	
	public List<String> getBusinessIds(String userId) throws Exception {
		List<String> results = new ArrayList<String>();
		List<TaskSummary> tasks = getTasks(userId);
		if(tasks != null && tasks.size() > 0) {
			for (TaskSummary task : tasks) {
	            String businessId = getBusinessId(task.getProcessInstanceId());
	            if (StringUtils.isNotBlank(businessId)) {
	                results.add(businessId);
	            }
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

	public long getProcessInstanceId(String processId, String businessId) {
		Long instanceId = cache.getProcessInstanceId(processId, businessId);
		if (instanceId == null) {
			List<ProcessInstanceLog> processInstanceLogs = JPAProcessInstanceDbLog.findActiveProcessInstances(processId);
			for(ProcessInstanceLog tempProcessInstanceLog : processInstanceLogs) {
				Long processInstanceId = tempProcessInstanceLog.getProcessInstanceId();
				ProcessInstance targetProcessInstance = ksession.getProcessInstance(processInstanceId);
				if(targetProcessInstance instanceof WorkflowProcessInstance) {
					WorkflowProcessInstance wpi = (WorkflowProcessInstance) targetProcessInstance;
					String targetBusinessId = (String)wpi.getVariable("businessId");
					if(businessId.equals(targetBusinessId)) {
						instanceId = processInstanceId;
						cache.putAndSave(processId, businessId, processInstanceId);
						break;
					}
				}
				
			}
		} 
		return instanceId == null ? -1 : instanceId;
	}
	
	public List<ActiveNodeInfo> getActiveNodeInfo(String processId, String businessId) {
		Long instanceId = getProcessInstanceId(processId, businessId);
		ProcessInstanceLog processInstanceLog = JPAProcessInstanceDbLog.findProcessInstance(instanceId);
		if (processInstanceLog == null) {
			throw new IllegalArgumentException(
					"Could not find process instance by instance id : " + instanceId);
		}
		Map<String, NodeInstanceLog> nodeInstances = new HashMap<String, NodeInstanceLog>();
		List<NodeInstanceLog> nodeInstanceList = JPAProcessInstanceDbLog.findNodeInstances(instanceId);
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
				DiagramInfo diagramInfo = getDiagramInfo(processInstanceLog
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
									+ processInstanceLog.getProcessId());
				}
				if (!found) {
					throw new IllegalArgumentException(
							"Could not find info for node "
									+ nodeInstance.getNodeId() + " of process "
									+ processInstanceLog.getProcessId());
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

	public void setBpmProcessEventListener(
			ProcessEventListener bpmProcessEventListener) {
		this.bpmProcessEventListener = bpmProcessEventListener;
	}

	public void setBpmEMF(EntityManagerFactory bpmEMF) {
		this.bpmEMF = bpmEMF;
	}

	public void setBpmTxManager(AbstractPlatformTransactionManager bpmTxManager) {
		this.bpmTxManager = bpmTxManager;
	}
	
	public Environment currentEnvironment() {
		return env;
	}

	public boolean isUseJTA() {
		return useJTA;
	}

	public void setUseJTA(boolean useJTA) {
		this.useJTA = useJTA;
	}
	
	
}
