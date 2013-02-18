package com.sinosoft.one.log.config;

import com.sinosoft.one.log.Environment;
import org.apache.commons.lang3.StringUtils;

/**
 * Log Method 类.
 * User: carvin
 * Date: 12-12-13
 * Time: 下午1:46
 * To change this template use File | Settings | File Templates.
 */
public class LogMethod {
    private String className;
    private String methodName;
    private String environment;
    private String description = "";
    private int maxExecuteTime;
    private int interval;

    private LogMethod() {}
    private LogMethod(String className, String methodName, String description, String environment, int maxExecuteTime, int interval) {
        this.className = className;
        this.methodName = methodName;
        this.description = description;
        this.environment = environment;
        this.maxExecuteTime = maxExecuteTime;
        this.interval = interval;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public boolean matches(String className, String methodName) {
        return this.className.equalsIgnoreCase(className) && this.methodName.equalsIgnoreCase(methodName);
    }

    public String getEnvironment() {
        return environment;
    }

    public String getDescription() {
        return description;
    }

    public int getMaxExecuteTime() {
        return maxExecuteTime;
    }

    public void setMaxExecuteTime(int maxExecuteTime) {
        this.maxExecuteTime = maxExecuteTime;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public String getFullMethodName() {
        return getClassName() + "." + getMethodName();
    }

    static class Builder {
        private String className;
        private String methodName;
        private String environment = Environment.DEVELOP.name();
        private String description = "";
        private int maxExecuteTime;
        private int interval;

        public Builder(String className, String methodName) {
            if(StringUtils.isBlank(className) || StringUtils.isBlank(methodName)) {
                throw new IllegalArgumentException("Log method's className and methodName must not be blank.");
            }
            this.className = className;
            this.methodName = methodName;
        }

        public Builder environment(String environment) {
            this.environment = environment;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder maxExecuteTime(int maxExecuteTime) {
            if(maxExecuteTime <= 0) {
                throw new IllegalArgumentException("Log method's maxExecuteTime must > 0");
            }
            this.maxExecuteTime = maxExecuteTime;
            return this;
        }

        public Builder interval(int interval) {
            if(interval < 0) {
                throw new IllegalArgumentException("Log method's interval must >= 0");
            }
            this.interval = interval;
            return this;
        }

        public LogMethod build() {
            return new LogMethod(className, methodName, description, environment, maxExecuteTime, interval);
        }
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) {
            return false;
        } else if(! (o instanceof LogMethod)) {
            return false;
        } else {
            LogMethod targetLogMethod = (LogMethod) o;
            return targetLogMethod.className.equals(this.className) && targetLogMethod.methodName.equals(this.methodName);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + className.hashCode();
        result = prime * result + methodName.hashCode();
        return result;
    }
}
