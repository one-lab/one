package com.sinosoft.one.bpm.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.bpm.service.facade.BpmService;

/**
 *
 * @author zhujinwei
 *
 */
public class TaskAspect {
    @Autowired
    private BpmService bpmService;
    private Logger logger = Logger.getLogger(TaskAspect.class);
    
    /**
     * Description:拦截标记有GetTask注解的方法,对被拦截方法返回的列表进行过滤,只返回属于该userId的业务任务。
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    public Object getTask(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("into getTask aspect");
        GetTask getTask = parserAnnotation(pjp, GetTask.class);
        String userId = getTask.userId();
        if(StringUtils.isBlank(userId)) {
        	int userIdBeanOffset = getTask.userIdBeanOffset();
        	if(userIdBeanOffset == -1) {
        		throw new IllegalArgumentException("getTask annotation must assign userId or userIdBeanOffset.");
        	}
        	userId = this.parserAttributeValue(pjp.getArgs()[userIdBeanOffset], getTask.userIdAttributeName());
        }
        String businessIdAttributeName = getTask.businessIdAttibuteName();
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
        
        Object result = pjp.proceed();
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
    public Object processTask(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("into processTask aspect");
        ProcessTask processTask = parserAnnotation(pjp, ProcessTask.class);
        Object[] args = pjp.getArgs();
        Object bean = args[processTask.businessBeanOffset()];
        String businessId = parserBusinessId(bean,
                processTask.businessIdAttibuteName());
        String userId = processTask.userId();
        if(StringUtils.isBlank(userId)) {
        	int userIdBeanOffset = processTask.userIdBeanOffset();
        	if(userIdBeanOffset == -1) {
        		throw new IllegalArgumentException("processTask annotation must assign userId or userIdBeanOffset.");
        	}
        	userId = this.parserAttributeValue(pjp.getArgs()[userIdBeanOffset], processTask.userIdAttributeName());
        }
        Object result = null;
        
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
        bpmService.startTask(taskId, userId);
        try {
            result = pjp.proceed();
        } catch (Exception e) {
            bpmService.releaseTask(taskId, userId);
            logger.info("releaseTask taskId="+taskId+"  userId="+userId);
            throw e;
        }   
        
        bpmService.submitTask(taskId, userId, paramData);
        logger.info("out processTask aspect");
        return result;
    }
    
    private void addParam(Map<String, Object> paramData, TaskParam taskParam, Object[] args) throws Exception {
    	String key = taskParam.key();
		if(StringUtils.isNotBlank(key)) {
			paramData.put(key, parserAttributeValue(args[taskParam.paramValueBeanOffset()], taskParam.paramValueAttributeName()));
		}
    }

    /**
     * Description:拦截标记有StartProcess注解的方法,并用bpmService创建流程
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    public Object startProcess(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("into processTask aspect");
        StartProcess startProcess = parserAnnotation(pjp, StartProcess.class);
        Object bean = pjp.getArgs()[startProcess.businessBeanOffset()];
        String businessId = parserBusinessId(bean,
                startProcess.businessIdAttibuteName());
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("businessId", businessId);
        Object result = pjp.proceed();
        bpmService.createProcess(startProcess.processId(), params);
        logger.info("out processTask aspect");
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
        
        return parserAttributeValue(bean, attributeName);
    }
    
    public String parserAttributeValue(Object bean, String attributeName) throws Exception  {
    	String value = "";
        if (BeanUtils.isSimpleProperty(bean.getClass())) {
        	value = bean.toString();
        } else {
        	if(StringUtils.isBlank(attributeName)) {
        		throw new IllegalArgumentException("the attribute value [" + attributeName + "] is invalid.");
        	}
        	value = PropertyUtils.getProperty(bean, attributeName)
                    .toString();
        }
        return value;
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
}
