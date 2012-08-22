package com.sinosoft.one.mvc.web.impl.mapping.ignored;

import java.util.regex.Pattern;

import com.sinosoft.one.mvc.web.RequestPath;

public class IgnoredPathRegexMatch implements IgnoredPath {

    private Pattern path;

    public IgnoredPathRegexMatch(String path) {
        this.path = Pattern.compile(path);
    }

    public boolean hit(RequestPath requestPath) {
        return path.matcher(requestPath.getMvcPath()).matches();
    }
}
