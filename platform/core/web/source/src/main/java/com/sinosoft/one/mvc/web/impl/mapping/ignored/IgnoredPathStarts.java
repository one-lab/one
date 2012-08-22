package com.sinosoft.one.mvc.web.impl.mapping.ignored;

import com.sinosoft.one.mvc.web.RequestPath;

public class IgnoredPathStarts implements IgnoredPath {

    private String path;

    public IgnoredPathStarts(String path) {
        this.path = path;
    }

    public boolean hit(RequestPath requestPath) {
        return requestPath.getMvcPath().startsWith(path);
    }
}