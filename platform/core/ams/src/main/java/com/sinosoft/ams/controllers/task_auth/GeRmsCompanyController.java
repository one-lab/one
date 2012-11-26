package com.sinosoft.ams.controllers.task_auth;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.ams.service.AccountManager;
import com.sinosoft.ams.task_auth.model.GeRmsCompany;
import com.sinosoft.ams.task_auth.model.NodeEntity;
import com.sinosoft.ams.user_group.model.User;
import com.sinosoft.ams.utils.uiutil.Render;
import com.sinosoft.ams.utils.uiutil.TreeRender;
import com.sinosoft.ams.utils.uiutil.Treeable;
import com.sinosoft.ams.utils.uiutil.UIType;
import com.sinosoft.ams.utils.uiutil.UIUtil;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;


@Path("company")
public class GeRmsCompanyController {

	@Autowired  //必须加的一句话，spring调用
	private AccountManager accountManager;
	@Post("companylist")
	public Reply list(Invocation inv) throws Exception {
		//通过用户获取用户的公司ID和公司中文名
		User user = (User) inv.getRequest().getSession().getAttribute("user");
		String comCode = user.getComCode();
		String comCName = accountManager.company(comCode).getComCName();
		
		//通过用户的公司ID获取下属子机构
		List<GeRmsCompany> companies = accountManager.findByUpperComCode(comCode);

		NodeEntity nodeEntity = new NodeEntity(comCode, comCName, "close");
		GeRmsCompanyController obj=new GeRmsCompanyController();
		
		obj.push(nodeEntity, companies);
		@SuppressWarnings("unchecked")
		Treeable<NodeEntity> treeable = new Treeable.Builder<NodeEntity>(nodeEntity.getChildren(), "id", "title", "children", "state").builder();
		
		//通过下属子机构获取下属子机构的子机构
		for(int i=0;i<companies.size();i++){
			NodeEntity ne=nodeEntity.getChildren().get(i);
			List<GeRmsCompany> comZi = accountManager.findByUpperComCode(companies.get(i).getComCode());
			obj.push(ne, comZi);
		}
		
		inv.getResponse().setContentType("text/html;charset=UTF-8");
	    Render render = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
		render.render(inv.getResponse());
		
		return null;
	}
	
	void push(NodeEntity nodeEntity,List<GeRmsCompany> companies){
		
        List<NodeEntity> nodeEntities = new ArrayList<NodeEntity>();
        for(GeRmsCompany company: companies){
        	
            NodeEntity ne = new NodeEntity();
            ne.setId(company.getComCode());
            ne.setTitle(company.getComCName());
            nodeEntities.add(ne);
        }
        nodeEntity.setChildren(nodeEntities);
   }

}
