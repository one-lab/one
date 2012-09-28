package ins.prpall.report.web;

import com.alibaba.fastjson.JSONObject;
import com.sinosoft.one.mvc.util.MvcPathUtil;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import ins.common.util.DisposeObject;
import ins.common.util.FinalCollection;
import ins.common.util.WebUtil;
import ins.framework.common.Page;
import ins.framework.web.Struts2Action;
import ins.platform.model.PrpDuser;
import ins.prpall.proposal.model.LCBnf;
import ins.prpall.proposal.model.LCInsured;
import ins.prpall.proposal.model.LCRepFile;
import ins.prpall.proposal.model.LDGrp;
import ins.prpall.report.model.LCActuarialAudit;
import ins.prpall.report.model.LCContPlanReport;
import ins.prpall.report.model.LCContReportId;
import ins.prpall.report.model.LCGrpAppReport;
import ins.prpall.report.model.LCGrpContReport;
import ins.prpall.report.model.LCGrpPolReport;
import ins.prpall.report.model.LCReinsAudit;
import ins.prpall.report.model.LCRepInfoReport;
import ins.prpall.report.model.LCRepInfoReportDetail;
import ins.prpall.report.model.LCReport;
import ins.prpall.report.model.LCReportAudit;
import ins.prpall.report.model.PropallSearchInfo;
import ins.prpall.report.model.PropallSearchItem;
import ins.prpall.report.service.facade.ReportService;
import ins.prpall.report.vo.ReportAuditVo;

import java.io.File;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

@Path("/prpall/report")
public class ReportController {
	private static final long serialVersionUID = 1L;
	

	/**呈报服务类*/
    @Autowired
	private ReportService reportService;

	/**
	 * 保存各种数据信息分别是：
	 * 呈报基本信息，
	 * 呈报团体客户信息，
	 * 呈报团单投保人信息，
	 * 集体保单部分信息，
	 * 呈报告知信息
	 */

