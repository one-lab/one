package com.sinosoft.one.log.config;

import com.alibaba.fastjson.JSONObject;
import com.sinosoft.one.log.Environment;
import org.apache.commons.lang3.StringUtils;

/**
 * Log URL 类.
 * User: carvin
 * Date: 12-12-13
 * Time: 下午1:46
 * To change this template use File | Settings | File Templates.
 */
public class LogUrl {
    private String url = "";
    private String environment = "";
    private int maxExecuteTime;

    public LogUrl() {}

    public LogUrl(String url, String environment, int maxExecuteTime) {
        if(StringUtils.isBlank(url)) {
            throw new IllegalArgumentException("Log url's url must not be blank.");
        }
        if(StringUtils.isBlank(environment)) {
            throw new IllegalArgumentException("Log url's environment must not be blank.");
        }
        if(maxExecuteTime <= 0) {
            throw new IllegalArgumentException("Log url's maxExecuteTime must be > 0.");
        }
        this.url = url;
        this.environment = environment;
        this.maxExecuteTime = maxExecuteTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public int getMaxExecuteTime() {
        return maxExecuteTime;
    }

    public void setMaxExecuteTime(int maxExecuteTime) {
        this.maxExecuteTime = maxExecuteTime;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) {
            return false;
        } else if(! (o instanceof LogUrl)) {
            return false;
        } else {
            LogUrl targetLogUrl = (LogUrl) o;
            return targetLogUrl.url.equals(this.url);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + url.hashCode();
        return result;
    }

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("url", url);
        jsonObject.put("environment", environment.toString());
        jsonObject.put("maxExecuteTime", maxExecuteTime);
        return jsonObject.toJSONString();
    }
}
