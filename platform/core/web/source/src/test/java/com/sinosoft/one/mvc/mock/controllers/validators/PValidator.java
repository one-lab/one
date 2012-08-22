package com.sinosoft.one.mvc.mock.controllers.validators;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.ParamValidator;
import com.sinosoft.one.mvc.web.paramresolver.ParamMetaData;

import org.springframework.validation.Errors;

public class PValidator implements ParamValidator {

    public boolean supports(ParamMetaData metaData) {
        return "p".equals(metaData.getParamName());
    }

    public Object validate(ParamMetaData metaData, Invocation inv, Object target, Errors errors) {
        return ((Integer) target) == 0 ? "error" : true;
    }

}
