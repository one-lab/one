package com.sinosoft.one.monitor.controllers.warn;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.monitor.service.SmsService;
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
@Path("tel")
public class TelDetailController {

    @Autowired
    private SmsService telService;

    @Get("update/{id}")
    @Post("update/{id}")
    public String updateEmailForm(@Param("id") String id, Invocation inv) {
        inv.addModel("sms", telService.findTel(id));
        return "smsEditForm";
    }

    @Post("save/{id}")
    public String save(@Validation(errorPath = "a:update/{id}") @Param("newPhoneno") @NotNull
                       @Size(min = 11, max = 11, message = "参数的长度应该在{min},{max}之间")
                       @Pattern(regexp = "[0-9]{11,11}", message = "手机号必须是数字，长度11位") String phoneno, @Param("id") String id,
                       Invocation inv) {
        telService.updateEmailAddress(id, phoneno, new Date());
        inv.addFlash("message", "修改手机号成功");
        return "r:/email_sms/emailSms/list";
    }
}
