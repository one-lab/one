package com.sinosoft.one.mvc.mock.controllers.paths;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.impl.thread.Engine;
import com.sinosoft.one.mvc.web.impl.thread.InvocationBean;

@Path( { "path", "path/c{c}" })
public class PathController {

    @Get( { "action", "action/a{a}" })
    public String action(Invocation inv) {
        return "1" + inv.getRequestPath().getActionPath();
    }

    public String controller(Invocation inv) {
        return "2" + inv.getRequestPath().getControllerPath();
    }

    public String module(Invocation inv) {
        return "3" + inv.getRequestPath().getModulePath();
    }

    public Engine moduleEngine(Invocation inv) {
        InvocationBean invb = (InvocationBean) inv;
        return invb.getModuleEngine();
    }

    public Engine controllerEngine(Invocation inv) {
        InvocationBean invb = (InvocationBean) inv;
        return invb.getControllerEngine();
    }

    public Engine actionEngine(Invocation inv) {
        InvocationBean invb = (InvocationBean) inv;
        return invb.getActionEngine();
    }
}
