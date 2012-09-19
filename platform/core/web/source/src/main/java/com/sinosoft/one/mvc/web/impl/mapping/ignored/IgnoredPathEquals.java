package com.sinosoft.one.mvc.web.impl.mapping.ignored;

import com.sinosoft.one.mvc.web.RequestPath;


public class IgnoredPathEquals implements IgnoredPath {

    private String path;

    public IgnoredPathEquals(String path) {
        this.path = path;
    }

    public boolean hit(RequestPath requestPath) {
        return requestPath.getMvcPath().equals(path);
    }
}

