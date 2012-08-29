package ins.claim.report.web;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import ins.claim.report.service.facade.LCInsuredService;
import ins.common.util.DisposeObject;
import ins.common.util.FinalCollection;
import ins.framework.common.Page;
import ins.framework.web.Struts2Action;
import ins.prpall.proposal.model.LCInsured;

public class LCInsuredAction extends Struts2Action {
	private static final long serialVersionUID = 1L;
	
	/**个单被保人表*/
	private LCInsured lcInsured;
	/**合同号和客户号组成的字符串*/
	private String ciStr;
	/**根据出险人条件查询出的page*/
	private Page lcInsuredPage;
	private LCInsuredService lcInsuredService;

	public Page getLcInsuredPage() {
		return lcInsuredPage;
	}

	public LCInsured getLcInsured() {
		return lcInsured;
	}

	public String getCiStr() {
		return ciStr;
	}

	public void setCiStr(String ciStr) {
		this.ciStr = ciStr;
	}

	public void setLcInsured(LCInsured lcInsured) {
		this.lcInsured = lcInsured;
	}

	public void setLcInsuredPage(Page lcInsuredPage) {
		this.lcInsuredPage = lcInsuredPage;
	}

	public LCInsuredService getLcInsuredService() {
		return lcInsuredService;
	}

	public void setLcInsuredService(LCInsuredService lcInsuredService) {
		this.lcInsuredService = lcInsuredService;
	}

	/**
	 * 根据查询条件对LCInsured表查询
	 * @author hesiqi
	 */
	public String findLCInsuredByCondition(){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		lcInsuredPage = lcInsuredService.findLCInsuredByCondition(lcInsured,pageNo,pageSize);
		this.getRequest().setAttribute("lcInsured", lcInsured);
		return SUCCESS;
	}
	
	/**
	 * 根据合同号和客户号查一条
	 * @return
	 * @author hesiqi
	 */
	public String findLCInsuredByContNoInsuredNo(){
		LCInsured lcInsured = lcInsuredService.findLCInsuredByContNoInsuredNo(ciStr);
		List<LCInsured> lcInsuredList = new ArrayList<LCInsured>();
		lcInsuredList.add(lcInsured);
		JSONObject jsonObject = new JSONObject();
		DisposeObject dis=new DisposeObject();
		jsonObject.put("lcInsuredList", JSONArray.fromObject(dis.dispose(lcInsuredList, new String[]{"id","name","sex","birthday","idType","idNo"})));
		renderHtml(jsonObject.toString());
		return NONE;
	}
}
