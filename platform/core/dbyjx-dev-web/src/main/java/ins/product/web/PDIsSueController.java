package ins.product.web;


import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.sinosoft.one.mvc.util.MvcPathUtil;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Text;
import ins.common.util.FinalCollection;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.platform.service.facade.PdLdCodeService;
import ins.product.model.PDIsSue;
import ins.product.model.PDIsSueId;
import ins.product.model.PDLDcode1;
import ins.product.model.PDLDcode1Id;
import ins.product.service.facade.PDIsSueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

@Path("/product")
public class PDIsSueController {
	private static final long serialVersionUID = 1L;

	private PDIsSueService pdIsSueService;
	private PdLdCodeService pdLdCodeService;

    @Autowired
	public void setPdIsSueService(PDIsSueService pdIsSueService) {
		this.pdIsSueService = pdIsSueService;
	}
	
	@Autowired
	public void setPdLdCodeService(PdLdCodeService pdLdCodeService) {
		this.pdLdCodeService = pdLdCodeService;
	}
	/**
	 * 获取已有的问题件
	 * @return
	 */
	public Reply queryApplingIssue(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize,
                                    @Param("riskCode") String riskCode,
                                    @Param("issueState") String issueState){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		QueryRule findRiskRule = QueryRule.getInstance();
		
		/** 参数以对象的方式传入，对应变量进行赋值*/
		
		if(null != riskCode && !"".equals(riskCode.trim())){
			findRiskRule.addLike("id.riskCode", riskCode.trim()+"%");
		}
		if(null != issueState && !"".equals(issueState.trim())){
			findRiskRule.addEqual("issuestate", issueState);//issueState :0 未发送 1 已发送
		}
			
		
		Page page = pdIsSueService.findRiskByCondition(findRiskRule,pageNo,pageSize);
        
		String[] factorArray = new String[]{"backpost","issuecont","issuestate","id.riskCode","id.serialNo"};

		return Replys.with(page.getResult()).as(Json.class).includes(factorArray);
	}
	
	
	
	/**
	 * 
	 *  @Description    : 上传附件信息
	 *  @Method_Name    : IssureFileUpload
	 *	@Param			:reportFile附件
	 *  @param			:lcReportFile附件信息
	 *  @Creation Date  : 2012-8-2 上午10:16:22 
	 */
	public Reply IssureFileUpload(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize,
                                   @Param("reportFile") MultipartFile reportFile,
                                   Invocation invocation){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		//获取存储路径
		String path = MvcPathUtil.getDirectoryPath(invocation, "uploadFile");
		String message=pdIsSueService.IssureFileUpload(reportFile,path,pageNo, pageSize);
		return Replys.with(message).as(Text.class);
	}
	
	
	/**
	 * 保存问题件
	 * @return
	 */
	public Reply saveIssue(@Param("pdIsSue") PDIsSue pdIsSue,Invocation invocation){
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
		
		pdIsSueService.saveIssue(pdIsSue,invocation);
		return Replys.with("save").as(Text.class);
	}

	/**
	 * @title deleteRiskDutyPay
	 * @description 删除一条问题件
	 * @return
	 */
	public Reply deleteIssue(@Param("id") String id){
		//获得定义的险种的相关信息
		String[] idList=id.split(",");
		PDIsSueId idKey=new PDIsSueId();
		idKey.setRiskCode(idList[0].toString());
		idKey.setSerialNo(new BigDecimal(Integer.parseInt(idList[1].toString())));
		
		
		String flag = pdIsSueService.deleteIssue(idKey);
		return Replys.with(flag).as(Text.class);
	}
	
	
	
	
	/**
	 * 修改/新增核保规则
	 * @return
	 */
	public Reply updateIssue(@Param("id") String id){
		if(null!=id){
			//获得定义的险种的相关信息
			String[] idList=id.split(",");
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
			Replys.with(list).as(Json.class).includes(factorArray);
		}
		 
		return Replys.simple().fail();
		
	}
}
