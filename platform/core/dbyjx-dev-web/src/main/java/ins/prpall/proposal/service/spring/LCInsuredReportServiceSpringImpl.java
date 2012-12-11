package ins.prpall.proposal.service.spring;

import ins.common.util.ExcelToMap;
import ins.framework.common.HqlQueryRule;
import ins.framework.common.Page;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.DateUtil;
import ins.platform.common.SerialNoUtil;
import ins.platform.model.PrpDcompany;
import ins.platform.model.PrpDuser;
import ins.prpall.proposal.model.LCAppnt;
import ins.prpall.report.model.LCInsuredReport;
import ins.prpall.report.model.LCInsuredReportId;
import ins.prpall.report.model.LCGrpInsuredInfoReport;
import ins.prpall.report.service.facade.LCInsuredReportService;

import java.io.File;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class LCInsuredReportServiceSpringImpl extends
		GenericDaoHibernate<LCInsuredReport, LCInsuredReportId> implements
		LCInsuredReportService {
	private ExcelToMap excelToMap;
	private SerialNoUtil serialNoUtil;
	public SerialNoUtil getSerialNoUtil() {
		return serialNoUtil;
	}

	public void setSerialNoUtil(SerialNoUtil serialNoUtil) {
		this.serialNoUtil = serialNoUtil;
	}

	public ExcelToMap getExcelToMap() {
		return excelToMap;
	}

	public void setExcelToMap(ExcelToMap excelToMap) {
		this.excelToMap = excelToMap;
	}

/**
 * 
 * @title importInsured
 * @param excel导入数据
 * @author long
 */
	@Override
	public boolean importInsured(File insuredFile) throws Exception {
		System.out.println("开始导入被保人");
		//公共信息
		ActionContext ac=ActionContext.getContext();
		PrpDuser user=(PrpDuser)ac.getSession().get("user");
		String userCode=user.getUserCode();
		PrpDcompany company=(PrpDcompany)ac.getSession().get("prpDcompany");
		String comCode=company.getComCode();
		Date date=DateUtil.getDate();
		String time=DateUtil.getTime();
		
		
		//从前台获得的数据
		String repNo="s123335456";//呈报申请号
		String grpContNo="s123335456";//集体合同号
		String appntNo="s123335456";//投保人客户号
		String repOperator="long";//申请人
		Date repApplyDate=date;//申请日期
		
		// 得到excel中的数据并且封装成对象LCInsuredReport
		List<Object> excelList=excelToMap.excelToMap(insuredFile, "2");
		for(int i=0;i<excelList.size();i++){
			LCInsuredReport temp=(LCInsuredReport)excelList.get(i);
			temp.getId().setRepNo(repNo);
			temp.setGrpContNo(grpContNo);
			temp.setRepOperator(repOperator);
			//印刷号
			temp.setPrtNo(grpContNo);
			temp.setRepApplyDate(repApplyDate);
			temp.setAppntNo(appntNo);
			temp.setManageCom(comCode);
			temp.setOperator(userCode);
			temp.setMakeDate(date);
			temp.setMakeTime(time);
			temp.setModifyDate(date);
			temp.setModifyTime(time);
			//字段长度控制
			temp.setSex(temp.getSex().substring(0, 1));
			temp.setIdType(temp.getIdType().substring(0,1));
			temp.setMarriage(temp.getMarriage().substring(0,1));
			temp.setInsuredStat(temp.getInsuredStat().substring(0,1));
		}
		this.saveAll(excelList);
		return true;
	}

	/**
	 * 集体被保人模糊信息保存
	 * @throws java.text.ParseException
	 */
	@Override
	public Page saveGrpInsurInfor(
			List<LCGrpInsuredInfoReport> lcGrpInsuredInfoReport, int pageNo,
			int pageSize) throws ParseException {
		//组织数据
		ActionContext ac = ActionContext.getContext();
		PrpDuser user=(PrpDuser)ac.getSession().get("user");
		PrpDcompany company=(PrpDcompany)ac.getSession().get("prpDcompany");
		String operator=user.getUserName();
		String manageCom=company.getComCode().toString();
		Date date=DateUtil.getDate();
		String time=DateUtil.getTime();
		
		if(null!=lcGrpInsuredInfoReport){
			for(int i=0;i<lcGrpInsuredInfoReport.size();i++){
				if("0".equals(lcGrpInsuredInfoReport.get(i).getId().getSerialNo())){
				String maxHql="select l.id.serialNo from LCGrpInsuredInfoReport l where l.id.repNo='"+lcGrpInsuredInfoReport.get(i).getId().getRepNo()+"'";
				List<String> list=this.findByHql(maxHql, null);
				int num=1;
				if(null!=list){
					for(int m=0;m<list.size();m++){
						int maxValue=Integer.parseInt(list.get(m));
						if(num<=maxValue){
							num=maxValue+1;
						}
					}
				}
				lcGrpInsuredInfoReport.get(i).setType(lcGrpInsuredInfoReport.get(i).getType().trim());
				lcGrpInsuredInfoReport.get(i).getId().setSerialNo(num+"");
				lcGrpInsuredInfoReport.get(i).setManageCom(manageCom);
				lcGrpInsuredInfoReport.get(i).setOperator(operator);
				lcGrpInsuredInfoReport.get(i).setMakeDate(date);
				lcGrpInsuredInfoReport.get(i).setMakeTime(time);
				lcGrpInsuredInfoReport.get(i).setModifyDate(date);
				lcGrpInsuredInfoReport.get(i).setModifyTime(time);
				this.save(lcGrpInsuredInfoReport.get(i));
				}else{
					lcGrpInsuredInfoReport.get(i).setType(lcGrpInsuredInfoReport.get(i).getType().trim());
					lcGrpInsuredInfoReport.get(i).setManageCom(manageCom);
					lcGrpInsuredInfoReport.get(i).setOperator(operator);
					lcGrpInsuredInfoReport.get(i).setMakeDate(date);
					lcGrpInsuredInfoReport.get(i).setMakeTime(time);
					lcGrpInsuredInfoReport.get(i).setModifyDate(date);
					lcGrpInsuredInfoReport.get(i).setModifyTime(time);
					this.update(lcGrpInsuredInfoReport.get(i));
				}
			}
		}
		if(null!=lcGrpInsuredInfoReport.get(0).getId().getRepNo()){
			HqlQueryRule hqlQueryRule = new HqlQueryRule();
			StringBuffer hql = new StringBuffer();
			hql.append("select t from LCGrpInsuredInfoReport t where t.id.repNo='"+lcGrpInsuredInfoReport.get(0).getId().getRepNo()+"'");
			System.out.print(hql.toString());
			return this.findByHqlNoLimit(hql.toString(), pageNo, pageSize,
					hqlQueryRule.getValues());
		}else{
		return null;
		}
	}

}
