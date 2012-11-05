package com.sinosoft.one.demo.controllers.account;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


import com.sinosoft.one.demo.model.account.User;
import com.sinosoft.one.demo.model.account.UserInfo;
import com.sinosoft.one.demo.service.account.AccountManager;
import com.sinosoft.one.demo.service.mail.IMailService;
import com.sinosoft.one.demo.service.mail.MailServiceImpl;
import com.sinosoft.one.mvc.util.MvcPathUtil;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sinosoft.one.demo.controllers.LoginRequired;
import com.sinosoft.one.demo.model.account.Group;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import com.sinosoft.one.mvc.web.validation.annotation.NotEmptyEx;
import com.sinosoft.one.mvc.web.validation.annotation.SizeEx;
import com.sinosoft.one.mvc.web.validation.annotation.Validation;

/**
 * Urls:
 * List   page        : GET  /account/user/
 * Create page        : GET  /account/user/create
 * Create action      : POST /account/user/save
 * Update page        : GET  /account/user/update/{id}
 * Update action      : POST /account/user/save/{id}
 * Delete action      : POST /account/user/delete/{id}
 * CheckLoginName ajax: GET  /account/user/checkLoginName?oldLoginName=a&loginName=b
 * 
 * @author calvin
 *
 */
@LoginRequired
@Path("user")
public class UserController {

	@Autowired
	private AccountManager accountManager;

	@Autowired
	private GroupListEditor groupListEditor;

    @Autowired
    private IMailService mailService;

	@InitBinder
	public void initBinder(WebDataBinder b) {
		b.registerCustomEditor(List.class, "groupList", groupListEditor);
	}
	
	@LoginRequired
	@Get("list")
	public String list(Invocation inv) {
		List<User> users = accountManager.getAllUser();
		inv.addModel("users", users);
		return "userList";
	}

	@Get("create")
	@Post("errorCreate")
	public String createForm(Invocation inv) {
		inv.addModel("user", new User());
		inv.addModel("allGroups", accountManager.getAllGroup());
		return "userForm";
	}
	@Get("userInfoList/{userId}")
	public String check(@Param("userId") long userId ,Invocation inv){
		UserInfo userInfos = accountManager.findUserInfoByUserId(userId);
		inv.addModel("uesrInfos",userInfos);
		return "userInfoList";
	}
	
	@Post("save")
	public String save(@Param("groupList") List<Long> gids,
			@Validation(errorPath="a:errorCreate",
				notEmpty=@NotEmptyEx( props={"loginName","password","email","name"} ) ,
				size=@SizeEx(max=20,min=4, props={"name","loginName","email"})
			) User user, @Param("doc") MultipartFile[] docs, Invocation inv) throws IllegalStateException, IOException {
		
		List<Group> groupList = new ArrayList<Group>();
		for (Long long1 : gids) {
			Group group = new Group(long1, null);
			groupList.add(group);
		}
		user.setGroupList(groupList);
		user.setId(System.currentTimeMillis());
		user.setCreateTime(new Date());
		accountManager.saveUser(user);
		for (MultipartFile multipartFile : docs) {
			if(StringUtils.isEmpty(multipartFile.getOriginalFilename())){
				continue;
			}

			multipartFile.transferTo(new File(MvcPathUtil.getDirectoryPath(inv, "/")+multipartFile.getOriginalFilename()));
		}
		

//		return Replys.sample().success("创建用户" + user.getLoginName() + "成功");
		return "r:/account/user/list";
	}

	@Get("delete/{id}")
	public String delete(@Param("id") Long id, Invocation inv) {
		accountManager.deleteUser(id);
		inv.addFlash("message", "删除用户成功");
		return "r:/account/user/list";
	}

	@Post("checkLoginName")
	public String checkLoginName(@Param("oldLoginName") String oldLoginName,
			@RequestParam("loginName") String loginName) {
		if (loginName.equals(oldLoginName)) {
			return "true";
		} else if (accountManager.findUserByLoginName(loginName) == null) {
			return "true";
		}

		return "@false";
	}
	
