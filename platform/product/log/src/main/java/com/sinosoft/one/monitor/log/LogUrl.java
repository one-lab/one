package com.sinosoft.one.monitor.log;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Log URL 类.
 * User: carvin
 * Date: 12-12-13
 * Time: 下午1:46
 * To change this template use File | Settings | File Templates.
 */
public class LogUrl {
    private String url = "";
    private String id = "";
	private List<LogMethod> logMethodList = new ArrayList<LogMethod>();

    public LogUrl() {}

    public LogUrl(String id, String url) {
		this.id = id;
	    this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void addLogMethod(LogMethod logMethod) {
		logMethodList.add(logMethod);
	}

	public List<LogMethod> getLogMethodList() {
		return logMethodList;
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
	    jsonObject.put("id", id);
        jsonObject.put("url", url);
        return jsonObject.toJSONString();
    }
}
