package com.sinosoft.one.uiutil;

import com.sinosoft.one.uiutil.exception.ConverterException;

/**
 * Created with IntelliJ IDEA.
 * User: seline
 * Date: 12-10-11
 * Time: 下午8:57
 * To change this template use File | Settings | File Templates.
 */
public interface Converter<T extends UIable> {
    String toJson(T t) throws ConverterException;

    String toXml(T t) throws ConverterException;
}
