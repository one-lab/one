package ins.prpall.report.service.facade;

import ins.framework.common.Page;
import ins.prpall.report.model.LCContPlanDutyParamReport;
import ins.prpall.report.model.LCContPlanReport;
import ins.prpall.report.model.LCContPlanRiskReport;
import ins.prpall.report.model.LCDutyReport;
import ins.prpall.report.model.LCGrpContReport;
import ins.prpall.report.model.LCReport;

import java.util.List;
import java.util.Map;

public interface LCContPlanReportService {
	/**
	 * 保存保障计划
	 * 
	 * @param lcContPlanReport
	 * @param lcContPlanRiskReportList
	 * @param lcContPlanDutyParamReportList
	 */
	boolean saveContPlan(LCContPlanReport lcContPlanReport,List<LCContPlanRiskReport> lcContPlanRiskReportList,
			List<LCDutyReport> lcDutyReportList,List<LCContPlanDutyParamReport> lcContPlanDutyParamReportList);

	/**
	 * 呈报保险计划初始化页面方法
	 * @param repNo 呈报申请号      
	 * @author 于文龙
	 */
	Map<String,Object> initializeEnsurePlan(LCGrpContReport lcGrpContReport);

	/**
	 * 
	 * @title deleteConPlan
	 * @description 呈报保障计划及其相关表的删除
	 * @author 于文龙
	 * @param lcContPlanReport
	 * @return
	 */
	Map<String, Object> deleteConPlan(LCContPlanReport lcContPlanReport);
	/**
	 * 保障计划的更新
	 * @param lcContPlanReport 保障计划表
	 * @param lcContPlanRiskReportList 险种表
	 * @param lcContPlanDutyParamReportList 责任表
	 * @author 于文龙
	 */
	Map<String,Object> updateConPlan(LCContPlanReport lcContPlanReport,
			List<LCContPlanRiskReport> lcContPlanRiskReportList,
			List<LCContPlanDutyParamReport> lcContPlanDutyParamReportList);
	/**
	 * 
	 * @title findCalMode
	 * @description 查找计算公式
	 * @author 于文龙
	 */
	String findCalMode(LCDutyReport lcDutyReport);
}
