package com.sinosoft.one.ams.controllers.user_group;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.ams.service.AccountManager;
import com.sinosoft.one.ams.service.facade.UserGroupService;
import com.sinosoft.one.mvc.web.annotation.Path;

@Path("group")
public class GroupController {
	
	@Autowired
	private AccountManager accountManager;
	@Autowired
	private UserGroupService userGroupService;
	
	private List<String> groupAttribute = new ArrayList<String>();
	private List<String> userAttribute = new ArrayList<String>();
	
}
