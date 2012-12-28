package com.sinosoft.one.mvc.web.validation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.validator.internal.engine.resolver.DefaultTraversableResolver;

import javax.validation.Path;
import java.lang.annotation.ElementType;

/**
 * @Author carvin
 * user OneTraversableResolver's isReachable method to prevent jpaTraversableResolver was not null
 */
public class OneTraversableResolver extends DefaultTraversableResolver {
    @Override
    public boolean isReachable(Object traversableObject, Path.Node traversableProperty, Class<?> rootBeanType, Path pathToTraversableObject, ElementType elementType) {
        return true;
    }
}
