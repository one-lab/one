package com.sinosoft.one.mvc.web.validation;

import org.hibernate.validator.cfg.ConstraintDef;
import org.hibernate.validator.cfg.context.PropertyConstraintMappingContext;
import org.hibernate.validator.cfg.context.TypeConstraintMappingContext;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.List;

/**
 * used for property validation.
 * User: ChengQi
 * Date: 12/19/12
 * Time: 5:50 下午
 * To change this template use File | Settings | File Templates.
 */
class ValidationPropertyContext {

    private String name;

    private List<ConstraintDef> constraints = new ArrayList<ConstraintDef>(0);

    public ValidationPropertyContext(String name){
        this.name = name;
    }

    public void addConstraint(ConstraintDef constraintDef){
       this.constraints.add(constraintDef);
    }

    PropertyConstraintMappingContext validate(TypeConstraintMappingContext typeConstraintMappingContext){
        PropertyConstraintMappingContext propertyConstraintMappingContext = typeConstraintMappingContext.
                property(name, ElementType.FIELD);
        for(ConstraintDef constraintDef:constraints){
            propertyConstraintMappingContext = propertyConstraintMappingContext.constraint(constraintDef);
        }
        propertyConstraintMappingContext = propertyConstraintMappingContext.valid();
        return propertyConstraintMappingContext;
    }

}
