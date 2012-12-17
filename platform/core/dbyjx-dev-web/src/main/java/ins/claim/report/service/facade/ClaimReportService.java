package ins.claim.report.service.facade;

import java.util.Date;
import java.util.List;
import java.util.Map;

import ins.framework.common.Page;

import ins.claim.report.model.LLAccident;
import ins.claim.report.model.LLReport;
import ins.claim.report.model.LLReportReason;
import ins.claim.report.model.LLSubReport;

public interface ClaimReportService {
		
	/**
	 * 根据页面录入条件查询llReport和llSubReport表，返回的是组合对象ReportVo
	 * @param llReport  个人报案表
	 * @param llSubReport 报案分案表
	 * @param llReportRela 报案事件关联表
	 * @author 张凯
	 */
	public Page findClaimReport(LLReport llReport,
			LLSubReport llSubReport, Date rptStartDate, Date rptEndDate,
			Date appntStartDate, Date appntEndDate, int pageNo, int pageSize);
	
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
	Page saveBaseInfo(LLReport llReport, LLSubReport llSubReport, LLAccident llAccident, 
			List<LLReportReason> reasonCodeList, int pageNo, int pageSize);
	
	/**
	 * @title findReportInfo
	 * @description TODO
	 * @author Administrator
	 * @create date 2012-8-20
	 * @param llReport
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	Map<String,Object> findReportInfo(LLReport llReport);
	/**
	 * 修改报案基本信息，客户出险信息,事件信息，理赔类型信息
	 * @param llReport
	 * @param llSubReport
	 * @param llAccident
	 * @param reasonCodeList
	 * @author hesiqi
	 */
	void updateBaseInfo(LLReport llReport, LLSubReport llSubReport,
			LLAccident llAccident, List<LLReportReason> reasonCodeList);

}