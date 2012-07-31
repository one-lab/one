package com.sinosoft.one.mvc.web.validation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.validator.engine.resolver.DefaultTraversableResolver;

import javax.validation.Path;
import java.lang.annotation.ElementType;

/**
 * @Author carvin
 * user OneTraversableResolver's isReachable method to prevent jpaTraversableResolver was not null
 */
public class OneTraversableResolver extends DefaultTraversableResolver {
    private static Log logger = LogFactory.getLog(OneTraversableResolver.class);
    @Override
    public boolean isReachable(Object traversableObject, Path.Node traversableProperty, Class<?> rootBeanType, Path pathToTraversableObject, ElementType elementType) {
        try {
            return super.isReachable(traversableObject, traversableProperty, rootBeanType, pathToTraversableObject, elementType);
        } catch (Throwable e) {
            logger.warn("user OneTraversableResolver's isReachable method to prevent jpaTraversableResolver was not null  ",e);
            return true;
        }
    }
}
