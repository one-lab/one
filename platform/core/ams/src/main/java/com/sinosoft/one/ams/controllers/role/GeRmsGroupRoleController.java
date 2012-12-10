package com.sinosoft.one.ams.controllers.role;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.sinosoft.one.ams.model.GeRmsRole;
import com.sinosoft.one.ams.service.AccountManager;
import com.sinosoft.one.ams.utils.uiutil.GridRender;
import com.sinosoft.one.ams.utils.uiutil.Gridable;
import com.sinosoft.one.ams.utils.uiutil.Render;
import com.sinosoft.one.ams.utils.uiutil.UIType;
import com.sinosoft.one.ams.utils.uiutil.UIUtil;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;

@Path("grouprole")
public class GeRmsGroupRoleController {

	@Autowired
	private AccountManager accountManager;

	private List<String> roleAttribute = new ArrayList<String>();

	@Post("role/{groupId}")
	@Get("role/{groupId}")
	public Reply list(@Param("groupId") String groupId,@Param("pageNo") int pageNo, @Param("rowNum") int rowNum,Invocation inv) throws Exception {
		
		Pageable pageable = new PageRequest(pageNo - 1, rowNum);
		Page<GeRmsRole> page = accountManager.roleList(groupId, pageable);
		
		Gridable<GeRmsRole> gridable = new Gridable<GeRmsRole>(page);
		gridable.setIdField("roleID");
		roleAttribute.add("name");
		roleAttribute.add("roleID");
		roleAttribute.add("createTime");
		roleAttribute.add("operateTime");
		roleAttribute.add("button");
		gridable.setCellListStringField(roleAttribute);

		inv.getResponse().setContentType("text/html;charset=UTF-8");
		Render render = (GridRender) UIUtil.with(gridable).as(UIType.Json);
		render.render(inv.getResponse());
		return null;
	}

}
