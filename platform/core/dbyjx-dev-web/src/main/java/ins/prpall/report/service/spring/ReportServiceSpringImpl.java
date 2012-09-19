package ins.prpall.report.service.spring;

import ins.framework.common.HqlQueryRule;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.DateUtil;
import ins.platform.common.SerialNoUtil;
import ins.platform.model.PrpDcompany;
import ins.platform.model.PrpDuser;
import ins.product.model.PDLMRisk;
import ins.prpall.proposal.model.LCBnf;
import ins.prpall.proposal.model.LCInsured;
import ins.prpall.proposal.model.LCRepFile;
import ins.prpall.proposal.model.LCRepInfo;
import ins.prpall.proposal.model.LDGrp;
import ins.prpall.report.model.LCActuarialAudit;
import ins.prpall.report.model.LCActuarialAuditId;
import ins.prpall.report.model.LCGrpAppReport;
import ins.prpall.report.model.LCGrpAppReportId;
import ins.prpall.report.model.LCGrpContReport;
import ins.prpall.report.model.LCGrpContReportId;
import ins.prpall.report.model.LCGrpPolReport;
import ins.prpall.report.model.LCReinsAudit;
import ins.prpall.report.model.LCReinsAuditId;
import ins.prpall.report.model.LCRepInfoReport;
import ins.prpall.report.model.LCRepInfoReportDetail;
import ins.prpall.report.model.LCReport;
import ins.prpall.report.model.LCReportAudit;
import ins.prpall.report.model.PropallSearchInfo;
import ins.prpall.report.model.PropallSearchItem;
import ins.prpall.report.service.facade.ReportService;
import ins.prpall.report.vo.ReportAuditVo;

import java.io.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import org.springframework.web.multipart.MultipartFile;

