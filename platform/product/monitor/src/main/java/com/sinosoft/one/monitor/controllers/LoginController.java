package com.sinosoft.one.monitor.controllers;


import com.sinosoft.one.monitor.account.model.Account;
import com.sinosoft.one.monitor.account.domain.AccountService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;

/**
 * LoginController负责打开登录页面(GET请求)和登录出错页面(POST请求)
 *
 * @author Administrator
 */
@LoginRequired
@Path
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private AccountService accountService;

    @Get("/login")
    @Post("/login")
    public String login(Invocation inv) {
        inv.getRequest().getSession().setAttribute("loginUserName", null);
        return "login";
    }

    @Get("/loginCheck")
    public String loginCheck(Invocation inv) {
        Subject currentUser = SecurityUtils.getSubject();
        Account checkuser = (Account) currentUser.getPrincipals().getPrimaryPrincipal();

        if (checkuser != null) {
            if (String.valueOf(0).equals(checkuser.getStatus())) {
                return "lock";
            }
            inv.getRequest().getSession().setAttribute("loginUserName", checkuser.getLoginName());
            return "r:account/user/list";
        } else {
            inv.addFlash("message", "用户名或者密码不对");
            return "r:/login";
        }

    }

    @Get("/logout")
    public String logout(Invocation inv) {
        inv.getRequest().getSession().setAttribute("loginUserName", null);
        //inv.getRequest().getSession().invalidate();
        return "login";
    }
}
