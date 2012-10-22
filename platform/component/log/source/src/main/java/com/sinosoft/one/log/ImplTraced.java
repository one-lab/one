package com.sinosoft.one.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标识一个实现类的方法将通过AOP进行ImplTraced.
 * @change 不再区分接口与实现类的日志注解，统一使用LogTraced
 * @see LogTraced
 * 
 * @author ZhuJinWei
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Deprecated
public @interface ImplTraced {

	Environment configEnv() default Environment.TEST;
}
