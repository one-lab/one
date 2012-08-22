package com.sinosoft.one.mvc.mock.resolvers;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.paramresolver.ParamMetaData;
import com.sinosoft.one.mvc.web.paramresolver.ParamResolver;

public class InterfaceResolver implements ParamResolver {

    public static final String GET_VALUE = "yhntgbrfv";

    public boolean supports(ParamMetaData paramMetaData) {
        return Interface.class == paramMetaData.getParamType();
    }

    public Object resolve(Invocation inv, ParamMetaData paramMetaData) throws Exception {
        return new Interface() {

            public String get() {
                return GET_VALUE;
            }
        };
    }

}
