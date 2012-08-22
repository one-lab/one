package com.sinosoft.one.mvc.mock.resolvers;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.paramresolver.ParamMetaData;
import com.sinosoft.one.mvc.web.paramresolver.ParamResolver;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextResolver implements ParamResolver, ApplicationContextAware {

    ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public boolean supports(ParamMetaData paramMetaData) {

        return ApplicationContext.class.isAssignableFrom(paramMetaData.getParamType());
    }

    public Object resolve(Invocation inv, ParamMetaData paramMetaData) throws Exception {
        return applicationContext;
    }

}
