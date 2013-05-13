package com.sinosoft.one.bpm.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.jbpm.task.query.TaskSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;

import com.sinosoft.one.bpm.service.facade.BpmService;
import com.sinosoft.one.bpm.util.BpmCommonUtils;
import com.sinosoft.one.bpm.variable.VariableScope;

/**
 *
 * @author carvin
 *
 */
//@Aspect
public class TaskAspect implements Ordered{
    @Autowired
	private BpmService bpmService;
    
//    public static void setBpmSerivce(BpmService bpmService) {
//    	TaskAspect.bpmService = bpmService;
//    }
    private Logger logger = Logger.getLogger(TaskAspect.class);
    
    
    /**
     * Description:拦截标记有GetTask注解的方法,对被拦截方法返回的列表进行过滤,只返回属于该userId的业务任务。
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
//    @Around("execution(@GetTask * com.sinosoft.one.bpm.test.service.spring.*.*(..))")
    public Object getTask(ProceedingJoinPoint pjp) throws Throwable {
    	Object result = pjp.proceed();
    	
    	logger.info("into getTask aspect");
        GetTask getTask = parserAnnotation(pjp, GetTask.class);
        String userId = getTask.userId();
        if(StringUtils.isBlank(userId)) {
        	int userIdBeanOffset = getTask.userIdBeanOffset();
        	if(userIdBeanOffset == -1) {
        		throw new IllegalArgumentException("getTask annotation must assign userId or userIdBeanOffset.");
        	}
        	userId = (String)BpmCommonUtils.parseAttributeValue(pjp.getArgs()[userIdBeanOffset], getTask.userIdAttributeName());
        }
        String businessIdAttributeName = getTask.businessIdAttributeName();
        if(StringUtils.isBlank(businessIdAttributeName)) {
        	throw new IllegalArgumentException("@getTask's property[businessIdAttributeName]  can't be empty .");
        }
        List<TaskSummary> tasks = bpmService.getTasks(userId);
        HashMap<String, String> taskAndBusiness = new HashMap<String, String>();
        for (TaskSummary task : tasks) {
            String businessId = bpmService.getBusinessId(task
                    .getProcessInstanceId());
            if (StringUtils.isNotBlank(businessId)) {
                taskAndBusiness.put(businessId, String.valueOf(task.getId()));
            }
        }
        
        Iterator<?> it = getIterator(result);
        String realBusinessIdAttributeName = businessIdAttributeName;
        if(it == null) {
        	String[] attributeNames = businessIdAttributeName.split("\\.");
        	int len = attributeNames.length;
        	realBusinessIdAttributeName = attributeNames[len-1].trim();
        	Object tempResult = result;
        	String currentAttributeName = "";
        	for(int i=0; i<len-1; i++) {
        		currentAttributeName = attributeNames[i];
        		tempResult = PropertyUtils.getProperty(tempResult, currentAttributeName);
        	}
        	it = getIterator(tempResult);
    		if(it == null) {
    			throw new IllegalArgumentException("the property [" + currentAttributeName + "]' value must be Collection or Map.");
    		}
        }
       
        while (it.hasNext()) {
            Object bean = it.next();
            String businessId = parserBusinessId(bean,
            		realBusinessIdAttributeName);
            if (!taskAndBusiness.containsKey(businessId)) {
                it.remove();
            }
        }
        logger.info("out getTask aspect");
        return result;
    }
    
    private Iterator<?> getIterator(Object target) {
    	Iterator<?> it = null;
    	 if(target instanceof List) {
         	it = ((List<?>) target).iterator();
         } else if(target instanceof Set) {
         	it = ((Set<?>) target).iterator();
         } else if(target instanceof Map) {
         	Collection<?> values = ((Map<?, ?>) target).values();
         	it = values != null ? values.iterator() : null;
         } 
    	 return it;
    }

    /**
     * Description:拦截标记有ProcessTask注解的方法,并用bpmService开启和提交任务。 当被拦截方法出现异常时,回退任务。
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
//    @Around("execution(@ProcessTask * com.sinosoft.one.bpm.test.service.spring.*.*(..))")
    public Object processTask(ProceedingJoinPoint pjp) throws Throwable {
    	StartProcess startProcess = parserAnnotation(pjp, StartProcess.class);
    	if(startProcess != null) {
    		return pjp.proceed();
    	}
    	Object result = pjp.proceed();
    	
    	// 处理变量
    	Variables variablesAnnotation = parserAnnotation(pjp, Variables.class);
        Variable variableAnnotation = parserAnnotation(pjp, Variable.class);
        doVariables(variablesAnnotation, variableAnnotation, pjp.getArgs());
        
    	processTaskHandler(pjp);
    	return result;
    	
    }
    
    private void processTaskHandler(ProceedingJoinPoint pjp) throws Throwable {
    	logger.info("into processTask aspect");
        ProcessTask processTask = parserAnnotation(pjp, ProcessTask.class);
        if(processTask == null) return;
        Object[] args = pjp.getArgs();
        Object bean = args[processTask.businessBeanOffset()];
        String businessId = parserBusinessId(bean,
                processTask.businessIdAttributeName());
        String userId = processTask.userId();
        if(StringUtils.isBlank(userId)) {
        	int userIdBeanOffset = processTask.userIdBeanOffset();
        	if(userIdBeanOffset == -1) {
        		throw new IllegalArgumentException("processTask annotation must assign userId or userIdBeanOffset.");
        	}
        	userId = (String)BpmCommonUtils.parseAttributeValue(pjp.getArgs()[userIdBeanOffset], processTask.userIdAttributeName());
        }
        
        
        Map<String, Object> paramData = new HashMap<String, Object>();
        TaskParams taskParamsAnnotation = parserAnnotation(pjp, TaskParams.class);
        if(taskParamsAnnotation != null) {
        	TaskParam[] taskParams = taskParamsAnnotation.taskParams();
        	if(taskParams != null) {
        		for(TaskParam taskParam : taskParams) {
        			addParam(paramData, taskParam, args);
        		}
        	}
        } else {
        	TaskParam taskParam = parserAnnotation(pjp, TaskParam.class);
        	if(taskParam != null) {
        		addParam(paramData, taskParam, args);
        	}
        }
        
        long taskId = bpmService.getTaskId(userId, businessId);
        
        try {
        	bpmService.startTask(taskId, userId);
        } catch (Exception e) {
            bpmService.releaseTask(taskId, userId);
            logger.info("releaseTask taskId="+taskId+"  userId="+userId);
            throw new RuntimeException(e);
        }   
        bpmService.submitTask(taskId, userId, paramData);
        logger.info("out processTask aspect");
    }
    
    private void addParam(Map<String, Object> paramData, TaskParam taskParam, Object[] args) throws Exception {
    	String key = taskParam.key();
		if(StringUtils.isNotBlank(key)) {
			paramData.put(key, BpmCommonUtils.parseAttributeValue(args[taskParam.paramValueBeanOffset()], taskParam.paramValueAttributeName()));
		}
    }
    
    /**
     * 处理全局变量
     * @param globalVariables
     * @param globalVariable
     * @param args
     * @throws Exception
     */
    private void doVariables(Variables variables, Variable variable, Object[] args) throws Exception {
    	List<Variable> variableList = new ArrayList<Variable>();
    	if(variables != null) {
    		variableList.addAll(Arrays.asList(variables.variables()));
    	}
    	if(variable != null) {
    		variableList.add(variable);
    	}
    	doVariables(variableList, args);
    	
    }
    
