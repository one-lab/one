package ins.claim.report.web;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import ins.claim.report.model.LLAccident;
import ins.claim.report.model.LLReport;
import ins.claim.report.model.LLReportReason;
import ins.claim.report.model.LLReportRela;
import ins.claim.report.model.LLSubReport;
import ins.claim.report.service.facade.ClaimReportService;
import ins.common.util.FinalCollection;
import ins.framework.common.Page;
import ins.framework.web.Struts2Action;
import org.springframework.beans.factory.annotation.Autowired;
import sun.security.x509.ReasonFlags;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Path("report")
public class ClaimReportController {
	private static final long serialVersionUID = 1L;
	
	/**理赔服务类*/
	private ClaimReportService claimReportService;

    @Autowired
	public void setClaimReportService(ClaimReportService claimReportService) {
		this.claimReportService = claimReportService;
	}
	/**
	 * @title findClaimReport
	 * @关联llRreport、llSubRepot和llReportRela表查询数据
	 * @author zhangkai
	 * @create date 2012-8-16
	 * @return
	 */
	public String findClaimReport(@Param("pageNo")int pageNo,@Param("pageSize")int pageSize,
                                  @Param("llReport")LLReport llReport,@Param("llSubReport") LLSubReport llSubReport,
                                 @Param("rptStartDate") Date rptStartDate,@Param("rptEndDate")Date rptEndDate,
                                @Param("appntStartDate") Date appntStartDate ,@Param("appntEndDate")Date appntEndDate){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		Page page = claimReportService.findClaimReport(llReport, llSubReport, rptStartDate, rptEndDate, appntStartDate, appntEndDate, pageNo, pageSize);
		
		return "/report/claimoperate/report/ReportQuery.jsp";
	}
	
	/**
	 * @title findReportInfo
	 * @根据报案号关联llRreport、llSubRepot和llReportRela表查询数据
	 * @author zhangkai
	 * @create date 2012-8-16
	 * @return
	 */
	public String findReportInfo(@Param("llReport")LLReport llReport,Invocation invocation,
                                 @Param("llAccidentList")List<LLAccident> llAccidentList,
                                 @Param("llSubReportList")List<LLSubReport> llSubReportList){
		Map<String ,Object> map = claimReportService.findReportInfo(llReport);
		//返回信息
		llReport = (LLReport) map.get("llReport");
        llAccidentList = (List<LLAccident>) map.get("llAccidentList");
		llSubReportList = (List<LLSubReport>) map.get("llSubReportList");
//		llReportReasonList = (List<LLReportReason>map.get("llReportReasonList"));
		
		invocation.addModel("llReport", llReport);
		invocation.addModel("llAccidentList", llAccidentList);
		invocation.addModel("llSubReportList", llSubReportList);
//		this.getRequest().setAttribute("llReportReasonList", llReportReasonList);
		
		return "/report/claimoperate/report/ReportAdd.jsp";
	}	
	
	/**
	 * @title saveClaimReportInfo
	 * @param llReport 个人报案表
	 * @param llReportRela 报案事件关联表
	 * @param llSubReport 分案表
	 * @param LLCaseRela 分案事件关联表
	 * @param LLAccident 事件表
	 * @param LLAccidentSub 分事件表
	 * @param LLReportReason 报案理赔类型
	 * @author zhangkai
	 * @create date 2012-8-16
	 * @return
	 */
	public Reply saveClaimReportInfo(@Param("pageNo")int pageNo,@Param("pageSize")int  pageSize,
                                     @Param("llReport")LLReport llReport,@Param("llSubReport") LLSubReport llSubReport,
                                    @Param("llAccident")LLAccident llAccident,
                                    @Param("reasonCodeList")List<LLReportReason> reasonCodeList){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		Page page = claimReportService.saveBaseInfo(llReport, llSubReport, llAccident, 
				reasonCodeList, pageNo, pageSize);
//		this.writeJSONData(page, new String[]{"CustomerNo","CustomerName","CustomerSex","CustBirthday","IDType","IDNo"});
		return Replys.with(page.getResult()).as(Json.class).includes("CustomerNo","CustomerName","CustomerSex","CustBirthday","IDType","IDNo");
	}
	/**
	 * 修改报案基本信息，客户出险信息,事件信息，理赔类型信息
	 * @return
	 * @author hesiqi
	 */
	public Reply udpateClaimReportInfo(@Param("llReport")LLReport llReport,@Param("llSubReport")LLSubReport llSubReport,
                                       @Param("llAccident")LLAccident llAccident,@Param("reasonCodeList")List<LLReportReason> reasonCodeList){
		claimReportService.updateBaseInfo(llReport, llSubReport, llAccident,reasonCodeList);
		return Replys.simple().success();
	}
	
}
