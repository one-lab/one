package ins.claim.report.service.spring;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import ins.claim.manage.model.LLInqApply;
import ins.claim.manage.model.LLInqCertificate;
import ins.claim.manage.model.LLInqConClusion;
import ins.claim.manage.model.LLInqCourse;
import ins.claim.manage.model.LLInqFee;
import ins.claim.report.model.LLReport;
import ins.claim.report.model.LLSubReport;
import ins.claim.report.service.facade.LLInqService;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.DateUtil;
import ins.platform.common.SerialNoUtil;
import ins.platform.model.PrpDuser;

public class LLInqServiceSpringImpl extends
		GenericDaoHibernate<LLInqApply, String> implements LLInqService {
	private SerialNoUtil serialNoUtil;

	public SerialNoUtil getSerialNoUtil() {
		return serialNoUtil;
	}

	public void setSerialNoUtil(SerialNoUtil serialNoUtil) {
		this.serialNoUtil = serialNoUtil;
	}

	/**
	 * 发起调查申请
	 * 
	 * @param llInqApply
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @author hesiq
	 */
	@Override
	public List<LLInqApply> saveInqApply(LLInqApply llInqApply) {
		ActionContext ac = ActionContext.getContext();
		PrpDuser user = (PrpDuser) ac.getSession().get("user");
		String inqNo;
		//TODO 获得最大的number？
		String hql = "select max(cast( llInqApply.id.inqNo as int)) as inqno from LLInqApply llInqApply where llInqApply.id.clmNo=?";
		List<Integer> list = (List<Integer>) this.findByHql(hql, llInqApply.getId().getClmNo());
		if (null == list.get(0) ) {
			inqNo = 1 + "";
		} else {
			inqNo = Integer.parseInt(String.valueOf(list.get(0))) + 1 + "";
		}
		// TODO 批次号生成策略未定
		String batNo = "pch";
		llInqApply.getId().setInqNo(inqNo);
		llInqApply.setBatNo(batNo);
		llInqApply.setApplyPer(user.getUserCode());
		llInqApply.setApplyDate(new Date());
		llInqApply.setOperator(user.getUserCode());
		llInqApply.setMakeDate(new Date());
		llInqApply.setMakeTime(DateUtil.getTime());
		llInqApply.setModifyDate(new Date());
		llInqApply.setModifyTime(DateUtil.getTime());
		llInqApply.setInqRCode(llInqApply.getInqRCode().trim());
		llInqApply.setSurveyFlag("01");
		llInqApply.setInqState("0");
		llInqApply.setInqStateValue("申请");
		this.save(llInqApply);
		QueryRule findInqApplyRule = QueryRule.getInstance();
		findInqApplyRule.addEqual("id.clmNo", llInqApply.getId().getClmNo());
		findInqApplyRule.addEqual("customerNo", llInqApply.getCustomerNo());
		List<LLInqApply> inqApplyList = this.find(findInqApplyRule);
		return inqApplyList;
	}
	/**
	 * 查询发起调查的调查结论
	 * @param clmInqStr
	 * @return
	 * @author hesiqi
	 */
	@Override
	public LLInqConClusion findLLInqConclusion(String clmInqStr) {
		String[] strAry = clmInqStr.split(",");
		QueryRule findInqConClusionRule = QueryRule.getInstance();
		findInqConClusionRule.addEqual("id.clmNo", strAry[0]);
		findInqConClusionRule.addEqual("id.conNo", strAry[1]);
		LLInqConClusion lLInqConClusion = this.findUnique(LLInqConClusion.class, findInqConClusionRule);
		return lLInqConClusion;
	}
	/**
	 * 查询发起调查的调查申请
	 * @param clmInqStr
	 * @return
	 * @author hesiqi
	 */
	@Override
	public LLInqApply findLLInqApply(String clmInqStr) {
		String[] strAry = clmInqStr.split(",");
		QueryRule findInqApplyRule = QueryRule.getInstance();
		findInqApplyRule.addEqual("id.clmNo", strAry[0]);
		findInqApplyRule.addEqual("id.inqNo", strAry[1]);
		LLInqApply llInqApply = this.findUnique(LLInqApply.class, findInqApplyRule);
		return llInqApply;
	}
	/**
	 * 查询发起调查的调查过程
	 * @param clmInqStr
	 * @return
	 * @author hesiqi
	 */
	@Override
	public LLInqCourse findLLInqCourse(String clmInqStr) {
		String[] strAry = clmInqStr.split(",");
		QueryRule findInqCourseRule = QueryRule.getInstance();
		findInqCourseRule.addEqual("id.clmNo", strAry[0]);
		findInqCourseRule.addEqual("id.inqNo", strAry[1]);
		LLInqCourse llInqCourse = this.findUnique(LLInqCourse.class, findInqCourseRule);
		return llInqCourse;
	}
	/**
	 * 查询发起调查的调查过程单证
	 * @param clmInqStr
	 * @return
	 * @author hesiqi
	 */
	@Override
	public List<LLInqCertificate> findLLInqCertificate(String clmInqStr) {
		String[] strAry = clmInqStr.split(",");
		QueryRule findInqCertificateRule = QueryRule.getInstance();
		findInqCertificateRule.addEqual("id.clmNo", strAry[0]);
		findInqCertificateRule.addEqual("id.inqNo", strAry[1]);
		List<LLInqCertificate> llInqCertificateList = this.find(LLInqCertificate.class, findInqCertificateRule);
		return llInqCertificateList;
	}
	/**
	 * 查询发起调查的调查费用
	 * @param clmInqStr
	 * @return
	 * @author hesiqi
	 */
	@Override
	public List<LLInqFee> findLLInqFee(String clmInqStr) {
		String[] strAry = clmInqStr.split(",");
		QueryRule findInqFeeRule = QueryRule.getInstance();
		findInqFeeRule.addEqual("id.clmNo", strAry[0]);
		findInqFeeRule.addEqual("id.inqNo", strAry[1]);
		return this.find(LLInqFee.class, findInqFeeRule);
	}
	/**
	 *  根据报案号和客户号查询已发起的调查
	 * @param lcInsured
	 * @param llReport
	 * @return
	 * @author hesiqi
	 */
	@Override
	public Page findLLInqApplyByRptNoInsuredNo(LLSubReport llSubReport, LLReport llReport,
			int pageNo, int pageSize) {
		QueryRule findLLInqApply = QueryRule.getInstance();
		findLLInqApply.addEqual("id.clmNo", llReport.getRptNo());
		findLLInqApply.addEqual("customerNo", llSubReport.getId().getCustomerNo());
		return this.find(findLLInqApply, pageNo, pageSize);
	}
	/**
	 * 取消调查
	 * @param cIBOStr
	 * @param llInqApply
	 * @return
	 * @author hesiqi
	 */
	@Override
	public String cancelSurvey(String cIOStr, LLInqApply llInqApply) {
		
		String[] strAry = cIOStr.split(",");
		QueryRule findInqApplyRule = QueryRule.getInstance();
		findInqApplyRule.addEqual("id.clmNo", strAry[0]);
		findInqApplyRule.addEqual("id.inqNo", strAry[1]);
		LLInqApply inqApply = this.findUnique(findInqApplyRule);
		ActionContext ac = ActionContext.getContext();
		PrpDuser user = (PrpDuser)ac.getSession().get("user");
		System.out.println(user.getUserCode().equals(strAry[2]));
		System.out.println(null==inqApply.getInqConclusion());
		if(user.getUserCode().equals(strAry[2]) && null==inqApply.getInqConclusion() && "01".equals(inqApply.getSurveyFlag())){
			inqApply.setInqCancel(llInqApply.getInqCancel());
			inqApply.setSurveyFlag("00");
			return "Yes";
		}else{
			return "No";
		}
	}
	
}
