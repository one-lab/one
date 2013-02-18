package com.sinosoft.one.monitor.controllers.warn;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.monitor.model.warn.Sms;
import com.sinosoft.one.monitor.service.SmsService;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.validation.annotation.Validation;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-26
 * Time: 下午7:22
 * To change this template use File | Settings | File Templates.
 */
@Path("tel")
public class TelController {
    @Autowired
    private SmsService telService;

    @Get("list")
    public String smsView(Invocation invocation) {
        List<Sms> smsList = telService.findAllTels();
        invocation.addModel("smsList", smsList);
        return "smsWindow";
    }

    @Get("createTel")
    @Post("errorCreateTel")
    public String createEmailForm(Invocation inv) {
        inv.addModel("sms", new Sms());
        return "smsForm";
    }

    @Post("save")
    public String save(@Validation(errorPath = "a:errorCreateTel") Sms sms, Invocation inv) throws IllegalStateException, IOException {
        sms.setCreateTime(new Date());
        sms.setStatus(String.valueOf(0));
        telService.addTel(sms);
        return "r:/email_sms/emailSms/list";
    }

    @Get("delete/{id}")
    public String delete(@Param("id") String id, Invocation inv) {
        telService.deleteSms(id);
        inv.addFlash("message", "删除手机成功");
        return "r:/email_sms/emailSms/list";
    }
}
