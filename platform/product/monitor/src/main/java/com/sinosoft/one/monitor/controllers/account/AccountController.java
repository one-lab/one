package com.sinosoft.one.monitor.controllers.account;


import com.sinosoft.one.monitor.account.model.Account;
import com.sinosoft.one.monitor.account.domain.AccountService;
import com.sinosoft.one.monitor.controllers.LoginRequired;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import com.sinosoft.one.mvc.web.validation.annotation.Validation;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
@LoginRequired
@Path("user")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @LoginRequired
    @Get("list")
    public String list(Invocation inv) {
        List<Account> accounts = accountService.getAllAccount();
        inv.addModel("accounts", accounts);
        return "userList";
    }

    @Get("create")
    @Post("errorCreate")
    public String createForm(Invocation inv) {
        inv.addModel("user", new Account());
        return "userForm";
    }

    @Post("save")
    public String save(@Validation(errorPath = "a:errorCreate") Account account, Invocation inv) throws IllegalStateException, IOException {
        account.setCreateTime(new Date());
        account.setStatus(String.valueOf(1));
        accountService.saveAccount(account);
        return "r:/account/user/list";
    }

    @Get("delete/{id}")
    public String delete(@Param("id") String id, Invocation inv) {
        accountService.deleteAccount(id);
        inv.addFlash("message", "删除用户成功");
        return "r:/account/user/list";
    }

    @Post("view/{id}")
    public Object view(@Param("id") String id, Invocation inv) {
        Account account = accountService.getAccount(id);
        return Replys.with(account).as(Json.class);
    }
}
