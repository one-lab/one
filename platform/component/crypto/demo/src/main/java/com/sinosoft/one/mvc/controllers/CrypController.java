package com.sinosoft.one.mvc.controllers;

import com.sinosoft.one.mvc.crypto.CryptoCodec;
import com.sinosoft.one.mvc.crypto.config.Crypto;
import com.sinosoft.one.mvc.crypto.config.CryptoConfig;
import com.sinosoft.one.mvc.crypto.util.CryptoConfigUpdateUtil;
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
import java.util.ArrayList;
import java.util.List;
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
	public Reply getCrpy(Invocation inv,@Param("data") String data) {
		String md5 = (String) inv.getRequest().getSession().getAttribute(CryptoConfig.CRYPTO_KEY_ATTR_NAME);

		User user = new User() ;
		user.setId("1");
		user.setEmail("aaaaaaaaaaaaaa");
		user.setInfo("asdfdsfs");
		return Replys.with(user).as(Json.class);
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
	@Get("testAdd")
	public String testAdd() {
		return "adduncrypto";
	}

	@Get("addUncrypto")
	public String addUncryptoUrl() {
		CryptoConfigUpdateUtil.saveUnCryptoConfig("/demo/testAddedUncrypto");
		return "adduncrypto";
	}
	@Get("deleteUncrypto")
	public String deleteUncryptoUrl() {
		CryptoConfigUpdateUtil.deleteUnCryptoConfigs("/demo/testAddedUncrypto");
		return "adduncrypto";
	}
	@Get("addCrypto")
	public String addCrypto() {
		List<Crypto> list = new ArrayList<Crypto>();
		list.add(new Crypto("/demo/views/adduncrypto.jsp","info,id,name",null,"user"));
		list.add(new Crypto("/demo/views/adduncrypto.jsp","info,id,name",null,"user2"));
		CryptoConfigUpdateUtil.saveCryptoConfig("/demo/views/adduncrypto.jsp",list);
		return "adduncrypto";
	}
	@Get("deleteCrypto")
	public String deleteCrypto() {
		CryptoConfigUpdateUtil.deleteCryptoConfigs("/demo/views/adduncrypto.jsp");
		return "adduncrypto";
	}

	@Post("/testAddedUncrypto")
	public String testAddedUncrypto(User user, Invocation inv) {
		inv.addModel("user",user);
		return "adduncrypto";
	}


}
