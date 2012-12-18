package com.sinosoft.one.log;

import com.sinosoft.one.log.handler.LogHandler;
import com.sinosoft.one.log.methodtrace.MethodTraceLog;
import com.sinosoft.one.log.queue.LoggableQueueAppender;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.spi.LoggingEvent;
import org.slf4j.helpers.MessageFormatter;

import java.lang.reflect.InvocationTargetException;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-11-29
 * Time: 下午12:28
 * To change this template use File | Settings | File Templates.
 */
public class Loggables {
    private static LogHandler userBehaviorLogQueueHandler;
    private static LogHandler userBehaviorLogSynchronizedHandler;
    private static LogHandler urlTraceLogHandler;
    private static LogHandler methodTraceLogHandler;

    private static LoggableQueueAppender loggableQueueAppender;

    private static User user;
    private static String appName;



    public static LogHandler getUserBehaviorLogQueueHandler() {
        return userBehaviorLogQueueHandler;
    }

    public static LogHandler getUserBehaviorLogSynchronizedHandlerHandler() {
        return userBehaviorLogSynchronizedHandler;
    }

    public static LogHandler getUrlTraceLogHandler() {
        return urlTraceLogHandler;
    }

    public static LogHandler getMethodTraceLogHandler() {
        return methodTraceLogHandler;
    }

    public static LoggableQueueAppender getLoggableQueueAppender() {
        return loggableQueueAppender;
    }

    public void setUserBehaviorLogQueueHandler(LogHandler userBehaviorLogQueueHandler) {
        Loggables.userBehaviorLogQueueHandler = userBehaviorLogQueueHandler;
    }

    public void setUserBehaviorLogSynchronizedHandler(LogHandler userBehaviorLogSynchronizedHandler) {
        Loggables.userBehaviorLogSynchronizedHandler = userBehaviorLogSynchronizedHandler;
    }

    public void setUrlTraceLogHandler(LogHandler urlTraceLogHandler) {
        Loggables.urlTraceLogHandler = urlTraceLogHandler;
    }

    public void setMethodTraceLogHandler(LogHandler methodTraceLogHandler) {
        Loggables.methodTraceLogHandler = methodTraceLogHandler;
    }

    public void setLoggableQueueAppender(LoggableQueueAppender loggableQueueAppender) {
        Loggables.loggableQueueAppender = loggableQueueAppender;
    }

    public void setUser(User user) {
        Loggables.user = user;
    }

    public void setAppName(String appName) {
        Loggables.appName = appName;
    }

    public static void clean() {
        if(userBehaviorLogQueueHandler != null) {
            userBehaviorLogQueueHandler.clean();
        } else if(userBehaviorLogSynchronizedHandler != null) {
            userBehaviorLogSynchronizedHandler.clean();
        } else if(urlTraceLogHandler != null) {
            urlTraceLogHandler.clean();
        } else if(methodTraceLogHandler != null) {
            methodTraceLogHandler.clean();
        }
    }

    public static Loggable parseLoggingEvent(LoggingEvent loggingEvent) {
        String message = (String) loggingEvent.getMessage();
        Loggable loggable = null;
        if(message.startsWith(MethodTraceLog.FORMAT_STRING_PREFIX)) {
            loggable = MethodTraceLog.valueOf(loggingEvent);
        } else {
            throw new IllegalStateException("This log [" + loggingEvent.getMessage() + "] should not be db log.");
        }

        return loggable;
    }

    public static User getUser() {
        return user;
    }

    public static String getUserId() {
        return user != null ? user.getUserCode() : StringUtils.EMPTY;
    }

    public static String getAppName() {
        return appName;
    }

    public static String formatDescription(String description,Object[] arguments) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        String[] formatStr = StringUtils.substringsBetween(description,"${","}");
        if(formatStr!=null){
            Object[] na = new Object[formatStr.length];
            for(int i=0;i<formatStr.length;i++){
                int paramIndex = Integer.parseInt(StringUtils.substringBetween(formatStr[i],"[","]"));
                String proPath = StringUtils.substringAfter(formatStr[i],":");
                if(StringUtils.isBlank(proPath))
                    na[i]=arguments[i];
                else
                    na[i]= BeanUtils.getProperty(arguments[paramIndex], proPath);

                //remove description ${}中内容
                description = StringUtils.remove(description,formatStr[i]);
            }
            description = StringUtils.replace(description,"${","{");
            return MessageFormatter.arrayFormat(description, na).getMessage();
        }
        else{
            return description;
        }

    }
}