	public Reply saveBaseInfo(@Param("lcReport") LCReport lcReport, @Param("ldGrp") LDGrp ldGrp,
                               @Param("lcRepInfoReportList") List<LCRepInfoReport> lcRepInfoReportList,
                               @Param("lcRepInfoReportDetail") LCRepInfoReportDetail lcRepInfoReportDetail,
                               @Param("lcGrpAppReport") LCGrpAppReport lcGrpAppReport,
                               @Param("lcGrpContReport")LCGrpContReport lcGrpContReport,Invocation invocation){
			//保存信息
			Map<String ,Object> map = reportService.saveBaseInfo(lcReport,ldGrp,lcRepInfoReportList,lcRepInfoReportDetail,lcGrpAppReport,lcGrpContReport);
			//返回信息
			lcReport = (LCReport)map.get("lcReport");
			ldGrp = (LDGrp)map.get("ldGrp");
			lcGrpAppReport = (LCGrpAppReport)map.get("lcGrpAppReport");
			lcGrpContReport = (LCGrpContReport)map.get("lcGrpContReport");
			lcRepInfoReportList=(List<LCRepInfoReport>)map.get("lcRepInfoReportList");
			lcRepInfoReportDetail=(LCRepInfoReportDetail)map.get("lcRepInfoReportDetail");


			JSONObject jsonObject = new JSONObject();
			jsonObject.put("ldGrp", JSONArray.toJSON(ldGrp));
		    jsonObject.put("lcGrpContReport", JSONArray.toJSON(lcGrpContReport));
		    jsonObject.put("lcReport", JSONArray.toJSON(lcReport));
		    jsonObject.put("lcRepInfoReportList", JSONArray.toJSON(lcRepInfoReportList));
		    jsonObject.put("lcRepInfoReportDetail", JSONArray.toJSON(lcRepInfoReportDetail));
		    return Replys.with(jsonObject.toJSONString()).as(Json.class);
	}
	/**
	 * 更新各种数据信息分别是：
	 * 呈报基本信息，
	 * 呈报团体客户信息，
	 * 呈报团单投保人信息，
	 * 集体保单部分信息，
	 * 呈报告知信息
	 * @author 于文龙
	 * @throws java.text.ParseException
	 */
	public Reply updateBaseInfo(@Param("lcReport") LCReport lcReport, @Param("ldGrp") LDGrp ldGrp,
                                 @Param("lcRepInfoReportList") List<LCRepInfoReport> lcRepInfoReportList,
                                 @Param("lcRepInfoReportDetail") LCRepInfoReportDetail lcRepInfoReportDetail,
                                 @Param("lcGrpAppReport") LCGrpAppReport lcGrpAppReport,
                                 @Param("lcGrpContReport")LCGrpContReport lcGrpContReport,Invocation invocation) throws ParseException{
        Map<String ,Object> map = reportService.updateBaseInfo(lcReport,ldGrp,lcRepInfoReportList,lcRepInfoReportDetail,lcGrpAppReport,lcGrpContReport);
        String result = "fail";
        if(null != map){
            result = "success";
        }
        return Replys.with(result).as(Json.class);
	}
	/**
	 * 根据lcreport和单位名称查询lcreport表中的数据
	 * @return
	 */
	public String findReport(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize,
                             @Param("lcReport") LCReport lcReport,
                             @Param("ldGrp") LDGrp ldGrp,
                             Invocation invocation){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
	    Page page = reportService.findReport(lcReport,ldGrp,pageNo,pageSize);
		//页面查询条件
        invocation.addModel("conditonRepNo", lcReport.getRepNo());
        invocation.addModel("conditonCom", lcReport.getManageCom());
        invocation.addModel("conditonRepApplyDate", lcReport.getRepApplyDate());
        invocation.addModel("conditonGrpName", ldGrp.getGrpName());
        invocation.addModel("page", page);
		return "/prpall/group/report/reportInput/ReportApply.jsp";
	}
	/**
	 * 
	 * @title 
	 * @description 开始录入载入信息
	 * @return
	 * @author 于文龙
	 */
	public String findReportAllInfo(@Param("lcReport") LCReport lcReport, Invocation invocation){
		Map<String ,Object> map=reportService.findReportAllInfo(lcReport);
		//返回信息
        LCReport lcReportTemp = (LCReport)map.get("lcReport");
        List<LCRepFile>  lcReportFileListTemp = (List<LCRepFile>)map.get("lcRepFileList");
        invocation.addModel("lcReport", lcReportTemp);
		if(null!=lcReportFileListTemp&&0!=lcReportFileListTemp.size()){
            invocation.addModel("lcReportFileList", lcReportFileListTemp);
		}else{
			invocation.addModel("lcReportFileList", null);
		}
		
		return "/prpall/group/report/reportInput/ReportAdd.jsp";
	}
	/**
	 * 
	 * @title initialReportAudit
	 * @description 呈报审核初始化
	 * @author 于文龙
	 */
	public Reply initialReportAudit(@Param("pageNo") int pageNo,@Param("pageSize") int pageSize,
                                     Invocation invocation){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		
		List<LCReport> lcReportList = reportService.initialReportAudit(pageNo, pageSize);
		
		JSONObject jsonObject = new JSONObject();
		DisposeObject dis=new DisposeObject();
        jsonObject.put("reportList", JSONArray.toJSON(dis.dispose(lcReportList, new String[]{"repNo","repOperator","manageCom","repApplyDate","name"})));
		return Replys.with(jsonObject.toJSONString()).as(Json.class);
	}




    /**
	 * 查询呈报表LCReport中的数据
	 * @return success
	 */
	public Reply findReportAudit(@Param("lcReport")LCReport lcReport,@Param("pageNo") int pageNo,
                                  @Param("pageSize") int pageSize,Invocation invocation ){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		
		Map<String,Object> map=reportService.findReportAudit(lcReport,pageNo,pageSize);
		
		
		List<ReportAuditVo> reportAuditVoList=(List<ReportAuditVo>)map.get("reportAuditVo");
		JSONObject jsonObject = new JSONObject();
		DisposeObject dis=new DisposeObject();
		
		jsonObject.put("reportAuditVoList", JSONArray.toJSON(dis.dispose(reportAuditVoList,new String[]{"repNo","repOperator","manageCom","repApplyDate","name","repAuditOperator","state"})));
        return Replys.with(jsonObject.toJSONString()).as(Json.class);
    }
	
