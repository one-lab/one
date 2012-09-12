package ins.claim.report.web;

import java.util.ArrayList;
import java.util.List;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import ins.claim.report.service.facade.LCInsuredService;
import ins.common.util.DisposeObject;
import ins.common.util.FinalCollection;
import ins.framework.common.Page;
import ins.framework.web.Struts2Action;
import ins.prpall.proposal.model.LCInsured;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/report")
public class LCInsuredController {
	private static final long serialVersionUID = 1L;
	private LCInsuredService lcInsuredService;
    @Autowired
	public void setLcInsuredService(LCInsuredService lcInsuredService) {
		this.lcInsuredService = lcInsuredService;
	}

	/**
	 * 根据查询条件对LCInsured表查询
	 * @author hesiqi
	 */
	public String findLCInsuredByCondition(@Param("pageNo")int pageNo,@Param("pageSize")int pageSize,
                                           @Param("lcInsured")LCInsured lcInsured,
                                           Invocation invocation){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		Page lcInsuredPage = lcInsuredService.findLCInsuredByCondition(lcInsured,pageNo,pageSize);
		invocation.addModel("lcInsured", lcInsured);
		return "/report/claim/claimoperate/report/AppntQuery.jsp";
	}
	
	/**
	 * 根据合同号和客户号查一条
	 * @return
	 * @author hesiqi
	 */
	public Reply findLCInsuredByContNoInsuredNo(@Param("ciStr")String ciStr){
		LCInsured lcInsured = lcInsuredService.findLCInsuredByContNoInsuredNo(ciStr);
		List<LCInsured> lcInsuredList = new ArrayList<LCInsured>();
		lcInsuredList.add(lcInsured);
		JSONObject jsonObject = new JSONObject();
		DisposeObject dis=new DisposeObject();
		jsonObject.put("lcInsuredList", JSONArray.fromObject(dis.dispose(lcInsuredList, new String[]{"id","name","sex","birthday","idType","idNo"})));
	//	renderHtml(jsonObject.toString());
		return Replys.with(jsonObject.toString()).as(Json.class).includes("id","name","sex","birthday","idType","idNo");
	}
}
