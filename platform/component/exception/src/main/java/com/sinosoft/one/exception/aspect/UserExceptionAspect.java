package com.sinosoft.one.exception.aspect;

import java.util.Date;

import com.sinosoft.one.exception.*;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 异常拦截,写数据库和发通知
 *
 * @author zhujinwei
 *
 */
public class UserExceptionAspect {
    //    @Autowired
//    private NotificationService notificationService;

    /**
     * 异常拦截,拦截后抛出
     *
     * @param ue
     */
    public void exceptionCatch(UserException ue) {
        Exceptions.handleUserException(ue);
    }


}