	/**
	 *呈报申请审核
	 *@return NONE
	 *@author 于文龙
	 */
	public String applyReportAudit(@Param("lcReport")LCReport lcReport,@Param("pageNo") int pageNo,
                                   @Param("pageSize") int pageSize,Invocation invocation){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		Map<String,Object> map=reportService.applyReportAudit(lcReport,pageNo,pageSize);
        List<LCReportAudit> lcReportAuditList=(List<LCReportAudit>)map.get("lcReportAuditList");
		lcReport=(LCReport)map.get("lcReport");
		if(null!=lcReportAuditList){
			invocation.addModel("lcReportAuditList", lcReportAuditList);
		}else{
			invocation.addModel("lcReportAuditList", null);
		}
		if(null!=lcReport){
			invocation.addModel("lcReport", lcReport);
		}else{
			invocation.addModel("lcReport", null);
		}
		return "/prpall/group/report/reportAudit/ReportAuditDeal.jsp";
	}
	/**
	 * 呈报查看
	 * @author 于文龙
	 */
	public String applyReportView(@Param("lcReportAudit")LCReportAudit lcReportAudit,@Param("pageNo") int pageNo,
                                  @Param("pageSize") int pageSize,Invocation invocation){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		ActionContext ac = ActionContext.getContext();
		PrpDuser user = (PrpDuser)ac.getSession().get("user");
		lcReportAudit.setRepAuditIdea(user.getUserCode());
		Map<String,Object> map=reportService.applyReportView(lcReportAudit,pageNo,pageSize);
		List<LCReportAudit> lcReportAuditList=(List<LCReportAudit>)map.get("lcReportAuditList");
		LCReport lcReport=(LCReport)map.get("lcReport");
		invocation.addModel("lcReportAuditList", lcReportAuditList);
	    invocation.addModel("lcReport", lcReport);
		return "/prpall/group/report/reportAudit/ReportAuditDeal.jsp";
	}
	/**
	 * 呈报审核确认
	 * @author 于文龙
	 */
	public String reportAuditCommit(@Param("lcReportAudit")LCReportAudit lcReportAudit,@Param("pageNo") int pageNo,
                                    @Param("pageSize") int pageSize,Invocation invocation){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		Page page=reportService.reportAuditCommit(lcReportAudit,pageNo,pageSize);
        JSONObject jsonObject = new JSONObject();
        invocation.addModel("repauditoperator");
        invocation.addModel("result");
        invocation.addModel("repauditidea");
        invocation.addModel("modifyDate");
        invocation.addModel("page",page);
 //       this.writeJSONData(page, new String[]{"repauditoperator", "result", "repauditidea", "modifyDate"});
		return "/prpall/group/report/reportAudit/ReportAuditDeal.jsp";
	}
	
	/**
	 * 
	 * @title openPrpallSearch
	 * @description 发起契调
	 * @author 于文龙
	 */
	public String openPrpallSearch(@Param("lcReport")LCReport lcReport,Invocation invocation){
		Map<String,Object> map=reportService.openPrpallSearch(lcReport);
		lcReport=(LCReport)map.get("lcReport");
		invocation.addModel("lcReport", lcReport);
		return "";
	}
	/**
	 * 契调信息的保存
	 * @author 于文龙
	 */
	public String reportConCommit(@Param("propallSearchInfo")PropallSearchInfo propallSearchInfo,
                                  @Param("propallSearchItemList")List<PropallSearchItem> propallSearchItemList,
                                        Invocation invocation){
		
		boolean result=reportService.reportConSave(propallSearchInfo, propallSearchItemList);
		if(result){
			invocation.addModel("success");
		}
		return "/prpall/group/report/reportAudit/ReportContSearch.jsp";
	}
	/**
	 * 根据呈报号查询呈报与呈报相关联的表
	 */
	public String findByRepNo(@Param("lcReport")LCReport lcReport,Invocation invocation){
		Map<String,Object> map = reportService.findByRepNo(lcReport.getRepNo());
		lcReport = (LCReport)map.get("lcReport");
		LDGrp ldGrp = (LDGrp)map.get("ldGrp");
        LCGrpAppReport lcGrpAppReport = (LCGrpAppReport)map.get("lcGrpAppReport");
        LCGrpContReport lcGrpContReport = (LCGrpContReport)map.get("lcGrpContReport");
		return "/prpall/group/report/reportInput/ReportAdd.jsp";
	}
	/**
	 * 增加险种
	 * @return
	 */
	public Reply addRisk(@Param("lcGrpPolReport") LCGrpPolReport lcGrpPolReport, Invocation invocation){
		ActionContext ac = ActionContext.getContext();
		PrpDuser user = (PrpDuser)ac.getSession().get("user");
		lcGrpPolReport.setOperator(user.getUserName());
        LCGrpPolReport lcGrpPolReportTemp = reportService.addRisk(lcGrpPolReport);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("lcGrpPolReport", JSONArray.toJSON(lcGrpPolReportTemp));
        return Replys.with(jsonObject.toJSONString()).as(Json.class);
    }
	/**
	 * 
	 * @title 
	 * @description 删除险种
	 * @author 于文龙
	 */
	public Reply deleRisk(@Param("lcGrpPolReport")LCGrpPolReport lcGrpPolReport,Invocation invocation){
		lcGrpPolReport=reportService.deleRisk(lcGrpPolReport);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("lcGrpPolReport", JSONArray.toJSON(lcGrpPolReport));
        return Replys.with(jsonObject.toJSONString()).as(Json.class);
    }
	/**
	 * 
	 *  @Description    : 上传附件信息
	 *  @Method_Name    : reportFileUpload
	 *	@Param			:reportFile附件
	 *  @param			:lcReportFile附件信息
	 *  @Creation Date  : 2012-8-2 上午10:16:22 
	 *  @Author         : 于文龙
	 */
    public Reply reportFileUpload(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize,
                                   @Param("reportFile") MultipartFile reportFile,
                                   @Param("lcReportFile") LCRepFile lcReportFile,
                                   Invocation invocation){
        if(pageNo == 0){
            pageNo = 1;
        }
        if(pageSize == 0){
            pageSize = FinalCollection.PAGE_SIZE;
        }
        //获取存储路径
        String path = MvcPathUtil.getDirectoryPath(invocation, "uploadFile");
        Map<String,Object> map=reportService.reportFileUpload(reportFile, lcReportFile,path,pageNo, pageSize);
        lcReportFile=(LCRepFile)map.get("lcFile");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("lcReportFile", JSONArray.toJSON(lcReportFile));
        return Replys.with(jsonObject.toJSONString()).as(Json.class);
    }


