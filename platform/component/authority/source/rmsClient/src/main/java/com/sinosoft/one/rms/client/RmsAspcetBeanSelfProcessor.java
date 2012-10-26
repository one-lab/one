package com.sinosoft.one.rms.client;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.sinosoft.one.rms.client.annotation.RmsAspectBeanSelfAware;

@Component
public class RmsAspcetBeanSelfProcessor implements BeanPostProcessor{

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		if(bean instanceof RmsAspectBeanSelfAware)  
        {  
            System.out.println("inject proxy：" + bean.getClass());  
            RmsAspectBeanSelfAware myBean = (RmsAspectBeanSelfAware)bean;  
            myBean.setSelf(bean);  
            return myBean;  
        }  
        return bean;   
	}

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;  
	}

}
