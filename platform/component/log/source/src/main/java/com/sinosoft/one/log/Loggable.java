package com.sinosoft.one.log;

import java.io.Serializable;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-11-27
 * Time: 下午8:29
 * To change this template use File | Settings | File Templates.
 */
public interface Loggable extends Serializable {

    Map<String, Object> toMap() throws Exception;

    LogType getType();

    void doHandler();


}