    private void doVariables(List<Variable> variableList, Object[] args)  throws Exception {
    	for(Variable aVariable : variableList) {
    		bpmService.doVariable(args, aVariable);
    	}
    }

    
    /**
     * Description:拦截标记有StartProcess注解的方法,并用bpmService创建流程
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
//    @Around("execution(@StartProcess * com.sinosoft.one.bpm.test.service.spring.*.*(..))")
    public Object startProcess(ProceedingJoinPoint pjp) throws Throwable {
    	Object result = pjp.proceed();
    	
        logger.info("into startProcess aspect");
        
     // 处理全局变量
        Variables variablesAnnotation = parserAnnotation(pjp, Variables.class);
        Variable variableAnnotation = parserAnnotation(pjp, Variable.class);
        
        List<Variable> globalVaribles = new ArrayList<Variable>();
        List<Variable> processInstanceVaribles = new ArrayList<Variable>();
        
        if(variablesAnnotation != null) {
        	Variable[] variables = variablesAnnotation.variables();
            if(variables != null) {
            	for(Variable variable : variables) {
            		if(variable.scope() == VariableScope.GLOBAL) {
            			globalVaribles.add(variable);
            		} else {
            			processInstanceVaribles.add(variable);
            		}
            	}
            }
        }
        
        if(variableAnnotation != null) {
	        if(variableAnnotation.scope() == VariableScope.GLOBAL) {
				globalVaribles.add(variableAnnotation);
			} else {
				processInstanceVaribles.add(variableAnnotation);
			}
        }
        
        // 处理全局变量
        doVariables(globalVaribles, pjp.getArgs());
        
        StartProcess startProcess = parserAnnotation(pjp, StartProcess.class);
        Object bean = pjp.getArgs()[startProcess.businessBeanOffset()];
        String businessId = parserBusinessId(bean,
                startProcess.businessIdAttributeName());
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("businessId", businessId);
        bpmService.createProcess(startProcess.processId(), params);
        
     // 处理流程变量
        doVariables(processInstanceVaribles, pjp.getArgs());
        
        // 如果需要流程启动直接处理第一个节点
        processTaskHandler(pjp);
        logger.info("out startProcess aspect");

        return result;
    }

    /**
     * Description:解析业务bean中的id
     *
     * @param bean
     * @param attibuteName
     * @return
     * @throws Exception
     */
    public String parserBusinessId(Object bean, String attributeName)
            throws Exception {
        return (String)BpmCommonUtils.parseAttributeValue(bean, attributeName);
    }
    
    /**
     * Description:解析注解
     *
     * @param <T>
     * @param pjp
     * @param annotationClass
     * @return
     * @throws Exception
     */
    public <T extends Annotation> T parserAnnotation(ProceedingJoinPoint pjp,
                                                     Class<T> annotationClass) throws Exception {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method m = signature.getMethod();
        if (Proxy.isProxyClass(pjp.getThis().getClass())) {
            m = pjp.getTarget().getClass()
                    .getMethod(m.getName(), m.getParameterTypes());
        }
        return (T) m.getAnnotation(annotationClass);
    }

	public int getOrder() {
		return 9999;
	}
}
