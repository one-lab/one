package com.sinosoft.one.rmsdemo.controllers;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.rmsdemo.model.User;
import com.sinosoft.one.rmsdemo.service.LoginManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: seline
 * Date: 12-9-20
 * Time: 下午2:37
 * To change this template use File | Settings | File Templates.
 */
@Path("login")
public class LoginController {
    @Autowired
    LoginManager loginManagerImp;
    @Get
    public String login(Invocation invocation) {
        invocation.getRequest().getSession().setAttribute("loginName",null);
        return "login";
    }
    @Post("/userLogin")
    public String login(Invocation invocation,User user) {
        User checkuser = loginManagerImp.findByLoginName(user.getLoginName());

        if(checkuser!=null && checkuser.getPassword().equals(user.getPassword())){
            invocation.getRequest().getSession().setAttribute("loginUserName", user.getLoginName());
            return "r:/account/user/list";
        } else {
            invocation.addFlash("message", "用户名或者密码不对");
            return "r:/login";
        }

    }

    @Get("/logout")
    public String logout(Invocation inv){
        inv.getRequest().getSession().setAttribute("loginUserName", null);
        return "login";
    }

}
