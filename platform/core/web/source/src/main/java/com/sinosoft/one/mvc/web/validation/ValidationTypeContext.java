package com.sinosoft.one.mvc.web.validation;

import org.apache.commons.collections.map.ListOrderedMap;
import org.hibernate.validator.cfg.ConstraintMapping;
import org.hibernate.validator.cfg.context.PropertyConstraintMappingContext;
import org.hibernate.validator.cfg.context.TypeConstraintMappingContext;

import java.util.*;

/**
 * Type校验类型，对validation来说需要校验的class是一种Type
 * User: ChengQi
 * Date: 12/19/12
 * Time: 5:49 下午
 */
class ValidationTypeContext<T> {

    private String name;

    private Class<T> currentClass;

    private ListOrderedMap validationPropertyContextMap = (ListOrderedMap) ListOrderedMap.decorate(new HashMap<String, ValidationPropertyContext>());

    ValidationTypeContext(String name,Class<T> currentClass){
        this.name = name;
        this.currentClass = currentClass;
    }

    public Class<T> getCurrentClass() {
        return currentClass;
    }

    public void putValidationProperty(String nodeName,ValidationPropertyContext validationPropertyContext){
        this.validationPropertyContextMap.put(nodeName,validationPropertyContext);
    }

    public ValidationPropertyContext getValidationProperty(String nodeName){
        return (ValidationPropertyContext)this.validationPropertyContextMap.get(nodeName);
    }

    public PropertyConstraintMappingContext validate(ConstraintMapping constraintMapping){
        TypeConstraintMappingContext typeConstraintMappingContext = constraintMapping.type(this.currentClass);
        PropertyConstraintMappingContext propertyConstraintMappingContext =null;
        Collection<ValidationPropertyContext> back = validationPropertyContextMap.values();
        for(ValidationPropertyContext validationPropertyContext:back){
             propertyConstraintMappingContext = validationPropertyContext.validate(typeConstraintMappingContext);
        }
        return propertyConstraintMappingContext;
    }

    public PropertyConstraintMappingContext validate(PropertyConstraintMappingContext propertyConstraintMappingContext){
        TypeConstraintMappingContext typeConstraintMappingContext = propertyConstraintMappingContext.type(this.currentClass);
        Collection<ValidationPropertyContext> back = validationPropertyContextMap.values();
        for(ValidationPropertyContext validationPropertyContext:back){
            propertyConstraintMappingContext = validationPropertyContext.validate(typeConstraintMappingContext);
        }
        return propertyConstraintMappingContext;
    }

}
