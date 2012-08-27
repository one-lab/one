package com.sinosoft.one.rms.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContextException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.integration.Message;
import org.springframework.integration.handler.MessageProcessor;
import org.springframework.integration.scripting.AbstractScriptExecutingMessageProcessor;
import org.springframework.integration.scripting.RefreshableResourceScriptSource;
import org.springframework.scripting.ScriptSource;
import org.springframework.scripting.groovy.GroovyScriptFactory;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * DataRuleFactoryPostProcessor
 * 完成rms的数据权限数据规则初始化工作，将会读取默认的数据权限配置资源文件，并将加载到spring容器当中，
 * 默认数据规则路径为classpath*:/rms/*.groovy,将所有的规则文件均加载上作为bean，文件名即为beanId
 * 如有是maven项目需要在resources下面建立rms目录，把所有的data-rule文件放置在目录下
 * 所有脚本文件支持热加载，可以设置扫描间隔，如果不设置默认为30s扫描一次
 * User: ChengQi
 * Date: 8/7/12
 * Time: 4:56 PM
 *
 */
public class DataRuleFactoryPostProcessor implements BeanFactoryPostProcessor {
    
    private Logger logger = LoggerFactory.getLogger(DataRuleFactoryPostProcessor.class);

    protected ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
    
    private final String DATA_RULE_PATH = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX+ "dataRule/*.groovy";

    private Map<String,MessageProcessor> dataRuleMap = new ConcurrentHashMap<String,MessageProcessor>();


    //默认扫描间隔
    private long refreshDelay = 30000;

    /**
     * 设置扫描文件间隔时间
     * @param refreshDelay
     */
    public void setRefreshDelay(long refreshDelay) {
        this.refreshDelay = refreshDelay;
    }


    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        logger.info("DataRule init start...");
        //1、初始化获取所有的MessageProcessor
        initMessageProcessor();
        //2、将messageProcessors全部注册为bean--放弃，没必要注册为bean的方式

    }

    /**
     * 返回处理的DataRule对象
     * @param dataRuleId
     * @param <T>
     * @return
     */
    public DataRuleScript getScript(String dataRuleId){
        return (DataRuleScript)dataRuleMap.get(dataRuleId).processMessage(null);
    }

    protected void initMessageProcessor(){
        convertResourceToGroovyProcess(findDataRuleResource());
    }

    //2、将resource文件转换为MessageProcessor
    private void convertResourceToGroovyProcess(Map<String,Resource> resources) {
       for(String resourceId:resources.keySet()){
           dataRuleMap.put(resourceId,
                   new CustomGroovyScriptExecutingMessageProcessor(
                           new RefreshableResourceScriptSource(resources.get(resourceId),refreshDelay)));
       }
    }

    //1、加载所有的符合data rule规则的list，会自动加载jar包中以及classpath下的Resource
    private Map<String,Resource> findDataRuleResource(){
        final Map<String,Resource> resources = new HashMap<String, Resource>();
        try{
           for(Resource resource:resourcePatternResolver.getResources(DATA_RULE_PATH)){
               String beanId =  org.apache.commons.lang.StringUtils.uncapitalize(StringUtils.stripFilenameExtension(resource.getFilename()));
               logger.info("resource:{}", beanId);
               resources.put(beanId,resource);
            }
        } catch (IOException e){
            throw new ApplicationContextException(
                    "error on getJarResources/getClassesFolderResources", e);
        }
        return resources;

    }

    /**
     * 自定义groovy脚本执行方式
     * @param
     */
    private class CustomGroovyScriptExecutingMessageProcessor extends AbstractScriptExecutingMessageProcessor{

        private final GroovyScriptFactory scriptFactory;

        private volatile ScriptSource scriptSource;

        public CustomGroovyScriptExecutingMessageProcessor(ScriptSource scriptSource) {
            super();
            this.scriptSource = scriptSource;
            this.scriptFactory = new GroovyScriptFactory(this.getClass().getSimpleName());
        }


        public ScriptSource getScriptSource(Message message) {
            return scriptSource;
        }


        public Object executeScript(ScriptSource scriptSource, Map variables) throws Exception {
            Assert.notNull(scriptSource, "scriptSource must not be null");
            synchronized (this) {
                return (DataRuleScript)this.scriptFactory.getScriptedObject(scriptSource, null);
            }
        }
    }


}
