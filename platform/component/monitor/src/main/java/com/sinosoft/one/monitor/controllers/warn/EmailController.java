package com.sinosoft.one.monitor.controllers.warn;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.monitor.model.warn.Email;
import com.sinosoft.one.monitor.service.MailService;
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
 * Time: 下午7:23
 * To change this template use File | Settings | File Templates.
 */
@Path("email")
public class EmailController {
    @Autowired
    private MailService emailService;

    @Get("list")
    public String emailView(Invocation invocation) {
        List<Email> emails = emailService.findAllEmails();
        invocation.addModel("emails", emails);
        return "emailWindow";
    }

    @Get("createEmail")
    @Post("errorCreateEmail")
    public String createEmailForm(Invocation inv) {
        inv.addModel("email", new Email());
        return "emailForm";
    }

    @Post("save")
    @Get("save")
    public String save(@Validation(errorPath = "a:errorCreateEmail") Email email, Invocation inv) throws IllegalStateException, IOException {
        email.setCreateTime(new Date());
        email.setStatus("1");
        email.setStatus("");
        emailService.addEmail(email);
        return "r:/email_sms/emailSms/list";
    }

    @Get("delete/{id}")
    public String delete(@Param("id") String id, Invocation inv) {
        emailService.deleteEmail(id);
        inv.addFlash("message", "删除邮箱成功");
        return "r:/email_sms/emailSms/list";
    }
}
