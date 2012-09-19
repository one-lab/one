package com.sinosoft.one.mvc.web.impl.thread;

public interface EngineChain {

    public Object doNext() throws Throwable;

    public void addAfterCompletion(AfterCompletion task);

}
