package ins.prpall.report.service.spring;

import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.DateUtil;
import ins.platform.model.PrpDuser;
import ins.product.model.PDLMRisk;
import ins.product.model.PDLMRiskDuty;
import ins.prpall.report.model.LCContPlanDutyParamReport;
import ins.prpall.report.model.LCContPlanDutyParamReportId;
import ins.prpall.report.model.LCContPlanReport;
import ins.prpall.report.model.LCContPlanReportId;
import ins.prpall.report.model.LCContPlanRiskReport;
import ins.prpall.report.model.LCDutyReport;
import ins.prpall.report.model.LCGrpContReport;
import ins.prpall.report.model.LCReport;
import ins.prpall.report.service.facade.LCContPlanReportService;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class LCContPlanReportServiceSpringImpl extends GenericDaoHibernate<LCContPlanReport, LCContPlanReportId> 
	implements LCContPlanReportService {
	/**
	 * 保存保障计划
	 * @param lcContPlanReport 保障计划表
	 * @param lcContPlanRiskReportList  保障计划险种表
	 * @param lcContPlanDutyParamReportList  保障计划要素表（跟责任已经关联）
	 */
	@Override
	public boolean saveContPlan(LCContPlanReport lcContPlanReport,
			List<LCContPlanRiskReport> lcContPlanRiskReportList,List<LCDutyReport> lcDutyReportList,
			List<LCContPlanDutyParamReport> lcContPlanDutyParamReportList) {
		//保存保障计划基础表——LCContPlanReport
		System.out.println("准备保存.....");
		LCReport report = this.findUnique(LCReport.class, "repNo", lcContPlanReport.getId().getRepNo());
		lcContPlanReport.setRepOperator(report.getRepOperator());
		lcContPlanReport.setRepApplyDate(report.getRepApplyDate());
		//TODO 保障计划中的计划类别暂时设置为0-固定计划
		lcContPlanReport.getId().setPlanType("0");
		ActionContext ac = ActionContext.getContext();
		PrpDuser user = (PrpDuser)ac.getSession().get("user");
		lcContPlanReport.setOperator(user.getUserCode());
		lcContPlanReport.setMakeDate(new Date());
		lcContPlanReport.setMakeTime(DateUtil.getTime());
		lcContPlanReport.setModifyDate(new Date());
		lcContPlanReport.setModifyTime(DateUtil.getTime());
		this.save(lcContPlanReport);
		
		//保存保障计划险种表
		//Iterator<LCContPlanRiskReport> it = lcContPlanRiskReportList.iterator();CONTPLANCODE
		for(int i = 0 ; i < lcContPlanRiskReportList.size() ; i++){
			LCContPlanRiskReport contPlanRiskTemp = lcContPlanRiskReportList.get(i);
			PDLMRisk risk = this.findUnique(PDLMRisk.class, "riskCode", contPlanRiskTemp.getId().getRiskCode());
//			select * from PD_LMRisk where riskCode in
//			 ( select rr.relaRiskCode from PD_LMRiskRela rr where rr.riskCode = 'GCAA' and rr.relaCode = '01' and rr.manageComGrp = '000000')
			String findMainRiskHql = "from PDLMRisk risk where risk.riskCode in ( select rr.id.relaRiskCode from PDLMRiskRela rr where rr.id.riskCode = ? and rr.id.relaCode = ? and rr.id.manageComGrp = ? )";
			PDLMRisk mainRisk = null;
			List<PDLMRisk> list = this.findByHql(findMainRiskHql, contPlanRiskTemp.getId().getRiskCode(),"01","000000");
			if(list != null && list.size()>0){
				mainRisk = list.get(0);
			}else{
				mainRisk = risk;
			}
			//集体合同号码
			contPlanRiskTemp.setGrpContNo(lcContPlanReport.getId().getGrpContNo());
			//集体投保单号码
			contPlanRiskTemp.getId().setProposalGrpContNo(lcContPlanReport.getProposalGrpContNo());
			//保险计划编码
			contPlanRiskTemp.getId().setContPlanCode(lcContPlanReport.getId().getContPlanCode());
			//主险险种编码
			contPlanRiskTemp.getId().setMainRiskCode(mainRisk.getRiskCode());
			//计划类别
			contPlanRiskTemp.getId().setPlanType(lcContPlanReport.getId().getPlanType());
			//呈报申请号
			contPlanRiskTemp.getId().setRepNo(lcContPlanReport.getId().getRepNo());
			//主险险种版本
			contPlanRiskTemp.setMainRiskVersion(mainRisk.getRiskVer());
			//险种版本
			contPlanRiskTemp.setRiskVersion(risk.getRiskVer());
			//操作员
			contPlanRiskTemp.setOperator(lcContPlanReport.getOperator());
			//入机日期
			contPlanRiskTemp.setMakeDate(lcContPlanReport.getMakeDate());
			//入机时间
			contPlanRiskTemp.setMakeTime(lcContPlanReport.getMakeTime());
			//最后一次修改日期
			contPlanRiskTemp.setModifyDate(lcContPlanReport.getMakeDate());
			//最后一次修改时间
			contPlanRiskTemp.setModifyTime(lcContPlanReport.getModifyTime());
			//呈报申请人
			contPlanRiskTemp.setRepOperator(lcContPlanReport.getRepOperator());
			//呈报申请日期
			contPlanRiskTemp.setRepApplyDate(lcContPlanReport.getRepApplyDate());
			//保险计划名称
			contPlanRiskTemp.setContPlanName(lcContPlanReport.getContPlanName());
		}
		this.saveAll(lcContPlanRiskReportList);
		
		
		/**
		//保障计划的责任要素
		List <LCContPlanDutyParamReport> cpdpr = new ArrayList<LCContPlanDutyParamReport>();
		for(int i = 0 ; i < lcContPlanDutyParamReportList.size() ; i++){
			//如果没有录入要素值则默认是不保存该要素的
			if(null != lcContPlanDutyParamReportList.get(i).getCalFactorValue() && !"".equals(lcContPlanDutyParamReportList.get(i).getCalFactorValue())){
				LCContPlanDutyParamReport dutyParamTemp = lcContPlanDutyParamReportList.get(i);
				LCContPlanDutyParamReportId id = dutyParamTemp.getId();
				//保险计划编码
				id.setContPlanCode(lcContPlanReport.getId().getContPlanCode());
				//集体合同号码
				id.setGrpContNo(lcContPlanReport.getId().getGrpContNo());
				//遍历lcContPlanRiskReportList，找到险种相同的，得到主险和版本，避免查询数据库
				for(int j = 0 ; j < lcContPlanRiskReportList.size() ; j++){
					if(lcContPlanRiskReportList.get(j).getId().getRiskCode().equals(id.getRiskCode())){
						id.setMainRiskCode(lcContPlanRiskReportList.get(j).getId().getMainRiskCode());
						dutyParamTemp.setMainRiskVersion(lcContPlanRiskReportList.get(j).getMainRiskVersion());
						dutyParamTemp.setRiskVersion(lcContPlanRiskReportList.get(j).getRiskVersion());
					}
				}
				//计划类别
				id.setPlanType(lcContPlanReport.getId().getPlanType());
				//保险计划名称
				dutyParamTemp.setContPlanName(lcContPlanReport.getContPlanName());
				//集体保单险种号码
				dutyParamTemp.setGrpPolNo(id.getRiskCode());
				//集体投保单号码
				dutyParamTemp.setProposalGrpContNo(lcContPlanReport.getProposalGrpContNo());
				//计划要素类型
				dutyParamTemp.setCalFactorType("算法计算结果值");
				//呈报申请号
				dutyParamTemp.getId().setRepNo(lcContPlanReport.getId().getRepNo());
				//呈报申请日期
				dutyParamTemp.setRepApplyDate(lcContPlanReport.getRepApplyDate());
				//呈报申请人
				dutyParamTemp.setRepOperator(lcContPlanReport.getRepOperator());
				//操作员
				dutyParamTemp.setOperator(lcContPlanReport.getOperator());
				//入机日期
				dutyParamTemp.setMakeDate(lcContPlanReport.getMakeDate());
				//入机时间
				dutyParamTemp.setMakeTime(lcContPlanReport.getMakeTime());
				//最后一次修改日期
				dutyParamTemp.setModifyDate(lcContPlanReport.getMakeDate());
				//最后一次修改时间
				dutyParamTemp.setModifyTime(lcContPlanReport.getModifyTime());
				cpdpr.add(dutyParamTemp);
			}
		}
		this.saveAll(cpdpr);
		System.out.println("保存完毕！");
		*/
		
		//险种责任表LCDutyReportList
		for(int i=0;i<lcDutyReportList.size();i++){
			
			lcDutyReportList.get(i).getId().setRepNo(report.getRepNo());
			lcDutyReportList.get(i).setRepOperator(report.getRepOperator());
			lcDutyReportList.get(i).setRepApplyDate(report.getRepApplyDate());
			//险种编码
			lcDutyReportList.get(i).getId().setPolNo(lcContPlanRiskReportList.get(i).getId().getMainRiskCode());
			//起领日期
			lcDutyReportList.get(i).setGetStartDate(new Date());
			lcDutyReportList.get(i).setOperator(user.getUserCode());
			lcDutyReportList.get(i).setMakeDate(new Date());
			lcDutyReportList.get(i).setMakeTime(DateUtil.getTime());
			lcDutyReportList.get(i).setModifyDate(new Date());
			lcDutyReportList.get(i).setModifyTime(DateUtil.getTime());
			 //计算保费和保额
			//lcDutyReportList.get(i).setAmnt(0);
			//lcDutyReportList.get(i).setPrem(0);
		}
		this.saveAll(lcDutyReportList);
		
		
		return true;
	}
	
	/**
	 * 呈报保险计划初始化页面方法
	 * @param repNo 呈报申请号
	 * @author 于文龙
	 */
	@Override
	public Map<String,Object> initializeEnsurePlan(LCGrpContReport lcGrpContReport) {
		Map<String,Object> map=new HashMap<String,Object>();
		LCGrpContReport lcGrpContReportTemp=null;
		List<LCContPlanReport>  lcContPlanReportList=null;
		if(null!=lcGrpContReport.getId().getRepNo()&&!"".equals(lcGrpContReport.getId().getRepNo())){
			QueryRule grpContRule=QueryRule.getInstance();
			grpContRule.addEqual("id.repNo", lcGrpContReport.getId().getRepNo());
			grpContRule.addEqual("id.grpContNo", lcGrpContReport.getId().getGrpContNo());
			
			lcGrpContReportTemp=this.findUnique(LCGrpContReport.class, grpContRule);
			
			//查询保障计划,使用同一个规则
			lcContPlanReportList=this.find(grpContRule);
			
			map.put("lcGrpContReport", lcGrpContReportTemp);
			map.put("lcContPlanReportList", lcContPlanReportList);
		}else{
			return null;
		}
	return map;
	}
	/**
	 * 呈报保障计划及其相关表的删除
	 * @param
	 * @param
	 * @author 于文龙
	 */
	@Override
	public Map<String,Object> deleteConPlan(LCContPlanReport lcContPlanReport) {
		//保障计划表
		lcContPlanReport.getId().setGrpContNo(lcContPlanReport.getId().getRepNo());
		lcContPlanReport.getId().setPlanType("0");
		//险种保障计划
		LCContPlanRiskReport lcContPlanRiskReport=new LCContPlanRiskReport();
		lcContPlanRiskReport.getId().setRepNo(lcContPlanReport.getId().getRepNo());
		lcContPlanRiskReport.getId().setPlanType("0");//计划类型暂为0
		lcContPlanRiskReport.getId().setContPlanCode(lcContPlanReport.getId().getContPlanCode());
			//获得集体投保单号
		Map<String , Object> map=new HashMap<String ,Object>();
		map.put("repNo",lcContPlanReport.getId().getRepNo());
		map.put("grpContNo", lcContPlanReport.getId().getGrpContNo());
		map.put("contPlanCode", lcContPlanReport.getId().getContPlanCode());
		map.put("planType", lcContPlanReport.getId().getPlanType());
		LCContPlanReport temp=this.findUnique(LCContPlanReport.class, map);
		lcContPlanRiskReport.getId().setProposalGrpContNo(temp.getProposalGrpContNo());
		//责任保障计划
		LCContPlanDutyParamReport lcPlanDutyParamReport=new LCContPlanDutyParamReport();
		lcPlanDutyParamReport.getId().setRepNo(lcContPlanReport.getId().getRepNo());
		lcPlanDutyParamReport.getId().setPlanType("0");
		lcPlanDutyParamReport.getId().setContPlanCode(lcContPlanReport.getId().getContPlanCode());
		lcPlanDutyParamReport.getId().setGrpContNo(lcContPlanReport.getId().getGrpContNo());
		
		//保障计划表
		//this.delete(lcContPlanReport);
		//险种表
		//this.delete(lcContPlanRiskReport);
		//责任表
		//this.delete(lcPlanDutyParamReport);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("lcContPlanReport", lcContPlanReport);
		return dataMap;
	}

	/**
	 * @title updateConPlan
	 * @param lcContPlanReport 保障计划表
	 * @param lcContPlanRiskReportList 险种表
	 * @param lcContPlanDutyParamReportList 责任表
	 * @author 于文龙
	 */
	@Override
	public Map<String, Object> updateConPlan(LCContPlanReport lcContPlanReport,
			List<LCContPlanRiskReport> lcContPlanRiskReportList,
			List<LCContPlanDutyParamReport> lcContPlanDutyParamReportList) {
		//保存保障计划基础表——LCContPlanReport
		System.out.println("准备更新.....");
		LCReport report = this.findUnique(LCReport.class, "repNo", lcContPlanReport.getId().getRepNo());
		lcContPlanReport.setRepOperator(report.getRepOperator());
		lcContPlanReport.setRepApplyDate(report.getRepApplyDate());
		//TODO 保障计划中的计划类别暂时设置为0-固定计划
		lcContPlanReport.getId().setPlanType("0");
		ActionContext ac = ActionContext.getContext();
		PrpDuser user = (PrpDuser)ac.getSession().get("user");
		lcContPlanReport.setOperator(user.getUserCode());
		lcContPlanReport.setModifyDate(new Date());
		lcContPlanReport.setModifyTime(DateUtil.getTime());
		this.update(lcContPlanReport);
		
		//保存保障计划险种表
		//Iterator<LCContPlanRiskReport> it = lcContPlanRiskReportList.iterator();CONTPLANCODE
		for(int i = 0 ; i < lcContPlanRiskReportList.size() ; i++){
			LCContPlanRiskReport contPlanRiskTemp = lcContPlanRiskReportList.get(i);
			PDLMRisk risk = this.findUnique(PDLMRisk.class, "riskCode", contPlanRiskTemp.getId().getRiskCode());
//			select * from PD_LMRisk where riskCode in
//			 ( select rr.relaRiskCode from PD_LMRiskRela rr where rr.riskCode = 'GCAA' and rr.relaCode = '01' and rr.manageComGrp = '000000')
			String findMainRiskHql = "from PDLMRisk risk where risk.riskCode in ( select rr.id.relaRiskCode from PDLMRiskRela rr where rr.id.riskCode = ? and rr.id.relaCode = ? and rr.id.manageComGrp = ? )";
			PDLMRisk mainRisk = null;
			List<PDLMRisk> list = this.findByHql(findMainRiskHql, contPlanRiskTemp.getId().getRiskCode(),"01","000000");
			if(list != null && list.size()>0){
				mainRisk = list.get(0);
			}else{
				mainRisk = risk;
			}
			//集体合同号码
			contPlanRiskTemp.setGrpContNo(lcContPlanReport.getId().getGrpContNo());
			//集体投保单号码
			contPlanRiskTemp.getId().setProposalGrpContNo(lcContPlanReport.getProposalGrpContNo());
			//保险计划编码
			contPlanRiskTemp.getId().setContPlanCode(lcContPlanReport.getId().getContPlanCode());
			//主险险种编码
			contPlanRiskTemp.getId().setMainRiskCode(mainRisk.getRiskCode());
			//计划类别
			contPlanRiskTemp.getId().setPlanType(lcContPlanReport.getId().getPlanType());
			//呈报申请号
			contPlanRiskTemp.getId().setRepNo(lcContPlanReport.getId().getRepNo());
			//主险险种版本
			contPlanRiskTemp.setMainRiskVersion(mainRisk.getRiskVer());
			//险种版本
			contPlanRiskTemp.setRiskVersion(risk.getRiskVer());
			//操作员
			contPlanRiskTemp.setOperator(lcContPlanReport.getOperator());
			//最后一次修改日期
			contPlanRiskTemp.setModifyDate(lcContPlanReport.getMakeDate());
			//最后一次修改时间
			contPlanRiskTemp.setModifyTime(lcContPlanReport.getModifyTime());
			//呈报申请人
			contPlanRiskTemp.setRepOperator(lcContPlanReport.getRepOperator());
			//呈报申请日期
			contPlanRiskTemp.setRepApplyDate(lcContPlanReport.getRepApplyDate());
			//保险计划名称
			contPlanRiskTemp.setContPlanName(lcContPlanReport.getContPlanName());
		}
		this.update(lcContPlanRiskReportList);
		
		//保障计划的责任
		List <LCContPlanDutyParamReport> cpdpr = new ArrayList<LCContPlanDutyParamReport>();
		for(int i = 0 ; i < lcContPlanDutyParamReportList.size() ; i++){
			//如果没有录入要素值则默认是不保存该要素的
			if(null != lcContPlanDutyParamReportList.get(i).getCalFactorValue() && !"".equals(lcContPlanDutyParamReportList.get(i).getCalFactorValue())){
				LCContPlanDutyParamReport dutyParamTemp = lcContPlanDutyParamReportList.get(i);
				LCContPlanDutyParamReportId id = dutyParamTemp.getId();
				//保险计划编码
				id.setContPlanCode(lcContPlanReport.getId().getContPlanCode());
				//集体合同号码
				id.setGrpContNo(lcContPlanReport.getId().getGrpContNo());
				//遍历lcContPlanRiskReportList，找到险种相同的，得到主险和版本，避免查询数据库
				for(int j = 0 ; j < lcContPlanRiskReportList.size() ; j++){
					if(lcContPlanRiskReportList.get(j).getId().getRiskCode().equals(id.getRiskCode())){
						id.setMainRiskCode(lcContPlanRiskReportList.get(j).getId().getMainRiskCode());
						dutyParamTemp.setMainRiskVersion(lcContPlanRiskReportList.get(j).getMainRiskVersion());
						dutyParamTemp.setRiskVersion(lcContPlanRiskReportList.get(j).getRiskVersion());
					}
				}
				//计划类别
				id.setPlanType(lcContPlanReport.getId().getPlanType());
				//保险计划名称
				dutyParamTemp.setContPlanName(lcContPlanReport.getContPlanName());
				//集体保单险种号码
				dutyParamTemp.setGrpPolNo(id.getRiskCode());
				//集体投保单号码
				dutyParamTemp.setProposalGrpContNo(lcContPlanReport.getProposalGrpContNo());
				//计划要素类型
				dutyParamTemp.setCalFactorType("算法计算结果值");
				//呈报申请号
				dutyParamTemp.getId().setRepNo(lcContPlanReport.getId().getRepNo());
				//呈报申请日期
				dutyParamTemp.setRepApplyDate(lcContPlanReport.getRepApplyDate());
				//呈报申请人
				dutyParamTemp.setRepOperator(lcContPlanReport.getRepOperator());
				//操作员
				dutyParamTemp.setOperator(lcContPlanReport.getOperator());
				//最后一次修改日期
				dutyParamTemp.setModifyDate(lcContPlanReport.getMakeDate());
				//最后一次修改时间
				dutyParamTemp.setModifyTime(lcContPlanReport.getModifyTime());
				cpdpr.add(dutyParamTemp);
			}
		}
		this.update(cpdpr);
		System.out.println("保存完毕！");
		return null;
	}

	/**
	 * @title findCalMode
	 * @description 查找计算公式
	 * @param lcDutyReport
	 * @return
	 * @author 于文龙
	 */
	@Override
	public String findCalMode(LCDutyReport lcDutyReport) {
		if(null!=lcDutyReport.getId().getDutyCode()&&null!=lcDutyReport.getId().getPolNo()
		&&!"".equals(lcDutyReport.getId().getDutyCode())&&!"".equals(lcDutyReport.getId().getPolNo())){
			QueryRule queryRule=QueryRule.getInstance();
			queryRule.addEqual("id.riskCode", lcDutyReport.getId().getPolNo());
			queryRule.addEqual("id.dutyCode", lcDutyReport.getId().getDutyCode());
			
			PDLMRiskDuty pdlmRiskDuty=this.findUnique(PDLMRiskDuty.class, queryRule);
			
			if(null!=pdlmRiskDuty){
				return pdlmRiskDuty.getDhtml();
			}else{
				return null;
			}
		}
		return null;
	}
}