	/**根据客户号投保申请号查询投保单位资料
	 * @author 郭占红
	 */
	
	public Reply findByCustomerNo(@Param("ldGrp") LDGrp ldGrp,Invocation invocation){
		//调用service层，调用对应的查询方法
		Page page = reportService.findInfoByCustomerNo(ldGrp);
        String result = "";
		if(null != page){
		    result = WebUtil.toJSONData(page, new String[]{"vipValue", "grpName", "organizationNo", "yearGrossIncome", "operateArea", "asset", "grpNature",
                    "mainBussiness", "businessType", "taxRegistNo", "foundDate", "peoples"});
		}
        return Replys.with(result).as(Json.class);

    }
	/**
	 * 呈报结果查询
	 * @param lcReport
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @author 郭占红
	 */
	public Reply findReportResult(@Param("lcReport")LCReport lcReport,@Param("pageNo") int pageNo,@Param("pageSize") int pageSize,
                                   Invocation invocation){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		Page page = reportService.findReportResult(lcReport,pageNo,pageSize);
        String result = WebUtil.toJSONData(page, new String[]{"repNo", "repOperator", "manageCom", "repApplyDate", "name", "state", "result", "repauditoperator"});
        return Replys.with(result).as(Json.class);
    }

	/**根据呈报申请号查询呈报返回信息
	 * @author 郭占红
	 */
	public Reply findReportReturningInfo(@Param("lcReportAudit")LCReportAudit lcReportAudit,@Param("pageNo") int pageNo,@Param("pageSize") int pageSize
                                        ,Invocation invocation){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		List report = reportService.findReportReturningInfo(lcReportAudit.getId().getRepNo(),lcReportAudit.getId().getSerialNo());
		return Replys.with(report).as(Json.class).includes("id","repauditoperator","modifyDate","result","repauditidea");
	}
	
