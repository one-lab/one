package com.sinosoft.one.monitor.controllers.email_sms;

import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.portal.Portal;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-26
 * Time: 下午4:33
 * To change this template use File | Settings | File Templates.
 */
@Path("emailSms")
public class EmailSmsController {

    @Get("/list")
    public String listViews(Portal portal) {
        portal.addWindow("email", "/warn/email/list");
        portal.addWindow("sms", "/warn/tel/list");
        return "emailAndSmsList";
    }
}
