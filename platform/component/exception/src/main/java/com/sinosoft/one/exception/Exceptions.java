package com.sinosoft.one.exception;

import com.sinosoft.one.exception.aspect.ExceptionEvent;
import com.sinosoft.one.exception.aspect.ExceptionQueueAppender;
import com.sinosoft.one.monitoragent.notification.Grade;
import com.sinosoft.one.monitoragent.notification.NotificationEvent;
import com.sinosoft.one.monitoragent.notification.NotificationModule;
import com.sinosoft.one.monitoragent.notification.NotificationService;
import com.sinosoft.one.util.date.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 异常处理工具类.
 * User: carvin
 * Date: 12-12-21
 * Time: 上午9:32
 *
 */
@Component
public final class Exceptions {
    private static ExceptionQueueAppender exceptionQueueAppender;
    private static NotificationService notificationService;

    private static Logger logger = LoggerFactory.getLogger(Exceptions.class);

    public static void handleThrowable(Throwable throwable) {
        UserException userException = new UserException(null, null, null, "", throwable, ExceptionLevel.MOSTSERIOUS) {};
    }
    public static void handleUserException(UserException userException) {
        if(logger.isDebugEnabled()) {
            logger.debug("--------catch---- begin------");
        }

        ExceptionLevelHandle exceptionLevelHandle = ExceptionConfig
                .getLevelHandle(userException.getLevel().toString());
        ExceptionEvent ee = new ExceptionEvent(userException, new Date());
        if(exceptionLevelHandle.isSave()) {
            // 放入异常入库队列dbException
            exceptionQueueAppender.append(ee);
        }
        if(exceptionLevelHandle.isWarning()) {
            // 放入异常通知队列notification
            exceptionNotification(ee, userException, exceptionLevelHandle);
        }

        if(logger.isDebugEnabled()) {
            logger.debug("--------catch-----end-----");
        }
    }

    /**
     * 异常通知
     *
     * @param ee
     * @param ue
     */
    private static void exceptionNotification(ExceptionEvent ee, UserException ue, ExceptionLevelHandle exceptionLevelHandle) {
        logger.info("拦截用户异常,发送通知");
        if (ee != null && ue != null) {
            NotificationEvent event = null;
            String title = ue.getMsg();
            String content = "在" + DateUtils.toFormatString(new Date(), DateUtils.Formatter.YEAR_TO_SECOND) + "产生异常:";
            if (null == ue.getMessage()) {
                content = content + title;
            } else {
                content = content + title + "--" + ue.getMessage();
            }
            logger.info("拦截用户异常,异常级别是" + ue.getLevel().toString());

            if (exceptionLevelHandle != null
                    && exceptionLevelHandle.getExceptionLevel() != ExceptionLevel.UNSERIOUS
                    .toString()) {
                event = new NotificationEvent(title, content, "",
                        NotificationModule.EXCEPTION, ue.getLevel().getNotificationValue());
                notificationService.notification(event);
            }else{
                logger.info("异常不严重,不发送通知");
            }
        } else {
            logger.info("拦截的UserException为null");
        }
    }


    public void setExceptionQueueAppender(ExceptionQueueAppender exceptionQueueAppender) {
        Exceptions.exceptionQueueAppender = exceptionQueueAppender;
    }

    public void setNotificationService(NotificationService notificationService) {
        Exceptions.notificationService = notificationService;
    }
}
