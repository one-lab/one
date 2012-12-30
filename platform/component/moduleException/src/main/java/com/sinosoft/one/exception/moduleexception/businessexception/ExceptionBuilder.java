package com.sinosoft.one.exception.moduleexception.businessexception;

import com.sinosoft.one.exception.ExceptionLevel;
import com.sinosoft.one.exception.UserException;
import com.sinosoft.one.util.reflection.ReflectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-12-26
 * Time: 下午12:56
 * To change this template use File | Settings | File Templates.
 */
public final class ExceptionBuilder<T extends UserException> {
    private static Logger logger = LoggerFactory.getLogger(ExceptionBuilder.class);
    private Class<T>  clazz;
    private Constructor<T> constructor;
    private ExceptionBuilder(Class<T> clazz) {
        this.clazz = clazz;
        this.constructor = ReflectionUtils.getPrivateConstructor(clazz, new Class[]{String.class, String.class, Throwable.class, ExceptionLevel.class});
    }
    public static <T extends UserException>  ExceptionBuilder builder(Class<T> clazz) {
        return new ExceptionBuilder(clazz);
    }

    public T newInstanceCode(String concreteExceptionCode) {
        try {
         return  constructor.newInstance(concreteExceptionCode, null, null, null);
        } catch (Exception e) {
            logger.error("create user exception error.", e);
            return null;
        }
    }

    public T newInstanceCode(String concreteExceptionCode, Throwable cause) {
        try {
            return  constructor.newInstance(concreteExceptionCode, null, null, cause);
        } catch (Exception e) {
            logger.error("create user exception error.", e);
            return null;
        }
    }

    public T newInstanceMsg(String msg) {
        try {
            return  constructor.newInstance(null, msg, null, null);
        } catch (Exception e) {
            logger.error("create user exception error.", e);
            return null;
        }
    }

    public T newInstanceMsg(String msg, Throwable cause) {
        try {
            return  constructor.newInstance(null, msg, cause, null);
        } catch (Exception e) {
            logger.error("create user exception error.", e);
            return null;
        }
    }

    public T newInstanceMsg(String msg, Throwable cause, ExceptionLevel level) {
        try {
            return  constructor.newInstance(null, msg, cause, level);
        } catch (Exception e) {
            logger.error("create user exception error.", e);
            return null;
        }
    }
}
