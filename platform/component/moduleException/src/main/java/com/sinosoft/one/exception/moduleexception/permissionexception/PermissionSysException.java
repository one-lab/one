package com.sinosoft.one.exception.moduleexception.permissionexception;


import com.sinosoft.one.exception.ExceptionLevel;
import com.sinosoft.one.exception.userexception.PermissionException;

/**
 * 权限模块异常
 *
 * @author zhujinwei
 *
 */
public class PermissionSysException extends PermissionException {
    private static final String subuserexceptionCode = "010200";

    private PermissionSysException(String concreteExceptionCode,
                                   String msg, Throwable cause, ExceptionLevel level) {
        super(subuserexceptionCode, concreteExceptionCode, msg, cause, level);
    }

    public static PermissionSysException newInstanceCode(
            String concreteExceptionCode) {
        return new PermissionSysException(concreteExceptionCode,
                null, null, null);
    }

    public static PermissionSysException newInstanceCode(
            String concreteExceptionCode, Throwable cause) {
        return new PermissionSysException(concreteExceptionCode,
                null, cause, null);
    }

    public static PermissionSysException newInstanceMsg(String msg) {
        return new PermissionSysException(null, msg, null, null);
    }

    public static PermissionSysException newInstanceMsg(String msg,
                                                        Throwable cause) {
        return new PermissionSysException(null, msg, cause, null);
    }

    public static PermissionSysException newInstanceMsg(String msg,
                                                        Throwable cause, ExceptionLevel level) {
        return new PermissionSysException(null, msg, cause, level);
    }

    public String getSubuserexceptionCode() {
        return subuserexceptionCode;
    }

    private static final long serialVersionUID = 1L;
}