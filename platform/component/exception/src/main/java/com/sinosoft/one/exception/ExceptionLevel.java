package com.sinosoft.one.exception;

/**
 *
 * 异常级别枚举类
 *
 * @author zhujinwei
 */
public enum ExceptionLevel {
    /**
     * 异常不严重
     */
    UNSERIOUS("0"),

    /**
     * 异常严重
     */
    SERIOUS("1"),

    /**
     * 异常很严重
     */
    MORESERIOUS("2"),

    /**
     * 异常最严重
     */
    MOSTSERIOUS("3");
    private String value;

    private ExceptionLevel(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }

    public static ExceptionLevel instanceOf(String value) {
        if(UNSERIOUS.value.equalsIgnoreCase(value)) {
            return UNSERIOUS;
        } else if(SERIOUS.value.equalsIgnoreCase(value)) {
            return SERIOUS;
        } else if(MORESERIOUS.value.equalsIgnoreCase(value)) {
            return MORESERIOUS;
        } else if(MOSTSERIOUS.value.equalsIgnoreCase(value)) {
            return MOSTSERIOUS;
        }
        throw new IllegalArgumentException("Invalid ExceptionLevel value [" + value + "]");
    }
}