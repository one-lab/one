package com.sinosoft.one.controllers.account;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.service.account.AccountManager;
import com.sinosoft.one.uiutil.UIType;
import com.sinosoft.one.uiutil.UIUtil;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-10-25
 * Time: 下午4:53
 * To change this template use File | Settings | File Templates.
 */
@Path("user")
public class UserController {

    @Get("login")
    public String list(Invocation inv) {
        return "index";
    }

    @Post("viewUserInfo")
    public void viewInfo(Invocation inv) throws Exception {
        AccountManager accountManager = new AccountManager();
        UIUtil.with(accountManager.getGridableData()).as(UIType.Json).render(inv.getResponse());
    }

    @Post("viewCompanyInfo")
    public void viewComInfo(Invocation inv) throws Exception {
        AccountManager accountManager = new AccountManager();
        UIUtil.with(accountManager.getTreeableData()).as(UIType.Json).render(inv.getResponse());
    }
}
