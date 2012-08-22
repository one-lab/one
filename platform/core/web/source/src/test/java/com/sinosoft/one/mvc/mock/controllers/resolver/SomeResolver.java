package com.sinosoft.one.mvc.mock.controllers.resolver;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.paramresolver.ParamMetaData;
import com.sinosoft.one.mvc.web.paramresolver.ParamResolver;

public class SomeResolver implements ParamResolver {

    public static final String DEFAULT_PHONE_ID = "45670tyuiuyt";

    public boolean supports(ParamMetaData paramMetaData) {
        boolean result = paramMetaData.getParamType() == Phone.class;
        if (result && !paramMetaData.isAnnotationPresent(Param.class)) {
            throw new NullPointerException("param: " + paramMetaData.getMethod());
        }
        return result;
    }

    public Object resolve(Invocation inv, ParamMetaData paramMetaData) throws Exception {
        if (!paramMetaData.isAnnotationPresent(Param.class)) {
            throw new NullPointerException("param: " + paramMetaData.getMethod());
        }
        Phone phone = new PhoneImpl();
        phone.setId(DEFAULT_PHONE_ID);
        return phone;
    }

}
