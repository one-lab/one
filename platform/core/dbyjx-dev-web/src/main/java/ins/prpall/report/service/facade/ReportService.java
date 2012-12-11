package ins.prpall.report.service.facade;

import ins.framework.common.Page;
import ins.platform.model.PrpDuser;
import ins.prpall.proposal.model.LCBnf;
import ins.prpall.proposal.model.LCInsured;
import ins.prpall.proposal.model.LCRepFile;
import ins.prpall.proposal.model.LCRepInfo;
import ins.prpall.proposal.model.LDGrp;
import ins.prpall.report.model.LCActuarialAudit;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface ReportService {
	/**
	 * 保存以下表的基本信息
	 * @param lcReport呈报基本表
	 * @param ldGrp团体客户表
	 * @param lcRepInfo呈报信息告知表
	 * @param lcGrpAppReport呈报团单投保人表
	 * @param lcGrpContReport呈报集体保单表
	 */
	Map<String,Object> saveBaseInfo(LCReport lcReport, LDGrp ldGrp,
			List<LCRepInfoReport> lcRepInfoReportList,LCRepInfoReportDetail lcRepInfoReportDetail, LCGrpAppReport lcGrpAppReport,
			LCGrpContReport lcGrpContReport);
	/**
	 * 更新以下表的基本信息
	 * @param lcReport呈报基本表
	 * @param ldGrp团体客户表
	 * @param lcRepInfo呈报信息告知表
	 * @param lcGrpAppReport呈报团单投保人表
	 * @param lcGrpContReport呈报集体保单表
	 */
	Map<String,Object> updateBaseInfo(LCReport lcReport, LDGrp ldGrp,
			List<LCRepInfoReport> lcRepInfoReportList,LCRepInfoReportDetail lcRepInfoReportDetail, LCGrpAppReport lcGrpAppReport,
			LCGrpContReport lcGrpContReport)throws ParseException ;
	
	/**
	 * 根据页面录入条件查询lcreport和ldgrp表，返回的是组合对象ReportVo
	 * @param lcReport  呈报基础表
	 * @param ldGrp  客户表
	 * @return
	 */
	Page findReport(LCReport lcReport, LDGrp ldGrp, int pageNo,
			int pageSize);
	
	/**
	 * 根据主键查出:
	 * lcReport呈报基本表
	 * ldGrp团体客户表
	 * lcRepInfo呈报信息告知表
	 * lcGrpAppReport呈报团单投保人表
	 * lcGrpContReport呈报集体保单表
	 * 的基本信息准备展示在页面上
	 * @param repNo 呈报号--主键
	 * @return 将上面查询出来的对象装在map中
	 */
	Map<String, Object> findByRepNo(String repNo);
	/**
	 * 为呈报增加险种
	 * @param lcGrpPolReport 集体险种表
	 * @return
	 */
	LCGrpPolReport addRisk(LCGrpPolReport lcGrpPolReport);
	/**
	 * 
	 * @title 
	 * @description 删除险种
	 * @param lcGrpPolReport
	 * @author 于文龙
	 */
	LCGrpPolReport deleRisk(LCGrpPolReport lcGrpPolReport);
	/**
	 * 
	 * @title initialReportAudit
	 * @description 呈报审核初始化
	 * @param pageNo
	 * @param pageSize
	 * @author 于文龙
	 */
	List<LCReport> initialReportAudit(int pageNo,int pageSize);
	/**
	 * 根据页面录入的查询条件查询呈报表LcReport
	 * @return page
	 */
	Map<String,Object> findReportAudit(LCReport lcReport, int pageNo, int pageSize);
	/**
	 * 申请呈报表
	 *
	 */
	Map<String,Object> applyReportAudit(LCReport lcReport, int pageNo, int pageSize);
	/**
	 * 呈报表查看
	 */
	Map<String,Object> applyReportView(LCReportAudit lcReportAudit,int pageNo,int pageSize);
	/**
	 * 呈报表确认
	 */
	Page reportAuditCommit(LCReportAudit lcReportAudit,int pageNo,int pageSize);
	/**
	 * 
	 * @title openPrpallSearch
	 * @description 发起契调
	 * @param lcReport
	 * @return
	 * @author 于文龙
	 */
	Map<String,Object> openPrpallSearch(LCReport lcReport);
	/**
	 * 契调信息保存
	 */
	boolean reportConSave(PropallSearchInfo propallSearchInfo,List<PropallSearchItem> propallSearchItemList);
	
	/**
	 * 上传附件
	 * @author 于文龙
	 */
	Map<String,Object> reportFileUpload(MultipartFile file,LCRepFile lcReportFile,String path,int pageNo,int pageSize);
	/**
	 *告知单、受益人、被保险人信息保存
	 *
	 *@author 于文龙
	 */
	Map<String,Object> saveAllInfo(LCInsured lcInsured,List<LCRepInfo> lcRepInfoList,List<LCBnf> lcBnfList);
	
	/**根据客户号投保申请号查询投保单位资料
	 * @param 客户号
	 * @param 呈报申请号
	 * @author 郭占红
	 */
	Page findInfoByCustomerNo(LDGrp ldGrp);
	 /** 根据页面录入条件查询lcreport和lcReportAudit表，返回的是组合对象ReportQueryResultVo
	 * @param lcReport  呈报基础表
	 * @author 郭占红
	 */
	Page findReportResult(LCReport lcReport,int pageNo,int pageSize);
	/**根据呈报申请号查询呈报返回信息
	 * @param repNo
	 * @author 郭占红
	 */
	List<LCReportAudit> findReportReturningInfo(String repNo,int serialNo);
	
	/**
	 * 再保审核信息查询
	 * @param lcReport 
	 * @param pageNo
	 * @param pageSize
	 * @return 
	 * @author xueyuqiang
	 */
	Page findReinsAuditInfo(LCReport lcReport,int pageNo,int pageSize);
	/**
	 * 
	 * @title findAuditIdea
	 * @description 再保审核中查询承包审核表中的审核信息
	 * @author xueyuqiang
	 * @create_date 2012-8-1
	 * @param lcReportAudit
	 * @return
	 */
	List<LCReinsAudit> findAuditIdea(LCReinsAudit lcReinsAudit);
	
	/**
	 * 
	 * @title saveAuditResultAndIdea
	 * @description 保存再保审核中审核意见和核保结论
	 * @author xueyuqiang
	 * @param user
	 * @param lcReportAudit
	 * @return
	 */
	boolean saveAuditResultAndIdea(PrpDuser user,LCReinsAudit lcReinsAudit);
	
	/**
	 * 
	 * @title findActuarialReport
	 * @description 精算审核－查询呈报审核信息
	 * @author xuxinling
	 * @create_date 2012-7-31
	 * @param lcReport 呈报类对象
	 * @param pageNo 当前页码
	 * @param pageSize 每页条数
	 * @return
	 */
	Page findActuarialReport(LCReport lcReport, int pageNo, int pageSize);

	/**
	 *
	 * @title findReportIdeaByrepNo
	 * @description 根据 呈报号查询呈报审核意见
	 * @author xu_xinling
	 * @create date 2012-7-31
	 * @param lcReport 呈报类对象
	 * @return 呈报审核类集合
	 */
	List<LCActuarialAudit> findReportIdeaByrepNo(LCActuarialAudit lcActuarialAudit);
	/**
	 * 
	 * @title findAIdeaByrepNo
	 * @description 根据 呈报号查询呈报审核意见住处
	 * @author xu_xinling
	 * @create date 2012-8-2
	 * @param repNo 呈报号
	 * @return
	 */
	List<LCActuarialAudit> findAIdeaByrepNo(String repNo);
	/**
	 * 
	 * @title saveActuarialAuditIdea
	 * @description 保存精审意见
	 * @author 
	 * @create date 2012-8-1
	 * @param lcReportAudit
	 * @param currentUser
	 * @return
	 */
	boolean saveActuarialAuditIdea(LCActuarialAudit lcActuarialAudit,PrpDuser currentUser);

	/**
	 * 
	 * @title deleteReport
	 * @description 删除呈报表信息
	 * @param lcReport
	 * @author 于文龙
	 */
	Map<String,Object> deleteReport(LCReport lcReport);
	/**
	 * 查询上传附件的信息
	 * @param lcRepFile
	 * @param pageNo
	 * @param pageSize
	 * @author 于文龙
	 */
	Map<String,Object> findFileInfo(LCRepFile lcRepFile,int pageNo,int pageSize);
	/**
	 * @title 
	 * @description 查询LCRpoert表的相关信息
	 * @param lcReport
	 * @author 于文龙
	 */
	Map<String,Object> findReportAllInfo(LCReport lcReport);
}