	/**
	 * 
	 * @title findReinsAuditInfo
	 * @description 再保审核中查询呈报表中的信息
	 * @author 薛玉强
	 * @return
	 */
	public String findReinsAuditInfo(@Param("lcReport")LCReport lcReport,@Param("pageNo") int pageNo,@Param("pageSize") int pageSize,
                                     Invocation invocation){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		Page page = reportService.findReinsAuditInfo(lcReport, pageNo, pageSize);
		invocation.addModel("page", page);
		//回显信息
		invocation.addModel("manageCom", lcReport.getManageCom());
		invocation.addModel("repApplyDate", lcReport.getRepApplyDate());
		return "/prpall/group/report/reinsAudit/ReinsAuditApply.jsp";
	}
	/**
	 * 
	 * @title findAuditIdea
	 * @description 再保审核中查询呈报审核表中的审核信息
	 * @author 薛玉强
	 * @return
	 */
	public String findAuditIdea(@Param("lcReinsAudit")LCReinsAudit lcReinsAudit,Invocation invocation){
		List<LCReinsAudit> lcReinsAudits = reportService.findAuditIdea(lcReinsAudit);
		invocation.addModel("lcReinsAudits", lcReinsAudits);
		invocation.addModel("repNo", lcReinsAudit.getId().getRepNo());
		return "/prpall/group/report/reinsAudit/ReinsAuditInput.jsp";
	}
	/**
	 * 
	 * @title saveAuditResultAndIdea
	 * @description 保存再保审核中审核后的审核意见和核保结论
	 * @author 薛玉强
	 * @return
	 */
	public Reply saveAuditResultAndIdea(@Param("lcReinsAudit")LCReinsAudit lcReinsAudit,Invocation invocation){
		PrpDuser user = (PrpDuser)ActionContext.getContext().getSession().get("user");
		boolean flag = reportService.saveAuditResultAndIdea(user, lcReinsAudit);
		List<LCReinsAudit> lcReinsAuditList = reportService.findAuditIdea(lcReinsAudit);
		return Replys.with(lcReinsAuditList).as(Json.class).includes("repAuditOperator","repAuditIdea","modifyDate","modifyTime");
	}
	/**
	 * 
	 * @title findActuarialReport
	 * @description 精算审核－查询呈报表LCReport中的数据
	 * @author  徐新玲
	 * @return 
	 */
	public String findActuarialReport(@Param("lcReport")LCReport lcReport,@Param("pageNo") int pageNo,@Param("pageSize") int pageSize,
                                      Invocation invocation){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		
		Page page = reportService.findActuarialReport(lcReport,pageNo,pageSize);
		invocation.addModel("page", page);
		//回显信息
		invocation.addModel("manageCom", lcReport.getManageCom());
		invocation.addModel("repApplyDate", lcReport.getRepApplyDate());
		return "/prpall/group/report/actuarialAudit/ActuarialAuditApply.jsp";
	}
	/**
	 * @title deleteReport
	 * @description 删除呈报表信息
	 * @param lcReport
	 * @author 于文龙
	 * @create date 2012-8-2
	 */
	public Reply deleteReport(@Param("lcReport")LCReport lcReport,Invocation invocation){
		Map<String,Object> map=reportService.deleteReport(lcReport);
		lcReport=(LCReport)map.get("lcReport");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("lcReport", JSONArray.toJSON(lcReport));
        return Replys.with(jsonObject.toJSONString()).as(Json.class);
    }
	/**
	 * 
	 * @title findReportIdea
	 * @description 根据 呈报号查询呈报审核意见
	 * @author 徐新玲
	 * @create_date 2012-8-1
	 * @return 
	 */
	public String findReportIdea(@Param("lcActuarialAudit")LCActuarialAudit lcActuarialAudit,Invocation invocation){
		//根据[呈报号]查询该号的[所有审核意见]
		List<LCActuarialAudit> lcActurialList=reportService.findReportIdeaByrepNo(lcActuarialAudit);
		
		invocation.addModel("lcActurialList", lcActurialList);
		//呈报号
		invocation.addModel("repNo", lcActuarialAudit.getId().getRepNo());
		return "/prpall/group/report/actuarialAudit/ActuarialAuditInput.jsp";
	}
	/**
	 * 
	 * @title saveActuarialAuditIdea
	 * @description 保存精审意见
	 * @author xu_xinling
	 * @create date 2012-8-1
	 * @return
	 */
	public Reply saveActuarialAuditIdea(@Param("lcActuarialAudit")LCActuarialAudit lcActuarialAudit,Invocation invocation){
		ActionContext ac = ActionContext.getContext();
		
		//当前用户
		PrpDuser currentUser = (PrpDuser)ac.getSession().get("user");
		reportService.saveActuarialAuditIdea(lcActuarialAudit, currentUser);
		
		//根据呈报报查询该号对应的所有精审意见
		List<LCActuarialAudit> reportIdeaList=reportService.findAIdeaByrepNo(lcActuarialAudit.getId().getRepNo());
		return Replys.with(reportIdeaList).as(Json.class).includes("repAuditOperator","repAuditIdea","modifyDate","modifyTime");
	}
	/**
	 * 查询上传附件的信息
	 * @param pageNo
	 * @param pageSize
	 * @author 于文龙
	 */
	public Reply findFileInfo(@Param("lcReportFile")LCRepFile lcReportFile,@Param("pageNo") int pageNo,@Param("pageSize") int pageSize,
                               Invocation invocation){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		Map<String,Object> map = reportService.findFileInfo(lcReportFile, pageNo, pageSize);
        List<LCRepFile> lcReportFileList = (List<LCRepFile>)map.get("lcReportFile");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("lcReportFile", JSONArray.toJSON(lcReportFile));
		return Replys.with(jsonObject.toJSONString()).as(Json.class);
    }
}
