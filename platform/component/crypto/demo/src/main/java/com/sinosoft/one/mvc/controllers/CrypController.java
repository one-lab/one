package com.sinosoft.one.mvc.controllers;

import com.sinosoft.one.mvc.crypto.CryptoCodec;
import com.sinosoft.one.mvc.crypto.config.CryptoConfig;
import com.sinosoft.one.mvc.model.User;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * User: Morgan
 * Date: 12-10-31
 * Time: 下午3:53
 */
@Path
public class CrypController {

	@Get("cryp")
	public String crpy(Invocation inv) throws NoSuchAlgorithmException {
		HttpSession session = inv.getRequest().getSession();

		String md5 = (String) session.getAttribute(CryptoConfig.CRYPTO_KEY_ATTR_NAME);

		inv.addModel("md5",md5);
		String data = "大家好"+ new Random().nextInt();
		//String cryptokey = (String) session.getAttribute("crypto_key");
		String crpydata = CryptoCodec.encode(md5, data);

		inv.addModel("crpydata",crpydata);

		return "cryp";
	}

	@Post("send")
	public String getCrpy(Invocation inv,@Param("data") String data) {
		String md5 = (String) inv.getRequest().getSession().getAttribute(CryptoConfig.CRYPTO_KEY_ATTR_NAME);
		String result = null;

		result = CryptoCodec.decode(md5,data);

		return "@"+result;
	}
	@Post("uncrypto")
	public String formUncrypto(Invocation inv,@Param("group.name") String groupName,
							   @Param("user")User user) {
		String age = inv.getParameter("role[0].age");
		String abcd = inv.getRequest().getParameter("a.b.c.d");
		return "uncryp";
	}

	@Post("ajaxParam")
	public String ajaxParam(@Param("id")String id,@Param("name")String name,Invocation inv) {
		String add01 = inv.getParameter("address[0][add1]");
		String add11 = inv.getParameter("address[1][add1]");
		return "@aa";
	}

	@Get("cryotp")
	public String cryoto(Invocation inv) {
		//HttpSession session = inv.getRequest().getSession();
//		String sessionId = session.getId();
//		String md5 = toMD5(sessionId+"user123");
//		session.setAttribute(CryptoConfig.CRYPTO_KEY_ATTR_NAME,md5);
		User user = new User();
		user.setId("userId");
		user.setName("张三");
		user.setEmail("email");
		user.setInfo("保密信息1");
		user.setInfo2("保密信息2");
		user.setInfo3("保密信息3");
		inv.addModel("user",user);
		return "uncrypto";
	}

}
