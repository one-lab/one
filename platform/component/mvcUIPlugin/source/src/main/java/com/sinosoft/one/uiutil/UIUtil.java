package com.sinosoft.one.uiutil;

/**
 * Created with IntelliJ IDEA.
 * User: seline
 * Date: 12-10-11
 * Time: 下午8:10
 * To change this template use File | Settings | File Templates.
 */
public final class UIUtil {
    public static <T extends UIable> Render with(T t) {
        return t.getRender();
    }
}
