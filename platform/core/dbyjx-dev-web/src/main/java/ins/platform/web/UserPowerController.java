package ins.platform.web;

import java.sql.Timestamp;
import java.util.*;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import ins.framework.utils.StringUtils;
import ins.framework.web.Struts2Action;
import ins.platform.model.PrpDcompany;
import ins.platform.model.PrpDuser;

import ins.platform.service.facade.UserPowerService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import javax.servlet.http.HttpSession;

@Path("/userPower")
public class UserPowerController {
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserPowerService userPowerService;

	/**
	 * 登陆方法
	 * @return
	 */
    @Post("/login")
	public String login(@Param("prpDuser") PrpDuser prpDuser, @Param("prpDcompany") PrpDcompany prpDcompany, Invocation invocation){
		prpDuser = userPowerService.login(prpDuser);
		PrpDcompany company = userPowerService.findCompanyByComCode(prpDcompany.getComCode());
		//如果用户名和密码正确，那么将一些需要的信息放在session中，以后后面调用
		if(prpDuser != null){
            HttpSession session = invocation.getRequest().getSession();
            session.setAttribute("user", prpDuser);
            session.setAttribute("comCode", prpDcompany.getComCode());
            session.setAttribute("prpDcompany",company);
			
			return "r:/common/pub/MainFrame.jsp";
		}
        return "r:/index.jsp";
	}
	/**
	 * 填写完员工编号，自动加载机构的方法
	 * @return
	 */
	public Reply loadCompany(@Param("userCode") String userCode){
		List<PrpDcompany> companys = userPowerService.loadCompany(userCode);
		return Replys.with(companys).includes("comCode","comCName").as(Json.class);
	}
	/**
	 * 根据用户编号和机构编号啦取菜单
	 * @return
	 */
	public Reply showTree(Invocation invocation){
		HttpSession httpSession = invocation.getRequest().getSession();
		PrpDuser userSession = (PrpDuser)httpSession.getAttribute("user");
		String comCode = (String)httpSession.getAttribute("comCode");
		JSONObject jsonObject = userPowerService.showTree(userSession.getUserCode(),comCode,"dbyjx","C");
		return Replys.with(jsonObject.toString()).as(Json.class);
	}
}