public class ReportServiceSpringImpl extends
		GenericDaoHibernate<LCReport, String> implements ReportService {
	private SerialNoUtil serialNoUtil;

	public SerialNoUtil getSerialNoUtil() {
		return serialNoUtil;
	}

	public void setSerialNoUtil(SerialNoUtil serialNoUtil) {
		this.serialNoUtil = serialNoUtil;
	}
	/**
	 * 保存以下表的基本信息
	 * @param lcReport呈报基本表
	 * @param ldGrp团体客户表
	 * @param lcRepInfo呈报信息告知表
	 * @param lcGrpAppReport呈报团单投保人表
	 * @param lcGrpContReport呈报集体保单表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String,Object> saveBaseInfo(LCReport lcReport, LDGrp ldGrp,
			List<LCRepInfoReport> lcRepInfoReportList,LCRepInfoReportDetail lcRepInfoReportDetail, LCGrpAppReport lcGrpAppReport,
			LCGrpContReport lcGrpContReport) {
		// ----------------为呈报表LCReport赋值 begin ----------------------
		ActionContext ac = ActionContext.getContext();
		PrpDuser user = (PrpDuser)ac.getSession().get("user");
		lcReport.setRepOperator(user.getUserName());
		lcReport.setRepApplyDate(new Date());
		lcReport.setName(ldGrp.getGrpName());
		lcReport.setMakeDate(new Date());
		lcReport.setMakeTime(DateUtil.getTime());
		lcReport.setModifyDate(new Date());
		lcReport.setModifyTime(DateUtil.getTime());
		lcReport.setState("新呈报件");
		lcReport.setSerialNo(1);
		lcReport.setServiceType(lcReport.getServiceType().trim());
		lcReport.setBussinessFlag(lcReport.getBussinessFlag().trim());
		// S+管理机构编码前四+年份+四位流水号
		lcReport.setRepNo(serialNoUtil.serialNo("lcReport",
				lcReport.getManageCom(), "repNo"));
		// ----------------为LCReport赋值 end ----------------------
		//集体合同号码自动生成
		String grpContNo=serialNoUtil.serialNo("lcGrpAppReport", lcReport.getManageCom(), "GRPCONTNO");
		//集体投保单号自动生成
		String proposalGrpNo=serialNoUtil.serialNo("LCGRPCONTREPORT", lcReport.getManageCom(), "PROPOSALGRPCONTNO");
		

		// ----------------为团体客户表ldGrp赋值 begin-------------------
		if(null==ldGrp.getCustomerNo()||"".equals(ldGrp.getCustomerNo())){
			ldGrp.setCustomerNo(serialNoUtil.serialNo("LDGRP",lcReport.getManageCom(), "customerNo"));
			ldGrp.setOperator(user.getUserName());
			ldGrp.setOperator(lcReport.getRepOperator());
			ldGrp.setMakeDate(lcReport.getMakeDate());
			ldGrp.setMakeTime(lcReport.getMakeTime());
			ldGrp.setModifyDate(lcReport.getModifyDate());
			ldGrp.setModifyTime(lcReport.getModifyTime());
			this.save(ldGrp);
		}		
		//呈报表的客户号
		lcReport.setAppNo(ldGrp.getCustomerNo());
		// ----------------为ldGrp赋值 end-------------------

		// ----------------为呈报团单投保人表lcGrpAppReport赋值 begin-------------------
		LCGrpAppReportId garid = new LCGrpAppReportId();
		garid.setGrpContNo(grpContNo);
		garid.setRepNo(lcReport.getRepNo());
		lcGrpAppReport.setId(garid);
		lcGrpAppReport.setOperator(user.getUserName());
		lcGrpAppReport.setName(ldGrp.getGrpName());
		lcGrpAppReport.setRepOperator(lcReport.getRepOperator());
		lcGrpAppReport.setRepApplyDate(lcReport.getRepApplyDate());
		lcGrpAppReport.setCustomerNo(ldGrp.getCustomerNo());
		//TODO：印刷号码为申请号还是集体合同号 于文龙
		lcGrpAppReport.setPrtNo(lcReport.getRepNo());
		lcGrpAppReport.setOperator(lcReport.getRepOperator());
		lcGrpAppReport.setMakeDate(lcReport.getMakeDate());
		lcGrpAppReport.setMakeTime(lcReport.getMakeTime());
		lcGrpAppReport.setModifyDate(lcReport.getModifyDate());
		lcGrpAppReport.setModifyTime(lcReport.getModifyTime());
		// ----------------为lcGrpAppReport赋值 end-------------------

		// ----------------为呈报集体保单表lcGrpContReport赋值 begin-------------------
		LCGrpContReportId gcrid = new LCGrpContReportId();
		//集体合同号
		gcrid.setGrpContNo(grpContNo);
		gcrid.setRepNo(lcReport.getRepNo());
		lcGrpContReport.setId(gcrid);
		lcGrpContReport.setRepOperator(lcReport.getRepOperator());
		lcGrpContReport.setRepApplyDate(lcReport.getRepApplyDate());
		lcGrpContReport.setManageCom(lcReport.getManageCom());
		//集体投保单号码
		lcGrpContReport.setProposalGrpContNo(proposalGrpNo);
		lcGrpContReport.setAppntNo(ldGrp.getCustomerNo());
		lcGrpContReport.setGrpName(ldGrp.getGrpName());
		lcGrpContReport.setAddressNo(lcGrpAppReport.getAddressNo());
		lcGrpContReport.setOperator(lcReport.getRepOperator());
		lcGrpContReport.setMakeDate(lcReport.getMakeDate());
		lcGrpContReport.setMakeTime(lcReport.getMakeTime());
		lcGrpContReport.setModifyDate(lcReport.getModifyDate());
		lcGrpContReport.setModifyTime(lcReport.getModifyTime());
		// ----------------为lcGrpContReport赋值 end-------------------
		
		// ----------------为呈报告知单信息lcRepInfoReportList赋值 begin-------------------
		for (int i = 0; i < lcRepInfoReportList.size(); i++) {
			//呈报号
			lcRepInfoReportList.get(i).getId().setRepNo(lcReport.getRepNo());
			// 集体合同号
			lcRepInfoReportList.get(i).setGrpContNo(grpContNo);
			// 印刷号码为申请号
			lcRepInfoReportList.get(i).setPrtNo(lcReport.getRepNo());
			//内部流水号
			// 流水号取得
			int number = 0;
			if (null != lcRepInfoReportList.get(i).getId().getRepNo()&& null != lcRepInfoReportList.get(i).getId().getImpartCode()
					&& null != lcRepInfoReportList.get(i).getId().getImpartVer()&&0==lcRepInfoReportList.get(i).getId().getSubSerialNo()) {
				QueryRule lcRepInfoReportRule=QueryRule.getInstance();
				lcRepInfoReportRule.addEqual("id.repNo", lcRepInfoReportList.get(i).getId().getRepNo());
				lcRepInfoReportRule.addEqual("id.impartCode", lcRepInfoReportList.get(i).getId().getImpartCode());
				lcRepInfoReportRule.addEqual("id.impartVer", lcRepInfoReportList.get(i).getId().getImpartVer());
				List<LCRepInfo> tempList = this.find(LCRepInfoReport.class, lcRepInfoReportRule);
			number=tempList.size()+1;
			}
			lcRepInfoReportList.get(i).getId().setSubSerialNo(number);
			lcRepInfoReportList.get(i).setOperator(lcReport.getRepOperator());
			lcRepInfoReportList.get(i).setMakeDate(lcReport.getMakeDate());
			lcRepInfoReportList.get(i).setMakeTime(lcReport.getMakeTime());
			lcRepInfoReportList.get(i).setModifyDate(lcReport.getModifyDate());
			lcRepInfoReportList.get(i).setModifyTime(lcReport.getModifyTime());
		}
		// ----------------为呈报告知单信息lcRepInfoReportList赋值 end-------------------

		// -----------------为呈报团体投保单告知明细lcRepInfoReportDetail赋值begin-------
		lcRepInfoReportDetail.setRepNo(lcReport.getRepNo());
		lcRepInfoReportDetail.setGrpContNo(grpContNo);
		lcRepInfoReportDetail.setPrtNo(lcReport.getRepNo());
		lcRepInfoReportDetail.setOperator(lcReport.getRepOperator());
		lcRepInfoReportDetail.setMakeDate(lcReport.getMakeDate());
		lcRepInfoReportDetail.setMakeTime(lcReport.getModifyTime());
		lcRepInfoReportDetail.setModifyDate(lcReport.getMakeDate());
		lcRepInfoReportDetail.setModifyTime(lcReport.getModifyTime());
		// -----------------为呈报团体投保单告知明细lcRepInfoReportDetail赋值end---------
		//呈报表
		this.flush();
		this.save(lcReport);
		this.flush();
		//System.out.println("ok");
		//TODO:
		//团体客户表
		
		///System.out.println("ok");
		this.flush();
		//呈报团单投保人表
		this.save(lcGrpAppReport);
		this.flush();
		//System.out.println("ok");
		//呈报集体保单表
		this.save(lcGrpContReport);
		//System.out.println("ok");
		this.flush();
		//投保单告知信息表List
		this.saveAll(lcRepInfoReportList);
		//System.out.println("ok");
		//投保单告知信息明细表
		this.save(lcRepInfoReportDetail);
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("lcReport", lcReport);
		dataMap.put("lcGrpAppReport", lcGrpAppReport);
		dataMap.put("lcGrpContReport", lcGrpContReport);
		dataMap.put("ldGrp", ldGrp);
		dataMap.put("lcRepInfoReportList", lcRepInfoReportList);
		dataMap.put("lcRepInfoReportDetail", lcRepInfoReportDetail);
		return dataMap;
	}
	/**
	 * 更新以下表的基本信息
	 * @param lcReport呈报基本表
	 * @param ldGrp团体客户表
	 * @param lcRepInfo呈报信息告知表
	 * @param lcGrpAppReport呈报团单投保人表
	 * @param lcGrpContReport呈报集体保单表
	 * @throws java.text.ParseException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> updateBaseInfo(LCReport lcReport, LDGrp ldGrp,
			List<LCRepInfoReport> lcRepInfoReportList,LCRepInfoReportDetail lcRepInfoReportDetail, LCGrpAppReport lcGrpAppReport,
			LCGrpContReport lcGrpContReport) throws ParseException {
		// ----------------为LCReport赋值 begin ----------------------
		LCReport lcReportTemp=null;
		if(null!=lcReport.getRepNo()&&!"".equals(lcReport.getRepNo())){
			lcReportTemp=this.findUnique("repNo", lcReport.getRepNo());
			lcReportTemp.setModifyDate(DateUtil.getDate());
			lcReportTemp.setModifyTime(DateUtil.getTime());
			lcReportTemp.setRepApplyDate(lcReport.getRepApplyDate());
			lcReportTemp.setManageCom(lcReport.getManageCom().trim());
			lcReportTemp.setRepOperator(lcReport.getRepOperator());
			lcReportTemp.setAgentCode(lcReport.getAgentCode());
			lcReportTemp.setServiceType(lcReport.getServiceType());
			lcReportTemp.setBussinessFlag(lcReport.getBussinessFlag());
			this.update(lcReportTemp);
		}
		// ----------------为LCReport赋值 end ----------------------

		// ----------------为ldGrp赋值 begin-------------------
		LDGrp ldGrpTemp=null;
		if(null!=ldGrp.getCustomerNo()&&!"".equals(ldGrp.getCustomerNo())){
			 ldGrpTemp=this.findUnique(LDGrp.class, "customerNo", ldGrp.getCustomerNo());
			ldGrpTemp.setModifyDate(DateUtil.getDate());
			ldGrpTemp.setModifyTime(DateUtil.getTime());
			ldGrpTemp.setVipValue(ldGrp.getVipValue().trim());
			ldGrpTemp.setGrpName(ldGrp.getGrpName());
			ldGrpTemp.setBusinessType(ldGrp.getBusinessType().trim());
			ldGrpTemp.setOrganizationNo(ldGrp.getOrganizationNo());
			ldGrpTemp.setAsset(ldGrp.getAsset());
			ldGrpTemp.setTaxRegistNo(ldGrp.getTaxRegistNo());
			ldGrpTemp.setYearGrossIncome(ldGrp.getYearGrossIncome());
			ldGrpTemp.setGrpNature(ldGrp.getGrpNature());
			ldGrpTemp.setFoundDate(ldGrp.getFoundDate());
			ldGrpTemp.setOperateArea(ldGrp.getOperateArea().trim());
			ldGrpTemp.setMainBussiness(ldGrp.getMainBussiness());
			ldGrpTemp.setGrpPeoples(ldGrp.getGrpPeoples().trim());
			this.update(ldGrpTemp);
		}
		// ----------------为ldGrp赋值 end-------------------

		

		// ----------------为lcGrpAppReport赋值 begin-------------------
		LCGrpAppReport lcGrpAppReportTemp=null;
		if(null!=lcGrpAppReport.getId().getGrpContNo()&&!"".equals(lcGrpAppReport.getId().getGrpContNo())){
			QueryRule grpAppRule=QueryRule.getInstance();
			grpAppRule.addEqual("id.grpContNo", lcGrpAppReport.getId().getGrpContNo());
			grpAppRule.addEqual("id.repNo", lcReport.getRepNo());
			lcGrpAppReportTemp=this.findUnique(LCGrpAppReport.class, grpAppRule);
			
			lcGrpAppReportTemp.setModifyDate(DateUtil.getDate());
			lcGrpAppReportTemp.setModifyTime(DateUtil.getTime());
			
			lcGrpAppReportTemp.setName(ldGrp.getGrpName());
			lcGrpAppReportTemp.setRepOperator(lcReport.getRepOperator());
			
			lcGrpAppReportTemp.setCustomerNo(ldGrp.getCustomerNo());
			lcGrpAppReportTemp.setPrtNo(lcReport.getRepNo());
			lcGrpAppReportTemp.setSocietyStat(lcGrpAppReport.getSocietyStat());
			lcGrpAppReportTemp.setSocietyRegistNo(lcGrpAppReport.getSocietyRegistNo());
			lcGrpAppReportTemp.setAddressNo(lcGrpAppReport.getAddressNo());
			lcGrpAppReportTemp.setPostalAddress(lcGrpAppReport.getPostalAddress());
			lcGrpAppReportTemp.setZipCode(lcGrpAppReport.getZipCode());
			lcGrpAppReportTemp.setPhone(lcGrpAppReport.getPhone());
			lcGrpAppReportTemp.setPeople(lcGrpAppReport.getPeople());
			lcGrpAppReportTemp.setPeopleSex(lcGrpAppReport.getPeopleSex().trim());
			lcGrpAppReportTemp.setPeopleTel(lcGrpAppReport.getPeopleTel());
			lcGrpAppReportTemp.setPeoplePhone(lcGrpAppReport.getPeoplePhone());
			lcGrpAppReportTemp.setEmail(lcGrpAppReport.getEmail());
			this.update(lcGrpAppReportTemp);
		}
		// ----------------为lcGrpAppReport赋值 end-------------------

		// ----------------为lcGrpContReport赋值 begin-------------------
		LCGrpContReport lcGrpContReportTemp=null;
		if(null!=lcGrpAppReport.getId().getGrpContNo()&&!"".equals(lcGrpAppReport.getId().getGrpContNo())){
		QueryRule grpContRule=QueryRule.getInstance();
		grpContRule.addEqual("id.repNo", lcReport.getRepNo());
		grpContRule.addEqual("id.grpContNo", lcGrpAppReport.getId().getGrpContNo());
		 lcGrpContReportTemp=this.findUnique(LCGrpContReport.class, grpContRule);
		
		lcGrpContReportTemp.setModifyDate(DateUtil.getDate());
		lcGrpContReportTemp.setModifyTime(DateUtil.getTime());
		
		lcGrpContReportTemp.setRepOperator(lcReport.getRepOperator());
		lcGrpContReportTemp.setAppntNo(ldGrp.getCustomerNo());
		lcGrpContReportTemp.setGrpName(ldGrp.getGrpName());
		lcGrpContReportTemp.setAddressNo(lcGrpAppReport.getAddressNo());
		
		lcGrpContReportTemp.setCorporation(lcGrpContReport.getCorporation());
		lcGrpContReportTemp.setCorporationIDType(lcGrpContReport.getCorporationIDType());
		lcGrpContReportTemp.setCorporationIDNo(lcGrpContReport.getCorporationIDNo());
		lcGrpContReportTemp.setCorporationsDate(lcGrpContReport.getCorporationsDate());
		lcGrpContReportTemp.setGrpPeoples(lcGrpContReport.getGrpPeoples());
		lcGrpContReportTemp.setMainInsurePersonNumber(lcGrpContReport.getMainInsurePersonNumber());
		lcGrpContReportTemp.setRelatedInsurePersonNumber(lcGrpContReport.getRelatedInsurePersonNumber());
		lcGrpContReportTemp.setRate(lcGrpContReport.getRate());
		lcGrpContReportTemp.setPremClearingForm(lcGrpContReport.getPremClearingForm());
		lcGrpContReportTemp.setUnitsBurden(lcGrpContReport.getUnitsBurden());
		lcGrpContReportTemp.setSpecNo(lcGrpContReport.getSpecNo());
		lcGrpContReportTemp.setSpecNoName(lcGrpContReport.getSpecNoName());
		this.update(lcGrpContReportTemp);
		}
		// ----------------为lcGrpContReport赋值 end-------------------
		
		// ----------------为lcRepInfoReportList赋值 begin-------------------
		List<LCRepInfoReport> lcRepInfoTempList=null;
		if(null!=lcReport.getRepNo()&&!"".equals(lcReport.getRepNo())){
			QueryRule repInfoRule=QueryRule.getInstance();
			repInfoRule.addEqual("id.repNo", lcReport.getRepNo());
			lcRepInfoTempList=this.find(LCRepInfoReport.class,repInfoRule);
			for(int i=0;i<lcRepInfoTempList.size();i++){
				for(int n=0;n<lcRepInfoReportList.size();n++){
					if(lcRepInfoTempList.get(i).getId().getSubSerialNo()==lcRepInfoReportList.get(n).getId().getSubSerialNo()){
						lcRepInfoTempList.get(i).getId().setImpartCode(lcRepInfoReportList.get(n).getId().getImpartCode());
						lcRepInfoTempList.get(i).getId().setImpartVer(lcRepInfoReportList.get(n).getId().getImpartVer());
						lcRepInfoTempList.get(i).setImpartDetailContent(lcRepInfoReportList.get(n).getImpartDetailContent());
						lcRepInfoTempList.get(i).setMessage(lcRepInfoReportList.get(n).getMessage());
						lcRepInfoTempList.get(i).setModifyDate(DateUtil.getDate());
						lcRepInfoTempList.get(i).setModifyTime(DateUtil.getTime());
						this.update(lcRepInfoTempList.get(i));
					}
				}
			}
			
		}
		// ----------------为lcRepInfoReportList赋值 end-------------------
		// ----------------为lcRepInfoReportDetail赋值 begin-------------------
		LCRepInfoReportDetail lcRepInfoReportDetailTemp=this.findUnique(LCRepInfoReportDetail.class, "repNo", lcReport.getRepNo());
		lcRepInfoReportDetailTemp.setModifyDate(DateUtil.getDate());
		lcRepInfoReportDetailTemp.setModifyTime(DateUtil.getTime());
		
		lcRepInfoReportDetailTemp.setCompetitionStatus(lcRepInfoReportDetail.getCompetitionStatus());
		lcRepInfoReportDetailTemp.setConStatusAndServ(lcRepInfoReportDetail.getConStatusAndServ());
		lcRepInfoReportDetailTemp.setInsurStatus(lcRepInfoReportDetail.getInsurStatus());
		lcRepInfoReportDetailTemp.setClmHistory(lcRepInfoReportDetail.getClmHistory());
		this.update(lcRepInfoReportDetailTemp);
		// ----------------为lcRepInfoReportDetail赋值 end-------------------
	
		

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("lcReport", lcReportTemp);
		dataMap.put("lcGrpAppReport", lcGrpAppReportTemp);
		dataMap.put("lcGrpContReport", lcGrpContReportTemp);
		dataMap.put("ldGrp", ldGrpTemp);
		dataMap.put("lcRepInfoReportList", lcRepInfoTempList);
		dataMap.put("lcRepInfoReportDetail", lcRepInfoReportDetailTemp);
		return dataMap;
	}
	/**
	 * @description 呈报查询
	 * @param lcReport
	 * @param ldGrp
	 * @param pageNo
	 * @param pageSize
	 * @author 
	 */
	@Override
	public Page findReport(LCReport lcReport, LDGrp ldGrp, int pageNo,
			int pageSize) {
		HqlQueryRule hqlqr = new HqlQueryRule();
		StringBuffer findReportHql = new StringBuffer();
		if (ldGrp != null&& (ldGrp.getGrpName() != null && !"".equals(ldGrp.getGrpName().trim()))) {
			findReportHql
					.append("select new ins.prpall.report.vo.ReportVo(lcReport.repNo,lcReport.repOperator,lcReport.manageCom,lcReport.repApplyDate,lcReport.state,ldGrp.grpName) "
							+ "from LCReport lcReport , LDGrp ldGrp  where 1 = 1 and lcReport.repNo in "
							+ "(select lcgrpAppReport.id.repNo from LCGrpAppReport lcgrpAppReport where lcgrpAppReport.customerNo in "
							+ "(select ldGrp.customerNo from LDGrp ldGrp where ldGrp.grpName = '"
							+ ldGrp.getGrpName() + "' )" + ")");
		} else {
			findReportHql
					.append("select new ins.prpall.report.vo.ReportVo(lcReport.repNo,lcReport.repOperator,lcReport.manageCom,lcReport.repApplyDate,lcReport.state,ldGrp.grpName) "
							+ "from LCReport lcReport , LDGrp ldGrp , LCGrpAppReport lcgrpAppReport  where lcReport.repNo = lcgrpAppReport.id.repNo and lcgrpAppReport.customerNo = ldGrp.customerNo");
		}
		if (lcReport != null
				&& (lcReport.getRepNo() != null && !"".equals(lcReport
						.getRepNo().trim()))) {
			findReportHql.append(" and lcReport.repNo = '"
					+ lcReport.getRepNo() + "' ");
		}
		if (lcReport != null
				&& (lcReport.getManageCom() != null && !"".equals(lcReport
						.getManageCom().trim()))) {
			findReportHql.append(" and lcReport.manageCom = '"
					+ lcReport.getManageCom() + "' ");
		}
		if (lcReport != null && lcReport.getRepApplyDate() != null) {
			hqlqr.addEqual("lcReport.repApplyDate", lcReport.getRepApplyDate(),
					null);
			System.out.println(hqlqr.getHql());
			findReportHql.append(" and " + hqlqr.getHql());
		}

		System.out.println(findReportHql.toString());
		return this.findByHqlNoLimit(findReportHql.toString(), pageNo,
				pageSize, hqlqr.getValues());
	}

	/**
	 * 根据主键查出: lcReport呈报基本表 ldGrp团体客户表 lcRepInfo呈报信息告知表 lcGrpAppReport呈报团单投保人表
	 * lcGrpContReport呈报集体保单表 的基本信息准备展示在页面上
	 * @param repNo    呈报号--主键
	 * @return 将上面查询出来的对象装在map中
	 */
	@Override
	public Map<String, Object> findByRepNo(String repNo) {
		// 查询出report表
		LCReport lcReport = this.get(repNo);

		// 查询出LCGrpAppReport和LCGepContReport
		QueryRule queryRule = null;
		queryRule = QueryRule.getInstance();
		queryRule.addEqual("id.repNo", repNo);
		queryRule.addEqual("id.grpContNo", repNo);
		LCGrpAppReport lcGrpAppReport = this.findUnique(LCGrpAppReport.class,
				queryRule);
		LCGrpContReport lcGrpContReport = this.findUnique(
				LCGrpContReport.class, queryRule);

		// 查询出LDGrp
		queryRule = QueryRule.getInstance();
		queryRule.addEqual("customerNo", lcGrpAppReport.getCustomerNo());
		LDGrp ldGrp = this.findUnique(LDGrp.class, queryRule);

		// 将查询到的结果放在map中
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("lcReport", lcReport);
		resultMap.put("lcGrpAppReport", lcGrpAppReport);
		resultMap.put("lcGrpContReport", lcGrpContReport);
		resultMap.put("ldGrp", ldGrp);
		return resultMap;
	}
/**
 * 
 * @title 
 * @description 添加险种
 * @param lcGrpPolReport
 * @return
 */
	@Override
	public LCGrpPolReport addRisk(LCGrpPolReport lcGrpPolReport) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("riskCode", lcGrpPolReport.getRiskCode());
		PDLMRisk pdlmRisk = this.findUnique(PDLMRisk.class, queryRule);
		//险种号自动取得
		lcGrpPolReport.getId().setGrpPolNo(serialNoUtil.serialNo("LCGRPPOLREPORT",lcGrpPolReport.getManageCom(), "GRPPOLNO"));
		lcGrpPolReport.setGrpProposalNo(lcGrpPolReport.getRiskCode());
		lcGrpPolReport.setRiskVersion(pdlmRisk.getRiskVer());
		//险类编码
		//lcGrpPolReport.setKindCode(pdlmRisk.getRiskCode());
		lcGrpPolReport.setExpPremium(new BigDecimal(0));
		lcGrpPolReport.setExpAmnt(new BigDecimal(0));
		lcGrpPolReport.setMakeDate(new Date());
		lcGrpPolReport.setMakeTime(DateUtil.getTime());
		lcGrpPolReport.setModifyDate(new Date());
		lcGrpPolReport.setModifyTime(DateUtil.getTime());
		this.save(lcGrpPolReport);
		return lcGrpPolReport;
	}
	/**
	 * @description 删除险种信息
	 * @param lcGrpPolReport
	 * @author 于文龙
	 */
	@Override
	public LCGrpPolReport deleRisk(LCGrpPolReport lcGrpPolReport) {
		this.delete(lcGrpPolReport);
		return lcGrpPolReport;
	}
	/**
	 * 
	 * @title initialReportAudit
	 * @description 呈报审核初始化
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @author 于文龙
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<LCReport> initialReportAudit(int pageNo,int pageSize){
		ActionContext ac=ActionContext.getContext();
		PrpDuser user=(PrpDuser)ac.getSession().get("user");
		//个人工作池信息
		HqlQueryRule reportRule = new HqlQueryRule();
		StringBuffer reportHql = new StringBuffer();
		reportHql.append("select lcReport from LCReport lcReport,LCReportAudit lcReportAudit where lcReport.repNo=lcReportAudit.id.repNo and lcReportAudit.result is null and lcReportAudit.repAuditOperator='"+user.getUserName().trim()+"' ");
		System.out.print(reportHql.toString());
		Page selfPage=this.findByHql(reportHql.toString(), pageNo, pageSize,
				reportRule.getValues());
		List<LCReport> reportList=selfPage.getResult();
		
		return reportList;
		
	}
/** 
 * 
 * @title 
 * @description 查询审核信息
 * @param lcReport
 * @param pageNo
 * @param pageSize
 * @return
 * @author 于文龙
 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String,Object> findReportAudit(LCReport lcReport, int pageNo, int pageSize) {
		HqlQueryRule hqlQueryRule = new HqlQueryRule();
		StringBuffer hql = new StringBuffer();
		Map<String,Object> map=new HashMap<String,Object>();
		hql.append("select new ins.prpall.report.vo.ReportAuditVo(report.repNo,report.repOperator,report.manageCom,report.repApplyDate,report.name,reportAudit.repAuditOperator,report.state) from LCReport report , LCReportAudit reportAudit where report.repNo=reportAudit.id.repNo and reportAudit.result is null and reportAudit.repAuditOperator is null and report.state='已呈报' ");
		if(null!=lcReport.getRepNo()&&!"".equals(lcReport.getRepNo())){
			hql.append(" and report.repNo= '" + lcReport.getRepNo().trim()+ "'");
		}
		if(null!=lcReport.getRepOperator()&&!"".equals(lcReport.getRepOperator())){
			hql.append(" and  report.repOperator='"+ lcReport.getRepOperator().trim() + "'");
		}
		if(null!=lcReport.getName()&&!"".equals(lcReport.getName())){
			hql.append(" and  report.name='" + lcReport.getName().trim() + "'");
		}
		if(null!=lcReport.getManageCom()&&!"".equals(lcReport.getManageCom())){
			hql.append(" and report.manageCom='"+ lcReport.getManageCom().trim() + "'");
		}
		
		if (null!=lcReport && lcReport.getRepApplyDate() != null) {
			hqlQueryRule.addEqual("report.repApplyDate",
					lcReport.getRepApplyDate(), null);
			hql.append(" and " + hqlQueryRule.getHql());
		}
		//查询共享工作池信息
		Page page= this.findByHql(hql.toString(), pageNo, pageSize,
				hqlQueryRule.getValues());
		
		List<ReportAuditVo> reportAuditVo=page.getResult();
		
		
		if(null!=reportAuditVo){
			map.put("reportAuditVo", reportAuditVo);
		}else{
			map.put("reportAuditVo", null);
		}
		return map;
	}
/**
 * 
 * @title applyReportAudit
 * @description 审核申请
 * @param lcReport
 * @param lcReportAudit
 * @param pageNo
 * @param pageSize
 * @return
 * @author 于文龙
 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String,Object> applyReportAudit(LCReport lcReport, int pageNo, int pageSize) {

		QueryRule queryRule=QueryRule.getInstance();
		List<LCReportAudit> lcReportAuditList=null;
		LCReport lcReportTemp=null;
		if(null!=lcReport.getRepNo()&&!"".equals(lcReport.getRepNo())){
		queryRule.addEqual("id.repNo", lcReport.getRepNo().trim());
		lcReportAuditList=this.find(LCReportAudit.class, queryRule);
		lcReportTemp=this.findUnique("repNo", lcReport.getRepNo());
		}
		Map<String,Object> map=new HashMap<String,Object>();
		if(null!=lcReportAuditList){
		map.put("lcReportAuditList", lcReportAuditList);
		}else{
			map.put("lcReportAuditList", null);
		}
		if(null!=lcReportTemp){
		map.put("lcReport", lcReportTemp);
		}else{
			map.put("lcReport", null);
		}
		return map;
	}

	/**
	 * 呈报审核查看
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> applyReportView(LCReportAudit lcReportAudit, int pageNo,
			int pageSize) {
		QueryRule reportAuditRule=QueryRule.getInstance();
		QueryRule reportRule=QueryRule.getInstance();
		if(null!=lcReportAudit.getId().getRepNo()&&!"".equals(lcReportAudit.getId().getRepNo())&&null!=lcReportAudit.getRepAuditOperator()&&!"".equals(lcReportAudit.getRepAuditOperator())){
			reportAuditRule.addEqual("id.repNo", lcReportAudit.getId().getRepNo());
			reportAuditRule.addEqual("repauditoperator", lcReportAudit.getRepAuditOperator());
			//审核表
		List<LCReportAudit> lcReportAuditList=this.find(LCReportAudit.class, reportAuditRule);
		
		//呈报表
		reportRule.addEqual("repNo", lcReportAudit.getId().getRepNo());
		LCReport lcRpeort=this.findUnique(reportRule);
		Map<String,Object> map=new HashMap<String,Object>();
		if(null!=lcReportAuditList){
			map.put("lcReportAuditList",lcReportAuditList);
			map.put("lcReport", lcRpeort);
			return map;
		}else{
			return null;
		}
		}else{
			return null;
		}
	}

	/**
	 * 呈报审核确认
	 */
	@Override
	public Page reportAuditCommit(LCReportAudit lcReportAudit,int pageNo,int pageSize) {
		ActionContext ac=ActionContext.getContext();
		PrpDuser user=(PrpDuser)ac.getSession().get("user");
		PrpDcompany com=(PrpDcompany)ac.getSession().get("prpDcompany");
		//查询对象
		
		QueryRule queryRule = QueryRule.getInstance();
		LCReportAudit reportAuditTemp=null;
		if(null!=lcReportAudit.getId().getRepNo().trim() && !"".equals(lcReportAudit.getId().getRepNo().trim())){
			queryRule.addEqual("id.repNo", lcReportAudit.getId().getRepNo().trim());
			queryRule.addEqual("id.serialNO",lcReportAudit.getId().getSerialNo());
			reportAuditTemp=this.findUnique(LCReportAudit.class, queryRule);
		}
		if(null!=reportAuditTemp){
			reportAuditTemp.setModifyDate(new Date());
			reportAuditTemp.setModifyTime(DateUtil.getTime());
			reportAuditTemp.setRepAuditIdea(lcReportAudit.getRepAuditIdea());
			reportAuditTemp.setResult(lcReportAudit.getResult());
			reportAuditTemp.setRepAuditIdea(com.getComCode());
			reportAuditTemp.setRepAuditIdea(user.getUserName());
			this.update(reportAuditTemp);
		}
		//查询list
		QueryRule queryList = QueryRule.getInstance();
		if(null!=lcReportAudit.getId().getRepNo().trim() && !"".equals(lcReportAudit.getId().getRepNo().trim())){
			queryList.addEqual("id.repNo", lcReportAudit.getId().getRepNo().trim());
			return this.find(LCReportAudit.class, queryList,pageNo, pageSize);
		}
		return null;
	}

	/**
	 * 
	 * @title reportConSave
	 * @description 契调信息保存
	 * @param propallSearchInfo
	 * @param propallSearchItemList
	 * @return
	 * @author 于文龙
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean reportConSave(PropallSearchInfo propallSearchInfo,List<PropallSearchItem> propallSearchItemList) {
		ActionContext ac=ActionContext.getContext();
		PrpDuser user=(PrpDuser)ac.getSession().get("user");
		
		//获得序列号
		int serialNo = 1;
		if(null!=propallSearchInfo.getId().getRepNo()&&!"".equals(propallSearchInfo.getId().getRepNo())){
			QueryRule queryRule=QueryRule.getInstance();
			queryRule.addEqual("id.repNo", propallSearchInfo.getId().getRepNo()); 
			List<PropallSearchInfo> propallSearchInfoList = this.find(PropallSearchInfo.class, queryRule);
			if (null != propallSearchInfoList) {
				for (int i = 0; i < propallSearchInfoList.size(); i++) {
					int num = propallSearchInfoList.get(i).getId().getSerialNo();
					if (num >= serialNo) {
						serialNo = num + 1;
					}
				}
			}
		}
		
			// 契调信息准备
			propallSearchInfo.getId().setSerialNo(serialNo);
			propallSearchInfo.setState("01");
			propallSearchInfo.setOperator(user.getUserCode());
			propallSearchInfo.setMakeDate(new Date());
			propallSearchInfo.setMakeTime(DateUtil.getTime());
			propallSearchInfo.setModifyDate(new Date());
			propallSearchInfo.setModifyTime(DateUtil.getTime());
			this.save(propallSearchInfo);
			// 契调项目信息准备
			for(int i=0;i<propallSearchItemList.size();i++){
				propallSearchItemList.get(i).getId().setRepNo(propallSearchInfo.getId().getRepNo());
				propallSearchItemList.get(i).getId().setSerialNo(i+1);
				propallSearchItemList.get(i).setOperator(user.getUserCode());
				propallSearchItemList.get(i).setMakeDate(new Date());
				propallSearchItemList.get(i).setMakeTime(DateUtil.getTime());
				propallSearchItemList.get(i).setModifyDate(new Date());
				propallSearchItemList.get(i).setModifyTime(DateUtil.getTime());
			}			
			this.saveAll(propallSearchItemList);
			return true;

	}
	/**
	 * 
	 * @title openPrpallSearch
	 * @description 发起契调
	 * @param lcReport
	 * @return
	 * @author 于文龙
	 */
	@Override
	public Map<String,Object> openPrpallSearch(LCReport lcReport) {
		Map<String,Object> map=new HashMap<String,Object>();
		
		if(null!=lcReport.getRepNo()&&!"".equals(lcReport.getRepNo())){
			LCReport lcReportTemp=this.findUnique("repNo", lcReport.getRepNo());
			map.put("lcReport", lcReportTemp);
		}
		return map;
	}
	/**
	 * 上传附件保存
	 * @param file 文件
	 * @param lcFile文件信息
	 * @author 于文龙
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String,Object> reportFileUpload(MultipartFile file, LCRepFile lcFile, String path,
			int pageNo, int pageSize) {

		ActionContext ac = ActionContext.getContext();
		//获取文件名称
		String fileName="";
		int num=1;
		String name0="";
		String name1=".rar";
		String findHql="from LCRepFile l where l.repno='"+lcFile.getRepno()+"'";
		List<LCRepFile> list=this.findByHql(findHql, null);
		if(null!=list){
			for(int i=0;i<list.size();i++){
				String name=list.get(i).getFileName();
				name0=name.substring(14,name.indexOf("."));
				name1=name.substring(name.indexOf("."));
				if(num<=Integer.parseInt(name0)){
					num=Integer.parseInt(name0)+1;
				}
			}
		}
		fileName=lcFile.getRepno()+"_"+num+name1;
		lcFile.setFileName(fileName);
		System.out.println("->>"+path);
		String filePath=path+lcFile.getFileName();
		System.out.println(filePath);
		lcFile.setFilePath(filePath.replace("\\", "/"));
		//经办人
		PrpDuser user = (PrpDuser)ac.getSession().get("user");
		lcFile.setFileoperator(user.getUserName());
		//时间和日期
		try {
			lcFile.setUploadDate(DateUtil.getDate());
			lcFile.setMakeDate(DateUtil.getDate());
			lcFile.setMaketime(DateUtil.getTime());
			lcFile.setModifydate(DateUtil.getDate());
			lcFile.setModifyTime(DateUtil.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 文件保存路径

		try {
			// 批次号的取得
			String uploadCode = serialNoUtil.serialNo("LCREPFILE", ac
					.getSession().get("comCode").toString(), "UPLOADCODE");
			lcFile.setUploadcode(uploadCode);
			File desFile = new File(lcFile.getFilePath());
			desFile.createNewFile();
			System.out.println(path);
			InputStream fis = file.getInputStream();
			FileOutputStream fos = new FileOutputStream(desFile);

			byte[] buffer = new byte[1024];
			int length = 0;
			while ((length = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, length);
			}
			fos.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("ok");
		// 信息保存
		this.save(lcFile);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("lcFile",lcFile);
		return map;
	}

	/**
	 * 告知单、受益人、被保险人信息保存
	 * @param lcInsured
	 * @param lcRepInfoList
	 * @param lcBnfList
	 * @author 于文龙
	 */
	@Override
	public Map<String, Object> saveAllInfo(LCInsured lcInsured,
			List<LCRepInfo> lcRepInfoList, List<LCBnf> lcBnfList) {
		// lcInsured信息整理
		try {
		lcInsured.getId().setContNo(lcInsured.getGrpContNo());
		lcInsured.setPrtNo(lcInsured.getGrpContNo());
		lcInsured.setExecuteCom(lcInsured.getManageCom());
		lcInsured.setMakeTime(DateUtil.getTime());
		lcInsured.setMakeDate(DateUtil.getDate());
		lcInsured.setModifyDate(DateUtil.getDate());
		lcInsured.setModifyTime(DateUtil.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//被保人客户号自动取得
		String insuredCode=serialNoUtil.serialNo("LCINSURED",lcInsured.getManageCom(),"INSUREDCODE");
		lcInsured.getId().setInsuredNo(insuredCode);
		lcInsured.setAppntNo(insuredCode);
		
		//告知单信息整理
		List<LCRepInfo> lcRepInfoListTemp=new ArrayList<LCRepInfo>();
		for(int i=0,k=0;i<lcRepInfoList.size();i++){
			if(null!=lcRepInfoList.get(i)){
				lcRepInfoListTemp.set(k, lcRepInfoList.get(i));
				k++;
			}
		}
		try{
		if(null!=lcRepInfoListTemp){
			for(int j=0;j<lcRepInfoListTemp.size();j++){
				lcRepInfoListTemp.get(j).getId().setGrpContNo(lcInsured.getGrpContNo());
				lcRepInfoListTemp.get(j).setContNo(lcInsured.getGrpContNo());
				//流水号
				// 流水号取得
				int number = 1;
				if (null != lcRepInfoList.get(0).getId().getGrpContNo()
						&& null != lcRepInfoList.get(0).getId().getImpartCode()
						&& null != lcRepInfoList.get(0).getId().getImpartVer()) {
					List<LCRepInfo> tempList = this
							.findByHql(
									"from LCRepInfo lcRepInfo where lcRepInfo.id.grpContNo='"
											+ lcRepInfoList.get(0).getId()
													.getGrpContNo()
											+ "' and  lcRepInfo.id.impartCode='"
											+ lcRepInfoList.get(0).getId()
													.getImpartCode()
											+ "' and lcRepInfo.id.impartVer='"
											+ lcRepInfoList.get(0).getId()
													.getImpartVer() + "'", null);
					if(tempList!=null){
						for(int k=0;k<tempList.size();k++){
							if(number<=tempList.get(k).getId().getSubSerialNo()){
								number=tempList.get(k).getId().getSubSerialNo()+1;
							}
						}
					}
				}
				lcRepInfoListTemp.get(j).getId().setSubSerialNo(number);
				lcRepInfoListTemp.get(j).setPrtNo(lcInsured.getGrpContNo());
				//客户号和类型
				lcRepInfoListTemp.get(j).setCustomerNo(insuredCode);
				lcRepInfoListTemp.get(j).setCustomerNoType("1");
				
				lcRepInfoListTemp.get(j).setOperator(lcInsured.getOperator());
				lcRepInfoListTemp.get(j).setMakeDate(DateUtil.getDate());
				lcRepInfoListTemp.get(j).setMakeTime(DateUtil.getTime());
				lcRepInfoListTemp.get(j).setModifyDate(DateUtil.getDate());
				lcRepInfoListTemp.get(j).setModifyTime(DateUtil.getTime());			
			}
		}
		}catch (ParseException e) {
			System.out.println("告知单信息异常");
			e.printStackTrace();
		}
		//受益人信息整合
		List<LCBnf> lcBnfListTemp=new ArrayList<LCBnf>();
		for(int i=0,k=0;i<lcBnfList.size();i++){
			if(null!=lcBnfList.get(i)){
				lcBnfListTemp.set(k, lcBnfList.get(i));
				k++;
			}
		}
		try{
			if(null!=lcBnfListTemp){
				for(int n=0;n<lcBnfListTemp.size();n++){
					lcBnfListTemp.get(n).getId().setInsuredNo(lcInsured.getGrpContNo());
					lcBnfListTemp.get(n).setContNo(lcInsured.getGrpContNo());
					lcBnfListTemp.get(n).setOperator(lcInsured.getOperator());
					lcBnfListTemp.get(n).setMakeDate(DateUtil.getDate());
					lcBnfListTemp.get(n).setMakeTime(DateUtil.getTime());
					lcBnfListTemp.get(n).setModifyDate(DateUtil.getDate());
					lcBnfListTemp.get(n).setModifyTime(DateUtil.getTime());	
				}
			}
			
		}catch(Exception e){
			System.out.println("受益人异常");
			e.getStackTrace();
		}
		
		this.save(lcInsured);
		this.saveAll(lcBnfListTemp);
		this.saveAll(lcRepInfoListTemp);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("lcInsured", lcInsured);
		dataMap.put("lcBnfList", lcBnfListTemp);
		dataMap.put("lcRepInfoList", lcRepInfoListTemp);
		return null;
	}
	
	/**根据客户号,投保申请号查询投保单位资料的查询按钮
	 * @param客户号：customerNo
	 * @param投保申请号：repNo
	 * @author 郭占红
	 */
	@Override
	public Page findInfoByCustomerNo(LDGrp ldGrp) {
		if(null!=ldGrp&&null!=ldGrp.getCustomerNo()&&!"".equals(ldGrp.getCustomerNo())){
			return this.findByHqlNoLimit("from LDGrp l where l.customerNo='"+ldGrp.getCustomerNo()+"'", 1, 20, null);
		}else{
		return null;
		}
	}

	 /** (呈报结果查询)根据页面录入条件查询lcReport和lcReportAudit表，返回的是组合对象ReportQueryResultVo
	 * @param lcReport  呈报基础表
	 * @return
	 * @author 郭占红
	 */
	public Page findReportResult(LCReport lcReport, int pageNo, int pageSize) {
		HqlQueryRule hqlqr = new HqlQueryRule();
		StringBuffer findReportHql = new StringBuffer();
		
		if (lcReport != null&& (lcReport.getName() != null && !"".equals(lcReport.getName().trim()))) {
			findReportHql
					.append("select new ins.prpall.report.vo.ReportQueryResultVo(lcReport.repNo,lcReport.repOperator,lcReport.manageCom,lcReport.repApplyDate,lcReport.name,lcReport.state,lcReportAudit.result,lcReportAudit.repauditoperator)"
							+ "from LCReport lcReport , LCReportAudit lcReportAudit  where 1 = 1 and lcReport.repNo in "
							+ "(select lcgrpAppReport.id.repNo from LCGrpAppReport lcgrpAppReport where lcgrpAppReport.customerNo in "
							+ "(select ldGrp.customerNo from LDGrp ldGrp where ldGrp.grpName = '"
							+ lcReport.getName() + "' )" + ")");
		} else {
			findReportHql
					.append("select new ins.prpall.report.vo.ReportQueryResultVo(lcReport.repNo,lcReport.repOperator,lcReport.manageCom,lcReport.repApplyDate,lcReport.name,lcReport.state,lcReportAudit.result,lcReportAudit.repauditoperator) "
							+ "from LCReport lcReport , LDGrp ldGrp , LCGrpAppReport lcgrpAppReport  where lcReport.repNo = lcgrpAppReport.id.repNo and lcgrpAppReport.customerNo = ldGrp.customerNo");
		}
		if (lcReport != null&& (lcReport.getRepNo() != null && !"".equals(lcReport.getRepNo().trim()))) {
			findReportHql.append(" and lcReport.repNo = '"+ lcReport.getRepNo() + "' ");
		}
		if (lcReport != null&& (lcReport.getManageCom() != null && !"".equals(lcReport.getManageCom().trim()))) {
			findReportHql.append(" and lcReport.manageCom = '"+ lcReport.getManageCom() + "' ");
		}
		if (lcReport != null && lcReport.getRepApplyDate() != null) {
			hqlqr.addEqual("lcReport.repApplyDate", lcReport.getRepApplyDate(),
					null);
		    System.out.println(hqlqr.getHql());
			findReportHql.append(" and " + hqlqr.getHql());
		}
		System.out.println(findReportHql.toString());
		return this.findByHqlNoLimit(findReportHql.toString(), pageNo,
				pageSize, hqlqr.getValues());
		
	}

	/**根据呈报申请号和批次号查询呈报返回信息
	 * @param repNo
	 * @author 郭占红
	 */
	public List<LCReportAudit> findReportReturningInfo(String repNo,int serialNo) {
		
		StringBuffer hql = new StringBuffer();
		hql.append("from LCReportAudit lcReportAudit where lcReportAudit.id.repNo='"+repNo+"' and lcReportAudit.id.serialNO='"+serialNo+"'");
		//HQL用来实现查询
		List<LCReportAudit>findResult =this.findByHql(hql.toString(), null);
		if(null != findResult && findResult.size() > 0){
			return findResult;
		}
		return null;
	}


	/**
	 * 再保审核信息查询
	 * @param lcReport 呈报表
	 * @param pageNo 
	 * @param pageSize
	 * @return page
	 * @author 薛玉强
	 */
	@Override
	public Page findReinsAuditInfo(LCReport lcReport,int pageNo,int pageSize) {
		HqlQueryRule hqlQueryRule = new HqlQueryRule();
		StringBuffer hql = new StringBuffer();
		hql.append("select lcReport from LCReport lcReport where 1=1");
		//判断呈报机构是否为空；
		if(lcReport.getManageCom() != null && !"".equals(lcReport.getManageCom().trim())){
			hql.append(" and lcReport.manageCom = '" + lcReport.getManageCom().trim() + "'");
		}
		//判断呈报号是否为空；
		if(lcReport.getRepNo() != null && !"".equals(lcReport.getRepNo().trim())){
			hql.append(" and lcReport.repNo = '" + lcReport.getRepNo().trim() + "'");
		}
		//判断呈报人是否为空；
		if(lcReport.getRepOperator() != null && !"".equals(lcReport.getRepOperator().trim())){
			hql.append(" and lcReport.repOperator like '%" + lcReport.getRepOperator().trim() + "%'");
		}
		//判断单位名称时候为空；
		if(lcReport.getName() != null && !"".equals(lcReport.getName().trim())){
			hql.append(" and lcReport.name = '" + lcReport.getName().trim() + "'");
		}
		//判断日期是否为空；
		if(lcReport != null && lcReport.getRepApplyDate() != null){
			hqlQueryRule.addEqual("repApplyDate", lcReport.getRepApplyDate(), null);
			hql.append(" and " + hqlQueryRule.getHql());
		}
		return this.findByHqlNoLimit(hql.toString(), pageNo, pageSize,
				hqlQueryRule.getValues());
	}

	/*
	 * 再保审核中查询审核意见
	 * @title findAuditIdea
	 * @author 薛玉强
	 * @see ins.prpall.report.service.facade.ReportService#findAuditIdea(ins.prpall.report.model.LCReport)
	 */
	@Override
	public List<LCReinsAudit> findAuditIdea(LCReinsAudit lcReinsAudit) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("id.repNo", lcReinsAudit.getId().getRepNo());
		List<LCReinsAudit> lcReportList = this.find(LCReinsAudit.class, queryRule);
		return lcReportList;
	}
	
	/**
	 * 再保审核中保存审核意见和核保结论
	 * @title saveAuditResultAndIdea
	 * @author 薛玉强
	 * @see ins.prpall.report.service.facade.ReportService#saveAuditResultAndIdea(ins.platform.model.PrpDuser, ins.prpall.report.model.LCReportAudit)
	 */

	@Override
	public boolean saveAuditResultAndIdea(PrpDuser user,
			LCReinsAudit lcReinsAudit) {
		int maxSerialNo = 0;
		//获得最大的序列号
		StringBuffer serialNoHql = new StringBuffer();
		serialNoHql.append("select max(id.serialNo) from LCReinsAudit lcReinsAudit where lcReinsAudit.id.repNo = '" + lcReinsAudit.getId().getRepNo() + "'");
		List<Integer> maxSerialNoList = this.findByHql(serialNoHql.toString(), null);
		if(null !=maxSerialNoList && maxSerialNoList.size() > 0){
			if(null != maxSerialNoList.get(0)){
				maxSerialNo = maxSerialNoList.get(0) + 1;
			}
		}
		//设置ID属性
		LCReinsAuditId auditId = new LCReinsAuditId();
		auditId.setRepNo(lcReinsAudit.getId().getRepNo());
		auditId.setSerialNo(maxSerialNo);
		lcReinsAudit.setId(auditId);
		
		lcReinsAudit.setMakeDate(new Date());
		lcReinsAudit.setMakeTime(DateUtil.getTime());
		lcReinsAudit.setModifyDate(new Date());
		lcReinsAudit.setModifyTime(DateUtil.getTime());
		lcReinsAudit.setRepAuditOperator(user.getUserName());
		String manageCom = (String)ActionContext.getContext().getSession().get("comCode");
		lcReinsAudit.setManageCom(manageCom);
		//保存到数据库
		this.save(lcReinsAudit);
		return true;
	}

	/*
	 * 
	 * @title findActuarialReport
	 * @author 徐新玲
	 * @see ins.prpall.report.service.facade.ReportService#findActuarialReport(ins.prpall.report.model.LCReport, int, int)
	 */
	public Page findActuarialReport(LCReport lcReport, int pageNo, int pageSize) {
		HqlQueryRule hqlqr=new HqlQueryRule();
		StringBuffer hql = new StringBuffer();
		hql.append("select lcReport from LCReport lcReport where 1=1 ");
		//呈报号不为空时
		if (lcReport != null
				&& (lcReport.getRepNo() != null && !"".equals(lcReport
						.getRepNo().trim()))) {
			hql.append(" and lcReport.repNo = '"
					+ lcReport.getRepNo().trim() + "' ");
		}
		//呈报人不为空时
		if (lcReport != null
				&& (lcReport.getRepOperator() != null && !"".equals(lcReport
						.getRepOperator().trim()))) {
			hql.append(" and lcReport.repOperator like '%"
					+ lcReport.getRepOperator().trim() + "%' ");
		}
		//呈报机构不为空时
		if (lcReport != null
				&& (lcReport.getManageCom() != null && !"".equals(lcReport
						.getManageCom().trim()))) {
			hql.append(" and lcReport.manageCom = '"
					+ lcReport.getManageCom().trim() + "' ");
		}
		//单位名称不为空时
		if (lcReport != null
				&& (lcReport.getName() != null && !"".equals(lcReport
						.getName().trim()))) {
			hql.append(" and lcReport.name like '%"
					+ lcReport.getName().trim() + "%' ");
		}
		//呈报日期不为空时
		if (lcReport != null && lcReport.getRepApplyDate() != null) {
			hqlqr.addEqual("lcReport.repApplyDate", lcReport.getRepApplyDate(),
					null);
			hql.append(" and " + hqlqr.getHql());
		}
		return this.findByHqlNoLimit(hql.toString(), pageNo,
				pageSize, hqlqr.getValues());
	}
	/*
	 * 
	 * @title findReportIdeaByrepNo
	 * @author 徐新玲
	 * @see ins.prpall.report.service.facade.ReportService#findReportIdeaByrepNo(ins.prpall.report.model.LCReport)
	 */
		@Override
		public List<LCActuarialAudit> findReportIdeaByrepNo(LCActuarialAudit lcActuarialAudit) {

			QueryRule queryRule = QueryRule.getInstance();
			queryRule.addEqual("id.repNo", lcActuarialAudit.getId().getRepNo());
			List<LCActuarialAudit> reportIdeaList = this.find(LCActuarialAudit.class, queryRule);
			if(null != reportIdeaList && reportIdeaList.size()>0){
				return reportIdeaList;
			}
			return null;
		}
	
/*
 * 保存精算审核意见
 * @title saveActuarialAuditIdea
 * @author 徐新玲
 * @see ins.prpall.report.service.facade.ReportService#saveActuarialAuditIdea(ins.prpall.report.model.LCReportAudit, ins.platform.model.PrpDuser)
 */
	@Override
	public boolean saveActuarialAuditIdea(LCActuarialAudit lcActuarialAudit,
			PrpDuser user) {
		
		int maxSerialNo = 0;
		//获得最大的序列号
		StringBuffer serialNoHql = new StringBuffer();
		serialNoHql.append("select max(id.serialNo) from LCActuarialAudit lcActuarialAudit where lcActuarialAudit.id.repNo = '" + lcActuarialAudit.getId().getRepNo() + "'");
		List<Integer> maxSerialNoList = this.findByHql(serialNoHql.toString(), null);
		if(null !=maxSerialNoList && maxSerialNoList.size() > 0){
			if(null != maxSerialNoList.get(0)){
				maxSerialNo = maxSerialNoList.get(0) + 1;
			}
		}
		//设置ID属性
		LCActuarialAuditId auditId = new LCActuarialAuditId();
		auditId.setRepNo(lcActuarialAudit.getId().getRepNo());
		auditId.setSerialNo(maxSerialNo);
		lcActuarialAudit.setId(auditId);
		
		lcActuarialAudit.setMakeDate(new Date());
		lcActuarialAudit.setMakeTime(DateUtil.getTime());
		lcActuarialAudit.setModifyDate(new Date());
		lcActuarialAudit.setModifyTime(DateUtil.getTime());
		lcActuarialAudit.setRepAuditOperator(user.getUserName());
		String manageCom = (String)ActionContext.getContext().getSession().get("comCode");
		lcActuarialAudit.setManageCom(manageCom);
		//保存到数据库
		this.save(lcActuarialAudit);
		return true;
	}

	@Override
	public List<LCActuarialAudit> findAIdeaByrepNo(String repNo) {
		String hql="from LCActuarialAudit lcActuarialAudit where lcActuarialAudit.id.repNo= '"+repNo+"'";
		List<LCActuarialAudit> reportIdeaList=(List<LCActuarialAudit>)this.findByHql(hql, null);
		if(null != reportIdeaList && reportIdeaList.size()>0){
			return reportIdeaList;
		}
		return null;
	}

	/**
	 * 
	 * @title deleteReport
	 * @description 删除呈报表信息
	 * @param lcReport
	 * @author 于文龙
	 */
	@Override
	public Map<String, Object> deleteReport(LCReport lcReport) {
		this.delete(lcReport);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("lcReport", lcReport);
		return map;
	}

	/**
	 * 查询上传附件的信息
	 * @param lcRepFile
	 * @param pageNo
	 * @param pageSize
	 * @author 于文龙
	 */
	@Override
	public Map<String, Object> findFileInfo(LCRepFile lcRepFile, int pageNo,
			int pageSize) {
		Map<String,Object> map=new HashMap<String,Object>();
		if(null==lcRepFile.getRepno()){
			map.put("lcReportFile", lcRepFile);
		}else{
			String hql="from LCRepFile l where l.repno='"+lcRepFile.getRepno()+"'";
			List<LCRepFile> fileList=this.findByHql(hql, null);
			map.put("lcReportFile", fileList);
		}
		return map;
	}

	/**
	 * @title 
	 * @description 查询LCReport表的相关信息
	 * @param lcReport
	 * @author 于文龙
	 */
	@Override
	public Map<String, Object> findReportAllInfo(LCReport lcReport) {
		
		//查询LCReport呈报表，主键repNo呈报号
		String lcReportHql="from LCReport t where t.repNo='"+lcReport.getRepNo()+"'";
		LCReport lcReportTemp=(LCReport)this.findByHql(lcReportHql, null).get(0);
		
		//查询上传附件表lcRepFile ，根据repNo查询，生成list
		String lcRepFileHql="from LCRepFile t where t.repno='"+lcReport.getRepNo()+"'";
		List<LCRepFile> lcRepFileList=this.findByHql(lcRepFileHql, null);
		
		//返回信息
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("lcReport", lcReportTemp);
		map.put("lcRepFileList", lcRepFileList);
		return map;
	}
}
