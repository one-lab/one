package com.sinosoft.one.log;

import com.sinosoft.one.log.handler.LogHandler;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-11-28
 * Time: 上午12:37
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractLoggable implements Loggable {
    protected static final String SEPARATOR = " _$$_ ";
    protected LogHandler logHandler;
    protected String appName;
    protected String userId;

    public AbstractLoggable() {
        userId = Loggables.getUserId();
        appName = Loggables.getAppName();
    }

    protected void setUserId(String userId) {
        this.userId = userId;
    }

    public void doHandler() {
        logHandler.doHandler(this);
    }
}
