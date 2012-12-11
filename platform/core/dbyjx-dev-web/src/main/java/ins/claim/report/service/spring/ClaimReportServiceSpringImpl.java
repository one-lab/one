package ins.claim.report.service.spring;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import ins.claim.report.model.LLAccident;
import ins.claim.report.model.LLAccidentSub;
import ins.claim.report.model.LLCaseRela;
import ins.claim.report.model.LLReport;
import ins.claim.report.model.LLReportReason;
import ins.claim.report.model.LLReportRela;
import ins.claim.report.model.LLSubReport;
import ins.claim.report.service.facade.ClaimReportService;

import ins.framework.common.HqlQueryRule;
import ins.framework.common.Page;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.DateUtil;
import ins.platform.common.SerialNoUtil;
import ins.platform.model.PrpDuser;


public class ClaimReportServiceSpringImpl extends
		GenericDaoHibernate<LLReport, String> implements ClaimReportService {
	/**分案事件关联*/
	private LLCaseRela llCaseRela;
	/**分事件*/
	private LLAccidentSub llAccidentSub;
	/**报案理赔类型*/
	private LLReportReason llReportReason;
	
	private LLReportRela llReportRela;
	
	private SerialNoUtil serialNoUtil;

	public SerialNoUtil getSerialNoUtil() {
		return serialNoUtil;
	}

	public void setSerialNoUtil(SerialNoUtil serialNoUtil) {
		this.serialNoUtil = serialNoUtil;
	}
	
	public LLCaseRela getLlCaseRela() {
		return llCaseRela;
	}

	public void setLlCaseRela(LLCaseRela llCaseRela) {
		this.llCaseRela = llCaseRela;
	}
	
	public LLAccidentSub getLlAccidentSub() {
		return llAccidentSub;
	}

	public void setLlAccidentSub(LLAccidentSub llAccidentSub) {
		this.llAccidentSub = llAccidentSub;
	}

	public LLReportReason getLlReportReason() {
		return llReportReason;
	}

	public void setLlReportReason(LLReportReason llReportReason) {
		this.llReportReason = llReportReason;
	}

	public LLReportRela getLlReportRela() {
		return llReportRela;
	}

	public void setLlReportRela(LLReportRela llReportRela) {
		this.llReportRela = llReportRela;
	}

	/**
	 * 根据页面录入条件查询llReport表、llSubReport表，返回的是组合对象ReportVo
	 * @param llReport  个人报案表
	 * @param llSubReport 报案分案表
	 * @param llReportRela 报案事件关联表
	 */
	@Override
	public Page findClaimReport(LLReport llReport,
			LLSubReport llSubReport, Date rptStartDate, Date rptEndDate,
			Date appntStartDate, Date appntEndDate, int pageNo, int pageSize) {
		HqlQueryRule hqlqr = new HqlQueryRule();
		String findReportHql = "      select new ins.claim.report.vo.ClaimReportVo(llReport.rptNo,llReport.rptorName,llReport.rptDate,"
				+ "llSubReport.customerName,llSubReport.sexValue,llReport.accidentDate,llReport.avaiFlagValue) " 
				+ "from LLReport llReport , LLSubReport llSubReport, LLReportRela llReportRela " 
		        + "where llReport.rptNo = llReportRela.id.rptNo and llReportRela.id.subRptNo = llSubReport.id.subRptNo";
		
		//页面条件值获取
		hqlqr.addHql(findReportHql);
		if (null != llReport && (null != llReport.getRptNo() && !"".equals(llReport.getRptNo().trim()))){
			hqlqr.addEqual("llReport.rptNo", llReport.getRptNo());
		}
		if (null != llReport && (null != llReport.getRptorName() && !"".equals(llReport.getRptorName().trim()))){
			hqlqr.addEqual("llReport.rptorName", llReport.getRptorName());
		}
		if (null != llSubReport	&& (null != llSubReport.getPolNo() && !"".equals(llSubReport.getPolNo().trim()))){
			hqlqr.addEqual("llSubReport.polNo", llSubReport.getPolNo());
		}
		if (null != llSubReport	&& (null != llSubReport.getCustomerName() && !"".equals(llSubReport.getCustomerName().trim()))){
			hqlqr.addEqual("llSubReport.customerName", llSubReport.getCustomerName());
		}
		if (null != llSubReport	&& (null != llSubReport.getIdType() && !"".equals(llSubReport.getIdType().trim()))){
			hqlqr.addEqual("llSubReport.idType", llSubReport.getIdType());
		}
		if (null != llSubReport && (null != llSubReport.getIdNo() && !"".equals(llSubReport.getIdNo().trim()))){
			hqlqr.addEqual("llSubReport.idNo", llSubReport.getIdNo());
		}
		
		// addGreaterEqual用于比较日期直接 
		if (null != rptStartDate && !"".equals(rptStartDate)){
			hqlqr.addGreaterEqual("llReport.rptDate", rptStartDate, 16);
		}
		if (null != rptEndDate && !"".equals(rptEndDate)) {
			hqlqr.addLessEqual("llReport.rptDate", rptEndDate, 16);
		}
		if (null != appntStartDate && !"".equals(appntStartDate)){
			hqlqr.addGreaterEqual("llReport.accidentDate", appntStartDate, 16);
		}
		if (null != appntEndDate && !"".equals(appntEndDate)) {
			hqlqr.addLessEqual("llReport.accidentDate", appntEndDate, 16);
		}
		System.out.println(hqlqr.getHql());
		Page page = this.findByHql(hqlqr.getHql(), pageNo, pageSize ,hqlqr.getValues());
		return page;
	}
	
	/**
	 * 保存以下表的基本信息
	 * @param llReport 个人报案表
	 * @param llReportRela 报案事件关联表
	 * @param llSubReport 分案表
	 * @param LLCaseRela 分案事件关联表
	 * @param LLAccident 事件表
	 * @param LLAccidentSub 分事件表
	 * @param LLReportReason 报案理赔类型
	 * @author 张凯
	 */
	@Override
	public Page saveBaseInfo(LLReport llReport, LLSubReport llSubReport, LLAccident llAccident, 
			List<LLReportReason> reasonCodeList, int pageNo, int pageSize) {
		// ----------------为LLReport赋值 begin ----------------------
		llReport.setMakeDate(new Date());
		llReport.setMakeTime(DateUtil.getTime());
		llReport.setModifyDate(new Date());
		llReport.setModifyTime(DateUtil.getTime());
		llReport.setMngCom(llReport.getMngCom().trim());
		llReport.setOperator(llReport.getOperator().trim());
		// Y+管理机构编码前四+年份+四位流水号
		llReport.setRptNo(serialNoUtil.serialNo("llReport", llReport.getMngCom(), "rptNo"));
		llReport.setRelation(llReport.getRelation());
		llReport.setRptDate(llReport.getRptDate());
		llReport.setRptorName(llReport.getRptorName());
		llReport.setRptorPhone(llReport.getRptorPhone());
		llReport.setRptorAddress(llReport.getRptorAddress());
		llReport.setEmail(llReport.getEmail());
		llReport.setRptMode(llReport.getRptMode());
		llReport.setRgtClass(llReport.getRgtClass());
		llReport.setAccidentSite(llReport.getAccidentSite());
		llReport.setAccidentDate(llSubReport.getAccDate());
		// ----------------为LLReport赋值 end ----------------------
		
		// ----------------为LLSubReport赋值 begin ----------------------
		llSubReport.setMakeDate(new Date());
		llSubReport.setMakeTime(DateUtil.getTime());
		llSubReport.setModifyDate(new Date());
		llSubReport.setModifyTime(DateUtil.getTime());
		llSubReport.setMngCom(llReport.getMngCom().trim());
		llSubReport.setOperator(llReport.getOperator().trim());
		// T+管理机构编码前四+年份+四位流水号
		llSubReport.getId().setSubRptNo(serialNoUtil.serialNo("llSubReport", llReport.getMngCom(), "subRptNo"));
		llSubReport.setContactNo(llSubReport.getContactNo());
		llSubReport.setAccCause(llSubReport.getAccCause());
		llSubReport.setAccDate(llSubReport.getAccDate());
		llSubReport.setHospitalCode(llSubReport.getHospitalCode());
		llSubReport.setCureDesc(llSubReport.getCureDesc());
		llSubReport.setAccResult1(llSubReport.getAccResult1());
		llSubReport.setAccResult2(llSubReport.getAccResult2());
		llSubReport.setSectionOffice(llSubReport.getSectionOffice());
		if(llSubReport.getDieDate() != null && !"".equals(llSubReport.getDieDate())){
			llSubReport.setDieDate(llSubReport.getDieDate());
			llSubReport.setDieFlag("1");
		}
		llSubReport.setAccidentDetail(llSubReport.getAccidentDetail());
		llSubReport.setAccDesc(llSubReport.getAccDesc());
		// ----------------为LLSubReport赋值 end ----------------------
		
		// ----------------为LLReportRela赋值 begin ----------------------
		llReportRela.getId().setRptNo(llReport.getRptNo());
		llReportRela.getId().setSubRptNo(llSubReport.getId().getSubRptNo());
		// ----------------为LLReportRela赋值 end ----------------------
		
		// ----------------为LLAccident赋值 begin ----------------------
		llAccident.setMakeDate(new Date());
		llAccident.setMakeTime(DateUtil.getTime());
		llAccident.setModifyDate(new Date());
		llAccident.setModifyTime(DateUtil.getTime());
		llAccident.setMngCom(llReport.getMngCom().trim());
		llAccident.setOperator(llReport.getOperator().trim());
		// A+管理机构编码前四+年份+四位流水号
		llAccident.setAccNo(serialNoUtil.serialNo("llAccident", llReport.getMngCom(), "subRptNo"));
		llAccident.setAccDate(llSubReport.getAccDate());
		llAccident.setAccType(llSubReport.getAccCause());
		llAccident.setAccDesc(llSubReport.getCureDesc());
		llAccident.setAccPlace(llReport.getAccidentSite());
		// ----------------为LLAccident赋值 end ----------------------
		
		// ----------------为LLAccidentSub赋值 begin ----------------------
		llAccidentSub.getId().setAccNo(llAccident.getAccNo());
		llAccidentSub.getId().setCustomerNo(llSubReport.getId().getCustomerNo());
		// ----------------为LLAccidentSub赋值 end ----------------------
		
		// ----------------为LLCaseRela赋值 begin ----------------------
		llCaseRela.getId().setCaseNo(llReport.getRptNo());
		llCaseRela.getId().setCaseRelaNo(llAccident.getAccNo());
		llCaseRela.getId().setSubRptNo(llSubReport.getId().getSubRptNo());
		// ----------------为LLCaseRela赋值 end ----------------------
		
		// ----------------为LLReportReason赋值 begin ----------------------
		
		llReportReason.setMakeDate(new Date());
		llReportReason.setMakeTime(DateUtil.getTime());
		llReportReason.setModifyDate(new Date());
		llReportReason.setModifyTime(DateUtil.getTime());
		llReportReason.setMngCom(llReport.getMngCom().trim());
		llReportReason.setOperator(llReport.getOperator().trim());
		llReportReason.getId().setRpNo(llReport.getRptNo());
		llReportReason.getId().setSubRptNo(llSubReport.getId().getSubRptNo());
		llReportReason.getId().setCustomerNo(llSubReport.getId().getCustomerNo());
		//llReportReason.getId().setReasonCode(reasonCode.get(index));
		// ----------------为LLReportReason赋值 end ----------------------
		
//		this.save(llReport);
//		//this.flush();
//		
//		this.save(llSubReport);
//		
//		this.save(llReportRela);
//		
//		this.save(llAccident);
//		
//		this.save(llAccidentSub);
//		
//		this.save(llCaseRela);
//		
//		this.save(llReportReason);
		
		return null;
	}

	/* 
	 * @title findReportInfo
	 * @description 根据报案号查询报案出险详细信息
	 * @author zhangkai
	 */
	@Override
	public Map<String,Object> findReportInfo(LLReport llReport) {
		
		//查询LLReport报案表，主键rptNo报案号
		String llReportHql = "from LLReport llReport where llReport.rptNo = '"+llReport.getRptNo()+"'";
		LLReport llReportTemp = (LLReport) this.findByHql(llReportHql, null).get(0);
		
		//查询LLAccident事件表
		String llAccidentHql = "from LLAccident llAccident where llAccident.accNo = (select llCaseRela.id.caseRelaNo from LLCaseRela llCaseRela where llCaseRela.id.caseNo = '" + llReport.getRptNo() + "')";
		List<LLAccident> llAccidentList = this.findByHql(llAccidentHql, null);
		
		//查询LLSubReport分案表
		String llSubReportHql = "from LLSubReport llSubReport where llSubReport.id.subRptNo = (select llReportRela.id.subRptNo from LLReportRela llReportRela where llReportRela.id.rptNo = '" + llReport.getRptNo() + "')";
		List<LLSubReport> llSubReportList = this.findByHql(llSubReportHql, null);
		
		//查询LLReportReason报案理赔类型表
		//TODO:
//		String llReportReasonHql = "from LLReportReason llReportReason where llReportReason.id.rpNo = '"+llReport.getRptNo()+"'";
//		List<LLReportReason> llReportReasonList = this.findByHql(llReportReasonHql, null);
		
		//返回信息
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("llReport", llReportTemp);
		map.put("llAccidentList", llAccidentList);
		map.put("llSubReportList", llSubReportList);
//		map.put("llReportReasonList", llReportReasonList);
		
		return map;
	}
	/**
	 * 修改报案基本信息，客户出险信息,事件信息，理赔类型信息
	 * @param llReport
	 * @param llSubReport
	 * @param llAccident
	 * @param reasonCodeList
	 * @author hesiqi
	 */
	@Override
	public void updateBaseInfo(LLReport llReport, LLSubReport llSubReport,
			LLAccident llAccident, List<LLReportReason> reasonCodeList) {
		ActionContext ac = ActionContext.getContext();
		PrpDuser user = (PrpDuser) ac.getSession().get("user");
		LLReport llReportTemp = this.findUnique("rptNo", llReport.getRptNo());
		//个人报案表修改
		llReportTemp.setRgtClass(llReport.getRgtClass());
		llReportTemp.setRptMode(llReport.getRptMode());
		llReportTemp.setRelation(llReport.getRelation());
		llReportTemp.setRptorName(llReport.getRptorName());
		llReportTemp.setRptorAddress(llReport.getRptorAddress());
		llReportTemp.setRptorPhone(llReport.getRptorPhone());
		llReportTemp.setPostCode(llReport.getPostCode());
		llReportTemp.setAccidentDate(llReport.getAccidentDate());
		llReportTemp.setAccidentSite(llReport.getAccidentSite());
		llReportTemp.setAccidentReason(llSubReport.getAccCause());
		llReportTemp.setRptDate(llReport.getRptDate());
		llReportTemp.setMngCom(llReport.getMngCom());
		llReportTemp.setOperator(user.getUserCode());
		llReportTemp.setModifyDate(new Date());
		llReportTemp.setModifyTime(DateUtil.getTime());
		//事件表修改
		String llAccidentHql = "from LLAccident llAccident where llAccident.accNo = (select llCaseRela.id.caseRelaNo from LLCaseRela llCaseRela where llCaseRela.id.caseNo = ?)";
		List<LLAccident> llAccidentList = this.findByHql(llAccidentHql, llReport.getRptNo());
		LLAccident llAccidentTemp = llAccidentList.get(0);
		llAccidentTemp.setAccDate(llAccident.getAccDate());
		llAccidentTemp.setAccDesc(llAccident.getAccDesc());
		llAccidentTemp.setAccPlace(llReport.getAccidentSite());
		llAccidentTemp.setOperator(user.getUserCode());
		llAccidentTemp.setMngCom(llReport.getMngCom());
		llAccidentTemp.setModifyDate(new Date());
		llAccidentTemp.setModifyTime(DateUtil.getTime());
		//分案表修改
		String llSubReportHql = "from LLSubReport llSubReport where llSubReport.id.subRptNo = (select llReportRela.id.subRptNo from LLReportRela llReportRela where llReportRela.id.rptNo = ?)";
		List<LLSubReport> llSubReportList = this.findByHql(llSubReportHql, llReport.getRptNo());
		LLSubReport llSubReportTemp = llSubReportList.get(0);
		llSubReportTemp.setCustomerName(llSubReport.getCustomerName());
		llSubReportTemp.setAccDate(llReport.getAccidentDate());
		llSubReportTemp.setAccDesc(llSubReport.getAccDesc());
		llSubReportTemp.setAccPlace(llReport.getAccidentSite());
		llSubReportTemp.setHospitalCode(llSubReport.getHospitalCode());
		llSubReportTemp.setHospitalName(llSubReport.getHospitalName());
		llSubReportTemp.setOperator(user.getUserCode());
		llSubReportTemp.setMngCom(llReport.getMngCom());
		llSubReportTemp.setModifyDate(new Date());
		llSubReportTemp.setModifyTime(DateUtil.getTime());
		if(llSubReport.getDieDate() != null){
			llSubReportTemp.setDieDate(llSubReport.getDieDate());
			llSubReportTemp.setDieFlag("1");
		}
		llSubReportTemp.setAccidentDetail(llSubReport.getAccidentDetail());
		llSubReportTemp.setCureDesc(llSubReport.getCureDesc());
		llSubReportTemp.setAccResult1(llSubReport.getAccResult1());
		llSubReportTemp.setAccResult2(llSubReport.getAccResult2());
		llSubReportTemp.setContactNo(llSubReport.getContactNo());
		llSubReportTemp.setSectionOffice(llSubReport.getSectionOffice());
		llSubReportTemp.setCustomerSex(llSubReport.getCustomerSex());
		//保存
		this.save(llReportTemp);
		this.save(llSubReportTemp);
		this.save(llAccidentTemp);
	}
	
}
