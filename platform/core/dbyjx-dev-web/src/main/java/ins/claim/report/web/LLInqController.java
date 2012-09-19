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

import ins.claim.manage.model.LLInqApply;
import ins.claim.manage.model.LLInqCertificate;
import ins.claim.manage.model.LLInqConClusion;
import ins.claim.manage.model.LLInqCourse;
import ins.claim.manage.model.LLInqFee;
import ins.claim.report.model.LLReport;
import ins.claim.report.model.LLSubReport;
import ins.claim.report.service.facade.LLInqService;
import ins.common.util.DisposeObject;
import ins.common.util.FinalCollection;
import ins.framework.common.Page;
import ins.framework.web.Struts2Action;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/report")
public class LLInqController {
	private static final long serialVersionUID = 1L;
	/**调查申请表*/
	private LLInqService llInqService;
	@Autowired
	public void setLlInqService(LLInqService llInqService) {
		this.llInqService = llInqService;
	}
	/**
	 * 发起调查申请
	 * @return 
	 * @author hesiqi
	 */
	public Reply saveLLInqApply(@Param("llInqApply")LLInqApply llInqApply){
		List<LLInqApply> inqApplyList = llInqService.saveInqApply(llInqApply);
		JSONObject jsonObject = new JSONObject();
		DisposeObject dis = new DisposeObject();
		jsonObject.put("inqApplyList", JSONArray.fromObject(dis.dispose(inqApplyList, new String[]{"id","customerNo","customerName","initDeptValue","inqRCodeValue","inqDeptName","inqStateValue"})));
	//	renderHtml(jsonObject.toString());
		return Replys.with(jsonObject.toString()).as(Json.class).includes("id","customerNo","customerName","initDeptValue","inqRCodeValue","inqDeptName","inqStateValue");
	}
	/**
	 * 根据报案号和客户号查已发起的调查(发起调查)
	 * @return
	 * @author hesiqi
	 */
	public String findLLInqApplyByRptNoInsuredNo(@Param("pageNo")int pageNo,@Param("pageSize")int pageSize,
                                                 @Param("llSubReport")LLSubReport llSubReport,
                                                 @Param("llReport")LLReport llReport,
                                                 Invocation invocation){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		Page llInqApplyPage = llInqService.findLLInqApplyByRptNoInsuredNo(llSubReport, llReport, pageNo, pageSize);
		invocation.addModel("llSubReport", llSubReport);
		invocation.addModel("llReport", llReport);
		return "/report/claim/claimoperate/report/SurveyApply.jsp";
	}
	/**
	 * 根据报案号和客户号查询已经发起的调查申请(查看调查)
	 * @return
	 * @author hesiqi
	 */
	public String findLLInqApplyByRptNoInsuredNoTwo(@Param("pageNo")int pageNo,@Param("pageSize")int pageSize,
                                                    @Param("llSubReport")LLSubReport llSubReport,
                                                    @Param("llReport")LLReport llReport){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
	   Page llInqApplyPage = llInqService.findLLInqApplyByRptNoInsuredNo(llSubReport, llReport, pageNo, pageSize);
		return "/report/claim/claimoperate/report/SurveyInfoQuery.jsp";
	}
	/**
	 * 根据报案号和客户号查询已经发起的调查申请(取消调查)
	 * @return
	 * @author hesiqi
	 */
	public String findLLInqApplyByRptNoInsuredNoThree(@Param("pageNo")int pageNo,@Param("pageSize")int pageSize,
                                                     @Param("llSubReport")LLSubReport llSubReport,
                                                     @Param("llReport")LLReport llReport){
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		Page llInqApplyPage = llInqService.findLLInqApplyByRptNoInsuredNo(llSubReport, llReport, pageNo, pageSize);
		return "/report/claim/claimoperate/report/SurveyCancel.jsp";
	}
	/**
	 * 查询出发起调查的调查结论、调查申请、调查过程、调查过程单证、调查费用
	 * @return
	 * @author hesiqi
	 */
	public Reply findLLInq(@Param("clmInqStr")String clmInqStr){
		//调查结论
		LLInqConClusion llInqConClusion = llInqService.findLLInqConclusion(clmInqStr);
		List<LLInqConClusion> inqConClusionList = new ArrayList<LLInqConClusion>();
		inqConClusionList.add(llInqConClusion);
		//调查申请
		LLInqApply llInqApply = llInqService.findLLInqApply(clmInqStr);
		List<LLInqApply> inqApplyList = new ArrayList<LLInqApply>();
		inqApplyList.add(llInqApply);
		//调查过程
		LLInqCourse llInqCourse = llInqService.findLLInqCourse(clmInqStr);
		List<LLInqCourse> llInqCourseList = new ArrayList<LLInqCourse>();
		llInqCourseList.add(llInqCourse);
		//调查过程单证
		List<LLInqCertificate> llInqCertificateList = new ArrayList<LLInqCertificate>();
		llInqCertificateList = llInqService.findLLInqCertificate(clmInqStr);
		//调查费用
		List<LLInqFee> llInqFeeList = new ArrayList<LLInqFee>();
		llInqFeeList = llInqService.findLLInqFee(clmInqStr);
		JSONObject jsonObject = new JSONObject();
		DisposeObject dis=new DisposeObject();
		jsonObject.put("inqConClusionList", JSONArray.fromObject(dis.dispose(inqConClusionList, new String[]{"id","inqDept","inqConclusion","remark"})));
		jsonObject.put("inqApplyList", JSONArray.fromObject(dis.dispose(inqApplyList, new String[]{"id","customerName","applyPer","applyDate","initPhase","initPhaseValue","inqDept","inqDeptName","inqItem","inqDesc","initDept","initDeptValue","inqRCode","inqRCodeValue","locFlagValue","inqStateValue"})));
		jsonObject.put("llInqCourseList", JSONArray.fromObject(dis.dispose(llInqCourseList, new String[]{"id","inqDate","inqModeValue","inqSite","inqByPer","inqDept","inqPer1","operator"})));
		jsonObject.put("llInqCertificateList", JSONArray.fromObject(dis.dispose(llInqCertificateList, new String[]{"id","cerType","cerName","oriFlagValue","cerCount","remark"})));
		jsonObject.put("llInqFeeList", JSONArray.fromObject(dis.dispose(llInqFeeList, new String[]{"id","feeSum","inqDeptName","feeTypeValue","feeDate","payee","payeeTypeValue","remark"})));
	//	renderHtml(jsonObject.toString());
		return Replys.with(jsonObject.toString()).as(Json.class);
	}
	/**
	 * 取消调查
	 * @return
	 * @author hesiqi
	 */
	public Reply cancelSurvey(@Param("cioStr")String cioStr,@Param("llInqApply")LLInqApply llInqApply){
		String str = llInqService.cancelSurvey(cioStr, llInqApply);
//		renderHtml(str);
		return Replys.simple().success();
	}
}
