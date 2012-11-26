package com.sinosoft.ams.utils.uiutil.exception;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-11-6
 * Time: 下午5:10
 * To change this template use File | Settings | File Templates.
 */
public class ConverterException extends Exception {
    public ConverterException() {
        super();
    }

    public ConverterException(String msg) {
        super(msg);
    }

    public ConverterException(Throwable cause) {
        super(cause);
    }

    public ConverterException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
