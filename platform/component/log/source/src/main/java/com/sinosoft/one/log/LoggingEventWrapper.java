package com.sinosoft.one.log;

/**
 * Copyright (c) 2005-2009 springside.org.cn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * $Id: LoggingEventWrapper.java 1099 2010-05-29 14:33:47Z calvinxiu $
 */

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Log4j LoggingEvent的包装类, 提供默认的toString函数及更直观的属性访问方法.
 * 
 * @author qc
 */
public class LoggingEventWrapper {
	public static final PatternLayout DEFAULT_PATTERN_LAYOUT = new PatternLayout(
			"%d [%t]  %-5p %c - %m");

    enum LogType{
        traceLog,commonLog
    }

	private final LoggingEvent event;
	private final LogType logType;
	private final String message;
	private final String className;
	private final String methodName;
    private final String msg[];
	private Logger logger = LoggerFactory.getLogger(getClass());


	public LoggingEventWrapper(LoggingEvent event) {
		this.event = event;
		this.message = (String) event.getMessage();
		this.className = event.getLocationInformation().getClassName();
		this.methodName = event.getLocationInformation().getMethodName();
		if (message.contains("@MethodTrace")
				&& className.contains("TraceAspect")) {
			this.logType = LogType.traceLog;
		} else {
			this.logType = LogType.commonLog;
		}
        this.msg = StringUtils.splitByWholeSeparator(this.message,LogTraceAspect.SEPARATOR);
	}

	/**
	 * 使用默认的layoutPattern转换事件到日志字符串.
	 */
	public String convertToString() {
		return DEFAULT_PATTERN_LAYOUT.format(event);
	}

	/**
	 * 根据参数中的layoutPattern转换事件到日志字符串.
	 */
	public String convertToString(String layoutPattern) {
		return new PatternLayout(layoutPattern).format(event);
	}

	public String getSerialNo() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public long getTimeStamp() {
		return event.getTimeStamp();
	}

	public String getTraceId() {
		String traceId = "noid";
		if (LogType.traceLog.equals(logType) && message.contains("@traceId=")) {
			traceId = message.split("Id=")[1].split("]")[0];
		}
		return traceId;
	}

	public Date getDate() {
		return new Date(event.getTimeStamp());
	}

	public String getThreadName() {
		return event.getThreadName();
	}

	public String getLoggerName() {
		return event.getLoggerName();
	}

	public String getLevel() {
		return event.getLevel().toString();
	}

	public String getMessage() {
        if(this.logType.equals(LogType.traceLog)){
            return msg[13].trim();
        }
        else
		    return this.message;
	}

    /**
     * 记录是否来自追踪日志：1为trace 0 为不是
     * @return
     */
	public String getLogType() {
		return this.logType.toString();
	}

	/**
	 * 影响性能,慎用.
	 */
	public String getClassName() {
		if (LogType.traceLog.equals(this.logType)) {
			try {
				String traceClassName = this.msg[3].split("\\(")[0]
						.split("\\.")[0];
				return traceClassName;
			} catch (Exception e) {
				logger.warn("err eventwrpper get classname");
			}
		}
		return this.className;
	}

	/**
	 * 影响性能,慎用.
	 */
	public String getMethodName() {
		if (LogType.traceLog.equals(this.logType)) {
			try {
				String traceMethodName = this.msg[3].split("\\(")[0]
						.split("\\.")[1];
				return traceMethodName;
			} catch (Exception e) {
				logger.warn("err eventwrpper get methodname");
			}
		}
		return this.methodName;
	}

	public String getInputParam() {
		if (LogType.traceLog.equals(this.logType)) {
			try {
				String inputParam = this.msg[5];
				return inputParam;
			} catch (Exception e) {
				logger.warn("err eventwrpper get inputparam");
			}
		}
		return null;
	}

	public String getOutParam() {
		if (LogType.traceLog.equals(this.logType)) {
			try {
				String outParam = this.msg[7];
				return outParam;
			} catch (Exception e) {
				logger.warn("err eventwrpper get outparam");
			}
		}
		return null;
	}

	public Date getBeginTime() {
		if (LogType.traceLog.equals(this.logType)) {
			try {
				Timestamp beginTime = Timestamp.valueOf(this.msg[1]);
				return beginTime;
			} catch (Exception e) {
				logger.warn("err eventwrpper get begintime");
			}
		}
		return null;
	}

	public Date getEndTime() {
		if (LogType.traceLog.equals(this.logType)) {
			try {
				Timestamp endTime = Timestamp.valueOf(this.msg[9]);
				return endTime;
			} catch (Exception e) {
				logger.warn("err eventwrpper get endtime");
			}
		}
		return null;
	}

	public int getConsumeTime() {
		if (LogType.traceLog.equals(this.logType)) {
			try {
				int consumeTime = new Integer(this.msg[11].trim())
						.intValue();
				return consumeTime;
			} catch (Exception e) {
				logger.warn("err eventwrpper get consumetime");
			}
		}
		return 0;
	}
    
    

	public String getThrowableInformation() {
		StringBuffer throwableInformation = new StringBuffer(1000);
		String[] throwableStrRep = event.getThrowableStrRep();
		if (throwableStrRep == null)
			return StringUtils.EMPTY;
		for (int i = 0, n = throwableStrRep.length; i < n; i++) {
			throwableInformation.append(throwableStrRep[i]);
			throwableInformation.append("\r\n");
		}
		return throwableInformation.toString();
	}

    public String getUserCode() {
        if (LogType.traceLog.equals(this.logType)) {
            return this.msg[15].trim();
        } else
            return null;
    }

    public Object getCompanyCode() {
        if (LogType.traceLog.equals(this.logType)) {
            return this.msg[17].trim();
        }
        else
            return null;
    }
}
