package com.sinosoft.one.monitor.controllers.os;

import java.util.Date;

import com.sinosoft.one.monitor.application.model.Application;
import com.sinosoft.one.monitor.os.linux.model.Os;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.validation.annotation.Validation;

@Path
public class OsManagerController {
	/**
     * 新增一个操作系统监控器.
     */
    @Post("addApp")
    public String saveOs(@Validation(errorPath = "a:errorCreateApp") Os os, Invocation inv) {
         
        return "a:/appperformance";
    }
}
