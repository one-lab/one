package ins.product.web;


import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import ins.common.util.FinalCollection;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.web.Struts2Action;
import ins.platform.service.facade.PdLdCodeService;
import ins.product.model.PDIsSue;
import ins.product.model.PDIsSueId;
import ins.product.model.PDLDcode1;
import ins.product.model.PDLDcode1Id;
import ins.product.service.facade.PDIsSueService;

public class PDIsSueAction extends Struts2Action {
	private static final long serialVersionUID = 1L;

	private PDIsSue pdIsSue;
	private PDIsSueService pdIsSueService;
	private PdLdCodeService pdLdCodeService;
	private String riskCode;
	private String issueState;
	private Page page;
	/**上传附件*/
	private File reportFile;
	private String id;
	

	public PDIsSue getPdIsSue() {
		return pdIsSue;
	}
	public void setPdIsSue(PDIsSue pdIsSue) {
		this.pdIsSue = pdIsSue;
	}
	public PDIsSueService getPdIsSueService() {
		return pdIsSueService;
	}
	public void setPdIsSueService(PDIsSueService pdIsSueService) {
		this.pdIsSueService = pdIsSueService;
	}
	
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	public String getIssueState() {
		return issueState;
	}
	public void setIssueState(String issueState) {
		this.issueState = issueState;
	}
	public File getReportFile() {
		return reportFile;
	}
	public void setReportFile(File reportFile) {
		this.reportFile = reportFile;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public PdLdCodeService getPdLdCodeService() {
		return pdLdCodeService;
	}
	public void setPdLdCodeService(PdLdCodeService pdLdCodeService) {
		this.pdLdCodeService = pdLdCodeService;
	}
	/**
	 * 获取已有的问题件
	 * @return
	 */
	public String queryApplingIssue(){
		if(this.pageNo == 0){
			this.pageNo = 1;
		}
		if(this.pageSize == 0){
			this.pageSize = FinalCollection.PAGE_SIZE;
		}
		QueryRule findRiskRule = QueryRule.getInstance();
		
		/** 参数以对象的方式传入，对应变量进行赋值*/
		
		if(null != riskCode && !"".equals(riskCode.trim())){
			findRiskRule.addLike("id.riskCode", riskCode.trim()+"%");
		}
		if(null != issueState && !"".equals(issueState.trim())){
			findRiskRule.addEqual("issuestate", issueState);//issueState :0 未发送 1 已发送
		}
			
		
		this.page = pdIsSueService.findRiskByCondition(findRiskRule,pageNo,pageSize);
        
		String[] factorArray = new String[]{"backpost","issuecont","issuestate","id.riskCode","id.serialNo"};
		this.writeJSONData(page.getResult(), factorArray);
		
		return NONE;
	}
	
	
	
	/**
	 * 
	 *  @Description    : 上传附件信息
	 *  @Method_Name    : IssureFileUpload
	 *	@Param			:reportFile附件
	 *  @param			:lcReportFile附件信息
	 *  @Creation Date  : 2012-8-2 上午10:16:22 
	 */
	public String IssureFileUpload(){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		//获取存储路径
		String path = this.getServletContext().getRealPath("/")+"uploadFile\\";
		String message=pdIsSueService.IssureFileUpload(reportFile,path,pageNo, pageSize);
	    renderHtml(message);
		return NONE;
	}
	
	
	/**
	 * 保存问题件
	 * @return
	 */
	public String saveIssue(){
		PDIsSueId id=new PDIsSueId();
		if (null!=pdIsSue.getId().getSerialNo()) {
			id.setSerialNo(pdIsSue.getId().getSerialNo());
			id.setRiskCode(pdIsSue.getId().getRiskCode());
			pdIsSue.setId(id);
		} else {
			int count=pdIsSueService.countIssue();
			id.setSerialNo(new BigDecimal(count+1));
			id.setRiskCode(pdIsSue.getId().getRiskCode());
			pdIsSue.setId(id);
		}
		
		pdIsSueService.saveIssue(pdIsSue);
		 this.writeJSONMsg("save");
		return NONE;
	}

	/**
	 * @title deleteRiskDutyPay
	 * @description 删除一条问题件
	 * @return
	 */
	public String deleteIssue(){
		//获得定义的险种的相关信息
		String[] idList=id.toString().split(",");
		PDIsSueId idKey=new PDIsSueId();
		idKey.setRiskCode(idList[0].toString());
		idKey.setSerialNo(new BigDecimal(Integer.parseInt(idList[1].toString())));
		
		
		String flag = pdIsSueService.deleteIssue(idKey);
		this.writeJSONMsg(flag);
		return NONE;
	}
	
	
	
	
	/**
	 * 修改/新增核保规则
	 * @return
	 */
	public String updateIssue(){
		if(null!=id){
			//获得定义的险种的相关信息
			String[] idList=id.toString().split(",");
			PDIsSueId idKey=new PDIsSueId();
			idKey.setRiskCode(idList[0].toString());
			idKey.setSerialNo(new BigDecimal(Integer.parseInt(idList[1].toString())));
			
			
			
			PDIsSue issue = pdIsSueService.findIssueByID(idKey);
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			
			Map<String,Object> temp = new HashMap<String, Object>();
			
			temp.put("backpost", issue.getBackpost());
			temp.put("issuecont", issue.getIssuecont());
			temp.put("riskCode", issue.getId().getRiskCode());
			temp.put("serialNo", issue.getId().getSerialNo());
			
			
			Map<String,Object> codetemp = new HashMap<String, Object>();
			codetemp.put("codeType","IssueGrade");
			codetemp.put("codeCode",issue.getBackpost());
			PDLDcode1Id ID=new PDLDcode1Id();
			ID.setCodeType("IssueGrade" );
			ID.setCode(issue.getBackpost());
			PDLDcode1 code=pdLdCodeService.findByPK(ID);
			
			temp.put("backpostname", code.getCodeName());
			list.add(temp);
			
			String[] factorArray = new String[]{"backpost","issuecont","riskCode","serialNo","backpostname"};
			this.writeJSONData(list, factorArray);
		}
		 
		return NONE;
		
	}
}
