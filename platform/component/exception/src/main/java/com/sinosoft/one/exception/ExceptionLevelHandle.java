package com.sinosoft.one.exception;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * 异常级别处理描述类
 *
 * @author zhujinwei
 */
public class ExceptionLevelHandle {
    private String exceptionLevel = "0";
    private String exceptionLevelDesc = "";
    private boolean save;
    private boolean warning;

    public ExceptionLevelHandle(String exceptionLevel, String getExceptionLevelDesc, String isSave, String isWarning) {
        this.exceptionLevel = exceptionLevel;
        this.exceptionLevelDesc = getExceptionLevelDesc;
        this.save = (StringUtils.isBlank(isSave) || "0".equals(isSave)) ? false : true;
        this.warning = (StringUtils.isBlank(isWarning) || "0".equals(isWarning)) ? false : true;
    }

    public String getExceptionLevel() {
        return exceptionLevel;
    }

    public String getExceptionLevelDesc() {
        return exceptionLevelDesc;
    }

    public boolean isSave() {
        return save;
    }

    public void setSave(boolean save) {
        this.save = save;
    }

    public boolean isWarning() {
        return warning;
    }

    public void setWarning(boolean warning) {
        this.warning = warning;
    }
}
