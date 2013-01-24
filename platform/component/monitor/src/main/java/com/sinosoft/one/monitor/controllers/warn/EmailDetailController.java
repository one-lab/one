package com.sinosoft.one.monitor.controllers.warn;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.monitor.service.MailService;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.validation.annotation.Validation;

/**
 * 使用@ModelAttribute, 实现Struts2 Preparable二次绑定的效果。
 * 因为@ModelAttribute被默认执行, 而其他的action url中并没有${id}，所以需要独立出一个Controller.
 *
 * @author Administrator
 */
/*@LoginRequired*/
@Path("email")
public class EmailDetailController {

    @Autowired
    private MailService emailService;

    @Get("update/{id}")
    @Post("update/{id}")
    public String updateEmailForm(@Param("id") String id, Invocation inv) {
        inv.addModel("email", emailService.findEmail(id));
        return "emailEditForm";
    }

    @Post("save/{id}")
    public String save(@Param("id") String id, @Validation(errorPath = "a:update/{id}") @Param("newAddress") @NotNull
    @Size(min = 4, max = 100, message = "参数的长度应该在{min},{max}之间") String address, Invocation inv) {
        emailService.updateEmailAddress(id, address, new Date());
        inv.addFlash("message", "修改邮箱成功");
        return "r:/email_sms/emailSms/list";
    }
}
