package com.sinosoft.one.mvc.mock.resolvers;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.paramresolver.ParamMetaData;
import com.sinosoft.one.mvc.web.paramresolver.ParamResolver;

public class BeanResolver implements ParamResolver {

    public static final String GET_VALUE = "bean0isadcae54";

    @Override
    public boolean supports(ParamMetaData paramMetaData) {
        return Bean.class == paramMetaData.getParamType();
    }

    @Override
    public Bean resolve(Invocation inv, ParamMetaData paramMetaData) throws Exception {
        return new Bean() {

            @Override
            public String get() {
                return GET_VALUE;
            }
        };
    }

}
