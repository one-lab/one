package ins.claim.report.service.facade;

import java.util.List;

import ins.claim.manage.model.LLInqApply;
import ins.claim.manage.model.LLInqCertificate;
import ins.claim.manage.model.LLInqConClusion;
import ins.claim.manage.model.LLInqCourse;
import ins.claim.manage.model.LLInqFee;
import ins.claim.report.model.LLReport;
import ins.claim.report.model.LLSubReport;
import ins.framework.common.Page;
import ins.prpall.proposal.model.LCInsured;

public interface LLInqService {

	/**
	 * 发起调查申请
	 * @param llInqApply
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @author hesiq
	 */
	List<LLInqApply> saveInqApply(LLInqApply llInqApply);
	/**
	 * 查询发起调查的调查结论
	 * @param clmInqStr
	 * @return
	 * @author hesiqi
	 */
	LLInqConClusion findLLInqConclusion(String clmInqStr);
	/**
	 * 查询发起调查的调查申请
	 * @param clmInqStr
	 * @return
	 * @author hesiqi
	 */
	LLInqApply findLLInqApply(String clmInqStr);
	/**
	 * 查询发起调查的调查过程
	 * @param clmInqStr
	 * @return
	 * @author hesiqi
	 */
	LLInqCourse findLLInqCourse(String clmInqStr);
	/**
	 * 查询发起调查的调查过程单证
	 * @param clmInqStr
	 * @return
	 * @author hesiqi
	 */
	List<LLInqCertificate> findLLInqCertificate(String clmInqStr);
	/**
	 * 查询发起调查的调查费用
	 * @param clmInqStr
	 * @return
	 * @author hesiqi
	 */
	List<LLInqFee> findLLInqFee(String clmInqStr);
	/**
	 * 根据报案号和客户号查询已发起的调查
	 * 
	 * @param lcInsured
	 * @param llReport
	 * @return
	 * @author hesiqi
	 */
	Page findLLInqApplyByRptNoInsuredNo(LLSubReport llSubReport, LLReport llReport, int pageNo,int pageSize);
	/**
	 * 取消调查
	 * @param cIBOStr
	 * @param llInqApply
	 * @return
	 * @author hesiqi
	 */
	String cancelSurvey(String cIBOStr, LLInqApply llInqApply);
	
}
