package com.sinosoft.one.mvc.mock.controllers.errorhandler;

import com.sinosoft.one.mvc.web.ControllerErrorHandler;
import com.sinosoft.one.mvc.web.Invocation;

public class ErrorHandler implements ControllerErrorHandler {

    public Object onError(Invocation inv, Throwable ex) {
        return ex;
    }

}
