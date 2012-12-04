package com.sinosoft.one.demo.controllers.crypto_uncrypto;

import com.sinosoft.one.demo.model.account.User;
import com.sinosoft.one.demo.service.account.AccountManager;
import com.sinosoft.one.mvc.crypto.config.CryptoConfig;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import org.springframework.beans.factory.annotation.Autowired;

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
    public Object frontendAjaxCrypto(Invocation inv) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("name:" + inv.getParameter("name"));
        stringBuffer.append(",age:" + inv.getParameter("age"));
        stringBuffer.append(",gender:" + inv.getParameter("selectGender"));
        stringBuffer.append(",checkbox:" + inv.getParameter("checkbox"));
        stringBuffer.append(",textarea:" + inv.getParameter("textarea"));
        stringBuffer.append(",children1:" + inv.getParameter("children[0][id1]"));
        stringBuffer.append(",children1:" + inv.getParameter("children[0][name1]"));
        stringBuffer.append(",children2:" + inv.getParameter("children[1][id2]"));
        stringBuffer.append(",children2:" + inv.getParameter("children[1][name2]"));
        String jsonString = stringBuffer.toString();
        inv.addModel("jsonString", jsonString);
        User user = new User();
        user.setName(jsonString);
        return Replys.with(user).as(Json.class);
    }

    @Get("backgroundCrypto")
    public String frontendUncrypto(Invocation inv, @Param("name4") String name, @Param("email") String email) {
        inv.addModel("nameForm1", "abc123");
        inv.addModel("name1", "aaaa");
        inv.addModel("name2", "bbbb");
        inv.addModel("email1", "email4@demo.com");
        inv.addModel("email2", "email5@demo.com");
        User user = new User();
        user.setLoginName("ZhangSan");
        user.setPassword("abc123d");
        user.setEmail("email6@demo.com");
        inv.addModel("user", user);
        return "backgroundCrypto";
    }
}
