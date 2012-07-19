package com.sinosoft.one.mvc.web.impl.mapping.ignored;

import com.sinosoft.one.mvc.web.RequestPath;

public class IgnoredPathEnds implements IgnoredPath {

    private String path;

    public IgnoredPathEnds(String path) {
        this.path = path;
    }

    @Override
    public boolean hit(RequestPath requestPath) {
        return requestPath.getMvcPath().endsWith(path);
    }
}
