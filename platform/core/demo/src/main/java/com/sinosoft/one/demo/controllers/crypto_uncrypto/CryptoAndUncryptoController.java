package com.sinosoft.one.demo.controllers.crypto_uncrypto;

import com.alibaba.fastjson.JSONObject;
import com.sinosoft.one.demo.model.account.User;
import com.sinosoft.one.demo.service.account.AccountManager;
import com.sinosoft.one.mvc.crypto.config.CryptoConfig;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-11-22
 * Time: 上午10:55
 * To change this template use File | Settings | File Templates.
 */
@Path("cryptoUncrypto")
public class CryptoAndUncryptoController {
    @Autowired
    private AccountManager accountManager;

    @Get("frontendCrypto")
    public String cryptoAndUnCrypto() {
        return "frontendCrypto";
    }

    @Post("frontendCrypto")
    public String frontendCrypto(Invocation inv, @Param("name") String name, @Param("email") String email) {
        String key = (String) inv.getRequest().getSession().getAttribute(CryptoConfig.CRYPTO_KEY_ATTR_NAME);
        inv.addModel("ciphertext1", key);
        inv.addModel("name1", name);
        inv.addModel("email1", email);
        return "frontendCrypto";
    }

    @Post("backgroundUncrypto")
    public String backgroundUncrypto(Invocation inv, @Param("name") String name, @Param("email") String email) {
        String key = (String) inv.getRequest().getSession().getAttribute(CryptoConfig.CRYPTO_KEY_ATTR_NAME);
        inv.addModel("ciphertext2", key);
        inv.addModel("name2", name);
        inv.addModel("email2", email);
        return "frontendCrypto";
    }

    @Post("frontendAjaxCrypto")
    public Reply frontendAjaxCrypto(Invocation inv) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key", inv.getRequest().getSession().getAttribute(CryptoConfig.CRYPTO_KEY_ATTR_NAME));
        jsonObject.put("name", inv.getParameter("name"));
        jsonObject.put("age", inv.getParameter("age"));
        jsonObject.put("gender", inv.getParameter("selectGender"));
        jsonObject.put("hobbies", inv.getParameter("checkbox"));
        jsonObject.put("address", inv.getParameter("textarea"));
        jsonObject.put("children1Id", inv.getParameter("children[0][id]"));
        jsonObject.put("children1Name", inv.getParameter("children[0][name]"));
        jsonObject.put("children2Id", inv.getParameter("children[1][id]"));
        jsonObject.put("children2Name", inv.getParameter("children[1][name]"));
        return Replys.with(jsonObject.toJSONString());
    }

    @Get("backgroundCrypto")
    public String frontendUncrypto(Invocation inv, @Param("name4") String name, @Param("email") String email) {
        inv.addModel("name", "abc123");
        inv.addModel("email", "email1@demo.com");

        User user = new User();
        user.setLoginName("ZhangSan");
        user.setPassword("abc123d");
        user.setEmail("email3@demo.com");
        inv.addModel("user", user);

        final User user1 = new User();
        user1.setLoginName("登录名1！@");
        user1.setPassword("123.456");
        user1.setEmail("email23@123demo.com");

        final User user2 = new User();
        user2.setLoginName("登录名2!@#$%^&*()[]-=");
        user2.setPassword("!1q@2w#3e$4r%5t^6y&7u*8i");
        user2.setEmail("email32@demo.com");

        List<User> users = new ArrayList<User>() {
            {
                add(user1);
                add(user2);
            }
        };
        inv.addModel("users", users);
        return "backgroundCrypto";
    }
}
