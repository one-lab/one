package com.sinosoft.one.exception;
/**
 *
 * 用户异常基类
 *
 * @author zhujinwei
 */
public abstract class UserException extends RuntimeException {

    private Throwable cause = null;
    private final String exceptionKind = "01";
    private String userExceptionCode = "";
    private String subUserExceptionCode = "";
    private String concreteExceptionCode = "";
    private String msg = "";
    private ExceptionLevel level = ExceptionLevel.UNSERIOUS;

    public UserException(String userExceptionCode, String subUserExceptionCode,
                         String concreteExceptionCode, String msg, Throwable cause,
                         ExceptionLevel level) {
        if (msg != null) {
            this.msg = msg;
        }
        if (level != null) {
            this.level = level;
        }
        if (userExceptionCode != null) {
            this.userExceptionCode = userExceptionCode;

        }
        if (subUserExceptionCode != null) {
            this.subUserExceptionCode = subUserExceptionCode;
        }
        if (concreteExceptionCode != null) {
            this.concreteExceptionCode = concreteExceptionCode;
        }
        if (!("").equals(this.concreteExceptionCode)
                && !("").equals(this.subUserExceptionCode)
                && !("").equals(this.userExceptionCode)) {
            XmlConcreteException xmlConcreteException = ExceptionConfig
                    .getXmlConcreteException(exceptionKind, userExceptionCode,
                            subUserExceptionCode, concreteExceptionCode);
            if (xmlConcreteException != null) {
                this.msg = xmlConcreteException.getExceptionDesc();
                this.level = xmlConcreteException.getLevel();
            }
        }

        this.cause = cause;
    }



    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }

    public String getUserExceptionCode() {
        return userExceptionCode;
    }

    public void setUserExceptionCode(String userExceptionCode) {
        this.userExceptionCode = userExceptionCode;
    }

    public String getSubUserExceptionCode() {
        return subUserExceptionCode;
    }

    public void setSubUserExceptionCode(String subUserExceptionCode) {
        this.subUserExceptionCode = subUserExceptionCode;
    }

    public String getConcreteExceptionCode() {
        return concreteExceptionCode;
    }

    public void setConcreteExceptionCode(String concreteExceptionCode) {
        this.concreteExceptionCode = concreteExceptionCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ExceptionLevel getLevel() {
        return level;
    }

    public void setLevel(ExceptionLevel level) {
        this.level = level;
    }

    public String getExceptionKind() {
        return exceptionKind;
    }

    private static final long serialVersionUID = 1L;
}