	@Get("/p1")
	public String p1(Invocation inv){ 
		List<User> users = accountManager.getAllUser();
		inv.addModel("users", users);
		return "userWindow";
//		return "@ p1***********";
	}
	
	@Get("/pipe1")
	public String pipe1(Invocation inv){ 
//		List<User> users = accountManager.getAllUser();
//		inv.addModel("users", users);
		return "userListPipe";
	}
	
	@Post("view/{key1}/{key2}/{id}")
	public Object view(@Param("key1") Long key1, @Param("key2") Long key2,
			@Param("id") Long id, Invocation inv){
		if(key1 == 1 && key2 == 2){
			User user = accountManager.getUser(id);
			
			return Replys.with(user).as(Json.class);
		}
		return "@e";
	}

    @Post("sendmail")
    public Object sendMail(Invocation invocation){
        String caption = invocation.getRequest().getParameter("caption");
        String sendto = invocation.getRequest().getParameter("sendto");
        String mailContent = invocation.getRequest().getParameter("mailContent");
        System.out.println("caption:"+caption+" sendto:"+sendto+" mailContent:"+mailContent+"++++++++++++++++");
        mailService.sendTextMail("yangming841022@163.com",sendto,caption,mailContent);
        return Replys.simple().success();
    }
	
	@Post("viewUserInfo/{id:[0-9]+}")
	public Object viewUserInfo(@Param("id") Long id, Invocation inv){
		
		UserInfo userInfo = accountManager.findUserInfo(id);
		
		return Replys.with(userInfo).as(Json.class);
	}

    @Get("qslList")
    public String qslList(Invocation inv){
        return "userQslList";
    }

    @Post("qslListResult")
    public String qslListResult(Invocation inv,@Param("mapa") Map<String,String> mapa) {
        List<User> users = accountManager.findAllUserByQSL(mapa);
        inv.addModel("users", users);
        return "userQslList";
    }

    @Get("complexSql")
    public String complexSql(Invocation inv){
        return "userComplexSqlList";
    }

    @Post("complexSqlResult")
    public String qslComplexListResult(Invocation inv,@Param("name") String name,@Param("email") String email, @Param("id") Long id) {
        List<User> users = accountManager.findAllUserByDynamicSQL(name,email,id);
        inv.addModel("users", users);
        return "userComplexSqlList";
    }

    @Get("queryResult")
    public String queryList(Invocation inv){
        List<User> users=accountManager.findAllUserOne();
        inv.addModel("users",users);
        return "userQueryList";
    }
    @Get("resourceResult")
    public String resourceList(Invocation inv){
        List<User> users=accountManager.findAllUserTwo();
        inv.addModel("users",users);
        return "userResourceList";

    }

    @Get("namedQuerylList")
    public String namedQueryList(Invocation inv){
        return "userNamedQueryList";
    }

    @Post("namedQueryResult")
    public String namedQueryResult(Invocation inv,@Param("name") String name) {
        List<User> users = accountManager.findAllUserByNamedQueyt(name);
        inv.addModel("users", users);
        return "userNamedQueryList";
    }

    @Get("createValidator")
    @Post("errorCreate")
    public String createValidatorForm(Invocation inv) {
        inv.addModel("user", new User());
        inv.addModel("allGroups", accountManager.getAllGroup());
        return "userValidatorForm";
    }

    @Post("saveValidator")
    public String saveValidator(@Param("groupList") List<Long> gids,User user, @Param("doc") MultipartFile[] docs, Invocation inv) throws IllegalStateException, IOException {

        List<Group> groupList = new ArrayList<Group>();
        for (Long long1 : gids) {
            Group group = new Group(long1, null);
            groupList.add(group);
        }
        user.setGroupList(groupList);
        user.setId(System.currentTimeMillis());
        user.setCreateTime(new Date());
        accountManager.saveUser(user);
        for (MultipartFile multipartFile : docs) {
            if(StringUtils.isEmpty(multipartFile.getOriginalFilename())){
                continue;
            }

            multipartFile.transferTo(new File(MvcPathUtil.getDirectoryPath(inv, "/")+multipartFile.getOriginalFilename()));
        }
        return "r:/account/user/queryResult";
    }



}
