package com.sinosoft.one.mvc.mock.controllers;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;

@Path("user")
public class UserController {

    @Get( { "", "index" })
    public String index() {
        return "index";
    }

    // 没有/结尾，则aliasxyz和aliasxyz/豆浆调用同一个方法
    @Get("alias$1")
    public String alias(String name) {
        return name == null ? "ALIAS_FAIL" : name;
    }

    @Get("{id}")
    public int show(@Param("id") Integer id, Invocation inv) {
        if (!id.toString().equals(inv.getParameter("id"))) {
            throw new IllegalStateException("inv.getParameter should return params in uri");
        }
        if (!String.valueOf(id).equals(inv.getRequest().getParameter("id"))) {
            throw new IllegalStateException("request.getParameter should return params in uri");
        }
        return id;
    }

    /*-不再支持这个测试，现在认为 @Get("{id}/")完全等价于 @Get("{id}")
    // 有/结尾，则/12345/将调用show2而非show
    @Get("{id}/")
    public int show2(@Param("id") Integer id, Invocation inv) {
        if (!id.toString().equals(inv.getParameter("id"))) {
            throw new IllegalStateException("inv.getParameter should return params in uri");
        }
        if (!String.valueOf(id).equals(inv.getRequest().getParameter("id"))) {
            throw new IllegalStateException("request.getParameter should return params in uri");
        }
        return id * 2;
    }*/

    /*-不再支持这个测试，现在认为 @Get("{id}/404/")完全等价于 @Get("{id}/404")
    // 假设设置了{id}/404/而没有设置{id}/404，则访问/12345/404将404
    @Get("{id}/404/")
    public int show404(@Param("id") Integer id, Invocation inv) {
        if (!id.toString().equals(inv.getParameter("id"))) {
            throw new IllegalStateException("inv.getParameter should return params in uri");
        }
        if (!String.valueOf(id).equals(inv.getRequest().getParameter("id"))) {
            throw new IllegalStateException("request.getParameter should return params in uri");
        }
        return id * 2;
    }
    */

    @Get("{id}/account")
    public String account(@Param("id") Integer id) {
        return "account_" + id;
    }

    public String accountb1(@Param("id") Integer id) {
        return "account_" + id;
    }

    @Post
    public String post1() {
        return "POST1";
    }


    @Post
    public String post() {
        return "POST";
    }

    public int queryString(@Param("id") int id) {
        return id;
    }

    public int inf(Interface inf, @Param("id") int id) {
        return id;
    }

    static interface Interface {

    }


}
