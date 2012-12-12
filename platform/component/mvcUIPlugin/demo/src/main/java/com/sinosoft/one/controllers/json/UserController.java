package com.sinosoft.one.controllers.json;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.service.json.JsonManager;
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
    /*@Get("viewUserInfo")*/
    public void viewInfo(Invocation inv) throws Exception {
        JsonManager jsonManager = new JsonManager();
        //不使用encoding()方法，默认的响应编码格式为UTF-8
        UIUtil.with(jsonManager.getGridableData()).as(UIType.Json).render(inv.getResponse());
    }

    @Post("viewGroupInfo")
    public void viewGroupInfo(Invocation inv) throws Exception {
        JsonManager jsonManager = new JsonManager();
        //使用encoding()方法，手动设置响应的编码格式
        UIUtil.with(jsonManager.getTreeableDataForGroup()).as(UIType.Json).encoding("utf-8").render(inv.getResponse());
    }

    @Post("viewRoleInfo")
    public void viewRoleInfo(Invocation inv) throws Exception {
        JsonManager jsonManager = new JsonManager();
        //使用encoding()方法，手动设置响应的编码格式
        UIUtil.with(jsonManager.getTreeableDataForGroup()).as(UIType.Json).encoding("utf-8").render(inv.getResponse());
    }

    @Post("viewCompanyInfo")
    public void viewComInfo(Invocation inv) throws Exception {
        JsonManager jsonManager = new JsonManager();
        //不使用encoding()方法，默认的响应编码格式为UTF-8
        UIUtil.with(jsonManager.getTreeableData()).as(UIType.Json).render(inv.getResponse());
        //使用encoding()方法，手动设置响应的编码格式
        /*UIUtil.with(accountManager.getTreeableData()).as(UIType.Json).encoding("GB2312").render(inv.getResponse());*/
    }
}
