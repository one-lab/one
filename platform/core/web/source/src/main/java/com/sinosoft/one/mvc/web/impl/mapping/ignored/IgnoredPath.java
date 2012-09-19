package com.sinosoft.one.mvc.web.impl.mapping.ignored;

import com.sinosoft.one.mvc.web.RequestPath;

public interface IgnoredPath {

    public boolean hit(RequestPath requestPath);
}
