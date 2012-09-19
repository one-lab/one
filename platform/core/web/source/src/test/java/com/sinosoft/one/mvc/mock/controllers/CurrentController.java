package com.sinosoft.one.mvc.mock.controllers;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.InvocationUtils;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.rest.Get;

public class CurrentController {

    @Get
    public String show(Invocation inv, @Param("testThread") String threadName) {
        if (!Thread.currentThread().getName().equals(threadName)) {
            // 为了在CurrentTest中确认最后的当前请求以及Inv为null
            // 所以需要判断一下Test和这里的线程应该是一样的，否则Test的测试没有意义
            return "Thread.currentThread().getName().error";
        }
        if (inv.getPreInvocation() != null) {
            new IllegalArgumentException("getPreInvocation.error.expected.null").printStackTrace();
            return "getPreInvocation.error.expected.null";
        }
        if (inv.getRequest() != InvocationUtils.getCurrentThreadRequest()) {
            return "getCurrentThreadRequest.error";
        }
        if (inv != InvocationUtils.getCurrentThreadInvocation()) {
            return "getCurrentThreadInvocation.error";
        }
        if (inv != InvocationUtils.getInvocation(inv.getRequest())) {
            return "getInvocation.error";
        }
        return "ok";
    }
}
