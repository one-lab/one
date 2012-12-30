package com.sinosoft.one.exception.userexception;

import com.sinosoft.one.exception.ExceptionLevel;
import com.sinosoft.one.exception.UserException;
import com.sinosoft.one.util.reflection.ReflectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 异常创建类
 * User: carvin
 * Date: 12-12-26
 * Time: 下午12:56
 * To change this template use File | Settings | File Templates.
 */
public final class ExceptionBuilder<T extends UserException> {
    private static Logger logger = LoggerFactory.getLogger(ExceptionBuilder.class);
    private static Map<String, ExceptionBuilder> exceptionBuilderMap = new ConcurrentHashMap<String, ExceptionBuilder>();
    private Constructor<T> constructor;

    private ExceptionBuilder(Class<T> clazz) {
        this.constructor = ReflectionUtils.getPrivateConstructor(clazz, new Class[]{String.class, String.class, Throwable.class, ExceptionLevel.class});
    }

    /**
     * 构造异常构建类
     * @param clazz 自定义异常的Class对象
     * @param <T>
     * @return 异常构建类
     */
    public static <T extends UserException>  ExceptionBuilder builder(Class<T> clazz) {
        String className = clazz.getName();
        if(exceptionBuilderMap.containsKey(className)) {
            return exceptionBuilderMap.get(className);
        } else {
            ExceptionBuilder exceptionBuilder = new ExceptionBuilder(clazz);
            exceptionBuilderMap.put(className, exceptionBuilder);
            return exceptionBuilder;
        }
    }

    /**
     * 通过异常代码实例化一个新的异常
     * @param concreteExceptionCode 配置文件中配置的ConcreteException的Code值
     * @return 用户自定义异常实例
     */
    public T newInstanceCode(String concreteExceptionCode) {
        try {
         return  constructor.newInstance(concreteExceptionCode, null, null, null);
        } catch (Exception e) {
            logger.error("create user exception error.", e);
            return null;
        }
    }

    /**
     * 通过异常代码实例化一个新的异常
     * @param concreteExceptionCode 配置文件中配置的ConcreteException的Code值
     * @param cause 指定捕获的异常
     * @return 用户自定义异常实例
     */
    public T newInstanceCode(String concreteExceptionCode, Throwable cause) {
        try {
            return  constructor.newInstance(concreteExceptionCode, null, cause, null);
        } catch (Exception e) {
            logger.error("create user exception error.", e);
            return null;
        }
    }

    /**
     * 通过指定异常消息实例化一个新的异常
     * @param msg 指定的异常消息
     * @return 用户自定义异常实例
     */
    public T newInstanceMsg(String msg) {
        try {
            return  constructor.newInstance(null, msg, null, null);
        } catch (Exception e) {
            logger.error("create user exception error.", e);
            return null;
        }
    }

    /**
     * 通过指定的异常消息以及捕获的异常实例化一个新的异常
     * @param msg 指定的异常消息
     * @param cause 指定捕获的异常
     * @return 用户自定义异常实例
     */
    public T newInstanceMsg(String msg, Throwable cause) {
        try {
            return  constructor.newInstance(null, msg, cause, null);
        } catch (Exception e) {
            logger.error("create user exception error.", e);
            return null;
        }
    }

    /**
     * 通过指定的异常消息、捕获的异常以及异常级别实例化一个新的异常
     * @param msg 指定的异常消息
     * @param cause 指定捕获的异常
     * @param level 异常级别，通过ExceptionLevel指定
     * @return 用户自定义异常实例
     */
    public T newInstanceMsg(String msg, Throwable cause, ExceptionLevel level) {
        try {
            return  constructor.newInstance(null, msg, cause, level);
        } catch (Exception e) {
            logger.error("create user exception error.", e);
            return null;
        }
    }
}
