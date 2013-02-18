package com.sinosoft.one.log;


import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Trace一个事件，并将该事件相关信息记录到日志中
 * @see LogTraced
 * @author qc
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogTraced {
    
    static final String DEFAULT_DEC = "";

    /**
     * 事件描述
     * 默认为空，可记录复杂文字加参数类型
     * 如
     *    @LogTraced(descrption="存储用户{[0].name}，总共存储了{[1]}次")
     *    saveUser(User user,int count)
     * aaaa{[0].asd}asdasd{[0].fgh}
     * @return
     */
    String description() default DEFAULT_DEC;

    /**
     * 环境设置
     * 默认为Environment.TEST
     * @return
     */
    Environment env() default Environment.TEST;

}
