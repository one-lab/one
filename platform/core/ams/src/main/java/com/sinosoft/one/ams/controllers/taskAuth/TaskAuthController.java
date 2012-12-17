package com.sinosoft.one.ams.controllers.taskAuth;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.ams.model.Company;
import com.sinosoft.one.ams.model.Employe;
import com.sinosoft.one.ams.model.TaskAuth;
import com.sinosoft.one.ams.service.facade.CompanyService;
import com.sinosoft.one.ams.service.facade.TaskAuthService;
import com.sinosoft.one.ams.utils.uiutil.NodeEntity;
import com.sinosoft.one.ams.utils.uiutil.Render;
import com.sinosoft.one.ams.utils.uiutil.TreeRender;
import com.sinosoft.one.ams.utils.uiutil.Treeable;
import com.sinosoft.one.ams.utils.uiutil.UIType;
import com.sinosoft.one.ams.utils.uiutil.UIUtil;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;

@Path
public class TaskAuthController {

	@Autowired
	private TaskAuthService taskAuthService;
	@Autowired
	private CompanyService companyService;
	
	@Post("companyAll")
	public Reply list(Invocation inv) throws Exception {
		
		Employe user = (Employe) inv.getRequest().getSession().getAttribute("user");
		//如果参数为空则查询全部机构
		List<Company> showCompany=companyService.findCompanyByUpperComCode(null);
		Company userCompany = user.getCompany();
		
		Map<String, Company> filter = new HashMap<String, Company>();
		List<Company> topList = new ArrayList<Company>();
		
		topList.add(userCompany);
		for (Company company : showCompany) {
			filter.put(company.getComCode(), company);
		}
		
		Treeable<NodeEntity> treeable = creatCompanyTreeAble(userCompany, filter);
		inv.getResponse().setContentType("text/html;charset=UTF-8");
		Render render = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
		render.render(inv.getResponse());
		return null;
	}
	
	//返回机构的功能，在页面功能已被授权给此机构，则打钩
	@Post("tasklist/{comCode}")
	public Reply list(@Param("comCode") String comCode, Invocation inv) throws Exception {		
		Treeable<NodeEntity> treeable = taskAuthService.treeAble(comCode);
		inv.getResponse().setContentType("text/html;charset=UTF-8");
		Render render = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
		render.render(inv.getResponse());
		return null;
	}
	
	//保存机构的功能
	@Post("taskId/{strId}/{comCode}")
	public Reply result(@Param("strId") String strId,@Param("comCode") String comCode, Invocation inv) {
		
		TaskAuth taskAuth = new TaskAuth();
		//保存当前机构的功能
		taskAuthService.save(strId,comCode,taskAuth);
		inv.addModel("comCode", comCode);
		return Replys.with("success");
	}
	
	
	//-----------------------------------------------------------//
	/**
	 * 构建功能树 topCompany父节点 filter所有节点
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  Treeable<NodeEntity> creatCompanyTreeAble(Company company,Map<String,Company> filter){
		List<NodeEntity> nodeEntitys=new ArrayList<NodeEntity>();
		List<Company> childCompany = companyService.findCompanyByUpperComCode(company.getComCode());
		nodeEntitys=creatSubNode(childCompany, filter);
		Treeable<NodeEntity> treeable =new Treeable.Builder(nodeEntitys,"id", "title", "children", "state").classField("classField").urlField("urlField").builder();
		return treeable;
	}
	
	List<NodeEntity> creatSubNode(List<Company> topCompany,Map<String,Company> filter){
		ArrayList<NodeEntity> nodeEntitys=new ArrayList<NodeEntity>();
		for (Company company : topCompany) {
			if(!filter.containsKey(company.getComCode()))
                continue;
			NodeEntity nodeEntity = new NodeEntity();
			nodeEntity.setId(company.getComCode());
			nodeEntity.setTitle(company.getComCName());
			List<Company> childCompany = companyService.findCompanyByUpperComCode(company.getComCode());
			if(!childCompany.isEmpty()){
				nodeEntity.setChildren(creatSubNode(childCompany,filter));
				
			}
				nodeEntitys.add(nodeEntity);
			}
		return nodeEntitys;
	}

	

}
