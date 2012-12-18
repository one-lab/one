package com.sinosoft.one.log.handler;

import com.sinosoft.one.log.Loggable;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-11-27
 * Time: 下午8:29
 * To change this template use File | Settings | File Templates.
 */
public interface LogHandler {
    void doHandler(Loggable loggable);
    void clean();
}
