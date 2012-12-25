package com.sinosoft.one.mvc.web.validation;

import org.hibernate.validator.cfg.ConstraintMapping;
import org.hibernate.validator.cfg.context.PropertyConstraintMappingContext;
import org.hibernate.validator.cfg.context.TypeConstraintMappingContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Type校验类型，对validation来说需要校验的class是一种Type
 * User: ChengQi
 * Date: 12/19/12
 * Time: 5:49 下午
 */
class ValidationTypeContext<T> {

    private String name;

    private Class<T> currentClass;

    private Map<String,ValidationPropertyContext> validationPropertyContextMap = new HashMap<String, ValidationPropertyContext>();

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
        return this.validationPropertyContextMap.get(nodeName);
    }

    public PropertyConstraintMappingContext validate(ConstraintMapping constraintMapping){
        TypeConstraintMappingContext typeConstraintMappingContext = constraintMapping.type(this.currentClass);
        PropertyConstraintMappingContext propertyConstraintMappingContext =null;
        for(ValidationPropertyContext validationPropertyContext:validationPropertyContextMap.values()){
             propertyConstraintMappingContext = validationPropertyContext.validate(typeConstraintMappingContext);
        }
        return propertyConstraintMappingContext;
    }

    public PropertyConstraintMappingContext validate(PropertyConstraintMappingContext propertyConstraintMappingContext){
        TypeConstraintMappingContext typeConstraintMappingContext = propertyConstraintMappingContext.type(this.currentClass);
        for(ValidationPropertyContext validationPropertyContext:validationPropertyContextMap.values()){
            propertyConstraintMappingContext = validationPropertyContext.validate(typeConstraintMappingContext);
        }
        return propertyConstraintMappingContext;
    }

}
